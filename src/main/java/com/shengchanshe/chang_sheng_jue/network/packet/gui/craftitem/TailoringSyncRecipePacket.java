package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.network.ServerPacketGuard;
import com.shengchanshe.chang_sheng_jue.recipe.TailoringCaseRecipe;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraftforge.network.NetworkEvent;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * 配方同步数据包
 * 用于在客户端和服务端之间同步裁衣案当前使用的配方
 */
public class TailoringSyncRecipePacket {
    private static final int MAX_RECIPE_ID_LENGTH = 256;
    private final BlockPos pos;
    private final ResourceLocation recipeId; // 存储配方的唯一标识符

    /**
     * 创建新的配方同步包
     * @param pos 方块位置
     * @param recipe 配方对象
     */
    public TailoringSyncRecipePacket(BlockPos pos, TailoringCaseRecipe recipe) {
        this.pos = pos;
        this.recipeId = recipe != null ? recipe.getId() : null;
    }

    /**
     * 创建新的配方同步包
     * @param pos 方块位置
     * @param recipeId 配方ID
     */
    public TailoringSyncRecipePacket(BlockPos pos, ResourceLocation recipeId) {
        this.pos = pos;
        this.recipeId = recipeId;
    }

    /**
     * 从字节缓冲区读取数据包
     * @param buf 字节缓冲区
     */
    public TailoringSyncRecipePacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
        this.recipeId = readResourceLocationFromBuffer(buf);
    }

    /**
     * 将数据包写入字节缓冲区
     * @param buf 字节缓冲区
     */
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        writeResourceLocationToBuffer(buf, recipeId);
    }

    /**
     * 从字节缓冲区创建数据包
     * @param buf 字节缓冲区
     * @return 新的配方同步包
     */
    public static TailoringSyncRecipePacket fromBytes(FriendlyByteBuf buf) {
        return new TailoringSyncRecipePacket(buf.readBlockPos(), readResourceLocationFromBuffer(buf));
    }

    /**
     * 处理网络包
     * 在服务端获取配方并设置到对应的方块实体中
     * @param supplier 网络事件上下文
     */
    public void handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            var player = context.getSender();
            ServerPacketGuard.tailoringCase(player, pos).ifPresent(blockEntity -> {
                if (recipeId == null) {
                    blockEntity.setCurrentRecipe(null);
                    blockEntity.setChanged();
                    return;
                }

                Optional<? extends Recipe<?>> optionalRecipe = player.level().getRecipeManager().byKey(recipeId);
                if (optionalRecipe.isEmpty() || !(optionalRecipe.get() instanceof TailoringCaseRecipe recipe)) {
                    return;
                }
                blockEntity.setCurrentRecipe(recipe);
                blockEntity.setChanged();
            });
        });
        context.setPacketHandled(true);
    }

    /**
     * 从缓冲区读取ResourceLocation
     * @param buf 字节缓冲区
     * @return 解析的ResourceLocation对象
     */
    private static ResourceLocation readResourceLocationFromBuffer(FriendlyByteBuf buf) {
        if (!buf.readBoolean()) {
            return null;
        }
        int length = buf.readInt();
        if (length < 0 || length > MAX_RECIPE_ID_LENGTH) {
            throw new DecoderException("Invalid tailoring recipe id length: " + length);
        }
        byte[] bytes = new byte[length];
        buf.readBytes(bytes);
        ResourceLocation location = ResourceLocation.tryParse(new String(bytes, StandardCharsets.UTF_8));
        if (location == null) {
            throw new DecoderException("Invalid recipe id in tailoring packet");
        }
        return location;
    }

    /**
     * 将ResourceLocation写入缓冲区
     * @param buf 字节缓冲区
     * @param location ResourceLocation对象
     */
    private static void writeResourceLocationToBuffer(FriendlyByteBuf buf, ResourceLocation location) {
        buf.writeBoolean(location != null);
        if (location != null) {
            byte[] bytes = location.toString().getBytes(StandardCharsets.UTF_8);
            if (bytes.length > MAX_RECIPE_ID_LENGTH) {
                throw new EncoderException("Tailoring recipe id exceeds " + MAX_RECIPE_ID_LENGTH + " bytes");
            }
            buf.writeInt(bytes.length);
            buf.writeBytes(bytes);
        }
    }
}
