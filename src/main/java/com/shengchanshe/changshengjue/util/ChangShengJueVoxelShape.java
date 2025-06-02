package com.shengchanshe.changshengjue.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChangShengJueVoxelShape {
    //旋转方法

    //筒瓦
    public static final VoxelShape CYLINDER_TILE_BOTTOM_NS = Stream.of(
            Block.box(12, 0, 0, 16, 5, 16),
            Block.box(0, 0, 0, 4, 5, 16),
            Block.box(4, 0, 0, 12, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BOTTOM_EW = Stream.of(
            Block.box(0, 0, 0, 16, 5, 4),
            Block.box(0, 0, 12, 16, 5, 16),
            Block.box(0, 0, 4, 16, 8, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape CYLINDER_TILE_DOUBLE_NS = Shapes.join(
            Block.box(4, 8, 0, 12, 12, 16),
            Block.box(0, 0, 0, 16, 8, 16), BooleanOp.OR);
    public static final VoxelShape CYLINDER_TILE_DOUBLE_EW = Shapes.join(
            Block.box(0, 8, 4, 16, 12, 12),
            Block.box(0, 0, 0, 16, 8, 16), BooleanOp.OR);

    public static final VoxelShape CYLINDER_TILE_TOP_NS = Stream.of(
            Block.box(12, 0, 0, 16, 5, 16),
            Block.box(0, 0, 0, 4, 5, 16),
            Block.box(4, 0, 0, 12, 8, 16),
            Block.box(12, 5, 15, 16, 8, 16),
            Block.box(0, 5, 15, 4, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_TOP_EW = Stream.of(
            Block.box(0, 0, 12, 16, 5, 16),
            Block.box(0, 0, 0, 16, 5, 4),
            Block.box(0, 0, 4, 16, 8, 12),
            Block.box(0, 5, 12, 1, 8, 16),
            Block.box(0, 5, 0, 1, 8, 4)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //短筒瓦
    public static final VoxelShape SHORT_CYLINDER_TILE_N = Stream.of(
            Block.box(12, 0, 8, 16, 5, 16),
            Block.box(0, 0, 8, 4, 5, 16),
            Block.box(4, 0, 8, 12, 8, 16),
            Block.box(12, 5, 15, 16, 8, 16),
            Block.box(0, 5, 15, 4, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape SHORT_CYLINDER_TILE_E = Stream.of(
            Block.box(0, 0, 12, 8, 5, 16),
            Block.box(0, 0, 0, 8, 5, 4),
            Block.box(0, 0, 4, 8, 8, 12),
            Block.box(0, 5, 12, 1, 8, 16),
            Block.box(0, 5, 0, 1, 8, 4)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape SHORT_CYLINDER_TILE_S = Stream.of(
            Block.box(0, 0, 0, 4, 5, 8),
            Block.box(12, 0, 0, 16, 5, 8),
            Block.box(4, 0, 0, 12, 8, 8),
            Block.box(0, 5, 0, 4, 8, 1),
            Block.box(12, 5, 0, 16, 8, 1)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape SHORT_CYLINDER_TILE_W = Stream.of(
            Block.box(8, 0, 0, 16, 5, 4),
            Block.box(8, 0, 12, 16, 5, 16),
            Block.box(8, 0, 4, 16, 8, 12),
            Block.box(15, 5, 0, 16, 8, 4),
            Block.box(15, 5, 12, 16, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //侧瓦当
    public static final VoxelShape EAVES_TILE_SIDE_N = Block.box(9, 0, 9, 16, 9, 16);
    public static final VoxelShape EAVES_TILE_SIDE_E = Block.box(0, 0, 9, 7, 9, 16);
    public static final VoxelShape EAVES_TILE_SIDE_S = Block.box(0, 0, 0, 7, 9, 7);
    public static final VoxelShape EAVES_TILE_SIDE_W = Block.box(9, 0, 0, 16, 9, 7);

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
    public static final VoxelShape CYLINDER_TILE_BLOCK_S_1 = Stream.of(
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

    public static final VoxelShape CYLINDER_TILE_BLOCK_N_2 = Stream.of(
            Block.box(0, 0, 0, 16, 5, 16),
            Block.box(0, 5, 8, 16, 12, 16),
            Block.box(4, 4, 0, 12, 8, 8),
            Block.box(4, 12, 8, 12, 16, 16),
            Block.box(12, 12, 15, 16, 16, 16),
            Block.box(0, 12, 15, 4, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_E_2 = Stream.of(
            Block.box(0, 0, 0, 16, 5, 16),
            Block.box(0, 5, 0, 8, 12, 16),
            Block.box(8, 4, 4, 16, 8, 12),
            Block.box(0, 12, 4, 8, 16, 12),
            Block.box(0, 12, 12, 1, 16, 16),
            Block.box(0, 12, 0, 1, 16, 4)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_S_2 = Stream.of(
            Block.box(0, 0, 0, 16, 5, 16),
            Block.box(0, 5, 0, 16, 12, 8),
            Block.box(4, 4, 8, 12, 8, 16),
            Block.box(4, 12, 0, 12, 16, 8),
            Block.box(0, 12, 0, 4, 16, 1),
            Block.box(12, 12, 0, 16, 16, 1)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_W_2 = Stream.of(
            Block.box(0, 0, 0, 16, 5, 16),
            Block.box(8, 5, 0, 16, 12, 16),
            Block.box(0, 4, 4, 8, 8, 12),
            Block.box(8, 12, 4, 16, 16, 12),
            Block.box(15, 12, 0, 16, 16, 4),
            Block.box(15, 12, 12, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape CYLINDER_TILE_BLOCK_N_2_B = Stream.of(
            Block.box(0, 0, 0, 16, 5, 16),
            Block.box(0, 5, 8, 16, 12, 16),
            Block.box(4, 4, 0, 12, 8, 8),
            Block.box(4, 12, 8, 12, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_E_2_B = Stream.of(
            Block.box(0, 0, 0, 16, 5, 16),
            Block.box(0, 5, 0, 8, 12, 16),
            Block.box(8, 4, 4, 16, 8, 12),
            Block.box(0, 12, 4, 8, 16, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_S_2_B = Stream.of(
            Block.box(0, 0, 0, 16, 5, 16),
            Block.box(0, 5, 0, 16, 12, 8),
            Block.box(4, 4, 8, 12, 8, 16),
            Block.box(4, 12, 0, 12, 16, 8)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_W_2_B = Stream.of(
            Block.box(0, 0, 0, 16, 5, 16),
            Block.box(8, 5, 0, 16, 12, 16),
            Block.box(0, 4, 4, 8, 8, 12),
            Block.box(8, 12, 4, 16, 16, 12)
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

    public static final VoxelShape CYLINDER_TILE_BLOCK_N_5 = Stream.of(
            Block.box(0, 0, 0, 16, 12, 16),
            Block.box(4, 12, 0, 12, 16, 16),
            Block.box(12, 12, 15, 16, 16, 16),
            Block.box(0, 12, 15, 4, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_E_5 = Stream.of(
            Block.box(0, 0, 0, 16, 12, 16),
            Block.box(0, 12, 4, 16, 16, 12),
            Block.box(0, 12, 12, 1, 16, 16),
            Block.box(0, 12, 0, 1, 16, 4)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_S_5 = Stream.of(
            Block.box(0, 0, 0, 16, 12, 16),
            Block.box(4, 12, 0, 12, 16, 16),
            Block.box(0, 12, 0, 4, 16, 1),
            Block.box(12, 12, 0, 16, 16, 1)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_W_5 = Stream.of(
            Block.box(0, 0, 0, 16, 12, 16),
            Block.box(0, 12, 4, 16, 16, 12),
            Block.box(15, 12, 0, 16, 16, 4),
            Block.box(15, 12, 12, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //鸱吻
    public static final VoxelShape DEMON_MASK_N = Stream.of(
            Block.box(0, 0, 0, 16, 5, 16),
            Block.box(4, 5, 0, 12, 13, 16),
            Block.box(3, 5, 4, 13, 16, 18),
            Block.box(4, 16, 7, 12, 21, 17),
            Block.box(5, 21, 5, 11, 25, 16),
            Block.box(6, 25, 0, 10, 27, 13),
            Block.box(6, 27, 5, 10, 28, 11),
            Block.box(6, 13, 1, 10, 15, 4),
            Block.box(3, 10, 1, 13, 13, 4),
            Block.box(3, 5, 2, 13, 7, 4)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape DEMON_MASK_E = Stream.of(
            Block.box(0, 0, 0, 16, 5, 16),
            Block.box(0, 5, 4, 16, 13, 12),
            Block.box(-2, 5, 3, 12, 16, 13),
            Block.box(-1, 16, 4, 9, 21, 12),
            Block.box(0, 21, 5, 11, 25, 11),
            Block.box(3, 25, 6, 16, 27, 10),
            Block.box(5, 27, 6, 11, 28, 10),
            Block.box(12, 13, 6, 15, 15, 10),
            Block.box(12, 10, 3, 15, 13, 13),
            Block.box(12, 5, 3, 14, 7, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape DEMON_MASK_S = Stream.of(
            Block.box(0, 0, 0, 16, 5, 16),
            Block.box(4, 5, 0, 12, 13, 16),
            Block.box(3, 5, -2, 13, 16, 12),
            Block.box(4, 16, -1, 12, 21, 9),
            Block.box(5, 21, 0, 11, 25, 11),
            Block.box(6, 25, 3, 10, 27, 16),
            Block.box(6, 27, 5, 10, 28, 11),
            Block.box(6, 13, 12, 10, 15, 15),
            Block.box(3, 10, 12, 13, 13, 15),
            Block.box(3, 5, 12, 13, 7, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape DEMON_MASK_W = Stream.of(
            Block.box(0, 0, 0, 16, 5, 16),
            Block.box(0, 5, 4, 16, 13, 12),
            Block.box(4, 5, 3, 18, 16, 13),
            Block.box(7, 16, 4, 17, 21, 12),
            Block.box(5, 21, 5, 16, 25, 11),
            Block.box(0, 25, 6, 13, 27, 10),
            Block.box(5, 27, 6, 11, 28, 10),
            Block.box(1, 13, 6, 4, 15, 10),
            Block.box(1, 10, 3, 4, 13, 13),
            Block.box(2, 5, 3, 4, 7, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    //双层脊瓦
    public static final VoxelShape DOUBLE_GABLE_RIDGE_CYLINDER_TILE_N = Stream.of(
            Block.box(0, 0, 0, 16, 6, 16),
            Block.box(0, 6, 8, 16, 12, 16),
            Block.box(4, 6, 0, 12, 10, 8),
            Block.box(4, 12, 8, 12, 18, 16),
            Block.box(12, 12, 15, 16, 16, 16),
            Block.box(0, 12, 15, 4, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape DOUBLE_GABLE_RIDGE_CYLINDER_TILE_E = Stream.of(
            Block.box(0, 0, 0, 16, 6, 16),
            Block.box(0, 6, 0, 8, 12, 16),
            Block.box(8, 6, 4, 16, 10, 12),
            Block.box(0, 12, 4, 8, 18, 12),
            Block.box(0, 12, 12, 1, 16, 16),
            Block.box(0, 12, 0, 1, 16, 4)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape DOUBLE_GABLE_RIDGE_CYLINDER_TILE_S = Stream.of(
            Block.box(0, 0, 0, 16, 6, 16),
            Block.box(0, 6, 0, 16, 12, 8),
            Block.box(4, 6, 8, 12, 10, 16),
            Block.box(4, 12, 0, 12, 18, 8),
            Block.box(0, 12, 0, 4, 16, 1),
            Block.box(12, 12, 0, 16, 16, 1)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape DOUBLE_GABLE_RIDGE_CYLINDER_TILE_W = Stream.of(
            Block.box(0, 0, 0, 16, 6, 16),
            Block.box(8, 6, 0, 16, 12, 16),
            Block.box(0, 6, 4, 8, 10, 12),
            Block.box(8, 12, 4, 16, 18, 12),
            Block.box(15, 12, 0, 16, 16, 4),
            Block.box(15, 12, 12, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE_N = Stream.of(
            Block.box(0, 0, 0, 16, 6, 16),
            Block.box(0, 6, 8, 16, 12, 16),
            Block.box(4, 6, 0, 12, 10, 8),
            Block.box(4, 12, 8, 12, 18, 16),
            Block.box(12, 12, 15, 16, 16, 16),
            Block.box(0, 12, 15, 4, 16, 16),
            Block.box(5.1875, 9.5, 0.6625000000000001, 10.4375, 16.25, 8.9125),
            Block.box(5.1875, 16.25, 2.1625, 10.4375, 20, 10.4125),
            Block.box(5.1875, 20, 4.4125, 10.4375, 23, 11.9125),
            Block.box(5.9375, 14.75, -3.0875000000000004, 9.6875, 19.25, 2.1625),
            Block.box(6.3125, 15.5, -4.5875, 9.3125, 17.75, -3.0875000000000004),
            Block.box(6.6875, 17.75, -3.8375000000000004, 8.9375, 18.5, -3.0875000000000004),
            Block.box(9.3125, 19.25, -3.0875000000000004, 9.3125, 23, 0.6625000000000001),
            Block.box(6.3125, 19.25, -3.0875000000000004, 6.3125, 23, 0.6625000000000001)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE_E = Stream.of(
            Block.box(0, 0, 0, 16, 6, 16),
            Block.box(0, 6, 0, 8, 12, 16),
            Block.box(8, 6, 4, 16, 10, 12),
            Block.box(0, 12, 4, 8, 18, 12),
            Block.box(0, 12, 12, 1, 16, 16),
            Block.box(0, 12, 0, 1, 16, 4),
            Block.box(7.0875, 9.5, 5.1875, 15.3375, 16.25, 10.4375),
            Block.box(5.5875, 16.25, 5.1875, 13.8375, 20, 10.4375),
            Block.box(4.0875, 20, 5.1875, 11.5875, 23, 10.4375),
            Block.box(13.8375, 14.75, 5.9375, 19.0875, 19.25, 9.6875),
            Block.box(19.0875, 15.5, 6.3125, 20.5875, 17.75, 9.3125),
            Block.box(19.0875, 17.75, 6.6875, 19.8375, 18.5, 8.9375),
            Block.box(15.3375, 19.25, 9.3125, 19.0875, 23, 9.3125),
            Block.box(15.3375, 19.25, 6.3125, 19.0875, 23, 6.3125)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE_S = Stream.of(
            Block.box(0, 0, 0, 16, 6, 16),
            Block.box(0, 6, 0, 16, 12, 8),
            Block.box(4, 6, 8, 12, 10, 16),
            Block.box(4, 12, 0, 12, 18, 8),
            Block.box(0, 12, 0, 4, 16, 1),
            Block.box(12, 12, 0, 16, 16, 1),
            Block.box(5.5625, 9.5, 7.0875, 10.8125, 16.25, 15.3375),
            Block.box(5.5625, 16.25, 5.5875, 10.8125, 20, 13.8375),
            Block.box(5.5625, 20, 4.0875, 10.8125, 23, 11.5875),
            Block.box(6.3125, 14.75, 13.8375, 10.0625, 19.25, 19.0875),
            Block.box(6.6875, 15.5, 19.0875, 9.6875, 17.75, 20.5875),
            Block.box(7.0625, 17.75, 19.0875, 9.3125, 18.5, 19.8375),
            Block.box(6.6875, 19.25, 15.3375, 6.6875, 23, 19.0875),
            Block.box(9.6875, 19.25, 15.3375, 9.6875, 23, 19.0875)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE_W = Stream.of(
            Block.box(0, 0, 0, 16, 6, 16),
            Block.box(8, 6, 0, 16, 12, 16),
            Block.box(0, 6, 4, 8, 10, 12),
            Block.box(8, 12, 4, 16, 18, 12),
            Block.box(15, 12, 0, 16, 16, 4),
            Block.box(15, 12, 12, 16, 16, 16),
            Block.box(0.6624999999999996, 9.5, 5.5625, 8.9125, 16.25, 10.8125),
            Block.box(2.1624999999999996, 16.25, 5.5625, 10.4125, 20, 10.8125),
            Block.box(4.4125, 20, 5.5625, 11.9125, 23, 10.8125),
            Block.box(-3.0874999999999986, 14.75, 6.3125, 2.1624999999999996, 19.25, 10.0625),
            Block.box(-4.587499999999999, 15.5, 6.6875, -3.0874999999999986, 17.75, 9.6875),
            Block.box(-3.8374999999999986, 17.75, 7.0625, -3.0874999999999986, 18.5, 9.3125),
            Block.box(-3.0874999999999986, 19.25, 6.6875, 0.6624999999999996, 23, 6.6875),
            Block.box(-3.0874999999999986, 19.25, 9.6875, 0.6624999999999996, 23, 9.6875)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //脊刹
    public static final VoxelShape RIDGE_FINIAL_PAVILION_BOTTOM_NS = Shapes.join(Block.box(0, 0, 0, 16, 5, 16), Stream.of(
            Block.box(2, 5, 3, 14, 13, 13),
            Block.box(-5, 12, 3, -3, 14, 13),
            Block.box(-3, 5, 3, -2, 13, 13),
            Block.box(-2, 5, 3, 2, 14, 13),
            Block.box(14, 5, 3, 18, 14, 13),
            Block.box(18, 5, 3, 19, 13, 13),
            Block.box(19, 12, 3, 21, 14, 13),
            Block.box(3, 13, 3, 13, 16, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(), BooleanOp.OR);

    public static final VoxelShape RIDGE_FINIAL_PAVILION_BOTTOM_EW = Shapes.join(Block.box(0, 0, 0, 16, 5, 16), Stream.of(
            Block.box(3, 5, 2, 13, 13, 14),
            Block.box(3, 12, -5, 13, 14, -3),
            Block.box(3, 5, -3, 13, 13, -2),
            Block.box(3, 5, -2, 13, 14, 2),
            Block.box(3, 5, 14, 13, 14, 18),
            Block.box(3, 5, 18, 13, 13, 19),
            Block.box(3, 12, 19, 13, 14, 21),
            Block.box(3, 13, 3, 13, 16, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(), BooleanOp.OR);


    public static final VoxelShape CYLINDER_TILE_BLOCK_NS_5_B = Shapes.join(Block.box(0, 0, 0, 16, 12, 16),
            Block.box(4, 12, 0, 12, 16, 16), BooleanOp.OR);
    public static final VoxelShape CYLINDER_TILE_BLOCK_EW_5_B = Shapes.join(Block.box(0, 0, 0, 16, 12, 16),
            Block.box(0, 12, 4, 16, 16, 12), BooleanOp.OR);

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
    //武器架
    public static final VoxelShape CHANG_SHENG_JUE_WEAPON_RACK_ONLY_NORTH =Stream.of(
            Block.box(14, 0, 6, 16, 2, 8),
            Block.box(14, 0, 14, 16, 16, 16),
            Block.box(14, 13, 11, 16, 15, 14),
            Block.box(0, 0, 14, 2, 16, 16),
            Block.box(0, 0, 6, 2, 2, 8),
            Block.box(14, 3, 6, 16, 6, 8),
            Block.box(0, 3, 6, 2, 6, 8),
            Block.box(14, 5, 7, 16, 8, 9),
            Block.box(0, 5, 7, 2, 8, 9),
            Block.box(14, 7, 8, 16, 10, 10),
            Block.box(0, 7, 8, 2, 10, 10),
            Block.box(14, 9, 9, 16, 12, 11),
            Block.box(0, 9, 9, 2, 12, 11),
            Block.box(14, 11, 10, 16, 14, 12),
            Block.box(0, 11, 10, 2, 14, 12),
            Block.box(0, 13, 11, 2, 15, 14),
            Block.box(0, 2, 6, 16, 3, 14),
            Block.box(2, 2, 14, 14, 3, 16),
            Block.box(2, 14, 14, 14, 15, 16),
            Block.box(2, 9, 9, 14, 10, 11)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_WEAPON_RACK_ONLY_EAST =Stream.of(
            Block.box(8, 0, 14, 10, 2, 16),
            Block.box(0, 0, 14, 2, 16, 16),
            Block.box(2, 13, 14, 5, 15, 16),
            Block.box(0, 0, 0, 2, 16, 2),
            Block.box(8, 0, 0, 10, 2, 2),
            Block.box(8, 3, 14, 10, 6, 16),
            Block.box(8, 3, 0, 10, 6, 2),
            Block.box(7, 5, 14, 9, 8, 16),
            Block.box(7, 5, 0, 9, 8, 2),
            Block.box(6, 7, 14, 8, 10, 16),
            Block.box(6, 7, 0, 8, 10, 2),
            Block.box(5, 9, 14, 7, 12, 16),
            Block.box(5, 9, 0, 7, 12, 2),
            Block.box(4, 11, 14, 6, 14, 16),
            Block.box(4, 11, 0, 6, 14, 2),
            Block.box(2, 13, 0, 5, 15, 2),
            Block.box(2, 2, 0, 10, 3, 16),
            Block.box(0, 2, 2, 2, 3, 14),
            Block.box(0, 14, 2, 2, 15, 14),
            Block.box(5, 9, 2, 7, 10, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_WEAPON_RACK_ONLY_SOUTH =Stream.of(
            Block.box(0, 0, 8, 2, 2, 10),
            Block.box(0, 0, 0, 2, 16, 2),
            Block.box(0, 13, 2, 2, 15, 5),
            Block.box(14, 0, 0, 16, 16, 2),
            Block.box(14, 0, 8, 16, 2, 10),
            Block.box(0, 3, 8, 2, 6, 10),
            Block.box(14, 3, 8, 16, 6, 10),
            Block.box(0, 5, 7, 2, 8, 9),
            Block.box(14, 5, 7, 16, 8, 9),
            Block.box(0, 7, 6, 2, 10, 8),
            Block.box(14, 7, 6, 16, 10, 8),
            Block.box(0, 9, 5, 2, 12, 7),
            Block.box(14, 9, 5, 16, 12, 7),
            Block.box(0, 11, 4, 2, 14, 6),
            Block.box(14, 11, 4, 16, 14, 6),
            Block.box(14, 13, 2, 16, 15, 5),
            Block.box(0, 2, 2, 16, 3, 10),
            Block.box(2, 2, 0, 14, 3, 2),
            Block.box(2, 14, 0, 14, 15, 2),
            Block.box(2, 9, 5, 14, 10, 7)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_WEAPON_RACK_ONLY_WEST =Stream.of(
            Block.box(6, 0, 0, 8, 2, 2),
            Block.box(14, 0, 0, 16, 16, 2),
            Block.box(11, 13, 0, 14, 15, 2),
            Block.box(14, 0, 14, 16, 16, 16),
            Block.box(6, 0, 14, 8, 2, 16),
            Block.box(6, 3, 0, 8, 6, 2),
            Block.box(6, 3, 14, 8, 6, 16),
            Block.box(7, 5, 0, 9, 8, 2),
            Block.box(7, 5, 14, 9, 8, 16),
            Block.box(8, 7, 0, 10, 10, 2),
            Block.box(8, 7, 14, 10, 10, 16),
            Block.box(9, 9, 0, 11, 12, 2),
            Block.box(9, 9, 14, 11, 12, 16),
            Block.box(10, 11, 0, 12, 14, 2),
            Block.box(10, 11, 14, 12, 14, 16),
            Block.box(11, 13, 14, 14, 15, 16),
            Block.box(6, 2, 0, 14, 3, 16),
            Block.box(14, 2, 2, 16, 3, 14),
            Block.box(14, 14, 2, 16, 15, 14),
            Block.box(9, 9, 2, 11, 10, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_WEAPON_RACK_DOUBLE_NORTH = Stream.of(
            Block.box(14, 0, 6, 16, 2, 8),
            Block.box(14, 0, 14, 16, 16, 16),
            Block.box(14, 13, 11, 16, 15, 14),
            Block.box(14, 3, 6, 16, 6, 8),
            Block.box(-16, 0, 14, -14, 16, 16),
            Block.box(-16, 0, 6, -14, 2, 8),
            Block.box(-16, 3, 6, -14, 6, 8),
            Block.box(14, 5, 7, 16, 8, 9),
            Block.box(-16, 5, 7, -14, 8, 9),
            Block.box(14, 7, 8, 16, 10, 10),
            Block.box(-16, 7, 8, -14, 10, 10),
            Block.box(14, 9, 9, 16, 12, 11),
            Block.box(-16, 9, 9, -14, 12, 11),
            Block.box(14, 11, 10, 16, 14, 12),
            Block.box(-16, 11, 10, -14, 14, 12),
            Block.box(14, 11, 10, 16, 14, 12),
            Block.box(-16, 11, 10, -14, 14, 12),
            Block.box(-16, 13, 11, -14, 15, 14),
            Block.box(0, 9, 9, 14, 10, 11),
            Block.box(0, 14, 14, 14, 15, 16),
            Block.box(0, 2, 14, 14, 3, 16),
            Block.box(0, 2, 6, 16, 3, 14),
            Block.box(-16, 2, 6, 0, 3, 14),
            Block.box(-14, 2, 14, 0, 3, 16),
            Block.box(-14, 14, 14, 0, 15, 16),
            Block.box(-14, 9, 9, 0, 10, 11)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_WEAPON_RACK_DOUBLE_SOUTH = Stream.of(
            Block.box(0, 0, 8, 2, 2, 10),
            Block.box(0, 0, 0, 2, 16, 2),
            Block.box(0, 13, 2, 2, 15, 5),
            Block.box(0, 3, 8, 2, 6, 10),
            Block.box(30, 0, 0, 32, 16, 2),
            Block.box(30, 0, 8, 32, 2, 10),
            Block.box(30, 3, 8, 32, 6, 10),
            Block.box(0, 5, 7, 2, 8, 9),
            Block.box(30, 5, 7, 32, 8, 9),
            Block.box(0, 7, 6, 2, 10, 8),
            Block.box(30, 7, 6, 32, 10, 8),
            Block.box(0, 9, 5, 2, 12, 7),
            Block.box(30, 9, 5, 32, 12, 7),
            Block.box(0, 11, 4, 2, 14, 6),
            Block.box(30, 11, 4, 32, 14, 6),
            Block.box(0, 11, 4, 2, 14, 6),
            Block.box(30, 11, 4, 32, 14, 6),
            Block.box(30, 13, 2, 32, 15, 5),
            Block.box(2, 9, 5, 16, 10, 7),
            Block.box(2, 14, 0, 16, 15, 2),
            Block.box(2, 2, 0, 16, 3, 2),
            Block.box(0, 2, 2, 16, 3, 10),
            Block.box(16, 2, 2, 32, 3, 10),
            Block.box(16, 2, 0, 30, 3, 2),
            Block.box(16, 14, 0, 30, 15, 2),
            Block.box(16, 9, 5, 30, 10, 7)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_WEAPON_RACK_DOUBLE_EAST  = Stream.of(
            Block.box(8, 0, 14, 10, 2, 16),
            Block.box(0, 0, 14, 2, 16, 16),
            Block.box(2, 13, 14, 5, 15, 16),
            Block.box(8, 3, 14, 10, 6, 16),
            Block.box(0, 0, -16, 2, 16, -14),
            Block.box(8, 0, -16, 10, 2, -14),
            Block.box(8, 3, -16, 10, 6, -14),
            Block.box(7, 5, 14, 9, 8, 16),
            Block.box(7, 5, -16, 9, 8, -14),
            Block.box(6, 7, 14, 8, 10, 16),
            Block.box(6, 7, -16, 8, 10, -14),
            Block.box(5, 9, 14, 7, 12, 16),
            Block.box(5, 9, -16, 7, 12, -14),
            Block.box(4, 11, 14, 6, 14, 16),
            Block.box(4, 11, -16, 6, 14, -14),
            Block.box(4, 11, 14, 6, 14, 16),
            Block.box(4, 11, -16, 6, 14, -14),
            Block.box(2, 13, -16, 5, 15, -14),
            Block.box(5, 9, 0, 7, 10, 14),
            Block.box(0, 14, 0, 2, 15, 14),
            Block.box(0, 2, 0, 2, 3, 14),
            Block.box(2, 2, 0, 10, 3, 16),
            Block.box(2, 2, -16, 10, 3, 0),
            Block.box(0, 2, -14, 2, 3, 0),
            Block.box(0, 14, -14, 2, 15, 0),
            Block.box(5, 9, -14, 7, 10, 0)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_WEAPON_RACK_DOUBLE_WEST =Stream.of(
            Block.box(6, 0, 0, 8, 2, 2),
            Block.box(14, 0, 0, 16, 16, 2),
            Block.box(11, 13, 0, 14, 15, 2),
            Block.box(6, 3, 0, 8, 6, 2),
            Block.box(14, 0, 30, 16, 16, 32),
            Block.box(6, 0, 30, 8, 2, 32),
            Block.box(6, 3, 30, 8, 6, 32),
            Block.box(7, 5, 0, 9, 8, 2),
            Block.box(7, 5, 30, 9, 8, 32),
            Block.box(8, 7, 0, 10, 10, 2),
            Block.box(8, 7, 30, 10, 10, 32),
            Block.box(9, 9, 0, 11, 12, 2),
            Block.box(9, 9, 30, 11, 12, 32),
            Block.box(10, 11, 0, 12, 14, 2),
            Block.box(10, 11, 30, 12, 14, 32),
            Block.box(10, 11, 0, 12, 14, 2),
            Block.box(10, 11, 30, 12, 14, 32),
            Block.box(11, 13, 30, 14, 15, 32),
            Block.box(9, 9, 2, 11, 10, 16),
            Block.box(14, 14, 2, 16, 15, 16),
            Block.box(14, 2, 2, 16, 3, 16),
            Block.box(6, 2, 0, 14, 3, 16),
            Block.box(6, 2, 16, 14, 3, 32),
            Block.box(14, 2, 16, 16, 3, 30),
            Block.box(14, 14, 16, 16, 15, 30),
            Block.box(9, 9, 16, 11, 10, 30)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_WEAPON_RACK_TREBLE_NORTH = Stream.of(
            Block.box(30, 0, 14, 32, 16, 16),
            Block.box(30, 13, 11, 32, 15, 14),
            Block.box(30, 0, 6, 32, 2, 8),
            Block.box(16, 2, 6, 32, 3, 14),
            Block.box(16, 2, 14, 30, 3, 16),
            Block.box(16, 14, 14, 30, 15, 16),
            Block.box(16, 9, 9, 30, 10, 11),
            Block.box(-16, 0, 14, -14, 16, 16),
            Block.box(-16, 0, 6, -14, 2, 8),
            Block.box(-16, 13, 11, -14, 15, 14),
            Block.box(-14, 9, 9, 0, 10, 11),
            Block.box(-14, 14, 14, 0, 15, 16),
            Block.box(-14, 2, 14, 0, 3, 16),
            Block.box(-16, 2, 6, 0, 3, 14),
            Block.box(0, 2, 6, 16, 3, 14),
            Block.box(-16, 3, 6, -14, 6, 8),
            Block.box(30, 3, 6, 32, 6, 8),
            Block.box(-16, 5, 7, -14, 8, 9),
            Block.box(30, 5, 7, 32, 8, 9),
            Block.box(30, 7, 8, 32, 10, 10),
            Block.box(-16, 7, 8, -14, 10, 10),
            Block.box(-16, 9, 9, -14, 12, 11),
            Block.box(30, 9, 9, 32, 12, 11),
            Block.box(30, 11, 10, 32, 14, 12),
            Block.box(-16, 11, 10, -14, 14, 12),
            Block.box(0, 2, 14, 16, 3, 16),
            Block.box(0, 14, 14, 16, 15, 16),
            Block.box(0, 9, 9, 16, 10, 11),
            Block.box(6.5, 0, 10, 8.5, 2, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_WEAPON_RACK_TREBLE_SOUTH = Stream.of(
            Block.box(-16, 0, 0, -14, 16, 2),
            Block.box(-16, 13, 2, -14, 15, 5),
            Block.box(-16, 0, 8, -14, 2, 10),
            Block.box(-16, 2, 2, 0, 3, 10),
            Block.box(-14, 2, 0, 0, 3, 2),
            Block.box(-14, 14, 0, 0, 15, 2),
            Block.box(-14, 9, 5, 0, 10, 7),
            Block.box(30, 0, 0, 32, 16, 2),
            Block.box(30, 0, 8, 32, 2, 10),
            Block.box(30, 13, 2, 32, 15, 5),
            Block.box(16, 9, 5, 30, 10, 7),
            Block.box(16, 14, 0, 30, 15, 2),
            Block.box(16, 2, 0, 30, 3, 2),
            Block.box(16, 2, 2, 32, 3, 10),
            Block.box(0, 2, 2, 16, 3, 10),
            Block.box(30, 3, 8, 32, 6, 10),
            Block.box(-16, 3, 8, -14, 6, 10),
            Block.box(30, 5, 7, 32, 8, 9),
            Block.box(-16, 5, 7, -14, 8, 9),
            Block.box(-16, 7, 6, -14, 10, 8),
            Block.box(30, 7, 6, 32, 10, 8),
            Block.box(30, 9, 5, 32, 12, 7),
            Block.box(-16, 9, 5, -14, 12, 7),
            Block.box(-16, 11, 4, -14, 14, 6),
            Block.box(30, 11, 4, 32, 14, 6),
            Block.box(0, 2, 0, 16, 3, 2),
            Block.box(0, 14, 0, 16, 15, 2),
            Block.box(0, 9, 5, 16, 10, 7),
            Block.box(7.5, 0, 4, 9.5, 2, 6)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_WEAPON_RACK_TREBLE_WEST =Stream.of(
            Block.box(14, 0, -16, 16, 16, -14),
            Block.box(11, 13, -16, 14, 15, -14),
            Block.box(6, 0, -16, 8, 2, -14),
            Block.box(6, 2, -16, 14, 3, 0),
            Block.box(14, 2, -14, 16, 3, 0),
            Block.box(14, 14, -14, 16, 15, 0),
            Block.box(9, 9, -14, 11, 10, 0),
            Block.box(6, 3, -16, 8, 6, -14),
            Block.box(7, 5, -16, 9, 8, -14),
            Block.box(8, 7, -16, 10, 10, -14),
            Block.box(9, 9, -16, 11, 12, -14),
            Block.box(10, 11, -16, 12, 14, -14),
            Block.box(14, 2, 16, 16, 3, 30),
            Block.box(10, 11, 30, 12, 14, 32),
            Block.box(9, 9, 30, 11, 12, 32),
            Block.box(8, 7, 30, 10, 10, 32),
            Block.box(7, 5, 30, 9, 8, 32),
            Block.box(6, 3, 30, 8, 6, 32),
            Block.box(6, 2, 16, 14, 3, 32),
            Block.box(14, 14, 16, 16, 15, 30),
            Block.box(9, 9, 16, 11, 10, 30),
            Block.box(11, 13, 30, 14, 15, 32),
            Block.box(6, 0, 30, 8, 2, 32),
            Block.box(14, 0, 30, 16, 16, 32),
            Block.box(6, 2, 0, 14, 3, 16),
            Block.box(14, 2, 0, 16, 3, 16),
            Block.box(14, 14, 0, 16, 15, 16),
            Block.box(9, 9, 0, 11, 10, 16),
            Block.box(11.5, 0, 7, 13.5, 2, 9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_WEAPON_RACK_TREBLE_EAST = Stream.of(
            Block.box(0, 0, 30, 2, 16, 32),
            Block.box(2, 13, 30, 5, 15, 32),
            Block.box(8, 0, 30, 10, 2, 32),
            Block.box(2, 2, 16, 10, 3, 32),
            Block.box(0, 2, 16, 2, 3, 30),
            Block.box(0, 14, 16, 2, 15, 30),
            Block.box(5, 9, 16, 7, 10, 30),
            Block.box(0, 0, -16, 2, 16, -14),
            Block.box(8, 0, -16, 10, 2, -14),
            Block.box(2, 13, -16, 5, 15, -14),
            Block.box(5, 9, -14, 7, 10, 0),
            Block.box(0, 14, -14, 2, 15, 0),
            Block.box(0, 2, -14, 2, 3, 0),
            Block.box(2, 2, -16, 10, 3, 0),
            Block.box(2, 2, 0, 10, 3, 16),
            Block.box(8, 3, -16, 10, 6, -14),
            Block.box(8, 3, 30, 10, 6, 32),
            Block.box(7, 5, -16, 9, 8, -14),
            Block.box(7, 5, 30, 9, 8, 32),
            Block.box(6, 7, 30, 8, 10, 32),
            Block.box(6, 7, -16, 8, 10, -14),
            Block.box(5, 9, -16, 7, 12, -14),
            Block.box(5, 9, 30, 7, 12, 32),
            Block.box(4, 11, 30, 6, 14, 32),
            Block.box(4, 11, -16, 6, 14, -14),
            Block.box(0, 2, 0, 2, 3, 16),
            Block.box(0, 14, 0, 2, 15, 16),
            Block.box(5, 9, 0, 7, 10, 16),
            Block.box(4.5, 0, 7, 6.5, 2, 9)
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

    //猪食槽
    public static final VoxelShape CHANG_SHENG_JUE_PIG_TROUGH_NORTH = Stream.of(
            Block.box(0, 0, 1, 16, 1, 15),
            Block.box(0, 1, 1, 16, 7, 3),
            Block.box(0, 1, 13, 16, 7, 15),
            Block.box(14, 1, 3, 16, 7, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_PIG_TROUGH_EAST = Stream.of(
            Block.box(1, 0, 0, 15, 1, 16),
            Block.box(13, 1, 0, 15, 7, 16),
            Block.box(1, 1, 0, 3, 7, 16),
            Block.box(3, 1, 14, 13, 7, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_PIG_TROUGH_SOUTH = Stream.of(
            Block.box(0, 0, 1, 16, 1, 15),
            Block.box(0, 1, 13, 16, 7, 15),
            Block.box(0, 1, 1, 16, 7, 3),
            Block.box(0, 1, 3, 2, 7, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_PIG_TROUGH_WEST = Stream.of(
            Block.box(1, 0, 0, 15, 1, 16),
            Block.box(1, 1, 0, 3, 7, 16),
            Block.box(13, 1, 0, 15, 7, 16),
            Block.box(3, 1, 0, 13, 7, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //字画(小)
    public static final VoxelShape PAINTING_SCROLL_NORTH = Stream.of(
            Block.box(0, 0, 14, 16, 2, 16),
            Block.box(0, 14, 14, 16, 16, 16),
            Block.box(1, 2, 15, 15, 14, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape PAINTING_SCROLL_EAST = Stream.of(
            Block.box(-1.7763568394002505e-15, 0, -1.7763568394002505e-15, 1.9999999999999982, 2, 16),
            Block.box(-1.7763568394002505e-15, 14, -1.7763568394002505e-15, 1.9999999999999982, 16, 16),
            Block.box(-1.7763568394002505e-15, 2, 1, 0.9999999999999982, 14, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape PAINTING_SCROLL_SOUTH = Stream.of(
            Block.box(0, 0, -3.552713678800501e-15, 16, 2, 1.9999999999999964),
            Block.box(0, 14, -3.552713678800501e-15, 16, 16, 1.9999999999999964),
            Block.box(0.9999999999999982, 2, -3.552713678800501e-15, 14.999999999999998, 14, 0.9999999999999964)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape PAINTING_SCROLL_WEST = Stream.of(
            Block.box(14.000000000000002, 0, 0, 16, 2, 15.999999999999998),
            Block.box(14.000000000000002, 14, 0, 16, 16, 15.999999999999998),
            Block.box(15.000000000000002, 2, 0.9999999999999964, 16, 14, 14.999999999999996)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    //字画(高)
    public static final VoxelShape HIGH_PAINTING_SCROLL_NORTH_LOWER = Shapes.join(
            Block.box(0, 0, 14, 16, 2, 16), Block.box(1, 2, 15, 15, 16, 16), BooleanOp.OR);
    public static final VoxelShape HIGH_PAINTING_SCROLL_EAST_LOWER = Shapes.join(
            Block.box(0, 0, 0, 2, 2, 16), Block.box(0, 2, 1, 1, 16, 15), BooleanOp.OR);
    public static final VoxelShape HIGH_PAINTING_SCROLL_SOUTH_LOWER = Shapes.join(
            Block.box(0, 0, 0, 16, 2, 2), Block.box(1, 2, 0, 15, 16, 1), BooleanOp.OR);
    public static final VoxelShape HIGH_PAINTING_SCROLL_WEST_LOWER = Shapes.join(
            Block.box(14, 0, 0, 16, 2, 16), Block.box(15, 2, 1, 16, 16, 15), BooleanOp.OR);

    public static final VoxelShape HIGH_PAINTING_SCROLL_NORTH_UPPER = Shapes.join(
            Block.box(0, 14, 14, 16, 16, 16), Block.box(1, 0, 15, 15, 14, 16), BooleanOp.OR);
    public static final VoxelShape HIGH_PAINTING_SCROLL_EAST_UPPER = Shapes.join(
            Block.box(0, 14, 0, 2, 16, 16), Block.box(0, 0, 1, 1, 14, 15), BooleanOp.OR);
    public static final VoxelShape HIGH_PAINTING_SCROLL_SOUTH_UPPER = Shapes.join(
            Block.box(0, 14, 0, 16, 16, 2), Block.box(1, 0, 0, 15, 14, 1), BooleanOp.OR);
    public static final VoxelShape HIGH_PAINTING_SCROLL_WEST_UPPER = Shapes.join(
            Block.box(14, 14, 0, 16, 16, 16), Block.box(15, 0, 1, 16, 14, 15), BooleanOp.OR);

    //字画(横)
    public static final VoxelShape WIDTH_PAINTING_SCROLL_SOUTH_RIGHT = Shapes.join(
            Block.box(0, 0, 14, 2, 16, 16), Block.box(2, 1, 15, 16, 15, 16),BooleanOp.OR);
    public static final VoxelShape WIDTH_PAINTING_SCROLL_WEST_RIGHT = Shapes.join(
            Block.box(0, 0, 0, 2, 16, 2), Block.box(0, 1, 2, 1, 15, 16), BooleanOp.OR);
    public static final VoxelShape WIDTH_PAINTING_SCROLL_EAST_RIGHT = Shapes.join(
            Block.box(14, 0, 0, 16, 16, 2), Block.box(0, 1, 0, 14, 15, 1), BooleanOp.OR);
    public static final VoxelShape WIDTH_PAINTING_SCROLL_NORTH_RIGHT = Shapes.join(
            Block.box(14, 0, 14, 16, 16, 16), Block.box(15, 1, 0, 16, 15, 14), BooleanOp.OR);

    public static final VoxelShape WIDTH_PAINTING_SCROLL_NORTH_LEFT = Shapes.join(
            Block.box(14, 0, 14, 16, 16, 16), Block.box(0, 1, 15, 14, 15, 16), BooleanOp.OR);
    public static final VoxelShape WIDTH_PAINTING_SCROLL_EAST_LEFT = Shapes.join(
            Block.box(0, 0, 14, 2, 16, 16), Block.box(0, 1, 0, 1, 15, 14), BooleanOp.OR);
    public static final VoxelShape WIDTH_PAINTING_SCROLL_SOUTH_LEFT = Shapes.join(
            Block.box(0, 0, 0, 2, 16, 2), Block.box(2, 1, 0, 16, 15, 1), BooleanOp.OR);
    public static final VoxelShape WIDTH_PAINTING_SCROLL_WEST_LEFT = Shapes.join(
            Block.box(14, 0, 0, 16, 16, 2), Block.box(15, 1, 2, 16, 15, 16), BooleanOp.OR);

    //酒桌椅
    public static final VoxelShape DRINKING_TABLE_AND_CHAIRS_NORTH = Stream.of(
            Block.box(1.3499999999999943, 1.9, 2, 2.3499999999999943, 2.9, 14),
            Block.box(13.649999999999999, 1.9, 2, 14.649999999999999, 2.9, 14),
            Block.box(1, 6, 1, 15, 8, 15),
            Block.box(1.5, 8, 1.5, 14.5, 9, 14.5),
            Block.box(5, 10.5, 13.5, 11, 20.5, 14.5),
            Block.box(10, 8.5, 13.5, 11, 10.5, 14.5),
            Block.box(1.3499999999999943, 8.5, 13.5, 2.3499999999999943, 20.5, 14.5),
            Block.box(13.649999999999999, 8.5, 13.5, 14.649999999999999, 20.5, 14.5),
            Block.box(5, 8.5, 13.5, 6, 10.5, 14.5),
            Block.box(1.25, 0, 1.25, 3.25, 8, 3.25),
            Block.box(1.25, 0, 12.75, 3.25, 8, 14.75),
            Block.box(12.75, 0, 12.75, 14.75, 8, 14.75),
            Block.box(2, 1.9, 13.650000000000006, 14, 2.9, 14.650000000000006),
            Block.box(2, 1.9, 1.3500000000000014, 14, 2.9, 2.3500000000000014),
            Block.box(-0.25, 20.5, 13.5, 16.25, 21.5, 14.5),
            Block.box(12.75, 0, 1.25, 14.75, 8, 3.25)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape DRINKING_TABLE_AND_CHAIRS_EAST = Stream.of(
            Block.box(2, 1.9, 1.3500000000000014, 14, 2.9, 2.3500000000000014),
            Block.box(2, 1.9, 13.650000000000006, 14, 2.9, 14.650000000000006),
            Block.box(1, 6, 1.000000000000007, 15, 8, 15.000000000000007),
            Block.box(1.5, 8, 1.500000000000007, 14.5, 9, 14.500000000000007),
            Block.box(1.5, 10.5, 5.000000000000007, 2.5, 20.5, 11.000000000000007),
            Block.box(1.5, 8.5, 10.000000000000007, 2.5, 10.5, 11.000000000000007),
            Block.box(1.5, 8.5, 1.3500000000000014, 2.5, 20.5, 2.3500000000000014),
            Block.box(1.5, 8.5, 13.650000000000006, 2.5, 20.5, 14.650000000000006),
            Block.box(1.5, 8.5, 5.000000000000007, 2.5, 10.5, 6.000000000000007),
            Block.box(12.75, 0, 1.250000000000007, 14.75, 8, 3.250000000000007),
            Block.box(1.25, 0, 1.250000000000007, 3.25, 8, 3.250000000000007),
            Block.box(1.25, 0, 12.750000000000007, 3.25, 8, 14.750000000000007),
            Block.box(1.3499999999999943, 1.9, 2.000000000000007, 2.3499999999999943, 2.9, 14.000000000000007),
            Block.box(13.649999999999999, 1.9, 2.000000000000007, 14.649999999999999, 2.9, 14.000000000000007),
            Block.box(1.5, 20.5, -0.2499999999999929, 2.5, 21.5, 16.250000000000007),
            Block.box(12.75, 0, 12.750000000000007, 14.75, 8, 14.750000000000007)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape DRINKING_TABLE_AND_CHAIRS_SOUTH = Stream.of(
            Block.box(13.649999999999999, 1.9, 2.000000000000007, 14.649999999999999, 2.9, 14.000000000000007),
            Block.box(1.3499999999999943, 1.9, 2.000000000000007, 2.3499999999999943, 2.9, 14.000000000000007),
            Block.box(0.9999999999999929, 6, 1.000000000000007, 14.999999999999993, 8, 15.000000000000007),
            Block.box(1.499999999999993, 8, 1.500000000000007, 14.499999999999993, 9, 14.500000000000007),
            Block.box(4.999999999999993, 10.5, 1.500000000000007, 10.999999999999993, 20.5, 2.500000000000007),
            Block.box(4.999999999999993, 8.5, 1.500000000000007, 5.999999999999993, 10.5, 2.500000000000007),
            Block.box(13.649999999999999, 8.5, 1.500000000000007, 14.649999999999999, 20.5, 2.500000000000007),
            Block.box(1.3499999999999943, 8.5, 1.500000000000007, 2.3499999999999943, 20.5, 2.500000000000007),
            Block.box(9.999999999999993, 8.5, 1.500000000000007, 10.999999999999993, 10.5, 2.500000000000007),
            Block.box(12.749999999999993, 0, 12.750000000000007, 14.749999999999993, 8, 14.750000000000007),
            Block.box(12.749999999999993, 0, 1.250000000000007, 14.749999999999993, 8, 3.250000000000007),
            Block.box(1.249999999999993, 0, 1.250000000000007, 3.249999999999993, 8, 3.250000000000007),
            Block.box(1.999999999999993, 1.9, 1.3500000000000014, 13.999999999999993, 2.9, 2.3500000000000014),
            Block.box(1.999999999999993, 1.9, 13.650000000000006, 13.999999999999993, 2.9, 14.650000000000006),
            Block.box(-0.2500000000000071, 20.5, 1.500000000000007, 16.249999999999993, 21.5, 2.500000000000007),
            Block.box(1.249999999999993, 0, 12.750000000000007, 3.249999999999993, 8, 14.750000000000007)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape DRINKING_TABLE_AND_CHAIRS_WEST = Stream.of(
            Block.box(1.999999999999993, 1.9, 13.650000000000006, 13.999999999999993, 2.9, 14.650000000000006),
            Block.box(1.999999999999993, 1.9, 1.3500000000000014, 13.999999999999993, 2.9, 2.3500000000000014),
            Block.box(0.9999999999999929, 6, 1, 14.999999999999993, 8, 15),
            Block.box(1.499999999999993, 8, 1.5, 14.499999999999993, 9, 14.5),
            Block.box(13.499999999999993, 10.5, 5, 14.499999999999993, 20.5, 11),
            Block.box(13.499999999999993, 8.5, 5, 14.499999999999993, 10.5, 6),
            Block.box(13.499999999999993, 8.5, 13.650000000000006, 14.499999999999993, 20.5, 14.650000000000006),
            Block.box(13.499999999999993, 8.5, 1.3500000000000014, 14.499999999999993, 20.5, 2.3500000000000014),
            Block.box(13.499999999999993, 8.5, 10, 14.499999999999993, 10.5, 11),
            Block.box(1.249999999999993, 0, 12.75, 3.249999999999993, 8, 14.75),
            Block.box(12.749999999999993, 0, 12.75, 14.749999999999993, 8, 14.75),
            Block.box(12.749999999999993, 0, 1.25, 14.749999999999993, 8, 3.25),
            Block.box(13.649999999999999, 1.9, 2, 14.649999999999999, 2.9, 14),
            Block.box(1.3499999999999943, 1.9, 2, 2.3499999999999943, 2.9, 14),
            Block.box(13.499999999999993, 20.5, -0.25, 14.499999999999993, 21.5, 16.25),
            Block.box(1.249999999999993, 0, 1.25, 3.249999999999993, 8, 3.25)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //书桌左
    public static final VoxelShape BOOK_DESK_NORTH_LEFT = Stream.of(
            Block.box(10, 0, 1, 13, 13, 4),
            Block.box(10, 0, 12, 13, 13, 15),
            Block.box(0, 13, 0, 16, 16, 16),
            Block.box(0, 8, 1, 13, 13, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape BOOK_DESK_EAST_LEFT = Stream.of(
            Block.box(12, 0, 10, 15, 13, 13),
            Block.box(1, 0, 10, 4, 13, 13),
            Block.box(0, 13, 0, 16, 16, 16),
            Block.box(1, 8, 0, 15, 13, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape BOOK_DESK_SOUTH_LEFT = Stream.of(
            Block.box(3, 0, 12, 6, 13, 15),
            Block.box(3, 0, 1, 6, 13, 4),
            Block.box(0, 13, 0, 16, 16, 16),
            Block.box(3, 8, 1, 16, 13, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape BOOK_DESK_WEST_LEFT = Stream.of(
            Block.box(1, 0, 3, 4, 13, 6),
            Block.box(12, 0, 3, 15, 13, 6),
            Block.box(0, 13, 0, 16, 16, 16),
            Block.box(1, 8, 3, 15, 13, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    //书桌右
    public static final VoxelShape BOOK_DESK_NORTH_RIGHT = Stream.of(
            Block.box(0, 13, 0, 16, 16, 16),
            Block.box(3, 0, 1, 6, 13, 4),
            Block.box(3, 0, 12, 6, 13, 15),
            Block.box(3, 8, 1, 16, 13, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape BOOK_DESK_EAST_RIGHT = Stream.of(
            Block.box(0, 13, 0, 16, 16, 16),
            Block.box(12, 0, 3, 15, 13, 6),
            Block.box(1, 0, 3, 4, 13, 6),
            Block.box(1, 8, 3, 15, 13, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape BOOK_DESK_SOUTH_RIGHT = Stream.of(
            Block.box(0, 13, 0, 16, 16, 16),
            Block.box(10, 0, 12, 13, 13, 15),
            Block.box(10, 0, 1, 13, 13, 4),
            Block.box(0, 8, 1, 13, 13, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape BOOK_DESK_WEST_RIGHT = Stream.of(
            Block.box(0, 13, 0, 16, 16, 16),
            Block.box(1, 0, 10, 4, 13, 13),
            Block.box(12, 0, 10, 15, 13, 13),
            Block.box(1, 8, 0, 15, 13, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //太师椅
    public static final VoxelShape TAISHI_CHAIR_NORTH = Stream.of(
            Block.box(0.3500000000000014, 1.9, 1, 1.3500000000000014, 2.9, 15),
            Block.box(14.650000000000006, 1.9, 1, 15.650000000000006, 2.9, 15),
            Block.box(0, 6, 0, 16, 8, 16),
            Block.box(0.5, 8, 0.5, 15.5, 9, 15.5),
            Block.box(0.3500000000000014, 13.75, 2.5, 1.3500000000000014, 14.75, 14.5),
            Block.box(0.3500000000000014, 9, 2.5, 1.3500000000000014, 13.75, 3.5),
            Block.box(0.3500000000000014, 8.9, 3.3500000000000014, 1.3500000000000014, 13.9, 14.600000000000001),
            Block.box(14.650000000000006, 13.75, 2.5, 15.650000000000006, 14.75, 14.5),
            Block.box(14.650000000000006, 9, 2.5, 15.650000000000006, 13.75, 3.5),
            Block.box(14.650000000000006, 8.9, 3.3500000000000014, 15.650000000000006, 13.9, 14.600000000000001),
            Block.box(5, 10.5, 14.5, 11, 23.5, 15.5),
            Block.box(10, 8.5, 14.5, 11, 10.5, 15.5),
            Block.box(0.3500000000000014, 9, 14.5, 1.3500000000000014, 20, 15.5),
            Block.box(1, 8.499999999999998, 14.5, 5.5, 21.5, 15.5),
            Block.box(11, 21.4, 14.5, 13.5, 22.4, 15.5),
            Block.box(10.5, 8.499999999999998, 14.5, 15, 21.5, 15.5),
            Block.box(14.650000000000006, 9, 14.5, 15.650000000000006, 20, 15.5),
            Block.box(5, 8.5, 14.5, 6, 10.5, 15.5),
            Block.box(0.25, 0, 0.25, 2.25, 8, 2.25),
            Block.box(0.25, 0, 13.75, 2.25, 8, 15.75),
            Block.box(13.75, 0, 13.75, 15.75, 8, 15.75),
            Block.box(1, 1.9, 14.649999999999999, 15, 2.9, 15.649999999999999),
            Block.box(1, 1.9, 0.3500000000000014, 15, 2.9, 1.3500000000000014),
            Block.box(2.5, 21.4, 14.5, 5, 22.4, 15.5),
            Block.box(13.75, 0, 0.25, 15.75, 8, 2.25)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape TAISHI_CHAIR_EAST = Stream.of(
            Block.box(1.0000000000000036, 1.9, 0.34999999999999787, 15.000000000000004, 2.9, 1.3499999999999979),
            Block.box(1.0000000000000036, 1.9, 14.650000000000002, 15.000000000000004, 2.9, 15.650000000000002),
            Block.box(3.552713678800501e-15, 6, -3.552713678800501e-15, 16.000000000000004, 8, 15.999999999999996),
            Block.box(0.5000000000000036, 8, 0.49999999999999645, 15.500000000000004, 9, 15.499999999999996),
            Block.box(1.5000000000000036, 13.75, 0.34999999999999787, 13.500000000000004, 14.75, 1.3499999999999979),
            Block.box(12.500000000000004, 9, 0.34999999999999787, 13.500000000000004, 13.75, 1.3499999999999979),
            Block.box(1.4000000000000021, 8.9, 0.34999999999999787, 12.650000000000002, 13.9, 1.3499999999999979),
            Block.box(1.5000000000000036, 13.75, 14.650000000000002, 13.500000000000004, 14.75, 15.650000000000002),
            Block.box(12.500000000000004, 9, 14.650000000000002, 13.500000000000004, 13.75, 15.650000000000002),
            Block.box(1.4000000000000021, 8.9, 14.650000000000002, 12.650000000000002, 13.9, 15.650000000000002),
            Block.box(0.5000000000000036, 10.5, 4.9999999999999964, 1.5000000000000036, 23.5, 10.999999999999996),
            Block.box(0.5000000000000036, 8.5, 9.999999999999996, 1.5000000000000036, 10.5, 10.999999999999996),
            Block.box(0.5000000000000036, 9, 0.34999999999999787, 1.5000000000000036, 20, 1.3499999999999979),
            Block.box(0.5000000000000036, 8.499999999999998, 0.9999999999999964, 1.5000000000000036, 21.5, 5.4999999999999964),
            Block.box(0.5000000000000036, 21.4, 10.999999999999996, 1.5000000000000036, 22.4, 13.499999999999996),
            Block.box(0.5000000000000036, 8.499999999999998, 10.499999999999996, 1.5000000000000036, 21.5, 14.999999999999996),
            Block.box(0.5000000000000036, 9, 14.650000000000002, 1.5000000000000036, 20, 15.650000000000002),
            Block.box(0.5000000000000036, 8.5, 4.9999999999999964, 1.5000000000000036, 10.5, 5.9999999999999964),
            Block.box(13.750000000000004, 0, 0.24999999999999645, 15.750000000000004, 8, 2.2499999999999964),
            Block.box(0.25000000000000355, 0, 0.24999999999999645, 2.2500000000000036, 8, 2.2499999999999964),
            Block.box(0.25000000000000355, 0, 13.749999999999996, 2.2500000000000036, 8, 15.749999999999996),
            Block.box(0.350000000000005, 1.9, 0.9999999999999964, 1.350000000000005, 2.9, 14.999999999999996),
            Block.box(14.650000000000002, 1.9, 0.9999999999999964, 15.650000000000002, 2.9, 14.999999999999996),
            Block.box(0.5000000000000036, 21.4, 2.4999999999999964, 1.5000000000000036, 22.4, 4.9999999999999964),
            Block.box(13.750000000000004, 0, 13.749999999999996, 15.750000000000004, 8, 15.749999999999996)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape TAISHI_CHAIR_SOUTH = Stream.of(
            Block.box(14.650000000000006, 1.9, 1, 15.650000000000006, 2.9, 15),
            Block.box(0.3500000000000014, 1.9, 1, 1.3500000000000014, 2.9, 15),
            Block.box(7.105427357601002e-15, 6, 0, 16.000000000000007, 8, 16),
            Block.box(0.5000000000000071, 8, 0.5, 15.500000000000007, 9, 15.5),
            Block.box(14.650000000000006, 13.75, 1.5, 15.650000000000006, 14.75, 13.5),
            Block.box(14.650000000000006, 9, 12.5, 15.650000000000006, 13.75, 13.5),
            Block.box(14.650000000000006, 8.9, 1.3999999999999986, 15.650000000000006, 13.9, 12.649999999999999),
            Block.box(0.3500000000000014, 13.75, 1.5, 1.3500000000000014, 14.75, 13.5),
            Block.box(0.3500000000000014, 9, 12.5, 1.3500000000000014, 13.75, 13.5),
            Block.box(0.3500000000000014, 8.9, 1.3999999999999986, 1.3500000000000014, 13.9, 12.649999999999999),
            Block.box(5.000000000000007, 10.5, 0.5, 11.000000000000007, 23.5, 1.5),
            Block.box(5.000000000000007, 8.5, 0.5, 6.000000000000007, 10.5, 1.5),
            Block.box(14.650000000000006, 9, 0.5, 15.650000000000006, 20, 1.5),
            Block.box(10.500000000000007, 8.499999999999998, 0.5, 15.000000000000007, 21.5, 1.5),
            Block.box(2.500000000000007, 21.4, 0.5, 5.000000000000007, 22.4, 1.5),
            Block.box(1.000000000000007, 8.499999999999998, 0.5, 5.500000000000007, 21.5, 1.5),
            Block.box(0.3500000000000014, 9, 0.5, 1.3500000000000014, 20, 1.5),
            Block.box(10.000000000000007, 8.5, 0.5, 11.000000000000007, 10.5, 1.5),
            Block.box(13.750000000000007, 0, 13.75, 15.750000000000007, 8, 15.75),
            Block.box(13.750000000000007, 0, 0.25, 15.750000000000007, 8, 2.25),
            Block.box(0.2500000000000071, 0, 0.25, 2.250000000000007, 8, 2.25),
            Block.box(1.000000000000007, 1.9, 0.3500000000000014, 15.000000000000007, 2.9, 1.3500000000000014),
            Block.box(1.000000000000007, 1.9, 14.649999999999999, 15.000000000000007, 2.9, 15.649999999999999),
            Block.box(11.000000000000007, 21.4, 0.5, 13.500000000000007, 22.4, 1.5),
            Block.box(0.2500000000000071, 0, 13.75, 2.250000000000007, 8, 15.75)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape TAISHI_CHAIR_WEST = Stream.of(
            Block.box(1.0000000000000036, 1.9, 14.650000000000002, 15.000000000000004, 2.9, 15.650000000000002),
            Block.box(1.0000000000000036, 1.9, 0.34999999999999787, 15.000000000000004, 2.9, 1.3499999999999979),
            Block.box(3.552713678800501e-15, 6, 3.552713678800501e-15, 16.000000000000004, 8, 16.000000000000004),
            Block.box(0.5000000000000036, 8, 0.5000000000000036, 15.500000000000004, 9, 15.500000000000004),
            Block.box(2.5000000000000036, 13.75, 14.650000000000002, 14.500000000000004, 14.75, 15.650000000000002),
            Block.box(2.5000000000000036, 9, 14.650000000000002, 3.5000000000000036, 13.75, 15.650000000000002),
            Block.box(3.350000000000005, 8.9, 14.650000000000002, 14.600000000000005, 13.9, 15.650000000000002),
            Block.box(2.5000000000000036, 13.75, 0.34999999999999787, 14.500000000000004, 14.75, 1.3499999999999979),
            Block.box(2.5000000000000036, 9, 0.34999999999999787, 3.5000000000000036, 13.75, 1.3499999999999979),
            Block.box(3.350000000000005, 8.9, 0.34999999999999787, 14.600000000000005, 13.9, 1.3499999999999979),
            Block.box(14.500000000000004, 10.5, 5.0000000000000036, 15.500000000000004, 23.5, 11.000000000000004),
            Block.box(14.500000000000004, 8.5, 5.0000000000000036, 15.500000000000004, 10.5, 6.0000000000000036),
            Block.box(14.500000000000004, 9, 14.650000000000002, 15.500000000000004, 20, 15.650000000000002),
            Block.box(14.500000000000004, 8.499999999999998, 10.500000000000004, 15.500000000000004, 21.5, 15.000000000000004),
            Block.box(14.500000000000004, 21.4, 2.5000000000000036, 15.500000000000004, 22.4, 5.0000000000000036),
            Block.box(14.500000000000004, 8.499999999999998, 1.0000000000000036, 15.500000000000004, 21.5, 5.5000000000000036),
            Block.box(14.500000000000004, 9, 0.34999999999999787, 15.500000000000004, 20, 1.3499999999999979),
            Block.box(14.500000000000004, 8.5, 10.000000000000004, 15.500000000000004, 10.5, 11.000000000000004),
            Block.box(0.25000000000000355, 0, 13.750000000000004, 2.2500000000000036, 8, 15.750000000000004),
            Block.box(13.750000000000004, 0, 13.750000000000004, 15.750000000000004, 8, 15.750000000000004),
            Block.box(13.750000000000004, 0, 0.25000000000000355, 15.750000000000004, 8, 2.2500000000000036),
            Block.box(14.650000000000002, 1.9, 1.0000000000000036, 15.650000000000002, 2.9, 15.000000000000004),
            Block.box(0.350000000000005, 1.9, 1.0000000000000036, 1.350000000000005, 2.9, 15.000000000000004),
            Block.box(14.500000000000004, 21.4, 11.000000000000004, 15.500000000000004, 22.4, 13.500000000000004),
            Block.box(0.25000000000000355, 0, 0.25000000000000355, 2.2500000000000036, 8, 2.2500000000000036)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    //席桌
    public static final VoxelShape LOW_DESK_NORTH = Stream.of(
            Block.box(3, 0, 2, 5, 7, 14),
            Block.box(3, 7, 2, 13, 8, 14),
            Block.box(0.5, 8, 1, 15.5, 10, 15),
            Block.box(11, 0, 2, 13, 7, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape LOW_DESK_EAST = Stream.of(
            Block.box(2, 0, 3, 14, 7, 5),
            Block.box(2, 7, 3, 14, 8, 13),
            Block.box(1, 8, 0.5, 15, 10, 15.5),
            Block.box(2, 0, 11, 14, 7, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape LOW_DESK_SOUTH = Stream.of(
            Block.box(11, 0, 2, 13, 7, 14),
            Block.box(3, 7, 2, 13, 8, 14),
            Block.box(0.5, 8, 1, 15.5, 10, 15),
            Block.box(3, 0, 2, 5, 7, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape LOW_DESK_WEST = Stream.of(
            Block.box(2, 0, 11, 14, 7, 13),
            Block.box(2, 7, 3, 14, 8, 13),
            Block.box(1, 8, 0.5, 15, 10, 15.5),
            Block.box(2, 0, 3, 14, 7, 5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    //席桌左
    public static final VoxelShape LOW_DESK_NORTH_SIDE = Stream.of(
            Block.box(1, 8, 0.5, 16, 10, 15.5),
            Block.box(5, 0, 2, 7, 7, 14),
            Block.box(2, 8, 1, 16, 9, 15),
            Block.box(3, 7, 2, 16, 8, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape LOW_DESK_EAST_SIDE = Stream.of(
            Block.box(0.5, 8, 1, 15.5, 10, 16),
            Block.box(2, 0, 5, 14, 7, 7),
            Block.box(1, 8, 2, 15, 9, 16),
            Block.box(2, 7, 3, 14, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape LOW_DESK_SOUTH_SIDE = Stream.of(
            Block.box(0, 8, 0.5, 15, 10, 15.5),
            Block.box(9, 0, 2, 11, 7, 14),
            Block.box(0, 8, 1, 14, 9, 15),
            Block.box(0, 7, 2, 13, 8, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape LOW_DESK_WEST_SIDE = Stream.of(
            Block.box(0.5, 8, 0, 15.5, 10, 15),
            Block.box(2, 0, 9, 14, 7, 11),
            Block.box(1, 8, 0, 15, 9, 14),
            Block.box(2, 7, 0, 14, 8, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    //席桌中
    public static final VoxelShape LOW_DESK_NORTH_AND_SOUTH_MIDDLE = Shapes.join(Block.box(0, 8, 1, 16, 9, 15), Block.box(0, 7, 2, 16, 8, 14), BooleanOp.OR);
    public static final VoxelShape LOW_DESK_WEST_AND_EAST_MIDDLE = Shapes.join(Block.box(1, 8, 0, 15, 9, 16), Block.box(2, 7, 0, 14, 8, 16), BooleanOp.OR);

    //酒桌
    public static final VoxelShape WINE_TABLE = Stream.of(
            Block.box(13.4, 0, 0, 16, 2.3, 2.6),
            Block.box(13.4, 0, 13.4, 16, 2.3, 16),
            Block.box(0, 0, 13.4, 2.6, 2.3, 16),
            Block.box(0, 0, 0, 2.6, 2.3, 2.6),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(0, 2.3, 0, 2.3, 13.3, 2.3),
            Block.box(0, 2.3, 13.7, 2.3, 13.3, 16),
            Block.box(13.7, 2.3, 0, 16, 13.3, 2.3),
            Block.box(13.7, 2.3, 13.7, 16, 13.3, 16),
            Block.box(1, 14.3, 1, 15, 15.3, 15),
            Block.box(0, 13.3, 0, 16, 14.3, 16),
            Block.box(0, 9.3, 0, 16, 13.3, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape WINE_TABLE_NORTH_SIDE = Stream.of(
            Block.box(13.4, 0, 13.4, 16, 2.3, 16),
            Block.box(13.4, 0, 0, 16, 2.3, 2.6),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(0, 14.3, 1, 15, 15.3, 15),
            Block.box(0, 13.3, 0, 16, 14.3, 16),
            Block.box(0, 9.3, 0, 16, 13.3, 16),
            Block.box(13.7, 2.3, 13.7, 16, 13.3, 16),
            Block.box(13.7, 2.3, 0, 16, 13.3, 2.3)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape WINE_TABLE_EAST_SIDE =Stream.of(
            Block.box(0, 0, 13.399999999999999, 2.6000000000000014, 2.3, 16),
            Block.box(13.399999999999999, 0, 13.399999999999999, 16, 2.3, 16),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(1, 14.3, 0, 15, 15.3, 15),
            Block.box(0, 13.3, 0, 16, 14.3, 16),
            Block.box(0, 9.3, 0, 16, 13.3, 16),
            Block.box(0, 2.3, 13.7, 2.3000000000000007, 13.3, 16),
            Block.box(13.7, 2.3, 13.7, 16, 13.3, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape WINE_TABLE_SOUTH_SIDE = Stream.of(
            Block.box(0, 0, 0, 2.6000000000000014, 2.3, 2.6000000000000014),
            Block.box(0, 0, 13.399999999999999, 2.6000000000000014, 2.3, 16),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(1, 14.3, 1, 16, 15.3, 15),
            Block.box(0, 13.3, 0, 16, 14.3, 16),
            Block.box(0, 9.3, 0, 16, 13.3, 16),
            Block.box(0, 2.3, 0, 2.3000000000000007, 13.3, 2.3000000000000007),
            Block.box(0, 2.3, 13.7, 2.3000000000000007, 13.3, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape WINE_TABLE_WEST_SIDE = Stream.of(
            Block.box(13.399999999999999, 0, 0, 16, 2.3, 2.6000000000000014),
            Block.box(0, 0, 0, 2.6000000000000014, 2.3, 2.6000000000000014),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(1, 14.3, 1, 15, 15.3, 16),
            Block.box(0, 13.3, 0, 16, 14.3, 16),
            Block.box(0, 9.3, 0, 16, 13.3, 16),
            Block.box(13.700000000000003, 2.3, 0, 16, 13.3, 2.3000000000000007),
            Block.box(0, 2.3, 0, 2.299999999999997, 13.3, 2.3000000000000007)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    //左右
    public static final VoxelShape WINE_TABLE_NORTH_SOUTH_SIDE = Stream.of(
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(0, 14.3, 1, 16, 15.3, 15),
            Block.box(0, 13.3, 0, 16, 14.3, 16),
            Block.box(0, 9.3, 0, 16, 13.3, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape WINE_TABLE_EAST_WEST_SIDE = Stream.of(
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(1, 14.3, 0, 15, 15.3, 16),
            Block.box(0, 13.3, 0, 16, 14.3, 16),
            Block.box(0, 9.3, 0, 16, 13.3, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //边角
    public static final VoxelShape WINE_TABLE_NORTH_EAST_SIDE = Stream.of(
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(0, 14.3, 0, 15, 15.3, 15),
            Block.box(0, 13.3, 0, 16, 14.3, 16),
            Block.box(0, 9.3, 0, 16, 13.3, 16),
            Block.box(13.4, 0, 13.4, 16, 2.3, 16),
            Block.box(13.7, 2.3, 13.7, 16, 13.3, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape WINE_TABLE_NORTH_WEST_SIDE = Stream.of(
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(1, 14.3, 1, 16, 15.3, 16),
            Block.box(0, 13.3, 0, 16, 14.3, 16),
            Block.box(0, 9.3, 0, 16, 13.3, 16),
            Block.box(0, 0, 0, 2.5999999999999996, 2.3, 2.5999999999999996),
            Block.box(0, 2.3, 0, 2.3000000000000007, 13.3, 2.3000000000000007)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape WINE_TABLE_SOUTH_EAST_SIDE = Stream.of(
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(1, 14.3, 0, 16, 15.3, 15),
            Block.box(0, 13.3, 0, 16, 14.3, 16),
            Block.box(0, 9.3, 0, 16, 13.3, 16),
            Block.box(0, 0, 13.4, 2.5999999999999996, 2.3, 16),
            Block.box(0, 2.3, 13.7, 2.3000000000000007, 13.3, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape WINE_TABLE_SOUTH_WEST_SIDE = Stream.of(
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(0, 14.3, 1, 15, 15.3, 16),
            Block.box(0, 13.3, 0, 16, 14.3, 16),
            Block.box(0, 9.3, 0, 16, 13.3, 16),
            Block.box(13.399999999999999, 0, 0, 16, 2.3, 2.5999999999999996),
            Block.box(13.7, 2.3, 0, 16, 13.3, 2.3000000000000007)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //中边
    public static final VoxelShape WINE_TABLE_MIDDLE_SIDE = Stream.of(
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(0, 14.3, 1, 16, 15.3, 15),
            Block.box(0, 13.3, 0, 16, 14.3, 16),
            Block.box(0, 9.3, 0, 16, 13.3, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape WINE_TABLE_MIDDLE_SIDE_1 = Stream.of(
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(1, 14.3, 0, 15, 15.3, 16),
            Block.box(0, 13.3, 0, 16, 14.3, 16),
            Block.box(0, 9.3, 0, 16, 13.3, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    //中间
    public static final VoxelShape WINE_TABLE_MIDDLE = Block.box(0, 15, 0, 16, 16, 16);


}
