package com.shengchanshe.chang_sheng_jue.capability.cultivation.entity;

import com.shengchanshe.chang_sheng_jue.ChangShengJueConfig;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.cultivation.CultivationPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.xiu_xian.TriggerBreakthroughParticlePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.xiu_xian.TriggerTunNaParticlePacket;
import com.shengchanshe.chang_sheng_jue.spirit.SpiritDensityLevel;
import com.shengchanshe.chang_sheng_jue.spirit.SpiritManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;

import java.util.*;

public class CultivationCapability implements ICultivationCapability {
    private CultivationStage cultivationStage = CultivationStage.MORTAL; // 境界

    private EnumSet<SpiritRootType> spiritRootType = this.initializeRandomSpiritRoots();//灵根

    private float spiritPower = 0;//灵力
    private float spiritPowerMax = 0;
    private float truePower= 0;//真元

    private final int DEFAULT_APTITUDE = 25;
    private int aptitude = this.calculateAptitude();//资质
    private int aptitudeThresholdHigh = 25;
    private int aptitudeThresholdLow = 20;

    private float comprehension = 15;//悟性
    private int lifeSpan = 300;//寿元
    private Physique physique = Physique.ORDINARY;//体质
    private int tunNaTick = 0;//每次吐纳时间
    private float tunNaEfficiency = this.calculateTunNaEfficiency();//吐纳效率

    private boolean isSeclusion = false;
    private int seclusionTick = 20;
    private float seclusionEfficiency = this.calculateSeclusionEfficiency();//闭关效率

    private int heartRealm = 0;//心境
    private final int HEART_REALM_TO_SECLUSION_COUNT = 100;//心境提高闭关效率阈值
    private final float HEART_REALM_TO_SECLUSION_EFFICIENCY = 0.01f;//心境提高闭关效率

    private float juQiEfficiency = 100;//聚气效率

    @Override
    public CultivationStage getCultivationStage() {
        return this.cultivationStage;
    }

    @Override
    public void setCultivationStage(CultivationStage cultivationStage) {
        this.cultivationStage = cultivationStage;
    }

    @Override
    public EnumSet<SpiritRootType> getSpiritRoots() {
        return EnumSet.copyOf(spiritRootType);
    }

    @Override
    public boolean addSpiritRoot(SpiritRootType spiritRootType) {
        if (this.spiritRootType.size() >= SpiritRootType.values().length) return false;
        return this.spiritRootType.add(spiritRootType);
    }

    @Override
    public boolean hasAllRoots() {
        return spiritRootType.size() == SpiritRootType.values().length;
    }

    @Override
    public EnumSet<SpiritRootType> initializeRandomSpiritRoots() {
        EnumSet<SpiritRootType> roots = EnumSet.noneOf(SpiritRootType.class);
        SpiritRootType[] allTypes = SpiritRootType.values();
        int rootCount = 1 + RandomSource.create().nextInt(allTypes.length); // 1到最大数量

        // 随机选择不重复的灵根类型
        List<SpiritRootType> shuffled = new ArrayList<>(Arrays.asList(allTypes));
        Collections.shuffle(shuffled);

        for (int i = 0; i < rootCount; i++) {
            roots.add(shuffled.get(i));
        }

        return roots;
    }

    @Override
    public float getSpiritPower() {
        return this.spiritPower;
    }

    @Override
    public void setSpiritPower(float spiritPower) {
        this.spiritPower = spiritPower;
    }

    @Override
    public float getMaxSpiritPower() {
        return spiritPowerMax;
    }

    @Override
    public void setMaxSpiritPower(float maxSpiritPower) {
        this.spiritPowerMax = maxSpiritPower;
    }

    @Override
    public float calculateMaxSpiritPower(CultivationStage stage, int size, int ordinal) {
        if (stage.getDefaultSpiritPowerMax() > 0){
            if (size > 1){
                return stage.getDefaultSpiritPowerMax() + (stage.getDefaultSpiritPowerMax() * (size * 0.1f));
            }
        }
        return 0;
    }

    @Override
    public float getTruePower() {
        return this.truePower;
    }

    @Override
    public void setTruePower(float truePower) {
        this.truePower = truePower;
    }

