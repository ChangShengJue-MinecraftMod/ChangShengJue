package com.shengchanshe.chang_sheng_jue.item.tool;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.event.quest.PlayerQuestEvent;
import com.shengchanshe.chang_sheng_jue.item.tiers.ChangShengJueTiers;
import com.shengchanshe.chang_sheng_jue.martial_arts.IKungFu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.WuGangCutGui;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu.WuGangCutGuiParticlePacket;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class XuanhuaAxe extends AxeItem {
    public XuanhuaAxe() {
        super(ChangShengJueTiers.IRON, 5.0F, -3.0F, new Item.Properties());
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        int baseDurability = super.getMaxDamage(stack);

        CompoundTag nbt = stack.getOrCreateTag();
        int maxDamage = nbt.getInt("xuanhuaAxeMaxDamage");

        return baseDurability + maxDamage;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (entityLiving instanceof Player player && player.isShiftKeyDown()){
            Level level = player.getCommandSenderWorld();
            if (!level.isClientSide) {
                player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                    cap.getKungFu(WuGangCutGui.KUNG_FU_ID.toString())
                            .filter(kungFu -> kungFu instanceof WuGangCutGui)
                            .filter(IKungFu::isReady)
                            .map(active -> {
                                BlockState blockState = level.getBlockState(pos);
                                ItemStack mainHandItem = player.getMainHandItem();
                                if (mainHandItem.getItem() instanceof XuanhuaAxe) {
                                    // 判断是否是木头
                                    if (isLog(blockState)) {
                                        // 存储已处理的方块
                                        Set<BlockPos> visited = new HashSet<>();
                                        // 记录第一个破坏的位置
                                        BlockPos dropPos = pos;
                                        // 执行连锁砍树
                                        chopTree((ServerLevel) level, pos, visited, dropPos, mainHandItem, player);
                                        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                                ChangShengJueSound.WU_GANG_CUT_GUI_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);

                                        CompoundTag nbt = stack.getOrCreateTag();
                                        int maxDamage = nbt.getInt("xuanhuaAxeMaxDamage");
                                        ((WuGangCutGui) active).setXuanhuaAxeMaxDamage(player.getRandom().nextFloat() > 0.2 ? 0 : 1);
                                        nbt.putInt("xuanhuaAxeMaxDamage", maxDamage + ((WuGangCutGui) active).getXuanhuaAxeMaxDamage());
                                        ((WuGangCutGui) active).onInteranKungFu(level, player);
                                        ChangShengJueMessages.sendToPlayer(new WuGangCutGuiParticlePacket(dropPos.getX() + 0.5f, dropPos.getY(), dropPos.getZ() + 0.5f),
                                                (ServerPlayer) player);
                                    }
                                }
                                if (entityLiving instanceof ServerPlayer) {
                                    cap.syncToClient((ServerPlayer) player);
                                }
                                return true;
                            });
                });
            }
        }
        return super.mineBlock(stack, worldIn, state, pos, entityLiving);
    }

    private static boolean isLog(BlockState state) {
        return state.is(BlockTags.LOGS);// 可添加其他木头类型
    }
    private static void chopTree(ServerLevel world, BlockPos pos, Set<BlockPos> visited, BlockPos dropPos,ItemStack stack,Player player) {
        if (visited.contains(pos)) return;
        visited.add(pos);
        BlockState state = world.getBlockState(pos);
        // 检测是否为木头
        if (isLog(state)) {
            // 获取掉落物品
            for (ItemStack drop : Block.getDrops(state, world, pos, null)) {
                // 将掉落物生成在第一个方块的位置
                world.addFreshEntity(new ItemEntity(world, dropPos.getX() + 0.5, dropPos.getY() + 0.5, dropPos.getZ() + 0.5, drop));
            }
            // 破坏方块但不掉落物品
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            // 检测相邻方块
            for (BlockPos adjacent : getAdjacentPositions(pos)) {
                chopTree(world, adjacent, visited, dropPos,stack,player);
            }
            stack.hurtAndBreak(1, player, player1 -> {
                player1.broadcastBreakEvent(player.getUsedItemHand());
            });
        }
    }

    private static Iterable<BlockPos> getAdjacentPositions(BlockPos pos) {
        return Set.of(
                pos.above(), pos.north(), pos.south(),
                pos.east(), pos.west()
        );
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            pPlayer.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
                // 1. 获取所有任务
                List<Quest> allQuests = cap.getQuests(pPlayer.getUUID());

                int completionCount = cap.getCompletionCount(PlayerQuestEvent.FIRST_VILLAGER_QUEST_ID);

                // 2. 构建消息内容
                Component message = buildQuestMessage(allQuests);

                // 3. 发送给玩家
                pPlayer.sendSystemMessage(message);
                pPlayer.sendSystemMessage(Component.literal(String.valueOf(completionCount)));
            });
