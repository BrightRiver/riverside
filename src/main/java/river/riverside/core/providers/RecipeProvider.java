package river.riverside.core.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jspecify.annotations.NonNull;
import river.riverside.core.instructions.RecipeInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends FabricRecipeProvider {

    private final List<RecipeInstruction> instructions = new ArrayList<>();

    public RecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public boolean add(RecipeInstruction instruction) {
        instructions.add(instruction);
        return true;
    }

    @Override
    protected net.minecraft.data.recipes.@NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registries, @NonNull RecipeOutput output) {
        return new net.minecraft.data.recipes.RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                for (RecipeInstruction instruction : instructions) {
                    switch (instruction.type()) {
                        case SHAPED:
                            generateShapedRecipe(instruction);
                            break;
                        case PLANKS:
                            planksFromLogs(instruction.target(), instruction.tagKey(), 4);
                            break;
                        case FENCE:
                            fenceBuilder(instruction.target(), Ingredient.of(instruction.baseBlock()))
                                    .unlockedBy(getHasName(instruction.baseBlock()), has(instruction.baseBlock()))
                                    .save(output);
                            break;
                        case GATE:
                            fenceGateBuilder(instruction.target(), Ingredient.of(instruction.baseBlock()))
                                    .unlockedBy(getHasName(instruction.baseBlock()), has(instruction.baseBlock()))
                                    .save(output);
                            break;
                        case STAIR:
                            stairBuilder(instruction.target(), Ingredient.of(instruction.baseBlock()))
                                    .unlockedBy(getHasName(instruction.baseBlock()), has(instruction.baseBlock()))
                                    .save(output);
                            break;
                        case BUTTON:
                            buttonBuilder(instruction.target(), Ingredient.of(instruction.baseBlock()))
                                    .unlockedBy(getHasName(instruction.baseBlock()), has(instruction.baseBlock()))
                                    .save(output);
                            break;
                        case PRESSURE_PLATE:
                            pressurePlate(instruction.target(), instruction.baseBlock());
                            break;
                        case TRAPDOOR:
                            trapdoorBuilder(instruction.target(), Ingredient.of(instruction.baseBlock()))
                                    .unlockedBy(getHasName(instruction.baseBlock()), has(instruction.baseBlock()))
                                    .save(output);
                            break;
                        case SIGN:
                            signBuilder(instruction.target(), Ingredient.of(instruction.baseBlock()));
                            break;
                        case HANGING_SIGN:
                            hangingSignBuilder(instruction.target(), Ingredient.of(instruction.baseBlock()));
                            break;
                        case DOOR:
                            doorBuilder(instruction.target(), Ingredient.of(instruction.baseBlock()))
                                    .unlockedBy(getHasName(instruction.baseBlock()), has(instruction.baseBlock()))
                                    .save(output);
                            break;
                        case SLAB:
                            slab(RecipeCategory.BUILDING_BLOCKS, instruction.target(), instruction.baseBlock());
                            break;
                        case WOOD:
                            woodFromLogs(instruction.target(), instruction.baseBlock());
                            break;
                        case SHELF:
                            shelf(instruction.target(), instruction.baseBlock());
                            break;
                        case BOAT :
                            woodenBoat(instruction.target(), instruction.baseBlock());
                            break;
                        case CHEST_BOAT:
                            chestBoat(instruction.target(), instruction.baseBlock());
                            break;
                    }
                }
            }

            private void generateShapedRecipe(RecipeInstruction instruction) {
                ShapedRecipeBuilder recipe = shaped(instruction.category(), instruction.target(), instruction.count());

                if (instruction.group() != null) {
                    recipe.group(instruction.group());
                }

                for (String row : instruction.pattern()) {
                    recipe.pattern(row);
                }

                for (Map.Entry<Character, ItemLike> ingredient : instruction.ingredients().entrySet()) {
                    recipe.define(ingredient.getKey(), ingredient.getValue());
                }

                ItemLike unlockItem = instruction.unlockItem();
                recipe.unlockedBy(getHasName(unlockItem), has(unlockItem)).save(output);
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "Riverside Recipes";
    }
}
