package com.shengchanshe.chang_sheng_jue.block.food.nobox;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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

public class Lichee extends NoBoxTypeBlock{
    protected static final VoxelShape LICHEE_EAST = Block.box(4.75D, 0.0D, 5.25D, 13.5D, 3.0D, 12.0D);
    protected static final VoxelShape LICHEE_WEST = Block.box(2D, 0.0D, 4.0D, 11.25D, 3.0D, 11.5D);
    protected static final VoxelShape LICHEE_SOUTH = Block.box(4.25D, 0.0D, 4.75D, 11.5D, 3.0D, 14.0D);
    protected static final VoxelShape LICHEE_NORTH = Block.box(5.25D, 0.0D, 2.0D, 11.5D, 3.0D, 10.75D);
    public static int fed = 0;
    public static float fedpro = 0.0F;

    public Lichee(Properties pProperties, int fed, float fedpro) {
        super(pProperties, fed, fedpro);
        this.fed = fed;
        this.fedpro = fedpro;
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        switch (direction) {
            case NORTH:
                return LICHEE_NORTH;
            case SOUTH:
                return LICHEE_SOUTH;
            case WEST:
                return LICHEE_WEST;
            case EAST:
                return LICHEE_EAST;
            default:
                return LICHEE_NORTH;
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
