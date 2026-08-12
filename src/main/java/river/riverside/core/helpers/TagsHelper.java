package river.riverside.core.helpers;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import river.riverside.Riverside;

public class TagsHelper {

    public static class Blocks {
        public static TagKey<Block> createTag(String name) {
            Identifier id = Riverside.id(name);
            return TagKey.create(Registries.BLOCK, id);
        }
    }

    public static class Items {
        public static TagKey<Item> createTag(String name) {
            Identifier id = Riverside.id(name);
            return TagKey.create(Registries.ITEM, id);
        }
    }

}
