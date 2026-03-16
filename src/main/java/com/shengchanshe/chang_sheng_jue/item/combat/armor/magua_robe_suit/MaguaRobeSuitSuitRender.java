package com.shengchanshe.chang_sheng_jue.item.combat.armor.magua_robe_suit;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.magua_robe_suit.layer.MaguaRobeSuitRenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MaguaRobeSuitSuitRender extends GeoArmorRenderer<MaguaRobeSuit> {
    public MaguaRobeSuitSuitRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/magua_robe_suit")));
        this.addRenderLayer(new MaguaRobeSuitRenderLayer(this));
    }

    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof MaguaRobeSuit dyeableArmorItem) {
            return dyeableArmorItem.getColor(stack);
        }
        return 0xFFFFFF;
    }
}
