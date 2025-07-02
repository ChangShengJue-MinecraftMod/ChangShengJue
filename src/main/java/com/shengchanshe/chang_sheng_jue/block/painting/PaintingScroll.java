package com.shengchanshe.chang_sheng_jue.block.painting;

import com.shengchanshe.chang_sheng_jue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PaintingScroll extends HorizontalDirectionalBlock {
    public static final EnumProperty<Variant> VARIANT = EnumProperty.create("variant", Variant.class);
    private VoxelShape AABB = Shapes.empty();

    public PaintingScroll(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction value = pState.getValue(FACING);
        return switch (value){
            case SOUTH -> this.AABB = ChangShengJueVoxelShape.PAINTING_SCROLL_SOUTH;
            case WEST -> this.AABB = ChangShengJueVoxelShape.PAINTING_SCROLL_WEST;
            case EAST -> this.AABB = ChangShengJueVoxelShape.PAINTING_SCROLL_EAST;
            default -> this.AABB = ChangShengJueVoxelShape.PAINTING_SCROLL_NORTH;
        };
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        RandomSource random = pContext.getLevel().random;
        Variant[] variants = Variant.values();
        Variant randomVariant = variants[random.nextInt(variants.length)];
        return this.defaultBlockState().setValue(VARIANT, randomVariant).setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(VARIANT);
    }

    public enum Variant implements StringRepresentable {
        DEFAULT("default"),
        VARIANT_1("variant_1"),
        VARIANT_2("variant_2"),
        VARIANT_3("variant_3"),
        VARIANT_4("variant_4");

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
