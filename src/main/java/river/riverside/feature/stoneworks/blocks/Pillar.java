package river.riverside.feature.stoneworks.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;

public class Pillar extends TransparentBlock  {

//    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
private static final VoxelShape SHAPE = Block.box(
        1, 0, 1,
        15, 16, 15
);

    public Pillar(Properties properties) {
        super(properties);
    }
    @Override
    protected boolean useShapeForLightOcclusion(final BlockState state) {
        return true;
    }

    @Override
    protected @NonNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter level, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        return SHAPE;
    }


}
