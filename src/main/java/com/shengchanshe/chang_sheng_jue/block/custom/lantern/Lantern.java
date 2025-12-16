package com.shengchanshe.chang_sheng_jue.block.custom.lantern;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class Lantern extends LanternBlock {
    protected static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 12, 12);
    protected static final VoxelShape SHAPE_LAY = Block.box(4, 0, 4, 12, 10, 12);
    public static final BooleanProperty LAY = BooleanProperty.create("lay");

    public Lantern(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LAY, false).setValue(HANGING, false).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LAY, HANGING, WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos below = pContext.getClickedPos().below();
        LevelAccessor level = pContext.getLevel();
        BlockState blockState = level.getBlockState(below);
        if (blockState.getBlock() instanceof LightStand) {
            return this.defaultBlockState().setValue(LAY, true);
        } else {
            return super.getStateForPlacement(pContext);
        }
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pState.getValue(LAY)) {
            return SHAPE_LAY;
        }
        return SHAPE;
    }
}