package com.shengchanshe.chang_sheng_jue.block.custom.sharpening_stone;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

public abstract class SharpeningStone extends HorizontalDirectionalBlock implements EntityBlock {
    private static final VoxelShape SHAPE_NORTH_SOUTH = Block.box(6, 0, 3, 10, 2, 13);
    private static final VoxelShape SHAPE_EAST_WEST = Block.box(3, 0, 6, 13, 2, 10);

    protected SharpeningStone(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case EAST, WEST -> SHAPE_EAST_WEST;
            default -> SHAPE_NORTH_SOUTH;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return SharpeningStoneEntity.create(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        ItemStack itemInHand = player.getItemInHand(hand);

        if (!isWeapon(itemInHand)) {
            return InteractionResult.PASS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof SharpeningStoneEntity sharpeningStoneEntity)) {
            return InteractionResult.FAIL;
        }

        // 获取磨刀石类型
        SharpeningStoneType type = getSharpeningStoneType(state.getBlock());

        // 尝试打磨武器
        if (sharpenWeapon(itemInHand, player, type, sharpeningStoneEntity)) {
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }

    // 判断是否为武器
    private boolean isWeapon(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return false;
        }

        return itemStack.canPerformAction(ToolActions.SWORD_DIG) ||
                itemStack.canPerformAction(ToolActions.AXE_DIG) ||
                itemStack.canPerformAction(ToolActions.PICKAXE_DIG) ||
                itemStack.canPerformAction(ToolActions.SHOVEL_DIG) ||
                itemStack.canPerformAction(ToolActions.HOE_DIG) ||
                itemStack.getAttributeModifiers(EquipmentSlot.MAINHAND).containsKey(Attributes.ATTACK_DAMAGE);
    }

    // 获取磨刀石类型
    private SharpeningStoneType getSharpeningStoneType(Block block) {
        if (block instanceof StoneSharpeningStone) {
            return SharpeningStoneType.STONE;
        } else if (block instanceof DiamondSharpeningStone) {
            return SharpeningStoneType.DIAMOND;
        } else if (block instanceof NetheriteSharpeningStone) {
            return SharpeningStoneType.NETHERITE;
        }
        return SharpeningStoneType.STONE;
    }

    // 打磨武器
    private boolean sharpenWeapon(ItemStack weapon, Player player, SharpeningStoneType type, SharpeningStoneEntity stoneEntity) {
        // 获取武器的基础攻击力
        float baseDamage = getBaseWeaponDamage(weapon);

        // 获取当前已增加的伤害
        float currentBonus = getCurrentSharpeningBonus(weapon);
        float currentTotalDamage = baseDamage + currentBonus;

        // 磨刀石的最大攻击力限制
        float maxTotalDamage = type.getMaxDamage();
        float increment = type.getDamageIncrement();

        // 检查是否已达到最大攻击力
        if (currentTotalDamage >= maxTotalDamage) {
            player.displayClientMessage(
                    Component.translatable("message.sharpening_stone.max_damage")
                            .append(Component.literal(" (" + String.format("%.1f", maxTotalDamage) + ")")),
                    true
            );
            return false;
        }

        // 计算本次可以增加多少
        float potentialNewTotal = currentTotalDamage + increment;
        float actualIncrease;

        if (potentialNewTotal > maxTotalDamage) {
            // 如果增加后会超过最大值，只增加到最大值
            actualIncrease = maxTotalDamage - currentTotalDamage;
        } else {
            actualIncrease = increment;
        }

        // 计算新的加成值
        float newBonus = currentBonus + actualIncrease;

        // 保存新的加成值到物品NBT
        saveSharpeningBonus(weapon, newBonus, type);

        // 消耗耐久
        stoneEntity.reduceDurability(1);

        player.level().playSound(
                null,
                player.getX(), player.getY(), player.getZ(),
                net.minecraft.sounds.SoundEvents.GRINDSTONE_USE,
                net.minecraft.sounds.SoundSource.BLOCKS,
                1.0F, 1.0F
        );

        float newTotalDamage = baseDamage + newBonus;
        player.displayClientMessage(
                Component.translatable("message.sharpening_stone.sharpened")
                        .append(Component.literal(" +" + String.format("%.1f", actualIncrease) + " "))
                        .append(Component.translatable("message.sharpening_stone.total_damage"))
                        .append(Component.literal(String.format("%.1f", newTotalDamage) + "/" + String.format("%.1f", maxTotalDamage))),
                true
        );

        return true;
    }

