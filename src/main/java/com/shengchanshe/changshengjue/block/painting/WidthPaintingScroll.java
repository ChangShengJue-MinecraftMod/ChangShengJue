package com.shengchanshe.changshengjue.block.painting;

import com.shengchanshe.changshengjue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class WidthPaintingScroll extends HorizontalDirectionalBlock {
    public static final EnumProperty<Variant> VARIANT = EnumProperty.create("variant", Variant.class);
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    private VoxelShape AABB = Shapes.empty();
    public WidthPaintingScroll(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(RIGHT, false).setValue(FACING, Direction.NORTH));
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
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!world.isClientSide) {
            Direction facing = state.getValue(FACING);
            Direction rightDirection = rightOf(facing);
            BlockPos pos2 = pos.relative(rightDirection); // 获取右侧的位置
            // 检查目标位置是否已经有合适的方块，避免递归放置
            if (world.isEmptyBlock(pos2) && !state.getValue(RIGHT)) { // 只有当目标位置为空时才放置新方块
                // 根据需要调整状态
                BlockState newState = this.defaultBlockState().setValue(VARIANT, state.getValue(VARIANT)).setValue(RIGHT, true).setValue(FACING, facing);
                world.setBlockAndUpdate(pos2, newState);
            }
        }
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            Direction facing = state.getValue(FACING);
            Direction rightDirection = rightOf(state.getValue(RIGHT) ? facing.getOpposite() : facing);
            BlockPos pos2 = pos.relative(rightDirection);
            BlockState stateAtPos2 = world.getBlockState(pos2);
            if (stateAtPos2.getBlock() == this) {
                // 安全移除方块，确保更新
                world.setBlock(pos2, Blocks.AIR.defaultBlockState(), 3); // 3 表示立即更新并重新计算光照
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction value = pState.getValue(FACING);
        boolean flag1 = pState.getValue(RIGHT);

        return switch (value){
            case SOUTH ->  flag1 ?this.AABB = ChangShengJueVoxelShape.WIDTH_PAINTING_SCROLL_EAST_RIGHT : ChangShengJueVoxelShape.WIDTH_PAINTING_SCROLL_SOUTH_LEFT;
            case WEST ->  flag1 ?this.AABB = ChangShengJueVoxelShape.WIDTH_PAINTING_SCROLL_NORTH_RIGHT : ChangShengJueVoxelShape.WIDTH_PAINTING_SCROLL_WEST_LEFT;
            case EAST ->  flag1 ?this.AABB = ChangShengJueVoxelShape.WIDTH_PAINTING_SCROLL_WEST_RIGHT : ChangShengJueVoxelShape.WIDTH_PAINTING_SCROLL_EAST_LEFT;
            default -> flag1 ? this.AABB = ChangShengJueVoxelShape.WIDTH_PAINTING_SCROLL_SOUTH_RIGHT : ChangShengJueVoxelShape.WIDTH_PAINTING_SCROLL_NORTH_LEFT;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        RandomSource random = pContext.getLevel().random;
        Variant[] variants = Variant.values();
        Variant randomVariant = variants[random.nextInt(variants.length)];
        return this.defaultBlockState().setValue(VARIANT, randomVariant).setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING,VARIANT,RIGHT);
    }

    public enum Variant implements StringRepresentable {
        DEFAULT("default"),
        VARIANT_1("variant_1"),
        VARIANT_2("variant_2"),
        VARIANT_3("variant_3"),
        VARIANT_4("variant_4"),
        VARIANT_5("variant_5");

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
