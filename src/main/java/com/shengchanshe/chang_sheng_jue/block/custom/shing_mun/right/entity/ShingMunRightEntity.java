package com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.right.entity;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.right.ShingMunRight;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ShingMunRightEntity extends BlockEntity implements GeoBlockEntity {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean open;
    private boolean left;

    private boolean one;
    private boolean two;
    private boolean three;
    private boolean four;
    private boolean five;
    private boolean six;
    private boolean seven;
    private boolean eight;

    public ShingMunRightEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.SHING_MUN_RIGHT_ENTITY.get(), pPos, pBlockState);
        this.open = pBlockState.getValue(ShingMunRight.OPEN); // 初始化时从 BlockState 获取值
        this.left = pBlockState.getValue(ShingMunRight.LEFT); // 初始化时从 BlockState 获取值

        this.one = pBlockState.getValue(ShingMunRight.ONE); // 初始化时从 BlockState 获取值
        this.two = pBlockState.getValue(ShingMunRight.TWO); // 初始化时从 BlockState 获取值
        this.three = pBlockState.getValue(ShingMunRight.THREE); // 初始化时从 BlockState 获取值
        this.four = pBlockState.getValue(ShingMunRight.FOUR); // 初始化时从 BlockState 获取值
        this.five = pBlockState.getValue(ShingMunRight.FIVE); // 初始化时从 BlockState 获取值
        this.six = pBlockState.getValue(ShingMunRight.SIX); // 初始化时从 BlockState 获取值
        this.seven = pBlockState.getValue(ShingMunRight.SEVEN); // 初始化时从 BlockState 获取值
        this.eight = pBlockState.getValue(ShingMunRight.EIGHT); // 初始化时从 BlockState 获取值
    }

    public boolean isOne() {
        return one;
    }

    public boolean isTwo() {
        return two;
    }

    public boolean isThree() {
        return three;
    }

    public boolean isFour() {
        return four;
    }

    public boolean isFive() {
        return five;
    }


    public boolean isSix() {
        return six;
    }

    public boolean isSeven() {
        return seven;
    }

    public boolean isEight() {
        return eight;
    }

    public void setOpen(boolean open) {
        this.open = open;

        // 更新 BlockState
        if (this.level != null) {
            BlockState state = this.getBlockState();
            if (state.getValue(ShingMunRight.OPEN) != open) {
                this.level.setBlockAndUpdate(this.worldPosition, state.setValue(ShingMunRight.OPEN, open));
            }
        }
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean("Open", this.open);
        tag.putBoolean("Left", this.left);

        tag.putBoolean("One", this.one);
        tag.putBoolean("Two", this.two);
        tag.putBoolean("Three", this.three);
        tag.putBoolean("Four", this.four);
        tag.putBoolean("Five", this.five);
        tag.putBoolean("Six", this.six);
        tag.putBoolean("Seven", this.seven);
        tag.putBoolean("Eight", this.eight);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.open = tag.getBoolean("Open");
        this.left = tag.getBoolean("Left");

        this.one =  tag.getBoolean("One");
        this.two =  tag.getBoolean("Two");
        this.three = tag.getBoolean("Three");
        this.four = tag.getBoolean("Four");
        this.five = tag.getBoolean("Five");
        this.six = tag.getBoolean("Six");
        this.seven = tag.getBoolean("Seven");
        this.eight = tag.getBoolean("Eight");
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        this.open = tag.getBoolean("Open");
        this.left = tag.getBoolean("Left");

        this.one =  tag.getBoolean("One");
        this.two =  tag.getBoolean("Two");
        this.three = tag.getBoolean("Three");
        this.four = tag.getBoolean("Four");
        this.five = tag.getBoolean("Five");
        this.six = tag.getBoolean("Six");
        this.seven = tag.getBoolean("Seven");
        this.eight = tag.getBoolean("Eight");
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        tag.putBoolean("Open", this.open);
        tag.putBoolean("Left", this.left);

        tag.putBoolean("One", this.one);
        tag.putBoolean("Two", this.two);
        tag.putBoolean("Three", this.three);
        tag.putBoolean("Four", this.four);
        tag.putBoolean("Five", this.five);
        tag.putBoolean("Six", this.six);
        tag.putBoolean("Seven", this.seven);
        tag.putBoolean("Eight", this.eight);
        return tag;
    }

    public boolean isOpen() {
        return open;
    }

    public boolean isLeft() {
        return left;
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        this.load(pkt.getTag());
    }

    @Override
    public void setChanged() {
        super.setChanged();
        if (this.level != null){
            this.level.sendBlockUpdated(this.getBlockPos(),this.getBlockState(),this.getBlockState(), Block.UPDATE_CLIENTS);
        }
    }

    protected <E extends ShingMunRightEntity> PlayState deployAnimController(final AnimationState<E> state) {
//        if (isRest()){
//            if (isOpen()){
//                state.setAndContinue(RawAnimation.begin().thenPlay("开门"));
//            }else {
//                state.setAndContinue(RawAnimation.begin().thenPlay("关门"));
//            }
//            return PlayState.CONTINUE;
//        }else {
        return PlayState.STOP;
//        }
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
