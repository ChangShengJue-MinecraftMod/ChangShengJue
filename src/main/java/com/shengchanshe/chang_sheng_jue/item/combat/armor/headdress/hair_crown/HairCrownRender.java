package com.shengchanshe.chang_sheng_jue.item.combat.armor.headdress.hair_crown;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.headdress.forehead_band.ForeheadBand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class HairCrownRender extends GeoArmorRenderer<ForeheadBand> {

    public HairCrownRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/hair_crown1")));
    }

    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof ForeheadBand dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        return 0xFFFFFF;
    }
}