    @Override
    public float getMaxTruePower() {
        return this.cultivationStage.getRequiredTruePower();
    }

    @Override
    public int getAptitude() {
        return this.aptitude;
    }
    @Override
    public void setAptitude(int aptitude) {
        this.aptitude = aptitude;
    }

    @Override
    public int calculateAptitude() {
        int size = this.getSpiritRoots().size();
        if (size > 1) {
            return this.DEFAULT_APTITUDE - ((size - 1) * 3);
        }
        return this.DEFAULT_APTITUDE;
    }

    @Override
    public float getComprehension() {
        return this.comprehension;
    }

    @Override
    public void setComprehension(float comprehension) {
        this.comprehension = comprehension;
    }

    @Override
    public int getLifeSpan() {
        return this.lifeSpan;
    }

    @Override
    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    @Override
    public Physique getPhysique() {
        return this.physique;
    }

    @Override
    public boolean setPhysique(Physique physiqueType) {
        return false;
    }

    @Override
    public int getTunNaTick() {
        return this.tunNaTick;
    }

    @Override
    public void setTunNaTick(int tunNaTick) {
        this.tunNaTick = tunNaTick;
    }

    @Override
    public float getTunNaEfficiency() {
        return this.tunNaEfficiency;
    }

    @Override
    public void setTunNaEfficiency(float tunNaEfficiency) {
        this.tunNaEfficiency = tunNaEfficiency;
    }

    @Override
    public float calculateTunNaEfficiency() {
        if (this.aptitude > this.aptitudeThresholdHigh) {
            //吐纳倍率 + (资质增加的吐纳倍率 * (资质 - 资质提升效率所需要的资质数量))
            return this.cultivationStage.getDefaultTunNaEfficiency() + ((ChangShengJueConfig.APTITUDE_TO_TUN_NA_RATE.get() * 0.01f) * (this.aptitude - this.aptitudeThresholdHigh));
        }else if (this.aptitude < this.aptitudeThresholdLow) {
            return this.cultivationStage.getDefaultTunNaEfficiency() - ((ChangShengJueConfig.APTITUDE_TO_TUN_NA_RATE.get() * 0.01f) * (this.aptitudeThresholdLow - this.aptitude));
        }
        return this.cultivationStage.getDefaultTunNaEfficiency();
    }

    @Override
    public boolean isSeclusion() {
        return this.isSeclusion;
    }

    @Override
    public void setSeclusion(boolean seclusion) {
        this.isSeclusion = seclusion;
    }

    @Override
    public int getSeclusionTick() {
        return this.seclusionTick;
    }

    @Override
    public void setSeclusionTick(int seclusionTick) {
        this.seclusionTick = seclusionTick;
    }

    @Override
    public float getSeclusionEfficiency() {
        return this.seclusionEfficiency;
    }

    @Override
    public void setSeclusionEfficiency(float seclusionEfficiency) {
        this.seclusionEfficiency = seclusionEfficiency;
    }

    @Override
    public float calculateSeclusionEfficiency() {
        CultivationStage[] stages = CultivationStage.values();
        int ordinal = this.getCultivationStage().ordinal();
        int size = this.getSpiritRoots().size();
        if (ordinal < stages.length - 1) {
            if (size > 1 && this.heartRealm > this.HEART_REALM_TO_SECLUSION_COUNT) {
                return (this.cultivationStage.getDefaultSeclusionEfficiency() - ((size - 1) * 0.01f))
                        + (((float) this.heartRealm / this.HEART_REALM_TO_SECLUSION_COUNT) * this.HEART_REALM_TO_SECLUSION_EFFICIENCY);
            }else if (this.heartRealm > this.HEART_REALM_TO_SECLUSION_COUNT){
                return this.cultivationStage.getDefaultSeclusionEfficiency()
                        + (((float) this.heartRealm / this.HEART_REALM_TO_SECLUSION_COUNT) * this.HEART_REALM_TO_SECLUSION_EFFICIENCY);
            }
        }else {
            if (size < 5 && this.heartRealm > this.HEART_REALM_TO_SECLUSION_COUNT) {
                return this.cultivationStage.getDefaultSeclusionEfficiency() - ((size - 1) * 0.02f);
            }else if (this.heartRealm > this.HEART_REALM_TO_SECLUSION_COUNT){
                return this.cultivationStage.getDefaultSeclusionEfficiency()
                        + (((float) this.heartRealm / this.HEART_REALM_TO_SECLUSION_COUNT) * this.HEART_REALM_TO_SECLUSION_EFFICIENCY);
            }
        }
        return this.cultivationStage.getDefaultSeclusionEfficiency();
    }

