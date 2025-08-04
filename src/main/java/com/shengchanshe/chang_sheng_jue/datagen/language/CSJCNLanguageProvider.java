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
    
    public class CSJCNLanguageProvider extends LanguageProvider {
        public CSJCNLanguageProvider(PackOutput output, String modid, String locale) {
            super(output, modid, locale);
        }
    
        @Override
        protected void addTranslations() {
            //创造栏
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_building_block", "长生诀 建筑方块");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_natural_blocks", "长生诀 自然方块");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_functional", "长生诀 功能方块");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_ingredients", "长生诀 原材料");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_food_and_drink", "长生诀 食物与饮品");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_combat", "长生诀 战斗用品");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_tool", "长生诀 工具与实用物品");
            this.add("itemGroup." + ChangShengJue.MOD_ID + "_spawn_eggs", "长生诀 刷怪蛋");
            //物品
            this.add(ChangShengJueItems.PINEAPPLE_SEEDS.get(),"菠萝种子");
            this.add(ChangShengJueItems.PINEAPPLE.get(),"菠萝");
            this.add(ChangShengJueItems.TOMATO_SEEDS.get(),"番茄种子");
            this.add(ChangShengJueItems.TOMATO.get(),"番茄");
            this.add(ChangShengJueItems.SOYBEAN.get(),"大豆");
            this.add(ChangShengJueItems.GU_SEEDS.get(),"谷种");
            this.add(ChangShengJueItems.GU_SUI.get(),"谷穗");
            this.add(ChangShengJueItems.SORGHUM_SEEDS.get(),"高粱种子");
            this.add(ChangShengJueItems.SORGHUM.get(),"高粱穗");
            this.add(ChangShengJueItems.LOTUS_ROOT.get(),"莲藕");
            this.add(ChangShengJueItems.LOTUS_SEEDS.get(),"莲子");
            this.add(ChangShengJueItems.LOTUS.get(),"莲花");
            this.add(ChangShengJueItems.REDBEAN.get(),"红豆");
            this.add(ChangShengJueItems.COTTON_SEEDS.get(),"棉花种子");
            this.add(ChangShengJueItems.COTTON.get(),"棉花");
            this.add(ChangShengJueItems.STICKYRICE_SEEDS.get(),"糯稻种子");
            this.add(ChangShengJueItems.STICKYRICE.get(),"糯稻");
            this.add(ChangShengJueItems.STICKYRICE_1.get(),"糯米");
            this.add(ChangShengJueItems.CORN_SEEDS.get(),"玉米种子");
            this.add(ChangShengJueItems.CORN.get(),"玉米");
            this.add(ChangShengJueItems.JALAPENOS_SEEDS.get(),"胡椒种子");
            this.add(ChangShengJueItems.JALAPENOS.get(),"胡椒");
            this.add(ChangShengJueItems.PEANUT_SEEDS.get(),"花生种子");
            this.add(ChangShengJueItems.PEANUT.get(),"花生");
            this.add(ChangShengJueItems.BRINJAL_SEEDS.get(),"茄子种子");
            this.add(ChangShengJueItems.BRINJAL.get(),"茄子");
            this.add(ChangShengJueItems.CANTALOUPE.get(),"哈密瓜片");
            this.add(ChangShengJueItems.CANTALOUPE_SEEDS.get(),"哈密瓜种子");
            this.add(ChangShengJueItems.GRAPE_SEEDS.get(),"葡萄种子");
            this.add(ChangShengJueItems.GRAPE.get(),"葡萄");
            this.add(ChangShengJueItems.RICE_SEEDS.get(),"水稻苗");
            this.add(ChangShengJueItems.RICE.get(),"水稻");
            this.add(ChangShengJueItems.BILUOCHUN_TEA_SEEDS.get(),"碧螺春种子");
            this.add(ChangShengJueItems.BILUOCHUN_TEA.get(),"碧螺春");
            this.add(ChangShengJueItems.LONG_JING_TEA_SEEDS.get(),"龙井种子");
            this.add(ChangShengJueItems.LONG_JING_TEA.get(),"龙井");
            this.add(ChangShengJueItems.HORDEUM_SEEDS.get(),"大麦种子");
            this.add(ChangShengJueItems.HORDEUM.get(),"大麦");
            this.add(ChangShengJueItems.MULBERRY_JUICE.get(),"桑葚汁");
            this.add(ChangShengJueItems.APPLE_JUICE.get(),"苹果汁");
            this.add(ChangShengJueItems.HOT_PEAR_SOUP.get(),"热梨汤");
            this.add(ChangShengJueItems.GRAPE_JUICE.get(),"葡萄汁");
            this.add(ChangShengJueItems.CROC.get(),"生鳄鱼肉");
            this.add(ChangShengJueItems.COOKED_CROC.get(),"熟鳄鱼肉");
            this.add(ChangShengJueItems.PEACOCK.get(),"生孔雀肉");
            this.add(ChangShengJueItems.COOKED_PEACOCK.get(),"熟孔雀肉");
            this.add(ChangShengJueItems.CI_PAN.get(),"瓷盘");
            this.add(ChangShengJueItems.CI_WAN.get(),"瓷碗");
            this.add(ChangShengJueItems.CI_BEI.get(),"瓷杯");
            this.add(ChangShengJueItems.CAPSULE_JIAO_ZI.get(),"荠菜饺子");
            this.add(ChangShengJueItems.ZHENG_CAI.get(),"蒸菜");
            this.add(ChangShengJueItems.PORTULACA_OLERACEA_CAKE.get(),"马齿苋饼");
            this.add(ChangShengJueItems.QING_TUAN.get(),"青团");
            this.add(ChangShengJueItems.BAKED_CORN.get(),"烤玉米");
            this.add(ChangShengJueItems.TOMATO_EGG.get(),"番茄炒蛋");
            this.add(ChangShengJueItems.GU_LAO_ROU.get(),"咕咾肉");
            this.add(ChangShengJueItems.MEAT_FOAM_BRINJAL.get(),"肉沫茄子");
            this.add(ChangShengJueItems.SORGHUM_CAKE.get(),"高粱饼");
            this.add(ChangShengJueItems.STINKY_TOFU.get(),"臭豆腐");
            this.add(ChangShengJueItems.ZHU_DU_JI.get(),"猪肚鸡");
            this.add(ChangShengJueItems.XIAO_MI_FAN.get(),"小米饭团");
            this.add(ChangShengJueItems.MI_FAN.get(),"饭团");
            this.add(ChangShengJueItems.GUI_HUA_TANG_OU.get(),"桂花糖藕");
            this.add(ChangShengJueItems.BA_BAO_ZHOU.get(),"八宝粥");
            this.add(ChangShengJueItems.BILUOCHUN_TEAS.get(),"碧螺春茶");
            this.add(ChangShengJueItems.LONG_JING_TEAS.get(),"龙井茶");
            this.add(ChangShengJueItems.SHI_LI_XIANG.get(),"十里香");
            this.add(ChangShengJueItems.FEN_JIU.get(),"汾酒");
            this.add(ChangShengJueItems.EMPTY_FEN_JIU.get(),"空酒瓶");
            this.add(ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get(),"麦块贡酒");
            this.add(ChangShengJueItems.MANGO.get(),"芒果");
            this.add(ChangShengJueItems.MEI_HUA.get(),"梅花");
            this.add(ChangShengJueItems.GUI_HUA.get(),"桂花");
            this.add(ChangShengJueItems.BANANA.get(),"香蕉");
            this.add(ChangShengJueItems.PEAR.get(),"梨子");
            this.add(ChangShengJueItems.LICHEE.get(),"荔枝");
            this.add(ChangShengJueItems.DURIAN.get(),"榴莲");
            this.add(ChangShengJueItems.DURIAN_MEAT.get(),"榴莲肉");
            this.add(ChangShengJueItems.MULBERRY.get(),"桑葚");
            this.add(ChangShengJueItems.NATURAL_SILK.get(),"蚕丝");
            this.add(ChangShengJueItems.SILK.get(),"丝绸");
            this.add(ChangShengJueItems.CAPSULE.get(),"荠菜");
            this.add(ChangShengJueItems.QUICKLIME.get(),"生石灰");
            this.add(ChangShengJueItems.LIME_SLURRY_BARRELS.get(),"石灰浆桶");
            this.add(ChangShengJueItems.WARM_LIME_SLURRY_BARRELS.get(),"暖色石灰浆桶");
            this.add(ChangShengJueItems.COOL_LIME_SLURRY_BARRELS.get(),"冷色石灰浆桶");
            this.add(ChangShengJueItems.CRANE_FEATHERS.get(), "鹤羽");
            this.add(ChangShengJueItems.PEACOCK_FEATHERS.get(), "孔雀羽翎");
            this.add(ChangShengJueItems.WHITE_PEACOCK_FEATHERS.get(), "白孔雀羽翎");
            this.add(ChangShengJueItems.PEACOCK_EGGS.get(), "孔雀蛋");
            this.add(ChangShengJueItems.ANTLER.get(), "鹿茸");
            this.add(ChangShengJueItems.DEER_BLOOD.get(), "鹿血");
            this.add(ChangShengJueItems.VENISON.get(), "生鹿肉");
            this.add(ChangShengJueItems.COOKED_VENISON.get(), "熟鹿肉");
            this.add(ChangShengJueItems.TIGER_SKIN.get(), "虎皮");
            this.add(ChangShengJueItems.CROC_SKIN.get(), "鳄鱼皮");
            this.add(ChangShengJueItems.RAW_AG.get(), "粗银");
            this.add(ChangShengJueItems.AG_INGOT.get(), "银锭");
    
            this.add(ChangShengJueItems.THATCH.get(), "茅草");
    
            this.add(ChangShengJueItems.PAINT_BRUSH.get(), "刷子");
            this.add(ChangShengJueItems.BLACK_BRICKS.get(), "黑砖");
            this.add(ChangShengJueItems.WHITE_BRICKS_ITEM.get(), "白砖");
            this.add(ChangShengJueItems.GOLD_BRICKS.get(), "金砖");
    
            this.add(ChangShengJueItems.TONG_QIAN.get(), "铜钱");
            this.add(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), "一贯铜钱");
            this.add(ChangShengJueItems.SILVER_BULLIONS.get(), "银元宝");
            this.add(ChangShengJueItems.GOLD_BULLIONS.get(), "金元宝");
    
            this.add(ChangShengJueItems.CRUCIBLE.get(), "坩埚");
            this.add(ChangShengJueItems.CRUCIBLE_CRUSHED_COPPER.get(), "坩埚(碎铜块)");
            this.add(ChangShengJueItems.CRUCIBLE_CRUSHED_SILVER.get(), "坩埚(碎银块)");
            this.add(ChangShengJueItems.CRUCIBLE_CRUSHED_GOLD.get(), "坩埚(碎金块)");
            this.add(ChangShengJueItems.CRUCIBLE_LIQUID_COPPER.get(), "坩埚(铜水)");
            this.add(ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get(), "坩埚(银水)");
            this.add(ChangShengJueItems.CRUCIBLE_LIQUID_GOLD.get(), "坩埚(金水)");
    
            this.add(ChangShengJueItems.GANG_TOKEN.get(),"帮派令牌");
    
            this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.PIT_YARD_TYPE, "%s情报");
            this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.SANDSTONE_CASTLE_TYPE, "%s情报");
            this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.SI_HE_YUAN_TYPE, "%s情报");
            this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.SU_PAI_VILLAGE_TYPE, "%s情报");
            this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.HUI_PAI_VILLAGE_TYPE, "%s情报");
            this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.FORTRESSES_TYPE, "%s情报");
    
            //刷怪蛋
            this.add(ChangShengJueItems.BUTTERFLY_EGG.get(), "蝴蝶刷怪蛋");
            this.add(ChangShengJueItems.MONKEY_EGG.get(), "猴刷怪蛋");
            this.add(ChangShengJueItems.DRAGONFLY_EGG.get(), "蜻蜓刷怪蛋");
            this.add(ChangShengJueItems.CICADA_EGG.get(), "蝉刷怪蛋");
            this.add(ChangShengJueItems.CRANE_EGG.get(), "鹤刷怪蛋");
            this.add(ChangShengJueItems.PEACOCK_EGG.get(), "雄孔雀刷怪蛋");
            this.add(ChangShengJueItems.PEACOCK_EGG_1.get(), "雌孔雀刷怪蛋");
            this.add(ChangShengJueItems.STAG_EGG.get(), "雄鹿刷怪蛋");
            this.add(ChangShengJueItems.HIND_EGG.get(), "雌鹿刷怪蛋");
            this.add(ChangShengJueItems.TIGER_EGG.get(), "虎刷怪蛋");
            this.add(ChangShengJueItems.CROC_EGG.get(), "鳄鱼刷怪蛋");
            this.add(ChangShengJueItems.CHANG_SHENG_JUE_VILLAGER_EGG.get(), "村民刷怪蛋");
            this.add(ChangShengJueItems.WARRIOR_EGG.get(), "武夫刷怪蛋");
            this.add(ChangShengJueItems.KILN_WORKER_EGG.get(), "营造主事刷怪蛋");
            this.add(ChangShengJueItems.MALE_INNKEEPER_EGG.get(), "酒馆男掌柜刷怪蛋");
            this.add(ChangShengJueItems.FEMALE_INNKEEPER_EGG.get(), "酒馆女掌柜刷怪蛋");
            this.add(ChangShengJueItems.CHALLENGER_EGG.get(), "挑战者刷怪蛋");
            this.add(ChangShengJueItems.BLACKSMITH_EGG.get(), "铁匠刷怪蛋");
            this.add(ChangShengJueItems.LANCE_GANG_LEADER_EGG.get(), "帮派首领(枪)刷怪蛋");
            this.add(ChangShengJueItems.KNIFE_GANG_LEADER_EGG.get(), "帮派首领(刀)刷怪蛋");
            this.add(ChangShengJueItems.SWORD_GANG_LEADER_EGG.get(), "帮派首领(剑)刷怪蛋");
            this.add(ChangShengJueItems.CLUBBED_GANG_LEADER_EGG.get(), "帮派首领(棍)刷怪蛋");
            this.add(ChangShengJueItems.GANG_LEADER_EGG.get(), "帮派首领(拳)刷怪蛋");
            this.add(ChangShengJueItems.BANDIT_EGG.get(), "强盗刷怪蛋");
            this.add(ChangShengJueItems.VILLAIN_EGG.get(), "恶徒刷怪蛋");
            this.add(ChangShengJueItems.ASSASSIN_EGG.get(), "杀手刷怪蛋");
            this.add(ChangShengJueItems.CLUBBED_MING_XIA_EGG.get(), "棍王刷怪蛋");
            this.add(ChangShengJueItems.SWORD_MING_XIA_EGG.get(), "剑仙刷怪蛋");
            this.add(ChangShengJueItems.KNIFE_MING_XIA_EGG.get(), "刀圣刷怪蛋");
            this.add(ChangShengJueItems.FIST_MING_XIA_EGG.get(), "北拳刷怪蛋");
            this.add(ChangShengJueItems.PIGLIN_WU_XIA_EGG.get(), "功夫猪灵刷怪蛋");
            this.add(ChangShengJueItems.WITCH_WU_XIA_EGG.get(), "功夫女巫刷怪蛋");
            this.add(ChangShengJueItems.EVOKER_WU_XIA_EGG.get(), "功夫唤魔者刷怪蛋");
            this.add(ChangShengJueItems.VINDICATOR_WU_XIA_EGG.get(), "功夫卫道士刷怪蛋");
            this.add(ChangShengJueItems.PILLAGER_WU_XIA_EGG.get(), "功夫掠夺者刷怪蛋");
            //工具武器和盔甲物品
            this.add(ChangShengJueItems.KAISHAN_PICKAXE.get(),"开山镐");
            this.add(ChangShengJueItems.XUANHUA_AXE.get(),"萱花斧");
            this.add(ChangShengJueItems.BRONZE_SWORD.get(),"青铜剑");
            this.add(ChangShengJueItems.HAN_JIAN.get(),"汉剑");
            this.add(ChangShengJueItems.HENG_DAO.get(),"横刀");
            this.add(ChangShengJueItems.LARGE_KNIFE.get(),"大刀");
            this.add(ChangShengJueItems.RED_TASSELLED_SPEAR.get(),"红缨枪");
            this.add(ChangShengJueItems.SOFT_SWORD.get(),"软剑");
            this.add(ChangShengJueItems.PAN_HUA_GUN.get(),"盘花棍");
            this.add(ChangShengJueItems.KITCHEN_KNIFE.get(),"菜刀");
            this.add(ChangShengJueItems.THROWING_KNIVES.get(),"飞刀");
            this.add(ChangShengJueItems.FLYING_DAGGER_POUCH.get(),"飞刀囊");
            this.add(ChangShengJueItems.BEAT_DOG_STICK.get(),"打狗棒");
            this.add(ChangShengJueItems.YI_TIAN_JIAN.get(),"倚天剑");
            this.add(ChangShengJueItems.TU_LONG_DAO.get(),"屠龙刀");
            this.add(ChangShengJueItems.BA_WANG_QIANG.get(),"霸王枪");
            this.add(ChangShengJueItems.GOLD_THREAD_GLOVE.get(),"金丝手套");
            this.add(ChangShengJueItems.COTTON_HELMET.get(),"棉盔");
            this.add(ChangShengJueItems.WHITE_COTTON_HELMET.get(),"白羽棉盔");
            this.add(ChangShengJueItems.COTTON_CHESTPLATE.get(),"棉甲");
            this.add(ChangShengJueItems.COTTON_LEGGINGS.get(),"棉护腿");
            this.add(ChangShengJueItems.COTTON_BOOTS.get(),"棉靴子");
            this.add(ChangShengJueItems.FEMALE_TAOIST_HELMET.get(),"道冠");
            this.add(ChangShengJueItems.FEMALE_TAOIST_CHESTPLATE.get(),"道袍");
            this.add(ChangShengJueItems.MALE_TAOIST_HELMET.get(),"四方巾");
            this.add(ChangShengJueItems.MALE_TAOIST_CHESTPLATE.get(),"道服");
            this.add(ChangShengJueItems.TAOIST_BOOTS.get(),"丝履");
            this.add(ChangShengJueItems.TAOIST_LEGGINGS.get(),"丝裳");
            this.add(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_BLACK_GAUZE_CAP.get(),"乌纱帽");
            this.add(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_KYLIN_BUFU.get(),"麒麟补服");
            this.add(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_PHOENIX_CORONET.get(),"凤冠");
            this.add(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_QUEEN_CLOTHING.get(),"袆衣");
            this.add(ChangShengJueItems.CHINESE_WEDDING_DRESS_GOLDEN_THREAD_SHOES.get(),"金丝履");
            this.add(ChangShengJueItems.MOUNTAIN_PATTERN_HELMET_GUN_HOOD.get(),"盔枪兜鍪");
            this.add(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR.get(),"山文甲");
            this.add(ChangShengJueItems.MOUNTAIN_PATTERN_DEERSKIN_TIBIAL_ARMOR.get(),"鹿皮胫甲");
            this.add(ChangShengJueItems.MOUNTAIN_PATTERN_CLOUD_BLACK_BOOTS.get(),"云头乌皮靴");
            this.add(ChangShengJueItems.FLY_FISH_IRON_HAT.get(), "铁笠");
            this.add(ChangShengJueItems.FLY_FISH_CLOUD_VEIL_CROWN.get(), "云纱冠");
            this.add(ChangShengJueItems.FLY_FISH_CHESTPLATE.get(), "飞鱼服");
            this.add(ChangShengJueItems.FLY_FISH_LONG_BOOTS.get(), "长靴");
            this.add(ChangShengJueItems.WALKER_GREEN_TREASURE_PENDANT.get(),"绿宝眉心坠");
            this.add(ChangShengJueItems.WALKER_GOLD_RING_BAND.get(), "金戒箍");
            this.add(ChangShengJueItems.WALKER_CHESTPLATE.get(), "行者装");
            this.add(ChangShengJueItems.WALKER_TIGER_SKIN_SKIRT.get(), "虎皮裙");
            this.add(ChangShengJueItems.WALKER_SHORT_BOOTS.get(), "短靴");
            this.add(ChangShengJueItems.PHOENIX_FEATHER_CAP.get(),"凤翅紫金冠");
            this.add(ChangShengJueItems.OLDEN_CHAIN_MAIL_SHIRT.get(),"锁子黄金甲");
            this.add(ChangShengJueItems.TIGER_SKIN_GARMENT.get(),"虎皮下裳");
            this.add(ChangShengJueItems.CLOUD_WALKING_BOOTS.get(),"藕丝步云履");
            this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_PHOENIX_WINGS_HELMET.get(), "凤翅兜鍪");
            this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE.get(), "明光铠");
            this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LAZULI_KNEE_PADS.get(), "青金护膝");
            this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_ANIMAL_SKIN_BOOTS.get(), "兽皮靴");
            this.add(ChangShengJueItems.CONFUCIAN_HELMET.get(), "儒冠");
            this.add(ChangShengJueItems.CONFUCIAN_INK_CHESTPLATE.get(), "染墨宽袍");
            this.add(ChangShengJueItems.CONFUCIAN_INK_LEGGINGS.get(), "染墨丝裳");
            this.add(ChangShengJueItems.CONFUCIAN_INK_BOOTS.get(), "染墨丝履");
    
            this.add(ChangShengJueItems.GOLD_SILK_SOFT_ARMOR.get(), "金丝软甲");
            this.add(ChangShengJueItems.LEATHER_INNER_ARMOR.get(), "皮内甲");
    
            this.add(ChangShengJueItems.ARMOR_PARCEL.get(), "盔甲包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "cotton_armor", "棉甲包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "mountain_pattern", "山文甲包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "mingguang_armor", "大将军明光铠包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "qi_tian_da_sheng", "大圣甲胄包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "male_taoist", "道服包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "female_taoist", "道袍包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "male_wedding_dress", "麒麟补服包裹");
            this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "female_wedding_dress", "袆衣包裹");
    
            //效果
            this.add(ChangShengJueItems.TRAUMA_EFFECT.get(), "外伤");
            this.add(ChangShengJueItems.INTERNAL_INJURY_EFFECT.get(), "内伤");
    
            //武功秘籍物品
            this.add(ChangShengJueItems.IMMORTAL_MIRACLE.get(),"不死神功");
            this.add(ChangShengJueItems.HERCULES.get(),"大力神功");
            this.add(ChangShengJueItems.DUGU_NINE_SWORDS.get(),"独孤九剑");
            this.add(ChangShengJueItems.GAO_MARKSMANSHIP.get(),"高家枪法");
            this.add(ChangShengJueItems.GE_SHAN_DA_NIU.get(),"隔山打牛");
            this.add(ChangShengJueItems.TURTLE_BREATH_WORK.get(),"龟息功");
            this.add(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get(),"金乌刀法");
            this.add(ChangShengJueItems.GOLDEN_BELL_JAR.get(),"金钟罩");
            this.add(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get(),"葵花点穴手");
            this.add(ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get(),"麦块百科");
            this.add(ChangShengJueItems.PAODING.get(),"庖丁解牛");
            this.add(ChangShengJueItems.SHAOLIN_STICK_METHOD.get(),"少林棍法");
            this.add(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get(),"踏雪无痕");
            this.add(ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get(),"无情飞刀");
            this.add(ChangShengJueItems.WU_GANG_CUT_GUI.get(),"吴刚伐桂");
            this.add(ChangShengJueItems.XUANNU_SWORDSMANSHIP.get(),"玄女剑法");
            this.add(ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get(),"愚公移山");
            this.add(ChangShengJueItems.ZHANG_MEN_XIN_XUE.get(),"张门心学");
            this.add(ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get(),"易筋经");
            this.add(ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get(),"乾坤大挪移");
    
            //武功描述
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DUGU_NINE_SWORDS.get()+".tooltip","天下剑法中的巅峰绝诣，其中包含森罗万象的诀窍。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DUGU_NINE_SWORDS.get()+".hold_shift.tooltip",
                    "未大成前施展效果:外功释放造成(主手武器伤害+1)*1.8倍的伤害\\n大成后施展效果:伤害倍数提高至2.2倍、使用剑时流血触发概率*1.25\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.XUANNU_SWORDSMANSHIP.get()+".tooltip","以巧借力，以柔克刚。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.XUANNU_SWORDSMANSHIP.get()+".hold_shift.tooltip",
                    "未大成前施展效果:外功释放造成(主手武器伤害+1)*2.2倍伤害\\n大成后施展效果:伤害倍数提高至2.5倍、使用软剑时流血触发概率*3.0\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GAO_MARKSMANSHIP.get()+".tooltip","一点寒芒先到，随后枪出如龙。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GAO_MARKSMANSHIP.get()+".hold_shift.tooltip",
                    "未大成前施展效果:外功释放造成(主手武器伤害+1)*1.8倍的伤害\\n大成后施展效果:伤害倍数提高至2.1倍、使用枪时挑飞触发概率*2.5\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get()+".tooltip","无情飞刀人有情义，人有情义飞刀无情。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get()+".hold_shift.tooltip",
                    "未大成前施展效果:飞刀伤害提高至1.25倍并可一次丢出3把飞刀\\n大成后施展效果:飞刀伤害提高至1.5倍并可一次丢出7把飞刀\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SHAOLIN_STICK_METHOD.get()+".tooltip","天下武功出少林，一棍定乾坤。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SHAOLIN_STICK_METHOD.get()+".hold_shift.tooltip",
                    "未大成前施展效果:外功释放造成(主手武器伤害+1)*1.7倍伤害\\n大成后施展效果:伤害倍数提高至2.0倍、使用棍时击晕触发概率*2.5\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get()+".tooltip","任你千变万化，我只一刀破去!");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get()+".hold_shift.tooltip",
                    "未大成前施展效果:外功释放造成(主手武器伤害+1)*1.9倍的伤害\\n大成后施展效果:伤害倍数提高至2.0倍、使用刀时重击触发概率*2.0\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()+".tooltip","来去无影无踪，逍遥自在。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()+".hold_shift.tooltip",
                    "未大成前施展效果:可以进行二连跳\\n大成后施展效果:可以进行三段跳\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WU_GANG_CUT_GUI.get()+".tooltip","何意杀人技，不如快人心。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WU_GANG_CUT_GUI.get()+".hold_shift.tooltip",
                    "未大成前施展效果:使用萱花斧砍树可以破坏整棵树\\n大成后施展效果:砍树连带破坏整个树的速度更快\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get()+".tooltip","生生不息，直至山平。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get()+".hold_shift.tooltip",
                    "未大成前施展效果:使用开山镐的挖掘面积扩大为2x2\\n大成后施展效果:挖掘面积扩大为3x3\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.PAODING.get()+".tooltip","若反复实践，掌握规律；便得心应手，运用自如。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.PAODING.get()+".hold_shift.tooltip",
                    "未大成前施展效果:主手持菜刀杀死动物有50%概率额外掉落肉\\n大成后施展效果:主手持菜刀杀死动物有75%概率额外掉落肉\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.HERCULES.get()+".tooltip","以气御力，神力无穷。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.HERCULES.get()+".hold_shift.tooltip",
                    "未大成前施展效果:减少疾跑消耗的饱食度降低至60%\\n大成后施展效果:主手持金丝手套右键可打开末影箱\\n移动大于%s米后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()+".tooltip","指如疾风，势如闪电。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()+".hold_shift.tooltip",
                    "未大成前施展效果:定住血量上限低于25点的目标1.5秒\\n大成后施展效果:定住血量上限低于200点的目标2秒\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BELL_JAR.get()+".tooltip","刀枪不入，浑然一金钟。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BELL_JAR.get()+".hold_shift.tooltip",
                    "未大成前施展效果:提高4点护甲,受到伤害时会获得3级的伤害吸收\\n大成后施展效果:提高8点护甲,受到伤害时伤害吸收的效果提高到5级\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.ZHANG_MEN_XIN_XUE.get()+".tooltip","江湖不是打打杀杀，那是人情世故!");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.ZHANG_MEN_XIN_XUE.get()+".hold_shift.tooltip",
                    "未大成前施展效果:与村民的交易一次即可将村民等级提升至学徒\\n大成后施展效果:额外有10%概率不消耗物品交易\\n与村民交易%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.IMMORTAL_MIRACLE.get()+".tooltip","不死不灭，岂是幻梦?");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.IMMORTAL_MIRACLE.get()+".hold_shift.tooltip",
                    "未大成前施展效果:在濒死时抵御一次致命伤害\\n大成后施展效果:减少15秒冷却时间\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GE_SHAN_DA_NIU.get()+".tooltip","神功盖世，何欺牛儿?");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GE_SHAN_DA_NIU.get()+".hold_shift.tooltip",
                    "未大成前施展效果:无视方块阻拦施展外功造成22点伤害\\n大成后施展效果:攻击伤害范围提高2格\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get()+".tooltip","学向勤中得，萤窗万卷书。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get()+".hold_shift.tooltip",
                    "未大成前施展效果:每次交易有25%概率获得5点经验\\n大成后施展效果:每次交易有35%概率获得10点经验\\n经验到达30级后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TURTLE_BREATH_WORK.get()+".tooltip","龟虽有鼻，而息之以耳。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TURTLE_BREATH_WORK.get()+".hold_shift.tooltip",
                    "未大成前施展效果:施展后一段时间内可以水下屏息更久，不会被动物主动攻击\\n大成后施展效果:提高屏息效果\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get()+".tooltip","武林中人梦寐以求的武学宝典。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get()+".hold_shift.tooltip",
                    "未大成前施展效果:释放武功需要的饥饿度减少1点\\n大成后施展效果:释放武功需要的饥饿度与饱和度各减少1点\\n成功施展%s次后武功大成");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()+".tooltip","激发潜力，牵引挪移，其中变化莫测，匪夷所思。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()+".hold_shift.tooltip",
                    "未大成前施展效果:有35%概率将遭受的攻击伤害于1.0秒后以1.5倍反弹给攻击者\\n大成后施展效果:每多1点血量额外提高2%触发概率\\n每施展1次冷却时间短期内延长2秒\\n成功施展%s次后武功大成");

            this.add("kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.kungfu", "习得%s");
            this.add("kungfu." + ChangShengJue.MOD_ID + ".succeed.studied.kungfu", "%s已阅览过,%s!");
            this.add("kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.kungfu", "%s已阅览,快去领悟吧");
            this.add("kungfu." + ChangShengJue.MOD_ID + ".succeed.dacheng.kungfu", "%s神功大成!");
            this.add("kungfu.true.comprehend", "且已领悟");
            this.add("kungfu.fales.comprehend", "还需领悟");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".state_change.kungfu", "%s : %s");
            this.add("kungfu.open", "启动");
            this.add("kungfu.off", "关闭");
            this.add("message." + ChangShengJue.MOD_ID + ".dagger_pouch.empty", "§c没有武器了");
    
            this.add("tooltip." + ChangShengJue.MOD_ID + ".dagger_pouch.count","飞刀囊容量 %s / %s");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".durability","耐久 %s / %s");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".dagger_pouch.contents","飞刀囊内的物品");
    
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DURIAN.get()+".tooltip","请使用斧子劈开");
            this.add("tooltip."+ChangShengJue.MOD_ID+".hold_shift.tooltip","按下 §eShift§r 查看更多信息");
    
            this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data","已内衬");
            this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.lining","此铠甲不可内衬");
            this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.lining1","请使用胸甲内衬");
            this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.unload","已从装备中卸下");
    
            this.add("tooltip."+ ChangShengJue.MOD_ID + ".damage_reduction","外功伤害减免: +%s%%");
            this.add("tooltip."+ ChangShengJue.MOD_ID + ".trauma","受到外伤的概率: -%s%%");
    
            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "pit_yard.tooltip", "地下窑洞");
            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "sandstone_castle.tooltip","沙石堡");
            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "si_he_yuan.tooltip","四合院");
            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "su_pai_village.tooltip","苏式村庄");
            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "hui_pai_village.tooltip","徽式村庄");
            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "fortresses_type.tooltip","古城");
            this.add("tooltip." + ChangShengJue.MOD_ID + "." + "null.structure.tooltip","未知结构");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".structural_location","在 [x=%d | z=%d] 位置坐落着一处%s,去看看吧");
    
            //声音
            this.add("sounds."+ChangShengJue.MOD_ID + ".ge_shan_da_niu_sound","武功 : 隔山打牛");
            this.add("sounds."+ChangShengJue.MOD_ID + ".dugu_nine_swords_sound","武功 : 独孤九剑");
            this.add("sounds."+ChangShengJue.MOD_ID + ".immortal_miracle_sound","武功 : 不死神功");
            this.add("sounds."+ChangShengJue.MOD_ID + ".gao_marksmanship_sound","武功 : 高家枪法");
            this.add("sounds."+ChangShengJue.MOD_ID + ".turtle_breath_work_sound","武功 : 龟息功");
            this.add("sounds."+ChangShengJue.MOD_ID + ".golden_black_knife_method_sound","武功 : 金乌刀法");
            this.add("sounds."+ChangShengJue.MOD_ID + ".sunflower_point_caveman_sound","武功 : 葵花点穴手");
            this.add("sounds."+ChangShengJue.MOD_ID + ".shaolin_stick_method_sound","武功 : 少林棍法");
            this.add("sounds."+ChangShengJue.MOD_ID + ".tread_the_snow_without_trace_sound","武功 : 踏雪无痕");
            this.add("sounds."+ChangShengJue.MOD_ID + ".throwing_knives_sound","飞刀 : 飞出");
            this.add("sounds."+ChangShengJue.MOD_ID + ".three_throwing_knives_sound","飞刀 : 飞出");
            this.add("sounds."+ChangShengJue.MOD_ID + ".seven_throwing_knives_sound","飞刀 : 飞出");
            this.add("sounds."+ChangShengJue.MOD_ID + ".throwing_knives_hit","飞刀 : 命中");
            this.add("sounds."+ChangShengJue.MOD_ID + ".throwing_knives_hit_ground","飞刀 : 命中");
            this.add("sounds."+ChangShengJue.MOD_ID + ".wu_gang_cut_gui_sound","武功 : 吴刚伐桂");
            this.add("sounds."+ChangShengJue.MOD_ID + ".xuannu_swordsmanship_sound","武功 : 玄女剑法");
            this.add("sounds."+ChangShengJue.MOD_ID + ".golden_belljar_sound","武功 : 金钟罩");
            this.add("sounds."+ChangShengJue.MOD_ID + ".qian_kun_da_nuo_yi_sound","武功 : 乾坤大挪移");
            this.add("sounds."+ChangShengJue.MOD_ID + ".comprehend_sound","武功 : 突破");
            this.add("sounds."+ChangShengJue.MOD_ID + ".dacheng_sound","武功 : 大成");
    
            this.add("sounds."+ChangShengJue.MOD_ID + ".cicada_sound", "蝉 : 鸣叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".cicada_hurt", "蝉 : 受伤");
            this.add("sounds."+ChangShengJue.MOD_ID + ".crane_sound", "鹤 : 鸣叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".crane_hurt", "鹤 : 受伤");
            this.add("sounds."+ChangShengJue.MOD_ID + ".crane_death", "鹤 : 死亡");
            this.add("sounds."+ChangShengJue.MOD_ID + ".croc_sound", "鳄鱼 : 咆哮");
            this.add("sounds."+ChangShengJue.MOD_ID + ".croc_hurt", "鳄鱼 : 受伤");
            this.add("sounds."+ChangShengJue.MOD_ID + ".croc_death", "鳄鱼 : 死亡");
            this.add("sounds."+ChangShengJue.MOD_ID + ".dragonfly_hurt", "蜻蜓 : 受伤");
            this.add("sounds."+ChangShengJue.MOD_ID + ".dragonfly_death", "蜻蜓 : 死亡");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_sound" , "猴 : 嚎叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_baby_sound" , "猴 : 嚎叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_angry_sound" , "猴 : 生气");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_hurt" , "猴 : 受伤");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_death" , "猴 : 死亡");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_1" , "猴 : 拜年");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_2" , "猴 : 翻筋斗");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_3" , "猴 : 敬礼");
            this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_4" , "猴 : 很脏很脏的嚎叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_sound" , "虎 : 咆哮");
            this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_sound_1" , "虎 : 咆哮");
            this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_hurt" , "虎 : 受伤");
            this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_death" , "虎 : 死亡");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound" , "鹿 : 鸣叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_1" , "鹿 : 鸣叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_2" , "鹿 : 鸣叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_3" , "鹿 : 鸣叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_4" , "鹿 : 鸣叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_5" , "鹿 : 鸣叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_hurt" , "鹿 : 受伤");
            this.add("sounds."+ChangShengJue.MOD_ID + ".deer_death" , "鹿 : 死亡");
            this.add("sounds."+ChangShengJue.MOD_ID + ".peacock_sound" , "孔雀 : 鸣叫");
            this.add("sounds."+ChangShengJue.MOD_ID + ".peacock_hurt" , "孔雀 : 受伤");
            this.add("sounds."+ChangShengJue.MOD_ID + ".peacock_death" , "孔雀 : 死亡");
    
            //风铃
            this.add("sounds."+ChangShengJue.MOD_ID + ".wind_chime_sound", "风铃 : 叮铃铃");
    
            this.add("sounds."+ChangShengJue.MOD_ID + ".gong_sound", "锣 : 铛~");
    
            this.add("sounds."+ChangShengJue.MOD_ID + ".tailoring_case_sound", "裁衣案 : 裁剪");
    
            this.add("sounds."+ChangShengJue.MOD_ID + ".forge_block_sound", "锻锤 : 锤击");
    
            this.add("sounds."+ChangShengJue.MOD_ID + ".stakes_hit_sound", "练功木桩 : 被击打");
    
            //方块
            this.add(ChangShengJueItems.STAKES.get(),"练功木桩");
            this.add(ChangShengJueBlocks.GONG.get(),"锣");
    
            this.add(ChangShengJueBlocks.CANTALOUPE_BLOCK.get(),"哈密瓜");
            this.add(ChangShengJueBlocks.WILDLIFE_HORDEUM.get(),"野生大麦");
    
            this.add(ChangShengJueBlocks.MANGO_LOG.get(),"芒果原木");
            this.add(ChangShengJueBlocks.MANGO_LEAVES.get(),"芒果树叶");
            this.add(ChangShengJueBlocks.MANGO_SAPLING.get(),"芒果树苗");
    
            this.add(ChangShengJueBlocks.BANANA_LOG.get(),"香蕉原木");
            this.add(ChangShengJueBlocks.BANANA_LEAVES.get(),"香蕉树叶");
            this.add(ChangShengJueBlocks.BANANA_SAPLING.get(),"香蕉树苗");
            this.add(ChangShengJueBlocks.BANANA_FRUIT.get(),"香蕉");
    
            this.add(ChangShengJueBlocks.PEAR_LOG.get(),"梨树原木");
            this.add(ChangShengJueBlocks.PEAR_LEAVES.get(),"梨树树叶");
            this.add(ChangShengJueBlocks.PEAR_SAPLING.get(),"梨树树苗");
    
            this.add(ChangShengJueBlocks.LICHEE_LOG.get(),"荔枝原木");
            this.add(ChangShengJueBlocks.LICHEE_LEAVES.get(),"荔枝树叶");
            this.add(ChangShengJueBlocks.LICHEE_SAPLING.get(),"荔枝树苗");
    
    
            this.add(ChangShengJueBlocks.DURIAN_LOG.get(),"榴莲原木");
            this.add(ChangShengJueBlocks.DURIAN_LEAVES.get(),"榴莲树叶");
            this.add(ChangShengJueBlocks.DURIAN_SAPLING.get(),"榴莲树苗");
    
            this.add(ChangShengJueBlocks.GUI_HUA_LOG.get(),"桂花原木");
            this.add(ChangShengJueBlocks.GUI_HUA_LEAVES.get(),"桂花树叶");
            this.add(ChangShengJueBlocks.GUI_HUA_SAPLING.get(),"桂花树苗");
            this.add(ChangShengJueBlocks.GUI_HUA_DEFOLIATION.get(),"桂花落叶");
    
            this.add(ChangShengJueBlocks.MEI_HUA_LOG.get(),"梅花原木");
            this.add(ChangShengJueBlocks.MEI_HUA_LEAVES.get(),"梅花树叶");
            this.add(ChangShengJueBlocks.MEI_HUA_SAPLING.get(),"梅花树苗");
            this.add(ChangShengJueBlocks.MEI_HUA_DEFOLIATION.get(),"梅花落叶");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get(),"黄花梨原木");
            this.add(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get(),"去皮黄花梨原木");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LEAVES.get(),"黄花梨树叶");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_SAPLING.get(),"黄花梨树苗");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get(),"黄花梨木板");
            this.add(ChangShengJueBlocks.JI_CHI_MU_LOG.get(),"鸡翅木原木");
            this.add(ChangShengJueBlocks.STRIPPED_JI_CHI_MU_LOG.get(),"去皮鸡翅木原木");
            this.add(ChangShengJueBlocks.JI_CHI_MU_LEAVES.get(),"鸡翅木树叶");
            this.add(ChangShengJueBlocks.JI_CHI_MU_SAPLING.get(),"鸡翅木树苗");
            this.add(ChangShengJueBlocks.JI_CHI_MU_PLANKS.get(),"鸡翅木木板");
            this.add(ChangShengJueBlocks.ZI_TAN_LOG.get(),"紫檀原木");
            this.add(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get(),"去皮紫檀原木");
            this.add(ChangShengJueBlocks.ZI_TAN_LEAVES.get(),"紫檀树叶");
            this.add(ChangShengJueBlocks.ZI_TAN_SAPLING.get(),"紫檀树苗");
            this.add(ChangShengJueBlocks.ZI_TAN_PLANKS.get(),"紫檀木板");
            this.add(ChangShengJueBlocks.POPLAR_LOG.get(),"白杨原木");
            this.add(ChangShengJueBlocks.POPLAR_LEAVES.get(),"白杨树叶");
            this.add(ChangShengJueBlocks.POPLAR_SAPLING.get(),"白杨树苗");
            this.add(ChangShengJueBlocks.POPLAR_DEFOLIATION.get(),"白杨落叶");
    
    
            this.add(ChangShengJueBlocks.MULBERRY_LOG.get(),"桑树原木");
            this.add(ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get(),"去皮桑树原木");
            this.add(ChangShengJueBlocks.MULBERRY_LEAVES.get(),"桑树树叶");
            this.add(ChangShengJueBlocks.MULBERRY_SAPLING.get(),"桑树树苗");
    
    
            // 食物容器类方块
            this.add(ChangShengJueBlocks.CAPSULE_JIAO_ZI_PAN.get(), "饺子盘");
            this.add(ChangShengJueBlocks.CAPSULE_JIAO_ZI_WAN.get(), "饺子碗");
            this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_PAN.get(), "马齿苋饼盘");
            this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_WAN.get(), "马齿苋饼碗");
            this.add(ChangShengJueBlocks.QING_TUAN_PAN.get(), "青团盘");
            this.add(ChangShengJueBlocks.QING_TUAN_WAN.get(), "青团碗");
            this.add(ChangShengJueBlocks.SORGHUM_CAKE_PAN.get(), "高粱饼盘");
            this.add(ChangShengJueBlocks.SORGHUM_CAKE_WAN.get(), "高粱饼碗");
            this.add(ChangShengJueBlocks.MI_FAN_PAN.get(), "米饭盘");
            this.add(ChangShengJueBlocks.MI_FAN_WAN.get(), "米饭碗");
            this.add(ChangShengJueBlocks.XIAO_MI_FAN_PAN.get(), "小米饭盘");
            this.add(ChangShengJueBlocks.XIAO_MI_FAN_WAN.get(), "小米饭碗");
    
    
            this.add(ChangShengJueBlocks.EMPTY_SHI_LI_XIANG.get(), "空十里香杯");
            this.add(ChangShengJueBlocks.EMPTY_WHEAT_NUGGETS_TRIBUTE_WINE.get(), "空麦块贡酒杯");
    
    
    
            this.add(ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.get(),"青花瓷花盆");
    
            this.add(ChangShengJueBlocks.MUGWORT_BLOCK.get(),"艾蒿");
            this.add(ChangShengJueBlocks.POTTED_MUGWORT_BLOCK.get(),"艾蒿");
    
            this.add(ChangShengJueBlocks.CAPSULE_BLOCK.get(),"荠菜");
    
            this.add(ChangShengJueBlocks.CUCKOO_BLOCK.get(),"杜鹃花");
            this.add(ChangShengJueBlocks.POTTED_CUCKOO_BLOCK.get(),"杜鹃花");
    
            this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get(),"马齿苋");
            this.add(ChangShengJueBlocks.POTTED_PORTULACA_OLERACEA_BLOCK.get(),"马齿苋");
    
            this.add(ChangShengJueBlocks.JASMINE_BLOCK.get(),"茉莉花");
            this.add(ChangShengJueBlocks.POTTED_JASMINE_BLOCK.get(),"茉莉花");
    
            this.add(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get(),"地肤草");
            this.add(ChangShengJueBlocks.POTTED_KOCHIA_SCOPARIA_BLOCK.get(),"地肤草");
    
            this.add(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get(),"水仙花");
            this.add(ChangShengJueBlocks.POTTED_SHUI_XIAN_BLOCK.get(),"水仙花");
    
            this.add(ChangShengJueBlocks.TAN_HUA_BLOCK.get(),"昙花");
            this.add(ChangShengJueBlocks.POTTED_TAN_HUA_BLOCK.get(),"昙花");
    
            this.add(ChangShengJueBlocks.STIPA_GRANDIS.get(),"大针茅");
            this.add(ChangShengJueBlocks.TALL_STIPA_GRANDIS.get(),"大针茅");
            this.add(ChangShengJueBlocks.TALL_STIPA_GRANDIS_VARIANT.get(),"高大的异种大针茅");
    
            this.add(ChangShengJueBlocks.SOLIDAGO.get(),"秋麒麟");
            this.add(ChangShengJueBlocks.POTTED_SOLIDAGO.get(),"秋麒麟");
    
            this.add(ChangShengJueBlocks.GEUM_TRIFLORUM.get(),"三花路边青");
            this.add(ChangShengJueBlocks.POTTED_GEUM_TRIFLORUM.get(),"三花路边青");
    
            this.add(ChangShengJueBlocks.PURPLE_DANDELION.get(),"紫色蒲公英");
            this.add(ChangShengJueBlocks.POTTED_PURPLE_DANDELION.get(),"紫色蒲公英");
    
            this.add(ChangShengJueBlocks.RED_KNOTWEED.get(),"红蓼");
            this.add(ChangShengJueBlocks.PURPLE_RED_KNOTWEED.get(),"异种红蓼");
    
            this.add(ChangShengJueBlocks.RAPE_FLOWERS.get(),"油菜花");
    
            this.add(ChangShengJueBlocks.ZHU_TAI.get(),"烛台");
            this.add(ChangShengJueBlocks.HANG_TU_BLOCK.get(),"夯土");
            this.add(ChangShengJueBlocks.HANG_TU_STAIRS.get(),"夯土楼梯");
            this.add(ChangShengJueBlocks.HANG_TU_SLAB.get(),"夯土台阶");
            this.add(ChangShengJueBlocks.HANG_TU_WALL.get(),"夯土墙");
            this.add(ChangShengJueBlocks.TU_PEI_BLOCK.get(),"土坯");
            this.add(ChangShengJueBlocks.TU_PEI_STAIRS.get(),"土坯楼梯");
            this.add(ChangShengJueBlocks.TU_PEI_SLAB.get(),"土坯台阶");
            this.add(ChangShengJueBlocks.TU_PEI_WALL.get(),"土坯墙");
    
            this.add(ChangShengJueBlocks.WHITE_WALLS_BLOCK.get(), "白墙");
            this.add(ChangShengJueBlocks.COOL_WHITE_WALLS_BLOCK.get(), "冷白色墙");
            this.add(ChangShengJueBlocks.WARM_WHITE_WALLS_BLOCK.get(), "暖白色墙");
    
            this.add(ChangShengJueBlocks.WHITE_FINE_BRICKS.get(),"白细砖");
            this.add(ChangShengJueBlocks.WHITE_BRICKS.get(),"白砖");
            this.add(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get(),"黑石细砖");
            this.add(ChangShengJueBlocks.BLACK_STONE_BRICKS.get(),"黑石砖");
            this.add(ChangShengJueBlocks.BLUE_STONE_BRICKS.get(),"青石砖");
            this.add(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get(),"青石细砖");
    
            this.add(ChangShengJueBlocks.WHITE_BRICKS_STAIRS.get(),"白砖楼梯");
            this.add(ChangShengJueBlocks.BLACK_STONE_BRICKS_STAIRS.get(),"黑石砖楼梯");
            this.add(ChangShengJueBlocks.BLUE_STONE_BRICKS_STAIRS.get(),"青石砖楼梯");
    
            this.add(ChangShengJueBlocks.WHITE_BRICKS_SLAB.get(),"白砖台阶");
            this.add(ChangShengJueBlocks.BLACK_STONE_BRICKS_SLAB.get(),"黑石台阶");
            this.add(ChangShengJueBlocks.BLUE_STONE_BRICKS_SLAB.get(),"青石台阶");
    
            this.add(ChangShengJueBlocks.WHITE_BRICKS_VERTICAL_WALLS.get(),"白砖竖墙");
            this.add(ChangShengJueBlocks.BLACK_STONE_VERTICAL_WALLS.get(),"黑石竖墙");
            this.add(ChangShengJueBlocks.BLUE_STONE_VERTICAL_WALLS.get(),"青石竖墙");
    
    
            this.add(ChangShengJueBlocks.MANGROVE_OVERLORD_FIST.get(),"红木霸王拳");
            this.add(ChangShengJueBlocks.BIRCH_OVERLORD_FIST.get(),"白桦木霸王拳");
            this.add(ChangShengJueBlocks.JUNGLE_OVERLORD_FIST.get(), "丛林木霸王拳");
            this.add(ChangShengJueBlocks.CRIMSON_OVERLORD_FIST.get(), "绯红木霸王拳");
            this.add(ChangShengJueBlocks.WARPED_OVERLORD_FIST.get(), "诡异木霸王拳");
            this.add(ChangShengJueBlocks.ACACIA_OVERLORD_FIST.get(), "金合欢霸王拳");
            this.add(ChangShengJueBlocks.DARK_OAK_OVERLORD_FIST.get(), "深色橡木霸王拳");
            this.add(ChangShengJueBlocks.OAK_OVERLORD_FIST.get(), "橡木霸王拳");
            this.add(ChangShengJueBlocks.CHERRY_OVERLORD_FIST.get(), "樱花木霸王拳");
            this.add(ChangShengJueBlocks.SPRUCE_OVERLORD_FIST.get(), "云杉木霸王拳");
            this.add(ChangShengJueBlocks.SHORT_MANGROVE_BACK_BRACKET.get(), "红木回纹雀替");
            this.add(ChangShengJueBlocks.SHORT_BIRCH_BACK_BRACKET.get(), "白桦木回纹雀替");
            this.add(ChangShengJueBlocks.SHORT_JUNGLE_BACK_BRACKET.get(), "丛林木回纹雀替");
            this.add(ChangShengJueBlocks.SHORT_CRIMSON_BACK_BRACKET.get(), "绯红木回纹雀替");
            this.add(ChangShengJueBlocks.SHORT_WARPED_BACK_BRACKET.get(), "诡异木回纹雀替");
            this.add(ChangShengJueBlocks.SHORT_ACACIA_BACK_BRACKET.get(), "金合欢回纹雀替");
            this.add(ChangShengJueBlocks.SHORT_DARK_OAK_BACK_BRACKET.get(), "深色橡木回纹雀替");
            this.add(ChangShengJueBlocks.SHORT_OAK_BACK_BRACKET.get(), "橡木回纹雀替");
            this.add(ChangShengJueBlocks.SHORT_CHERRY_BACK_BRACKET.get(), "樱花木回纹雀替");
            this.add(ChangShengJueBlocks.SHORT_SPRUCE_BACK_BRACKET.get(), "云杉木回纹雀替");
            this.add(ChangShengJueBlocks.SHORT_MANGROVE_FLOWER_BRACKET.get(), "红木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_BIRCH_FLOWER_BRACKET.get(), "白桦木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_JUNGLE_FLOWER_BRACKET.get(), "丛林木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_CRIMSON_FLOWER_BRACKET.get(), "绯红木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_WARPED_FLOWER_BRACKET.get(), "诡异木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_ACACIA_FLOWER_BRACKET.get(), "金合欢花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_DARK_OAK_FLOWER_BRACKET.get(), "深色橡木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_OAK_FLOWER_BRACKET.get(), "橡木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_CHERRY_FLOWER_BRACKET.get(), "樱花木花牙子雀替");
            this.add(ChangShengJueBlocks.SHORT_SPRUCE_FLOWER_BRACKET.get(), "云杉木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_MANGROVE_BACK_BRACKET.get(), "红木回纹雀替");
            this.add(ChangShengJueBlocks.LONG_BIRCH_BACK_BRACKET.get(), "白桦木回纹雀替");
            this.add(ChangShengJueBlocks.LONG_JUNGLE_BACK_BRACKET.get(), "丛林木回纹雀替");
            this.add(ChangShengJueBlocks.LONG_CRIMSON_BACK_BRACKET.get(), "绯红木回纹雀替");
            this.add(ChangShengJueBlocks.LONG_WARPED_BACK_BRACKET.get(), "诡异木回纹雀替");
            this.add(ChangShengJueBlocks.LONG_ACACIA_BACK_BRACKET.get(), "金合欢回纹雀替");
            this.add(ChangShengJueBlocks.LONG_DARK_OAK_BACK_BRACKET.get(), "深色橡木回纹雀替");
            this.add(ChangShengJueBlocks.LONG_OAK_BACK_BRACKET.get(), "橡木回纹雀替");
            this.add(ChangShengJueBlocks.LONG_CHERRY_BACK_BRACKET.get(), "樱花木回纹雀替");
            this.add(ChangShengJueBlocks.LONG_SPRUCE_BACK_BRACKET.get(), "云杉木回纹雀替");
            this.add(ChangShengJueBlocks.LONG_MANGROVE_FLOWER_BRACKET.get(), "红木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_BIRCH_FLOWER_BRACKET.get(), "白桦木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_JUNGLE_FLOWER_BRACKET.get(), "丛林木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_CRIMSON_FLOWER_BRACKET.get(), "绯红木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_WARPED_FLOWER_BRACKET.get(), "诡异木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_ACACIA_FLOWER_BRACKET.get(), "金合欢花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_DARK_OAK_FLOWER_BRACKET.get(), "深色橡木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_OAK_FLOWER_BRACKET.get(), "橡木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_CHERRY_FLOWER_BRACKET.get(), "樱花木花牙子雀替");
            this.add(ChangShengJueBlocks.LONG_SPRUCE_FLOWER_BRACKET.get(), "云杉木花牙子雀替");
            this.add(ChangShengJueBlocks.MANGROVE_DOUGONG.get(), "红木斗拱");
            this.add(ChangShengJueBlocks.BIRCH_DOUGONG.get(), "白桦木斗拱");
            this.add(ChangShengJueBlocks.JUNGLE_DOUGONG.get(), "丛林木斗拱");
            this.add(ChangShengJueBlocks.CRIMSON_DOUGONG.get(), "绯红木斗拱");
            this.add(ChangShengJueBlocks.WARPED_DOUGONG.get(), "诡异木斗拱");
            this.add(ChangShengJueBlocks.ACACIA_DOUGONG.get(), "金合欢斗拱");
            this.add(ChangShengJueBlocks.DARK_OAK_DOUGONG.get(), "深色橡木斗拱");
            this.add(ChangShengJueBlocks.OAK_DOUGONG.get(), "橡木斗拱");
            this.add(ChangShengJueBlocks.CHERRY_DOUGONG.get(), "樱花木斗拱");
            this.add(ChangShengJueBlocks.SPRUCE_DOUGONG.get(), "云杉木斗拱");
            this.add(ChangShengJueBlocks.GREEN_DOUGONG.get(),"绿斗青拱");
            this.add(ChangShengJueBlocks.BLUE_DOUGONG.get(),"青斗绿拱");
    
    
            this.add(ChangShengJueBlocks.STONE_LAMPS_BASE_BLOCK.get(),"石灯底座");
            this.add(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get(),"未点亮的石灯");
            this.add(ChangShengJueBlocks.STONE_LAMPS_LIANG_BLOCK.get(),"石灯");
            this.add(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get(),"黄色石狮子");
            this.add(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get(),"灰色石狮子");
            this.add(ChangShengJueBlocks.BAI_HUA_FU_TI_BLOCK.get(),"白桦扶梯");
            this.add(ChangShengJueBlocks.YUN_SHAN_FU_TI_BLOCK.get(),"云杉扶梯");
    
            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE.get(),"灰色筒瓦块");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE.get(),"红色琉璃瓦块");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get(),"黑色筒瓦块");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get(),"金色琉璃瓦块");
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get(),"青色琉璃瓦块");
    
            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get(),"灰色筒瓦台阶");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get(),"红色琉璃瓦台阶");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get(),"黑色筒瓦台阶");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get(),"金色琉璃瓦台阶");
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get(),"青色琉璃瓦台阶");
    
            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.get(),"灰色侧向筒瓦");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.get(),"红色侧向琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.get(),"黑色侧向筒瓦");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.get(),"金色侧向琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.get(),"青色侧向琉璃瓦");
    
            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.get(),"灰色侧向飞檐");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.get(),"红色侧向飞檐");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.get(),"黑色侧向飞檐");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.get(),"金色侧向飞檐");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.get(),"青色侧向飞檐");
    
            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"灰色侧向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"红色侧向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"黑色侧向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"金色侧向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"青色侧向矮脊瓦(前)");
    
            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"灰色侧向矮脊瓦(后)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"红色侧向矮脊瓦(后)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"黑色侧向矮脊瓦(后)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"金色侧向矮脊瓦(后)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"青色侧向矮脊瓦(后)");
    
    
            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"灰色侧向高脊瓦(前)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"灰色侧向高脊瓦(前)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"灰色侧向高脊瓦(前)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"灰色侧向高脊瓦(前)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"灰色侧向高脊瓦(前)");
    
            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"灰色侧向高脊瓦(后)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"灰色侧向高脊瓦(后)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"灰色侧向高脊瓦(后)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"灰色侧向高脊瓦(后)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"灰色侧向高脊瓦(后)");
    
            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"灰色侧向双层脊瓦(前)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"红色侧向双层脊瓦(前)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"黑色侧向双层脊瓦(前)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"金色侧向双层脊瓦(前)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"青色侧向双层脊瓦(前)");
    
            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"灰色侧向双层脊瓦(后)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"红色侧向双层脊瓦(后)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"黑色侧向双层脊瓦(后)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"金色侧向双层脊瓦(后)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"青色侧向双层脊瓦(后)");
    
            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"灰色侧向脊瓦屋顶");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"红色侧向脊瓦屋顶");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"黑色侧向脊瓦屋顶");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"金色侧向脊瓦屋顶");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"青色侧向脊瓦屋顶");
    
            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get(),"灰色筒瓦");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get(),"红色琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get(),"黑色筒瓦");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get(),"金色琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get(),"青色琉璃瓦");
    
            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_1.get(),"灰色瓦当");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_1.get(),"红色瓦当");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_1.get(),"黑色瓦当");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_1.get(),"金色瓦当");
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_1.get(),"青色瓦当");
    
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_2.get(),"青色双层琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_2.get(),"灰色双层筒瓦");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_2.get(),"红色双层琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get(),"黑色双层筒瓦");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_2.get(),"金色双层琉璃瓦");
    
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_3.get(),"青色小鸱吻");
            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_3.get(),"灰色小鸱吻");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_3.get(),"红色小鸱吻");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_3.get(),"黑色小鸱吻");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_3.get(),"金色小鸱吻");
    
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_4.get(),"青色高脊瓦");
            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_4.get(),"灰色高脊瓦");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_4.get(),"红色高脊瓦");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_4.get(),"黑色高脊瓦");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_4.get(),"金色高脊瓦");
    
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_5.get(),"青色高琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_5.get(),"灰色高筒瓦");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_5.get(),"红色高琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_5.get(),"黑色高筒瓦");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_5.get(),"金色高琉璃瓦");
    
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_6.get(),"青色双层脊瓦");
            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_6.get(),"灰色双层脊瓦");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_6.get(),"红色双层脊瓦");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_6.get(),"黑色双层脊瓦");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_6.get(),"金色双层脊瓦");
    
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_7.get(),"青色飞檐琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_7.get(),"灰色飞檐筒瓦");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_7.get(),"红色飞檐琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_7.get(),"黑色飞檐筒瓦");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_7.get(),"金色飞檐琉璃瓦");
    
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_8.get(),"青色脊瓦");
            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_8.get(),"灰色脊瓦");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_8.get(),"红色脊瓦");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_8.get(),"黑色脊瓦");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_8.get(),"金色脊瓦");
    
            this.add(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get(),"青色双层脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get(),"灰色双层脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get(),"红色双层脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get(),"黑色双层脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get(),"金色双层脊兽脊瓦");
    
            this.add(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE_1.get(),"青色脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE_1.get(),"灰色脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE_1.get(),"红色脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE_1.get(),"黑色脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE_1.get(),"金色脊兽脊瓦");
    
            this.add(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.get(),"青色垂兽脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.get(),"灰色垂兽脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.get(),"红色垂兽脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.get(),"黑色垂兽脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.get(),"金色垂兽脊瓦");
    
            this.add(ChangShengJueBlocks.BLUE_ROOF_RIDGE.get(),"青色屋脊");
            this.add(ChangShengJueBlocks.GRE_ROOF_RIDGE.get(),"灰色屋脊");
            this.add(ChangShengJueBlocks.RED_ROOF_RIDGE.get(),"红色屋脊");
            this.add(ChangShengJueBlocks.BLACK_ROOF_RIDGE.get(),"黑色屋脊");
            this.add(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get(),"金色屋脊");
    
            this.add(ChangShengJueBlocks.BLUE_DEMON_MASK.get(), "青色鸱吻");
            this.add(ChangShengJueBlocks.GRE_DEMON_MASK.get(), "灰色鸱吻");
            this.add(ChangShengJueBlocks.RED_DEMON_MASK.get(), "红色鸱吻");
            this.add(ChangShengJueBlocks.BLACK_DEMON_MASK.get(), "黑色鸱吻");
            this.add(ChangShengJueBlocks.GOLDEN_DEMON_MASK.get(), "金色鸱吻");
    
            this.add(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.get(), "青色楼阁脊刹");
            this.add(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.get(), "灰色楼阁脊刹");
            this.add(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.get(), "红色楼阁脊刹");
            this.add(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.get(), "黑色楼阁脊刹");
            this.add(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.get(), "金色楼阁脊刹");
    
            this.add(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.get(), "青色字牌脊刹");
            this.add(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.get(), "灰色字牌脊刹");
            this.add(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.get(), "红色字牌脊刹");
            this.add(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.get(), "黑色字牌脊刹");
            this.add(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.get(), "金色字牌脊刹");
    
            this.add(ChangShengJueBlocks.BLUE_HIPPED_ROOF.get(), "青色攒尖");
            this.add(ChangShengJueBlocks.GRE_HIPPED_ROOF.get(), "灰色攒尖");
            this.add(ChangShengJueBlocks.RED_HIPPED_ROOF.get(), "红色攒尖");
            this.add(ChangShengJueBlocks.BLACK_HIPPED_ROOF.get(), "黑色攒尖");
            this.add(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.get(), "金色攒尖");
    
            this.add(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.get(), "青色齐瓦当");
            this.add(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.get(), "灰色齐瓦当");
            this.add(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.get(), "红色齐瓦当");
            this.add(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.get(), "黑色齐瓦当");
            this.add(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.get(), "金色齐瓦当");
    
            this.add(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "青色双层脊瓦");
            this.add(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "灰色双层脊瓦");
            this.add(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "红色双层脊瓦");
            this.add(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "黑色双层脊瓦");
            this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "金色双层脊瓦");
    
            this.add(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "青色双层垂兽脊瓦");
            this.add(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "灰色双层垂兽脊瓦");
            this.add(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "红色双层垂兽脊瓦");
            this.add(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "黑色双层垂兽脊瓦");
            this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "金色双层垂兽脊瓦");
    
            this.add(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE.get(), "青色短琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE.get(), "灰色短筒瓦");
            this.add(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE.get(), "红色短琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE.get(), "黑色短筒瓦");
            this.add(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE.get(), "金色短琉璃瓦");
    
            this.add(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.get(), "青色侧向双层琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.get(), "灰色侧向双层筒瓦");
            this.add(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.get(), "红色侧向双层琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.get(), "黑色侧向双层筒瓦");
            this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.get(), "金色侧向双层琉璃瓦");
    
            this.add(ChangShengJueBlocks.BLUE_HIGH_CYLINDER_TILE_SIDE.get(), "青色侧向高琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_HIGH_CYLINDER_TILE_SIDE.get(), "灰色侧向高筒瓦");
            this.add(ChangShengJueBlocks.RED_HIGH_CYLINDER_TILE_SIDE.get(), "红色侧向高琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_HIGH_CYLINDER_TILE_SIDE.get(), "黑色侧向高筒瓦");
            this.add(ChangShengJueBlocks.GOLDEN_HIGH_CYLINDER_TILE_SIDE.get(), "金色侧向高琉璃瓦");
    
            this.add(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE.get(), "青色侧向瓦当");
            this.add(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE.get(), "灰色侧向瓦当");
            this.add(ChangShengJueBlocks.RED_EAVES_TILE_SIDE.get(), "红色侧向瓦当");
            this.add(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE.get(), "黑色侧向瓦当");
            this.add(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE.get(), "金色侧向瓦当");
    
            this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK.get(), "金色瓦片");
            this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_1.get(), "金色瓦片");
            this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_2.get(), "金色瓦片");
            this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_3.get(), "金色瓦片");
            this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_4.get(), "金色瓦片");
    
            this.add(ChangShengJueBlocks.TILE_BLOCK.get(), "瓦片");
            this.add(ChangShengJueBlocks.TILE_BLOCK_1.get(), "瓦片");
            this.add(ChangShengJueBlocks.TILE_BLOCK_2.get(), "瓦片");
            this.add(ChangShengJueBlocks.TILE_BLOCK_3.get(), "瓦片");
            this.add(ChangShengJueBlocks.TILE_BLOCK_4.get(), "瓦片");
    
            this.add(ChangShengJueBlocks.BITUMEN_FLOOR_TILES_BLOCK.get(), "沥青地砖");
            this.add(ChangShengJueBlocks.BLUE_FLOOR_TILES_BLOCK.get(), "青石地砖");
            this.add(ChangShengJueBlocks.BLACK_FLOOR_TILES_BLOCK.get(), "黑石地砖");
    
            this.add(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK.get(), "白桦木窗户");
            this.add(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK_1.get(), "白桦木窗户");
            this.add(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK.get(), "金合欢窗户");
            this.add(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK_1.get(), "金合欢窗户");
            this.add(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK.get(), "深色橡木窗户");
            this.add(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK_1.get(), "深色橡木窗户");
            this.add(ChangShengJueBlocks.WINDOWS_OAK_BLOCK.get(), "橡木窗户");
            this.add(ChangShengJueBlocks.WINDOWS_OAK_BLOCK_1.get(), "橡木窗户");
            this.add(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK.get(), "云杉窗户");
            this.add(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK_1.get(), "云杉窗户");
    
            this.add(ChangShengJueBlocks.HIGH_BIRCH_WINDOWS.get(), "白桦木窗户");
            this.add(ChangShengJueBlocks.HIGH_ACACIA_WINDOWS.get(), "金合欢木窗户");
            this.add(ChangShengJueBlocks.HIGH_DARK_OAK_WINDOWS.get(), "深色橡木窗户");
            this.add(ChangShengJueBlocks.HIGH_OAK_WINDOWS.get(), "橡木窗户");
            this.add(ChangShengJueBlocks.HIGH_SPRUCE_WINDOWS.get(), "云杉木窗户");
    
            this.add(ChangShengJueBlocks.DOOR_BIRCH.get(), "白桦木门");
            this.add(ChangShengJueBlocks.DOOR_ACACIA.get(), "金合欢木门");
            this.add(ChangShengJueBlocks.DOOR_DARK_OAK.get(), "深色橡木门");
            this.add(ChangShengJueBlocks.DOOR_OAK.get(), "橡木门");
            this.add(ChangShengJueBlocks.DOOR_SPRUCE.get(), "云杉木门");
    
            this.add(ChangShengJueBlocks.MEI_REN_KAO_ACACIA_BLOCK.get(), "金合欢木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_DARK_OAK_BLOCK.get(), "深色橡木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_OAK_BLOCK.get(), "橡木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_SPRUCE_BLOCK.get(), "云杉木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_BIRCH_BLOCK.get(), "白桦木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_JUNGLE_BLOCK.get(), "丛林木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_MANGROVE_BLOCK.get(), "红树木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_CHERRY_BLOCK.get(), "樱花木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_CRIMSON_BLOCK.get(), "绯红木美人靠");
            this.add(ChangShengJueBlocks.MEI_REN_KAO_WARPED_BLOCK.get(), "诡异木美人靠");
    
    
    
            this.add(ChangShengJueBlocks.BIRCH_BENCH.get(), "白桦木长凳");
            this.add(ChangShengJueBlocks.CRIMSON_BENCH.get(), "绯红木长凳");
            this.add(ChangShengJueBlocks.WARPED_BENCH.get(), "诡异木长凳");
            this.add(ChangShengJueBlocks.MANGROVE_BENCH.get(), "红树长凳");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_BENCH.get(), "黄花梨长凳");
            this.add(ChangShengJueBlocks.JI_CHI_MU_BENCH.get(), "鸡翅木长凳");
            this.add(ChangShengJueBlocks.ACACIA_BENCH.get(), "金合欢木长凳");
            this.add(ChangShengJueBlocks.DARK_OAK_BENCH.get(), "深色橡木长凳");
            this.add(ChangShengJueBlocks.OAK_BENCH.get(), "橡木长凳");
            this.add(ChangShengJueBlocks.CHERRY_BENCH.get(), "樱花木长凳");
            this.add(ChangShengJueBlocks.SPRUCE_BENCH.get(), "云杉木长凳");
            this.add(ChangShengJueBlocks.ZI_TAN_BENCH.get(), "紫檀木长凳");
    
            this.add(ChangShengJueBlocks.BIRCH_DRINKING_TABLE_AND_CHAIRS.get(), "白桦木酒桌椅");
            this.add(ChangShengJueBlocks.CRIMSON_DRINKING_TABLE_AND_CHAIRS.get(), "绯红木酒桌椅");
            this.add(ChangShengJueBlocks.WARPED_DRINKING_TABLE_AND_CHAIRS.get(), "诡异木酒桌椅");
            this.add(ChangShengJueBlocks.MANGROVE_DRINKING_TABLE_AND_CHAIRS.get(), "红树酒桌椅");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_DRINKING_TABLE_AND_CHAIRS.get(), "黄花梨酒桌椅");
            this.add(ChangShengJueBlocks.JI_CHI_MU_DRINKING_TABLE_AND_CHAIRS.get(), "鸡翅木酒桌椅");
            this.add(ChangShengJueBlocks.ACACIA_DRINKING_TABLE_AND_CHAIRS.get(), "金合欢木酒桌椅");
            this.add(ChangShengJueBlocks.DARK_OAK_DRINKING_TABLE_AND_CHAIRS.get(), "深色橡木酒桌椅");
            this.add(ChangShengJueBlocks.OAK_DRINKING_TABLE_AND_CHAIRS.get(), "橡木酒桌椅");
            this.add(ChangShengJueBlocks.CHERRY_DRINKING_TABLE_AND_CHAIRS.get(), "樱花木酒桌椅");
            this.add(ChangShengJueBlocks.SPRUCE_DRINKING_TABLE_AND_CHAIRS.get(), "云杉木酒桌椅");
            this.add(ChangShengJueBlocks.ZI_TAN_DRINKING_TABLE_AND_CHAIRS.get(), "紫檀木酒桌椅");
    
            this.add(ChangShengJueBlocks.BIRCH_BOOK_DESK.get(), "白桦木书桌");
            this.add(ChangShengJueBlocks.CRIMSON_BOOK_DESK.get(), "绯红木书桌");
            this.add(ChangShengJueBlocks.WARPED_BOOK_DESK.get(), "诡异木书桌");
            this.add(ChangShengJueBlocks.MANGROVE_BOOK_DESK.get(), "红树书桌");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_DESK.get(), "黄花梨书桌");
            this.add(ChangShengJueBlocks.JI_CHI_MU_BOOK_DESK.get(), "鸡翅木书桌");
            this.add(ChangShengJueBlocks.ACACIA_BOOK_DESK.get(), "金合欢书桌");
            this.add(ChangShengJueBlocks.DARK_OAK_BOOK_DESK.get(), "深色橡木书桌");
            this.add(ChangShengJueBlocks.OAK_BOOK_DESK.get(), "橡木书桌");
            this.add(ChangShengJueBlocks.CHERRY_BOOK_DESK.get(), "樱花木书桌");
            this.add(ChangShengJueBlocks.SPRUCE_BOOK_DESK.get(), "云杉木书桌");
            this.add(ChangShengJueBlocks.ZI_TAN_BOOK_DESK.get(), "紫檀木书桌");
    
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get(), "黄花梨茶几");
            this.add(ChangShengJueBlocks.JI_CHI_MU_TEAPOY.get(), "鸡翅木茶几");
            this.add(ChangShengJueBlocks.ZI_TAN_TEAPOY.get(), "紫檀木茶几");
    
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR.get(), "黄花梨太师椅");
            this.add(ChangShengJueBlocks.JI_CHI_MU_TAISHI_CHAIR.get(), "鸡翅木太师椅");
            this.add(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR.get(), "紫檀木太师椅");
    
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE.get(), "黄花梨五围屏宝座");
            this.add(ChangShengJueBlocks.JI_CHI_MU_FIVE_SCREEN_THRONE.get(), "鸡翅木五围屏宝座");
            this.add(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE.get(), "紫檀木五围屏宝座");
    
            this.add(ChangShengJueBlocks.BIRCH_LOW_DESK.get(), "白桦木席桌");
            this.add(ChangShengJueBlocks.CRIMSON_LOW_DESK.get(), "绯红木席桌");
            this.add(ChangShengJueBlocks.WARPED_LOW_DESK.get(), "诡异木席桌");
            this.add(ChangShengJueBlocks.MANGROVE_LOW_DESK.get(), "红树席桌");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LOW_DESK.get(), "黄花梨席桌");
            this.add(ChangShengJueBlocks.JI_CHI_MU_LOW_DESK.get(), "鸡翅木席桌");
            this.add(ChangShengJueBlocks.ACACIA_LOW_DESK.get(), "金合欢席桌");
            this.add(ChangShengJueBlocks.DARK_OAK_LOW_DESK.get(), "深色橡木席桌");
            this.add(ChangShengJueBlocks.OAK_LOW_DESK.get(), "橡木席桌");
            this.add(ChangShengJueBlocks.CHERRY_LOW_DESK.get(), "樱花木席桌");
            this.add(ChangShengJueBlocks.SPRUCE_LOW_DESK.get(), "云杉木席桌");
            this.add(ChangShengJueBlocks.ZI_TAN_LOW_DESK.get(), "紫檀木席桌");
    
            this.add(ChangShengJueBlocks.ZAFU.get(), "蒲团");
    
            this.add(ChangShengJueBlocks.BIRCH_WINE_TABLE.get(), "白桦木酒桌");
            this.add(ChangShengJueBlocks.CRIMSON_WINE_TABLE.get(), "绯红木酒桌");
            this.add(ChangShengJueBlocks.WARPED_WINE_TABLE.get(), "诡异木酒桌");
            this.add(ChangShengJueBlocks.MANGROVE_WINE_TABLE.get(), "红树酒桌");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE.get(), "黄花梨酒桌");
            this.add(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE.get(), "鸡翅木酒桌");
            this.add(ChangShengJueBlocks.ACACIA_WINE_TABLE.get(), "金合欢酒桌");
            this.add(ChangShengJueBlocks.DARK_OAK_WINE_TABLE.get(), "深色橡木酒桌");
            this.add(ChangShengJueBlocks.OAK_WINE_TABLE.get(), "橡木酒桌");
            this.add(ChangShengJueBlocks.CHERRY_WINE_TABLE.get(), "樱花木酒桌");
            this.add(ChangShengJueBlocks.SPRUCE_WINE_TABLE.get(), "云杉木酒桌");
            this.add(ChangShengJueBlocks.ZI_TAN_WINE_TABLE.get(), "紫檀木酒桌");
    
            this.add(ChangShengJueBlocks.WHITE_JADE_BLOCK.get(),  "汉白玉块");
            this.add(ChangShengJueBlocks.WHITE_JADE_STAIRS.get(), "汉白玉楼梯");
            this.add(ChangShengJueBlocks.WHITE_JADE_SLAB.get(), "汉白玉台阶");
            this.add(ChangShengJueBlocks.WHITE_JADE_WALL.get(), "汉白玉墙");
            this.add(ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get(),"汉白玉栏杆");
            this.add(ChangShengJueBlocks.OAK_BALUSTRADE.get(),"橡木栏杆");
            this.add(ChangShengJueBlocks.SPRUCE_BALUSTRADE.get(), "云杉木栏杆");
            this.add(ChangShengJueBlocks.BIRCH_BALUSTRADE.get(), "白桦木栏杆");
            this.add(ChangShengJueBlocks.JUNGLE_BALUSTRADE.get(), "金合欢木栏杆");
            this.add(ChangShengJueBlocks.ACACIA_BALUSTRADE.get(), "金合欢木栏杆");
            this.add(ChangShengJueBlocks.MANGROVE_BALUSTRADE.get(), "红树栏杆");
            this.add(ChangShengJueBlocks.CHERRY_BALUSTRADE.get(), "樱花木栏杆");
            this.add(ChangShengJueBlocks.DARK_OAK_BALUSTRADE.get(), "深色橡木栏杆");
            this.add(ChangShengJueBlocks.CRIMSON_BALUSTRADE.get(), "绯红木栏杆");
            this.add(ChangShengJueBlocks.WARPED_BALUSTRADE.get(), "诡异木栏杆");
            this.add(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get(),"汉白玉护栏");
    
            this.add(ChangShengJueBlocks.AG_ORE.get(), "银矿石");
            this.add(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get(), "深层银矿石");
            this.add(ChangShengJueBlocks.KAOLIN_ORE.get(), "高岭土矿");
            this.add(ChangShengJueBlocks.LIMESTONE.get(), "石灰岩");
            this.add(ChangShengJueBlocks.SYDEROLIFE_ORE.get(), "陶土矿");
    
            this.add(ChangShengJueBlocks.CASTING_MOLDS.get(), "铜钱模具");
            this.add(ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get(), "元宝模具");
    
            this.add(ChangShengJueBlocks.PAINTING_SCROLL.get(), "画轴(1X1)");
            this.add(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get(), "画轴(1X2)");
            this.add(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get(), "画轴(2X1)");
            this.add(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get(), "画轴(2X2)");
    
            this.add(ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get(), "织布机");
            this.add(ChangShengJueBlocks.POTTERY_WHEEL.get(), "陶轮");
            this.add(ChangShengJueBlocks.TOOL_TABLE.get(), "工具台");
            this.add(ChangShengJueBlocks.WEAPON_RACK.get(), "武器架");
            this.add(ChangShengJueBlocks.DESK.get(), "案台");
            this.add(ChangShengJueBlocks.PIG_TROUGH.get(), "牲畜食槽");
    
            this.add(ChangShengJueBlocks.PLAQUE.get(), "牌匾");
            this.add(ChangShengJueBlocks.SHING_MUN_LEFT.get(), "小城门(左)");
            this.add(ChangShengJueBlocks.SHING_MUN_RIGHT.get(), "小城门(右)");
    
            this.add(ChangShengJueBlocks.BIG_SHING_MUN_LEFT.get(), "大城门(左)");
            this.add(ChangShengJueBlocks.BIG_SHING_MUN_RIGHT.get(), "大城门(右)");
            this.add(ChangShengJueBlocks.WIND_CHIME.get(), "风铃");
            this.add(ChangShengJueBlocks.TAILORING_CASE.get(), "裁衣案");
            this.add(ChangShengJueBlocks.FORGE_BLOCK.get(), "锻造炉");
            //实体生物
            this.add(ChangShengJueEntity.BUTTERFLY.get(), "蝴蝶");
            this.add(ChangShengJueEntity.MONKEY.get(), "猴");
            this.add(ChangShengJueEntity.DRAGONFLY.get(), "蜻蜓");
            this.add(ChangShengJueEntity.CICADA.get(), "蝉");
            this.add(ChangShengJueEntity.CRANE.get(), "鹤");
            this.add(ChangShengJueEntity.MALE_PEACOCK.get(), "孔雀");
            this.add(ChangShengJueEntity.FEMALE_PEACOCK.get(), "孔雀");
            this.add(ChangShengJueEntity.STAG.get(), "鹿");
            this.add(ChangShengJueEntity.HIND.get(), "鹿");
            this.add(ChangShengJueEntity.TIGER.get(), "老虎");
            this.add(ChangShengJueEntity.CROC.get(), "鳄鱼");
            this.add(ChangShengJueEntity.WARRIOR.get(), "武夫");
            this.add(ChangShengJueEntity.KILN_WORKER.get(), "营造主事");
            this.add(ChangShengJueEntity.MALE_INNKEEPER.get(), "酒馆男掌柜");
            this.add(ChangShengJueEntity.FEMALE_INNKEEPER.get(), "酒馆女掌柜");
            this.add(ChangShengJueEntity.CHALLENGER.get(), "挑战者");
            this.add(ChangShengJueEntity.BLACKSMITH.get(), "铁匠");
            this.add(ChangShengJueEntity.LANCE_GANG_LEADER.get(), "帮派首领");
            this.add(ChangShengJueEntity.KNIFE_GANG_LEADER.get(), "帮派首领");
            this.add(ChangShengJueEntity.SWORD_GANG_LEADER.get(), "帮派首领");
            this.add(ChangShengJueEntity.CLUBBED_GANG_LEADER.get(), "帮派首领");
            this.add(ChangShengJueEntity.GANG_LEADER.get(), "帮派首领");
            this.add(ChangShengJueEntity.BANDIT.get(), "强盗");
            this.add(ChangShengJueEntity.VILLAIN.get(), "恶徒");
            this.add(ChangShengJueEntity.ASSASSIN.get(), "帮派杀手");
            this.add(ChangShengJueEntity.CLUBBED_MING_XIA.get(), "棍王董大侠");
            this.add(ChangShengJueEntity.SWORD_MING_XIA.get(), "剑仙张大侠");
            this.add(ChangShengJueEntity.KNIFE_MING_XIA.get(), "刀圣徐大侠");
            this.add(ChangShengJueEntity.FIST_MING_XIA.get(), "北拳萧大侠");
            this.add(ChangShengJueEntity.PIGLIN_WU_XIA.get(), "功夫猪灵");
            this.add(ChangShengJueEntity.WITCH_WU_XIA.get(), "功夫女巫");
            this.add(ChangShengJueEntity.EVOKER_WU_XIA.get(), "功夫唤魔者");
            this.add(ChangShengJueEntity.VINDICATOR_WU_XIA.get(), "功夫卫道士");
            this.add(ChangShengJueEntity.PILLAGER_WU_XIA.get(), "功夫掠夺者");
    
            this.add(ChangShengJueEntity.STAKES.get(), "练功木桩");
            this.add(ChangShengJueEntity.GE_SHAN_DA_NIU.get(), "隔山打牛");
            this.add(ChangShengJueEntity.PEACOCK_EGG.get(), "孔雀蛋");
            this.add(ChangShengJueEntity.THROWING_KNIVES_ENTITY.get(), "飞刀");
            this.add(ChangShengJueEntity.BA_WANG_QIANG.get(), "霸王枪");
            this.add(ChangShengJueEntity.RED_TASSELLED_SPEAR.get(), "红缨枪");
            // 村民职业
            this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_farmer", "农民");
            this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_potter", "窑工");
            this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_hunter", "猎人");
            this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_chief", "村长");
            this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_seamstress", "缝工");
    
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_farmer", "农民");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_potter", "窑工");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_hunter", "猎人");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_chief", "村长");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_seamstress", "缝工");
    
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager", "Villager");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.none", "Villager");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.villager", "Villager");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.armorer", "Armorer");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.butcher", "Butcher");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.cartographer", "制图师");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.cleric", "Cleric");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.farmer", "Farmer");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.fisherman", "Fisherman");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.fletcher", "Fletcher");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.leatherworker", "Leatherworker");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.librarian", "Librarian");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.mason", "Mason");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.nitwit", "Nitwit");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.shepherd", "Shepherd");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.toolsmith", "Toolsmith");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.weaponsmith", "Weaponsmith");
    
            //buff
            this.add(ChangShengJueEffects.BLEED_EFFECT.get(), "流血");
            this.add(ChangShengJueEffects.DIZZY_EFFECT.get(), "眩晕");
            this.add(ChangShengJueEffects.AIRBORNE_EFFECT.get(), "挑飞");
            this.add(ChangShengJueEffects.FIXATION_EFFECT.get(), "定身");
    //        this.add(ChangShengJueEffects.GOLDEN_BELL_JAR_EFFECT.get(), "金钟罩");
            this.add(ChangShengJueEffects.TURTLE_BREATH_EFFECT.get(), "龟息");
            this.add(ChangShengJueEffects.TRAUMA_EFFECT.get(), "外伤");
            this.add(ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get(), "内伤");
            this.add(ChangShengJueEffects.BILUOCHUN_TEAS.get(), "碧螺春");
            this.add(ChangShengJueEffects.LONG_JING_TEAS.get(), "龙井");
            this.add(ChangShengJueEffects.FEN_JIU.get(), "汾酒");
            this.add(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get(), "麦块贡酒");
            this.add(ChangShengJueEffects.SHI_LI_XIANG.get(), "十里香");
            this.add(ChangShengJueEffects.DRUNKEN.get(), "醉酒");
            this.add(ChangShengJueEffects.VILLAGER_CHARM_EFFECT.get(), "持续提高村民声望");
            this.add(ChangShengJueEffects.INSTANT_CHARM_EFFECT.get(), "瞬间提高村民声望");
            this.add(ChangShengJueEffects.INSTANT_DISFAVOR_EFFECT.get(), "瞬间降低村民声望");
    
            //群系
            this.add("biome."+ ChangShengJue.MOD_ID +".chang_shen_jue_prairie", "慕然草原");
    
            //存储
            this.add("container.hercules", "大力神功");
    
            /*信息*/
            //死亡信息
            this.add("death.attack." + CSJDamageTypes.BLEED.location().getPath(), "%1$s失血过多。");
            this.add("death.attack." + CSJDamageTypes.MARTIAL_ARTS.location().getPath(), "%1$s被%2$s使用武功震碎了内脏。");
            this.add("death.attack." + CSJDamageTypes.TRAUMA.location().getPath(), "%1$s的伤势过重。");
            //配置文件信息
            this.add("config."+ ChangShengJue.MOD_ID +".reload", "配置已重新加载");
            this.add("config."+ ChangShengJue.MOD_ID +".enable_quests", "是否启用自动接受类型任务。");
            this.add("config."+ ChangShengJue.MOD_ID +".spirit_recovery_amount", "自然恢复的灵气值。");
            this.add("config."+ ChangShengJue.MOD_ID +".spirit_recovery_interval", "灵气自然恢复间隔(游戏刻)。");
            this.add("config."+ ChangShengJue.MOD_ID +".spirit_root_ju_qi_efficiency", "化神期后灵根数量影响聚气效率");
    
            this.add("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_level", "独孤九剑最大等级上限");
            this.add("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_exp", "独孤九剑突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_cooldown", "独孤九剑最大冷却时间");
    
            this.add("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_level", "高家枪法最大等级上限");
            this.add("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_exp", "高家枪法突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_cooldown", "高家枪法最大冷却时间");
    
            this.add("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_level", "隔山打牛最大等级上限");
            this.add("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_exp", "隔山打牛突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_cooldown", "隔山打牛最大冷却时间");
    
            this.add("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_level", "金乌刀法最大等级上限");
            this.add("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_exp", "金乌刀法突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_cooldown", "金乌刀法最大冷却时间");
    
            this.add("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_level", "少林棍法最大等级上限");
            this.add("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_exp", "少林棍法突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_cooldown", "少林棍法最大冷却时间");
    
            this.add("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_level", "葵花点穴手最大等级上限");
            this.add("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_exp", "葵花点穴手突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_cooldown", "葵花点穴手最大冷却时间");
    
            this.add("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_level", "龟息功最大等级上限");
            this.add("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_exp", "龟息功突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_cooldown", "龟息功最大冷却时间");
    
            this.add("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_level", "玄女剑法最大等级上限");
            this.add("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_exp", "玄女剑法突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_cooldown", "玄女剑法最大冷却时间");
    
            this.add("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_level", "无情飞刀最大等级上限");
            this.add("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_exp", "无情飞刀突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_cooldown", "无情飞刀最大冷却时间");
            this.add("config."+ ChangShengJue.MOD_ID +".flying_dagger_pouch_max_slots", "飞刀囊中最大可放入的飞刀数量");
    
            this.add("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_level", "金钟罩最大等级上限");
            this.add("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_exp", "金钟罩突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_cooldown", "金钟罩最大冷却时间");
    
            this.add("config."+ ChangShengJue.MOD_ID +".hercules_max_exp", "大力神功突破所需的移动距离");
    
            this.add("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_level", "不死神功最大等级上限");
            this.add("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_exp", "不死神功突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_cooldown", "不死神功最大冷却时间");
    
            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_level", "乾坤大挪移最大等级上限");
            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_exp", "乾坤大挪移突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_cooldown", "乾坤大挪移最大冷却时间");
            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_probability", "乾坤大挪移每次反弹伤害的概率");
            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_extra_probability", "乾坤大挪移大成后每点血量增加反弹伤害的概率");
            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_multiplier", "乾坤大挪移反弹伤害的倍率");
            this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_tick", "乾坤大挪移每次反弹伤害需要的时间");
            this.add("config."+ ChangShengJue.MOD_ID +".qian_kun_da_nuo_yi_max_cooldown_extra_tick", "乾坤大挪移每次释放后增加的冷却恢复到默认冷却的时间");
    
            this.add("config."+ ChangShengJue.MOD_ID +".the_classics_of_tendon_changing_max_exp", "易筋经突破所需的成功释放次数");
    
            this.add("config."+ ChangShengJue.MOD_ID +".paoding_max_exp", "庖丁解牛突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".paoding_additional_drops_count", "庖丁解牛杀死生物时额外掉落肉的数量");
    
            this.add("config."+ ChangShengJue.MOD_ID +".wu_gang_cut_gui_max_exp", "吴刚伐桂突破所需的成功释放次数");
    
            this.add("config."+ ChangShengJue.MOD_ID +".yugong_moves_mountains_max_exp", "愚公移山突破所需的成功释放次数");
            this.add("config."+ ChangShengJue.MOD_ID +".yugong_moves_mountains_excavation_range", "愚公移山的挖掘范围");
    
            this.add("config."+ ChangShengJue.MOD_ID +".zhang_men_xin_xue_max_exp", "张门心学突破所需的交易成功次数");
            this.add("config."+ ChangShengJue.MOD_ID +".zhang_men_xin_xue_extra_probability", "张门心学大成后交易不消耗物品的概率");
    
            this.add("config."+ ChangShengJue.MOD_ID +".tun_na_particle", "是否显示吐纳粒子");
            this.add("config."+ ChangShengJue.MOD_ID +".breakthrough_particle", "是否显示突破粒子");
            //普通信息
            this.add("block.changshengjue.fen_jiu.no_wine","已经没有酒了！");
            this.add("tooltip.changshengjue.natural_silk", "通过挖掘桑叶获得");
    
            //进度
            // 一级进度
            this.add("advancement." + ChangShengJue.MOD_ID + ".begin", "长生诀");
            this.add("advancement." + ChangShengJue.MOD_ID + ".begin.desc", "大千世界，无奇不有");
    
            // 二级进度
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasmifan", "人是铁饭是钢");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasmifan.desc", "人靠饭，铁靠钢，一顿不吃饿得慌。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".hassilverbullions", "银华熠熠");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hassilverbullions.desc", "银子久了虽会变黑，但他内在还是银光闪烁的。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasbronzesword", "侠客行");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasbronzesword.desc", "所谓侠客者，就是不畏强权，敢于为正义事业而奋斗，以保护弱者、扶持正义为己任，无私奉献，不计较个人得失。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".findchinesevillage", "新生活！");
            this.add("advancement." + ChangShengJue.MOD_ID + ".findchinesevillage.desc", "大江南北，江山如画！");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".accessguildtask", "帮会？");
            this.add("advancement." + ChangShengJue.MOD_ID + ".accessguildtask.desc", "且看小爷我叱咤风云，搅动天下！");
    
            // 三级进度
            this.add("advancement." + ChangShengJue.MOD_ID + ".haslichee", "妃子笑");
            this.add("advancement." + ChangShengJue.MOD_ID + ".haslichee.desc", "一骑红尘妃子笑，无人知是荔枝来。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".hastomatoegg", "家常小炒");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hastomatoegg.desc", "每个人都能做，做的味道也常不一样的家常小炒。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".hastea", "习习清风生");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hastea.desc", "自神农尝百草，饮茶解毒，饮茶的历史源远流长。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".haswine", "对酒当歌，人生几何？");
            this.add("advancement." + ChangShengJue.MOD_ID + ".haswine.desc", "譬如朝露，去日苦多。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasgoldbullions", "金光闪闪");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasgoldbullions.desc", "是金子，放在哪里都闪光！");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".usewaigong", "趁手兵器");
            this.add("advancement." + ChangShengJue.MOD_ID + ".usewaigong.desc", "一把趁手剑，潇洒走天涯。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasarmor", "布衣侠客");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasarmor.desc", "甲虽简陋，当心如坚石。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".learngongfa", "初学乍练");
            this.add("advancement." + ChangShengJue.MOD_ID + ".learngongfa.desc", "若一遇挫折便松散懈怠，日后怎成大器？");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".makechinaware", "做瓷器");
            this.add("advancement." + ChangShengJue.MOD_ID + ".makechinaware.desc", "china，china，china！");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".finishtask", "善恶谁定？");
            this.add("advancement." + ChangShengJue.MOD_ID + ".finishtask.desc", "要多读书，才不会被人骗。要多看历史，才能明辨是非。");
    
            // 四级进度
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasbabaozhu", "吉祥如意");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasbabaozhu.desc", "健脾养胃，消滞减肥，益气安神。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasguihuatangou", "甜蜜蜜");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasguihuatangou.desc", "希望你的人生能一直甜蜜下去或者接下去是甜蜜的展开。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".hassword", "绝世神兵");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hassword.desc", "武林至尊，宝刀屠龙，号令天下，莫敢不从！");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasadvancedarrmor", "将门之后");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasadvancedarrmor.desc", "甲虽坚固，莫埋于灰尘。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".mastergongfa", "融会贯通");
            this.add("advancement." + ChangShengJue.MOD_ID + ".mastergongfa.desc", "成就虽存，然需知道人外有人，天外有天。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".donefivetask", "有求必应");
            this.add("advancement." + ChangShengJue.MOD_ID + ".donefivetask.desc", "要懂得拒绝人，马桶是通不完的。");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".agroupgangtoken", "扛把子");
            this.add("advancement." + ChangShengJue.MOD_ID + ".agroupgangtoken.desc", "我扛的不是铜锣湾，是天下！天下苍生！");
    
            //五级进度
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasqitian", "未竟");
            this.add("advancement." + ChangShengJue.MOD_ID + ".hasqitian.desc", "齐天大圣在何处？长生之路又在何处？未来在何处？");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".gongfadone", "一代宗师");
            this.add("advancement." + ChangShengJue.MOD_ID + ".gongfadone.desc", "人有情欲，剑没有，武功没有。紫禁之巅，谁能与我争高低？");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".donefinaltask", "隐世大侠");
            this.add("advancement." + ChangShengJue.MOD_ID + ".donefinaltask.desc", "既是有情有欲人，天地不平心何甘？");
    
            this.add("advancement." + ChangShengJue.MOD_ID + ".beatleader", "头把交椅");
            this.add("advancement." + ChangShengJue.MOD_ID + ".beatleader.desc", "这木头座位总比那个剑刃做的舒适，不扎屁股。");
    
            //按钮
            this.add("quest."+ ChangShengJue.MOD_ID +".gre_button", "灰");
            this.add("quest."+ ChangShengJue.MOD_ID +".red_button", "红");
            this.add("quest."+ ChangShengJue.MOD_ID +".black_button", "黑");
            this.add("quest."+ ChangShengJue.MOD_ID +".blue_button", "青");
            this.add("quest."+ ChangShengJue.MOD_ID +".golden_button", "金");
    
            //任务
            this.add("quest."+ ChangShengJue.MOD_ID +".button", "任务");
            this.add("quest."+ ChangShengJue.MOD_ID +".requirements", "任务需求:");
            this.add("quest."+ ChangShengJue.MOD_ID +".rewards", "任务奖励:");
            this.add("quest."+ ChangShengJue.MOD_ID +".submit.button", "提交任务");
            this.add("quest."+ ChangShengJue.MOD_ID +".accept.button", "接受任务");
            this.add("quest."+ ChangShengJue.MOD_ID +".abandon.button", "放弃任务");
            this.add("quest."+ ChangShengJue.MOD_ID +".flushed.button", "刷新任务");
            this.add("quest."+ ChangShengJue.MOD_ID +".requirements.prompt", "任务需求不足!");
            this.add("quest."+ ChangShengJue.MOD_ID +".finish", "§a%s任务完成！");
            this.add("quest."+ ChangShengJue.MOD_ID +".trigger", "§a触发%s任务");
            this.add("quest."+ ChangShengJue.MOD_ID +".fail", "§a%s任务失败！");
    
            this.add("quest."+ ChangShengJue.MOD_ID +".food.questName", "收集食物");
            this.add("quest."+ ChangShengJue.MOD_ID +".food.questDescription", "首领：兄弟们的吃食又不够了，总不能饿肚子吧，兄弟你去想想办法。");
            this.add("quest."+ ChangShengJue.MOD_ID +".money.questName", "收集钱款");
            this.add("quest."+ ChangShengJue.MOD_ID +".money.questDescription", "首领：这年头什么都要花钱，一文钱难倒英雄汉，兄弟能筹点帮费吗？");
    
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questName", "踢馆");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questDescription", "首领：可恶！这是今年第二个趁我病期来踢馆的了，欺我帮派无人，你去回敬下吧！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questRequirementsDescription", "击杀任意帮派首领");
    
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questName", "侠客行");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questDescription", "首领：灾厄巡逻队总是与我们发生冲突，不知死活！做掉他们！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questRequirementsDescription", "击杀掠夺者");
    
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questName", "杀鸡儆猴");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questDescription", "首领：这群刁民真是有够胆大的，去收帮费的人拒了我们几波，你去给他们点颜色看看！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questRequirementsDescription", "击杀任意村民");
    
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questName", "投名状");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questDescription", "首领：这位兄弟，想入我们帮派，你需要先纳投名状！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questRequirementsDescription", "击杀任意人型生物");
    
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questName", "挑战");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questDescription", "首领：有兄弟听说你武功高强，想和你较量一番，你意下如何？");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questRequirementsDescription", "击败或者击杀前来的挑战者");
    
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia.questName", "天下第一");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_1.questDescription", "首领：虽说现在天下第一是棍王董大侠，但以兄台的实力也能与其一争啊！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_2.questDescription", "首领：虽说现在天下第一是刀圣徐大侠，但以兄台的实力也能与其一争啊！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_3.questDescription", "首领：虽说现在天下第一是北拳萧大侠，但以兄台的实力也能与其一争啊！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_4.questDescription", "首领：虽说现在天下第一是剑仙张大侠，但以兄台的实力也能与其一争啊！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia.questRequirementsDescription", "击杀四大名侠之一");
    
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questName", "保护村庄");
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questDescription", "首领：我们帮派名下的村庄被入侵了，快去保护咱们的粮仓！");
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questRequirementsDescription", "在袭击中胜利");
    
            this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questName", "救民侠医");
            this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questDescription", "首领：附近的村庄被僵尸袭击，好多村民变成了僵尸村民，听说兄弟你会些医术，去看看吧？");
            this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questRequirementsDescription", "救治一名僵尸村民");
    
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questName", "斋饭");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questDescription", "首领：心念慈悲，不犯杀戒。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questRequirementsDescription", "2个游戏日内不杀死生物");
    
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questName", "行侠仗义");
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questDescription", "附近一村庄被乌泱泱的僵尸入侵了，君愿舍身以助吗？");
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questRequirementsDescription", "留在村庄内协助村民抵御僵尸");
    
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questName", "田园侠客");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questDescription", "因为有你，这里的村民没人敢欺负，你也在这里安居乐业。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questRequirementsDescription", "偶遇村民");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questName", "快意恩仇");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questDescription", "冤仇若不分明报，枉做人间大丈夫。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questRequirementsDescription", "击败攻击你的敌人");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questName", "为民除害");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questDescription", "这一大虫总拿村民当食吃，大侠小心！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questRequirementsDescription", "击杀1只老虎");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questName", "除暴安良");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questDescription", "村长：村里有一恶人到处抢掠，大侠可能帮帮我们？！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questRequirementsDescription", "击杀1个恶徒");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questName", "武侠");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questDescription", "路见不平，拔刀相助，才堪侠客。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questRequirementsDescription", "夜间村庄内击杀1只僵尸");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questName", "杀人越货");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questDescription", "你即以财宝显漏，就别怪我了下手狠了！嘿嘿嘿...");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questRequirementsDescription", "击杀1个流浪商人");
            this.add("quest."+ ChangShengJue.MOD_ID +".gather.food.questName", "大额交易");
            this.add("quest."+ ChangShengJue.MOD_ID +".gather.food.questDescription", "村长：最近庄稼减收冬天怕是不好过了，大侠可以帮我们收集些食物度过难关吗？");
            this.add("quest."+ ChangShengJue.MOD_ID +".gather.money.questName", "大额交易");
            this.add("quest."+ ChangShengJue.MOD_ID +".gather.money.questDescription", "村长：这次真是大丰收！但是如此多粮食放久了会坏，大侠你能帮我们想想办法吗？");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questName", "任我行");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questDescription", "海阔天空，何处不容人。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questRequirementsDescription", "7天内死亡次数小于1");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questName", "锄强扶弱");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questDescription", "村民不光要面对僵尸的袭击，竟还有帮派的威胁！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questRequirementsDescription", "击杀3个强盗");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questName", "江湖追杀令");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questDescription", "你帮助村庄对抗帮派，各大势力都以你武林公敌的借口对你进行了追杀！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questRequirementsDescription", "杀死袭击你的人");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombies.questName", "傲气天地间");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombies.questDescription", "我有百般力，何向弱者使？天地不平，我自平之！虽百人，有所可惧，智勇以对。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombies.questRequirementsDescription", "击杀100只僵尸");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questName", "天若有情天亦老");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questDescription", "人间正道是沧桑。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questRequirementsDescription", "完成两次江湖追杀令");
    
            //裁衣案"container.tailoring_case.json"
            this.add("container."+ ChangShengJue.MOD_ID +".tailoring_case", "裁衣案");
            this.add("gui."+ ChangShengJue.MOD_ID + ".tailoring_case.craft", "裁衣");
            //锻台“forgeblock”
            this.add("container."+ ChangShengJue.MOD_ID +".forge_block", "锻台");
            this.add("gui."+ ChangShengJue.MOD_ID + ".forge_block.craft", "锻造");
    
        }
    }
