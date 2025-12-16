package com.shengchanshe.chang_sheng_jue.block.custom.balustrade;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Iterator;
import java.util.Map;

public class StoneBalustrade extends WallBlock {
    private final Map<BlockState, VoxelShape> shapeByIndex;
    private final Map<BlockState, VoxelShape> collisionShapeByIndex;

    public StoneBalustrade(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(UP, true)
                .setValue(NORTH_WALL, WallSide.NONE).setValue(EAST_WALL, WallSide.NONE)
                .setValue(SOUTH_WALL, WallSide.NONE).setValue(WEST_WALL, WallSide.NONE)
                .setValue(WATERLOGGED, false));
        this.shapeByIndex = this.makeShapes(3.03F, 3.0F, 16.0F, 0.0F, 11.0F, 11.0F);
        this.collisionShapeByIndex = this.makeShapes(4.0F, 3.0F, 24.0F, 0.0F, 24.0F, 24.0F);
    }

    private static VoxelShape applyWallShape(VoxelShape pBaseShape, WallSide pHeight, VoxelShape pLowShape, VoxelShape pTallShape) {
        if (pHeight == WallSide.TALL) {
            return Shapes.or(pBaseShape, pTallShape);
        } else {
            return pHeight == WallSide.LOW ? Shapes.or(pBaseShape, pLowShape) : pBaseShape;
        }
    }

    private Map<BlockState, VoxelShape> makeShapes(float pWidth, float pDepth, float pWallPostHeight, float pWallMinY, float pWallLowHeight, float pWallTallHeight) {
        float $$6 = 8.0F - pWidth;
        float $$7 = 8.0F + pWidth;
        float $$8 = 8.0F - pDepth;
        float $$9 = 8.0F + pDepth;
        VoxelShape $$10 = Block.box($$6, 0.0, $$6, $$7, pWallPostHeight, $$7);
        VoxelShape $$11 = Block.box($$8, pWallMinY, 0.0, $$9, pWallLowHeight, $$9);
        VoxelShape $$12 = Block.box($$8, pWallMinY, $$8, $$9, pWallLowHeight, 16.0);
        VoxelShape $$13 = Block.box(0.0, pWallMinY, $$8, $$9, pWallLowHeight, $$9);
        VoxelShape $$14 = Block.box($$8, pWallMinY, $$8, 16.0, pWallLowHeight, $$9);
        VoxelShape $$15 = Block.box($$8, pWallMinY, 0.0, $$9, pWallTallHeight, $$9);
        VoxelShape $$16 = Block.box($$8, pWallMinY, $$8, $$9, pWallTallHeight, 16.0);
        VoxelShape $$17 = Block.box(0.0, pWallMinY, $$8, $$9, pWallTallHeight, $$9);
        VoxelShape $$18 = Block.box($$8, pWallMinY, $$8, 16.0, pWallTallHeight, $$9);
        ImmutableMap.Builder<BlockState, VoxelShape> $$19 = ImmutableMap.builder();
        Iterator var21 = UP.getPossibleValues().iterator();

        while(var21.hasNext()) {
            Boolean $$20 = (Boolean)var21.next();
            Iterator var23 = EAST_WALL.getPossibleValues().iterator();

            while(var23.hasNext()) {
                WallSide $$21 = (WallSide)var23.next();
                Iterator var25 = NORTH_WALL.getPossibleValues().iterator();

                while(var25.hasNext()) {
                    WallSide $$22 = (WallSide)var25.next();
                    Iterator var27 = WEST_WALL.getPossibleValues().iterator();

                    while(var27.hasNext()) {
                        WallSide $$23 = (WallSide)var27.next();
                        Iterator var29 = SOUTH_WALL.getPossibleValues().iterator();

                        while(var29.hasNext()) {
                            WallSide $$24 = (WallSide)var29.next();
                            VoxelShape $$25 = Shapes.empty();
                            $$25 = applyWallShape($$25, $$21, $$14, $$18);
                            $$25 = applyWallShape($$25, $$23, $$13, $$17);
                            $$25 = applyWallShape($$25, $$22, $$11, $$15);
                            $$25 = applyWallShape($$25, $$24, $$12, $$16);
                            if ($$20) {
                                $$25 = Shapes.or($$25, $$10);
                            }

                            BlockState $$26 = this.defaultBlockState().setValue(UP, $$20).setValue(EAST_WALL, $$21).setValue(WEST_WALL, $$23).setValue(NORTH_WALL, $$22).setValue(SOUTH_WALL, $$24);
                            $$19.put($$26.setValue(WATERLOGGED, false), $$25);
                            $$19.put($$26.setValue(WATERLOGGED, true), $$25);
                        }
                    }
                }
            }
        }

        return $$19.build();
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return this.shapeByIndex.get(pState);
    }

    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return this.collisionShapeByIndex.get(pState);
    }

    private static boolean isCovered(VoxelShape pFirstShape, VoxelShape pSecondShape) {
        return !Shapes.joinIsNotEmpty(pSecondShape, pFirstShape, BooleanOp.ONLY_FIRST);
    }

    private boolean connectsTo(BlockState pState, boolean pSideSolid, Direction pDirection) {
        Block $$3 = pState.getBlock();
        boolean $$4 = $$3 instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(pState, pDirection);
        return pState.is(BlockTags.WALLS) || !isExceptionForConnection(pState) && pSideSolid || $$3 instanceof IronBarsBlock || $$4;
    }


    private WallSide makeWallState(boolean pAllowConnection, VoxelShape pShape, VoxelShape pNeighbourShape) {
        if (pAllowConnection) {
            return isCovered(pShape, pNeighbourShape) ? WallSide.TALL : WallSide.LOW;
        } else {
            return WallSide.NONE;
        }
    }
}