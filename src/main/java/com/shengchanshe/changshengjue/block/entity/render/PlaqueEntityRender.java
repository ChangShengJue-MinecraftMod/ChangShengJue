package com.shengchanshe.changshengjue.block.entity.render;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.shengchanshe.changshengjue.block.entity.PlaqueEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Map;

public class PlaqueEntityRender implements BlockEntityRenderer<PlaqueEntity> {
    private static final int OUTLINE_RENDER_DISTANCE = Mth.square(16);
    private static final Vec3 TEXT_OFFSET = new Vec3(0.0D, 0.33333334F, 0.076666667F);
    private final Map<WoodType, SignModel> signModels;
    private final Font font;

    public PlaqueEntityRender(BlockEntityRendererProvider.Context pContext) {
        this.signModels = WoodType.values().collect(ImmutableMap.toImmutableMap((p_173645_) -> p_173645_, (p_173651_) -> new  SignModel(pContext.bakeLayer(ModelLayers.createSignModelName(p_173651_)))));
        this.font = pContext.getFont();
    }

    public void render( PlaqueEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        BlockState blockstate = pBlockEntity.getBlockState();
        SignBlock signblock = (SignBlock)blockstate.getBlock();
        WoodType woodtype = SignBlock.getWoodType(signblock);
        SignModel signrenderer$signmodel = this.signModels.get(woodtype);
        signrenderer$signmodel.paibian.visible = blockstate.getBlock() instanceof StandingSignBlock;
        this.renderSignWithText(pBlockEntity, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, blockstate, signblock, woodtype, signrenderer$signmodel);
    }

    public float getSignModelRenderScale() {
        return 0.0666667F;
    }

    public float getSignTextRenderScale() {
        return 0.6666667F;
    }

    void renderSignWithText(PlaqueEntity pSignEntity, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay, BlockState pState, SignBlock pSignBlock, WoodType pWoodType, Model pModel) {
        pPoseStack.pushPose();
        this.translateSign(pPoseStack, -pSignBlock.getYRotationDegrees(pState), pState);
        this.renderSignText(pSignEntity.getBlockPos(), pSignEntity.getFrontText(), pPoseStack, pBuffer, pPackedLight, pSignEntity.getTextLineHeight(), pSignEntity.getMaxTextLineWidth(), true);
        this.renderSignText(pSignEntity.getBlockPos(), pSignEntity.getBackText(), pPoseStack, pBuffer, pPackedLight, pSignEntity.getTextLineHeight(), pSignEntity.getMaxTextLineWidth(), false);
        pPoseStack.popPose();
    }

    void translateSign(PoseStack pPoseStack, float pYRot, BlockState pState) {
        pPoseStack.translate(0.5F, 0.75F * this.getSignModelRenderScale(), 0.46F);
        if (!(pState.getBlock() instanceof StandingSignBlock)) {
            pPoseStack.mulPose(Axis.YP.rotationDegrees(pYRot));
            pPoseStack.translate(0.0F, 0.1F, -0.4F);
        }
    }

    void renderSignText(BlockPos pPos, SignText pText, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pLineHeight, int pMaxWidth, boolean pIsFrontText) {
        pPoseStack.pushPose();
        this.translateSignText(pPoseStack, pIsFrontText, this.getTextOffset());
        int i = getDarkColor(pText);
        int j = 4 * pLineHeight / 2;
        FormattedCharSequence[] aformattedcharsequence = pText.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), (p_277227_) -> {
            List<FormattedCharSequence> list = this.font.split(p_277227_, pMaxWidth);
            return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
        });
        int k;
        boolean flag;
        int l;
        if (pText.hasGlowingText()) {
            k = pText.getColor().getTextColor();
            flag = isOutlineVisible(pPos, k);
            l = 15728880;
        } else {
            k = i;
            flag = false;
            l = pPackedLight;
        }

        for(int i1 = 0; i1 < 4; ++i1) {
            FormattedCharSequence formattedcharsequence = aformattedcharsequence[i1];
            float f = (float)(-this.font.width(formattedcharsequence) / 2);
            if (flag) {
                this.font.drawInBatch8xOutline(formattedcharsequence, f, (float)(i1 * pLineHeight - j), k, i, pPoseStack.last().pose(), pBuffer, l);
            } else {
                this.font.drawInBatch(formattedcharsequence, f, (float)(i1 * pLineHeight - j), k, false, pPoseStack.last().pose(), pBuffer, Font.DisplayMode.POLYGON_OFFSET, 0, l);
            }
        }

        pPoseStack.popPose();
    }

    private void translateSignText(PoseStack pPoseStack, boolean pIsFrontText, Vec3 pOffset) {
        if (!pIsFrontText) {
            pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        }

        float f = 0.012327F * this.getSignTextRenderScale();
        pPoseStack.translate(pOffset.x, pOffset.y, pOffset.z);
        pPoseStack.scale(f, -f, f);
    }

    Vec3 getTextOffset() {
        return TEXT_OFFSET;
    }

    static boolean isOutlineVisible(BlockPos pPos, int pTextColor) {
        if (pTextColor == DyeColor.BLACK.getTextColor()) {
            return true;
        } else {
            Minecraft minecraft = Minecraft.getInstance();
            LocalPlayer localplayer = minecraft.player;
            if (localplayer != null && minecraft.options.getCameraType().isFirstPerson() && localplayer.isScoping()) {
                return true;
            } else {
                Entity entity = minecraft.getCameraEntity();
                return entity != null && entity.distanceToSqr(Vec3.atCenterOf(pPos)) < (double)OUTLINE_RENDER_DISTANCE;
            }
        }
    }

    static int getDarkColor(SignText pSignText) {
        int i = pSignText.getColor().getTextColor();
        if (i == DyeColor.BLACK.getTextColor() && pSignText.hasGlowingText()) {
            return -988212;
        } else {
            double d0 = 0.4D;
            int j = (int)((double) FastColor.ARGB32.red(i) * 0.4D);
            int k = (int)((double)FastColor.ARGB32.green(i) * 0.4D);
            int l = (int)((double)FastColor.ARGB32.blue(i) * 0.4D);
            return FastColor.ARGB32.color(0, j, k, l);
        }
    }


    @OnlyIn(Dist.CLIENT)
    public static final class SignModel extends Model {
        private final ModelPart paibian;

        public SignModel(ModelPart root) {
            super(RenderType::entityCutoutNoCull);
            this.paibian = root;
        }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
            paibian.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }
}