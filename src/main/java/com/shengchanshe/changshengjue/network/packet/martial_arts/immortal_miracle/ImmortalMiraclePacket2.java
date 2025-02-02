package com.shengchanshe.changshengjue.network.packet.martial_arts.immortal_miracle;

import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.hercules.HerculesCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.hercules.HerculesCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu.GeShanDaNiuPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.hercules.HerculesPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.sunflower_point_caveman.SunflowerPointCavemanPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.turtle_breath_work.TurtleBreathWorkPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ImmortalMiraclePacket2 {

    private String key;

    public ImmortalMiraclePacket2(String key) {
        this.key = key;
    }

    public ImmortalMiraclePacket2(FriendlyByteBuf buf) {
        this.key = buf.readUtf(32767); // 读取按键
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUtf(this.key); // 写入按键
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();
            player.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
                if (this.key.equals("Z")){
                    immortalMiracle.setSkillZActive(!immortalMiracle.isSkillZActive());
                    player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu ->{
                        if (geShanDaNiu.isSkillZActive()){
                            geShanDaNiu.setSkillZActive(false);
                            geShanDaNiuMessages(geShanDaNiu,player);
                        }
                    });
                    player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman ->{
                        if (sunflowerPointCaveman.isSkillZActive()){
                            sunflowerPointCaveman.setSkillZActive(false);
                            sunflowerPointCavemanMessages(sunflowerPointCaveman,player);
                        }
                    });
                    player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar ->{
                        if (goldenBellJar.isSkillZActive()){
                            goldenBellJar.setSkillZActive(false);
                            goldenBellJarMessages(goldenBellJar,player);
                        }
                    });
                    player.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi->{
                        if (qianKunDaNuoYi.isSkillZActive()){
                            qianKunDaNuoYi.setSkillZActive(false);
                            qianKunDaNuoYi.setQianKunDaNuoYiUseCooldownMax(60);
                            qianKunDaNuoYiMessages(qianKunDaNuoYi,player);
                        }
                    });
                    player.getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).ifPresent(hercules->{
                        if (hercules.isSkillZActive()){
                            hercules.setSkillZActive(false);
                            herculesPacketMessages(hercules,player);
                        }
                    });
                    player.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork->{
                        if (turtleBreathWork.isSkillZActive()){
                            turtleBreathWork.setSkillZActive(false);
                            turtleBreathWorkPacketMessages(turtleBreathWork,player);
                        }
                    });
                }else if (this.key.equals("X")){
                    immortalMiracle.setSkillXActive(!immortalMiracle.isSkillXActive());
                    player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu ->{
                        if (geShanDaNiu.isSkillXActive()){
                            geShanDaNiu.setSkillXActive(false);
                            geShanDaNiuMessages(geShanDaNiu,player);
                        }
                    });
                    player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman ->{
                        if (sunflowerPointCaveman.isSkillXActive()){
                            sunflowerPointCaveman.setSkillXActive(false);
                            sunflowerPointCavemanMessages(sunflowerPointCaveman,player);
                        }
                    });
                    player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar ->{
                        if (goldenBellJar.isSkillXActive()){
                            goldenBellJar.setSkillXActive(false);
                            goldenBellJarMessages(goldenBellJar,player);
                        }
                    });
                    player.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi->{
                        if (qianKunDaNuoYi.isSkillXActive()){
                            qianKunDaNuoYi.setSkillXActive(false);
                            qianKunDaNuoYi.setQianKunDaNuoYiUseCooldownMax(60);
                            qianKunDaNuoYiMessages(qianKunDaNuoYi,player);
                        }
                    });
                    player.getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).ifPresent(hercules->{
                        if (hercules.isSkillXActive()){
                            hercules.setSkillXActive(false);
                            herculesPacketMessages(hercules,player);
                        }
                    });
                    player.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork->{
                        if (turtleBreathWork.isSkillXActive()){
                            turtleBreathWork.setSkillXActive(false);
                            turtleBreathWorkPacketMessages(turtleBreathWork,player);
                        }
                    });
                }else if (this.key.equals("C")) {
                    immortalMiracle.setSkillCActive(!immortalMiracle.isSkillCActive());
                    player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu ->{
                        if (geShanDaNiu.isSkillCActive()){
                            geShanDaNiu.setSkillCActive(false);
                            geShanDaNiuMessages(geShanDaNiu,player);
                        }
                    });
                    player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman ->{
                        if (sunflowerPointCaveman.isSkillCActive()){
                            sunflowerPointCaveman.setSkillCActive(false);
                            sunflowerPointCavemanMessages(sunflowerPointCaveman,player);
                        }
                    });
                    player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar ->{
                        if (goldenBellJar.isSkillCActive()){
                            goldenBellJar.setSkillCActive(false);
                            goldenBellJarMessages(goldenBellJar,player);
                        }
                    });
                    player.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi->{
                        if (qianKunDaNuoYi.isSkillCActive()){
                            qianKunDaNuoYi.setSkillCActive(false);
                            qianKunDaNuoYi.setQianKunDaNuoYiUseCooldownMax(60);
                            qianKunDaNuoYiMessages(qianKunDaNuoYi,player);
                        }
                    });
                    player.getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).ifPresent(hercules->{
                        if (hercules.isSkillCActive()){
                            hercules.setSkillCActive(false);
                            herculesPacketMessages(hercules,player);
                        }
                    });
                    player.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork->{
                        if (turtleBreathWork.isSkillCActive()){
                            turtleBreathWork.setSkillCActive(false);
                            turtleBreathWorkPacketMessages(turtleBreathWork,player);
                        }
                    });
                }
                if (!immortalMiracle.isImmortalMiracleOff()){
                    immortalMiracle.setImmortalMiracleOff(true);
                }
                if (!immortalMiracle.isImmortalMiracleComprehend()) {
                    immortalMiracle.setImmortalMiracleComprehend(true);
                }
                ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
                        immortalMiracle.getImmortalMiracleLevel(),
                        immortalMiracle.isImmortalMiracleComprehend(),
                        immortalMiracle.getImmortalMiracleUseCooldownPercent(),
                        immortalMiracle.isImmortalMiracleOff(),
                        immortalMiracle.getImmortalMiracleToppedTick(),
                        immortalMiracle.getImmortalMiracleDachengTick(),
                        immortalMiracle.isImmortalMiracleParticle(),
                        immortalMiracle.getImmortalMiracleUseCooldownPercentMax(),
                        immortalMiracle.isSkillZActive(),
                        immortalMiracle.isSkillXActive(),
                        immortalMiracle.isSkillCActive()), player);
            });
        });
        return true;
    }

    public void geShanDaNiuMessages(GeShanDaNiuCapability geShanDaNiu, ServerPlayer player){
        ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
                geShanDaNiu.getGeShanDaNiuLevel(),
                geShanDaNiu.isGeShanDaNiuComprehend(),
                geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
                geShanDaNiu.getGeShanDaNiuToppedTick(),
                geShanDaNiu.getGeShanDaNiuDachengTick(),
                geShanDaNiu.isGeShanDaNiuParticle(),
                geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax(),
                geShanDaNiu.isSkillZActive(),
                geShanDaNiu.isSkillXActive(),
                geShanDaNiu.isSkillCActive()), player);
    }
    public void sunflowerPointCavemanMessages(SunflowerPointCavemanCapability sunflowerPointCaveman, ServerPlayer player){
        ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
                sunflowerPointCaveman.isSkillZActive(),
                sunflowerPointCaveman.isSkillXActive(),
                sunflowerPointCaveman.isSkillCActive()), player);
    }
    public void goldenBellJarMessages(GoldenBellJarCapability goldenBellJar, ServerPlayer player){
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
                goldenBellJar.isSkillCActive()), player);
    }
    public void qianKunDaNuoYiMessages(QianKunDaNuoYiCapability qianKunDaNuoYi ,ServerPlayer player){
        ChangShengJueMessages.sendToPlayer(new QianKunDaNuoYiPacket(
                qianKunDaNuoYi.getQianKunDaNuoYiLevel(),
                qianKunDaNuoYi.isQianKunDaNuoYiComprehend(),
                qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownPercent(),
                qianKunDaNuoYi.isQianKunDaNuoYiOff(),
                qianKunDaNuoYi.getQianKunDaNuoYiToppedTick(),
                qianKunDaNuoYi.getQianKunDaNuoYiDachengTick(),
                qianKunDaNuoYi.isQianKunDaNuoYiParticle(),
                qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownMax(),
                qianKunDaNuoYi.isSkillZActive(),
                qianKunDaNuoYi.isSkillXActive(),
                qianKunDaNuoYi.isSkillCActive()), player);
    }
    public void herculesPacketMessages(HerculesCapability hercules , ServerPlayer player){
        ChangShengJueMessages.sendToPlayer(new HerculesPacket(
                hercules.getHerculesLevel(),
                hercules.isHerculesComprehend(),
                hercules.getHerculesToppedTick(),
                hercules.getHerculesDachengTick(),
                hercules.isHerculesParticle(),
                hercules.isSkillZActive(),
                hercules.isSkillXActive(),
                hercules.isSkillCActive()), player);
    }

    public void turtleBreathWorkPacketMessages(TurtleBreathWorkCapability turtleBreathWork , ServerPlayer player){
        ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
                turtleBreathWork.getTurtleBreathWorkLevel(),
                turtleBreathWork.isTurtleBreathWorkComprehend(),
                turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
                turtleBreathWork.isTurtleBreathWorkOff(),
                turtleBreathWork.getTurtleBreathWorkToppedTick(),
                turtleBreathWork.getTurtleBreathWorkDachengTick(),
                turtleBreathWork.isTurtleBreathWorkParticle(),
                turtleBreathWork.isSkillZActive(),
                turtleBreathWork.isSkillXActive(),
                turtleBreathWork.isSkillCActive()), player);
    }
}
