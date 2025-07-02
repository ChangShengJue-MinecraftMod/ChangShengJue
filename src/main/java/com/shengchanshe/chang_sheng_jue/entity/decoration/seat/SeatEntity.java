package com.shengchanshe.chang_sheng_jue.entity.decoration.seat;

import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class SeatEntity extends Entity {
    public SeatEntity(Level level) {
        super(ChangShengJueEntity.SEAT.get(), level);
        this.noPhysics = true;
    }

    private SeatEntity(Level level, BlockPos pos, double yOffset, Direction direction) {
        this(level);
        this.setPos(pos.getX() + 0.5, pos.getY() + yOffset, pos.getZ() + 0.5);
        this.setRot(direction.getOpposite().toYRot(), 0F);
    }

    @Override
    public void tick()
    {
        super.tick();
        if(!this.level().isClientSide) {
            if(this.getPassengers().isEmpty() || this.level().isEmptyBlock(this.blockPosition())) {
                this.remove(RemovalReason.DISCARDED);
                this.level().updateNeighbourForOutputSignal(blockPosition(), this.level().getBlockState(blockPosition()).getBlock());
            }
        }
    }

    public static InteractionResult useOn(Level level, BlockPos pos, double yOffset, Player player, Direction direction) {
        if(!level.isClientSide()) {
            List<SeatEntity> seats = level.getEntitiesOfClass(SeatEntity.class, new AABB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0, pos.getY() + 1.0, pos.getZ() + 1.0));
            if(seats.isEmpty()) {
                SeatEntity seat = new SeatEntity(level, pos, yOffset, direction);
                level.addFreshEntity(seat);
                player.startRiding(seat, false);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }
}
