package com.shengchanshe.changshengjue.datagen.loot;

import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.advancements.critereon.DamageSourcePredicate;
import net.minecraft.advancements.critereon.EntityFlagsPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.DamageSourceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Stream;

public class CSJEntityLootTables extends EntityLootSubProvider {
    public CSJEntityLootTables() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        /*有掉落*/
        // 老虎掉落
        add(ChangShengJueEntity.TIGER_ENTITY.get(),
                LootTable.lootTable()
                        .withPool(createMainDropPool(ChangShengJueItems.TIGER_SKIN.get(), 0, 2))
        );
        // 雄鹿掉落
        add(ChangShengJueEntity.STAG_ENTITY.get(),
                LootTable.lootTable()
                        // 鹿皮掉落（带掠夺加成）
                        .withPool(createMainDropPool(ChangShengJueItems.DEERSKIN.get(), 0, 2))
                        // 生鹿肉掉落（带烧烤转换）
                        .withPool(LootPool.lootPool()
                                .name("main_drops")
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(ChangShengJueItems.VENISON.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                        .apply(SmeltItemFunction.smelted()
                                                .when(LootItemEntityPropertyCondition.hasProperties(
                                                        LootContext.EntityTarget.THIS,
                                                        EntityPredicate.Builder.entity()
                                                                .flags(EntityFlagsPredicate.Builder.flags().setOnFire(true).build())
                                                ))
                                        )
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
                                )
                        )
                        // 鹿血掉落
                        .withPool(createSimpleDropPool(ChangShengJueItems.DEER_BLOOD.get(), 0, 1))
                        // 鹿角掉落
                        .withPool(createSimpleDropPool(ChangShengJueItems.ANTLER.get(), 0, 2))
        );
        // 雌鹿掉落配置
        add(ChangShengJueEntity.HIND_ENTITY.get(),
                LootTable.lootTable()
                        .withPool(createMainDropPool(ChangShengJueItems.DEERSKIN.get(), 0.0F, 2.0F))
                        .withPool(LootPool.lootPool()
                                .name("main_drops")
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(ChangShengJueItems.VENISON.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                        .apply(SmeltItemFunction.smelted()
                                                .when(LootItemEntityPropertyCondition.hasProperties(
                                                        LootContext.EntityTarget.THIS,
                                                        EntityPredicate.Builder.entity()
                                                                .flags(EntityFlagsPredicate.Builder.flags().setOnFire(true).build())
                                                ))
                                        )
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
                                )
                        )
                        .withPool(createSimpleDropPool(ChangShengJueItems.DEER_BLOOD.get(), 0.0F, 1.0F))
        );

//        // 木桩掉落
//        add(ChangShengJueEntity.STAKES.get(), // 需替换为实际实体获取方式
//                LootTable.lootTable()
//                        .withPool(LootPool.lootPool()
//                                .name("special_drops")
//                                .setRolls(ConstantValue.exactly(1))
//                                .add(LootItem.lootTableItem(ChangShengJueItems.STAKES.get())
//                                        .apply(LootingEnchantFunction.lootingMultiplier(
//                                                UniformGenerator.between(1.0F, 1.0F) // 固定每次掠夺+1
//                                        ))
//                                )
//                        )
//        );

        // 鹤掉落
        add(ChangShengJueEntity.CRANE_ENTITY.get(),
                LootTable.lootTable()
                        .withPool(createMainDropPool(ChangShengJueItems.CRANE_FEATHERS.get(), 0, 2))
        );

        // 孔雀掉落
        add(ChangShengJueEntity.MALE_PEACOCK_ENTITY.get(),
                LootTable.lootTable()
                        .withPool(createMainDropPool(ChangShengJueItems.PEACOCK_FEATHERS.get(), 0, 2))
        );
        // 鳄鱼掉落
        add(ChangShengJueEntity.CROC_ENTITY.get(),
                LootTable.lootTable()
                        .withPool(createMainDropPool(ChangShengJueItems.CROC_SKIN.get(), 0, 2))
        );
        /*无掉落*/
        // 蝴蝶掉落
        add(ChangShengJueEntity.BUTTERFLY_ENTITY.get(), LootTable.lootTable());
        add(ChangShengJueEntity.DRAGONFLY_ENTITY.get(), LootTable.lootTable());
        // 金丝猴掉落
        add(ChangShengJueEntity.MONKEY_ENTITY.get(), LootTable.lootTable());
        // 蝉掉落
        add(ChangShengJueEntity.CICADA_ENTITY.get(), LootTable.lootTable());
        // 雌孔雀
        add(ChangShengJueEntity.FEMALE_PEACOCK_ENTITY.get(), LootTable.lootTable());
    }

    //主要掉落：正常掉落方法，百分百触发掉落，最少min个最多max个
    private LootPool.Builder createMainDropPool(Item item, float min, float max) {
        return LootPool.lootPool()
                .name("main_drops")
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
                        .apply(ApplyExplosionDecay.explosionDecay())
                );
    }

    // 稀有掉落物，受到baseChance概率的影响，抢夺加成为一半，只有随机数满足才会掉落
    private LootPool.Builder createRareDropPool(Item item, float baseChance) {
        return LootPool.lootPool()
                .name("rare_drops")
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(item)
                        .when(LootItemRandomChanceCondition.randomChance(baseChance))
                        .apply(LootingEnchantFunction.lootingMultiplier(
                                UniformGenerator.between(0.0F, baseChance/2) // 抢夺效果递减
                        ))
                );
    }

    // 基础掉落，不考虑一切，只掉落数字内的
    private LootPool.Builder createSimpleDropPool(Item item, float min, float max) {
        return LootPool.lootPool()
                .name("simple_drops")
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                );
    }

//    private LootPool.Builder createFireDropPool(Item item, float min, float max) {
//        EntityPredicate.Builder predicate = EntityPredicate.Builder.entity()
//                .flags(EntityFlagsPredicate.Builder.flags().setOnFire(true).build());
//
//        return LootPool.lootPool()
//                .name("fire_drops")
//                .setRolls(ConstantValue.exactly(1))
//                .add(LootItem.lootTableItem(item)
//                        .when(LootItemEntityPropertyCondition.hasProperties(
//                                LootContext.EntityTarget.THIS,
//                                predicate
//                        ))
//                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
//                );
//    }
    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return ChangShengJueEntity.ENTITY_TYPES.getEntries().stream()
                .map(RegistryObject::get);
    }
}