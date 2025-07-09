package com.shengchanshe.chang_sheng_jue.block.food.nobox;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
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
    public static int fed = 0;
    public static float fedpro = 0.0F;
    protected static final VoxelShape DURIAN_NORTH = Block.box(4D, 0.0D, 4D, 12D, 13D, 12D);
    

    public Durian(Properties pProperties, int fed, float fedpro) {
        super(pProperties, fed,fedpro);
        this.fed = fed;
        this.fedpro = fedpro;
    }


    protected InteractionResult addFed(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, int fed, float fedpro) {
        ItemStack itemstack = player.getItemInHand(hand);
        if(state.getBlock()==ChangShengJueBlocks.DURIAN.get()){
            if(itemstack.getItem() instanceof AxeItem){
                itemstack.hurtAndBreak(1, player, (p) -> {p.broadcastBreakEvent(player.getUsedItemHand());});

                // 使用level.random生成随机数
                int dropCount = level.getRandom().nextInt(5) + 3; // 生成3~7的随机数
                level.addFreshEntity(new ItemEntity(
                        level,
                        pos.getX(),
                        pos.getY(),
                        pos.getZ(),
                        new ItemStack(ChangShengJueItems.DURIAN_MEAT.get(), dropCount) // 添加随机数量参数
                ));

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
