package com.shengchanshe.changshengjue.util;

import net.minecraft.core.Direction;
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

    public static final VoxelShape CYLINDER_TILE_BLOCK_N_4 = Stream.of(
            Block.box(0, 0, 0, 16, 8, 16),
            Block.box(8, 8, 8, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_E_4 = Stream.of(
            Block.box(0.11055322985034799, 0, 0.030428986436911387, 16.110553229850346, 8, 16.03042898643691),
            Block.box(0.11055322985034799, 8, 8.030428986436911, 8.110553229850348, 16, 16.03042898643691)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_S_4 = Stream.of(
            Block.box(0.08012424341343838, 0, -0.10901778371274062, 16.080124243413437, 8, 15.890982216287256),
            Block.box(0.08012424341343838, 8, -0.10901778371274062, 8.080124243413437, 16, 7.890982216287259)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CYLINDER_TILE_BLOCK_W_4 = Stream.of(
            Block.box(-0.030428986436907834, 0, -0.13944677014965023, 15.96957101356309, 8, 15.860553229850346),
            Block.box(7.969571013563089, 8, -0.13944677014965023, 15.96957101356309, 16, 7.860553229850348)
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

    //案台
    public static final VoxelShape CHANG_SHENG_JUE_DESK_NORTH = Stream.of(
            Block.box(0, 11.25, 3, 16, 15.25, 5),
            Block.box(0, 11.25, 4, 2, 15.25, 13),
            Block.box(14, 11.25, 4, 16, 15.25, 13),
            Block.box(0, 14.75, 3, 16, 15.75, 13),
            Block.box(0, 3, 3, 2, 15, 5),
            Block.box(0, 3, 11, 2, 15, 13),
            Block.box(0, 0.25, 11, 2, 3.2499999999999996, 13),
            Block.box(0, 0.25, 3, 2, 3.2499999999999996, 5),
            Block.box(14, 0.25, 3, 16, 3.2499999999999996, 5),
            Block.box(14, 0.25, 11, 16, 3.2499999999999996, 13),
            Block.box(14, 3, 11, 16, 15, 13),
            Block.box(14, 3, 3, 16, 15, 5),
            Block.box(1, 16.1, 3, 9, 16.1, 13),
            Block.box(4, 16.200000000000003, 3, 12, 16.200000000000003, 13),
            Block.box(6, 16.300000000000004, 3, 14, 16.300000000000004, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_DESK_EAST = Stream.of(
            Block.box(11, 11.25, 0, 13, 15.25, 16),
            Block.box(3, 11.25, 0, 12, 15.25, 2),
            Block.box(3, 11.25, 14, 12, 15.25, 16),
            Block.box(3, 14.75, 0, 13, 15.75, 16),
            Block.box(11, 3, 0, 13, 15, 2),
            Block.box(3, 3, 0, 5, 15, 2),
            Block.box(3, 0.25, 0, 5, 3.2499999999999996, 2),
            Block.box(11, 0.25, 0, 13, 3.2499999999999996, 2),
            Block.box(11, 0.25, 14, 13, 3.2499999999999996, 16),
            Block.box(3, 0.25, 14, 5, 3.2499999999999996, 16),
            Block.box(3, 3, 14, 5, 15, 16),
            Block.box(11, 3, 14, 13, 15, 16),
            Block.box(1.9280701703934433, 16.1, 1.6110448348312296, 11.928070170393443, 16.1, 9.61104483483123),
            Block.box(3, 16.200000000000003, 4, 13, 16.200000000000003, 12),
            Block.box(4.707106781186548, 16.300000000000004, 6.121320343559643, 14.707106781186548, 16.300000000000004, 14.121320343559642)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_DESK_SOUTH = Stream.of(
            Block.box(0, 11.25, 11, 16, 15.25, 13),
            Block.box(14, 11.25, 3, 16, 15.25, 12),
            Block.box(0, 11.25, 3, 2, 15.25, 12),
            Block.box(0, 14.75, 3, 16, 15.75, 13),
            Block.box(14, 3, 11, 16, 15, 13),
            Block.box(14, 3, 3, 16, 15, 5),
            Block.box(14, 0.25, 3, 16, 3.2499999999999996, 5),
            Block.box(14, 0.25, 11, 16, 3.2499999999999996, 13),
            Block.box(0, 0.25, 11, 2, 3.2499999999999996, 13),
            Block.box(0, 0.25, 3, 2, 3.2499999999999996, 5),
            Block.box(0, 3, 3, 2, 15, 5),
            Block.box(0, 3, 11, 2, 15, 13),
            Block.box(6.38895516516877, 16.1, 1.9280701703934433, 14.38895516516877, 16.1, 11.928070170393443),
            Block.box(4, 16.200000000000003, 3, 12, 16.200000000000003, 13),
            Block.box(1.878679656440358, 16.300000000000004, 4.707106781186548, 9.878679656440358, 16.300000000000004, 14.707106781186548)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CHANG_SHENG_JUE_DESK_WEST = Stream.of(
            Block.box(3, 11.25, 0, 5, 15.25, 16),
            Block.box(4, 11.25, 14, 13, 15.25, 16),
            Block.box(4, 11.25, 0, 13, 15.25, 2),
            Block.box(3, 14.75, 0, 13, 15.75, 16),
            Block.box(3, 3, 14, 5, 15, 16),
            Block.box(11, 3, 14, 13, 15, 16),
            Block.box(11, 0.25, 14, 13, 3.2499999999999996, 16),
            Block.box(3, 0.25, 14, 5, 3.2499999999999996, 16),
            Block.box(3, 0.25, 0, 5, 3.2499999999999996, 2),
            Block.box(11, 0.25, 0, 13, 3.2499999999999996, 2),
            Block.box(11, 3, 0, 13, 15, 2),
            Block.box(3, 3, 0, 5, 15, 2),
            Block.box(4.071929829606557, 16.1, 6.38895516516877, 14.071929829606557, 16.1, 14.38895516516877),
            Block.box(3, 16.200000000000003, 4, 13, 16.200000000000003, 12),
            Block.box(1.292893218813452, 16.300000000000004, 1.878679656440358, 11.292893218813452, 16.300000000000004, 9.878679656440358)
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
}
