package scorned.riverside.item;


import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import scorned.riverside.Riverside;
import scorned.riverside.block.ModBlocks;
import scorned.riverside.entity.ModEntities;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ModItems {

    public static final Item PICKLED_EGG = register("pickled_egg", Item::new, new Item.Properties());
    public static final Item OLIVE = register("olive", Item::new, new Item.Properties());



    public static final Item OLIVE_HANGING_SIGN = registerBlock(
            BlockItemId.create(Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "olive_hanging_sign")
                    , Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "olive_hanging_sign"))
            , ModBlocks.OLIVE_HANGING_SIGN,
            (b, p) -> new HangingSignItem(b, ModBlocks.OLIVE_WALL_HANGING_SIGN, p),
            new Item.Properties().stacksTo(16)
    );

    public static final Item OLIVE_SIGN = registerBlock(
            BlockItemId.create(Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "olive_sign")
                    , Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "olive_sign"))
            , ModBlocks.OLIVE_SIGN,
            (b, p) -> new SignItem(b, ModBlocks.OLIVE_WALL_SIGN, p),
            new Item.Properties().stacksTo(16)
    );

    public static final Item OLIVE_BOAT = registerItem("olive_boat",
            properties -> new BoatItem(ModEntities.OLIVE_BOAT, properties.stacksTo(1)));

    public static final Item OLIVED_CHEST_BOAT = registerItem("olive_chest_boat",
            properties -> new BoatItem(ModEntities.OLIVE_CHEST_BOAT, properties.stacksTo(1)));

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, name));
        T item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(item));

        return item;
    }


    private static Item registerBlock(
            final BlockItemId id, final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory, final Item.Properties properties
    ) {
        return registerItem(id.item(), p -> itemFactory.apply(block, p), properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures()));
    }

    private static Item registerItem(final ResourceKey<Item> id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        Item item = itemFactory.apply(properties.setId(id));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void initialize() {
        Riverside.LOGGER.info("Registering mod items for " + Riverside.MOD_ID);
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, name)))));
    }


    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }
}
