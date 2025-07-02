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

public class Banana extends NoBoxTypeBlock{

//    protected static final VoxelShape PLATE_BANANA = Block.box(1D, 0.0D, 4D, 12.82D, 4.25D, 12D);
    protected static final VoxelShape BANANA_WEST = Block.box(1.0D, 0.0D, 4D, 15.2D, 4.25D, 12D);
    protected static final VoxelShape BANANA_EAST = Block.box(0.8D, 0.0D, 4D, 15.0D, 4.25D, 12D);
    protected static final VoxelShape BANANA_SOUTH = Block.box(4D, 0.0D, 3.0D, 12D, 4.25D, 15.5D);
    protected static final VoxelShape BANANA_NORTH = Block.box(4D, 0.0D, 3.0D, 12D, 4.25D, 15.5D);
    public static int fed = 0;
    public static float fedpro = 0.0F;



    public Banana(Properties pProperties, int fed, float fedpro) {
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
                return BANANA_NORTH;
            case SOUTH:
                return BANANA_SOUTH;
            case WEST:
                return BANANA_WEST;
            case EAST:
                return BANANA_EAST;
            default:
                return BANANA_NORTH; // 默认情况
        }
    }

}
