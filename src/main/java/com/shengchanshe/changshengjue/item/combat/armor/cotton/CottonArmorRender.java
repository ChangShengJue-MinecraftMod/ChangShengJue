package com.shengchanshe.changshengjue.item.combat.armor.cotton;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.armor.cotton.layer.CottonArmorFeatherLayer;
import com.shengchanshe.changshengjue.item.combat.armor.cotton.layer.CottonArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class CottonArmorRender extends GeoArmorRenderer<CottonArmor> {
    public CottonArmorRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/cotton_armor")));
        this.addRenderLayer(new CottonArmorLayer(this));
        this.addRenderLayer(new CottonArmorFeatherLayer(this));
    }

    /**
     * 获取盔甲的颜色。如果没有染色，返回默认颜色。
     */
    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof CottonArmor dyeableArmorItem) {
            if (stack.is(ChangShengJueItems.COTTON_ARMOR_FEATHER_HELMET.get()) || stack.is(ChangShengJueItems.COTTON_ARMOR_WHITE_FEATHER_HELMET.get()) ||
                    stack.is(ChangShengJueItems.COTTON_ARMOR_CHESTPLATE.get()) || stack.is(ChangShengJueItems.COTTON_ARMOR_LEGGINGS.get()) || stack.is(ChangShengJueItems.COTTON_ARMOR_BOOTS.get())){
                return dyeableArmorItem.getColor(stack);
            }
        }
        // 如果物品不是可染色盔甲，返回默认白色
        return 0xFFFFFF;
    }
}
