package com.shengchanshe.chang_sheng_jue.item.tool;

import com.shengchanshe.chang_sheng_jue.capability.martial_arts.wu_gang_cut_gui.WuGangCutGuiCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.item.tiers.ChangShengJueTiers;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.wu_gang_cut_gui.WuGangCutGuiPacket;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
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
        if (entityLiving instanceof Player player){
            Level level = player.getCommandSenderWorld();
            if (!level.isClientSide) {
                player.getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).ifPresent(wuGangCutGui -> {
                    if (wuGangCutGui.isWuGangCutGuiComprehend() && wuGangCutGui.getWuGangCutGuiLevel() >= 1) {
                        BlockPos startPos = pos;
                        BlockState blockState = level.getBlockState(startPos);
                        ItemStack mainHandItem = player.getMainHandItem();
                        if (mainHandItem.getItem() instanceof XuanhuaAxe) {
                            // 判断是否是木头
                            if (isLog(blockState)) {
                                // 存储已处理的方块
                                Set<BlockPos> visited = new HashSet<>();
                                // 记录第一个破坏的位置
                                BlockPos dropPos = startPos;
                                // 执行连锁砍树
                                chopTree((ServerLevel) level, startPos, visited, dropPos, mainHandItem, player);
                                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                        ChangShengJueSound.WU_GANG_CUT_GUI_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);

                                CompoundTag nbt = stack.getOrCreateTag();
                                int maxDamage = nbt.getInt("xuanhuaAxeMaxDamage");
                                wuGangCutGui.setWuGangCutGuiMaxDamage(player.getRandom().nextFloat() > 0.2 ? 0 : 1);
                                nbt.putInt("xuanhuaAxeMaxDamage", maxDamage + wuGangCutGui.getWuGangCutGuiMaxDamage());
                                if (wuGangCutGui.getWuGangCutGuiUseCount() < 1000) {
                                    wuGangCutGui.addWuGangCutGuiUseCount(!player.getAbilities().instabuild ? 1 : 1000);
                                    if (wuGangCutGui.getWuGangCutGuiUseCount() >= 1000){
                                        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                                ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                        wuGangCutGui.setWuGangCutGuiParticle(true);
                                    }
                                }
                                ChangShengJueMessages.sendToServer(new WuGangCutGuiPacket(dropPos,20));
                            }
                        }
                    }
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
//        if (!pLevel.isClientSide) {
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
//        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
