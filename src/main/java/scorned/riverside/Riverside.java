package scorned.riverside;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scorned.riverside.block.ModBlockFamilies;
import scorned.riverside.block.ModBlocks;
import scorned.riverside.block.entity.ModBlockEntities;
import scorned.riverside.item.ModItems;
import scorned.riverside.tab.ModCreativeModeTabs;

public class Riverside implements ModInitializer {
	public static final String MOD_ID = "riverside";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Mod + " + MOD_ID);
		ModCreativeModeTabs.initialize();
		ModItems.initialize();
		ModBlocks.initialize();
		ModBlockEntities.initialize();
		ModBlockFamilies.initialize();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
