package river.riverside.feature.stoneworks.blocks;

import com.mojang.math.OctahedralGroup;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class ShallowSlopeLower extends StairBlock {

    private static final VoxelShape SHAPE_OUTER =
            Shapes.or(
                    Block.box(0, 0, 0, 16, 1, 16),
                    Block.box(0, 1, 0, 14, 2, 14),
                    Block.box(0, 2, 0, 12, 3, 12),
                    Block.box(0, 3, 0, 10, 4, 10),
                    Block.box(0, 4, 0, 8, 5, 8),
                    Block.box(0, 5, 0, 6, 6, 6),
                    Block.box(0, 6, 0, 4, 7, 4),
                    Block.box(0, 7, 0, 2, 8, 2)

            );

    private static final VoxelShape SHAPE_STRAIGHT = Shapes.or(
                    Block.box(0, 0, 0, 16, 1, 16),
                    Block.box(0, 1, 0, 16, 2, 14),
                    Block.box(0, 2, 0, 16, 3, 12),
                    Block.box(0, 3, 0, 16, 4, 10),
                    Block.box(0, 4, 0, 16, 5, 8),
                    Block.box(0, 5, 0, 16, 6, 6),
                    Block.box(0, 6, 0, 16, 7, 4),
                    Block.box(0, 7, 0, 16, 8, 2)

    );
    private static final VoxelShape SHAPE_INNER = Shapes.or(SHAPE_STRAIGHT, Shapes.rotate(SHAPE_STRAIGHT, OctahedralGroup.BLOCK_ROT_Y_90));

    private static final Map<Direction, VoxelShape> SHAPE_BOTTOM_OUTER = Shapes.rotateHorizontal(SHAPE_OUTER);
    private static final Map<Direction, VoxelShape> SHAPE_BOTTOM_STRAIGHT = Shapes.rotateHorizontal(SHAPE_STRAIGHT);
    private static final Map<Direction, VoxelShape> SHAPE_BOTTOM_INNER = Shapes.rotateHorizontal(SHAPE_INNER);
    private static final Map<Direction, VoxelShape> SHAPE_TOP_OUTER = Shapes.rotateHorizontal(SHAPE_OUTER, OctahedralGroup.INVERT_Y);
    private static final Map<Direction, VoxelShape> SHAPE_TOP_STRAIGHT = Shapes.rotateHorizontal(SHAPE_STRAIGHT, OctahedralGroup.INVERT_Y);
    private static final Map<Direction, VoxelShape> SHAPE_TOP_INNER = Shapes.rotateHorizontal(SHAPE_INNER, OctahedralGroup.INVERT_Y);

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     *
     * @param baseState
     * @param properties
     */
    public ShallowSlopeLower(BlockState baseState, Properties properties) {
        super(baseState, properties);
    }

    @Override
    protected boolean useShapeForLightOcclusion(final BlockState state) {
        return true;
    }
    @Override
    protected VoxelShape getShape(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        boolean isBottom = state.getValue(HALF) == Half.BOTTOM;
        Direction facing = state.getValue(FACING);

        Map var10000 = switch ((StairsShape)state.getValue(SHAPE)) {
            case STRAIGHT -> isBottom ? SHAPE_BOTTOM_STRAIGHT : SHAPE_TOP_STRAIGHT;
            case OUTER_LEFT, OUTER_RIGHT -> isBottom ? SHAPE_BOTTOM_OUTER : SHAPE_TOP_OUTER;
            case INNER_RIGHT, INNER_LEFT -> isBottom ? SHAPE_BOTTOM_INNER : SHAPE_TOP_INNER;
        };

        return (VoxelShape)var10000.get(switch ((StairsShape)state.getValue(SHAPE)) {
            case STRAIGHT, OUTER_LEFT, INNER_RIGHT -> facing;
            case INNER_LEFT -> facing.getCounterClockWise();
            case OUTER_RIGHT -> facing.getClockWise();
        });
    }
}
