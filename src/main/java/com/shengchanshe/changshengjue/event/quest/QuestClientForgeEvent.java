package com.shengchanshe.changshengjue.event.quest;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class QuestClientForgeEvent {

}
