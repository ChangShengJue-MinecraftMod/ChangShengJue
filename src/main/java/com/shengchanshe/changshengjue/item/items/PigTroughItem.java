package com.shengchanshe.changshengjue.item.items;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class PigTroughItem extends BlockItem {
    public PigTroughItem(Block pBlock, Item.Properties pProperties) {
        super(pBlock, pProperties);
    }

    protected boolean placeBlock(BlockPlaceContext pContext, BlockState pState) {
        return pContext.getLevel().setBlock(pContext.getClickedPos(), pState, 26);
    }
}
