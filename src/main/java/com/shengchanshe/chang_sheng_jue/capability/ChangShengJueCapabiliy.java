package com.shengchanshe.chang_sheng_jue.capability;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.cultivation.entity.CultivationCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.kungfu.IKungFuCapability;
import com.shengchanshe.chang_sheng_jue.capability.kungfu.KungFuCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.event.xiu_xian.XiuXianEvent;
import com.shengchanshe.chang_sheng_jue.quest.QuestManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class ChangShengJueCapabiliy {
    public static final Capability<IKungFuCapability> KUNGFU =
            CapabilityManager.get(new CapabilityToken<>() {});

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.register(CultivationCapabilityProvider.class);
        event.register(PlayerQuestCapabilityProvider.class);
        event.register(KungFuCapabilityProvider.class);
    }

    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player player) {//判断生物为玩家,只给玩家添加这些能力
            if (!event.getObject().getCapability(KUNGFU).isPresent()) {
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID, "kungfu"), new KungFuCapabilityProvider(player));
            }
            if (!event.getObject().getCapability(CultivationCapabilityProvider.XIU_XIAN_CAPABILITY).isPresent()) {
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID, "spirit_root"), new CultivationCapabilityProvider());
            }
            if (!event.getObject().getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).isPresent()) {
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID, "quest"), new PlayerQuestCapabilityProvider());
            }
        }
    }


    //玩家克隆事件,用于玩家死亡重生时或者从末地回到主世界时克隆旧玩家的属性到新玩家
    public static void onPlayerCloned(PlayerEvent.Clone event){
        Player oldPlayer = event.getOriginal();
        oldPlayer.reviveCaps();
        //武功
        oldPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(oldStore->
                event.getEntity().getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(newStore->  newStore.deserializeNBT(oldStore.serializeNBT())));
        //任务
        oldPlayer.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(newStore-> newStore.copyFrom(oldStore)));

        //修仙
        XiuXianEvent.onPlayerCloned(event);
        event.getOriginal().invalidateCaps();
    }

    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        //玩家进入世界时同步能力数据
        if(!event.getLevel().isClientSide()) {
            if(event.getEntity() instanceof ServerPlayer player) {
                QuestManager.getInstance().syncQuestsToPlayer(player); // 全量同步
                XiuXianEvent.onPlayerJoinWorld(event);
                player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY)
                        .ifPresent(cap -> cap.syncToClient(player));
                player.getCapability(KUNGFU).ifPresent(cap -> cap.syncToClient(player));
            }
        }
    }
}
