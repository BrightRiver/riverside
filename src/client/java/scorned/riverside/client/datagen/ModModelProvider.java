package scorned.riverside.client.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import org.jspecify.annotations.NonNull;
import scorned.riverside.block.ModBlockFamilies;
import scorned.riverside.block.ModBlocks;
import scorned.riverside.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {
        generateOliveBlockModels(blockModelGenerators);
    }

    private void generateOliveBlockModels(BlockModelGenerators blockModelGenerators) {
        BlockModelGenerators.BlockFamilyProvider woodFamily = blockModelGenerators.family(ModBlocks.OLIVE_PLANKS);
        woodFamily.generateFor(ModBlockFamilies.OLIVE_PLANKS);

        blockModelGenerators.woodProvider(ModBlocks.OLIVE_LOG)
                .log(ModBlocks.OLIVE_LOG)
                .wood(ModBlocks.OLIVE_WOOD);

        blockModelGenerators.woodProvider(ModBlocks.STRIPPED_OLIVE_LOG)
                .log(ModBlocks.STRIPPED_OLIVE_LOG)
                .wood(ModBlocks.STRIPPED_OLIVE_WOOD);

        blockModelGenerators.createShelf(ModBlocks.OLIVE_SHELF, ModBlocks.STRIPPED_OLIVE_LOG);


    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.OLIVE, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.OLIVE_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.OLIVED_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PICKLED_EGG, ModelTemplates.FLAT_ITEM);
    }
}