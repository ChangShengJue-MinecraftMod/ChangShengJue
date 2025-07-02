package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest.RequestQuestsPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.RefreshGangQuestPacket;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.AbandonGangQuestPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.AcceptGangQuestsPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.SubmitGangQuestsPacket;
import com.shengchanshe.chang_sheng_jue.util.GuiEntityGraphics;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.*;

@OnlyIn(Dist.CLIENT)
public class GangQuestsScreen extends AbstractContainerScreen<GangQuestsMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/container/gang_quests.png");
    private static final int TEXTURE_WIDTH = 512;
    private static final int TEXTURE_HEIGHT = 512;

    private static final int PROGRESS_BAR_Y = 180;

    private static final int SLOT_SIZE = 18;

    private static final int REQ_SLOTS_X = 28;
    private static final int REQ_SLOTS_Y = 150;
    private static final int REWARD_SLOTS_X = 28;
    private static final int REWARD_SLOTS_Y = 170;

    private static final int BUTTON_WIDTH = 88;
    private static final int BUTTON_HEIGHT = 20;
    private static final int BUTTON_SPACING = 8;

    private TexturedButtonWithLabel actionButton; // 将按钮提取为成员变量
    private TexturedButtonWithLabel cancelButton;

    private static final int HEAD_SIZE = 9; // 每个头像的大小
    private static final int MAX_VISIBLE_HEADS = 5; // 最多显示的头像数量
    // 缓存已创建的实体实例
    private static final Map<EntityType<?>, Entity> ENTITY_CACHE = new HashMap<>();

    public GangQuestsScreen(GangQuestsMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 277;
        this.imageHeight = 210;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight,TEXTURE_WIDTH,TEXTURE_HEIGHT);
        if (minecraft != null && minecraft.level.isClientSide) {
            ChangShengJueMessages.sendToServer(new RequestQuestsPacket());
        }
//        // 渲染槽位背景
//        for (int i = 0; i < 3; i++) {
//            guiGraphics.blit(TEXTURE, x + REQ_SLOTS_X + i * SLOT_SIZE, y + REQ_SLOTS_Y,
//                    176, 0, SLOT_SIZE, SLOT_SIZE);
//            guiGraphics.blit(TEXTURE, x + REWARD_SLOTS_X + i * SLOT_SIZE, y + REWARD_SLOTS_Y,
//                    176, 0, SLOT_SIZE, SLOT_SIZE);
//        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(font, menu.getGangQuests().getQuestName(),
                (imageWidth - font.width(menu.getGangQuests().getQuestName())) / 2, 67, 0x404040, false);

        var lines = font.split(Component.translatable(menu.getGangQuests().getQuestDescription()), imageWidth - 50);
        for (int i = 0; i < lines.size(); i++) {
            guiGraphics.drawString(font, lines.get(i), 28, 101 + i * font.lineHeight, 0x404040, false);
        }

//        if (menu.getGangQuests().getQuestType() == Quest.QuestType.KILL) {
            var lines1 = font.split(Component.translatable(menu.getGangQuests().getQuestRequirementsDescription()), imageWidth - 50);
            for (int i = 0; i < lines1.size(); i++) {
                guiGraphics.drawString(font, lines1.get(i), menu.getGangQuests().getTargetEntity().isEmpty() ? REQ_SLOTS_X + 40 : REQ_SLOTS_X + 60,
                        (REQ_SLOTS_Y - 9) + i * font.lineHeight, ChatFormatting.RED.getColor(), false);
            }
