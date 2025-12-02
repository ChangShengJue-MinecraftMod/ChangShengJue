package com.shengchanshe.chang_sheng_jue.block.custom.furniture.desk;

import com.shengchanshe.chang_sheng_jue.block.custom.furniture.desk.entity.Desks;
import com.shengchanshe.chang_sheng_jue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class StoneTable extends Desks {
    private VoxelShape AABB = Shapes.empty();

    public StoneTable(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Stream.of(
                Block.box(4.5, 1, 4.5, 11.5, 3, 11.5),
                Block.box(4, 0, 4, 12, 1, 12),
                Block.box(5, 3, 5, 11, 13, 11),
                Block.box(-1.5, 15, -1.5, 17.5, 16, 17.5),
                Block.box(-2, 13, -2, 18, 15, 18)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }
}
