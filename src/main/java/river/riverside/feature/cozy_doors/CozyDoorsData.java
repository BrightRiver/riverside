package river.riverside.feature.cozy_doors;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import river.riverside.core.instructions.BlockLootInstruction;
import river.riverside.core.instructions.BlockTagInstruction;
import river.riverside.core.instructions.LanguageInstruction;
import river.riverside.core.providers.PackProviders;

public class CozyDoorsData {


    private static LanguageInstruction language(ItemLike b, String englishName) {
        return new LanguageInstruction()
                .target(b)
                .englishName(englishName);
    }

    public void generate_door(PackProviders p, Block door, String name) {
        p.lootProvider().add(new BlockLootInstruction()
                .dropType(BlockLootInstruction.DropType.DOOR)
                .target(door));
        p.languageProvider().add(language(door,name));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(door)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.DOORS)
                .addTag(BlockTags.WOODEN_DOORS)
                .addTag(BlockTags.MOB_INTERACTABLE_DOORS)
        );
    }

    public CozyDoorsData(PackProviders p) {
        generate_door(p, CozyDoors.DUNGEON_DOOR, "Dungeon Door");
        generate_door(p, CozyDoors.FOLDING_DOOR, "Folding Door");
        generate_door(p, CozyDoors.STAINED_GLASS_DOOR, "Stained Glass Door");

    }
}
