package com.shengchanshe.chang_sheng_jue.block.custom.gong;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.apache.commons.lang3.mutable.MutableInt;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Iterator;
import java.util.List;

public class GongEntity extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private long lastRingTimestamp;
    public int ticks;
    public boolean shaking;
    public Direction clickDirection;
    private List<LivingEntity> nearbyEntities;
    private boolean resonating;
    private int resonationTicks;

    public GongEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.GONG_ENTITY.get(), pPos, pBlockState);
    }

    public boolean triggerEvent(int pId, int pType) {
        if (pId == 1) {
            this.updateEntities();
            this.resonationTicks = 0;
            this.clickDirection = Direction.from3DDataValue(pType);
            this.ticks = 0;
            this.shaking = true;
            return true;
        } else {
            return super.triggerEvent(pId, pType);
        }
    }

    private static void tick(Level pLevel, BlockPos pPos, BlockState pState, GongEntity pBlockEntity, ResonationEndAction pResonationEndAction) {
        if (pBlockEntity.shaking) {
            ++pBlockEntity.ticks;
        }

        if (pBlockEntity.ticks >= 50) {
            pBlockEntity.shaking = false;
            pBlockEntity.ticks = 0;
        }

        if (pBlockEntity.ticks >= 5 && pBlockEntity.resonationTicks == 0 && areRaidersNearby(pPos, pBlockEntity.nearbyEntities)) {
            pBlockEntity.resonating = true;
            pLevel.playSound(null, pPos, SoundEvents.BELL_RESONATE, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

        if (pBlockEntity.resonating) {
            if (pBlockEntity.resonationTicks < 40) {
                ++pBlockEntity.resonationTicks;
            } else {
                pResonationEndAction.run(pLevel, pPos, pBlockEntity.nearbyEntities);
                pBlockEntity.resonating = false;
            }
        }

    }

    public static void clientTick(Level pLevel, BlockPos pPos, BlockState pState, GongEntity pBlockEntity) {
        tick(pLevel, pPos, pState, pBlockEntity, GongEntity::showBellParticles);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, GongEntity pBlockEntity) {
        tick(pLevel, pPos, pState, pBlockEntity, GongEntity::makeRaidersGlow);
    }

    public void onHit(Direction pDirection) {
        BlockPos blockPos = this.getBlockPos();
        this.clickDirection = pDirection;
        if (this.shaking) {
            this.ticks = 0;
        } else {
            this.shaking = true;
        }

        this.level.blockEvent(blockPos, this.getBlockState().getBlock(), 1, pDirection.get3DDataValue());
    }

    private void updateEntities() {
        BlockPos blockPos = this.getBlockPos();
        if (this.level.getGameTime() > this.lastRingTimestamp + 60L || this.nearbyEntities == null) {
            this.lastRingTimestamp = this.level.getGameTime();
            AABB $$1 = (new AABB(blockPos)).inflate(48.0);
            this.nearbyEntities = this.level.getEntitiesOfClass(LivingEntity.class, $$1);
        }

        if (!this.level.isClientSide) {
            Iterator var4 = this.nearbyEntities.iterator();

            while(var4.hasNext()) {
                LivingEntity $$2 = (LivingEntity)var4.next();
                if ($$2.isAlive() && !$$2.isRemoved() && blockPos.closerToCenterThan($$2.position(), 32.0)) {
                    $$2.getBrain().setMemory(MemoryModuleType.HEARD_BELL_TIME, this.level.getGameTime());
                }
            }
        }

    }

    private static boolean areRaidersNearby(BlockPos pPos, List<LivingEntity> pRaiders) {
        Iterator var2 = pRaiders.iterator();

        LivingEntity livingEntity;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            livingEntity = (LivingEntity)var2.next();
        } while(!livingEntity.isAlive() || livingEntity.isRemoved() || !pPos.closerToCenterThan(livingEntity.position(), 32.0) || !livingEntity.getType().is(EntityTypeTags.RAIDERS));

        return true;
    }

    private static void makeRaidersGlow(Level level, BlockPos pos, List<LivingEntity> livingEntities) {
        livingEntities.stream().filter((p_155219_) -> isRaiderWithinRange(pos, p_155219_)).forEach(GongEntity::glow);
    }

    private static void showBellParticles(Level level, BlockPos pos, List<LivingEntity> livingEntities) {
        MutableInt $$3 = new MutableInt(16700985);
        int $$4 = (int)livingEntities.stream().filter((p_289508_) -> pos.closerToCenterThan(p_289508_.position(), 48.0)).count();
        livingEntities.stream().filter((p_155213_) -> isRaiderWithinRange(pos, p_155213_)).forEach((p_155195_) -> {
            float $$5 = 1.0F;
            double $$6 = Math.sqrt((p_155195_.getX() - (double)pos.getX()) * (p_155195_.getX() - (double)pos.getX()) + (p_155195_.getZ() - (double)pos.getZ()) * (p_155195_.getZ() - (double)pos.getZ()));
            double $$7 = (double)((float)pos.getX() + 0.5F) + 1.0 / $$6 * (p_155195_.getX() - (double)pos.getX());
            double $$8 = (double)((float)pos.getZ() + 0.5F) + 1.0 / $$6 * (p_155195_.getZ() - (double)pos.getZ());
            int $$9 = Mth.clamp(($$4 - 21) / -2, 3, 15);

            for(int $$10 = 0; $$10 < $$9; ++$$10) {
                int $$11 = $$3.addAndGet(5);
                double $$12 = (double) FastColor.ARGB32.red($$11) / 255.0;
                double $$13 = (double) FastColor.ARGB32.green($$11) / 255.0;
                double $$14 = (double) FastColor.ARGB32.blue($$11) / 255.0;
                level.addParticle(ParticleTypes.ENTITY_EFFECT, $$7, (double)((float)pos.getY() + 0.5F), $$8, $$12, $$13, $$14);
            }

        });
    }

    private static boolean isRaiderWithinRange(BlockPos pPos, LivingEntity pRaider) {
        return pRaider.isAlive() && !pRaider.isRemoved() && pPos.closerToCenterThan(pRaider.position(), 48.0) && pRaider.getType().is(EntityTypeTags.RAIDERS);
    }

    private static void glow(LivingEntity p_58841_) {
        p_58841_.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60));
    }

    @FunctionalInterface
    interface ResonationEndAction {
        void run(Level var1, BlockPos var2, List<LivingEntity> var3);
    }

    protected <E extends GongEntity> PlayState deployAnimController(final AnimationState<E> state) {
        if (shaking){
            state.setAndContinue(RawAnimation.begin().thenPlay("qiaoluo"));
        }else {
            state.setAndContinue(RawAnimation.begin().thenPlay("idle"));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, this::deployAnimController));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
