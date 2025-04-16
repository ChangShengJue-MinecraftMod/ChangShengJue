package com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.quest.Quest;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.gui.quest.AbandonGangQuestPacket;
import com.shengchanshe.changshengjue.network.packet.gui.quest.AcceptGangQuestsPacket;
import com.shengchanshe.changshengjue.network.packet.gui.quest.SubmitGangQuestsPacket;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
import org.joml.Quaternionf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

    private static final int HEAD_SIZE = 12; // 每个头像的大小
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

        if (menu.getGangQuests().getQuestType() == Quest.QuestType.KILL) {
            var lines1 = font.split(Component.translatable(menu.getGangQuests().getQuestRequirementsDescription()), imageWidth - 50);
            for (int i = 0; i < lines1.size(); i++) {
                guiGraphics.drawString(font, lines1.get(i), 28, 120 + i * font.lineHeight, ChatFormatting.RED.getColor(), false);
            }
        }

        guiGraphics.drawString(font, Component.translatable("quest.requirements"), REQ_SLOTS_X, REQ_SLOTS_Y - 9, ChatFormatting.RED.getColor(), false);
        guiGraphics.drawString(font, Component.translatable("quest.rewards"), REWARD_SLOTS_X, REWARD_SLOTS_Y - 9, ChatFormatting.YELLOW.getColor(), false);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        Quest currentQuest = menu.getGangQuests();

        // 根据任务类型决定渲染内容
        if (currentQuest.getQuestType() == Quest.QuestType.KILL) {
            // 渲染击杀任务的目标生物
            renderKillTargetHead(guiGraphics,x + REQ_SLOTS_X + 40, y + REQ_SLOTS_Y - 1, currentQuest);
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

        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    private void renderKillTargetHead(GuiGraphics guiGraphics, int x, int y, Quest quest) {
        // 判断是否是标签目标
        if (quest.getTargetEntity().startsWith("#")) {
            // 处理生物标签
            renderTaggedEntities(guiGraphics, x, y, quest);
        } else {
            // 处理单个生物
            renderSingleEntity(guiGraphics, x, y, quest);
        }

        // 渲染击杀数量
        String killText = quest.getCurrentKills() + "/" + quest.getRequiredKills();
        guiGraphics.drawString(font, killText, x + 15, y + HEAD_SIZE - 15, 0xFFFFFF);
    }

    private void renderTaggedEntities(GuiGraphics guiGraphics, int x, int y, Quest quest) {
        // 获取生物标签
        TagKey<EntityType<?>> tag = TagKey.create(
                ForgeRegistries.ENTITY_TYPES.getRegistryKey(),
                new ResourceLocation(quest.getTargetEntity().substring(1))
        );

        // 获取所有带标签的生物
        List<EntityType<?>> taggedEntities = ForgeRegistries.ENTITY_TYPES.tags().getTag(tag).stream().toList();

        if (taggedEntities.isEmpty()) {
            // 没有找到生物，显示问号图标
            renderMissingIcon(guiGraphics, x, y);
            return;
        }

        // 计算起始位置（居中显示）
        int totalWidth = Math.min(taggedEntities.size(), MAX_VISIBLE_HEADS) * HEAD_SIZE;
        int startX = x - (totalWidth - HEAD_SIZE) / 2;

        // 随机选择一个生物类型渲染
        EntityType<?> randomEntity = getRandomEntityForTag(quest, taggedEntities);
        renderEntityHead(guiGraphics, x, y, randomEntity);

        // 如果生物数量超过显示上限，显示"..."提示
//        if (taggedEntities.size() > MAX_VISIBLE_HEADS) {
//            guiGraphics.drawString(font, "...",
//                    startX + MAX_VISIBLE_HEADS * HEAD_SIZE + 2,
//                    y + HEAD_SIZE / 2 - 4,
//                    0xFFFFFF);
//        }
    }

    // 根据任务ID作为种子随机选择，保证同一任务每次渲染相同生物
    private EntityType<?> getRandomEntityForTag(Quest quest, List<EntityType<?>> entities) {
        long seed = quest.getQuestId().getMostSignificantBits();
        Random random = new Random(seed);
        return entities.get(random.nextInt(entities.size()));
    }

    private void renderSingleEntity(GuiGraphics guiGraphics, int x, int y, Quest quest) {
        EntityType<?> entityType = ForgeRegistries.ENTITY_TYPES.getValue(
                new ResourceLocation(quest.getTargetEntity())
        );

        if (entityType != null) {
            renderEntityHead(guiGraphics, x, y, entityType);
        } else {
            renderMissingIcon(guiGraphics, x, y);
        }
    }

    private void renderMissingIcon(GuiGraphics guiGraphics, int x, int y) {
        // 表示未知生物
        guiGraphics.blit(new ResourceLocation("textures/gui/icon_missing.png"),
                x, y, 0, 0, HEAD_SIZE, HEAD_SIZE, HEAD_SIZE, HEAD_SIZE);
    }

    private void renderEntityHead(GuiGraphics guiGraphics, int x, int y, EntityType<?> entityType) {
        // 从缓存获取或创建实体
        Entity entity = ENTITY_CACHE.computeIfAbsent(entityType, type -> {
            Entity e = type.create(Minecraft.getInstance().level);
            return e;
        });

        if (entity == null) {
            renderMissingIcon(guiGraphics, x, y);
            return;
        }

        // 设置渲染参数
        float yOffset = 0.0F;

        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(x + (float) HEAD_SIZE / 2, y + (float) HEAD_SIZE / 2 + yOffset, 100.0F);
        guiGraphics.pose().scale(HEAD_SIZE, HEAD_SIZE, HEAD_SIZE);

        // 设置朝向
        Quaternionf quaternion = new Quaternionf().rotateZ(180.0F * (float)Math.PI / 180.0F);
        guiGraphics.pose().mulPose(quaternion);

        // 渲染实体
        EntityRenderDispatcher renderer = Minecraft.getInstance().getEntityRenderDispatcher();
        quaternion.conjugate();
        renderer.overrideCameraOrientation(quaternion);
        renderer.setRenderShadow(false);

        MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
        renderer.render(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F,
                guiGraphics.pose(), buffer, 0xF000F0);

        buffer.endBatch();
        renderer.setRenderShadow(true);
        guiGraphics.pose().popPose();

//        // 渲染头像边框（可选）
//        guiGraphics.blit(new ResourceLocation("textures/gui/head_border.png"),
//                x, y, 0, 0, HEAD_SIZE, HEAD_SIZE, HEAD_SIZE, HEAD_SIZE);
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
        return Component.translatable(menu.getGangQuests().getAcceptedBy() != null ? "quest.submit.button" : "quest.accept.button");
    }

    private Component getCancelButtonText() {
        return Component.translatable(menu.getGangQuests().getAcceptedBy() != null ? "quest.abandon.button" : "quest.flushed.button");
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
        // 添加刷新调用
        this.refreshUI();
    }

    //处理放弃和刷新按钮点击
    private void handleCancelButtonClick(Button button) {
        if (menu.getGangQuests().getAcceptedBy() != null) {
            ChangShengJueMessages.sendToServer(new AbandonGangQuestPacket());
        }else {

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