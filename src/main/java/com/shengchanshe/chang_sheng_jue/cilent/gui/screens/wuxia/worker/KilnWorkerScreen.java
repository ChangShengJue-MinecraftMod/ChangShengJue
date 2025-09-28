package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.worker;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.button.TexturedButtonWithText;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.KilnWorkerSetTradeTypePacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ServerboundSelectTradePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KilnWorkerScreen extends AbstractContainerScreen<KilnWorkerMenu> {
    private static final ResourceLocation VILLAGER_LOCATION = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/container/worker_trading.png");
    private static final ResourceLocation BOTTON = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/botton.png");
    //整张纹理的宽和高
    private static final int TEXTURE_WIDTH = 512;
    private static final int TEXTURE_HEIGHT = 512;
    private static final int MERCHANT_MENU_PART_X = 99;  //整张纹理中菜单的宽度
    //进度条的宽和高,这里不显示进度条,在实体中设置
    private static final int PROGRESS_BAR_X = 136;
    private static final int PROGRESS_BAR_Y = 59;
    //商品物品在菜单中的位置
    private static final int SELL_ITEM_1_X = 5;
    private static final int SELL_ITEM_2_X = 35;
    private static final int BUY_ITEM_X = 68;
    private static final int LABEL_Y = 6;
    private static final int NUMBER_OF_OFFER_BUTTONS = 7;
    private static final int TRADE_BUTTON_X = 7;//交易按钮x轴的位置
    //交易按钮的宽和高
    private static final int TRADE_BUTTON_HEIGHT = 20;
    private static final int TRADE_BUTTON_WIDTH = 87;
    //滚动条的宽和高
    private static final int SCROLLER_HEIGHT = 27;
    private static final int SCROLLER_WIDTH = 6;
    //滚动条整体高度
    private static final int SCROLL_BAR_HEIGHT = 139;
    //滚动条的位置
    private static final int SCROLL_BAR_TOP_POS_Y = 61;
    private static final int SCROLL_BAR_START_X = 95;
    //文字
    private static final Component TRADES_LABEL = Component.translatable("merchant.trades");
    private static final Component LEVEL_SEPARATOR = Component.literal(" - ");
    private static final Component DEPRECATED_TOOLTIP = Component.translatable("merchant.deprecated");
    private int shopItem;
    private final TradeOfferButton[] tradeOfferButtons = new TradeOfferButton[NUMBER_OF_OFFER_BUTTONS];
    int scrollOff;
    private boolean isDragging;

    private TradeType currentTradeType = TradeType.GRE;
    private ImageButton greButton;
    private ImageButton redButton;
    private ImageButton blackButton;
    private ImageButton blueButton;
    private ImageButton goldenButton;

    public KilnWorkerScreen(KilnWorkerMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageWidth = 276;
        this.imageHeight = 209;
        this.inventoryLabelX = 107;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    private void postButtonClick() {
        this.menu.setSelectionHint(this.shopItem);
        this.menu.tryMoveItems(this.shopItem);
        this.minecraft.getConnection().send(new ServerboundSelectTradePacket(this.shopItem));
    }

    @Override
    protected void init() {
        super.init();
        int left = (this.width - this.imageWidth) / 2;
        int top = (this.height - this.imageHeight) / 2;
        int buttonY = top + PROGRESS_BAR_Y + 2;

        for (int i = 0; i < NUMBER_OF_OFFER_BUTTONS; ++i) {
            this.tradeOfferButtons[i] = this.addRenderableWidget(new TradeOfferButton(left + TRADE_BUTTON_X, buttonY, i, button -> {
                if (button instanceof TradeOfferButton) {
                    this.shopItem = ((TradeOfferButton) button).getIndex() + this.scrollOff;
                    this.postButtonClick();
                }

            }));
            buttonY += TRADE_BUTTON_HEIGHT;
        }

        this.greButton = this.addRenderableWidget(new TexturedButtonWithText(left - 32, top + 48, 35, 25, 0, 0, 25, BOTTON, 256, 256, button -> {
                    this.setCurrentTradeType(TradeType.GRE);
                    this.sendTradeTypeUpdate(TradeType.GRE);
                }, Component.translatable("button." + ChangShengJue.MOD_ID + ".gre_button.tips"),
                        0x000, 0x000, 1.0F, 1.0F, 1.0F, 1.0F)
                        .setItemIcon(new ItemStack(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_2.get())))
                .setItemIconPosition(TexturedButtonWithText.IconPosition.CENTER)
                .setItemIconScale(1.2f);
        this.redButton = this.addRenderableWidget(new TexturedButtonWithText(left - 32, (top + 48) + 25, 35, 25, 0, 0, 25, BOTTON, 256, 256, button -> {
                    this.setCurrentTradeType(TradeType.RED);
                    this.sendTradeTypeUpdate(TradeType.RED);
                }, Component.translatable("button." + ChangShengJue.MOD_ID + ".red_button.tips"),
                        0x000, 0x000, 1.0F, 1.0F, 1.0F, 1.0F)
                        .setItemIcon(new ItemStack(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_2.get())))
                .setItemIconPosition(TexturedButtonWithText.IconPosition.CENTER)
                .setItemIconScale(1.2f);
        this.blackButton = this.addRenderableWidget(new TexturedButtonWithText(left - 32, (top + 48) + (25 * 2), 35, 25, 0, 0, 25, BOTTON, 256, 256, button -> {
                    this.setCurrentTradeType(TradeType.BLACK);
                    this.sendTradeTypeUpdate(TradeType.BLACK);
                }, Component.translatable("button." + ChangShengJue.MOD_ID + ".black_button.tips"),
                        0x000, 0x000, 1.0F, 1.0F, 1.0F, 1.0F)
                        .setItemIcon(new ItemStack(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get())))
                .setItemIconPosition(TexturedButtonWithText.IconPosition.CENTER)
                .setItemIconScale(1.2f);
        this.blueButton = this.addRenderableWidget(new TexturedButtonWithText(left - 32, (top + 48) + (25 * 3), 35, 25, 0, 0, 25, BOTTON, 256, 256, button -> {
                    this.setCurrentTradeType(TradeType.BLUE);
                    this.sendTradeTypeUpdate(TradeType.BLUE);
                }, Component.translatable("button." + ChangShengJue.MOD_ID + ".blue_button.tips"),
                        0x000, 0x000, 1.0F, 1.0F, 1.0F, 1.0F)
                        .setItemIcon(new ItemStack(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_2.get())))
                .setItemIconPosition(TexturedButtonWithText.IconPosition.CENTER)
                .setItemIconScale(1.2f);
        this.goldenButton = this.addRenderableWidget(new TexturedButtonWithText(left - 32, (top + 48) + (25 * 4), 35, 25, 0, 0, 25, BOTTON, 256, 256, button -> {
                    this.setCurrentTradeType(TradeType.GOLDEN);
                    this.sendTradeTypeUpdate(TradeType.GOLDEN);
                }, Component.translatable("button." + ChangShengJue.MOD_ID + ".golden_button.tips"),
                        0x000, 0x000, 1.0F, 1.0F, 1.0F, 1.0F)
                        .setItemIcon(new ItemStack(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_2.get())))
                .setItemIconPosition(TexturedButtonWithText.IconPosition.CENTER)
                .setItemIconScale(1.2f);
        this.goldenButton = this.addRenderableWidget(new TexturedButtonWithText(left - 32, (top + 48) + (25 * 5), 35, 25, 0, 0, 25, BOTTON, 256, 256, button -> {
                    this.setCurrentTradeType(TradeType.WOOD);
                    this.sendTradeTypeUpdate(TradeType.WOOD);
                }, Component.translatable("button." + ChangShengJue.MOD_ID + ".wood_button.tips"),
                        0x000, 0x000, 1.0F, 1.0F, 1.0F, 1.0F)
                        .setItemIcon(new ItemStack(ChangShengJueBlocks.OAK_BALUSTRADE.get())))
                .setItemIconPosition(TexturedButtonWithText.IconPosition.CENTER)
                .setItemIconScale(1.2f);
    }

    private void sendTradeTypeUpdate(TradeType tradeType) {
        if (this.minecraft != null && this.minecraft.player != null) {
            // 发送数据包到服务器
            ChangShengJueMessages.sendToServer(new KilnWorkerSetTradeTypePacket(tradeType));
        }
    }

    private void refreshTradeOffers() {
        MerchantOffers offers = this.menu.getOffers();
        if (offers != null) {
            this.shopItem = 0; // 重置选中项
            this.scrollOff = 0; // 重置滚动位置

            // 强制重新渲染
            for (TradeOfferButton button : this.tradeOfferButtons) {
                button.visible = false;
            }
        }
    }

    // 修改setCurrentTradeType方法
    public void setCurrentTradeType(TradeType currentTradeType) {
        this.currentTradeType = currentTradeType;
        this.refreshTradeOffers(); // 添加这行
    }

    @Override
    protected void renderLabels(GuiGraphics transform, int x, int y) {
//        int level = this.menu.getTraderLevel();
//        if (level > 0 && level <= 5 && this.menu.showProgressBar()) {
//            Component component = this.title.copy().append(LEVEL_SEPARATOR).append(Component.translatable("merchant.level." + level));
//            int fontWidth = this.font.width(component);
//            int k = 49 + this.imageWidth / 2 - fontWidth / 2;
//            transform.drawString(this.font, component, k, 6, 0x404040, false);
//        } else {
//            transform.drawString(this.font, this.title, 49 + this.imageWidth / 2 - this.font.width(this.title) / 2, 48, 0x404040, false);
//        }
        transform.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 0x404040, false);
        int l = this.font.width(TRADES_LABEL);
        transform.drawString(this.font, TRADES_LABEL, 5 - l / 2 + 48, 48, 0x404040, false);
    }

    @Override
    protected void renderBg(GuiGraphics transform, float partialTicks, int x, int y) {
        int left = (this.width - this.imageWidth) / 2;
        int top = (this.height - (this.imageHeight)) / 2;
        transform.blit(VILLAGER_LOCATION, left, top, 0, 0.0F, 0.0F, this.imageWidth, this.imageHeight, TEXTURE_WIDTH, TEXTURE_HEIGHT);
        MerchantOffers merchantoffers = this.menu.getOffers();
        if (!merchantoffers.isEmpty()) {
            int k = this.shopItem;
            if (k < 0 || k >= merchantoffers.size()) {
                return;
            }

            MerchantOffer merchantoffer = merchantoffers.get(k);
            if (merchantoffer.isOutOfStock()) {
                transform.blit(VILLAGER_LOCATION, this.leftPos + 83 + MERCHANT_MENU_PART_X, this.topPos + 35, 0, 311.0F, 0.0F, 28, 21, TEXTURE_WIDTH, TEXTURE_HEIGHT);
            }
        }
    }

    private void renderProgressBar(GuiGraphics transform, int x, int y) {
        int level = this.menu.getTraderLevel();
        int xp = this.menu.getTraderXp();
        if (level < 5) {
            transform.blit(VILLAGER_LOCATION, x + PROGRESS_BAR_X, y + PROGRESS_BAR_Y, 0, 0.0F, 186.0F, 102, 5, TEXTURE_WIDTH, TEXTURE_HEIGHT);
            int k = 15;
            if (xp >= k && level > 1) {
                float f = 100.0F / (float) (300 - k);
                int progress = Math.min(Mth.floor(f * (float) (xp - k)), 100);
                transform.blit(VILLAGER_LOCATION, x + PROGRESS_BAR_X, y + PROGRESS_BAR_Y, 0, 0.0F, 191.0F, progress + 1, 5, TEXTURE_WIDTH, TEXTURE_HEIGHT);
                int addXp = this.menu.getFutureTraderXp();
                if (addXp > 0) {
                    int addProgress = Math.min(Mth.floor((float) addXp * f), 100 - progress);
                    transform.blit(VILLAGER_LOCATION, x + PROGRESS_BAR_X + progress + 1, y + PROGRESS_BAR_Y + 1, 0, 2.0F, 182.0F, addProgress, 3, TEXTURE_WIDTH, TEXTURE_HEIGHT);
                }

            }
        }
    }

    private void renderScroller(GuiGraphics transform, int x, int y, MerchantOffers offers) {
        int overSize = offers.size() + 1 - NUMBER_OF_OFFER_BUTTONS;
        if (overSize > 1) {
            // 计算可滚动范围
            int scrollableRange = SCROLL_BAR_HEIGHT - SCROLLER_HEIGHT;

            // 计算滚动位置比例
            float scrollProgress = (float) this.scrollOff / (float) (overSize - 1);

            // 计算滚动条位置
            int scrollY = (int) (scrollProgress * scrollableRange);

            // 确保滚动条在有效范围内
            scrollY = Mth.clamp(scrollY, 0, scrollableRange);

            transform.blit(VILLAGER_LOCATION, x + SCROLL_BAR_START_X, y + SCROLL_BAR_TOP_POS_Y + scrollY,
                    0, 0.0F, 210.0F, SCROLLER_WIDTH, SCROLLER_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);
        } else {
            transform.blit(VILLAGER_LOCATION, x + SCROLL_BAR_START_X, y + SCROLL_BAR_TOP_POS_Y,
                    0, 6.0F, 210.0F, SCROLLER_WIDTH, SCROLLER_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);
        }
    }

    @Override
    public void render(GuiGraphics transform, int x, int y, float partialTicks) {
        this.renderBackground(transform);
        super.render(transform, x, y, partialTicks);
        MerchantOffers merchantoffers = this.menu.getOffers();
        if (!merchantoffers.isEmpty()) {
            int left = (this.width - this.imageWidth) / 2;
            int top = (this.height - this.imageHeight) / 2;
            int merchantY = top + PROGRESS_BAR_Y + 1;
            int costAX = left + TRADE_BUTTON_X + SELL_ITEM_1_X;
            this.renderScroller(transform, left, top, merchantoffers);
            int index = 0;

            for (MerchantOffer merchantoffer : merchantoffers) {
                if (!this.canScroll(merchantoffers.size()) || index >= this.scrollOff && index < 7 + this.scrollOff) {
                    ItemStack baseCostA = merchantoffer.getBaseCostA();
                    ItemStack costA = merchantoffer.getCostA();
                    ItemStack costB = merchantoffer.getCostB();
                    ItemStack result = merchantoffer.getResult();
                    transform.pose().pushPose();
                    transform.pose().translate(0.0F, 0.0F, 100.0F);
                    int itemY = merchantY + 2;
                    this.renderAndDecorateCostA(transform, costA, baseCostA, costAX, itemY);
                    if (!costB.isEmpty()) {
                        transform.renderFakeItem(costB, left + SELL_ITEM_1_X + SELL_ITEM_2_X, itemY);
                        transform.renderItemDecorations(this.font, costB, left + SELL_ITEM_1_X + SELL_ITEM_2_X, itemY);
                    }

                    this.renderButtonArrows(transform, merchantoffer, left, itemY);
                    transform.renderFakeItem(result, left + SELL_ITEM_1_X + BUY_ITEM_X, itemY);
                    transform.renderItemDecorations(this.font, result, left + SELL_ITEM_1_X + BUY_ITEM_X, itemY);
                    transform.pose().popPose();
                    merchantY += TRADE_BUTTON_HEIGHT;
                }
                ++index;
            }

            MerchantOffer currentOffer = merchantoffers.get(this.shopItem);
            if (this.menu.showProgressBar()) {
                this.renderProgressBar(transform, left, top);
            }

            if (currentOffer.isOutOfStock() && this.isHovering(186, 35, 22, 21, x, y) && this.menu.canRestock()) {
                transform.renderTooltip(this.font, DEPRECATED_TOOLTIP, x, y);
            }

            for (TradeOfferButton tradeOfferButton : this.tradeOfferButtons) {
                if (tradeOfferButton.isHoveredOrFocused()) {
                    tradeOfferButton.renderToolTip(transform, x, y);
                }

                tradeOfferButton.visible = tradeOfferButton.index < this.menu.getOffers().size();
            }

            RenderSystem.enableDepthTest();
        }

        this.renderTooltip(transform, x, y);
    }

    private void renderButtonArrows(GuiGraphics transform, MerchantOffer offer, int x, int y) {
        if (offer.isOutOfStock()) {
            transform.blit(VILLAGER_LOCATION, x + SELL_ITEM_1_X + SELL_ITEM_2_X + 20, y + 3, 0, 10.0F, 238.0F, 10, 9, TEXTURE_WIDTH, TEXTURE_HEIGHT);
        } else {
            transform.blit(VILLAGER_LOCATION, x + SELL_ITEM_1_X + SELL_ITEM_2_X + 20, y + 3, 0, 0.0F, 238.0F, 10, 9, TEXTURE_WIDTH, TEXTURE_HEIGHT);
        }
    }

    private void renderAndDecorateCostA(GuiGraphics transform, ItemStack baseCostA, ItemStack costA, int x, int y) {
        transform.renderFakeItem(baseCostA, x, y);
        if (costA.getCount() == baseCostA.getCount()) {
            transform.renderItemDecorations(this.font, baseCostA, x, y);
        } else {
            transform.renderItemDecorations(this.font, costA, x, y, costA.getCount() == 1 ? "1" : null);
            transform.pose().pushPose();
            transform.pose().translate(0.0F, 0.0F, 200.0F);
            String count = baseCostA.getCount() == 1 ? "1" : String.valueOf(baseCostA.getCount());
            this.font.drawInBatch(
                    count, (float) (x + 14) + 19.0F - 2.0F - (float) this.font.width(count),
                    (float) (y + LABEL_Y) + 3.0F, 0xFFFFFF, true,
                    transform.pose().last().pose(), transform.bufferSource(),
                    Font.DisplayMode.NORMAL, 0, 15728880, false
            );
            transform.pose().popPose();
            transform.pose().pushPose();
            transform.pose().translate(0.0F, 0.0F, 300.0F);
            transform.blit(VILLAGER_LOCATION, x + 7, y + 12, 0, 0.0F, 286.0F, 9, 2, 512, 512);
            transform.pose().popPose();
        }
    }

    private boolean canScroll(int size) {
        return size > NUMBER_OF_OFFER_BUTTONS;
    }

    @Override
    public boolean mouseScrolled(double x, double y, double delta) {
        int size = this.menu.getOffers().size();
        if (this.canScroll(size)) {
            int overSize = size - NUMBER_OF_OFFER_BUTTONS;
            this.scrollOff = Mth.clamp((int) (this.scrollOff - delta), 0, overSize);
        }
        return true;
    }

    @Override
    public boolean mouseDragged(double fromX, double fromY, int activeButton, double toX, double toY) {
        int size = this.menu.getOffers().size();
        if (this.isDragging) {
            int scrollTop = this.topPos + SCROLL_BAR_TOP_POS_Y;
            int overSize = size - NUMBER_OF_OFFER_BUTTONS;

            if (overSize > 0) {
                // 计算鼠标位置在滚动条区域内的相对位置
                float relativeY = (float) (fromY - scrollTop - SCROLLER_HEIGHT / 2.0);
                float scrollableHeight = SCROLL_BAR_HEIGHT - SCROLLER_HEIGHT;

                // 计算滚动比例
                float scrollProgress = Mth.clamp(relativeY / scrollableHeight, 0.0f, 1.0f);

                // 根据比例计算滚动偏移
                this.scrollOff = (int) (scrollProgress * overSize);
                this.scrollOff = Mth.clamp(this.scrollOff, 0, overSize);
            }

            return true;
        }
        return super.mouseDragged(fromX, fromY, activeButton, toX, toY);
    }

    @Override
    public boolean mouseClicked(double x, double y, int mouseButton) {
        this.isDragging = false;
        int left = (this.width - this.imageWidth) / 2;
        int top = (this.height - this.imageHeight) / 2;
        if (this.canScroll(this.menu.getOffers().size()) &&
                x > (double) (left + SCROLL_BAR_START_X) && x < (double) (left + SCROLL_BAR_START_X + SCROLLER_WIDTH) &&
                y > (double) (top + SCROLL_BAR_TOP_POS_Y) && y <= (double) (top + SCROLL_BAR_TOP_POS_Y + SCROLL_BAR_HEIGHT + 1)) {
            this.isDragging = true;
        }

        return super.mouseClicked(x, y, mouseButton);
    }

    @OnlyIn(Dist.CLIENT)
    class TradeOfferButton extends Button {
        final int index;

        public TradeOfferButton(int x, int y, int index, OnPress onPress) {
            super(x, y, TRADE_BUTTON_WIDTH, TRADE_BUTTON_HEIGHT, CommonComponents.EMPTY, onPress, DEFAULT_NARRATION);
            this.index = index;
            this.visible = false;
        }

        public int getIndex() {
            return this.index;
        }

        protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
            Minecraft minecraft = Minecraft.getInstance();
            pGuiGraphics.setColor(1.0F, 1.0F, 1.0F, this.alpha);
            RenderSystem.enableBlend();
            RenderSystem.enableDepthTest();
            pGuiGraphics.blitNineSliced(BOTTON, this.getX(), this.getY(), this.getWidth(), this.getHeight(), 20, 4, 200, 20, 0, this.getTextureY());
            pGuiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
            int i = this.getFGColor();
            this.renderString(pGuiGraphics, minecraft.font, i | Mth.ceil(this.alpha * 255.0F) << 24);
        }

        private int getTextureY() {
            int i = 1;
            if (!this.active) {
                i = 0;
            } else if (this.isHoveredOrFocused()) {
                i = 2;
            }

            return 46 + i * 20;
        }


        public void renderToolTip(GuiGraphics transform, int x, int y) {
            if (this.isHovered && KilnWorkerScreen.this.menu.getOffers().size() > this.index + KilnWorkerScreen.this.scrollOff) {
                if (x < this.getX() + 20) {
                    ItemStack itemstack = KilnWorkerScreen.this.menu.getOffers().get(this.index + KilnWorkerScreen.this.scrollOff).getCostA();
                    transform.renderTooltip(KilnWorkerScreen.this.font, itemstack, x, y);
                } else if (x < this.getX() + 50 && x > this.getX() + 30) {
                    ItemStack itemstack2 = KilnWorkerScreen.this.menu.getOffers().get(this.index + KilnWorkerScreen.this.scrollOff).getCostB();
                    if (!itemstack2.isEmpty()) {
                        transform.renderTooltip(KilnWorkerScreen.this.font, itemstack2, x, y);
                    }
                } else if (x > this.getX() + 65) {
                    ItemStack itemstack1 = KilnWorkerScreen.this.menu.getOffers().get(this.index + KilnWorkerScreen.this.scrollOff).getResult();
                    transform.renderTooltip(KilnWorkerScreen.this.font, itemstack1, x, y);
                }
            }
        }
    }

    public enum TradeType {
        GRE(Component.translatable("gui." + ChangShengJue.MOD_ID + ".trade.gre")),
        RED(Component.translatable("gui." + ChangShengJue.MOD_ID + ".trade.red")),
        BLACK(Component.translatable("gui." + ChangShengJue.MOD_ID + ".trade.black")),
        BLUE(Component.translatable("gui." + ChangShengJue.MOD_ID + ".trade.blue")),
        GOLDEN(Component.translatable("gui." + ChangShengJue.MOD_ID + ".trade.golden")),
        WOOD(Component.translatable("gui." + ChangShengJue.MOD_ID + ".trade.wood"));

        private final Component displayName;

        TradeType(Component displayName) {
            this.displayName = displayName;
        }

        public Component getDisplayName() {
            return displayName;
        }
    }
}
