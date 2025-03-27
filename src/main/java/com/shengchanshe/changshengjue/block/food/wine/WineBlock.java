package com.shengchanshe.changshengjue.block.food.wine;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.block.food.TypeBlock;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WineBlock extends TypeBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final VoxelShape PLATE_SHAPE = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 5.0D, 10.5D);
    protected static final VoxelShape PIE_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(6.5D, 1.0D, 6.5D, 9.5D, 5.0D, 9.5D), BooleanOp.OR);


    public WineBlock(BlockBehaviour.Properties properties, boolean hasLeftovers, int nutrition, float saturationMod) {
        super(properties, hasLeftovers, nutrition, saturationMod);
    }

    protected InteractionResult addFed(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, int fed, float fedpro) {
        int types = state.getValue(getTYPE());
        if(fed == 0 && fedpro == 0){
            player.displayClientMessage(Component.translatable("block.changshengjue.fen_jiu.no_wine"), true);
        }
        if(fed != 0 && fedpro != 0) {
            if (types > 0) {
                //如果玩家饥饿值满且物品等级不为0
                if (player.getFoodData().getFoodLevel() < 20 || player.isCreative()) {
                    level.setBlock(pos, state.setValue(getTYPE(), 0), 3);
                    // 增加饥饿值
                    player.getFoodData().eat(fed, fedpro);
                    level.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
                }
            } else if (types == 0) {
                player.displayClientMessage(Component.translatable("block.changshengjue.fen_jiu.no_wine"), true);
                return InteractionResult.SUCCESS;
            }
            if (!level.isClientSide) {
                if (player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) || player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get()) || player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get())){
                    if (state.getBlock() == ChangShengJueBlocks.SHI_LI_XIANG.get() || state.getBlock() == ChangShengJueBlocks.WHEAT_NUGGETS_TRIBUTE_WINE.get() || state.getBlock() == ChangShengJueBlocks.FEN_JIU.get()){
                        player.addEffect(new MobEffectInstance(ChangShengJueEffects.DRUNKEN.get(),1600),player);
                    }
                }
                if (state.getBlock() == ChangShengJueBlocks.FEN_JIU.get()){
                    if (!player.hasEffect(ChangShengJueEffects.FEN_JIU.get())){
                        player.addEffect(new MobEffectInstance(ChangShengJueEffects.FEN_JIU.get(), 1200), player);
                        player.removeEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get());
                        player.removeEffect(ChangShengJueEffects.SHI_LI_XIANG.get());
                    }
                }else if (state.getBlock() == ChangShengJueBlocks.WHEAT_NUGGETS_TRIBUTE_WINE.get()){
                    if (!player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get())){
                        player.addEffect(new MobEffectInstance(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get(), 1200), player);
                        player.removeEffect(ChangShengJueEffects.FEN_JIU.get());
                        player.removeEffect(ChangShengJueEffects.SHI_LI_XIANG.get());
                    }
                }else if (state.getBlock() == ChangShengJueBlocks.SHI_LI_XIANG.get()){
                    if (!player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get())){
                        player.addEffect(new MobEffectInstance(ChangShengJueEffects.SHI_LI_XIANG.get(), 1200), player);
                        player.removeEffect(ChangShengJueEffects.FEN_JIU.get());
                        player.removeEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get());
                    }
                }
            }
            if(state.getBlock() == ChangShengJueBlocks.FEN_JIU.get()) {
                level.setBlock(pos, ChangShengJueBlocks.EMPTY_FEN_JIU.get().defaultBlockState(), 3);
            }
            if(state.getBlock() == ChangShengJueBlocks.SHI_LI_XIANG.get()) {
                level.setBlock(pos, ChangShengJueBlocks.EMPTY_SHI_LI_XIANG.get().defaultBlockState(), 3);
            }
            if(state.getBlock() == ChangShengJueBlocks.WHEAT_NUGGETS_TRIBUTE_WINE.get()) {
                level.setBlock(pos, ChangShengJueBlocks.EMPTY_WHEAT_NUGGETS_TRIBUTE_WINE.get().defaultBlockState(), 3);
            }
        }
        return InteractionResult.PASS;
    }


        @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(TYPES) == 0 ? PLATE_SHAPE : PIE_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPES);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

}
