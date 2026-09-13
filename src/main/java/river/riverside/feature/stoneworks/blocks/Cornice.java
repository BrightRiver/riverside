package river.riverside.feature.stoneworks.blocks;

import com.mojang.math.OctahedralGroup;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;

import java.util.Map;

public class Cornice extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<StairsShape> SHAPE = EnumProperty.create(
            "shape",
            StairsShape.class,
            StairsShape.STRAIGHT,
            StairsShape.INNER_LEFT,
            StairsShape.INNER_RIGHT,
            StairsShape.OUTER_LEFT,
            StairsShape.OUTER_RIGHT
    );

    private static final VoxelShape SHAPE_STRAIGHT = Shapes.or(
            Block.box(0, 0, 0, 16, 2, 16),
            Block.box(0, 2, 0, 16, 4, 14),
            Block.box(0, 4, 0, 16, 5, 12),
            Block.box(0, 5, 0, 16, 9, 10),
            Block.box(0, 9, 0, 16, 10, 9),
            Block.box(0, 10, 0, 16, 11, 8),
            Block.box(0, 11, 0, 16, 13, 5),
            Block.box(0, 13, 0, 16, 14, 4),
            Block.box(0, 14, 0, 16, 16, 2)
    );

    private static final VoxelShape SHAPE_OUTER = Shapes.or(
            Block.box(0, 0, 0, 16, 2, 16),
            Block.box(0, 2, 0, 14, 4, 14),
            Block.box(0, 4, 0, 12, 5, 12),
            Block.box(0, 5, 0, 10, 9, 10),
            Block.box(0, 9, 0, 9, 10, 9),
            Block.box(0, 10, 0, 8, 11, 8),
            Block.box(0, 11, 0, 5, 13, 5),
            Block.box(0, 13, 0, 4, 14, 4),
            Block.box(0, 14, 0, 2, 16, 2)
    );

    private static final VoxelShape SHAPE_INNER = Shapes.or(
            SHAPE_STRAIGHT,
            Shapes.rotate(SHAPE_STRAIGHT, OctahedralGroup.BLOCK_ROT_Y_90)
    );

    private static final Map<Direction, VoxelShape> SHAPE_TOP_OUTER =
            Shapes.rotateHorizontal(SHAPE_OUTER, OctahedralGroup.INVERT_Y);

    private static final Map<Direction, VoxelShape> SHAPE_TOP_STRAIGHT =
            Shapes.rotateHorizontal(SHAPE_STRAIGHT, OctahedralGroup.INVERT_Y);

    private static final Map<Direction, VoxelShape> SHAPE_TOP_INNER =
            Shapes.rotateHorizontal(SHAPE_INNER, OctahedralGroup.INVERT_Y);

    public Cornice(Properties properties) {
        super(properties);

        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(SHAPE, StairsShape.STRAIGHT)
        );
    }

    @Override
    protected boolean useShapeForLightOcclusion(final BlockState state) {
        return true;
    }

    @Override
    protected @NonNull VoxelShape getShape(
            BlockState state,
            @NonNull BlockGetter level,
            @NonNull BlockPos pos,
            @NonNull CollisionContext context
    ) {
        Map<Direction, VoxelShape> shapes = switch (state.getValue(SHAPE)) {
            case STRAIGHT -> SHAPE_TOP_STRAIGHT;
            case OUTER_LEFT, OUTER_RIGHT -> SHAPE_TOP_OUTER;
            case INNER_LEFT, INNER_RIGHT -> SHAPE_TOP_INNER;
        };

        return shapes.get(
                switch (state.getValue(SHAPE)) {
                    case STRAIGHT, OUTER_LEFT, INNER_RIGHT -> state.getValue(FACING);
                    case INNER_LEFT -> state.getValue(FACING).getCounterClockWise();
                    case OUTER_RIGHT -> state.getValue(FACING).getClockWise();
                }
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getHorizontalDirection();

        BlockState state = this.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(
                        WATERLOGGED,
                        context.getLevel()
                                .getFluidState(context.getClickedPos())
                                .getType() == Fluids.WATER
                );

        return state.setValue(
                SHAPE,
                getCorniceShape(state, context.getLevel(), context.getClickedPos())
        );
    }

    @Override
    protected @NonNull BlockState updateShape(
            @NonNull BlockState state,
            @NonNull LevelReader level,
            @NonNull ScheduledTickAccess ticks,
            @NonNull BlockPos pos,
            @NonNull Direction directionToNeighbour,
            @NonNull BlockPos neighbourPos,
            @NonNull BlockState neighbourState,
            @NonNull RandomSource random
    ) {
        if (state.getValue(WATERLOGGED)) {
            ticks.scheduleTick(
                    pos,
                    Fluids.WATER,
                    Fluids.WATER.getTickDelay(level)
            );
        }

        return directionToNeighbour.getAxis().isHorizontal()
                ? state.setValue(
                SHAPE,
                getCorniceShape(state, level, pos)
        )
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

    private static StairsShape getCorniceShape(
            BlockState state,
            BlockGetter level,
            BlockPos pos
    ) {
        Direction facing = state.getValue(FACING);

        BlockState behindState =
                level.getBlockState(pos.relative(facing));

        if (isCornice(behindState)) {
            Direction behindFacing = behindState.getValue(FACING);

            if (behindFacing.getAxis() != facing.getAxis()
                    && canTakeShape(
                    state,
                    level,
                    pos,
                    behindFacing.getOpposite()
            )) {

                if (behindFacing == facing.getCounterClockWise()) {
                    return StairsShape.OUTER_LEFT;
                }

                return StairsShape.OUTER_RIGHT;
            }
        }

        BlockState frontState =
                level.getBlockState(pos.relative(facing.getOpposite()));

        if (isCornice(frontState)) {
            Direction frontFacing = frontState.getValue(FACING);

            if (frontFacing.getAxis() != facing.getAxis()
                    && canTakeShape(
                    state,
                    level,
                    pos,
                    frontFacing
            )) {

                if (frontFacing == facing.getCounterClockWise()) {
                    return StairsShape.INNER_LEFT;
                }

                return StairsShape.INNER_RIGHT;
            }
        }

        return StairsShape.STRAIGHT;
    }

    private static boolean canTakeShape(
            BlockState state,
            BlockGetter level,
            BlockPos pos,
            Direction neighbour
    ) {
        BlockState neighbourState =
                level.getBlockState(pos.relative(neighbour));

        return !isCornice(neighbourState)
                || neighbourState.getValue(FACING) != state.getValue(FACING);
    }

    public static boolean isCornice(BlockState state) {
        return state.getBlock() instanceof Cornice;
    }

    @Override
    protected @NonNull BlockState rotate(
            BlockState state,
            Rotation rotation
    ) {
        return state.setValue(
                FACING,
                rotation.rotate(state.getValue(FACING))
        );
    }

    @Override
    protected @NonNull BlockState mirror(final BlockState state, final Mirror mirror) {
        Direction direction = state.getValue(FACING);
        StairsShape shape = state.getValue(SHAPE);
        switch (mirror) {
            case LEFT_RIGHT:
                if (direction.getAxis() == Direction.Axis.Z) {
                    return switch (shape) {
                        case OUTER_LEFT ->
                                state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT);
                        case INNER_RIGHT ->
                                state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT);
                        case INNER_LEFT ->
                                state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT);
                        case OUTER_RIGHT ->
                                state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT);
                        default -> state.rotate(Rotation.CLOCKWISE_180);
                    };
                }
                break;
            case FRONT_BACK:
                if (direction.getAxis() == Direction.Axis.X) {
                    return switch (shape) {
                        case STRAIGHT -> state.rotate(Rotation.CLOCKWISE_180);
                        case OUTER_LEFT ->
                                state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT);
                        case INNER_RIGHT ->
                                state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT);
                        case INNER_LEFT -> state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT);
                        case OUTER_RIGHT ->
                                state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT);
                    };
                }
        }

        return super.mirror(state, mirror);
    }

    @Override
    protected @NonNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED)
                ? Fluids.WATER.getSource(false)
                : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<Block, BlockState> builder
    ) {
        builder.add(FACING, SHAPE, WATERLOGGED);
    }
}