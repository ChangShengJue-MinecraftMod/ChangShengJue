package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.paoding.PaodingCapabilityProvider;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.entity.custom.deer.AbstractDeer;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AirItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.Collection;

public class PaodingEvent {
    //生物受伤事件
    public static void onEntityHurt(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            if (event.getSource().getDirectEntity() instanceof Player directEntity){
                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()){
                    if (!directEntity.isShiftKeyDown()){
                        event.setAmount(0);
                    }
                    directEntity.getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).ifPresent(paoding -> {
                        if (paoding.isPaodingComprehend() && paoding.getPaodingLevel() == 0) {
                            float probability = directEntity.getRandom().nextFloat();
                            float defaultProbability = 0.01F;
                            if (probability < defaultProbability) {
                                paoding.addPaodingLevel();
                            }
                        }
                    });
                }
            }
        }
    }

    public static void onEntityDeath(LivingDeathEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            Entity directEntity = event.getSource().getDirectEntity();
            if (directEntity instanceof Player player){
                directEntity.getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).ifPresent(paoding -> {
                    if (paoding.isPaodingComprehend() && paoding.getPaodingLevel() != 0){
                        if (event.getEntity() instanceof Animal && player.getMainHandItem().is(ChangShengJueItems.KITCHEN_KNIFE.get())){
                            float probability = player.getRandom().nextFloat();
                            float defaultProbability = 0.5F;
                            if (paoding.getPaodingLevel() > 1){
                                defaultProbability = (float) (defaultProbability * 0.25);
                            }
                            if (probability >= defaultProbability){
                                if (event.getEntity() instanceof Chicken){
                                    ItemEntity entityToSpawn = new ItemEntity(level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.CHICKEN));
                                    level.addFreshEntity(entityToSpawn);
                                }else if (event.getEntity() instanceof Cow){
                                    ItemEntity entityToSpawn = new ItemEntity(level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.BEEF));
                                    level.addFreshEntity(entityToSpawn);
                                }else if (event.getEntity() instanceof Pig){
                                    ItemEntity entityToSpawn = new ItemEntity(level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.PORKCHOP));
                                    level.addFreshEntity(entityToSpawn);
                                }else if (event.getEntity() instanceof Sheep){
                                    ItemEntity entityToSpawn = new ItemEntity(level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.MUTTON));
                                    level.addFreshEntity(entityToSpawn);
                                }else if (event.getEntity() instanceof Rabbit){
                                    ItemEntity entityToSpawn = new ItemEntity(level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.RABBIT));
                                    level.addFreshEntity(entityToSpawn);
                                }else if (event.getEntity() instanceof AbstractDeer){
                                    ItemEntity entityToSpawn = new ItemEntity(level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(ChangShengJueItems.VENISON.get()));
                                    level.addFreshEntity(entityToSpawn);
                                }
                                if (paoding.getPaodingUseCount() <= 1000) {
                                    paoding.addPaodingUseCount();
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
