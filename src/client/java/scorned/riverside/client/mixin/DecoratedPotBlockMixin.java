package scorned.riverside.client.mixin;


import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import scorned.riverside.block.ModBlocks;
import scorned.riverside.block.PicklingVesselBlock;
import scorned.riverside.block.entity.PicklingVesselBlockEntity;

@Mixin(DecoratedPotBlock.class)
public class DecoratedPotBlockMixin {
    @Inject(
            method = "useItemOn",
            at = @At("HEAD"),
            cancellable = true
    )
    protected void useItemOn(
            ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult, CallbackInfoReturnable<InteractionResult> cir
    ) {

        if (itemStack.is(Items.WATER_BUCKET)) {
            // The client just reports success so vanilla doesn't process it.
            if (level.isClientSide()) {
                cir.setReturnValue(InteractionResult.SUCCESS);
                return;
            }

            if (level.getBlockEntity(pos) instanceof DecoratedPotBlockEntity pot) {

                //drop pot contents
                ItemStack stored = pot.getTheItem();
                if (!stored.isEmpty()) {
                    Containers.dropItemStack(
                            level,
                            pos.getX(),
                            pos.getY(),
                            pos.getZ(),
                            stored
                    );
                }

                //get the existing decorations
                PotDecorations decorations = pot.getDecorations();

                //create a new block state to copy rotation and waterlogging properties from original block to new block
                BlockState newState = ModBlocks.PICKLING_VESSEL
                        .defaultBlockState()
                        .setValue(
                                PicklingVesselBlock.HORIZONTAL_FACING,
                                state.getValue(DecoratedPotBlock.HORIZONTAL_FACING)
                        )
                        .setValue(
                                PicklingVesselBlock.WATERLOGGED,
                                state.getValue(DecoratedPotBlock.WATERLOGGED)
                        );


                level.setBlock(
                        pos,
                        newState,
                        3
                );

                if (level.getBlockEntity(pos) instanceof PicklingVesselBlockEntity vessel) {
                    vessel.setDecorations(decorations);
                    vessel.setChanged();
                }

                if (!player.isCreative()) {
                    player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                }
            }
            cir.setReturnValue(InteractionResult.SUCCESS);
        }

    }

}
