package scorned.riverside.recipe.custom;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jspecify.annotations.NonNull;


public record PicklingRecipeInput(ItemStack input) implements RecipeInput {

    @Override
    public @NonNull ItemStack getItem(int index) {
        return input;
    }

    @Override
    public int size() {
       return 1;
    }
}
