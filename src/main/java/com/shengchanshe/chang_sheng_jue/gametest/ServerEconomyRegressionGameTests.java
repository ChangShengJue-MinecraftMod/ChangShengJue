package com.shengchanshe.chang_sheng_jue.gametest;

import com.mojang.authlib.GameProfile;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.custom.castingmolds.BullionsCastingMoldsBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.castingmolds.CastingMoldsBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.brick_kiln.BrickKilnEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.pottery.PotteryWheel;
import com.shengchanshe.chang_sheng_jue.block.custom.pottery.PotteryWheelEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.racks.ClothesRack;
import com.shengchanshe.chang_sheng_jue.block.custom.racks.ClothesRackEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase.TailoringCaseEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.workbench.WoodworkingBenchEntity;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.blacksmith.BlacksmithMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangleaderTradingMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.innkeeper.InnkeeperMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.worker.KilnWorkerMenu;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.AbstractWuXiaMerchant;
import com.shengchanshe.chang_sheng_jue.entity.villagers.worker.KilnWorker;
import com.shengchanshe.chang_sheng_jue.entity.villagers.worker.KilnWorkerTradeType;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.ClientSideMerchant;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;
import net.minecraftforge.items.ItemStackHandler;

import java.util.UUID;
import java.util.function.Supplier;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class ServerEconomyRegressionGameTests {
    private ServerEconomyRegressionGameTests() {
    }

    @GameTest(template = "empty")
    public static void potteryWheelDeliversExactlyOneProduct(GameTestHelper helper) {
        BlockPos relativePos = new BlockPos(1, 1, 1);
        BlockPos absolutePos = helper.absolutePos(relativePos);
        AABB productArea = new AABB(absolutePos).inflate(2.0D);
        helper.getLevel().getEntitiesOfClass(ItemEntity.class, productArea,
                entity -> entity.getItem().is(ChangShengJueItems.CI_BEI.get())).forEach(Entity::discard);
        PotteryWheelEntity pottery = placeEntity(helper, relativePos,
                ChangShengJueBlocks.POTTERY_WHEEL.get(), PotteryWheelEntity.class);
        pottery.getInventory().setStackInSlot(0, new ItemStack(Items.CLAY_BALL));

        for (int tick = 0; tick < 200; tick++) {
            pottery.tick();
        }

        helper.assertTrue(pottery.getInventory().getStackInSlot(0).isEmpty(),
                "pottery input was not consumed");
        helper.assertTrue(pottery.getInventory().getStackInSlot(1).isEmpty(),
                "pottery product was duplicated into an ingredient slot");
        int productCount = helper.getLevel().getEntitiesOfClass(
                        ItemEntity.class, productArea,
                        entity -> entity.getItem().is(ChangShengJueItems.CI_BEI.get()))
                .stream()
                .mapToInt(entity -> entity.getItem().getCount())
                .sum();
        helper.assertTrue(productCount == 1, "pottery wheel must deliver exactly one product, got " + productCount);
        helper.getLevel().getEntitiesOfClass(ItemEntity.class, productArea,
                entity -> entity.getItem().is(ChangShengJueItems.CI_BEI.get())).forEach(Entity::discard);
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void potteryWheelPreservesLegacyProductsForRecovery(GameTestHelper helper) {
        BlockPos relativePos = new BlockPos(1, 1, 1);
        PotteryWheelEntity pottery = placeEntity(helper, relativePos,
                ChangShengJueBlocks.POTTERY_WHEEL.get(), PotteryWheelEntity.class);

        ItemStackHandler legacyInventory = new ItemStackHandler(3);
        legacyInventory.setStackInSlot(0, new ItemStack(Items.CLAY_BALL));
        legacyInventory.setStackInSlot(1, new ItemStack(ChangShengJueItems.CI_BEI.get()));
        legacyInventory.setStackInSlot(2, new ItemStack(ChangShengJueItems.CI_PAN.get()));
        CompoundTag legacyTag = new CompoundTag();
        legacyTag.put("PotteryWheelInventory", legacyInventory.serializeNBT());
        legacyTag.putInt("PotteryProgress", 199);

        BlockPos absolutePos = helper.absolutePos(relativePos);
        AABB recoveryArea = new AABB(absolutePos).inflate(2.0D);
        helper.getLevel().getEntitiesOfClass(ItemEntity.class, recoveryArea,
                entity -> entity.getItem().is(Items.CLAY_BALL)
                        || entity.getItem().is(ChangShengJueItems.CI_BEI.get())
                        || entity.getItem().is(ChangShengJueItems.CI_PAN.get())
                        || entity.getItem().is(ChangShengJueItems.CI_WAN.get()))
                .forEach(Entity::discard);
        pottery.load(legacyTag);
        pottery.tick();

        CompoundTag roundTripped = pottery.getUpdateTag();
        helper.assertTrue(roundTripped.contains("PotteryWheelInventory"),
                "legacy pottery inventory key was not preserved");
        helper.assertTrue(roundTripped.getCompound("PotteryWheelInventory").getInt("Size") == 3,
                "legacy three-slot pottery inventory layout was not preserved");
        helper.assertTrue(pottery.getInventory().getStackInSlot(0).is(Items.CLAY_BALL),
                "legacy inventory consumed clay while a historical product was present");
        helper.assertTrue(pottery.getInventory().getStackInSlot(1).is(ChangShengJueItems.CI_BEI.get()),
                "legacy slot 1 product was consumed as a new ingredient");
        helper.assertTrue(pottery.getInventory().getStackInSlot(2).is(ChangShengJueItems.CI_PAN.get()),
                "legacy slot 2 product was consumed as a new ingredient");

        helper.assertTrue(helper.getLevel().getEntitiesOfClass(
                        ItemEntity.class, recoveryArea,
                        entity -> entity.getItem().is(ChangShengJueItems.CI_WAN.get())).isEmpty(),
                "blocked legacy inventory unexpectedly crafted a new product");

        pottery.drops();
        assertDroppedCount(helper, recoveryArea, Items.CLAY_BALL, 1,
                "legacy clay was not recoverable when the pottery wheel was removed");
        assertDroppedCount(helper, recoveryArea, ChangShengJueItems.CI_BEI.get(), 1,
                "legacy slot 1 product was not recoverable when the pottery wheel was removed");
        assertDroppedCount(helper, recoveryArea, ChangShengJueItems.CI_PAN.get(), 1,
                "legacy slot 2 product was not recoverable when the pottery wheel was removed");
        helper.getLevel().getEntitiesOfClass(ItemEntity.class, recoveryArea,
                entity -> entity.getItem().is(Items.CLAY_BALL)
                        || entity.getItem().is(ChangShengJueItems.CI_BEI.get())
                        || entity.getItem().is(ChangShengJueItems.CI_PAN.get()))
                .forEach(Entity::discard);
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void potteryWheelUsesTheInteractingHand(GameTestHelper helper) {
        BlockPos relativePos = new BlockPos(1, 1, 1);
        BlockPos absolutePos = helper.absolutePos(relativePos);
        PotteryWheelEntity pottery = placeEntity(helper, relativePos,
                ChangShengJueBlocks.POTTERY_WHEEL.get(), PotteryWheelEntity.class);
        ServerPlayer player = new ServerPlayer(
                helper.getLevel().getServer(), helper.getLevel(),
                new GameProfile(UUID.randomUUID(), "pottery-offhand-test"));
        player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.DIRT));
        player.setItemInHand(InteractionHand.OFF_HAND, new ItemStack(Items.CLAY_BALL));

        Block block = ChangShengJueBlocks.POTTERY_WHEEL.get();
        helper.assertTrue(block instanceof PotteryWheel, "registered pottery wheel has the wrong block type");
        block.use(helper.getLevel().getBlockState(absolutePos), helper.getLevel(), absolutePos,
                player, InteractionHand.OFF_HAND,
                new BlockHitResult(Vec3.atCenterOf(absolutePos), net.minecraft.core.Direction.UP, absolutePos, false));

        helper.assertTrue(pottery.getInventory().getStackInSlot(0).is(Items.CLAY_BALL),
                "pottery wheel did not insert clay from the interacting off hand");
        helper.assertTrue(player.getMainHandItem().is(Items.DIRT),
                "pottery wheel consumed or inserted the unrelated main-hand item");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void coinMoldUsesTheInteractingHand(GameTestHelper helper) {
        BlockPos relativePos = new BlockPos(1, 1, 1);
        BlockPos absolutePos = helper.absolutePos(relativePos);
        CastingMoldsBlockEntity mold = placeEntity(helper, relativePos,
                ChangShengJueBlocks.CASTING_MOLDS.get(), CastingMoldsBlockEntity.class);
        ServerPlayer player = new ServerPlayer(
                helper.getLevel().getServer(), helper.getLevel(),
                new GameProfile(UUID.randomUUID(), "coin-mold-offhand-test"));
        player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.DIRT));
        player.setItemInHand(InteractionHand.OFF_HAND,
                new ItemStack(ChangShengJueItems.CRUCIBLE_LIQUID_COPPER.get()));

        Block block = ChangShengJueBlocks.CASTING_MOLDS.get();
        block.use(helper.getLevel().getBlockState(absolutePos), helper.getLevel(), absolutePos,
                player, InteractionHand.OFF_HAND,
                new BlockHitResult(Vec3.atCenterOf(absolutePos), net.minecraft.core.Direction.UP, absolutePos, false));

        helper.assertTrue(mold.getInventory().getStackInSlot(0)
                        .is(ChangShengJueItems.CRUCIBLE_LIQUID_COPPER.get()),
                "coin mold did not insert the interacted off-hand crucible");
        helper.assertTrue(player.getMainHandItem().is(Items.DIRT),
                "coin mold consumed the unrelated main-hand item");
        helper.assertTrue(player.getOffhandItem().is(ChangShengJueItems.CRUCIBLE.get()),
                "coin mold did not return the empty crucible to the interacted hand");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void bullionMoldUsesTheInteractingHand(GameTestHelper helper) {
        BlockPos relativePos = new BlockPos(1, 1, 1);
        BlockPos absolutePos = helper.absolutePos(relativePos);
        BullionsCastingMoldsBlockEntity mold = placeEntity(helper, relativePos,
                ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get(), BullionsCastingMoldsBlockEntity.class);
        ServerPlayer player = new ServerPlayer(
                helper.getLevel().getServer(), helper.getLevel(),
                new GameProfile(UUID.randomUUID(), "bullion-mold-offhand-test"));
        player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.DIRT));
        player.setItemInHand(InteractionHand.OFF_HAND,
                new ItemStack(ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get()));

        Block block = ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get();
        block.use(helper.getLevel().getBlockState(absolutePos), helper.getLevel(), absolutePos,
                player, InteractionHand.OFF_HAND,
                new BlockHitResult(Vec3.atCenterOf(absolutePos), net.minecraft.core.Direction.UP, absolutePos, false));

        helper.assertTrue(mold.getInventory().getStackInSlot(0)
                        .is(ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get()),
                "bullion mold did not insert the interacted off-hand crucible");
        helper.assertTrue(player.getMainHandItem().is(Items.DIRT),
                "bullion mold consumed the unrelated main-hand item");
        helper.assertTrue(player.getOffhandItem().is(ChangShengJueItems.CRUCIBLE.get()),
                "bullion mold did not return the empty crucible to the interacted hand");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void coinMoldWaitsForWorstCaseOutputCapacity(GameTestHelper helper) {
        CastingMoldsBlockEntity mold = placeEntity(helper, new BlockPos(1, 1, 1),
                ChangShengJueBlocks.CASTING_MOLDS.get(), CastingMoldsBlockEntity.class);
        mold.getInventory().setStackInSlot(0, new ItemStack(ChangShengJueItems.CRUCIBLE_LIQUID_COPPER.get()));
        mold.getInventory().setStackInSlot(1, new ItemStack(ChangShengJueItems.TONG_QIAN.get(), 41));

        for (int tick = 0; tick < 300; tick++) {
            mold.tick();
        }

        helper.assertTrue(mold.getInventory().getStackInSlot(0).is(ChangShengJueItems.CRUCIBLE_LIQUID_COPPER.get()),
                "coin mold consumed input without room for the maximum output");
        helper.assertTrue(mold.getInventory().getStackInSlot(1).getCount() == 41,
                "coin mold changed a blocked output stack");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void bullionMoldWaitsForFullThreeItemCapacity(GameTestHelper helper) {
        BullionsCastingMoldsBlockEntity mold = placeEntity(helper, new BlockPos(1, 1, 1),
                ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get(), BullionsCastingMoldsBlockEntity.class);
        mold.getInventory().setStackInSlot(0, new ItemStack(ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get()));
        mold.getInventory().setStackInSlot(1, new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 62));

        for (int tick = 0; tick < 300; tick++) {
            mold.tick();
        }

        helper.assertTrue(mold.getInventory().getStackInSlot(0).is(ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get()),
                "bullion mold consumed input without room for all three outputs");
        helper.assertTrue(mold.getInventory().getStackInSlot(1).getCount() == 62,
                "bullion mold changed a blocked output stack");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void emptyWineKeepsItsOwnZeroNutrition(GameTestHelper helper) {
        BlockPos relativePos = new BlockPos(1, 1, 1);
        BlockPos absolutePos = helper.absolutePos(relativePos);
        Block emptyWine = ChangShengJueBlocks.EMPTY_FEN_JIU.get();
        helper.setBlock(relativePos, emptyWine);
        ServerPlayer player = new ServerPlayer(
                helper.getLevel().getServer(), helper.getLevel(),
                new GameProfile(UUID.randomUUID(), "empty-wine-test")) {
            @Override
            public void displayClientMessage(Component message, boolean actionBar) {
                // 无连接的 GameTest 玩家只验证服务端营养变化，不发送客户端提示。
            }
        };
        player.getFoodData().setFoodLevel(10);

        emptyWine.use(helper.getLevel().getBlockState(absolutePos), helper.getLevel(), absolutePos,
                player, InteractionHand.MAIN_HAND,
                new BlockHitResult(Vec3.atCenterOf(absolutePos), net.minecraft.core.Direction.UP, absolutePos, false));

        helper.assertTrue(player.getFoodData().getFoodLevel() == 10,
                "empty wine inherited nutrition from another registered food block");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void parcelInvalidTypeFallsBackWithoutCrashing(GameTestHelper helper) {
        ItemStack parcel = new ItemStack(ChangShengJueItems.ARMOR_PARCEL.get());
        parcel.getOrCreateTag().putInt("ParcelType", Integer.MAX_VALUE);
        helper.assertTrue(parcel.getDescriptionId().endsWith(".cotton_armor"),
                "oversized parcel type did not fall back to cotton armor");

        parcel.getOrCreateTag().putInt("ParcelType", -1);
        helper.assertTrue(parcel.getDescriptionId().endsWith(".cotton_armor"),
                "negative parcel type did not fall back to cotton armor");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void clothesRackUpperBreakDropsStoredArmorOnce(GameTestHelper helper) {
        BlockPos lowerPos = new BlockPos(1, 1, 1);
        BlockPos upperPos = lowerPos.above();
        BlockPos absoluteLower = helper.absolutePos(lowerPos);
        BlockPos absoluteUpper = helper.absolutePos(upperPos);
        ClothesRack rack = (ClothesRack) ChangShengJueBlocks.OAK_CLOTHES_RACK.get();
        helper.setBlock(lowerPos, rack.defaultBlockState().setValue(ClothesRack.HALF, DoubleBlockHalf.LOWER));
        helper.setBlock(upperPos, rack.defaultBlockState().setValue(ClothesRack.HALF, DoubleBlockHalf.UPPER));
        ClothesRackEntity entity = (ClothesRackEntity) helper.getLevel().getBlockEntity(absoluteLower);
        helper.assertTrue(entity != null, "lower clothes rack entity was not created");
        helper.assertTrue(entity.setArmorItem(0, new ItemStack(Items.IRON_CHESTPLATE)),
                "test armor could not be stored in clothes rack");
        AABB dropArea = new AABB(absoluteLower).inflate(2.0D);
        helper.getLevel().getEntitiesOfClass(ItemEntity.class, dropArea).forEach(Entity::discard);

        ServerPlayer player = new ServerPlayer(helper.getLevel().getServer(), helper.getLevel(),
                new GameProfile(UUID.randomUUID(), "clothes-rack-survival-test"));
        BlockState upperState = helper.getLevel().getBlockState(absoluteUpper);
        rack.playerWillDestroy(helper.getLevel(), absoluteUpper, upperState, player);
        helper.getLevel().setBlock(absoluteUpper, Blocks.AIR.defaultBlockState(), 3);

        assertDroppedCount(helper, dropArea, Items.IRON_CHESTPLATE, 1,
                "breaking the upper clothes rack must drop stored armor exactly once");
        helper.getLevel().getEntitiesOfClass(ItemEntity.class, dropArea).forEach(Entity::discard);
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void clothesRackCreativeBreakDoesNotDropStoredArmor(GameTestHelper helper) {
        BlockPos lowerPos = new BlockPos(1, 1, 1);
        BlockPos upperPos = lowerPos.above();
        BlockPos absoluteLower = helper.absolutePos(lowerPos);
        ClothesRack rack = (ClothesRack) ChangShengJueBlocks.OAK_CLOTHES_RACK.get();
        helper.setBlock(lowerPos, rack.defaultBlockState().setValue(ClothesRack.HALF, DoubleBlockHalf.LOWER));
        helper.setBlock(upperPos, rack.defaultBlockState().setValue(ClothesRack.HALF, DoubleBlockHalf.UPPER));
        ClothesRackEntity entity = (ClothesRackEntity) helper.getLevel().getBlockEntity(absoluteLower);
        helper.assertTrue(entity != null, "lower clothes rack entity was not created");
        helper.assertTrue(entity.setArmorItem(0, new ItemStack(Items.IRON_CHESTPLATE)),
                "test armor could not be stored in clothes rack");
        AABB dropArea = new AABB(absoluteLower).inflate(2.0D);
        helper.getLevel().getEntitiesOfClass(ItemEntity.class, dropArea).forEach(Entity::discard);

        ServerPlayer player = new ServerPlayer(helper.getLevel().getServer(), helper.getLevel(),
                new GameProfile(UUID.randomUUID(), "clothes-rack-creative-test")) {
            @Override
            public boolean isCreative() {
                return true;
            }
        };
        BlockState lowerState = helper.getLevel().getBlockState(absoluteLower);
        rack.playerWillDestroy(helper.getLevel(), absoluteLower, lowerState, player);
        helper.getLevel().setBlock(absoluteLower, Blocks.AIR.defaultBlockState(), 3);

        assertDroppedCount(helper, dropArea, Items.IRON_CHESTPLATE, 0,
                "creative clothes rack break must not drop stored armor");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void kilnTradeTypeChangeIsStableAndPersistent(GameTestHelper helper) {
        KilnWorker worker = ChangShengJueEntity.KILN_WORKER.get().create(helper.getLevel());
        helper.assertTrue(worker != null, "kiln worker was not created");
        helper.assertTrue(!worker.getOffers().isEmpty(), "GRE trade offers were not generated");
        worker.getOffers().get(0).increaseUses();

        helper.assertTrue(worker.changeCurrentTradeType(KilnWorkerTradeType.RED),
                "first trade type change was rejected");
        helper.assertTrue(worker.getCurrentTradeType() == KilnWorkerTradeType.RED,
                "trade type did not change");
        helper.assertTrue(worker.getOffers().stream().allMatch(offer -> offer.getUses() == 0),
                "uses leaked across different trade types");
        helper.assertTrue(!worker.getOffers().isEmpty(), "RED trade offers were not generated");
        worker.getOffers().get(0).increaseUses();
        Object redOffers = worker.getOffers();
        helper.assertTrue(!worker.changeCurrentTradeType(KilnWorkerTradeType.RED),
                "same trade type should be a no-op");
        helper.assertTrue(worker.getOffers() == redOffers,
                "same trade type rebuilt the offers");
        helper.assertTrue(worker.changeCurrentTradeType(KilnWorkerTradeType.GRE),
                "returning to GRE was rejected");
        helper.assertTrue(worker.getOffers().get(0).getUses() == 1,
                "GRE uses were reset after switching away and back");
        helper.assertTrue(worker.changeCurrentTradeType(KilnWorkerTradeType.RED),
                "returning to RED was rejected");
        helper.assertTrue(worker.getOffers().get(0).getUses() == 1,
                "RED uses were reset after switching away and back");

        CompoundTag saved = new CompoundTag();
        worker.addAdditionalSaveData(saved);
        KilnWorker loaded = ChangShengJueEntity.KILN_WORKER.get().create(helper.getLevel());
        helper.assertTrue(loaded != null, "reloaded kiln worker was not created");
        loaded.readAdditionalSaveData(saved);
        helper.assertTrue(loaded.getCurrentTradeType() == KilnWorkerTradeType.RED,
                "trade type was not restored from NBT");
        helper.assertTrue(loaded.getOffers().get(0).getUses() == 1,
                "active RED uses were not restored from NBT");
        helper.assertTrue(loaded.changeCurrentTradeType(KilnWorkerTradeType.GRE),
                "loaded worker could not switch to GRE");
        helper.assertTrue(loaded.getOffers().get(0).getUses() == 1,
                "inactive GRE uses were not restored from NBT");

        CompoundTag legacySaved = saved.copy();
        legacySaved.remove("TradeOffersByType");
        KilnWorker legacyLoaded = ChangShengJueEntity.KILN_WORKER.get().create(helper.getLevel());
        helper.assertTrue(legacyLoaded != null, "legacy kiln worker was not created");
        legacyLoaded.readAdditionalSaveData(legacySaved);
        helper.assertTrue(legacyLoaded.getCurrentTradeType() == KilnWorkerTradeType.RED,
                "legacy current trade type was not restored");
        helper.assertTrue(legacyLoaded.getOffers().get(0).getUses() == 1,
                "legacy active offers were not adopted without per-type data");

        legacySaved.remove("CurrentTradeType");
        KilnWorker preTypeLoaded = ChangShengJueEntity.KILN_WORKER.get().create(helper.getLevel());
        helper.assertTrue(preTypeLoaded != null, "pre-type kiln worker was not created");
        preTypeLoaded.readAdditionalSaveData(legacySaved);
        helper.assertTrue(preTypeLoaded.getCurrentTradeType() == KilnWorkerTradeType.GRE,
                "save without a trade type did not fall back to GRE");
        helper.assertTrue(preTypeLoaded.getOffers().get(0).getUses() == 1,
                "pre-type active offers were not preserved during fallback");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void merchantRestockWindowsMatchVanillaSemantics(GameTestHelper helper) {
        assertRestockWindows(helper,
                () -> ChangShengJueEntity.KILN_WORKER.get().create(helper.getLevel()), "kiln worker");
        assertRestockWindows(helper,
                () -> ChangShengJueEntity.BLACKSMITH.get().create(helper.getLevel()), "wuxia merchant");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void merchantRestockStateSurvivesNbtRoundTrip(GameTestHelper helper) {
        assertRestockNbtRoundTrip(helper,
                () -> ChangShengJueEntity.KILN_WORKER.get().create(helper.getLevel()), "kiln worker");
        assertRestockNbtRoundTrip(helper,
                () -> ChangShengJueEntity.BLACKSMITH.get().create(helper.getLevel()), "wuxia merchant");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void merchantCrossDayResetCatchesUpDemand(GameTestHelper helper) {
        long originalDayTime = helper.getLevel().getDayTime();
        long nextDayTime = (originalDayTime / 24000L + 1L) * 24000L;
        try {
            helper.getLevel().setDayTime(nextDayTime);
            assertCrossDayReset(helper,
                    () -> ChangShengJueEntity.KILN_WORKER.get().create(helper.getLevel()), "kiln worker");
            assertCrossDayReset(helper,
                    () -> ChangShengJueEntity.BLACKSMITH.get().create(helper.getLevel()), "wuxia merchant");
        } finally {
            helper.getLevel().setDayTime(originalDayTime);
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void frozenCraftingJobsFinishAfterRecipeRemoval(GameTestHelper helper) {
        BlockPos tailoringPos = new BlockPos(1, 1, 1);
        TailoringCaseEntity tailoring = placeEntity(helper, tailoringPos,
                ChangShengJueBlocks.TAILORING_CASE.get(), TailoringCaseEntity.class);
        loadFrozenJob(tailoring, Items.DIAMOND);
        tailoring.tick(helper.getLevel(), helper.absolutePos(tailoringPos), tailoring.getBlockState());
        helper.assertTrue(tailoring.getItemHandler().getStackInSlot(TailoringCaseEntity.SLOT_OUTPUT).is(Items.DIAMOND),
                "tailoring case blocked a frozen job after its recipe disappeared");

        BlockPos forgePos = new BlockPos(2, 1, 1);
        ForgeBlockEntity forge = placeEntity(helper, forgePos,
                ChangShengJueBlocks.FORGE_BLOCK.get(), ForgeBlockEntity.class);
        loadFrozenJob(forge, Items.IRON_INGOT);
        forge.tick(helper.getLevel(), helper.absolutePos(forgePos), forge.getBlockState());
        helper.assertTrue(forge.getItemHandler().getStackInSlot(ForgeBlockEntity.SLOT_OUTPUT).is(Items.IRON_INGOT),
                "forge block blocked a frozen job after its recipe disappeared");

        BlockPos woodworkingPos = new BlockPos(1, 1, 2);
        WoodworkingBenchEntity woodworking = placeEntity(helper, woodworkingPos,
                ChangShengJueBlocks.WOOD_WORKING_BENCH.get(), WoodworkingBenchEntity.class);
        loadFrozenJob(woodworking, Items.OAK_PLANKS);
        woodworking.tick(helper.getLevel(), helper.absolutePos(woodworkingPos), woodworking.getBlockState());
        helper.assertTrue(woodworking.getItemHandler().getStackInSlot(WoodworkingBenchEntity.SLOT_OUTPUT).is(Items.OAK_PLANKS),
                "woodworking bench blocked a frozen job after its recipe disappeared");

        BlockPos kilnPos = new BlockPos(2, 1, 2);
        BrickKilnEntity kiln = placeEntity(helper, kilnPos,
                ChangShengJueBlocks.BRICK_KILN.get(), BrickKilnEntity.class);
        loadFrozenJob(kiln, Items.BRICK);
        kiln.tick(helper.getLevel(), helper.absolutePos(kilnPos), kiln.getBlockState());
        helper.assertTrue(kiln.getItemHandler().getStackInSlot(BrickKilnEntity.SLOT_OUTPUT).is(Items.BRICK),
                "brick kiln blocked a frozen job after its recipe disappeared");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void wuxiaTradeMenusRejectNegativeSelection(GameTestHelper helper) {
        ServerPlayer player = new ServerPlayer(
                helper.getLevel().getServer(), helper.getLevel(),
                new GameProfile(UUID.randomUUID(), "negative-trade-test"));
        ClientSideMerchant merchant = new ClientSideMerchant(player);

        new BlacksmithMenu(1, player.getInventory(), merchant).tryMoveItems(-1);
        new InnkeeperMenu(2, player.getInventory(), merchant).tryMoveItems(-1);
        new KilnWorkerMenu(3, player.getInventory(), merchant).tryMoveItems(-1);
        new GangleaderTradingMenu(4, player.getInventory(), merchant).tryMoveItems(-1);

        helper.succeed();
    }

    private static <B extends BlockEntity> B placeEntity(GameTestHelper helper, BlockPos relativePos,
                                                          Block block, Class<B> type) {
        helper.setBlock(relativePos, block);
        BlockEntity entity = helper.getLevel().getBlockEntity(helper.absolutePos(relativePos));
        helper.assertTrue(type.isInstance(entity), "expected block entity was not created");
        return type.cast(entity);
    }

    private static void assertRestockWindows(GameTestHelper helper,
                                             Supplier<? extends AbstractVillager> factory, String label) {
        long gameTime = helper.getLevel().getGameTime();
        AbstractVillager first = configuredRestockMerchant(helper, factory, 0, gameTime, helper.getLevel().getDayTime());
        helper.assertTrue(shouldRestock(first), label + " rejected its first daily restock");

        AbstractVillager boundary = configuredRestockMerchant(helper, factory, 1,
                gameTime - 2400L, helper.getLevel().getDayTime());
        helper.assertTrue(!shouldRestock(boundary), label + " accepted its second restock at the strict boundary");

        AbstractVillager second = configuredRestockMerchant(helper, factory, 1,
                gameTime - 2401L, helper.getLevel().getDayTime());
        helper.assertTrue(shouldRestock(second), label + " rejected its second restock after cooldown");

        AbstractVillager exhausted = configuredRestockMerchant(helper, factory, 2,
                gameTime - 2401L, helper.getLevel().getDayTime());
        helper.assertTrue(!shouldRestock(exhausted), label + " allowed a third daily restock");
    }

    private static void assertRestockNbtRoundTrip(GameTestHelper helper,
                                                   Supplier<? extends AbstractVillager> factory, String label) {
        long gameTime = helper.getLevel().getGameTime();
        long checkTime = Math.max(1L, helper.getLevel().getDayTime());
        AbstractVillager original = configuredRestockMerchant(helper, factory, 1, gameTime - 1200L, checkTime);
        CompoundTag saved = new CompoundTag();
        original.addAdditionalSaveData(saved);
        AbstractVillager loaded = factory.get();
        helper.assertTrue(loaded != null, label + " was not created for NBT reload");
        loaded.readAdditionalSaveData(saved);
        CompoundTag roundTripped = new CompoundTag();
        loaded.addAdditionalSaveData(roundTripped);
        helper.assertTrue(roundTripped.getLong("LastRestock") == gameTime - 1200L,
                label + " changed LastRestock during NBT round trip");
        helper.assertTrue(roundTripped.getInt("RestocksToday") == 1,
                label + " changed RestocksToday during NBT round trip");
        helper.assertTrue(roundTripped.getLong("LastRestockCheckDayTime") == checkTime,
                label + " changed LastRestockCheckDayTime during NBT round trip");
    }

    private static void assertCrossDayReset(GameTestHelper helper,
                                            Supplier<? extends AbstractVillager> factory, String label) {
        assertCrossDayResetCase(helper, factory, label, 0);
        assertCrossDayResetCase(helper, factory, label, 1);
        assertCrossDayResetCase(helper, factory, label, 2);
    }

    private static void assertCrossDayResetCase(GameTestHelper helper,
                                                Supplier<? extends AbstractVillager> factory, String label,
                                                int previousRestocks) {
        long gameTime = helper.getLevel().getGameTime();
        long previousDay = Math.max(1L, helper.getLevel().getDayTime() - 24000L);
        AbstractVillager merchant = configuredRestockMerchant(
                helper, factory, previousRestocks, gameTime, previousDay);
        helper.assertTrue(shouldRestock(merchant),
                label + " rejected the first restock after a day boundary and " + previousRestocks + " prior restocks");
        helper.assertTrue(merchant.getOffers().get(0).needsRestock(),
                label + " reset trade uses during cross-day demand catch-up");
        int expectedCatchUpDemand = previousRestocks == 0 ? 1 : 0;
        helper.assertTrue(merchant.getOffers().get(0).getDemand() == expectedCatchUpDemand,
                label + " applied catch-up demand for the wrong previous restock count");
        restock(merchant);
        assertRestockCount(helper, merchant, 1,
                label + " did not count the first post-boundary restock");

        configureRestockMerchant(merchant, 1, gameTime - 2401L, helper.getLevel().getDayTime());
        helper.assertTrue(shouldRestock(merchant),
                label + " rejected the second daily restock after cooldown");
        restock(merchant);
        assertRestockCount(helper, merchant, 2,
                label + " did not count the second daily restock");

        configureRestockMerchant(merchant, 2, gameTime - 2401L, helper.getLevel().getDayTime());
        helper.assertTrue(!shouldRestock(merchant),
                label + " allowed a third restock in the new day");
    }

    private static AbstractVillager configuredRestockMerchant(GameTestHelper helper,
                                                                Supplier<? extends AbstractVillager> factory,
                                                                int restocksToday, long lastRestock,
                                                                long lastCheckDayTime) {
        AbstractVillager merchant = factory.get();
        helper.assertTrue(merchant != null, "merchant was not created");
        configureRestockMerchant(merchant, restocksToday, lastRestock, lastCheckDayTime);
        return merchant;
    }

    private static void configureRestockMerchant(AbstractVillager merchant, int restocksToday,
                                                  long lastRestock, long lastCheckDayTime) {
        CompoundTag state = new CompoundTag();
        merchant.addAdditionalSaveData(state);
        state.putLong("LastRestock", lastRestock);
        state.putInt("RestocksToday", restocksToday);
        state.putLong("LastRestockCheckDayTime", lastCheckDayTime);
        merchant.readAdditionalSaveData(state);
        merchant.getOffers().clear();
        MerchantOffer exhausted = new MerchantOffer(
                new ItemStack(Items.EMERALD), new ItemStack(Items.DIAMOND), 1, 1, 0.05F);
        exhausted.increaseUses();
        merchant.getOffers().add(exhausted);
    }

    private static boolean shouldRestock(AbstractVillager merchant) {
        if (merchant instanceof KilnWorker kilnWorker) {
            return kilnWorker.shouldRestock();
        }
        return ((AbstractWuXiaMerchant) merchant).shouldRestock();
    }

    private static void restock(AbstractVillager merchant) {
        if (merchant instanceof KilnWorker kilnWorker) {
            kilnWorker.restock();
        } else {
            ((AbstractWuXiaMerchant) merchant).restock();
        }
    }

    private static void assertRestockCount(GameTestHelper helper, AbstractVillager merchant,
                                           int expected, String message) {
        CompoundTag saved = new CompoundTag();
        merchant.addAdditionalSaveData(saved);
        helper.assertTrue(saved.getInt("RestocksToday") == expected, message);
    }

    private static void loadFrozenJob(BlockEntity entity, net.minecraft.world.item.Item output) {
        CompoundTag state = entity.getUpdateTag();
        state.putInt("progress", 100);
        state.putString("current_recipe", ChangShengJue.MOD_ID + ":removed_regression_recipe");
        CompoundTag job = new CompoundTag();
        job.putString("recipe", ChangShengJue.MOD_ID + ":removed_regression_recipe");
        job.put("output", new ItemStack(output).save(new CompoundTag()));
        job.putInt("total", 1);
        job.putInt("remaining", 1);
        job.putInt("progress", 100);
        state.put("active_job", job);
        entity.load(state);
    }

    private static void assertDroppedCount(GameTestHelper helper, AABB area, net.minecraft.world.item.Item item,
                                           int expected, String message) {
        int count = helper.getLevel().getEntitiesOfClass(
                        ItemEntity.class, area, entity -> entity.getItem().is(item))
                .stream()
                .mapToInt(entity -> entity.getItem().getCount())
                .sum();
        helper.assertTrue(count == expected, message + "; got " + count);
    }
}
