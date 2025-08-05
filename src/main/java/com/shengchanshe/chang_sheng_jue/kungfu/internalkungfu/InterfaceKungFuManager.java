package com.shengchanshe.chang_sheng_jue.kungfu.internalkungfu;

import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.kungfu.internalkungfu.kungfu.*;
import net.minecraft.world.item.ItemStack;

import java.util.*;

public class InterfaceKungFuManager {
    private final Map<InternalKungFu, InternalKungFuCapability> kungFuCapabilities = new HashMap<>();

    public InterfaceKungFuManager() {
        // 初始化每种武功的能力
        kungFuCapabilities.put(InternalKungFu.GOLDEN_BELL_JAR, new GoldenBellJar());
        kungFuCapabilities.put(InternalKungFu.IMMORTAL_MIRACLE, new ImmortalMiracle());
        kungFuCapabilities.put(InternalKungFu.QIAN_KUN_DA_NUO_YI, new QianKunDaNuoYi());
        kungFuCapabilities.put(InternalKungFu.TURTLE_BREATH_WORK, new TurtleBreathWork());
        kungFuCapabilities.put(InternalKungFu.THE_CLASSICS_OF_TENDON_CHANGING, new TheClassicsOfTendonChanging());
    }

    public static InternalKungFuCapability createInterfaceKungFuCapabilityFromTag(String kungFuType) {
        return switch (kungFuType) {
            case "GoldenBellJar" -> new GoldenBellJar();
            case "ImmortalMiracle" -> new ImmortalMiracle();
            case "QianKunDaNuoYi" -> new QianKunDaNuoYi();
            case "TurtleBreathWork" -> new TurtleBreathWork();
            case "TheClassicsOfTendonChanging" -> new TheClassicsOfTendonChanging();
            default -> null;
        };
    }

    public static ItemStack createInterfaceKungFuBookItems(String kungFuType) {
        return switch (kungFuType) {
            case "GoldenBellJar" -> new ItemStack(ChangShengJueItems.GOLDEN_BELL_JAR.get());
            case "ImmortalMiracle" -> new ItemStack(ChangShengJueItems.IMMORTAL_MIRACLE.get());
            case "QianKunDaNuoYi" -> new ItemStack(ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get());
            case "TurtleBreathWork" -> new ItemStack(ChangShengJueItems.TURTLE_BREATH_WORK.get());
            case "TheClassicsOfTendonChanging" -> new ItemStack(ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get());
            default -> null;
        };
    }

    public static List<InternalKungFuCapability> createInterfaceKungFuCapabilitiesFromTag(String kungFuType) {
        List<InternalKungFuCapability> internalKungFuCapabilities = new ArrayList<>();
        switch (kungFuType) {
            case "GoldenBellJar":
                internalKungFuCapabilities.add(new GoldenBellJar());
                break;
            case "ImmortalMiracle":
                internalKungFuCapabilities.add(new ImmortalMiracle());
                break;
            case "QianKunDaNuoYi":
                internalKungFuCapabilities.add(new QianKunDaNuoYi());
                break;
            case "TurtleBreathWork":
                internalKungFuCapabilities.add(new TurtleBreathWork());
                break;
            case "TheClassicsOfTendonChanging":
                internalKungFuCapabilities.add(new TheClassicsOfTendonChanging());
                break;
            default:
                // 如果kungFuType不匹配任何已知类型，可以在这里添加默认行为
                break;
        }
        return internalKungFuCapabilities;
    }

    public List<InternalKungFuCapability> getRandomInternalKungFuCapabilities() {
        Random random = new Random();
        List<InternalKungFu> availableKungFus = new ArrayList<>(Arrays.asList(InternalKungFu.values()));
        List<InternalKungFuCapability> internalKungFuCapabilities = new ArrayList<>();

            for (int i = 0; i < 2; i++) {
                if (!availableKungFus.isEmpty()) {
                    InternalKungFu randomKungFu = availableKungFus.get(random.nextInt(availableKungFus.size()));
                    internalKungFuCapabilities.add(kungFuCapabilities.get(randomKungFu));
                    availableKungFus.remove(randomKungFu);
                }
            }
        return internalKungFuCapabilities;
    }

    public InternalKungFuCapability getRandomInterfaceKungFuCapability() {
        Random random = new Random();
        InternalKungFu randomKungFu = InternalKungFu.values()[random.nextInt(InternalKungFu.values().length)];
        return kungFuCapabilities.get(randomKungFu);
    }
}
