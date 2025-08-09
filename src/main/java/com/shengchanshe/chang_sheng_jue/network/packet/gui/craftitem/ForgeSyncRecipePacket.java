package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlockEntity;
import com.shengchanshe.chang_sheng_jue.recipe.ForgeBlockRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * 配方同步数据包
 * 用于在客户端和服务端之间同步锻造台当前使用的配方
 */
public class ForgeSyncRecipePacket {
    private final BlockPos pos;
    private final ResourceLocation recipeId;

    /**
     * 创建新的配方同步包
     * @param pos 方块位置
     * @param recipe 配方对象
     */
    public ForgeSyncRecipePacket(BlockPos pos, ForgeBlockRecipe recipe) {
        this.pos = pos;
        this.recipeId = recipe != null ? recipe.getId() : null;
        System.out.println("创建同步包，配方ID: " + (recipeId != null ? recipeId : "无"));
    }

    /**
     * 通过ResourceLocation创建同步包
     * @param pos 方块位置
     * @param recipeId 配方ID
     */
    public ForgeSyncRecipePacket(BlockPos pos, ResourceLocation recipeId) {
        this.pos = pos;
        this.recipeId = recipeId;
        System.out.println("通过ResourceLocation创建同步包，配方ID: " + (recipeId != null ? recipeId : "无"));
    }

    /**
     * 从字节缓冲区读取数据包
     * @param buf 字节缓冲区
     */
    public ForgeSyncRecipePacket(FriendlyByteBuf buf) {
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
    public static ForgeSyncRecipePacket fromBytes(FriendlyByteBuf buf) {
        try {
            BlockPos pos = buf.readBlockPos();
            ResourceLocation recipeId = readResourceLocationFromBuffer(buf);
            return new ForgeSyncRecipePacket(pos, recipeId);
        } catch (Exception e) {
            System.out.println("Error decoding recipe packet");
            e.printStackTrace();
            // 安全跳过异常数据
            try {
                buf.skipBytes(buf.readableBytes());
            } catch (Exception inner) {
                // 忽略内部异常
            }
            return new ForgeSyncRecipePacket(buf.readBlockPos(), (ResourceLocation)null);
        }
    }

    /**
     * 处理网络包
     * 在服务端获取配方并设置到对应的方块实体中
     * @param packet 数据包实例
     * @param supplier 网络事件上下文
     */
    public static void handle(ForgeSyncRecipePacket packet, Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player == null) return;

            Level level = player.level();
            BlockPos pos = packet.pos;
            BlockEntity entity = level.getBlockEntity(pos);

            if (entity instanceof ForgeBlockEntity forgeEntity) {
                ForgeBlockRecipe recipe = null;
                if (packet.recipeId != null) {
                    Optional<? extends net.minecraft.world.item.crafting.Recipe<?>> optionalRecipe = level.getRecipeManager().byKey(packet.recipeId);
                    if (optionalRecipe.isPresent() && optionalRecipe.get() instanceof ForgeBlockRecipe) {
                        recipe = (ForgeBlockRecipe) optionalRecipe.get();
                    }
                }

                // 先清空旧配方再设置新配方（确保状态一致）
                forgeEntity.setCurrentRecipe(null);
                forgeEntity.setCurrentRecipe(recipe);
                forgeEntity.setChanged();  // 同步到客户端
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