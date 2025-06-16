package com.shengchanshe.changshengjue.block.food.nobox;

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

public class Pear extends NoBoxTypeBlock{
    protected static final VoxelShape PEAR_NORTH = Block.box(6D, 0.0D, 5D, 10D, 8.0D, 9D);
    protected static final VoxelShape PEAR_SOUTH = Block.box(6D, 0.0D, 7D, 10D, 8.0D, 11D);
    protected static final VoxelShape PEAR_EAST = Block.box(7D, 0.0D, 6D, 11D, 8.0D, 10D);
    protected static final VoxelShape PEAR_WEST = Block.box(5D, 0.0D, 6D, 9D, 8.0D, 10D);
    public static int fed = 0;
    public static float fedpro = 0.0F;

    public Pear(Properties pProperties, int fed, float fedpro) {
        super(pProperties, fed, fedpro);
        this.fed = fed;
        this.fedpro = fedpro;
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return PEAR_NORTH;
            case SOUTH:
                return PEAR_SOUTH;
            case EAST:
                return PEAR_EAST;
            case WEST:
                return PEAR_WEST;
            default:
                return super.getShape(state, level, pos, context);
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
