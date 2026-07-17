package scorned.riverside.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jspecify.annotations.NonNull;
import scorned.riverside.block.ModBlocks;
import scorned.riverside.item.ModItems;
import scorned.riverside.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registries, @NonNull RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {

                woodFromLogs(ModBlocks.OLIVE_WOOD, ModBlocks.OLIVE_LOG);
                woodFromLogs(ModBlocks.STRIPPED_OLIVE_WOOD, ModBlocks.STRIPPED_OLIVE_LOG);
                planksFromLogs(ModBlocks.OLIVE_PLANKS, ModTags.Items.OLIVE_LOGS, 4);

                stairBuilder(ModBlocks.OLIVE_STAIR, Ingredient.of(ModBlocks.OLIVE_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.OLIVE_PLANKS), has(ModBlocks.OLIVE_PLANKS))
                        .save(output);

                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_SLAB, ModBlocks.OLIVE_PLANKS);

                buttonBuilder(ModBlocks.OLIVE_BUTTON, Ingredient.of(ModBlocks.OLIVE_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.OLIVE_PLANKS), has(ModBlocks.OLIVE_PLANKS))
                        .save(output);

                pressurePlate(ModBlocks.OLIVE_PRESSURE_PLATE, ModBlocks.OLIVE_PLANKS);

                fenceBuilder(ModBlocks.OLIVE_FENCE, Ingredient.of(ModBlocks.OLIVE_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.OLIVE_PLANKS), has(ModBlocks.OLIVE_PLANKS))
                        .save(output);

                fenceGateBuilder(ModBlocks.OLIVE_FENCE_GATE, Ingredient.of(ModBlocks.OLIVE_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.OLIVE_PLANKS), has(ModBlocks.OLIVE_PLANKS))
                        .save(output);

                doorBuilder(ModBlocks.OLIVE_DOOR, Ingredient.of(ModBlocks.OLIVE_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.OLIVE_PLANKS), has(ModBlocks.OLIVE_PLANKS))
                        .save(output);

                trapdoorBuilder(ModBlocks.OLIVE_TRAPDOOR, Ingredient.of(ModBlocks.OLIVE_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.OLIVE_PLANKS), has(ModBlocks.OLIVE_PLANKS))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_WALL)
                        .pattern("PSP")
                        .pattern("PPP")
                        .define('P', ModBlocks.OLIVE_PLANKS)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModBlocks.OLIVE_PLANKS), has(ModBlocks.OLIVE_PLANKS))
                        .save(output);

                woodenBoat(ModItems.OLIVE_BOAT, ModBlocks.OLIVE_PLANKS);

                chestBoat(ModItems.OLIVED_CHEST_BOAT, ModItems.OLIVE_BOAT);
                signBuilder(ModItems.OLIVE_SIGN, Ingredient.of(ModBlocks.OLIVE_PLANKS));
                hangingSignBuilder(ModItems.OLIVE_HANGING_SIGN, Ingredient.of(ModBlocks.STRIPPED_OLIVE_LOG));

            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "Riverside Recipes";
    }
}
