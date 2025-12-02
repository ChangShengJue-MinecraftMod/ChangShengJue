package com.shengchanshe.chang_sheng_jue.block.custom.furniture.bamboo_mat;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class BambooMatEntity extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private DyeColor color;

    public BambooMatEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.BAMBOO_MAT_ENTITY.get(), pPos, pBlockState);
        this.color = ((BedBlock)pBlockState.getBlock()).getColor();
    }

    public BambooMatEntity(BlockPos pPos, BlockState pBlockState, DyeColor pColor) {
        super(ChangShengJueBlocksEntities.BAMBOO_MAT_ENTITY.get(), pPos, pBlockState);
        this.color = pColor;
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public DyeColor getColor() {
        return this.color;
    }

    public void setColor(DyeColor pColor) {
        this.color = pColor;
    }

    protected <E extends BambooMatEntity> PlayState deployAnimController(final AnimationState<E> state) {
        state.setAndContinue(RawAnimation.begin().thenPlay("zhuxi_open"));
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
