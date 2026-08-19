package com.shengchanshe.chang_sheng_jue.block.custom.plaque;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PlaqueTextLayout {
    public static final int MAX_TEXT_LENGTH = 256;

    private PlaqueTextLayout() {
    }

    public static int getCapacity(Level level, BlockPos origin) {
        Segment segment = findSegment(level, origin);
        return segment == null || resolveEntities(level, segment.positions()) == null
                ? 0
                : segment.positions().size();
    }

    public static String read(Level level, BlockPos origin) {
        Segment segment = findSegment(level, origin);
        if (segment == null) {
            return "";
        }

        List<PlaqueEntity> plaques = resolveEntities(level, segment.positions());
        if (plaques == null) {
            return "";
        }

        StringBuilder text = new StringBuilder(segment.positions().size());
        for (PlaqueEntity plaque : plaques) {
            String storedText = plaque.getText();
            if (!storedText.isEmpty() && text.length() < MAX_TEXT_LENGTH) {
                text.append(storedText.charAt(0));
            }
        }
        return text.toString();
    }

    public static boolean write(ServerLevel level, BlockPos origin, String text) {
        if (text == null || text.length() > MAX_TEXT_LENGTH) {
            return false;
        }

        Segment segment = findSegment(level, origin);
        if (segment == null || text.length() > segment.positions().size()) {
            return false;
        }

        List<PlaqueEntity> plaques = resolveEntities(level, segment.positions());
        if (plaques == null) {
            return false;
        }

        for (int index = 0; index < plaques.size(); index++) {
            plaques.get(index).setText(index < text.length() ? String.valueOf(text.charAt(index)) : "");
        }
        return true;
    }

    private static Segment findSegment(Level level, BlockPos origin) {
        if (level == null || origin == null || !level.hasChunkAt(origin)) {
            return null;
        }

        BlockState originState = level.getBlockState(origin);
        if (!(originState.getBlock() instanceof Plaque plaque) || !originState.hasProperty(Plaque.FACING)) {
            return null;
        }

        Direction facing = originState.getValue(Plaque.FACING);
        List<BlockPos> left = scan(level, origin, plaque.leftOf(facing), plaque, facing);
        if (left == null || left.size() >= MAX_TEXT_LENGTH) {
            return null;
        }

        List<BlockPos> right = scan(level, origin, plaque.rightOf(facing), plaque, facing);
        if (right == null || left.size() + 1 + right.size() > MAX_TEXT_LENGTH) {
            return null;
        }

        Collections.reverse(left);
        List<BlockPos> positions = new ArrayList<>(left.size() + 1 + right.size());
        positions.addAll(left);
        positions.add(origin.immutable());
        positions.addAll(right);
        return new Segment(List.copyOf(positions));
    }

    private static List<BlockPos> scan(Level level, BlockPos origin, Direction direction, Plaque plaque,
                                       Direction facing) {
        List<BlockPos> positions = new ArrayList<>();
        BlockPos cursor = origin;
        for (int index = 0; index < MAX_TEXT_LENGTH; index++) {
            cursor = cursor.relative(direction);
            // 未加载区域不能被当作实体段边界，否则客户端可能提交局部文本并清空服务端远端文字。
            if (!level.hasChunkAt(cursor)) {
                return null;
            }
            if (!isConnected(level, cursor, plaque, facing)) {
                break;
            }
            positions.add(cursor.immutable());
        }
        return positions;
    }

    private static boolean isConnected(Level level, BlockPos pos, Plaque plaque, Direction facing) {
        BlockState state = level.getBlockState(pos);
        return state.getBlock() == plaque
                && state.hasProperty(Plaque.FACING)
                && state.getValue(Plaque.FACING) == facing;
    }

    private static List<PlaqueEntity> resolveEntities(Level level, List<BlockPos> positions) {
        List<PlaqueEntity> plaques = new ArrayList<>(positions.size());
        for (BlockPos pos : positions) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (!(blockEntity instanceof PlaqueEntity plaque)) {
                return null;
            }
            plaques.add(plaque);
        }
        return plaques;
    }

    private record Segment(List<BlockPos> positions) {
    }
}
