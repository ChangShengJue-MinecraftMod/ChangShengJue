package com.shengchanshe.chang_sheng_jue.item.combat.armor.flying_fish_robe;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.flying_fish_robe.layer.FlyingFishRobeHelmetLayer;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.flying_fish_robe.layer.FlyingFishRobeLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FlyingFishRobeRender extends GeoArmorRenderer<FlyingFishRobe> {
    public FlyingFishRobeRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/flying_fish_robe")));
        this.addRenderLayer(new FlyingFishRobeHelmetLayer(this));
        this.addRenderLayer(new FlyingFishRobeLayer(this));
    }

    /**
     * 获取盔甲的颜色。如果没有染色，返回默认颜色。
     */
    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof FlyingFishRobe dyeableArmorItem) {
            if (!stack.is(ChangShengJueItems.FLY_FISH_IRON_HAT.get())){
                return dyeableArmorItem.getColor(stack);
            }
        }
        // 如果物品不是可染色盔甲，返回默认白色
        return 0xFFFFFF;
    }
}
