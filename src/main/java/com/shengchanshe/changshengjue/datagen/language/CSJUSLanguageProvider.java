package com.shengchanshe.changshengjue.datagen.language;

import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class CSJUSLanguageProvider extends LanguageProvider {
    public CSJUSLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add(ChangShengJueItems.CROC.get(),"生鳄鱼肉");
    }
}
