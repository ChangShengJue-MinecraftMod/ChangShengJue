package com.shengchanshe.changshengjue.item.items;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.util.CSJTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class PaintBrush extends Item {
    public PaintBrush() {
        super(new Properties().stacksTo(1));
    }
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);

        Player player = pContext.getPlayer();
        if (player.getMainHandItem().is(this)){
            if (blockstate.getBlock().defaultBlockState().is(CSJTags.Blocks.BRICKS)){
                if (player.getOffhandItem().is(ChangShengJueItems.LIME_SLURRY_BARRELS.get())){
                    level.setBlock(blockpos, ChangShengJueBlocks.WHITE_WALLS_BLOCK.get().defaultBlockState(),3);
                    player.getOffhandItem().hurtAndBreak(6,player ,(player1) -> {
                        player1.setItemInHand(InteractionHand.OFF_HAND,Items.BUCKET.getDefaultInstance());
                    });
                }else if(player.getOffhandItem().is(ChangShengJueItems.WARM_LIME_SLURRY_BARRELS.get())) {
                    level.setBlock(blockpos, ChangShengJueBlocks.WARM_WHITE_WALLS_BLOCK.get().defaultBlockState(),3);
                    player.getOffhandItem().hurtAndBreak(6,player ,(player1) -> {
                        player1.setItemInHand(InteractionHand.OFF_HAND,Items.BUCKET.getDefaultInstance());
                    });
                }else if (player.getOffhandItem().is(ChangShengJueItems.COOL_LIME_SLURRY_BARRELS.get())){
                    level.setBlock(blockpos, ChangShengJueBlocks.COOL_WHITE_WALLS_BLOCK.get().defaultBlockState(),3);
                    player.getOffhandItem().hurtAndBreak(6,player ,(player1) -> {
                        player1.setItemInHand(InteractionHand.OFF_HAND,Items.BUCKET.getDefaultInstance());
                    });
                }
                return InteractionResult.SUCCESS;
            }
        }
        return super.useOn(pContext);
    }
}
