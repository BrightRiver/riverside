package scorned.riverside.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import scorned.riverside.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {


    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.getRK(ModBlocks.OLIVE_PLANKS))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_WOOD))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_LOG))
                .add(ModBlocks.getRK(ModBlocks.STRIPPED_OLIVE_WOOD))
                .add(ModBlocks.getRK(ModBlocks.STRIPPED_OLIVE_LOG))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_FENCE))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_WALL))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_SLAB))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_SHELF))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_STAIR))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_BUTTON))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_PRESSURE_PLATE));

        tag(BlockTags.STAIRS).add(ModBlocks.getRK(ModBlocks.OLIVE_STAIR));
        tag(BlockTags.SLABS).add(ModBlocks.getRK(ModBlocks.OLIVE_SLAB));

        tag(BlockTags.WOODEN_SHELVES).add(ModBlocks.getRK(ModBlocks.OLIVE_SHELF));
        tag(BlockTags.FENCES).add(ModBlocks.getRK(ModBlocks.OLIVE_FENCE));
        tag(BlockTags.WALLS).add(ModBlocks.getRK(ModBlocks.OLIVE_WALL));
        tag(BlockTags.FENCE_GATES).add(ModBlocks.getRK(ModBlocks.OLIVE_FENCE_GATE));

    }
}
