package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest.AbandonPlayerQuestPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest.SubmitPlayerQuestsPacket;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.util.GuiEntityGraphics;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class PlayerQuestScreen extends AbstractContainerScreen<PlayerQuestMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/container/player_quests.png");
    private static final int TEXTURE_WIDTH = 256;
    private static final int TEXTURE_HEIGHT = 256;

    private static final int SLOT_SIZE = 18;

    private static final int REQ_SLOTS_X = 18;
    private static final int REQ_SLOTS_Y = 95;

    private static final int REWARD_SLOTS_Y = 99;

    private static final int BUTTON_WIDTH = 89;
    private static final int BUTTON_HEIGHT = 17;
    private static final int BUTTON_SPACING = 50;

    private static final int ARROW_BUTTON_WIDTH = 7;
    private static final int ARROW_BUTTON_HEIGHT = 11;
    private static final int ARROW_BUTTON_SPACING = 78;

    private static final int HEAD_SIZE = 9; // 每个头像的大小
    private static final int MAX_VISIBLE_HEADS = 5; // 最多显示的头像数量
    private static final Map<EntityType<?>, Entity> ENTITY_CACHE = new HashMap<>();

    private int scrollTick = 0;

    private TexturedButtonWithLabel peviousButton;
    private TexturedButtonWithLabel nextButton;

    private TexturedButtonWithLabel actionButton;
    private TexturedButtonWithLabel cancelButton;

    public PlayerQuestScreen(PlayerQuestMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 255;
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
        int buttonY = top + REWARD_SLOTS_Y + 31;
        int buttonX = left + (this.imageWidth - (BUTTON_WIDTH * 2 + BUTTON_SPACING)) / 2;
        // 上一页按钮
        peviousButton = this.addRenderableWidget(new TexturedButtonWithLabel(
                arrowButtonX - ARROW_BUTTON_SPACING + 15, arrowButtonY,
                ARROW_BUTTON_WIDTH, ARROW_BUTTON_HEIGHT,
                7, 202, 11,
                TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT,
                (button) -> this.menu.prevPage(),
                Component.empty()
        ));

        nextButton = this.addRenderableWidget(new TexturedButtonWithLabel(
                arrowButtonX + ARROW_BUTTON_WIDTH + (ARROW_BUTTON_SPACING * 2) - 15, arrowButtonY,
                ARROW_BUTTON_WIDTH, ARROW_BUTTON_HEIGHT,
                0, 202, 11,
                TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT,
                (button) -> this.menu.nextPage(),
                Component.empty()
        ));

        actionButton = this.addRenderableWidget(new TexturedButtonWithLabel(
                buttonX, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT,
                0, 167, 17, TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT,
                (button) -> {
                    this.getMenu().getCurrentQuest(this.getMenu().getCurrentPage()).ifPresentOrElse(
                            quest -> {
                                ChangShengJueMessages.sendToServer(
                                        new SubmitPlayerQuestsPacket(quest.getQuestId(), this.getMenu().getCurrentPage()));
                            },
                            () -> {
                                // 处理空任务情况
                                if (Minecraft.getInstance().player != null) {
                                    Minecraft.getInstance().player.displayClientMessage(
                                            Component.translatable("quest."+ ChangShengJue.MOD_ID +".no_submit.button"), false);
                                }
                            }
                    );
                },
                Component.translatable("quest."+ ChangShengJue.MOD_ID +".submit.button")
        ));

        cancelButton = this.addRenderableWidget(new TexturedButtonWithLabel(
                buttonX + BUTTON_WIDTH + BUTTON_SPACING, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT,
                0, 167, 17, TEXTURE, TEXTURE_WIDTH, TEXTURE_HEIGHT,
                (button) -> {
                    this.getMenu().getCurrentQuest(this.getMenu().getCurrentPage()).ifPresentOrElse(
                            quest -> {
                                ChangShengJueMessages.sendToServer(
                                        new AbandonPlayerQuestPacket(quest.getQuestId(), this.getMenu().getCurrentPage()));
                            },
                            () -> {
                                // 处理空任务情况
                                if (Minecraft.getInstance().player != null) {
                                    Minecraft.getInstance().player.displayClientMessage(
                                            Component.translatable("quest."+ ChangShengJue.MOD_ID +".no_abandon.button"), false);
                                }
                            }
                    );

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
            int requirementsTitleWidth = font.width(Component.translatable("quest." + ChangShengJue.MOD_ID + ".requirements"));
            int descriptionStartX = x + REQ_SLOTS_X + requirementsTitleWidth + 5;

            int rewardsTitleWidth = font.width(Component.translatable("quest." + ChangShengJue.MOD_ID + ".rewards"));
            int rewardsDescriptionStartX = x + REQ_SLOTS_X + rewardsTitleWidth + 5;
            // 渲染需求物品
            var reqs = quest.getQuestRequirements();
            for (int i = 0; i < Math.min(3, reqs.size()); i++) {
                ItemStack stack = reqs.get(i);
                renderItemAt(guiGraphics, descriptionStartX + i * SLOT_SIZE, y + REQ_SLOTS_Y - 8, stack);
            }
            var rewards = quest.getQuestRewards();
            for (int i = 0; i < Math.min(6, rewards.size()); i++) {
                ItemStack stack = rewards.get(i);
                renderItemAt(guiGraphics, rewardsDescriptionStartX + i * SLOT_SIZE, y + REWARD_SLOTS_Y + 8, stack);
            }
            if (!quest.getTargetEntity().isEmpty()){
                GuiEntityGraphics.getInstance(font, HEAD_SIZE, MAX_VISIBLE_HEADS, ENTITY_CACHE).
                        renderKillTargetHead(guiGraphics, descriptionStartX, y + REQ_SLOTS_Y ,
                                quest.getTargetEntity(), quest.getCurrentKills(), quest.getRequiredKills());
                if (quest.getSecondTargetEntity() != null && !quest.getSecondTargetEntity().isEmpty()) {
                    GuiEntityGraphics.getInstance(font, HEAD_SIZE, MAX_VISIBLE_HEADS, ENTITY_CACHE).
                            renderKillTargetHead(guiGraphics, descriptionStartX + 15, y + REQ_SLOTS_Y,
                                    quest.getSecondTargetEntity(), quest.getSecondCurrentKills(), quest.getSecondRequiredKills());
                }
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
        int currentPage = menu.getCurrentPage() + 1;
        String pageInfo = String.format("%d/%d", currentPage, menu.getTotalPages());
        guiGraphics.drawString(font, pageInfo, x + imageWidth - (currentPage >= 10 ? 35 : 30), y + 150, 0x404040, false);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        Optional<Quest> currentQuest = menu.getCurrentQuest(this.getMenu().getCurrentPage());

        if (currentQuest.isPresent()) {
            // 渲染当前任务
            Quest quest = currentQuest.get();
            // 任务标题
            guiGraphics.drawString(font, Component.translatable(quest.getQuestName()),
                    (this.imageWidth - font.width(Component.translatable(quest.getQuestName()))) / 2, 14, 0x404040, false);
            // 任务描述
            var lines = font.split(Component.translatable(quest.getQuestDescription()), imageWidth - 45);
            for (int i = 0; i < lines.size(); i++) {
                int descX = i == 0 ? 20 + 17 : 20;
                guiGraphics.drawString(font, lines.get(i), descX,35 + i * font.lineHeight,0x404040, false);
            }
            // 获取需求标题的宽度
            int requirementsTitleWidth = font.width(Component.translatable("quest." + ChangShengJue.MOD_ID + ".requirements"));
            int descriptionStartX = REQ_SLOTS_X + requirementsTitleWidth + (quest.getSecondTargetEntity() != null && !quest.getSecondTargetEntity().isEmpty() ? 30
                    : (quest.getTargetEntity() != null && !quest.getTargetEntity().isEmpty() ? 20 : 5));

            guiGraphics.drawString(font, Component.translatable("quest."+ ChangShengJue.MOD_ID +".requirements"), REQ_SLOTS_X, REQ_SLOTS_Y - 4, ChatFormatting.RED.getColor(), false);

            String requirementsText = quest.getQuestRequirementsDescription();
            Component fullDescriptionComponent = Component.translatable(requirementsText);
            int fullTextWidth = font.width(fullDescriptionComponent);

            // 计算可用宽度
            int maxAvailableWidth = imageWidth - 50 - descriptionStartX;
            if (fullTextWidth > maxAvailableWidth && maxAvailableWidth > 0) {
                scrollTick++;
                // 每8帧移动一个字符
                String visibleText = getString(fullDescriptionComponent);
                // 渲染文本
                guiGraphics.drawString(font, Component.literal(visibleText), descriptionStartX,
                        REQ_SLOTS_Y - 4, ChatFormatting.RED.getColor(), false);
            } else {
                var lines1 = font.split(fullDescriptionComponent, imageWidth - 50);
                for (int i = 0; i < lines1.size(); i++) {
                    guiGraphics.drawString(font, lines1.get(i), descriptionStartX,
                            REQ_SLOTS_Y - 4 + i * font.lineHeight, ChatFormatting.RED.getColor(), false);
                }
            }

            guiGraphics.drawString(font, Component.translatable("quest."+ ChangShengJue.MOD_ID +".rewards"), REQ_SLOTS_X,REWARD_SLOTS_Y + 13, ChatFormatting.YELLOW.getColor(), false);
        } else {
            guiGraphics.drawString(font, Component.translatable("quest." + ChangShengJue.MOD_ID + ".no_quest"),
                    (this.imageWidth - font.width(Component.translatable("quest." + ChangShengJue.MOD_ID + ".no_quest")))
                            / 2, 35, ChatFormatting.RED.getColor(), true);
        }
    }

    private @NotNull String getString(Component requirementsText) {
        int scrollSpeed = 15;
        int visibleChars = Math.min(30, requirementsText.getString().length()); // 最多显示50个字符

        // 在文本末尾添加间隔
        String textWithSpacing = requirementsText.getString() + "    ";

        int totalLength = textWithSpacing.length();
        int startPos = (scrollTick / scrollSpeed) % totalLength;

        String visibleText;
        if (startPos + visibleChars <= totalLength) {
            visibleText = textWithSpacing.substring(startPos, startPos + visibleChars);
        } else {
            // 文本到达末尾，衔接开头部分
            int part1Length = totalLength - startPos;
            int part2Length = visibleChars - part1Length;
            visibleText = textWithSpacing.substring(startPos) + textWithSpacing.substring(0, part2Length);
        }
        return visibleText;
    }

    private void renderTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y, Quest quest) {
        int requirementsTitleWidth = font.width(Component.translatable("quest." + ChangShengJue.MOD_ID + ".requirements"));
        int descriptionStartX = x + REQ_SLOTS_X + requirementsTitleWidth + 5;

        int rewardsTitleWidth = font.width(Component.translatable("quest." + ChangShengJue.MOD_ID + ".rewards"));
        int rewardsDescriptionStartX = x + REQ_SLOTS_X + rewardsTitleWidth + 5;
        // 检查需求物品提示
        List<ItemStack> reqs = quest.getQuestRequirements();
        for (int i = 0; i < Math.min(3, reqs.size()); i++) {
            if (isMouseOverSlot(mouseX, mouseY,descriptionStartX + i * SLOT_SIZE,y + REQ_SLOTS_Y - 8, SLOT_SIZE, SLOT_SIZE)) {
                guiGraphics.renderTooltip(font, reqs.get(i), mouseX, mouseY);
                return;
            }
        }
        // 检查奖励物品提示
        List<ItemStack> rewards = quest.getQuestRewards();
        for (int i = 0; i < Math.min(3, rewards.size()); i++) {
            if (isMouseOverSlot(mouseX, mouseY,rewardsDescriptionStartX + i * SLOT_SIZE,y + REWARD_SLOTS_Y + 8, SLOT_SIZE, SLOT_SIZE)) {
                guiGraphics.renderTooltip(font, rewards.get(i), mouseX, mouseY);
                return;
            }
        }
    }

    private boolean isMouseOverSlot(int mouseX, int mouseY, int slotX, int slotY, int width, int height) {
        return mouseX >= slotX && mouseX <= slotX + width &&
                mouseY >= slotY && mouseY <= slotY + height;
    }

    public void refreshUI() {
        // 彻底清理旧组件
        this.clearWidgets();
        this.renderables.clear(); // 确保所有UI元素被移除
        // 刷新任务列表并调整页码
        this.menu.refreshQuests();
        this.menu.adjustPageAfterQuestRemoval();
        this.menu.refreshQuests();

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
