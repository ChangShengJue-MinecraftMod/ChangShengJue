package com.shengchanshe.chang_sheng_jue.block.custom.forgeblock;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase.TailoringCaseEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class ForgeBlockEntityModel extends DefaultedBlockGeoModel<ForgeBlockEntity> {
    public ForgeBlockEntityModel() {
        super(new ResourceLocation(ChangShengJue.MOD_ID, "forge_block"));
    }

    public RenderType getRenderType(ForgeBlockEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(this.getTextureResource(animatable));
    }
}
