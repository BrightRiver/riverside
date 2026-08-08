package river.riverside.core.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;
import river.riverside.core.instructions.BlockTagInstruction;
import net.minecraft.tags.TagKey;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    private final List<BlockTagInstruction> instructions = new ArrayList<>();


    public BlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    public boolean add(BlockTagInstruction instruction) {
        instructions.add(instruction);
        return true;
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        for (BlockTagInstruction instruction : instructions) {
            for (TagKey<Block> newTag : instruction.getTags()) {
                tag(newTag).add(instruction.target());
            }

        }
    }
}
