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
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagerEntity;
import com.shengchanshe.changshengjue.entity.villagers.warrior.Warrior;
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

        event.put(ChangShengJueEntity.STAKES.get(), StakesEntity.setAttributes());
    }

}
