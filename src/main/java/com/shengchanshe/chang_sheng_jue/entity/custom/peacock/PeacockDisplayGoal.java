package com.shengchanshe.chang_sheng_jue.entity.custom.peacock;

import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.female.FemalePeacock;
import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.male.MalePeacock;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.List;

public class PeacockDisplayGoal extends Goal {
    private final MalePeacock peacock;
    private int cooldown;

    public PeacockDisplayGoal(MalePeacock peacock) {
        this.peacock = peacock;
        this.cooldown = 0;
    }

    @Override
    public boolean canUse() {
        if (cooldown-- > 0) return false;

        // 检测8格内是否有雌孔雀
        List<FemalePeacock> females = peacock.level()
                .getEntitiesOfClass(FemalePeacock.class,
                        peacock.getBoundingBox().inflate(8.0),
                        e -> true
                );

        return !females.isEmpty();
    }

    @Override
    public void start() {
        peacock.setDisplaying(true); // 需在MalePeacock中添加此方法
        cooldown = peacock.getRandom().nextInt(200) + 216;
    }

    @Override
    public void stop() {
        peacock.setDisplaying(false);
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

}
