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

public class Corn extends NoBoxTypeBlock{
//    protected static final VoxelShape PLATE_SHAPE = Block.box(3.5D, 0.0D, 5.5D, 12.5D, 5.0D, 10.5D);

    protected static final VoxelShape CORN_EAST = Block.box(3.5D, 0.0D, 5.5D, 12.5D, 5.0D, 10.5D);
    protected static final VoxelShape CORN_SOUTH = Block.box(5.5D, 0.0D, 3.5D, 10.5D, 5.0D, 12.5D);
    protected static final VoxelShape CORN_WEST = Block.box(3.5D, 0.0D, 5.5D, 12.5D, 5.0D, 10.5D);
    protected static final VoxelShape CORN_NORTH = Block.box(5.5D, 0.0D, 3.5D, 10.5D, 5.0D, 12.5D);
    public static int fed = 0;
    public static float fedpro = 0.0F;


    public Corn(Properties pProperties, int fed, float fedpro) {
        super(pProperties, fed,fedpro);
        this.fed = fed;
        this.fedpro = fedpro;
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

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        switch (direction) {
            case NORTH:
                return CORN_NORTH;
            case SOUTH:
                return CORN_SOUTH;
            case WEST:
                return CORN_WEST;
            case EAST:
                return CORN_EAST;
            default:
                return CORN_NORTH; // 默认情况
        }
    }



}
