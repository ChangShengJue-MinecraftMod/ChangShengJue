package com.shengchanshe.chang_sheng_jue.item.combat.armor.qing_soldier_armor;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.qing_soldier_armor.layer.QingSoldierRenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class QingSoldierArmorRender extends GeoArmorRenderer<QingSoldierArmor> {
    public QingSoldierArmorRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/qing_soldier_armor")));
        this.addRenderLayer(new QingSoldierRenderLayer(this));
    }

    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof QingSoldierArmor dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        return 0xFFFFFF;
    }
}
