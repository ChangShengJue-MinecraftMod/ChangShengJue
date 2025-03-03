package com.shengchanshe.changshengjue.block.custom.tile;

import net.minecraft.core.Direction;

public class AnimalsCylinderTile  extends CylinderTile {
    public AnimalsCylinderTile(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
}
