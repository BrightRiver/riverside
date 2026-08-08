package river.riverside.core.instructions;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceKey;
import river.riverside.core.Blocks;

import java.util.ArrayList;
import java.util.List;

public class BlockTagInstruction {

    private ResourceKey<Block> targetKey;

    private final List<TagKey<Block>> tags = new ArrayList<>();

    public BlockTagInstruction target(Block b) {
        targetKey = Blocks.getRK(b);
        return this;
    }

    public BlockTagInstruction addTag(TagKey<Block> tag) {
        tags.add(tag);
        return this;
    }

    public ResourceKey<Block> target() {
        return targetKey;
    }

    public List<TagKey<Block>> getTags() {
        return tags;
    }
}
