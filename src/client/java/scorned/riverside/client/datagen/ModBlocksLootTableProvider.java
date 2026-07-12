package scorned.riverside.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import scorned.riverside.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlocksLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlocksLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.OLIVE_PLANKS);
        dropSelf(ModBlocks.OLIVE_WOOD);
        dropSelf(ModBlocks.OLIVE_LOG);
        dropSelf(ModBlocks.STRIPPED_OLIVE_WOOD);
        dropSelf(ModBlocks.STRIPPED_OLIVE_LOG);
        dropSelf(ModBlocks.OLIVE_FENCE);
        dropSelf(ModBlocks.OLIVE_WALL);
        dropSelf(ModBlocks.OLIVE_SHELF);
        dropSelf(ModBlocks.OLIVE_STAIR);
        dropSelf(ModBlocks.OLIVE_BUTTON);
        dropSelf(ModBlocks.OLIVE_PRESSURE_PLATE);

        add(ModBlocks.OLIVE_SLAB, this::createSlabItemTable);
    }
}
