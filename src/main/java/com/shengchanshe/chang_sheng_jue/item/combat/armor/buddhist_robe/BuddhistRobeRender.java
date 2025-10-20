package com.shengchanshe.chang_sheng_jue.item.combat.armor.buddhist_robe;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.buddhist_robe.layer.BuddhistRobeRenderLayer;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.hats.with_veil.HatsWithVeil;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.hats.with_veil.layer.HatsWithVeilRenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BuddhistRobeRender extends GeoArmorRenderer<BuddhistRobe> {

    public BuddhistRobeRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/buddhist_robe")));
        this.addRenderLayer(new BuddhistRobeRenderLayer(this));
    }

    /**
     * 获取盔甲的颜色。如果没有染色，返回默认颜色。
     */
    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof BuddhistRobe dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        // 如果物品不是可染色盔甲，返回默认白色
        return 0xFFFFFF;
    }
}
