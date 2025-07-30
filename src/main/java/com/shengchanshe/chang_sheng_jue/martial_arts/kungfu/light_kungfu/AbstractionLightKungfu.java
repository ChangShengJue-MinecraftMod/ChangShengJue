package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.light_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.event.CSJAdvanceEvent;
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import com.shengchanshe.chang_sheng_jue.martial_arts.IKungFuUpgradable;
import com.shengchanshe.chang_sheng_jue.martial_arts.ILightKungfu;
import com.shengchanshe.chang_sheng_jue.martial_arts.IMentalKungfu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffer;

public abstract class AbstractionLightKungfu implements ILightKungfu, IKungFuUpgradable {
    protected String id;
    // 武功名称
    protected Component name;
    // 武功类型
    protected KungFuType type;
    // 武功描述
    protected String description;
    // 武功是否领悟
    protected boolean isComprehend;
    // 武功领悟概率
    protected float comprehendProbability;
    // 武功领悟显示tick
    protected int levelUpTick;
    // 武功伤害
    protected float damage;
    // 武功消耗饥饿值
    protected int hunger;
    // 武功消耗饱和度
    protected float saturation;
    // 武功附带的Effect概率
    protected float effectProbability;
    // 武功等级
    protected int level;
    //武功突破显示tick
    protected int dachengTick;
    // 武功升级所需经验
    protected int exp;
    // 武功冷却
    protected int cooldown;
    // 武功冷却倍率
    protected float cooldownFactor;
    // 武功是否启动
    protected boolean isStart;

    public RandomSource randomSource = RandomSource.create();

    public AbstractionLightKungfu(String id, Component name, KungFuType type, String description,
                                  float comprehendProbability) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.comprehendProbability = comprehendProbability;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Component getName() {
        return name;
    }

    @Override
    public KungFuType getKungFuType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isComprehend() {
        return isComprehend;
    }

    @Override
    public void comprehendKungFu(LivingEntity entity) {
        if (!isComprehend && level == 0) {
            if (randomSource.nextFloat() <= getComprehendProbability(entity)) {
                levelUp(entity);
                isStart = true;
                isComprehend = true;
                if (entity instanceof Player player) {
                    player.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                            ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                    player.sendSystemMessage(Component.translatable("kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.kungfu", this.name));
                    if (player instanceof ServerPlayer serverPlayer) {
                        CSJAdvanceInit.LEARN_GONG_FA.trigger(serverPlayer);
                    }
                }
            }
        }
    }

    @Override
    public void attackEffect(LivingEntity source, Entity target) {

    }

    @Override
    public float getComprehendProbability(LivingEntity entity) {
        if (entity instanceof Player player && player.getAbilities().instabuild){
            return 1.0F;
        }else {
            return comprehendProbability;
        }
    }

