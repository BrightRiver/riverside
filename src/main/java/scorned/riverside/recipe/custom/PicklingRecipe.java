package scorned.riverside.recipe.custom;

import net.minecraft.world.item.ItemStackTemplate;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import scorned.riverside.recipe.ModRecipes;

public record PicklingRecipe(Ingredient inputItem, ItemStackTemplate output) implements Recipe<PicklingRecipeInput> {


    public static final MapCodec<PicklingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(PicklingRecipe::inputItem),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(PicklingRecipe::output)
            ).apply(instance, PicklingRecipe::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, PicklingRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC,
                    PicklingRecipe::inputItem,

                    ItemStackTemplate.STREAM_CODEC,
                    PicklingRecipe::output,

                    PicklingRecipe::new);

    @Override
    public boolean matches(@NonNull PicklingRecipeInput input, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(input.getItem(0));
    }

    @Override
    public @NonNull ItemStack assemble(@NonNull PicklingRecipeInput input) {
        return output.create().copy();
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public @NonNull String group() {
        return "Pickle";
    }

    @Override
    public @NonNull RecipeSerializer<? extends Recipe<PicklingRecipeInput>> getSerializer() {
        return ModRecipes.PICKLING_SERIALIZER;
    }

    @Override
    public @NonNull RecipeType<? extends Recipe<PicklingRecipeInput>> getType() {
        return ModRecipes.PICKLING_TYPE;
    }

    @Override
    public @NonNull PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public @NonNull RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

}
