package river.riverside.core.instructions;

import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import river.riverside.core.helpers.BlocksHelper;
import river.riverside.core.helpers.ItemsHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemTagInstruction {

    private ResourceKey<Item> targetKey;

    private final List<TagKey<Item>> tags = new ArrayList<>();

    public ItemTagInstruction target(Item i) {
        targetKey = ItemsHelper.getRK(i);
        return this;
    }

    public ItemTagInstruction addTag(TagKey<Item> tag) {
        tags.add(tag);
        return this;
    }

    public ResourceKey<Item> target() {
        return targetKey;
    }

    public List<TagKey<Item>> getTags() {
        return tags;
    }
}
