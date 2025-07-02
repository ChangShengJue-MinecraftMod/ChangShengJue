package com.shengchanshe.chang_sheng_jue.item.combat.armor.wedding;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.wedding.layer.FemaleChineseWeddingDressLayer;
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
            if (stack.is(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_PHOENIX_CORONET.get()) || stack.is(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_QUEEN_CLOTHING.get())
                    || stack.is(ChangShengJueItems.TAOIST_LEGGINGS.get()) || stack.is(ChangShengJueItems.CHINESE_WEDDING_DRESS_GOLDEN_THREAD_SHOES.get())){
                return dyeableArmorItem.getColor(stack);
            }
        }
        // 如果物品不是可染色盔甲，返回默认白色
        return 0xFFFFFF;
    }
}