    @Override
    public int getHeartRealm() {
        return this.heartRealm;
    }
    @Override
    public HeartRealm getCurrentLevel() {
        return HeartRealm.getLevel(this.heartRealm, this.cultivationStage);
    }

    @Override
    public float getJiQiEfficiency() {
        return juQiEfficiency;
    }

    @Override
    public void setJiQiEfficiency(float jiQiEfficiency) {
        this.juQiEfficiency = jiQiEfficiency;
    }

    @Override
    public float calculateJiQiEfficiency(Player player) {
        CultivationStage[] stages = CultivationStage.values();
        int ordinal = this.getCultivationStage().ordinal();
        int size = this.getSpiritRoots().size();
        float absorbSpiritPowerMax = this.cultivationStage.getAbsorbSpiritPowerMax();
        ServerLevel serverLevel = (ServerLevel) player.level();
        SpiritDensityLevel density = SpiritDensityLevel.getForValue(
                SpiritManager.getSpiritValue(serverLevel, player.getOnPos())
        );
        if (ordinal >= stages.length - 1) {
            if (size > 1) {
                return absorbSpiritPowerMax +
                        ((absorbSpiritPowerMax * (((size - 1) * (ChangShengJueConfig.SPIRIT_ROOT_JU_QI_EFFICIENCY.get() * 0.01f))))
                        + (absorbSpiritPowerMax * density.getEfficiency()));
            }
        }
        return absorbSpiritPowerMax + (absorbSpiritPowerMax * density.getEfficiency());
    }

//    public float calculateJiQiEfficiency(Player player) {
//        CultivationStage[] stages = CultivationStage.values();
//        int ordinal = this.getCultivationStage().ordinal();
//        int rootCount = this.getSpiritRoots().size();
//        float absorbSpiritPowerMax = this.cultivationStage.getAbsorbSpiritPowerMax();
//        ServerLevel serverLevel = (ServerLevel) player.level();
//        SpiritDensityLevel density = SpiritDensityLevel.getForValue(SpiritManager.getSpiritValue(serverLevel, player.getOnPos()));
//        if (ordinal >= stages.length - 1) {
//            float rootBonus = (rootCount > 1) ?
//                    absorbSpiritPowerMax * ((rootCount - 1) * ChangShengJueConfig.SPIRIT_ROOT_JU_QI_EFFICIENCY.get() * 0.01f) : 0;
//            float densityFactor = 1 + density.getEfficiency();
//            return Math.max(0, absorbSpiritPowerMax + rootBonus) * densityFactor;
//        }
//        return absorbSpiritPowerMax + (absorbSpiritPowerMax * density.getEfficiency());
//    }

    @Override
    public void absorbSpiritPower(Player player) {
        if (player.level() instanceof ServerLevel level) {
            if (this.isSeclusion) return;
            // 获取玩家所在区块的灵气数据
            float chunkSpirit = SpiritManager.getSpiritValue(level, player.getOnPos());

            if (this.spiritPower < this.getMaxSpiritPower() && chunkSpirit > 0) {
                if (this.tunNaTick <= 0) {
                    float juQi = Math.min(chunkSpirit, this.juQiEfficiency);

                    this.spiritPower = Math.min(this.getMaxSpiritPower(),
                            this.spiritPower + (juQi * this.tunNaEfficiency));

                    if (!player.isCreative() || !(player.isSpectator())){
                        SpiritManager.modifySpirit(level, player.blockPosition(), -juQi);
                    }

                    this.juQiEfficiency = this.calculateJiQiEfficiency(player);
                    this.tunNaTick = RandomSource.create().nextInt(41) + 80;

                    if (ChangShengJueConfig.TUN_NA_PARTICLE.get()){
                        ChangShengJueMessages.sendToPlayer(
                                new TriggerTunNaParticlePacket(player.getUUID()),
                                (ServerPlayer) player);
                    }

                    ChangShengJueMessages.sendToPlayer(new CultivationPacket(
                                    this.cultivationStage.getName(this.truePower,this.cultivationStage),
                                    this.cultivationStage.ordinal(),
                                    this.spiritPower,
                                    this.getMaxSpiritPower(),
                                    this.truePower,
                                    this.getMaxTruePower(),
                                    this.tunNaTick), (ServerPlayer) player);
                } else {
                    this.tunNaTick--;
                }
            }
        }
    }

