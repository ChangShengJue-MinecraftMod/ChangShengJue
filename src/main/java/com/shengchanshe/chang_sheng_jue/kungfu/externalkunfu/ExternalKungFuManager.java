package com.shengchanshe.chang_sheng_jue.kungfu.externalkunfu;

import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.assassin.Assassin;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.clubbed.ClubbedGangLeader;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.knife.KnifeGangLeader;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.lance.LanceGangLeader;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.other.GangLeader;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.sword.SwordGangLeader;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.clubbed.ClubbedMingXia;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.knife.KnifeMingXia;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.sword.SwordMingXia;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.kungfu.externalkunfu.kungfu.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.*;

public class ExternalKungFuManager {
    private final Map<ExternalKungFu, ExternalKungFuCapability> kungFuCapabilities = new HashMap<>();

    public ExternalKungFuManager() {
        // 初始化每种武功的能力
        kungFuCapabilities.put(ExternalKungFu.DUGU_NINE_SWORDS, new DuguNineSwords());
        kungFuCapabilities.put(ExternalKungFu.GAO_MARKSMANSHIP, new GaoMarksmanship());
        kungFuCapabilities.put(ExternalKungFu.GOLDEN_BLACK_KNIFE_METHOD, new GoldenBlackKnifeMethod());
        kungFuCapabilities.put(ExternalKungFu.RELENTLESS_THROWING_KNIVES, new RelentlessThrowingKnives());
        kungFuCapabilities.put(ExternalKungFu.SHAOLIN_STICK_METHOD, new ShaolinStickMethod());
        kungFuCapabilities.put(ExternalKungFu.XUANNU_SWORDSMANSHIP, new XuannuSwordsmanship());
        kungFuCapabilities.put(ExternalKungFu.GE_SHAN_DA_NIU, new GeShanDaNiu());
        kungFuCapabilities.put(ExternalKungFu.SUNFLOWER_POINT_CAVEMAN, new SunflowerPointCaveman());
    }

    // 从 NBT 数据中创建 KungFuCapability 实例
    public static ExternalKungFuCapability createExternalKungFuCapabilityFromTag(String kungFuType) {
        return switch (kungFuType) {
            case "DuguNineSwords" -> new DuguNineSwords();
            case "GaoMarksmanship" -> new GaoMarksmanship();
            case "GoldenBlackKnifeMethod" -> new GoldenBlackKnifeMethod();
            case "RelentlessThrowingKnives" -> new RelentlessThrowingKnives();
            case "ShaolinStickMethod" -> new ShaolinStickMethod();
            case "XuannuSwordsmanship" -> new XuannuSwordsmanship();
            case "GeShanDaNiu" -> new GeShanDaNiu();
            case "SunflowerPointCaveman" -> new SunflowerPointCaveman();
            default -> null;
        };
    }

    public static ItemStack createExternalKungFuBookItems(String kungFuType) {
        return switch (kungFuType) {
            case "DuguNineSwords" -> new ItemStack(ChangShengJueItems.DUGU_NINE_SWORDS.get());
            case "GaoMarksmanship" -> new ItemStack(ChangShengJueItems.GAO_MARKSMANSHIP.get());
            case "GoldenBlackKnifeMethod" -> new ItemStack(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get());
            case "RelentlessThrowingKnives" -> new ItemStack(ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get());
            case "ShaolinStickMethod" -> new ItemStack(ChangShengJueItems.SHAOLIN_STICK_METHOD.get());
            case "XuannuSwordsmanship" -> new ItemStack(ChangShengJueItems.XUANNU_SWORDSMANSHIP.get());
            case "GeShanDaNiu" -> new ItemStack(ChangShengJueItems.GE_SHAN_DA_NIU.get());
            case "SunflowerPointCaveman" -> new ItemStack(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get());
            default -> null;
        };
    }

    public static List<ExternalKungFuCapability> createExternalKungFuCapabilitiesFromTag(String kungFuType) {
        List<ExternalKungFuCapability> externalKungFuCapabilities = new ArrayList<>();
        switch (kungFuType) {
            case "DuguNineSwords":
                externalKungFuCapabilities.add(new DuguNineSwords());
                break;
            case "GaoMarksmanship":
                externalKungFuCapabilities.add(new GaoMarksmanship());
                break;
            case "GoldenBlackKnifeMethod":
                externalKungFuCapabilities.add(new GoldenBlackKnifeMethod());
                break;
            case "RelentlessThrowingKnives":
                externalKungFuCapabilities.add(new RelentlessThrowingKnives());
                break;
            case "ShaolinStickMethod":
                externalKungFuCapabilities.add(new ShaolinStickMethod());
                break;
            case "XuannuSwordsmanship":
                externalKungFuCapabilities.add(new XuannuSwordsmanship());
                break;
            case "GeShanDaNiu":
                externalKungFuCapabilities.add(new GeShanDaNiu());
                break;
            case "SunflowerPointCaveman":
                externalKungFuCapabilities.add(new SunflowerPointCaveman());
                break;
            default:
                // 如果kungFuType不匹配任何已知类型，可以在这里添加默认行为
                break;
        }
        return externalKungFuCapabilities;
    }

