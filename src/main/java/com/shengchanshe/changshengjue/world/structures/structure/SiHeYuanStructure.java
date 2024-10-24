package com.shengchanshe.changshengjue.world.structures.structure;

import com.mojang.serialization.Codec;
import com.shengchanshe.changshengjue.world.structures.CSJStructureType;
import com.shengchanshe.changshengjue.world.structures.piece.CSJStructurePieces;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

import java.util.Optional;

public class SiHeYuanStructure extends Structure {
    public static final Codec<SiHeYuanStructure> CODEC = simpleCodec(SiHeYuanStructure::new);

    public SiHeYuanStructure(StructureSettings pSettings) {
        super(pSettings);
    }

    @Override
    protected Optional<GenerationStub> findGenerationPoint(GenerationContext pContext) {
        return onTopOfChunkCenter(pContext, Heightmap.Types.WORLD_SURFACE_WG, structurePiecesBuilder -> this.generatePieces(structurePiecesBuilder, pContext));
    }

    private void generatePieces(StructurePiecesBuilder pBuilder, Structure.GenerationContext pContext) {
        ChunkPos chunkpos = pContext.chunkPos();
        WorldgenRandom worldgenrandom = pContext.random();
        int groundY = pContext.chunkGenerator().getFirstOccupiedHeight(chunkpos.getMinBlockX(), chunkpos.getMinBlockZ(), Heightmap.Types.WORLD_SURFACE_WG, pContext.heightAccessor(),pContext.randomState());

        BlockPos blockpos = new BlockPos(chunkpos.getMinBlockX(),groundY, chunkpos.getMinBlockZ());
        Rotation rotation = Rotation.getRandom(worldgenrandom);
        CSJStructurePieces.addPieces(pContext.structureTemplateManager(), blockpos, rotation, pBuilder, worldgenrandom);
    }

    @Override
    public StructureType<?> type() {
        return CSJStructureType.SI_HE_YUAN.get();
    }
}