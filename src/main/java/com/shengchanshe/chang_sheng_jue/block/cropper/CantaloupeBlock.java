package com.shengchanshe.chang_sheng_jue.block.cropper;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;

public class CantaloupeBlock extends StemGrownBlock {
    public CantaloupeBlock(Properties p_57058_) {
        super(p_57058_);
    }

    @Override
    public StemBlock getStem() {
        return (StemBlock) ChangShengJueBlocks.CANTALOUPE_STEM.get();
    }

    @Override
    public AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock) ChangShengJueBlocks.ATTACHED_CANTALOUPE_STEM.get();
    }
}
