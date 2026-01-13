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
            this.add(ChangShengJueItems.SILKWORM.get(),"蚕");
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
            this.add(ChangShengJueItems.CYAN_BRICKS.get(), "青砖");
            this.add(ChangShengJueItems.WHITE_BRICKS_ITEM.get(), "白砖");
            this.add(ChangShengJueItems.GOLD_BRICKS.get(), "金砖");

            this.add(ChangShengJueItems.SYDEROLIFE_BALL.get(), "陶土球");
            this.add(ChangShengJueItems.KAOLIN_BALL.get(), "高岭土球");
            this.add(ChangShengJueItems.NATURAL_ASPHALT.get(), "天然沥青");

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
            this.add(ChangShengJueItems.EXTERNAL_KUNG_FU_XP.get(), "外功经验+5");
            this.add(ChangShengJueItems.INTERNAL_KUNG_FU_XP.get(), "内功经验+5");

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
            this.add(ChangShengJueItems.LONG_YUAN_SWORD.get(),"龙渊剑");
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
            this.add(ChangShengJueItems.CONFUCIAN_HELMET.get(), "宝缁撮");
            this.add(ChangShengJueItems.CONFUCIAN_INK_CHESTPLATE.get(), "公子宽袍");
            this.add(ChangShengJueItems.CONFUCIAN_INK_LEGGINGS.get(), "丝执裤");
            this.add(ChangShengJueItems.CONFUCIAN_INK_BOOTS.get(), "轻丝履");

            this.add(ChangShengJueItems.CONSTABLE_UNIFORM_HELMET.get(), "玄纹束发冠");
            this.add(ChangShengJueItems.CONSTABLE_UNIFORM_CHESTPLATE.get(), "云纹暗绣氅衣");
            this.add(ChangShengJueItems.CONSTABLE_UNIFORM_LEGGINGS.get(), "蟒纹缀穗下裳");
            this.add(ChangShengJueItems.CONSTABLE_UNIFORM_BOOTS.get(), "玄革踏云靴");

            this.add(ChangShengJueItems.HATS_WITH_VEIL_HELMET.get(), "垂纱斗笠");
            this.add(ChangShengJueItems.HATS_WITH_VEIL_CHESTPLATE.get(), "素雅长裙");

            this.add(ChangShengJueItems.HATS_BLACK_ROBE_HELMET.get(), "竹斗笠");
            this.add(ChangShengJueItems.HATS_BLACK_ROBE_CHESTPLATE.get(), "玄衣");
            this.add(ChangShengJueItems.HATS_BLACK_ROBE_LEGGINGS.get(), "玄衣下裳");

            this.add(ChangShengJueItems.DUAN_DA_CHESTPLATE.get(), "短打上衣");

            this.add(ChangShengJueItems.BUDDHIST_ROBE_CHESTPLATE.get(), "念珠僧袍");

            this.add(ChangShengJueItems.NIGHT_SUIT_HELMET.get(), "蒙面头巾");
            this.add(ChangShengJueItems.NIGHT_SUIT_CHESTPLATE.get(), "夜行衣");

            this.add(ChangShengJueItems.LONG_GOWN_CHESTPLATE.get(), "窄袖长衫");
            this.add(ChangShengJueItems.NIGHT_SUIT_LEGGINGS.get(), "丝绸绑腿");

            this.add(ChangShengJueItems.FOREHEAD_BAND_HELMET1.get(), "额头链");
            this.add(ChangShengJueItems.FOREHEAD_BAND_HELMET2.get(), "红玉金抹额");
            this.add(ChangShengJueItems.HAIR_CROWN_HELMET1.get(), "雪银束发冠");
            this.add(ChangShengJueItems.HAIR_CROWN_HELMET2.get(), "红玉束发冠");

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
                    "未大成前施展效果:主手持菜刀杀死动物有50%%概率额外掉落肉\\n大成后施展效果:主手持菜刀杀死动物有75%%概率额外掉落肉\\n成功施展%s次后武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.HERCULES.get()+".tooltip","以气御力，神力无穷。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.HERCULES.get()+".hold_shift.tooltip",
                    "未大成前施展效果:减少疾跑消耗的饱食度降低至60%%\\n大成后施展效果:主手持金丝手套右键可打开末影箱\\n移动大于%s米后武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()+".tooltip","指如疾风，势如闪电。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()+".hold_shift.tooltip",
                    "未大成前施展效果:定住血量上限低于25点的目标1.5秒\\n大成后施展效果:定住血量上限低于200点的目标2秒\\n成功施展%s次后武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BELL_JAR.get()+".tooltip","刀枪不入，浑然一金钟。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BELL_JAR.get()+".hold_shift.tooltip",
                    "未大成前施展效果:提高4点护甲,受到伤害时会获得3级的伤害吸收\\n大成后施展效果:提高8点护甲,受到伤害时伤害吸收的效果提高到5级\\n成功施展%s次后武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.ZHANG_MEN_XIN_XUE.get()+".tooltip","江湖不是打打杀杀，那是人情世故!");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.ZHANG_MEN_XIN_XUE.get()+".hold_shift.tooltip",
                    "未大成前施展效果:与村民的交易一次即可将村民等级提升至学徒\\n大成后施展效果:额外有10%%概率不消耗物品交易\\n与村民交易%s次后武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.IMMORTAL_MIRACLE.get()+".tooltip","不死不灭，岂是幻梦?");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.IMMORTAL_MIRACLE.get()+".hold_shift.tooltip",
                    "未大成前施展效果:在濒死时抵御一次致命伤害\\n大成后施展效果:减少15秒冷却时间\\n成功施展%s次后武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GE_SHAN_DA_NIU.get()+".tooltip","神功盖世，何欺牛儿?");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GE_SHAN_DA_NIU.get()+".hold_shift.tooltip",
                    "未大成前施展效果:无视方块阻拦施展外功造成22点伤害\\n大成后施展效果:攻击伤害范围提高2格\\n成功施展%s次后武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get()+".tooltip","学向勤中得，萤窗万卷书。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get()+".hold_shift.tooltip",
                    "未大成前施展效果:每次交易有25%%概率获得5点经验\\n大成后施展效果:每次交易有35%%概率获得10点经验\\n经验到达30级后武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TURTLE_BREATH_WORK.get()+".tooltip","龟虽有鼻，而息之以耳。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TURTLE_BREATH_WORK.get()+".hold_shift.tooltip",
                    "未大成前施展效果:施展后一段时间内可以水下屏息更久，不会被动物主动攻击\\n大成后施展效果:提高屏息效果\\n成功施展%s次后武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get()+".tooltip","武林中人梦寐以求的武学宝典。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get()+".hold_shift.tooltip",
                    "未大成前施展效果:释放武功需要的饥饿度减少1点\\n大成后施展效果:释放武功需要的饥饿度与饱和度各减少1点\\n成功施展%s次后武功大成");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()+".tooltip","激发潜力，牵引挪移，其中变化莫测，匪夷所思。");
            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()+".hold_shift.tooltip",
                    "未大成前施展效果:有35%%概率将遭受的攻击伤害于1.0秒后以1.5倍反弹给攻击者\\n大成后施展效果:每多1点血量额外提高2%%触发概率\\n每施展1次冷却时间短期内延长2秒\\n成功施展%s次后武功大成");

            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.external_kunfu", "习得%s,可使用使用%s长按鼠标右键蓄力%s秒后施展武功!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.external_kunfu_glove", "习得%s,可使用%s长按鼠标右键蓄力%s秒后施展武功!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.internal_kungfu", "习得%s!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.studied.kungfu", "%s已阅览过,%s!");

            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.external_kunfu", "%s已阅览,使用%s攻击目标来实战领悟吧!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.external_kunfu_glove", "%s已阅览,还需用空手或%s攻击木桩来操练领悟吧!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.internal_kungfu", "%s已阅览,还需用%s攻击木桩来操练领悟吧!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.light_kungfu", "%s已阅览,还需%s来领悟!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.mental_kungfu", "%s已阅览,还需%s来领悟!");
            this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.dacheng.kungfu", "%s神功大成!");

            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".swords.type", "剑");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".softsword.type", "软剑");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".clubbed.type", "棍");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".glove.type", "拳套");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".knife.type", "刀");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".lance.type", "枪");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".throwingknives.type", "飞刀");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".hand_and_glove.type", "空手或手套");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".run_and_jump.type", "奔跑或跳跃");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".mental_kungfu.type", "跟生物交互");

            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu.true.comprehend", "且已习得!可使用%s长按鼠标右键蓄力%s秒后施展武功");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu.fales.comprehend", "还需用%s攻击目标来实战领悟!");

            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu.true.comprehend", "且已习得!");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu.fales.comprehend", "还需用%s攻击木桩来操练领悟!");

            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".light_kungfu.fales.comprehend", "还需%s来领悟!");

            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".mental_kungfu.fales.comprehend", "还需%s来领悟!");

            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".state_change.kungfu", "%s : %s");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.open", "启动,还需用空手或%s攻击木桩来操练领悟!");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu_glove.open", "启动,还需用空手攻击木桩来操练领悟!");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.comprehend.open", "启动,可使用%s长按鼠标右键蓄力%s秒后施展武功");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu_glove.comprehend.open", "启动,大成后可使用%s来施展武功!");
            this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.off", "关闭");

            this.add("message." + ChangShengJue.MOD_ID + ".dagger_pouch.empty", "§c没有武器了");

            this.add("message." + ChangShengJue.MOD_ID + ".install_patchouli_for_guide", "提示：您可以安装帕秋莉手册(Patchouli)模组来获取长生诀模组的游戏引导书《五方汇录》");

            this.add("tooltip." + ChangShengJue.MOD_ID + ".dagger_pouch.count","飞刀囊容量 %s / %s");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".flying_dagger_pouch.right_click.tooltip","在背包内拿起并右键飞刀可将飞刀放入飞刀囊中");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".throwing_knives.right_click.tooltip","在背包内拿起并右键飞刀囊可将飞刀放入飞刀囊中");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".durability","耐久 %s / %s");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".dagger_pouch.contents","飞刀囊内的物品");

            this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DURIAN.get()+".tooltip","请使用斧子劈开");
            this.add("tooltip."+ChangShengJue.MOD_ID+".hold_shift.tooltip","按下 §eShift§r 查看更多信息");

            this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data","已内衬");
            this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.lining","此铠甲不可内衬");
            this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.lining1","请使用胸甲内衬");
            this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.unload","已从装备中卸下");
            this.add("tooltip." + ChangShengJue.MOD_ID + ".dyeing","可染色");

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

            this.add("sounds."+ChangShengJue.MOD_ID + ".taxation_sound", "铸币税");

            this.add("sounds."+ChangShengJue.MOD_ID + ".stakes_hit_sound", "练功木桩 : 被击打");

            //方块
            this.add(ChangShengJueItems.STAKES.get(),"练功木桩");
            this.add(ChangShengJueBlocks.GONG.get(),"锣");

            this.add(ChangShengJueBlocks.CANTALOUPE_BLOCK.get(),"哈密瓜");
            this.add(ChangShengJueBlocks.WILDLIFE_HORDEUM.get(),"野生大麦");

            this.add(ChangShengJueBlocks.MANGO_LOG.get(),"芒果树原木");
            this.add(ChangShengJueBlocks.MANGO_WOOD.get(),"芒果树木");
            this.add(ChangShengJueBlocks.STRIPPED_MANGO_LOG.get(),"去皮芒果树原木");
            this.add(ChangShengJueBlocks.STRIPPED_MANGO_WOOD.get(),"去皮芒果树木");
            this.add(ChangShengJueBlocks.MANGO_PLANKS.get(),"芒果树木板");
            this.add(ChangShengJueBlocks.MANGO_LEAVES.get(),"芒果树树叶");
            this.add(ChangShengJueBlocks.MANGO_SAPLING.get(),"芒果树树苗");

            this.add(ChangShengJueBlocks.BANANA_LOG.get(),"香蕉原木");
            this.add(ChangShengJueBlocks.BANANA_LEAVES.get(),"香蕉树叶");
            this.add(ChangShengJueBlocks.BANANA_SAPLING.get(),"香蕉树苗");
            this.add(ChangShengJueBlocks.BANANA_FRUIT.get(),"香蕉");

            this.add(ChangShengJueBlocks.PEAR_LOG.get(),"梨树原木");
            this.add(ChangShengJueBlocks.PEAR_WOOD.get(),"梨树木");
            this.add(ChangShengJueBlocks.STRIPPED_PEAR_LOG.get(),"去皮梨树原木");
            this.add(ChangShengJueBlocks.STRIPPED_PEAR_WOOD.get(),"去皮梨树木");
            this.add(ChangShengJueBlocks.PEAR_PLANKS.get(),"梨树木板");
            this.add(ChangShengJueBlocks.PEAR_LEAVES.get(),"梨树树叶");
            this.add(ChangShengJueBlocks.PEAR_SAPLING.get(),"梨树树苗");

            this.add(ChangShengJueBlocks.LICHEE_LOG.get(),"荔枝树原木");
            this.add(ChangShengJueBlocks.LICHEE_WOOD.get(),"荔枝树木");
            this.add(ChangShengJueBlocks.STRIPPED_LICHEE_LOG.get(),"去皮荔枝树原木");
            this.add(ChangShengJueBlocks.STRIPPED_LICHEE_WOOD.get(),"去皮荔枝树");
            this.add(ChangShengJueBlocks.LICHEE_PLANKS.get(),"荔枝树木板");
            this.add(ChangShengJueBlocks.LICHEE_LEAVES.get(),"荔枝树树叶");
            this.add(ChangShengJueBlocks.LICHEE_SAPLING.get(),"荔枝树树苗");

            this.add(ChangShengJueBlocks.DURIAN_LOG.get(),"榴莲树原木");
            this.add(ChangShengJueBlocks.DURIAN_WOOD.get(),"榴莲树木");
            this.add(ChangShengJueBlocks.STRIPPED_DURIAN_LOG.get(),"去皮榴莲树原木");
            this.add(ChangShengJueBlocks.STRIPPED_DURIAN_WOOD.get(),"去皮榴莲树木");
            this.add(ChangShengJueBlocks.DURIAN_PLANKS.get(),"榴莲树木板");
            this.add(ChangShengJueBlocks.DURIAN_LEAVES.get(),"榴莲树树叶");
            this.add(ChangShengJueBlocks.DURIAN_SAPLING.get(),"榴莲树树苗");

            this.add(ChangShengJueBlocks.OSMANTHUS_LOG.get(),"桂花树原木");
            this.add(ChangShengJueBlocks.OSMANTHUS_WOOD.get(),"桂花树木");
            this.add(ChangShengJueBlocks.STRIPPED_OSMANTHUS_LOG.get(),"去皮桂花树原木");
            this.add(ChangShengJueBlocks.STRIPPED_OSMANTHUS_WOOD.get(),"去皮桂花树木");
            this.add(ChangShengJueBlocks.OSMANTHUS_PLANKS.get(),"桂花树木板");
            this.add(ChangShengJueBlocks.OSMANTHUS_LEAVES.get(),"桂花树树叶");
            this.add(ChangShengJueBlocks.OSMANTHUS_SAPLING.get(),"桂花树树苗");
            this.add(ChangShengJueBlocks.OSMANTHUS_DEFOLIATION.get(),"桂花树落叶");

            this.add(ChangShengJueBlocks.PLUM_LOG.get(),"梅花树原木");
            this.add(ChangShengJueBlocks.PLUM_WOOD.get(),"梅花树木");
            this.add(ChangShengJueBlocks.STRIPPED_PLUM_LOG.get(),"去皮梅花树原木");
            this.add(ChangShengJueBlocks.STRIPPED_PLUM_WOOD.get(),"去皮梅花树木");
            this.add(ChangShengJueBlocks.PLUM_PLANKS.get(),"梅花树木板");
            this.add(ChangShengJueBlocks.PLUM_LEAVES.get(),"梅花树树叶");
            this.add(ChangShengJueBlocks.PLUM_SAPLING.get(),"梅花树树苗");
            this.add(ChangShengJueBlocks.PLUM_DEFOLIATION.get(),"梅花树落叶");

            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get(),"黄花梨原木");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_WOOD.get(),"黄花梨木");
            this.add(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get(),"去皮黄花梨原木");
            this.add(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_WOOD.get(),"去皮黄花梨木");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LEAVES.get(),"黄花梨树叶");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_SAPLING.get(),"黄花梨树苗");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get(),"黄花梨木板");

            this.add(ChangShengJueBlocks.WENGE_LOG.get(),"鸡翅木原木");
            this.add(ChangShengJueBlocks.WENGE_WOOD.get(),"鸡翅木");
            this.add(ChangShengJueBlocks.STRIPPED_WENGE_LOG.get(),"去皮鸡翅木原木");
            this.add(ChangShengJueBlocks.STRIPPED_WENGE_WOOD.get(),"去皮鸡翅木");
            this.add(ChangShengJueBlocks.WENGE_LEAVES.get(),"鸡翅木树叶");
            this.add(ChangShengJueBlocks.WENGE_SAPLING.get(),"鸡翅木树苗");
            this.add(ChangShengJueBlocks.WENGE_PLANKS.get(),"鸡翅木木板");

            this.add(ChangShengJueBlocks.ZI_TAN_LOG.get(),"紫檀原木");
            this.add(ChangShengJueBlocks.ZI_TAN_WOOD.get(),"紫檀木");
            this.add(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get(),"去皮紫檀原木");
            this.add(ChangShengJueBlocks.STRIPPED_ZI_TAN_WOOD.get(),"去皮紫檀木");
            this.add(ChangShengJueBlocks.ZI_TAN_LEAVES.get(),"紫檀树树叶");
            this.add(ChangShengJueBlocks.ZI_TAN_SAPLING.get(),"紫檀树树苗");
            this.add(ChangShengJueBlocks.ZI_TAN_PLANKS.get(),"紫檀木板");

            this.add(ChangShengJueBlocks.POPLAR_LOG.get(),"白杨树原木");
            this.add(ChangShengJueBlocks.POPLAR_WOOD.get(),"白杨树木");
            this.add(ChangShengJueBlocks.STRIPPED_POPLAR_LOG.get(),"去皮白杨树原木");
            this.add(ChangShengJueBlocks.STRIPPED_POPLAR_WOOD.get(),"去皮白杨树木");
            this.add(ChangShengJueBlocks.POPLAR_PLANKS.get(),"白杨树木板");
            this.add(ChangShengJueBlocks.POPLAR_LEAVES.get(),"白杨树树叶");
            this.add(ChangShengJueBlocks.POPLAR_SAPLING.get(),"白杨树树苗");
            this.add(ChangShengJueBlocks.POPLAR_DEFOLIATION.get(),"白杨树落叶");

            this.add(ChangShengJueBlocks.MULBERRY_LOG.get(),"桑树原木");
            this.add(ChangShengJueBlocks.MULBERRY_WOOD.get(),"桑树木");
            this.add(ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get(),"去皮桑树原木");
            this.add(ChangShengJueBlocks.STRIPPED_MULBERRY_WOOD.get(),"去皮桑树木");
            this.add(ChangShengJueBlocks.MULBERRY_PLANKS.get(),"桑树木板");
            this.add(ChangShengJueBlocks.MULBERRY_LEAVES.get(),"桑树树叶");
            this.add(ChangShengJueBlocks.MULBERRY_LEAVES_FRUITS.get(),"有蚕的桑叶");
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

            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get(),"灰色琉璃瓦块");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get(),"红色琉璃瓦块");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get(),"黑色琉璃瓦块");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get(),"金色琉璃瓦块");
            this.add(ChangShengJueBlocks.CYAN_CYLINDER_TILE_BLOCK.get(),"青色琉璃瓦块");
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get(),"蓝色琉璃瓦块");
            this.add(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_BLOCK.get(),"紫色琉璃瓦块");

            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get(),"灰色琉璃瓦半砖");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get(),"红色琉璃瓦半砖");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get(),"黑色琉璃瓦半砖");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get(),"金色琉璃瓦半砖");
            this.add(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SLAB.get(),"青色琉璃瓦半砖");
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get(),"蓝色琉璃瓦半砖");
            this.add(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SLAB.get(),"紫色琉璃瓦半砖");

            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.get(),"灰色侧向琉璃瓦");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.get(),"红色侧向琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.get(),"黑色侧向琉璃瓦");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.get(),"金色侧向琉璃瓦");
            this.add(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SIDE.get(),"青色侧向琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.get(),"蓝色侧向琉璃瓦");
            this.add(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SIDE.get(),"紫色侧向琉璃瓦");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.get(),"灰色侧向飞檐");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.get(),"红色侧向飞檐");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.get(),"黑色侧向飞檐");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.get(),"金色侧向飞檐");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_UPTURNED_EAVES.get(),"青色侧向飞檐");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.get(),"蓝色侧向飞檐");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_UPTURNED_EAVES.get(),"紫色侧向飞檐");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"灰色侧向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"红色侧向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"黑色侧向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"金色侧向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"青色侧向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"蓝色侧向矮脊瓦(前)");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"紫色侧向矮脊瓦(前)");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"灰色侧向矮脊瓦(后)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"红色侧向矮脊瓦(后)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"黑色侧向矮脊瓦(后)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"金色侧向矮脊瓦(后)");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"青色侧向矮脊瓦(后)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"蓝色侧向矮脊瓦(后)");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"紫色侧向矮脊瓦(后)");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"灰色侧向高脊瓦(前)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"红色侧向高脊瓦(前)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"黑色侧向高脊瓦(前)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"金色侧向高脊瓦(前)");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"青色侧向高脊瓦(前)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"蓝色侧向高脊瓦(前)");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"紫色侧向高脊瓦(前)");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"灰色侧向高脊瓦(后)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"红色侧向高脊瓦(后)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"黑色侧向高脊瓦(后)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"金色侧向高脊瓦(后)");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"青色侧向高脊瓦(后)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"蓝色侧向高脊瓦(后)");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"紫色侧向高脊瓦(后)");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"灰色侧向双层脊瓦(前)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"红色侧向双层脊瓦(前)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"黑色侧向双层脊瓦(前)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"金色侧向双层脊瓦(前)");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"青色侧向双层脊瓦(前)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"蓝色侧向双层脊瓦(前)");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"紫色侧向双层脊瓦(前)");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"灰色侧向双层脊瓦(后)");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"红色侧向双层脊瓦(后)");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"黑色侧向双层脊瓦(后)");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"金色侧向双层脊瓦(后)");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"青色侧向双层脊瓦(后)");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"蓝色侧向双层脊瓦(后)");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"紫色侧向双层脊瓦(后)");

            this.add(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"灰色侧向脊瓦屋顶");
            this.add(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"红色侧向脊瓦屋顶");
            this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"黑色侧向脊瓦屋顶");
            this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"金色侧向脊瓦屋顶");
            this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"青色侧向脊瓦屋顶");
            this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"蓝色侧向脊瓦屋顶");
            this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"紫色侧向脊瓦屋顶");

            this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE.get(),"灰色琉璃瓦");
            this.add(ChangShengJueBlocks.RED_CYLINDER_TILE.get(),"红色琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get(),"黑色琉璃瓦");
            this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get(),"金色琉璃瓦");
            this.add(ChangShengJueBlocks.CYAN_CYLINDER_TILE.get(),"青色琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get(),"蓝色琉璃瓦");
            this.add(ChangShengJueBlocks.PURPLE_CYLINDER_TILE.get(),"紫色琉璃瓦");

            this.add(ChangShengJueBlocks.GRE_EAVES_TILE.get(),"灰色瓦当");
            this.add(ChangShengJueBlocks.RED_EAVES_TILE.get(),"红色瓦当");
            this.add(ChangShengJueBlocks.BLACK_EAVES_TILE.get(),"黑色瓦当");
            this.add(ChangShengJueBlocks.GOLDEN_EAVES_TILE.get(),"金色瓦当");
            this.add(ChangShengJueBlocks.CYAN_EAVES_TILE.get(),"青色瓦当");
            this.add(ChangShengJueBlocks.BLUE_EAVES_TILE.get(),"蓝色瓦当");
            this.add(ChangShengJueBlocks.PURPLE_EAVES_TILE.get(),"紫色瓦当");

            this.add(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE.get(),"青色双层琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE.get(),"灰色双层琉璃瓦");
            this.add(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE.get(),"红色双层琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE.get(),"黑色双层琉璃瓦");
            this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE.get(),"金色双层琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE.get(),"蓝色双层琉璃瓦");
            this.add(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE.get(),"紫色双层琉璃瓦");

            this.add(ChangShengJueBlocks.CYAN_SMALL_DEMON_MASK.get(),"青色小鸱吻");
            this.add(ChangShengJueBlocks.GRE_SMALL_DEMON_MASK.get(),"灰色小鸱吻");
            this.add(ChangShengJueBlocks.RED_SMALL_DEMON_MASK.get(),"红色小鸱吻");
            this.add(ChangShengJueBlocks.BLACK_SMALL_DEMON_MASK.get(),"黑色小鸱吻");
            this.add(ChangShengJueBlocks.GOLDEN_SMALL_DEMON_MASK.get(),"金色小鸱吻");
            this.add(ChangShengJueBlocks.BLUE_SMALL_DEMON_MASK.get(),"蓝色小鸱吻");
            this.add(ChangShengJueBlocks.PURPLE_SMALL_DEMON_MASK.get(),"紫色小鸱吻");

            this.add(ChangShengJueBlocks.CYAN_RIDGE_TILE.get(),"青色脊瓦");
            this.add(ChangShengJueBlocks.GRE_RIDGE_TILE.get(),"灰色脊瓦");
            this.add(ChangShengJueBlocks.RED_RIDGE_TILE.get(),"红色脊瓦");
            this.add(ChangShengJueBlocks.BLACK_RIDGE_TILE.get(),"黑色脊瓦");
            this.add(ChangShengJueBlocks.GOLDEN_RIDGE_TILE.get(),"金色脊瓦");
            this.add(ChangShengJueBlocks.BLUE_RIDGE_TILE.get(),"蓝色脊瓦");
            this.add(ChangShengJueBlocks.PURPLE_RIDGE_TILE.get(),"紫色脊瓦");

            this.add(ChangShengJueBlocks.CYAN_DOUBLE_RIDGE_TILE.get(),"青色双层脊瓦");
            this.add(ChangShengJueBlocks.GRE_DOUBLE_RIDGE_TILE.get(),"灰色双层脊瓦");
            this.add(ChangShengJueBlocks.RED_DOUBLE_RIDGE_TILE.get(),"红色双层脊瓦");
            this.add(ChangShengJueBlocks.BLACK_DOUBLE_RIDGE_TILE.get(),"黑色双层脊瓦");
            this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_RIDGE_TILE.get(),"金色双层脊瓦");
            this.add(ChangShengJueBlocks.BLUE_DOUBLE_RIDGE_TILE.get(),"蓝色双层脊瓦");
            this.add(ChangShengJueBlocks.PURPLE_DOUBLE_RIDGE_TILE.get(),"紫色双层脊瓦");

            this.add(ChangShengJueBlocks.CYAN_EAVES_CYLINDER_TILE.get(),"青色飞檐琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_EAVES_CYLINDER_TILE.get(),"灰色飞檐琉璃瓦");
            this.add(ChangShengJueBlocks.RED_EAVES_CYLINDER_TILE.get(),"红色飞檐琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_EAVES_CYLINDER_TILE.get(),"黑色飞檐琉璃瓦");
            this.add(ChangShengJueBlocks.GOLDEN_EAVES_CYLINDER_TILE.get(),"金色飞檐琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_EAVES_CYLINDER_TILE.get(),"蓝色飞檐琉璃瓦");
            this.add(ChangShengJueBlocks.PURPLE_EAVES_CYLINDER_TILE.get(),"紫色飞檐琉璃瓦");

            this.add(ChangShengJueBlocks.ANIMALS_CYAN_RIDGE_TILE.get(),"青色脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get(),"灰色脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get(),"红色脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get(),"黑色脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get(),"金色脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get(),"蓝色脊兽脊瓦");
            this.add(ChangShengJueBlocks.ANIMALS_PURPLE_RIDGE_TILE.get(),"紫色脊兽脊瓦");

            this.add(ChangShengJueBlocks.HANGING_BEAST_CYAN_RIDGE_TILE.get(),"青色垂兽脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.get(),"灰色垂兽脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.get(),"红色垂兽脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.get(),"黑色垂兽脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.get(),"金色垂兽脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.get(),"蓝色垂兽脊瓦");
            this.add(ChangShengJueBlocks.HANGING_BEAST_PURPLE_RIDGE_TILE.get(),"紫色垂兽脊瓦");

            this.add(ChangShengJueBlocks.CYAN_ROOF_RIDGE.get(),"青色屋脊");
            this.add(ChangShengJueBlocks.GRE_ROOF_RIDGE.get(),"灰色屋脊");
            this.add(ChangShengJueBlocks.RED_ROOF_RIDGE.get(),"红色屋脊");
            this.add(ChangShengJueBlocks.BLACK_ROOF_RIDGE.get(),"黑色屋脊");
            this.add(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get(),"金色屋脊");
            this.add(ChangShengJueBlocks.BLUE_ROOF_RIDGE.get(),"蓝色屋脊");
            this.add(ChangShengJueBlocks.PURPLE_ROOF_RIDGE.get(),"紫色屋脊");

            this.add(ChangShengJueBlocks.CYAN_DEMON_MASK.get(), "青色鸱吻");
            this.add(ChangShengJueBlocks.GRE_DEMON_MASK.get(), "灰色鸱吻");
            this.add(ChangShengJueBlocks.RED_DEMON_MASK.get(), "红色鸱吻");
            this.add(ChangShengJueBlocks.BLACK_DEMON_MASK.get(), "黑色鸱吻");
            this.add(ChangShengJueBlocks.GOLDEN_DEMON_MASK.get(), "金色鸱吻");
            this.add(ChangShengJueBlocks.BLUE_DEMON_MASK.get(), "蓝色鸱吻");
            this.add(ChangShengJueBlocks.PURPLE_DEMON_MASK.get(), "紫色鸱吻");

            this.add(ChangShengJueBlocks.CYAN_RIDGE_FINIAL_PAVILION.get(), "青色楼阁脊刹");
            this.add(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.get(), "灰色楼阁脊刹");
            this.add(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.get(), "红色楼阁脊刹");
            this.add(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.get(), "黑色楼阁脊刹");
            this.add(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.get(), "金色楼阁脊刹");
            this.add(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.get(), "蓝色楼阁脊刹");
            this.add(ChangShengJueBlocks.PURPLE_RIDGE_FINIAL_PAVILION.get(), "紫色楼阁脊刹");

            this.add(ChangShengJueBlocks.CYAN_CHARACTER_PLAQUE_PAVILION.get(), "青色字牌脊刹");
            this.add(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.get(), "灰色字牌脊刹");
            this.add(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.get(), "红色字牌脊刹");
            this.add(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.get(), "黑色字牌脊刹");
            this.add(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.get(), "金色字牌脊刹");
            this.add(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.get(), "蓝色字牌脊刹");
            this.add(ChangShengJueBlocks.PURPLE_CHARACTER_PLAQUE_PAVILION.get(), "紫色字牌脊刹");

            this.add(ChangShengJueBlocks.CYAN_HIPPED_ROOF.get(), "青色攒尖");
            this.add(ChangShengJueBlocks.GRE_HIPPED_ROOF.get(), "灰色攒尖");
            this.add(ChangShengJueBlocks.RED_HIPPED_ROOF.get(), "红色攒尖");
            this.add(ChangShengJueBlocks.BLACK_HIPPED_ROOF.get(), "黑色攒尖");
            this.add(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.get(), "金色攒尖");
            this.add(ChangShengJueBlocks.BLUE_HIPPED_ROOF.get(), "蓝色攒尖");
            this.add(ChangShengJueBlocks.PURPLE_HIPPED_ROOF.get(), "紫色攒尖");

            this.add(ChangShengJueBlocks.CYAN_GABLE_RIDGE_CYLINDER_TILE.get(), "青色齐瓦当");
            this.add(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.get(), "灰色齐瓦当");
            this.add(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.get(), "红色齐瓦当");
            this.add(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.get(), "黑色齐瓦当");
            this.add(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.get(), "金色齐瓦当");
            this.add(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.get(), "蓝色齐瓦当");
            this.add(ChangShengJueBlocks.PURPLE_GABLE_RIDGE_CYLINDER_TILE.get(), "紫色齐瓦当");

            this.add(ChangShengJueBlocks.CYAN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "青色双层脊瓦");
            this.add(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "灰色双层脊瓦");
            this.add(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "红色双层脊瓦");
            this.add(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "黑色双层脊瓦");
            this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "金色双层脊瓦");
            this.add(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "蓝色双层脊瓦");
            this.add(ChangShengJueBlocks.PURPLE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "紫色双层脊瓦");

            this.add(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "蓝色双层垂兽脊瓦");
            this.add(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "灰色双层垂兽脊瓦");
            this.add(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "红色双层垂兽脊瓦");
            this.add(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "黑色双层垂兽脊瓦");
            this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "金色双层垂兽脊瓦");
            this.add(ChangShengJueBlocks.CYAN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "青色双层垂兽脊瓦");
            this.add(ChangShengJueBlocks.PURPLE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), "紫色双层垂兽脊瓦");

            this.add(ChangShengJueBlocks.CYAN_SHORT_CYLINDER_TILE.get(), "青色短琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE.get(), "灰色短琉璃瓦");
            this.add(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE.get(), "红色短琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE.get(), "黑色短琉璃瓦");
            this.add(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE.get(), "金色短琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE.get(), "蓝色短琉璃瓦");
            this.add(ChangShengJueBlocks.PURPLE_SHORT_CYLINDER_TILE.get(), "紫色短琉璃瓦");

            this.add(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE_SIDE.get(), "青色侧向双层琉璃瓦");
            this.add(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.get(), "灰色侧向双层琉璃瓦");
            this.add(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.get(), "红色侧向双层琉璃瓦");
            this.add(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.get(), "黑色侧向双层琉璃瓦");
            this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.get(), "金色侧向双层琉璃瓦");
            this.add(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.get(), "蓝色侧向双层琉璃瓦");
            this.add(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE_SIDE.get(), "紫色侧向双层琉璃瓦");

            this.add(ChangShengJueBlocks.CYAN_EAVES_TILE_SIDE.get(), "青色侧向瓦当");
            this.add(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE.get(), "灰色侧向瓦当");
            this.add(ChangShengJueBlocks.RED_EAVES_TILE_SIDE.get(), "红色侧向瓦当");
            this.add(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE.get(), "黑色侧向瓦当");
            this.add(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE.get(), "金色侧向瓦当");
            this.add(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE.get(), "蓝色侧向瓦当");
            this.add(ChangShengJueBlocks.PURPLE_EAVES_TILE_SIDE.get(), "紫色侧向瓦当");

            this.add(ChangShengJueBlocks.GOLDEN_TILE.get(), "金色瓦");
            this.add(ChangShengJueBlocks.GOLDEN_GENTLE_TILE.get(), "金色平缓瓦");
            this.add(ChangShengJueBlocks.GOLDEN_CORNICES.get(), "金色飞檐瓦");
            this.add(ChangShengJueBlocks.GOLDEN_GENTLE_CORNICES.get(), "金色平缓飞檐瓦");
            this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_2.get(), "金色瓦");
            this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_3.get(), "金色瓦");
            this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_4.get(), "金色瓦");

            this.add(ChangShengJueBlocks.BLACK_TILE.get(), "瓦");
            this.add(ChangShengJueBlocks.BLACK_GENTLE_TILE.get(), "平缓瓦");
            this.add(ChangShengJueBlocks.BLACK_CORNICES.get(), "飞檐瓦");
            this.add(ChangShengJueBlocks.BLACK_GENTLE_CORNICES.get(), "平缓飞檐瓦");
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
            this.add(ChangShengJueBlocks.JUNGLE_BENCH.get(), "丛林木长凳");
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
            this.add(ChangShengJueBlocks.JUNGLE_DRINKING_TABLE_AND_CHAIRS.get(), "丛林木酒桌椅");
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
            this.add(ChangShengJueBlocks.JUNGLE_BOOK_DESK.get(), "丛林木书桌");
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

            this.add(ChangShengJueBlocks.BIRCH_TEAPOY.get(), "白桦木茶几");
            this.add(ChangShengJueBlocks.JUNGLE_TEAPOY.get(), "丛林木茶几");
            this.add(ChangShengJueBlocks.CRIMSON_TEAPOY.get(), "绯红木茶几");
            this.add(ChangShengJueBlocks.WARPED_TEAPOY.get(), "诡异木茶几");
            this.add(ChangShengJueBlocks.MANGROVE_TEAPOY.get(), "红木茶几");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get(), "黄花梨茶几");
            this.add(ChangShengJueBlocks.WENGE_TEAPOY.get(), "鸡翅木茶几");
            this.add(ChangShengJueBlocks.ACACIA_TEAPOY.get(), "金合欢茶几");
            this.add(ChangShengJueBlocks.DARK_OAK_TEAPOY.get(), "深色橡木茶几");
            this.add(ChangShengJueBlocks.OAK_TEAPOY.get(), "橡木茶几");
            this.add(ChangShengJueBlocks.CHERRY_TEAPOY.get(), "樱花木茶几");
            this.add(ChangShengJueBlocks.SPRUCE_TEAPOY.get(), "云杉木茶几");
            this.add(ChangShengJueBlocks.ZI_TAN_TEAPOY.get(), "紫檀木茶几");

            this.add(ChangShengJueBlocks.BIRCH_TAISHI_CHAIR.get(), "白桦木太师椅");
            this.add(ChangShengJueBlocks.JUNGLE_TAISHI_CHAIR.get(), "丛林木太师椅");
            this.add(ChangShengJueBlocks.CRIMSON_TAISHI_CHAIR.get(), "绯红木太师椅");
            this.add(ChangShengJueBlocks.WARPED_TAISHI_CHAIR.get(), "诡异木太师椅");
            this.add(ChangShengJueBlocks.MANGROVE_TAISHI_CHAIR.get(), "红木太师椅");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR.get(), "黄花梨太师椅");
            this.add(ChangShengJueBlocks.WENGE_TAISHI_CHAIR.get(), "鸡翅木太师椅");
            this.add(ChangShengJueBlocks.ACACIA_TAISHI_CHAIR.get(), "金合欢太师椅");
            this.add(ChangShengJueBlocks.DARK_OAK_TAISHI_CHAIR.get(), "深色橡木太师椅");
            this.add(ChangShengJueBlocks.OAK_TAISHI_CHAIR.get(), "橡木太师椅");
            this.add(ChangShengJueBlocks.CHERRY_TAISHI_CHAIR.get(), "樱花木太师椅");
            this.add(ChangShengJueBlocks.SPRUCE_TAISHI_CHAIR.get(), "云杉木太师椅");
            this.add(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR.get(), "紫檀木太师椅");

            this.add(ChangShengJueBlocks.BIRCH_FIVE_SCREEN_THRONE.get(), "白桦木五围屏宝座");
            this.add(ChangShengJueBlocks.JUNGLE_FIVE_SCREEN_THRONE.get(), "丛林木五围屏宝座");
            this.add(ChangShengJueBlocks.CRIMSON_FIVE_SCREEN_THRONE.get(), "绯红木五围屏宝座");
            this.add(ChangShengJueBlocks.WARPED_FIVE_SCREEN_THRONE.get(), "诡异木五围屏宝座");
            this.add(ChangShengJueBlocks.MANGROVE_FIVE_SCREEN_THRONE.get(), "红木五围屏宝座");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE.get(), "黄花梨五围屏宝座");
            this.add(ChangShengJueBlocks.WENGE_FIVE_SCREEN_THRONE.get(), "鸡翅木五围屏宝座");
            this.add(ChangShengJueBlocks.ACACIA_FIVE_SCREEN_THRONE.get(), "金合欢五围屏宝座");
            this.add(ChangShengJueBlocks.DARK_OAK_FIVE_SCREEN_THRONE.get(), "深色橡木五围屏宝座");
            this.add(ChangShengJueBlocks.OAK_FIVE_SCREEN_THRONE.get(), "橡木五围屏宝座");
            this.add(ChangShengJueBlocks.CHERRY_FIVE_SCREEN_THRONE.get(), "樱花木五围屏宝座");
            this.add(ChangShengJueBlocks.SPRUCE_FIVE_SCREEN_THRONE.get(), "云杉木五围屏宝座");
            this.add(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE.get(), "紫檀木五围屏宝座");

            this.add(ChangShengJueBlocks.BIRCH_LOW_DESK.get(), "白桦木席桌");
            this.add(ChangShengJueBlocks.JUNGLE_LOW_DESK.get(), "丛林木席桌");
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

            this.add(ChangShengJueBlocks.BIRCH_SQUARE_STOOL.get(), "白桦木方凳");
            this.add(ChangShengJueBlocks.JUNGLE_SQUARE_STOOL.get(), "丛林木方凳");
            this.add(ChangShengJueBlocks.CRIMSON_SQUARE_STOOL.get(), "绯红木方凳");
            this.add(ChangShengJueBlocks.WARPED_SQUARE_STOOL.get(), "诡异木方凳");
            this.add(ChangShengJueBlocks.MANGROVE_SQUARE_STOOL.get(), "红木方凳");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_SQUARE_STOOL.get(), "黄花梨方凳");
            this.add(ChangShengJueBlocks.WENGE_SQUARE_STOOL.get(), "鸡翅木方凳");
            this.add(ChangShengJueBlocks.ACACIA_SQUARE_STOOL.get(), "金合欢方凳");
            this.add(ChangShengJueBlocks.DARK_OAK_SQUARE_STOOL.get(), "深色橡木方凳");
            this.add(ChangShengJueBlocks.OAK_SQUARE_STOOL.get(), "橡木方凳");
            this.add(ChangShengJueBlocks.CHERRY_SQUARE_STOOL.get(), "樱花木方凳");
            this.add(ChangShengJueBlocks.SPRUCE_SQUARE_STOOL.get(), "云杉木方凳");
            this.add(ChangShengJueBlocks.ZI_TAN_SQUARE_STOOL.get(), "紫檀木方凳");

            this.add(ChangShengJueBlocks.BIRCH_FRETWORK_OPENWORK_PANEL.get(), "白桦木回纹亮格");
            this.add(ChangShengJueBlocks.JUNGLE_FRETWORK_OPENWORK_PANEL.get(), "丛林木回纹亮格");
            this.add(ChangShengJueBlocks.CRIMSON_FRETWORK_OPENWORK_PANEL.get(), "绯红木回纹亮格");
            this.add(ChangShengJueBlocks.WARPED_FRETWORK_OPENWORK_PANEL.get(), "诡异木回纹亮格");
            this.add(ChangShengJueBlocks.MANGROVE_FRETWORK_OPENWORK_PANEL.get(), "红木回纹亮格");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_FRETWORK_OPENWORK_PANEL.get(), "黄花梨回纹亮格");
            this.add(ChangShengJueBlocks.WENGE_FRETWORK_OPENWORK_PANEL.get(), "鸡翅木回纹亮格");
            this.add(ChangShengJueBlocks.ACACIA_FRETWORK_OPENWORK_PANEL.get(), "金合欢回纹亮格");
            this.add(ChangShengJueBlocks.DARK_OAK_FRETWORK_OPENWORK_PANEL.get(), "深色橡木回纹亮格");
            this.add(ChangShengJueBlocks.OAK_FRETWORK_OPENWORK_PANEL.get(), "橡木回纹亮格");
            this.add(ChangShengJueBlocks.CHERRY_FRETWORK_OPENWORK_PANEL.get(), "樱花木回纹亮格");
            this.add(ChangShengJueBlocks.SPRUCE_FRETWORK_OPENWORK_PANEL.get(), "云杉木回纹亮格");
            this.add(ChangShengJueBlocks.ZI_TAN_FRETWORK_OPENWORK_PANEL.get(), "紫檀木回纹亮格");

            this.add(ChangShengJueBlocks.BIRCH_BOOK_GRID.get(), "白桦木书格");
            this.add(ChangShengJueBlocks.JUNGLE_BOOK_GRID.get(), "丛林木书格");
            this.add(ChangShengJueBlocks.CRIMSON_BOOK_GRID.get(), "绯红木书格");
            this.add(ChangShengJueBlocks.WARPED_BOOK_GRID.get(), "诡异木书格");
            this.add(ChangShengJueBlocks.MANGROVE_BOOK_GRID.get(), "红木书格");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_GRID.get(), "黄花梨书格");
            this.add(ChangShengJueBlocks.WENGE_BOOK_GRID.get(), "鸡翅木书格");
            this.add(ChangShengJueBlocks.ACACIA_BOOK_GRID.get(), "金合欢书格");
            this.add(ChangShengJueBlocks.DARK_OAK_BOOK_GRID.get(), "深色橡木书格");
            this.add(ChangShengJueBlocks.OAK_BOOK_GRID.get(), "橡木书格");
            this.add(ChangShengJueBlocks.CHERRY_BOOK_GRID.get(), "樱花木书格");
            this.add(ChangShengJueBlocks.SPRUCE_BOOK_GRID.get(), "云杉木书格");
            this.add(ChangShengJueBlocks.ZI_TAN_BOOK_GRID.get(), "紫檀木书格");

            this.add(ChangShengJueBlocks.BIRCH_CABINET.get(), "白桦木柜子");
            this.add(ChangShengJueBlocks.JUNGLE_CABINET.get(), "丛林木柜子");
            this.add(ChangShengJueBlocks.CRIMSON_CABINET.get(), "绯红木柜子");
            this.add(ChangShengJueBlocks.WARPED_CABINET.get(), "诡异木柜子");
            this.add(ChangShengJueBlocks.MANGROVE_CABINET.get(), "红木柜子");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_CABINET.get(), "黄花梨柜子");
            this.add(ChangShengJueBlocks.WENGE_CABINET.get(), "鸡翅木柜子");
            this.add(ChangShengJueBlocks.ACACIA_CABINET.get(), "金合欢柜子");
            this.add(ChangShengJueBlocks.DARK_OAK_CABINET.get(), "深色橡木柜子");
            this.add(ChangShengJueBlocks.OAK_CABINET.get(), "橡木柜子");
            this.add(ChangShengJueBlocks.CHERRY_CABINET.get(), "樱花木柜子");
            this.add(ChangShengJueBlocks.SPRUCE_CABINET.get(), "云杉木柜子");
            this.add(ChangShengJueBlocks.ZI_TAN_CABINET.get(), "紫檀木柜子");

            this.add(ChangShengJueBlocks.BIRCH_LARGE_CABINET.get(), "白桦木立柜");
            this.add(ChangShengJueBlocks.JUNGLE_LARGE_CABINET.get(), "丛林木立柜");
            this.add(ChangShengJueBlocks.CRIMSON_LARGE_CABINET.get(), "绯红木立柜");
            this.add(ChangShengJueBlocks.WARPED_LARGE_CABINET.get(), "诡异木立柜");
            this.add(ChangShengJueBlocks.MANGROVE_LARGE_CABINET.get(), "红木立柜");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LARGE_CABINET.get(), "黄花梨立柜");
            this.add(ChangShengJueBlocks.WENGE_LARGE_CABINET.get(), "鸡翅木立柜");
            this.add(ChangShengJueBlocks.ACACIA_LARGE_CABINET.get(), "金合欢立柜");
            this.add(ChangShengJueBlocks.DARK_OAK_LARGE_CABINET.get(), "深色橡木立柜");
            this.add(ChangShengJueBlocks.OAK_LARGE_CABINET.get(), "橡木立柜");
            this.add(ChangShengJueBlocks.CHERRY_LARGE_CABINET.get(), "樱花木立柜");
            this.add(ChangShengJueBlocks.SPRUCE_LARGE_CABINET.get(), "云杉木立柜");
            this.add(ChangShengJueBlocks.ZI_TAN_LARGE_CABINET.get(), "紫檀木立柜");

            this.add(ChangShengJueBlocks.BIRCH_DRYING_RAIL.get(), "白桦木晾衣杆");
            this.add(ChangShengJueBlocks.JUNGLE_DRYING_RAIL.get(), "丛林木晾衣杆");
            this.add(ChangShengJueBlocks.CRIMSON_DRYING_RAIL.get(), "绯红木晾衣杆");
            this.add(ChangShengJueBlocks.WARPED_DRYING_RAIL.get(), "诡异木晾衣杆");
            this.add(ChangShengJueBlocks.MANGROVE_DRYING_RAIL.get(), "红木晾衣杆");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_DRYING_RAIL.get(), "黄花梨晾衣杆");
            this.add(ChangShengJueBlocks.WENGE_DRYING_RAIL.get(), "鸡翅木晾衣杆");
            this.add(ChangShengJueBlocks.ACACIA_DRYING_RAIL.get(), "金合欢晾衣杆");
            this.add(ChangShengJueBlocks.DARK_OAK_DRYING_RAIL.get(), "深色橡木晾衣杆");
            this.add(ChangShengJueBlocks.OAK_DRYING_RAIL.get(), "橡木晾衣杆");
            this.add(ChangShengJueBlocks.CHERRY_DRYING_RAIL.get(), "樱花木晾衣杆");
            this.add(ChangShengJueBlocks.SPRUCE_DRYING_RAIL.get(), "云杉木晾衣杆");
            this.add(ChangShengJueBlocks.ZI_TAN_DRYING_RAIL.get(), "紫檀木晾衣杆");

            this.add(ChangShengJueBlocks.BIRCH_CLOTHES_RACK.get(), "白桦木衣架");
            this.add(ChangShengJueBlocks.JUNGLE_CLOTHES_RACK.get(), "丛林木衣架");
            this.add(ChangShengJueBlocks.CRIMSON_CLOTHES_RACK.get(), "绯红木衣架");
            this.add(ChangShengJueBlocks.WARPED_CLOTHES_RACK.get(), "诡异木衣架");
            this.add(ChangShengJueBlocks.MANGROVE_CLOTHES_RACK.get(), "红木衣架");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_CLOTHES_RACK.get(), "黄花梨衣架");
            this.add(ChangShengJueBlocks.WENGE_CLOTHES_RACK.get(), "鸡翅木衣架");
            this.add(ChangShengJueBlocks.ACACIA_CLOTHES_RACK.get(), "金合欢衣架");
            this.add(ChangShengJueBlocks.DARK_OAK_CLOTHES_RACK.get(), "深色橡木衣架");
            this.add(ChangShengJueBlocks.OAK_CLOTHES_RACK.get(), "橡木衣架");
            this.add(ChangShengJueBlocks.CHERRY_CLOTHES_RACK.get(), "樱花木衣架");
            this.add(ChangShengJueBlocks.SPRUCE_CLOTHES_RACK.get(), "云杉木衣架");
            this.add(ChangShengJueBlocks.ZI_TAN_CLOTHES_RACK.get(), "紫檀木衣架");

            this.add(ChangShengJueBlocks.BIRCH_CHEST_OF_DRAWERS.get(), "白桦木屉柜");
            this.add(ChangShengJueBlocks.JUNGLE_CHEST_OF_DRAWERS.get(), "丛林木屉柜");
            this.add(ChangShengJueBlocks.CRIMSON_CHEST_OF_DRAWERS.get(), "绯红木屉柜");
            this.add(ChangShengJueBlocks.WARPED_CHEST_OF_DRAWERS.get(), "诡异木屉柜");
            this.add(ChangShengJueBlocks.MANGROVE_CHEST_OF_DRAWERS.get(), "红木屉柜");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_CHEST_OF_DRAWERS.get(), "黄花梨屉柜");
            this.add(ChangShengJueBlocks.WENGE_CHEST_OF_DRAWERS.get(), "鸡翅木屉柜");
            this.add(ChangShengJueBlocks.ACACIA_CHEST_OF_DRAWERS.get(), "金合欢屉柜");
            this.add(ChangShengJueBlocks.DARK_OAK_CHEST_OF_DRAWERS.get(), "深色橡木屉柜");
            this.add(ChangShengJueBlocks.OAK_CHEST_OF_DRAWERS.get(), "橡木屉柜");
            this.add(ChangShengJueBlocks.CHERRY_CHEST_OF_DRAWERS.get(), "樱花木屉柜");
            this.add(ChangShengJueBlocks.SPRUCE_CHEST_OF_DRAWERS.get(), "云杉木屉柜");
            this.add(ChangShengJueBlocks.ZI_TAN_CHEST_OF_DRAWERS.get(), "紫檀木屉柜");

            this.add(ChangShengJueBlocks.BIRCH_LIANGGE.get(), "白桦木亮格");
            this.add(ChangShengJueBlocks.JUNGLE_LIANGGE.get(), "丛林木亮格");
            this.add(ChangShengJueBlocks.CRIMSON_LIANGGE.get(), "绯红木亮格");
            this.add(ChangShengJueBlocks.WARPED_LIANGGE.get(), "诡异木亮格");
            this.add(ChangShengJueBlocks.MANGROVE_LIANGGE.get(), "红木亮格");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LIANGGE.get(), "黄花梨亮格");
            this.add(ChangShengJueBlocks.WENGE_LIANGGE.get(), "鸡翅木亮格");
            this.add(ChangShengJueBlocks.ACACIA_LIANGGE.get(), "金合欢亮格");
            this.add(ChangShengJueBlocks.DARK_OAK_LIANGGE.get(), "深色橡木亮格");
            this.add(ChangShengJueBlocks.OAK_LIANGGE.get(), "橡木亮格");
            this.add(ChangShengJueBlocks.CHERRY_LIANGGE.get(), "樱花木亮格");
            this.add(ChangShengJueBlocks.SPRUCE_LIANGGE.get(), "云杉木亮格");
            this.add(ChangShengJueBlocks.ZI_TAN_LIANGGE.get(), "紫檀木亮格");

            this.add(ChangShengJueBlocks.STONE_BENCH.get(), "石凳");
            this.add(ChangShengJueBlocks.STONE_TABLE.get(), "石桌");
            this.add(ChangShengJueBlocks.STONE_BALUSTRADE.get(),"石栏杆");

            this.add(ChangShengJueBlocks.ZAFU.get(), "蒲团");

            this.add(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN.get(), "白桦木折屏");
            this.add(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN.get(), "丛林木折屏");
            this.add(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN.get(), "绯红木折屏");
            this.add(ChangShengJueBlocks.WARPED_FOLDING_SCREEN.get(), "诡异木折屏");
            this.add(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN.get(), "红木折屏");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN.get(), "黄花梨折屏");
            this.add(ChangShengJueBlocks.WENGE_FOLDING_SCREEN.get(), "鸡翅木折屏");
            this.add(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN.get(), "金合欢折屏");
            this.add(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN.get(), "深色橡木折屏");
            this.add(ChangShengJueBlocks.OAK_FOLDING_SCREEN.get(), "橡木折屏");
            this.add(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN.get(), "樱花木折屏");
            this.add(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN.get(), "云杉木折屏");
            this.add(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN.get(), "紫檀木折屏");

            this.add(ChangShengJueBlocks.BIRCH_ARHAT_BED.get(), "白桦木藤面罗汉床");
            this.add(ChangShengJueBlocks.JUNGLE_ARHAT_BED.get(), "丛林木藤面罗汉床");
            this.add(ChangShengJueBlocks.CRIMSON_ARHAT_BED.get(), "绯红木藤面罗汉床");
            this.add(ChangShengJueBlocks.WARPED_ARHAT_BED.get(), "诡异木藤面罗汉床");
            this.add(ChangShengJueBlocks.MANGROVE_ARHAT_BED.get(), "红木藤面罗汉床");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_ARHAT_BED.get(), "黄花梨藤面罗汉床");
            this.add(ChangShengJueBlocks.WENGE_ARHAT_BED.get(), "鸡翅木藤面罗汉床");
            this.add(ChangShengJueBlocks.ACACIA_ARHAT_BED.get(), "金合欢藤面罗汉床");
            this.add(ChangShengJueBlocks.DARK_OAK_ARHAT_BED.get(), "深色橡木藤面罗汉床");
            this.add(ChangShengJueBlocks.OAK_ARHAT_BED.get(), "橡木藤面罗汉床");
            this.add(ChangShengJueBlocks.CHERRY_ARHAT_BED.get(), "樱花木藤面罗汉床");
            this.add(ChangShengJueBlocks.SPRUCE_ARHAT_BED.get(), "云杉木藤面罗汉床");
            this.add(ChangShengJueBlocks.ZI_TAN_ARHAT_BED.get(), "紫檀木藤面罗汉床");

            this.add(ChangShengJueBlocks.BIRCH_CANOPY_BED.get(), "白桦木架子床");
            this.add(ChangShengJueBlocks.JUNGLE_CANOPY_BED.get(), "丛林木架子床");
            this.add(ChangShengJueBlocks.CRIMSON_CANOPY_BED.get(), "绯红木架子床");
            this.add(ChangShengJueBlocks.WARPED_CANOPY_BED.get(), "诡异木架子床");
            this.add(ChangShengJueBlocks.MANGROVE_CANOPY_BED.get(), "红木架子床");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.get(), "黄花梨架子床");
            this.add(ChangShengJueBlocks.WENGE_CANOPY_BED.get(), "鸡翅木架子床");
            this.add(ChangShengJueBlocks.ACACIA_CANOPY_BED.get(), "金合欢架子床");
            this.add(ChangShengJueBlocks.DARK_OAK_CANOPY_BED.get(), "深色橡木架子床");
            this.add(ChangShengJueBlocks.OAK_CANOPY_BED.get(), "橡木架子床");
            this.add(ChangShengJueBlocks.CHERRY_CANOPY_BED.get(), "樱花木架子床");
            this.add(ChangShengJueBlocks.SPRUCE_CANOPY_BED.get(), "云杉木架子床");
            this.add(ChangShengJueBlocks.ZI_TAN_CANOPY_BED.get(), "紫檀木架子床");

            this.add(ChangShengJueBlocks.LANTERN.get(), "灯笼");
            this.add(ChangShengJueBlocks.WHITE_LANTERN.get(), "白色灯笼");
            this.add(ChangShengJueBlocks.ORANGE_LANTERN.get(), "橙色灯笼");
            this.add(ChangShengJueBlocks.MAGENTA_LANTERN.get(), "品红色灯笼");
            this.add(ChangShengJueBlocks.LIGHT_BLUE_LANTERN.get(), "浅蓝色灯笼");
            this.add(ChangShengJueBlocks.YELLOW_LANTERN.get(), "黄色灯笼");
            this.add(ChangShengJueBlocks.LIME_LANTERN.get(), "黄绿色灯笼");
            this.add(ChangShengJueBlocks.PINK_LANTERN.get(), "粉红色灯笼");
            this.add(ChangShengJueBlocks.GRAY_LANTERN.get(), "灰色灯笼");
            this.add(ChangShengJueBlocks.LIGHT_GRAY_LANTERN.get(), "浅灰色灯笼");
            this.add(ChangShengJueBlocks.CYAN_LANTERN.get(), "青色灯笼");
            this.add(ChangShengJueBlocks.PURPLE_LANTERN.get(), "紫色灯笼");
            this.add(ChangShengJueBlocks.BLUE_LANTERN.get(), "蓝色灯笼");
            this.add(ChangShengJueBlocks.BROWN_LANTERN.get(), "棕色灯笼");
            this.add(ChangShengJueBlocks.GREEN_LANTERN.get(), "绿色灯笼");
            this.add(ChangShengJueBlocks.RED_LANTERN.get(), "红色灯笼");
            this.add(ChangShengJueBlocks.BLACK_LANTERN.get(), "黑色灯笼");

            this.add(ChangShengJueBlocks.BIRCH_LIGHT_STAND.get(), "白桦木独柱烛台");
            this.add(ChangShengJueBlocks.JUNGLE_LIGHT_STAND.get(), "丛林木独柱烛台");
            this.add(ChangShengJueBlocks.CRIMSON_LIGHT_STAND.get(), "绯红木独柱烛台");
            this.add(ChangShengJueBlocks.WARPED_LIGHT_STAND.get(), "诡异木独柱烛台");
            this.add(ChangShengJueBlocks.MANGROVE_LIGHT_STAND.get(), "红木独柱烛台");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_LIGHT_STAND.get(), "黄花梨独柱烛台");
            this.add(ChangShengJueBlocks.WENGE_LIGHT_STAND.get(), "鸡翅木独柱烛台");
            this.add(ChangShengJueBlocks.ACACIA_LIGHT_STAND.get(), "金合欢独柱烛台");
            this.add(ChangShengJueBlocks.DARK_OAK_LIGHT_STAND.get(), "深色橡木独柱烛台");
            this.add(ChangShengJueBlocks.OAK_LIGHT_STAND.get(), "橡木独柱烛台");
            this.add(ChangShengJueBlocks.CHERRY_LIGHT_STAND.get(), "樱花木独柱烛台");
            this.add(ChangShengJueBlocks.SPRUCE_LIGHT_STAND.get(), "云杉木独柱烛台");
            this.add(ChangShengJueBlocks.ZI_TAN_LIGHT_STAND.get(), "紫檀木独柱烛台");

            this.add(ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND.get(), "白桦木灯挂架");
            this.add(ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND.get(), "丛林木灯挂架");
            this.add(ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND.get(), "绯红木灯挂架");
            this.add(ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND.get(), "诡异木灯挂架");
            this.add(ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND.get(), "红木灯挂架");
            this.add(ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND.get(), "黄花梨灯挂架");
            this.add(ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND.get(), "鸡翅木灯挂架");
            this.add(ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND.get(), "金合欢灯挂架");
            this.add(ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND.get(), "深色橡木灯挂架");
            this.add(ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND.get(), "橡木灯挂架");
            this.add(ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND.get(), "樱花木灯挂架");
            this.add(ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND.get(), "云杉木灯挂架");
            this.add(ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND.get(), "紫檀木灯挂架");

            this.add(ChangShengJueBlocks.BAMBOO_MAT.get(), "竹席");

            this.add(ChangShengJueBlocks.BIRCH_WINE_TABLE.get(), "白桦木酒桌");
            this.add(ChangShengJueBlocks.JUNGLE_WINE_TABLE.get(), "丛林木酒桌");
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
            this.add(ChangShengJueBlocks.NATURAL_ASPHALT_ORE.get(), "天然沥青块");

            this.add(ChangShengJueBlocks.STONE_SHARPENING_STONE.get(), "圆石磨刀石");
            this.add(ChangShengJueBlocks.DIAMOND_SHARPENING_STONE.get(), "钻石磨刀石");
            this.add(ChangShengJueBlocks.NETHERITE_SHARPENING_STONE.get(), "下界合金磨刀石");

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
            this.add(ChangShengJueBlocks.WOOD_WORKING_BENCH.get(), "木工台");
            this.add(ChangShengJueBlocks.BRICK_KILN.get(), "窑炉");
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

            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager", "村民");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.none", "无业");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.villager", "村民");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.armorer", "盔甲匠");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.butcher", "屠夫");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.cartographer", "制图师");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.cleric", "牧师");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.farmer", "农民");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.fisherman", "渔夫");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.fletcher", "制箭师");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.leatherworker", "皮匠");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.librarian", "图书管理员");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.mason", "石匠");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.nitwit", "傻子");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.shepherd", "牧羊人");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.toolsmith", "工具匠");
            this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.weaponsmith", "武器匠");

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
            this.add("biome."+ ChangShengJue.MOD_ID +".chang_sheng_jue_prairie", "慕然草原");

            //存储
            this.add("container.hercules", "大力神功");
            //柜子
            this.add("container."+ ChangShengJue.MOD_ID +".cabinet", "柜子");

            /*信息*/
            //死亡信息
            this.add("death.attack." + CSJDamageTypes.BLEED.location().getPath(), "%1$s失血过多。");
            this.add("death.attack." + CSJDamageTypes.MARTIAL_ARTS.location().getPath(), "%1$s被%2$s使用武功震碎了内脏。");
            this.add("death.attack." + CSJDamageTypes.TRAUMA.location().getPath(), "%1$s的伤势过重。");
            //配置文件信息
            this.add("config."+ ChangShengJue.MOD_ID +".reload", "配置已重新加载");
            this.add("config."+ ChangShengJue.MOD_ID +".enable_quests", "是否启用自动接受类型任务。");

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

            //普通信息
            this.add("block."+ ChangShengJue.MOD_ID +".fen_jiu.no_wine","已经没有酒了！");

            this.add("message.sharpening_stone.sharpened", "§a武器已打磨！本次增加：");
            this.add("message.sharpening_stone.total_damage", "§a，当前攻击力：");
            this.add("message.sharpening_stone.max_damage", "§c武器已打磨到上限");

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
            this.add("button."+ ChangShengJue.MOD_ID +".gre_button.tips", "灰");
            this.add("button."+ ChangShengJue.MOD_ID +".red_button.tips", "红");
            this.add("button."+ ChangShengJue.MOD_ID +".black_button.tips", "黑");
            this.add("button."+ ChangShengJue.MOD_ID +".blue_button.tips", "青");
            this.add("button."+ ChangShengJue.MOD_ID +".golden_button.tips", "金");
            this.add("button."+ ChangShengJue.MOD_ID +".wood_button.tips", "木");
            this.add("gui."+ ChangShengJue.MOD_ID +".trade.gre", "灰");
            this.add("gui."+ ChangShengJue.MOD_ID +".trade.red", "红");
            this.add("gui."+ ChangShengJue.MOD_ID +".trade.black", "黑");
            this.add("gui."+ ChangShengJue.MOD_ID +".trade.blue", "青");
            this.add("gui."+ ChangShengJue.MOD_ID +".trade.golden", "金");
            this.add("gui."+ ChangShengJue.MOD_ID +".trade.wood", "木");

            //任务
            this.add("quest."+ ChangShengJue.MOD_ID +".button", "任务");
            this.add("quest."+ ChangShengJue.MOD_ID +".requirements", "任务需求:");
            this.add("quest."+ ChangShengJue.MOD_ID +".rewards", "任务奖励:");
            this.add("quest."+ ChangShengJue.MOD_ID +".submit.button", "提交任务");
            this.add("quest."+ ChangShengJue.MOD_ID +".no_submit.button", "当前没有任务可以提交!");
            this.add("quest."+ ChangShengJue.MOD_ID +".accept.button", "接受任务");
            this.add("quest."+ ChangShengJue.MOD_ID +".abandon.button", "放弃任务");
            this.add("quest."+ ChangShengJue.MOD_ID +".no_abandon.button", "无法放弃不存在的任务!");
            this.add("quest."+ ChangShengJue.MOD_ID +".requirements.prompt", "任务需求不足!");
            this.add("quest."+ ChangShengJue.MOD_ID +".finish", "§a%s任务完成！");
            this.add("quest."+ ChangShengJue.MOD_ID +".trigger", "§a触发%s任务");
            this.add("quest."+ ChangShengJue.MOD_ID +".fail", "§a%s任务失败!");
            this.add("quest."+ ChangShengJue.MOD_ID +".requires.kill.target","需要击杀: %s次");
            this.add("quest."+ ChangShengJue.MOD_ID +".current.kill.target","当前进度: %s/%s");
            this.add("quest."+ ChangShengJue.MOD_ID +".no_quest","当前没有正在进行的任务!");
            this.add("quest."+ ChangShengJue.MOD_ID +".no_action_quest","当前没有可以接受的任务!");

            this.add("quest."+ ChangShengJue.MOD_ID +".food.questName", "收集食物");
            this.add("quest."+ ChangShengJue.MOD_ID +".food.questDescription", "首领：兄弟们的吃食又不够了，总不能饿肚子吧，兄弟你去想想办法。");
            this.add("quest."+ ChangShengJue.MOD_ID +".money.questName", "收集钱款");
            this.add("quest."+ ChangShengJue.MOD_ID +".money.questDescription", "首领：这年头什么都要花钱，一文钱难倒英雄汉，兄弟能筹点帮费吗？");

            this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questName", "踢馆");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questDescription", "首领：可恶！这是今年第二个趁我病期来踢馆的了，欺我帮派无人，你去回敬下吧！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questRequirementsDescription", "击杀任意帮派首领。");

            this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questName", "侠客行");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questDescription", "首领：灾厄巡逻队总是与我们发生冲突，不知死活！做掉他们！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questRequirementsDescription", "击杀掠夺者。");

            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questName", "杀鸡儆猴");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questDescription", "首领：这群刁民真是有够胆大的，去收帮费的人拒了我们几波，你去给他们点颜色看看！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questRequirementsDescription", "击杀任意村民。");

            this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questName", "投名状");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questDescription", "首领：这位兄弟，想入我们帮派，你需要先纳投名状！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questRequirementsDescription", "击杀任意人型生物。");

            this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questName", "挑战");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questDescription", "首领：有兄弟听说你武功高强，想和你较量一番，你意下如何？");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questRequirementsDescription", "击败或者击杀前来的挑战者。");

            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia.questName", "天下第一");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_1.questDescription", "首领：虽说现在天下第一是棍王董大侠，但以兄台的实力也能与其一争啊！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_2.questDescription", "首领：虽说现在天下第一是刀圣徐大侠，但以兄台的实力也能与其一争啊！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_3.questDescription", "首领：虽说现在天下第一是北拳萧大侠，但以兄台的实力也能与其一争啊！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_4.questDescription", "首领：虽说现在天下第一是剑仙张大侠，但以兄台的实力也能与其一争啊！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia.questRequirementsDescription", "击杀四大名侠之一。");

            this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questName", "保护村庄");
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questDescription", "首领：我们帮派名下的村庄被入侵了，快去保护咱们的粮仓！");
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questRequirementsDescription", "在袭击中胜利。");

            this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questName", "救民侠医");
            this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questDescription", "首领：附近的村庄被僵尸袭击，好多村民变成了僵尸村民，听说兄弟你会些医术，去看看吧？");
            this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questRequirementsDescription", "救治一名僵尸村民。");

            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questName", "斋饭");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questDescription", "首领：心念慈悲，不犯杀戒。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questRequirementsDescription", "2个游戏日内不杀死生物。");

            this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questName", "行侠仗义");
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questDescription", "附近一村庄被乌泱泱的僵尸入侵了，君愿舍身以助吗？");
            this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questRequirementsDescription", "留在村庄内协助村民抵御僵尸。");

            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questName", "田园侠客");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questDescription", "因为有你，这里的村民没人敢欺负，你也在这里安居乐业。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questRequirementsDescription", "偶遇村民。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questName", "快意恩仇");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questDescription", "冤仇若不分明报，枉做人间大丈夫。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questRequirementsDescription", "击败攻击你的敌人。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questName", "为民除害");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questDescription", "这一大虫总拿村民当食吃，大侠小心！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questRequirementsDescription", "击杀1只老虎。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questName", "除暴安良");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questDescription", "村长：村里有一恶人到处抢掠，大侠可能帮帮我们？！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questRequirementsDescription", "击杀1个恶徒。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questName", "武侠");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questDescription", "路见不平，拔刀相助，才堪侠客。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questRequirementsDescription", "夜间村庄内击杀1只僵尸。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questName", "杀人越货");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questDescription", "你即以财宝显漏，就别怪我了下手狠了！嘿嘿嘿...");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questRequirementsDescription", "击杀1个流浪商人。");
            this.add("quest."+ ChangShengJue.MOD_ID +".gather.food.questName", "大额交易");
            this.add("quest."+ ChangShengJue.MOD_ID +".gather.food.questDescription", "村长：最近庄稼减收冬天怕是不好过了，大侠可以帮我们收集些食物度过难关吗？");
            this.add("quest."+ ChangShengJue.MOD_ID +".gather.money.questName", "大额交易");
            this.add("quest."+ ChangShengJue.MOD_ID +".gather.money.questDescription", "村长：这次真是大丰收！但是如此多粮食放久了会坏，大侠你能帮我们想想办法吗？");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questName", "任我行");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questDescription", "海阔天空，何处不容人。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questRequirementsDescription", "7天内死亡次数小于1。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questName", "锄强扶弱");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questDescription", "村民不光要面对僵尸的袭击，竟还有帮派的威胁！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questRequirementsDescription", "击杀3个强盗。");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questName", "江湖追杀令");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questDescription", "你帮助村庄对抗帮派，各大势力都以你武林公敌的借口对你进行了追杀！");
            this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questRequirementsDescription", "杀死袭击你的人。");
            this.add("quest."+ ChangShengJue.MOD_ID +".ao_qi_tian_di_jian.questName", "傲气天地间");
            this.add("quest."+ ChangShengJue.MOD_ID +".ao_qi_tian_di_jian.questDescription", "我有百般力，何向弱者使？天地不平，我自平之！虽百人，有所可惧，智勇以对。");
            this.add("quest."+ ChangShengJue.MOD_ID +".ao_qi_tian_di_jian.questRequirementsDescription", "击杀恶徒与杀手。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questName", "天若有情天亦老");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questDescription", "人间正道是沧桑。");
            this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questRequirementsDescription", "完成两次江湖追杀令。");

            //裁衣案"container.tailoring_case.json"
            this.add("container."+ ChangShengJue.MOD_ID +".tailoring_case", "裁衣案");
            this.add("gui."+ ChangShengJue.MOD_ID + ".tailoring_case.craft", "裁衣");
            //锻台“forgeblock”
            this.add("container."+ ChangShengJue.MOD_ID +".forge_block", "锻造炉");
            this.add("gui."+ ChangShengJue.MOD_ID + ".forge_block.craft", "锻造");

            this.add("container."+ ChangShengJue.MOD_ID +".wood_working_bench", "木工台");
            this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.craft", "制作");
            this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.all", "全部");
            this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.da_mu_zuo", "大木作");
            this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.xiao_mu_zuo", "小木作");
            this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.chen_she", "陈设");
            this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.furniture", "家具");
            this.add("container."+ ChangShengJue.MOD_ID +".brick_kiln", "砖窑");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.craft", "烧制");

            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.all", "全部");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.wa_zuo", "瓦作");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.shi_zuo", "石作");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.za_lei", "杂类");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color", "颜色");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.gray", "灰");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.red", "红");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.black", "黑");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.gold", "金");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.cyan", "青");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.purple", "紫");
            this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.blue", "蓝");
            //jei
            this.add("jei."+ ChangShengJue.MOD_ID +".woodworking_bench.usage", "在木工台中制作该物品");
            this.add("jei."+ ChangShengJue.MOD_ID +".tailoring_case.usage", "在裁衣案中制作该物品");
            this.add("jei."+ ChangShengJue.MOD_ID +".forge_block.usage", "在锻造炉中制作该物品");
            this.add("jei."+ ChangShengJue.MOD_ID +".brick_kiln.usage", "在窑炉中制作该物品");
            //帕秋莉
            this.add(ChangShengJue.MOD_ID +".function", "功能物品");
            this.add(ChangShengJue.MOD_ID +".function.desc", "从那个空间裂缝来了很多奇怪的人，他们不仅会舞火为凤，飞天遁地。也带来了很多奇怪的东西。听说他们是从东方来的？");
            this.add(ChangShengJue.MOD_ID +".function.blue_and_white_porcelain_flower_pots", "青花瓷花盆");
            this.add(ChangShengJue.MOD_ID +".function.blue_and_white_porcelain_flower_pots.page1.text", "作用等同于原版花盆");
            this.add(ChangShengJue.MOD_ID +".function.brush_and_lime_slurry", "刷子和石灰浆");
            this.add(ChangShengJue.MOD_ID +".function.brush_and_lime_slurry.page1.text", "将任意石灰浆桶放副手，主手持刷子就可以将整块红砖刷成对应色系白墙。石灰浆桶使用12次后会变成空桶。");
            this.add(ChangShengJue.MOD_ID +".function.bullions_casting_molds", "元宝铸造模具");
            this.add(ChangShengJue.MOD_ID +".function.bullions_casting_molds.page1.text", "将模具右键放置在地面，手持【坩埚（金/银液）】右键倒入");
            this.add(ChangShengJue.MOD_ID +".function.casting_molds", "铜钱铸造模具");
            this.add(ChangShengJue.MOD_ID +".function.casting_molds.page1.text", "用于铸造铜钱，将模具右键放置在地面，手持【坩埚（铜液）】右键倒入");
            this.add(ChangShengJue.MOD_ID +".function.crucible", "坩埚");
            this.add(ChangShengJue.MOD_ID +".function.crucible.page1.text", "是制作铜钱、元宝的重要道具$(br)可与8个铜/银/金合成为 坩埚（碎铜/银/金）$(br)【坩埚（碎铜/银/金）】在熔炉中烧制可获得【坩埚（铜/银/金液）】");
            this.add(ChangShengJue.MOD_ID +".function.crucible.page3.text", "坩埚（碎铜/银/金）在熔炉中烧制可获得坩埚（铜/银/金液）");
            this.add(ChangShengJue.MOD_ID +".function.crucible.page5.text", "坩埚（铜/银/金液）可放入模具中制作：铜钱/金银元宝");
            this.add(ChangShengJue.MOD_ID +".function.ladder", "扶梯");
            this.add(ChangShengJue.MOD_ID +".function.ladder.page1.text", "梯子有三格高，并且可以向上继续拼接增高。（当玩家处于方块边缘时向前一格放置扶梯会被压趴下）");
            this.add(ChangShengJue.MOD_ID +".function.painting_scroll", "画轴");
            this.add(ChangShengJue.MOD_ID +".function.painting_scroll.page1.text", "分为（1x1、2x1、1x2、2x2）四种，作用同原版画，有多种图案。");
            this.add(ChangShengJue.MOD_ID +".function.plaque", "牌匾");
            this.add(ChangShengJue.MOD_ID +".function.plaque.page1.text", "右键牌匾可以写入内容。侧面放置于方块上，作用同告示牌（可左右连接调整牌匾长度）");
            this.add(ChangShengJue.MOD_ID +".function.stone_lamp", "石灯");
            this.add(ChangShengJue.MOD_ID +".function.stone_lamp.page1.text", "石灯分为点燃和未燃两个状态$(br)使用打火石进行点燃，用作光源，光照亮度等同于烛台");
            this.add(ChangShengJue.MOD_ID +".function.stone_lamp.page2.title", "石灯底座");
            this.add(ChangShengJue.MOD_ID +".function.stone_lamp.page2.text", "石灯的底座，除装饰外无其他作用");
            this.add(ChangShengJue.MOD_ID +".function.zhu_tai", "烛台");
            this.add(ChangShengJue.MOD_ID +".function.zhu_tai.page1.text", "作用同火把，照亮半径12格范围。");

            this.add(ChangShengJue.MOD_ID +".village", "村落");
            this.add(ChangShengJue.MOD_ID +".village.desc", "大大小小的中式村庄坐落在麦块大陆上，他们带来了许多新奇玩意儿…");
            this.add(ChangShengJue.MOD_ID +".village.tool.chang_sheng_jue_loom", "织布机");
            this.add(ChangShengJue.MOD_ID +".village.tool.chang_sheng_jue_loom.page1.text", "使用说明：主手持$(item)蚕丝$()右键织布机可织成$(item)丝绸$()$(br)产出比例：2蚕丝 → 1丝绸");
            this.add(ChangShengJue.MOD_ID +".village.tool.pig_trough", "牲畜食槽");
            this.add(ChangShengJue.MOD_ID +".village.tool.pig_trough.page1.text", "加速生长：$(li)可放置$(item)小麦$()$(br)效果：提升附近动物20%%生长速度");
            this.add(ChangShengJue.MOD_ID +".village.tool.pig_trough.page2.text", "牲畜食槽合成配方");
            this.add(ChangShengJue.MOD_ID +".village.tool.pottery_wheel", "陶轮");
            this.add(ChangShengJue.MOD_ID +".village.tool.pottery_wheel.page1.text", "交互功能：$(li)1个粘土 → 制造$(item)瓷杯$()$(li)2个粘土 → 制造$(item)瓷碗$()$(li)3个粘土 → 制造$(item)瓷盘$()");
            this.add(ChangShengJue.MOD_ID +".village.tool.tool_table", "工具台");
            this.add(ChangShengJue.MOD_ID +".village.tool.tool_table.page1.text", "维护功能：主手持$(item)弓$()右键工具台可快速修复工具耐久");
            this.add(ChangShengJue.MOD_ID +".village.tool.tool_table.page2.text", "工具台合成配方");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief", "村长");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page1.text", "右键村长时有50%%概率会触发村庄任务[除暴安良]，完成可获得一定奖励。");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page2.title", "村长交易列表-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page2.text", "$(br)$(li)1x 银元宝 → 6x 一贯铜钱$(br)$(li)1x 金元宝 → 6x 银元宝$(br)$(li)7x 一贯铜钱 → 1x 银元宝$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page3.title", "村长交易列表-学徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page3.text", "$(br)$(li)1x 钻石 → 4x 一贯铜钱$(br)$(li)4x 一贯铜钱 → 2x 烛台$(br)$(li)7x 银元宝 → 1x 金元宝$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page4.title", "村长交易列表-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page4.text", "$(br)$(li)1x 指南针 → 4x 一贯铜钱$(br)$(li)4x 一贯铜钱 → 1x 绿宝石$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page5.title", "村长交易列表-专家与大师");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page5.text", "专家:$(br)$(li)2x 书与笔 → 4x 一贯铜钱$(br2)大师:$(br)$(li)1x 银元宝 → 1x 字画$(br)$(li)2x 金元宝 → 1x 绿宝石$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page2.anchor", "村长-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page3.anchor", "村长-学徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page4.anchor", "村长-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.chief.page5.anchor", "村长-专家");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer", "农民");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page2.anchor", "农民-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page2.title", "农民交易列表-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page2.text", "$(br)$(li)20x 玉米 → 4x 一贯铜钱$(br)$(li)20x 水稻 → 4x 一贯铜钱$(br)$(li)22x 番茄 → 4x 一贯铜钱$(br)$(li)22x 花生 → 4x 一贯铜钱$(br)$(li)4x 一贯铜钱 → 4x 米饭");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page3.anchor", "农民-学徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page3.title", "农民交易列表-学徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page3.text", "$(br)$(li)22x 葡萄 → 4x 一贯铜钱$(br)$(li)4x 一贯铜钱 → 4x 蒸菜$(br)$(li)4x 一贯铜钱 → 4x 青团");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page4.anchor", "农民-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page4.title", "农民交易列表-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page4.text", "$(br)$(li)4x 桂花糖藕 → 4x 一贯铜钱$(br)$(li)4x 一贯铜钱 → 4x 猪肚鸡");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page5.anchor", "农民-专家");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page5.title", "农民交易列表-专家与大师");
            this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page5.text", "专家:$(br)$(li) 4x 一贯铜钱 → 1x 谜之炖菜（夜视，失明，饱和，虚弱，跳跃提升，中毒中1-2种）$(br2)大师:$(br)$(li)4x 一贯铜钱 → 4x 番茄炒蛋$(br)$(li)8x 一贯铜钱 → 8x 肉沫茄子$(br)$(li)8x 一贯铜钱 → 8x 八宝粥");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter", "猎人");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page2.anchor", "猎人-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page2.title", "猎人交易列表-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page2.text", "$(br)$(li)14x 生鸡肉 → 4x 一贯铜钱$(br)$(li)4x 生兔肉 → 4x 一贯铜钱$(br)$(li)7x 生猪排 → 4x 一贯铜钱$(br)$(li)4x 一贯铜钱 → 1x 孔雀蛋$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page3.anchor", "猎人-学徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page3.title", "猎人交易列表-学徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page3.text", "$(br)$(li)7x 生羊肉 → 4x 一贯铜钱$(br)$(li)4x 一贯铜钱 → 5x 熟鹿肉$(br)$(li)4x 一贯铜钱 → 1x 鹿血$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page4.anchor", "猎人-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page4.title", "猎人交易列表-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page4.text", "$(br)$(li)7x 生鹿肉 → 4x 一贯铜钱$(br)$(li)10x 生牛肉 → 4x 一贯铜钱$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page5.anchor", "猎人-专家");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page5.title", "猎人交易列表-专家与大师");
            this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page5.text", "专家:$(br)$(li)7x 鹿茸 → 14x 一贯铜钱$(br2)大师:$(br)$(li)5x 虎皮 → 15x 一贯铜钱");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter", "窑工");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page2.anchor", "窑工-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page2.title", "窑工交易列表-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page2.text", "$(br)$(li)8x 一贯铜钱 → 32x 青石砖$(br)$(li)8x 一贯铜钱 → 32x 青石细砖$(br)$(li)8x 一贯铜钱 → 32x 青石砖楼梯$(br)$(li)8x 一贯铜钱 → 32x 青石台阶$(br)$(li)8x 一贯铜钱 → 32x 青石竖墙$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page3.anchor", "窑工-学徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page3.title", "窑工交易列表-学徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page3.text", "$(br)$(li)8x 一贯铜钱 → 32x 青石地砖$(br)$(li)8x 一贯铜钱 → 32x 黑石地砖$(br)$(li)8x 一贯铜钱 → 32x 沥青地砖$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page4.anchor", "窑工-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page4.title", "窑工交易列表-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page4.text", "$(br)$(li)4x 一贯铜钱 → 8x 瓷碗$(br)$(li)4x 一贯铜钱 → 8x 瓷杯$(br)$(li)4x 一贯铜钱 → 4x 酒坛$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page5.anchor", "窑工-专家");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page5.title", "窑工交易列表-专家与大师");
            this.add(ChangShengJue.MOD_ID +".village.villager.potter.page5.text", "专家:$(br)$(li)4x 一贯铜钱 → 1x 青花瓷花盆$(br2)大师:$(br)$(li)4x 一贯铜钱 → 1x 黄色石狮子$(br)$(li)4x 一贯铜钱 → 1x 灰色石狮子$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress", "缝工");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page2.anchor", "缝工-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page2.title", "缝工交易列表-新手");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page2.text", "$(br)$(li)6x 蚕丝 → 4x 一贯铜钱$(br)$(li)22x 棉花 → 4x 一贯铜钱$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page3.anchor", "缝工-学徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page3.title", "缝工交易列表-学徒");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page3.text", "$(br)$(li)4x 一贯铜钱 → 4x 丝绸$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page4.anchor", "缝工-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page4.title", "缝工交易列表-老手");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page4.text", "$(br)$(li)28x 一贯铜钱 → 1x 道服包裹$(br)$(li)28x 一贯铜钱 → 1x 道袍包裹$(br2)");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page5.anchor", "缝工-专家");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page5.title", "缝工交易列表-专家与大师");
            this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page5.text", "专家:$(br)$(li)6x 银元宝 → 1x 麒麟补服包裹$(br)$(li)6x 银元宝 → 1x 袆衣包裹$(br)$(li)6x 银元宝 → 1x 行者装包裹$(br)$(li)6x 银元宝 → 1x 儒装包裹$(br2)大师:$(br)$(li)8x 银元宝 → 1x 金色棉甲包裹$(br2)");

            this.add(ChangShengJue.MOD_ID +".village.villages.sandstone_castle", "沙石堡");
            this.add(ChangShengJue.MOD_ID +".village.villages.sandstone_castle.page1.text", "常生成在沙漠群系，用砂岩构筑的堡垒式村庄，储备充足、抗袭击，仿佛沙漠中的明珠。其中常有作物：棉花、番茄、葡萄、哈密瓜。");
            this.add(ChangShengJue.MOD_ID +".village.villages.courtyard", "四合院");
            this.add(ChangShengJue.MOD_ID +".village.villages.courtyard.page1.text", "常生成在草原群系，一个院子四面建有房屋，从四面将庭院合围在中间，故名四合院。其中常有作物：高粱、玉米、小麦、大豆、谷子。");
            this.add(ChangShengJue.MOD_ID +".village.villages.huizhou", "徽式村庄");
            this.add(ChangShengJue.MOD_ID +".village.villages.huizhou.page1.text", "常生成在森林群系，徽州民居以白墙黛瓦、马头墙闻名。看那雕花门窗多精致！其中常有作物：莲藕、花生、茄子、梨子。");
            this.add(ChangShengJue.MOD_ID +".village.villages.suzhou", "苏式村庄");
            this.add(ChangShengJue.MOD_ID +".village.villages.suzhou.page1.text", "常生成在丛林群系，白墙黑瓦那朴素典雅的风格与脊角高翘的屋顶，是苏派建筑的艺术典范。其中常有作物：荔枝、香蕉、榴莲、水稻。");
            this.add(ChangShengJue.MOD_ID +".village.villages.cave_dwelling", "窑洞");
            this.add(ChangShengJue.MOD_ID +".village.villages.cave_dwelling.page1.text", "常生成在高原群系，通过下挖泥土建造窑洞，冬暖夏凉，是一种特殊的建筑。其中常有作物：甘蔗、胡椒、芒果、菠萝。");

            this.add(ChangShengJue.MOD_ID +".xiake", "侠客");
            this.add(ChangShengJue.MOD_ID +".xiake.desc", "不知从什么时候，这里的情况发生了变化。自称要行侠仗义的人多了起来，他们多喜欢称呼自己为“侠客”。");
            this.add(ChangShengJue.MOD_ID +".xiake.equipment", "盔甲");
            this.add(ChangShengJue.MOD_ID +".xiake.equipment.page1.text", "武侠装备除了像原版盔甲可以给你提供盔甲值或盔甲韧性等外，还可以减少他人对你造成的外功伤害。盔甲可以自己制作也可以在古城的铁匠铺内使用货币兑换。大部分盔甲是支持颜色改变外观的，可以试试。$(br)当你初次合成或使用长生诀服装的胸甲时，会为其生成随机的化解外功效果与减少受到外伤概率。");
            this.add(ChangShengJue.MOD_ID +".xiake.equipment.page2.title", "内甲");
            this.add(ChangShengJue.MOD_ID +".xiake.equipment.page2.text", "内甲可以内衬在长生诀服装的胸甲里，提高胸甲的盔甲值或韧性。$(br)完成胸甲内衬有两种方式：1.先穿戴内甲然后穿戴打算进行内衬的胸甲就可以完成胸甲内衬。2.也可以副手持内甲，主手持打算进行内衬的胸甲按SHIFT+右键完成胸甲内衬。$(br)内甲也可单独穿戴同一般胸甲。$(br)");
            this.add(ChangShengJue.MOD_ID +".xiake.internal_injury", "内伤");
            this.add(ChangShengJue.MOD_ID +".xiake.internal_injury.page1.text", "每层内伤效果影响：受到伤害增加5%%，已穿戴的盔甲效果降低5%%，每秒5%%的概率会眩晕，持续15秒；已被施加这个效果的目标再次空手攻击他可使内伤效果叠加1层并延长2秒持续时间；内伤效果最大是5级，每等级效果提升1倍。");
            this.add(ChangShengJue.MOD_ID +".xiake.internal_injury.page2.text", "当正在运转空手类外功时，空手攻击目标向对方造成1级内伤，使用空手类外功攻击目标则造成2级内伤。$(br)主手持金丝手套也视为空手攻击。");

            this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual", "武功秘籍");
            this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual.page1.text", "通过完成帮派任务、村庄任务有概率会获取到武功秘籍；击杀会武功的NPC也有概率掉落武功秘籍。");
            this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual.page2.text", "武功秘籍分为外功类（主要是主动类武功），内功类（主要是被动类武功），轻功类（主要影响移动等效果），心法（提供一些特殊加成）。武功秘境具体效果可以从武功秘籍描述看出。武功秘籍上有清楚的说明，右键它可获取如何领悟及施展武功。");
            this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual.page3.text", "习得剑类外功后使用剑攻击目标有15%%概率让敌人受到流血效果（每0.5秒流失1血量，持续1秒），习得刀类外功后使用刀攻击目标有15%%概率触发重击效果（重击额外造成15%%伤害），习得棍类外功后使用棍攻击目标有15%%概率打晕目标（打晕目标0.5秒），习得枪类外功后使用枪攻击目标有15%%概率挑飞目标（挑飞目标0.7秒）。");

            this.add(ChangShengJue.MOD_ID +".xiake.trauma", "外伤");
            this.add(ChangShengJue.MOD_ID +".xiake.trauma.page1.text", "每层外伤效果影响：造成伤害降低5%%，速度降低5%%，每秒流失1%%血量，持续7秒；已被施加这个效果的目标再次使用对应兵器攻击他可使外伤效果持续时间延长1秒(若此次攻击造成更大级别外伤效果则会覆盖前效果)；外伤效果最大是5级，每等级效果提升1倍。");
            this.add(ChangShengJue.MOD_ID +".xiake.trauma.page2.text", "当正在运转兵器类外功时，使用对应武器攻击目标有25%%概率向对方造成1~2级外伤，使用(兵器)类外功攻击目标则有100%%概率造成1~5级外伤。");

            this.add(ChangShengJue.MOD_ID +".xiake.stakes", "木桩");
            this.add(ChangShengJue.MOD_ID +".xiake.stakes.page1.text", "木桩合成配方");
            this.add(ChangShengJue.MOD_ID +".xiake.stakes.page2.text", "内功、轻功、外功(空手)类功法可以通过打击木桩练习领悟，每次打击领悟概率为15%%。");

            this.add(ChangShengJue.MOD_ID +".function.tailoring_case", "裁衣案");
            this.add(ChangShengJue.MOD_ID +".function.tailoring_case.page1.text", "裁衣案合成配方");
            this.add(ChangShengJue.MOD_ID +".function.tailoring_case.page2.text", "用于制作服装（盔甲）等，可于裁衣案内查看选中物品，制作会自动从背包扣除对应所需材料。");

            this.add(ChangShengJue.MOD_ID +".function.forge_block", "锻造炉");
            this.add(ChangShengJue.MOD_ID +".function.forge_block.page1.text", "锻造炉合成配方");
            this.add(ChangShengJue.MOD_ID +".function.forge_block.page2.text", "用于制作武器、盔甲等，可于锻造炉内查看选中物品，制作会自动从背包扣除对应所需材料。");

            this.add(ChangShengJue.MOD_ID +".function.wood_working_bench", "木工台");
            this.add(ChangShengJue.MOD_ID +".function.wood_working_bench.page1.text", "木工台合成配方");
            this.add(ChangShengJue.MOD_ID +".function.wood_working_bench.page2.text", "用于快速制作各种家具与木制建筑构件，可以批量制作（点击数字旁的图标增加或减少制作次数，最大次数为64次），制作会自动从背包扣除对应所需材料。");

            this.add(ChangShengJue.MOD_ID +".function.brick_kiln", "窑炉");
            this.add(ChangShengJue.MOD_ID +".function.brick_kiln.page1.text", "窑炉合成配方");
            this.add(ChangShengJue.MOD_ID +".function.brick_kiln.page2.text", "用于快速制作各种石制建筑构件（琉璃瓦、片瓦等），可以批量制作（点击数字旁的图标增加或减少制作数量，最大数量为64个），制作会自动从背包扣除对应所需材料。");

            this.add(ChangShengJue.MOD_ID +".village.tool.silkworm_and_natural_silk", "蚕与蚕丝");
            this.add(ChangShengJue.MOD_ID +".village.tool.silkworm_and_natural_silk.page1.text", "丝绸合成配方");
            this.add(ChangShengJue.MOD_ID +".village.tool.silkworm_and_natural_silk.page2.text", "破坏“有蚕的桑叶”有一定概率掉落蚕与蚕丝，蚕可以放在正常桑叶使其变化为“有蚕的桑叶”；蚕丝可以合成丝绸来制作各种衣物。$(br)$(br)桑树会在森林群系和其变种群系自然生成$(br)徽派村庄的道路旁也有概率会生成一些桑树");

            this.add(ChangShengJue.MOD_ID +".village.tool.kaolin_ball", "高岭土球");
            this.add(ChangShengJue.MOD_ID +".village.tool.kaolin_ball.page1.text", "挖掘高岭土矿会掉落4个高岭土球，高岭土球可以制作琉璃瓦等石质建筑材料。");

            this.add(ChangShengJue.MOD_ID +".village.tool.syderolife_ball", "陶土球");
            this.add(ChangShengJue.MOD_ID +".village.tool.syderolife_ball.page1.text", "挖掘陶土矿会掉落4个陶土球，陶土球可以制作黑砖等石质建筑材料。");

            this.add(ChangShengJue.MOD_ID +".village.tool.natural_asphalt", "天然沥青");
            this.add(ChangShengJue.MOD_ID +".village.tool.natural_asphalt.page1.text", "挖掘天然沥青块会掉落4个天然沥青，天然沥青可以制作沥青砖等。");

            this.add(ChangShengJue.MOD_ID +".function.sharpening_stone", "磨刀石");
            this.add(ChangShengJue.MOD_ID +".function.sharpening_stone.page1.text", "通过磨刀石你可以强化你的武器，圆石磨刀石最高可以将武器伤害提升6点，钻石磨刀石则是最高提升至8点，下界合金磨刀石最高提升10点。注意！打磨后武器的耐久消耗也会对应提高。");

            this.add(ChangShengJue.MOD_ID +".xiake.quest", "任务");
            this.add(ChangShengJue.MOD_ID +".xiake.quest.page1.text", "右键帮派首领可以在任务页面领取帮派任务，完成帮派任务可以获取帮派令牌、武功秘籍、货币等物品。游玩时也有概率自动触发一些其他任务（大部分是自动领取的，符合完成条件会自动完成），奖励会有武功秘籍、货币等物品。");

            this.add(ChangShengJue.MOD_ID +".xiake.tea", "茶");
            this.add(ChangShengJue.MOD_ID +".xiake.tea.page1.text", "喝茶可以让你更快恢复血量或饥饿度，详细效果可以看茶的描述。");

            this.add(ChangShengJue.MOD_ID +".xiake.weapon", "武器");
            this.add(ChangShengJue.MOD_ID +".xiake.weapon.page1.text", "部分外功需要武器作为媒介进行施展，所以拥有对应武器很重要。可以自己制作武器，也可以在帮派使用帮派令牌兑换武器，完成帮派任务则可以解锁绝世兵器的兑换。");

            this.add(ChangShengJue.MOD_ID +".xiake.wine", "酒");
            this.add(ChangShengJue.MOD_ID +".xiake.wine.page1.text", "喝酒可以让你武功更快冷却、减少施展武功的饥饿度消耗、增加武功伤害等，详细效果可以看酒的描述。不要贪杯，喝多会醉~");

            this.add(ChangShengJue.MOD_ID +".thanks", "致谢");
            this.add(ChangShengJue.MOD_ID +".thanks.desc", "这不仅是我们的创作，更是与你共度的时光。由衷感谢。$(br2)致谢名单：$(br)ID：Peng_Fan");
            this.add(ChangShengJue.MOD_ID +".thanks.long_yuan_sword.name", "龙渊剑");
            this.add(ChangShengJue.MOD_ID +".thanks.long_yuan_sword", "以此剑特别感谢Peng_Fan在模组测试期间提供的帮助！");

            this.add(ChangShengJue.MOD_ID +".wufanglu", "五方汇录");
            this.add(ChangShengJue.MOD_ID +".wufanglu.desc", "“天若有情天亦老，人间正道是沧桑。”$(br)长生之道，岂可无知？通晓天地，百科全解。");
            this.add(ChangShengJue.MOD_ID +".wufanglu.desc2", "长生诀百科全书");
        }
    }
