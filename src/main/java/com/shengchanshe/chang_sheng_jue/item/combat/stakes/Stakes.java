package com.shengchanshe.chang_sheng_jue.item.combat.stakes;

import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.combat.stakes.StakesEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.function.Consumer;

public class Stakes extends Item {
    public Stakes() {
        super(new Properties());
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Direction pContextClickedFace = pContext.getClickedFace();
        if (pContextClickedFace == Direction.DOWN) {
            return InteractionResult.FAIL;
        } else {
            Level pContextLevel = pContext.getLevel();
            BlockPlaceContext placeContext = new BlockPlaceContext(pContext);
            BlockPos clickedPos = placeContext.getClickedPos();
            ItemStack itemInHand = pContext.getItemInHand();
            Vec3 vec3 = Vec3.atBottomCenterOf(clickedPos);
            AABB aabb = ChangShengJueEntity.STAKES.get().getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());
            if (pContextLevel.noCollision(null, aabb) && pContextLevel.getEntities(null, aabb).isEmpty()) {
                if (pContextLevel instanceof ServerLevel pContextLevel1) {
                    Consumer<StakesEntity> defaultStackConfig = EntityType.createDefaultStackConfig(pContextLevel1, itemInHand, pContext.getPlayer());
                    StakesEntity stakesEntity = ChangShengJueEntity.STAKES.get().create(pContextLevel1, itemInHand.getTag(),
                            defaultStackConfig, clickedPos, MobSpawnType.SPAWN_EGG,
                            true, true);
                    if (stakesEntity == null) {
                        return InteractionResult.FAIL;
                    }

                    float $$11 = (float) Mth.floor((Mth.wrapDegrees(pContext.getRotation() - 180.0F) + 22.5F) / 45.0F) * 45.0F;
                    stakesEntity.moveTo(stakesEntity.getX(), stakesEntity.getY(), stakesEntity.getZ(), $$11, 0.0F);
                    pContextLevel1.addFreshEntityWithPassengers(stakesEntity);
                    pContextLevel.playSound(null, stakesEntity.getX(), stakesEntity.getY(), stakesEntity.getZ(),
                            SoundEvents.ARMOR_STAND_PLACE, SoundSource.BLOCKS, 0.75F, 0.8F);
                    stakesEntity.gameEvent(GameEvent.ENTITY_PLACE, pContext.getPlayer());
                }

                itemInHand.shrink(1);
                return InteractionResult.sidedSuccess(pContextLevel.isClientSide);
            } else {
                return InteractionResult.FAIL;
            }
        }
    }
}
