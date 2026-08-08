package river.riverside.core.providers;

import java.util.Objects;

public class PackProviders {
    ModelProvider modelProvider;
    BlockTagProvider tagProvider;
    BlockLootProvider lootProvider;
    RecipeProvider recipeProvider;
    LanguageProvider languageProvider;

    public PackProviders modelProvider(ModelProvider modelProvider) {
        this.modelProvider = modelProvider;
        return this;
    }

    public ModelProvider modelProvider() {
        Objects.requireNonNull(modelProvider, "ModelProvider has not been registered.");
        return modelProvider;
    }


    public PackProviders tagProvider(BlockTagProvider tagProvider) {
        this.tagProvider = tagProvider;
        return this;
    }

    public BlockTagProvider tagProvider() {
        Objects.requireNonNull(tagProvider, "TagProvider has not been registered.");
        return tagProvider;
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
