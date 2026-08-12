package river.riverside.core.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import river.riverside.core.instructions.BlockLootInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BlockLootProvider extends FabricBlockLootSubProvider {

    private final List<BlockLootInstruction> instructions = new ArrayList<>();

    public BlockLootProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    public boolean add(BlockLootInstruction instruction) {
        instructions.add(instruction);
        return true;
    }

    public void generate() {
        for (BlockLootInstruction instruction : instructions) {
            switch (instruction.dropType()) {
                case SELF :
                    dropSelf(instruction.target());
                    break;
                case DOOR:
                    add(instruction.target(), this::createDoorTable);
                    break;
                case SLAB:
                    add(instruction.target(), this::createSlabItemTable);
                    break;
            }
        }
    }
}
