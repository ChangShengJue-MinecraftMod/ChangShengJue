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

public class Mango extends NoBoxTypeBlock{
    protected static final VoxelShape NORTH_SHAPE = Block.box(3D, 0.0D, 7D, 12.25D, 5.0D, 10D);
    protected static final VoxelShape SOUTH_SHAPE = Block.box(3.75D, 0.0D, 6D, 13D, 5.0D, 9D);
    protected static final VoxelShape WEST_SHAPE = Block.box(7D, 0.0D, 3.75D, 10D, 5.0D, 13D);
    protected static final VoxelShape EAST_SHAPE = Block.box(6D, 0.0D, 3D, 9D, 5.0D, 12.25D);
    public static int fed = 0;
    public static float fedpro = 0.0F;

    public Mango(Properties pProperties, int fed, float fedpro) {
        super(pProperties, fed,fedpro);
        this.fed = fed;
        this.fedpro = fedpro;
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
                return EAST_SHAPE;
            default:
                return PLATE_SHAPE;
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
