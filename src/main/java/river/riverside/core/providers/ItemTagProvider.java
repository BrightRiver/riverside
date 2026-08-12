package river.riverside.core.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NonNull;
import river.riverside.core.instructions.ItemTagInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagsProvider.ItemTagsProvider {

    private final List<ItemTagInstruction> instructions = new ArrayList<>();


    public ItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    public boolean add(ItemTagInstruction instruction) {
        instructions.add(instruction);
        return true;
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        for (ItemTagInstruction instruction : instructions) {
            for (TagKey<Item> newTag : instruction.getTags()) {
                tag(newTag).add(instruction.target());
            }

        }
    }
}
