package com.shengchanshe.chang_sheng_jue.entity.custom.wuxia;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Iterator;

public class AbstractWuXiaMerchant extends AbstractWuXia {
    // 补货相关变量
    private long lastRestockGameTime; // 上次补货的游戏时间（以游戏刻为单位）
    private int numberOfRestocksToday; // 今天补货的次数
    private long lastRestockCheckDayTime; // 上次检查补货的游戏时间（用于跨天重置）

    public AbstractWuXiaMerchant(EntityType<? extends AbstractWuXia> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }

    @Override
    protected int decreaseAirSupply(int pAir) {
        return pAir;
    }

    public boolean showProgressBar() {
        return false;
    }

    protected void startTrading(Player pPlayer) {
        this.setTradingPlayer(pPlayer);
        this.openTradingScreen(pPlayer, this.getDisplayName(),1);
    }

    public void setTradingPlayer(@Nullable Player pPlayer) {
        boolean flag = this.getTradingPlayer() != null && pPlayer == null;
        super.setTradingPlayer(pPlayer);
        if (flag) {
            this.stopTrading();
        }
    }

    // 检查村民是否可以补货
    public boolean canRestock() {
        return true; // 默认情况下，村民总是可以补货
    }

    // 执行补货操作
    public void restock() {
        this.updateDemand(); // 更新交易需求
        Iterator var1 = this.getOffers().iterator();

        // 重置所有交易的已使用次数
        while (var1.hasNext()) {
            MerchantOffer merchantoffer = (MerchantOffer) var1.next();
            merchantoffer.resetUses();
        }

        // 重新发送交易给当前交易的玩家
        this.resendOffersToTradingPlayer();
        this.lastRestockGameTime = this.level().getGameTime(); // 记录最后一次补货的游戏时间
        ++this.numberOfRestocksToday; // 增加今天的补货次数
    }

    // 检查是否需要补货
    private boolean needsToRestock() {
        Iterator var1 = this.getOffers().iterator();

        MerchantOffer merchantoffer;
        do {
            if (!var1.hasNext()) {
                return false; // 如果没有需要补货的交易，返回false
            }

            merchantoffer = (MerchantOffer) var1.next();
        } while (!merchantoffer.needsRestock()); // 检查交易是否需要补货

        return true; // 如果有需要补货的交易，返回true
    }

    // 检查是否允许补货
    private boolean allowedToRestock() {
        long currentTime = this.level().getGameTime();
        long timeSinceLastRestock = currentTime - this.lastRestockGameTime;
        long oneGameDayInTicks = 24000L; // 一个游戏日为 24000 游戏刻

        // 如果今天还没有补货，并且距离上次补货时间超过一个游戏日，则允许补货
        return this.numberOfRestocksToday == 0 && timeSinceLastRestock >= oneGameDayInTicks;
    }

    // 检查是否应该补货
    public boolean shouldRestock() {
        long i = this.lastRestockGameTime + 12000L; // 计算补货冷却时间
        long j = this.level().getGameTime();
        boolean flag = j > i; // 检查是否过了补货冷却时间
        long k = this.level().getDayTime();
        if (this.lastRestockCheckDayTime > 0L) {
            long l = this.lastRestockCheckDayTime / 24000L;
            long i1 = k / 24000L;
            flag |= i1 > l; // 如果已经过了一天，则允许补货
        }

        this.lastRestockCheckDayTime = k; // 更新最后一次检查补货的时间
        if (flag) {
            this.lastRestockGameTime = j; // 更新最后一次补货的时间
            this.resetNumberOfRestocks(); // 重置补货次数
        }

        return this.allowedToRestock() && this.needsToRestock(); // 返回是否允许补货且需要补货
    }

    // 重置补货次数
    private void resetNumberOfRestocks() {
        this.catchUpDemand(); // 更新需求
        this.numberOfRestocksToday = 0; // 重置今天的补货次数
    }

    // 更新交易需求
    private void updateDemand() {
        Iterator var1 = this.getOffers().iterator();

        while (var1.hasNext()) {
            MerchantOffer merchantoffer = (MerchantOffer) var1.next();
            merchantoffer.updateDemand(); // 更新每个交易的需求
        }
    }

    // 补货时更新需求
    private void catchUpDemand() {
        int i = this.numberOfRestocksToday;
        if (i == 0) {
            Iterator var2 = this.getOffers().iterator();

            // 重置所有交易的已使用次数
            while (var2.hasNext()) {
                MerchantOffer merchantoffer = (MerchantOffer) var2.next();
                merchantoffer.resetUses();
            }

            // 更新需求
            this.updateDemand();

            // 重新发送交易给当前交易的玩家
            this.resendOffersToTradingPlayer();
        }
    }

    @Override
    public void tick() {
        super.tick();

        // 检查是否需要补货
        if (this.shouldRestock()) {
            this.restock(); // 执行补货
        }
    }

    // 重新发送交易给当前交易的玩家
    private void resendOffersToTradingPlayer() {
        MerchantOffers merchantoffers = this.getOffers();
        Player player = this.getTradingPlayer();
        if (player != null && !merchantoffers.isEmpty()) {
            player.sendMerchantOffers(player.containerMenu.containerId, merchantoffers,1, this.getVillagerXp(), this.showProgressBar(), this.canRestock());
        }
    }

    // 保存补货数据到 NBT
    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putLong("LastRestock", this.lastRestockGameTime); // 保存上次补货时间
        pCompound.putInt("RestocksToday", this.numberOfRestocksToday); // 保存今天的补货次数
        pCompound.putLong("LastRestockCheckDayTime", this.lastRestockCheckDayTime); // 保存上次检查补货的时间
    }

    // 从 NBT 加载补货数据
    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("LastRestock")) {
            this.lastRestockGameTime = pCompound.getLong("LastRestock"); // 加载上次补货时间
        }
        if (pCompound.contains("RestocksToday")) {
            this.numberOfRestocksToday = pCompound.getInt("RestocksToday"); // 加载今天的补货次数
        }
        if (pCompound.contains("LastRestockCheckDayTime")) {
            this.lastRestockCheckDayTime = pCompound.getLong("LastRestockCheckDayTime"); // 加载上次检查补货的时间
        }
    }


    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return false;
    }

    protected void rewardTradeXp(MerchantOffer pOffer) {
        if (pOffer.shouldRewardExp()) {
            int $$1 = 3 + this.random.nextInt(4);
            this.level().addFreshEntity(new ExperienceOrb(this.level(), this.getX(), this.getY() + 0.5, this.getZ(), $$1));
        }

    }

}
