package river.riverside.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;

public class Cover extends TransparentBlock {

    public static final EnumProperty<Direction> FACING =
            HorizontalDirectionalBlock.FACING;

    public static final IntegerProperty VARIANT =
            IntegerProperty.create("variant", 0, 3);

    private final int variantCount;

    private static final VoxelShape NORTH_SHAPE =
            Block.box(0, 1, 0, 16, 16, 0.1);

    private static final VoxelShape SOUTH_SHAPE =
            Block.box(0, 1, 15.9, 16, 16, 16);

    private static final VoxelShape WEST_SHAPE =
            Block.box(0, 1, 0, 0.9, 16, 16);

    private static final VoxelShape EAST_SHAPE =
            Block.box(15.9, 1, 0, 16, 16, 16);

    public Cover(BlockBehaviour.Properties properties, int variantCount) {
        super(properties);

        this.variantCount = variantCount;

        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(VARIANT, 0)
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection());
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
            int currentVariant = state.getValue(VARIANT);
            int nextVariant = (currentVariant + 1) % variantCount;

            level.setBlock(
                    pos,
                    state.setValue(VARIANT, nextVariant),
                    Block.UPDATE_ALL
            );
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected @NonNull BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(
                FACING,
                rotation.rotate(state.getValue(FACING))
        );
    }

    @Override
    protected @NonNull BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<Block, BlockState> builder
    ) {
        builder.add(FACING, VARIANT);
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