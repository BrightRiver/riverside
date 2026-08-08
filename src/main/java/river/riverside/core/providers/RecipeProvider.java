package river.riverside.core.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
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
                        case SHAPED -> generateShapedRecipe(instruction);
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
