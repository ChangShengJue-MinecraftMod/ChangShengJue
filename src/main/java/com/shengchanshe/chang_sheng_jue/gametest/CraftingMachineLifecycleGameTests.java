package com.shengchanshe.chang_sheng_jue.gametest;

import com.mojang.authlib.GameProfile;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.custom.CraftingMaterialTransaction;
import com.shengchanshe.chang_sheng_jue.block.custom.PersistedCraftingJob;
import com.shengchanshe.chang_sheng_jue.block.custom.brick_kiln.BrickKilnEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase.TailoringCaseEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.workbench.WoodworkingBenchEntity;
import com.shengchanshe.chang_sheng_jue.recipe.BrickKilnRecipe;
import com.shengchanshe.chang_sheng_jue.recipe.ForgeBlockRecipe;
import com.shengchanshe.chang_sheng_jue.recipe.TailoringCaseRecipe;
import com.shengchanshe.chang_sheng_jue.recipe.WoodworkingBenchRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import java.util.UUID;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class CraftingMachineLifecycleGameTests {
    private static final BlockPos MACHINE_POS = BlockPos.ZERO;

    private CraftingMachineLifecycleGameTests() {
    }

    @GameTest(template = "empty")
    public static void tailoringCaseCompletesPersistedJob(GameTestHelper helper) {
        TailoringCaseRecipe recipe = requireRecipe(helper,
                "cotton_boots", TailoringCaseRecipe.class);
        ServerPlayer player = createUnconnectedServerPlayer(helper, "tailorLife");
        TailoringCaseEntity original = placeEntity(helper, ChangShengJueBlocks.TAILORING_CASE.get(),
                TailoringCaseEntity.class);
        NonNullList<Ingredient> ingredients = recipe.getIngredients();
        int[] counts = CraftingMaterialTransaction.countsFromIngredients(ingredients);
        int materialCount = seedExactMaterials(helper, player, ingredients, counts, 1);

        original.setCurrentRecipe(recipe);
        original.craftCurrentRecipe(player);
        assertPaidAndPersisted(helper, player, original.saveWithFullMetadata(), recipe, materialCount, 1,
                original.maxProgress);
        tickToMidpoint(helper, original, player);

        CompoundTag saved = original.saveWithFullMetadata();
        TailoringCaseEntity loaded = replaceAndLoad(helper, original, saved,
                ChangShengJueBlocks.TAILORING_CASE.get(), TailoringCaseEntity.class);
        CompoundTag frozen = activeJob(loaded);
        loaded.setCurrentRecipe(null);
        assertMutationRejected(helper, loaded.getCurrentRecipe(), recipe, frozen, activeJob(loaded),
                "tailoring recipe changed during an active job");

        ItemStack expected = recipe.getResultItem(helper.getLevel().registryAccess());
        tickToProductionBoundary(helper, loaded, ItemStack.EMPTY);
        tickOnce(helper, loaded);
        assertFinished(helper, loaded.isCrafting(), loaded.saveWithFullMetadata(),
                loaded.getItemHandler().getStackInSlot(TailoringCaseEntity.SLOT_OUTPUT), expected);
        cleanup(helper, player, loaded, TailoringCaseEntity.SLOT_OUTPUT);
    }

    @GameTest(template = "empty")
    public static void forgeBlockCompletesPersistedJob(GameTestHelper helper) {
        ForgeBlockRecipe recipe = requireRecipe(helper, "bronze_sword", ForgeBlockRecipe.class);
        ServerPlayer player = createUnconnectedServerPlayer(helper, "forgeLife");
        ForgeBlockEntity original = placeEntity(helper, ChangShengJueBlocks.FORGE_BLOCK.get(),
                ForgeBlockEntity.class);
        NonNullList<Ingredient> ingredients = recipe.getIngredients();
        int[] counts = CraftingMaterialTransaction.countsFromIngredients(ingredients);
        int materialCount = seedExactMaterials(helper, player, ingredients, counts, 1);

        original.setCurrentRecipe(recipe);
        original.craftCurrentRecipe(player);
        assertPaidAndPersisted(helper, player, original.saveWithFullMetadata(), recipe, materialCount, 1,
                original.maxProgress);
        tickToMidpoint(helper, original, player);

        CompoundTag saved = original.saveWithFullMetadata();
        ForgeBlockEntity loaded = replaceAndLoad(helper, original, saved,
                ChangShengJueBlocks.FORGE_BLOCK.get(), ForgeBlockEntity.class);
        CompoundTag frozen = activeJob(loaded);
        loaded.setCurrentRecipe(null);
        assertMutationRejected(helper, loaded.getCurrentRecipe(), recipe, frozen, activeJob(loaded),
                "forge recipe changed during an active job");

        ItemStack expected = recipe.getResultItem(helper.getLevel().registryAccess());
        tickToProductionBoundary(helper, loaded, ItemStack.EMPTY);
        tickOnce(helper, loaded);
        assertFinished(helper, loaded.isCrafting(), loaded.saveWithFullMetadata(),
                loaded.getItemHandler().getStackInSlot(ForgeBlockEntity.SLOT_OUTPUT), expected);
        cleanup(helper, player, loaded, ForgeBlockEntity.SLOT_OUTPUT);
    }

    @GameTest(template = "empty")
    public static void woodworkingBenchCompletesTwoPersistedJobs(GameTestHelper helper) {
        WoodworkingBenchRecipe recipe = requireRecipe(helper,
                "woodworking_bench/xiao_mu_zuo/acacia_balustrade", WoodworkingBenchRecipe.class);
        ServerPlayer player = createUnconnectedServerPlayer(helper, "woodLife");
        WoodworkingBenchEntity original = placeEntity(helper, ChangShengJueBlocks.WOOD_WORKING_BENCH.get(),
                WoodworkingBenchEntity.class);
        int craftTimes = 2;
        NonNullList<Ingredient> ingredients = recipe.getIngredients();
        int[] counts = recipe.getCachedRequiredCounts();
        int materialCount = seedExactMaterials(helper, player, ingredients, counts, craftTimes);

        original.setCurrentRecipe(recipe);
        original.setCraftTimes(craftTimes);
        original.craftCurrentRecipe(player);
        assertPaidAndPersisted(helper, player, original.saveWithFullMetadata(), recipe, materialCount,
                craftTimes, original.maxProgress);
        tickToMidpoint(helper, original, player);

        CompoundTag saved = original.saveWithFullMetadata();
        WoodworkingBenchEntity loaded = replaceAndLoad(helper, original, saved,
                ChangShengJueBlocks.WOOD_WORKING_BENCH.get(), WoodworkingBenchEntity.class);
        CompoundTag frozen = activeJob(loaded);
        loaded.setCurrentRecipe(null);
        loaded.setCraftTimes(64);
        assertMutationRejected(helper, loaded.getCurrentRecipe(), recipe, frozen, activeJob(loaded),
                "woodworking recipe or amount changed during an active job");
        helper.assertTrue(loaded.getCraftTimes() == craftTimes,
                "woodworking craft amount changed during an active job");

        ItemStack oneOutput = recipe.getResultItem(helper.getLevel().registryAccess());
        tickToProductionBoundary(helper, loaded, ItemStack.EMPTY);
        tickOnce(helper, loaded);
        assertProducedOneOfTwo(helper, loaded, oneOutput);
        tickToProductionBoundary(helper, loaded, oneOutput);
        tickOnce(helper, loaded);
        ItemStack expected = oneOutput.copy();
        expected.setCount(expected.getCount() * craftTimes);
        assertFinished(helper, loaded.isCrafting(), loaded.saveWithFullMetadata(),
                loaded.getItemHandler().getStackInSlot(WoodworkingBenchEntity.SLOT_OUTPUT), expected);
        cleanup(helper, player, loaded, WoodworkingBenchEntity.SLOT_OUTPUT);
    }

    @GameTest(template = "empty")
    public static void brickKilnCompletesTwoPersistedJobs(GameTestHelper helper) {
        BrickKilnRecipe recipe = requireRecipe(helper,
                "brick_kiln/shi_zuo/stone_bench", BrickKilnRecipe.class);
        ServerPlayer player = createUnconnectedServerPlayer(helper, "kilnLife");
        BrickKilnEntity original = placeEntity(helper, ChangShengJueBlocks.BRICK_KILN.get(),
                BrickKilnEntity.class);
        int craftTimes = 2;
        NonNullList<Ingredient> ingredients = recipe.getIngredients();
        int[] counts = recipe.getCachedRequiredCounts();
        int materialCount = seedExactMaterials(helper, player, ingredients, counts, craftTimes);

        original.setCurrentRecipe(recipe);
        original.setCraftTimes(craftTimes);
        original.craftCurrentRecipe(player);
        assertPaidAndPersisted(helper, player, original.saveWithFullMetadata(), recipe, materialCount,
                craftTimes, original.maxProgress);
        tickToMidpoint(helper, original, player);

        CompoundTag saved = original.saveWithFullMetadata();
        BrickKilnEntity loaded = replaceAndLoad(helper, original, saved,
                ChangShengJueBlocks.BRICK_KILN.get(), BrickKilnEntity.class);
        CompoundTag frozen = activeJob(loaded);
        loaded.setCurrentRecipe(null);
        loaded.setCraftTimes(64);
        assertMutationRejected(helper, loaded.getCurrentRecipe(), recipe, frozen, activeJob(loaded),
                "brick kiln recipe or amount changed during an active job");
        helper.assertTrue(loaded.getCraftTimes() == craftTimes,
                "brick kiln craft amount changed during an active job");

        ItemStack oneOutput = recipe.getResultItem(helper.getLevel().registryAccess());
        tickToProductionBoundary(helper, loaded, ItemStack.EMPTY);
        tickOnce(helper, loaded);
        assertProducedOneOfTwo(helper, loaded, oneOutput);
        tickToProductionBoundary(helper, loaded, oneOutput);
        tickOnce(helper, loaded);
        ItemStack expected = oneOutput.copy();
        expected.setCount(expected.getCount() * craftTimes);
        assertFinished(helper, loaded.isCrafting(), loaded.saveWithFullMetadata(),
                loaded.getItemHandler().getStackInSlot(BrickKilnEntity.SLOT_OUTPUT), expected);
        cleanup(helper, player, loaded, BrickKilnEntity.SLOT_OUTPUT);
    }

    private static <R extends Recipe<?>> R requireRecipe(GameTestHelper helper, String path, Class<R> type) {
        ResourceLocation id = new ResourceLocation(ChangShengJue.MOD_ID, path);
        Recipe<?> recipe = helper.getLevel().getRecipeManager().byKey(id).orElse(null);
        helper.assertTrue(type.isInstance(recipe), "expected live recipe " + id + " was not loaded");
        return type.cast(recipe);
    }

    private static int seedExactMaterials(GameTestHelper helper, ServerPlayer player,
                                          NonNullList<Ingredient> ingredients, int[] counts, int craftTimes) {
        player.getInventory().clearContent();
        int slot = 0;
        int total = 0;
        for (int index = 0; index < ingredients.size(); index++) {
            Ingredient ingredient = ingredients.get(index);
            if (ingredient.isEmpty()) continue;
            ItemStack[] choices = ingredient.getItems();
            helper.assertTrue(choices.length > 0 && !choices[0].isEmpty(),
                    "recipe ingredient has no concrete server-side item candidate");
            int required = Math.multiplyExact(counts[index], craftTimes);
            ItemStack material = choices[0].copy();
            helper.assertTrue(required <= material.getMaxStackSize(),
                    "fixture material does not fit one player inventory stack");
            material.setCount(required);
            player.getInventory().setItem(slot++, material);
            total += required;
        }
        helper.assertTrue(total > 0 && inventoryItemCount(player) == total,
                "fixture did not seed the exact recipe materials");
        return total;
    }

    private static void assertPaidAndPersisted(GameTestHelper helper, ServerPlayer player, CompoundTag saved,
                                               Recipe<?> recipe, int materialCount, int craftTimes,
                                               int maxProgress) {
        helper.assertTrue(inventoryItemCount(player) == 0,
                "craft did not deduct the exact seeded material count " + materialCount);
        helper.assertTrue(saved.contains("active_job", Tag.TAG_COMPOUND),
                "craft did not create a persisted active_job");
        PersistedCraftingJob.Loaded loaded = PersistedCraftingJob.load(saved.getCompound("active_job"), maxProgress);
        helper.assertTrue(loaded != null, "active_job could not be decoded by the production persistence codec");
        PersistedCraftingJob job = loaded.job();
        ItemStack expectedOutput = recipe.getResultItem(helper.getLevel().registryAccess());
        helper.assertTrue(job.recipeId().equals(recipe.getId()), "active_job did not freeze the selected recipe id");
        helper.assertTrue(ItemStack.isSameItemSameTags(job.output(), expectedOutput)
                        && job.output().getCount() == expectedOutput.getCount(),
                "active_job did not freeze the selected recipe output");
        helper.assertTrue(job.total() == craftTimes && job.remaining() == craftTimes,
                "active_job did not freeze the requested craft count");
    }

    private static void assertMutationRejected(GameTestHelper helper, Recipe<?> actualRecipe,
                                               Recipe<?> expectedRecipe, CompoundTag before, CompoundTag after,
                                               String message) {
        helper.assertTrue(actualRecipe != null && actualRecipe.getId().equals(expectedRecipe.getId()), message);
        helper.assertTrue(before.equals(after), message + " (active_job changed)");
    }

    private static CompoundTag activeJob(BlockEntity entity) {
        return entity.saveWithFullMetadata().getCompound("active_job").copy();
    }

    private static <B extends BlockEntity> B placeEntity(GameTestHelper helper, Block block, Class<B> type) {
        helper.setBlock(MACHINE_POS, block);
        BlockEntity entity = helper.getLevel().getBlockEntity(helper.absolutePos(MACHINE_POS));
        helper.assertTrue(type.isInstance(entity), "expected " + type.getSimpleName() + " was not created");
        return type.cast(entity);
    }

    private static <B extends BlockEntity> B replaceAndLoad(GameTestHelper helper, B original, CompoundTag saved,
                                                            Block block, Class<B> type) {
        helper.setBlock(MACHINE_POS, Blocks.AIR);
        B loaded = placeEntity(helper, block, type);
        helper.assertTrue(loaded != original, "block replacement reused the original block entity");
        loaded.load(saved);
        loaded.onLoad();
        helper.assertTrue(activeJob(loaded).equals(saved.getCompound("active_job")),
                "new block entity did not restore the persisted active_job");
        return loaded;
    }

    private static void tickToMidpoint(GameTestHelper helper, BlockEntity entity, ServerPlayer player) {
        int midpoint = maxProgress(entity) / 2;
        helper.assertTrue(progress(entity) == 1, "new active job did not start at progress 1");
        int ticks = midpoint - progress(entity);
        helper.assertTrue(ticks > 0, "machine progress range has no deterministic midpoint");
        for (int index = 0; index < ticks; index++) {
            tickOnce(helper, entity);
            helper.assertTrue(isCrafting(entity), "active job disappeared before the midpoint save");
            helper.assertTrue(output(entity).isEmpty(), "machine produced output before the midpoint save");
        }
        CompoundTag saved = entity.saveWithFullMetadata();
        helper.assertTrue(progress(entity) == midpoint, "fixture did not stop at the deterministic midpoint");
        helper.assertTrue(isCrafting(entity) && saved.contains("active_job", Tag.TAG_COMPOUND),
                "active job disappeared before the midpoint save");
        helper.assertTrue(output(entity).isEmpty(), "machine produced output before the midpoint save");
        helper.assertTrue(inventoryItemCount(player) == 0, "paid materials were returned before the midpoint save");
    }

    private static void tickToProductionBoundary(GameTestHelper helper, BlockEntity entity,
                                                 ItemStack expectedOutputBeforeProduction) {
        int ticks = maxProgress(entity) - progress(entity);
        helper.assertTrue(ticks >= 0 && isCrafting(entity), "restored job was outside its production boundary");
        for (int index = 0; index < ticks; index++) {
            tickOnce(helper, entity);
            helper.assertTrue(isCrafting(entity), "job completed before the final production tick");
            assertOutput(helper, output(entity), expectedOutputBeforeProduction,
                    "machine produced output before the final production tick");
        }
        helper.assertTrue(progress(entity) == maxProgress(entity),
                "job did not stop exactly one tick before production");
        helper.assertTrue(entity.saveWithFullMetadata().contains("active_job", Tag.TAG_COMPOUND),
                "active_job disappeared one tick before production");
        assertOutput(helper, output(entity), expectedOutputBeforeProduction,
                "machine output changed one tick before production");
    }

    private static void assertProducedOneOfTwo(GameTestHelper helper, BlockEntity entity, ItemStack expected) {
        helper.assertTrue(isCrafting(entity), "two-count job ended after producing only one output");
        helper.assertTrue(progress(entity) == 1, "two-count job did not reset progress after its first output");
        CompoundTag saved = entity.saveWithFullMetadata();
        helper.assertTrue(saved.contains("active_job", Tag.TAG_COMPOUND),
                "two-count job lost active_job after its first output");
        PersistedCraftingJob.Loaded loaded = PersistedCraftingJob.load(
                saved.getCompound("active_job"), maxProgress(entity));
        helper.assertTrue(loaded != null && loaded.job().total() == 2 && loaded.job().remaining() == 1,
                "two-count job did not persist exactly one remaining output");
        assertOutput(helper, output(entity), expected, "first production tick emitted the wrong output");
    }

    private static void tickOnce(GameTestHelper helper, BlockEntity entity) {
        if (entity instanceof TailoringCaseEntity value) {
            value.tick(helper.getLevel(), value.getBlockPos(), value.getBlockState());
        } else if (entity instanceof ForgeBlockEntity value) {
            value.tick(helper.getLevel(), value.getBlockPos(), value.getBlockState());
        } else if (entity instanceof WoodworkingBenchEntity value) {
            value.tick(helper.getLevel(), value.getBlockPos(), value.getBlockState());
        } else if (entity instanceof BrickKilnEntity value) {
            value.tick(helper.getLevel(), value.getBlockPos(), value.getBlockState());
        } else {
            throw new IllegalArgumentException("unsupported crafting machine");
        }
    }

    private static int progress(BlockEntity entity) {
        if (entity instanceof TailoringCaseEntity value) return value.progress;
        if (entity instanceof ForgeBlockEntity value) return value.progress;
        if (entity instanceof WoodworkingBenchEntity value) return value.progress;
        if (entity instanceof BrickKilnEntity value) return value.progress;
        throw new IllegalArgumentException("unsupported crafting machine");
    }

    private static int maxProgress(BlockEntity entity) {
        if (entity instanceof TailoringCaseEntity value) return value.maxProgress;
        if (entity instanceof ForgeBlockEntity value) return value.maxProgress;
        if (entity instanceof WoodworkingBenchEntity value) return value.maxProgress;
        if (entity instanceof BrickKilnEntity value) return value.maxProgress;
        throw new IllegalArgumentException("unsupported crafting machine");
    }

    private static ItemStack output(BlockEntity entity) {
        if (entity instanceof TailoringCaseEntity value) {
            return value.getItemHandler().getStackInSlot(TailoringCaseEntity.SLOT_OUTPUT);
        }
        if (entity instanceof ForgeBlockEntity value) {
            return value.getItemHandler().getStackInSlot(ForgeBlockEntity.SLOT_OUTPUT);
        }
        if (entity instanceof WoodworkingBenchEntity value) {
            return value.getItemHandler().getStackInSlot(WoodworkingBenchEntity.SLOT_OUTPUT);
        }
        if (entity instanceof BrickKilnEntity value) {
            return value.getItemHandler().getStackInSlot(BrickKilnEntity.SLOT_OUTPUT);
        }
        throw new IllegalArgumentException("unsupported crafting machine");
    }

    private static void assertOutput(GameTestHelper helper, ItemStack actual, ItemStack expected, String message) {
        if (expected.isEmpty()) {
            helper.assertTrue(actual.isEmpty(), message);
            return;
        }
        helper.assertTrue(ItemStack.isSameItemSameTags(actual, expected) && actual.getCount() == expected.getCount(),
                message);
    }

    private static boolean isCrafting(BlockEntity entity) {
        if (entity instanceof TailoringCaseEntity value) return value.isCrafting();
        if (entity instanceof ForgeBlockEntity value) return value.isCrafting();
        if (entity instanceof WoodworkingBenchEntity value) return value.isCrafting();
        if (entity instanceof BrickKilnEntity value) return value.isCrafting();
        throw new IllegalArgumentException("unsupported crafting machine");
    }

    private static void assertFinished(GameTestHelper helper, boolean crafting, CompoundTag saved,
                                       ItemStack actual, ItemStack expected) {
        helper.assertTrue(!crafting, "completed machine retained an active in-memory job");
        helper.assertTrue(!saved.contains("active_job"), "completed machine retained active_job in NBT");
        helper.assertTrue(ItemStack.isSameItemSameTags(actual, expected) && actual.getCount() == expected.getCount(),
                "completed machine output did not equal the frozen output and count");
    }

    private static int inventoryItemCount(ServerPlayer player) {
        int count = 0;
        for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
            count += player.getInventory().getItem(slot).getCount();
        }
        return count;
    }

    private static ServerPlayer createUnconnectedServerPlayer(GameTestHelper helper, String name) {
        return new ServerPlayer(helper.getLevel().getServer(), helper.getLevel(),
                new GameProfile(UUID.randomUUID(), name)) {
            @Override
            public boolean isSpectator() {
                return false;
            }

            @Override
            public boolean isCreative() {
                return false;
            }
        };
    }

    private static void cleanup(GameTestHelper helper, ServerPlayer player, BlockEntity entity, int outputSlot) {
        player.getInventory().clearContent();
        if (entity instanceof TailoringCaseEntity value) value.getItemHandler().setStackInSlot(outputSlot, ItemStack.EMPTY);
        else if (entity instanceof ForgeBlockEntity value) value.getItemHandler().setStackInSlot(outputSlot, ItemStack.EMPTY);
        else if (entity instanceof WoodworkingBenchEntity value) value.getItemHandler().setStackInSlot(outputSlot, ItemStack.EMPTY);
        else if (entity instanceof BrickKilnEntity value) value.getItemHandler().setStackInSlot(outputSlot, ItemStack.EMPTY);
        helper.setBlock(MACHINE_POS, Blocks.AIR);
        helper.succeed();
    }
}
