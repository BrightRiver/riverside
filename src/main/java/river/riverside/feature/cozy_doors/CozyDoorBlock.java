package river.riverside.feature.cozy_doors;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;

import java.util.Map;

public class CozyDoorBlock extends DoorBlock {

    private final Map<Direction, VoxelShape> CLOSED_SHAPES = Shapes.rotateHorizontal(
            Block.boxZ(16.0F, 16.0F, 14.0F, 16.0F)
    );
    private Map<Direction, VoxelShape> OPEN_LEFT_SHAPES = Shapes.rotateHorizontal(
                        Block.box(0.0F, 0.0F, 0.0F, 2F, 16.0F, 16.0F)
                );
    private Map<Direction, VoxelShape> OPEN_RIGHT_SHAPES = Shapes.rotateHorizontal(
                Block.box(14F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F)
    );

    public CozyDoorBlock(BlockSetType type, Properties properties) {
        super(type, properties);
    }

    @Override
    protected @NonNull VoxelShape getShape(
            BlockState state,
            @NonNull BlockGetter level,
            @NonNull BlockPos pos,
            @NonNull CollisionContext context
    ) {
        Direction direction = state.getValue(FACING);

        if (!state.getValue(OPEN)) {
            return CLOSED_SHAPES.get(direction);
        }

        if (state.getValue(HINGE) == DoorHingeSide.LEFT) {
            return OPEN_LEFT_SHAPES.get(direction);
        }

        return OPEN_RIGHT_SHAPES.get(direction);
    }

    @Override
    protected @NonNull BlockState updateShape(
            BlockState state,
            @NonNull LevelReader level,
            @NonNull ScheduledTickAccess ticks,
            @NonNull BlockPos pos,
            Direction directionToNeighbour,
            @NonNull BlockPos neighbourPos,
            @NonNull BlockState neighbourState,
            @NonNull RandomSource random
    ) {
        DoubleBlockHalf half = state.getValue(HALF);

        if (directionToNeighbour.getAxis() == Direction.Axis.Y
                && half == DoubleBlockHalf.LOWER == (directionToNeighbour == Direction.UP)) {

            return neighbourState.getBlock() instanceof DoorBlock
                    && neighbourState.getValue(HALF) != half
                    ? neighbourState.setValue(HALF, half)
                    : Blocks.AIR.defaultBlockState();

        } else {
            return half == DoubleBlockHalf.LOWER
                    && directionToNeighbour == Direction.DOWN
                    && !state.canSurvive(level, pos)
                    ? Blocks.AIR.defaultBlockState()
                    : super.updateShape(
                    state,
                    level,
                    ticks,
                    pos,
                    directionToNeighbour,
                    neighbourPos,
                    neighbourState,
                    random
            );
        }
    }

    public CozyDoorBlock shapeOpenLeft(Map<Direction, VoxelShape> shape) {
        OPEN_LEFT_SHAPES = shape;
        return this;
    }


    public CozyDoorBlock shapeOpenRight(Map<Direction, VoxelShape> shape) {
        OPEN_RIGHT_SHAPES = shape;
        return this;
    }

}