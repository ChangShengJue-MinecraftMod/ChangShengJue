package com.shengchanshe.chang_sheng_jue.gametest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.plaque.UpdatePlaqueTextPacket;
import com.shengchanshe.chang_sheng_jue.entity.villagers.worker.KilnWorkerTradeType;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.KilnWorkerSetTradeTypePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.BrickKilnPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.BrickKilnSetAmountPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.BrickKilnSyncRecipePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.ForgeCraftPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.ForgeSyncRecipePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.TailoringCraftPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.TailoringSyncRecipePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.WoodworkingBenchPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.WoodworkingBenchSetAmountPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.WoodworkingBenchSyncRecipePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest.RefreshPlayerQuestScreenPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.AcceptGangQuestsPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.OpenGangQuestScreenPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.SyncKungFuCapabilityPacket;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import java.util.Arrays;
import java.util.UUID;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class NetworkProtocolCompatibilityGameTests {
    private static final BlockPos TEST_POS = new BlockPos(1, 2, 3);
    private static final ResourceLocation TEST_RECIPE = new ResourceLocation(ChangShengJue.MOD_ID, "test");
    private static final UUID TEST_UUID = UUID.fromString("00112233-4455-6677-8899-aabbccddeeff");

    private static final byte[] BLOCK_POS_GOLDEN = hex("0000004000003002");
    private static final byte[] RECIPE_ID_UTF8 = hex("6368616e675f7368656e675f6a75653a74657374");
    private static final byte[] UUID_GOLDEN = hex("00112233445566778899aabbccddeeff");

    private NetworkProtocolCompatibilityGameTests() {
    }

    @GameTest(template = "empty")
    public static void plaqueCodecMatchesPublishedWire(GameTestHelper helper) {
        byte[] golden = concat(BLOCK_POS_GOLDEN, hex("06e7a291e69687"));
        assertCodec(
            helper,
            "plaque BlockPos+UTF-8",
            golden,
            new UpdatePlaqueTextPacket(TEST_POS, "碑文"),
            (packet, buffer) -> packet.toBytes(buffer),
            UpdatePlaqueTextPacket::new
        );
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void tailoringRecipeCodecMatchesPublishedRawUtf8Wire(GameTestHelper helper) {
        byte[] presentGolden = concat(
            BLOCK_POS_GOLDEN,
            hex("0100000014"),
            RECIPE_ID_UTF8
        );
        assertCodec(
            helper,
            "tailoring BlockPos+boolean+int32+raw UTF-8",
            presentGolden,
            new TailoringSyncRecipePacket(TEST_POS, TEST_RECIPE),
            (packet, buffer) -> packet.toBytes(buffer),
            TailoringSyncRecipePacket::fromBytes
        );
        assertCodec(
            helper,
            "tailoring null recipe",
            concat(BLOCK_POS_GOLDEN, hex("00")),
            new TailoringSyncRecipePacket(TEST_POS, (ResourceLocation) null),
            (packet, buffer) -> packet.toBytes(buffer),
            TailoringSyncRecipePacket::fromBytes
        );
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void kilnAndGangCodecsMatchPublishedOrdinalsAndUuids(GameTestHelper helper) {
        assertCodec(
            helper,
            "kiln trade enum ordinal",
            hex("04"),
            new KilnWorkerSetTradeTypePacket(KilnWorkerTradeType.GOLDEN),
            KilnWorkerSetTradeTypePacket::encode,
            KilnWorkerSetTradeTypePacket::decode
        );
        assertCodec(
            helper,
            "open gang screen UUID",
            UUID_GOLDEN,
            new OpenGangQuestScreenPacket(TEST_UUID),
            OpenGangQuestScreenPacket::encode,
            OpenGangQuestScreenPacket::decode
        );
        assertCodec(
            helper,
            "accept gang quest UUID",
            UUID_GOLDEN,
            new AcceptGangQuestsPacket(TEST_UUID),
            AcceptGangQuestsPacket::encode,
            AcceptGangQuestsPacket::decode
        );
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void fourCraftCodecsKeepBlockPosWire(GameTestHelper helper) {
        assertCodec(helper, "tailoring craft", BLOCK_POS_GOLDEN,
            new TailoringCraftPacket(TEST_POS),
            (packet, buffer) -> packet.toBytes(buffer), TailoringCraftPacket::fromBytes);
        assertCodec(helper, "forge craft", BLOCK_POS_GOLDEN,
            new ForgeCraftPacket(TEST_POS),
            (packet, buffer) -> packet.toBytes(buffer), ForgeCraftPacket::fromBytes);
        assertCodec(helper, "woodworking craft", BLOCK_POS_GOLDEN,
            new WoodworkingBenchPacket(TEST_POS),
            (packet, buffer) -> packet.toBytes(buffer), WoodworkingBenchPacket::fromBytes);
        assertCodec(helper, "brick kiln craft", BLOCK_POS_GOLDEN,
            new BrickKilnPacket(TEST_POS),
            (packet, buffer) -> packet.toBytes(buffer), BrickKilnPacket::fromBytes);
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void recipeCodecsKeepBooleanAndUtfWire(GameTestHelper helper) {
        byte[] presentGolden = concat(BLOCK_POS_GOLDEN, hex("0114"), RECIPE_ID_UTF8);
        byte[] absentGolden = concat(BLOCK_POS_GOLDEN, hex("00"));

        assertCodec(helper, "forge recipe present", presentGolden,
            new ForgeSyncRecipePacket(TEST_POS, TEST_RECIPE),
            (packet, buffer) -> packet.toBytes(buffer), ForgeSyncRecipePacket::fromBytes);
        assertCodec(helper, "forge recipe absent", absentGolden,
            new ForgeSyncRecipePacket(TEST_POS, (ResourceLocation) null),
            (packet, buffer) -> packet.toBytes(buffer), ForgeSyncRecipePacket::fromBytes);

        assertCodec(helper, "woodworking recipe present", presentGolden,
            new WoodworkingBenchSyncRecipePacket(TEST_POS, TEST_RECIPE),
            (packet, buffer) -> packet.toBytes(buffer), WoodworkingBenchSyncRecipePacket::fromBytes);
        assertCodec(helper, "woodworking recipe absent", absentGolden,
            new WoodworkingBenchSyncRecipePacket(TEST_POS, (ResourceLocation) null),
            (packet, buffer) -> packet.toBytes(buffer), WoodworkingBenchSyncRecipePacket::fromBytes);

        assertCodec(helper, "brick kiln recipe present", presentGolden,
            new BrickKilnSyncRecipePacket(TEST_POS, TEST_RECIPE),
            (packet, buffer) -> packet.toBytes(buffer), BrickKilnSyncRecipePacket::fromBytes);
        assertCodec(helper, "brick kiln recipe absent", absentGolden,
            new BrickKilnSyncRecipePacket(TEST_POS, (ResourceLocation) null),
            (packet, buffer) -> packet.toBytes(buffer), BrickKilnSyncRecipePacket::fromBytes);
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void amountCodecsKeepBlockPosAndInt32Wire(GameTestHelper helper) {
        byte[] golden = concat(BLOCK_POS_GOLDEN, hex("00000025"));
        assertCodec(helper, "woodworking amount", golden,
            new WoodworkingBenchSetAmountPacket(TEST_POS, 37),
            (packet, buffer) -> packet.toBytes(buffer), WoodworkingBenchSetAmountPacket::new);
        assertCodec(helper, "brick kiln amount", golden,
            new BrickKilnSetAmountPacket(TEST_POS, 37),
            (packet, buffer) -> packet.toBytes(buffer), BrickKilnSetAmountPacket::new);
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void keyS2cCodecsKeepNbtAndEmptyPayloadWire(GameTestHelper helper) {
        assertCodec(helper, "kung fu empty compound NBT", hex("0a000000"),
            new SyncKungFuCapabilityPacket(new CompoundTag()),
            (packet, buffer) -> packet.encode(buffer), SyncKungFuCapabilityPacket::new);
        assertCodec(helper, "refresh player quest empty payload", new byte[0],
            new RefreshPlayerQuestScreenPacket(),
            RefreshPlayerQuestScreenPacket::encode, RefreshPlayerQuestScreenPacket::decode);
        helper.succeed();
    }

    private static <T> void assertCodec(
        GameTestHelper helper,
        String name,
        byte[] golden,
        T source,
        PacketEncoder<T> encoder,
        PacketDecoder<T> decoder
    ) {
        helper.assertTrue(Arrays.equals(golden, encode(source, encoder)), name + " encoder changed published bytes");

        FriendlyByteBuf input = new FriendlyByteBuf(Unpooled.wrappedBuffer(golden));
        T decoded;
        try {
            decoded = decoder.decode(input);
            helper.assertTrue(input.readableBytes() == 0, name + " decoder left unread bytes");
        } finally {
            input.release();
        }
        helper.assertTrue(Arrays.equals(golden, encode(decoded, encoder)), name + " decode/encode round trip changed bytes");
    }

    private static <T> byte[] encode(T packet, PacketEncoder<T> encoder) {
        FriendlyByteBuf output = new FriendlyByteBuf(Unpooled.buffer());
        try {
            encoder.encode(packet, output);
            byte[] bytes = new byte[output.readableBytes()];
            output.getBytes(output.readerIndex(), bytes);
            return bytes;
        } finally {
            output.release();
        }
    }

    private static byte[] concat(byte[]... parts) {
        int length = 0;
        for (byte[] part : parts) {
            length += part.length;
        }
        byte[] result = new byte[length];
        int offset = 0;
        for (byte[] part : parts) {
            System.arraycopy(part, 0, result, offset, part.length);
            offset += part.length;
        }
        return result;
    }

    private static byte[] hex(String value) {
        if ((value.length() & 1) != 0) {
            throw new IllegalArgumentException("hex fixture must contain complete bytes");
        }
        byte[] result = new byte[value.length() / 2];
        for (int i = 0; i < value.length(); i += 2) {
            result[i / 2] = (byte) Integer.parseInt(value.substring(i, i + 2), 16);
        }
        return result;
    }

    @FunctionalInterface
    private interface PacketEncoder<T> {
        void encode(T packet, FriendlyByteBuf buffer);
    }

    @FunctionalInterface
    private interface PacketDecoder<T> {
        T decode(FriendlyByteBuf buffer);
    }
}
