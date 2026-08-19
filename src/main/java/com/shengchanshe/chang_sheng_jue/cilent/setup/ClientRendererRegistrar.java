package com.shengchanshe.chang_sheng_jue.cilent.setup;

import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.combat.beat_dog_stick.BeatDogStickAttackEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.dugu_nine_swords.DuguNineSwordsEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.ge_shan_da_niu.GeShanDaNiuRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.golden_black_knife_method.GoldenBlackKnifeMethodEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.lance.BaWangQiangAttackEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.lance.ThrownBaWangQiangRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.lance.ThrownRedTasselledSpearRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.stakes.StakesRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.throwingknives.ThrowingKnivesEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.tu_long_dao.TuLongDaoAttackEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.yi_tian_jian.YiTianJianAttackEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.custom.butterfly.ButterflyRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.cicada.CicadaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.crane.CraneRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.croc.CrocRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.deer.hind.HindRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.deer.stag.StagRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.dragonfly.DragonflyRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.monkey.MonkeyRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.female.FemalePeacockRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.male.MalePeacockRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.tiger.TigerRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.assassin.AssassinRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.bandit.BanditRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.blacksmith.BlacksmithRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.challenger.ChallengerRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.evoker.EvokerWuXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.clubbed.ClubbedGangLeaderRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.knife.KnifeGangLeaderRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.lance.LanceGangLeaderRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.other.GangLeaderRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.sword.SwordGangLeaderRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.innkeeper.female.FemaleInnkeeperRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.innkeeper.male.MaleInnkeeperRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.piglin.PiglinWuXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.pillager.PillagerWuXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.villain.VillainRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.vindicator.VindicatorWuXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.witch.WitchWuXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.clubbed.ClubbedMingXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.fist.FistMingXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.knife.KnifeMingXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.sword.SwordMingXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.villagers.render.ChangShengJueVillagerRender;
import com.shengchanshe.chang_sheng_jue.entity.villagers.warrior.WarriorRenderer;
import com.shengchanshe.chang_sheng_jue.entity.villagers.worker.KilnWorkerRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public final class ClientRendererRegistrar {
    private ClientRendererRegistrar() {
    }

    public static void register() {
        EntityRenderers.register(ChangShengJueEntity.BUTTERFLY.get(), ButterflyRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.MONKEY.get(), MonkeyRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.DRAGONFLY.get(), DragonflyRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CICADA.get(), CicadaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CRANE.get(), CraneRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.MALE_PEACOCK.get(), MalePeacockRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.FEMALE_PEACOCK.get(), FemalePeacockRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.STAG.get(), StagRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.HIND.get(), HindRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.TIGER.get(), TigerRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CROC.get(), CrocRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER.get(), ChangShengJueVillagerRender::new);

        EntityRenderers.register(ChangShengJueEntity.THROWING_KNIVES_ENTITY.get(), ThrowingKnivesEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.GE_SHAN_DA_NIU.get(), GeShanDaNiuRender::new);

        EntityRenderers.register(ChangShengJueEntity.BA_WANG_QIANG.get(), ThrownBaWangQiangRender::new);
        EntityRenderers.register(ChangShengJueEntity.RED_TASSELLED_SPEAR.get(), ThrownRedTasselledSpearRender::new);

        EntityRenderers.register(ChangShengJueEntity.DUGU_NINE_SOWRDS.get(), DuguNineSwordsEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.GOLDEN_BLACK_KNIFE_METHOD.get(), GoldenBlackKnifeMethodEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.BEAT_DOG_STICK_ATTACK.get(), BeatDogStickAttackEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.TU_LONG_DAO_ATTACK.get(), TuLongDaoAttackEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.BA_WANG_QIANG_ATTACK.get(), BaWangQiangAttackEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.YI_TIAN_JIAN_ATTACK.get(), YiTianJianAttackEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.STAKES.get(), StakesRender::new);

        EntityRenderers.register(ChangShengJueEntity.WARRIOR.get(), WarriorRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.KILN_WORKER.get(), KilnWorkerRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.MALE_INNKEEPER.get(), MaleInnkeeperRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.FEMALE_INNKEEPER.get(), FemaleInnkeeperRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CHALLENGER.get(), ChallengerRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.BLACKSMITH.get(), BlacksmithRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.LANCE_GANG_LEADER.get(), LanceGangLeaderRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.KNIFE_GANG_LEADER.get(), KnifeGangLeaderRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.SWORD_GANG_LEADER.get(), SwordGangLeaderRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CLUBBED_GANG_LEADER.get(), ClubbedGangLeaderRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.GANG_LEADER.get(), GangLeaderRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.BANDIT.get(), BanditRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.VILLAIN.get(), VillainRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.ASSASSIN.get(), AssassinRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.PIGLIN_WU_XIA.get(), PiglinWuXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.WITCH_WU_XIA.get(), WitchWuXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.EVOKER_WU_XIA.get(), EvokerWuXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.VINDICATOR_WU_XIA.get(), VindicatorWuXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.PILLAGER_WU_XIA.get(), PillagerWuXiaRenderer::new);
 
        EntityRenderers.register(ChangShengJueEntity.CLUBBED_MING_XIA.get(), ClubbedMingXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.SWORD_MING_XIA.get(), SwordMingXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.KNIFE_MING_XIA.get(), KnifeMingXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.FIST_MING_XIA.get(), FistMingXiaRenderer::new);
    }
}

