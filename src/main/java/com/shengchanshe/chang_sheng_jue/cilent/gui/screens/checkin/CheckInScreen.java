package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.checkin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.checkin.CheckInRewardConfig;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.button.TexturedButtonWithText;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.custom.checkin.CheckInNPC;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.checkin.CheckInPacket;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Quaternionf;

/**
 * 签到界面
 */
@OnlyIn(Dist.CLIENT)
public class CheckInScreen extends AbstractContainerScreen<CheckInMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/container/checkin.png");

    private static final int TEXTURE_WIDTH = 256;
    private static final int TEXTURE_HEIGHT = 256;

    private TexturedButtonWithText checkInButton;

    private int rewardRotationTicks = 0;
    private static final int REWARD_ROTATION_INTERVAL = 120;

    private CheckInNPC npcEntity;

    public CheckInScreen(CheckInMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 192;
        this.imageHeight = 120;
        if (Minecraft.getInstance().level != null) {
            this.npcEntity = new CheckInNPC(ChangShengJueEntity.CHECKIN_NPC.get(), Minecraft.getInstance().level);
        }
    }

    @Override
    protected void init() {
        super.init();

        int left = (this.width - this.imageWidth) / 2;
        int top = (this.height - this.imageHeight) / 2;

        int buttonWidth = 40;
        int buttonHeight = 14;
        int buttonX = left + (this.imageWidth - buttonWidth) / 2;
        int buttonY = top + 95;

        this.checkInButton = this.addRenderableWidget(new TexturedButtonWithText(
                buttonX, buttonY, buttonWidth, buttonHeight,
                0, 202, 14,
                TEXTURE, 256, 256,
                this::handleCheckInButtonClick,
                Component.translatable("gui." + ChangShengJue.MOD_ID + ".checkin.button"),
                0x000000, 0x000000, 1.0F, false
        ));

        updateButtonState();
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight, TEXTURE_WIDTH, TEXTURE_HEIGHT);

        renderRewardBackgrounds(guiGraphics, x, y);

        RenderSystem.disableBlend();
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        var poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.scale(0.5F, 0.5F, 0.5F);

        Component bonusText = Component.translatable("gui." + ChangShengJue.MOD_ID + ".checkin.bonus_hint");
        int scaledTextWidth = font.width(bonusText);
        int bonusX = (imageWidth - scaledTextWidth / 2) / 2 * 2;
        int bonusY = 112 * 2;

        guiGraphics.drawString(font, bonusText, bonusX, bonusY, 0xFFFFFF, false);
        poseStack.popPose();

        if (menu.hasCheckedInToday()) {
            Component checkedInText = Component.translatable("gui." + ChangShengJue.MOD_ID + ".checkin.already_checked_in_hint");
            int textWidth = font.width(checkedInText);
            int textX = (imageWidth - textWidth) / 2;
            int textY = 95 + (14 - 9) / 2;
            guiGraphics.drawString(font, checkedInText, textX, textY, ChatFormatting.GRAY.getColor(), false);
        }

        renderTotalDaysDisplay(guiGraphics);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        var poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.scale(4.0F, 4.0F, 4.0F);

        Component titleText = Component.translatable("gui." + ChangShengJue.MOD_ID + ".checkin.title");
        int scaledTextWidth = font.width(titleText);
        int titleX = (x + (imageWidth - scaledTextWidth * 4) / 2) / 4;
        int titleY = (y + 6 - 50) / 4;

        guiGraphics.drawString(font, titleText, titleX, titleY, 0xFFFFFF, false);
        poseStack.popPose();

        renderNPCEntity(guiGraphics, x, y, partialTick);


        renderRewardLabels(guiGraphics, x, y);

        renderRewardItems(guiGraphics, x, y);

        renderTopOverlay(guiGraphics, x, y);

        renderRewardTooltips(guiGraphics, mouseX, mouseY, x, y);

        this.renderTooltip(guiGraphics, mouseX, mouseY);

        rewardRotationTicks++;
    }

    /**
     * 渲染云游道人NPC模型
     */
    private void renderNPCEntity(GuiGraphics guiGraphics, int x, int y, float partialTick) {
        if (npcEntity == null) {
            return;
        }

        int npcY = y + this.imageHeight / 2 + 40;

        Quaternionf rotation = new Quaternionf().rotateX((float) Math.PI).rotateY((float) Math.toRadians(45));

        InventoryScreen.renderEntityInInventory(guiGraphics, x, npcY, 40, rotation, null, npcEntity);
    }

    /**
     * 渲染累计签到天数显示
     */
    private void renderTotalDaysDisplay(GuiGraphics guiGraphics) {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, TEXTURE);

        int displayY = 114 + 9 + 10;

        int displayX = (imageWidth - 150) / 2;

        guiGraphics.blit(TEXTURE, displayX, displayY, 1, 124, 150, 30, TEXTURE_WIDTH, TEXTURE_HEIGHT);

        var poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.scale(0.8F, 0.8F, 0.8F);

        Component label = Component.translatable("gui." + ChangShengJue.MOD_ID + ".checkin.total_check_in");
        int labelWidth = font.width(label);
        int labelX = (int)((displayX + (43 - labelWidth * 0.8) / 2) / 0.8);
        int labelY = (int)((displayY + 6) / 0.8);
        guiGraphics.drawString(font, label, labelX, labelY, ChatFormatting.BLACK.getColor(), false);
        poseStack.popPose();

        Component daysText = Component.translatable("gui." + ChangShengJue.MOD_ID + ".checkin.days_count", menu.getTotalDays());
        int daysWidth = font.width(daysText);
        int daysX = displayX + (43 - daysWidth) / 2;
        guiGraphics.drawString(font, daysText, daysX, displayY + 17, ChatFormatting.BLACK.getColor(), false);

        renderTomorrowRewards(guiGraphics, displayX, displayY);
        RenderSystem.disableBlend();
    }

    /**
     * 渲染明日奖励预览
     */
    private void renderTomorrowRewards(GuiGraphics guiGraphics, int displayX, int displayY) {
        int rightX = displayX + 43;

        Component label = Component.translatable("gui." + ChangShengJue.MOD_ID + ".checkin.tomorrow_reward");

        var poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.scale(0.8F, 0.8F, 0.8F);

        int labelWidth = font.width(label);
        int labelX = (int)((rightX + (107 - labelWidth * 0.8) / 2) / 0.8);
        int labelY = (int)((displayY + 2) / 0.8);

        guiGraphics.drawString(font, label, labelX, labelY, ChatFormatting.BLACK.getColor(), false);
        poseStack.popPose();

        int currentIndex = menu.getCheckInData() != null ? menu.getCheckInData().getCurrentRewardIndex() : 0;
        int tomorrowIndex = (currentIndex + 1) % 7;
        int rewardPoolSize = CheckInRewardConfig.getRewardListSize(tomorrowIndex);
        int startIndex = (rewardRotationTicks / REWARD_ROTATION_INTERVAL) % rewardPoolSize;

        int itemsStartX = rightX + (107 - 56) / 2;

        for (int i = 0; i < 3; i++) {
            int rewardIndex = (startIndex + i) % rewardPoolSize;
            ItemStack rewardStack = CheckInRewardConfig.getRewardFromPool(tomorrowIndex, rewardIndex).getItemStack();

            int itemX = itemsStartX + i * 20;
            int itemY = displayY + 10;

            if (!rewardStack.isEmpty()) {
                guiGraphics.renderItem(rewardStack, itemX, itemY);
                guiGraphics.renderItemDecorations(font, rewardStack, itemX, itemY);
            }
        }
    }

    /**
     * 渲染奖励背景
     */
    private void renderRewardBackgrounds(GuiGraphics guiGraphics, int x, int y) {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, TEXTURE);

        int currentIndex = menu.getCheckInData() != null ? menu.getCheckInData().getCurrentRewardIndex() : 0;
        boolean hasCheckedInToday = menu.hasCheckedInToday();

        int[][] positions = {
                {30, 5},
                {66, 5},
                {102, 5},
                {30, 50},
                {66, 50},
                {102, 50},
                {138, 30}
        };

        int cyclePosition = currentIndex % 7;

        for (int i = 0; i < 7; i++) {
            int slotX = x + positions[i][0];
            int slotY = y + positions[i][1];

            guiGraphics.blit(TEXTURE, slotX, slotY, 1, 157, 32, 42, TEXTURE_WIDTH, TEXTURE_HEIGHT);

            if (i == cyclePosition && !hasCheckedInToday) {
                guiGraphics.blit(TEXTURE, slotX, slotY, 67, 157, 32, 42, TEXTURE_WIDTH, TEXTURE_HEIGHT);
            } else if (menu.getCheckInData() != null && menu.getCheckInData().hasReceivedReward(i)) {
                guiGraphics.blit(TEXTURE, slotX, slotY, 34, 157, 32, 42, TEXTURE_WIDTH, TEXTURE_HEIGHT);
            } else if (menu.getCheckInData() != null && menu.getCheckInData().hasMissedReward(i)) {
                guiGraphics.blit(TEXTURE, slotX, slotY, 34, 157, 32, 42, TEXTURE_WIDTH, TEXTURE_HEIGHT);
            }
        }

        int day7X = x + positions[6][0];
        int day7Y = y + positions[6][1];

        var poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.scale(0.5F, 0.5F, 0.5F);

        int decorX = (day7X + 32) * 2;
        int decorY = (day7Y + 35) * 2;
        guiGraphics.blit(TEXTURE, decorX, decorY, 127, 157, 28, 12, TEXTURE_WIDTH, TEXTURE_HEIGHT);

        poseStack.popPose();
        RenderSystem.disableBlend();
    }

    /**
     * 渲染奖励标签
     */
    private void renderRewardLabels(GuiGraphics guiGraphics, int x, int y) {
        int currentIndex = menu.getCheckInData() != null ? menu.getCheckInData().getCurrentRewardIndex() : 0;
        boolean hasCheckedInToday = menu.hasCheckedInToday();

        int[][] positions = {
                {30, 5},
                {66, 5},
                {102, 5},
                {30, 50},
                {66, 50},
                {102, 50},
                {138, 30}
        };

        for (int i = 0; i < 7; i++) {
            int slotX = x + positions[i][0];
            int slotY = y + positions[i][1];

            int cyclePosition = currentIndex % 7;

            Component dayLabel;
            if (i == cyclePosition && !hasCheckedInToday) {
                dayLabel = Component.translatable("gui." + ChangShengJue.MOD_ID + ".checkin.available");
            } else {
                dayLabel = Component.translatable("gui." + ChangShengJue.MOD_ID + ".checkin.day_" + (i + 1));
            }

            int textWidth = font.width(dayLabel);
            int textX = slotX + 1 + (32 - textWidth) / 2;
            int textY = slotY + 3;
            guiGraphics.drawString(font, dayLabel, textX, textY, ChatFormatting.BLACK.getColor(), false);
        }
    }

    /**
     * 渲染奖励物品
     */
    private void renderRewardItems(GuiGraphics guiGraphics, int x, int y) {
        int[][] positions = {
                {30, 5},
                {66, 5},
                {102, 5},
                {30, 50},
                {66, 50},
                {102, 50},
                {138, 30}
        };

        int currentIndex = menu.getCheckInData() != null ? menu.getCheckInData().getCurrentRewardIndex() : 0;
        boolean hasCheckedInToday = menu.hasCheckedInToday();

        int cyclePosition = currentIndex % 7;

        for (int i = 0; i < 7; i++) {
            int slotX = x + positions[i][0];
            int slotY = y + positions[i][1];

            ItemStack rewardStack = ItemStack.EMPTY;

            if (menu.getCheckInData() != null && menu.getCheckInData().hasReceivedReward(i)) {
                rewardStack = menu.getCheckInData().getReceivedReward(i);
            } else if (menu.getCheckInData() != null && menu.getCheckInData().hasMissedReward(i)) {
                rewardStack = CheckInRewardConfig.getReward(i).getItemStack();
            } else if (i == cyclePosition && !hasCheckedInToday) {
                rewardStack = menu.getTodayBaseReward();
            } else if (i > cyclePosition || (i == cyclePosition && hasCheckedInToday)) {
                int rewardPoolSize = CheckInRewardConfig.getRewardListSize(i);
                int rotationIndex = (rewardRotationTicks / REWARD_ROTATION_INTERVAL) % rewardPoolSize;
                int displayIndex = (rotationIndex) % rewardPoolSize;
                rewardStack = CheckInRewardConfig.getRewardFromPool(i, displayIndex).getItemStack();
            }

            if (!rewardStack.isEmpty()) {
                renderItemAt(guiGraphics, slotX + 8, slotY + 17, rewardStack);
            }
        }
    }

    /**
     * 渲染顶层叠加(遮挡物品) - 只有最上层会遮挡物品
     */
    private void renderTopOverlay(GuiGraphics guiGraphics, int x, int y) {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, TEXTURE);

        boolean hasCheckedInToday = menu.hasCheckedInToday();
        int currentIndex = menu.getCheckInData() != null ? menu.getCheckInData().getCurrentRewardIndex() : 0;

        int[][] positions = {
                {30, 5},
                {66, 5},
                {102, 5},
                {30, 50},
                {66, 50},
                {102, 50},
                {138, 30}
        };

        RenderSystem.disableDepthTest();

        for (int i = 0; i < 7; i++) {
            int slotX = x + positions[i][0];
            int slotY = y + positions[i][1];

            if (menu.getCheckInData() != null && menu.getCheckInData().hasReceivedReward(i)) {
                guiGraphics.blit(TEXTURE, slotX + 5, slotY + 11, 102, 157, 22, 19, TEXTURE_WIDTH, TEXTURE_HEIGHT);
            } else if (menu.getCheckInData() != null && menu.getCheckInData().hasMissedReward(i)) {
                guiGraphics.blit(TEXTURE, slotX + 8, slotY + 22, 101, 178, 16, 14, TEXTURE_WIDTH, TEXTURE_HEIGHT);
            }
        }

        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
    }

    private void renderItemAt(GuiGraphics guiGraphics, int x, int y, ItemStack stack) {
        guiGraphics.renderItem(stack, x, y);
        guiGraphics.renderItemDecorations(font, stack, x, y);
    }

    private void renderRewardTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y) {
        int[][] positions = {
                {30, 5},
                {66, 5},
                {102, 5},
                {30, 50},
                {66, 50},
                {102, 50},
                {138, 30}
        };

        int currentIndex = menu.getCheckInData() != null ? menu.getCheckInData().getCurrentRewardIndex() : 0;
        boolean hasCheckedInToday = menu.hasCheckedInToday();

        int cyclePosition = currentIndex % 7;

        for (int i = 0; i < 7; i++) {
            int slotX = x + positions[i][0] + 8;
            int slotY = y + positions[i][1] + 17;

            if (isMouseOverSlot(mouseX, mouseY, slotX, slotY, 16, 16)) {
                ItemStack rewardStack = ItemStack.EMPTY;

                if (menu.getCheckInData() != null && menu.getCheckInData().hasReceivedReward(i)) {
                    rewardStack = menu.getCheckInData().getReceivedReward(i);
                } else if (menu.getCheckInData() != null && menu.getCheckInData().hasMissedReward(i)) {
                    rewardStack = CheckInRewardConfig.getReward(i).getItemStack();
                } else if (i == cyclePosition && !hasCheckedInToday) {
                    rewardStack = menu.getTodayBaseReward();
                } else if (i > cyclePosition || (i == cyclePosition && hasCheckedInToday)) {
                    int rewardPoolSize = CheckInRewardConfig.getRewardListSize(i);
                    int rotationIndex = (rewardRotationTicks / REWARD_ROTATION_INTERVAL) % rewardPoolSize;
                    int displayIndex = (rotationIndex) % rewardPoolSize;
                    rewardStack = CheckInRewardConfig.getRewardFromPool(i, displayIndex).getItemStack();
                }

                if (!rewardStack.isEmpty()) {
                    guiGraphics.renderTooltip(font, rewardStack, mouseX, mouseY);
                }
                break;
            }
        }
    }

    private boolean isMouseOverSlot(int mouseX, int mouseY, int slotX, int slotY, int width, int height) {
        return mouseX >= slotX && mouseX <= slotX + width &&
                mouseY >= slotY && mouseY <= slotY + height;
    }

    private void handleCheckInButtonClick(Button button) {
        ChangShengJueMessages.sendToServer(new CheckInPacket());
    }

    /**
     * 更新按钮状态
     */
    private void updateButtonState() {
        if (checkInButton != null) {
            boolean hasChecked = menu.hasCheckedInToday();
            checkInButton.active = !hasChecked;
            checkInButton.visible = !hasChecked;
        }
    }

    /**
     * 刷新界面
     */
    public void refreshUI() {
        menu.refreshData();
        updateButtonState();
    }
}
