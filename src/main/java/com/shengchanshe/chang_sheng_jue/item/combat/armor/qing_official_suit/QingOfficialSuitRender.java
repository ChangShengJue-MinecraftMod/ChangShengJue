package com.shengchanshe.chang_sheng_jue.item.combat.armor.qing_official_suit;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.qing_official_suit.layer.QingOfficialSuitRenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class QingOfficialSuitRender extends GeoArmorRenderer<QingOfficialSuit> {
    public QingOfficialSuitRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/qing_official_suit")));
        this.addRenderLayer(new QingOfficialSuitRenderLayer(this));
    }

    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof QingOfficialSuit dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        return 0xFFFFFF;
    }
}
