package scorned.riverside.recipe;

import scorned.riverside.Riverside;
import scorned.riverside.recipe.custom.PicklingRecipe;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipes {
    public static final RecipeSerializer<PicklingRecipe> PICKLING_SERIALIZER = Registry.register(
            BuiltInRegistries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "pickling"),
            new RecipeSerializer<>(PicklingRecipe.CODEC, PicklingRecipe.STREAM_CODEC));

    public static final RecipeType<PicklingRecipe> PICKLING_TYPE = Registry.register(
            BuiltInRegistries.RECIPE_TYPE, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "pickling"),
            new RecipeType<PicklingRecipe>() {
                @Override
                public String toString() {
                    return "pickling";
                }
            });


    public static void initialize() {
        Riverside.LOGGER.info("Registering Mod Recipes for " + Riverside.MOD_ID);
    }

}