    @Override
    public ResourceKey<DamageType> getDamageType() {
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ChangShengJue.MOD_ID + ":martial_arts"));
    }

    @Override
    public boolean isReady() {
        return cooldown <= 0 && isStart && isComprehend && level > 0;
    }

    @Override
    public int getHunger() {
        return hunger;
    }

    @Override
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    @Override
    public float getSaturation() {
        return saturation;
    }
    @Override
    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }

    @Override
    public float getEffectProbability() {
        return effectProbability;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getLevelUpTick() {
        if (levelUpTick >= 80) {
            levelUpTick = 0;
        }
        return levelUpTick;
    }

    @Override
    public void setLevelUpTick() {
        this.levelUpTick++;
    }

    @Override
    public int getDachengTick() {
        if (this.dachengTick >= 30){
            this.dachengTick = 0;
        }
        return dachengTick;
    }

    @Override
    public void setDachengTick() {
        dachengTick++;
    }

    public void clampLevelToMax() {
        if (this.level > this.getMaxLevel()) {
            this.level = this.getMaxLevel(); // 将等级限制到当前配置上限
            this.exp = 0;
        }
        if (this.exp > getMaxExp()) {
            this.exp = getMaxExp();
        }
    }

    @Override
    public void levelUp(LivingEntity entity) {
        level++;
        if (level >= getMaxLevel()) {
            dachengTick = 1;
        } else {
            levelUpTick = 1;
        }
        if (entity instanceof ServerPlayer player) {
            CSJAdvanceEvent.CheckLevel(level, player, exp, getMaxLevel());
        }
        exp = 0;
        onLevelUp(entity);
    }

    public void onLevelUp(LivingEntity livingEntity) {
        // 子类可重写
    }
    @Override
    public void onLightKungfu(Player player) {

    }

    @Override
    public int getExp() {
        return exp;
    }

    @Override
    public void addExp(LivingEntity entity, int amount) {
        exp += amount;
        while (exp >= getMaxExp() && level < getMaxLevel()) {
            levelUp(entity);
            if (level >= getMaxLevel()) {
                entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                        ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
            } else {
                entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }
    }

    @Override
    public int getCoolDown() {
        return cooldown;
    }

    @Override
    public void tickCooldown() {
        if (cooldown > 0) cooldown--;
    }

    @Override
    public float getCoolDownFactor() {
        return cooldownFactor;
    }

    @Override
    public boolean isStart() {
        return isStart;
    }

    @Override
    public void startKungFu(boolean isStart) {
        this.isStart = isStart;
    }

    @Override
    public void biluochunTeasAndLongJingTeasEffect(LivingEntity source) {
        if (source.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())){
            source.setHealth(source.getHealth() + 1);
        }
        if (source.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())){
            if (source instanceof Player player){
                player.getFoodData().eat(1,0);
            }
        }
    }

    @Override
    public float funJiuEffect(LivingEntity source, float damage) {
        if (source.hasEffect(ChangShengJueEffects.FEN_JIU.get())){
            if (source instanceof Player player){
                player.getFoodData().eat(-1,0);
            }
            return damage + 2;
        }
        return damage;
    }

    @Override
    public int wheatNuggetsTributeWineEffect(LivingEntity source) {
        if (source.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get())){
            return 30;
        }
        return 0;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        if (this.id != null){
            tag.putString("KungFuId", this.id);
        }
        if (this.name != null){
            tag.putString("KungFuName", Component.Serializer.toJson(this.name));
        }
        if (this.description != null) {
            tag.putString("KungFuDescription", this.description);
        }
        if (this.type != null) {
            tag.putString("KungFuType", this.type.name());
        }
        tag.putBoolean("KungFuIsComprehend", this.isComprehend);
        tag.putInt("KungFuComprehendTick", this.levelUpTick);
        tag.putFloat("KungFuDamage", this.damage);
        tag.putInt("KungFuHunger", this.hunger);
        tag.putFloat("KungFuSaturation", this.saturation);
        tag.putFloat("KungFuEffectProbability", this.effectProbability);
        tag.putInt("KungFuLevel", this.level);
        tag.putInt("KungFuLevelUpTick", this.dachengTick);
        tag.putInt("KungFuExp", this.exp);
        tag.putInt("KungFuCooldown", this.cooldown);
        tag.putFloat("KungFuCooldownFactor", this.cooldownFactor);
        tag.putBoolean("KungFuIsStart", this.isStart);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        this.id = tag.getString("KungFuId");
        this.name = Component.Serializer.fromJson(tag.getString("KungFuName"));
        this.description = tag.getString("KungFuDescription");
        this.type = KungFuType.valueOf(tag.getString("KungFuType"));
        this.isComprehend = tag.getBoolean("KungFuIsComprehend");
        this.levelUpTick = tag.getInt("KungFuComprehendTick");
        this.damage = tag.getFloat("KungFuDamage");
        this.hunger = tag.getInt("KungFuHunger");
        this.saturation = tag.getFloat("KungFuSaturation");
        this.effectProbability = tag.getFloat("KungFuEffectProbability");
        this.level = tag.getInt("KungFuLevel");
        this.dachengTick = tag.getInt("KungFuLevelUpTick");
        this.exp = tag.getInt("KungFuExp");
        this.cooldown = tag.getInt("KungFuCooldown");
        this.cooldownFactor = tag.getFloat("KungFuCooldownFactor");
        this.isStart = tag.getBoolean("KungFuIsStart");
        clampLevelToMax();
    }

}

