package com.shengchanshe.chang_sheng_jue.block.custom.racks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class DryingRail extends HorizontalDirectionalBlock implements EntityBlock {
    public static final BooleanProperty HAS_ARMOR = BooleanProperty.create("has_armor");

    public DryingRail(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HAS_ARMOR, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HAS_ARMOR);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();

        Direction facing = context.getHorizontalDirection().getOpposite();

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = level.getBlockState(neighborPos);

            if (neighborState.is(this)) {
                Direction neighborFacing = neighborState.getValue(FACING);

                if (neighborFacing == Direction.NORTH || neighborFacing == Direction.SOUTH) {
                    facing = Direction.NORTH;
                } else if (neighborFacing == Direction.EAST || neighborFacing == Direction.WEST) {
                    facing = Direction.EAST;
                }

                if (isFormingLine(level, pos, direction, neighborFacing)) {
                    facing = neighborFacing;
                    break;
                }
            }
        }

        return this.defaultBlockState().setValue(FACING, facing);
    }

    private boolean isFormingLine(Level level, BlockPos pos, Direction neighborDirection, Direction neighborFacing) {
        if (neighborFacing == Direction.NORTH || neighborFacing == Direction.SOUTH) {
            return neighborDirection == Direction.EAST || neighborDirection == Direction.WEST;
        } else if (neighborFacing == Direction.EAST || neighborFacing == Direction.WEST) {
            return neighborDirection == Direction.NORTH || neighborDirection == Direction.SOUTH;
        }
        return false;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pState.getValue(FACING) == Direction.NORTH || pState.getValue(FACING) == Direction.SOUTH) {
            return Block.box(7, 0, 0, 9, 16, 16);
        } else {
            return Block.box(0, 0, 7, 16, 16, 9);
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof DryingRailEntity dryingRail) {
                if (dryingRail.hasArmor()) {
                    popResource(level, pos, dryingRail.getArmorItem().copy());
                }
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof DryingRailEntity dryingRail) {
            ItemStack handItem = player.getItemInHand(hand);

            if (!handItem.isEmpty() && isAllowedArmor(handItem) && !dryingRail.hasArmor()) {
                ItemStack armorStack = handItem.copy();
                armorStack.setCount(1);
                dryingRail.setArmorItem(armorStack);

                if (!player.getAbilities().instabuild) {
                    handItem.shrink(1);
                }

                level.setBlock(pos, state.setValue(HAS_ARMOR, true), 3);
                return InteractionResult.SUCCESS;
            }
            else if (handItem.isEmpty() && dryingRail.hasArmor()) {
                ItemStack armorStack = dryingRail.getArmorItem().copy();
                player.setItemInHand(hand, armorStack);
                dryingRail.clearArmor();

                level.setBlock(pos, state.setValue(HAS_ARMOR, false), 3);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    private boolean isAllowedArmor(ItemStack stack) {
        if (stack.getItem() instanceof ArmorItem armor) {
            EquipmentSlot slot = armor.getEquipmentSlot();
            return slot == EquipmentSlot.CHEST || slot == EquipmentSlot.LEGS;
        }
        return false;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DryingRailEntity(pos, state);
    }
}