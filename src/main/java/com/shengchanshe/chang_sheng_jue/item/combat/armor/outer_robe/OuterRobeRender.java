package com.shengchanshe.chang_sheng_jue.item.combat.armor.outer_robe;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.outer_robe.layer.OuterRobeLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class OuterRobeRender extends GeoArmorRenderer<OuterRobe> {
    public OuterRobeRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/outer_robe")));
        this.addRenderLayer(new OuterRobeLayer(this));
    }

    /**
     * 获取盔甲的颜色。如果没有染色，返回默认颜色。
     */
    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof OuterRobe dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        return 0xFFFFFF;
    }
}
