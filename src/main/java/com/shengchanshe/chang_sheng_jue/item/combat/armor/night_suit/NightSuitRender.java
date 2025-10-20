package com.shengchanshe.chang_sheng_jue.item.combat.armor.night_suit;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.buddhist_robe.BuddhistRobe;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.buddhist_robe.layer.BuddhistRobeRenderLayer;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.night_suit.layer.NightSuitRenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NightSuitRender extends GeoArmorRenderer<NightSuit> {

    public NightSuitRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/night_suit")));
        this.addRenderLayer(new NightSuitRenderLayer(this));
    }

    /**
     * 获取盔甲的颜色。如果没有染色，返回默认颜色。
     */
    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof NightSuit dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        // 如果物品不是可染色盔甲，返回默认白色
        return 0xFFFFFF;
    }
}
