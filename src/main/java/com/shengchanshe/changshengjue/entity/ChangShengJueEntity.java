package com.shengchanshe.changshengjue.entity;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.combat.lance.ThrownBaWangQiang;
import com.shengchanshe.changshengjue.entity.combat.lance.BaWangQiangAttackEntity;
import com.shengchanshe.changshengjue.entity.combat.beat_dog_stick.BeatDogStickAttackEntity;
import com.shengchanshe.changshengjue.entity.combat.dugu_nine_swords.DuguNineSwordsEntity;
import com.shengchanshe.changshengjue.entity.combat.lance.ThrownRedTasselledSpear;
import com.shengchanshe.changshengjue.entity.combat.throwingknives.ThrowingKnivesEntity;
import com.shengchanshe.changshengjue.entity.combat.ge_shan_da_niu.GeShanDaNiuEntity;
import com.shengchanshe.changshengjue.entity.combat.golden_black_knife_method.GoldenBlackKnifeMethodEntity;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.entity.combat.tu_long_dao.TuLongDaoAttackEntity;
import com.shengchanshe.changshengjue.entity.combat.yi_tian_jian.YiTianJianAttackEntity;
import com.shengchanshe.changshengjue.entity.custom.butterfly.Butterfly;
import com.shengchanshe.changshengjue.entity.custom.cicada.Cicada;
import com.shengchanshe.changshengjue.entity.custom.crane.Crane;
import com.shengchanshe.changshengjue.entity.custom.croc.Croc;
import com.shengchanshe.changshengjue.entity.custom.deer.hind.Hind;
import com.shengchanshe.changshengjue.entity.custom.deer.stag.Stag;
import com.shengchanshe.changshengjue.entity.custom.dragonfly.Dragonfly;
import com.shengchanshe.changshengjue.entity.custom.monkey.Monkey;
import com.shengchanshe.changshengjue.entity.custom.peacock.female.FemalePeacock;
import com.shengchanshe.changshengjue.entity.custom.peacock.male.MalePeacock;
import com.shengchanshe.changshengjue.entity.custom.peacock.egg.PeacockEgg;
import com.shengchanshe.changshengjue.entity.custom.tiger.Tiger;
import com.shengchanshe.changshengjue.entity.decoration.seat.SeatEntity;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagerEntity;
import com.shengchanshe.changshengjue.entity.villagers.warrior.Warrior;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangShengJueEntity {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ChangShengJue.MOD_ID);

    public static final RegistryObject<EntityType<Butterfly>> BUTTERFLY =
            ENTITY_TYPES.register("butterfly",
                    () -> EntityType.Builder.of(Butterfly::new, MobCategory.CREATURE)
                            .sized(0.8f,0.2f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"butterfly").toString()));

    public static final RegistryObject<EntityType<Monkey>> MONKEY =
            ENTITY_TYPES.register("monkey",
                    () -> EntityType.Builder.of(Monkey::new, MobCategory.CREATURE)
                            .sized(1.0f,1.5f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"monkey").toString()));

    public static final RegistryObject<EntityType<Dragonfly>> DRAGONFLY =
            ENTITY_TYPES.register("dragonfly",
                    () -> EntityType.Builder.of(Dragonfly::new, MobCategory.CREATURE)
                            .sized(0.8f,0.4f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"dragonfly").toString()));
    // 蝉
    public static final RegistryObject<EntityType<Cicada>> CICADA =
            ENTITY_TYPES.register("cicada",
                    () -> EntityType.Builder.of(Cicada::new, MobCategory.CREATURE)
                            .sized(0.6f,0.5f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"cicada").toString()));

    public static final RegistryObject<EntityType<Crane>> CRANE =
            ENTITY_TYPES.register("crane",
                    () -> EntityType.Builder.of(Crane::new, MobCategory.CREATURE)
                            .sized(1.0f,1.4f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"crane").toString()));

    public static final RegistryObject<EntityType<MalePeacock>> MALE_PEACOCK =
            ENTITY_TYPES.register("male_peacock",
                    () -> EntityType.Builder.of(MalePeacock::new, MobCategory.CREATURE)
                            .sized(0.8f,1.4f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"male_peacock").toString()));

    public static final RegistryObject<EntityType<FemalePeacock>> FEMALE_PEACOCK =
            ENTITY_TYPES.register("female_peacock",
                    () -> EntityType.Builder.of(FemalePeacock::new, MobCategory.CREATURE)
                            .sized(0.8f,1.4f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"female_peacock").toString()));

    public static final RegistryObject<EntityType<Stag>> STAG =
            ENTITY_TYPES.register("stag",
                    () -> EntityType.Builder.of(Stag::new, MobCategory.CREATURE)
                            .sized(0.9F, 1.5F)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"stag").toString()));

    public static final RegistryObject<EntityType<Hind>> HIND =
            ENTITY_TYPES.register("hind",
                    () -> EntityType.Builder.of(Hind::new, MobCategory.CREATURE)
                            .sized(0.9F, 1.4F)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"hind").toString()));

    public static final RegistryObject<EntityType<Tiger>> TIGER =
            ENTITY_TYPES.register("tiger",
                    () -> EntityType.Builder.of(Tiger::new, MobCategory.CREATURE)
                            .sized(1.0F, 1.4F)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"tiger").toString()));

    public static final RegistryObject<EntityType<Croc>> CROC =
            ENTITY_TYPES.register("croc",
                    () -> EntityType.Builder.of(Croc::new, MobCategory.CREATURE)
                            .sized(1.15F, 0.5F)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"croc").toString()));

    public static final RegistryObject<EntityType<ChangShengJueVillagerEntity>> CHANG_SHENG_JUE_VILLAGER =
            ENTITY_TYPES.register("chang_sheng_jue_villager",
                    () -> EntityType.Builder.of(ChangShengJueVillagerEntity::new, MobCategory.MISC)
                            .sized(0.6F, 1.95F)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"chang_sheng_jue_villager").toString()));

    //武夫
    public static final RegistryObject<EntityType<Warrior>> WARRIOR =
            ENTITY_TYPES.register("warrior",
                    () -> EntityType.Builder.of(Warrior::new, MobCategory.MISC)
                            .sized(1.0F, 2.2F)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"warrior").toString()));

    //独孤九剑
    public static final RegistryObject<EntityType<DuguNineSwordsEntity>> DUGU_NINE_SOWRDS =
            ENTITY_TYPES.register("dugu_nine_sowrds",
                    () -> EntityType.Builder.of(DuguNineSwordsEntity::new, MobCategory.MISC)
                            .sized(5f, 1f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"dugu_nine_sowrds").toString()));
    //金乌刀法
    public static final RegistryObject<EntityType<GoldenBlackKnifeMethodEntity>> GOLDEN_BLACK_KNIFE_METHOD =
            ENTITY_TYPES.register("golden_black_knife_method_entity",
                    () -> EntityType.Builder.of(GoldenBlackKnifeMethodEntity::new, MobCategory.MISC)
                            .sized(5f, 1f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"golden_black_knife_method").toString()));
    //隔山打牛
    public static final RegistryObject<EntityType<GeShanDaNiuEntity>> GE_SHAN_DA_NIU =
            ENTITY_TYPES.register("ge_shan_da_niu",
                    () -> EntityType.Builder.of(GeShanDaNiuEntity::new, MobCategory.MISC)
                            .sized(5f, 1f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"ge_shan_da_niu").toString()));

    //打狗棒Attack
    public static final RegistryObject<EntityType<BeatDogStickAttackEntity>> BEAT_DOG_STICK_ATTACK =
            ENTITY_TYPES.register("beat_dog_stick_attack",
                    () -> EntityType.Builder.of(BeatDogStickAttackEntity::new, MobCategory.MISC)
                            .sized(1.3f, 1.3f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"beat_dog_stick_attack").toString()));
    //屠龙刀Attack
    public static final RegistryObject<EntityType<TuLongDaoAttackEntity>> TU_LONG_DAO_ATTACK =
            ENTITY_TYPES.register("tu_long_dao_attack",
                    () -> EntityType.Builder.of(TuLongDaoAttackEntity::new, MobCategory.MISC)
                            .sized(1.3f, 1.3f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"tu_long_dao_attack").toString()));

    //霸王枪Attack
    public static final RegistryObject<EntityType<BaWangQiangAttackEntity>> BA_WANG_QIANG_ATTACK =
            ENTITY_TYPES.register("ba_wang_qiang_attack",
                    () -> EntityType.Builder.of(BaWangQiangAttackEntity::new, MobCategory.MISC)
                            .sized(1.3f, 1.3f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"ba_wang_qiang_attack").toString()));
    //霸王枪投掷
    public static final RegistryObject<EntityType<ThrownBaWangQiang>> BA_WANG_QIANG =
            ENTITY_TYPES.register("ba_wang_qiang",
                    () -> EntityType.Builder.<ThrownBaWangQiang>of(ThrownBaWangQiang::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"ba_wang_qiang").toString()));
    //红缨枪投掷
    public static final RegistryObject<EntityType<ThrownRedTasselledSpear>> RED_TASSELLED_SPEAR =
            ENTITY_TYPES.register("red_tasselled_spear",
                    () -> EntityType.Builder.<ThrownRedTasselledSpear>of(ThrownRedTasselledSpear::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"red_tasselled_spear").toString()));

    //倚天剑Attack
    public static final RegistryObject<EntityType<YiTianJianAttackEntity>> YI_TIAN_JIAN_ATTACK =
            ENTITY_TYPES.register("yi_tian_jian_attack",
                    () -> EntityType.Builder.of(YiTianJianAttackEntity::new, MobCategory.MISC)
                            .sized(1.3f, 1.3f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"yi_tian_jian_attack").toString()));

    //练功木桩
    public static final RegistryObject<EntityType<StakesEntity>> STAKES =
            ENTITY_TYPES.register("stakes",
                    () -> EntityType.Builder.<StakesEntity>of(StakesEntity::new, MobCategory.MISC)
                            .sized(0.6F, 1.95F).clientTrackingRange(10)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"stakes").toString()));

    //座位
