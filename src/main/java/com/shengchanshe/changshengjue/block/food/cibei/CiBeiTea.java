package com.shengchanshe.changshengjue.block.food.cibei;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CiBeiTea extends CiBeiTypeBlock{
    protected static final VoxelShape PLATE_SHAPE = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 5.0D, 10.5D);
    protected static final VoxelShape PIE_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(6.5D, 1.0D, 6.5D, 9.5D, 5.0D, 9.5D), BooleanOp.OR);
    protected static int eff;
    protected static int fed;
    protected static float fedpro;



    public CiBeiTea(BlockBehaviour.Properties properties, boolean hasLeftovers, int fed, float fedpro, int eff) {
        super(properties, hasLeftovers, fed, fedpro);
        this.eff = eff;
        this.fed = fed;
        this.fedpro = fedpro;
    }

    private void addEffect(MobEffect effect) {
    }

    protected InteractionResult addFed(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, int fed, float fedpro) {
        super.addFed(level, pos, state, player, hand, this.fed, this.fedpro);
        //为玩家添加效果
        if(eff == 1){
            player.addEffect(new MobEffectInstance(ChangShengJueEffects.BILUOCHUN_TEAS.get(), 1200, 0));
        }
        if(eff == 2){
            player.addEffect(new MobEffectInstance(ChangShengJueEffects.LONG_JING_TEAS.get(), 1200, 0));
        }

        return InteractionResult.SUCCESS;
    }


        @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(TYPES) == 0 ? PLATE_SHAPE : PIE_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPES);
    }

}
