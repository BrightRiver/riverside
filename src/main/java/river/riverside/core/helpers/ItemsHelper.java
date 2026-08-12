package river.riverside.core.helpers;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import river.riverside.Riverside;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ItemsHelper {

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, name));
        T item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(item));

        return item;
    }


    public static Item registerBlock(
            String name, final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory, final Item.Properties properties
    ) {
        Identifier id = Riverside.id(name);
        BlockItemId blockItemId = BlockItemId.create(id, id);
        return registerItem(blockItemId.item(), p -> itemFactory.apply(block, p),
                properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures()));
    }

    public static Item registerItem(final ResourceKey<Item> id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        Item item = itemFactory.apply(properties.setId(id));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void initialize() {
        Riverside.LOGGER.info("Registering mod items for " + Riverside.MOD_ID);
    }

    public static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, name)))));
    }


    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }
}
