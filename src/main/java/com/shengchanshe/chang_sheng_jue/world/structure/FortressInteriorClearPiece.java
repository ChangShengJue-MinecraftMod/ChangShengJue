package com.shengchanshe.chang_sheng_jue.world.structure;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;

public class FortressInteriorClearPiece extends StructurePiece {
    private static final int HORIZONTAL_PADDING = 4;
    private static final int CLEAR_HEIGHT = 24;
    private static final int FOUNDATION_DEPTH = 4;
    private static final BlockState BLUE_STONE_BRICKS = com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks.BLUE_STONE_BRICKS.get().defaultBlockState();
    private static final BlockState TOP_STATE = Blocks.GRASS_BLOCK.defaultBlockState();
    private static final BlockState FILL_STATE = Blocks.DIRT.defaultBlockState();

    private final int floorY;

    public FortressInteriorClearPiece(BoundingBox structureBounds) {
        this(new BoundingBox(
                structureBounds.minX() + HORIZONTAL_PADDING,
                structureBounds.minY(),
                structureBounds.minZ() + HORIZONTAL_PADDING,
                structureBounds.maxX() - HORIZONTAL_PADDING,
                structureBounds.maxY(),
                structureBounds.maxZ() - HORIZONTAL_PADDING
        ), structureBounds.minY());
    }

    private FortressInteriorClearPiece(BoundingBox boundingBox, int floorY) {
        super(CSJStructurePieceTypes.FORTRESS_INTERIOR_CLEAR.get(), 0, boundingBox);
        this.floorY = floorY;
    }

    public FortressInteriorClearPiece(StructurePieceSerializationContext context, CompoundTag tag) {
        super(CSJStructurePieceTypes.FORTRESS_INTERIOR_CLEAR.get(), tag);
        this.floorY = tag.getInt("FloorY");
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag tag) {
        tag.putInt("FloorY", this.floorY);
    }

    @Override
    public void postProcess(WorldGenLevel level,
                            StructureManager structureManager,
                            ChunkGenerator chunkGenerator,
                            RandomSource random,
                            BoundingBox chunkBox,
                            ChunkPos chunkPos,
                            BlockPos pivot) {
        if (this.boundingBox.minX() > this.boundingBox.maxX() || this.boundingBox.minZ() > this.boundingBox.maxZ()) {
            return;
        }

        int maxY = Math.min(level.getMaxBuildHeight() - 1, this.floorY + CLEAR_HEIGHT);
        int minY = Math.max(level.getMinBuildHeight(), this.floorY - FOUNDATION_DEPTH + 1);
        for (int x = Math.max(this.boundingBox.minX(), chunkBox.minX()); x <= Math.min(this.boundingBox.maxX(), chunkBox.maxX()); x++) {
            for (int z = Math.max(this.boundingBox.minZ(), chunkBox.minZ()); z <= Math.min(this.boundingBox.maxZ(), chunkBox.maxZ()); z++) {
                for (int y = maxY; y >= this.floorY; y--) {
                    BlockPos pos = new BlockPos(x, y, z);
                    BlockState state = level.getBlockState(pos);
                    if (isWaterlogged(state)) {
                        level.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, false), 2);
                    } else if (canClear(state)) {
                        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    }
                }

                for (int y = this.floorY; y >= minY; y--) {
                    BlockPos pos = new BlockPos(x, y, z);
                    BlockState existingState = level.getBlockState(pos);
                    if (!canReplaceGround(existingState)) {
                        if (y == this.floorY) {
                            break;
                        }
                        continue;
                    }
                    BlockState surfaceState = y == this.floorY ? TOP_STATE : FILL_STATE;
                    level.setBlock(pos, surfaceState, 2);
                }
            }
        }
    }

    private static boolean canClear(BlockState state) {
        return isNaturalTerrain(state) || isNaturalSurfaceCover(state);
    }

    private static boolean canReplaceGround(BlockState state) {
        return state.isAir() || isNaturalTerrain(state) || isNaturalSurfaceCover(state);
    }

    private static boolean isWaterlogged(BlockState state) {
        return state.getBlock() instanceof SimpleWaterloggedBlock
                && state.hasProperty(BlockStateProperties.WATERLOGGED)
                && state.getValue(BlockStateProperties.WATERLOGGED);
    }

    private static boolean isNaturalTerrain(BlockState state) {
        return !state.is(BLUE_STONE_BRICKS.getBlock())
                && (state.is(Blocks.LAVA)
                || state.is(Blocks.SNOW)
                || state.is(Blocks.DIRT)
                || state.is(Blocks.GRASS_BLOCK)
                || state.is(Blocks.STONE)
                || state.is(Blocks.GRAVEL)
                || state.is(Blocks.SAND)
                || state.is(Blocks.RED_SAND)
                || state.is(Blocks.CLAY)
                || state.is(Blocks.MUD)
                || state.is(Blocks.MUDDY_MANGROVE_ROOTS));
    }

    private static boolean isNaturalSurfaceCover(BlockState state) {
        return !state.is(BLUE_STONE_BRICKS.getBlock())
                && (state.is(Blocks.ICE)
                || state.is(Blocks.PACKED_ICE)
                || state.is(Blocks.BLUE_ICE));
    }
}
//还没有单独削城墙外侧的山体
//还没有按不规则墙线精确识别“真正的城内”，目前是按整座堡垒总包围盒内缩后的矩形区域清场
