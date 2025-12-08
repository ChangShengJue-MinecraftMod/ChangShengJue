package com.shengchanshe.chang_sheng_jue.block.custom.sharpening_stone;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class NetheriteSharpeningStone  extends SharpeningStone {
    public NetheriteSharpeningStone() {
        super(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_BLACK)
                        .strength(4.0F, 1200.0F)
                        .requiresCorrectToolForDrops().noOcclusion()
        );
    }
}