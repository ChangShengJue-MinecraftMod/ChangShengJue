package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase.TailoringCaseEntity;
import com.shengchanshe.chang_sheng_jue.recipe.TailoringCaseRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
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
        System.out.println("创建同步包，配方ID: " + (recipeId != null ? recipeId : "无"));
    }

    /**
     * 创建新的配方同步包
     * @param pos 方块位置
     * @param recipeId 配方ID
     */
    public TailoringSyncRecipePacket(BlockPos pos, ResourceLocation recipeId) {
        this.pos = pos;
        this.recipeId = recipeId;
        System.out.println("通过ResourceLocation创建同步包，配方ID: " + (recipeId != null ? recipeId : "无"));
    }

    /**
     * 从字节缓冲区读取数据包
     * @param buf 字节缓冲区
     */
    public TailoringSyncRecipePacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
        this.recipeId = readResourceLocationFromBuffer(buf);
        System.out.println("解码同步包，配方ID: " + (recipeId != null ? recipeId : "无"));
    }

    /**
     * 将数据包写入字节缓冲区
     * @param buf 字节缓冲区
     */
    public void toBytes(FriendlyByteBuf buf) {
        try {
            buf.writeBlockPos(pos);
            writeResourceLocationToBuffer(buf, recipeId);
            System.out.println("编码同步包，配方ID: " + (recipeId != null ? recipeId : "无"));
        } catch (Exception e) {
            System.out.println("Error encoding recipe ID: " + (recipeId != null ? recipeId : "null"));
            e.printStackTrace();
        }
    }

    /**
     * 从字节缓冲区创建数据包
     * @param buf 字节缓冲区
     * @return 新的配方同步包
     */
    public static TailoringSyncRecipePacket fromBytes(FriendlyByteBuf buf) {
        try {
            BlockPos pos = buf.readBlockPos();
            ResourceLocation recipeId = readResourceLocationFromBuffer(buf);
            return new TailoringSyncRecipePacket(pos, recipeId);
        } catch (Exception e) {
            System.out.println("Error decoding recipe packet");
            e.printStackTrace();
            // 安全跳过异常数据
            try {
                buf.skipBytes(buf.readableBytes());
            } catch (Exception inner) {
                // 忽略内部异常
            }
            return new TailoringSyncRecipePacket(buf.readBlockPos(), (ResourceLocation)null);
        }
    }

    /**
     * 处理网络包
     * 在服务端获取配方并设置到对应的方块实体中
     * @param supplier 网络事件上下文
     */
    public void handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null && player.level().getBlockEntity(pos) instanceof TailoringCaseEntity blockEntity) {
                TailoringCaseRecipe recipe = null;
                if (recipeId != null) {
                    Optional<? extends Recipe<?>> optionalRecipe = player.level().getRecipeManager().byKey(recipeId);
                    if (optionalRecipe.isPresent() && optionalRecipe.get() instanceof TailoringCaseRecipe) {
                        recipe = (TailoringCaseRecipe) optionalRecipe.get();
                    } else {
                        recipe = null;
                    }
                }

                blockEntity.setCurrentRecipe(recipe);
                blockEntity.setChanged();
            }
        });
        context.setPacketHandled(true);
    }

    /**
     * 从缓冲区读取ResourceLocation
     * @param buf 字节缓冲区
     * @return 解析的ResourceLocation对象
     */
    private static ResourceLocation readResourceLocationFromBuffer(FriendlyByteBuf buf) {
        if (buf.readBoolean()) {
            int length = buf.readInt();
            if (length >= 0) {
                byte[] bytes = new byte[length];
                buf.readBytes(bytes);
                return ResourceLocation.tryParse(new String(bytes, StandardCharsets.UTF_8));
            }
        }
        return null;
    }

    /**
     * 将ResourceLocation写入缓冲区
     * @param buf 字节缓冲区
     * @param location ResourceLocation对象
     */
    private static void writeResourceLocationToBuffer(FriendlyByteBuf buf, ResourceLocation location) {
        buf.writeBoolean(location != null);
        if (location != null) {
            String idString = location.toString();
            byte[] bytes = idString.getBytes(StandardCharsets.UTF_8);
            buf.writeInt(bytes.length);
            buf.writeBytes(bytes);
        }
    }
}