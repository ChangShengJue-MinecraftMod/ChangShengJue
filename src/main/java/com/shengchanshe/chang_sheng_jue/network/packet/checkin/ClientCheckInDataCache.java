package com.shengchanshe.chang_sheng_jue.network.packet.checkin;

import com.shengchanshe.chang_sheng_jue.checkin.PlayerCheckInData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * 客户端签到数据缓存
 */
@OnlyIn(Dist.CLIENT)
public class ClientCheckInDataCache {
    private static PlayerCheckInData cachedData = null;

    public static void setPlayerData(PlayerCheckInData data) {
        cachedData = data;
    }

    public static PlayerCheckInData getPlayerData() {
        return cachedData;
    }

    public static void clear() {
        cachedData = null;
    }
}
