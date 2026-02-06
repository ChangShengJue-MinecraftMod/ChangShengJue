package com.shengchanshe.chang_sheng_jue.item.combat.armor.side_fastening_leather;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.cotton.CottonArmor;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.cotton.layer.CottonArmorLayer;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.side_fastening_leather.layer.SideFasteningLeatherArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SideFasteningLeatherArmorRender extends GeoArmorRenderer<SideFasteningLeatherArmor> {
    public SideFasteningLeatherArmorRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/side_fastening_leather_armor")));
        this.addRenderLayer(new SideFasteningLeatherArmorLayer(this));
    }

    /**
     * 获取盔甲的颜色。如果没有染色，返回默认颜色。
     */
    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof SideFasteningLeatherArmor dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        return 0xFFFFFF;
    }
}
