package river.riverside.feature.stoneworks.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.util.RandomSource;
import org.jspecify.annotations.NonNull;

public class Coping extends TransparentBlock {

    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");

    public Coping(Properties properties) {
        super(properties);

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false));
    }

    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<Block, BlockState> builder
    ) {
        builder.add(NORTH, EAST, SOUTH, WEST);
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
        if (directionToNeighbour.getAxis().isHorizontal()) {
            return updateConnections(state, level, pos);
        }

        return super.updateShape(
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

    private static BlockState updateConnections(
            BlockState state,
            BlockGetter level,
            BlockPos pos
    ) {
        return state
                .setValue(NORTH, isCoping(level.getBlockState(pos.north())))
                .setValue(EAST, isCoping(level.getBlockState(pos.east())))
                .setValue(SOUTH, isCoping(level.getBlockState(pos.south())))
                .setValue(WEST, isCoping(level.getBlockState(pos.west())));
    }

    private static boolean isCoping(BlockState state) {
        return state.getBlock() instanceof Coping;
    }
}