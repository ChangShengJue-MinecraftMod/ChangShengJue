    package com.shengchanshe.chang_sheng_jue.datagen.language;

    import com.shengchanshe.chang_sheng_jue.ChangShengJue;
    import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
    import com.shengchanshe.chang_sheng_jue.damage.CSJDamageTypes;
    import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
    import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
    import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
    import com.shengchanshe.chang_sheng_jue.item.items.StructureIntelligence;
    import net.minecraft.data.PackOutput;
    import net.minecraftforge.common.data.LanguageProvider;

    public class CSJHKLanguageProvider extends LanguageProvider {
        public CSJHKLanguageProvider(PackOutput output, String modid, String locale) {
            super(output, modid, locale);
        }

        @Override
        protected void addTranslations() {
            //创造栏
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_building_block", "長生訣 建築方塊");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_natural_blocks", "長生訣 自然方塊");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_functional", "長生訣 功能方塊");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_ingredients", "長生訣 原材料");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_food_and_drink", "長生訣 食物與飲品");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_combat", "長生訣 戰鬥用品");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_tool", "長生訣 工具與實用物品");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_spawn_eggs", "長生訣 刷怪蛋");
            //物品
            this.add(ChangShengJueItems.PINEAPPLE_SEEDS.get(),"菠蘿種子");
            this.add(ChangShengJueItems.PINEAPPLE.get(),"菠蘿");
            this.add(ChangShengJueItems.TOMATO_SEEDS.get(),"番茄種子");
            this.add(ChangShengJueItems.TOMATO.get(),"番茄");
            this.add(ChangShengJueItems.SOYBEAN.get(),"大豆");
            this.add(ChangShengJueItems.GU_SEEDS.get(),"穀種");
            this.add(ChangShengJueItems.GU_SUI.get(),"穀穗");
            this.add(ChangShengJueItems.SORGHUM_SEEDS.get(),"高粱種子");
            this.add(ChangShengJueItems.SORGHUM.get(),"高粱穗");
            this.add(ChangShengJueItems.LOTUS_ROOT.get(),"蓮藕");
            this.add(ChangShengJueItems.LOTUS_SEEDS.get(),"蓮子");
            this.add(ChangShengJueItems.LOTUS.get(),"蓮花");
            this.add(ChangShengJueItems.REDBEAN.get(),"紅豆");
            this.add(ChangShengJueItems.COTTON_SEEDS.get(),"棉花種子");
            this.add(ChangShengJueItems.COTTON.get(),"棉花");
            this.add(ChangShengJueItems.STICKYRICE_SEEDS.get(),"糯稻種子");
            this.add(ChangShengJueItems.STICKYRICE.get(),"糯稻");
            this.add(ChangShengJueItems.STICKYRICE_1.get(),"糯米");
            this.add(ChangShengJueItems.CORN_SEEDS.get(),"玉米種子");
            this.add(ChangShengJueItems.CORN.get(),"玉米");
            this.add(ChangShengJueItems.JALAPENOS_SEEDS.get(),"胡椒種子");
            this.add(ChangShengJueItems.JALAPENOS.get(),"胡椒");
            this.add(ChangShengJueItems.PEANUT_SEEDS.get(),"花生種子");
            this.add(ChangShengJueItems.PEANUT.get(),"花生");
            this.add(ChangShengJueItems.BRINJAL_SEEDS.get(),"茄子種子");
            this.add(ChangShengJueItems.BRINJAL.get(),"茄子");
            this.add(ChangShengJueItems.CANTALOUPE.get(),"哈密瓜片");
            this.add(ChangShengJueItems.CANTALOUPE_SEEDS.get(),"哈密瓜種子");
            this.add(ChangShengJueItems.GRAPE_SEEDS.get(),"葡萄種子");
            this.add(ChangShengJueItems.GRAPE.get(),"葡萄");
            this.add(ChangShengJueItems.RICE_SEEDS.get(),"水稻苗");
            this.add(ChangShengJueItems.RICE.get(),"水稻");
            this.add(ChangShengJueItems.BILUOCHUN_TEA_SEEDS.get(),"碧螺春種子");
            this.add(ChangShengJueItems.BILUOCHUN_TEA.get(),"碧螺春");
            this.add(ChangShengJueItems.LONG_JING_TEA_SEEDS.get(),"龍井種子");
            this.add(ChangShengJueItems.LONG_JING_TEA.get(),"龍井");
            this.add(ChangShengJueItems.HORDEUM_SEEDS.get(),"大麥種子");
            this.add(ChangShengJueItems.HORDEUM.get(),"大麥");
            this.add(ChangShengJueItems.MULBERRY_JUICE.get(),"桑葚汁");
            this.add(ChangShengJueItems.APPLE_JUICE.get(),"蘋果汁");
            this.add(ChangShengJueItems.HOT_PEAR_SOUP.get(),"熱梨湯");
            this.add(ChangShengJueItems.GRAPE_JUICE.get(),"葡萄汁");
            this.add(ChangShengJueItems.CROC.get(),"生鱷魚肉");
            this.add(ChangShengJueItems.COOKED_CROC.get(),"熟鱷魚肉");
            this.add(ChangShengJueItems.PEACOCK.get(),"生孔雀肉");
            this.add(ChangShengJueItems.COOKED_PEACOCK.get(),"熟孔雀肉");
            this.add(ChangShengJueItems.CI_PAN.get(),"瓷盤");
            this.add(ChangShengJueItems.CI_WAN.get(),"瓷碗");
            this.add(ChangShengJueItems.CI_BEI.get(),"瓷杯");
            this.add(ChangShengJueItems.CAPSULE_JIAO_ZI.get(),"薺菜餃子");
            this.add(ChangShengJueItems.ZHENG_CAI.get(),"蒸菜");
            this.add(ChangShengJueItems.PORTULACA_OLERACEA_CAKE.get(),"馬齒莧餅");
            this.add(ChangShengJueItems.QING_TUAN.get(),"青糰");
            this.add(ChangShengJueItems.BAKED_CORN.get(),"烤玉米");
            this.add(ChangShengJueItems.TOMATO_EGG.get(),"番茄炒蛋");
            this.add(ChangShengJueItems.GU_LAO_ROU.get(),"咕咾肉");
            this.add(ChangShengJueItems.MEAT_FOAM_BRINJAL.get(),"肉沫茄子");
            this.add(ChangShengJueItems.SORGHUM_CAKE.get(),"高粱餅");
            this.add(ChangShengJueItems.STINKY_TOFU.get(),"臭豆腐");
            this.add(ChangShengJueItems.ZHU_DU_JI.get(),"豬肚雞");
            this.add(ChangShengJueItems.XIAO_MI_FAN.get(),"小米飯糰");
            this.add(ChangShengJueItems.MI_FAN.get(),"飯糰");
            this.add(ChangShengJueItems.GUI_HUA_TANG_OU.get(),"桂花糖藕");
            this.add(ChangShengJueItems.BA_BAO_ZHOU.get(),"八寶粥");
            this.add(ChangShengJueItems.BILUOCHUN_TEAS.get(),"碧螺春茶");
            this.add(ChangShengJueItems.LONG_JING_TEAS.get(),"龍井茶");
            this.add(ChangShengJueItems.SHI_LI_XIANG.get(),"十里香");
            this.add(ChangShengJueItems.FEN_JIU.get(),"汾酒");
            this.add(ChangShengJueItems.EMPTY_FEN_JIU.get(),"空酒瓶");
            this.add(ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get(),"麥塊貢酒");
            this.add(ChangShengJueItems.MANGO.get(),"芒果");
            this.add(ChangShengJueItems.MEI_HUA.get(),"梅花");
            this.add(ChangShengJueItems.GUI_HUA.get(),"桂花");
            this.add(ChangShengJueItems.BANANA.get(),"香蕉");
            this.add(ChangShengJueItems.PEAR.get(),"梨子");
            this.add(ChangShengJueItems.LICHEE.get(),"荔枝");
            this.add(ChangShengJueItems.DURIAN.get(),"榴槤");
            this.add(ChangShengJueItems.DURIAN_MEAT.get(),"榴槤肉");
            this.add(ChangShengJueItems.MULBERRY.get(),"桑葚");
            this.add(ChangShengJueItems.NATURAL_SILK.get(),"蠶絲");
            this.add(ChangShengJueItems.SILKWORM.get(),"蠶");
            this.add(ChangShengJueItems.SILK.get(),"絲綢");
            this.add(ChangShengJueItems.CAPSULE.get(),"薺菜");
            this.add(ChangShengJueItems.QUICKLIME.get(),"生石灰");
            this.add(ChangShengJueItems.LIME_SLURRY_BARRELS.get(),"石灰漿桶");
            this.add(ChangShengJueItems.WARM_LIME_SLURRY_BARRELS.get(),"暖色石灰漿桶");
            this.add(ChangShengJueItems.COOL_LIME_SLURRY_BARRELS.get(),"冷色石灰漿桶");
            this.add(ChangShengJueItems.CRANE_FEATHERS.get(), "鶴羽");
            this.add(ChangShengJueItems.PEACOCK_FEATHERS.get(), "孔雀羽翎");
            this.add(ChangShengJueItems.WHITE_PEACOCK_FEATHERS.get(), "白孔雀羽翎");
            this.add(ChangShengJueItems.PEACOCK_EGGS.get(), "孔雀蛋");
            this.add(ChangShengJueItems.ANTLER.get(), "鹿茸");
            this.add(ChangShengJueItems.DEER_BLOOD.get(), "鹿血");
            this.add(ChangShengJueItems.VENISON.get(), "生鹿肉");
            this.add(ChangShengJueItems.COOKED_VENISON.get(), "熟鹿肉");
            this.add(ChangShengJueItems.TIGER_SKIN.get(), "虎皮");
            this.add(ChangShengJueItems.CROC_SKIN.get(), "鱷魚皮");
            this.add(ChangShengJueItems.RAW_AG.get(), "粗銀");
            this.add(ChangShengJueItems.AG_INGOT.get(), "銀錠");

            this.add(ChangShengJueItems.THATCH.get(), "茅草");

            this.add(ChangShengJueItems.PAINT_BRUSH.get(), "刷子");
            this.add(ChangShengJueItems.BLACK_BRICKS.get(), "黑磚");
            this.add(ChangShengJueItems.CYAN_BRICKS.get(), "青磚");
            this.add(ChangShengJueItems.WHITE_BRICKS_ITEM.get(), "白磚");
            this.add(ChangShengJueItems.GOLD_BRICKS.get(), "金磚");

            this.add(ChangShengJueItems.SYDEROLIFE_BALL.get(), "陶土球");
            this.add(ChangShengJueItems.KAOLIN_BALL.get(), "高嶺土球");
            this.add(ChangShengJueItems.NATURAL_ASPHALT.get(), "天然瀝青");

            this.add(ChangShengJueItems.TONG_QIAN.get(), "銅錢");
            this.add(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), "一貫銅錢");
            this.add(ChangShengJueItems.SILVER_BULLIONS.get(), "銀元寶");
            this.add(ChangShengJueItems.GOLD_BULLIONS.get(), "金元寶");

            this.add(ChangShengJueItems.CRUCIBLE.get(), "坩堝");
            this.add(ChangShengJueItems.CRUCIBLE_CRUSHED_COPPER.get(), "坩堝(碎銅塊)");
            this.add(ChangShengJueItems.CRUCIBLE_CRUSHED_SILVER.get(), "坩堝(碎銀塊)");
            this.add(ChangShengJueItems.CRUCIBLE_CRUSHED_GOLD.get(), "坩堝(碎金塊)");
            this.add(ChangShengJueItems.CRUCIBLE_LIQUID_COPPER.get(), "坩堝(銅水)");
            this.add(ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get(), "坩堝(銀水)");
            this.add(ChangShengJueItems.CRUCIBLE_LIQUID_GOLD.get(), "坩堝(金水)");

            this.add(ChangShengJueItems.GANG_TOKEN.get(),"幫派令牌");
            this.add(ChangShengJueItems.EXTERNAL_KUNG_FU_XP.get(), "外功經驗+5");
            this.add(ChangShengJueItems.INTERNAL_KUNG_FU_XP.get(), "內功經驗+5");

            this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.PIT_YARD_TYPE, "%s情報");
            this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.SANDSTONE_CASTLE_TYPE, "%s情報");
            this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.SI_HE_YUAN_TYPE, "%s情報");
            this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.SU_PAI_VILLAGE_TYPE, "%s情報");
            this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.HUI_PAI_VILLAGE_TYPE, "%s情報");
            this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.FORTRESSES_TYPE, "%s情報");

            //刷怪蛋
            this.add(ChangShengJueItems.BUTTERFLY_EGG.get(), "蝴蝶刷怪蛋");
            this.add(ChangShengJueItems.MONKEY_EGG.get(), "猴刷怪蛋");
            this.add(ChangShengJueItems.DRAGONFLY_EGG.get(), "蜻蜓刷怪蛋");
            this.add(ChangShengJueItems.CICADA_EGG.get(), "蟬刷怪蛋");
            this.add(ChangShengJueItems.CRANE_EGG.get(), "鶴刷怪蛋");
            this.add(ChangShengJueItems.PEACOCK_EGG.get(), "雄孔雀刷怪蛋");
            this.add(ChangShengJueItems.PEACOCK_EGG_1.get(), "雌孔雀刷怪蛋");
            this.add(ChangShengJueItems.STAG_EGG.get(), "雄鹿刷怪蛋");
            this.add(ChangShengJueItems.HIND_EGG.get(), "雌鹿刷怪蛋");
            this.add(ChangShengJueItems.TIGER_EGG.get(), "虎刷怪蛋");
            this.add(ChangShengJueItems.CROC_EGG.get(), "鱷魚刷怪蛋");
            this.add(ChangShengJueItems.CHANG_SHENG_JUE_VILLAGER_EGG.get(), "村民刷怪蛋");
            this.add(ChangShengJueItems.WARRIOR_EGG.get(), "武夫刷怪蛋");
            this.add(ChangShengJueItems.KILN_WORKER_EGG.get(), "營造主事刷怪蛋");
            this.add(ChangShengJueItems.MALE_INNKEEPER_EGG.get(), "酒館男掌櫃刷怪蛋");
            this.add(ChangShengJueItems.FEMALE_INNKEEPER_EGG.get(), "酒館女掌櫃刷怪蛋");
            this.add(ChangShengJueItems.CHALLENGER_EGG.get(), "挑戰者刷怪蛋");
            this.add(ChangShengJueItems.BLACKSMITH_EGG.get(), "鐵匠刷怪蛋");
            this.add(ChangShengJueItems.LANCE_GANG_LEADER_EGG.get(), "幫派首領(槍)刷怪蛋");
            this.add(ChangShengJueItems.KNIFE_GANG_LEADER_EGG.get(), "幫派首領(刀)刷怪蛋");
            this.add(ChangShengJueItems.SWORD_GANG_LEADER_EGG.get(), "幫派首領(劍)刷怪蛋");
            this.add(ChangShengJueItems.CLUBBED_GANG_LEADER_EGG.get(), "幫派首領(棍)刷怪蛋");
            this.add(ChangShengJueItems.GANG_LEADER_EGG.get(), "幫派首領(拳)刷怪蛋");
            this.add(ChangShengJueItems.BANDIT_EGG.get(), "強盜刷怪蛋");
            this.add(ChangShengJueItems.VILLAIN_EGG.get(), "惡徒刷怪蛋");
            this.add(ChangShengJueItems.ASSASSIN_EGG.get(), "殺手刷怪蛋");
            this.add(ChangShengJueItems.CLUBBED_MING_XIA_EGG.get(), "棍王刷怪蛋");
            this.add(ChangShengJueItems.SWORD_MING_XIA_EGG.get(), "劍仙刷怪蛋");
            this.add(ChangShengJueItems.KNIFE_MING_XIA_EGG.get(), "刀聖刷怪蛋");
            this.add(ChangShengJueItems.FIST_MING_XIA_EGG.get(), "北拳刷怪蛋");
            this.add(ChangShengJueItems.PIGLIN_WU_XIA_EGG.get(), "功夫豬靈刷怪蛋");
            this.add(ChangShengJueItems.WITCH_WU_XIA_EGG.get(), "功夫女巫刷怪蛋");
            this.add(ChangShengJueItems.EVOKER_WU_XIA_EGG.get(), "功夫喚魔者刷怪蛋");
            this.add(ChangShengJueItems.VINDICATOR_WU_XIA_EGG.get(), "功夫衛道士刷怪蛋");
            this.add(ChangShengJueItems.PILLAGER_WU_XIA_EGG.get(), "功夫掠奪者刷怪蛋");
            //工具武器和盔甲物品
            this.add(ChangShengJueItems.KAISHAN_PICKAXE.get(),"開山鎬");
            this.add(ChangShengJueItems.XUANHUA_AXE.get(),"萱花斧");
            this.add(ChangShengJueItems.BRONZE_SWORD.get(),"青銅劍");
            this.add(ChangShengJueItems.LONG_YUAN_SWORD.get(),"龍淵劍");
            this.add(ChangShengJueItems.HAN_JIAN.get(),"漢劍");
            this.add(ChangShengJueItems.HENG_DAO.get(),"橫刀");
            this.add(ChangShengJueItems.LARGE_KNIFE.get(),"大刀");
            this.add(ChangShengJueItems.RED_TASSELLED_SPEAR.get(),"紅纓槍");
            this.add(ChangShengJueItems.SOFT_SWORD.get(),"軟劍");
            this.add(ChangShengJueItems.PAN_HUA_GUN.get(),"盤花棍");
            this.add(ChangShengJueItems.KITCHEN_KNIFE.get(),"菜刀");
            this.add(ChangShengJueItems.THROWING_KNIVES.get(),"飛刀");
            this.add(ChangShengJueItems.FLYING_DAGGER_POUCH.get(),"飛刀囊");
            this.add(ChangShengJueItems.BEAT_DOG_STICK.get(),"打狗棒");
            this.add(ChangShengJueItems.YI_TIAN_JIAN.get(),"倚天劍");
            this.add(ChangShengJueItems.TU_LONG_DAO.get(),"屠龍刀");
            this.add(ChangShengJueItems.BA_WANG_QIANG.get(),"霸王槍");
            this.add(ChangShengJueItems.GOLD_THREAD_GLOVE.get(),"金絲手套");
            this.add(ChangShengJueItems.COTTON_HELMET.get(),"棉盔");
            this.add(ChangShengJueItems.WHITE_COTTON_HELMET.get(),"白羽棉盔");
            this.add(ChangShengJueItems.COTTON_CHESTPLATE.get(),"棉甲");
            this.add(ChangShengJueItems.COTTON_LEGGINGS.get(),"棉護腿");
            this.add(ChangShengJueItems.COTTON_BOOTS.get(),"棉靴子");
            this.add(ChangShengJueItems.FEMALE_TAOIST_HELMET.get(),"道冠");
            this.add(ChangShengJueItems.FEMALE_TAOIST_CHESTPLATE.get(),"道袍");
            this.add(ChangShengJueItems.MALE_TAOIST_HELMET.get(),"四方巾");
            this.add(ChangShengJueItems.MALE_TAOIST_CHESTPLATE.get(),"道服");
            this.add(ChangShengJueItems.TAOIST_BOOTS.get(),"絲履");
            this.add(ChangShengJueItems.TAOIST_LEGGINGS.get(),"絲裳");
            this.add(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_BLACK_GAUZE_CAP.get(),"烏紗帽");
            this.add(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_KYLIN_BUFU.get(),"麒麟補服");
            this.add(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_PHOENIX_CORONET.get(),"鳳冠");
            this.add(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_QUEEN_CLOTHING.get(),"褘衣");
            this.add(ChangShengJueItems.CHINESE_WEDDING_DRESS_GOLDEN_THREAD_SHOES.get(),"金絲履");
            this.add(ChangShengJueItems.MOUNTAIN_PATTERN_HELMET_GUN_HOOD.get(),"盔槍兜鍪");
            this.add(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR.get(),"山文甲");
            this.add(ChangShengJueItems.MOUNTAIN_PATTERN_DEERSKIN_TIBIAL_ARMOR.get(),"鹿皮脛甲");
            this.add(ChangShengJueItems.MOUNTAIN_PATTERN_CLOUD_BLACK_BOOTS.get(),"雲頭烏皮靴");
            this.add(ChangShengJueItems.FLY_FISH_IRON_HAT.get(), "鐵笠");
            this.add(ChangShengJueItems.FLY_FISH_CLOUD_VEIL_CROWN.get(), "雲紗冠");
            this.add(ChangShengJueItems.FLY_FISH_CHESTPLATE.get(), "飛魚服");
            this.add(ChangShengJueItems.FLY_FISH_LONG_BOOTS.get(), "長靴");
            this.add(ChangShengJueItems.WALKER_GREEN_TREASURE_PENDANT.get(),"綠寶眉心墜");
            this.add(ChangShengJueItems.WALKER_GOLD_RING_BAND.get(), "金戒箍");
            this.add(ChangShengJueItems.WALKER_CHESTPLATE.get(), "行者裝");
            this.add(ChangShengJueItems.WALKER_TIGER_SKIN_SKIRT.get(), "虎皮裙");
            this.add(ChangShengJueItems.WALKER_SHORT_BOOTS.get(), "短靴");
            this.add(ChangShengJueItems.PHOENIX_FEATHER_CAP.get(),"鳳翅紫金冠");
            this.add(ChangShengJueItems.OLDEN_CHAIN_MAIL_SHIRT.get(),"鎖子黃金甲");
            this.add(ChangShengJueItems.TIGER_SKIN_GARMENT.get(),"虎皮下裳");
            this.add(ChangShengJueItems.CLOUD_WALKING_BOOTS.get(),"藕絲步雲履");
            this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_PHOENIX_WINGS_HELMET.get(), "鳳翅兜鍪");
            this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE.get(), "明光鎧");
            this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LAZULI_KNEE_PADS.get(), "青金護膝");
            this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_ANIMAL_SKIN_BOOTS.get(), "獸皮靴");
            this.add(ChangShengJueItems.CONFUCIAN_HELMET.get(), "寶緇撮");
            this.add(ChangShengJueItems.CONFUCIAN_INK_CHESTPLATE.get(), "公子寬袍");
            this.add(ChangShengJueItems.CONFUCIAN_INK_LEGGINGS.get(), "絲執褲");
            this.add(ChangShengJueItems.CONFUCIAN_INK_BOOTS.get(), "輕絲履");

            this.add(ChangShengJueItems.CONSTABLE_UNIFORM_HELMET.get(), "玄紋束髮冠");
            this.add(ChangShengJueItems.CONSTABLE_UNIFORM_CHESTPLATE.get(), "雲紋暗繡氅衣");
            this.add(ChangShengJueItems.CONSTABLE_UNIFORM_LEGGINGS.get(), "蟒紋綴穗下裳");
            this.add(ChangShengJueItems.CONSTABLE_UNIFORM_BOOTS.get(), "玄革踏雲靴");

            this.add(ChangShengJueItems.HATS_WITH_VEIL_HELMET.get(), "垂紗鬥笠");
            this.add(ChangShengJueItems.HATS_WITH_VEIL_CHESTPLATE.get(), "素雅長裙");

            this.add(ChangShengJueItems.HATS_BLACK_ROBE_HELMET.get(), "竹鬥笠");
            this.add(ChangShengJueItems.HATS_BLACK_ROBE_CHESTPLATE.get(), "玄衣");
            this.add(ChangShengJueItems.HATS_BLACK_ROBE_LEGGINGS.get(), "玄衣下裳");

            this.add(ChangShengJueItems.DUAN_DA_CHESTPLATE.get(), "短打上衣");
            this.add(ChangShengJueItems.BUDDHIST_ROBE_CHESTPLATE.get(), "念珠僧袍");
            this.add(ChangShengJueItems.NIGHT_SUIT_HELMET.get(), "蒙面頭巾");
            this.add(ChangShengJueItems.NIGHT_SUIT_CHESTPLATE.get(), "夜行衣");
            this.add(ChangShengJueItems.LONG_GOWN_CHESTPLATE.get(), "窄袖長衫");
            this.add(ChangShengJueItems.NIGHT_SUIT_LEGGINGS.get(), "絲綢綁腿");

            this.add(ChangShengJueItems.FOREHEAD_BAND_HELMET1.get(), "额带");
            this.add(ChangShengJueItems.FOREHEAD_BAND_HELMET2.get(), "额带");
            this.add(ChangShengJueItems.HAIR_CROWN_HELMET1.get(), "束发冠");
            this.add(ChangShengJueItems.HAIR_CROWN_HELMET2.get(), "束发冠");

            this.add(ChangShengJueItems.GOLD_SILK_SOFT_ARMOR.get(), "金絲軟甲");
            this.add(ChangShengJueItems.LEATHER_INNER_ARMOR.get(), "皮內甲");

            this.add(ChangShengJueItems.ARMOR_PARCEL.get(), "盔甲包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "cotton_armor", "棉甲包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "mountain_pattern", "山文甲包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "mingguang_armor", "大將軍明光鎧包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "qi_tian_da_sheng", "大聖甲胄包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "male_taoist", "道服包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "female_taoist", "道袍包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "male_wedding_dress", "麒麟補服包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "female_wedding_dress", "褘衣包裹");

            //效果
            this.add(ChangShengJueItems.TRAUMA_EFFECT.get(), "外傷");
            this.add(ChangShengJueItems.INTERNAL_INJURY_EFFECT.get(), "內傷");

            this.add(ChangShengJueItems.IMMORTAL_MIRACLE.get(),"不死神功");
            this.add(ChangShengJueItems.HERCULES.get(),"大力神功");
            this.add(ChangShengJueItems.DUGU_NINE_SWORDS.get(),"獨孤九劍");
            this.add(ChangShengJueItems.GAO_MARKSMANSHIP.get(),"高家槍法");
            this.add(ChangShengJueItems.GE_SHAN_DA_NIU.get(),"隔山打牛");
            this.add(ChangShengJueItems.TURTLE_BREATH_WORK.get(),"龜息功");
            this.add(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get(),"金烏刀法");
            this.add(ChangShengJueItems.GOLDEN_BELL_JAR.get(),"金鐘罩");
            this.add(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get(),"葵花點穴手");
            this.add(ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get(),"麥塊百科");
            this.add(ChangShengJueItems.PAODING.get(),"庖丁解牛");
            this.add(ChangShengJueItems.SHAOLIN_STICK_METHOD.get(),"少林棍法");
            this.add(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get(),"踏雪無痕");
            this.add(ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get(),"無情飛刀");
            this.add(ChangShengJueItems.WU_GANG_CUT_GUI.get(),"吳剛伐桂");
            this.add(ChangShengJueItems.XUANNU_SWORDSMANSHIP.get(),"玄女劍法");
            this.add(ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get(),"愚公移山");
            this.add(ChangShengJueItems.ZHANG_MEN_XIN_XUE.get(),"張門心學");
            this.add(ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get(),"易筋經");
            this.add(ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get(),"乾坤大挪移");

            //武功描述
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DUGU_NINE_SWORDS.get()+".tooltip","天下劍法中的巔峰絕詣，其中包含森羅萬象的訣竅。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DUGU_NINE_SWORDS.get()+".hold_shift.tooltip",
                    "未大成前施展效果:外功釋放造成(主手武器傷害+1)*1.8倍的傷害\\n大成後施展效果:傷害倍數提高至2.2倍、使用劍時流血觸發概率*1.25\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.XUANNU_SWORDSMANSHIP.get()+".tooltip","以巧借力，以柔克剛。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.XUANNU_SWORDSMANSHIP.get()+".hold_shift.tooltip",
                    "未大成前施展效果:外功釋放造成(主手武器傷害+1)*2.2倍傷害\\n大成後施展效果:傷害倍數提高至2.5倍、使用軟劍時流血觸發概率*3.0\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GAO_MARKSMANSHIP.get()+".tooltip","一點寒芒先到，隨後槍出如龍。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GAO_MARKSMANSHIP.get()+".hold_shift.tooltip",
                    "未大成前施展效果:外功釋放造成(主手武器傷害+1)*1.8倍的傷害\\n大成後施展效果:傷害倍數提高至2.1倍、使用槍時挑飛觸發概率*2.5\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get()+".tooltip","無情飛刀人有情義，人有情義飛刀無情。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get()+".hold_shift.tooltip",
                    "未大成前施展效果:飛刀傷害提高至1.25倍並可一次丟出3把飛刀\\n大成後施展效果:飛刀傷害提高至1.5倍並可一次丟出7把飛刀\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SHAOLIN_STICK_METHOD.get()+".tooltip","天下武功出少林，一棍定乾坤。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SHAOLIN_STICK_METHOD.get()+".hold_shift.tooltip",
                    "未大成前施展效果:外功釋放造成(主手武器傷害+1)*1.7倍傷害\\n大成後施展效果:傷害倍數提高至2.0倍、使用棍時擊暈觸發概率*2.5\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get()+".tooltip","任你千變萬化，我只一刀破去!");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get()+".hold_shift.tooltip",
                    "未大成前施展效果:外功釋放造成(主手武器傷害+1)*1.9倍的傷害\\n大成後施展效果:傷害倍數提高至2.0倍、使用刀時重擊觸發概率*2.0\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()+".tooltip","來去無影無蹤，逍遙自在。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()+".hold_shift.tooltip",
                    "未大成前施展效果:可以進行二連跳\\n大成後施展效果:可以進行三段跳\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WU_GANG_CUT_GUI.get()+".tooltip","何意殺人技，不如快人心。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WU_GANG_CUT_GUI.get()+".hold_shift.tooltip",
                    "未大成前施展效果:使用萱花斧砍樹可以破壞整棵樹\\n大成後施展效果:砍樹連帶破壞整個樹的速度更快\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get()+".tooltip","生生不息，直至山平。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get()+".hold_shift.tooltip",
                    "未大成前施展效果:使用開山鎬的挖掘面積擴大為2x2\\n大成後施展效果:挖掘面積擴大為3x3\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.PAODING.get()+".tooltip","若反覆實踐，掌握規律；便得心應手，運用自如。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.PAODING.get()+".hold_shift.tooltip",
                    "未大成前施展效果:主手持菜刀殺死動物有50%%概率額外掉落肉\\n大成後施展效果:主手持菜刀殺死動物有75%%概率額外掉落肉\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.HERCULES.get()+".tooltip","以氣御力，神力無窮。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.HERCULES.get()+".hold_shift.tooltip",
                    "未大成前施展效果:減少疾跑消耗的飽食度降低至60%%\\n大成後施展效果:主手持金絲手套右鍵可打開終界箱\\n移動大於%s米後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()+".tooltip","指如疾風，勢如閃電。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()+".hold_shift.tooltip",
                    "未大成前施展效果:定住血量上限低於25點的目標1.5秒\\n大成後施展效果:定住血量上限低於200點的目標2秒\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BELL_JAR.get()+".tooltip","刀槍不入，渾然一金鐘。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BELL_JAR.get()+".hold_shift.tooltip",
                    "未大成前施展效果:提高4點護甲,受到傷害時會獲得3級的傷害吸收\\n大成後施展效果:提高8點護甲,受到傷害時傷害吸收的效果提高到5級\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.ZHANG_MEN_XIN_XUE.get()+".tooltip","江湖不是打打殺殺，那是人情世故!");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.ZHANG_MEN_XIN_XUE.get()+".hold_shift.tooltip",
                    "未大成前施展效果:與村民的交易一次即可將村民等級提升至學徒\\n大成後施展效果:額外有10%%概率不消耗物品交易\\n與村民交易%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.IMMORTAL_MIRACLE.get()+".tooltip","不死不滅，豈是幻夢?");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.IMMORTAL_MIRACLE.get()+".hold_shift.tooltip",
                    "未大成前施展效果:在瀕死時抵禦一次致命傷害\\n大成後施展效果:減少15秒冷卻時間\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GE_SHAN_DA_NIU.get()+".tooltip","神功蓋世，何欺牛兒?");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GE_SHAN_DA_NIU.get()+".hold_shift.tooltip",
                    "未大成前施展效果:無視方塊阻攔施展外功造成22點傷害\\n大成後施展效果:攻擊傷害範圍提高2格\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get()+".tooltip","學向勤中得，螢窗萬卷書。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get()+".hold_shift.tooltip",
                    "未大成前施展效果:每次交易有25%%概率獲得5點經驗\\n大成後施展效果:每次交易有35%%概率獲得10點經驗\\n經驗到達30級後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TURTLE_BREATH_WORK.get()+".tooltip","龜雖有鼻，而息之以耳。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TURTLE_BREATH_WORK.get()+".hold_shift.tooltip",
                    "未大成前施展效果:施展後一段時間內可以水下屏息更久，不會被動物主動攻擊\\n大成後施展效果:提高屏息效果\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get()+".tooltip","武林中人夢寐以求的武學寶典。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get()+".hold_shift.tooltip",
                    "未大成前施展效果:釋放武功需要的飢餓度減少1點\\n大成後施展效果:釋放武功需要的飢餓度與飽和度各減少1點\\n成功施展%s次後武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()+".tooltip","激發潛力，牽引挪移，其中變化莫測，匪夷所思。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()+".hold_shift.tooltip",
                    "未大成前施展效果:有35%%概率將遭受的攻擊傷害於1.0秒後以1.5倍反彈給攻擊者\\n大成後施展效果:每多1點血量額外提高2%%觸發概率\\n每施展1次冷卻時間短期內延長2秒\\n成功施展%s次後武功大成");

            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.external_kunfu", "習得%s,可使用使用%s長按滑鼠右鍵蓄力%s秒後施展武功!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.external_kunfu_glove", "習得%s,可使用%s長按滑鼠右鍵蓄力%s秒後施展武功!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.internal_kungfu", "習得%s!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.studied.kungfu", "%s已閱覽過,%s!");

            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.external_kunfu", "%s已閱覽,使用%s攻擊目標來實戰領悟吧!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.external_kunfu_glove", "%s已閱覽,還需用空手或%s攻擊木樁來操練領悟吧!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.internal_kungfu", "%s已閱覽,還需用%s攻擊木樁來操練領悟吧!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.light_kungfu", "%s已閱覽,還需%s來領悟!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.mental_kungfu", "%s已閱覽,還需%s來領悟!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.dacheng.kungfu", "%s神功大成!");

            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".swords.type", "劍");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".softsword.type", "軟劍");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".clubbed.type", "棍");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".glove.type", "拳套");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".knife.type", "刀");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".lance.type", "槍");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".throwingknives.type", "飛刀");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".hand_and_glove.type", "空手或手套");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".run_and_jump.type", "奔跑或跳躍");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".mental_kungfu.type", "跟生物互動");

            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu.true.comprehend", "且已習得!可使用%s長按滑鼠右鍵蓄力%s秒後施展武功");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu.fales.comprehend", "還需用%s攻擊目標來實戰領悟!");

            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu.true.comprehend", "且已習得!");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu.fales.comprehend", "還需用%s攻擊木樁來操練領悟!");

            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".light_kungfu.fales.comprehend", "還需%s來領悟!");

            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".mental_kungfu.fales.comprehend", "還需%s來領悟!");

            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".state_change.kungfu", "%s : %s");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.open", "啟動,還需用空手或%s攻擊木樁來操練領悟!");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu_glove.open", "啟動,還需用空手攻擊木樁來操練領悟!");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.comprehend.open", "啟動,可使用%s長按滑鼠右鍵蓄力%s秒後施展武功");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu_glove.comprehend.open", "啟動,大成後可使用%s來施展武功!");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.off", "關閉");

            this.add("message." + ChangShengJue.MOD_ID + ".dagger_pouch.empty", "§c沒有武器了");

            this.add("message." + ChangShengJue.MOD_ID + ".install_patchouli_for_guide", "提示：您可以安裝帕秋莉手冊(Patchouli)模組來獲取長生訣模組的遊戲引導書《五方匯錄》");

            this.add("tooltip." + ChangShengJue.MOD_ID + ".dagger_pouch.count","飛刀囊容量 %s / %s");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".flying_dagger_pouch.right_click.tooltip","在背包內拿起並右鍵飛刀可將飛刀放入飛刀囊中");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".throwing_knives.right_click.tooltip","在背包內拿起並右鍵飛刀囊可將飛刀放入飛刀囊中");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".durability","耐久 %s / %s");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".dagger_pouch.contents","飛刀囊內的物品");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DURIAN.get()+".tooltip","請使用斧子劈開");
            this.add("tooltip."+ChangShengJue.MOD_ID+".hold_shift.tooltip","按下 §eShift§r 查看更多資訊");

            this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data","已內襯");
            this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.lining","此鎧甲不可內襯");
            this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.lining1","請使用胸甲內襯");
            this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.unload","已從裝備中卸下");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".dyeing","可染色");

            this.add("tooltip."+ ChangShengJue.MOD_ID + ".damage_reduction","外功傷害減免: +%s%%");
            this.add("tooltip."+ ChangShengJue.MOD_ID + ".trauma","受到外傷的概率: -%s%%");

            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "pit_yard.tooltip", "地下窯洞");
            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "sandstone_castle.tooltip","沙石堡");
            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "si_he_yuan.tooltip","四合院");
            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "su_pai_village.tooltip","蘇式村莊");
            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "hui_pai_village.tooltip","徽式村莊");
            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "fortresses_type.tooltip","古城");
            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "null.structure.tooltip","未知結構");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".structural_location","在 [x=%d | z=%d] 位置坐落著一處%s,去看看吧");

            //声音
            this.add("sounds."+ChangShengJue.MOD_ID + ".ge_shan_da_niu_sound","武功 : 隔山打牛");
            this.add("sounds."+ChangShengJue.MOD_ID + ".dugu_nine_swords_sound","武功 : 獨孤九劍");
            this.add("sounds."+ChangShengJue.MOD_ID + ".immortal_miracle_sound","武功 : 不死神功");
            this.add("sounds."+ChangShengJue.MOD_ID + ".gao_marksmanship_sound","武功 : 高家槍法");
            this.add("sounds."+ChangShengJue.MOD_ID + ".turtle_breath_work_sound","武功 : 龜息功");
            this.add("sounds."+ChangShengJue.MOD_ID + ".golden_black_knife_method_sound","武功 : 金烏刀法");
            this.add("sounds."+ChangShengJue.MOD_ID + ".sunflower_point_caveman_sound","武功 : 葵花點穴手");
            this.add("sounds."+ChangShengJue.MOD_ID + ".shaolin_stick_method_sound","武功 : 少林棍法");
            this.add("sounds."+ChangShengJue.MOD_ID + ".tread_the_snow_without_trace_sound","武功 : 踏雪無痕");
            this.add("sounds."+ChangShengJue.MOD_ID + ".throwing_knives_sound","飛刀 : 飛出");
            this.add("sounds."+ChangShengJue.MOD_ID + ".throwing_knives_hit","飛刀 : 命中");
            this.add("sounds."+ChangShengJue.MOD_ID + ".throwing_knives_hit_ground","飛刀 : 命中");
            this.add("sounds."+ChangShengJue.MOD_ID + ".wu_gang_cut_gui_sound","武功 : 吳剛伐桂");
            this.add("sounds."+ChangShengJue.MOD_ID + ".xuannu_swordsmanship_sound","武功 : 玄女劍法");
            this.add("sounds."+ChangShengJue.MOD_ID + ".golden_belljar_sound","武功 : 金鐘罩");
            this.add("sounds."+ChangShengJue.MOD_ID + ".qian_kun_da_nuo_yi_sound","武功 : 乾坤大挪移");
            this.add("sounds."+ChangShengJue.MOD_ID + ".comprehend_sound","武功 : 突破");
            this.add("sounds."+ChangShengJue.MOD_ID + ".dacheng_sound","武功 : 大成");

            this.add("sounds."+ChangShengJue.MOD_ID + ".cicada_sound", "蟬 : 鳴叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".cicada_hurt", "蟬 : 受傷");
            this.add("sounds."+ChangShengJue.MOD_ID + ".crane_sound", "鶴 : 鳴叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".crane_hurt", "鶴 : 受傷");
            this.add("sounds."+ChangShengJue.MOD_ID + ".crane_death", "鶴 : 死亡");
            this.add("sounds."+ChangShengJue.MOD_ID + ".croc_sound", "鱷魚 : 咆哮");
            this.add("sounds."+ChangShengJue.MOD_ID + ".croc_hurt", "鱷魚 : 受傷");
            this.add("sounds."+ChangShengJue.MOD_ID + ".croc_death", "鱷魚 : 死亡");
            this.add("sounds."+ChangShengJue.MOD_ID + ".dragonfly_hurt", "蜻蜓 : 受傷");
            this.add("sounds."+ChangShengJue.MOD_ID + ".dragonfly_death", "蜻蜓 : 死亡");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_sound" , "猴 : 嚎叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_baby_sound" , "猴 : 嚎叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_angry_sound" , "猴 : 生氣");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_hurt" , "猴 : 受傷");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_death" , "猴 : 死亡");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_1" , "猴 : 拜年");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_2" , "猴 : 翻筋斗");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_3" , "猴 : 敬禮");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_4" , "猴 : 很髒很髒的嚎叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_sound" , "虎 : 咆哮");
            this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_sound_1" , "虎 : 咆哮");
            this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_hurt" , "虎 : 受傷");
            this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_death" , "虎 : 死亡");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound" , "鹿 : 鳴叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_1" , "鹿 : 鳴叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_2" , "鹿 : 鳴叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_3" , "鹿 : 鳴叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_4" , "鹿 : 鳴叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_5" , "鹿 : 鳴叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_hurt" , "鹿 : 受傷");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_death" , "鹿 : 死亡");
            this.add("sounds."+ChangShengJue.MOD_ID + ".peacock_sound" , "孔雀 : 鳴叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".peacock_hurt" , "孔雀 : 受傷");
            this.add("sounds."+ChangShengJue.MOD_ID + ".peacock_death" , "孔雀 : 死亡");

            //风铃
            this.add("sounds."+ChangShengJue.MOD_ID + ".wind_chime_sound", "風鈴 : 叮鈴鈴");

            this.add("sounds."+ChangShengJue.MOD_ID + ".gong_sound", "鑼 : 鐺~");

            this.add("sounds."+ChangShengJue.MOD_ID + ".tailoring_case_sound", "裁衣案 : 裁剪");

            this.add("sounds."+ChangShengJue.MOD_ID + ".forge_block_sound", "鍛錘 : 錘擊");

            this.add("sounds."+ChangShengJue.MOD_ID + ".taxation_sound", "鑄幣稅");

            this.add("sounds."+ChangShengJue.MOD_ID + ".stakes_hit_sound", "練功木樁 : 被擊打");

            //方块
            this.add(ChangShengJueItems.STAKES.get(),"練功木樁");
            this.add(ChangShengJueBlocks.GONG.get(),"鑼");

            this.add(ChangShengJueBlocks.CANTALOUPE_BLOCK.get(),"哈密瓜");
            this.add(ChangShengJueBlocks.WILDLIFE_HORDEUM.get(),"野生大麥");

            this.add(ChangShengJueBlocks.MANGO_LOG.get(),"芒果樹原木");
            this.add(ChangShengJueBlocks.MANGO_WOOD.get(),"芒果樹木");
            this.add(ChangShengJueBlocks.STRIPPED_MANGO_LOG.get(),"去皮芒果樹原木");
            this.add(ChangShengJueBlocks.STRIPPED_MANGO_WOOD.get(),"去皮芒果樹木");
            this.add(ChangShengJueBlocks.MANGO_PLANKS.get(),"芒果樹木板");
            this.add(ChangShengJueBlocks.MANGO_LEAVES.get(),"芒果樹樹葉");
            this.add(ChangShengJueBlocks.MANGO_SAPLING.get(),"芒果樹樹苗");

            this.add(ChangShengJueBlocks.BANANA_LOG.get(),"香蕉原木");
            this.add(ChangShengJueBlocks.BANANA_LEAVES.get(),"香蕉樹葉");
            this.add(ChangShengJueBlocks.BANANA_SAPLING.get(),"香蕉樹苗");
            this.add(ChangShengJueBlocks.BANANA_FRUIT.get(),"香蕉");

            this.add(ChangShengJueBlocks.PEAR_LOG.get(),"梨樹原木");
            this.add(ChangShengJueBlocks.PEAR_WOOD.get(),"梨樹木");
            this.add(ChangShengJueBlocks.STRIPPED_PEAR_LOG.get(),"去皮梨樹原木");
            this.add(ChangShengJueBlocks.STRIPPED_PEAR_WOOD.get(),"去皮梨樹木");
            this.add(ChangShengJueBlocks.PEAR_PLANKS.get(),"梨樹木板");
            this.add(ChangShengJueBlocks.PEAR_LEAVES.get(),"梨樹樹葉");
            this.add(ChangShengJueBlocks.PEAR_SAPLING.get(),"梨樹樹苗");

            this.add(ChangShengJueBlocks.LICHEE_LOG.get(),"荔枝樹原木");
            this.add(ChangShengJueBlocks.LICHEE_WOOD.get(),"荔枝樹木");
            this.add(ChangShengJueBlocks.STRIPPED_LICHEE_LOG.get(),"去皮荔枝樹原木");
            this.add(ChangShengJueBlocks.STRIPPED_LICHEE_WOOD.get(),"去皮荔枝樹");
            this.add(ChangShengJueBlocks.LICHEE_PLANKS.get(),"荔枝樹木板");
            this.add(ChangShengJueBlocks.LICHEE_LEAVES.get(),"荔枝樹樹葉");
            this.add(ChangShengJueBlocks.LICHEE_SAPLING.get(),"荔枝樹樹苗");

            this.add(ChangShengJueBlocks.DURIAN_LOG.get(),"榴槤樹原木");
            this.add(ChangShengJueBlocks.DURIAN_WOOD.get(),"榴槤樹木");
            this.add(ChangShengJueBlocks.STRIPPED_DURIAN_LOG.get(),"去皮榴槤樹原木");
            this.add(ChangShengJueBlocks.STRIPPED_DURIAN_WOOD.get(),"去皮榴槤樹木");
            this.add(ChangShengJueBlocks.DURIAN_PLANKS.get(),"榴槤樹木板");
            this.add(ChangShengJueBlocks.DURIAN_LEAVES.get(),"榴槤樹樹葉");
            this.add(ChangShengJueBlocks.DURIAN_SAPLING.get(),"榴槤樹樹苗");

            this.add(ChangShengJueBlocks.OSMANTHUS_LOG.get(),"桂花樹原木");
            this.add(ChangShengJueBlocks.OSMANTHUS_WOOD.get(),"桂花樹木");
            this.add(ChangShengJueBlocks.STRIPPED_OSMANTHUS_LOG.get(),"去皮桂花樹原木");
            this.add(ChangShengJueBlocks.STRIPPED_OSMANTHUS_WOOD.get(),"去皮桂花樹木");
            this.add(ChangShengJueBlocks.OSMANTHUS_PLANKS.get(),"桂花樹木板");
            this.add(ChangShengJueBlocks.OSMANTHUS_LEAVES.get(),"桂花樹樹葉");
            this.add(ChangShengJueBlocks.OSMANTHUS_SAPLING.get(),"桂花樹樹苗");
            this.add(ChangShengJueBlocks.OSMANTHUS_DEFOLIATION.get(),"桂花樹落葉");

            this.add(ChangShengJueBlocks.PLUM_LOG.get(),"梅花樹原木");
            this.add(ChangShengJueBlocks.PLUM_WOOD.get(),"梅花樹木");
            this.add(ChangShengJueBlocks.STRIPPED_PLUM_LOG.get(),"去皮梅花樹原木");
            this.add(ChangShengJueBlocks.STRIPPED_PLUM_WOOD.get(),"去皮梅花樹木");
            this.add(ChangShengJueBlocks.PLUM_PLANKS.get(),"梅花樹木板");
            this.add(ChangShengJueBlocks.PLUM_LEAVES.get(),"梅花樹樹葉");
            this.add(ChangShengJueBlocks.PLUM_SAPLING.get(),"梅花樹樹苗");
            this.add(ChangShengJueBlocks.PLUM_DEFOLIATION.get(),"梅花樹落葉");

            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get(),"黃花梨原木");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_WOOD.get(),"黃花梨木");
            this.add(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get(),"去皮黃花梨原木");
            this.add(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_WOOD.get(),"去皮黃花梨木");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LEAVES.get(),"黃花梨樹葉");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_SAPLING.get(),"黃花梨樹苗");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get(),"黃花梨木板");

            this.add(ChangShengJueBlocks.WENGE_LOG.get(),"雞翅木原木");
            this.add(ChangShengJueBlocks.WENGE_WOOD.get(),"雞翅木");
            this.add(ChangShengJueBlocks.STRIPPED_WENGE_LOG.get(),"去皮雞翅木原木");
            this.add(ChangShengJueBlocks.STRIPPED_WENGE_WOOD.get(),"去皮雞翅木");
            this.add(ChangShengJueBlocks.WENGE_LEAVES.get(),"雞翅木樹葉");
            this.add(ChangShengJueBlocks.WENGE_SAPLING.get(),"雞翅木樹苗");
            this.add(ChangShengJueBlocks.WENGE_PLANKS.get(),"雞翅木木板");

            this.add(ChangShengJueBlocks.ZI_TAN_LOG.get(),"紫檀原木");
            this.add(ChangShengJueBlocks.ZI_TAN_WOOD.get(),"紫檀木");
            this.add(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get(),"去皮紫檀原木");
            this.add(ChangShengJueBlocks.STRIPPED_ZI_TAN_WOOD.get(),"去皮紫檀木");
            this.add(ChangShengJueBlocks.ZI_TAN_LEAVES.get(),"紫檀樹樹葉");
            this.add(ChangShengJueBlocks.ZI_TAN_SAPLING.get(),"紫檀樹樹苗");
            this.add(ChangShengJueBlocks.ZI_TAN_PLANKS.get(),"紫檀木板");

            this.add(ChangShengJueBlocks.POPLAR_LOG.get(),"白楊樹原木");
            this.add(ChangShengJueBlocks.POPLAR_WOOD.get(),"白楊樹木");
            this.add(ChangShengJueBlocks.STRIPPED_POPLAR_LOG.get(),"去皮白楊樹原木");
            this.add(ChangShengJueBlocks.STRIPPED_POPLAR_WOOD.get(),"去皮白楊樹木");
            this.add(ChangShengJueBlocks.POPLAR_PLANKS.get(),"白楊樹木板");
            this.add(ChangShengJueBlocks.POPLAR_LEAVES.get(),"白楊樹樹葉");
            this.add(ChangShengJueBlocks.POPLAR_SAPLING.get(),"白楊樹樹苗");
            this.add(ChangShengJueBlocks.POPLAR_DEFOLIATION.get(),"白楊樹落葉");

            this.add(ChangShengJueBlocks.MULBERRY_LOG.get(),"桑樹原木");
            this.add(ChangShengJueBlocks.MULBERRY_WOOD.get(),"桑樹木");
            this.add(ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get(),"去皮桑樹原木");
            this.add(ChangShengJueBlocks.STRIPPED_MULBERRY_WOOD.get(),"去皮桑樹木");
            this.add(ChangShengJueBlocks.MULBERRY_PLANKS.get(),"桑樹木板");
            this.add(ChangShengJueBlocks.MULBERRY_LEAVES.get(),"桑樹樹葉");
            this.add(ChangShengJueBlocks.MULBERRY_LEAVES_FRUITS.get(),"有蠶的桑葉");
            this.add(ChangShengJueBlocks.MULBERRY_SAPLING.get(),"桑樹樹苗");

            // 食物容器类方块
            this.add(ChangShengJueBlocks.CAPSULE_JIAO_ZI_PAN.get(), "餃子盤");
            this.add(ChangShengJueBlocks.CAPSULE_JIAO_ZI_WAN.get(), "餃子碗");
            this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_PAN.get(), "馬齒莧餅盤");
            this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_WAN.get(), "馬齒莧餅碗");
            this.add(ChangShengJueBlocks.QING_TUAN_PAN.get(), "青糰盤");
            this.add(ChangShengJueBlocks.QING_TUAN_WAN.get(), "青糰碗");
            this.add(ChangShengJueBlocks.SORGHUM_CAKE_PAN.get(), "高粱餅盤");
            this.add(ChangShengJueBlocks.SORGHUM_CAKE_WAN.get(), "高粱餅碗");
            this.add(ChangShengJueBlocks.MI_FAN_PAN.get(), "米飯盤");
            this.add(ChangShengJueBlocks.MI_FAN_WAN.get(), "米飯碗");
            this.add(ChangShengJueBlocks.XIAO_MI_FAN_PAN.get(), "小米飯盤");
            this.add(ChangShengJueBlocks.XIAO_MI_FAN_WAN.get(), "小米飯碗");

            this.add(ChangShengJueBlocks.EMPTY_SHI_LI_XIANG.get(), "空十里香杯");
            this.add(ChangShengJueBlocks.EMPTY_WHEAT_NUGGETS_TRIBUTE_WINE.get(), "空麥塊貢酒杯");

            this.add(ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.get(),"青花瓷花盆");

            this.add(ChangShengJueBlocks.MUGWORT_BLOCK.get(),"艾蒿");
            this.add(ChangShengJueBlocks.POTTED_MUGWORT_BLOCK.get(),"艾蒿");

            this.add(ChangShengJueBlocks.CAPSULE_BLOCK.get(),"薺菜");

            this.add(ChangShengJueBlocks.CUCKOO_BLOCK.get(),"杜鵑花");
            this.add(ChangShengJueBlocks.POTTED_CUCKOO_BLOCK.get(),"杜鵑花");

            this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get(),"馬齒莧");
            this.add(ChangShengJueBlocks.POTTED_PORTULACA_OLERACEA_BLOCK.get(),"馬齒莧");

            this.add(ChangShengJueBlocks.JASMINE_BLOCK.get(),"茉莉花");
            this.add(ChangShengJueBlocks.POTTED_JASMINE_BLOCK.get(),"茉莉花");

            this.add(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get(),"地膚草");
            this.add(ChangShengJueBlocks.POTTED_KOCHIA_SCOPARIA_BLOCK.get(),"地膚草");

            this.add(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get(),"水仙花");
            this.add(ChangShengJueBlocks.POTTED_SHUI_XIAN_BLOCK.get(),"水仙花");

            this.add(ChangShengJueBlocks.TAN_HUA_BLOCK.get(),"曇花");
            this.add(ChangShengJueBlocks.POTTED_TAN_HUA_BLOCK.get(),"曇花");

            this.add(ChangShengJueBlocks.STIPA_GRANDIS.get(),"大針茅");
            this.add(ChangShengJueBlocks.TALL_STIPA_GRANDIS.get(),"大針茅");
            this.add(ChangShengJueBlocks.TALL_STIPA_GRANDIS_VARIANT.get(),"高大的異種大針茅");

            this.add(ChangShengJueBlocks.SOLIDAGO.get(),"秋麒麟");
            this.add(ChangShengJueBlocks.POTTED_SOLIDAGO.get(),"秋麒麟");

            this.add(ChangShengJueBlocks.GEUM_TRIFLORUM.get(),"三花路邊青");
            this.add(ChangShengJueBlocks.POTTED_GEUM_TRIFLORUM.get(),"三花路邊青");

            this.add(ChangShengJueBlocks.PURPLE_DANDELION.get(),"紫色蒲公英");
            this.add(ChangShengJueBlocks.POTTED_PURPLE_DANDELION.get(),"紫色蒲公英");

            this.add(ChangShengJueBlocks.RED_KNOTWEED.get(),"紅蓼");
            this.add(ChangShengJueBlocks.PURPLE_RED_KNOTWEED.get(),"異種紅蓼");

            this.add(ChangShengJueBlocks.RAPE_FLOWERS.get(),"油菜花");

            this.add(ChangShengJueBlocks.ZHU_TAI.get(),"燭台");
            this.add(ChangShengJueBlocks.HANG_TU_BLOCK.get(),"夯土");
            this.add(ChangShengJueBlocks.HANG_TU_STAIRS.get(),"夯土樓梯");
            this.add(ChangShengJueBlocks.HANG_TU_SLAB.get(),"夯土台階");
            this.add(ChangShengJueBlocks.HANG_TU_WALL.get(),"夯土牆");
            this.add(ChangShengJueBlocks.TU_PEI_BLOCK.get(),"土坯");
            this.add(ChangShengJueBlocks.TU_PEI_STAIRS.get(),"土坯樓梯");
            this.add(ChangShengJueBlocks.TU_PEI_SLAB.get(),"土坯台階");
            this.add(ChangShengJueBlocks.TU_PEI_WALL.get(),"土坯牆");

            this.add(ChangShengJueBlocks.WHITE_WALLS_BLOCK.get(), "白牆");
            this.add(ChangShengJueBlocks.COOL_WHITE_WALLS_BLOCK.get(), "冷白色牆");
            this.add(ChangShengJueBlocks.WARM_WHITE_WALLS_BLOCK.get(), "暖白色牆");

            this.add(ChangShengJueBlocks.WHITE_FINE_BRICKS.get(),"白細磚");
            this.add(ChangShengJueBlocks.WHITE_BRICKS.get(),"白磚");
            this.add(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get(),"黑石細磚");
            this.add(ChangShengJueBlocks.BLACK_STONE_BRICKS.get(),"黑石磚");
            this.add(ChangShengJueBlocks.BLUE_STONE_BRICKS.get(),"青石磚");
            this.add(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get(),"青石細磚");

            this.add(ChangShengJueBlocks.WHITE_BRICKS_STAIRS.get(),"白磚樓梯");
            this.add(ChangShengJueBlocks.BLACK_STONE_BRICKS_STAIRS.get(),"黑石磚樓梯");
            this.add(ChangShengJueBlocks.BLUE_STONE_BRICKS_STAIRS.get(),"青石磚樓梯");

            this.add(ChangShengJueBlocks.WHITE_BRICKS_SLAB.get(),"白磚台階");
            this.add(ChangShengJueBlocks.BLACK_STONE_BRICKS_SLAB.get(),"黑石台階");
            this.add(ChangShengJueBlocks.BLUE_STONE_BRICKS_SLAB.get(),"青石台階");

            this.add(ChangShengJueBlocks.WHITE_BRICKS_VERTICAL_WALLS.get(),"白磚豎牆");
            this.add(ChangShengJueBlocks.BLACK_STONE_VERTICAL_WALLS.get(),"黑石豎牆");
            this.add(ChangShengJueBlocks.BLUE_STONE_VERTICAL_WALLS.get(),"青石豎牆");

            this.add(ChangShengJueBlocks.MANGROVE_OVERLORD_FIST.get(),"紅木霸王拳");
            this.add(ChangShengJueBlocks.BIRCH_OVERLORD_FIST.get(),"白樺木霸王拳");
            this.add(ChangShengJueBlocks.JUNGLE_OVERLORD_FIST.get(), "叢林木霸王拳");
            this.add(ChangShengJueBlocks.CRIMSON_OVERLORD_FIST.get(), "緋紅木霸王拳");
            this.add(ChangShengJueBlocks.WARPED_OVERLORD_FIST.get(), "詭異木霸王拳");
            this.add(ChangShengJueBlocks.ACACIA_OVERLORD_FIST.get(), "金合歡霸王拳");
            this.add(ChangShengJueBlocks.DARK_OAK_OVERLORD_FIST.get(), "深色橡木霸王拳");
            this.add(ChangShengJueBlocks.OAK_OVERLORD_FIST.get(), "橡木霸王拳");
            this.add(ChangShengJueBlocks.CHERRY_OVERLORD_FIST.get(), "櫻花木霸王拳");
            this.add(ChangShengJueBlocks.SPRUCE_OVERLORD_FIST.get(), "雲杉木霸王拳");
            this.add(ChangShengJueBlocks.SHORT_MANGROVE_BACK_BRACKET.get(), "紅木回紋雀替");
            this.add(ChangShengJueBlocks.SHORT_BIRCH_BACK_BRACKET.get(), "白樺木回紋雀替");
            this.add(ChangShengJueBlocks.SHORT_JUNGLE_BACK_BRACKET.get(), "叢林木回紋雀替");
            this.add(ChangShengJueBlocks.SHORT_CRIMSON_BACK_BRACKET.get(), "緋紅木回紋雀替");
            this.add(ChangShengJueBlocks.SHORT_WARPED_BACK_BRACKET.get(), "詭異木回紋雀替");
            this.add(ChangShengJueBlocks.SHORT_ACACIA_BACK_BRACKET.get(), "金合歡回紋雀替");
            this.add(ChangShengJueBlocks.SHORT_DARK_OAK_BACK_BRACKET.get(), "深色橡木回紋雀替");
            this.add(ChangShengJueBlocks.SHORT_OAK_BACK_BRACKET.get(), "橡木回紋雀替");
            this.add(ChangShengJueBlocks.SHORT_CHERRY_BACK_BRACKET.get(), "櫻花木回紋雀替");
            this.add(ChangShengJueBlocks.SHORT_SPRUCE_BACK_BRACKET.get(), "雲杉木回紋雀替");
            this.add(ChangShengJueBlocks.SHORT_MANGROVE_FLOWER_BRACKET.get(), "紅木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_BIRCH_FLOWER_BRACKET.get(), "白樺木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_JUNGLE_FLOWER_BRACKET.get(), "叢林木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_CRIMSON_FLOWER_BRACKET.get(), "緋紅木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_WARPED_FLOWER_BRACKET.get(), "詭異木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_ACACIA_FLOWER_BRACKET.get(), "金合歡花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_DARK_OAK_FLOWER_BRACKET.get(), "深色橡木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_OAK_FLOWER_BRACKET.get(), "橡木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_CHERRY_FLOWER_BRACKET.get(), "櫻花木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_SPRUCE_FLOWER_BRACKET.get(), "雲杉木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_MANGROVE_BACK_BRACKET.get(), "紅木回紋雀替");
            this.add(ChangShengJueBlocks.LONG_BIRCH_BACK_BRACKET.get(), "白樺木回紋雀替");
            this.add(ChangShengJueBlocks.LONG_JUNGLE_BACK_BRACKET.get(), "叢林木回紋雀替");
            this.add(ChangShengJueBlocks.LONG_CRIMSON_BACK_BRACKET.get(), "緋紅木回紋雀替");
            this.add(ChangShengJueBlocks.LONG_WARPED_BACK_BRACKET.get(), "詭異木回紋雀替");
            this.add(ChangShengJueBlocks.LONG_ACACIA_BACK_BRACKET.get(), "金合歡回紋雀替");
            this.add(ChangShengJueBlocks.LONG_DARK_OAK_BACK_BRACKET.get(), "深色橡木回紋雀替");
            this.add(ChangShengJueBlocks.LONG_OAK_BACK_BRACKET.get(), "橡木回紋雀替");
            this.add(ChangShengJueBlocks.LONG_CHERRY_BACK_BRACKET.get(), "櫻花木回紋雀替");
            this.add(ChangShengJueBlocks.LONG_SPRUCE_BACK_BRACKET.get(), "雲杉木回紋雀替");
            this.add(ChangShengJueBlocks.LONG_MANGROVE_FLOWER_BRACKET.get(), "紅木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_BIRCH_FLOWER_BRACKET.get(), "白樺木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_JUNGLE_FLOWER_BRACKET.get(), "叢林木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_CRIMSON_FLOWER_BRACKET.get(), "緋紅木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_WARPED_FLOWER_BRACKET.get(), "詭異木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_ACACIA_FLOWER_BRACKET.get(), "金合歡花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_DARK_OAK_FLOWER_BRACKET.get(), "深色橡木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_OAK_FLOWER_BRACKET.get(), "橡木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_CHERRY_FLOWER_BRACKET.get(), "櫻花木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_SPRUCE_FLOWER_BRACKET.get(), "雲杉木花牙子雀替");
            this.add(ChangShengJueBlocks.MANGROVE_DOUGONG.get(), "紅木斗拱");
            this.add(ChangShengJueBlocks.BIRCH_DOUGONG.get(), "白樺木斗拱");
            this.add(ChangShengJueBlocks.JUNGLE_DOUGONG.get(), "叢林木斗拱");
            this.add(ChangShengJueBlocks.CRIMSON_DOUGONG.get(), "緋紅木斗拱");
            this.add(ChangShengJueBlocks.WARPED_DOUGONG.get(), "詭異木斗拱");
            this.add(ChangShengJueBlocks.ACACIA_DOUGONG.get(), "金合歡斗拱");
            this.add(ChangShengJueBlocks.DARK_OAK_DOUGONG.get(), "深色橡木斗拱");
            this.add(ChangShengJueBlocks.OAK_DOUGONG.get(), "橡木斗拱");
            this.add(ChangShengJueBlocks.CHERRY_DOUGONG.get(), "櫻花木斗拱");
            this.add(ChangShengJueBlocks.SPRUCE_DOUGONG.get(), "雲杉木斗拱");
            this.add(ChangShengJueBlocks.GREEN_DOUGONG.get(),"綠斗青拱");
            this.add(ChangShengJueBlocks.BLUE_DOUGONG.get(),"青斗綠拱");

            this.add(ChangShengJueBlocks.STONE_LAMPS_BASE_BLOCK.get(),"石燈底座");
            this.add(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get(),"未點亮的石燈");
            this.add(ChangShengJueBlocks.STONE_LAMPS_LIANG_BLOCK.get(),"石燈");
            this.add(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get(),"黃色石獅子");
            this.add(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get(),"灰色石獅子");
            this.add(ChangShengJueBlocks.BAI_HUA_FU_TI_BLOCK.get(),"白樺扶梯");
            this.add(ChangShengJueBlocks.YUN_SHAN_FU_TI_BLOCK.get(),"雲杉扶梯");

            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get(),"灰色琉璃塊");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get(),"紅色琉璃瓦塊");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get(),"黑色琉璃塊");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get(),"金色琉璃瓦塊");
            this.add(ChangShengJueBlocks.CYAN_CYLINDER_TILE_BLOCK.get(),"青色琉璃瓦塊");
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get(),"蓝色琉璃瓦塊");
            this.add(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_BLOCK.get(),"紫色琉璃瓦塊");

            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get(),"灰色琉璃半磚");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get(),"紅色琉璃瓦半磚");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get(),"黑色琉璃半磚");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get(),"金色琉璃瓦半磚");
            this.add(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SLAB.get(),"青色琉璃瓦半磚");
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get(),"蓝色琉璃瓦半磚");
            this.add(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SLAB.get(),"蓝色琉璃瓦半磚");

            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.get(),"灰色側向琉璃");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.get(),"紅色側向琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.get(),"黑色側向琉璃");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.get(),"金色側向琉璃瓦");
            this.add(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SIDE.get(),"青色側向琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.get(),"蓝色侧向琉璃瓦");
            this.add(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SIDE.get(),"紫色侧向琉璃瓦");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.get(),"灰色側向飛簷");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.get(),"紅色側向飛簷");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.get(),"黑色側向飛簷");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.get(),"金色側向飛簷");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_UPTURNED_EAVES.get(),"青色側向飛簷");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.get(),"蓝色側向飛簷");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_UPTURNED_EAVES.get(),"紫色側向飛簷");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"灰色側向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"紅色側向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"黑色側向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"金色側向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"青色側向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"蓝色側向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"紫色側向矮脊瓦(前)");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"灰色側向矮脊瓦(後)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"紅色側向矮脊瓦(後)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"黑色側向矮脊瓦(後)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"金色側向矮脊瓦(後)");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"青色側向矮脊瓦(後)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"蓝色側向矮脊瓦(後)");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"紫色側向矮脊瓦(後)");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"灰色側向高脊瓦(前)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"紅色側向高脊瓦(前)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"黑色側向高脊瓦(前)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"金色側向高脊瓦(前)");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"青色側向高脊瓦(前)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"蓝色側向高脊瓦(前)");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"紫色側向高脊瓦(前)");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"灰色側向高脊瓦(後)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"紅色側向高脊瓦(後)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"黑色側向高脊瓦(後)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"金色側向高脊瓦(後)");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"青色側向高脊瓦(後)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"蓝色側向高脊瓦(後)");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"紫色側向高脊瓦(後)");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"灰色側向雙層脊瓦(前)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"紅色側向雙層脊瓦(前)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"黑色側向雙層脊瓦(前)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"金色側向雙層脊瓦(前)");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"青色側向雙層脊瓦(前)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"蓝色側向雙層脊瓦(前)");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"紫色側向雙層脊瓦(前)");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"灰色側向雙層脊瓦(後)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"紅色側向雙層脊瓦(後)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"黑色側向雙層脊瓦(後)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"金色側向雙層脊瓦(後)");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"青色側向雙層脊瓦(後)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"蓝色側向雙層脊瓦(後)");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"紫色側向雙層脊瓦(後)");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"灰色側向脊瓦屋頂");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"紅色側向脊瓦屋頂");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"黑色側向脊瓦屋頂");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"金色側向脊瓦屋頂");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"青色側向脊瓦屋頂");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"蓝色側向脊瓦屋頂");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"紫色側向脊瓦屋頂");

            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE.get(),"灰色琉璃");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE.get(),"紅色琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get(),"黑色琉璃");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get(),"金色琉璃瓦");
            this.add(ChangShengJueBlocks.CYAN_CYLINDER_TILE.get(),"青色琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get(),"蓝色琉璃瓦");
            this.add(ChangShengJueBlocks.PURPLE_CYLINDER_TILE.get(),"紫色琉璃瓦");

            this.add(ChangShengJueBlocks.GRE_EAVES_TILE.get(),"灰色瓦當");
            this.add(ChangShengJueBlocks.RED_EAVES_TILE.get(),"紅色瓦當");
            this.add(ChangShengJueBlocks.BLACK_EAVES_TILE.get(),"黑色瓦當");
            this.add(ChangShengJueBlocks.GOLDEN_EAVES_TILE.get(),"金色瓦當");
            this.add(ChangShengJueBlocks.CYAN_EAVES_TILE.get(),"青色瓦當");
            this.add(ChangShengJueBlocks.BLUE_EAVES_TILE.get(),"蓝色瓦當");
            this.add(ChangShengJueBlocks.PURPLE_EAVES_TILE.get(),"紫色瓦當");

            this.add(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE.get(),"青色雙層琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE.get(),"灰色雙層琉璃瓦");
            this.add(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE.get(),"紅色雙層琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE.get(),"黑色雙層琉璃");
            this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE.get(),"金色雙層琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE.get(),"蓝色雙層琉璃瓦");
            this.add(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE.get(),"紫色雙層琉璃瓦");

            this.add(ChangShengJueBlocks.CYAN_SMALL_DEMON_MASK.get(),"青色小鴟吻");
            this.add(ChangShengJueBlocks.GRE_SMALL_DEMON_MASK.get(),"灰色小鴟吻");
            this.add(ChangShengJueBlocks.RED_SMALL_DEMON_MASK.get(),"紅色小鴟吻");
            this.add(ChangShengJueBlocks.BLACK_SMALL_DEMON_MASK.get(),"黑色小鴟吻");
            this.add(ChangShengJueBlocks.GOLDEN_SMALL_DEMON_MASK.get(),"金色小鴟吻");
            this.add(ChangShengJueBlocks.BLUE_SMALL_DEMON_MASK.get(),"蓝色小鴟吻");
            this.add(ChangShengJueBlocks.PURPLE_SMALL_DEMON_MASK.get(),"紫色小鴟吻");

            this.add(ChangShengJueBlocks.CYAN_RIDGE_TILE.get(),"青色脊瓦");
            this.add(ChangShengJueBlocks.GRE_RIDGE_TILE.get(),"灰色脊瓦");
            this.add(ChangShengJueBlocks.RED_RIDGE_TILE.get(),"紅色脊瓦");
            this.add(ChangShengJueBlocks.BLACK_RIDGE_TILE.get(),"黑色脊瓦");
            this.add(ChangShengJueBlocks.GOLDEN_RIDGE_TILE.get(),"金色脊瓦");
            this.add(ChangShengJueBlocks.BLUE_RIDGE_TILE.get(),"蓝色脊瓦");
            this.add(ChangShengJueBlocks.PURPLE_RIDGE_TILE.get(),"紫色脊瓦");

            this.add(ChangShengJueBlocks.CYAN_DOUBLE_RIDGE_TILE.get(),"青色雙層脊瓦");
            this.add(ChangShengJueBlocks.GRE_DOUBLE_RIDGE_TILE.get(),"灰色雙層脊瓦");
            this.add(ChangShengJueBlocks.RED_DOUBLE_RIDGE_TILE.get(),"紅色雙層脊瓦");
            this.add(ChangShengJueBlocks.BLACK_DOUBLE_RIDGE_TILE.get(),"黑色雙層脊瓦");
            this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_RIDGE_TILE.get(),"金色雙層脊瓦");
            this.add(ChangShengJueBlocks.BLUE_DOUBLE_RIDGE_TILE.get(),"蓝色雙層脊瓦");
            this.add(ChangShengJueBlocks.PURPLE_DOUBLE_RIDGE_TILE.get(),"蓝色雙層脊瓦");

            this.add(ChangShengJueBlocks.CYAN_EAVES_CYLINDER_TILE.get(),"青色飛簷琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_EAVES_CYLINDER_TILE.get(),"灰色飛簷琉璃");
            this.add(ChangShengJueBlocks.RED_EAVES_CYLINDER_TILE.get(),"紅色飛簷琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_EAVES_CYLINDER_TILE.get(),"黑色飛簷琉璃");
            this.add(ChangShengJueBlocks.GOLDEN_EAVES_CYLINDER_TILE.get(),"金色飛簷琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_EAVES_CYLINDER_TILE.get(),"蓝色飛簷琉璃瓦");
            this.add(ChangShengJueBlocks.PURPLE_EAVES_CYLINDER_TILE.get(),"紫色飛簷琉璃瓦");

            this.add(ChangShengJueBlocks.ANIMALS_CYAN_RIDGE_TILE.get(),"青色脊獸脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get(),"灰色脊獸脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get(),"紅色脊獸脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get(),"黑色脊獸脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get(),"金色脊獸脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get(),"蓝色脊獸脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_PURPLE_RIDGE_TILE.get(),"紫色脊獸脊瓦");

            this.add(ChangShengJueBlocks.HANGING_BEAST_CYAN_RIDGE_TILE.get(),"青色垂獸脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.get(),"灰色垂獸脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.get(),"紅色垂獸脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.get(),"黑色垂獸脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.get(),"金色垂獸脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.get(),"蓝色垂獸脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_PURPLE_RIDGE_TILE.get(),"紫色垂獸脊瓦");

            this.add(ChangShengJueBlocks.CYAN_ROOF_RIDGE.get(),"青色屋脊");
            this.add(ChangShengJueBlocks.GRE_ROOF_RIDGE.get(),"灰色屋脊");
            this.add(ChangShengJueBlocks.RED_ROOF_RIDGE.get(),"紅色屋脊");
            this.add(ChangShengJueBlocks.BLACK_ROOF_RIDGE.get(),"黑色屋脊");
            this.add(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get(),"金色屋脊");
            this.add(ChangShengJueBlocks.BLUE_ROOF_RIDGE.get(),"蓝色屋脊");
            this.add(ChangShengJueBlocks.PURPLE_ROOF_RIDGE.get(),"紫色屋脊");

            this.add(ChangShengJueBlocks.CYAN_DEMON_MASK.get(), "青色鴟吻");
            this.add(ChangShengJueBlocks.GRE_DEMON_MASK.get(), "灰色鴟吻");
            this.add(ChangShengJueBlocks.RED_DEMON_MASK.get(), "紅色鴟吻");
            this.add(ChangShengJueBlocks.BLACK_DEMON_MASK.get(), "黑色鴟吻");
            this.add(ChangShengJueBlocks.GOLDEN_DEMON_MASK.get(), "金色鴟吻");
            this.add(ChangShengJueBlocks.BLUE_DEMON_MASK.get(), "蓝色鴟吻");
            this.add(ChangShengJueBlocks.PURPLE_DEMON_MASK.get(), "紫色鴟吻");

            this.add(ChangShengJueBlocks.CYAN_RIDGE_FINIAL_PAVILION.get(), "青色樓閣脊剎");
            this.add(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.get(), "灰色樓閣脊剎");
            this.add(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.get(), "紅色樓閣脊剎");
            this.add(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.get(), "黑色樓閣脊剎");
            this.add(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.get(), "金色樓閣脊剎");
            this.add(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.get(), "蓝色樓閣脊剎");
            this.add(ChangShengJueBlocks.PURPLE_RIDGE_FINIAL_PAVILION.get(), "紫色樓閣脊剎");

            this.add(ChangShengJueBlocks.CYAN_CHARACTER_PLAQUE_PAVILION.get(), "青色字牌脊剎");
            this.add(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.get(), "灰色字牌脊剎");
            this.add(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.get(), "紅色字牌脊剎");
            this.add(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.get(), "黑色字牌脊剎");
            this.add(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.get(), "金色字牌脊剎");
            this.add(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.get(), "蓝色字牌脊剎");
            this.add(ChangShengJueBlocks.PURPLE_CHARACTER_PLAQUE_PAVILION.get(), "紫色字牌脊剎");

            this.add(ChangShengJueBlocks.CYAN_HIPPED_ROOF.get(), "青色攢尖");
            this.add(ChangShengJueBlocks.GRE_HIPPED_ROOF.get(), "灰色攢尖");
            this.add(ChangShengJueBlocks.RED_HIPPED_ROOF.get(), "紅色攢尖");
            this.add(ChangShengJueBlocks.BLACK_HIPPED_ROOF.get(), "黑色攢尖");
            this.add(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.get(), "金色攢尖");
            this.add(ChangShengJueBlocks.BLUE_HIPPED_ROOF.get(), "蓝色攢尖");
            this.add(ChangShengJueBlocks.PURPLE_HIPPED_ROOF.get(), "紫色攢尖");

            this.add(ChangShengJueBlocks.CYAN_GABLE_RIDGE_CYLINDER_TILE.get(), "青色齊瓦當");
            this.add(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.get(), "灰色齊瓦當");
            this.add(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.get(), "紅色齊瓦當");
            this.add(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.get(), "黑色齊瓦當");
            this.add(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.get(), "金色齊瓦當");
            this.add(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.get(), "蓝色齊瓦當");
            this.add(ChangShengJueBlocks.PURPLE_GABLE_RIDGE_CYLINDER_TILE.get(), "紫色齊瓦當");

            this.add(ChangShengJueBlocks.CYAN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "青色雙層脊瓦");
            this.add(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "灰色雙層脊瓦");
            this.add(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "紅色雙層脊瓦");
            this.add(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "黑色雙層脊瓦");
            this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "金色雙層脊瓦");
            this.add(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "蓝色雙層脊瓦");
            this.add(ChangShengJueBlocks.PURPLE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "紫色雙層脊瓦");

            this.add(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "蓝色雙層垂獸脊瓦");
            this.add(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "灰色雙層垂獸脊瓦");
            this.add(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "紅色雙層垂獸脊瓦");
            this.add(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "黑色雙層垂獸脊瓦");
            this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "金色雙層垂獸脊瓦");
            this.add(ChangShengJueBlocks.CYAN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "青色雙層垂獸脊瓦");
            this.add(ChangShengJueBlocks.PURPLE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "青色雙層垂獸脊瓦");

            this.add(ChangShengJueBlocks.CYAN_SHORT_CYLINDER_TILE.get(), "青色短琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE.get(), "灰色短琉璃");
            this.add(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE.get(), "紅色短琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE.get(), "黑色短琉璃");
            this.add(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE.get(), "金色短琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE.get(), "蓝色短琉璃瓦");
            this.add(ChangShengJueBlocks.PURPLE_SHORT_CYLINDER_TILE.get(), "紫色短琉璃瓦");

            this.add(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE_SIDE.get(), "青色側向雙層琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.get(), "灰色側向雙層琉璃");
            this.add(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.get(), "紅色側向雙層琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.get(), "黑色側向雙層琉璃");
            this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.get(), "金色側向雙層琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.get(), "蓝色側向雙層琉璃瓦");
            this.add(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE_SIDE.get(), "紫色側向雙層琉璃瓦");

            this.add(ChangShengJueBlocks.CYAN_EAVES_TILE_SIDE.get(), "青色側向瓦當");
            this.add(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE.get(), "灰色側向瓦當");
            this.add(ChangShengJueBlocks.RED_EAVES_TILE_SIDE.get(), "紅色側向瓦當");
            this.add(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE.get(), "黑色側向瓦當");
            this.add(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE.get(), "金色側向瓦當");
            this.add(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE.get(), "蓝色側向瓦當");
            this.add(ChangShengJueBlocks.PURPLE_EAVES_TILE_SIDE.get(), "紫色側向瓦當");

            this.add(ChangShengJueBlocks.GOLDEN_TILE.get(), "金色瓦");
            this.add(ChangShengJueBlocks.GOLDEN_GENTLE_TILE.get(), "金色平緩瓦");
            this.add(ChangShengJueBlocks.GOLDEN_CORNICES.get(), "金色飛簷瓦");
            this.add(ChangShengJueBlocks.GOLDEN_GENTLE_CORNICES.get(), "金色平緩飛簷瓦");
            this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_2.get(), "金色瓦");
            this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_3.get(), "金色瓦");
            this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_4.get(), "金色瓦");

            this.add(ChangShengJueBlocks.BLACK_TILE.get(), "瓦");
            this.add(ChangShengJueBlocks.BLACK_GENTLE_TILE.get(), "平緩瓦");
            this.add(ChangShengJueBlocks.BLACK_CORNICES.get(), "飛簷瓦");
            this.add(ChangShengJueBlocks.BLACK_GENTLE_CORNICES.get(), "平缓飛簷瓦");
            this.add(ChangShengJueBlocks.TILE_BLOCK_2.get(), "瓦");
            this.add(ChangShengJueBlocks.TILE_BLOCK_3.get(), "瓦");
            this.add(ChangShengJueBlocks.TILE_BLOCK_4.get(), "瓦");

            this.add(ChangShengJueBlocks.BITUMEN_FLOOR_TILES_BLOCK.get(), "瀝青地磚");
            this.add(ChangShengJueBlocks.BLUE_FLOOR_TILES_BLOCK.get(), "青石地磚");
            this.add(ChangShengJueBlocks.BLACK_FLOOR_TILES_BLOCK.get(), "黑石地磚");

            this.add(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK.get(), "白樺木窗戶");
            this.add(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK_1.get(), "白樺木窗戶");
            this.add(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK.get(), "金合歡窗戶");
            this.add(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK_1.get(), "金合歡窗戶");
            this.add(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK.get(), "深色橡木窗戶");
            this.add(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK_1.get(), "深色橡木窗戶");
            this.add(ChangShengJueBlocks.WINDOWS_OAK_BLOCK.get(), "橡木窗戶");
            this.add(ChangShengJueBlocks.WINDOWS_OAK_BLOCK_1.get(), "橡木窗戶");
            this.add(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK.get(), "雲杉窗戶");
            this.add(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK_1.get(), "雲杉窗戶");

            this.add(ChangShengJueBlocks.HIGH_BIRCH_WINDOWS.get(), "白樺木窗戶");
            this.add(ChangShengJueBlocks.HIGH_ACACIA_WINDOWS.get(), "金合歡木窗戶");
            this.add(ChangShengJueBlocks.HIGH_DARK_OAK_WINDOWS.get(), "深色橡木窗戶");
            this.add(ChangShengJueBlocks.HIGH_OAK_WINDOWS.get(), "橡木窗戶");
            this.add(ChangShengJueBlocks.HIGH_SPRUCE_WINDOWS.get(), "雲杉木窗戶");

            this.add(ChangShengJueBlocks.DOOR_BIRCH.get(), "白樺木門");
            this.add(ChangShengJueBlocks.DOOR_ACACIA.get(), "金合歡木門");
            this.add(ChangShengJueBlocks.DOOR_DARK_OAK.get(), "深色橡木門");
            this.add(ChangShengJueBlocks.DOOR_OAK.get(), "橡木門");
            this.add(ChangShengJueBlocks.DOOR_SPRUCE.get(), "雲杉木門");

            this.add(ChangShengJueBlocks.MEI_REN_KAO_ACACIA_BLOCK.get(), "金合歡木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_DARK_OAK_BLOCK.get(), "深色橡木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_OAK_BLOCK.get(), "橡木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_SPRUCE_BLOCK.get(), "雲杉木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_BIRCH_BLOCK.get(), "白樺木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_JUNGLE_BLOCK.get(), "叢林木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_MANGROVE_BLOCK.get(), "紅樹木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_CHERRY_BLOCK.get(), "櫻花木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_CRIMSON_BLOCK.get(), "緋紅木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_WARPED_BLOCK.get(), "詭異木美人靠");

            this.add(ChangShengJueBlocks.BIRCH_BENCH.get(), "白樺木長凳");
            this.add(ChangShengJueBlocks.JUNGLE_BENCH.get(), "叢林木長凳");
            this.add(ChangShengJueBlocks.CRIMSON_BENCH.get(), "緋紅木長凳");
            this.add(ChangShengJueBlocks.WARPED_BENCH.get(), "詭異木長凳");
            this.add(ChangShengJueBlocks.MANGROVE_BENCH.get(), "紅樹長凳");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_BENCH.get(), "黃花梨長凳");
            this.add(ChangShengJueBlocks.JI_CHI_MU_BENCH.get(), "雞翅木長凳");
            this.add(ChangShengJueBlocks.ACACIA_BENCH.get(), "金合歡木長凳");
            this.add(ChangShengJueBlocks.DARK_OAK_BENCH.get(), "深色橡木長凳");
            this.add(ChangShengJueBlocks.OAK_BENCH.get(), "橡木長凳");
            this.add(ChangShengJueBlocks.CHERRY_BENCH.get(), "櫻花木長凳");
            this.add(ChangShengJueBlocks.SPRUCE_BENCH.get(), "雲杉木長凳");
            this.add(ChangShengJueBlocks.ZI_TAN_BENCH.get(), "紫檀木長凳");

            this.add(ChangShengJueBlocks.BIRCH_DRINKING_TABLE_AND_CHAIRS.get(), "白樺木酒桌椅");
            this.add(ChangShengJueBlocks.JUNGLE_DRINKING_TABLE_AND_CHAIRS.get(), "叢林木酒桌椅");
            this.add(ChangShengJueBlocks.CRIMSON_DRINKING_TABLE_AND_CHAIRS.get(), "緋紅木酒桌椅");
            this.add(ChangShengJueBlocks.WARPED_DRINKING_TABLE_AND_CHAIRS.get(), "詭異木酒桌椅");
            this.add(ChangShengJueBlocks.MANGROVE_DRINKING_TABLE_AND_CHAIRS.get(), "紅樹酒桌椅");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_DRINKING_TABLE_AND_CHAIRS.get(), "黃花梨酒桌椅");
            this.add(ChangShengJueBlocks.JI_CHI_MU_DRINKING_TABLE_AND_CHAIRS.get(), "雞翅木酒桌椅");
            this.add(ChangShengJueBlocks.ACACIA_DRINKING_TABLE_AND_CHAIRS.get(), "金合歡木酒桌椅");
            this.add(ChangShengJueBlocks.DARK_OAK_DRINKING_TABLE_AND_CHAIRS.get(), "深色橡木酒桌椅");
            this.add(ChangShengJueBlocks.OAK_DRINKING_TABLE_AND_CHAIRS.get(), "橡木酒桌椅");
            this.add(ChangShengJueBlocks.CHERRY_DRINKING_TABLE_AND_CHAIRS.get(), "櫻花木酒桌椅");
            this.add(ChangShengJueBlocks.SPRUCE_DRINKING_TABLE_AND_CHAIRS.get(), "雲杉木酒桌椅");
            this.add(ChangShengJueBlocks.ZI_TAN_DRINKING_TABLE_AND_CHAIRS.get(), "紫檀木酒桌椅");

            this.add(ChangShengJueBlocks.BIRCH_BOOK_DESK.get(), "白樺木書桌");
            this.add(ChangShengJueBlocks.JUNGLE_BOOK_DESK.get(), "叢林木書桌");
            this.add(ChangShengJueBlocks.CRIMSON_BOOK_DESK.get(), "緋紅木書桌");
            this.add(ChangShengJueBlocks.WARPED_BOOK_DESK.get(), "詭異木書桌");
            this.add(ChangShengJueBlocks.MANGROVE_BOOK_DESK.get(), "紅樹書桌");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_DESK.get(), "黃花梨書桌");
            this.add(ChangShengJueBlocks.JI_CHI_MU_BOOK_DESK.get(), "雞翅木書桌");
            this.add(ChangShengJueBlocks.ACACIA_BOOK_DESK.get(), "金合歡書桌");
            this.add(ChangShengJueBlocks.DARK_OAK_BOOK_DESK.get(), "深色橡木書桌");
            this.add(ChangShengJueBlocks.OAK_BOOK_DESK.get(), "橡木書桌");
            this.add(ChangShengJueBlocks.CHERRY_BOOK_DESK.get(), "櫻花木書桌");
            this.add(ChangShengJueBlocks.SPRUCE_BOOK_DESK.get(), "雲杉木書桌");
            this.add(ChangShengJueBlocks.ZI_TAN_BOOK_DESK.get(), "紫檀木書桌");

            this.add(ChangShengJueBlocks.BIRCH_TEAPOY.get(), "白樺木茶几");
            this.add(ChangShengJueBlocks.JUNGLE_TEAPOY.get(), "叢林木茶几");
            this.add(ChangShengJueBlocks.CRIMSON_TEAPOY.get(), "緋紅木茶几");
            this.add(ChangShengJueBlocks.WARPED_TEAPOY.get(), "詭異木茶几");
            this.add(ChangShengJueBlocks.MANGROVE_TEAPOY.get(), "紅木茶几");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get(), "黃花梨茶几");
            this.add(ChangShengJueBlocks.WENGE_TEAPOY.get(), "雞翅木茶几");
            this.add(ChangShengJueBlocks.ACACIA_TEAPOY.get(), "金合歡茶几");
            this.add(ChangShengJueBlocks.DARK_OAK_TEAPOY.get(), "深色橡木茶几");
            this.add(ChangShengJueBlocks.OAK_TEAPOY.get(), "橡木茶几");
            this.add(ChangShengJueBlocks.CHERRY_TEAPOY.get(), "樱花木茶几");
            this.add(ChangShengJueBlocks.SPRUCE_TEAPOY.get(), "雲杉木茶几");
            this.add(ChangShengJueBlocks.ZI_TAN_TEAPOY.get(), "紫檀木茶几");

            this.add(ChangShengJueBlocks.BIRCH_TAISHI_CHAIR.get(), "白樺木太師椅");
            this.add(ChangShengJueBlocks.JUNGLE_TAISHI_CHAIR.get(), "叢林木太師椅");
            this.add(ChangShengJueBlocks.CRIMSON_TAISHI_CHAIR.get(), "緋紅木太師椅");
            this.add(ChangShengJueBlocks.WARPED_TAISHI_CHAIR.get(), "詭異木太師椅");
            this.add(ChangShengJueBlocks.MANGROVE_TAISHI_CHAIR.get(), "紅木太師椅");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR.get(), "黃花梨太師椅");
            this.add(ChangShengJueBlocks.WENGE_TAISHI_CHAIR.get(), "雞翅木太師椅");
            this.add(ChangShengJueBlocks.ACACIA_TAISHI_CHAIR.get(), "金合歡太師椅");
            this.add(ChangShengJueBlocks.DARK_OAK_TAISHI_CHAIR.get(), "深色橡木太師椅");
            this.add(ChangShengJueBlocks.OAK_TAISHI_CHAIR.get(), "橡木太師椅");
            this.add(ChangShengJueBlocks.CHERRY_TAISHI_CHAIR.get(), "樱花木太師椅");
            this.add(ChangShengJueBlocks.SPRUCE_TAISHI_CHAIR.get(), "雲杉木太師椅");
            this.add(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR.get(), "紫檀木太師椅");

            this.add(ChangShengJueBlocks.BIRCH_FIVE_SCREEN_THRONE.get(), "白樺木五圍屏寶座");
            this.add(ChangShengJueBlocks.JUNGLE_FIVE_SCREEN_THRONE.get(), "叢林木五圍屏寶座");
            this.add(ChangShengJueBlocks.CRIMSON_FIVE_SCREEN_THRONE.get(), "緋紅木五圍屏寶座");
            this.add(ChangShengJueBlocks.WARPED_FIVE_SCREEN_THRONE.get(), "詭異木五圍屏寶座");
            this.add(ChangShengJueBlocks.MANGROVE_FIVE_SCREEN_THRONE.get(), "紅木五圍屏寶座");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE.get(), "黃花梨五圍屏寶座");
            this.add(ChangShengJueBlocks.WENGE_FIVE_SCREEN_THRONE.get(), "雞翅木五圍屏寶座");
            this.add(ChangShengJueBlocks.ACACIA_FIVE_SCREEN_THRONE.get(), "金合歡五圍屏寶座");
            this.add(ChangShengJueBlocks.DARK_OAK_FIVE_SCREEN_THRONE.get(), "深色橡木五圍屏寶座");
            this.add(ChangShengJueBlocks.OAK_FIVE_SCREEN_THRONE.get(), "橡木五圍屏寶座");
            this.add(ChangShengJueBlocks.CHERRY_FIVE_SCREEN_THRONE.get(), "樱花木五圍屏寶座");
            this.add(ChangShengJueBlocks.SPRUCE_FIVE_SCREEN_THRONE.get(), "雲杉木五圍屏寶座");
            this.add(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE.get(), "紫檀木五圍屏寶座");

            this.add(ChangShengJueBlocks.BIRCH_LOW_DESK.get(), "白樺木席桌");
            this.add(ChangShengJueBlocks.JUNGLE_LOW_DESK.get(), "叢林木席桌");
            this.add(ChangShengJueBlocks.CRIMSON_LOW_DESK.get(), "緋紅木席桌");
            this.add(ChangShengJueBlocks.WARPED_LOW_DESK.get(), "詭異木席桌");
            this.add(ChangShengJueBlocks.MANGROVE_LOW_DESK.get(), "紅樹席桌");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LOW_DESK.get(), "黃花梨席桌");
            this.add(ChangShengJueBlocks.JI_CHI_MU_LOW_DESK.get(), "雞翅木席桌");
            this.add(ChangShengJueBlocks.ACACIA_LOW_DESK.get(), "金合歡席桌");
            this.add(ChangShengJueBlocks.DARK_OAK_LOW_DESK.get(), "深色橡木席桌");
            this.add(ChangShengJueBlocks.OAK_LOW_DESK.get(), "橡木席桌");
            this.add(ChangShengJueBlocks.CHERRY_LOW_DESK.get(), "櫻花木席桌");
            this.add(ChangShengJueBlocks.SPRUCE_LOW_DESK.get(), "雲杉木席桌");
            this.add(ChangShengJueBlocks.ZI_TAN_LOW_DESK.get(), "紫檀木席桌");

            this.add(ChangShengJueBlocks.BIRCH_SQUARE_STOOL.get(), "白樺木方凳");
            this.add(ChangShengJueBlocks.JUNGLE_SQUARE_STOOL.get(), "叢林木方凳");
            this.add(ChangShengJueBlocks.CRIMSON_SQUARE_STOOL.get(), "緋紅木方凳");
            this.add(ChangShengJueBlocks.WARPED_SQUARE_STOOL.get(), "詭異木方凳");
            this.add(ChangShengJueBlocks.MANGROVE_SQUARE_STOOL.get(), "紅木方凳");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_SQUARE_STOOL.get(), "黃花梨方凳");
            this.add(ChangShengJueBlocks.WENGE_SQUARE_STOOL.get(), "雞翅木方凳");
            this.add(ChangShengJueBlocks.ACACIA_SQUARE_STOOL.get(), "金合歡方凳");
            this.add(ChangShengJueBlocks.DARK_OAK_SQUARE_STOOL.get(), "深色橡木方凳");
            this.add(ChangShengJueBlocks.OAK_SQUARE_STOOL.get(), "橡木方凳");
            this.add(ChangShengJueBlocks.CHERRY_SQUARE_STOOL.get(), "樱花木方凳");
            this.add(ChangShengJueBlocks.SPRUCE_SQUARE_STOOL.get(), "雲杉木方凳");
            this.add(ChangShengJueBlocks.ZI_TAN_SQUARE_STOOL.get(), "紫檀木方凳");

            this.add(ChangShengJueBlocks.BIRCH_FRETWORK_OPENWORK_PANEL.get(), "白樺木回紋亮格");
            this.add(ChangShengJueBlocks.JUNGLE_FRETWORK_OPENWORK_PANEL.get(), "叢林木回紋亮格");
            this.add(ChangShengJueBlocks.CRIMSON_FRETWORK_OPENWORK_PANEL.get(), "緋紅木回紋亮格");
            this.add(ChangShengJueBlocks.WARPED_FRETWORK_OPENWORK_PANEL.get(), "詭異木回紋亮格");
            this.add(ChangShengJueBlocks.MANGROVE_FRETWORK_OPENWORK_PANEL.get(), "紅木回紋亮格");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_FRETWORK_OPENWORK_PANEL.get(), "黄花梨回紋亮格");
            this.add(ChangShengJueBlocks.WENGE_FRETWORK_OPENWORK_PANEL.get(), "雞翅木回紋亮格");
            this.add(ChangShengJueBlocks.ACACIA_FRETWORK_OPENWORK_PANEL.get(), "金合歡回紋亮格");
            this.add(ChangShengJueBlocks.DARK_OAK_FRETWORK_OPENWORK_PANEL.get(), "深色橡木回紋亮格");
            this.add(ChangShengJueBlocks.OAK_FRETWORK_OPENWORK_PANEL.get(), "橡木回紋亮格");
            this.add(ChangShengJueBlocks.CHERRY_FRETWORK_OPENWORK_PANEL.get(), "樱花木回紋亮格");
            this.add(ChangShengJueBlocks.SPRUCE_FRETWORK_OPENWORK_PANEL.get(), "雲杉木回紋亮格");
            this.add(ChangShengJueBlocks.ZI_TAN_FRETWORK_OPENWORK_PANEL.get(), "紫檀木回紋亮格");

            this.add(ChangShengJueBlocks.BIRCH_BOOK_GRID.get(), "白樺木書格");
            this.add(ChangShengJueBlocks.JUNGLE_BOOK_GRID.get(), "叢林木書格");
            this.add(ChangShengJueBlocks.CRIMSON_BOOK_GRID.get(), "緋紅木書格");
            this.add(ChangShengJueBlocks.WARPED_BOOK_GRID.get(), "詭異木書格");
            this.add(ChangShengJueBlocks.MANGROVE_BOOK_GRID.get(), "紅木書格");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_GRID.get(), "黄花梨書格");
            this.add(ChangShengJueBlocks.WENGE_BOOK_GRID.get(), "雞翅木書格");
            this.add(ChangShengJueBlocks.ACACIA_BOOK_GRID.get(), "金合歡書格");
            this.add(ChangShengJueBlocks.DARK_OAK_BOOK_GRID.get(), "深色橡木書格");
            this.add(ChangShengJueBlocks.OAK_BOOK_GRID.get(), "橡木書格");
            this.add(ChangShengJueBlocks.CHERRY_BOOK_GRID.get(), "樱花木書格");
            this.add(ChangShengJueBlocks.SPRUCE_BOOK_GRID.get(), "雲杉木書格");
            this.add(ChangShengJueBlocks.ZI_TAN_BOOK_GRID.get(), "紫檀木書格");

            this.add(ChangShengJueBlocks.BIRCH_CABINET.get(), "白樺木櫃子");
            this.add(ChangShengJueBlocks.JUNGLE_CABINET.get(), "叢林木櫃子");
            this.add(ChangShengJueBlocks.CRIMSON_CABINET.get(), "緋紅木櫃子");
            this.add(ChangShengJueBlocks.WARPED_CABINET.get(), "詭異木櫃子");
            this.add(ChangShengJueBlocks.MANGROVE_CABINET.get(), "紅木櫃子");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_CABINET.get(), "黄花梨櫃子");
            this.add(ChangShengJueBlocks.WENGE_CABINET.get(), "雞翅木櫃子");
            this.add(ChangShengJueBlocks.ACACIA_CABINET.get(), "金合歡櫃子");
            this.add(ChangShengJueBlocks.DARK_OAK_CABINET.get(), "深色橡木櫃子");
            this.add(ChangShengJueBlocks.OAK_CABINET.get(), "橡木櫃子");
            this.add(ChangShengJueBlocks.CHERRY_CABINET.get(), "樱花木櫃子");
            this.add(ChangShengJueBlocks.SPRUCE_CABINET.get(), "雲杉木櫃子");
            this.add(ChangShengJueBlocks.ZI_TAN_CABINET.get(), "紫檀木櫃子");

            this.add(ChangShengJueBlocks.BIRCH_LARGE_CABINET.get(), "白樺木立櫃");
            this.add(ChangShengJueBlocks.JUNGLE_LARGE_CABINET.get(), "叢林木立櫃");
            this.add(ChangShengJueBlocks.CRIMSON_LARGE_CABINET.get(), "緋紅木立櫃");
            this.add(ChangShengJueBlocks.WARPED_LARGE_CABINET.get(), "詭異木立櫃");
            this.add(ChangShengJueBlocks.MANGROVE_LARGE_CABINET.get(), "紅木立櫃");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LARGE_CABINET.get(), "黄花梨立櫃");
            this.add(ChangShengJueBlocks.WENGE_LARGE_CABINET.get(), "雞翅木立櫃");
            this.add(ChangShengJueBlocks.ACACIA_LARGE_CABINET.get(), "金合歡立櫃");
            this.add(ChangShengJueBlocks.DARK_OAK_LARGE_CABINET.get(), "深色橡木立櫃");
            this.add(ChangShengJueBlocks.OAK_LARGE_CABINET.get(), "橡木立櫃");
            this.add(ChangShengJueBlocks.CHERRY_LARGE_CABINET.get(), "樱花木立櫃");
            this.add(ChangShengJueBlocks.SPRUCE_LARGE_CABINET.get(), "雲杉木立櫃");
            this.add(ChangShengJueBlocks.ZI_TAN_LARGE_CABINET.get(), "紫檀木立櫃");

            this.add(ChangShengJueBlocks.BIRCH_DRYING_RAIL.get(), "白樺木晾衣桿");
            this.add(ChangShengJueBlocks.JUNGLE_DRYING_RAIL.get(), "叢林木晾衣桿");
            this.add(ChangShengJueBlocks.CRIMSON_DRYING_RAIL.get(), "緋紅木晾衣桿");
            this.add(ChangShengJueBlocks.WARPED_DRYING_RAIL.get(), "詭異木晾衣桿");
            this.add(ChangShengJueBlocks.MANGROVE_DRYING_RAIL.get(), "紅木晾衣桿");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_DRYING_RAIL.get(), "黄花梨晾衣桿");
            this.add(ChangShengJueBlocks.WENGE_DRYING_RAIL.get(), "雞翅木晾衣桿");
            this.add(ChangShengJueBlocks.ACACIA_DRYING_RAIL.get(), "金合歡晾衣桿");
            this.add(ChangShengJueBlocks.DARK_OAK_DRYING_RAIL.get(), "深色橡木晾衣桿");
            this.add(ChangShengJueBlocks.OAK_DRYING_RAIL.get(), "橡木晾衣桿");
            this.add(ChangShengJueBlocks.CHERRY_DRYING_RAIL.get(), "樱花木晾衣桿");
            this.add(ChangShengJueBlocks.SPRUCE_DRYING_RAIL.get(), "雲杉木晾衣桿");
            this.add(ChangShengJueBlocks.ZI_TAN_DRYING_RAIL.get(), "紫檀木晾衣桿");

            this.add(ChangShengJueBlocks.BIRCH_CLOTHES_RACK.get(), "白樺木衣架");
            this.add(ChangShengJueBlocks.JUNGLE_CLOTHES_RACK.get(), "叢林木衣架");
            this.add(ChangShengJueBlocks.CRIMSON_CLOTHES_RACK.get(), "緋紅木衣架");
            this.add(ChangShengJueBlocks.WARPED_CLOTHES_RACK.get(), "詭異木衣架");
            this.add(ChangShengJueBlocks.MANGROVE_CLOTHES_RACK.get(), "紅木衣架");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_CLOTHES_RACK.get(), "黄花梨衣架");
            this.add(ChangShengJueBlocks.WENGE_CLOTHES_RACK.get(), "雞翅木衣架");
            this.add(ChangShengJueBlocks.ACACIA_CLOTHES_RACK.get(), "金合歡衣架");
            this.add(ChangShengJueBlocks.DARK_OAK_CLOTHES_RACK.get(), "深色橡木衣架");
            this.add(ChangShengJueBlocks.OAK_CLOTHES_RACK.get(), "橡木衣架");
            this.add(ChangShengJueBlocks.CHERRY_CLOTHES_RACK.get(), "樱花木衣架");
            this.add(ChangShengJueBlocks.SPRUCE_CLOTHES_RACK.get(), "雲杉木衣架");
            this.add(ChangShengJueBlocks.ZI_TAN_CLOTHES_RACK.get(), "紫檀木衣架");

            this.add(ChangShengJueBlocks.BIRCH_CHEST_OF_DRAWERS.get(), "白樺木屜櫃");
            this.add(ChangShengJueBlocks.JUNGLE_CHEST_OF_DRAWERS.get(), "叢林木屜櫃");
            this.add(ChangShengJueBlocks.CRIMSON_CHEST_OF_DRAWERS.get(), "緋紅木屜櫃");
            this.add(ChangShengJueBlocks.WARPED_CHEST_OF_DRAWERS.get(), "詭異木屜櫃");
            this.add(ChangShengJueBlocks.MANGROVE_CHEST_OF_DRAWERS.get(), "紅木屜櫃");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_CHEST_OF_DRAWERS.get(), "黄花梨屜櫃");
            this.add(ChangShengJueBlocks.WENGE_CHEST_OF_DRAWERS.get(), "雞翅木屜櫃");
            this.add(ChangShengJueBlocks.ACACIA_CHEST_OF_DRAWERS.get(), "金合歡屜櫃");
            this.add(ChangShengJueBlocks.DARK_OAK_CHEST_OF_DRAWERS.get(), "深色橡木屜櫃");
            this.add(ChangShengJueBlocks.OAK_CHEST_OF_DRAWERS.get(), "橡木屜櫃");
            this.add(ChangShengJueBlocks.CHERRY_CHEST_OF_DRAWERS.get(), "樱花木屜櫃");
            this.add(ChangShengJueBlocks.SPRUCE_CHEST_OF_DRAWERS.get(), "雲杉木屜櫃");
            this.add(ChangShengJueBlocks.ZI_TAN_CHEST_OF_DRAWERS.get(), "紫檀木屜櫃");

            this.add(ChangShengJueBlocks.BIRCH_LIANGGE.get(), "白樺木亮格");
            this.add(ChangShengJueBlocks.JUNGLE_LIANGGE.get(), "叢林木亮格");
            this.add(ChangShengJueBlocks.CRIMSON_LIANGGE.get(), "緋紅木亮格");
            this.add(ChangShengJueBlocks.WARPED_LIANGGE.get(), "詭異木亮格");
            this.add(ChangShengJueBlocks.MANGROVE_LIANGGE.get(), "紅木亮格");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LIANGGE.get(), "黄花梨亮格");
            this.add(ChangShengJueBlocks.WENGE_LIANGGE.get(), "雞翅木亮格");
            this.add(ChangShengJueBlocks.ACACIA_LIANGGE.get(), "金合歡亮格");
            this.add(ChangShengJueBlocks.DARK_OAK_LIANGGE.get(), "深色橡木亮格");
            this.add(ChangShengJueBlocks.OAK_LIANGGE.get(), "橡木亮格");
            this.add(ChangShengJueBlocks.CHERRY_LIANGGE.get(), "樱花木亮格");
            this.add(ChangShengJueBlocks.SPRUCE_LIANGGE.get(), "雲杉木亮格");
            this.add(ChangShengJueBlocks.ZI_TAN_LIANGGE.get(), "紫檀木亮格");

            this.add(ChangShengJueBlocks.STONE_BENCH.get(), "石凳");
            this.add(ChangShengJueBlocks.STONE_TABLE.get(), "石桌");
            this.add(ChangShengJueBlocks.STONE_BALUSTRADE.get(),"石欄杆");

            this.add(ChangShengJueBlocks.ZAFU.get(), "蒲團");

            this.add(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN.get(), "白樺木折屏");
            this.add(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN.get(), "叢林木折屏");
            this.add(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN.get(), "緋紅木折屏");
            this.add(ChangShengJueBlocks.WARPED_FOLDING_SCREEN.get(), "詭異木折屏");
            this.add(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN.get(), "紅木折屏");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN.get(), "黃花梨折屏");
            this.add(ChangShengJueBlocks.WENGE_FOLDING_SCREEN.get(), "雞翅木折屏");
            this.add(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN.get(), "金合歡折屏");
            this.add(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN.get(), "深色橡木折屏");
            this.add(ChangShengJueBlocks.OAK_FOLDING_SCREEN.get(), "橡木折屏");
            this.add(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN.get(), "樱花木折屏");
            this.add(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN.get(), "雲杉木折屏");
            this.add(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN.get(), "紫檀木折屏");

            this.add(ChangShengJueBlocks.BIRCH_ARHAT_BED.get(), "白樺木藤面羅漢床");
            this.add(ChangShengJueBlocks.JUNGLE_ARHAT_BED.get(), "叢林木藤面羅漢床");
            this.add(ChangShengJueBlocks.CRIMSON_ARHAT_BED.get(), "緋紅木藤面羅漢床");
            this.add(ChangShengJueBlocks.WARPED_ARHAT_BED.get(), "詭異木藤面羅漢床");
            this.add(ChangShengJueBlocks.MANGROVE_ARHAT_BED.get(), "紅木藤面羅漢床");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_ARHAT_BED.get(), "黃花梨藤面羅漢床");
            this.add(ChangShengJueBlocks.WENGE_ARHAT_BED.get(), "雞翅木藤面羅漢床");
            this.add(ChangShengJueBlocks.ACACIA_ARHAT_BED.get(), "金合歡藤面羅漢床");
            this.add(ChangShengJueBlocks.DARK_OAK_ARHAT_BED.get(), "深色橡木藤面羅漢床");
            this.add(ChangShengJueBlocks.OAK_ARHAT_BED.get(), "橡木藤面羅漢床");
            this.add(ChangShengJueBlocks.CHERRY_ARHAT_BED.get(), "櫻花木藤面羅漢床");
            this.add(ChangShengJueBlocks.SPRUCE_ARHAT_BED.get(), "雲杉木藤面羅漢床");
            this.add(ChangShengJueBlocks.ZI_TAN_ARHAT_BED.get(), "紫檀木藤面羅漢床");

            this.add(ChangShengJueBlocks.BIRCH_CANOPY_BED.get(), "白樺木架子床");
            this.add(ChangShengJueBlocks.JUNGLE_CANOPY_BED.get(), "叢林木架子床");
            this.add(ChangShengJueBlocks.CRIMSON_CANOPY_BED.get(), "緋紅木架子床");
            this.add(ChangShengJueBlocks.WARPED_CANOPY_BED.get(), "詭異木架子床");
            this.add(ChangShengJueBlocks.MANGROVE_CANOPY_BED.get(), "紅木架子床");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.get(), "黃花梨架子床");
            this.add(ChangShengJueBlocks.WENGE_CANOPY_BED.get(), "雞翅木架子床");
            this.add(ChangShengJueBlocks.ACACIA_CANOPY_BED.get(), "金合歡架子床");
            this.add(ChangShengJueBlocks.DARK_OAK_CANOPY_BED.get(), "深色橡木架子床");
            this.add(ChangShengJueBlocks.OAK_CANOPY_BED.get(), "橡木架子床");
            this.add(ChangShengJueBlocks.CHERRY_CANOPY_BED.get(), "櫻花木架子床");
            this.add(ChangShengJueBlocks.SPRUCE_CANOPY_BED.get(), "雲杉木架子床");
            this.add(ChangShengJueBlocks.ZI_TAN_CANOPY_BED.get(), "紫檀木架子床");

            this.add(ChangShengJueBlocks.LANTERN.get(), "白色燈籠");
            this.add(ChangShengJueBlocks.WHITE_LANTERN.get(), "白色燈籠");
            this.add(ChangShengJueBlocks.ORANGE_LANTERN.get(), "橙色燈籠");
            this.add(ChangShengJueBlocks.MAGENTA_LANTERN.get(), "品红色燈籠");
            this.add(ChangShengJueBlocks.LIGHT_BLUE_LANTERN.get(), "浅蓝色燈籠");
            this.add(ChangShengJueBlocks.YELLOW_LANTERN.get(), "黄色燈籠");
            this.add(ChangShengJueBlocks.LIME_LANTERN.get(), "黄绿色燈籠");
            this.add(ChangShengJueBlocks.PINK_LANTERN.get(), "粉红色燈籠");
            this.add(ChangShengJueBlocks.GRAY_LANTERN.get(), "灰色燈籠");
            this.add(ChangShengJueBlocks.LIGHT_GRAY_LANTERN.get(), "浅灰色燈籠");
            this.add(ChangShengJueBlocks.CYAN_LANTERN.get(), "青色燈籠");
            this.add(ChangShengJueBlocks.PURPLE_LANTERN.get(), "紫色燈籠");
            this.add(ChangShengJueBlocks.BLUE_LANTERN.get(), "蓝色燈籠");
            this.add(ChangShengJueBlocks.BROWN_LANTERN.get(), "棕色燈籠");
            this.add(ChangShengJueBlocks.GREEN_LANTERN.get(), "绿色燈籠");
            this.add(ChangShengJueBlocks.RED_LANTERN.get(), "红色燈籠");
            this.add(ChangShengJueBlocks.BLACK_LANTERN.get(), "黑色燈籠");

            this.add(ChangShengJueBlocks.BIRCH_LIGHT_STAND.get(), "白樺木獨柱燭台");
            this.add(ChangShengJueBlocks.JUNGLE_LIGHT_STAND.get(), "叢林木白獨柱燭台");
            this.add(ChangShengJueBlocks.CRIMSON_LIGHT_STAND.get(), "緋紅木白獨柱燭台");
            this.add(ChangShengJueBlocks.WARPED_LIGHT_STAND.get(), "詭異木白獨柱燭台");
            this.add(ChangShengJueBlocks.MANGROVE_LIGHT_STAND.get(), "紅木白獨柱燭台");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LIGHT_STAND.get(), "黃花梨白獨柱燭台");
            this.add(ChangShengJueBlocks.WENGE_LIGHT_STAND.get(), "雞翅木白獨柱燭台");
            this.add(ChangShengJueBlocks.ACACIA_LIGHT_STAND.get(), "金合歡白獨柱燭台");
            this.add(ChangShengJueBlocks.DARK_OAK_LIGHT_STAND.get(), "深色橡木白獨柱燭台");
            this.add(ChangShengJueBlocks.OAK_LIGHT_STAND.get(), "橡木白獨柱燭台");
            this.add(ChangShengJueBlocks.CHERRY_LIGHT_STAND.get(), "櫻花木白獨柱燭台");
            this.add(ChangShengJueBlocks.SPRUCE_LIGHT_STAND.get(), "雲杉木白獨柱燭台");
            this.add(ChangShengJueBlocks.ZI_TAN_LIGHT_STAND.get(), "紫檀木白獨柱燭台");

            this.add(ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND.get(), "白樺木燈掛架");
            this.add(ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND.get(), "叢林木白燈掛架");
            this.add(ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND.get(), "緋紅木白燈掛架");
            this.add(ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND.get(), "詭異木白燈掛架");
            this.add(ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND.get(), "紅木白燈掛架");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND.get(), "黃花梨白燈掛架");
            this.add(ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND.get(), "雞翅木白燈掛架");
            this.add(ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND.get(), "金合歡白燈掛架");
            this.add(ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND.get(), "深色橡木白燈掛架");
            this.add(ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND.get(), "橡木白燈掛架");
            this.add(ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND.get(), "櫻花木白燈掛架");
            this.add(ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND.get(), "雲杉木白燈掛架");
            this.add(ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND.get(), "紫檀木白燈掛架");

            this.add(ChangShengJueBlocks.BAMBOO_MAT.get(), "竹席");

            this.add(ChangShengJueBlocks.BIRCH_WINE_TABLE.get(), "白樺木酒桌");
            this.add(ChangShengJueBlocks.JUNGLE_WINE_TABLE.get(), "叢林木酒桌");
            this.add(ChangShengJueBlocks.CRIMSON_WINE_TABLE.get(), "緋紅木酒桌");
            this.add(ChangShengJueBlocks.WARPED_WINE_TABLE.get(), "詭異木酒桌");
            this.add(ChangShengJueBlocks.MANGROVE_WINE_TABLE.get(), "紅樹酒桌");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE.get(), "黃花梨酒桌");
            this.add(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE.get(), "雞翅木酒桌");
            this.add(ChangShengJueBlocks.ACACIA_WINE_TABLE.get(), "金合歡酒桌");
            this.add(ChangShengJueBlocks.DARK_OAK_WINE_TABLE.get(), "深色橡木酒桌");
            this.add(ChangShengJueBlocks.OAK_WINE_TABLE.get(), "橡木酒桌");
            this.add(ChangShengJueBlocks.CHERRY_WINE_TABLE.get(), "櫻花木酒桌");
            this.add(ChangShengJueBlocks.SPRUCE_WINE_TABLE.get(), "雲杉木酒桌");
            this.add(ChangShengJueBlocks.ZI_TAN_WINE_TABLE.get(), "紫檀木酒桌");

            this.add(ChangShengJueBlocks.WHITE_JADE_BLOCK.get(),  "漢白玉塊");
            this.add(ChangShengJueBlocks.WHITE_JADE_STAIRS.get(), "漢白玉樓梯");
            this.add(ChangShengJueBlocks.WHITE_JADE_SLAB.get(), "漢白玉台階");
            this.add(ChangShengJueBlocks.WHITE_JADE_WALL.get(), "漢白玉牆");
            this.add(ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get(),"漢白玉欄杆");
            this.add(ChangShengJueBlocks.OAK_BALUSTRADE.get(),"橡木欄杆");
            this.add(ChangShengJueBlocks.SPRUCE_BALUSTRADE.get(), "雲杉木欄杆");
            this.add(ChangShengJueBlocks.BIRCH_BALUSTRADE.get(), "白樺木欄杆");
            this.add(ChangShengJueBlocks.JUNGLE_BALUSTRADE.get(), "金合歡木欄杆");
            this.add(ChangShengJueBlocks.ACACIA_BALUSTRADE.get(), "金合歡木欄杆");
            this.add(ChangShengJueBlocks.MANGROVE_BALUSTRADE.get(), "紅樹欄杆");
            this.add(ChangShengJueBlocks.CHERRY_BALUSTRADE.get(), "櫻花木欄杆");
            this.add(ChangShengJueBlocks.DARK_OAK_BALUSTRADE.get(), "深色橡木欄杆");
            this.add(ChangShengJueBlocks.CRIMSON_BALUSTRADE.get(), "緋紅木欄杆");
            this.add(ChangShengJueBlocks.WARPED_BALUSTRADE.get(), "詭異木欄杆");
            this.add(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get(),"漢白玉護欄");

            this.add(ChangShengJueBlocks.AG_ORE.get(), "銀礦石");
            this.add(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get(), "深層銀礦石");
            this.add(ChangShengJueBlocks.KAOLIN_ORE.get(), "高嶺土礦");
            this.add(ChangShengJueBlocks.LIMESTONE.get(), "石灰岩");
            this.add(ChangShengJueBlocks.SYDEROLIFE_ORE.get(), "陶土礦");
            this.add(ChangShengJueBlocks.NATURAL_ASPHALT_ORE.get(), "天然瀝青塊");

            this.add(ChangShengJueBlocks.STONE_SHARPENING_STONE.get(), "圓石磨刀石");
            this.add(ChangShengJueBlocks.DIAMOND_SHARPENING_STONE.get(), "鑽石磨刀石");
            this.add(ChangShengJueBlocks.NETHERITE_SHARPENING_STONE.get(), "下界合金磨刀石");

            this.add(ChangShengJueBlocks.CASTING_MOLDS.get(), "銅錢模具");
            this.add(ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get(), "元寶模具");

            this.add(ChangShengJueBlocks.PAINTING_SCROLL.get(), "畫軸(1X1)");
            this.add(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get(), "畫軸(1X2)");
            this.add(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get(), "畫軸(2X1)");
            this.add(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get(), "畫軸(2X2)");

            this.add(ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get(), "織布機");
            this.add(ChangShengJueBlocks.POTTERY_WHEEL.get(), "陶輪");
            this.add(ChangShengJueBlocks.TOOL_TABLE.get(), "工具台");
            this.add(ChangShengJueBlocks.WEAPON_RACK.get(), "武器架");
            this.add(ChangShengJueBlocks.DESK.get(), "案台");
            this.add(ChangShengJueBlocks.PIG_TROUGH.get(), "牲畜食槽");

            this.add(ChangShengJueBlocks.PLAQUE.get(), "牌匾");
            this.add(ChangShengJueBlocks.SHING_MUN_LEFT.get(), "小城門(左)");
            this.add(ChangShengJueBlocks.SHING_MUN_RIGHT.get(), "小城門(右)");

            this.add(ChangShengJueBlocks.BIG_SHING_MUN_LEFT.get(), "大城門(左)");
            this.add(ChangShengJueBlocks.BIG_SHING_MUN_RIGHT.get(), "大城門(右)");
            this.add(ChangShengJueBlocks.WIND_CHIME.get(), "風鈴");
            this.add(ChangShengJueBlocks.TAILORING_CASE.get(), "裁衣案");
            this.add(ChangShengJueBlocks.FORGE_BLOCK.get(), "鍛造爐");
            this.add(ChangShengJueBlocks.WOOD_WORKING_BENCH.get(), "木工臺");
            this.add(ChangShengJueBlocks.BRICK_KILN.get(), "磚窯爐");
            //实体生物
            this.add(ChangShengJueEntity.BUTTERFLY.get(), "蝴蝶");
            this.add(ChangShengJueEntity.MONKEY.get(), "猴");
            this.add(ChangShengJueEntity.DRAGONFLY.get(), "蜻蜓");
            this.add(ChangShengJueEntity.CICADA.get(), "蟬");
            this.add(ChangShengJueEntity.CRANE.get(), "鶴");
            this.add(ChangShengJueEntity.MALE_PEACOCK.get(), "孔雀");
            this.add(ChangShengJueEntity.FEMALE_PEACOCK.get(), "孔雀");
            this.add(ChangShengJueEntity.STAG.get(), "鹿");
            this.add(ChangShengJueEntity.HIND.get(), "鹿");
            this.add(ChangShengJueEntity.TIGER.get(), "老虎");
            this.add(ChangShengJueEntity.CROC.get(), "鱷魚");
            this.add(ChangShengJueEntity.WARRIOR.get(), "武夫");
            this.add(ChangShengJueEntity.KILN_WORKER.get(), "營造主事");
            this.add(ChangShengJueEntity.MALE_INNKEEPER.get(), "酒館男掌櫃");
            this.add(ChangShengJueEntity.FEMALE_INNKEEPER.get(), "酒館女掌櫃");
            this.add(ChangShengJueEntity.CHALLENGER.get(), "挑戰者");
            this.add(ChangShengJueEntity.BLACKSMITH.get(), "鐵匠");
            this.add(ChangShengJueEntity.LANCE_GANG_LEADER.get(), "幫派首領");
            this.add(ChangShengJueEntity.KNIFE_GANG_LEADER.get(), "幫派首領");
            this.add(ChangShengJueEntity.SWORD_GANG_LEADER.get(), "幫派首領");
            this.add(ChangShengJueEntity.CLUBBED_GANG_LEADER.get(), "幫派首領");
            this.add(ChangShengJueEntity.GANG_LEADER.get(), "幫派首領");
            this.add(ChangShengJueEntity.BANDIT.get(), "強盜");
            this.add(ChangShengJueEntity.VILLAIN.get(), "惡徒");
            this.add(ChangShengJueEntity.ASSASSIN.get(), "幫派殺手");
            this.add(ChangShengJueEntity.CLUBBED_MING_XIA.get(), "棍王董大俠");
            this.add(ChangShengJueEntity.SWORD_MING_XIA.get(), "劍仙張大俠");
            this.add(ChangShengJueEntity.KNIFE_MING_XIA.get(), "刀聖徐大俠");
            this.add(ChangShengJueEntity.FIST_MING_XIA.get(), "北拳蕭大俠");
            this.add(ChangShengJueEntity.PIGLIN_WU_XIA.get(), "功夫豬靈");
            this.add(ChangShengJueEntity.WITCH_WU_XIA.get(), "功夫女巫");
            this.add(ChangShengJueEntity.EVOKER_WU_XIA.get(), "功夫喚魔者");
            this.add(ChangShengJueEntity.VINDICATOR_WU_XIA.get(), "功夫衛道士");
            this.add(ChangShengJueEntity.PILLAGER_WU_XIA.get(), "功夫掠奪者");

            this.add(ChangShengJueEntity.STAKES.get(), "練功木樁");
            this.add(ChangShengJueEntity.GE_SHAN_DA_NIU.get(), "隔山打牛");
            this.add(ChangShengJueEntity.PEACOCK_EGG.get(), "孔雀蛋");
            this.add(ChangShengJueEntity.THROWING_KNIVES_ENTITY.get(), "飛刀");
            this.add(ChangShengJueEntity.BA_WANG_QIANG.get(), "霸王槍");
            this.add(ChangShengJueEntity.RED_TASSELLED_SPEAR.get(), "紅纓槍");
            // 村民职业
            this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_farmer", "農民");
            this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_potter", "窯工");
            this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_hunter", "獵人");
            this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_chief", "村長");
            this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_seamstress", "縫工");

            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_farmer", "農民");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_potter", "窯工");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_hunter", "獵人");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_chief", "村長");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_seamstress", "縫工");

            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager", "村民");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.none", "無業");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.villager", "村民");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.armorer", "盔甲匠");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.butcher", "屠夫");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.cartographer", "製圖師");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.cleric", "牧師");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.farmer", "農民");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.fisherman", "漁夫");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.fletcher", "製箭師");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.leatherworker", "皮匠");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.librarian", "圖書管理員");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.mason", "石匠");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.nitwit", "傻子");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.shepherd", "牧羊人");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.toolsmith", "工具匠");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.weaponsmith", "武器匠");

            //buff
            this.add(ChangShengJueEffects.BLEED_EFFECT.get(), "流血");
            this.add(ChangShengJueEffects.DIZZY_EFFECT.get(), "眩暈");
            this.add(ChangShengJueEffects.AIRBORNE_EFFECT.get(), "挑飛");
            this.add(ChangShengJueEffects.FIXATION_EFFECT.get(), "定身");
            this.add(ChangShengJueEffects.TURTLE_BREATH_EFFECT.get(), "龜息");
            this.add(ChangShengJueEffects.TRAUMA_EFFECT.get(), "外傷");
            this.add(ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get(), "內傷");
            this.add(ChangShengJueEffects.BILUOCHUN_TEAS.get(), "碧螺春");
            this.add(ChangShengJueEffects.LONG_JING_TEAS.get(), "龍井");
            this.add(ChangShengJueEffects.FEN_JIU.get(), "汾酒");
            this.add(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get(), "麥塊貢酒");
            this.add(ChangShengJueEffects.SHI_LI_XIANG.get(), "十里香");
            this.add(ChangShengJueEffects.DRUNKEN.get(), "醉酒");
            this.add(ChangShengJueEffects.VILLAGER_CHARM_EFFECT.get(), "持續提高村民聲望");
            this.add(ChangShengJueEffects.INSTANT_CHARM_EFFECT.get(), "瞬間提高村民聲望");
            this.add(ChangShengJueEffects.INSTANT_DISFAVOR_EFFECT.get(), "瞬間降低村民聲望");

            //群系
            this.add("biome."+ ChangShengJue.MOD_ID +".chang_sheng_jue_prairie", "慕然草原");

            //存储
            this.add("container.hercules", "大力神功");
            this.add("container."+ ChangShengJue.MOD_ID +".cabinet", "櫃子");

            this.add("message.sharpening_stone.sharpened", "§a武器已打磨！ 本次增加：");
            this.add("message.sharpening_stone.total_damage", "§a，當前攻擊力：");
            this.add("message.sharpening_stone.max_damage", "§c武器已打磨到上限");
            /*信息*/
            //死亡信息
            this.add("death.attack." + CSJDamageTypes.BLEED.location().getPath(), "%1$s失血過多。");
            this.add("death.attack." + CSJDamageTypes.MARTIAL_ARTS.location().getPath(), "%1$s被%2$s使用武功震碎了內臟。");
            this.add("death.attack." + CSJDamageTypes.TRAUMA.location().getPath(), "%1$s的傷勢過重。");
            //配置文件信息
            this.add("config."+ ChangShengJue.MOD_ID +".reload", "配置已重新載入");
            this.add("config."+ ChangShengJue.MOD_ID +".enable_quests", "是否啟用自動接受類型任務。");

            this.add("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_level", "獨孤九劍最大等級上限");
            this.add("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_exp", "獨孤九劍突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_cooldown", "獨孤九劍最大冷卻時間");

            this.add("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_level", "高家槍法最大等級上限");
            this.add("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_exp", "高家槍法突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_cooldown", "高家槍法最大冷卻時間");

            this.add("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_level", "隔山打牛最大等級上限");
            this.add("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_exp", "隔山打牛突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_cooldown", "隔山打牛最大冷卻時間");

            this.add("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_level", "金烏刀法最大等級上限");
            this.add("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_exp", "金烏刀法突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_cooldown", "金烏刀法最大冷卻時間");

            this.add("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_level", "少林棍法最大等級上限");
            this.add("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_exp", "少林棍法突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_cooldown", "少林棍法最大冷卻時間");

            this.add("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_level", "葵花點穴手最大等級上限");
            this.add("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_exp", "葵花點穴手突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_cooldown", "葵花點穴手最大冷卻時間");

            this.add("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_level", "龜息功最大等級上限");
            this.add("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_exp", "龜息功突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_cooldown", "龜息功最大冷卻時間");

            this.add("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_level", "玄女劍法最大等級上限");
            this.add("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_exp", "玄女劍法突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_cooldown", "玄女劍法最大冷卻時間");

            this.add("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_level", "無情飛刀最大等級上限");
            this.add("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_exp", "無情飛刀突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_cooldown", "無情飛刀最大冷卻時間");
            this.add("config."+ ChangShengJue.MOD_ID +".flying_dagger_pouch_max_slots", "飛刀囊中最大可放入的飛刀數量");

            this.add("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_level", "金鐘罩最大等級上限");
            this.add("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_exp", "金鐘罩突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_cooldown", "金鐘罩最大冷卻時間");

            this.add("config."+ ChangShengJue.MOD_ID +".hercules_max_exp", "大力神功突破所需的移動距離");

            this.add("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_level", "不死神功最大等級上限");
            this.add("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_exp", "不死神功突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_cooldown", "不死神功最大冷卻時間");

            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_level", "乾坤大挪移最大等級上限");
            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_exp", "乾坤大挪移突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_cooldown", "乾坤大挪移最大冷卻時間");
            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_probability", "乾坤大挪移每次反彈傷害的概率");
            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_extra_probability", "乾坤大挪移大成後每點血量增加反彈傷害的概率");
            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_multiplier", "乾坤大挪移反彈傷害的倍率");
            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_tick", "乾坤大挪移每次反彈傷害需要的時間");
            this.add("config."+ ChangShengJue.MOD_ID +".qian_kun_da_nuo_yi_max_cooldown_extra_tick", "乾坤大挪移每次釋放後增加的冷卻恢復到默認冷卻的時間");

            this.add("config."+ ChangShengJue.MOD_ID +".the_classics_of_tendon_changing_max_exp", "易筋經突破所需的成功釋放次數");

            this.add("config."+ ChangShengJue.MOD_ID +".paoding_max_exp", "庖丁解牛突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".paoding_additional_drops_count", "庖丁解牛殺死生物時額外掉落肉的數量");

            this.add("config."+ ChangShengJue.MOD_ID +".wu_gang_cut_gui_max_exp", "吳剛伐桂突破所需的成功釋放次數");

            this.add("config."+ ChangShengJue.MOD_ID +".yugong_moves_mountains_max_exp", "愚公移山突破所需的成功釋放次數");
            this.add("config."+ ChangShengJue.MOD_ID +".yugong_moves_mountains_excavation_range", "愚公移山的挖掘範圍");

            this.add("config."+ ChangShengJue.MOD_ID +".zhang_men_xin_xue_max_exp", "張門心學突破所需的交易成功次數");
            this.add("config."+ ChangShengJue.MOD_ID +".zhang_men_xin_xue_extra_probability", "張門心學大成後交易不消耗物品的概率");

            //普通信息
            this.add("block."+ ChangShengJue.MOD_ID +".fen_jiu.no_wine","已經沒有酒了！");

            //进度
            // 一级进度
            this.add("advancement." + ChangShengJue.MOD_ID + ".begin", "長生訣");
            this.add("advancement." + ChangShengJue.MOD_ID + ".begin.desc", "大千世界，無奇不有");
            // 二级进度
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasmifan", "人是鐵飯是鋼");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasmifan.desc", "人靠飯，鐵靠鋼，一頓不吃餓得慌。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".hassilverbullions", "銀華熠熠");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hassilverbullions.desc", "銀子久了雖會變黑，但他內在還是銀光閃爍的。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".hasbronzesword", "俠客行");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasbronzesword.desc", "所謂俠客者，就是不畏強權，敢於為正義事業而奮鬥，以保護弱者、扶持正義為己任，無私奉獻，不計較個人得失。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".findchinesevillage", "新生活！");
            this.add("advancement." + ChangShengJue.MOD_ID + ".findchinesevillage.desc", "大江南北，江山如畫！");

            this.add("advancement." + ChangShengJue.MOD_ID + ".accessguildtask", "幫會？");
            this.add("advancement." + ChangShengJue.MOD_ID + ".accessguildtask.desc", "且看小爺我叱吒風雲，攪動天下！");
            // 三级进度
            this.add("advancement." + ChangShengJue.MOD_ID + ".haslichee", "妃子笑");
            this.add("advancement." + ChangShengJue.MOD_ID + ".haslichee.desc", "一騎紅塵妃子笑，無人知是荔枝來。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".hastomatoegg", "家常小炒");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hastomatoegg.desc", "每個人都能做，做的味道也常不一樣的家常小炒。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".hastea", "習習清風生");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hastea.desc", "自神農嘗百草，飲茶解毒，飲茶的歷史源遠流長。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".haswine", "對酒當歌，人生幾何？");
            this.add("advancement." + ChangShengJue.MOD_ID + ".haswine.desc", "譬如朝露，去日苦多。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".hasgoldbullions", "金光閃閃");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasgoldbullions.desc", "是金子，放在哪裡都閃光！");

            this.add("advancement." + ChangShengJue.MOD_ID + ".usewaigong", "趁手兵器");
            this.add("advancement." + ChangShengJue.MOD_ID + ".usewaigong.desc", "一把趁手劍，瀟灑走天涯。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".hasarmor", "布衣俠客");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasarmor.desc", "甲雖簡陋，當心如堅石。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".learngongfa", "初學乍練");
            this.add("advancement." + ChangShengJue.MOD_ID + ".learngongfa.desc", "若一遇挫折便鬆散懈怠，日後怎成大器？");

            this.add("advancement." + ChangShengJue.MOD_ID + ".makechinaware", "做瓷器");
            this.add("advancement." + ChangShengJue.MOD_ID + ".makechinaware.desc", "china，china，china！");

            this.add("advancement." + ChangShengJue.MOD_ID + ".finishtask", "善惡誰定？");
            this.add("advancement." + ChangShengJue.MOD_ID + ".finishtask.desc", "要多讀書，才不會被人騙。要多看歷史，才能明辨是非。");

            // 四级进度
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasbabaozhu", "吉祥如意");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasbabaozhu.desc", "健脾養胃，消滯減肥，益氣安神。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".hasguihuatangou", "甜蜜蜜");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasguihuatangou.desc", "希望你的人生能一直甜蜜下去或者接下去是甜蜜的展開。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".hassword", "絕世神兵");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hassword.desc", "武林至尊，寶刀屠龍，號令天下，莫敢不從！");

            this.add("advancement." + ChangShengJue.MOD_ID + ".hasadvancedarrmor", "將門之後");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasadvancedarrmor.desc", "甲雖堅固，莫埋於灰塵。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".mastergongfa", "融會貫通");
            this.add("advancement." + ChangShengJue.MOD_ID + ".mastergongfa.desc", "成就雖存，然需知道人外有人，天外有天。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".donefivetask", "有求必應");
            this.add("advancement." + ChangShengJue.MOD_ID + ".donefivetask.desc", "要懂得拒絕人，馬桶是通不完的。");

            this.add("advancement." + ChangShengJue.MOD_ID + ".agroupgangtoken", "扛把子");
            this.add("advancement." + ChangShengJue.MOD_ID + ".agroupgangtoken.desc", "我扛的不是銅鑼灣，是天下！天下蒼生！");

            //五级进度
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasqitian", "未竟");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasqitian.desc", "齊天大聖在何處？長生之路又在何處？未來在何處？");

            this.add("advancement." + ChangShengJue.MOD_ID + ".gongfadone", "一代宗師");
            this.add("advancement." + ChangShengJue.MOD_ID + ".gongfadone.desc", "人有情慾，劍沒有，武功沒有。紫禁之巔，誰能與我爭高低？");

            this.add("advancement." + ChangShengJue.MOD_ID + ".donefinaltask", "隱世大俠");
            this.add("advancement." + ChangShengJue.MOD_ID + ".donefinaltask.desc", "既是有情有慾人，天地不平心何甘？");

            this.add("advancement." + ChangShengJue.MOD_ID + ".beatleader", "頭把交椅");
            this.add("advancement." + ChangShengJue.MOD_ID + ".beatleader.desc", "這木頭座位總比那個劍刃做的舒適，不扎屁股。");

            //按钮
            this.add("button."+ ChangShengJue.MOD_ID +".gre_button.tips", "灰");
            this.add("button."+ ChangShengJue.MOD_ID +".red_button.tips", "紅");
            this.add("button."+ ChangShengJue.MOD_ID +".black_button.tips", "黑");
            this.add("button."+ ChangShengJue.MOD_ID +".blue_button.tips", "青");
            this.add("button."+ ChangShengJue.MOD_ID +".golden_button.tips", "金");
            this.add("button."+ ChangShengJue.MOD_ID +".wood_button.tips", "木");
            this.add("gui."+ ChangShengJue.MOD_ID +".trade.gre", "灰");
            this.add("gui."+ ChangShengJue.MOD_ID +".trade.red", "紅");
            this.add("gui."+ ChangShengJue.MOD_ID +".trade.black", "黑");
            this.add("gui."+ ChangShengJue.MOD_ID +".trade.blue", "青");
            this.add("gui."+ ChangShengJue.MOD_ID +".trade.golden", "金");
            this.add("gui."+ ChangShengJue.MOD_ID +".trade.wood", "木");

            //任务
            this.add("quest."+ ChangShengJue.MOD_ID +".button", "任務");
            this.add("quest."+ ChangShengJue.MOD_ID +".requirements", "任務需求:");
            this.add("quest."+ ChangShengJue.MOD_ID +".rewards", "任務獎勵:");
            this.add("quest."+ ChangShengJue.MOD_ID +".submit.button", "提交任務");
            this.add("quest."+ ChangShengJue.MOD_ID +".no_submit.button", "當前沒有任務可以提交!");
            this.add("quest."+ ChangShengJue.MOD_ID +".accept.button", "接受任務");
            this.add("quest."+ ChangShengJue.MOD_ID +".abandon.button", "放棄任務");
            this.add("quest."+ ChangShengJue.MOD_ID +".no_abandon.button", "無法放棄不存在的任務!");
            this.add("quest."+ ChangShengJue.MOD_ID +".requirements.prompt", "任務需求不足!");
            this.add("quest."+ ChangShengJue.MOD_ID +".finish", "§a%s任務完成！");
            this.add("quest."+ ChangShengJue.MOD_ID +".trigger", "§a觸發%s任務");
            this.add("quest."+ ChangShengJue.MOD_ID +".fail", "§a%s任務失敗!");
            this.add("quest."+ ChangShengJue.MOD_ID +".requires.kill.target","需要擊殺: %s次");
            this.add("quest."+ ChangShengJue.MOD_ID +".current.kill.target","當前進度: %s/%s");
            this.add("quest."+ ChangShengJue.MOD_ID +".no_quest","當前沒有正在進行的任務!");
            this.add("quest."+ ChangShengJue.MOD_ID +".no_action_quest","當前沒有可以接受的任務!");

            this.add("quest."+ ChangShengJue.MOD_ID +".food.questName", "收集食物");
            this.add("quest."+ ChangShengJue.MOD_ID +".food.questDescription", "首領：兄弟們的吃食又不夠了，總不能餓肚子吧，兄弟你去想想辦法。");
            this.add("quest."+ ChangShengJue.MOD_ID +".money.questName", "收集錢款");
            this.add("quest."+ ChangShengJue.MOD_ID +".money.questDescription", "首領：這年頭什麼都要花錢，一文錢難倒英雄漢，兄弟能籌點幫費嗎？");

            this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questName", "踢館");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questDescription", "首領：可惡！這是今年第二個趁我病期來踢館的了，欺我幫派無人，你去回敬下吧！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questRequirementsDescription", "擊殺任意幫派首領。");

            this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questName", "俠客行");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questDescription", "首領：災厄巡邏隊總是與我們發生衝突，不知死活！做掉他們！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questRequirementsDescription", "擊殺掠奪者。");

            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questName", "殺雞儆猴");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questDescription", "首領：這群刁民真是有夠膽大的，去收幫費的人拒了我們幾波，你去給他們點顏色看看！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questRequirementsDescription", "擊殺任意村民。");

            this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questName", "投名狀");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questDescription", "首領：這位兄弟，想入我們幫派，你需要先納投名狀！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questRequirementsDescription", "擊殺任意人型生物。");

            this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questName", "挑戰");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questDescription", "首領：有兄弟聽說你武功高強，想和你較量一番，你意下如何？");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questRequirementsDescription", "擊敗或者擊殺前來的挑戰者。");

            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia.questName", "天下第一");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_1.questDescription", "首領：雖說現在天下第一是棍王董大俠，但以兄台的實力也能與其一爭啊！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_2.questDescription", "首領：雖說現在天下第一是刀聖徐大俠，但以兄台的實力也能與其一爭啊！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_3.questDescription", "首領：雖說現在天下第一是北拳蕭大俠，但以兄台的實力也能與其一爭啊！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_4.questDescription", "首領：雖說現在天下第一是劍仙張大俠，但以兄台的實力也能與其一爭啊！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia.questRequirementsDescription", "擊殺四大名俠之一。");

            this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questName", "保護村莊");
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questDescription", "首領：我們幫派名下的村莊被入侵了，快去保護咱們的糧倉！");
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questRequirementsDescription", "在襲擊中勝利。");

            this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questName", "救民俠醫");
            this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questDescription", "首領：附近的村莊被殭屍襲擊，好多村民變成了殭屍村民，聽說兄弟你會些醫術，去看看吧？");
            this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questRequirementsDescription", "救治一名殭屍村民。");

            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questName", "齋飯");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questDescription", "首領：心念慈悲，不犯殺戒。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questRequirementsDescription", "2個遊戲日內不殺死生物。");

            this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questName", "行俠仗義");
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questDescription", "附近一村莊被烏泱泱的殭屍入侵了，君願捨身以助嗎？");
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questRequirementsDescription", "留在村莊內協助村民抵禦殭屍。");

            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questName", "田園俠客");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questDescription", "因為有你，這裡的村民沒人敢欺負，你也在這裡安居樂業。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questRequirementsDescription", "偶遇村民。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questName", "快意恩仇");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questDescription", "冤仇若不分明報，枉做人間大丈夫。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questRequirementsDescription", "擊敗攻擊你的敵人。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questName", "為民除害");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questDescription", "這一大蟲總拿村民當食吃，大俠小心！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questRequirementsDescription", "擊殺1隻老虎。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questName", "除暴安良");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questDescription", "村長：村裡有一惡人到處搶掠，大俠可能幫幫我們？！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questRequirementsDescription", "擊殺1個惡徒。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questName", "武俠");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questDescription", "路見不平，拔刀相助，才堪俠客。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questRequirementsDescription", "夜間村莊內擊殺1隻殭屍。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questName", "殺人越貨");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questDescription", "你即以財寶顯漏，就別怪我了下手狠了！嘿嘿嘿...");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questRequirementsDescription", "擊殺1個流浪商人。");
            this.add("quest."+ ChangShengJue.MOD_ID +".gather.food.questName", "大額交易");
            this.add("quest."+ ChangShengJue.MOD_ID +".gather.food.questDescription", "村長：最近莊稼減收冬天怕是不好過了，大俠可以幫我們收集些食物度過難關嗎？");
            this.add("quest."+ ChangShengJue.MOD_ID +".gather.money.questName", "大額交易");
            this.add("quest."+ ChangShengJue.MOD_ID +".gather.money.questDescription", "村長：這次真是大豐收！但是如此多糧食放久了會壞，大俠你能幫我們想想辦法嗎？");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questName", "任我行");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questDescription", "海闊天空，何處不容人。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questRequirementsDescription", "7天內死亡次數小於1。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questName", "鋤強扶弱");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questDescription", "村民不光要面對殭屍的襲擊，竟還有幫派的威脅！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questRequirementsDescription", "擊殺3個強盜。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questName", "江湖追殺令");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questDescription", "你幫助村莊對抗幫派，各大勢力都以你武林公敵的藉口對你進行了追殺！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questRequirementsDescription", "殺死襲擊你的人。");
            this.add("quest."+ ChangShengJue.MOD_ID +".ao_qi_tian_di_jian.questName", "傲氣天地間");
            this.add("quest."+ ChangShengJue.MOD_ID +".ao_qi_tian_di_jian.questDescription", "我有百般力，何向弱者使？天地不平，我自平之！雖百人，有所可懼，智勇以對。");
            this.add("quest."+ ChangShengJue.MOD_ID +".ao_qi_tian_di_jian.questRequirementsDescription", "擊殺惡徒與殺手。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questName", "天若有情天亦老");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questDescription", "人間正道是滄桑。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questRequirementsDescription", "完成兩次江湖追殺令。");

            //裁衣案
            this.add("container."+ ChangShengJue.MOD_ID +".tailoring_case", "裁衣案");
            this.add("gui."+ ChangShengJue.MOD_ID + ".tailoring_case.craft", "裁衣");
            //锻台
            this.add("container."+ ChangShengJue.MOD_ID +".forge_block", "鍛造爐");
            this.add("gui."+ ChangShengJue.MOD_ID + ".forge_block.craft", "鍛造");

            this.add("container."+ ChangShengJue.MOD_ID +".wood_working_bench", "木工臺");
            this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.craft", "製作");
            this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.all", "全部");
            this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.da_mu_zuo", "大木作");
            this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.xiao_mu_zuo", "小木作");
            this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.chen_she", "陳設");
            this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.furniture", "傢俱");
            this.add("container."+ ChangShengJue.MOD_ID +".brick_kiln", "磚窯");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.craft", "燒制");

            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.all", "全部");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.wa_zuo", "瓦作");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.shi_zuo", "石作");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.za_lei", "雜類");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color", "顏色");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.gray", "灰");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.red", "紅");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.black", "黑");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.gold", "金");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.cyan", "青");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.purple", "紫");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.blue", "藍");

            this.add("jei."+ ChangShengJue.MOD_ID +".woodworking_bench.usage", "在木工台中製作該物品");
            this.add("jei."+ ChangShengJue.MOD_ID +".tailoring_case.usage", "在裁衣案中製作該物品");
            this.add("jei."+ ChangShengJue.MOD_ID +".forge_block.usage", "在鍛造爐中製作該物品");
            this.add("jei."+ ChangShengJue.MOD_ID +".brick_kiln.usage", "在窯爐中製作該物品");

            //帕秋莉
            this.add(ChangShengJue.MOD_ID +".function", "功能物品");
            this.add(ChangShengJue.MOD_ID +".function.desc", "從那個空間裂縫來了很多奇怪的人，他們不僅會舞火為鳳，飛天遁地。也帶來了很多奇怪的東西。聽說他們是從東方來的？");
            this.add(ChangShengJue.MOD_ID +".function.blue_and_white_porcelain_flower_pots", "青花瓷花盆");
            this.add(ChangShengJue.MOD_ID +".function.blue_and_white_porcelain_flower_pots.page1.text", "作用等同於原版花盆");
            this.add(ChangShengJue.MOD_ID +".function.brush_and_lime_slurry", "刷子和石灰漿");
            this.add(ChangShengJue.MOD_ID +".function.brush_and_lime_slurry.page1.text", "將任意石灰漿桶放副手，主手持刷子就可以將整塊紅磚刷成對應色系白牆。石灰漿桶使用12次後會變成空桶。");
            this.add(ChangShengJue.MOD_ID +".function.bullions_casting_molds", "元寶鑄造模具");
            this.add(ChangShengJue.MOD_ID +".function.bullions_casting_molds.page1.text", "將模具右鍵放置在地面，手持【坩堝（金/銀液）】右鍵倒入");
            this.add(ChangShengJue.MOD_ID +".function.casting_molds", "銅錢鑄造模具");
            this.add(ChangShengJue.MOD_ID +".function.casting_molds.page1.text", "用於鑄造銅錢，將模具右鍵放置在地面，手持【坩堝（銅液）】右鍵倒入");
            this.add(ChangShengJue.MOD_ID +".function.crucible", "坩堝");
            this.add(ChangShengJue.MOD_ID +".function.crucible.page1.text", "是製作銅錢、元寶的重要道具$(br)可與8個銅/銀/金合成為 坩堝（碎銅/銀/金）$(br)【坩堝（碎銅/銀/金）】在熔爐中燒製可獲得【坩堝（銅/銀/金液）】");
            this.add(ChangShengJue.MOD_ID +".function.crucible.page3.text", "坩堝（碎銅/銀/金）在熔爐中燒製可獲得坩堝（銅/銀/金液）");
            this.add(ChangShengJue.MOD_ID +".function.crucible.page5.text", "坩堝（銅/銀/金液）可放入模具中製作：銅錢/金銀元寶");
            this.add(ChangShengJue.MOD_ID +".function.ladder", "扶梯");
            this.add(ChangShengJue.MOD_ID +".function.ladder.page1.text", "梯子有三格高，並且可以向上繼續拼接增高。（當玩家處於方塊邊緣時向前一格放置扶梯會被壓趴下）");
            this.add(ChangShengJue.MOD_ID +".function.painting_scroll", "畫軸");
            this.add(ChangShengJue.MOD_ID +".function.painting_scroll.page1.text", "分為（1x1、2x1、1x2、2x2）四種，作用同原版畫，有多種圖案。");
            this.add(ChangShengJue.MOD_ID +".function.plaque", "牌匾");
            this.add(ChangShengJue.MOD_ID +".function.plaque.page1.text", "右鍵牌匾可以寫入內容。側面放置於方塊上，作用同告示牌（可左右連接調整牌匾長度）");
            this.add(ChangShengJue.MOD_ID +".function.stone_lamp", "石燈");
            this.add(ChangShengJue.MOD_ID +".function.stone_lamp.page1.text", "石燈分為點燃和未燃兩個狀態$(br)使用打火石進行點燃，用作光源，光照亮度等同於燭台");
            this.add(ChangShengJue.MOD_ID +".function.stone_lamp.page2.title", "石燈底座");
            this.add(ChangShengJue.MOD_ID +".function.stone_lamp.page2.text", "石燈的底座，除裝飾外無其他作用");
            this.add(ChangShengJue.MOD_ID +".function.zhu_tai", "燭台");
            this.add(ChangShengJue.MOD_ID +".function.zhu_tai.page1.text", "作用同火把，照亮半徑12格範圍。");

            this.add(ChangShengJue.MOD_ID +".village", "村落");
            this.add(ChangShengJue.MOD_ID +".village.desc", "大大小小的中式村莊坐落在麥塊大陸上，他們帶來了許多新奇玩意兒…");
            this.add(ChangShengJue.MOD_ID +".village.tool.chang_sheng_jue_loom", "織布機");
            this.add(ChangShengJue.MOD_ID +".village.tool.chang_sheng_jue_loom.page1.text", "使用說明：主手持$(item)蠶絲$()右鍵織布機可織成$(item)絲綢$()$(br)產出比例：2蠶絲 → 1絲綢");
            this.add(ChangShengJue.MOD_ID +".village.tool.pig_trough", "牲畜食槽");
            this.add(ChangShengJue.MOD_ID +".village.tool.pig_trough.page1.text", "加速生長：$(li)可放置$(item)小麥$()$(br)效果：提升附近動物20%%生長速度");
            this.add(ChangShengJue.MOD_ID +".village.tool.pig_trough.page2.text", "牲畜食槽合成配方");
            this.add(ChangShengJue.MOD_ID +".village.tool.pottery_wheel", "陶輪");
            this.add(ChangShengJue.MOD_ID +".village.tool.pottery_wheel.page1.text", "交互功能：$(li)1個粘土 → 製造$(item)瓷杯$()$(li)2個粘土 → 製造$(item)瓷碗$()$(li)3個粘土 → 製造$(item)瓷盤$()");
            this.add(ChangShengJue.MOD_ID +".village.tool.tool_table", "工具台");
            this.add(ChangShengJue.MOD_ID +".village.tool.tool_table.page1.text", "維護功能：主手持$(item)弓$()右鍵工具台可快速修復工具耐久");
            this.add(ChangShengJue.MOD_ID +".village.tool.tool_table.page2.text", "工具台合成配方");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief", "村長");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page1.text", "右鍵村長時有50%%概率會觸發村莊任務[除暴安良]，完成可獲得一定獎勵。");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page2.title", "村長交易列表-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page2.text", "$(br)$(li)1x 銀元寶 → 6x 一貫銅錢$(br)$(li)1x 金元寶 → 6x 銀元寶$(br)$(li)7x 一貫銅錢 → 1x 銀元寶$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page3.title", "村長交易列表-學徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page3.text", "$(br)$(li)1x 鑽石 → 4x 一貫銅錢$(br)$(li)4x 一貫銅錢 → 2x 燭台$(br)$(li)7x 銀元寶 → 1x 金元寶$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page4.title", "村長交易列表-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page4.text", "$(br)$(li)1x 指南針 → 4x 一貫銅錢$(br)$(li)4x 一貫銅錢 → 1x 綠寶石$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page5.title", "村長交易列表-專家與大師");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page5.text", "專家:$(br)$(li)2x 書與筆 → 4x 一貫銅錢$(br2)大師:$(br)$(li)1x 銀元寶 → 1x 字畫$(br)$(li)2x 金元寶 → 1x 綠寶石$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page2.anchor", "村長-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page3.anchor", "村長-學徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page4.anchor", "村長-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page5.anchor", "村長-專家");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer", "農民");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page2.anchor", "農民-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page2.title", "農民交易列表-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page2.text", "$(br)$(li)20x 玉米 → 4x 一貫銅錢$(br)$(li)20x 水稻 → 4x 一貫銅錢$(br)$(li)22x 番茄 → 4x 一貫銅錢$(br)$(li)22x 花生 → 4x 一貫銅錢$(br)$(li)4x 一貫銅錢 → 4x 米飯");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page3.anchor", "農民-學徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page3.title", "農民交易列表-學徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page3.text", "$(br)$(li)22x 葡萄 → 4x 一貫銅錢$(br)$(li)4x 一貫銅錢 → 4x 蒸菜$(br)$(li)4x 一貫銅錢 → 4x 青糰");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page4.anchor", "農民-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page4.title", "農民交易列表-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page4.text", "$(br)$(li)4x 桂花糖藕 → 4x 一貫銅錢$(br)$(li)4x 一貫銅錢 → 4x 豬肚雞");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page5.anchor", "農民-專家");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page5.title", "農民交易列表-專家與大師");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page5.text", "專家:$(br)$(li) 4x 一貫銅錢 → 1x 謎之燉菜（夜視，失明，飽和，虛弱，跳躍提升，中毒中1-2種）$(br2)大師:$(br)$(li)4x 一貫銅錢 → 4x 番茄炒蛋$(br)$(li)8x 一貫銅錢 → 8x 肉沫茄子$(br)$(li)8x 一貫銅錢 → 8x 八寶粥");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter", "獵人");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page2.anchor", "獵人-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page2.title", "獵人交易列表-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page2.text", "$(br)$(li)14x 生雞肉 → 4x 一貫銅錢$(br)$(li)4x 生兔肉 → 4x 一貫銅錢$(br)$(li)7x 生豬排 → 4x 一貫銅錢$(br)$(li)4x 一貫銅錢 → 1x 孔雀蛋$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page3.anchor", "獵人-學徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page3.title", "獵人交易列表-學徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page3.text", "$(br)$(li)7x 生羊肉 → 4x 一貫銅錢$(br)$(li)4x 一貫銅錢 → 5x 熟鹿肉$(br)$(li)4x 一貫銅錢 → 1x 鹿血$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page4.anchor", "獵人-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page4.title", "獵人交易列表-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page4.text", "$(br)$(li)7x 生鹿肉 → 4x 一貫銅錢$(br)$(li)10x 生牛肉 → 4x 一貫銅錢$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page5.anchor", "獵人-專家");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page5.title", "獵人交易列表-專家與大師");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page5.text", "專家:$(br)$(li)7x 鹿茸 → 14x 一貫銅錢$(br2)大師:$(br)$(li)5x 虎皮 → 15x 一貫銅錢");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter", "窯工");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page2.anchor", "窯工-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page2.title", "窯工交易列表-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page2.text", "$(br)$(li)8x 一貫銅錢 → 32x 青石磚$(br)$(li)8x 一貫銅錢 → 32x 青石細磚$(br)$(li)8x 一貫銅錢 → 32x 青石磚樓梯$(br)$(li)8x 一貫銅錢 → 32x 青石台階$(br)$(li)8x 一貫銅錢 → 32x 青石豎牆$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page3.anchor", "窯工-學徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page3.title", "窯工交易列表-學徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page3.text", "$(br)$(li)8x 一貫銅錢 → 32x 青石地磚$(br)$(li)8x 一貫銅錢 → 32x 黑石地磚$(br)$(li)8x 一貫銅錢 → 32x 瀝青地磚$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page4.anchor", "窯工-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page4.title", "窯工交易列表-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page4.text", "$(br)$(li)4x 一貫銅錢 → 8x 瓷碗$(br)$(li)4x 一貫銅錢 → 8x 瓷杯$(br)$(li)4x 一貫銅錢 → 4x 酒罈$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page5.anchor", "窯工-專家");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page5.title", "窯工交易列表-專家與大師");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page5.text", "專家:$(br)$(li)4x 一貫銅錢 → 1x 青花瓷花盆$(br2)大師:$(br)$(li)4x 一貫銅錢 → 1x 黃色石獅子$(br)$(li)4x 一貫銅錢 → 1x 灰色石獅子$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress", "縫工");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page2.anchor", "縫工-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page2.title", "縫工交易列表-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page2.text", "$(br)$(li)6x 蠶絲 → 4x 一貫銅錢$(br)$(li)22x 棉花 → 4x 一貫銅錢$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page3.anchor", "縫工-學徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page3.title", "縫工交易列表-學徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page3.text", "$(br)$(li)4x 一貫銅錢 → 4x 絲綢$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page4.anchor", "縫工-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page4.title", "縫工交易列表-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page4.text", "$(br)$(li)28x 一貫銅錢 → 1x 道服包裹$(br)$(li)28x 一貫銅錢 → 1x 道袍包裹$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page5.anchor", "縫工-專家");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page5.title", "縫工交易列表-專家與大師");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page5.text", "專家:$(br)$(li)6x 銀元寶 → 1x 麒麟補服包裹$(br)$(li)6x 銀元寶 → 1x 褘衣包裹$(br)$(li)6x 銀元寶 → 1x 行者裝包裹$(br)$(li)6x 銀元寶 → 1x 儒裝包裹$(br2)大師:$(br)$(li)8x 銀元寶 → 1x 金色棉甲包裹$(br2)");

            this.add(ChangShengJue.MOD_ID +".village.villages.sandstone_castle", "沙石堡");
            this.add(ChangShengJue.MOD_ID +".village.villages.sandstone_castle.page1.text", "常生成在沙漠群系，用砂岩構築的堡壘式村莊，儲備充足、抗襲擊，彷彿沙漠中的明珠。其中常有作物：棉花、番茄、葡萄、哈密瓜。");
            this.add(ChangShengJue.MOD_ID +".village.villages.courtyard", "四合院");
            this.add(ChangShengJue.MOD_ID +".village.villages.courtyard.page1.text", "常生成在草原群系，一個院子四面建有房屋，從四面將庭院合圍在中間，故名四合院。其中常有作物：高粱、玉米、小麥、大豆、穀子。");
            this.add(ChangShengJue.MOD_ID +".village.villages.huizhou", "徽式村莊");
            this.add(ChangShengJue.MOD_ID +".village.villages.huizhou.page1.text", "常生成在森林群系，徽州民居以白牆黛瓦、馬頭牆聞名。看那雕花門窗多精緻！其中常有作物：蓮藕、花生、茄子、梨子。");
            this.add(ChangShengJue.MOD_ID +".village.villages.suzhou", "蘇式村莊");
            this.add(ChangShengJue.MOD_ID +".village.villages.suzhou.page1.text", "常生成在叢林群系，白牆黑瓦那樸素典雅的風格與脊角高翹的屋頂，是蘇派建築的藝術典範。其中常有作物：荔枝、香蕉、榴槤、水稻。");
            this.add(ChangShengJue.MOD_ID +".village.villages.cave_dwelling", "窯洞");
            this.add(ChangShengJue.MOD_ID +".village.villages.cave_dwelling.page1.text", "常生成在高原群系，通過下挖泥土建造窯洞，冬暖夏涼，是一種特殊的建築。其中常有作物：甘蔗、胡椒、芒果、菠蘿。");

            this.add(ChangShengJue.MOD_ID +".xiake", "俠客");
            this.add(ChangShengJue.MOD_ID +".xiake.desc", "不知從什麼時候，這裡的情況發生了變化。自稱要行俠仗義的人多了起來，他們多喜歡稱呼自己為「俠客」。");
            this.add(ChangShengJue.MOD_ID +".xiake.equipment", "盔甲");
            this.add(ChangShengJue.MOD_ID +".xiake.equipment.page1.text", "武俠裝備除了像原版盔甲可以給你提供盔甲值或盔甲韌性等外，還可以減少他人對你造成的外功傷害。盔甲可以自己製作也可以在古城的鐵匠鋪內使用貨幣兌換。大部分盔甲是支持顏色改變外觀的，可以試試。$(br)當你初次合成或使用長生訣服裝的胸甲時，會為其生成隨機的化解外功效果與減少受到外傷概率。");
            this.add(ChangShengJue.MOD_ID +".xiake.equipment.page2.title", "內甲");
            this.add(ChangShengJue.MOD_ID +".xiake.equipment.page2.text", "內甲可以內襯在長生訣服裝的胸甲裡，提高胸甲的盔甲值或韌性。$(br)完成胸甲內襯有兩種方式：1.先穿戴內甲然後穿戴打算進行內襯的胸甲就可以完成胸甲內襯。2.也可以副手持內甲，主手持打算進行內襯的胸甲按SHIFT+右鍵完成胸甲內襯。$(br)內甲也可單獨穿戴同一般胸甲。$(br)");
            this.add(ChangShengJue.MOD_ID +".xiake.internal_injury", "內傷");
            this.add(ChangShengJue.MOD_ID +".xiake.internal_injury.page1.text", "每層內傷效果影響：受到傷害增加5%%，已穿戴的盔甲效果降低5%%，每秒5%%的概率會眩暈，持續15秒；已被施加這個效果的目標再次空手攻擊他可使內傷效果疊加1層並延長2秒持續時間；內傷效果最大是5級，每等級效果提升1倍。");
            this.add(ChangShengJue.MOD_ID +".xiake.internal_injury.page2.text", "當正在運轉空手類外功時，空手攻擊目標向對方造成1級內傷，使用空手類外功攻擊目標則造成2級內傷。$(br)主手持金絲手套也視為空手攻擊。");

            this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual", "武功秘籍");
            this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual.page1.text", "通過完成幫派任務、村莊任務有概率會獲取到武功秘籍；擊殺會武功的NPC也有概率掉落武功秘籍。");
            this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual.page2.text", "武功秘籍分為外功類（主要是主動類武功），內功類（主要是被動類武功），輕功類（主要影響移動等效果），心法（提供一些特殊加成）。武功秘境具體效果可以從武功秘籍描述看出。武功秘籍上有清楚的說明，右鍵它可獲取如何領悟及施展武功。");
            this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual.page3.text", "習得劍類外功後使用劍攻擊目標有15%%概率讓敵人受到流血效果（每0.5秒流失1血量，持續1秒），習得刀類外功後使用刀攻擊目標有15%%概率觸發重擊效果（重擊額外造成15%%傷害），習得棍類外功後使用棍攻擊目標有15%%概率打暈目標（打暈目標0.5秒），習得槍類外功後使用槍攻擊目標有15%%概率挑飛目標（挑飛目標0.7秒）。");

            this.add(ChangShengJue.MOD_ID +".xiake.trauma", "外傷");
            this.add(ChangShengJue.MOD_ID +".xiake.trauma.page1.text", "每層外傷效果影響：造成傷害降低5%%，速度降低5%%，每秒流失1%%血量，持續7秒；已被施加這個效果的目標再次使用對應兵器攻擊他可使外傷效果持續時間延長1秒(若此次攻擊造成更大級別外傷效果則會覆蓋前效果)；外傷效果最大是5級，每等級效果提升1倍。");
            this.add(ChangShengJue.MOD_ID +".xiake.trauma.page2.text", "當正在運轉兵器類外功時，使用對應武器攻擊目標有25%%概率向對方造成1~2級外傷，使用(兵器)類外功攻擊目標則有100%%概率造成1~5級外傷。");

            this.add(ChangShengJue.MOD_ID +".xiake.stakes", "木樁");
            this.add(ChangShengJue.MOD_ID +".xiake.stakes.page1.text", "木樁合成配方");
            this.add(ChangShengJue.MOD_ID +".xiake.stakes.page2.text", "內功、輕功、外功(空手)類功法可以通過打擊木樁練習領悟，每次打擊領悟概率為15%%。");

            this.add(ChangShengJue.MOD_ID +".function.tailoring_case", "裁衣案");
            this.add(ChangShengJue.MOD_ID +".function.tailoring_case.page1.text", "裁衣案合成配方");
            this.add(ChangShengJue.MOD_ID +".function.tailoring_case.page2.text", "用於製作服裝（盔甲）等，可於裁衣案內查看選中物品，製作會自動從背包扣除對應所需材料。");

            this.add(ChangShengJue.MOD_ID +".function.forge_block", "鍛造爐");
            this.add(ChangShengJue.MOD_ID +".function.forge_block.page1.text", "鍛造爐合成配方");
            this.add(ChangShengJue.MOD_ID +".function.forge_block.page2.text", "用於製作武器、盔甲等，可於鍛造爐內查看選中物品，製作會自動從背包扣除對應所需材料。");

            this.add(ChangShengJue.MOD_ID +".function.wood_working_bench", "木工臺");
            this.add(ChangShengJue.MOD_ID +".function.wood_working_bench.page1.text", "木工臺合成配方");
            this.add(ChangShengJue.MOD_ID +".function.wood_working_bench.page2.text", "用於快速製作各種傢俱與木製建築構件，可以批量製作（點擊數位旁的圖示增加或減少製作次數，最大次數為64次），製作會自動從背包扣除對應所需材料。");

            this.add(ChangShengJue.MOD_ID +".function.brick_kiln", "磚窯爐");
            this.add(ChangShengJue.MOD_ID +".function.brick_kiln.page1.text", "磚窯爐合成配方");
            this.add(ChangShengJue.MOD_ID +".function.brick_kiln.page2.text", "用於快速製作各種石製建築構件（琉璃瓦、片瓦等），可以批量製作（點擊數位旁的圖示增加或減少製作數量，最大數量為64個），製作會自動從背包扣除對應所需材料。");

            this.add(ChangShengJue.MOD_ID +".village.tool.silkworm_and_natural_silk", "蠶與蠶絲");
            this.add(ChangShengJue.MOD_ID +".village.tool.silkworm_and_natural_silk.page1.text", "絲綢合成配方");
            this.add(ChangShengJue.MOD_ID +".village.tool.silkworm_and_natural_silk.page2.text", "破壞「有蠶的桑葉」有一定概率掉落蠶與蠶絲，蠶可以放在正常桑葉使其變化為「有蠶的桑葉」; 蠶絲可以合成絲綢來製作各種衣物。 $（br）$(br)桑樹會在森林群系和其變種群系自然生成$（br）徽派村莊的道路旁也有概率會生成一些桑樹");

            this.add(ChangShengJue.MOD_ID +".village.tool.kaolin_ball", "高嶺土球");
            this.add(ChangShengJue.MOD_ID +".village.tool.kaolin_ball.page1.text", "挖掘高嶺土礦會掉落4個高嶺土球，高嶺土球可以製作琉璃瓦等石質建築材料。");

            this.add(ChangShengJue.MOD_ID +".village.tool.syderolife_ball", "陶土球");
            this.add(ChangShengJue.MOD_ID +".village.tool.syderolife_ball.page1.text", "挖掘陶土礦會掉落4個陶土球，陶土球可以製作黑磚等石質建築材料。");

            this.add(ChangShengJue.MOD_ID +".village.tool.natural_asphalt", "天然瀝青");
            this.add(ChangShengJue.MOD_ID +".village.tool.natural_asphalt.page1.text", "挖掘天然瀝青塊會掉落4個天然瀝青，天然瀝青可以製作瀝青磚等。");

            this.add(ChangShengJue.MOD_ID +".function.sharpening_stone", "磨刀石");
            this.add(ChangShengJue.MOD_ID +".function.sharpening_stone.page1.text", "通過磨刀石你可以強化你的武器，圓石磨刀石最高可以將武器傷害提升6點，鑽石磨刀石則是最高提升至8點，下界合金磨刀石最高提升10點。 注意！ 打磨後武器的耐久消耗也會對應提高。");

            this.add(ChangShengJue.MOD_ID +".xiake.quest", "任務");
            this.add(ChangShengJue.MOD_ID +".xiake.quest.page1.text", "右鍵幫派首領可以在任務頁面領取幫派任務，完成幫派任務可以獲取幫派令牌、武功秘籍、貨幣等物品。遊玩時也有概率自動觸發一些其他任務（大部分是自動領取的，符合完成條件會自動完成），獎勵會有武功秘籍、貨幣等物品。");

            this.add(ChangShengJue.MOD_ID +".xiake.tea", "茶");
            this.add(ChangShengJue.MOD_ID +".xiake.tea.page1.text", "喝茶可以讓你更快恢復血量或飢餓度，詳細效果可以看茶的描述。");

            this.add(ChangShengJue.MOD_ID +".xiake.weapon", "武器");
            this.add(ChangShengJue.MOD_ID +".xiake.weapon.page1.text", "部分外功需要武器作為媒介進行施展，所以擁有對應武器很重要。可以自己製作武器，也可以在幫派使用幫派令牌兌換武器，完成幫派任務則可以解鎖絕世兵器的兌換。");

            this.add(ChangShengJue.MOD_ID +".xiake.wine", "酒");
            this.add(ChangShengJue.MOD_ID +".xiake.wine.page1.text", "喝酒可以讓你武功更快冷卻、減少施展武功的飢餓度消耗、增加武功傷害等，詳細效果可以看酒的描述。不要貪杯，喝多會醉~");

            this.add(ChangShengJue.MOD_ID +".thanks", "致謝");
            this.add(ChangShengJue.MOD_ID +".thanks.long_yuan_sword", "以此劍特別感謝Peng_Fan在模組測試期間提供的幫助！");
            this.add(ChangShengJue.MOD_ID +".thanks.desc", "這不僅是我們的創作，更是與你共度的時光。 由衷感謝。 $（br2）致謝名單：$（br）ID： Peng_Fan");
            this.add(ChangShengJue.MOD_ID +".thanks.long_yuan_sword.name", "龍淵劍");

            this.add(ChangShengJue.MOD_ID +".wufanglu", "五方匯錄");
            this.add(ChangShengJue.MOD_ID +".wufanglu.desc", "「天若有情天亦老，人間正道是滄桑。」$(br)長生之道，豈可無知？通曉天地，百科全解。");
            this.add(ChangShengJue.MOD_ID +".wufanglu.desc2", "長生訣百科全書");
        }
    }
