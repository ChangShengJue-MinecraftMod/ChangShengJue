package com.shengchanshe.chang_sheng_jue.capability.kungfu;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class FoodDataOwnerTracker {
    private static final Map<FoodData, WeakReference<Player>> OWNERS = new WeakHashMap<>();

    private FoodDataOwnerTracker() {
    }

    public static Player findOwner(FoodData foodData) {
        synchronized (OWNERS) {
            WeakReference<Player> reference = OWNERS.get(foodData);
            return reference == null ? null : reference.get();
        }
    }

    public static void bind(ServerPlayer player) {
        synchronized (OWNERS) {
            OWNERS.put(player.getFoodData(), new WeakReference<>(player));
        }
    }

    public static void unbind(ServerPlayer player) {
        synchronized (OWNERS) {
            OWNERS.remove(player.getFoodData());
        }
    }

    public static void clear() {
        synchronized (OWNERS) {
            OWNERS.clear();
        }
    }
}
