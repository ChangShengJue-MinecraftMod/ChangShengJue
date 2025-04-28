package com.shengchanshe.changshengjue.tags;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

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
        public static final TagKey<Block> BENCH  = tag("bench");
        public static final TagKey<Block> DRINKING_TABLE_AND_CHAIRS  = tag("drinking_table_and_chairs");
        public static final TagKey<Block> BOOK_DESK = tag("book_desk");
        public static final TagKey<Block> TEAPOY = tag("teapoy");
        public static final TagKey<Block> TAISHI_CHAIR = tag("taishi_chair");
        public static final TagKey<Block> FIVE_SCREEN_THRONE = tag("five_screen_throne");
        public static final TagKey<Block> LOW_DESK = tag("low_desk");

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
        public static final TagKey<Item> INTERNAL_KUNG_FU_MJ = tag("internal_kung_fu_mj");
        public static final TagKey<Item> EXTERNAL_KUNG_FU_MJ = tag("external_kung_fu_mj");
        public static final TagKey<Item> ARTIFACT = tag("artifact");
        public static final TagKey<Item> DRINKS = tag("drinks");
        public static final TagKey<Item> PAINTING = tag("painting");
        public static final TagKey<Item> WINE = tag("wine");
        public static final TagKey<Item> TEA = tag("tea");
        public static final TagKey<Item> FOODS = tag("foods");
        public static final TagKey<Item> UNPROCESSED_FOODS = tag("unprocessed_foods");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ChangShengJue.MOD_ID, name));
        }
    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> HUMANOIDS = create("humanoids");
        public static final TagKey<EntityType<?>> GANG_LEADER = create("gang_leader");
        public static final TagKey<EntityType<?>> PILLAGER = create("pillager");
        public static final TagKey<EntityType<?>> VILLAGERS = create("villagers");
        public static final TagKey<EntityType<?>> MING_XIA = create("ming_xia");

        public static TagKey<EntityType<?>> create(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(ChangShengJue.MOD_ID, name));
        }
    }

    public static class ForgeItems{
        public static final TagKey<Item> INGOTS_SILVER = tag(Tags.Items.INGOTS.location().getPath() + "/silver");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

}
