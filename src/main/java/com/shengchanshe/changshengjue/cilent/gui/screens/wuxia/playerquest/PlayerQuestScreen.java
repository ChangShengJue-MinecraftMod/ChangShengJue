package com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.playerquest;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.gui.playerquest.AbandonPlayerQuestPacket;
import com.shengchanshe.changshengjue.network.packet.gui.playerquest.RequestQuestsPacket;
import com.shengchanshe.changshengjue.network.packet.gui.playerquest.SubmitPlayerQuestsPacket;
import com.shengchanshe.changshengjue.network.packet.gui.quest.AbandonGangQuestPacket;
import com.shengchanshe.changshengjue.quest.Quest;
import com.shengchanshe.changshengjue.util.GuiEntityGraphics;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

import java.util.*;

public class PlayerQuestScreen extends AbstractContainerScreen<PlayerQuestMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/container/player_quests.png");
    private static final int TEXTURE_WIDTH = 256;
    private static final int TEXTURE_HEIGHT = 256;

    private static final int SLOT_SIZE = 18;

    private static final int REQ_SLOTS_X = 18;
    private static final int REQ_SLOTS_Y = 79;

    private static final int REWARD_SLOTS_Y = 99;

    private static final int BUTTON_WIDTH = 51;
    private static final int BUTTON_HEIGHT = 17;
    private static final int BUTTON_SPACING = 50;

    private static final int ARROW_BUTTON_WIDTH = 7;
    private static final int ARROW_BUTTON_HEIGHT = 11;
    private static final int ARROW_BUTTON_SPACING = 78;

    private static final int HEAD_SIZE = 9; // 每个头像的大小
    private static final int MAX_VISIBLE_HEADS = 5; // 最多显示的头像数量
    private static final Map<EntityType<?>, Entity> ENTITY_CACHE = new HashMap<>();

    private TexturedButtonWithLabel peviousButton;
    private TexturedButtonWithLabel nextButton;

    private TexturedButtonWithLabel actionButton;
    private TexturedButtonWithLabel cancelButton;

    public PlayerQuestScreen(PlayerQuestMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        if (minecraft != null && minecraft.level.isClientSide) {
            ChangShengJueMessages.sendToServer(new RequestQuestsPacket());
        }
        this.imageWidth = 175;
        this.imageHeight = 165;
    }

    @Override
    protected void init() {
        super.init();
        int left = (this.width - this.imageWidth) / 2;
        int top = (this.height - this.imageHeight) / 2;
        // 动态按钮位置计算
        int arrowButtonY = top + SLOT_SIZE - 5;
        int arrowButtonX = left + (this.imageWidth - (ARROW_BUTTON_WIDTH * 2 + ARROW_BUTTON_SPACING)) / 2;
        int buttonY = top + REWARD_SLOTS_Y + 15;
        int buttonX = left + (this.imageWidth - (BUTTON_WIDTH * 2 + BUTTON_SPACING)) / 2;
        // 上一页按钮
        peviousButton = this.addRenderableWidget(new TexturedButtonWithLabel(
                arrowButtonX, arrowButtonY,
                ARROW_BUTTON_WIDTH, ARROW_BUTTON_HEIGHT,
                68, 170, 17,
                TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT,
                (button) -> {
                    this.menu.prevPage();

                },
                Component.translatable("")
        ));

        nextButton = this.addRenderableWidget(new TexturedButtonWithLabel(
                arrowButtonX + ARROW_BUTTON_WIDTH + ARROW_BUTTON_SPACING, arrowButtonY, ARROW_BUTTON_WIDTH, ARROW_BUTTON_HEIGHT,
                55, 170, 17, TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT,
                (button) -> {
                    this.menu.nextPage();
                },
                Component.translatable("")
        ));

        actionButton = this.addRenderableWidget(new TexturedButtonWithLabel(
                buttonX, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT,
                0, 167, 17, TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT,
                (button) -> {
                    ChangShengJueMessages.sendToServer(new SubmitPlayerQuestsPacket(this.getMenu().getCurrentPage()));
                },
                Component.translatable("quest."+ ChangShengJue.MOD_ID +".submit.button")
        ));

        cancelButton = this.addRenderableWidget(new TexturedButtonWithLabel(
                buttonX + BUTTON_WIDTH + BUTTON_SPACING, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT,
                0, 167, 17, TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT,
                (button) -> {
                    ChangShengJueMessages.sendToServer(new AbandonPlayerQuestPacket(this.getMenu().getCurrentPage()));
                },
                Component.translatable("quest."+ ChangShengJue.MOD_ID +".abandon.button")
        ));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        menu.getCurrentQuest(this.getMenu().getCurrentPage()).ifPresent(quest -> {
            // 渲染需求物品
            var reqs = quest.getQuestRequirements();
            for (int i = 0; i < Math.min(3, reqs.size()); i++) {
                ItemStack stack = reqs.get(i);
                renderItemAt(guiGraphics, x + REQ_SLOTS_X + 40 + i * SLOT_SIZE, y + REQ_SLOTS_Y - 10, stack);
            }
            var rewards = quest.getQuestRewards();
            for (int i = 0; i < Math.min(6, rewards.size()); i++) {
                ItemStack stack = rewards.get(i);
                renderItemAt(guiGraphics, x + REQ_SLOTS_X + 40 + i * SLOT_SIZE, y + REWARD_SLOTS_Y - 7, stack);
            }
            if (!quest.getTargetEntity().isEmpty()){
                GuiEntityGraphics.getInstance(font, HEAD_SIZE, MAX_VISIBLE_HEADS, ENTITY_CACHE)
                        .renderKillTargetHead(guiGraphics,x + REQ_SLOTS_X + 40, y + REQ_SLOTS_Y, quest);
            }
            this.renderTooltips(guiGraphics, mouseX, mouseY, x, y, quest);
        });
    }

    private void renderItemAt(GuiGraphics guiGraphics, int x, int y, ItemStack stack) {
        guiGraphics.renderItem(stack, x, y);
        guiGraphics.renderItemDecorations(font, stack, x, y);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight,TEXTURE_WIDTH,TEXTURE_HEIGHT);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        // 渲染当前任务
        menu.getCurrentQuest(this.getMenu().getCurrentPage()).ifPresent(quest -> {
            // 任务标题
            guiGraphics.drawString(font,  Component.translatable(quest.getQuestName()),
                    (this.imageWidth - font.width(Component.translatable(quest.getQuestName()))) / 2, 14, 0x404040, false);
            // 任务描述
            var lines = font.split(Component.translatable(quest.getQuestDescription()), imageWidth - 50);
            for (int i = 0; i < lines.size(); i++) {
                int descX = i == 0 ? 20 + 17 : 20;
                guiGraphics.drawString(font, lines.get(i), descX,35 + i * font.lineHeight,0x404040,false);
            }

            var lines1 = font.split(Component.translatable(quest.getQuestRequirementsDescription()), imageWidth - 50);
            for (int i = 0; i < lines1.size(); i++) {
                guiGraphics.drawString(font, lines1.get(i), !quest.getTargetEntity().isEmpty() ? REQ_SLOTS_X + 60 : REQ_SLOTS_X + 40,
                        73 + i * font.lineHeight, ChatFormatting.RED.getColor(), false);
            }
        });
        guiGraphics.drawString(font, Component.translatable("quest."+ ChangShengJue.MOD_ID +".requirements"), REQ_SLOTS_X, REQ_SLOTS_Y - 6, ChatFormatting.RED.getColor(), false);
        guiGraphics.drawString(font, Component.translatable("quest."+ ChangShengJue.MOD_ID +".rewards"), REQ_SLOTS_X, REWARD_SLOTS_Y - 3, ChatFormatting.YELLOW.getColor(), false);
    }

    private void renderTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y, Quest quest) {
        // 检查需求物品提示
        List<ItemStack> reqs = quest.getQuestRequirements();
        for (int i = 0; i < Math.min(3, reqs.size()); i++) {
            if (isMouseOverSlot(mouseX, mouseY,
                    x + REQ_SLOTS_X + 40 + i * SLOT_SIZE, y + REQ_SLOTS_Y - 10,
                    SLOT_SIZE, SLOT_SIZE)) {

                guiGraphics.renderTooltip(font, reqs.get(i), mouseX, mouseY);
                return;
            }
        }
        // 检查奖励物品提示
        List<ItemStack> rewards = quest.getQuestRewards();
        for (int i = 0; i < Math.min(3, rewards.size()); i++) {
            if (isMouseOverSlot(mouseX, mouseY,
                    x + REQ_SLOTS_X + 40 + i * SLOT_SIZE, y + REWARD_SLOTS_Y - 7,
                    SLOT_SIZE, SLOT_SIZE)) {

                guiGraphics.renderTooltip(font, rewards.get(i), mouseX, mouseY);
                return;
            }
        }
        // 击杀任务目标提示
        if (quest.getQuestType() == Quest.QuestType.KILL &&
                isMouseOverSlot(mouseX, mouseY,
                        x + REQ_SLOTS_X + 40, y + REQ_SLOTS_Y - 9, HEAD_SIZE, HEAD_SIZE)) {
            renderKillTargetTooltip(guiGraphics, mouseX, mouseY, quest);
        }
    }
    // 击杀目标特殊提示
    private void renderKillTargetTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY, Quest quest) {
        List<Component> tooltip = List.of(
                Component.literal("需要击杀: " + quest.getRequiredKills() + "次"),
                Component.literal("当前进度: " + quest.getCurrentKills() + "/" + quest.getRequiredKills()).withStyle(ChatFormatting.YELLOW)
        );
        guiGraphics.renderTooltip(font, tooltip, Optional.empty(), mouseX, mouseY);
    }

    private boolean isMouseOverSlot(int mouseX, int mouseY, int slotX, int slotY, int width, int height) {
        return mouseX >= slotX && mouseX <= slotX + width &&
                mouseY >= slotY && mouseY <= slotY + height;
    }

    public void refreshUI(UUID uuid) {
        // 彻底清理旧组件
        this.clearWidgets();
        this.renderables.clear(); // 确保所有UI元素被移除
        this.menu.removedCurrentQuest(uuid);

        // 重新初始化
        this.init();

        // 强制布局更新
        this.repositionElements();
    }

    public static class TexturedButtonWithLabel extends ImageButton {
        private Component label;

        public TexturedButtonWithLabel(int x, int y, int width, int height,
                                       int texX, int texY, int yDiffText,
                                       ResourceLocation resource, int texWidth, int texHeight,
                                       OnPress onPress, Component label) {
            super(x, y, width, height, texX, texY, yDiffText, resource, texWidth, texHeight, onPress);
            this.label = label;
        }

        @Override
        public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            super.renderWidget(guiGraphics, mouseX, mouseY, partialTick);

            Font font = Minecraft.getInstance().font;
            int textWidth = font.width(label);
            int textX = this.getX() + (this.width - textWidth) / 2;
            int textY = this.getY() + (this.height - 8) / 2; // +1微调垂直位置

            // 添加文字阴影
            guiGraphics.drawString(
                    font,
                    label,
                    textX,
                    textY,
                    this.active ? 0xFFFFFF : 0xA0A0A0,
                    true
            );
        }
    }
}
