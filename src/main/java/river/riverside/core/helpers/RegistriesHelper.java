package river.riverside.core.helpers;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.world.level.block.Block;

public class RegistriesHelper {

    public static void makeStrippable(Block base, Block stripped) {
        StrippableBlockRegistry.register(base, stripped);
    }
}
