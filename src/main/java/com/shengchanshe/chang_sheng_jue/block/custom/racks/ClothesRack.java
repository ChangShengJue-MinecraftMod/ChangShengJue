package com.shengchanshe.chang_sheng_jue.block.custom.racks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class ClothesRack extends HorizontalDirectionalBlock implements EntityBlock {
    public static final BooleanProperty HAS_ARMOR = BooleanProperty.create("has_armor");
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public ClothesRack(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HAS_ARMOR, false)
                .setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HAS_ARMOR, HALF);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();

        // 检查上方是否有足够空间放置上层方块
        if (pos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(pos.above()).canBeReplaced(context)) {
            return this.defaultBlockState()
                    .setValue(FACING, context.getHorizontalDirection().getOpposite())
                    .setValue(HALF, DoubleBlockHalf.LOWER);
        } else {
            return null; // 无法放置
        }
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);

        if (!pLevel.isClientSide && pState.getValue(HALF) == DoubleBlockHalf.LOWER) {
            BlockPos abovePos = pPos.above();
            pLevel.setBlock(abovePos, pState.setValue(HALF, DoubleBlockHalf.UPPER), 3);

            if (pLevel.getBlockEntity(abovePos) instanceof ClothesRackEntity upperEntity) {
                upperEntity.setChanged();
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        DoubleBlockHalf half = state.getValue(HALF);

        // 根据朝向和上下部分返回不同的碰撞箱
        if (facing == Direction.NORTH || facing == Direction.SOUTH) {
            return Block.box(0, 0, 7, 16, 16, 9); // 下层
        } else {
            return Block.box(7, 0, 0, 9, 16, 16); // 下层
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }
        DoubleBlockHalf half = state.getValue(HALF);
        BlockPos targetPos = half == DoubleBlockHalf.UPPER ? pos.below() : pos;

        BlockEntity blockEntity = level.getBlockEntity(targetPos);
        if (blockEntity instanceof ClothesRackEntity rackEntity) {
            ItemStack handItem = player.getItemInHand(hand);

            if (!handItem.isEmpty() && handItem.getItem() instanceof ArmorItem armor) {
                EquipmentSlot armorType = armor.getEquipmentSlot();
                int targetSlot = rackEntity.getSlotForArmorType(armorType);

                if (targetSlot != -1 && rackEntity.isSlotEmpty(targetSlot)) {
                    if (rackEntity.setArmorItem(targetSlot, handItem)) {
                        if (!player.getAbilities().instabuild) {
                            handItem.shrink(1);
                        }
                        updateBothHalves(level, targetPos, rackEntity.hasArmor());
                        return InteractionResult.SUCCESS;
                    }
                }
            } else if (handItem.isEmpty()) {
                int clickedSlot = getClickedSlot(hit, state);

                if (!rackEntity.getArmorItem(clickedSlot).isEmpty()) {
                    ItemStack armorStack = rackEntity.getArmorItem(clickedSlot).copy();
                    player.setItemInHand(hand, armorStack);
                    rackEntity.clearArmor(clickedSlot);

                    updateBothHalves(level, targetPos, rackEntity.hasArmor());
                    return InteractionResult.SUCCESS;
                }
            }
        }

        return InteractionResult.PASS;
    }

    private int getClickedSlot(BlockHitResult hit, BlockState state) {
        double hitY = hit.getLocation().y - hit.getBlockPos().getY();

        if (hitY > 0.66) {
            return 0;
        } else if (hitY > 0.33) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        DoubleBlockHalf half = state.getValue(HALF);
        BlockPos otherPos = half == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
        BlockState otherState = level.getBlockState(otherPos);

        // 如果另一半也是衣架，则破坏另一半
        if (otherState.is(this) && otherState.getValue(HALF) != half) {
            // 只在 playerWillDestroy 中处理另一半的掉落，当前方块的掉落交给 onRemove
            BlockEntity blockEntity = level.getBlockEntity(otherPos);
            if (blockEntity instanceof ClothesRackEntity rackEntity && !player.isCreative()) {
                // 掉落所有盔甲物品
                for (ItemStack armorStack : rackEntity.getAllArmorItems()) {
                    if (!armorStack.isEmpty()) {
                        popResource(level, otherPos, armorStack.copy());
                    }
                }
            }

            // 设置空气并更新
            level.setBlock(otherPos, net.minecraft.world.level.block.Blocks.AIR.defaultBlockState(), 3);
            level.levelEvent(player, 2001, otherPos, Block.getId(otherState));
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof ClothesRackEntity rackEntity) {
                // 掉落所有盔甲物品（在生存模式下）
                Player player = level.getNearestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
                if (player == null || !player.isCreative()) {
                    for (ItemStack armorStack : rackEntity.getAllArmorItems()) {
                        if (!armorStack.isEmpty()) {
                            popResource(level, pos, armorStack.copy());
                        }
                    }
                }
            }

            // 确保另一半也被正确处理
            DoubleBlockHalf half = state.getValue(HALF);
            BlockPos otherPos = half == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
            BlockState otherState = level.getBlockState(otherPos);

            if (otherState.is(this) && otherState.getValue(HALF) != half) {
                level.setBlock(otherPos, net.minecraft.world.level.block.Blocks.AIR.defaultBlockState(), 3);
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    // 更新两个部分的方块状态
    private void updateBothHalves(Level level, BlockPos lowerPos, boolean hasArmor) {
        BlockState lowerState = level.getBlockState(lowerPos);
        if (lowerState.is(this) && lowerState.getValue(HALF) == DoubleBlockHalf.LOWER) {
            // 更新下层
            level.setBlock(lowerPos, lowerState.setValue(HAS_ARMOR, hasArmor), 3);

            // 更新上层
            BlockPos upperPos = lowerPos.above();
            BlockState upperState = level.getBlockState(upperPos);
            if (upperState.is(this) && upperState.getValue(HALF) == DoubleBlockHalf.UPPER) {
                level.setBlock(upperPos, upperState.setValue(HAS_ARMOR, hasArmor), 3);
            }
        }
    }

    // 方块状态更新
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf half = state.getValue(HALF);

        if (direction.getAxis() == Direction.Axis.Y) {
            if (half == DoubleBlockHalf.LOWER && direction == Direction.UP) {
                // 下层检查上层是否存在
                if (!neighborState.is(this) || neighborState.getValue(HALF) != DoubleBlockHalf.UPPER) {
                    return net.minecraft.world.level.block.Blocks.AIR.defaultBlockState();
                }
            } else if (half == DoubleBlockHalf.UPPER && direction == Direction.DOWN) {
                // 上层检查下层是否存在
                if (!neighborState.is(this) || neighborState.getValue(HALF) != DoubleBlockHalf.LOWER) {
                    return net.minecraft.world.level.block.Blocks.AIR.defaultBlockState();
                }
            }
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    private boolean isAllowedArmor(ItemStack stack) {
        if (stack.getItem() instanceof ArmorItem armor) {
            EquipmentSlot slot = armor.getEquipmentSlot();
            return slot == EquipmentSlot.CHEST || slot == EquipmentSlot.LEGS || slot == EquipmentSlot.FEET;
        }
        return false;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ClothesRackEntity(pos, state);
    }
}