package com.shengchanshe.chang_sheng_jue.entity.combat.golden_black_knife_method;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class GoldenBlackKnifeMethodEntity extends Projectile{
    public GoldenBlackKnifeMethodEntity(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.noPhysics = true;
    }

    @Override
    protected void defineSynchedData() {
    }


    @Override
    public void tick() {
        if (!firstTick) {
            firstTick = true;
        }
        if (tickCount >= 9){
            discard();
        }
    }

    @Override
    public boolean shouldBeSaved() {
        return false;
    }

    @Override
    public void refreshDimensions() {
        return;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
