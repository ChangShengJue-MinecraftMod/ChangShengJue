package com.shengchanshe.chang_sheng_jue.block.painting;

import com.shengchanshe.chang_sheng_jue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class HighPaintingScroll extends HorizontalDirectionalBlock {
    public static final EnumProperty<Variant> VARIANT = EnumProperty.create("variant", Variant.class);
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    private VoxelShape AABB = Shapes.empty();

    public HighPaintingScroll(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
    }


    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        if (!pLevel.isClientSide) {
            pLevel.setBlock(pPos.above(), pState.setValue(HALF, DoubleBlockHalf.UPPER), 3);
        }
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        super.neighborChanged(pState, pLevel, pPos, pNeighborBlock, pNeighborPos, pMovedByPiston);
        DoubleBlockHalf half = pState.getValue(HALF);
        BlockPos otherPartPos = half == DoubleBlockHalf.LOWER ? pPos.above() : pPos.below();
        BlockState otherPartState = pLevel.getBlockState(otherPartPos);

        if (otherPartState.getBlock() != this) {
            // 如果另一半不是相同的方块，则将当前部分也移除
            pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 35);
            pLevel.levelEvent(2001, pPos, Block.getId(pState));
        }
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction value = pState.getValue(FACING);
        boolean flag1 = pState.getValue(HALF) == DoubleBlockHalf.UPPER;

        return switch (value){
            case SOUTH ->  flag1 ?this.AABB = ChangShengJueVoxelShape.HIGH_PAINTING_SCROLL_SOUTH_UPPER : ChangShengJueVoxelShape.HIGH_PAINTING_SCROLL_SOUTH_LOWER;
            case WEST ->  flag1 ?this.AABB = ChangShengJueVoxelShape.HIGH_PAINTING_SCROLL_WEST_UPPER : ChangShengJueVoxelShape.HIGH_PAINTING_SCROLL_WEST_LOWER;
            case EAST ->  flag1 ?this.AABB = ChangShengJueVoxelShape.HIGH_PAINTING_SCROLL_EAST_UPPER : ChangShengJueVoxelShape.HIGH_PAINTING_SCROLL_EAST_LOWER;
            default -> flag1 ? this.AABB = ChangShengJueVoxelShape.HIGH_PAINTING_SCROLL_NORTH_UPPER : ChangShengJueVoxelShape.HIGH_PAINTING_SCROLL_NORTH_LOWER;
        };
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING,VARIANT,HALF);
    }

    public enum Variant implements StringRepresentable {
        DEFAULT("default"),
        VARIANT_1("variant_1"),
        VARIANT_2("variant_2"),
        VARIANT_3("variant_3"),
        VARIANT_4("variant_4"),
        VARIANT_5("variant_5"),
        VARIANT_6("variant_6"),
        VARIANT_7("variant_7"),
        VARIANT_8("variant_8"),
        VARIANT_9("variant_9"),
        VARIANT_10("variant_10"),
        VARIANT_11("variant_11"),
        VARIANT_12("variant_12");


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
