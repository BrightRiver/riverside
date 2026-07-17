package scorned.riverside.registries;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import scorned.riverside.block.ModBlocks;

public class ModStrippableBlocks {
    public static void initialize() {
        StrippableBlockRegistry.register(ModBlocks.OLIVE_LOG, ModBlocks.STRIPPED_OLIVE_LOG);
        StrippableBlockRegistry.register(ModBlocks.OLIVE_WOOD, ModBlocks.STRIPPED_OLIVE_WOOD);
    }
}
