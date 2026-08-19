package com.shengchanshe.chang_sheng_jue.block.custom;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Plans all ingredient withdrawals against a shadow inventory before mutating the player inventory.
 */
public final class CraftingMaterialTransaction {
    private CraftingMaterialTransaction() {
    }

    public static boolean canConsume(Container inventory, NonNullList<Ingredient> ingredients,
                                     int[] requiredCounts, int craftCount) {
        return plan(inventory, ingredients, requiredCounts, craftCount) != null;
    }

    public static boolean consume(Container inventory, NonNullList<Ingredient> ingredients,
                                  int[] requiredCounts, int craftCount) {
        int[] withdrawals = plan(inventory, ingredients, requiredCounts, craftCount);
        if (withdrawals == null) {
            return false;
        }
        for (int slot = 0; slot < withdrawals.length; slot++) {
            if (withdrawals[slot] > 0) {
                inventory.getItem(slot).shrink(withdrawals[slot]);
            }
        }
        inventory.setChanged();
        return true;
    }

    private static int[] plan(Container inventory, NonNullList<Ingredient> ingredients,
                              int[] requiredCounts, int craftCount) {
        if (craftCount < 1 || ingredients.size() > 9 || requiredCounts.length < ingredients.size()) {
            return null;
        }

        int ingredientCount = ingredients.size();
        int slotCount = inventory.getContainerSize();
        int source = 0;
        int ingredientStart = 1;
        int slotStart = ingredientStart + ingredientCount;
        int sink = slotStart + slotCount;
        FlowNetwork network = new FlowNetwork(sink + 1);
        long totalRequested = 0L;
        for (int ingredientIndex = 0; ingredientIndex < ingredients.size(); ingredientIndex++) {
            Ingredient ingredient = ingredients.get(ingredientIndex);
            if (ingredient.isEmpty()) {
                continue;
            }

            long requested = (long) requiredCounts[ingredientIndex] * craftCount;
            if (requested <= 0L || requested > Integer.MAX_VALUE) {
                return null;
            }
            totalRequested += requested;
            if (totalRequested > Integer.MAX_VALUE) return null;
            network.addEdge(source, ingredientStart + ingredientIndex, (int) requested);
            for (int slot = 0; slot < slotCount; slot++) {
                ItemStack stack = inventory.getItem(slot);
                if (!stack.isEmpty() && matches(ingredient, stack, requiredCounts[ingredientIndex])) {
                    network.addEdge(ingredientStart + ingredientIndex, slotStart + slot, (int) requested);
                }
            }
        }

        FlowEdge[] slotEdges = new FlowEdge[slotCount];
        for (int slot = 0; slot < slotCount; slot++) {
            slotEdges[slot] = network.addEdge(slotStart + slot, sink, inventory.getItem(slot).getCount());
        }
        if (network.maxFlow(source, sink) != (int) totalRequested) return null;

        int[] withdrawals = new int[slotCount];
        for (int slot = 0; slot < slotCount; slot++) withdrawals[slot] = slotEdges[slot].flow;
        return withdrawals;
    }

    public static int[] countsFromIngredients(NonNullList<Ingredient> ingredients) {
        int[] counts = new int[ingredients.size()];
        for (int i = 0; i < ingredients.size(); i++) {
            ItemStack[] examples = ingredients.get(i).getItems();
            counts[i] = examples.length == 0 ? 1 : Math.max(1, examples[0].getCount());
        }
        return counts;
    }

    private static boolean matches(Ingredient ingredient, ItemStack stack, int requiredCount) {
        ItemStack probe = stack.copy();
        probe.setCount(Math.max(probe.getCount(), Math.max(1, requiredCount)));
        return ingredient.test(probe);
    }

    private static final class FlowNetwork {
        private final List<FlowEdge>[] edges;
        private final int[] level;
        private final int[] next;

        @SuppressWarnings("unchecked")
        private FlowNetwork(int nodes) {
            edges = new List[nodes];
            for (int i = 0; i < nodes; i++) edges[i] = new ArrayList<>();
            level = new int[nodes];
            next = new int[nodes];
        }

        private FlowEdge addEdge(int from, int to, int capacity) {
            FlowEdge forward = new FlowEdge(to, edges[to].size(), capacity);
            FlowEdge reverse = new FlowEdge(from, edges[from].size(), 0);
            edges[from].add(forward);
            edges[to].add(reverse);
            return forward;
        }

        private int maxFlow(int source, int sink) {
            int result = 0;
            while (buildLevels(source, sink)) {
                Arrays.fill(next, 0);
                int pushed;
                while ((pushed = push(source, sink, Integer.MAX_VALUE)) > 0) result += pushed;
            }
            return result;
        }

        private boolean buildLevels(int source, int sink) {
            Arrays.fill(level, -1);
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            level[source] = 0;
            queue.add(source);
            while (!queue.isEmpty()) {
                int node = queue.removeFirst();
                for (FlowEdge edge : edges[node]) {
                    if (edge.remaining() > 0 && level[edge.to] < 0) {
                        level[edge.to] = level[node] + 1;
                        queue.addLast(edge.to);
                    }
                }
            }
            return level[sink] >= 0;
        }

        private int push(int node, int sink, int limit) {
            if (node == sink) return limit;
            for (; next[node] < edges[node].size(); next[node]++) {
                FlowEdge edge = edges[node].get(next[node]);
                if (edge.remaining() <= 0 || level[edge.to] != level[node] + 1) continue;
                int pushed = push(edge.to, sink, Math.min(limit, edge.remaining()));
                if (pushed <= 0) continue;
                edge.flow += pushed;
                edges[edge.to].get(edge.reverseIndex).flow -= pushed;
                return pushed;
            }
            return 0;
        }
    }

    private static final class FlowEdge {
        private final int to;
        private final int reverseIndex;
        private final int capacity;
        private int flow;

        private FlowEdge(int to, int reverseIndex, int capacity) {
            this.to = to;
            this.reverseIndex = reverseIndex;
            this.capacity = Math.max(0, capacity);
        }

        private int remaining() {
            return capacity - flow;
        }
    }
}
