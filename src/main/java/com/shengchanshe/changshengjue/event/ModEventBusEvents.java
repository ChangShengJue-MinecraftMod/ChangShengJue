package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.custom.*;
import com.shengchanshe.changshengjue.entity.custom.deer.AbstractDeer;
import com.shengchanshe.changshengjue.entity.custom.peacock.AbstractPeacockEntity;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueHunterEntity;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagerChiefEntity;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagerEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event){
        event.put(ChangShengJueEntity.BUTTERFLY_ENTITY.get(), ButterflyEntity.setAttributes());
        event.put(ChangShengJueEntity.MONKEY_ENTITY.get(), MonkeyEntity.setAttributes());
        event.put(ChangShengJueEntity.DRAGONFLY_ENTITY.get(), DragonflyEntity.setAttributes());
        event.put(ChangShengJueEntity.CICADA_ENTITY.get(), CicadaEntity.setAttributes());
        event.put(ChangShengJueEntity.CRANE_ENTITY.get(), CraneEntity.setAttributes());
        event.put(ChangShengJueEntity.MALE_PEACOCK_ENTITY.get(), AbstractPeacockEntity.setAttributes());
        event.put(ChangShengJueEntity.FEMALE_PEACOCK_ENTITY.get(), AbstractPeacockEntity.setAttributes());
        event.put(ChangShengJueEntity.STAG_ENTITY.get(), AbstractDeer.setAttributes());
        event.put(ChangShengJueEntity.HIND_ENTITY.get(), AbstractDeer.setAttributes());
        event.put(ChangShengJueEntity.TIGER_ENTITY.get(), TigerEntity.setAttributes());
        event.put(ChangShengJueEntity.CROC_ENTITY.get(), CrocEntity.setAttributes());
        event.put(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER.get(), ChangShengJueVillagerEntity.setAttributes());
        event.put(ChangShengJueEntity.CHANG_SHENG_JUE_HUNTER.get(), ChangShengJueHunterEntity.setAttributes());
        event.put(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER_CHIEF.get(), ChangShengJueVillagerChiefEntity.setAttributes());
    }
}
