package com.shengchanshe.chang_sheng_jue.block.custom.sharpening_stone;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class DiamondSharpeningStone extends SharpeningStone {
    public DiamondSharpeningStone() {
        super(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.DIAMOND)
                        .strength(3.0F, 10.0F)
                        .requiresCorrectToolForDrops().noOcclusion()
        );
    }
}
