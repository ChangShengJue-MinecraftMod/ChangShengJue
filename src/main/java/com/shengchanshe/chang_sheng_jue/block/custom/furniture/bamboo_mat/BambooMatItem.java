package com.shengchanshe.chang_sheng_jue.block.custom.furniture.bamboo_mat;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BambooMatItem extends BlockItem {
    public BambooMatItem(Block pBlock, Item.Properties pProperties) {
        super(pBlock, pProperties);
    }

    protected boolean placeBlock(BlockPlaceContext pContext, BlockState pState) {
        return pContext.getLevel().setBlock(pContext.getClickedPos(), pState, 26);
    }
}
