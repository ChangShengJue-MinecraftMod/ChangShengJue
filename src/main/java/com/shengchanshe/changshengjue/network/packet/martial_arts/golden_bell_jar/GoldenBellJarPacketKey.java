//package com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar;
//
//import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
//import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
//import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
//import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.sounds.SoundSource;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraftforge.network.NetworkEvent;
//
//import java.util.function.Supplier;
//
//public class GoldenBellJarPacketKey {
//    int key;
//
//    public GoldenBellJarPacketKey(int key) {
//        this.key = key;
//    }
//
//    public GoldenBellJarPacketKey(FriendlyByteBuf buf) {
//        this.key = buf.readInt(); // 读取按键
//    }
//
//    public void toBytes(FriendlyByteBuf buf) {
//        buf.writeInt(this.key); // 写入按键
//    }
//
//    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
//        NetworkEvent.Context context = supplier.get();
//        context.enqueueWork(() -> {
//            ServerPlayer player = context.getSender();
//            ServerLevel level = player.serverLevel();
//            player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
//                if (!goldenBellJar.isGoldenBellJarComprehend()){
//                    goldenBellJar.setGoldenBellJarComprehend(true);
//                }
//                if (goldenBellJar.isGoldenBellJarOff()){
//                    if (goldenBellJar.getGoldenBellJarKey() != this.key) {
//                        goldenBellJar.setGoldenBellJarKey(this.key);
//                        goldenBellJar.setGoldenBellJarOff(false);
//                        goldenBellJar.setGoldenBellJarKeyTick(100);
//                    }else if (goldenBellJar.getGoldenBellJarKey() == this.key){
//                        goldenBellJar.setGoldenBellJarKey(this.key);
//                        goldenBellJar.setSkillActive(!goldenBellJar.isSkillActive());
//                    }
//                }
//
//                ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
//                        goldenBellJar.getGoldenBellJarLevel(),
//                        goldenBellJar.isGoldenBellJarComprehend(),
//                        goldenBellJar.getGoldenBellJarUseCooldownPercent(),
//                        goldenBellJar.isGoldenBellJarOff(),
//                        goldenBellJar.getGoldenBellJarToppedTick(),
//                        goldenBellJar.getGoldenBellJarDachengTick(),
//                        goldenBellJar.isGoldenBellJarParticle(),
//                        goldenBellJar.getGoldenBellJarKey(),
//                        goldenBellJar.isSkillActive()), player);
//
//            });
//        });
//        return true;
//    }
//}
