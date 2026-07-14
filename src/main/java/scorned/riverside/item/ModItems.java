package scorned.riverside.item;


import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.references.BlockItemIds;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import scorned.riverside.Riverside;
import scorned.riverside.block.ModBlocks;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ModItems {

    public static final Item OLIVE = register("olive", Item::new, new Item.Properties());
//    public static final Item OLIVE_PIT = register("olive_pit", Item::new, new Item.Properties());
//    public static final Item OLIVE_SAPLING = register("olive_sapling", Item::new, new Item.Properties());
//    public static final Item OLIVE_WOOD = register("olive_wood", Item::new, new Item.Properties());
//    public static final Item OLIVE_LOG = register("olive_log", Item::new, new Item.Properties());
//    public static final Item STRIPPED_OLIVE_WOOD = register("stripped_olive_wood", Item::new, new Item.Properties());
//    public static final Item STRIPPED_OLIVE_LOG = register("stripped_olive_log", Item::new, new Item.Properties());
//    public static final Item OLIVE_LEAVES = register("olive_leaves", Item::new, new Item.Properties());
//    public static final Item OLIVE_PLANKS = register("olive_planks", Item::new, new Item.Properties());
//    public static final Item OLIVE_STAIRS = register("olive_stairs", Item::new, new Item.Properties());
//    public static final Item OLIVE_SLAB = register("olive_slab", Item::new, new Item.Properties());
//    public static final Item OLIVE_FENCE = register("olive_fence", Item::new, new Item.Properties());
//    public static final Item OLIVE_FENCE_GATE = register("olive_fence_gate", Item::new, new Item.Properties());
//    public static final Item OLIVE_BUTTON = register("olive_button", Item::new, new Item.Properties());
//    public static final Item OLIVE_PRESSURE_PLATE = register("olive_pressure_plate", Item::new, new Item.Properties());
//    public static final Item OLIVE_DOOR = register("olive_door", Item::new, new Item.Properties());
//    public static final Item OLIVE_TRAP_DOOR = register("olive_trap_door", Item::new, new Item.Properties());
//    public static final Item OLIVE_SIGN = register("olive_sign", Item::new, new Item.Properties());
//    public static final Item OLIVE_HANGING_SIGN = register("olive_hanging_sign", Item::new, new Item.Properties());
//    public static final Item OLIVE_BOAT = register("olive_boat", Item::new, new Item.Properties());
//    public static final Item OLIVE_CHEST_BOAT = register("olive_chest_boat", Item::new, new Item.Properties());
//    public static final Item OLIVE_SHELVES = register("olive_shelves", Item::new, new Item.Properties());

    public static final Item OLIVE_HANGING_SIGN = registerBlock(
            BlockItemId.create(Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "olive_hanging_sign")
                    ,Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "olive_hanging_sign"))
            , ModBlocks.OLIVE_HANGING_SIGN,
            (b, p) -> new HangingSignItem(b, ModBlocks.OLIVE_WALL_HANGING_SIGN, p),
            new Item.Properties().stacksTo(16)
    );

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
}
