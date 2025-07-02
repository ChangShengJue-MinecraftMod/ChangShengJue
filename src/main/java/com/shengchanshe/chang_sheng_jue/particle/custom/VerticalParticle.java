package com.shengchanshe.chang_sheng_jue.particle.custom;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VerticalParticle extends TextureSheetParticle {

    protected VerticalParticle(ClientLevel pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ);
    }

    protected VerticalParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTicks) {
        if (Float.isNaN((float) this.x)) return;

        Vec3 camPos = camera.getPosition();
        float centerX = (float)(Mth.lerp(partialTicks, this.xo, this.x) - camPos.x());
        float centerY = (float)(Mth.lerp(partialTicks, this.yo, this.y) - camPos.y());
        float centerZ = (float)(Mth.lerp(partialTicks, this.zo, this.z) - camPos.z());

        float yaw = camera.getYRot() * (float)Math.PI / 180F;
        float cosYaw = Mth.cos(yaw);
        float sinYaw = Mth.sin(yaw);

        float size = Math.max(this.getQuadSize(partialTicks), 0.01f);
        float[] xCoords = { -size, -size, size, size };
        float[] yCoords = { -size, size, size, -size };
        float[] zCoords = { 0, 0, 0, 0 };

        for (int i = 0; i < 4; i++) {
            float x = xCoords[i];
            float z = zCoords[i];
            xCoords[i] = x * cosYaw - z * sinYaw;
            zCoords[i] = x * sinYaw + z * cosYaw;
        }

        float u0 = this.getU0();
        float u1 = this.getU1();
        float v0 = this.getV0();
        float v1 = this.getV1();
        int light = this.getLightColor(partialTicks);
        float[] uCoords = { u0, u0, u1, u1 };
        float[] vCoords = { v1, v0, v0, v1 };

        for (int i = 0; i < 4; i++) {
            buffer.vertex(centerX + xCoords[i], centerY + yCoords[i], centerZ + zCoords[i])
                    .uv(uCoords[i], vCoords[i])
                    .color(rCol, gCol, bCol, alpha)
                    .uv2(light)
                    .endVertex();
        }
    }

    public void verticalRenderer(VertexConsumer buffer, Camera camera, float partialTicks, float width, float height) {
        Vec3 camPos = camera.getPosition();
        float centerX = (float)(Mth.lerp(partialTicks, this.xo, this.x) - camPos.x());
        float centerY = (float)(Mth.lerp(partialTicks, this.yo, this.y) - camPos.y());
        float centerZ = (float)(Mth.lerp(partialTicks, this.zo, this.z) - camPos.z());

        float yawRad = camera.getYRot() * (float)Math.PI / 180F;
        float cosYaw = Mth.cos(yawRad);
        float sinYaw = Mth.sin(yawRad);

        float[] xCoords = { -width, -width, width, width };
        float[] yCoords = { 0f, height, height, 0f };
        float[] zCoords = { 0f, 0f, 0f, 0f };

        float u0 = this.sprite.getU0();
        float u1 = this.sprite.getU1();
        float v0 = this.sprite.getV0();
        float v1 = this.sprite.getV1();
        int light = LightTexture.FULL_BRIGHT;

        for (int i = 0; i < 4; i++) {
            // 应用旋转（绕Y轴）
            float rx = xCoords[i] * cosYaw - zCoords[i] * sinYaw;
            float rz = xCoords[i] * sinYaw + zCoords[i] * cosYaw;

            buffer.vertex(centerX + rx,centerY + yCoords[i],centerZ + rz).uv(i < 2 ? u0 : u1, i % 3 == 0 ? v1 : v0)
                    .color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

//    @Override
//    public void render(VertexConsumer buffer, Camera camera, float partialTicks) {
//        Vec3 camPos = camera.getPosition();
//        float centerX = (float)(Mth.lerp(partialTicks, this.xo, this.x) - camPos.x());
//        float centerY = (float)(Mth.lerp(partialTicks, this.yo, this.y) - camPos.y());
//        float centerZ = (float)(Mth.lerp(partialTicks, this.zo, this.z) - camPos.z());
//
//        float yaw = camera.getYRot() * (float)Math.PI / 180F;
//        float cosYaw = Mth.cos(yaw);
//        float sinYaw = Mth.sin(yaw);
//
//        float size = this.getQuadSize(partialTicks);
//        float[] xCoords = { -size, -size, size, size };
//        float[] yCoords = { -size, size, size, -size };
//        float[] zCoords = { 0, 0, 0, 0 };
//
//        for (int i = 0; i < 4; i++) {
//            float rx = xCoords[i] * cosYaw - zCoords[i] * sinYaw;
//            float rz = xCoords[i] * sinYaw + zCoords[i] * cosYaw;
//            xCoords[i] = rx;
//            zCoords[i] = rz;
//        }
//
//        renderQuad(buffer, centerX, centerY, centerZ, xCoords, yCoords, zCoords);
//    }
//
//
//    private void renderQuad(VertexConsumer buffer, float cx, float cy, float cz,
//                            float[] x, float[] y, float[] z) {
//        float u0 = this.sprite.getU0();
//        float u1 = this.sprite.getU1();
//        float v0 = this.sprite.getV0();
//        float v1 = this.sprite.getV1();
//        int light = LightTexture.FULL_BRIGHT;
//
//        // 正面
//        buffer.vertex(cx + x[0], cy + y[0], cz + z[0]).uv(u0, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
//        buffer.vertex(cx + x[1], cy + y[1], cz + z[1]).uv(u0, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
//        buffer.vertex(cx + x[2], cy + y[2], cz + z[2]).uv(u1, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
//        buffer.vertex(cx + x[3], cy + y[3], cz + z[3]).uv(u1, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
//
////        // 背面
////        buffer.vertex(cx + x[3], cy + y[3], cz + z[3]).uv(u1, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
////        buffer.vertex(cx + x[2], cy + y[2], cz + z[2]).uv(u1, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
////        buffer.vertex(cx + x[1], cy + y[1], cz + z[1]).uv(u0, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
////        buffer.vertex(cx + x[0], cy + y[0], cz + z[0]).uv(u0, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
//    }
}
