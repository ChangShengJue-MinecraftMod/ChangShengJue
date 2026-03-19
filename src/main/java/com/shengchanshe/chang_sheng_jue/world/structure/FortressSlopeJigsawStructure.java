package com.shengchanshe.chang_sheng_jue.world.structure;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.Optional;

public class FortressSlopeJigsawStructure extends Structure {
    private static final int MAX_INNER_TERRAIN_HEIGHT_DELTA = 18;
    private static final int MAX_OUTER_WALL_RISE_ABOVE_CENTER = 4;
    private static final int MAX_OUTER_WALL_DROP_BELOW_CENTER = 6;
    private static final int MAX_TERRAIN_DROP_BELOW_CENTER = 28;
    private static final int FOUNDATION_SAMPLE_RADIUS = 40;
    private static final int OUTER_SAMPLE_EDGE_OFFSET_DIVISOR = 2;

    public static final Codec<FortressSlopeJigsawStructure> CODEC =
            RecordCodecBuilder.create((RecordCodecBuilder.Instance<FortressSlopeJigsawStructure> instance) ->
                    instance.group(
                            Structure.settingsCodec(instance),
                            StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                            ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                            Codec.intRange(0, 7).fieldOf("size").forGetter(structure -> structure.size),
                            HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                            Codec.BOOL.fieldOf("use_expansion_hack").forGetter(structure -> structure.useExpansionHack),
                            Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(structure -> structure.projectStartToHeightmap),
                            Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter)
                    ).apply(instance, FortressSlopeJigsawStructure::new));

    private final Holder<StructureTemplatePool> startPool;
    private final Optional<ResourceLocation> startJigsawName;
    private final int size;
    private final HeightProvider startHeight;
    private final boolean useExpansionHack;
    private final Optional<Heightmap.Types> projectStartToHeightmap;
    private final int maxDistanceFromCenter;

    public FortressSlopeJigsawStructure(StructureSettings settings, Holder<StructureTemplatePool> startPool,
                                        Optional<ResourceLocation> startJigsawName,
                                        int size, HeightProvider startHeight, boolean useExpansionHack,
                                        Optional<Heightmap.Types> projectStartToHeightmap, int maxDistanceFromCenter) {
        super(settings);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.size = size;
        this.startHeight = startHeight;
        this.useExpansionHack = useExpansionHack;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxDistanceFromCenter;
    }

    @Override
    protected Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        BlockPos center = context.chunkPos().getMiddleBlockPosition(0);
        int sampleRadius = Math.min(this.maxDistanceFromCenter, FOUNDATION_SAMPLE_RADIUS);
        if (!isFortressTerrainValid(context, center, sampleRadius)) {
            return Optional.empty();
        }

        Optional<GenerationStub> generationStub = JigsawPlacement.addPieces(
                context,
                this.startPool,
                this.startJigsawName,
                this.size,
                center,
                this.useExpansionHack,
                this.projectStartToHeightmap,
                this.maxDistanceFromCenter
        );
        if (generationStub.isEmpty()) {
            return Optional.empty();
        }

        StructurePiecesBuilder piecesBuilder = generationStub.get().getPiecesBuilder();
        BoundingBox structureBounds = piecesBuilder.getBoundingBox();
        piecesBuilder.addPiece(new FortressInteriorClearPiece(structureBounds));
        return Optional.of(new GenerationStub(generationStub.get().position(), Either.right(piecesBuilder)));
    }

    @Override
    public StructureType<?> type() {
        return CSJStructureTypes.FORTRESS_SLOPE_JIGSAW.get();
    }

    private static boolean isFortressTerrainValid(GenerationContext context, BlockPos center, int radius) {
        ChunkGenerator generator = context.chunkGenerator();
        LevelHeightAccessor heightAccessor = context.heightAccessor();
        RandomState randomState = context.randomState();
        int innerRadius = Math.max(8, radius / 2);
        int centerX = center.getX();
        int centerZ = center.getZ();
        int centerHeight = generator.getBaseHeight(
                centerX,
                centerZ,
                Heightmap.Types.WORLD_SURFACE_WG,
                heightAccessor,
                randomState
        );
        int edgeMidOffset = Math.max(8, radius / OUTER_SAMPLE_EDGE_OFFSET_DIVISOR);

        if (!isOuterWallClear(generator, heightAccessor, randomState, centerX, centerZ, centerHeight, radius, edgeMidOffset)) {
            return false;
        }

        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        int surfaceY = getSurfaceHeight(generator, heightAccessor, randomState, centerX - innerRadius, centerZ - innerRadius);
        minHeight = Math.min(minHeight, surfaceY);
        maxHeight = Math.max(maxHeight, surfaceY);
        if (centerHeight - surfaceY > MAX_TERRAIN_DROP_BELOW_CENTER) {
            return false;
        }
        surfaceY = getSurfaceHeight(generator, heightAccessor, randomState, centerX - innerRadius, centerZ);
        minHeight = Math.min(minHeight, surfaceY);
        maxHeight = Math.max(maxHeight, surfaceY);
        if (centerHeight - surfaceY > MAX_TERRAIN_DROP_BELOW_CENTER || maxHeight - minHeight > MAX_INNER_TERRAIN_HEIGHT_DELTA) {
            return false;
        }
        surfaceY = getSurfaceHeight(generator, heightAccessor, randomState, centerX - innerRadius, centerZ + innerRadius);
        minHeight = Math.min(minHeight, surfaceY);
        maxHeight = Math.max(maxHeight, surfaceY);
        if (centerHeight - surfaceY > MAX_TERRAIN_DROP_BELOW_CENTER || maxHeight - minHeight > MAX_INNER_TERRAIN_HEIGHT_DELTA) {
            return false;
        }
        surfaceY = getSurfaceHeight(generator, heightAccessor, randomState, centerX, centerZ - innerRadius);
        minHeight = Math.min(minHeight, surfaceY);
        maxHeight = Math.max(maxHeight, surfaceY);
        if (centerHeight - surfaceY > MAX_TERRAIN_DROP_BELOW_CENTER || maxHeight - minHeight > MAX_INNER_TERRAIN_HEIGHT_DELTA) {
            return false;
        }
        surfaceY = centerHeight;
        minHeight = Math.min(minHeight, surfaceY);
        maxHeight = Math.max(maxHeight, surfaceY);
        if (maxHeight - minHeight > MAX_INNER_TERRAIN_HEIGHT_DELTA) {
            return false;
        }
        surfaceY = getSurfaceHeight(generator, heightAccessor, randomState, centerX, centerZ + innerRadius);
        minHeight = Math.min(minHeight, surfaceY);
        maxHeight = Math.max(maxHeight, surfaceY);
        if (centerHeight - surfaceY > MAX_TERRAIN_DROP_BELOW_CENTER || maxHeight - minHeight > MAX_INNER_TERRAIN_HEIGHT_DELTA) {
            return false;
        }
        surfaceY = getSurfaceHeight(generator, heightAccessor, randomState, centerX + innerRadius, centerZ - innerRadius);
        minHeight = Math.min(minHeight, surfaceY);
        maxHeight = Math.max(maxHeight, surfaceY);
        if (centerHeight - surfaceY > MAX_TERRAIN_DROP_BELOW_CENTER || maxHeight - minHeight > MAX_INNER_TERRAIN_HEIGHT_DELTA) {
            return false;
        }
        surfaceY = getSurfaceHeight(generator, heightAccessor, randomState, centerX + innerRadius, centerZ);
        minHeight = Math.min(minHeight, surfaceY);
        maxHeight = Math.max(maxHeight, surfaceY);
        if (centerHeight - surfaceY > MAX_TERRAIN_DROP_BELOW_CENTER || maxHeight - minHeight > MAX_INNER_TERRAIN_HEIGHT_DELTA) {
            return false;
        }
        surfaceY = getSurfaceHeight(generator, heightAccessor, randomState, centerX + innerRadius, centerZ + innerRadius);
        minHeight = Math.min(minHeight, surfaceY);
        maxHeight = Math.max(maxHeight, surfaceY);
        if (centerHeight - surfaceY > MAX_TERRAIN_DROP_BELOW_CENTER || maxHeight - minHeight > MAX_INNER_TERRAIN_HEIGHT_DELTA) {
            return false;
        }

        return true;
    }

    private static boolean isOuterWallClear(ChunkGenerator generator,
                                            LevelHeightAccessor heightAccessor,
                                            RandomState randomState,
                                            int centerX,
                                            int centerZ,
                                            int centerHeight,
                                            int radius,
                                            int edgeMidOffset) {
        return isOuterWallPointClear(generator, heightAccessor, randomState, centerX - radius, centerZ - radius, centerHeight)
                && isOuterWallPointClear(generator, heightAccessor, randomState, centerX, centerZ - radius, centerHeight)
                && isOuterWallPointClear(generator, heightAccessor, randomState, centerX + radius, centerZ - radius, centerHeight)
                && isOuterWallPointClear(generator, heightAccessor, randomState, centerX - radius, centerZ, centerHeight)
                && isOuterWallPointClear(generator, heightAccessor, randomState, centerX + radius, centerZ, centerHeight)
                && isOuterWallPointClear(generator, heightAccessor, randomState, centerX - radius, centerZ + radius, centerHeight)
                && isOuterWallPointClear(generator, heightAccessor, randomState, centerX, centerZ + radius, centerHeight)
                && isOuterWallPointClear(generator, heightAccessor, randomState, centerX + radius, centerZ + radius, centerHeight)
                && isOuterWallPointClear(generator, heightAccessor, randomState, centerX - edgeMidOffset, centerZ - radius, centerHeight)
                && isOuterWallPointClear(generator, heightAccessor, randomState, centerX + edgeMidOffset, centerZ - radius, centerHeight)
                && isOuterWallPointClear(generator, heightAccessor, randomState, centerX - edgeMidOffset, centerZ + radius, centerHeight)
                && isOuterWallPointClear(generator, heightAccessor, randomState, centerX + edgeMidOffset, centerZ + radius, centerHeight);
    }

    private static boolean isOuterWallPointClear(ChunkGenerator generator,
                                                 LevelHeightAccessor heightAccessor,
                                                 RandomState randomState,
                                                 int sampleX,
                                                 int sampleZ,
                                                 int centerHeight) {
        int surfaceY = getSurfaceHeight(generator, heightAccessor, randomState, sampleX, sampleZ);
        return surfaceY - centerHeight <= MAX_OUTER_WALL_RISE_ABOVE_CENTER
                && centerHeight - surfaceY <= MAX_OUTER_WALL_DROP_BELOW_CENTER;
    }

    private static int getSurfaceHeight(ChunkGenerator generator,
                                        LevelHeightAccessor heightAccessor,
                                        RandomState randomState,
                                        int sampleX,
                                        int sampleZ) {
        return generator.getBaseHeight(
                sampleX,
                sampleZ,
                Heightmap.Types.WORLD_SURFACE_WG,
                heightAccessor,
                randomState
        );
    }
}