    // 获取武器的基础攻击力
    private float getBaseWeaponDamage(ItemStack weapon) {
        var item = weapon.getItem();

        // 原版武器的硬编码基础伤害
        if (item instanceof SwordItem sword) {
            return sword.getDamage();
        } else if (item instanceof AxeItem axe) {
            return axe.getAttackDamage();
        } else if (item instanceof PickaxeItem pickaxe) {
            return pickaxe.getAttackDamage();
        } else if (item instanceof ShovelItem shovel) {
            return shovel.getAttackDamage();
        } else if (item instanceof HoeItem hoe) {
            return hoe.getAttackDamage();
        }

        // 对于模组的武器，尝试从属性中获取基础值
        // 移除所有属性修改器来计算基础值
        float baseDamage = 0;

        // 获取所有属性修改器
        var modifiers = weapon.getAttributeModifiers(EquipmentSlot.MAINHAND);
        if (modifiers.containsKey(Attributes.ATTACK_DAMAGE)) {
            for (var modifier : modifiers.get(Attributes.ATTACK_DAMAGE)) {
                // 只计算Operation为ADDITION的，并且不是我们添加的
                if (modifier.getOperation().equals(AttributeModifier.Operation.ADDITION)) {
                    String modifierName = modifier.getName();
                    // 排除我们添加的修改器
                    if (!modifierName.contains("sharpening")) {
                        baseDamage += (float) modifier.getAmount();
                    }
                }
            }
        }

        // 如果还是0，尝试从物品的默认属性获取
        if (baseDamage <= 0.1f) {
            // 创建物品的新实例来获取默认属性
            ItemStack freshStack = new ItemStack(weapon.getItem(), 1);
            var freshModifiers = freshStack.getAttributeModifiers(EquipmentSlot.MAINHAND);
            if (freshModifiers.containsKey(Attributes.ATTACK_DAMAGE)) {
                for (var modifier : freshModifiers.get(Attributes.ATTACK_DAMAGE)) {
                    if (modifier.getOperation().equals(AttributeModifier.Operation.ADDITION)) {
                        baseDamage += (float) modifier.getAmount();
                    }
                }
            }
        }

        return baseDamage;
    }

    // 获取当前打磨加成
    private float getCurrentSharpeningBonus(ItemStack weapon) {
        if (!weapon.hasTag()) {
            return 0.0f;
        }

        var tag = weapon.getTag();
        if (tag != null && tag.contains("SharpeningBonus")) {
            return tag.getFloat("SharpeningBonus");
        }

        return 0.0f;
    }

    // 获取当前打磨次数
    private int getCurrentSharpeningCount(ItemStack weapon) {
        if (!weapon.hasTag()) {
            return 0;
        }

        var tag = weapon.getTag();
        if (tag != null && tag.contains("SharpeningCount")) {
            return tag.getInt("SharpeningCount");
        }

        return 0;
    }

    // 保存打磨加成到物品NBT
    private void saveSharpeningBonus(ItemStack weapon, float bonus, SharpeningStoneType type) {
        if (!weapon.hasTag()) {
            weapon.setTag(new CompoundTag());
        }

        var tag = weapon.getTag();

        if (tag != null) {
            tag.putFloat("SharpeningBonus", bonus);
            // 保存打磨次数
            int currentCount = getCurrentSharpeningCount(weapon);
            tag.putInt("SharpeningCount", currentCount + 1);
        }
        if (tag != null) {
            tag.putString("SharpenedBy", type.name().toLowerCase());
        }
    }

    private enum SharpeningStoneType {
        STONE(0.5f, 6.0f),
        DIAMOND(1.0f, 8.0f),
        NETHERITE(2.0f, 10.0f);

        private final float damageIncrement; // 每次打磨增加的伤害
        private final float maxDamage;

        SharpeningStoneType(float damageIncrement, float maxDamage) {
            this.damageIncrement = damageIncrement;
            this.maxDamage = maxDamage;
        }

        public float getDamageIncrement() {
            return damageIncrement;
        }

        public float getMaxDamage() {
            return maxDamage;
        }
    }
}