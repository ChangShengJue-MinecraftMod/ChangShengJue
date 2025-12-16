package com.shengchanshe.chang_sheng_jue.block.custom.furniture.bed;

import com.shengchanshe.chang_sheng_jue.block.custom.furniture.bamboo_mat.BambooMatEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ArhatBed extends BedBlock {
    public static final EnumProperty<ArhatBedSection> BED_SECTION = EnumProperty.create("bed_section", ArhatBedSection.class);
    protected static final VoxelShape SHAPE_HEAD = Block.box(0, 0, 0, 16, 8, 16);
    protected static final VoxelShape SHAPE_BODY = Block.box(0, 0, 0, 16, 8, 16);
    protected static final VoxelShape SHAPE_FOOT = Block.box(0, 0, 0, 16, 8, 16);

    public ArhatBed(DyeColor color, Properties properties) {
        super(color, properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(BED_SECTION, ArhatBedSection.FOOT)
                .setValue(OCCUPIED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (state.getValue(BED_SECTION) == ArhatBedSection.HEAD) {
            return SHAPE_HEAD;
        } else if (state.getValue(BED_SECTION) == ArhatBedSection.BODY) {
            return SHAPE_BODY;
        }
        return SHAPE_FOOT;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ArhatBedEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.CONSUME;
        }

        if (!canSetSpawn(level)) {
            level.removeBlock(pos, false);
            BlockPos blockpos = pos.relative(state.getValue(FACING).getOpposite());
            if (level.getBlockState(blockpos).is(this)) {
                level.removeBlock(blockpos, false);
            }
            Vec3 center = pos.getCenter();
            level.explode(null, level.damageSources().badRespawnPointExplosion(center), null, center, 5.0F, true, Level.ExplosionInteraction.BLOCK);
            return InteractionResult.SUCCESS;
        }

        Direction facing = state.getValue(FACING);
        BlockPos sleepPos = findHeadPart(level, pos, facing);

        if (sleepPos == null) {
            return InteractionResult.FAIL;
        }

        BlockState sleepState = level.getBlockState(sleepPos);

        if (sleepState.getValue(OCCUPIED)) {
            player.displayClientMessage(net.minecraft.network.chat.Component.translatable("block.minecraft.bed.occupied"), true);
            return InteractionResult.SUCCESS;
        }

        player.startSleepInBed(sleepPos).ifLeft((problem) -> {
            if (problem.getMessage() != null) {
                player.displayClientMessage(problem.getMessage(), true);
            }
        });

        return InteractionResult.SUCCESS;
    }

    private BlockPos findHeadPart(Level level, BlockPos pos, Direction facing) {
        ArhatBedSection section = level.getBlockState(pos).getValue(BED_SECTION);

        if (section == ArhatBedSection.HEAD) {
            return pos;
        } else if (section == ArhatBedSection.BODY) {
            return pos.relative(facing);
        } else if (section == ArhatBedSection.FOOT) {
            return pos.relative(facing, 2);
        }

        return null;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection();
        BlockPos pPos = context.getClickedPos();

        BlockPos middlePos = pPos.relative(direction);
        BlockPos headPos = middlePos.relative(direction);
        Level pLevel = context.getLevel();

        if (pLevel.getBlockState(middlePos).canBeReplaced(context) &&
                pLevel.getBlockState(headPos).canBeReplaced(context) &&
                pLevel.getWorldBorder().isWithinBounds(headPos)) {
            return this.defaultBlockState()
                    .setValue(FACING, direction)
                    .setValue(BED_SECTION, ArhatBedSection.FOOT)
                    .setValue(OCCUPIED, false);
        }
        return null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pPos, BlockState state, net.minecraft.world.entity.LivingEntity placer, net.minecraft.world.item.ItemStack stack) {
        if (!level.isClientSide) {
            Direction facing = state.getValue(FACING);

            BlockPos middlePos = pPos.relative(facing);
            level.setBlock(middlePos, state
                    .setValue(BED_SECTION, ArhatBedSection.BODY), 3);

            BlockPos headPos = middlePos.relative(facing);
            level.setBlock(headPos, state
                    .setValue(BED_SECTION, ArhatBedSection.HEAD), 3);

            level.blockUpdated(pPos, Blocks.AIR);
            state.updateNeighbourShapes(level, pPos, 3);
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        ArhatBedSection section = state.getValue(BED_SECTION);
        Direction facing = state.getValue(FACING);

        if (section == ArhatBedSection.FOOT) {
            if (direction == facing) {
                return neighborState.is(this) ? state.setValue(OCCUPIED, neighborState.getValue(OCCUPIED)) : Blocks.AIR.defaultBlockState();
            }
        } else if (section == ArhatBedSection.BODY) {
            if (direction == facing || direction == facing.getOpposite()) {
                return neighborState.is(this) ? state.setValue(OCCUPIED, neighborState.getValue(OCCUPIED)) : Blocks.AIR.defaultBlockState();
            }
        } else if (section == ArhatBedSection.HEAD) {
            if (direction == facing.getOpposite()) {
                return neighborState.is(this) ? state.setValue(OCCUPIED, neighborState.getValue(OCCUPIED)) : Blocks.AIR.defaultBlockState();
            }
        }

        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            if (player.isCreative()) {
                ArhatBedSection section = state.getValue(BED_SECTION);
                Direction facing = state.getValue(FACING);

                if (section == ArhatBedSection.FOOT) {
                    removeIfIsBed(level, pos.relative(facing), player);
                    removeIfIsBed(level, pos.relative(facing, 2), player);
                } else if (section == ArhatBedSection.BODY) {
                    removeIfIsBed(level, pos.relative(facing.getOpposite()), player);
                    removeIfIsBed(level, pos.relative(facing), player);
                } else if (section == ArhatBedSection.HEAD) {
                    removeIfIsBed(level, pos.relative(facing.getOpposite()), player);
                    removeIfIsBed(level, pos.relative(facing.getOpposite(), 2), player);
                }

                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 35);
                level.levelEvent(player, 2001, pos, Block.getId(state));
                return;
            }
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    private void removeIfIsBed(Level level, BlockPos pos, Player player) {
        BlockState state = level.getBlockState(pos);
        if (state.is(this)) {
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 35);
            level.levelEvent(player, 2001, pos, Block.getId(state));
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, PART, OCCUPIED, BED_SECTION);
    }
}