    @Override
    public void convertTruePower(Player player) {
        if (this.isSeclusion){
            if (this.truePower < this.getMaxTruePower() && this.spiritPower > 0) {
                if (this.seclusionTick <= 0) {
                    this.truePower = Math.min(this.getMaxTruePower(), this.truePower
                            + ((Math.min(this.spiritPower, this.cultivationStage.getTransformedSpiritPowerMax())) * this.seclusionEfficiency));
                    player.sendSystemMessage(Component.literal("闭关转换真元,当前真元" + this.getTruePower()));
                    this.spiritPower = this.spiritPower > this.cultivationStage.getTransformedSpiritPowerMax()
                            ? this.spiritPower - this.cultivationStage.getTransformedSpiritPowerMax() : 0;
                    this.seclusionTick = 20;
                }else {
                    this.seclusionTick--;
                }
            }else {
                this.checkStageAdvancement(player,this.truePower);
                if (this.isSeclusion){
                    this.isSeclusion = false;
                }
            }
            ChangShengJueMessages.sendToPlayer(new CultivationPacket(
                            this.cultivationStage.getName(this.truePower,this.cultivationStage),
                            this.cultivationStage.ordinal(),
                            this.spiritPower,
                            this.getMaxSpiritPower(),
                            this.truePower,
                            this.getMaxTruePower(),
                            this.tunNaTick),
                    (ServerPlayer) player);
        }
    }

    @Override
    public void checkStageAdvancement(Player player, float truePower) {
        if (this.cultivationStage.canAdvance(truePower)) {
            CultivationStage[] stages = CultivationStage.values();
            int ordinal = this.getCultivationStage().ordinal();
            int size = this.spiritRootType.size();
            if (ordinal < stages.length - 1) {
                CultivationStage stage = stages[ordinal + 1];
                this.cultivationStage = stage;
                ordinal = this.getCultivationStage().ordinal();
                this.spiritPowerMax = this.calculateMaxSpiritPower(stage, size, ordinal);
                this.tunNaEfficiency = this.calculateTunNaEfficiency();
                this.seclusionEfficiency = this.calculateSeclusionEfficiency();
                this.juQiEfficiency = this.calculateJiQiEfficiency(player);
                this.isSeclusion = false;
                this.truePower = 0;

                if (ChangShengJueConfig.BREAKTHROUGH_PARTICLE.get()){
                    ChangShengJueMessages.sendToPlayer(
                            new TriggerBreakthroughParticlePacket(player.getUUID(), ordinal, this.cultivationStage.getBreakthroughTick()),
                            (ServerPlayer) player);
                }
            }
        }
    }


    @Override
    public void setHeartRealm(int heartRealm) {
        if (heartRealm <= 0) return;

        int newHeartRealm = this.heartRealm + heartRealm;
        HeartRealm currentLevel = getCurrentLevel();
        newHeartRealm = Math.min(newHeartRealm, currentLevel.getStageCap());
//        boolean leveledUp = (getCurrentLevel() != HeartRealm.getLevel(newHeartRealm, cultivationStage));
        this.heartRealm = newHeartRealm;
    }

