package scorned.riverside.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;
import scorned.riverside.block.ModBlocks;
import scorned.riverside.item.ModItems;
import scorned.riverside.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {


    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
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
                .add(ModBlocks.getRK(ModBlocks.OLIVE_PRESSURE_PLATE))
                .add(ModBlocks.getRK(Block.byItem(ModItems.OLIVE_SIGN)))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_WALL_SIGN))
                .add(ModBlocks.getRK(Block.byItem(ModItems.OLIVE_HANGING_SIGN)))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_TRAPDOOR))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_DOOR));

        tag(BlockTags.PLANKS).add(ModBlocks.getRK(ModBlocks.OLIVE_PLANKS));

        tag(BlockTags.STAIRS).add(ModBlocks.getRK(ModBlocks.OLIVE_STAIR));
        tag(BlockTags.SLABS).add(ModBlocks.getRK(ModBlocks.OLIVE_SLAB));


        tag(BlockTags.WOODEN_SHELVES).add(ModBlocks.getRK(ModBlocks.OLIVE_SHELF));
        tag(BlockTags.FENCES).add(ModBlocks.getRK(ModBlocks.OLIVE_FENCE));
        tag(BlockTags.WALLS).add(ModBlocks.getRK(ModBlocks.OLIVE_WALL));
        tag(BlockTags.FENCE_GATES).add(ModBlocks.getRK(ModBlocks.OLIVE_FENCE_GATE));

        tag(BlockTags.STANDING_SIGNS).add(ModBlocks.getRK(Block.byItem(ModItems.OLIVE_SIGN)));
        tag(BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.getRK(Block.byItem(ModItems.OLIVE_HANGING_SIGN)));
        tag(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.getRK(ModBlocks.OLIVE_WALL_HANGING_SIGN));

        tag(BlockTags.ALL_HANGING_SIGNS)
                .add(ModBlocks.getRK(Block.byItem(ModItems.OLIVE_HANGING_SIGN)))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_WALL_HANGING_SIGN));

        tag(BlockTags.ALL_SIGNS)
                .add(ModBlocks.getRK(Block.byItem(ModItems.OLIVE_HANGING_SIGN)))
                .add(ModBlocks.getRK(Block.byItem(ModItems.OLIVE_SIGN)))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_WALL_SIGN))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_WALL_HANGING_SIGN));

        tag(BlockTags.TRAPDOORS).add(ModBlocks.getRK(ModBlocks.OLIVE_TRAPDOOR));
        tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.getRK(ModBlocks.OLIVE_TRAPDOOR));

        tag(ModTags.Blocks.OLIVE_LOGS)
                .add(ModBlocks.getRK(ModBlocks.OLIVE_WOOD))
                .add(ModBlocks.getRK(ModBlocks.OLIVE_LOG))
                .add(ModBlocks.getRK(ModBlocks.STRIPPED_OLIVE_WOOD))
                .add(ModBlocks.getRK(ModBlocks.STRIPPED_OLIVE_LOG));


        tag(BlockTags.WOODEN_DOORS).add(ModBlocks.getRK(ModBlocks.OLIVE_DOOR));
        tag(BlockTags.DOORS).add(ModBlocks.getRK(ModBlocks.OLIVE_DOOR));

    }
}
