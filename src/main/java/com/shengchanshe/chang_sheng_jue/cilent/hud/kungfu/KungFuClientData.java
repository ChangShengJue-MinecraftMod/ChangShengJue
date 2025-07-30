package com.shengchanshe.chang_sheng_jue.cilent.hud.kungfu;

import com.shengchanshe.chang_sheng_jue.martial_arts.IKungFu;
import com.shengchanshe.chang_sheng_jue.martial_arts.IKungFuUpgradable;
import com.shengchanshe.chang_sheng_jue.martial_arts.KungFuRegistry;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.light_kungfu.TreadTheSnowWithoutTrace;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class KungFuClientData {
    private static final KungFuClientData INSTANCE = new KungFuClientData();
    private final ConcurrentHashMap<String, IKungFu> clientData = new ConcurrentHashMap<>();

    public static KungFuClientData get() {
        return INSTANCE;
    }

    public void handleKungFuSync(CompoundTag data) {
        clientData.clear();
        ListTag kungFuList = data.getList("LearnedKungFu", Tag.TAG_COMPOUND);

        for (Tag t : kungFuList) {
            CompoundTag kungFuTag = (CompoundTag)t;
            String id = kungFuTag.getString("KungFuId");
            KungFuRegistry.getInstance().getKungFu(id).ifPresent(kungFu -> {
                kungFu.deserializeNBT(kungFuTag);
                clientData.put(id, kungFu);
            });
        }
    }

    /**
     * 根据武功ID获取武功数据
     * @param id 武功ID
     * @return 对应的武功对象，如果不存在则返回Optional.empty()
     */
    public Optional<IKungFu> getKungFu(String id) {
        return Optional.ofNullable(clientData.get(id));
    }

    /**
     * 获取当前所有正在冷却的武功（cooldown > 0）
     * @return 正在冷却的武功ID集合
     */
    public Set<String> getCoolingDownKungFu() {
        return clientData.entrySet().stream()
                .filter(entry -> entry.getValue().getCoolDown() > 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Set<String> getComprehendTickKungFu() {
        return clientData.entrySet().stream()
                .filter(entry -> entry.getValue().getLevelUpTick() >= 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public int kungFuComprehend(String id) {
        return Optional.ofNullable(clientData.get(id))
                .map(IKungFu::getLevelUpTick)
                .orElse(0); // 提供一个默认的冷却时间
    }

    public Set<String> getLevelUpTickKungFu() {
        return clientData.entrySet().stream()
                .filter(entry -> entry.getValue().getDachengTick() >= 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public int kungFuLevelUpTick(String id) {
        return Optional.ofNullable(clientData.get(id))
                .map(IKungFu::getDachengTick)
                .orElse(0); // 提供一个默认的冷却时间
    }

    /**
     * 检查指定武功是否在冷却中
     * @param id 武功ID
     * @return 如果武功存在且冷却中返回 true，否则 false
     */
    public boolean isCoolingDown(String id) {
        return Optional.ofNullable(clientData.get(id))
                .map(kungFu -> kungFu.getCoolDown() > 0)
                .orElse(false);
    }

    public boolean knowsKungFu(String id) {
        return clientData.containsKey(id);
    }

    /**
     * 检查指定武功是否已经领悟
     * @param id 武功ID
     * @return 如果武功已经领悟返回 true，否则 false
     */
    public boolean isKnows(String id) {
        return Optional.ofNullable(clientData.get(id))
                .map(IKungFu::isComprehend)
                .orElse(false);
    }

    /**
     * 检查指定武功是否已经启用
     * @param id 武功ID
     * @return 如果武功已经启用返回 true，否则 false
     */
    public boolean isStart(String id) {
        return Optional.ofNullable(clientData.get(id))
                .map(IKungFu::isStart)
                .orElse(false);
    }

    public int getKungFuLevel(String id) {
        return Optional.ofNullable(clientData.get(id))
                .filter(kungFu -> kungFu instanceof IKungFuUpgradable)
                .map(kungFu -> (IKungFuUpgradable) kungFu)
                .map(IKungFuUpgradable::getLevel)
                .orElse(0); // 提供一个默认的等级
    }

    public int getMaxKungFuLevel(String id) {
        return Optional.ofNullable(clientData.get(id))
                .filter(kungFu -> kungFu instanceof IKungFuUpgradable)
                .map(kungFu -> (IKungFuUpgradable) kungFu)
                .map(IKungFuUpgradable::getMaxLevel)
                .orElse(0); // 提供一个默认的等级
    }

    public int getMaxCoolDown(String id) {
        return Optional.ofNullable(clientData.get(id))
                .map(IKungFu::getMaxCoolDown)
                .orElse(5); // 提供一个默认的冷却时间
    }

    public int kungFuCoolDown(String id) {
        return Optional.ofNullable(clientData.get(id))
                .map(IKungFu::getCoolDown)
                .orElse(0); // 提供一个默认的冷却时间
    }

    public void clear() {
        clientData.clear();
    }
}
