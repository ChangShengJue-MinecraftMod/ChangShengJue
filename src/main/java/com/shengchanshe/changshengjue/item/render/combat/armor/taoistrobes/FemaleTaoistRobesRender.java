package com.shengchanshe.changshengjue.item.render.combat.armor.taoistrobes;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.FemaleTaoistRobes;
import com.shengchanshe.changshengjue.item.render.combat.armor.taoistrobes.layer.FemaleTaoistRobesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FemaleTaoistRobesRender extends GeoArmorRenderer<FemaleTaoistRobes> {
    public FemaleTaoistRobesRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/female_taoist_robes")));
        this.addRenderLayer(new FemaleTaoistRobesLayer(this));
    }

    /**
     * 获取盔甲的颜色。如果没有染色，返回默认颜色。
     */
    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof FemaleTaoistRobes dyeableArmorItem) {
            if (!stack.is(ChangShengJueItems.FEMALE_TAOIST_ROBES_HELMET.get())){
                return dyeableArmorItem.getColor(stack);
            }
        }
        // 如果物品不是可染色盔甲，返回默认白色
        return 0xFFFFFF;
    }
}
