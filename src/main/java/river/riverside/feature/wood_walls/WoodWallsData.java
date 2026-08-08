package river.riverside.feature.wood_walls;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import river.riverside.Riverside;
import river.riverside.core.instructions.BlockLootInstruction;
import river.riverside.core.instructions.ModelInstruction;
import river.riverside.core.instructions.BlockTagInstruction;
import river.riverside.core.instructions.RecipeInstruction;
import river.riverside.core.instructions.LanguageInstruction;
import river.riverside.core.providers.PackProviders;

public class WoodWallsData {

    private static ModelInstruction wallModel(Block b, Block f) {
        return new ModelInstruction()
                .type(ModelInstruction.ModelType.WALL)
                .block(b)
                .baseBlock(f);
    }

    private static BlockTagInstruction wallTag(Block b) {
        return new BlockTagInstruction()
                .target(b)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.WALLS);
    }

    private static BlockLootInstruction wallLoot(Block b) {
        return new BlockLootInstruction()
                .target(b);
    }

    private static RecipeInstruction wallRecipe(Block b, Block planks) {
        return new RecipeInstruction()
                .category(RecipeCategory.BUILDING_BLOCKS)
                .group("wood_walls")
                .target(b)
                .count(6)
                .unlockItem(planks)
                .pattern("PSP")
                .pattern("PPP")
                .ingredient('P', planks)
                .ingredient('S', Items.STICK);
    }

    private static LanguageInstruction wallLanguage(Block b, String englishName) {
        return new LanguageInstruction()
                .target(b)
                .englishName(englishName);
    }

    private static void generate_oakWalls(PackProviders p) {
        p.modelProvider().add(wallModel(WoodWalls.OAK_WALL, Blocks.OAK_PLANKS));
        p.tagProvider().add(wallTag(WoodWalls.OAK_WALL));
        p.lootProvider().add(wallLoot(WoodWalls.OAK_WALL));
        p.recipeProvider().add(wallRecipe(WoodWalls.OAK_WALL, Blocks.OAK_PLANKS));
        p.languageProvider().add(wallLanguage(WoodWalls.OAK_WALL, "Oak Wall"));
    }

    private static void generate_birchWalls(PackProviders p) {
        p.modelProvider().add(wallModel(WoodWalls.BIRCH_WALL, Blocks.BIRCH_PLANKS));
        p.tagProvider().add(wallTag(WoodWalls.BIRCH_WALL));
        p.lootProvider().add(wallLoot(WoodWalls.BIRCH_WALL));
        p.recipeProvider().add(wallRecipe(WoodWalls.BIRCH_WALL, Blocks.BIRCH_PLANKS));
        p.languageProvider().add(wallLanguage(WoodWalls.BIRCH_WALL, "Birch Wall"));
    }


    private static void generate_acaciaWalls(PackProviders p) {
        p.modelProvider().add(wallModel(WoodWalls.ACACIA_WALL, Blocks.ACACIA_PLANKS));
        p.tagProvider().add(wallTag(WoodWalls.ACACIA_WALL));
        p.lootProvider().add(wallLoot(WoodWalls.ACACIA_WALL));
        p.recipeProvider().add(wallRecipe(WoodWalls.ACACIA_WALL, Blocks.ACACIA_PLANKS));
        p.languageProvider().add(wallLanguage(WoodWalls.ACACIA_WALL, "Acacia Wall"));
    }

    private static void generate_bambooWalls(PackProviders p) {
        p.modelProvider().add(wallModel(WoodWalls.BAMBOO_WALL, Blocks.BAMBOO_PLANKS));
        p.tagProvider().add(wallTag(WoodWalls.BAMBOO_WALL));
        p.lootProvider().add(wallLoot(WoodWalls.BAMBOO_WALL));
        p.recipeProvider().add(wallRecipe(WoodWalls.BAMBOO_WALL, Blocks.BAMBOO_PLANKS));
        p.languageProvider().add(wallLanguage(WoodWalls.BAMBOO_WALL, "Bamboo Wall"));
    }

    private static void generate_cherryWalls(PackProviders p) {
        p.modelProvider().add(wallModel(WoodWalls.CHERRY_WALL, Blocks.CHERRY_PLANKS));
        p.tagProvider().add(wallTag(WoodWalls.CHERRY_WALL));
        p.lootProvider().add(wallLoot(WoodWalls.CHERRY_WALL));
        p.recipeProvider().add(wallRecipe(WoodWalls.CHERRY_WALL, Blocks.CHERRY_PLANKS));
        p.languageProvider().add(wallLanguage(WoodWalls.CHERRY_WALL, "Cherry Wall"));
    }

    private static void generate_crimsonWalls(PackProviders p) {
        p.modelProvider().add(wallModel(WoodWalls.CRIMSON_WALL, Blocks.CRIMSON_PLANKS));
        p.tagProvider().add(wallTag(WoodWalls.CRIMSON_WALL));
        p.lootProvider().add(wallLoot(WoodWalls.CRIMSON_WALL));
        p.recipeProvider().add(wallRecipe(WoodWalls.CRIMSON_WALL, Blocks.CRIMSON_PLANKS));
        p.languageProvider().add(wallLanguage(WoodWalls.CRIMSON_WALL, "Crimson Wall"));
    }

    private static void generate_darkOakWalls(PackProviders p) {
        p.modelProvider().add(wallModel(WoodWalls.DARK_OAK_WALL, Blocks.DARK_OAK_PLANKS));
        p.tagProvider().add(wallTag(WoodWalls.DARK_OAK_WALL));
        p.lootProvider().add(wallLoot(WoodWalls.DARK_OAK_WALL));
        p.recipeProvider().add(wallRecipe(WoodWalls.DARK_OAK_WALL, Blocks.DARK_OAK_PLANKS));
        p.languageProvider().add(wallLanguage(WoodWalls.DARK_OAK_WALL, "Dark Oak Wall"));
    }

    private static void generate_jungleWalls(PackProviders p) {
        p.modelProvider().add(wallModel(WoodWalls.JUNGLE_WALL, Blocks.JUNGLE_PLANKS));
        p.tagProvider().add(wallTag(WoodWalls.JUNGLE_WALL));
        p.lootProvider().add(wallLoot(WoodWalls.JUNGLE_WALL));
        p.recipeProvider().add(wallRecipe(WoodWalls.JUNGLE_WALL, Blocks.JUNGLE_PLANKS));
        p.languageProvider().add(wallLanguage(WoodWalls.JUNGLE_WALL, "Jungle Wall"));
    }

    private static void generate_mangroveWalls(PackProviders p) {
        p.modelProvider().add(wallModel(WoodWalls.MANGROVE_WALL, Blocks.MANGROVE_PLANKS));
        p.tagProvider().add(wallTag(WoodWalls.MANGROVE_WALL));
        p.lootProvider().add(wallLoot(WoodWalls.MANGROVE_WALL));
        p.recipeProvider().add(wallRecipe(WoodWalls.MANGROVE_WALL, Blocks.MANGROVE_PLANKS));
        p.languageProvider().add(wallLanguage(WoodWalls.MANGROVE_WALL, "Mangrove Wall"));
    }

    private static void generate_paleOakWalls(PackProviders p) {
        p.modelProvider().add(wallModel(WoodWalls.PALE_OAK_WALL, Blocks.PALE_OAK_PLANKS));
        p.tagProvider().add(wallTag(WoodWalls.PALE_OAK_WALL));
        p.lootProvider().add(wallLoot(WoodWalls.PALE_OAK_WALL));
        p.recipeProvider().add(wallRecipe(WoodWalls.PALE_OAK_WALL, Blocks.PALE_OAK_PLANKS));
        p.languageProvider().add(wallLanguage(WoodWalls.PALE_OAK_WALL, "Pale Oak Wall"));
    }

    private static void generate_spruceWalls(PackProviders p) {
        p.modelProvider().add(wallModel(WoodWalls.SPRUCE_WALL, Blocks.SPRUCE_PLANKS));
        p.tagProvider().add(wallTag(WoodWalls.SPRUCE_WALL));
        p.lootProvider().add(wallLoot(WoodWalls.SPRUCE_WALL));
        p.recipeProvider().add(wallRecipe(WoodWalls.SPRUCE_WALL, Blocks.SPRUCE_PLANKS));
        p.languageProvider().add(wallLanguage(WoodWalls.SPRUCE_WALL, "Spruce Wall"));
    }

    private static void generate_warpedWalls(PackProviders p) {
        p.modelProvider().add(wallModel(WoodWalls.WARPED_WALL, Blocks.WARPED_PLANKS));
        p.tagProvider().add(wallTag(WoodWalls.WARPED_WALL));
        p.lootProvider().add(wallLoot(WoodWalls.WARPED_WALL));
        p.recipeProvider().add(wallRecipe(WoodWalls.WARPED_WALL, Blocks.WARPED_PLANKS));
        p.languageProvider().add(wallLanguage(WoodWalls.WARPED_WALL, "Warped Wall"));
    }

    public WoodWallsData(PackProviders providers) {
        Riverside.LOGGER.info(Riverside.MOD_ID + ": wood walls data");
        generate_oakWalls(providers);
        generate_birchWalls(providers);
        generate_acaciaWalls(providers);
        generate_bambooWalls(providers);
        generate_cherryWalls(providers);
        generate_crimsonWalls(providers);
        generate_darkOakWalls(providers);
        generate_jungleWalls(providers);
        generate_mangroveWalls(providers);
        generate_paleOakWalls(providers);
        generate_spruceWalls(providers);
        generate_warpedWalls(providers);
    }
}
