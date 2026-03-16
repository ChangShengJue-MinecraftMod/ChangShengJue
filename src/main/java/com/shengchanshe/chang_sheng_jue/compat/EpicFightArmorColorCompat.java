package com.shengchanshe.chang_sheng_jue.compat;

import com.mojang.blaze3d.platform.NativeImage;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.DyeableItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class EpicFightArmorColorCompat {
    private static final String EVENT_CLASS = "yesman.epicfight.api.client.forgeevent.AnimatedArmorTextureEvent";
    private static final ResourceLocation TRANSPARENT = new ResourceLocation(ChangShengJue.MOD_ID, "textures/misc/transparent.png");
    private static final Map<Class<?>, EventMethods> METHOD_CACHE = new HashMap<>();
    private static final Map<Class<?>, Field> RESULT_FIELD_CACHE = new HashMap<>();
    private static final Map<CompositeKey, ResourceLocation> COMPOSITE_CACHE = new HashMap<>();

    private EpicFightArmorColorCompat() {}

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onAnyEvent(Event event) {
        if (!ModList.get().isLoaded("epicfight")) {
            return;
        }
        if (!event.getClass().getName().equals(EVENT_CLASS)) {
            return;
        }

        try {
            EventMethods methods = getEventMethods(event.getClass());
            if (methods == null) {
                return;
            }

            Object stackObj = methods.getItemstack.invoke(event);
            if (!(stackObj instanceof ItemStack stack)) {
                return;
            }
            if (!(stack.getItem() instanceof DyeableItem)) {
                return;
            }

            Object slotObj = methods.getEquipmentSlot.invoke(event);
            Object livingObj = methods.getLivingEntity.invoke(event);
            if (!(slotObj instanceof EquipmentSlot slot) || !(livingObj instanceof LivingEntity living)) {
                return;
            }

            ResourceLocation current = (ResourceLocation) methods.getResultLocation.invoke(event);
            ResourceLocation base = resolveBaseTexture(event, stack, living, slot, methods.getResultLocation);
            if (base == null) {
                return;
            }

            ResourceLocation dyeLayer = getCustomLayerForStack(stack);
            if (dyeLayer == null) {
                dyeLayer = withSuffixIfExists(base, "_layer");
            }
            ResourceLocation overlayLayer = getCustomOverlayForStack(stack);
            if (overlayLayer == null) {
                overlayLayer = withSuffixIfExists(base, "_overlay");
            }
            ResourceLocation extraOverlay = getExtraOverlayForStack(stack);

            if (dyeLayer != null) {
                int color = getDyeColor(stack, living, slot);
                ResourceLocation compositeOverlay = overlayLayer != null ? overlayLayer : extraOverlay;
                ResourceLocation composite = getOrCreateTintedComposite(base, dyeLayer, compositeOverlay, color);
                if (composite != null && !composite.equals(current)) {
                    setResultLocationSilently(event, methods.setResultLocation, composite);
                }
                return;
            }

            if (current == null || current.equals(base)) {
                if (overlayLayer != null) {
                    setResultLocationSilently(event, methods.setResultLocation, overlayLayer);
                }
                return;
            }

            if (overlayLayer != null && current.equals(overlayLayer)) {
                return;
            }

        } catch (Throwable ignored) {

        }
    }

    private static ResourceLocation resolveArmorTexture(ItemStack stack, LivingEntity living, EquipmentSlot slot, String type) {
        if (stack.getItem() instanceof ArmorItem armor) {
            String tex = ForgeHooksClient.getArmorTexture(living, stack, armor.getMaterial().getName(), slot, type);
            if (tex != null && !tex.isEmpty()) {
                return new ResourceLocation(tex);
            }
        }
        return null;
    }

    private static ResourceLocation resolveBaseTexture(Event event, ItemStack stack, LivingEntity living, EquipmentSlot slot,
                                                       Method getResultLocation) throws Exception {
        ResourceLocation base = (ResourceLocation) getResultLocation.invoke(event);
        if (base == null) {
            base = resolveArmorTexture(stack, living, slot, null);
        }
        if (base == null) {
            return null;
        }
        if (base.equals(TRANSPARENT)) {
            return null;
        }
        String path = base.getPath();
        if (path.endsWith("_layer.png") || path.endsWith("_overlay.png")) {
            String trimmed = path.substring(0, path.length() - ".png".length());
            int idx = trimmed.lastIndexOf("_layer");
            if (idx >= 0) {
                return new ResourceLocation(base.getNamespace(), trimmed.substring(0, idx) + ".png");
            }
            idx = trimmed.lastIndexOf("_overlay");
            if (idx >= 0) {
                return new ResourceLocation(base.getNamespace(), trimmed.substring(0, idx) + ".png");
            }
        }
        return base;
    }

    private record EventMethods(Method getItemstack, Method getEquipmentSlot, Method getLivingEntity,
                                Method getResultLocation, Method setResultLocation) {}

    private static EventMethods getEventMethods(Class<?> eventClass) {
        EventMethods cached = METHOD_CACHE.get(eventClass);
        if (cached != null) {
            return cached;
        }
        try {
            EventMethods methods = new EventMethods(
                    eventClass.getMethod("getItemstack"),
                    eventClass.getMethod("getEquipmentSlot"),
                    eventClass.getMethod("getLivingEntity"),
                    eventClass.getMethod("getResultLocation"),
                    eventClass.getMethod("setResultLocation", ResourceLocation.class)
            );
            METHOD_CACHE.put(eventClass, methods);
            return methods;
        } catch (Throwable ignored) {
            METHOD_CACHE.put(eventClass, null);
            return null;
        }
    }

    private record CompositeKey(ResourceLocation base, ResourceLocation layer, ResourceLocation overlay, int color) {}

    private static ResourceLocation getOrCreateTintedComposite(ResourceLocation base, ResourceLocation layer, ResourceLocation overlay, int color) {
        CompositeKey key = new CompositeKey(base, layer, overlay, color);
        ResourceLocation cached = COMPOSITE_CACHE.get(key);
        if (cached != null) {
            return cached;
        }

        NativeImage baseImg = null;
        NativeImage layerImg = null;
        NativeImage overlayImg = null;
        try {
            baseImg = loadImage(base);
            layerImg = loadImage(layer);
            if (baseImg == null || layerImg == null) {
                return null;
            }
            if (overlay != null) {
                overlayImg = loadImage(overlay);
            }
            int width = Math.min(baseImg.getWidth(), layerImg.getWidth());
            int height = Math.min(baseImg.getHeight(), layerImg.getHeight());
            if (overlayImg != null) {
                width = Math.min(width, overlayImg.getWidth());
                height = Math.min(height, overlayImg.getHeight());
            }
            NativeImage out = new NativeImage(width, height, true);

            int cr = (color >> 16) & 0xFF;
            int cg = (color >> 8) & 0xFF;
            int cb = color & 0xFF;

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int baseRgba = baseImg.getPixelRGBA(x, y);
                    int layerRgba = layerImg.getPixelRGBA(x, y);
                    int ba = getA(baseRgba);
                    float outA = ba / 255.0f;
                    float outR = getR(baseRgba) / 255.0f;
                    float outG = getG(baseRgba) / 255.0f;
                    float outB = getB(baseRgba) / 255.0f;

                    int la = getA(layerRgba);
                    if (la != 0) {
                        int lr = getR(layerRgba);
                        int lg = getG(layerRgba);
                        int lb = getB(layerRgba);

                        float tr = (lr * cr) / 255.0f / 255.0f;
                        float tg = (lg * cg) / 255.0f / 255.0f;
                        float tb = (lb * cb) / 255.0f / 255.0f;

                        float a = la / 255.0f;
                        float inv = 1.0f - a;
                        outR = outR * inv + tr * a;
                        outG = outG * inv + tg * a;
                        outB = outB * inv + tb * a;
                        outA = outA + a * (1.0f - outA);
                    }

                    if (overlayImg != null) {
                        int overlayRgba = overlayImg.getPixelRGBA(x, y);
                        int oa = getA(overlayRgba);
                        if (oa != 0) {
                            float or = getR(overlayRgba) / 255.0f;
                            float og = getG(overlayRgba) / 255.0f;
                            float ob = getB(overlayRgba) / 255.0f;
                            float oaF = oa / 255.0f;
                            float inv = 1.0f - oaF;
                            outR = outR * inv + or * oaF;
                            outG = outG * inv + og * oaF;
                            outB = outB * inv + ob * oaF;
                            outA = outA + oaF * (1.0f - outA);
                        }
                    }
                    int outAi = Math.min(255, Math.max(0, Math.round(outA * 255.0f)));
                    int outRi = Math.min(255, Math.max(0, Math.round(outR * 255.0f)));
                    int outGi = Math.min(255, Math.max(0, Math.round(outG * 255.0f)));
                    int outBi = Math.min(255, Math.max(0, Math.round(outB * 255.0f)));

                    int outRgba = packABGR(outAi, outRi, outGi, outBi);
                    out.setPixelRGBA(x, y, outRgba);
                }
            }

            ResourceLocation id = new ResourceLocation(ChangShengJue.MOD_ID,
                    "generated/epicfight/armor/" + Integer.toHexString(key.hashCode()) + ".png");
            Minecraft.getInstance().getTextureManager().register(id, new DynamicTexture(out));
            COMPOSITE_CACHE.put(key, id);
            return id;
        } catch (Throwable ignored) {
            return null;
        } finally {
            if (baseImg != null) {
                baseImg.close();
            }
            if (layerImg != null) {
                layerImg.close();
            }
            if (overlayImg != null) {
                overlayImg.close();
            }
        }
    }

    private static NativeImage loadImage(ResourceLocation location) {
        try {
            return Minecraft.getInstance().getResourceManager()
                    .getResource(location)
                    .map(resource -> {
                        try {
                            return NativeImage.read(resource.open());
                        } catch (Throwable ignored) {
                            return null;
                        }
                    })
                    .orElse(null);
        } catch (Throwable ignored) {
            return null;
        }
    }

    private static int getA(int abgr) {
        return (abgr >>> 24) & 0xFF;
    }

    private static int getB(int abgr) {
        return (abgr >>> 16) & 0xFF;
    }

    private static int getG(int abgr) {
        return (abgr >>> 8) & 0xFF;
    }

    private static int getR(int abgr) {
        return abgr & 0xFF;
    }

    private static int packABGR(int a, int r, int g, int b) {
        return (a << 24) | (b << 16) | (g << 8) | r;
    }

    private static ResourceLocation getExtraOverlayForStack(ItemStack stack) {
        if (stack.is(ChangShengJueItems.COTTON_HELMET.get())) {
            return new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/cotton_armor_feather_overlay.png");
        }
        if (stack.is(ChangShengJueItems.WHITE_COTTON_HELMET.get())) {
            return new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/cotton_armor_white_feather_overlay.png");
        }
        return null;
    }

    private static ResourceLocation getCustomLayerForStack(ItemStack stack) {
        if (stack.is(ChangShengJueItems.FLY_FISH_CLOUD_VEIL_CROWN.get())) {
            return new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/flying_fish_robe_layer_1.png");
        }
        if (stack.is(ChangShengJueItems.FLY_FISH_IRON_HAT.get())) {
            return new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/flying_fish_robe_layer_0.png");
        }
        if (stack.is(ChangShengJueItems.FLY_FISH_CHESTPLATE.get()) || stack.is(ChangShengJueItems.FLY_FISH_LONG_BOOTS.get())) {
            return new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/flying_fish_robe_layer_0.png");
        }
        return null;
    }

    private static ResourceLocation getCustomOverlayForStack(ItemStack stack) {
        if (stack.is(ChangShengJueItems.WALKER_GOLD_RING_BAND.get())) {
            return new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/walker_set_0_overlay.png");
        }
        if (stack.is(ChangShengJueItems.WALKER_GREEN_TREASURE_PENDANT.get())) {
            return new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/walker_set_1_overlay.png");
        }
        if (stack.is(ChangShengJueItems.FLY_FISH_CLOUD_VEIL_CROWN.get())) {
            return new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/flying_fish_robe_1_overlay.png");
        }
        if (stack.is(ChangShengJueItems.FLY_FISH_IRON_HAT.get())) {
            return new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/flying_fish_robe_0_overlay.png");
        }
        return null;
    }

    private static int getDyeColor(ItemStack stack, LivingEntity living, EquipmentSlot slot) {
        if (stack.is(ChangShengJueItems.FLY_FISH_IRON_HAT.get())) {
            return 0xFFFFFF;
        }
        if (stack.getItem() instanceof DyeableItem dyeable) {
            if (dyeable.hasCustomColor(stack)) {
                int c = dyeable.getColor(stack);
                return c == -1 || c == 0x0000FF ? 0xFFFFFF : c;
            }
            ItemStack equipped = living.getItemBySlot(slot);
            if (!equipped.isEmpty() && equipped.getItem() == stack.getItem() && dyeable.hasCustomColor(equipped)) {
                int c = dyeable.getColor(equipped);
                return c == -1 || c == 0x0000FF ? 0xFFFFFF : c;
            }
        }
        return 0xFFFFFF;
    }

    private static void setResultLocationSilently(Event event, Method setResultLocation, ResourceLocation desired) throws Exception {
        Field field = RESULT_FIELD_CACHE.get(event.getClass());
        if (field == null && !RESULT_FIELD_CACHE.containsKey(event.getClass())) {
            field = findResultField(event.getClass());
            RESULT_FIELD_CACHE.put(event.getClass(), field);
        }
        if (field != null) {
            field.set(event, desired);
            return;
        }
        setResultLocation.invoke(event, desired);
    }

    private static Field findResultField(Class<?> eventClass) {
        try {
            Field f = eventClass.getDeclaredField("resultLocation");
            f.setAccessible(true);
            return f;
        } catch (Throwable ignored) {
        }
        try {
            Field f = eventClass.getDeclaredField("result");
            f.setAccessible(true);
            return f;
        } catch (Throwable ignored) {
        }
        for (Field f : eventClass.getDeclaredFields()) {
            if (f.getType() == ResourceLocation.class) {
                f.setAccessible(true);
                return f;
            }
        }
        return null;
    }

    private static ResourceLocation withSuffixIfExists(ResourceLocation base, String suffix) {
        String path = base.getPath();
        if (!path.endsWith(".png")) {
            return null;
        }
        String with = path.substring(0, path.length() - 4) + suffix + ".png";
        ResourceLocation candidate = new ResourceLocation(base.getNamespace(), with);
        return resourceExists(candidate) ? candidate : null;
    }

    private static boolean resourceExists(ResourceLocation location) {
        return Minecraft.getInstance().getResourceManager().getResource(location).isPresent();
    }
}
