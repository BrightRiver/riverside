package river.riverside.core.providers;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import org.jspecify.annotations.NonNull;
import river.riverside.core.instructions.ModelInstruction;

import java.util.ArrayList;
import java.util.List;

public class ModelProvider extends FabricModelProvider {
    private final List<ModelInstruction> instructions = new ArrayList<>();

    public ModelProvider(FabricPackOutput output) {
        super(output);
    }

    public boolean add(ModelInstruction instruction) {
        if(instruction.validate()) {
            instructions.add(instruction);
            return true;
        }
        return false;
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {
        for (ModelInstruction instruction : instructions) {
            switch (instruction.type()) {
                case WALL :
                    var blockFamily = blockModelGenerators.family(instruction.baseBlock());
                    blockFamily.wall(instruction.block());
            }
        }
    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {

    }


}
