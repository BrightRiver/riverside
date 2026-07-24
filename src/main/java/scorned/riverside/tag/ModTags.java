package scorned.riverside.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.block.Block;
import scorned.riverside.Riverside;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> OLIVE_LOGS = createTag("olive_logs");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> OLIVE_LOGS = createTag("olive_logs");
        public static final TagKey<Item> PICKLEABLE = createTag("pickleable");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, name));
        }
    }

    public static class Trades {
    }
}