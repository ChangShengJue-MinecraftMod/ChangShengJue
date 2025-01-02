//package com.shengchanshe.changshengjue.martial_arts;
//
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//
//import java.util.Set;
//
//public class QianKunDaNuoYi extends MartialArtsData {
//
//    public QianKunDaNuoYi(boolean learned, boolean mastered, int cooldown, int level, int pFooddeplete, int pSaturationdeplete, String effect, Set<Integer> boundKeys) {
//        super(learned, mastered, cooldown, level, pFooddeplete, pSaturationdeplete, effect, boundKeys);
//    }
//
//    @Override
//    public void execute(LivingEntity player) {
//        if (player instanceof Player){
//            // 检查技能是否冷却完成
//            if (getCooldown() > 0) {
//                return;
//            }
//            // 检查玩家是否有足够的饱食度和饱和度
//            if (((Player) player).getFoodData().getFoodLevel() < getpFooddeplete() && ((Player) player).getFoodData().getSaturationLevel() < getpSaturationdeplete()) {
//                return;
//            }
//
//            // 消耗饱食度和饱和度
//            ((Player) player).getFoodData().eat(-getpFooddeplete(), -getpSaturationdeplete());
//
//            // 有35%的概率将下次遭受伤害转移给攻击者
//            if (player.getRandom().nextFloat() < 0.35) {
//                setCooldown(getLevel() * 10); // 设置冷却时间
//            }
//        }
//
//    }
//}
