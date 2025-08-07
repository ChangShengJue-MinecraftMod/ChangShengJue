package com.shengchanshe.chang_sheng_jue.item.combat.armor.confucian_costumes;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.confucian_costumes.layer.ConfucianCostumesLayer;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.cotton.CottonArmor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ConfucianCostumesRender extends GeoArmorRenderer<ConfucianCostumes> {

    public ConfucianCostumesRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/confucian_costumes")));
        this.addRenderLayer(new ConfucianCostumesLayer(this));
    }

    /**
     * 获取盔甲的颜色。如果没有染色，返回默认颜色。
     */
    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof ConfucianCostumes dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        // 如果物品不是可染色盔甲，返回默认白色
        return 0xFFFFFF;
    }
}
