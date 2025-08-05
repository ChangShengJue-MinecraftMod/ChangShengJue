package com.shengchanshe.chang_sheng_jue.util;

import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.ForgeRegistries;
import org.joml.Quaternionf;

import java.util.List;
import java.util.Map;

public record GuiEntityGraphics(Font font, int headSize, int maxVisibleHeads, Map<EntityType<?>, Entity> entityCache) {
//    private float rotationAngle = 0; // 当前旋转角度（度）
//    private long lastUpdateTime = 0; // 上次更新时间
    private static GuiEntityGraphics instance;

    public static GuiEntityGraphics getInstance(Font font,int headSize,int maxVisibleHeads,Map<EntityType<?>, Entity> entityCache) {
        if (instance == null) {
            instance = new GuiEntityGraphics(font, headSize, maxVisibleHeads,entityCache);
        }
        return instance;
    }

    public void renderKillTargetHead(GuiGraphics guiGraphics, int x, int y, Quest quest) {
        // 判断是否是标签目标
        if (quest.getTargetEntity().startsWith("#")) {
            // 处理生物标签
            renderTaggedEntities(guiGraphics, x, y, quest);
        } else {
            // 处理单个生物
            renderSingleEntity(guiGraphics, x, y, quest);
        }
        // 渲染击杀数量
        renderScaledKillCount(guiGraphics, x, y, quest);
    }

    private void renderScaledKillCount(GuiGraphics guiGraphics, int x, int y, Quest quest) {
        String killText = quest.getCurrentKills() + "/" + quest.getRequiredKills();
        int textWidth = font.width(killText);

        // 计算缩放比例（最大宽度为headSize的80%）
        float maxWidth = headSize * 1.0f;
        float scale = textWidth > maxWidth ? maxWidth / textWidth : 1.0f;

        // 设置渲染位置（居中下方）
        int renderX = x + (headSize - (int)(textWidth * scale)) / 2;
        int renderY = y + headSize - (int)(9 * scale);

        // 带缩放的文字渲染
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(renderX, renderY, 0);
        guiGraphics.pose().scale(scale, scale, 1.0f);

        // 渐变色文本（当前数黄色，总数白色）
        int currentKills = quest.getCurrentKills();
        int requiredKills = quest.getRequiredKills();
        String[] parts = killText.split("/");

        font.drawInBatch(
                parts[0],
                0, 0,
                currentKills >= requiredKills ? 0x00FF00 : 0xFFD700, // 绿色/金色
                true,
                guiGraphics.pose().last().pose(),
                guiGraphics.bufferSource(),
                Font.DisplayMode.NORMAL,
                0, 0xF000F0
        );

        font.drawInBatch(
                "/" + parts[1],
                font.width(parts[0]), 0,
                0xFFFFFF, // 白色
                true,
                guiGraphics.pose().last().pose(),
                guiGraphics.bufferSource(),
                Font.DisplayMode.NORMAL,
                0, 0xF000F0
        );

        guiGraphics.pose().popPose();
    }


    public void renderTaggedEntities(GuiGraphics guiGraphics, int x, int y, Quest quest) {
        // 获取生物标签
        TagKey<EntityType<?>> tag = TagKey.create(
                ForgeRegistries.ENTITY_TYPES.getRegistryKey(),
                new ResourceLocation(quest.getTargetEntity().substring(1))
        );

        // 获取所有带标签的生物
        List<EntityType<?>> taggedEntities = ForgeRegistries.ENTITY_TYPES.tags()
                .getTag(tag)
                .stream()
                .toList();

        if (taggedEntities.isEmpty()) {
            renderMissingIcon(guiGraphics, x, y);
            return;
        }

        // 计算动画进度（每20 ticks切换一次生物）
        long gameTime = Minecraft.getInstance().level.getGameTime();
        int index = (int)((gameTime / 20) % taggedEntities.size()); // 循环索引

        // 渲染当前选中的生物
        renderEntityHead(guiGraphics, x, y, taggedEntities.get(index));

//        // 显示标签提示（可选）
//        if (taggedEntities.size() > 1) {
//            guiGraphics.pose().pushPose();
//            guiGraphics.pose().translate(0, 0, 200); // 确保文字在前景
//            guiGraphics.drawString(
//                    font,
//                    "(" + (index+1) + "/" + taggedEntities.size() + ")",
//                    x + headSize + 2,
//                    y + headSize - 10,
//                    0xAAAAAA
//            );
//            guiGraphics.pose().popPose();
//        }
    }

    // 根据任务ID作为种子随机选择，保证同一任务每次渲染相同生物
//    public EntityType<?> getRandomEntityForTag(Quest quest, List<EntityType<?>> entities) {
//        long seed = quest.getQuestId().getMostSignificantBits();
//        Random random = new Random(seed);
//        return entities.get(random.nextInt(entities.size()));
//    }

    public void renderSingleEntity(GuiGraphics guiGraphics, int x, int y, Quest quest) {
        EntityType<?> entityType = ForgeRegistries.ENTITY_TYPES.getValue(
                new ResourceLocation(quest.getTargetEntity())
        );

        if (entityType != null) {
            renderEntityHead(guiGraphics, x, y, entityType);
        } else {
            renderMissingIcon(guiGraphics, x, y);
        }
    }

    public void renderMissingIcon(GuiGraphics guiGraphics, int x, int y) {
        // 表示未知生物
        guiGraphics.blit(new ResourceLocation("textures/gui/icon_missing.png"),
                x, y, 0, 0, headSize, headSize, headSize, headSize);
    }

    public void renderEntityHead(GuiGraphics guiGraphics, int x, int y, EntityType<?> entityType) {
        // 从缓存获取或创建实体
        Entity entity = entityCache.computeIfAbsent(entityType, type -> {
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
        guiGraphics.pose().translate(x + (float) headSize / 2, y + (float) headSize / 2 + yOffset, 100.0F);
        guiGraphics.pose().scale(headSize, headSize, headSize);

        // 设置朝向
        Quaternionf quaternion = new Quaternionf().rotateZ(180.0F * (float)Math.PI / 180.0F);
        guiGraphics.pose().mulPose(quaternion);
        //让生物旋转
//        Quaternionf rotation = new Quaternionf()
//                .rotateYXZ(
//                        0, // Y轴旋转（可调整）
//                        rotationAngle * ((float)Math.PI / 180f), // X轴旋转（主要旋转轴）
//                        0  // Z轴旋转（可调整）
//                )
//                .rotateZ(180 * ((float)Math.PI / 180f)); // 保持原有翻转
//
//        guiGraphics.pose().mulPose(rotation);

        // 渲染实体
        EntityRenderDispatcher renderer = Minecraft.getInstance().getEntityRenderDispatcher();
        quaternion.conjugate();
        renderer.overrideCameraOrientation(quaternion);
        renderer.setRenderShadow(false);

        MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
        renderer.render(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F,
                guiGraphics.pose(), buffer, 0xF000F0);

        buffer.endBatch();
        renderer.setRenderShadow(false);
        guiGraphics.pose().popPose();
    }
}
