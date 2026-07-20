package scorned.riverside.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import scorned.riverside.block.ModBlocks;
import scorned.riverside.item.ModItems;

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
        dropSelf(Block.byItem(ModItems.OLIVE_HANGING_SIGN));
        dropSelf(Block.byItem(ModItems.OLIVE_SIGN));
        dropSelf(ModBlocks.OLIVE_TRAPDOOR);
        add(ModBlocks.OLIVE_DOOR, this::createDoorTable);
        dropSelf(ModBlocks.OLIVE_WALL_HANGING_SIGN);
        dropSelf(ModBlocks.OLIVE_WALL_SIGN);
        add(ModBlocks.OLIVE_SLAB, this::createSlabItemTable);
        add(ModBlocks.PICKLING_VESSEL, this::createDecoratedPotTable);
    }


    private LootTable.Builder createDecoratedPotTable(final Block original) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(
                                DynamicLoot.dynamicEntry(DecoratedPotBlock.SHERDS_DYNAMIC_DROP_ID)
                                        .when(
                                                LootItemBlockStatePropertyCondition
                                                        .hasBlockStateProperties(original)
                                                        .setProperties(StatePropertiesPredicate
                                                                .Builder
                                                                .properties()
                                                                .hasProperty(DecoratedPotBlock.CRACKED, true)
                                                        )
                                        )
                                        .otherwise(
                                                LootItem.lootTableItem(Blocks.DECORATED_POT)
                                                        .apply(CopyComponentsFunction
                                                                .copyComponentsFromBlockEntity(LootContextParams.BLOCK_ENTITY)
                                                                .include(DataComponents.POT_DECORATIONS)
                                                        )
                                        )
                        )
                );
    }
}
