package com.shengchanshe.chang_sheng_jue.block.custom.sharpening_stone;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class StoneSharpeningStone  extends SharpeningStone {
    public StoneSharpeningStone() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .strength(2.0F, 6.0F)
                .requiresCorrectToolForDrops().noOcclusion()
        );
    }
}
