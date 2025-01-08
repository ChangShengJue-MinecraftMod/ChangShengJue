package com.shengchanshe.changshengjue.item.combat.armor.taoistrobes;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.layer.MaleTaoistRobesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MaleTaoistRobesRender extends GeoArmorRenderer<MaleTaoistRobes> {
    public MaleTaoistRobesRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/male_taoist_robes")));
        this.addRenderLayer(new MaleTaoistRobesLayer(this));
    }

    /**
     * 获取盔甲的颜色。如果没有染色，返回默认颜色。
     */
    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof MaleTaoistRobes dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        // 如果物品不是可染色盔甲，返回默认白色
        return 0xFFFFFF;
    }
}
