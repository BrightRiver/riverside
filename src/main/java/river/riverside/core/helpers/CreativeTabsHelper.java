package river.riverside.core.helpers;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;


public class CreativeTabsHelper {

    //TODO make dynamic based on config
    public static final ResourceKey<CreativeModeTab> RIVERSIDE_TAB = createKey("riverside");

    static {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, RIVERSIDE_TAB,
                CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                        .title(Component.translatable("tab.riverside.creative_tab"))
                        .icon(() -> new ItemStack(Blocks.BRICKS))
                        .build());
    }

    private static ResourceKey<CreativeModeTab> createKey(final String id) {
        return ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.withDefaultNamespace(id));
    }

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
