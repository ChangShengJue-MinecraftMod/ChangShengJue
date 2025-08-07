package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.List;

public class Paoding extends AbstractionInternalkungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "paoding");

    public Paoding() {
        super(KUNG_FU_ID.toString(), Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.BLACK),
                KungFuType.INTERNAL_KUNGFU, Component.translatable("description"),0.15f, 0,0);
    }

    @Override
    public void onEntityTick(LivingEntity player) {}

    @Override
    public void onEntityHurt(LivingEntity livingEntity, DamageSource source, float amount) {

    }

    public void attack(LivingEntity entity, Entity target,DamageSource damageSource) {
        if (randomSource.nextFloat() <= getEffectProbability()) {
            if (target instanceof LivingEntity livingEntity) {
                ItemStack extraMeat = getExtraMeatDrop(livingEntity, damageSource);
                if (!extraMeat.isEmpty()) {
                    livingEntity.spawnAtLocation(extraMeat, 0.5f); // 0.5f是垂直偏移
                }
                if (entity instanceof Player player) {
                    addExp(player, !player.getAbilities().instabuild ? 1 : getMaxExp());
                }
            }
        }
    }

    @Override
    public void onInteranKungFu(Level pLevel, LivingEntity pEntity) {

    }

    @Override
    public void onLevelUp(LivingEntity livingEntity) {
    }

    private ItemStack getExtraMeatDrop(LivingEntity animal, DamageSource damageSource) {
        if (!(animal.level() instanceof ServerLevel serverLevel)) {
            return ItemStack.EMPTY;
        }

        // 正确构建 LootParams，包含所有必需参数
        LootParams.Builder lootParams = new LootParams.Builder(serverLevel)
                .withParameter(LootContextParams.THIS_ENTITY, animal)
                .withParameter(LootContextParams.ORIGIN, animal.position())
                .withParameter(LootContextParams.DAMAGE_SOURCE, damageSource) // 必须包含伤害源
                .withOptionalParameter(LootContextParams.KILLER_ENTITY, damageSource.getEntity())
                .withOptionalParameter(LootContextParams.DIRECT_KILLER_ENTITY, damageSource.getDirectEntity());

        // 获取生物的标准掉落表
        LootTable lootTable = serverLevel.getServer().getLootData().getLootTable(animal.getLootTable());
        List<ItemStack> possibleDrops = lootTable.getRandomItems(lootParams.create(LootContextParamSets.ENTITY));

        // 从掉落物中寻找肉类
        for (ItemStack stack : possibleDrops) {
            if (isMeatItem(stack.getItem())) {
                ItemStack extraMeat = stack.copy();
                extraMeat.setCount(KungFuConfig.PAODING_ADDITIONAL_DROPS_COUNT.get()); // 只额外掉落一块
                return extraMeat;
            }
        }

        return ItemStack.EMPTY;
    }

    private boolean isMeatItem(Item item) {
        // 检查物品是否是肉类（可扩展）
        return item.isEdible() &&
                (item.getFoodProperties() != null &&
                        item.getFoodProperties().isMeat());
    }

    @Override
    public float getEffectProbability() {
        if (level == 1) {
            return 0.5f;
        } else if (level == 2) {
            return 0.75f;
        } else {
            return 1.0f;
        }
    }

    @Override
    public int getMaxCoolDown() {
        return 0;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public int getMaxExp() {
        return KungFuConfig.THE_CLASSICS_OF_TENDON_CHANGING_MAX_EXP.get();
    }
}