    @Override
    public void copy(ICultivationCapability oldStore) {
        this.cultivationStage = oldStore.getCultivationStage();
        this.spiritRootType = oldStore.getSpiritRoots();
        this.spiritPower = oldStore.getSpiritPower();
        this.spiritPowerMax = oldStore.getMaxSpiritPower();
        this.truePower = oldStore.getTruePower();
        this.aptitude = oldStore.getAptitude();
        this.comprehension = oldStore.getComprehension();
        this.lifeSpan = oldStore.getLifeSpan();
        this.physique = oldStore.getPhysique();
        this.tunNaTick = oldStore.getTunNaTick();
        this.tunNaEfficiency = oldStore.getTunNaEfficiency();
        this.isSeclusion = oldStore.isSeclusion();
        this.seclusionTick = oldStore.getSeclusionTick();
        this.seclusionEfficiency = oldStore.getSeclusionEfficiency();
        this.heartRealm = oldStore.getHeartRealm();
        this.juQiEfficiency = oldStore.getJiQiEfficiency();
    }

    @Override
    public CompoundTag serializeNBT(CompoundTag nbt) {
        nbt.putString("CultivationStage", this.cultivationStage.name());
        nbt.putFloat("SpiritPower", this.spiritPower);
        nbt.putFloat("SpiritPowerMax", this.spiritPowerMax);
        nbt.putFloat("TruePower", this.truePower);
        // 存储灵根类型
        ListTag rootsList = new ListTag();
        spiritRootType.forEach(root -> rootsList.add(IntTag.valueOf(root.ordinal())));
        nbt.put("Roots", rootsList);
        //存储资质
        nbt.putInt("Aptitude", this.aptitude);
        nbt.putInt("AptitudeThresholdHigh", this.aptitudeThresholdHigh);
        nbt.putInt("AptitudeThresholdLow", this.aptitudeThresholdLow);
        //存储悟性
        nbt.putFloat("Comprehension", this.comprehension);
        //存储寿元
        nbt.putInt("LifeSpan", this.lifeSpan);
        //存储体质
        nbt.putString("Physique", this.physique.name());
        //存储吐纳时间
        nbt.putInt("TunNaTick", this.tunNaTick);
        //存储吐纳效率
        nbt.putFloat("TunNaEfficiency", this.tunNaEfficiency);
        //是否开始闭关
        nbt.putBoolean("IsSeclusion", this.isSeclusion);
        //闭关时间
        nbt.putInt("SeclusionTick", this.seclusionTick);
        //存储闭关效率
        nbt.putFloat("SeclusionEfficiency", this.seclusionEfficiency);
        //存储心境
        nbt.putInt("HeartRealm", this.heartRealm);
        //存储聚气值
        nbt.putFloat("JuQiEfficiency", this.juQiEfficiency);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        spiritRootType.clear();
        this.cultivationStage = CultivationStage.valueOf(nbt.getString("CultivationStage"));
        this.spiritPower = nbt.getFloat("SpiritPower");
        this.spiritPowerMax = nbt.getFloat("SpiritPowerMax");
        this.truePower = nbt.getFloat("TruePower");
        // 读取灵根类型
        ListTag rootsList = nbt.getList("Roots", Tag.TAG_INT);
        for (var tag : rootsList) {
            int id = ((IntTag) tag).getAsInt();
            if (id >= 0 && id < SpiritRootType.values().length) {
                spiritRootType.add(SpiritRootType.values()[id]);
            }
        }
        this.aptitude = nbt.getInt("Aptitude");
        this.aptitudeThresholdHigh = nbt.getInt("AptitudeThresholdHigh");
        this.aptitudeThresholdLow = nbt.getInt("AptitudeThresholdLow");
        this.comprehension = nbt.getFloat("Comprehension");
        this.lifeSpan = nbt.getInt("LifeSpan");
        this.physique = Physique.valueOf(nbt.getString("Physique"));
        this.tunNaTick = nbt.getInt("TunNaRate");
        this.tunNaEfficiency = nbt.getFloat("TunNaEfficiency");
        this.isSeclusion = nbt.getBoolean("IsSeclusion");
        this.seclusionTick = nbt.getInt("SeclusionTick");
        this.seclusionEfficiency = nbt.getFloat("SeclusionEfficiency");
        this.heartRealm = nbt.getInt("HeartRealm");
        this.juQiEfficiency = nbt.getFloat("JuQiEfficiency");
    }

}