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
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.brick_kiln.BrickKilnMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.forgeblock.ForgeBlockMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.plaque.PlaqueMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.plaque.UpdatePlaqueTextPacket;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.tailoringcase.TailoringCaseMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.workbench.WoodworkingBenchMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.PlayerQuestMenu;
import com.shengchanshe.chang_sheng_jue.network.ServerPacketGuard;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.BrickKilnSyncRecipePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.ForgeSyncRecipePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.TailoringSyncRecipePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.WoodworkingBenchSyncRecipePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest.PlayerQuestPacketGuard;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest.OpenPlayerQuestScreenPacket;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderException;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class NetworkSecurityGameTests {
    private NetworkSecurityGameTests() {
    }

    @GameTest(template = "empty")
    public static void craftAmountBounds(GameTestHelper helper) {
        helper.assertTrue(!ServerPacketGuard.isCraftAmountValid(0), "0 must be rejected");
        helper.assertTrue(ServerPacketGuard.isCraftAmountValid(1), "1 must be accepted");
        helper.assertTrue(ServerPacketGuard.isCraftAmountValid(64), "64 must be accepted");
        helper.assertTrue(!ServerPacketGuard.isCraftAmountValid(65), "65 must be rejected");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void playerQuestOpenIsContextBoundAndRateLimited(GameTestHelper helper) {
        ServerPlayer player = createUnconnectedServerPlayer(helper);
        player.containerMenu = player.inventoryMenu;
        helper.assertTrue(PlayerQuestPacketGuard.allowOpen(player), "first inventory-context open must be accepted");
        helper.assertTrue(!PlayerQuestPacketGuard.allowOpen(player), "repeated open in the cooldown window must be rejected");
        player.containerMenu = new AbstractContainerMenu(null, 1) {
            @Override
            public ItemStack quickMoveStack(net.minecraft.world.entity.player.Player player, int index) {
                return ItemStack.EMPTY;
            }

            @Override
            public boolean stillValid(net.minecraft.world.entity.player.Player player) {
                return true;
            }
        };
        helper.assertTrue(!PlayerQuestPacketGuard.allowOpen(player), "non-inventory menu context must be rejected");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void playerQuestOpenRejectsOversizedTitleBeforeHandling(GameTestHelper helper) {
        FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
        try {
            buffer.writeInt(0);
            buffer.writeUtf("\"" + "x".repeat(513) + "\"");
            boolean rejected = false;
            try {
                OpenPlayerQuestScreenPacket.decode(buffer);
            } catch (DecoderException expected) {
                rejected = true;
            }
            helper.assertTrue(rejected, "oversized ignored title must be rejected during decode");
        } finally {
            buffer.release();
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void playerQuestActionsAreContextBoundAndRateLimited(GameTestHelper helper) {
        ServerPlayer player = createUnconnectedServerPlayer(helper);
        player.containerMenu = new PlayerQuestMenu(1, player.getInventory(), player);
        helper.assertTrue(PlayerQuestPacketGuard.allowAction(player),
                "first action from the player quest menu must be accepted");
        helper.assertTrue(!PlayerQuestPacketGuard.allowAction(player),
                "repeated action in the cooldown window must be rejected");
        player.containerMenu = player.inventoryMenu;
        helper.assertTrue(!PlayerQuestPacketGuard.allowAction(player),
                "action outside the player quest menu must be rejected");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void overlappingIngredientsCannotReuseOneStack(GameTestHelper helper) {
        SimpleContainer inventory = new SimpleContainer(new ItemStack(Items.IRON_INGOT));
        NonNullList<Ingredient> ingredients = NonNullList.of(
                Ingredient.EMPTY,
                Ingredient.of(Items.IRON_INGOT),
                Ingredient.of(Items.IRON_INGOT)
        );
        helper.assertTrue(!CraftingMaterialTransaction.consume(inventory, ingredients, new int[]{1, 1}, 1),
                "one stack must not satisfy two overlapping ingredients");
        helper.assertTrue(inventory.getItem(0).getCount() == 1,
                "failed transaction must not consume any material");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void activeJobNbtRoundTripFreezesOutputAndCount(GameTestHelper helper) {
        ResourceLocation recipeId = new ResourceLocation(ChangShengJue.MOD_ID, "security_test");
        PersistedCraftingJob source = new PersistedCraftingJob(recipeId, new ItemStack(Items.DIAMOND, 2), 4, 3);
        PersistedCraftingJob.Loaded loaded = PersistedCraftingJob.load(source.save(37), 100);
        helper.assertTrue(loaded != null, "valid active job must load");
        helper.assertTrue(loaded.job().recipeId().equals(recipeId), "recipe id changed during NBT round trip");
        helper.assertTrue(loaded.job().output().is(Items.DIAMOND) && loaded.job().output().getCount() == 2,
                "frozen output changed during NBT round trip");
        helper.assertTrue(loaded.job().total() == 4 && loaded.job().remaining() == 3 && loaded.progress() == 37,
                "frozen count/progress changed during NBT round trip");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void materialPlannerHandlesWideThenNarrowIngredient(GameTestHelper helper) {
        SimpleContainer inventory = new SimpleContainer(new ItemStack(Items.IRON_INGOT), new ItemStack(Items.GOLD_INGOT));
        NonNullList<Ingredient> ingredients = NonNullList.of(Ingredient.EMPTY,
                Ingredient.of(Items.IRON_INGOT, Items.GOLD_INGOT), Ingredient.of(Items.IRON_INGOT));
        helper.assertTrue(CraftingMaterialTransaction.consume(inventory, ingredients, new int[]{1, 1}, 1),
                "capacity planner rejected a valid wide+narrow allocation");
        helper.assertTrue(inventory.isEmpty(), "capacity planner did not commit the full allocation");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void materialPlannerIsIndependentOfIngredientOrder(GameTestHelper helper) {
        NonNullList<Ingredient> ingredients = NonNullList.of(Ingredient.EMPTY,
                Ingredient.of(Items.IRON_INGOT), Ingredient.of(Items.IRON_INGOT, Items.GOLD_INGOT));
        SimpleContainer inventory = new SimpleContainer(new ItemStack(Items.IRON_INGOT), new ItemStack(Items.GOLD_INGOT));
        helper.assertTrue(CraftingMaterialTransaction.consume(inventory, ingredients, new int[]{1, 1}, 1),
                "permuted valid allocation was rejected");
        helper.assertTrue(inventory.isEmpty(), "permuted allocation left uncommitted materials");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void materialPlannerCombinesMultipleStacks(GameTestHelper helper) {
        SimpleContainer inventory = new SimpleContainer(new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT));
        NonNullList<Ingredient> ingredients = NonNullList.of(Ingredient.EMPTY, Ingredient.of(Items.IRON_INGOT));
        helper.assertTrue(CraftingMaterialTransaction.consume(inventory, ingredients, new int[]{2}, 1),
                "one requirement was not split across multiple stacks");
        helper.assertTrue(inventory.isEmpty(), "multi-stack allocation did not consume both stacks");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void activeJobRejectsInvalidNbtBounds(GameTestHelper helper) {
        PersistedCraftingJob valid = new PersistedCraftingJob(
                new ResourceLocation(ChangShengJue.MOD_ID, "bounds"), new ItemStack(Items.BRICK), 1, 1);
        CompoundTag invalidCount = valid.save(1);
        invalidCount.putInt("total", 65);
        helper.assertTrue(PersistedCraftingJob.load(invalidCount, 100) == null, "job total above 64 was accepted");
        CompoundTag invalidProgress = valid.save(101);
        helper.assertTrue(PersistedCraftingJob.load(invalidProgress, 100) == null, "progress above device maximum was accepted");
        CompoundTag invalidOutput = valid.save(1);
        invalidOutput.getCompound("output").putByte("Count", (byte) 65);
        helper.assertTrue(PersistedCraftingJob.load(invalidOutput, 100) == null, "oversized output stack was accepted");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void legacyMissingRecipeWaitsWithoutProducing(GameTestHelper helper) {
        TailoringCaseEntity tailoring = placeEntity(helper, BlockPos.ZERO,
                ChangShengJueBlocks.TAILORING_CASE.get(), TailoringCaseEntity.class);
        CompoundTag legacy = tailoring.saveWithFullMetadata();
        legacy.putInt("progress", 20);
        legacy.putString("current_recipe", ChangShengJue.MOD_ID + ":temporarily_missing");
        tailoring.load(legacy);
        tailoring.tick(helper.getLevel(), tailoring.getBlockPos(), tailoring.getBlockState());
        CompoundTag after = tailoring.saveWithFullMetadata();
        helper.assertTrue(after.getInt("progress") == 20, "missing legacy recipe advanced or reset progress");
        helper.assertTrue(after.getString("current_recipe").endsWith("temporarily_missing"), "waiting recipe id was lost");
        helper.assertTrue(tailoring.getItemHandler().getStackInSlot(TailoringCaseEntity.SLOT_OUTPUT).isEmpty(),
                "missing legacy recipe produced an item");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void tailoringAndForgeClearLegacyGhostInputs(GameTestHelper helper) {
        TailoringCaseEntity tailoring = placeEntity(helper, new BlockPos(0, 0, 0),
                ChangShengJueBlocks.TAILORING_CASE.get(), TailoringCaseEntity.class);
        ForgeBlockEntity forge = placeEntity(helper, new BlockPos(2, 0, 0),
                ChangShengJueBlocks.FORGE_BLOCK.get(), ForgeBlockEntity.class);
        verifyLegacyGhostCleanup(helper, tailoring.getItemHandler(), tailoring::onLoad, tailoring, "tailoring case");
        verifyLegacyGhostCleanup(helper, forge.getItemHandler(), forge::onLoad, forge, "forge block");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void outputExtractionMarksChunkDirtyForAllMachines(GameTestHelper helper) {
        verifyOutputExtractionDirty(helper, BlockPos.ZERO, ChangShengJueBlocks.TAILORING_CASE.get(),
                TailoringCaseEntity.class, TailoringCaseEntity.SLOT_OUTPUT);
        verifyOutputExtractionDirty(helper, BlockPos.ZERO, ChangShengJueBlocks.FORGE_BLOCK.get(),
                ForgeBlockEntity.class, ForgeBlockEntity.SLOT_OUTPUT);
        verifyOutputExtractionDirty(helper, BlockPos.ZERO, ChangShengJueBlocks.WOOD_WORKING_BENCH.get(),
                WoodworkingBenchEntity.class, WoodworkingBenchEntity.SLOT_OUTPUT);
        verifyOutputExtractionDirty(helper, BlockPos.ZERO, ChangShengJueBlocks.BRICK_KILN.get(),
                BrickKilnEntity.class, BrickKilnEntity.SLOT_OUTPUT);
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void tailoringAndForgeMenusRejectGhostQuickMove(GameTestHelper helper) {
        ServerPlayer player = createUnconnectedServerPlayer(helper);
        TailoringCaseEntity tailoring = placeEntity(helper, BlockPos.ZERO,
                ChangShengJueBlocks.TAILORING_CASE.get(), TailoringCaseEntity.class);
        TailoringCaseMenu tailoringMenu = new TailoringCaseMenu(1, player.getInventory(), tailoring, new SimpleContainerData(2));
        tailoring.getItemHandler().setStackInSlot(0, new ItemStack(Items.DIAMOND));
        helper.assertTrue(tailoringMenu.quickMoveStack(player, 36).isEmpty(), "tailoring ghost slot was quick-moved");
        helper.assertTrue(tailoring.getItemHandler().getStackInSlot(0).is(Items.DIAMOND), "tailoring ghost slot changed");

        ForgeBlockEntity forge = placeEntity(helper, BlockPos.ZERO,
                ChangShengJueBlocks.FORGE_BLOCK.get(), ForgeBlockEntity.class);
        ForgeBlockMenu forgeMenu = new ForgeBlockMenu(2, player.getInventory(), forge, new SimpleContainerData(2));
        forge.getItemHandler().setStackInSlot(0, new ItemStack(Items.DIAMOND));
        helper.assertTrue(forgeMenu.quickMoveStack(player, 36).isEmpty(), "forge ghost slot was quick-moved");
        helper.assertTrue(forge.getItemHandler().getStackInSlot(0).is(Items.DIAMOND), "forge ghost slot changed");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void invalidMenuBlockEntitiesUseSafeEmptyMirrors(GameTestHelper helper) {
        ServerPlayer player = createUnconnectedServerPlayer(helper);
        BlockPos wrongTypePos = helper.absolutePos(BlockPos.ZERO);
        helper.setBlock(BlockPos.ZERO, ChangShengJueBlocks.FORGE_BLOCK.get());
        BlockPos missingPos = wrongTypePos.offset(2, 0, 0);

        BrickKilnMenu kiln = withMenuBuffer(wrongTypePos,
                buffer -> new BrickKilnMenu(1, player.getInventory(), buffer));
        TailoringCaseMenu tailoring = withMenuBuffer(wrongTypePos,
                buffer -> new TailoringCaseMenu(2, player.getInventory(), buffer));
        WoodworkingBenchMenu woodworking = withMenuBuffer(wrongTypePos,
                buffer -> new WoodworkingBenchMenu(3, player.getInventory(), buffer));
        ForgeBlockMenu forge = withMenuBuffer(missingPos,
                buffer -> new ForgeBlockMenu(4, player.getInventory(), buffer));
        PlaqueMenu plaque = withMenuBuffer(wrongTypePos,
                buffer -> new PlaqueMenu(5, player.getInventory(), buffer));

        helper.assertTrue(!kiln.hasValidBackingEntity() && kiln.slots.size() == 46,
                "invalid kiln menu did not expose a safe 36+10 slot mirror");
        helper.assertTrue(!tailoring.hasValidBackingEntity() && tailoring.slots.size() == 46,
                "invalid tailoring menu did not expose a safe 36+10 slot mirror");
        helper.assertTrue(!woodworking.hasValidBackingEntity() && woodworking.slots.size() == 46,
                "invalid woodworking menu did not expose a safe 36+10 slot mirror");
        helper.assertTrue(!forge.hasValidBackingEntity() && forge.slots.size() == 46,
                "invalid forge menu did not expose a safe 36+10 slot mirror");
        helper.assertTrue(!plaque.hasValidBackingEntity() && !plaque.stillValid(player),
                "invalid plaque menu remained interactive");

        player.getInventory().setItem(0, new ItemStack(Items.DIAMOND));
        helper.assertTrue(kiln.quickMoveStack(player, 0).isEmpty()
                        && tailoring.quickMoveStack(player, 0).isEmpty()
                        && woodworking.quickMoveStack(player, 0).isEmpty()
                        && forge.quickMoveStack(player, 0).isEmpty(),
                "invalid menu moved a player item");
        helper.assertTrue(player.getInventory().getItem(0).is(Items.DIAMOND),
                "invalid menu changed the player inventory");
        helper.assertTrue(kiln.getCurrentRecipe() == null && kiln.getCraftTimes() == 0
                        && !kiln.craftItem(player),
                "invalid kiln mirror exposed mutable crafting state");
        helper.assertTrue(tailoring.getCurrentRecipe() == null
                        && woodworking.getCurrentRecipe() == null && woodworking.getCraftTimes() == 0
                        && !woodworking.craftItem(player)
                        && forge.getCurrentRecipe() == null && !forge.craftItem(player),
                "invalid crafting mirror exposed mutable recipe state");
        helper.assertTrue(plaque.getTextCapacity() == 0 && plaque.getPlaqueText().isEmpty(),
                "invalid plaque mirror exposed world text");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void activeJobRejectsAmountMutation(GameTestHelper helper) {
        WoodworkingBenchEntity woodworking = placeEntity(helper, new BlockPos(0, 0, 0),
                ChangShengJueBlocks.WOOD_WORKING_BENCH.get(), WoodworkingBenchEntity.class);
        BrickKilnEntity kiln = placeEntity(helper, new BlockPos(2, 0, 0),
                ChangShengJueBlocks.BRICK_KILN.get(), BrickKilnEntity.class);
        CompoundTag active = new PersistedCraftingJob(
                new ResourceLocation(ChangShengJue.MOD_ID, "missing_but_frozen"), new ItemStack(Items.BRICK), 2, 2
        ).save(10);
        CompoundTag woodworkingTag = woodworking.saveWithFullMetadata();
        woodworkingTag.put("active_job", active.copy());
        woodworking.load(woodworkingTag);
        CompoundTag woodworkingFrozen = woodworking.saveWithFullMetadata().getCompound("active_job").copy();
        woodworking.setCraftTimes(64);
        helper.assertTrue(woodworking.getCraftTimes() == 2, "woodworking amount changed during active job");
        helper.assertTrue(woodworkingFrozen.equals(woodworking.saveWithFullMetadata().getCompound("active_job")),
                "woodworking active job changed after rejected mutation");
        CompoundTag kilnTag = kiln.saveWithFullMetadata();
        kilnTag.put("active_job", active.copy());
        kiln.load(kilnTag);
        CompoundTag kilnFrozen = kiln.saveWithFullMetadata().getCompound("active_job").copy();
        kiln.setCraftTimes(64);
        helper.assertTrue(kiln.getCraftTimes() == 2, "brick kiln amount changed during active job");
        helper.assertTrue(kilnFrozen.equals(kiln.saveWithFullMetadata().getCompound("active_job")),
                "brick kiln active job changed after rejected mutation");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void tailoringRejectsOversizedRecipeId(GameTestHelper helper) {
        FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
        try {
            buffer.writeBlockPos(BlockPos.ZERO);
            buffer.writeBoolean(true);
            buffer.writeInt(257);
            expectDecoderRejection(buffer, helper, "oversized recipe id must be rejected");
        } finally {
            buffer.release();
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void tailoringRejectsInvalidRecipeId(GameTestHelper helper) {
        byte[] invalidId = "INVALID ID".getBytes(StandardCharsets.UTF_8);
        FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
        try {
            buffer.writeBlockPos(BlockPos.ZERO);
            buffer.writeBoolean(true);
            buffer.writeInt(invalidId.length);
            buffer.writeBytes(invalidId);
            expectDecoderRejection(buffer, helper, "invalid recipe id must be rejected");
        } finally {
            buffer.release();
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void forgeRejectsOversizedRecipeId(GameTestHelper helper) {
        verifyUtfRecipeLengthBound(helper, ForgeSyncRecipePacket::fromBytes, "forge");
    }

    @GameTest(template = "empty")
    public static void woodworkingRejectsOversizedRecipeId(GameTestHelper helper) {
        verifyUtfRecipeLengthBound(helper, WoodworkingBenchSyncRecipePacket::fromBytes, "woodworking");
    }

    @GameTest(template = "empty")
    public static void brickKilnRejectsOversizedRecipeId(GameTestHelper helper) {
        verifyUtfRecipeLengthBound(helper, BrickKilnSyncRecipePacket::fromBytes, "brick kiln");
    }

    @GameTest(template = "empty")
    public static void tailoringPreservesPublishedWireFormat(GameTestHelper helper) {
        BlockPos pos = new BlockPos(1, 2, 3);
        ResourceLocation recipeId = new ResourceLocation(ChangShengJue.MOD_ID, "test_recipe");
        byte[] expectedId = recipeId.toString().getBytes(StandardCharsets.UTF_8);
        FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
        try {
            new TailoringSyncRecipePacket(pos, recipeId).toBytes(buffer);
            helper.assertTrue(pos.equals(buffer.readBlockPos()), "BlockPos field order changed");
            helper.assertTrue(buffer.readBoolean(), "present recipe id must retain presence=true");
            int length = buffer.readInt();
            helper.assertTrue(length == expectedId.length, "recipe id byte length changed");
            byte[] actualId = new byte[length];
            buffer.readBytes(actualId);
            helper.assertTrue(Arrays.equals(expectedId, actualId), "recipe id bytes changed");
            helper.assertTrue(buffer.readableBytes() == 0, "unexpected trailing bytes");
        } finally {
            buffer.release();
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void tailoringPreservesPublishedNullEncoding(GameTestHelper helper) {
        FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
        try {
            new TailoringSyncRecipePacket(BlockPos.ZERO, (ResourceLocation) null).toBytes(buffer);
            helper.assertTrue(BlockPos.ZERO.equals(buffer.readBlockPos()), "BlockPos field order changed");
            helper.assertTrue(!buffer.readBoolean(), "null recipe id must retain presence=false");
            helper.assertTrue(buffer.readableBytes() == 0, "null recipe id gained trailing bytes");
        } finally {
            buffer.release();
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void plaqueRejectsOversizedText(GameTestHelper helper) {
        FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
        try {
            UpdatePlaqueTextPacket packet = new UpdatePlaqueTextPacket(
                    BlockPos.ZERO,
                    "x".repeat(UpdatePlaqueTextPacket.MAX_TEXT_LENGTH + 1)
            );
            boolean rejected = false;
            try {
                packet.toBytes(buffer);
            } catch (RuntimeException expected) {
                rejected = true;
            }
            helper.assertTrue(rejected, "oversized plaque text must be rejected");
        } finally {
            buffer.release();
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void tailoringGuardUsesMenuAuthority(GameTestHelper helper) {
        verifyCraftGuard(
                helper,
                ChangShengJueBlocks.TAILORING_CASE.get(),
                TailoringCaseEntity.class,
                (player, entity) -> new TailoringCaseMenu(1, player.getInventory(), entity, new SimpleContainerData(2)),
                ServerPacketGuard::tailoringCase
        );
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void forgeGuardUsesMenuAuthority(GameTestHelper helper) {
        verifyCraftGuard(
                helper,
                ChangShengJueBlocks.FORGE_BLOCK.get(),
                ForgeBlockEntity.class,
                (player, entity) -> new ForgeBlockMenu(1, player.getInventory(), entity, new SimpleContainerData(2)),
                ServerPacketGuard::forgeBlock
        );
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void woodworkingGuardUsesMenuAuthority(GameTestHelper helper) {
        verifyCraftGuard(
                helper,
                ChangShengJueBlocks.WOOD_WORKING_BENCH.get(),
                WoodworkingBenchEntity.class,
                (player, entity) -> new WoodworkingBenchMenu(1, player.getInventory(), entity, new SimpleContainerData(3)),
                ServerPacketGuard::woodworkingBench
        );
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void brickKilnGuardUsesMenuAuthority(GameTestHelper helper) {
        verifyCraftGuard(
                helper,
                ChangShengJueBlocks.BRICK_KILN.get(),
                BrickKilnEntity.class,
                (player, entity) -> new BrickKilnMenu(1, player.getInventory(), entity, new SimpleContainerData(3)),
                ServerPacketGuard::brickKiln
        );
        helper.succeed();
    }

    private static void expectDecoderRejection(FriendlyByteBuf buffer, GameTestHelper helper, String message) {
        boolean rejected = false;
        try {
            TailoringSyncRecipePacket.fromBytes(buffer);
        } catch (DecoderException expected) {
            rejected = true;
        }
        helper.assertTrue(rejected, message);
    }

    private static void verifyUtfRecipeLengthBound(
            GameTestHelper helper,
            Consumer<FriendlyByteBuf> decoder,
            String deviceName
    ) {
        FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
        try {
            buffer.writeBlockPos(BlockPos.ZERO);
            buffer.writeBoolean(true);
            buffer.writeUtf("a".repeat(257));
            boolean rejected = false;
            try {
                decoder.accept(buffer);
            } catch (DecoderException expected) {
                rejected = true;
            }
            helper.assertTrue(rejected, deviceName + " oversized recipe id must be rejected");
        } finally {
            buffer.release();
        }
        helper.succeed();
    }

    private static <B extends BlockEntity> void verifyCraftGuard(
            GameTestHelper helper,
            Block block,
            Class<B> entityType,
            MenuFactory<B> menuFactory,
            PositionGuard<B> guard
    ) {
        BlockPos relativePos = BlockPos.ZERO;
        BlockPos absolutePos = helper.absolutePos(relativePos);
        helper.setBlock(relativePos, block);

        BlockEntity placedEntity = helper.getLevel().getBlockEntity(absolutePos);
        helper.assertTrue(entityType.isInstance(placedEntity), "device block entity was not created");
        B entity = entityType.cast(placedEntity);
        ServerPlayer player = createUnconnectedServerPlayer(helper);
        player.setPos(absolutePos.getX() + 0.5D, absolutePos.getY() + 0.5D, absolutePos.getZ() + 0.5D);

        AbstractContainerMenu deviceMenu = menuFactory.create(player, entity);
        player.containerMenu = deviceMenu;
        helper.assertTrue(guard.apply(player, absolutePos).orElse(null) == entity,
                "matching packet position must accept the menu-bound block entity");

        assertRejectedWithoutInventoryChanges(
                helper,
                player,
                entity,
                () -> guard.apply(player, absolutePos.offset(32, 0, 0)),
                "forged packet position must be rejected"
        );
        assertRejectedWithoutInventoryChanges(
                helper,
                player,
                entity,
                () -> guard.apply(player, null),
                "null packet position must be rejected"
        );

        player.containerMenu = player.inventoryMenu;
        assertRejectedWithoutInventoryChanges(
                helper,
                player,
                entity,
                () -> guard.apply(player, absolutePos),
                "wrong menu must be rejected"
        );

        player.containerMenu = deviceMenu;
        player.setPos(absolutePos.getX() + 16.5D, absolutePos.getY() + 0.5D, absolutePos.getZ() + 0.5D);
        assertRejectedWithoutInventoryChanges(
                helper,
                player,
                entity,
                () -> guard.apply(player, absolutePos),
                "player beyond the menu interaction distance must be rejected"
        );
    }

    private static void assertRejectedWithoutInventoryChanges(
            GameTestHelper helper,
            ServerPlayer player,
            BlockEntity entity,
            GuardAttempt guardAttempt,
            String message
    ) {
        CompoundTag entityBefore = entity.saveWithFullMetadata();
        ListTag inventoryBefore = new ListTag();
        player.getInventory().save(inventoryBefore);

        helper.assertTrue(guardAttempt.get().isEmpty(), message);
        helper.assertTrue(entityBefore.equals(entity.saveWithFullMetadata()), message + " (block entity changed)");
        ListTag inventoryAfter = new ListTag();
        player.getInventory().save(inventoryAfter);
        helper.assertTrue(inventoryBefore.equals(inventoryAfter), message + " (player inventory changed)");
    }

    private static ServerPlayer createUnconnectedServerPlayer(GameTestHelper helper) {
        return new ServerPlayer(
                helper.getLevel().getServer(),
                helper.getLevel(),
                new GameProfile(UUID.randomUUID(), "guard-test")
        ) {
            @Override
            public boolean isSpectator() {
                return false;
            }

            @Override
            public boolean isCreative() {
                return true;
            }
        };
    }

    private static <T> T withMenuBuffer(BlockPos pos, java.util.function.Function<FriendlyByteBuf, T> factory) {
        FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
        try {
            buffer.writeBlockPos(pos);
            return factory.apply(buffer);
        } finally {
            buffer.release();
        }
    }

    private static <B extends BlockEntity> B placeEntity(GameTestHelper helper, BlockPos relativePos,
                                                          Block block, Class<B> type) {
        helper.setBlock(relativePos, block);
        BlockEntity entity = helper.getLevel().getBlockEntity(helper.absolutePos(relativePos));
        helper.assertTrue(type.isInstance(entity), "expected block entity was not created");
        return type.cast(entity);
    }

    private static void verifyLegacyGhostCleanup(GameTestHelper helper,
                                                  net.minecraftforge.items.ItemStackHandler handler,
                                                  Runnable reload,
                                                  BlockEntity entity,
                                                  String name) {
        handler.setStackInSlot(0, new ItemStack(Items.DIAMOND));
        handler.setStackInSlot(9, new ItemStack(Items.EMERALD));
        CompoundTag saved = entity.saveWithFullMetadata();
        entity.load(saved);
        reload.run();
        helper.assertTrue(handler.getStackInSlot(0).isEmpty(), name + " retained a legacy ghost input");
        helper.assertTrue(handler.getStackInSlot(9).is(Items.EMERALD), name + " lost its real output");
        var sideHandler = entity.getCapability(net.minecraftforge.common.capabilities.ForgeCapabilities.ITEM_HANDLER, Direction.UP).resolve();
        helper.assertTrue(sideHandler.isPresent(), name + " side capability was absent");
        ItemStack rejected = sideHandler.orElseThrow().insertItem(0, new ItemStack(Items.DIAMOND), false);
        helper.assertTrue(rejected.getCount() == 1, name + " side capability accepted an insertion");
    }

    private static <B extends BlockEntity> void verifyOutputExtractionDirty(GameTestHelper helper,
                                                                             BlockPos relativePos,
                                                                             Block block,
                                                                             Class<B> type,
                                                                             int outputSlot) {
        B entity = placeEntity(helper, relativePos, block, type);
        net.minecraftforge.items.ItemStackHandler internal;
        if (entity instanceof TailoringCaseEntity value) internal = value.getItemHandler();
        else if (entity instanceof ForgeBlockEntity value) internal = value.getItemHandler();
        else if (entity instanceof WoodworkingBenchEntity value) internal = value.getItemHandler();
        else if (entity instanceof BrickKilnEntity value) internal = value.getItemHandler();
        else throw new IllegalArgumentException("unsupported machine");
        internal.setStackInSlot(outputSlot, new ItemStack(Items.EMERALD));
        var chunk = helper.getLevel().getChunkAt(entity.getBlockPos());
        chunk.setUnsaved(false);
        var sideHandler = entity.getCapability(net.minecraftforge.common.capabilities.ForgeCapabilities.ITEM_HANDLER, Direction.UP).resolve();
        helper.assertTrue(sideHandler.isPresent(), "machine output capability was absent");
        ItemStack extracted = sideHandler.orElseThrow().extractItem(0, 1, false);
        helper.assertTrue(extracted.is(Items.EMERALD), "machine output was not extractable");
        helper.assertTrue(chunk.isUnsaved(), "output extraction did not mark the containing chunk dirty");
        helper.assertTrue(internal.getStackInSlot(outputSlot).isEmpty(), "extracted output remained in serialized handler state");
    }

    @FunctionalInterface
    private interface MenuFactory<B extends BlockEntity> {
        AbstractContainerMenu create(ServerPlayer player, B entity);
    }

    @FunctionalInterface
    private interface PositionGuard<B extends BlockEntity> {
        Optional<B> apply(ServerPlayer player, BlockPos expectedPos);
    }

    @FunctionalInterface
    private interface GuardAttempt {
        Optional<?> get();
    }
}
