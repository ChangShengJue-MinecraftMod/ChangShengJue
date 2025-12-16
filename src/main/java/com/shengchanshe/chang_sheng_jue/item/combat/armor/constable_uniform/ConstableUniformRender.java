package com.shengchanshe.chang_sheng_jue.item.combat.armor.constable_uniform;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.constable_uniform.layer.ConstableUniformRenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ConstableUniformRender extends GeoArmorRenderer<ConstableUniform> {

    public ConstableUniformRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/constable_uniform")));
        this.addRenderLayer(new ConstableUniformRenderLayer(this));
    }

    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof ConstableUniform dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        return 0xFFFFFF;
    }
}
