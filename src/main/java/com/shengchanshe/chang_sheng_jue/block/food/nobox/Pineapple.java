package com.shengchanshe.chang_sheng_jue.block.food.nobox;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Pineapple extends NoBoxTypeBlock{
    protected static final VoxelShape PINEAPPLE_NORTH = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 10.0D, 10.5D);
    protected static final VoxelShape PINEAPPLE_SOUTH = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 10.0D, 10.5D);
    protected static final VoxelShape PINEAPPLE_EAST = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 10.0D, 10.5D);
    protected static final VoxelShape PINEAPPLE_WEST = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 10.0D, 10.5D);
    public int fed;
    public float fedpro;

    public Pineapple(Properties pProperties, int fed, float fedpro) {
        super(pProperties, fed, fedpro);
        this.fed = fed;
        this.fedpro = fedpro;
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return PINEAPPLE_NORTH;
            case SOUTH:
                return PINEAPPLE_SOUTH;
            case EAST:
                return PINEAPPLE_EAST;
            case WEST:
                return PINEAPPLE_WEST;
            default:
                return PINEAPPLE_NORTH;
        }
    }
    protected InteractionResult addFed(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, int fed, float fedpro) {
        if (player.getFoodData().getFoodLevel() < 20 || player.isCreative()) {
            player.getFoodData().eat(this.fed, this.fedpro);
            level.destroyBlock(pos, false);
            level.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
    
}
