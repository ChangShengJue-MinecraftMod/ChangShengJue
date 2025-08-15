package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlockEntity;
import com.shengchanshe.chang_sheng_jue.recipe.ForgeBlockRecipe;
import io.netty.handler.codec.DecoderException;
import net.minecraft.ResourceLocationException;
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
 * 配方同步数据包
 * 用于在客户端和服务端之间同步锻造台当前使用的配方
 */
public class ForgeSyncRecipePacket {
    private final BlockPos pos;
    private final ResourceLocation recipeId; // 存储配方的唯一标识符

    /**
     * 创建新的配方同步包
     * @param pos 方块位置
     * @param recipe 配方对象
     */
    public ForgeSyncRecipePacket(BlockPos pos, ForgeBlockRecipe recipe) {
        this.pos = pos;
        this.recipeId = recipe != null ? recipe.getId() : null;
    }

    /**
     * 创建新的配方同步包
     * @param pos 方块位置
     * @param recipeId 配方ID
     */
    public ForgeSyncRecipePacket(BlockPos pos, ResourceLocation recipeId) {
        this.pos = pos;
        this.recipeId = recipeId;
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos); // 写入方块位置
        if (recipeId != null) {
            buf.writeBoolean(true); // 标记存在 recipeId
            buf.writeUtf(recipeId.toString()); // 使用 UTF-8 编码写入字符串
        } else {
            buf.writeBoolean(false); // 标记无 recipeId
        }
    }

    public static ForgeSyncRecipePacket fromBytes(FriendlyByteBuf buf) {
        BlockPos pos = buf.readBlockPos();
        ResourceLocation recipeId = null;
        if (buf.readBoolean()) { // 检查是否有 recipeId
            String recipeIdStr = buf.readUtf(); // 使用 UTF-8 解码
            try {
                recipeId = new ResourceLocation(recipeIdStr); // 转换为 ResourceLocation
            } catch (ResourceLocationException e) {
                throw new DecoderException("Invalid ResourceLocation in packet: " + recipeIdStr, e);
            }
        }
        return new ForgeSyncRecipePacket(pos, recipeId);
    }

    /**
     * 处理网络包
     * 在服务端获取配方并设置到对应的方块实体中
     * @param ctx 网络事件上下文
     */
    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null && player.level().getBlockEntity(pos) instanceof ForgeBlockEntity blockEntity) {
                ForgeBlockRecipe recipe = null;
                if (recipeId != null) {
                    Optional<? extends Recipe<?>> optionalRecipe = player.level().getRecipeManager().byKey(recipeId);
                    if (optionalRecipe.isPresent() && optionalRecipe.get() instanceof ForgeBlockRecipe) {
                        recipe = (ForgeBlockRecipe) optionalRecipe.get();
                    }
                }

                blockEntity.setCurrentRecipe(recipe);
                blockEntity.setChanged();
            }
        });
        ctx.get().setPacketHandled(true);
    }
}