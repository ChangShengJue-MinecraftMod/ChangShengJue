//package com.shengchanshe.changshengjue.util;
//
//import net.minecraft.core.Direction;
//import net.minecraft.world.phys.AABB;
//import net.minecraft.world.phys.shapes.BooleanOp;
//import net.minecraft.world.phys.shapes.Shapes;
//import net.minecraft.world.phys.shapes.VoxelShape;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class VoxelShapeUtil {
//    public static VoxelShape rotateVoxelShape(VoxelShape shape, Direction.Axis axis, int angleDegrees) {
//        VoxelShape[] rotatedShape = new VoxelShape[]{Shapes.empty()};
//
//        // 遍历每个 AABB（盒子）并旋转
//        shape.forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> {
//            AABB rotatedBox = rotateAABB(new AABB(minX, minY, minZ, maxX, maxY, maxZ), axis, angleDegrees);
//            rotatedShape[0] = Shapes.or(rotatedShape[0], Shapes.create(rotatedBox));
//        });
//
//        return rotatedShape[0];
//    }
//
//    public static VoxelShape rotateVoxelShapeAroundY(VoxelShape shape, double degrees) {
//        List<AABB> boxes = shape.toAabbs();
//        List<AABB> rotatedBoxes = new ArrayList<>();
//
//        double radians = Math.toRadians(degrees);
//        double sin = Math.sin(radians);
//        double cos = Math.cos(radians);
//
//        for (AABB box : boxes) {
//            // 计算出方块的中心
//            double centerX = box.minX + box.getXsize() / 2;
//            double centerZ = box.minZ + box.getZsize() / 2;
//
//            // 获取盒子的8个顶点，并分别旋转
//            double[] xs = {box.minX - centerX, box.maxX - centerX};
//            double[] zs = {box.minZ - centerZ, box.maxZ - centerZ};
//            double minX = Double.POSITIVE_INFINITY, minZ = Double.POSITIVE_INFINITY, maxX = Double.NEGATIVE_INFINITY, maxZ = Double.NEGATIVE_INFINITY;
//
//            for (double x : xs) {
//                for (double z : zs) {
//                    double newX = x * cos - z * sin;
//                    double newZ = x * sin + z * cos;
//                    minX = Math.min(minX, newX);
//                    minZ = Math.min(minZ, newZ);
//                    maxX = Math.max(maxX, newX);
//                    maxZ = Math.max(maxZ, newZ);
//                }
//            }
//
//            // 将旋转后的盒子的中心移动回原来的位置
//            minX += centerX;
//            minZ += centerZ;
//            maxX += centerX;
//            maxZ += centerZ;
//
//            // 创建一个新的盒子，并添加到列表中
//            rotatedBoxes.add(new AABB(minX, box.minY, minZ, maxX, box.maxY, maxZ));
//        }
//
//        // 使用新的盒子列表创建一个新的 VoxelShape
//        VoxelShape rotatedShape = Shapes.empty();
//        for (AABB box : rotatedBoxes) {
//            rotatedShape = Shapes.joinUnoptimized(rotatedShape, Shapes.create(box), BooleanOp.OR);
//        }
//        return rotatedShape.optimize();
//    }
//
//    private static AABB rotateAABB(AABB box, Direction.Axis axis, int angleDegrees) {
//        double radians = Math.toRadians(angleDegrees);
//        double sin = Math.sin(radians);
//        double cos = Math.cos(radians);
//
//        // 原始盒子的坐标
//        double minX = box.minX, minY = box.minY, minZ = box.minZ;
//        double maxX = box.maxX, maxY = box.maxY, maxZ = box.maxZ;
//
//        switch (axis) {
//            case Y -> {
//                // 绕 Y 轴旋转，影响 X 和 Z 坐标
//                return new AABB(
//                        rotateX(minX, minZ, cos, sin), minY, rotateZ(minX, minZ, cos, sin),
//                        rotateX(maxX, maxZ, cos, sin), maxY, rotateZ(maxX, maxZ, cos, sin)
//                );
//            }
//            case X -> {
//                // 绕 X 轴旋转，影响 Y 和 Z 坐标
//                return new AABB(
//                        minX, rotateX(minY, minZ, cos, sin), rotateZ(minY, minZ, cos, sin),
//                        maxX, rotateX(maxY, maxZ, cos, sin), rotateZ(maxY, maxZ, cos, sin)
//                );
//            }
//            case Z -> {
//                // 绕 Z 轴旋转，影响 X 和 Y 坐标
//                return new AABB(
//                        rotateX(minX, minY, cos, sin), rotateZ(minX, minY, cos, sin), minZ,
//                        rotateX(maxX, maxY, cos, sin), rotateZ(maxX, maxY, cos, sin), maxZ
//                );
//            }
//            default -> throw new IllegalArgumentException("Invalid axis for rotation");
//        }
//    }
//
//    private static double rotateX(double x, double z, double cos, double sin) {
//        return x * cos - z * sin;
//    }
//
//    private static double rotateZ(double x, double z, double cos, double sin) {
//        return x * sin + z * cos;
//    }
//}
