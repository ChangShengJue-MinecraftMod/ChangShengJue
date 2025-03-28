package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.entity.custom.butterfly.Butterfly;
import com.shengchanshe.changshengjue.entity.custom.cicada.Cicada;
import com.shengchanshe.changshengjue.entity.custom.crane.Crane;
import com.shengchanshe.changshengjue.entity.custom.croc.Croc;
import com.shengchanshe.changshengjue.entity.custom.deer.AbstractDeer;
import com.shengchanshe.changshengjue.entity.custom.dragonfly.Dragonfly;
import com.shengchanshe.changshengjue.entity.custom.monkey.Monkey;
import com.shengchanshe.changshengjue.entity.custom.peacock.AbstractPeacock;
import com.shengchanshe.changshengjue.entity.custom.tiger.Tiger;
import com.shengchanshe.changshengjue.entity.custom.wuxia.assassin.Assassin;
import com.shengchanshe.changshengjue.entity.custom.wuxia.bandit.Bandit;
import com.shengchanshe.changshengjue.entity.custom.wuxia.blacksmith.Blacksmith;
import com.shengchanshe.changshengjue.entity.custom.wuxia.challenger.Challenger;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.GangLeader;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.clubbed.ClubbedGangLeader;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.knife.KnifeGangLeader;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.lance.LanceGangLeader;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.sword.SwordGangLeader;
import com.shengchanshe.changshengjue.entity.custom.wuxia.innkeeper.female.FemaleInnkeeper;
import com.shengchanshe.changshengjue.entity.custom.wuxia.innkeeper.male.MaleInnkeeper;
import com.shengchanshe.changshengjue.entity.custom.wuxia.piglin.PiglinWuXia;
import com.shengchanshe.changshengjue.entity.custom.wuxia.villain.Villain;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagerEntity;
import com.shengchanshe.changshengjue.entity.villagers.warrior.Warrior;
import com.shengchanshe.changshengjue.entity.villagers.worker.KilnWorker;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class CSJEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event){
        event.put(ChangShengJueEntity.BUTTERFLY.get(), Butterfly.setAttributes());
        event.put(ChangShengJueEntity.MONKEY.get(), Monkey.setAttributes());
        event.put(ChangShengJueEntity.DRAGONFLY.get(), Dragonfly.setAttributes());
        event.put(ChangShengJueEntity.CICADA.get(), Cicada.setAttributes());
        event.put(ChangShengJueEntity.CRANE.get(), Crane.setAttributes());
        event.put(ChangShengJueEntity.MALE_PEACOCK.get(), AbstractPeacock.setAttributes());
        event.put(ChangShengJueEntity.FEMALE_PEACOCK.get(), AbstractPeacock.setAttributes());
        event.put(ChangShengJueEntity.STAG.get(), AbstractDeer.setAttributes());
        event.put(ChangShengJueEntity.HIND.get(), AbstractDeer.setAttributes());
        event.put(ChangShengJueEntity.TIGER.get(), Tiger.setAttributes());
        event.put(ChangShengJueEntity.CROC.get(), Croc.setAttributes());
        event.put(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER.get(), ChangShengJueVillagerEntity.setAttributes());

        event.put(ChangShengJueEntity.WARRIOR.get(), Warrior.setAttributes());
        event.put(ChangShengJueEntity.KILN_WORKER.get(), KilnWorker.setAttributes());
        event.put(ChangShengJueEntity.MALE_INNKEEPER.get(), MaleInnkeeper.setAttributes());
        event.put(ChangShengJueEntity.FEMALE_INNKEEPER.get(), FemaleInnkeeper.setAttributes());
        event.put(ChangShengJueEntity.CHALLENGER.get(), Challenger.setAttributes());
        event.put(ChangShengJueEntity.BLACKSMITH.get(), Blacksmith.setAttributes());
        event.put(ChangShengJueEntity.LANCE_GANG_LEADER.get(), LanceGangLeader.setAttributes());
        event.put(ChangShengJueEntity.KNIFE_GANG_LEADER.get(), KnifeGangLeader.setAttributes());
        event.put(ChangShengJueEntity.SWORD_GANG_LEADER.get(), SwordGangLeader.setAttributes());
        event.put(ChangShengJueEntity.CLUBBED_GANG_LEADER.get(), ClubbedGangLeader.setAttributes());
        event.put(ChangShengJueEntity.GANG_LEADER.get(), GangLeader.setAttributes());
        event.put(ChangShengJueEntity.BANDIT.get(), Bandit.setAttributes());
        event.put(ChangShengJueEntity.VILLAIN.get(), Villain.setAttributes());
        event.put(ChangShengJueEntity.ASSASSIN.get(), Assassin.setAttributes());
        event.put(ChangShengJueEntity.PIGLIN_WU_XIA.get(), PiglinWuXia.setAttributes());
        event.put(ChangShengJueEntity.WITCH_WU_XIA.get(), Witch.createAttributes().build());
        event.put(ChangShengJueEntity.EVOKER_WU_XIA.get(), Evoker.createAttributes().build());
        event.put(ChangShengJueEntity.VINDICATOR_WU_XIA.get(), Vindicator.createAttributes().build());
        event.put(ChangShengJueEntity.PILLAGER_WU_XIA.get(), Pillager.createAttributes().build());

        event.put(ChangShengJueEntity.STAKES.get(), StakesEntity.setAttributes());
    }

}