//            pPlayer.getCapability(CultivationCapabilityProvider.XIU_XIAN_CAPABILITY).ifPresent(cap -> {
//                cap.setSpiritPower(Math.min(cap.getMaxSpiritPower(), cap.getSpiritPower() + 1000));
//                pPlayer.sendSystemMessage(Component.literal("当前灵力:" + cap.getSpiritPower()));
//                pPlayer.sendSystemMessage(Component.literal("当前真元:" + cap.getTruePower()));
//                pPlayer.sendSystemMessage(Component.literal("灵力上限：" + cap.getMaxSpiritPower()));
//                pPlayer.sendSystemMessage(Component.literal("真元上限：" + cap.getMaxTruePower()));
//                pPlayer.sendSystemMessage(Component.literal("当前境界:" + cap.getCultivationStage().getName(cap.getTruePower(), cap.getCultivationStage())));
//                pPlayer.sendSystemMessage(Component.literal("当前资质：" + cap.getAptitude()));
//                pPlayer.sendSystemMessage(Component.literal("当前吐纳转换效率：" + cap.getTunNaEfficiency()));
//                pPlayer.sendSystemMessage(Component.literal("当前真元转换效率：" + cap.getSeclusionEfficiency()));
//                pPlayer.sendSystemMessage(Component.literal("当前聚气效率：" + cap.getJiQiEfficiency()));
//
//                String combinedNames = cap.getSpiritRoots().stream()
//                        .map(SpiritRootType::getName)
//                        .collect(Collectors.joining("、"));
//                pPlayer.sendSystemMessage(Component.literal("拥有的灵根：" + combinedNames));
//            });
//            // 获取玩家所在区块
//
//            // 获取灵气数据
//            float spiritValue = SpiritManager.getSpiritValue((ServerLevel) pLevel, pPlayer.blockPosition());
//
//            SpiritDensityLevel level = SpiritDensityLevel.getForValue(spiritValue);
//
//            // 发送消息给玩家
//            pPlayer.sendSystemMessage(Component.literal("当前区块灵气: ")
//                    .append(Component.literal(String.valueOf(spiritValue)).withStyle(style -> style.withColor(0x55FF55)))
//                    .append(" | 等级: ")
//                    .append(Component.literal(level.getName()).withStyle(style -> style.withColor(0xFFFF55)))
//                    .append(" | 效率: ")
//                    .append(Component.literal(String.format("%+.1f%%", level.getEfficiency() * 100)).withStyle(style -> style.withColor(0x55FFFF)))
//            );
//
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    // 构建任务信息消息
    private Component buildQuestMessage(List<Quest> quests) {
        MutableComponent message = Component.literal("==== 当前任务 ====\n").withStyle(ChatFormatting.GOLD);

        if (quests.isEmpty()) {
            return message.append(Component.literal("暂无任务").withStyle(ChatFormatting.GRAY));
        }

        for (Quest quest : quests) {
            message.append("\n")
                    .append(Component.literal("[" + quest.getQuestDescription() + "]")
                            .withStyle(ChatFormatting.YELLOW))
                    .append("\n - 任务名称: ")
                    .append(Component.literal(quest.getQuestName())
                            .withStyle(ChatFormatting.WHITE));
        }

        return message;
    }
}
