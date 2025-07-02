package com.shengchanshe.chang_sheng_jue.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;

public class HorizontalParticle extends SimpleAnimatedParticle {
    protected HorizontalParticle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet pSprites, float pGravity) {
        super(pLevel, pX, pY, pZ, pSprites, pGravity);
    }

}
