package com.shengchanshe.changshengjue.item.render.combat.armor.wedding;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.FemaleTaoistRobes;
import com.shengchanshe.changshengjue.item.combat.armor.wedding.FemaleChineseWeddingDress;
import com.shengchanshe.changshengjue.item.render.combat.armor.taoistrobes.layer.MaleTaoistRobesLayer;
import com.shengchanshe.changshengjue.item.render.combat.armor.wedding.layer.FemaleChineseWeddingDressLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.GeoCube;
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
            if (stack.is(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_HELMET.get()) || stack.is(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_CHESTPLATE.get())
                    || stack.is(ChangShengJueItems.SILK_LEGGINGS.get()) || stack.is(ChangShengJueItems.CHINESE_WEDDING_DRESS_BOOTS.get())){
                return dyeableArmorItem.getColor(stack);
            }
        }
        // 如果物品不是可染色盔甲，返回默认白色
        return 0xFFFFFF;
    }
}
