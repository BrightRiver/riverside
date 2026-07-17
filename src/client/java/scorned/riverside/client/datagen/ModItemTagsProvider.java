package scorned.riverside.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import org.jspecify.annotations.NonNull;
import scorned.riverside.block.ModBlocks;
import scorned.riverside.item.ModItems;
import scorned.riverside.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {


    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {


        tag(ModTags.Items.OLIVE_LOGS)
                .add(ModItems.getRK(ModBlocks.OLIVE_WOOD.asItem()))
                .add(ModItems.getRK(ModBlocks.OLIVE_LOG.asItem()))
                .add(ModItems.getRK(ModBlocks.STRIPPED_OLIVE_WOOD.asItem()))
                .add(ModItems.getRK(ModBlocks.STRIPPED_OLIVE_LOG.asItem()));

        tag(ItemTags.PLANKS).add(ModItems.getRK(ModBlocks.OLIVE_PLANKS.asItem()));

    }
}
