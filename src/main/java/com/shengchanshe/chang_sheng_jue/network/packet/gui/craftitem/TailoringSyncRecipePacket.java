package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase.TailoringCaseEntity;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.tailoringcase.TailoringCaseMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TailoringSyncRecipePacket {
    private final BlockPos pos;
    private final TailoringCaseMenu.TailoringRecipe recipe;

    public TailoringSyncRecipePacket(BlockPos pos, TailoringCaseMenu.TailoringRecipe recipe) {
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

    public static TailoringSyncRecipePacket fromBytes(FriendlyByteBuf buf) {
        BlockPos pos = buf.readBlockPos();
        TailoringCaseMenu.TailoringRecipe recipe = null;

        if (buf.readBoolean()) {
            CompoundTag tag = buf.readNbt();
            if (tag != null) {
                recipe = TailoringCaseMenu.TailoringRecipe.deserializeNBT(tag);
            }
        }

        return new TailoringSyncRecipePacket(pos, recipe);
    }

    public static void handle(TailoringSyncRecipePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;

            Level level = player.level();
            BlockPos pos = packet.pos;
            BlockEntity entity = level.getBlockEntity(pos);

            if (entity instanceof TailoringCaseEntity tailoringEntity) {
                if (tailoringEntity.getCurrentRecipe() != null){
                    tailoringEntity.setCurrentRecipe(null);
                }
                tailoringEntity.setCurrentRecipe(packet.recipe);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}