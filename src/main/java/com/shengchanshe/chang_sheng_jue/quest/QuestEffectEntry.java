package com.shengchanshe.chang_sheng_jue.quest;

public record QuestEffectEntry(String effectId, int duration, int amplifier, boolean isAmbient, boolean showParticles, boolean showIcon) {
    public QuestEffectEntry {
        isAmbient = isAmbient || false;
        showParticles = showParticles != false;
        showIcon = showIcon != false;
    }
}