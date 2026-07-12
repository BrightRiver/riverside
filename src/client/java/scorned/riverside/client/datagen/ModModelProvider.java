package scorned.riverside.client.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;


import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import scorned.riverside.block.ModBlocks;
import scorned.riverside.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

        blockModelGenerators.family(ModBlocks.OLIVE_PLANKS)
                .stairs(ModBlocks.OLIVE_STAIR)
                .slab(ModBlocks.OLIVE_SLAB)
                .wall(ModBlocks.OLIVE_WALL)
                .fence(ModBlocks.OLIVE_FENCE)
                .fenceGate(ModBlocks.OLIVE_FENCE_GATE)
                .button(ModBlocks.OLIVE_BUTTON)
                .pressurePlate(ModBlocks.OLIVE_PRESSURE_PLATE);


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

    }
}