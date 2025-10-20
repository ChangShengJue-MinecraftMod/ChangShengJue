package com.shengchanshe.chang_sheng_jue.item.combat.armor.headdress.hair_crown;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.headdress.forehead_band.ForeheadBand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class HairCrown2Render extends GeoArmorRenderer<ForeheadBand> {

    public HairCrown2Render() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/hair_crown2")));
    }

    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof HairCrown2 dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        return 0xFFFFFF;
    }
}
