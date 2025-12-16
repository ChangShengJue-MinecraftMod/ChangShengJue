package com.shengchanshe.chang_sheng_jue.block.custom.furniture.bed;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.CollisionGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CanopyBed extends HorizontalDirectionalBlock {
    public static final EnumProperty<CanopyBedSection> SECTION = EnumProperty.create("section", CanopyBedSection.class);

    private static final Set<BlockPos> BEDS_IN_PROGRESS = Collections.newSetFromMap(new WeakHashMap<>());

    private final Map<BlockPos, Set<LivingEntity>> sleepingEntities = new WeakHashMap<>();

    private static class BedPart {
        public final CanopyBedSection section;
        public final BlockPos offset;

        public BedPart(CanopyBedSection section, BlockPos offset) {
            this.section = section;
            this.offset = offset;
        }
    }

    public CanopyBed(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(SECTION, CanopyBedSection.FOOT_FRONT_BOTTOM));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, SECTION);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getHorizontalDirection();
        BlockPos pos = pContext.getClickedPos();
        Level level = pContext.getLevel();

        if (!canPlaceBed(level, pos, direction)) {
            return null;
        }

        return this.defaultBlockState().setValue(FACING, direction)
                .setValue(SECTION, CanopyBedSection.FOOT_FRONT_BOTTOM);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);

        if (pState.getValue(SECTION) == CanopyBedSection.FOOT_FRONT_BOTTOM &&
                !pLevel.isClientSide &&
                !BEDS_IN_PROGRESS.contains(pPos)) {

            BEDS_IN_PROGRESS.add(pPos);
            try {
                placeAllBedParts(pLevel, pPos, pState.getValue(FACING));
            } finally {
                BEDS_IN_PROGRESS.remove(pPos);
            }
        }
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide && !BEDS_IN_PROGRESS.contains(pPos)) {
            if (pState.hasProperty(FACING) && pState.hasProperty(SECTION)) {
                BlockPos mainPos = findMainBedPart(pLevel, pPos, pState.getValue(FACING), pState.getValue(SECTION));
                if (mainPos != null) {
                    BEDS_IN_PROGRESS.add(pPos);
                    try {
                        wakeUpAllSleepers(pLevel, mainPos, pState.getValue(FACING));

                        boolean isMainPart = pPos.equals(mainPos);

                        for (BedPart part : getBedLayout()) {
                            BlockPos removePos = calculateActualPos(mainPos, part.offset, pState.getValue(FACING));
                            if (!removePos.equals(pPos)) { // 跳过当前方块
                                BlockState state = pLevel.getBlockState(removePos);
                                if (state.getBlock() == this) {
                                    pLevel.setBlock(removePos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                                }
                            }
                        }

                        if (pPlayer.isCreative()) {
                            pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                        } else {
                            if (isMainPart) {
                                super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
                            } else {
                                Block.popResource(pLevel, mainPos, new ItemStack(this));
                                pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                            }
                        }

                    } finally {
                        BEDS_IN_PROGRESS.remove(pPos);
                    }
                    return;
                }
            }
        }

        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    private void wakeUpAllSleepers(Level level, BlockPos mainPos, Direction facing) {
        Set<LivingEntity> sleepers = sleepingEntities.get(mainPos);
        if (sleepers != null) {
            for (LivingEntity sleeper : sleepers) {
                if (sleeper.isSleeping()) {
                    sleeper.stopSleeping();
                }
            }
            sleepingEntities.remove(mainPos);
        }
    }

    private boolean canPlaceBed(Level level, BlockPos startPos, Direction facing) {
        for (BedPart part : getBedLayout()) {
            BlockPos checkPos = calculateActualPos(startPos, part.offset, facing);
            if (!level.getBlockState(checkPos).canBeReplaced()) {
                return false;
            }
        }
        return true;
    }

    private void placeAllBedParts(Level level, BlockPos startPos, Direction facing) {
        for (BedPart part : getBedLayout()) {
            BlockPos placePos = calculateActualPos(startPos, part.offset, facing);
            if (level.getBlockState(placePos).canBeReplaced()) {
                BlockState partState = this.defaultBlockState()
                        .setValue(FACING, facing)
                        .setValue(SECTION, part.section);
                level.setBlock(placePos, partState, Block.UPDATE_ALL);
            }
        }
    }

    private void removeAllBedParts(Level level, BlockPos startPos, Direction facing) {
        for (BedPart part : getBedLayout()) {
            BlockPos removePos = calculateActualPos(startPos, part.offset, facing);
            BlockState state = level.getBlockState(removePos);
            if (state.getBlock() == this) {
                level.setBlock(removePos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
            }
        }
    }

    private BlockPos calculateActualPos(BlockPos startPos, BlockPos offset, Direction facing) {
        int x = offset.getX();
        int y = offset.getY();
        int z = offset.getZ();

        return switch (facing) {
            case SOUTH -> startPos.offset(x, y, z);
            case WEST -> startPos.offset(-z, y, x);
            case EAST -> startPos.offset(z, y, -x);
            default -> startPos.offset(-x, y, -z);
        };
    }

    private List<BedPart> getBedLayout() {
        List<BedPart> layout = new ArrayList<>();

        layout.add(new BedPart(CanopyBedSection.FOOT_FRONT_BOTTOM, new BlockPos(0, 0, 0)));
        layout.add(new BedPart(CanopyBedSection.FOOT_REAR_BOTTOM, new BlockPos(-1, 0, 0)));
        layout.add(new BedPart(CanopyBedSection.BODY_FRONT_BOTTOM, new BlockPos(0, 0, 1)));
        layout.add(new BedPart(CanopyBedSection.BODY_REAR_BOTTOM, new BlockPos(-1, 0, 1)));
        layout.add(new BedPart(CanopyBedSection.HEAD_FRONT_BOTTOM, new BlockPos(0, 0, 2)));
        layout.add(new BedPart(CanopyBedSection.HEAD_REAR_BOTTOM, new BlockPos(-1, 0, 2)));

        layout.add(new BedPart(CanopyBedSection.FOOT_FRONT_MIDDLE, new BlockPos(0, 1, 0)));
        layout.add(new BedPart(CanopyBedSection.FOOT_REAR_MIDDLE, new BlockPos(-1, 1, 0)));
        layout.add(new BedPart(CanopyBedSection.BODY_REAR_MIDDLE, new BlockPos(0, 1, 1)));
        layout.add(new BedPart(CanopyBedSection.HEAD_FRONT_MIDDLE, new BlockPos(0, 1, 2)));
        layout.add(new BedPart(CanopyBedSection.HEAD_REAR_MIDDLE, new BlockPos(-1, 1, 2)));

        layout.add(new BedPart(CanopyBedSection.FOOT_FRONT_TOP, new BlockPos(0, 2, 0)));
        layout.add(new BedPart(CanopyBedSection.FOOT_REAR_TOP, new BlockPos(-1, 2, 0)));
        layout.add(new BedPart(CanopyBedSection.BODY_FRONT_TOP, new BlockPos(0, 2, 1)));
        layout.add(new BedPart(CanopyBedSection.BODY_REAR_TOP, new BlockPos(-1, 2, 1)));
        layout.add(new BedPart(CanopyBedSection.HEAD_FRONT_TOP, new BlockPos(0, 2, 2)));
        layout.add(new BedPart(CanopyBedSection.HEAD_REAR_TOP, new BlockPos(-1, 2, 2)));

        return layout;
    }

    private BlockPos findMainBedPart(Level level, BlockPos pos, Direction facing, CanopyBedSection section) {
        if (section == CanopyBedSection.FOOT_FRONT_BOTTOM) {
            return pos;
        }

        for (BedPart part : getBedLayout()) {
            if (part.section == section) {
                BlockPos mainPos = calculateActualPos(pos, part.offset.multiply(-1), facing);
                if (level.isLoaded(mainPos)) {
                    BlockState mainState = level.getBlockState(mainPos);
                    if (mainState.getBlock() == this && mainState.hasProperty(FACING) && mainState.getValue(SECTION) == CanopyBedSection.FOOT_FRONT_BOTTOM) {
                        return mainPos;
                    }
                }
            }
        }

        return null;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            return InteractionResult.CONSUME;
        }

        BlockPos mainBedPos = findMainBedPart(pLevel, pPos, pState.getValue(FACING), pState.getValue(SECTION));
        if (mainBedPos == null) {
            return InteractionResult.FAIL;
        }

        Direction facing = pState.getValue(FACING);

        if (isBedFull(pLevel, mainBedPos, facing)) {
            pPlayer.displayClientMessage(Component.translatable("block.minecraft.bed.occupied"), true);
            return InteractionResult.FAIL;
        }

        BlockPos sleepBlockPos = determineSleepPosition(pState, mainBedPos, facing, pPos);

        if (isSleepPositionOccupied(pLevel, mainBedPos, facing, sleepBlockPos)) {
            pPlayer.displayClientMessage(net.minecraft.network.chat.Component.translatable("block.minecraft.bed.occupied"), true);
            return InteractionResult.FAIL;
        }

        pPlayer.startSleepInBed(sleepBlockPos).ifLeft((bedSleepingProblem) -> {
            if (bedSleepingProblem.getMessage() != null) {
                pPlayer.displayClientMessage(bedSleepingProblem.getMessage(), true);
            }
        });

        if (pPlayer.isSleeping()) {
            addSleeper(pLevel, mainBedPos, facing, sleepBlockPos, pPlayer);
        }

        return InteractionResult.SUCCESS;
    }

    private boolean isBedFull(Level level, BlockPos mainPos, Direction facing) {
        Set<LivingEntity> sleepers = sleepingEntities.get(mainPos);
        return sleepers != null && sleepers.size() >= 2;
    }

    private boolean isSleepPositionOccupied(Level level, BlockPos mainPos, Direction facing, BlockPos sleepPos) {
        Set<LivingEntity> sleepers = sleepingEntities.get(mainPos);
        if (sleepers != null) {
            for (LivingEntity sleeper : sleepers) {
                BlockPos sleeperPos = sleeper.getSleepingPos().orElse(null);
                if (sleeperPos != null && sleeperPos.equals(sleepPos)) {
                    return true;
                }
            }
        }
        return false;
    }

    private BlockPos determineSleepPosition(BlockState pState, BlockPos mainPos, Direction facing, BlockPos clickedPos) {
        CanopyBedSection section = pState.getValue(SECTION);

        if (section == CanopyBedSection.HEAD_FRONT_BOTTOM || section == CanopyBedSection.BODY_FRONT_BOTTOM) {
            return calculateActualPos(mainPos, new BlockPos(0, 0, 2), facing); // HEAD_FRONT_BOTTOM
        } else if (section == CanopyBedSection.HEAD_REAR_BOTTOM || section == CanopyBedSection.BODY_REAR_BOTTOM) {
            return calculateActualPos(mainPos, new BlockPos(-1, 0, 2), facing); // HEAD_REAR_BOTTOM
        } else {
            return calculateActualPos(mainPos, new BlockPos(0, 0, 2), facing);
        }
    }

    private void addSleeper(Level level, BlockPos mainPos, Direction facing, BlockPos sleepPos, LivingEntity sleeper) {
        sleepingEntities.computeIfAbsent(mainPos, k -> Collections.newSetFromMap(new WeakHashMap<>())).add(sleeper);
    }

    private void removeSleeper(Level level, BlockPos mainPos, LivingEntity sleeper) {
        Set<LivingEntity> sleepers = sleepingEntities.get(mainPos);
        if (sleepers != null) {
            sleepers.remove(sleeper);
            if (sleepers.isEmpty()) {
                sleepingEntities.remove(mainPos);
            }
        }
    }

    @Override
    public void setBedOccupied(BlockState state, Level level, BlockPos pos, LivingEntity sleeper, boolean occupied) {
        if (!occupied) {
            BlockPos mainPos = findMainBedPart(level, pos, state.getValue(FACING), state.getValue(SECTION));
            if (mainPos != null) {
                removeSleeper(level, mainPos, sleeper);
            }
        }
    }

    private static VoxelShape createShapeFromStream(Stream<VoxelShape> boxes) {
        return boxes.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).orElse(Shapes.empty());
    }

    /**
     * 将 VoxelShape 从北方向旋转到指定方向
     * @param northShape 北方向的碰撞箱
     * @param direction 目标方向（EAST, SOUTH, WEST）
     * @return 旋转后的碰撞箱
     */
    private static VoxelShape rotateShape(VoxelShape northShape, Direction direction) {
        if (direction == Direction.NORTH) {
            return northShape;
        }

        return northShape.toAabbs().stream()
                .map(aabb -> {
                    double x1 = aabb.minX * 16;
                    double y1 = aabb.minY * 16;
                    double z1 = aabb.minZ * 16;
                    double x2 = aabb.maxX * 16;
                    double y2 = aabb.maxY * 16;
                    double z2 = aabb.maxZ * 16;

                    double nx1, nz1, nx2, nz2;

                    switch (direction) {
                        case EAST -> {
                            // (x, y, z) → (z, y, 16-x)
                            nx1 = z1;
                            nz1 = 16 - x1;
                            nx2 = z2;
                            nz2 = 16 - x2;
                        }
                        case SOUTH -> {
                            // (x, y, z) → (16-x, y, 16-z)
                            nx1 = 16 - x1;
                            nz1 = 16 - z1;
                            nx2 = 16 - x2;
                            nz2 = 16 - z2;
                        }
                        case WEST -> {
                            // (x, y, z) → (16-z, y, x)
                            nx1 = 16 - z1;
                            nz1 = x1;
                            nx2 = 16 - z2;
                            nz2 = x2;
                        }
                        default -> {
                            return Block.box(x1, y1, z1, x2, y2, z2);
                        }
                    }

                    // 确保最小值和最大值正确
                    double minX = Math.min(nx1, nx2);
                    double maxX = Math.max(nx1, nx2);
                    double minZ = Math.min(nz1, nz2);
                    double maxZ = Math.max(nz1, nz2);

                    return Block.box(minX, y1, minZ, maxX, y2, maxZ);
                })
                .reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR))
                .orElse(Shapes.empty());
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction facing = pState.getValue(FACING);
        CanopyBedSection section = pState.getValue(SECTION);

        Map<CanopyBedSection, Supplier<VoxelShape>> northShapes = createNorthShapes();
        Map<CanopyBedSection, Supplier<VoxelShape>> eastShapes = createEastShapes();
        Map<CanopyBedSection, Supplier<VoxelShape>> southShapes = createSouthShapes();
        Map<CanopyBedSection, Supplier<VoxelShape>> westShapes = createWestShapes();

        return switch (facing) {
            case EAST -> eastShapes.getOrDefault(section, Shapes::block).get();
            case SOUTH -> southShapes.getOrDefault(section, Shapes::block).get();
            case WEST -> westShapes.getOrDefault(section, Shapes::block).get();
            default -> northShapes.getOrDefault(section, Shapes::block).get();
        };
    }
    private Map<CanopyBedSection, Supplier<VoxelShape>> createWestShapes() {
        Map<CanopyBedSection, Supplier<VoxelShape>> shapes = new HashMap<>();
        Map<CanopyBedSection, Supplier<VoxelShape>> northShapes = createNorthShapes();

        for (Map.Entry<CanopyBedSection, Supplier<VoxelShape>> entry : northShapes.entrySet()) {
            CanopyBedSection section = entry.getKey();
            shapes.put(section, () -> rotateShape(entry.getValue().get(), Direction.EAST));
        }

        return shapes;
    }

    private Map<CanopyBedSection, Supplier<VoxelShape>> createNorthShapes() {
        Map<CanopyBedSection, Supplier<VoxelShape>> shapes = new HashMap<>();

        shapes.put(CanopyBedSection.BODY_FRONT_BOTTOM, () -> createShapeFromStream(Stream.of(
                Block.box(1, 6, 0, 16, 10, 16),
                Block.box(0.97, 8.97, -0.03, 2.03, 16.03, 16.03)
        )));

        shapes.put(CanopyBedSection.BODY_FRONT_TOP, () -> createShapeFromStream(Stream.of(
                Block.box(1, 8, 0, 16, 9, 16),
                Block.box(1.9700000000000006, 2.97, -0.02999999999999936, 2.0299999999999994, 8.03, 16.03),
                Block.box(3, 0, 0, 3, 8, 16)
        )));

        shapes.put(CanopyBedSection.BODY_REAR_BOTTOM, () -> Block.box(0, 6, 0, 15, 10, 16));

        shapes.put(CanopyBedSection.BODY_REAR_MIDDLE, () -> Block.box(2, -6, 0, 3, 16, 16));

        shapes.put(CanopyBedSection.BODY_REAR_TOP, () -> createShapeFromStream(Stream.of(
                Block.box(12.97, 2.97, -0.03, 14.03, 8.03, 16.03),
                Block.box(0, 8, 0, 15, 9, 16)
        )));

        shapes.put(CanopyBedSection.FOOT_FRONT_BOTTOM, () -> createShapeFromStream(Stream.of(
                Block.box(1, 6, 0, 16, 10, 15),
                Block.box(1, 0, 12, 4, 2, 15),
                Block.box(0.5, 2, 12.75, 3.5, 6, 15.75),
                Block.box(1, 9, 13, 16, 16, 15),
                Block.box(1, 9, 0, 3, 16, 15)
        )));

        shapes.put(CanopyBedSection.FOOT_FRONT_MIDDLE, () -> createShapeFromStream(Stream.of(
                Block.box(1, 0, 13, 16, 16, 15),
                Block.box(1, 0, 0, 3, 16, 15)
        )));

        shapes.put(CanopyBedSection.FOOT_FRONT_TOP, () -> createShapeFromStream(Stream.of(
                Block.box(1, 8, 0, 16, 9, 15),
                Block.box(1, 0, 0, 3, 8, 15),
                Block.box(1, 0, 13, 16, 8, 15)
        )));

        shapes.put(CanopyBedSection.FOOT_REAR_BOTTOM, () -> createShapeFromStream(Stream.of(
                Block.box(12.5, 2, 12.5, 15.5, 6, 15.5),
                Block.box(12, 0, 12, 15, 2, 15),
                Block.box(0, 6, 0, 15, 10, 15),
                Block.box(13, 9, 4, 15, 16, 15),
                Block.box(0, 9, 13, 15, 16, 15)
        )));

        shapes.put(CanopyBedSection.FOOT_REAR_MIDDLE, () -> createShapeFromStream(Stream.of(
                Block.box(13, 0, 0, 15, 16, 15),
                Block.box(0, 0, 13, 15, 16, 15)
        )));

        shapes.put(CanopyBedSection.FOOT_REAR_TOP, () -> createShapeFromStream(Stream.of(
                Block.box(0, 8, 0, 15, 9, 15),
                Block.box(13, 0, 0, 15, 8, 15),
                Block.box(0, 0, 13, 15, 8, 15)
        )));

        shapes.put(CanopyBedSection.HEAD_FRONT_BOTTOM, () -> createShapeFromStream(Stream.of(
                Block.box(0.5, 2, 0.25, 3.5, 6, 3.25),
                Block.box(1, 0, 1, 4, 2, 4),
                Block.box(1, 6, 1, 16, 10, 16),
                Block.box(1, 9, 1, 16, 16, 3),
                Block.box(1, 9, 1, 3, 16, 16)
        )));

        shapes.put(CanopyBedSection.HEAD_FRONT_MIDDLE, () -> createShapeFromStream(Stream.of(
                Block.box(1, 0, 1, 3, 16, 16),
                Block.box(1, 0, 1, 16, 16, 3)
        )));

        shapes.put(CanopyBedSection.HEAD_FRONT_TOP, () -> createShapeFromStream(Stream.of(
                Block.box(1, 8, 1, 16, 9, 16),
                Block.box(1, 0, 1, 16, 8, 3),
                Block.box(1, 0, 1, 3, 8, 16)
        )));

        shapes.put(CanopyBedSection.HEAD_REAR_BOTTOM, () -> createShapeFromStream(Stream.of(
                Block.box(12, 0, 1, 15, 2, 4),
                Block.box(12.5, 2, 0.5, 15.5, 6, 3.5),
                Block.box(0, 6, 1, 15, 10, 16),
                Block.box(13, 9, 1, 15, 16, 12),
                Block.box(0, 9, 1, 15, 16, 3)
        )));

        shapes.put(CanopyBedSection.HEAD_REAR_MIDDLE, () -> createShapeFromStream(Stream.of(
                Block.box(13, 0, 1, 15, 16, 16),
                Block.box(0, 0, 1, 15, 16, 3)
        )));

        shapes.put(CanopyBedSection.HEAD_REAR_TOP, () -> createShapeFromStream(Stream.of(
                Block.box(13, 0, 1, 15, 8, 16),
                Block.box(0, 0, 1, 15, 8, 3),
                Block.box(0, 8, 1, 15, 9, 16)
        )));

        return shapes;
    }

    private Map<CanopyBedSection, Supplier<VoxelShape>> createEastShapes() {
        Map<CanopyBedSection, Supplier<VoxelShape>> shapes = new HashMap<>();
        Map<CanopyBedSection, Supplier<VoxelShape>> northShapes = createNorthShapes();

        for (Map.Entry<CanopyBedSection, Supplier<VoxelShape>> entry : northShapes.entrySet()) {
            CanopyBedSection section = entry.getKey();
            shapes.put(section, () -> rotateShape(entry.getValue().get(), Direction.WEST));
        }

        return shapes;
    }

    private Map<CanopyBedSection, Supplier<VoxelShape>> createSouthShapes() {
        Map<CanopyBedSection, Supplier<VoxelShape>> shapes = new HashMap<>();
        Map<CanopyBedSection, Supplier<VoxelShape>> northShapes = createNorthShapes();

        for (Map.Entry<CanopyBedSection, Supplier<VoxelShape>> entry : northShapes.entrySet()) {
            CanopyBedSection section = entry.getKey();
            shapes.put(section, () -> rotateShape(entry.getValue().get(), Direction.SOUTH));
        }

        return shapes;
    }

    public static boolean canSetSpawn(Level pLevel) {
        return pLevel.dimensionType().bedWorks();
    }

    private static boolean isBunkBed(BlockGetter pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.below()).getBlock() instanceof CanopyBed;
    }

    public static Optional<Vec3> findStandUpPosition(EntityType<?> pEntityType, CollisionGetter pCollisionGetter, BlockPos pPos, Direction pDirection, float pYRot) {
        Direction $$5 = pDirection.getClockWise();
        Direction $$6 = $$5.isFacingAngle(pYRot) ? $$5.getOpposite() : $$5;
        if (isBunkBed(pCollisionGetter, pPos)) {
            return findBunkBedStandUpPosition(pEntityType, pCollisionGetter, pPos, pDirection, $$6);
        } else {
            int[][] $$7 = bedStandUpOffsets(pDirection, $$6);
            Optional<Vec3> $$8 = findStandUpPositionAtOffset(pEntityType, pCollisionGetter, pPos, $$7, true);
            return $$8.isPresent() ? $$8 : findStandUpPositionAtOffset(pEntityType, pCollisionGetter, pPos, $$7, false);
        }
    }

    private static Optional<Vec3> findBunkBedStandUpPosition(EntityType<?> pEntityType, CollisionGetter pCollisionGetter, BlockPos pPos, Direction pStateFacing, Direction pEntityFacing) {
        int[][] $$5 = bedSurroundStandUpOffsets(pStateFacing, pEntityFacing);
        Optional<Vec3> $$6 = findStandUpPositionAtOffset(pEntityType, pCollisionGetter, pPos, $$5, true);
        if ($$6.isPresent()) {
            return $$6;
        } else {
            BlockPos $$7 = pPos.below();
            Optional<Vec3> $$8 = findStandUpPositionAtOffset(pEntityType, pCollisionGetter, $$7, $$5, true);
            if ($$8.isPresent()) {
                return $$8;
            } else {
                int[][] $$9 = bedAboveStandUpOffsets(pStateFacing);
                Optional<Vec3> $$10 = findStandUpPositionAtOffset(pEntityType, pCollisionGetter, pPos, $$9, true);
                if ($$10.isPresent()) {
                    return $$10;
                } else {
                    Optional<Vec3> $$11 = findStandUpPositionAtOffset(pEntityType, pCollisionGetter, pPos, $$5, false);
                    if ($$11.isPresent()) {
                        return $$11;
                    } else {
                        Optional<Vec3> $$12 = findStandUpPositionAtOffset(pEntityType, pCollisionGetter, $$7, $$5, false);
                        return $$12.isPresent() ? $$12 : findStandUpPositionAtOffset(pEntityType, pCollisionGetter, pPos, $$9, false);
                    }
                }
            }
        }
    }

    private static Optional<Vec3> findStandUpPositionAtOffset(EntityType<?> pEntityType, CollisionGetter pCollisionGetter, BlockPos pPos, int[][] pOffsets, boolean pSimulate) {
        BlockPos.MutableBlockPos $$5 = new BlockPos.MutableBlockPos();
        int[][] var6 = pOffsets;
        int var7 = pOffsets.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            int[] $$6 = var6[var8];
            $$5.set(pPos.getX() + $$6[0], pPos.getY(), pPos.getZ() + $$6[1]);
            Vec3 $$7 = DismountHelper.findSafeDismountLocation(pEntityType, pCollisionGetter, $$5, pSimulate);
            if ($$7 != null) {
                return Optional.of($$7);
            }
        }
        return Optional.empty();
    }

    private static int[][] bedStandUpOffsets(Direction pFirstDir, Direction pSecondDir) {
        return ArrayUtils.addAll(bedSurroundStandUpOffsets(pFirstDir, pSecondDir), bedAboveStandUpOffsets(pFirstDir));
    }

    private static int[][] bedSurroundStandUpOffsets(Direction pFirstDir, Direction pSecondDir) {
        return new int[][]{{pSecondDir.getStepX(), pSecondDir.getStepZ()}, {pSecondDir.getStepX() - pFirstDir.getStepX(), pSecondDir.getStepZ() - pFirstDir.getStepZ()}, {pSecondDir.getStepX() - pFirstDir.getStepX() * 2, pSecondDir.getStepZ() - pFirstDir.getStepZ() * 2}, {-pFirstDir.getStepX() * 2, -pFirstDir.getStepZ() * 2}, {-pSecondDir.getStepX() - pFirstDir.getStepX() * 2, -pSecondDir.getStepZ() - pFirstDir.getStepZ() * 2}, {-pSecondDir.getStepX() - pFirstDir.getStepX(), -pSecondDir.getStepZ() - pFirstDir.getStepZ()}, {-pSecondDir.getStepX(), -pSecondDir.getStepZ()}, {-pSecondDir.getStepX() + pFirstDir.getStepX(), -pSecondDir.getStepZ() + pFirstDir.getStepZ()}, {pFirstDir.getStepX(), pFirstDir.getStepZ()}, {pSecondDir.getStepX() + pFirstDir.getStepX(), pSecondDir.getStepZ() + pFirstDir.getStepZ()}};
    }

    private static int[][] bedAboveStandUpOffsets(Direction pDir) {
        return new int[][]{{0, 0}, {-pDir.getStepX(), -pDir.getStepZ()}};
    }

    @Override
    public boolean isBed(BlockState state, BlockGetter level, BlockPos pos, @Nullable Entity player) {
        return true;
    }

    @Override
    public Optional<Vec3> getRespawnPosition(BlockState state, EntityType<?> type, LevelReader levelReader, BlockPos pos, float orientation, @Nullable LivingEntity entity) {
        if (!state.hasProperty(FACING) || !state.hasProperty(SECTION)) {
            return Optional.empty();
        }
        if (levelReader instanceof Level level) {
            if (CanopyBed.canSetSpawn(level)) {
                BlockPos mainPos = findMainBedPart((Level) levelReader, pos, state.getValue(FACING), state.getValue(SECTION));
                if (mainPos != null) {
                    BlockPos respawnPos = calculateActualPos(mainPos, new BlockPos(-1, 0, 2), state.getValue(FACING));
                    return CanopyBed.findStandUpPosition(type, levelReader, respawnPos, state.getValue(FACING), orientation);
                }
            }
        }
        return Optional.empty();
    }

    public enum CanopyBedSection implements StringRepresentable {
        HEAD_FRONT_TOP("head_front_top"),
        HEAD_REAR_TOP("head_rear_top"),
        HEAD_FRONT_MIDDLE("head_front_middle"),
        HEAD_REAR_MIDDLE("head_rear_middle"),
        HEAD_FRONT_BOTTOM("head_front_bottom"),
        HEAD_REAR_BOTTOM("head_rear_bottom"),

        BODY_FRONT_TOP("body_front_top"),
        BODY_REAR_TOP("body_rear_top"),
        BODY_REAR_MIDDLE("body_rear_middle"),
        BODY_FRONT_BOTTOM("body_front_bottom"),
        BODY_REAR_BOTTOM("body_rear_bottom"),

        FOOT_FRONT_TOP("foot_front_top"),
        FOOT_REAR_TOP("foot_rear_top"),
        FOOT_FRONT_MIDDLE("foot_front_middle"),
        FOOT_REAR_MIDDLE("foot_rear_middle"),
        FOOT_FRONT_BOTTOM("foot_front_bottom"),
        FOOT_REAR_BOTTOM("foot_rear_bottom");

        private final String name;
        CanopyBedSection(String pName) {
            this.name = pName;
        }
        public String toString() {
            return this.name;
        }
        public @NotNull String getSerializedName() {
            return this.name;
        }
    }
}