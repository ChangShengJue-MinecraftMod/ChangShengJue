package com.shengchanshe.changshengjue.item.combat.armor.wedding;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.armor.wedding.layer.FemaleChineseWeddingDressLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FemaleChineseWeddingDressRender extends GeoArmorRenderer<FemaleChineseWeddingDress> {
    public FemaleChineseWeddingDressRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/female_chinese_wedding_dress")));
        this.addRenderLayer(new FemaleChineseWeddingDressLayer(this));
    }

    /**
     * 获取盔甲的颜色。如果没有染色，返回默认颜色。
     */
    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof FemaleChineseWeddingDress dyeableArmorItem) {
            if (stack.is(ChangShengJueItems.PHOENIX_CORONET.get()) || stack.is(ChangShengJueItems.QUEEN_CLOTHING.get())
                    || stack.is(ChangShengJueItems.SILK_LEGGINGS.get()) || stack.is(ChangShengJueItems.GOLDEN_THREAD_SHOES.get())){
                return dyeableArmorItem.getColor(stack);
            }
        }
        // 如果物品不是可染色盔甲，返回默认白色
        return 0xFFFFFF;
    }
}
