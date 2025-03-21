package com.shengchanshe.changshengjue.datagen.loot;

import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.advancements.critereon.EntityFlagsPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
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
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

public class CSJEntityLootTables extends EntityLootSubProvider {
    public CSJEntityLootTables() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        /*有掉落*/
        // 老虎掉落
        add(ChangShengJueEntity.TIGER.get(),
                LootTable.lootTable()
                        .withPool(createMainDropPool(ChangShengJueItems.TIGER_SKIN.get(), 0, 2))
        );
        // 雄鹿掉落
        add(ChangShengJueEntity.STAG.get(),
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
        add(ChangShengJueEntity.HIND.get(),
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

        // 鹤掉落
        add(ChangShengJueEntity.CRANE.get(),
                LootTable.lootTable()
                        .withPool(createMainDropPool(ChangShengJueItems.CRANE_FEATHERS.get(), 0, 2))
        );

        // 孔雀掉落
        this.add(ChangShengJueEntity.MALE_PEACOCK.get(),
                LootTable.lootTable().withPool(
                                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ChangShengJueItems.PEACOCK_FEATHERS.get())
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ChangShengJueItems.PEACOCK.get())
                                        .apply(SmeltItemFunction.smelted()
                                                .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
                //                        .withPool(createMainDropPool(ChangShengJueItems.PEACOCK_FEATHERS.get(), 0, 2))
//                        .withPool(LootPool.lootPool()
//                                .name("main_drops")
//                                .setRolls(ConstantValue.exactly(1))
//                                .add(LootItem.lootTableItem(ChangShengJueItems.PEACOCK.get())
//                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
//                                        .apply(SmeltItemFunction.smelted()
//                                                .when(LootItemEntityPropertyCondition.hasProperties(
//                                                        LootContext.EntityTarget.THIS,
//                                                        EntityPredicate.Builder.entity()
//                                                                .flags(EntityFlagsPredicate.Builder.flags().setOnFire(true).build())
//                                                ))
//                                        )
//                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
//                                )
//                        )
        );
        // 雌孔雀
        this.add(ChangShengJueEntity.FEMALE_PEACOCK.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ChangShengJueItems.PEACOCK.get())
                                        .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );

        // 鳄鱼掉落
        // 向当前对象添加一个战利品表配置，针对ChangShengJueEntity中的CROC_ENTITY实体
        this.add(ChangShengJueEntity.CROC.get(),
                // 创建一个新的战利品表
                LootTable.lootTable().withPool(
                                // 创建一个战利品池，该池固定掉落1次
                                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(
                                        // 向该池中添加一个战利品项，即ChangShengJueItems中的CROC_SKIN
                                        LootItem.lootTableItem(ChangShengJueItems.CROC_SKIN.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                                // 设置该战利品项的数量范围为0到2
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
                        // 应用抢夺附魔效果，增加掉落数量，范围为0到1
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(ChangShengJueItems.CROC.get())
                                // 向该池中添加另一个战利品项，即ChangShengJueItems中的CROC
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                // 设置该战利品项的数量范围为1到3
                                .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                // 当实体被火焰烧死时，应用熔炼效果                     应用抢夺附魔效果，增加掉落数量，范围为0到1
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );

        this.add(ChangShengJueEntity.WARRIOR.get(),
                LootTable.lootTable().withPool(
                                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ChangShengJueItems.YI_GUAN_TONG_QIAN.get())
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ChangShengJueItems.FEN_JIU.get()))
                                .add(LootItem.lootTableItem(ChangShengJueItems.SHI_LI_XIANG.get()))
                                .add(LootItem.lootTableItem(ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get())
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.5F, 0.01F))))
        );

        this.add(ChangShengJueEntity.MALE_INNKEEPER.get(),
                LootTable.lootTable().withPool(
                                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ChangShengJueItems.AG_INGOT.get())
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );
        this.add(ChangShengJueEntity.FEMALE_INNKEEPER.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ChangShengJueItems.AG_INGOT.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );

        this.add(ChangShengJueEntity.CHALLENGER.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ChangShengJueItems.YI_GUAN_TONG_QIAN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );

        this.add(ChangShengJueEntity.BLACKSMITH.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ChangShengJueItems.AG_INGOT.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );

        this.add(ChangShengJueEntity.LANCE_GANG_LEADER.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ChangShengJueItems.GANG_TOKEN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 10.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );
        this.add(ChangShengJueEntity.KNIFE_GANG_LEADER.get(),
                LootTable.lootTable().withPool(
                                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ChangShengJueItems.GANG_TOKEN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 10.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );

        this.add(ChangShengJueEntity.SWORD_GANG_LEADER.get(),
                LootTable.lootTable().withPool(
                                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ChangShengJueItems.GANG_TOKEN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 10.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );
        this.add(ChangShengJueEntity.CLUBBED_GANG_LEADER.get(),
                LootTable.lootTable().withPool(
                                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ChangShengJueItems.GANG_TOKEN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 10.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );
        this.add(ChangShengJueEntity.BANDIT.get(),
                LootTable.lootTable().withPool(
                                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ChangShengJueItems.AG_INGOT.get())
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );

        this.add(ChangShengJueEntity.VILLAIN.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ChangShengJueItems.YI_GUAN_TONG_QIAN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );

        this.add(ChangShengJueEntity.ASSASSIN.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ChangShengJueItems.AG_INGOT.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );

        this.add(ChangShengJueEntity.WITCH_WU_XIA.get(),
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(Items.GLOWSTONE_DUST).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
                        .add(LootItem.lootTableItem(Items.SUGAR).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
                        .add(LootItem.lootTableItem(Items.REDSTONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
                        .add(LootItem.lootTableItem(Items.SPIDER_EYE).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
                        .add(LootItem.lootTableItem(Items.GLASS_BOTTLE).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
                        .add(LootItem.lootTableItem(Items.GUNPOWDER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
                        .add(LootItem.lootTableItem(Items.STICK).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
        );

        this.add(ChangShengJueEntity.EVOKER_WU_XIA.get(),
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.TOTEM_OF_UNDYING))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.EMERALD).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer()))
        );

        this.add(ChangShengJueEntity.VINDICATOR_WU_XIA.get(),
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.EMERALD).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer()))
        );

        this.add(ChangShengJueEntity.PIGLIN_WU_XIA.get(), LootTable.lootTable());
        this.add(ChangShengJueEntity.PILLAGER_WU_XIA.get(), LootTable.lootTable());

        /*无掉落*/
        // 蝴蝶掉落
        add(ChangShengJueEntity.BUTTERFLY.get(), LootTable.lootTable());
        add(ChangShengJueEntity.DRAGONFLY.get(), LootTable.lootTable());
        // 金丝猴掉落
        add(ChangShengJueEntity.MONKEY.get(), LootTable.lootTable());
        // 蝉掉落
        add(ChangShengJueEntity.CICADA.get(), LootTable.lootTable());
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
                                UniformGenerator.between(0.0F, baseChance / 2) // 抢夺效果递减
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
        return ChangShengJueEntity.ENTITY_TYPES.getEntries().stream().map(RegistryObject::get);
    }
}