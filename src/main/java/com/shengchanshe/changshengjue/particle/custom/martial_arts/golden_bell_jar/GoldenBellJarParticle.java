//package com.shengchanshe.changshengjue.particle.custom.martial_arts.golden_bell_jar;
//
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import net.minecraft.client.Camera;
//import net.minecraft.client.multiplayer.ClientLevel;
//import net.minecraft.client.particle.*;
//import net.minecraft.client.renderer.LightTexture;
//import net.minecraft.core.particles.SimpleParticleType;
//import net.minecraft.util.Mth;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//@OnlyIn(Dist.CLIENT)
//public class GoldenBellJarParticle extends TextureSheetParticle {
//    private final float endRed;
//    private final float endGreen;
//    private final float endBlue;
//    protected GoldenBellJarParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
//                                    SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pZSpeed) {
//        super(level, xCoord, yCoord, zCoord, pXSpeed, pYSpeed, pZSpeed);
//        this.rCol = 1.0f;
//        this.gCol = 0.69f;
//        this.bCol = 0.22f;
//        this.endRed = 1.0f;
//        this.endGreen = 1.0f;
//        this.endBlue = 0.0f;
//        this.pickSprite(spriteSet);
//        this.xd = pXSpeed;
//        this.yd = pYSpeed;
//        this.zd = pZSpeed;
//        this.quadSize *= 0.4F;
//        this.lifetime = 40;
//        this.friction = 1.0F;
//        this.setSpriteFromAge(spriteSet);
//        this.gravity = -0.015F;
//        this.alpha = 0.0F;
//
//        this.hasPhysics = false; // 粒子是否可以被碰撞
//    }
//
//    @Override
//    public void tick() {
//        super.tick();
//        float lifeRatio = (float) this.age / this.lifetime; // 当前生命比例（0到1之间）
//        // 透明度公式：从透明 -> 不透明 -> 透明
//        this.alpha = (float) Math.sin(Math.PI * lifeRatio);
//
//        if (this.alpha >= 0.7){
//            // 根据生命周期进度插值计算颜色
//            float red = this.rCol + lifeRatio * (endRed - this.rCol);
//            float green = this.gCol + lifeRatio * (endGreen - this.gCol);
//            float blue = this.bCol + lifeRatio * (endBlue - this.bCol);
//            // 设置当前颜色
//            this.setColor(red, green, blue);
//        }
//    }
//    @Override
//    public void render(VertexConsumer buffer, Camera camera, float partialTicks) {
//        // 粒子中心位置，相对于相机
//        float centerX = (float) (Mth.lerp(partialTicks, this.xo, this.x) - camera.getPosition().x());
//        float centerY = (float) (Mth.lerp(partialTicks, this.yo, this.y) - camera.getPosition().y());
//        float centerZ = (float) (Mth.lerp(partialTicks, this.zo, this.z) - camera.getPosition().z());
//
//        float scale = this.getQuadSize(partialTicks);
//
//        float x1 = -scale;
//        float y1 = -scale;
//        float z1 = 0;
//
//        float x2 = -scale;
//        float y2 = scale;
//        float z2 = 0;
//
//        float x3 = scale;
//        float y3 = scale;
//        float z3 = 0;
//
//        float x4 = scale;
//        float y4 = -scale;
//        float z4 = 0;
//
//        float yaw = camera.getYRot(); // 获取玩家的水平旋转角度（Yaw）
//        float cosYaw = Mth.cos(yaw * ((float) Math.PI / 180F));
//        float sinYaw = Mth.sin(yaw * ((float) Math.PI / 180F));
//
//        float rx1 = x1 * cosYaw - z1 * sinYaw;
//        float rz1 = x1 * sinYaw + z1 * cosYaw;
//
//        float rx2 = x2 * cosYaw - z2 * sinYaw;
//        float rz2 = x2 * sinYaw + z2 * cosYaw;
//
//        float rx3 = x3 * cosYaw - z3 * sinYaw;
//        float rz3 = x3 * sinYaw + z3 * cosYaw;
//
//        float rx4 = x4 * cosYaw - z4 * sinYaw;
//        float rz4 = x4 * sinYaw + z4 * cosYaw;
//
//        float u0 = this.sprite.getU0();
//        float u1 = this.sprite.getU1();
//        float v0 = this.sprite.getV0();
//        float v1 = this.sprite.getV1();
//
//        int light = LightTexture.FULL_BRIGHT;
//
//        buffer.vertex(centerX + rx1, centerY + y1, centerZ + rz1).uv(u0, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
//        buffer.vertex(centerX + rx2, centerY + y2, centerZ + rz2).uv(u0, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
//        buffer.vertex(centerX + rx3, centerY + y3, centerZ + rz3).uv(u1, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
//        buffer.vertex(centerX + rx4, centerY + y4, centerZ + rz4).uv(u1, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
//    }
//    @Override
//    public int getLightColor(float partialTick) {
//        return LightTexture.FULL_BRIGHT; // 返回最大亮度值
//    }
//
//    @Override
//    public ParticleRenderType getRenderType() {
//        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
//    }
//
//    @OnlyIn(Dist.CLIENT)
//    public static class Provider implements ParticleProvider<SimpleParticleType> {
//        private final SpriteSet sprites;
//
//        public Provider(SpriteSet spriteSet) {
//            this.sprites = spriteSet;
//        }
//
//        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
//                                       double x, double y, double z,
//                                       double pXSpeed, double pYSpeed, double pZSpeed) {
//            GoldenBellJarParticle particle = new GoldenBellJarParticle(level, x, y, z, this.sprites, pXSpeed, pYSpeed, pZSpeed);
//            particle.pickSprite(this.sprites); // 随机选择一张纹理贴图
//            return particle;
//        }
//    }
//}