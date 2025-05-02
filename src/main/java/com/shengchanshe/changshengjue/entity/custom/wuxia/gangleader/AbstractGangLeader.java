package com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader;

import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.GangleaderTradingMenu;
import com.shengchanshe.changshengjue.quest.Quest;
import com.shengchanshe.changshengjue.quest.QuestManager;
import com.shengchanshe.changshengjue.entity.custom.wuxia.AbstractWuXia;
import com.shengchanshe.changshengjue.entity.custom.wuxia.AbstractWuXiaMerchant;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

import java.util.OptionalInt;

public class AbstractGangLeader extends AbstractWuXiaMerchant {
    private Quest quest;

    public AbstractGangLeader(EntityType<? extends AbstractWuXia> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.quest = QuestManager.getInstance().generateNewQuestForNpc(this);
    }
//    @Override
//    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
//        this.quest = QuestManager.getInstance().generateNewQuestForNpc(this.getUUID());
//    }

    public void resetOffers() {
        this.offers = null; // 强制下次访问时重新生成
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if (this.quest != null){
            pCompound.putUUID("QuestID",this.quest.getQuestId());
            this.quest.saveNBTData(pCompound);
        }else {
            QuestManager.getInstance().generateNewQuestForNpc(this);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("QuestId")) {
            this.quest = new Quest(pCompound);
            quest.loadNBTData(pCompound);
        }else {
            QuestManager.getInstance().generateNewQuestForNpc(this);
        }
    }


    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

}
