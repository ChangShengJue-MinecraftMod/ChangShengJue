package com.shengchanshe.changshengjue.datagen.language;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class CSJCNLanguageProvider extends LanguageProvider {
    public CSJCNLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        //创造栏
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_building_block", "长生决 建筑方块");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_natural_blocks", "长生决 自然方块");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_functional", "长生决 功能方块");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_ingredients", "长生决 原材料");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_food_and_drink", "长生决 食物与饮品");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_combat", "长生决 战斗用品");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_tool", "长生决 工具与实用物品");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_spawn_eggs", "长生决 刷怪蛋");
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
        this.add(ChangShengJueItems.EMPTY_SHI_LI_XIANG.get(),"十里香空瓶");
        this.add(ChangShengJueItems.FEN_JIU.get(),"汾酒");
        this.add(ChangShengJueItems.EMPTY_FEN_JIU.get(),"汾酒空瓶");
        this.add(ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get(),"麦块贡酒");
        this.add(ChangShengJueItems.EMPTY_WHEAT_NUGGETS_TRIBUTE_WINE.get(),"麦块贡酒空瓶");
        this.add(ChangShengJueItems.MANGO.get(),"芒果");
        this.add(ChangShengJueItems.MEI_HUA.get(),"梅花");
        this.add(ChangShengJueItems.GUI_HUA.get(),"桂花");
        this.add(ChangShengJueItems.BANANA.get(),"香蕉");
        this.add(ChangShengJueItems.PEAR.get(),"梨子");
        this.add(ChangShengJueItems.LICHEE.get(),"荔枝");
        this.add(ChangShengJueItems.DURIAN.get(),"榴莲");
        this.add(ChangShengJueItems.OPEN_DURIAN.get(),"打开的榴莲");
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
        this.add(ChangShengJueItems.DEERSKIN.get(), "鹿皮");
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
        this.add(ChangShengJueItems.CRUCIBLE_LIQUID_COPPER.get(), "坩埚(铜液)");
        this.add(ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get(), "坩埚(银液)");
        this.add(ChangShengJueItems.CRUCIBLE_LIQUID_GOLD.get(), "坩埚(金液)");

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
        this.add(ChangShengJueItems.THREE_THROWING_KNIVES.get(),"飞刀");
        this.add(ChangShengJueItems.SEVEN_THROWING_KNIVES.get(),"飞刀");
        this.add(ChangShengJueItems.BEAT_DOG_STICK.get(),"打狗棒");
        this.add(ChangShengJueItems.YI_TINA_JIAN.get(),"倚天剑");
        this.add(ChangShengJueItems.TU_LONG_DAO.get(),"屠龙刀");
        this.add(ChangShengJueItems.BA_WANG_QIANG.get(),"霸王枪");
        this.add(ChangShengJueItems.COTTON_ARMOR_FEATHER_HELMET.get(),"羽翎棉甲头盔");
        this.add(ChangShengJueItems.COTTON_ARMOR_WHITE_FEATHER_HELMET.get(),"白色羽翎棉甲头盔");
        this.add(ChangShengJueItems.COTTON_ARMOR_CHESTPLATE.get(),"棉甲胸甲");
        this.add(ChangShengJueItems.COTTON_ARMOR_LEGGINGS.get(),"棉甲护腿");
        this.add(ChangShengJueItems.COTTON_ARMOR_BOOTS.get(),"棉甲靴子");
        this.add(ChangShengJueItems.FEMALE_TAOIST_ROBES_HELMET.get(),"道袍头冠");
        this.add(ChangShengJueItems.FEMALE_TAOIST_ROBES_CHESTPLATE.get(),"道袍衣裳");
        this.add(ChangShengJueItems.MALE_TAOIST_ROBES_HELMET.get(),"道袍头冠");
        this.add(ChangShengJueItems.MALE_TAOIST_ROBES_CHESTPLATE.get(),"道袍衣裳");
        this.add(ChangShengJueItems.TAOIST_ROBES_BOOTS.get(),"道袍鞋子");
        this.add(ChangShengJueItems.SILK_LEGGINGS.get(),"丝绸下裳");
        this.add(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_HELMET.get(),"婚服头冠");
        this.add(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_CHESTPLATE.get(),"婚服衣裳");
        this.add(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_HELMET.get(),"嫁衣头冠");
        this.add(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_CHESTPLATE.get(),"嫁衣衣裳");
        this.add(ChangShengJueItems.CHINESE_WEDDING_DRESS_BOOTS.get(),"婚服鞋子");
        this.add(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR_HELMET.get(),"山文甲头盔");
        this.add(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR_CHESTPLATE.get(),"山文甲胸甲");
        this.add(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR_LEGGINGS.get(),"山文甲护腿");
        this.add(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR_BOOTS.get(),"山文甲靴子");
        this.add(ChangShengJueItems.FLYING_FISH_ROBE_HELMET_0.get(),"飞鱼服头盔");
        this.add(ChangShengJueItems.FLYING_FISH_ROBE_HELMET_1.get(),"飞鱼服帽子");
        this.add(ChangShengJueItems.FLYING_FISH_ROBE_CHESTPLATE.get(),"飞鱼服胸甲");
        this.add(ChangShengJueItems.FLYING_FISH_ROBE_BOOTS.get(),"飞鱼服靴子");
        this.add(ChangShengJueItems.WALKER_SET_HELMET_0.get(),"行者头箍");
        this.add(ChangShengJueItems.WALKER_SET_HELMET_1.get(),"行者头链");
        this.add(ChangShengJueItems.WALKER_SET_CHESTPLATE.get(),"行者胸甲");
        this.add(ChangShengJueItems.WALKER_SET_LEGGINGS.get(),"行者护腿");
        this.add(ChangShengJueItems.WALKER_SET_BOOTS.get(),"行者靴子");
        this.add(ChangShengJueItems.QI_TIAN_DA_SHENG_HELMET.get(),"凤翅紫金冠");
        this.add(ChangShengJueItems.QI_TIAN_DA_SHENG_CHESTPLATE.get(),"锁子黄金甲");
        this.add(ChangShengJueItems.QI_TIAN_DA_SHENG_LEGGINGS.get(),"虎皮下裳");
        this.add(ChangShengJueItems.QI_TIAN_DA_SHENG_BOOTS.get(),"藕丝步云履");
        this.add(ChangShengJueItems.THE_GREAT_GENERAL_MINGGUANG_ARMOR_HELMET.get(),"大将军明光铠头盔");
        this.add(ChangShengJueItems.THE_GREAT_GENERAL_MINGGUANG_ARMOR_CHESTPLATE.get(),"大将军明光铠胸甲");
        this.add(ChangShengJueItems.THE_GREAT_GENERAL_MINGGUANG_ARMOR_LEGGINGS.get(),"大将军明光铠护腿");
        this.add(ChangShengJueItems.THE_GREAT_GENERAL_MINGGUANG_ARMOR_BOOTS.get(),"大将军明光铠靴子");
        this.add(ChangShengJueItems.CONFUCIAN_COSTUMES_HELMET.get(),"儒装头冠");
        this.add(ChangShengJueItems.CONFUCIAN_COSTUMES_CHESTPLATE.get(),"儒装衣裳");
        this.add(ChangShengJueItems.CONFUCIAN_COSTUMES_LEGGINGS.get(),"儒装下裳");
        this.add(ChangShengJueItems.CONFUCIAN_COSTUMES_BOOTS.get(),"儒装鞋子");


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
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.IMMORTAL_MIRACLE.get()+".tooltip","不死不灭，岂是幻梦?");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.HERCULES.get()+".tooltip","以气御力，神力无穷。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DUGU_NINE_SWORDS.get()+".tooltip","天下剑法中的巅峰绝诣，其中包含森罗万象的诀窍。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GAO_MARKSMANSHIP.get()+".tooltip","一点寒芒先到，随后枪出如龙。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GE_SHAN_DA_NIU.get()+".tooltip","神功盖世，何欺牛儿?");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TURTLE_BREATH_WORK.get()+".tooltip","龟虽有鼻，而息之以耳。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get()+".tooltip","任你千变万化，我只一刀破去!");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BELL_JAR.get()+".tooltip","刀枪不入，浑然一金钟。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()+".tooltip","指如疾风，势如闪电。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get()+".tooltip","学向勤中得，萤窗万卷书。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.PAODING.get()+".tooltip","若反复实践，掌握规律；便得心应手，运用自如。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SHAOLIN_STICK_METHOD.get()+".tooltip","天下武功出少林，一棍定乾坤。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()+".tooltip","来去无影无踪，逍遥自在。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get()+".tooltip","无情飞刀人有情义，人有情义飞刀无情。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WU_GANG_CUT_GUI.get()+".tooltip","何意杀人技，不如快人心。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.XUANNU_SWORDSMANSHIP.get()+".tooltip","以巧借力，以柔克刚。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get()+".tooltip","生生不息，直至山平。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.ZHANG_MEN_XIN_XUE.get()+".tooltip","江湖不是打打杀杀，那是人情世故!");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get()+".tooltip","武林中人梦寐以求的武学宝典。");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()+".tooltip","激发潜力，牵引挪移，其中变化莫测，匪夷所思。");

        //声音
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".ge_shan_da_niu_sound","武功 : 隔山打牛");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".dugu_nine_swords_sound","武功 : 独孤九剑");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".immortal_miracle_sound","武功 : 不死神功");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".gao_marksmanship_sound","武功 : 高家枪法");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".turtle_breath_work_sound","武功 : 龟息功");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".golden_black_knife_method_sound","武功 : 金乌刀法");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".sunflower_point_caveman_sound","武功 : 葵花点穴手");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".shaolin_stick_method_sound","武功 : 少林棍法");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".tread_the_snow_without_trace_sound","武功 : 踏雪无痕");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".throwing_knives_sound","飞刀 : 飞出");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".three_throwing_knives_sound","飞刀 : 飞出");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".seven_throwing_knives_sound","飞刀 : 飞出");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".throwing_knives_hit","飞刀 : 命中");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".throwing_knives_hit_ground","飞刀 : 命中");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".wu_gang_cut_gui_sound","武功 : 吴刚伐桂");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".xuannu_swordsmanship_sound","武功 : 玄女剑法");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".golden_belljar_sound","武功 : 金钟罩");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".comprehend_sound","武功 : 领悟");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + ".dacheng_sound","武功 : 大成");

        this.add("sounds."+ChangShengJue.MOD_ID+"." + "cicada_sound", "蝉 : 鸣叫");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "cicada_hurt", "蝉 : 受伤");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "crane_sound", "鹤 : 鸣叫");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "crane_hurt", "鹤 : 受伤");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "crane_death", "鹤 : 死亡");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "croc_sound", "鳄鱼 : 咆哮");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "croc_hurt", "鳄鱼 : 受伤");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "croc_death", "鳄鱼 : 死亡");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "dragonfly_hurt", "蜻蜓 : 受伤");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "dragonfly_death", "蜻蜓 : 死亡");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "monkey_sound" , "猴 : 嚎叫");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "monkey_baby_sound" , "猴 : 嚎叫");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "monkey_angry_sound" , "猴 : 生气");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "monkey_hurt" , "猴 : 受伤");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "monkey_death" , "猴 : 死亡");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "tiger_sound" , "虎 : 咆哮");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "tiger_sound_1" , "虎 : 咆哮");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "tiger_hurt" , "虎 : 受伤");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "tiger_death" , "虎 : 死亡");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "deer_sound" , "鹿 : 鸣叫");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "deer_sound_1" , "鹿 : 鸣叫");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "deer_sound_2" , "鹿 : 鸣叫");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "deer_sound_3" , "鹿 : 鸣叫");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "deer_sound_4" , "鹿 : 鸣叫");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "deer_sound_5" , "鹿 : 鸣叫");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "deer_hurt" , "鹿 : 受伤");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "deer_death" , "鹿 : 死亡");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "peacock_sound" , "孔雀 : 鸣叫");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "peacock_hurt" , "孔雀 : 受伤");
        this.add("sounds."+ChangShengJue.MOD_ID+"." + "peacock_death" , "孔雀 : 死亡");

        //方块
        this.add(ChangShengJueItems.STAKES.get(),"练功木桩");

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
        this.add(ChangShengJueBlocks.MEI_HUA_LOG.get(),"梅花原木");
        this.add(ChangShengJueBlocks.MEI_HUA_LEAVES.get(),"梅花树叶");
        this.add(ChangShengJueBlocks.MEI_HUA_SAPLING.get(),"梅花树苗");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get(),"黄花梨原木");
        this.add(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get(),"去皮黄花梨原木");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get(),"黄花梨木板");
        this.add(ChangShengJueBlocks.JI_CHI_MU_LOG.get(),"鸡翅木原木");
        this.add(ChangShengJueBlocks.STRIPPED_JI_CHI_MU_LOG.get(),"去皮鸡翅木原木");
        this.add(ChangShengJueBlocks.JI_CHI_MU_PLANKS.get(),"鸡翅木木板");
        this.add(ChangShengJueBlocks.ZI_TAN_LOG.get(),"紫檀原木");
        this.add(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get(),"去皮紫檀原木");
        this.add(ChangShengJueBlocks.ZI_TAN_PLANKS.get(),"紫檀木板");
        this.add(ChangShengJueBlocks.POPLAR_LOG.get(),"白杨原木");
        this.add(ChangShengJueBlocks.POPLAR_LEAVES.get(),"白杨树叶");
        this.add(ChangShengJueBlocks.POPLAR_SAPLING.get(),"白杨树苗");
        this.add(ChangShengJueBlocks.POPLAR_DEFOLIATION.get(),"白杨落叶");

        this.add(ChangShengJueBlocks.MULBERRY_LOG.get(),"桑树原木");
        this.add(ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get(),"去皮桑树原木");
        this.add(ChangShengJueBlocks.MULBERRY_LEAVES.get(),"桑树树叶");
        this.add(ChangShengJueBlocks.MULBERRY_SAPLING.get(),"桑树树苗");

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

        this.add(ChangShengJueBlocks.STONE_LAMPS_BASE_BLOCK.get(),"石灯底座");
        this.add(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get(),"未点亮的石灯");
        this.add(ChangShengJueBlocks.STONE_LAMPS_LIANG_BLOCK.get(),"石灯");
        this.add(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get(),"黄色石狮子");
        this.add(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get(),"灰色石狮子");
        this.add(ChangShengJueBlocks.BAI_HUA_FU_TI_BLOCK.get(),"白桦扶梯");
        this.add(ChangShengJueBlocks.YUN_SHAN_FU_TI_BLOCK.get(),"云杉扶梯");

        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE.get(),"灰色筒瓦块");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE.get(),"红色筒瓦块");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get(),"黑色筒瓦块");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get(),"金色筒瓦块");
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get(),"青色筒瓦块");

        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get(),"黑色筒瓦");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get(),"金色筒瓦");
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get(),"青色筒瓦");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get(),"灰色筒瓦");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get(),"红色筒瓦");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_1.get(),"青色瓦当");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_1.get(),"灰色瓦当");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_1.get(),"红色瓦当");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_1.get(),"黑色瓦当");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_1.get(),"金色瓦当");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_2.get(),"青色双层筒瓦");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_2.get(),"灰色双层筒瓦");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_2.get(),"红色双层筒瓦");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get(),"黑色双层筒瓦");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_2.get(),"金色双层筒瓦");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_3.get(),"青色小鸱吻");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_3.get(),"灰色小鸱吻");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_3.get(),"红色小鸱吻");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_3.get(),"黑色小鸱吻");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_3.get(),"金色小鸱吻");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_4.get(),"青色脊瓦");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_4.get(),"灰色脊瓦");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_4.get(),"红色脊瓦");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_4.get(),"黑色脊瓦");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_4.get(),"金色脊瓦");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_5.get(),"青色高筒瓦");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_5.get(),"灰色高筒瓦");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_5.get(),"红色高筒瓦");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_5.get(),"黑色高筒瓦");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_5.get(),"金色高筒瓦");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_6.get(),"青色双层脊瓦");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_6.get(),"灰色双层脊瓦");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_6.get(),"红色双层脊瓦");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_6.get(),"黑色双层脊瓦");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_6.get(),"金色双层脊瓦");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_7.get(),"青色飞檐筒瓦");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_7.get(),"灰色飞檐筒瓦");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_7.get(),"红色飞檐筒瓦");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_7.get(),"黑色飞檐筒瓦");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_7.get(),"金色飞檐筒瓦");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_8.get(),"青色脊兽筒瓦");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_8.get(),"灰色脊兽筒瓦");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_8.get(),"红色脊兽筒瓦");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_8.get(),"黑色脊兽筒瓦");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_8.get(),"金色脊兽筒瓦");

        this.add(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get(),"青色双层蹲兽脊瓦");
        this.add(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get(),"灰色双层蹲兽脊瓦");
        this.add(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get(),"红色双层蹲兽脊瓦");
        this.add(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get(),"黑色双层蹲兽脊瓦");
        this.add(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get(),"金色双层蹲兽脊瓦");

        this.add(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE_1.get(),"青色蹲兽脊瓦");
        this.add(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE_1.get(),"灰色蹲兽脊瓦");
        this.add(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE_1.get(),"红色蹲兽脊瓦");
        this.add(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE_1.get(),"黑色蹲兽脊瓦");
        this.add(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE_1.get(),"金色蹲兽脊瓦");


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

        this.add(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.get(), "青色垂脊筒瓦");
        this.add(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.get(), "灰色垂脊筒瓦");
        this.add(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.get(), "红色垂脊筒瓦");
        this.add(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.get(), "黑色垂脊筒瓦");
        this.add(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.get(), "金色垂脊筒瓦");

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

        this.add(ChangShengJueBlocks.DOOR_BIRCH_BLOCK.get(), "白桦木门");
        this.add(ChangShengJueBlocks.DOOR_ACACIA_BLOCK.get(), "金合欢木门");
        this.add(ChangShengJueBlocks.DOOR_DARK_OAK_BLOCK.get(), "深色橡木门");
        this.add(ChangShengJueBlocks.DOOR_OAK_BLOCK.get(), "橡木门");
        this.add(ChangShengJueBlocks.DOOR_SPRUCE_BLOCK.get(), "云杉木门");

        this.add(ChangShengJueBlocks.MEI_REN_KAO_ACACIA_BLOCK.get(), "金合欢木美人靠");
        this.add(ChangShengJueBlocks.MEI_REN_KAO_DARK_OAK_BLOCK.get(), "深色橡木美人靠");
        this.add(ChangShengJueBlocks.MEI_REN_KAO_OAK_BLOCK.get(), "橡木美人靠");
        this.add(ChangShengJueBlocks.MEI_REN_KAO_SPRUCE_BLOCK.get(), "云杉木美人靠");

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
        this.add(ChangShengJueBlocks.DESK.get(), "案台");
        this.add(ChangShengJueBlocks.PIG_TROUGH.get(), "牲畜食槽");

        this.add(ChangShengJueBlocks.PLAQUE.get(), "牌匾");
        this.add(ChangShengJueBlocks.SHING_MUN_LEFT.get(), "小城门(左)");
        this.add(ChangShengJueBlocks.SHING_MUN_RIGHT.get(), "小城门(右)");

        this.add(ChangShengJueBlocks.BIG_SHING_MUN_LEFT.get(), "大城门(左)");
        this.add(ChangShengJueBlocks.BIG_SHING_MUN_RIGHT.get(), "大城门(右)");
        //实体生物
        this.add(ChangShengJueEntity.BUTTERFLY_ENTITY.get(), "蝴蝶");
        this.add(ChangShengJueEntity.MONKEY_ENTITY.get(), "猴");
        this.add(ChangShengJueEntity.DRAGONFLY_ENTITY.get(), "蜻蜓");
        this.add(ChangShengJueEntity.CICADA_ENTITY.get(), "蝉");
        this.add(ChangShengJueEntity.CRANE_ENTITY.get(), "鹤");
        this.add(ChangShengJueEntity.MALE_PEACOCK_ENTITY.get(), "孔雀");
        this.add(ChangShengJueEntity.FEMALE_PEACOCK_ENTITY.get(), "孔雀");
        this.add(ChangShengJueEntity.STAG_ENTITY.get(), "鹿");
        this.add(ChangShengJueEntity.HIND_ENTITY.get(), "鹿");
        this.add(ChangShengJueEntity.TIGER_ENTITY.get(), "老虎");
        this.add(ChangShengJueEntity.CROC_ENTITY.get(), "鳄鱼");

        this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_farmer", "农民");
        this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_potter", "窑工");
        this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_potter_1", "高级窑工");
        this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_hunter", "猎人");
        this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_chief", "村长");
        this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_seamstress", "缝工");

        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_farmer", "农民");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_potter", "窑工");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_potter_1", "高级窑工");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_hunter", "猎人");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_chief", "村长");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_seamstress", "缝工");

        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager", "村民");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.none", "村民");
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
        this.add(ChangShengJueEffects.GOLDEN_BELL_JAR_EFFECT.get(), "金钟罩");
        this.add(ChangShengJueEffects.TURTLE_BREATH_EFFECT.get(), "龟息");
        this.add(ChangShengJueEffects.BILUOCHUN_TEAS.get(), "碧螺春");
        this.add(ChangShengJueEffects.LONG_JING_TEAS.get(), "龙井");
        this.add(ChangShengJueEffects.FEN_JIU.get(), "汾酒");
        this.add(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get(), "麦块贡酒");
        this.add(ChangShengJueEffects.SHI_LI_XIANG.get(), "十里香");
        this.add(ChangShengJueEffects.DRUNKEN.get(), "醉酒");

        //群系
        this.add("biome.chang_sheng_jue.chang_shen_jue_prairie", "慕然草原");

        //按键
        this.add("key."+ ChangShengJue.MOD_ID +".key.category", "长生诀");
        this.add("key."+ ChangShengJue.MOD_ID +".key.ability_1", "技能1");
        this.add("key."+ ChangShengJue.MOD_ID +".key.ability_2", "技能2");
        this.add("key."+ ChangShengJue.MOD_ID +".key.ability_3", "技能3");

        //存储
        this.add("container.hercules", "大力神功");

        //死亡信息
        this.add("death.attack.bleed", "%1$s失血过多。");
        this.add("death.attack.martial_arts", "%1$s被%2$s强大的武功杀死了。");
    }
}