    public List<ExternalKungFuCapability> getRandomExternalKungFuCapabilities(LivingEntity entity) {
        Random random = new Random();
        List<ExternalKungFu> availableKungFus = new ArrayList<>(Arrays.asList(ExternalKungFu.values()));
        List<ExternalKungFuCapability> externalKungFuCapabilities = new ArrayList<>();

        if (!(entity instanceof Assassin) && !(entity instanceof GangLeader)) {
            availableKungFus.remove(ExternalKungFu.RELENTLESS_THROWING_KNIVES);
        }
        //根据生物判断分配第一种外功
        if (entity instanceof LanceGangLeader){
            externalKungFuCapabilities.add(new GaoMarksmanship());
            availableKungFus.remove(ExternalKungFu.DUGU_NINE_SWORDS);
            availableKungFus.remove(ExternalKungFu.GOLDEN_BLACK_KNIFE_METHOD);
            availableKungFus.remove(ExternalKungFu.SHAOLIN_STICK_METHOD);
            availableKungFus.remove(ExternalKungFu.XUANNU_SWORDSMANSHIP);
        }

        if (entity instanceof KnifeGangLeader || entity instanceof KnifeMingXia){
            externalKungFuCapabilities.add(new GoldenBlackKnifeMethod());
            availableKungFus.remove(ExternalKungFu.DUGU_NINE_SWORDS);
            availableKungFus.remove(ExternalKungFu.GAO_MARKSMANSHIP);
            availableKungFus.remove(ExternalKungFu.SHAOLIN_STICK_METHOD);
            availableKungFus.remove(ExternalKungFu.XUANNU_SWORDSMANSHIP);
        }

        if (entity instanceof SwordGangLeader || entity instanceof SwordMingXia){
            availableKungFus.remove(ExternalKungFu.GOLDEN_BLACK_KNIFE_METHOD);
            availableKungFus.remove(ExternalKungFu.GAO_MARKSMANSHIP);
            availableKungFus.remove(ExternalKungFu.SHAOLIN_STICK_METHOD);
            ExternalKungFu randomKungFu = availableKungFus.get(random.nextInt(availableKungFus.size()));
            externalKungFuCapabilities.add(kungFuCapabilities.get(randomKungFu));
        }

        if (entity instanceof ClubbedGangLeader || entity instanceof ClubbedMingXia){
            externalKungFuCapabilities.add(new ShaolinStickMethod());
            availableKungFus.remove(ExternalKungFu.DUGU_NINE_SWORDS);
            availableKungFus.remove(ExternalKungFu.GAO_MARKSMANSHIP);
            availableKungFus.remove(ExternalKungFu.GOLDEN_BLACK_KNIFE_METHOD);
            availableKungFus.remove(ExternalKungFu.XUANNU_SWORDSMANSHIP);
        }

        if (entity instanceof GangLeader){
            availableKungFus.remove(ExternalKungFu.SHAOLIN_STICK_METHOD);
            availableKungFus.remove(ExternalKungFu.DUGU_NINE_SWORDS);
            availableKungFus.remove(ExternalKungFu.GAO_MARKSMANSHIP);
            availableKungFus.remove(ExternalKungFu.GOLDEN_BLACK_KNIFE_METHOD);
            availableKungFus.remove(ExternalKungFu.XUANNU_SWORDSMANSHIP);
        }

        if (entity instanceof GangLeader){
            for (int i = 0; i < 2; i++) {
                if (!availableKungFus.isEmpty()) {
                    ExternalKungFu randomKungFu = availableKungFus.get(random.nextInt(availableKungFus.size()));
                    externalKungFuCapabilities.add(kungFuCapabilities.get(randomKungFu));
                    availableKungFus.remove(randomKungFu);
                }
            }
        }else {
            ExternalKungFu randomKungFu = availableKungFus.get(random.nextInt(availableKungFus.size()));
            externalKungFuCapabilities.add(kungFuCapabilities.get(randomKungFu));
        }
        return externalKungFuCapabilities;
    }


    public ExternalKungFuCapability getRandomExternalKungFuCapability(LivingEntity entity) {
        Random random = new Random();
        List<ExternalKungFu> availableKungFus = new ArrayList<>(Arrays.asList(ExternalKungFu.values()));

        if (!(entity instanceof Assassin)) {
            availableKungFus.remove(ExternalKungFu.RELENTLESS_THROWING_KNIVES);
        }

        if (entity instanceof Assassin){
            availableKungFus.remove(ExternalKungFu.SHAOLIN_STICK_METHOD);
            availableKungFus.remove(ExternalKungFu.GAO_MARKSMANSHIP);
            availableKungFus.remove(ExternalKungFu.GOLDEN_BLACK_KNIFE_METHOD);
        }

        ExternalKungFu randomKungFu = availableKungFus.get(random.nextInt(availableKungFus.size()));
        return kungFuCapabilities.get(randomKungFu);
    }
}
