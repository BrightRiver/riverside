package river.riverside.core;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jspecify.annotations.NonNull;
import river.riverside.Riverside;

import java.util.function.Function;

public class Blocks {

    public static @NonNull Block registerBlock(String name, @NonNull Function<BlockBehaviour.Properties, Block> function) {
        Identifier id = Riverside.id(name);
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, id)));

        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, id, toRegister);
    }

    public static void registerBlockItem(String name, Block block) {
        Identifier id = Riverside.id(name);
        Item.Properties itemProperties = new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, id));
        BlockItem blockItem = new BlockItem(block, itemProperties);

        Registry.register(BuiltInRegistries.ITEM, id, blockItem);
    }

    public static @NonNull ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }
}
