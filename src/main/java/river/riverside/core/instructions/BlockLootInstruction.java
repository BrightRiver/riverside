package river.riverside.core.instructions;

import net.minecraft.world.level.block.Block;

public class BlockLootInstruction {

    public enum DropType {
        CUSTOM,
        DOOR,
        OTHER,
        SELF,
        SLAB
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

    public BlockLootInstruction dropType(DropType dropType) {
        this.dropType = dropType;
        return this;
    }
}
