package river.riverside.core.instructions;

import net.minecraft.world.level.block.Block;

public class LanguageInstruction {

    private Block target;
    private String englishName;

    public LanguageInstruction target(Block target) {
        this.target = target;
        return this;
    }

    public Block target() {
        return target;
    }

    public LanguageInstruction englishName(String englishName) {
        this.englishName = englishName;
        return this;
    }

    public String englishName() {
        return englishName;
    }
}
