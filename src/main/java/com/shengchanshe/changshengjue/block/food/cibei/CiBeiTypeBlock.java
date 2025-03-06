package com.shengchanshe.changshengjue.block.food.cibei;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.block.food.TypeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("deprecation")
public class CiBeiTypeBlock extends TypeBlock {


    public CiBeiTypeBlock(Properties properties, boolean hasLeftovers, int nutrition, float saturationMod) {
        super(properties, hasLeftovers, nutrition, saturationMod);
    }

    protected InteractionResult addFed(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, int fed, float fedpro) {
        int types = state.getValue(getTYPE());

        if (types > 0) {
            //如果玩家饥饿值满且物品等级不为0
            if (player.getFoodData().getFoodLevel() < 20 || player.isCreative()) {
                level.setBlock(pos, state.setValue(getTYPE(), 0), 3);
                // 增加饥饿值
                player.getFoodData().eat(fed, fedpro);
                level.setBlock(pos, ChangShengJueBlocks.CI_BEI.get().defaultBlockState(), 3);
                level.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
            }
        } else if (types == 0) {
            level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.destroyBlock(pos, true);
            level.setBlock(pos, ChangShengJueBlocks.CI_BEI.get().defaultBlockState(), 3);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

}
