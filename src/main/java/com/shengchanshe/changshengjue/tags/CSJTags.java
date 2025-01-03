package com.shengchanshe.changshengjue.tags;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CSJTags {
    public static class Blocks{
        public static final TagKey<Block> DOORS = tag("doors");
        public static final TagKey<Block> JI_CHI_MU_LOG = tag("ji_chi_mu_log");
        public static final TagKey<Block> HUANG_HUA_LI_LOG = tag("huang_hua_li_log");
        public static final TagKey<Block> ZI_TAN_LOG = tag("zi_tan_log");
        public static final TagKey<Block> POPLAR_LOG = tag("poplar_log");
        public static final TagKey<Block> MULBERRY_LOG = tag("mulberry_log");
        public static final TagKey<Block> LOG = tag("log");
        public static final TagKey<Block> MEI_REN_KAO = tag("mei_ren_kao");
        public static final TagKey<Block> TILE = tag("tile");
        public static final TagKey<Block> WINDOWS = tag("windows");
        public static final TagKey<Block> BRICKS = tag("bricks");
        public static final TagKey<Block> PAINTING = tag("painting");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ChangShengJue.MOD_ID, name));
        }
    }
    public static class Items{
        public static final TagKey<Item> DOORS = tag("doors");
        public static final TagKey<Item> JI_CHI_MU_LOG = tag("ji_chi_mu_log");
        public static final TagKey<Item> HUANG_HUA_LI_LOG = tag("huang_hua_li_log");
        public static final TagKey<Item> ZI_TAN_LOG = tag("zi_tan_log");
        public static final TagKey<Item> POPLAR_LOG = tag("poplar_log");
        public static final TagKey<Item> MULBERRY_LOG = tag("mulberry_log");
        public static final TagKey<Item> LOG = tag("log");
        public static final TagKey<Item> MEI_REN_KAO = tag("mei_ren_kao");
        public static final TagKey<Item> TILE = tag("tile");
        public static final TagKey<Item> WINDOWS = tag("windows");
        public static final TagKey<Item> MJ_BOOK = tag("mj_book");
        public static final TagKey<Item> ARTIFACT = tag("artifact");
        public static final TagKey<Item> DRINKS = tag("drinks");
        public static final TagKey<Item> PAINTING = tag("painting");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ChangShengJue.MOD_ID, name));
        }
    }

}
