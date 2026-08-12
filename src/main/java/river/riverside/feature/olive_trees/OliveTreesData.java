package river.riverside.feature.olive_trees;


import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import river.riverside.core.defaults.StandardRecipes;
import river.riverside.core.instructions.*;
import river.riverside.core.providers.PackProviders;

public class OliveTreesData {


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

    private void generate_oliveFamily(PackProviders p) {
        ModelInstruction instruction = new ModelInstruction()
                .type(ModelInstruction.ModelType.WOOD_FAMILY)
                .block(OliveTrees.OLIVE_PLANKS)
                .blockFamily(OliveTrees.OLIVE_FAMILY);
        p.modelProvider().add(instruction);


        p.lootProvider().add(basicLoot(OliveTrees.OLIVE_PLANKS));
        p.recipeProvider().add(StandardRecipes.planks(OliveTrees.OLIVE_PLANKS, OliveTrees.OLIVE_LOGS_TAG));
        p.languageProvider().add(language(OliveTrees.OLIVE_PLANKS,"Olive Planks"));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_PLANKS)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.PLANKS)
        );


        p.lootProvider().add(basicLoot(OliveTrees.OLIVE_FENCE));
        p.recipeProvider().add(StandardRecipes.fence(OliveTrees.OLIVE_FENCE, OliveTrees.OLIVE_PLANKS));
        p.languageProvider().add(language(OliveTrees.OLIVE_FENCE,"Olive Fence"));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_FENCE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.FENCES)
                .addTag(BlockTags.WOODEN_FENCES)
        );


        p.lootProvider().add(basicLoot(OliveTrees.OLIVE_FENCE_GATE));
        p.recipeProvider().add(StandardRecipes.fenceGate(OliveTrees.OLIVE_FENCE_GATE, OliveTrees.OLIVE_PLANKS));
        p.languageProvider().add(language(OliveTrees.OLIVE_FENCE_GATE,"Olive Fence Gate"));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_FENCE_GATE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.FENCE_GATES)
        );


        p.lootProvider().add(basicLoot(OliveTrees.OLIVE_WALL));
        p.recipeProvider().add(StandardRecipes.woodenWall(OliveTrees.OLIVE_WALL, OliveTrees.OLIVE_PLANKS));
        p.languageProvider().add(language(OliveTrees.OLIVE_WALL,"Olive Wall"));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_WALL)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.WALLS)
        );

        p.lootProvider().add(basicLoot(OliveTrees.OLIVE_STAIR));
        p.recipeProvider().add(StandardRecipes.stair(OliveTrees.OLIVE_STAIR, OliveTrees.OLIVE_PLANKS));
        p.languageProvider().add(language(OliveTrees.OLIVE_STAIR,"Olive Stairs"));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_STAIR)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.STAIRS)
        );

        p.lootProvider().add(basicLoot(OliveTrees.OLIVE_BUTTON));
        p.recipeProvider().add(StandardRecipes.button(OliveTrees.OLIVE_BUTTON, OliveTrees.OLIVE_PLANKS));
        p.languageProvider().add(language(OliveTrees.OLIVE_BUTTON,"Olive Button"));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_BUTTON)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.BUTTONS)
                .addTag(BlockTags.WOODEN_BUTTONS)
        );


        p.lootProvider().add(basicLoot(OliveTrees.OLIVE_PRESSURE_PLATE));
        p.recipeProvider().add(StandardRecipes.pressurePlate(OliveTrees.OLIVE_PRESSURE_PLATE, OliveTrees.OLIVE_PLANKS));
        p.languageProvider().add(language(OliveTrees.OLIVE_PRESSURE_PLATE,"Olive Pressure Plate"));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_PRESSURE_PLATE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.PRESSURE_PLATES)
                .addTag(BlockTags.WOODEN_PRESSURE_PLATES)
        );

        p.lootProvider().add(basicLoot(OliveTrees.OLIVE_TRAPDOOR));
        p.recipeProvider().add(StandardRecipes.trapdoor(OliveTrees.OLIVE_TRAPDOOR, OliveTrees.OLIVE_PLANKS));
        p.languageProvider().add(language(OliveTrees.OLIVE_TRAPDOOR,"Olive Trapdoor"));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_TRAPDOOR)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.TRAPDOORS)
                .addTag(BlockTags.WOODEN_TRAPDOORS)
        );

        p.lootProvider().add(basicBlockItemLoot(OliveTrees.OLIVE_SIGN_ITEM));
        p.lootProvider().add(basicLoot(OliveTrees.OLIVE_WALL_SIGN));
        p.recipeProvider().add(StandardRecipes.sign(OliveTrees.OLIVE_SIGN_ITEM, OliveTrees.OLIVE_PLANKS));
        p.languageProvider().add(language(OliveTrees.OLIVE_SIGN_ITEM,"Olive Sign"));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_WALL_SIGN)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.SIGNS)
                .addTag(BlockTags.ALL_SIGNS)
                .addTag(BlockTags.WALL_SIGNS)
        );

        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_SIGN)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.SIGNS)
                .addTag(BlockTags.ALL_SIGNS)
                .addTag(BlockTags.STANDING_SIGNS)
        );

        p.lootProvider().add(basicBlockItemLoot(OliveTrees.OLIVE_HANGING_SIGN_ITEM));
        p.lootProvider().add(basicLoot(OliveTrees.OLIVE_WALL_HANGING_SIGN));
        p.recipeProvider().add(StandardRecipes.hangingSign(OliveTrees.OLIVE_HANGING_SIGN_ITEM, OliveTrees.STRIPPED_OLIVE_LOG));
        p.languageProvider().add(language(OliveTrees.OLIVE_HANGING_SIGN_ITEM,"Olive Hanging Sign"));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_WALL_HANGING_SIGN)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.SIGNS)
                .addTag(BlockTags.ALL_HANGING_SIGNS)
                .addTag(BlockTags.WALL_HANGING_SIGNS)
        );

        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_HANGING_SIGN)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.SIGNS)
                .addTag(BlockTags.ALL_HANGING_SIGNS)
                .addTag(BlockTags.CEILING_HANGING_SIGNS)
        );


        p.lootProvider().add(new BlockLootInstruction()
                .dropType(BlockLootInstruction.DropType.DOOR)
                .target(OliveTrees.OLIVE_DOOR));
        p.recipeProvider().add(StandardRecipes.door(OliveTrees.OLIVE_DOOR, OliveTrees.OLIVE_PLANKS));
        p.languageProvider().add(language(OliveTrees.OLIVE_DOOR,"Olive Door"));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_DOOR)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.DOORS)
                .addTag(BlockTags.WOODEN_DOORS)
                .addTag(BlockTags.MOB_INTERACTABLE_DOORS)
        );

        p.lootProvider().add(new BlockLootInstruction()
                .dropType(BlockLootInstruction.DropType.SLAB)
                .target(OliveTrees.OLIVE_SLAB));
        p.recipeProvider().add(StandardRecipes.slab(OliveTrees.OLIVE_SLAB, OliveTrees.OLIVE_PLANKS));
        p.languageProvider().add(language(OliveTrees.OLIVE_SLAB,"Olive Slab"));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_SLAB)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.SLABS)
                .addTag(BlockTags.WOODEN_SLABS)
        );

    }

    private void generate_oliveLogs(PackProviders p) {
        ModelInstruction logInstruction = new ModelInstruction()
                .type(ModelInstruction.ModelType.LOG)
                .block(OliveTrees.OLIVE_LOG)
                .variant(OliveTrees.OLIVE_WOOD);
        p.modelProvider().add(logInstruction);

        ModelInstruction strippedInstruction = new ModelInstruction()
                .type(ModelInstruction.ModelType.LOG)
                .block(OliveTrees.STRIPPED_OLIVE_LOG)
                .variant(OliveTrees.STRIPPED_OLIVE_WOOD);
        p.modelProvider().add(strippedInstruction);

        p.recipeProvider().add(StandardRecipes.wood(OliveTrees.OLIVE_WOOD, OliveTrees.OLIVE_LOG));
        p.languageProvider().add(language(OliveTrees.OLIVE_WOOD,"Olive Wood"));
        p.languageProvider().add(language(OliveTrees.OLIVE_LOG,"Olive Log"));
        p.recipeProvider().add(StandardRecipes.wood(OliveTrees.STRIPPED_OLIVE_WOOD, OliveTrees.STRIPPED_OLIVE_LOG));
        p.languageProvider().add(language(OliveTrees.STRIPPED_OLIVE_WOOD,"Stripped Olive Wood"));
        p.languageProvider().add(language(OliveTrees.STRIPPED_OLIVE_LOG,"Stripped Olive Log"));



        p.lootProvider().add(basicLoot(OliveTrees.OLIVE_WOOD));
        p.lootProvider().add(basicLoot(OliveTrees.OLIVE_LOG));
        p.lootProvider().add(basicLoot(OliveTrees.STRIPPED_OLIVE_WOOD));
        p.lootProvider().add(basicLoot(OliveTrees.STRIPPED_OLIVE_LOG));

        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_WOOD)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.LOGS)
        );


        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_LOG)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.LOGS)
        );


        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.STRIPPED_OLIVE_WOOD)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.LOGS)
        );


        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.STRIPPED_OLIVE_LOG)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.LOGS)
        );

        p.itemTagProvider().add(new ItemTagInstruction()
                .target(OliveTrees.OLIVE_WOOD.asItem())
                .addTag(OliveTrees.OLIVE_LOGS_TAG)
        );

        p.itemTagProvider().add(new ItemTagInstruction()
                .target(OliveTrees.OLIVE_LOG.asItem())
                .addTag(OliveTrees.OLIVE_LOGS_TAG)
        );

        p.itemTagProvider().add(new ItemTagInstruction()
                .target(OliveTrees.STRIPPED_OLIVE_WOOD.asItem())
                .addTag(OliveTrees.OLIVE_LOGS_TAG)
        );

        p.itemTagProvider().add(new ItemTagInstruction()
                .target(OliveTrees.STRIPPED_OLIVE_LOG.asItem())
                .addTag(OliveTrees.OLIVE_LOGS_TAG)
        );


    }

    private void generate_oliveShelf(PackProviders p) {
        ModelInstruction instruction = new ModelInstruction()
                .type(ModelInstruction.ModelType.SHELF)
                .block(OliveTrees.OLIVE_SHELF)
                .baseBlock(OliveTrees.STRIPPED_OLIVE_LOG);
        p.modelProvider().add(instruction);
        p.lootProvider().add(basicLoot(OliveTrees.OLIVE_SHELF));

        p.recipeProvider().add(StandardRecipes.shelf(OliveTrees.OLIVE_SHELF, OliveTrees.STRIPPED_OLIVE_LOG));
        p.languageProvider().add(language(OliveTrees.OLIVE_SHELF,"Olive Shelf"));

        p.blockTagProvider().add(new BlockTagInstruction()
                .target(OliveTrees.OLIVE_SHELF)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.WOODEN_SHELVES)
        );


    }

    private void generate_oliveBoats(PackProviders p) {
        ModelInstruction boatInstruction = new ModelInstruction()
                .type(ModelInstruction.ModelType.FLAT)
                .item(OliveTrees.OLIVE_BOAT_ITEM);
        p.modelProvider().addItem(boatInstruction);
        p.recipeProvider().add(StandardRecipes.boat(OliveTrees.OLIVE_BOAT_ITEM, OliveTrees.OLIVE_PLANKS));
        p.languageProvider().add(language(OliveTrees.OLIVE_BOAT_ITEM,"Olive Boat"));

        ModelInstruction chestBoatInstruction = new ModelInstruction()
                .type(ModelInstruction.ModelType.FLAT)
                .item(OliveTrees.OLIVE_CHEST_BOAT_ITEM);
        p.modelProvider().addItem(chestBoatInstruction);
        p.recipeProvider().add(StandardRecipes.chestBoat(OliveTrees.OLIVE_CHEST_BOAT_ITEM, OliveTrees.OLIVE_PLANKS));

        p.languageProvider().add(language(OliveTrees.OLIVE_CHEST_BOAT_ITEM,"Olive Chest Boat"));

    }

    public OliveTreesData(PackProviders providers) {
        generate_oliveFamily(providers);
        generate_oliveLogs(providers);
        generate_oliveShelf(providers);
        generate_oliveBoats(providers);
    }
}
