package com.shengchanshe.changshengjue.datagen.language;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
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
        this.add("itemGroup" + ChangShengJue.MOD_ID + "_building_block", "长生决 建筑方块");
        this.add("itemGroup" + ChangShengJue.MOD_ID + "_natural_blocks", "长生决 自然方块");
        this.add("itemGroup" + ChangShengJue.MOD_ID + "_functional", "长生决 功能方块");
        this.add("itemGroup" + ChangShengJue.MOD_ID + "_ingredients", "长生决 原材料");
        this.add("itemGroup" + ChangShengJue.MOD_ID + "_food_and_drink", "长生决 食物与饮品");
        this.add("itemGroup" + ChangShengJue.MOD_ID + "_combat", "长生决 战斗用品");
        this.add("itemGroup" + ChangShengJue.MOD_ID + "_tool", "长生决 工具与实用物品");
        this.add("itemGroup" + ChangShengJue.MOD_ID + "_spawn_eggs", "长生决 刷怪蛋");
        //食物
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
        this.add(ChangShengJueItems.MULBERRY_JUICE.get(),"生鳄鱼肉");
        this.add(ChangShengJueItems.APPLE_JUICE.get(),"熟鳄鱼肉");
        this.add(ChangShengJueItems.HOT_PEAR_SOUP.get(),"生孔雀肉");
        this.add(ChangShengJueItems.GRAPE_JUICE.get(),"熟孔雀肉");
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
        this.add(ChangShengJueItems.XIAO_MI_FAN.get(),"小米饭");
        this.add(ChangShengJueItems.MI_FAN.get(),"米饭");
        this.add(ChangShengJueItems.GUI_HUA_TANG_OU.get(),"桂花糖藕");
        this.add(ChangShengJueItems.BA_BAO_ZHOU.get(),"八宝粥");
        this.add(ChangShengJueItems.BILUOCHUN_TEAS.get(),"碧螺春茶");
        this.add(ChangShengJueItems.LONG_JING_TEAS.get(),"龙井茶");
        this.add(ChangShengJueItems.FEN_JIU.get(),"汾酒");
        this.add(ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get(),"麦块贡酒");
        this.add(ChangShengJueItems.SHI_LI_XIANG.get(),"十里香");
        this.add(ChangShengJueItems.MANGO.get(),"芒果");
        this.add(ChangShengJueItems.BANANA.get(),"香蕉");
        this.add(ChangShengJueItems.PEAR.get(),"梨子");
        this.add(ChangShengJueItems.LICHEE.get(),"荔枝");

        this.add(ChangShengJueItems.DURIAN.get(),"梨子");
        this.add("durian_open","打开的榴莲");

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
        this.add(ChangShengJueItems.IMMORTAL_MIRACLE.get(),"不死神功");
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



//        this.add(ModBlocks.RUBY_BLOCK.get(),&quot;Ruby Block&quot;);
        //其他
    }
}
