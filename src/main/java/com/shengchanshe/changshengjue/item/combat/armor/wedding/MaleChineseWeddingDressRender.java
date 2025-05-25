package com.shengchanshe.changshengjue.item.combat.armor.wedding;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.armor.wedding.layer.MaleChineseWeddingDressLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MaleChineseWeddingDressRender extends GeoArmorRenderer<MaleChineseWeddingDress> {
    public MaleChineseWeddingDressRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"armor/male_chinese_wedding_dress")));
        this.addRenderLayer(new MaleChineseWeddingDressLayer(this));
    }

    /**
     * 获取盔甲的颜色。如果没有染色，返回默认颜色。
     */
    public int getArmorColor(ItemStack stack) {
        if (stack.getItem() instanceof MaleChineseWeddingDress dyeableArmorItem) {
            if (stack.is(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_BLACK_GAUZE_CAP.get()) || stack.is(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_KYLIN_BUFU.get())
                    || stack.is(ChangShengJueItems.TAOIST_LEGGINGS.get()) || stack.is(ChangShengJueItems.CHINESE_WEDDING_DRESS_GOLDEN_THREAD_SHOES.get())){
                return dyeableArmorItem.getColor(stack);
            }
        }
        // 如果物品不是可染色盔甲，返回默认白色
        return 0xFFFFFF;
    }
}
