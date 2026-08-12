package river.riverside.core.providers;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import org.jspecify.annotations.NonNull;
import river.riverside.core.instructions.ModelInstruction;

import java.util.ArrayList;
import java.util.List;

public class ModelProvider extends FabricModelProvider {
    private final List<ModelInstruction> instructions = new ArrayList<>();
    private final List<ModelInstruction> itemInstructions = new ArrayList<>();

    public ModelProvider(FabricPackOutput output) {
        super(output);
    }

    public boolean add(ModelInstruction instruction) {
        if (instruction.validate()) {
            instructions.add(instruction);
            return true;
        }
        return false;
    }

    public boolean addItem(ModelInstruction instruction) {
        if (instruction.validate()) {
            itemInstructions.add(instruction);
            return true;
        }
        return false;
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {
        for (ModelInstruction instruction : instructions) {
            switch (instruction.type()) {
                case LOG:
                    blockModelGenerators.woodProvider(instruction.block())
                            .log(instruction.block())
                            .wood(instruction.variant());
                    break;
                case SHELF:
                    blockModelGenerators.createShelf(instruction.block(), instruction.baseBlock());
                    break;
                case WALL:
                    var blockFamily = blockModelGenerators.family(instruction.baseBlock());
                    blockFamily.wall(instruction.block());
                    break;
                case WOOD_FAMILY:
                    BlockModelGenerators.BlockFamilyProvider woodFamily = blockModelGenerators.family(instruction.block());
                    woodFamily.generateFor(instruction.blockFamily());
                    break;
            }
        }
    }


    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
        for (ModelInstruction instruction : itemInstructions) {
            switch (instruction.type()) {
                case FLAT:
                    itemModelGenerators.generateFlatItem(instruction.item(), ModelTemplates.FLAT_ITEM);

            }
        }
    }


}
