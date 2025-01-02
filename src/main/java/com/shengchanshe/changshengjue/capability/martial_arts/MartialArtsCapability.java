package com.shengchanshe.changshengjue.capability.martial_arts;

import com.shengchanshe.changshengjue.martial_arts.MartialArtsData;

import java.util.HashMap;
import java.util.Map;

public class MartialArtsCapability {

    private final Map<String, MartialArtsData> martialArtsDataMap = new HashMap<>();
    private final Map<Integer, String> keyToMartialArts = new HashMap<>();

    public void addSkill(String martialArtsId, MartialArtsData martialArtsData) {
        martialArtsDataMap.put(martialArtsId, martialArtsData);
    }

    public void bindKeyToSkill(int key, String martialArtsId) {
        // 如果这个按键已经被其他技能绑定，那么先解绑
        if (keyToMartialArts.containsKey(key)) {
            String oldSkillId = keyToMartialArts.get(key);
            MartialArtsData oldSkill = martialArtsDataMap.get(oldSkillId);
            oldSkill.getBoundKeys().remove(key);
        }

        // 绑定新的技能
        keyToMartialArts.put(key, martialArtsId);
        MartialArtsData newSkill = martialArtsDataMap.get(martialArtsId);
        newSkill.getBoundKeys().add(key);
    }

    public void handleKeyEvent(int key) {
        if (keyToMartialArts.containsKey(key)) {
            String skillId = keyToMartialArts.get(key);
            MartialArtsData skill = martialArtsDataMap.get(skillId);

            // 触发技能，例如：
            // skill.activate();
        }
    }

}
