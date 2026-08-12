package river.riverside.core.providers;

import java.util.Objects;

public class PackProviders {
    ModelProvider modelProvider;
    BlockTagProvider blockTagProvider;
    BlockLootProvider lootProvider;
    RecipeProvider recipeProvider;
    LanguageProvider languageProvider;
    ItemTagProvider itemTagProvider;

    public PackProviders modelProvider(ModelProvider modelProvider) {
        this.modelProvider = modelProvider;
        return this;
    }

    public ModelProvider modelProvider() {
        Objects.requireNonNull(modelProvider, "ModelProvider has not been registered.");
        return modelProvider;
    }


    public PackProviders blockTagProvider(BlockTagProvider tagProvider) {
        this.blockTagProvider = tagProvider;
        return this;
    }

    public BlockTagProvider blockTagProvider() {
        Objects.requireNonNull(blockTagProvider, "BlockTagProvider has not been registered.");
        return blockTagProvider;
    }


    public PackProviders itemTagProvider(ItemTagProvider tagProvider) {
        this.itemTagProvider = tagProvider;
        return this;
    }

    public ItemTagProvider itemTagProvider() {
        Objects.requireNonNull(itemTagProvider, "BlockTagProvider has not been registered.");
        return itemTagProvider;
    }

    public PackProviders lootProvider(BlockLootProvider lootProvider) {
        this.lootProvider = lootProvider;
        return this;
    }

    public BlockLootProvider lootProvider() {
        Objects.requireNonNull(lootProvider, "LootProvider has not been registered.");
        return lootProvider;
    }

    public PackProviders recipeProvider(RecipeProvider recipeProvider) {
        this.recipeProvider = recipeProvider;
        return this;
    }

    public RecipeProvider recipeProvider() {
        Objects.requireNonNull(recipeProvider, "RecipeProvider has not been registered.");
        return recipeProvider;
    }

    public PackProviders languageProvider(LanguageProvider languageProvider) {
        this.languageProvider = languageProvider;
        return this;
    }

    public LanguageProvider languageProvider() {
        Objects.requireNonNull(languageProvider, "LanguageProvider has not been registered.");
        return languageProvider;
    }

}
