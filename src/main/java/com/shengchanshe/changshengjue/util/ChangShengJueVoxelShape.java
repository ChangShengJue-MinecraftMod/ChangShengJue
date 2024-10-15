package com.shengchanshe.changshengjue.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class ChangShengJueVoxelShape {
    //筒瓦
    public static final VoxelShape CYLINDER_TILE_BLOCK_N = Shapes.join(Block.box(0, 0, 0, 16, 8, 16),
            Block.box(4, 8, 0, 12, 12, 16), BooleanOp.OR);
    public static final VoxelShape CYLINDER_TILE_BLOCK_E = Shapes.join(Block.box(0, 0, 0, 16, 8, 16),
            Block.box(0, 8, 4, 16, 12, 12), BooleanOp.OR);

    public static final VoxelShape CYLINDER_TILE_BLOCK_N_1 = Stream.of(
            Block.box(4, 0, 10, 12, 8, 16),
            Block.box(10, -2.0394659486396307, 12.443111471168688, 13, 3.9605340513603693, 17.443111471168688),
            Block.box(3, -2.0394659486396307, 12.443111471168688, 6, 3.9605340513603693, 17.443111471168688),
            Block.box(13, -4.039465948639631, 12.443111471168688, 16, 2.9605340513603693, 17.443111471168688),
            Block.box(0, -4.039465948639631, 12.443111471168688, 3, 2.9605340513603693, 17.443111471168688)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_E_1 = Stream.of(
            Block.box(0, 0, 4, 6, 8, 12),
            Block.box(-1.443111471168688, -2.0394659486396307, 10, 3.556888528831312, 3.9605340513603693, 13),
            Block.box(-1.443111471168688, -2.0394659486396307, 3, 3.556888528831312, 3.9605340513603693, 6),
            Block.box(-1.443111471168688, -4.039465948639631, 13, 3.556888528831312, 2.9605340513603693, 16),
            Block.box(-1.443111471168688, -4.039465948639631, 0, 3.556888528831312, 2.9605340513603693, 3)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_S_1 =Stream.of(
            Block.box(4, 0, 0, 12, 8, 6),
            Block.box(3, -2.0394659486396307, -1.443111471168688, 6, 3.9605340513603693, 3.556888528831312),
            Block.box(10, -2.0394659486396307, -1.443111471168688, 13, 3.9605340513603693, 3.556888528831312),
            Block.box(0, -4.039465948639631, -1.443111471168688, 3, 2.9605340513603693, 3.556888528831312),
            Block.box(13, -4.039465948639631, -1.443111471168688, 16, 2.9605340513603693, 3.556888528831312)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_W_1 = Stream.of(
            Block.box(10, 0, 4, 16, 8, 12),
            Block.box(12.443111471168688, -2.0394659486396307, 3, 17.443111471168688, 3.9605340513603693, 6),
            Block.box(12.443111471168688, -2.0394659486396307, 10, 17.443111471168688, 3.9605340513603693, 13),
            Block.box(12.443111471168688, -4.039465948639631, 0, 17.443111471168688, 2.9605340513603693, 3),
            Block.box(12.443111471168688, -4.039465948639631, 13, 17.443111471168688, 2.9605340513603693, 16)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape CYLINDER_TILE_BLOCK_N_3 = Stream.of(
            Block.box(2.9000000000000004, 3, 10, 13.1, 13, 16),
            Block.box(4, 13, 4, 12, 21, 7),
            Block.box(4, 11.139697469370066, 8.756985588965863, 12, 18.139697469370066, 11.756985588965863)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_E_3 = Stream.of(
            Block.box(0, 3, 2.9000000000000004, 6, 13, 13.1),
            Block.box(9, 13, 4, 12, 21, 12),
            Block.box(4.243014411034137, 11.139697469370066, 4, 7.243014411034137, 18.139697469370066, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_S_3 = Stream.of(
            Block.box(2.9000000000000004, 3, 0, 13.1, 13, 6),
            Block.box(4, 13, 9, 12, 21, 12),
            Block.box(4, 11.139697469370066, 4.243014411034137, 12, 18.139697469370066, 7.243014411034137)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_W_3 = Stream.of(
            Block.box(10, 3, 2.9000000000000004, 16, 13, 13.1),
            Block.box(4, 13, 4, 7, 21, 12),
            Block.box(8.756985588965863, 11.139697469370066, 4, 11.756985588965863, 18.139697469370066, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    //织布机
    public static final VoxelShape CHANG_SHENG_JUE_LOOM_NORTH = Stream.of(
            Block.box(0, 0.01, 0, 16, 12.01, 16),
            Block.box(5, 12.5, 9, 12, 15.5, 12),
            Block.box(5, 12, 3, 6, 12, 10),
            Block.box(7, 12, 3, 8, 12, 10),
            Block.box(9, 12, 3, 10, 12, 10),
            Block.box(11, 12, 3, 12, 12, 10),
            Block.box(12, 12, 9, 13, 16, 12),
            Block.box(3, 12, 9, 4, 16, 12),
            Block.box(4, 13, 9.5, 12, 15, 11.5),
            Block.box(4.5, 7.15, 10.25, 11.5, 12.15, 16.25),
            Block.box(4.5, 0.25, -0.25, 11.5, 7.25, 15.75)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_LOOM_EAST =Stream.of(
            Block.box(0, 0.01, 0, 16, 12.01, 16),
            Block.box(4, 12.5, 5, 7, 15.5, 12),
            Block.box(6, 12, 5, 13, 12, 6),
            Block.box(6, 12, 7, 13, 12, 8),
            Block.box(6, 12, 9, 13, 12, 10),
            Block.box(6, 12, 11, 13, 12, 12),
            Block.box(4, 12, 12, 7, 16, 13),
            Block.box(4, 12, 3, 7, 16, 4),
            Block.box(4.5, 13, 4, 6.5, 15, 12),
            Block.box(-0.25, 7.15, 4.5, 5.75, 12.15, 11.5),
            Block.box(0.25, 0.25, 4.5, 16.25, 7.25, 11.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_LOOM_SOUTH = Stream.of(
            Block.box(0, 0.01, 0, 16, 12.01, 16),
            Block.box(4, 12.5, 4, 11, 15.5, 7),
            Block.box(10, 12, 6, 11, 12, 13),
            Block.box(8, 12, 6, 9, 12, 13),
            Block.box(6, 12, 6, 7, 12, 13),
            Block.box(4, 12, 6, 5, 12, 13),
            Block.box(3, 12, 4, 4, 16, 7),
            Block.box(12, 12, 4, 13, 16, 7),
            Block.box(4, 13, 4.5, 12, 15, 6.5),
            Block.box(4.5, 7.15, -0.25, 11.5, 12.15, 5.75),
            Block.box(4.5, 0.25, 0.25, 11.5, 7.25, 16.25)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_LOOM_WEST = Stream.of(
            Block.box(0, 0.01, 0, 16, 12.01, 16),
            Block.box(9, 12.5, 4, 12, 15.5, 11),
            Block.box(3, 12, 10, 10, 12, 11),
            Block.box(3, 12, 8, 10, 12, 9),
            Block.box(3, 12, 6, 10, 12, 7),
            Block.box(3, 12, 4, 10, 12, 5),
            Block.box(9, 12, 3, 12, 16, 4),
            Block.box(9, 12, 12, 12, 16, 13),
            Block.box(9.5, 13, 4, 11.5, 15, 12),
            Block.box(10.25, 7.15, 4.5, 16.25, 12.15, 11.5),
            Block.box(-0.25, 0.25, 4.5, 15.75, 7.25, 11.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    //工具台
    public static final VoxelShape CHANG_SHENG_JUE_TOOL_TABLE = Stream.of(
            Block.box(0, 0, 0, 4, 11, 4),
            Block.box(0, 0, 12, 4, 11, 16),
            Block.box(12, 0, 0, 16, 11, 4),
            Block.box(12, 0, 12, 16, 11, 16),
            Block.box(0, 11, 0, 16, 15, 16),
            Block.box(2, 15, 2, 14, 16, 14)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
}
