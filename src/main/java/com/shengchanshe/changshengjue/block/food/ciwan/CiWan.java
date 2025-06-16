package com.shengchanshe.changshengjue.block.food.ciwan;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CiWan extends WanTypeBlock{
    protected static final VoxelShape PLATE_SHAPE = Block.box(3.5D, 0.0D, 3.5D, 12.5D, 5.0D, 12.5D);

    public CiWan(BlockBehaviour.Properties properties, boolean hasLeftovers, int fed, float fedpro) {
        super(properties, hasLeftovers, fed, fedpro);
    }

    protected InteractionResult addFed(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, int fed, float fedpro) {
        put(level, pos, player, hand, ChangShengJueItems.CAPSULE_JIAO_ZI.get() , ChangShengJueBlocks.CAPSULE_JIAO_ZI_WAN.get());
        put(level, pos, player, hand, ChangShengJueItems.QING_TUAN.get() , ChangShengJueBlocks.QING_TUAN_WAN.get());
        put(level, pos, player, hand, ChangShengJueItems.PORTULACA_OLERACEA_CAKE.get(), ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_WAN.get());
        put(level, pos, player, hand, ChangShengJueItems.MI_FAN.get(), ChangShengJueBlocks.MI_FAN_WAN.get());
        put(level, pos, player, hand, ChangShengJueItems.XIAO_MI_FAN.get(), ChangShengJueBlocks.XIAO_MI_FAN_WAN.get());
        put(level, pos, player, hand, ChangShengJueItems.SORGHUM_CAKE.get(), ChangShengJueBlocks.SORGHUM_CAKE_WAN.get());
        return InteractionResult.SUCCESS;
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return PLATE_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPES);
    }
}
