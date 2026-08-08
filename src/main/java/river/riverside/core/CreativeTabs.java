package river.riverside.core;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class CreativeTabs {

    public static void accept(ResourceKey<CreativeModeTab> tab, ItemLike block) {
        CreativeModeTabEvents.modifyOutputEvent(tab)
                .register(output -> {
                    output.accept(block);
                });
    }

    public static void acceptAfter(ResourceKey<CreativeModeTab> tab, ItemLike after, ItemLike block) {
        CreativeModeTabEvents.modifyOutputEvent(tab)
                .register(output -> {
                    output.insertAfter(after, block);
                });
    }
}