//    public static final RegistryObject<EntityType<SeatEntity>> SEAT = ENTITY_TYPES.register("seat",
//            () -> EntityType.Builder.<SeatEntity>of(((type,level) -> new SeatEntity(level),MobCategory.MISC)).sized(0.0F,0.0F).setCustomClientFactory((spawnEntity, level) -> new SeatEntity(level)));

    public static final RegistryObject<EntityType<SeatEntity>> SEAT = register("seat", EntityType.Builder.<SeatEntity>of((type, level) ->
            new SeatEntity(level), MobCategory.MISC).sized(0.0F, 0.0F).setCustomClientFactory((spawnEntity, level) -> new SeatEntity(level)));

    public static final RegistryObject<EntityType<PeacockEgg>> PEACOCK_EGG = ENTITY_TYPES.register("peacock_egg",
            () -> EntityType.Builder.<PeacockEgg>of(PeacockEgg::new, MobCategory.MISC).sized(0.25F, 0.25F)
                    .clientTrackingRange(4).updateInterval(10).build("peacock_egg"));

    public static final RegistryObject<EntityType<ThrowingKnivesEntity>> THROWING_KNIVES_ENTITY = ENTITY_TYPES.register("throwing_knives_entity",
            () -> EntityType.Builder.<ThrowingKnivesEntity>of(ThrowingKnivesEntity::new, MobCategory.MISC).sized(0.25F, 0.25F)
                    .clientTrackingRange(4).updateInterval(20).build("throwing_knives_entity"));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(name, () -> builder.build(name));
    }

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
