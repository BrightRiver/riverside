package scorned.riverside.client.renderer.blockentity;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.PotDecorations;
import org.jspecify.annotations.Nullable;
import scorned.riverside.block.entity.PicklingVesselBlockEntity;

public class PicklingVesselRenderState extends BlockEntityRenderState {
    public float yRot;
    public PicklingVesselBlockEntity.@Nullable WobbleStyle wobbleStyle;
    public float wobbleProgress;
    public PotDecorations decorations;
    public Direction direction;

    public PicklingVesselRenderState() {
        this.decorations = PotDecorations.EMPTY;
        this.direction = Direction.NORTH;
    }
}
