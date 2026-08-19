package com.shengchanshe.chang_sheng_jue.network;

import com.shengchanshe.chang_sheng_jue.block.custom.brick_kiln.BrickKilnEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.plaque.PlaqueEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase.TailoringCaseEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.workbench.WoodworkingBenchEntity;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.brick_kiln.BrickKilnMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.forgeblock.ForgeBlockMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.plaque.PlaqueMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.tailoringcase.TailoringCaseMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.workbench.WoodworkingBenchMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.worker.KilnWorkerMenu;
import com.shengchanshe.chang_sheng_jue.entity.villagers.worker.KilnWorker;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.Optional;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Function;

public final class ServerPacketGuard {
    private static final double MAX_MENU_DISTANCE_SQUARED = 64.0D;
    private static final int PLAQUE_WRITE_INTERVAL_TICKS = 10;
    private static final Map<ServerPlayer, Long> LAST_PLAQUE_WRITE_TICK = new WeakHashMap<>();

    private ServerPacketGuard() {
    }

    public static Optional<TailoringCaseEntity> tailoringCase(ServerPlayer player) {
        return boundBlockEntity(player, TailoringCaseMenu.class, menu -> menu.blockEntity, TailoringCaseEntity.class);
    }

    public static Optional<TailoringCaseEntity> tailoringCase(ServerPlayer player, BlockPos expectedPos) {
        return atExpectedPosition(tailoringCase(player), expectedPos);
    }

    public static Optional<ForgeBlockEntity> forgeBlock(ServerPlayer player) {
        return boundBlockEntity(player, ForgeBlockMenu.class, menu -> menu.blockEntity, ForgeBlockEntity.class);
    }

    public static Optional<ForgeBlockEntity> forgeBlock(ServerPlayer player, BlockPos expectedPos) {
        return atExpectedPosition(forgeBlock(player), expectedPos);
    }

    public static Optional<WoodworkingBenchEntity> woodworkingBench(ServerPlayer player) {
        return boundBlockEntity(player, WoodworkingBenchMenu.class, menu -> menu.blockEntity, WoodworkingBenchEntity.class);
    }

    public static Optional<WoodworkingBenchEntity> woodworkingBench(ServerPlayer player, BlockPos expectedPos) {
        return atExpectedPosition(woodworkingBench(player), expectedPos);
    }

    public static Optional<BrickKilnEntity> brickKiln(ServerPlayer player) {
        return boundBlockEntity(player, BrickKilnMenu.class, menu -> menu.blockEntity, BrickKilnEntity.class);
    }

    public static Optional<BrickKilnEntity> brickKiln(ServerPlayer player, BlockPos expectedPos) {
        return atExpectedPosition(brickKiln(player), expectedPos);
    }

    public static Optional<PlaqueEntity> plaque(ServerPlayer player, BlockPos expectedPos) {
        if (expectedPos == null) {
            return Optional.empty();
        }
        return boundBlockEntity(player, PlaqueMenu.class, menu -> menu.blockEntity, PlaqueEntity.class)
                .filter(entity -> entity.getBlockPos().equals(expectedPos));
    }

    public static boolean allowPlaqueWrite(ServerPlayer player) {
        if (player == null || !player.isAlive() || player.hasDisconnected()) {
            return false;
        }
        long now = player.level().getGameTime();
        Long last = LAST_PLAQUE_WRITE_TICK.get(player);
        if (last != null && now >= last && now - last < PLAQUE_WRITE_INTERVAL_TICKS) {
            return false;
        }
        LAST_PLAQUE_WRITE_TICK.put(player, now);
        return true;
    }

    public static Optional<KilnWorker> kilnWorkerTrader(ServerPlayer player) {
        if (player == null || !player.isAlive() || player.hasDisconnected()
                || !(player.containerMenu instanceof KilnWorkerMenu menu)
                || !menu.stillValid(player)
                || !(menu.getTrader() instanceof KilnWorker worker)
                || !worker.isAlive()
                || worker.isRemoved()
                || worker.level() != player.level()
                || player.distanceToSqr(worker) > MAX_MENU_DISTANCE_SQUARED) {
            return Optional.empty();
        }
        return Optional.of(worker);
    }

    public static boolean isCraftAmountValid(int amount) {
        return amount >= 1 && amount <= 64;
    }

    private static <B extends BlockEntity> Optional<B> atExpectedPosition(Optional<B> authoritativeEntity, BlockPos expectedPos) {
        if (authoritativeEntity.isEmpty() || expectedPos == null) {
            return Optional.empty();
        }
        return authoritativeEntity.filter(entity -> entity.getBlockPos().equals(expectedPos));
    }

    private static <M extends AbstractContainerMenu, B extends BlockEntity> Optional<B> boundBlockEntity(
            ServerPlayer player,
            Class<M> menuType,
            Function<M, B> entityGetter,
            Class<B> entityType
    ) {
        if (player == null || !player.isAlive() || player.hasDisconnected()) {
            return Optional.empty();
        }

        AbstractContainerMenu currentMenu = player.containerMenu;
        if (!menuType.isInstance(currentMenu)) {
            return Optional.empty();
        }

        M menu = menuType.cast(currentMenu);
        B boundEntity = entityGetter.apply(menu);
        ServerLevel level = player.serverLevel();
        if (boundEntity == null || boundEntity.isRemoved() || boundEntity.getLevel() != level) {
            return Optional.empty();
        }

        BlockPos pos = boundEntity.getBlockPos();
        if (!level.hasChunkAt(pos)
                || player.distanceToSqr(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) > MAX_MENU_DISTANCE_SQUARED
                || level.getBlockEntity(pos) != boundEntity
                || !entityType.isInstance(boundEntity)
                || !menu.stillValid(player)) {
            return Optional.empty();
        }

        return Optional.of(boundEntity);
    }
}
