package com.shengchanshe.chang_sheng_jue.block.painting;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BigPaintingScroll extends HorizontalDirectionalBlock {
    public static final EnumProperty<Variant> VARIANT = EnumProperty.create("variant", Variant.class);
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    private VoxelShape AABB = Shapes.empty();

    public BigPaintingScroll(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(RIGHT, false));
    }
    public Direction rightOf(Direction facing) {
        switch (facing) {
            case NORTH:
                return Direction.WEST;
            case EAST:
                return Direction.NORTH;
            case SOUTH:
                return Direction.EAST;
            case WEST:
                return Direction.SOUTH;
            default:
                return facing; // 如果不是水平方向，就返回原方向
        }
    }
    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction facing = pState.getValue(FACING);
        Direction rightDirection = rightOf(facing);
        BlockPos pos2 = pPos.relative(rightDirection); // 获取右侧的位置
        if (!pLevel.getBlockState(pos2).isAir()) {
            return false; // 如果被阻挡，返回false，阻止方块放置
        }
        return true; // 如果没有阻挡，允许放置
    }
    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        if (!pLevel.isClientSide) {
            pLevel.setBlock(pPos.above(), pState.setValue(HALF, DoubleBlockHalf.UPPER), 3);
            Direction facing = pState.getValue(FACING);
            Direction rightDirection = rightOf(facing);
            BlockPos pos2 = pPos.relative(rightDirection); // 获取右侧的位置
            // 检查目标位置是否已经有合适的方块，避免递归放置
            if (pLevel.isEmptyBlock(pos2) && !pState.getValue(RIGHT)) { // 只有当目标位置为空时才放置新方块
                // 根据需要调整状态
                BlockState newState = this.defaultBlockState().setValue(VARIANT, pState.getValue(VARIANT)).setValue(RIGHT, true).setValue(FACING, facing);
                pLevel.setBlockAndUpdate(pos2, newState);
                pLevel.setBlock(pos2.above(), pState.setValue(HALF, DoubleBlockHalf.UPPER).setValue(RIGHT, true), 3);
            }
        }
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        super.neighborChanged(pState, pLevel, pPos, pNeighborBlock, pNeighborPos, pMovedByPiston);
        DoubleBlockHalf half = pState.getValue(HALF);
        BlockPos otherPartPos = half == DoubleBlockHalf.LOWER ? pPos.above() : pPos.below();
        BlockState otherPartState = pLevel.getBlockState(otherPartPos);
        Direction facing = pState.getValue(FACING);
        Direction rightDirection = rightOf(pState.getValue(RIGHT) ? facing.getOpposite() : facing);
        BlockPos pos2 = pPos.relative(rightDirection);
        BlockState stateAtPos2 = pLevel.getBlockState(pos2);
        if (otherPartState.getBlock() != this) {
            // 如果另一半不是相同的方块，则将当前部分也移除
            if (stateAtPos2.getBlock() == this) {
                pLevel.setBlock(pos2, Blocks.AIR.defaultBlockState(), 35);
                pLevel.levelEvent(2001, pPos, Block.getId(pState));
            }
            pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 35);
            pLevel.levelEvent(2001, pPos, Block.getId(pState));
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        RandomSource random = pContext.getLevel().random;
        Variant[] variants = Variant.values();
        Variant randomVariant = variants[random.nextInt(variants.length)];
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        if (blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(pContext)) {
            return this.defaultBlockState().setValue(VARIANT, randomVariant).setValue(FACING, pContext.getHorizontalDirection().getOpposite());
        } else {
            return null;
        }
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction value = pState.getValue(FACING);

        return switch (value){
            case SOUTH -> this.AABB = Block.box(0, 0, 0, 16, 16, 2);
            case WEST -> this.AABB = Block.box(14, 0, 0, 16, 16, 16);
            case EAST -> this.AABB = Block.box(0, 0, 0, 2, 16, 16);
            default -> this.AABB = Block.box(0, 0, 14, 16, 16, 16);
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING,VARIANT,HALF,RIGHT);
    }

    public enum Variant implements StringRepresentable {
        DEFAULT("default"),
        VARIANT_1("variant_1"),
        VARIANT_2("variant_2"),
        VARIANT_3("variant_3");

        private final String name;

        Variant(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return name;
        }
    }
}