//        }


        guiGraphics.drawString(font, Component.translatable("quest."+ ChangShengJue.MOD_ID +".requirements"), REQ_SLOTS_X, REQ_SLOTS_Y - 9, ChatFormatting.RED.getColor(), false);
        guiGraphics.drawString(font, Component.translatable("quest."+ ChangShengJue.MOD_ID +".rewards"), REWARD_SLOTS_X, REWARD_SLOTS_Y - 9, ChatFormatting.YELLOW.getColor(), false);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        Quest currentQuest = menu.getGangQuests();

        // 根据任务类型决定渲染内容
        if (currentQuest.getQuestType() == Quest.QuestType.KILL) {
            // 渲染击杀任务的目标生物
            GuiEntityGraphics.getInstance(font,HEAD_SIZE,MAX_VISIBLE_HEADS,ENTITY_CACHE).renderKillTargetHead(guiGraphics,x + REQ_SLOTS_X + 40, y + REQ_SLOTS_Y - 3, currentQuest);
        } else if (currentQuest.getQuestType() == Quest.QuestType.GATHER) {
            // 渲染需求物品
            var reqs = currentQuest.getQuestRequirements();
            for (int i = 0; i < Math.min(3, reqs.size()); i++) {
                ItemStack stack = reqs.get(i);
                renderItemAt(guiGraphics, x + REQ_SLOTS_X + 40 + i * SLOT_SIZE, y + REQ_SLOTS_Y - 13, stack);
            }
        }

        // 渲染奖励物品
        var rewards = currentQuest.getQuestRewards();
        for (int i = 0; i < Math.min(3, rewards.size()); i++) {
            ItemStack stack = rewards.get(i);
            renderItemAt(guiGraphics, x + REWARD_SLOTS_X + 40 + i * SLOT_SIZE, y + REWARD_SLOTS_Y - 13, stack);
        }

        this.renderTooltips(guiGraphics, mouseX, mouseY, x, y, currentQuest);
    }

    private void renderTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y, Quest quest) {
        // 检查需求物品提示
        List<ItemStack> reqs = quest.getQuestRequirements();
        for (int i = 0; i < Math.min(3, reqs.size()); i++) {
            if (isMouseOverSlot(mouseX, mouseY,
                    x + REQ_SLOTS_X + 40 + i * SLOT_SIZE,
                    y + REQ_SLOTS_Y - 13,
                    SLOT_SIZE, SLOT_SIZE)) {

                guiGraphics.renderTooltip(font, reqs.get(i), mouseX, mouseY);
                return;
            }
        }
        // 检查奖励物品提示
        List<ItemStack> rewards = quest.getQuestRewards();
        for (int i = 0; i < Math.min(3, rewards.size()); i++) {
            if (isMouseOverSlot(mouseX, mouseY,
                    x + REWARD_SLOTS_X + 40 + i * SLOT_SIZE,
                    y + REWARD_SLOTS_Y - 13,
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
//     击杀目标特殊提示
    private void renderKillTargetTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY, Quest quest) {
//        String targetName = getEntityName(quest.getTargetEntity(), quest.isEntityTag());
        List<Component> tooltip = List.of(
//                Component.literal("目标: " + targetName),
                Component.literal("需要击杀: " + quest.getRequiredKills() + "次"),
                Component.literal("当前进度: " + quest.getCurrentKills() + "/" + quest.getRequiredKills())
                        .withStyle(ChatFormatting.YELLOW)
        );
        guiGraphics.renderTooltip(font, tooltip, Optional.empty(), mouseX, mouseY);
    }
//    // 获取实体显示名称
//    private String getEntityName(String targetId, boolean isTag) {
//        if (isTag) {
//            return "#" + targetId.substring(1);
//        }
//        EntityType<?> type = ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(targetId));
//        return type != null ? type.getDescription().getString() : targetId;
//    }


    private boolean isMouseOverSlot(int mouseX, int mouseY, int slotX, int slotY, int width, int height) {
        return mouseX >= slotX && mouseX <= slotX + width &&
                mouseY >= slotY && mouseY <= slotY + height;
    }

    private void renderItemAt(GuiGraphics guiGraphics, int x, int y, ItemStack stack) {
        guiGraphics.renderItem(stack, x, y);
        guiGraphics.renderItemDecorations(font, stack, x, y);
    }

    @Override
    protected void init() {
        super.init();

        int left = (this.width - this.imageWidth) / 2;
        int top = (this.height - this.imageHeight) / 2;

        // 动态按钮位置计算
        int buttonY = top + PROGRESS_BAR_Y + 2;
        int buttonX = left + (this.imageWidth - (BUTTON_WIDTH * 2 + BUTTON_SPACING)) / 2;

        // 主操作按钮
        this.actionButton = this.addRenderableWidget(new TexturedButtonWithLabel(
                buttonX, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT,
                0, 211, 20, TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT,
                this::handleActionButtonClick,
                getActionButtonText()
        ));
        // 取消/放弃按钮
        this.cancelButton = this.addRenderableWidget(new TexturedButtonWithLabel(
                buttonX + BUTTON_WIDTH + BUTTON_SPACING, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT,
                0, 211, 20, TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT,
                this::handleCancelButtonClick,
                getCancelButtonText()
        ));

        this.updateButtonStates();
    }

    // 动态获取按钮文本
    private Component getActionButtonText() {
        return Component.translatable(menu.getGangQuests().getAcceptedBy() != null ? "quest."+ ChangShengJue.MOD_ID + ".submit.button"
                : "quest."+ ChangShengJue.MOD_ID + ".accept.button");
    }

    private Component getCancelButtonText() {
        return Component.translatable(menu.getGangQuests().getAcceptedBy() != null ? "quest."+ ChangShengJue.MOD_ID + ".abandon.button" :
                "quest."+ ChangShengJue.MOD_ID + ".flushed.button");
    }
    // 更新按钮状态
    private void updateButtonStates() {
        actionButton.setMessage(getActionButtonText());
        cancelButton.setMessage(getCancelButtonText());
    }
    // 处理提交和接受按钮点击
    private void handleActionButtonClick(Button button) {
        if (menu.getGangQuests().getAcceptedBy() != null) {
            ChangShengJueMessages.sendToServer(new SubmitGangQuestsPacket());
        } else {
            ChangShengJueMessages.sendToServer(new AcceptGangQuestsPacket());
        }
    }

    //处理放弃和刷新按钮点击
    private void handleCancelButtonClick(Button button) {
        if (menu.getGangQuests().getAcceptedBy() != null) {
            ChangShengJueMessages.sendToServer(new AbandonGangQuestPacket());
        } else {
            ChangShengJueMessages.sendToServer(new RefreshGangQuestPacket());
        }
    }

    public void refreshUI() {
        // 彻底清理旧组件
        this.clearWidgets();
        this.renderables.clear(); // 确保所有UI元素被移除

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