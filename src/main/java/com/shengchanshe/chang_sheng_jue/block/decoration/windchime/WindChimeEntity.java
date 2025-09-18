package com.shengchanshe.chang_sheng_jue.block.decoration.windchime;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.util.ClientUtils;
import software.bernie.geckolib.util.GeckoLibUtil;

public class WindChimeEntity extends BlockEntity implements GeoBlockEntity {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public WindChimeEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.WIND_CHIME_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(((new AnimationController<>(this, "idle", 0, (state) ->
                state.setAndContinue(DefaultAnimations.IDLE))
        ).setSoundKeyframeHandler((state) -> {
            Player player = ClientUtils.getClientPlayer();
            Level level1 = ClientUtils.getLevel();
            if (player != null && player.getRandom().nextFloat() < 0.2F) {
                Vec3 pos = this.getBlockPos().getCenter();
                float distToPlayer = (float) pos.distanceTo(player.position());
                float volume = calculateVolume(distToPlayer, 4.0f, 16.0f, 0.3f);

                level1.playSound(
                        player, // 非实体音源
                        pos.x, pos.y, pos.z,
                        ChangShengJueSound.WIND_CHIME_SOUND.get(),
                        SoundSource.RECORDS,
                        volume,
                        1.0f // 固定音高
                );
//                level1.playSound(player,this.getBlockPos(), ChangShengJueSound.WIND_CHIME_SOUND.get(), SoundSource.BLOCKS, 0.1F, 1.0F);
            }})));
    }
    private static float calculateVolume(float distance, float refDist, float maxDist, float baseVol) {
        float clampedDist = Mth.clamp(distance, refDist, maxDist);
        return baseVol * (1.0f - (clampedDist - refDist) / (maxDist - refDist));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}