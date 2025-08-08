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

import java.util.Optional;
import java.util.function.Supplier;

public class ForgeSyncRecipePacket {
    private final BlockPos pos;
    private final ResourceLocation recipeId; // 同步配方ID而非整个配方

    public ForgeSyncRecipePacket(BlockPos pos, ForgeBlockRecipe recipe) {
        this.pos = pos;
        // 传输配方时只传输配方ID而不是整个配方对象
        this.recipeId = recipe != null ? recipe.getId() : null;
        System.out.println("创建配方同步包，配方ID: " + this.recipeId);
    }

    public ForgeSyncRecipePacket(BlockPos pos, ResourceLocation recipeId) {
        this.pos = pos;
        this.recipeId = recipeId;
        System.out.println("创建配方同步包，配方ID: " + this.recipeId);
    }

    public ForgeSyncRecipePacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
        // 读取配方ID，如果有
        boolean hasRecipe = buf.readBoolean();
        if (hasRecipe) {
            this.recipeId = buf.readResourceLocation();
        } else {
            this.recipeId = null;
        }
        System.out.println("从字节缓冲区读取配方同步包，配方ID: " + this.recipeId);
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        // 写入配方ID，如果有
        buf.writeBoolean(recipeId != null);
        if (recipeId != null) {
            buf.writeResourceLocation(recipeId);
        }
        System.out.println("将配方同步包写入字节缓冲区，配方ID: " + recipeId);
    }

    public static ForgeSyncRecipePacket fromBytes(FriendlyByteBuf buf) {
        BlockPos pos = buf.readBlockPos();
        ResourceLocation recipeId = null;
        if (buf.readBoolean()) {
            recipeId = buf.readResourceLocation();
        }
        return new ForgeSyncRecipePacket(pos, recipeId); // 修复：传递recipeId而不是null
    }

    public void handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // 确保在服务端执行
            ServerPlayer player = context.getSender();
            if (player != null && player.level().getBlockEntity(pos) instanceof ForgeBlockEntity blockEntity) {

                // 从配方ID获取实际配方对象
                ForgeBlockRecipe recipe = null;
                if (recipeId != null) {
                    Optional<? extends Recipe<?>> optionalRecipe = player.level().getRecipeManager().byKey(recipeId);
                    if (optionalRecipe.isPresent() && optionalRecipe.get() instanceof ForgeBlockRecipe) {
                        recipe = (ForgeBlockRecipe) optionalRecipe.get();
                    }
                }

                // 设置配方到方块实体
                blockEntity.setCurrentRecipe(recipe);
                
                // 同步到客户端
                blockEntity.setChanged();
            }
        });
        context.setPacketHandled(true);
    }
}