package river.riverside;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import river.riverside.core.providers.BlockLootProvider;
import river.riverside.core.providers.ModelProvider;
import river.riverside.core.providers.PackProviders;
import river.riverside.core.providers.BlockTagProvider;
import river.riverside.core.providers.RecipeProvider;
import river.riverside.core.providers.LanguageProvider;

public class RiversideDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();

        PackProviders providers = new PackProviders();

        providers
                .modelProvider(pack.addProvider(ModelProvider::new))
                .blockTagProvider(pack.addProvider(BlockTagProvider::new))
                .lootProvider(pack.addProvider(BlockLootProvider::new))
                .recipeProvider(pack.addProvider(RecipeProvider::new))
                .languageProvider(pack.addProvider(LanguageProvider::new));

        FeatureList.generateData(providers);
    }
}
