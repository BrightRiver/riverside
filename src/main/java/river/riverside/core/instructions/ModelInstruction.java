package river.riverside.core.instructions;

import net.minecraft.world.level.block.Block;
import river.riverside.Riverside;

public class ModelInstruction {

    public enum ModelType {
        WALL
    }

    private ModelType type;
    private Block block;
    private Block baseBlock;


    public ModelInstruction type(ModelType type) {
        this.type = type;
        return this;
    }

    public ModelType type() {
        return this.type;
    }

    public ModelInstruction baseBlock(Block baseBlock) {
        this.baseBlock = baseBlock;
        return this;
    }

    public Block baseBlock() {
        return this.baseBlock;
    }

    public ModelInstruction block(Block block) {
        this.block = block;
        return this;
    }

    public Block block() {
        return this.block;
    }


    public boolean validate() {
        if (type == null) {
            Riverside.LOGGER.error("{} : instruction missing type", Riverside.MOD_ID);
            return false;
        }

        boolean valid = true;
        return switch (type) {
            case WALL:
                valid &= required(block, "block");
                valid &= required(baseBlock, "base block");
                yield valid;
            default:
                Riverside.LOGGER.error("{} : instruction has invalid type", Riverside.MOD_ID);
                yield false;

        };

    }

    private static boolean required(Object input, String field) {
        if (input == null) {
            Riverside.LOGGER.error("{} : instruction missing field : {}", Riverside.MOD_ID, field);
            return false;
        }
        return true;
    }
}
