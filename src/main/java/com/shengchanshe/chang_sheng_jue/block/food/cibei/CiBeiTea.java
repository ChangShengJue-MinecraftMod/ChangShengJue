package com.shengchanshe.chang_sheng_jue.block.food.cibei;

import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.event.DrunkennessManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber
public class CiBeiTea extends CiBeiTypeBlock{
    protected static final VoxelShape PLATE_SHAPE = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 5.0D, 10.5D);
    protected static final VoxelShape PIE_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(6.5D, 1.0D, 6.5D, 9.5D, 5.0D, 9.5D), BooleanOp.OR);
    protected int eff;
    protected int fed;
    protected float fedpro;

    // 存储玩家UUID和是否已减少醉酒状态的映射（针对CiBeiTea）
    private static final Map<UUID, Boolean> HAS_REDUCED_DRUNKENNESS = new HashMap<>();

    public CiBeiTea(BlockBehaviour.Properties properties, boolean hasLeftovers, int fed, float fedpro, int eff) {
        super(properties, hasLeftovers, fed, fedpro);
        this.eff = eff;
        this.fed = fed;
        this.fedpro = fedpro;
    }

    protected InteractionResult addFed(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, int fed, float fedpro) {
        super.addFed(level, pos, state, player, hand, this.fed, this.fedpro);

        // 为玩家添加效果
        if(eff == 1){
            player.addEffect(new MobEffectInstance(ChangShengJueEffects.BILUOCHUN_TEAS.get(), 1200, 0));
        }
        if(eff == 2){
            player.addEffect(new MobEffectInstance(ChangShengJueEffects.LONG_JING_TEAS.get(), 1200, 0));
        }
        DrunkennessManager.tryReduceDrunkenness(player);

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

    // 监听实体更新事件，当醉酒效果结束时清除标记
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            UUID playerUUID = player.getUUID();

            // 检查玩家是否有醉酒效果
            boolean hasDrunkenEffect = player.hasEffect(ChangShengJueEffects.DRUNKEN.get());

            // 如果玩家没有醉酒效果但有标记，则清除标记
            if (!hasDrunkenEffect && HAS_REDUCED_DRUNKENNESS.containsKey(playerUUID)) {
                HAS_REDUCED_DRUNKENNESS.remove(playerUUID);
            }
        }
    }
}