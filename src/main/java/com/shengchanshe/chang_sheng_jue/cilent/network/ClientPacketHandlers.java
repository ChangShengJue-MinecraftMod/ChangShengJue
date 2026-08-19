package com.shengchanshe.chang_sheng_jue.cilent.network;

import com.shengchanshe.chang_sheng_jue.network.ClientPacketBridge;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangQuestsScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.ClientQuestDataCache;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.PlayerQuestScreen;
import com.shengchanshe.chang_sheng_jue.cilent.hud.kungfu.KungFuClientData;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.util.particle.ComprehendParticle;
import com.shengchanshe.chang_sheng_jue.util.particle.DachengParticle;
import com.shengchanshe.chang_sheng_jue.util.particle.XpParatice;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public final class ClientPacketHandlers {
    private ClientPacketHandlers() {
    }

    public static void register() {
        ClientPacketBridge.install(
                ClientPacketHandlers::syncQuestData,
                ClientPacketHandlers::refreshQuestScreen,
                ClientPacketHandlers::refreshPlayerQuestScreen,
                ClientPacketHandlers::syncKungFuCapability,
                ClientPacketHandlers::triggerKungFuParticle,
                ClientPacketHandlers::triggerKungFuLevelUpParticle,
                ClientPacketHandlers::immortalMiracleParticle,
                ClientPacketHandlers::wuGangCutGuiParticle,
                ClientPacketHandlers::treadTheSnowWithoutTraceParticle,
                ClientPacketHandlers::xpParticle
        );
    }

    public static void syncQuestData(UUID playerId, CompoundTag questData) {
        if (questData != null) {
            ClientQuestDataCache.get().updateData(playerId, questData);
        }
    }

    public static void refreshQuestScreen(List<Quest> availableQuests) {
        if (Minecraft.getInstance().screen instanceof GangQuestsScreen screen) {
            List<Quest> newQuests = new ArrayList<>();
            for (Quest questData : availableQuests) {
                Quest newData = new Quest(questData.toNbt());
                newData.updateFrom(questData);
                if (newData.getAcceptedBy() == null) {
                    newQuests.add(newData);
                }
            }
            screen.forceRefresh(newQuests);
        }
    }

    public static void refreshPlayerQuestScreen() {
        if (Minecraft.getInstance().screen instanceof PlayerQuestScreen screen) {
            screen.getMenu().getCurrentQuest(screen.getMenu().getCurrentPage()).ifPresent(quest -> screen.refreshUI());
        }
    }

    public static void syncKungFuCapability(CompoundTag data) {
        if (data != null) {
            KungFuClientData.get().handleKungFuSync(data);
        }
    }

    public static void triggerKungFuParticle(UUID playerId, String kungFuId) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) {
            return;
        }

        Player player = minecraft.level.getPlayerByUUID(playerId);
        if (player != null && player.level() == minecraft.level) {
            int remainingCooldown = KungFuClientData.get().kungFuComprehend(kungFuId);
            ComprehendParticle.ComprehendParticle(player, player.level(), remainingCooldown);
        }
    }

    public static void triggerKungFuLevelUpParticle(UUID playerId, String kungFuId) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) {
            return;
        }

        Player player = minecraft.level.getPlayerByUUID(playerId);
        if (player != null && player.level() == minecraft.level) {
            int remainingCooldown = KungFuClientData.get().kungFuLevelUpTick(kungFuId);
            DachengParticle.DachengParticle(player, player.level(), remainingCooldown);
        }
    }

    public static void immortalMiracleParticle(UUID playerId, String kungFuId) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) {
            return;
        }

        Player player = minecraft.level.getPlayerByUUID(playerId);
        if (player != null && player.level() == minecraft.level) {
            double radius = 0.4;
            int particleCount = 3;

            for (int i = 0; i < particleCount; i++) {
                double phi = Math.random() * Math.PI * 2;
                double costheta = Math.random() * 2 - 1;
                double theta = Math.acos(costheta);
                double randomAngleVariation = Math.random() * 0.5 - 0.25;
                phi += randomAngleVariation;

                double dx = radius * Math.sin(theta) * Math.cos(phi);
                double dy = radius * Math.sin(theta) * Math.sin(phi);
                double dz = radius * Math.cos(theta);
                double speedFactor = 0.2;
                double speedX = dx * speedFactor;
                double speedY = dy * speedFactor;
                double speedZ = dz * speedFactor;

                player.level().addParticle(ChangShengJueParticles.IMMORTAL_MIRACLE_PARTICLE.get(),
                        player.getX() + dx, player.getY() + 1.3 + dy, player.getZ() + dz,
                        speedX, speedY, speedZ);
            }
        }
    }

    public static void wuGangCutGuiParticle(float x, float y, float z) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level != null) {
            minecraft.level.addParticle(ChangShengJueParticles.WU_GANG_CUT_GUI_PARTICLE_1.get(),
                    x, y, z, 0, 0, 0);
        }
    }

    public static void treadTheSnowWithoutTraceParticle(UUID playerId, String kungFuId) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) {
            return;
        }

        Player player = minecraft.level.getPlayerByUUID(playerId);
        if (player != null && player.level() == minecraft.level) {
            int numParticles = 1;
            Random random = new Random();

            for (int i = 0; i < numParticles; ++i) {
                double radius = 0.3;
                double theta = random.nextDouble() * 2 * Math.PI;
                double phi = random.nextDouble() * Math.PI;
                double offsetX = radius * Math.sin(phi) * Math.cos(theta);
                double offsetY = radius * Math.sin(phi) * Math.sin(theta);
                double offsetZ = radius * Math.cos(phi);
                double particleX = player.getX() + offsetX;
                double particleY = player.getY() + offsetY;
                double particleZ = player.getZ() + offsetZ;

                double playerYawRadians = Math.toRadians(player.getYRot());
                double playerPitchRadians = Math.toRadians(player.getXRot());
                double directionX = Math.sin(playerYawRadians) * Math.cos(playerPitchRadians);
                double directionZ = -Math.cos(playerYawRadians) * Math.cos(playerPitchRadians);
                Vec3 normalizedDirection = new Vec3(directionX, 0, directionZ).normalize();
                double speedFactor = 0.3;
                double speedX = normalizedDirection.x * speedFactor;
                double speedZ = normalizedDirection.z * speedFactor;

                player.level().addParticle(ChangShengJueParticles.TREAD_THE_SNOW_WITHOUT_TRACE_PARTICLE.get(),
                        particleX, particleY, particleZ, speedX, 0, speedZ);
            }
        }
    }

    public static void xpParticle(UUID playerId, SimpleParticleType particleType, int tick) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) {
            return;
        }

        Player player = minecraft.level.getPlayerByUUID(playerId);
        if (player != null && player.level() == minecraft.level) {
            XpParatice.XpParaticeParticle(particleType, player, player.level(), tick);
        }
    }
}
