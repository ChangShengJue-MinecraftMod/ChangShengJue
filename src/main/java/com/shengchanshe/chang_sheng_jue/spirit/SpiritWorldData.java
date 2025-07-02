package com.shengchanshe.chang_sheng_jue.spirit;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SpiritWorldData extends SavedData {
    public final Map<ChunkPos, Float> chunkData = new HashMap<>();

    // 单例获取方法
    public static SpiritWorldData get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(
                SpiritWorldData::load,
                SpiritWorldData::new,
                "spirit_level_data" // 存档文件名
        );
    }

    // 从NBT加载
    public static SpiritWorldData load(CompoundTag nbt) {
        SpiritWorldData data = new SpiritWorldData();
        ListTag chunksList = nbt.getList("chunks", 10); // 10对应CompoundTag类型
        for (Tag tag : chunksList) {
            CompoundTag entry = (CompoundTag) tag;
            ChunkPos pos = new ChunkPos(
                    entry.getInt("x"),
                    entry.getInt("z")
            );
            data.chunkData.put(pos, entry.getFloat("value"));
        }
        return data;
    }

    // 保存到NBT
    @Override
    public CompoundTag save(CompoundTag nbt) {
        ListTag chunksList = new ListTag();
        chunkData.forEach((pos, value) -> {
            CompoundTag entry = new CompoundTag();
            entry.putInt("x", pos.x);
            entry.putInt("z", pos.z);
            entry.putFloat("value", value);
            chunksList.add(entry);
        });
        nbt.put("chunks", chunksList);
        return nbt;
    }

    // 获取/设置灵气值
    public float getSpiritValue(ServerLevel level, ChunkPos pos) {
        return chunkData.computeIfAbsent(pos, p -> generateInitialValue(level, p));
    }

    public void setSpiritValue(ChunkPos pos, float value) {
        chunkData.put(pos, Math.max(0, value));
        setDirty(); // 标记需要保存
    }

    // 初始灵气值生成（枯竭到浓郁随机）
    private float generateInitialValue(ServerLevel level, ChunkPos pos) {
        boolean isModBiome = isModBiome(level, pos); // 需实现生物群系检测
        Random random = new Random(pos.toLong());

        return isModBiome ?
                random.nextInt(SpiritDensityLevel.SCARCE.getMin(), SpiritDensityLevel.ABUNDANT.getMax() + 1) :
                random.nextInt(SpiritDensityLevel.DEPLETED.getMin(), SpiritDensityLevel.RICH.getMax() + 1);
    }

    private boolean isModBiome(ServerLevel level, ChunkPos chunkPos) {
        BlockPos centerPos = new BlockPos(
                chunkPos.getMiddleBlockX(),
                64,
                chunkPos.getMiddleBlockZ()
        );

        Holder<Biome> biome = level.getBiome(centerPos);
        return biome.unwrapKey()
                .map(ResourceKey::location)
                .filter(loc -> loc.getNamespace().equals(ChangShengJue.MOD_ID))
                .isPresent();
    }


}
