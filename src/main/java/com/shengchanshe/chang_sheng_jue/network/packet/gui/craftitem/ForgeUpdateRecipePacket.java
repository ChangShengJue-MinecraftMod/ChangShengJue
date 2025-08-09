package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlockEntity;
import com.shengchanshe.chang_sheng_jue.recipe.ForgeBlockRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraftforge.network.NetworkEvent;

import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * 制作时配方更新数据包
 * 用于在制作过程中更新客户端显示的配方
 */
public class ForgeUpdateRecipePacket {
    private final BlockPos pos;
    private final ResourceLocation recipeId; // 存储配方的唯一标识符

    // 添加静态日志记录器
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * 创建新的配方更新包
     * @param pos 方块位置
     * @param recipe 配方对象
     */
    public ForgeUpdateRecipePacket(BlockPos pos, ForgeBlockRecipe recipe) {
        this.pos = pos;
        this.recipeId = recipe != null ? recipe.getId() : null;
        validateRecipeId();
        LOGGER.info("创建配方更新包，配方ID: {}", recipeId != null ? recipeId : "无");
    }

    /**
     * 验证配方ID的有效性（保留原始方法，但移除正则验证）
     */
    private void validateRecipeId() {
        if (recipeId != null && !ResourceLocation.isValidResourceLocation(recipeId.toString())) {
            throw new IllegalArgumentException("Invalid recipe ID: " + recipeId);
        }
    }

    /**
     * 创建新的配方更新包
     * @param pos 方块位置
     * @param recipeId 配方ID
     */
    public ForgeUpdateRecipePacket(BlockPos pos, ResourceLocation recipeId) {
        this.pos = pos;
        this.recipeId = recipeId;
        validateRecipeId();
        LOGGER.info("通过ResourceLocation创建配方更新包，配方ID: {}", recipeId != null ? recipeId : "无");
    }

    /**
     * 从字节缓冲区读取数据包
     * @param buf 字节缓冲区
     */
    public ForgeUpdateRecipePacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
        this.recipeId = buf.readBoolean() ? ResourceLocation.tryParse(buf.readUtf(32767)) : null;
        
        if (recipeId != null && (!ResourceLocation.isValidResourceLocation(recipeId.toString()) || 
               !recipeId.getNamespace().matches("[a-z0-9_]+") || 
               !recipeId.getPath().matches("[a-z0-9/._-]+"))) {
            throw new IllegalArgumentException("Invalid recipe ID in packet: " + recipeId);
        }
        
        LOGGER.info("从字节缓冲区读取配方更新包，配方ID: {}", recipeId != null ? recipeId : "无");
    }

    /**
     * 将数据包写入字节缓冲区
     * @param buf 字节缓冲区
     */
    public void toBytes(FriendlyByteBuf buf) {
        try {
            buf.writeBlockPos(pos);
            if (recipeId != null) {
                String idString = recipeId.toString();
                // 使用UTF-8字节编码代替writeUtf
                byte[] bytes = idString.getBytes(StandardCharsets.UTF_8);
                // 先写入长度保证读取安全
                buf.writeInt(bytes.length);
                buf.writeBytes(bytes);
            } else {
                buf.writeInt(-1); // 写入特殊标记表示null
            }
            LOGGER.info("将配方更新包写入字节缓冲区，配方ID: {}", recipeId != null ? recipeId.toString() : "无");
        } catch (Exception e) {
            System.err.println("Error encoding recipe update ID: " + (recipeId != null ? recipeId.toString() : "null"));
            e.printStackTrace();
        }
    }

    /**
     * 从字节缓冲区创建数据包
     * @param buf 字节缓冲区
     * @return 新的配方更新包
     */
    public static ForgeUpdateRecipePacket fromBytes(FriendlyByteBuf buf) {
        try {
            BlockPos pos = buf.readBlockPos();
            ResourceLocation recipeId = null;
            
            int length = buf.readInt();
            if (length >= 0) {
                // 根据长度读取字节
                byte[] bytes = new byte[length];
                buf.readBytes(bytes);
                String id = new String(bytes, StandardCharsets.UTF_8);
                recipeId = ResourceLocation.tryParse(id);
            }

            return new ForgeUpdateRecipePacket(pos, recipeId);
        } catch (Exception e) {
            System.err.println("Error decoding recipe update packet");
            e.printStackTrace();
            
            // 安全跳过异常数据
            try {
                // 直接跳过所有可读字节
                buf.skipBytes(buf.readableBytes());
            } catch (Exception inner) {
                // 忽略内部异常
            }
            
            return new ForgeUpdateRecipePacket(buf.readBlockPos(), (ResourceLocation)null);
        }
    }

    /**
     * 处理网络包
     * 在客户端更新当前显示的配方
     * @param supplier 网络事件上下文
     */
    public void handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // 这个包只在客户端处理，用于更新显示
            if (recipeId != null) {
                LOGGER.info("客户端处理配方更新包，配方ID: {}", recipeId.toString());
            } else {
                LOGGER.warn("客户端处理配方更新包，收到空配方ID");
            }
        });
        context.setPacketHandled(true);
    }
}