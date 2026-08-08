package river.riverside.core.instructions;

import net.minecraft.world.level.block.Block;

public class BlockLootInstruction {

    public enum DropType {
        SELF,
        OTHER,
        CUSTOM
    }

    private DropType dropType = DropType.SELF;
    private Block target;
    private Block drops;

    public BlockLootInstruction target(Block target) {
        this.target = target;
        return this;
    }

    public Block target() {
        return this.target;
    }

    public BlockLootInstruction drops(Block block) {
        this.dropType = DropType.OTHER;
        this.drops = block;
        return this;
    }

    public Block drops() {
        return drops;
    }

    public DropType dropType() {
        return dropType;
    }
}
