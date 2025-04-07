package com.shengchanshe.changshengjue.block.food.nobox;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Durian extends NoBoxTypeBlock{
    public static int nutrition = 0;
    public static float saturationMod = 0.0F;
    protected static final VoxelShape DURIAN_NORTH = Block.box(4D, 0.0D, 4D, 12D, 13D, 12D);
    

    public Durian(Properties pProperties, int nutrition, float saturationMod) {
        super(pProperties, nutrition,saturationMod);
    }

    protected InteractionResult addFed(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, int fed, float fedpro) {
        ItemStack itemstack = player.getItemInHand(hand);
        if(state.getBlock()==ChangShengJueBlocks.DURIAN.get()){
            if(itemstack.getItem() instanceof AxeItem){
                itemstack.hurtAndBreak(1, player, (p) -> {p.broadcastBreakEvent(player.getUsedItemHand());});
                level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ChangShengJueItems.OPEN_DURIAN.get())));
                level.destroyBlock(pos, false);
                level.playSound(null, pos, SoundEvents.AXE_STRIP, SoundSource.PLAYERS, 0.8F, 0.8F);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return DURIAN_NORTH;
    }
}
