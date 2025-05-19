package com.shengchanshe.changshengjue.block.custom.furniture.desk;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class Teapoy extends Desks {
    private VoxelShape AABB = Shapes.empty();

    public Teapoy(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Stream.of(
                Block.box(1, 15, 1, 15, 16, 15),
                Block.box(1, 2.3000000000000003, 1, 3, 13.299999999999999, 3),
                Block.box(1.1499999999999986, 0.15000000000000002, 1.1499999999999986, 3.1499999999999986, 2.1500000000000004, 3.1499999999999986),
                Block.box(13, 2.3000000000000003, 1, 15, 13.299999999999999, 3),
                Block.box(1, 2.3000000000000003, 13, 3, 13.299999999999999, 15),
                Block.box(1.1499999999999986, 0.15000000000000002, 12.850000000000001, 3.1499999999999986, 2.1500000000000004, 14.850000000000001),
                Block.box(12.850000000000001, 0.15000000000000002, 12.850000000000001, 14.850000000000001, 2.1500000000000004, 14.850000000000001),
                Block.box(12.850000000000001, 0.15000000000000002, 1.1499999999999986, 14.850000000000001, 2.1500000000000004, 3.1499999999999986),
                Block.box(13, 2.3000000000000003, 13, 15, 13.299999999999999, 15),
                Block.box(1.5, 14.3, 1.5, 14.5, 15.3, 14.5),
                Block.box(1, 13.299999999999999, 1, 15, 14.299999999999999, 15),
                Block.box(1, 9.299999999999999, 1, 15, 13.299999999999999, 15)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }

}
