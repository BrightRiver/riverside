package river.riverside;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import river.riverside.core.providers.*;

public class RiversideDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();

        PackProviders providers = new PackProviders();

        providers
                .modelProvider(pack.addProvider(ModelProvider::new))
                .blockTagProvider(pack.addProvider(BlockTagProvider::new))
                .itemTagProvider(pack.addProvider(ItemTagProvider::new))
                .lootProvider(pack.addProvider(BlockLootProvider::new))
                .recipeProvider(pack.addProvider(RecipeProvider::new))
                .languageProvider(pack.addProvider(LanguageProvider::new));

        FeatureList.generateData(providers);
    }
}
