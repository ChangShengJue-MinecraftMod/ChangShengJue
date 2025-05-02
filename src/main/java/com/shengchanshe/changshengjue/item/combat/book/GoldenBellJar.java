package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class GoldenBellJar extends Item {
    public GoldenBellJar() {
        super(new Properties());
    }
//    @Override
//    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
//        if (!pLevel.isClientSide){
//            pPlayer.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
//                goldenBellJar.setGoldenBellJarOff(true);
//                if (pPlayer instanceof ServerPlayer player){
//                    player.connection.send(new ClientboundSetActionBarTextPacket(Component.translatable("ui.chang_sheng_jue.binding_prompts").withStyle(ChatFormatting.YELLOW)));
//                }
//                // 发送提示消息
//                ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
//                        goldenBellJar.getGoldenBellJarLevel(),
//                        goldenBellJar.isGoldenBellJarComprehend(),
//                        goldenBellJar.getGoldenBellJarUseCooldownPercent(),
//                        goldenBellJar.isGoldenBellJarOff(),
//                        goldenBellJar.getGoldenBellJarToppedTick(),
//                        goldenBellJar.getGoldenBellJarDachengTick(),
//                        goldenBellJar.isGoldenBellJarParticle(),
//                        goldenBellJar.isSkillZActive(),
//                        goldenBellJar.isSkillXActive(),
//                        goldenBellJar.isSkillCActive()), (ServerPlayer) pPlayer);
//            });
//        }
//        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
//    }

    public static void comprehend(Entity entity, Level level){
        if (!level.isClientSide) {
            if (entity instanceof Player player){
                player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
                    if (goldenBellJar.isGoldenBellJarComprehend() && goldenBellJar.getGoldenBellJarLevel() == 0) {
                        if (goldenBellJar.isSkillZActive() || goldenBellJar.isSkillXActive() || goldenBellJar.isSkillCActive()) {
                            float probability = player.getRandom().nextFloat();
                            float defaultProbability = !player.getAbilities().instabuild ? 0.01F : 1.0F;
                            if (probability < defaultProbability) {
                                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                goldenBellJar.addGoldenBellJarLevel();
                                goldenBellJar.setGoldenBellJarParticle(true);
                                ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                                        goldenBellJar.getGoldenBellJarLevel(),
                                        goldenBellJar.isGoldenBellJarComprehend(),
                                        goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                                        goldenBellJar.isGoldenBellJarOff(),
                                        goldenBellJar.getGoldenBellJarToppedTick(),
                                        goldenBellJar.getGoldenBellJarDachengTick(),
                                        goldenBellJar.isGoldenBellJarParticle(),
                                        goldenBellJar.isSkillZActive(),
                                        goldenBellJar.isSkillXActive(),
                                        goldenBellJar.isSkillCActive()), (ServerPlayer) player);
                                if (player instanceof ServerPlayer serverPlayer) {
                                    CSJAdvanceInit.LEARN_GONG_FA.trigger(serverPlayer);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            Component fullDesc = Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "."
                    + this + ".hold_shift.tooltip").withStyle(ChatFormatting.GOLD);
            String formattedText = fullDesc.getString();
            Arrays.stream(formattedText.split("\\u000A|\\\\n"))
                    .map(line -> Component.literal(line).withStyle(fullDesc.getStyle()))
                    .forEach(pTooltipComponents::add);
        } else {
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "." + this + ".tooltip").withStyle(ChatFormatting.GOLD));
            // 提示按住Shift
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID +".hold_shift.tooltip"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
