package river.riverside.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;

public class WoodTrim extends TransparentBlock {

    public static final EnumProperty<Direction> FACING =
            HorizontalDirectionalBlock.FACING;

    public static final BooleanProperty OUTER_EAST =
            BooleanProperty.create("outer_east");

    public static final BooleanProperty OUTER_WEST =
            BooleanProperty.create("outer_west");

    public static final BooleanProperty OUTER_UPPER =
            BooleanProperty.create("outer_upper");

    public static final BooleanProperty OUTER_LOWER =
            BooleanProperty.create("outer_lower");

    /*
     * Inner variants:
     *
     * 0 = off
     * 1 = diagonal_left
     * 2 = diagonal_right
     * 3 = diagonal_left_upper
     * 4 = diagonal_right_upper
     * 5 = diagonal_left_lower
     * 6 = diagonal_right_lower
     * 7 = center_vertical
     * 8 = center_horizontal
     * 9 = center_cross
     */
    public static final IntegerProperty INNER =
            IntegerProperty.create("inner", 0, 9);

    /*
     * Thin collision/selection planes.
     *
     * The trim models are currently built on the north plane,
     * so these correspond to the four possible faces.
     */
    private static final VoxelShape NORTH_SHAPE =
            Block.box(0, 0, 0, 16, 16, 1);

    private static final VoxelShape SOUTH_SHAPE =
            Block.box(0, 0, 15, 16, 16, 16);

    private static final VoxelShape WEST_SHAPE =
            Block.box(0, 0, 0, 1, 16, 16);

    private static final VoxelShape EAST_SHAPE =
            Block.box(15, 0, 0, 16, 16, 16);

    public WoodTrim(BlockBehaviour.Properties properties) {
        super(properties);

        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(OUTER_EAST, true)
                        .setValue(OUTER_WEST, true)
                        .setValue(OUTER_UPPER, true)
                        .setValue(OUTER_LOWER, true)
                        .setValue(INNER, 0)
        );
    }

    @Override
    protected @NonNull VoxelShape getBlockSupportShape(
            @NonNull BlockState state,
            @NonNull BlockGetter level,
            @NonNull BlockPos pos
    ) {
        return Shapes.empty();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {

        Direction clickedFace = context.getClickedFace();

        /*
         * We currently only support the four vertical planes.
         * If placed on the floor/ceiling, use the player's
         * horizontal direction instead.
         */
        if (clickedFace.getAxis().isVertical()) {
            clickedFace = context.getHorizontalDirection();
        } else {
            /*
             * getClickedFace() describes the face of the block
             * being clicked, so the trim itself faces the opposite
             * direction.
             */
            clickedFace = clickedFace.getOpposite();
        }

        return this.defaultBlockState()
                .setValue(FACING, clickedFace);
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(
            @NonNull BlockState state,
            Level level,
            @NonNull BlockPos pos,
            @NonNull Player player,
            @NonNull BlockHitResult hit
    ) {
        if (!level.isClientSide()) {

            /*
             * SHIFT + RIGHT CLICK
             *
             * Treat the four outer BooleanProperties as
             * four bits and cycle through all 16 combinations.
             */
            if (player.isShiftKeyDown()) {

                int outerState = 0;

                if (state.getValue(OUTER_EAST)) {
                    outerState |= 1;
                }

                if (state.getValue(OUTER_WEST)) {
                    outerState |= 2;
                }

                if (state.getValue(OUTER_UPPER)) {
                    outerState |= 4;
                }

                if (state.getValue(OUTER_LOWER)) {
                    outerState |= 8;
                }

                outerState = (outerState + 1) % 16;

                level.setBlock(
                        pos,
                        state
                                .setValue(
                                        OUTER_EAST,
                                        (outerState & 1) != 0
                                )
                                .setValue(
                                        OUTER_WEST,
                                        (outerState & 2) != 0
                                )
                                .setValue(
                                        OUTER_UPPER,
                                        (outerState & 4) != 0
                                )
                                .setValue(
                                        OUTER_LOWER,
                                        (outerState & 8) != 0
                                ),
                        Block.UPDATE_ALL
                );

            } else {

                /*
                 * RIGHT CLICK
                 *
                 * Cycle through the inner variants.
                 */
                int currentInner = state.getValue(INNER);
                int nextInner = (currentInner + 1) % 10;

                level.setBlock(
                        pos,
                        state.setValue(INNER, nextInner),
                        Block.UPDATE_ALL
                );
            }
        }

        return InteractionResult.SUCCESS;
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
    protected @NonNull BlockState mirror(
            BlockState state,
            Mirror mirror
    ) {
        return state.rotate(
                mirror.getRotation(state.getValue(FACING))
        );
    }

    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<Block, BlockState> builder
    ) {
        builder.add(
                FACING,
                OUTER_EAST,
                OUTER_WEST,
                OUTER_UPPER,
                OUTER_LOWER,
                INNER
        );
    }

    @Override
    protected @NonNull VoxelShape getShape(
            @NonNull BlockState state,
            @NonNull BlockGetter level,
            @NonNull BlockPos pos,
            @NonNull CollisionContext context
    ) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST -> EAST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }
}