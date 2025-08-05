package com.shengchanshe.chang_sheng_jue.cilent.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.lance.Lance;
import com.shengchanshe.chang_sheng_jue.item.combat.throwingknives.ThrowingKnives;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;
import java.util.WeakHashMap;

@OnlyIn(Dist.CLIENT)
public class EntityExtraLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation CHARGE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/charge.png");
    private final LivingEntityRenderer<T, M> renderer;
    private final Map<LivingEntity, Integer> animationStartTicks = new WeakHashMap<>();

    public EntityExtraLayer(LivingEntityRenderer<T, M> renderer) {
        super(renderer);
        this.renderer = renderer;
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        if (shouldRender(pLivingEntity)) {
            if (!animationStartTicks.containsKey(pLivingEntity)) {
                animationStartTicks.put(pLivingEntity, pLivingEntity.tickCount);
            }

            float fadeInProgress = calculateFadeInProgress(pLivingEntity, pPartialTicks);

            float time = pLivingEntity.tickCount + pPartialTicks;
            float uOffset = this.xOffset(time) % 1.0F;

            VertexConsumer buffer = pBuffer.getBuffer(RenderType.energySwirl(this.getTextureLocation(), uOffset, time * 0.01F % 1.0F));

            EntityModel<T> model = this.renderer.getModel();
            model.prepareMobModel(pLivingEntity, pLimbSwing, pLimbSwingAmount, pPartialTicks);
            this.getParentModel().copyPropertiesTo(model);
            model.setupAnim(pLivingEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);

            if (pLivingEntity.getMainHandItem().getItem() instanceof Lance lance) {
                if (lance.isThrowing && !pLivingEntity.isShiftKeyDown()) {
                    model.renderToBuffer(pPoseStack, buffer, pPackedLight, OverlayTexture.NO_OVERLAY,
                            fadeInProgress, fadeInProgress, fadeInProgress, fadeInProgress);
                }
            }else {
                model.renderToBuffer(pPoseStack, buffer, pPackedLight, OverlayTexture.NO_OVERLAY,
                        fadeInProgress, fadeInProgress, fadeInProgress, fadeInProgress);
            }
//            float $$10 = (float)pLivingEntity.tickCount + pPartialTicks;
//            float animProgress = this.xOffset($$10) % 1.0F;
//            EntityModel<T> model = this.renderer.getModel();
//            model.prepareMobModel(pLivingEntity, pLimbSwing, pLimbSwingAmount, pPartialTicks);
//            this.getParentModel().copyPropertiesTo(model);
//            VertexConsumer buffer = pBuffer.getBuffer(RenderType.energySwirl(this.getTextureLocation(), this.xOffset($$10) % 1.0F, $$10 * 0.01F % 1.0F));
//            model.setupAnim(pLivingEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
//
//            model.renderToBuffer(pPoseStack, buffer, pPackedLight, OverlayTexture.NO_OVERLAY,
//                    animProgress, animProgress, animProgress, animProgress);
        }else {
            animationStartTicks.remove(pLivingEntity);
        }
    }

    private boolean shouldRender(T entity) {
        return entity.isUsingItem() &&
                entity.getMainHandItem().getItem() instanceof SwordItem &&
                !(entity.getMainHandItem().getItem() instanceof ThrowingKnives);
    }

    // 新增：计算渐入进度（20 tick = 1秒内从0→0.5）
    private float calculateFadeInProgress(T entity, float partialTicks) {
        int startTick = animationStartTicks.getOrDefault(entity, entity.tickCount);
        float elapsed = (entity.tickCount - startTick) + partialTicks;
        return Math.min(elapsed / 6.0F, 1.0F) * 0.5F; // 限制最大0.5
    }

    protected float xOffset(float pTickCount) {
        return pTickCount * 0.01F;
    }

    protected ResourceLocation getTextureLocation() {
        return CHARGE_TEXTURE;
    }
}