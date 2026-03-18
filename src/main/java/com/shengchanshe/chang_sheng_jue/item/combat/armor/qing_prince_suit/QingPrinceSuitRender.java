package com.shengchanshe.chang_sheng_jue.item.combat.armor.qing_prince_suit;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.qing_prince_suit.layer.QingPrinceSuitRenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class QingPrinceSuitRender extends GeoArmorRenderer<QingPrinceSuit> {
    public QingPrinceSuitRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/qing_prince_suit")));
        this.addRenderLayer(new QingPrinceSuitRenderLayer(this));
    }

    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof QingPrinceSuit dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        return 0xFFFFFF;
    }
}
