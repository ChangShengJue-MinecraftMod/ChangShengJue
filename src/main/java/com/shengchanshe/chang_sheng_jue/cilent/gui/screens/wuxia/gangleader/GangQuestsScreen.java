package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.button.TexturedButtonWithText;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.AcceptGangQuestsPacket;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.util.GuiEntityGraphics;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class GangQuestsScreen extends AbstractContainerScreen<GangQuestsMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/container/gang_quests.png");
    private static final ResourceLocation BOTTON = new ResourceLocation(ChangShengJue.MOD_ID,"textures/gui/botton.png");
    private static final int TEXTURE_WIDTH = 512;
    private static final int TEXTURE_HEIGHT = 512;

    private static final int PROGRESS_BAR_Y = 180;

    private static final int SLOT_SIZE = 18;

    private static final int REQ_SLOTS_X = 28;
    private static final int REQ_SLOTS_Y = 150;
    private static final int REWARD_SLOTS_X = 28;
    private static final int REWARD_SLOTS_Y = 170;

    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 20;
    private static final int BUTTON_SPACING = 8;

    private static final int PAGE_BUTTON_WIDTH = 10;
    private static final int PAGE_BUTTON_HEIGHT = 11;

    private TexturedButtonWithText actionButton;
    private TexturedButtonWithText onPageButton;
    private TexturedButtonWithText nextPageButton;

    private static final int HEAD_SIZE = 9;
    private static final int MAX_VISIBLE_HEADS = 5;

    private static final Map<EntityType<?>, Entity> ENTITY_CACHE = new HashMap<>();

    public GangQuestsScreen(GangQuestsMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 270;
        this.imageHeight = 209;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight,TEXTURE_WIDTH,TEXTURE_HEIGHT);

        String pageInfo = String.format("%d/%d", menu.getCurrentPage() + 1, menu.getTotalPages());
        guiGraphics.drawString(font, pageInfo, x + imageWidth - 25, y + 50, 0xFFFFFF, false);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        Quest currentQuest = menu.getCurrentQuest();
        if (currentQuest == null) return;

        guiGraphics.drawString(font, currentQuest.getQuestName(),
                (imageWidth - font.width(currentQuest.getQuestName())) / 2, 67, 0x404040, false);

        var lines = font.split(Component.translatable(currentQuest.getQuestDescription()), imageWidth - 50);
        for (int i = 0; i < lines.size(); i++) {
            guiGraphics.drawString(font, lines.get(i), 28, 101 + i * font.lineHeight, 0x404040, false);
        }

        var lines1 = font.split(Component.translatable(currentQuest.getQuestRequirementsDescription()), imageWidth - 50);
        for (int i = 0; i < lines1.size(); i++) {
            guiGraphics.drawString(font, lines1.get(i), currentQuest.getTargetEntity().isEmpty() ? 28 + 40 : 28 + 60,
                    (150 - 9) + i * font.lineHeight, ChatFormatting.RED.getColor(), false);
        }

        guiGraphics.drawString(font, Component.translatable("quest."+ ChangShengJue.MOD_ID +".requirements"), 28, 150 - 9, ChatFormatting.RED.getColor(), false);
        guiGraphics.drawString(font, Component.translatable("quest."+ ChangShengJue.MOD_ID +".rewards"), 28, 170 - 9, ChatFormatting.YELLOW.getColor(), false);
    }


    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        Quest currentQuest = getCurrentQuest();
        if (currentQuest == null) return;

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        // 根据任务类型决定渲染内容
        if (currentQuest.getQuestType() == Quest.QuestType.KILL) {
            // 渲染击杀任务的目标生物
            GuiEntityGraphics.getInstance(font, HEAD_SIZE, MAX_VISIBLE_HEADS, ENTITY_CACHE).renderKillTargetHead(guiGraphics, x + REQ_SLOTS_X + 40, y + REQ_SLOTS_Y - 3, currentQuest);
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

    private Quest getCurrentQuest() {
        if (menu.getAllAvailableQuests().isEmpty()) {
            return menu.getCurrentQuest();
        }
        if (menu.getCurrentPage() >= 0 && menu.getCurrentPage() < menu.getAllAvailableQuests().size()) {
            return menu.getAllAvailableQuests().get(menu.getCurrentPage());
        }
        return null;
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
    // 击杀目标特殊提示
    private void renderKillTargetTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY, Quest quest) {
        List<Component> tooltip = List.of(
                Component.translatable("quest."+ ChangShengJue.MOD_ID +".requires.kill.target", quest.getRequiredKills()),
                Component.translatable("quest."+ ChangShengJue.MOD_ID +".current.kill.target", quest.getCurrentKills(), quest.getRequiredKills())
                        .withStyle(ChatFormatting.YELLOW)
        );
        guiGraphics.renderTooltip(font, tooltip, Optional.empty(), mouseX, mouseY);
    }

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
        int buttonX = left + (this.imageWidth - BUTTON_WIDTH) / 2;
        this.actionButton = this.addRenderableWidget(new TexturedButtonWithText(
                buttonX, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT,
                0, 66, 20,
                BOTTON,
                256, 256,
                this::handleActionButtonClick,
                Component.translatable("quest."+ ChangShengJue.MOD_ID + ".accept.button"),0xFFFFFF,0xFFFFFF,1.0F,true
        ));

        int pageButtonY = top + 65;
        int pageButtonX = left + (this.imageWidth - PAGE_BUTTON_WIDTH) / 2;
        this.onPageButton = this.addRenderableWidget(new TexturedButtonWithText(
                pageButtonX - 70, pageButtonY, PAGE_BUTTON_WIDTH, PAGE_BUTTON_HEIGHT,
                14, 211, 11,
                TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT,
                button -> menu.previousPage(),
                CommonComponents.EMPTY,0xFFFFFF,0xFFFFFF,1.0F,1.5F,1.5F,1.6F
        ));

        this.nextPageButton = this.addRenderableWidget(new TexturedButtonWithText(
                pageButtonX + 72, pageButtonY, PAGE_BUTTON_WIDTH, PAGE_BUTTON_HEIGHT,
                0, 211, 11,
                TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT,
                button -> menu.nextPage(),
                CommonComponents.EMPTY,0xFFFFFF,0xFFFFFF,1.0F,1.5F,1.5F,1.6F
        ));
    }
    // 处理接受按钮点击
    private void handleActionButtonClick(Button button) {
        ChangShengJueMessages.sendToServer(new AcceptGangQuestsPacket(menu.getCurrentQuest().getQuestId()));
    }

    public void refreshUI() {
        this.clearWidgets();
        this.renderables.clear();
        this.init();
        this.repositionElements();
    }

    public void forceRefresh(List<Quest> newQuests) {
        menu.updateAvailableQuests(newQuests);
        refreshUI();
    }
}