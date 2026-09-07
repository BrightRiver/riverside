package river.riverside.core.defaults;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import river.riverside.core.instructions.*;
import river.riverside.core.providers.PackProviders;

public class WoodSetData {

    private static LanguageInstruction language(ItemLike b, String englishName) {
        return new LanguageInstruction()
                .target(b)
                .englishName(englishName);
    }

    private static BlockLootInstruction basicLoot(Block b) {
        return new BlockLootInstruction()
                .target(b);
    }


    private static BlockLootInstruction basicBlockItemLoot(Item i) {
        return new BlockLootInstruction()
                .target(Block.byItem(i));
    }

    private void generateFamily(PackProviders p, WoodSet woodSet, String englishName) {
        ModelInstruction instruction = new ModelInstruction()
                .type(ModelInstruction.ModelType.WOOD_FAMILY)
                .block(woodSet.getPlanks())
                .blockFamily(woodSet.getFamily());
        p.modelProvider().add(instruction);


        p.lootProvider().add(basicLoot(woodSet.getPlanks()));
        p.recipeProvider().add(StandardRecipes.planks(woodSet.getPlanks(), woodSet.getLogsTag()));
        p.languageProvider().add(language(woodSet.getPlanks(), "%s Planks".formatted(englishName)));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getPlanks())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.PLANKS)
        );


        p.lootProvider().add(basicLoot(woodSet.getFence()));
        p.recipeProvider().add(StandardRecipes.fence(woodSet.getFence(), woodSet.getPlanks()));
        p.languageProvider().add(language(woodSet.getFence(), "%s Fence".formatted(englishName)));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getFence())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.FENCES)
                .addTag(BlockTags.WOODEN_FENCES)
        );


        p.lootProvider().add(basicLoot(woodSet.getFenceGate()));
        p.recipeProvider().add(StandardRecipes.fenceGate(woodSet.getFenceGate(), woodSet.getPlanks()));
        p.languageProvider().add(language(woodSet.getFenceGate(), "%s Fence Gate".formatted(englishName)));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getFenceGate())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.FENCE_GATES)
        );


        p.lootProvider().add(basicLoot(woodSet.getWall()));
        p.recipeProvider().add(StandardRecipes.woodenWall(woodSet.getWall(), woodSet.getPlanks()));
        p.languageProvider().add(language(woodSet.getWall(), "%s Wall".formatted(englishName)));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getWall())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.WALLS)
        );

        p.lootProvider().add(basicLoot(woodSet.getStair()));
        p.recipeProvider().add(StandardRecipes.stair(woodSet.getStair(), woodSet.getPlanks()));
        p.languageProvider().add(language(woodSet.getStair(), "%s Stairs".formatted(englishName)));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getStair())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.STAIRS)
        );

        p.lootProvider().add(basicLoot(woodSet.getButton()));
        p.recipeProvider().add(StandardRecipes.button(woodSet.getButton(), woodSet.getPlanks()));
        p.languageProvider().add(language(woodSet.getButton(), "%s Button".formatted(englishName)));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getButton())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.BUTTONS)
                .addTag(BlockTags.WOODEN_BUTTONS)
        );


        p.lootProvider().add(basicLoot(woodSet.getPressurePlate()));
        p.recipeProvider().add(StandardRecipes.pressurePlate(woodSet.getPressurePlate(), woodSet.getPlanks()));
        p.languageProvider().add(language(woodSet.getPressurePlate(), "%s Pressure Plate".formatted(englishName)));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getPressurePlate())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.PRESSURE_PLATES)
                .addTag(BlockTags.WOODEN_PRESSURE_PLATES)
        );

        p.lootProvider().add(basicLoot(woodSet.getTrapdoor()));
        p.recipeProvider().add(StandardRecipes.trapdoor(woodSet.getTrapdoor(), woodSet.getPlanks()));
        p.languageProvider().add(language(woodSet.getTrapdoor(), "%s Trapdoor".formatted(englishName)));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getTrapdoor())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.TRAPDOORS)
                .addTag(BlockTags.WOODEN_TRAPDOORS)
        );

        p.lootProvider().add(basicBlockItemLoot(woodSet.getSignItem()));
        p.lootProvider().add(basicLoot(woodSet.getWallSign()));
        p.recipeProvider().add(StandardRecipes.sign(woodSet.getSignItem(), woodSet.getPlanks()));
        p.languageProvider().add(language(woodSet.getSignItem(), "%s Sign".formatted(englishName)));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getWallSign())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.SIGNS)
                .addTag(BlockTags.ALL_SIGNS)
                .addTag(BlockTags.WALL_SIGNS)
        );

        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getSign())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.SIGNS)
                .addTag(BlockTags.ALL_SIGNS)
                .addTag(BlockTags.STANDING_SIGNS)
        );

        p.lootProvider().add(basicBlockItemLoot(woodSet.getHangingSignItem()));
        p.lootProvider().add(basicLoot(woodSet.getWallHangingSign()));
        p.recipeProvider().add(StandardRecipes.hangingSign(woodSet.getHangingSignItem(), woodSet.getStrippedLog()));
        p.languageProvider().add(language(woodSet.getHangingSignItem(), "%s Hanging Sign".formatted(englishName)));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getWallHangingSign())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.SIGNS)
                .addTag(BlockTags.ALL_HANGING_SIGNS)
                .addTag(BlockTags.WALL_HANGING_SIGNS)
        );

        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getHangingSign())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.SIGNS)
                .addTag(BlockTags.ALL_HANGING_SIGNS)
                .addTag(BlockTags.CEILING_HANGING_SIGNS)
        );


        p.lootProvider().add(new BlockLootInstruction()
                .dropType(BlockLootInstruction.DropType.DOOR)
                .target(woodSet.getDoor()));
        p.recipeProvider().add(StandardRecipes.door(woodSet.getDoor(), woodSet.getPlanks()));
        p.languageProvider().add(language(woodSet.getDoor(), "%s Door".formatted(englishName)));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getDoor())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.DOORS)
                .addTag(BlockTags.WOODEN_DOORS)
                .addTag(BlockTags.MOB_INTERACTABLE_DOORS)
        );

        p.lootProvider().add(new BlockLootInstruction()
                .dropType(BlockLootInstruction.DropType.SLAB)
                .target(woodSet.getSlab()));
        p.recipeProvider().add(StandardRecipes.slab(woodSet.getSlab(), woodSet.getPlanks()));
        p.languageProvider().add(language(woodSet.getSlab(), "%s Slab".formatted(englishName)));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getSlab())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.SLABS)
                .addTag(BlockTags.WOODEN_SLABS)
        );

    }

    private void generateLogs(PackProviders p, WoodSet woodSet, String englishName) {
        ModelInstruction logInstruction = new ModelInstruction()
                .type(ModelInstruction.ModelType.LOG)
                .block(woodSet.getLog())
                .variant(woodSet.getWood());
        p.modelProvider().add(logInstruction);

        ModelInstruction strippedInstruction = new ModelInstruction()
                .type(ModelInstruction.ModelType.LOG)
                .block(woodSet.getStrippedLog())
                .variant(woodSet.getStrippedWood());
        p.modelProvider().add(strippedInstruction);

        p.recipeProvider().add(StandardRecipes.wood(woodSet.getWood(), woodSet.getLog()));
        p.languageProvider().add(language(woodSet.getWood(), "%s Wood".formatted(englishName)));
        p.languageProvider().add(language(woodSet.getLog(), "%s Log".formatted(englishName)));
        p.recipeProvider().add(StandardRecipes.wood(woodSet.getStrippedWood(), woodSet.getStrippedLog()));
        p.languageProvider().add(language(woodSet.getStrippedWood(), "Stripped %s Wood".formatted(englishName)));
        p.languageProvider().add(language(woodSet.getStrippedLog(), "Stripped %s Log".formatted(englishName)));


        p.lootProvider().add(basicLoot(woodSet.getWood()));
        p.lootProvider().add(basicLoot(woodSet.getLog()));
        p.lootProvider().add(basicLoot(woodSet.getStrippedWood()));
        p.lootProvider().add(basicLoot(woodSet.getStrippedLog()));

        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getWood())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.LOGS)
        );


        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getLog())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.LOGS)
        );


        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getStrippedWood())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.LOGS)
        );


        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getStrippedLog())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.LOGS)
        );

        p.itemTagProvider().add(new ItemTagInstruction()
                .target(woodSet.getWood().asItem())
                .addTag(woodSet.getLogsTag())
        );

        p.itemTagProvider().add(new ItemTagInstruction()
                .target(woodSet.getLog().asItem())
                .addTag(woodSet.getLogsTag())
        );

        p.itemTagProvider().add(new ItemTagInstruction()
                .target(woodSet.getStrippedWood().asItem())
                .addTag(woodSet.getLogsTag())
        );

        p.itemTagProvider().add(new ItemTagInstruction()
                .target(woodSet.getStrippedLog().asItem())
                .addTag(woodSet.getLogsTag())
        );


    }

    private void generateShelf(PackProviders p, WoodSet woodSet, String englishName) {
        ModelInstruction instruction = new ModelInstruction()
                .type(ModelInstruction.ModelType.SHELF)
                .block(woodSet.getShelf())
                .baseBlock(woodSet.getStrippedLog());
        p.modelProvider().add(instruction);
        p.lootProvider().add(basicLoot(woodSet.getShelf()));

        p.recipeProvider().add(StandardRecipes.shelf(woodSet.getShelf(), woodSet.getStrippedLog()));
        p.languageProvider().add(language(woodSet.getShelf(), "%s Shelf".formatted(englishName)));

        p.blockTagProvider().add(new BlockTagInstruction()
                .target(woodSet.getShelf())
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.WOODEN_SHELVES)
        );


    }

    private void generateBoats(PackProviders p, WoodSet woodSet, String englishName) {
        ModelInstruction boatInstruction = new ModelInstruction()
                .type(ModelInstruction.ModelType.FLAT)
                .item(woodSet.getBoatItem());
        p.modelProvider().addItem(boatInstruction);
        p.recipeProvider().add(StandardRecipes.boat(woodSet.getBoatItem(), woodSet.getPlanks()));
        p.languageProvider().add(language(woodSet.getBoatItem(), "%s Boat".formatted(englishName)));

        ModelInstruction chestBoatInstruction = new ModelInstruction()
                .type(ModelInstruction.ModelType.FLAT)
                .item(woodSet.getChestBoatItem());
        p.modelProvider().addItem(chestBoatInstruction);
        p.recipeProvider().add(StandardRecipes.chestBoat(woodSet.getChestBoatItem(), woodSet.getPlanks()));

        p.languageProvider().add(language(woodSet.getChestBoatItem(), "%s Chest Boat".formatted(englishName)));

    }

    public WoodSetData(PackProviders providers, WoodSet woodSet, String englishName) {
        generateFamily(providers, woodSet, englishName);
        generateLogs(providers, woodSet, englishName);
        generateShelf(providers, woodSet, englishName);
        generateBoats(providers, woodSet, englishName);
    }
}
