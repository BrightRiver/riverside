package river.riverside.core.instructions;

import net.minecraft.data.BlockFamily;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import river.riverside.Riverside;

public class ModelInstruction {

    public enum ModelType {
        LOG,
        SHELF,
        WALL,
        WOOD_FAMILY,
        FLAT
    }

    private ModelType type;
    private Block block;
    private Block baseBlock;
    private BlockFamily blockFamily;
    private Block variant;
    private Item item;


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

    public ModelInstruction blockFamily(BlockFamily blockFamily) {
        this.blockFamily = blockFamily;
        return this;
    }

    public BlockFamily blockFamily() {
        return blockFamily;
    }

    public ModelInstruction block(Block block) {
        this.block = block;
        return this;
    }

    public Block block() {
        return this.block;
    }


    public ModelInstruction item(Item item) {
        this.item = item;
        return this;
    }

    public Item item() {
        return this.item;
    }

    public ModelInstruction variant(Block block) {
        this.variant = block;
        return this;
    }
    public Block variant() {
        return variant;
    }

    public boolean validate() {
        if (type == null) {
            Riverside.LOGGER.error("{} : instruction missing type", Riverside.MOD_ID);
            return false;
        }

        boolean valid = true;
        return switch (type) {
            case LOG :
                valid &= required(block, "block (log)");
                valid &= required(variant, "variant (wood)");
                yield valid;
            case WALL:
            case SHELF:
                valid &= required(block, "block");
                valid &= required(baseBlock, "base block");
                yield valid;
            case WOOD_FAMILY:
                valid &= required(block, "block");
                valid &= required(blockFamily, "block family");
                yield valid;
            case FLAT:
                valid &= required(item, "item");
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
