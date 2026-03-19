package com.shengchanshe.chang_sheng_jue.world.processor;

import com.mojang.serialization.Codec;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class BlueStoneBrickFoundationProcessor extends StructureProcessor {
    private static final int MAX_SOLID_REPLACEMENT_DEPTH = 6;

    public static final BlueStoneBrickFoundationProcessor INSTANCE = new BlueStoneBrickFoundationProcessor();
    public static final Codec<BlueStoneBrickFoundationProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    protected StructureProcessorType<?> getType() {
        return CSJProcessorTypes.BLUE_STONE_BRICK_FOUNDATION.get();
    }

    @Override
    public StructureTemplate.StructureBlockInfo process(LevelReader levelReader,
                                                        BlockPos jigsawPiecePos,
                                                        BlockPos jigsawPieceBottomCenterPos,
                                                        StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                        StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                        StructurePlaceSettings structurePlacementData,
                                                        StructureTemplate template) {
        BlockState foundationState = ChangShengJueBlocks.BLUE_STONE_BRICKS.get().defaultBlockState();
        if (!blockInfoGlobal.state().is(ChangShengJueBlocks.BLUE_STONE_BRICKS.get())) {
            return blockInfoGlobal;
        }
        if (!isFoundationStart(template, blockInfoLocal)) {
            return blockInfoGlobal;
        }

        if (levelReader instanceof WorldGenRegion worldGenRegion
                && !worldGenRegion.getCenter().equals(new ChunkPos(blockInfoGlobal.pos()))) {
            return blockInfoGlobal;
        }

        BlockPos.MutableBlockPos mutablePos = blockInfoGlobal.pos().mutable().move(Direction.DOWN);
        BlockState currentState = levelReader.getBlockState(mutablePos);
        blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), foundationState, blockInfoGlobal.nbt());

        int solidDepth = 0;
        while (mutablePos.getY() > levelReader.getMinBuildHeight()
                && mutablePos.getY() < levelReader.getMaxBuildHeight()) {
            if (currentState.isSolid()) {
                solidDepth++;
                if (solidDepth > MAX_SOLID_REPLACEMENT_DEPTH) {
                    break;
                }
            }

            levelReader.getChunk(mutablePos).setBlockState(mutablePos, foundationState, false);
            mutablePos.move(Direction.DOWN);
            currentState = levelReader.getBlockState(mutablePos);
        }

        return blockInfoGlobal;
    }

    private static boolean isFoundationStart(StructureTemplate template, StructureTemplate.StructureBlockInfo blockInfoLocal) {
        for (StructureTemplate.StructureBlockInfo structureBlockInfo : template.filterBlocks(BlockPos.ZERO, new StructurePlaceSettings(), ChangShengJueBlocks.BLUE_STONE_BRICKS.get(), true)) {
            if (structureBlockInfo.pos().getX() == blockInfoLocal.pos().getX()
                    && structureBlockInfo.pos().getZ() == blockInfoLocal.pos().getZ()
                    && structureBlockInfo.pos().getY() < blockInfoLocal.pos().getY()) {
                return false;
            }
        }
        return true;
    }
}
