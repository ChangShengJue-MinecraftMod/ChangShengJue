package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlockEntity;
import com.shengchanshe.chang_sheng_jue.recipe.ForgeBlockRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraftforge.network.NetworkEvent;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * 制作时配方更新数据包
 * 用于在制作过程中更新客户端显示的配方
 */
public class ForgeUpdateRecipePacket {
    private final BlockPos pos;
    private final ResourceLocation recipeId; // 存储配方的唯一标识符

    /**
     * 创建新的配方更新包
     * @param pos 方块位置
     * @param recipe 配方对象
     */
    public ForgeUpdateRecipePacket(BlockPos pos, ForgeBlockRecipe recipe) {
        this.pos = pos;
        this.recipeId = recipe != null ? recipe.getId() : null;
    }

    /**
     * 创建新的配方更新包
     * @param pos 方块位置
     * @param recipeId 配方ID
     */
    public ForgeUpdateRecipePacket(BlockPos pos, ResourceLocation recipeId) {
        this.pos = pos;
        this.recipeId = recipeId;
    }

    /**
     * 从字节缓冲区读取数据包
     * @param buf 字节缓冲区
     */
    public ForgeUpdateRecipePacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
        boolean hasRecipe = buf.readBoolean();
        if (hasRecipe) {
            this.recipeId = buf.readResourceLocation();
        } else {
            this.recipeId = null;
        }
    }

    /**
     * 将数据包写入字节缓冲区
     * @param buf 字节缓冲区
     */
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeBoolean(recipeId != null);
        if (recipeId != null) {
            buf.writeResourceLocation(recipeId);
        }
    }

    /**
     * 从字节缓冲区创建数据包
     * @param buf 字节缓冲区
     * @return 新的配方更新包
     */
    public static ForgeUpdateRecipePacket fromBytes(FriendlyByteBuf buf) {
        BlockPos pos = buf.readBlockPos();
        ResourceLocation recipeId = null;
        if (buf.readBoolean()) {
            recipeId = buf.readResourceLocation();
        }
        return new ForgeUpdateRecipePacket(pos, recipeId);
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
        });
        context.setPacketHandled(true);
    }
}