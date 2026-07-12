package scorned.riverside.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import scorned.riverside.client.datagen.ModBlockTagsProvider;
import scorned.riverside.client.datagen.ModBlocksLootTableProvider;
import scorned.riverside.client.datagen.ModModelProvider;

public class RiversideDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlocksLootTableProvider::new);
	}
}
