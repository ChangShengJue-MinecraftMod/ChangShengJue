package com.shengchanshe.chang_sheng_jue.entity.villagers;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Dynamic;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.custom.gong.Gong;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import net.minecraft.core.GlobalPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.SpawnUtil;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.*;
import net.minecraft.world.entity.ai.behavior.declarative.BehaviorBuilder;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.sensing.GolemSensor;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.entity.schedule.Schedule;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class ChangShengJueVillagerEntity extends Villager {
    public ChangShengJueVillagerEntity(EntityType<? extends ChangShengJueVillagerEntity> p_35381_, Level p_35382_) {
        super(p_35381_, p_35382_);
    }
    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE,48D)
                .add(Attributes.MOVEMENT_SPEED,0.5D).build();
    }

    protected @NotNull Brain<?> makeBrain(Dynamic<?> pDynamic) {
        Brain<Villager> brain = this.brainProvider().makeBrain(pDynamic);
        this.registerBrainGoals(brain);
        return brain;
    }

    public void refreshBrain(ServerLevel pServerLevel) {
        Brain<Villager> brain = this.getBrain();
        brain.stopAll(pServerLevel, this);
        this.brain = brain.copyWithoutBehaviors();
        this.registerBrainGoals(this.getBrain());
    }

    private void registerBrainGoals(Brain<Villager> pVillagerBrain) {
        VillagerProfession villagerprofession = this.getVillagerData().getProfession();

        if (this.isBaby()) {
            pVillagerBrain.setSchedule(Schedule.VILLAGER_BABY);
            pVillagerBrain.addActivity(Activity.PLAY, VillagerGoalPackages.getPlayPackage(0.5F));
        } else {
            pVillagerBrain.setSchedule(Schedule.VILLAGER_DEFAULT);
            pVillagerBrain.addActivityWithConditions(Activity.WORK, VillagerGoalPackages.getWorkPackage(villagerprofession, 0.5F),
                    ImmutableSet.of(Pair.of(MemoryModuleType.JOB_SITE, MemoryStatus.VALUE_PRESENT)));
        }

        // 修改核心行为包，添加获取 Gong POI 的行为
        pVillagerBrain.addActivity(Activity.CORE, getCustomCorePackage(villagerprofession, 0.5F));

        pVillagerBrain.addActivityWithConditions(Activity.MEET, VillagerGoalPackages.getMeetPackage(villagerprofession, 0.5F),
                ImmutableSet.of(Pair.of(MemoryModuleType.MEETING_POINT, MemoryStatus.VALUE_PRESENT)));
        pVillagerBrain.addActivity(Activity.REST, VillagerGoalPackages.getRestPackage(villagerprofession, 0.5F));
        pVillagerBrain.addActivity(Activity.IDLE, VillagerGoalPackages.getIdlePackage(villagerprofession, 0.5F));
        pVillagerBrain.addActivity(Activity.PANIC, VillagerGoalPackages.getPanicPackage(villagerprofession, 0.5F));
        pVillagerBrain.addActivity(Activity.PRE_RAID, this.getPreRaidPackage(villagerprofession, 0.5F));
        pVillagerBrain.addActivity(Activity.RAID, VillagerGoalPackages.getRaidPackage(villagerprofession, 0.5F));
        pVillagerBrain.addActivity(Activity.HIDE, VillagerGoalPackages.getHidePackage(villagerprofession, 0.5F));

        pVillagerBrain.setCoreActivities(ImmutableSet.of(Activity.CORE));
        pVillagerBrain.setDefaultActivity(Activity.IDLE);
        pVillagerBrain.setActiveActivityIfPossible(Activity.IDLE);
        pVillagerBrain.updateActivityFromSchedule(this.level().getDayTime(), this.level().getGameTime());
    }

    private ImmutableList<Pair<Integer, ? extends BehaviorControl<? super Villager>>> getCustomCorePackage(VillagerProfession pProfession, float pSpeedModifier) {
        ResourceLocation gongPoiId = new ResourceLocation(ChangShengJue.MOD_ID, "gong_meeting");

        return ImmutableList.of(
                Pair.of(0, new Swim(0.8F)),
                Pair.of(0, InteractWithDoor.create()),
                Pair.of(0, new LookAtTargetSink(45, 90)),
                Pair.of(0, new VillagerPanicTrigger()),
                Pair.of(0, WakeUp.create()),
                Pair.of(0, ReactToBell.create()),
                Pair.of(0, SetRaidStatus.create()),
                Pair.of(0, ValidateNearbyPoi.create(pProfession.heldJobSite(), MemoryModuleType.JOB_SITE)),
                Pair.of(0, ValidateNearbyPoi.create(pProfession.acquirableJobSite(), MemoryModuleType.POTENTIAL_JOB_SITE)),
                Pair.of(1, new MoveToTargetSink()),
                Pair.of(2, PoiCompetitorScan.create()),
                Pair.of(3, new LookAndFollowTradingPlayerSink(pSpeedModifier)),
                Pair.of(5, GoToWantedItem.create(pSpeedModifier, false, 4)),
                Pair.of(6, AcquirePoi.create(pProfession.acquirableJobSite(), MemoryModuleType.JOB_SITE, MemoryModuleType.POTENTIAL_JOB_SITE, true, Optional.empty())),
                Pair.of(7, new GoToPotentialJobSite(pSpeedModifier)),
                Pair.of(8, YieldJobSite.create(pSpeedModifier)),
                Pair.of(10, AcquirePoi.create((p_217499_) -> p_217499_.is(PoiTypes.HOME), MemoryModuleType.HOME, false, Optional.of((byte)14))),
                // 添加获取 Gong POI 的行为 - 关键修改！
                Pair.of(10, AcquirePoi.create((poiType) ->
                                poiType.unwrapKey()
                                        .map(key -> key.location().equals(gongPoiId))
                                        .orElse(false),
                        MemoryModuleType.MEETING_POINT,
                        true,
                        Optional.of((byte)14)
                )),
                Pair.of(10, AssignProfessionFromJobSite.create()),
                Pair.of(10, ResetProfession.create())
        );
    }

    @Nullable
    public ChangShengJueVillagerEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        ChangShengJueVillagerEntity villager = new ChangShengJueVillagerEntity(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER.get(), pLevel);
        villager.finalizeSpawn(pLevel, pLevel.getCurrentDifficultyAt(villager.blockPosition()), MobSpawnType.BREEDING, null, null);
        return villager;
    }

    public void spawnGolemIfNeeded(ServerLevel pServerLevel, long pGameTime, int pMinVillagerAmount) {
        if (this.wantsToSpawnGolem(pGameTime)) {
            AABB aabb = this.getBoundingBox().inflate(10.0, 10.0, 10.0);
            List<Villager> list = pServerLevel.getEntitiesOfClass(Villager.class, aabb);
            List<Villager> list1 = list.stream().filter((p_186293_) -> p_186293_.wantsToSpawnGolem(pGameTime)).limit(5L).toList();
            if (list1.size() >= pMinVillagerAmount && SpawnUtil.trySpawnMob(ChangShengJueEntity.WARRIOR.get(), MobSpawnType.MOB_SUMMONED, pServerLevel, this.blockPosition(), 10, 8, 6, SpawnUtil.Strategy.LEGACY_IRON_GOLEM).isPresent()) {
                list.forEach(GolemSensor::golemDetected);
            }
        }

    }

    public ImmutableList<Pair<Integer, ? extends BehaviorControl<? super Villager>>> getPreRaidPackage(VillagerProfession pProfession, float pSpeedModifier) {
        return ImmutableList.of(Pair.of(0, this.create()), Pair.of(0,
                TriggerGate.triggerOneShuffled(ImmutableList.of(Pair.of(SetWalkTargetFromBlockMemory.create(
                        MemoryModuleType.MEETING_POINT, pSpeedModifier * 1.5F, 2, 150,
                        200), 6), Pair.of(VillageBoundRandomStroll.create(pSpeedModifier * 1.5F), 2)))),
                getMinimalLookBehavior(), Pair.of(99, ResetRaidStatus.create()));
    }

    private Pair<Integer, BehaviorControl<LivingEntity>> getMinimalLookBehavior() {
        return Pair.of(5, new RunOne<>(ImmutableList.of(Pair.of(SetEntityLookTarget.create(EntityType.VILLAGER, 8.0F), 2),
                Pair.of(SetEntityLookTarget.create(EntityType.PLAYER, 8.0F), 2), Pair.of(new DoNothing(30, 60), 8))));
    }

    // 修改敲锣行为，检查 Gong POI 类型
    public BehaviorControl<LivingEntity> create() {
        return BehaviorBuilder.create((livingEntityInstance) ->
                livingEntityInstance.group(livingEntityInstance.present(MemoryModuleType.MEETING_POINT))
                        .apply(livingEntityInstance, (meetingPointMemory) -> (level, livingEntity, gameTime) -> {
                            if (level.random.nextFloat() <= 0.95F) {
                                return false;
                            } else {
                                GlobalPos meetingPos = livingEntity.getBrain().getMemory(MemoryModuleType.MEETING_POINT).orElse(null);
                                if (meetingPos != null && meetingPos.pos().closerThan(livingEntity.blockPosition(), 8.0)) {
                                    BlockState block = level.getBlockState(meetingPos.pos());
                                    if (block.getBlock() instanceof Gong gong) {
                                        gong.attemptToRing(livingEntity, level, meetingPos.pos(), null);
                                        return true;
                                    }
                                }
                                return false;
                            }
                        }));
    }

}
