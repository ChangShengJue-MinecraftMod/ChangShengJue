package com.shengchanshe.chang_sheng_jue.entity.villagers.worker;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.worker.KilnWorkerMenu;
import com.shengchanshe.chang_sheng_jue.entity.custom.goal.ReturnToSpawnGoal;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.world.village.WuXiaMerahantTrades;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;

public class KilnWorker extends AbstractVillager {
    private static final String TRADE_OFFERS_BY_TYPE_TAG = "TradeOffersByType";

    private KilnWorkerTradeType currentTradeType = KilnWorkerTradeType.GRE;
    private final Map<KilnWorkerTradeType, MerchantOffers> tradeOffersByType =
            new EnumMap<>(KilnWorkerTradeType.class);
    // 补货相关变量
    private long lastRestockGameTime; // 上次补货的游戏时间（以游戏刻为单位）
    private int numberOfRestocksToday; // 今天补货的次数
    private long lastRestockCheckDayTime; // 上次检查补货的游戏时间（用于跨天重置）

    public KilnWorker(EntityType<? extends KilnWorker> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.updateTrades();
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,20.0D)
                .add(Attributes.MOVEMENT_SPEED,0.5D).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.6D));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9, 32.0F));
        this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6, false));
        this.goalSelector.addGoal(5, new ReturnToSpawnGoal(this, 0.6, 16, 100));
        this.goalSelector.addGoal(4, new GolemRandomStrollInVillageGoal(this, 0.6));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    public void openTradingScreen(Player pPlayer, Component pDisplayName, int pLevel) {
        OptionalInt present = pPlayer.openMenu(new SimpleMenuProvider((i, inventory, player) -> new KilnWorkerMenu(i, inventory, this), pDisplayName));
        if (present.isPresent()) {
            MerchantOffers merchantOffers = this.getOffers();
            if (!merchantOffers.isEmpty()) {
                pPlayer.sendMerchantOffers(present.getAsInt(), merchantOffers, pLevel, this.getVillagerXp(), this.showProgressBar(), this.canRestock());
            }
        }
    }

    public void setCurrentTradeType(KilnWorkerTradeType tradeType) {
        this.changeCurrentTradeType(tradeType);
    }

    public boolean changeCurrentTradeType(KilnWorkerTradeType tradeType) {
        if (tradeType == null || tradeType == this.currentTradeType) {
            return false;
        }
        this.tradeOffersByType.put(this.currentTradeType, this.getOffers());
        this.currentTradeType = tradeType;
        MerchantOffers storedOffers = this.tradeOffersByType.get(tradeType);
        if (storedOffers == null) {
            this.updateTrades();
        } else {
            this.offers = storedOffers;
        }
        return true;
    }

    public KilnWorkerTradeType getCurrentTradeType() {
        return this.currentTradeType;
    }

    @Override
    protected void updateTrades() {
        // 获取新的交易列表
        VillagerTrades.ItemListing[] listings = switch (this.currentTradeType) {
            case GRE -> WuXiaMerahantTrades.KILN_WORKER_TRADES.get(1);
            case RED -> WuXiaMerahantTrades.KILN_WORKER_TRADES.get(2);
            case BLACK -> WuXiaMerahantTrades.KILN_WORKER_TRADES.get(3);
            case BLUE -> WuXiaMerahantTrades.KILN_WORKER_TRADES.get(4);
            case GOLDEN -> WuXiaMerahantTrades.KILN_WORKER_TRADES.get(5);
            case WOOD -> WuXiaMerahantTrades.KILN_WORKER_TRADES.get(6);
        };

        if (listings != null) {
            MerchantOffers newOffers = new MerchantOffers();
            for (int i = 0; i < listings.length; i++) {
                MerchantOffer originalOffer = listings[i].getOffer(this, this.random);
                if (originalOffer != null) {
                    // 使用正确的8参数构造函数
                    MerchantOffer newOffer = new MerchantOffer(
                            originalOffer.getBaseCostA(),
                            originalOffer.getCostB(),
                            originalOffer.getResult(),
                            0,
                            originalOffer.getMaxUses(),
                            originalOffer.getXp(),
                            originalOffer.getPriceMultiplier(),
                            originalOffer.getDemand()
                    );
                    // 特殊价格处理（如果需要）
//                    setSpecialPriceThroughReflection(newOffer, originalOffer.getSpecialPriceDiff());
                    newOffers.add(newOffer);
                }
            }
            this.offers = newOffers;
            this.tradeOffersByType.put(this.currentTradeType, newOffers);
        }
    }

    private void setSpecialPriceThroughReflection(MerchantOffer offer, int specialPrice) {
        try {
            Field field = MerchantOffer.class.getDeclaredField("specialPriceDiff");
            field.setAccessible(true);
            field.setInt(offer, specialPrice);
        } catch (Exception e) {
            ChangShengJue.LOGGER.error("Could not set special price for merchant offer", e);
        }
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemInHand = pPlayer.getItemInHand(pHand);
        if (!itemInHand.is(ChangShengJueItems.KILN_WORKER_EGG.get()) && this.isAlive() && !this.isTrading() && !this.isBaby()) {
            if (pHand == InteractionHand.MAIN_HAND) {
                pPlayer.awardStat(Stats.TALKED_TO_VILLAGER);
            }

            if (this.getOffers().isEmpty()) {
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            } else {
                if (!this.level().isClientSide) {
                    this.startTrading(pPlayer);
                }

                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
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
        this.forEachTradeOffer(MerchantOffer::resetUses);

        // 重新发送交易给当前交易的玩家
        this.resendOffersToTradingPlayer();
        this.lastRestockGameTime = this.level().getGameTime(); // 记录最后一次补货的游戏时间
        ++this.numberOfRestocksToday; // 增加今天的补货次数
    }

    // 检查是否需要补货
    private boolean needsToRestock() {
        this.rememberCurrentOffers();
        for (MerchantOffers offers : this.uniqueTradeOffers()) {
            for (MerchantOffer offer : offers) {
                if (offer.needsRestock()) {
                    return true;
                }
            }
        }
        return false;
    }

    // 检查是否允许补货
    private boolean allowedToRestock() {
        long currentTime = this.level().getGameTime();
        return this.numberOfRestocksToday == 0
                || this.numberOfRestocksToday < 2 && currentTime > this.lastRestockGameTime + 2400L;
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
        this.forEachTradeOffer(MerchantOffer::updateDemand);
    }

    // 补货时更新需求
    private void catchUpDemand() {
        if (this.numberOfRestocksToday == 0) {
            this.updateDemand();
        }
    }

    private void forEachTradeOffer(java.util.function.Consumer<MerchantOffer> action) {
        this.rememberCurrentOffers();
        for (MerchantOffers offers : this.uniqueTradeOffers()) {
            offers.forEach(action);
        }
    }

    private Set<MerchantOffers> uniqueTradeOffers() {
        Set<MerchantOffers> offers = Collections.newSetFromMap(new IdentityHashMap<>());
        offers.addAll(this.tradeOffersByType.values());
        return offers;
    }

    private void rememberCurrentOffers() {
        this.tradeOffersByType.put(this.currentTradeType, this.getOffers());
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

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    // 保存补货数据到 NBT
    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        this.tradeOffersByType.put(this.currentTradeType, this.getOffers());
        super.addAdditionalSaveData(pCompound);
        pCompound.putLong("LastRestock", this.lastRestockGameTime); // 保存上次补货时间
        pCompound.putInt("RestocksToday", this.numberOfRestocksToday); // 保存今天的补货次数
        pCompound.putLong("LastRestockCheckDayTime", this.lastRestockCheckDayTime); // 保存上次检查补货的时间
        pCompound.putString("CurrentTradeType", this.currentTradeType.name());
        CompoundTag offersByTypeTag = new CompoundTag();
        this.tradeOffersByType.forEach((tradeType, offers) ->
                offersByTypeTag.put(tradeType.name(), offers.createTag()));
        pCompound.put(TRADE_OFFERS_BY_TYPE_TAG, offersByTypeTag);
    }

    // 从 NBT 加载补货数据
    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        MerchantOffers legacyActiveOffers = this.offers;
        if (pCompound.contains("LastRestock")) {
            this.lastRestockGameTime = pCompound.getLong("LastRestock"); // 加载上次补货时间
        }
        if (pCompound.contains("RestocksToday")) {
            this.numberOfRestocksToday = pCompound.getInt("RestocksToday"); // 加载今天的补货次数
        }
        if (pCompound.contains("LastRestockCheckDayTime")) {
            this.lastRestockCheckDayTime = pCompound.getLong("LastRestockCheckDayTime"); // 加载上次检查补货的时间
        }
        if (pCompound.contains("CurrentTradeType")) {
            try {
                this.currentTradeType = KilnWorkerTradeType.valueOf(pCompound.getString("CurrentTradeType"));
            } catch (IllegalArgumentException exception) {
                ChangShengJue.LOGGER.warn("忽略营造主事存档中的未知交易类型: {}", pCompound.getString("CurrentTradeType"));
                this.currentTradeType = KilnWorkerTradeType.GRE;
            }
        }
        this.tradeOffersByType.clear();
        if (pCompound.contains(TRADE_OFFERS_BY_TYPE_TAG, Tag.TAG_COMPOUND)) {
            CompoundTag offersByTypeTag = pCompound.getCompound(TRADE_OFFERS_BY_TYPE_TAG);
            for (KilnWorkerTradeType tradeType : KilnWorkerTradeType.values()) {
                if (offersByTypeTag.contains(tradeType.name(), Tag.TAG_COMPOUND)) {
                    this.tradeOffersByType.put(tradeType,
                            new MerchantOffers(offersByTypeTag.getCompound(tradeType.name())));
                }
            }
        }
        MerchantOffers activeOffers = this.tradeOffersByType.get(this.currentTradeType);
        if (activeOffers == null) {
            activeOffers = legacyActiveOffers;
            if (activeOffers == null) {
                this.updateTrades();
                activeOffers = this.offers;
            }
            this.tradeOffersByType.put(this.currentTradeType, activeOffers);
        }
        this.offers = activeOffers;
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

    public long getLastRestockGameTime() {
        return lastRestockGameTime;
    }

    public int getNumberOfRestocksToday() {
        return numberOfRestocksToday;
    }

    public long getLastRestockCheckDayTime() {
        return lastRestockCheckDayTime;
    }

    public void setLastRestockGameTime(long lastRestockGameTime) {
        this.lastRestockGameTime = lastRestockGameTime;
    }

    public void setNumberOfRestocksToday(int numberOfRestocksToday) {
        this.numberOfRestocksToday = numberOfRestocksToday;
    }

    public void setLastRestockCheckDayTime(long lastRestockCheckDayTime) {
        this.lastRestockCheckDayTime = lastRestockCheckDayTime;
    }
}
