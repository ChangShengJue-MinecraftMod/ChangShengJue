package com.shengchanshe.changshengjue.block.custom.balustrade;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Wooden_Balustrade extends  Balustrade{
    private final VoxelShape[] occlusionByIndex;

    public Wooden_Balustrade(Properties p_53302_) {
        super(p_53302_);
        this.occlusionByIndex = this.makeShapes(2.5F, 2.5F, 21.0F, 6.0F, 14.0F);

    }
    //默认
    protected static final VoxelShape BASE_SHAPE = Stream.of(
            Block.box(6.5, 0, 6.5, 9.5, 12, 9.5),
            Block.box(7, 12, 7, 9, 13, 9),
            Block.box(6.5, 13, 6.5, 9.5, 17, 9.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    //长
    protected static final VoxelShape NORTH_SHAPE = Stream.of(
            Block.box(6.5, 0, 6.5, 9.5, 12, 9.5),
            Block.box(7, 12, 7, 9, 13, 9),
            Block.box(6.5, 13, 6.5, 9.5, 17, 9.5),
            Block.box(7, 0.75, 0, 9, 1.75, 7),
            Block.box(7.5, 2.75, 0, 8.5, 3.75, 7),
            Block.box(7, 10.75, 0, 9, 11.75, 7),
            Block.box(7.5, 8.75, 0, 8.5, 9.75, 7),
            Block.box(7.5, 6.75, 0, 8.5, 7.75, 4),
            Block.box(7.5, 5.75, 3, 8.5, 6.75, 5),
            Block.box(7.5, 7.75, 1, 8.5, 8.75, 2),
            Block.box(7.5, 3.75, 1, 8.5, 4.75, 2),
            Block.box(7.5, 4.75, 0, 8.5, 5.75, 4),
            Block.box(7.5, 3.75, 5, 8.5, 8.75, 6)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape EAST_SHAPE =Stream.of(
            Block.box(6.5, 0, 6.5, 9.5, 12, 9.5),
            Block.box(7, 12, 7, 9, 13, 9),
            Block.box(6.5, 13, 6.5, 9.5, 17, 9.5),
            Block.box(9, 0.75, 7, 16, 1.75, 9),
            Block.box(9, 2.75, 7.5, 16, 3.75, 8.5),
            Block.box(9, 10.75, 7, 16, 11.75, 9),
            Block.box(9, 8.75, 7.5, 16, 9.75, 8.5),
            Block.box(12, 6.75, 7.5, 16, 7.75, 8.5),
            Block.box(11, 5.75, 7.5, 13, 6.75, 8.5),
            Block.box(14, 7.75, 7.5, 15, 8.75, 8.5),
            Block.box(14, 3.75, 7.5, 15, 4.75, 8.5),
            Block.box(12, 4.75, 7.5, 16, 5.75, 8.5),
            Block.box(10, 3.75, 7.5, 11, 8.75, 8.5)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape SOUTH_SHAPE = Stream.of(
            Block.box(6.5, 0, 6.5, 9.5, 12, 9.5),
            Block.box(7, 12, 7, 9, 13, 9),
            Block.box(6.5, 13, 6.5, 9.5, 17, 9.5),
            Block.box(7, 0.75, 9, 9, 1.75, 16),
            Block.box(7.5, 2.75, 9, 8.5, 3.75, 16),
            Block.box(7, 10.75, 9, 9, 11.75, 16),
            Block.box(7.5, 8.75, 9, 8.5, 9.75, 16),
            Block.box(7.5, 6.75, 12, 8.5, 7.75, 16),
            Block.box(7.5, 5.75, 11, 8.5, 6.75, 13),
            Block.box(7.5, 7.75, 14, 8.5, 8.75, 15),
            Block.box(7.5, 3.75, 14, 8.5, 4.75, 15),
            Block.box(7.5, 4.75, 12, 8.5, 5.75, 16),
            Block.box(7.5, 3.75, 10, 8.5, 8.75, 11)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape WEST_SHAPE = Stream.of(
            Block.box(6.5, 0, 6.5, 9.5, 12, 9.5),
            Block.box(7, 12, 7, 9, 13, 9),
            Block.box(6.5, 13, 6.5, 9.5, 17, 9.5),
            Block.box(0, 0.75, 7, 7, 1.75, 9),
            Block.box(0, 2.75, 7.5, 7, 3.75, 8.5),
            Block.box(0, 10.75, 7, 7, 11.75, 9),
            Block.box(0, 8.75, 7.5, 7, 9.75, 8.5),
            Block.box(0, 6.75, 7.5, 4, 7.75, 8.5),
            Block.box(3, 5.75, 7.5, 5, 6.75, 8.5),
            Block.box(1, 7.75, 7.5, 2, 8.75, 8.5),
            Block.box(1, 3.75, 7.5, 2, 4.75, 8.5),
            Block.box(0, 4.75, 7.5, 4, 5.75, 8.5),
            Block.box(5, 3.75, 7.5, 6, 8.75, 8.5)
             ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    //短
    protected static final VoxelShape N_SHAPE = Stream.of(
            Block.box(6.5, 0, 6.5, 9.5, 12, 9.5),
            Block.box(7, 0.75, 0, 9, 1.75, 7),
            Block.box(7.5, 2.75, 0, 8.5, 3.75, 7),
            Block.box(7, 10.75, 0, 9, 11.75, 7),
            Block.box(7.5, 8.75, 0, 8.5, 9.75, 7),
            Block.box(7.5, 6.75, 0, 8.5, 7.75, 4),
            Block.box(7.5, 5.75, 3, 8.5, 6.75, 5),
            Block.box(7.5, 7.75, 1, 8.5, 8.75, 2),
            Block.box(7.5, 3.75, 1, 8.5, 4.75, 2),
            Block.box(7.5, 4.75, 0, 8.5, 5.75, 4),
            Block.box(7.5, 3.75, 5, 8.5, 8.75, 6)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape E_SHAPE = Stream.of(
            Block.box(6.5, 0, 6.5, 9.5, 12, 9.5),
            Block.box(9, 0.75, 7, 16, 1.75, 9),
            Block.box(9, 2.75, 7.5, 16, 3.75, 8.5),
            Block.box(9, 10.75, 7, 16, 11.75, 9),
            Block.box(9, 8.75, 7.5, 16, 9.75, 8.5),
            Block.box(12, 6.75, 7.5, 16, 7.75, 8.5),
            Block.box(11, 5.75, 7.5, 13, 6.75, 8.5),
            Block.box(14, 7.75, 7.5, 15, 8.75, 8.5),
            Block.box(14, 3.75, 7.5, 15, 4.75, 8.5),
            Block.box(12, 4.75, 7.5, 16, 5.75, 8.5),
            Block.box(10, 3.75, 7.5, 11, 8.75, 8.5)
             ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape S_SHAPE = Stream.of(
            Block.box(6.5, 0, 6.5, 9.5, 12, 9.5),
            Block.box(7, 0.75, 9, 9, 1.75, 16),
            Block.box(7.5, 2.75, 9, 8.5, 3.75, 16),
            Block.box(7, 10.75, 9, 9, 11.75, 16),
            Block.box(7.5, 8.75, 9, 8.5, 9.75, 16),
            Block.box(7.5, 6.75, 12, 8.5, 7.75, 16),
            Block.box(7.5, 5.75, 11, 8.5, 6.75, 13),
            Block.box(7.5, 7.75, 14, 8.5, 8.75, 15),
            Block.box(7.5, 3.75, 14, 8.5, 4.75, 15),
            Block.box(7.5, 4.75, 12, 8.5, 5.75, 16),
            Block.box(7.5, 3.75, 10, 8.5, 8.75, 11)
             ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    protected static final VoxelShape W_SHAPE = Stream.of(
            Block.box(6.5, 0, 6.5, 9.5, 12, 9.5),
            Block.box(0, 0.75, 7, 7, 1.75, 9),
            Block.box(0, 2.75, 7.5, 7, 3.75, 8.5),
            Block.box(0, 10.75, 7, 7, 11.75, 9),
            Block.box(0, 8.75, 7.5, 7, 9.75, 8.5),
            Block.box(0, 6.75, 7.5, 4, 7.75, 8.5),
            Block.box(3, 5.75, 7.5, 5, 6.75, 8.5),
            Block.box(1, 7.75, 7.5, 2, 8.75, 8.5),
            Block.box(1, 3.75, 7.5, 2, 4.75, 8.5),
            Block.box(0, 4.75, 7.5, 4, 5.75, 8.5),
            Block.box(5, 3.75, 7.5, 6, 8.75, 8.5)
             ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        boolean N_VALUE = state.getValue(NORTH);
        boolean S_VALUE = state.getValue(SOUTH);
        boolean W_VALUE = state.getValue(WEST);
        boolean E_VALUE = state.getValue(EAST);

        List<VoxelShape> shapes = new ArrayList<>(4);
        if (N_VALUE) shapes.add(N_SHAPE);
        if (S_VALUE) shapes.add(S_SHAPE);
        if (W_VALUE) shapes.add(W_SHAPE);
        if (E_VALUE) shapes.add(E_SHAPE);

        if (shapes.size() == 1) {
            shapes.add(BASE_SHAPE);
        }

        if (shapes.isEmpty()) {
            return BASE_SHAPE;
        }
        return shapes.stream().reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }


}
