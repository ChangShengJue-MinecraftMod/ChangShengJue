package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlockEntity;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.forgeblock.ForgeBlockMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ForgeSyncRecipePacket {
    private final BlockPos pos;
    private final ForgeBlockMenu.ForgeRecipe recipe;

    public ForgeSyncRecipePacket(BlockPos pos, ForgeBlockMenu.ForgeRecipe recipe) {
        this.pos = pos;
        this.recipe = recipe;
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);

        // 将配方序列化为NBT
        if (recipe != null) {
            buf.writeBoolean(true);
            buf.writeNbt(recipe.serializeNBT());
        } else {
            buf.writeBoolean(false);
        }
    }

    public static ForgeSyncRecipePacket fromBytes(FriendlyByteBuf buf) {
        BlockPos pos = buf.readBlockPos();
        ForgeBlockMenu.ForgeRecipe recipe = null;

        if (buf.readBoolean()) {
            CompoundTag tag = buf.readNbt();
            if (tag != null) {
                recipe = ForgeBlockMenu.ForgeRecipe.deserializeNBT(tag);
            }
        }

        return new ForgeSyncRecipePacket(pos, recipe);
    }

    public static void handle(ForgeSyncRecipePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;

            Level level = player.level();
            BlockPos pos = packet.pos;
            BlockEntity entity = level.getBlockEntity(pos);

            if (entity instanceof ForgeBlockEntity forgeEntity) {
                forgeEntity.setCurrentRecipe(packet.recipe);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}