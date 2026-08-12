package river.riverside.core.instructions;

import net.minecraft.world.level.ItemLike;

public class LanguageInstruction {

    private ItemLike target;
    private String englishName;

    public LanguageInstruction target(ItemLike target) {
        this.target = target;
        return this;
    }

    public ItemLike target() {
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
