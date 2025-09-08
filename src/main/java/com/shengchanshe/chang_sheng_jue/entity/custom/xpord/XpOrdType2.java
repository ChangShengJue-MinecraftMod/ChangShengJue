package com.shengchanshe.chang_sheng_jue.entity.custom.xpord;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.kungfu.externalkunfu.ExternalKungFuCapability;
import com.shengchanshe.chang_sheng_jue.kungfu.internalkungfu.InternalKungFuCapability;
import com.shengchanshe.chang_sheng_jue.martial_arts.IKungFuUpgradable;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 第二种XpOrd实体
public class XpOrdType2 extends ExperienceOrb {

    // 构造函数
    public XpOrdType2(EntityType<? extends ExperienceOrb> entityType, Level level) {
        super(entityType, level);
    }
    
    // 自定义构造函数，用于生成时设置值
    public XpOrdType2(Level level, double x, double y, double z, int value) {
        super(level, x, y, z, value);
    }
    
    // 自定义碰撞玩家方法，替换为完整的外功经验分配逻辑
    @Override
    public void playerTouch(Player player) {
        if (!this.level().isClientSide && player.takeXpDelay == 0) {
            if (MinecraftForge.EVENT_BUS.post(new PlayerXpEvent.PickupXp(player, this))) {
                return;
            }
            player.takeXpDelay = 2;
            player.take(this, 1);
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                // 获取所有已学武功
                List<IKungFuUpgradable> kungFus = new ArrayList<>();
                cap.getAllLearned().forEach(kungFu -> {
                    if (kungFu instanceof IKungFuUpgradable upgradable) {
                        kungFus.add(upgradable);
                    }
                });
                // 按当前经验数量排序（从高到低）\
                System.out.println(5);
                kungFus.sort(Comparator.comparingInt(IKungFuUpgradable::getExp).reversed());

                // 保存初始经验数量
                int originalValue = this.value;

                // 分配经验直到用完
                for (IKungFuUpgradable kungFu : kungFus) {
                    if (!kungFu.toString().contains("external_kunfu")) {
                        continue;
                    }

                    System.out.println("6-" + kungFu.toString());
                    if (value > 0 && kungFu.getLevel() < kungFu.getMaxLevel()) {
                        System.out.println("7-" + kungFu.toString());
                        int expToAdd = Math.min(value, kungFu.getMaxExp() - kungFu.getExp());
                        kungFu.addExp(player, expToAdd);
                        value -= expToAdd;
                        System.out.println("已分配经验：" + expToAdd);
                        System.out.println(kungFu.getExp());
                        //输出名字
                        System.out.println(kungFu.toString());
                    }
                }
                if (value == originalValue) {
                    int appleCount = 3 + player.getRandom().nextInt(4);
                    player.addItem(new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), appleCount));
                }
            });
            player.takeXpDelay = 2;
            player.take(this, 1);
//            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
//                if (cap.getKungFuLevel(GoldenBellJar.KUNG_FU_ID.toString()) >= 1) {
//                    System.out.println(2);
//                }
//                //Hercules
//                if (cap.getKungFuLevel(Hercules.KUNG_FU_ID.toString()) >= 1) {
//                    System.out.println(3);
//                }
//                //ImmortalMiracle
//                if (cap.getKungFuLevel(ImmortalMiracle.KUNG_FU_ID.toString()) >= 1) {
//                    System.out.println(4);
//                }
//                //Paoding
//                if (cap.getKungFuLevel(Paoding.KUNG_FU_ID.toString()) >= 1) {
//                    System.out.println(5);
//                }
//                if (cap.getKungFuLevel(QianKunDaNuoYi.KUNG_FU_ID.toString()) >= 1) {
//                    System.out.println(6);
//                }
//                if (cap.getKungFuLevel(TheClassicsOfTendonChanging.KUNG_FU_ID.toString()) >= 1) {
//                    System.out.println(7);
//                }
//                if (cap.getKungFuLevel(WuGangCutGui.KUNG_FU_ID.toString()) >= 1) {
//                    System.out.println(8);
//                }
//                if (cap.getKungFuLevel(YugongMovesMountains.KUNG_FU_ID.toString()) >= 1) {
//                    System.out.println(9);
//                }
//            });
            this.discard();
        }
    }
}
