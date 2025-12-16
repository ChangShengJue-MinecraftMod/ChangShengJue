package com.shengchanshe.chang_sheng_jue.item.combat.armor.headdress.forehead_band;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ForeheadBand2Render extends GeoArmorRenderer<ForeheadBand2> {

    public ForeheadBand2Render() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/forehead_band2")));
    }

    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof ForeheadBand2 dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        return 0xFFFFFF;
    }
}
