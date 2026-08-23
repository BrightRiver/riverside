package river.riverside.feature.wooden_trims;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import river.riverside.core.instructions.BlockLootInstruction;
import river.riverside.core.instructions.BlockTagInstruction;
import river.riverside.core.instructions.LanguageInstruction;
import river.riverside.core.instructions.RecipeInstruction;
import river.riverside.core.providers.PackProviders;

public class WoodenTrimsData {

    private static RecipeInstruction woodenTrimRecipe(Block b, ItemLike plank) {
        return new RecipeInstruction()
                .category(RecipeCategory.BUILDING_BLOCKS)
                .group("wooden_trim")
                .target(b)
                .count(4)
                .unlockItem(plank)
                .pattern("PS")
                .pattern("SP")
                .ingredient('P', plank)
                .ingredient('S', Items.STICK);
    }


    private static LanguageInstruction woodenTrimLanguage(Block b, String englishName) {
        return new LanguageInstruction()
                .target(b)
                .englishName(englishName);
    }

    private static BlockTagInstruction woodenTrimTags(Block b) {
        return new BlockTagInstruction()
                .target(b)
                .addTag(BlockTags.MINEABLE_WITH_AXE);
    }

    private static BlockLootInstruction woodenTrimLoot(Block b) {
        return new BlockLootInstruction()
                .target(b);
    }

    private void generateWoodenTrim(PackProviders p, Block woodenTrim, String name, ItemLike craftingIngredient) {
        p.blockTagProvider().add(woodenTrimTags(woodenTrim));
        p.lootProvider().add(woodenTrimLoot(woodenTrim));
        p.recipeProvider().add(woodenTrimRecipe(woodenTrim, craftingIngredient));
        p.languageProvider().add(woodenTrimLanguage(woodenTrim, name));
    }

    public WoodenTrimsData(PackProviders p) {
        generateWoodenTrim(p, WoodenTrims.ACACIA_TRIM, "Acacia trim", Blocks.ACACIA_PLANKS);
        generateWoodenTrim(p, WoodenTrims.BAMBOO_TRIM, "Bamboo trim", Blocks.BAMBOO_PLANKS);
        generateWoodenTrim(p, WoodenTrims.BIRCH_TRIM, "Birch trim", Blocks.BIRCH_PLANKS);
        generateWoodenTrim(p, WoodenTrims.CHERRY_TRIM, "Cherry trim", Blocks.CHERRY_PLANKS);
        generateWoodenTrim(p, WoodenTrims.CRIMSON_TRIM, "Crimson trim", Blocks.CRIMSON_PLANKS);
        generateWoodenTrim(p, WoodenTrims.DARK_OAK_TRIM, "Dark Oak trim", Blocks.DARK_OAK_PLANKS);
        generateWoodenTrim(p, WoodenTrims.JUNGLE_TRIM, "Jungle trim", Blocks.JUNGLE_PLANKS);
        generateWoodenTrim(p, WoodenTrims.MANGROVE_TRIM, "Mangrove trim", Blocks.MANGROVE_PLANKS);
        generateWoodenTrim(p, WoodenTrims.OAK_TRIM, "Oak trim", Blocks.OAK_PLANKS);
        generateWoodenTrim(p, WoodenTrims.PALE_OAK_TRIM, "Pale Oak trim", Blocks.PALE_OAK_PLANKS);
        generateWoodenTrim(p, WoodenTrims.SPRUCE_TRIM, "Spruce trim", Blocks.SPRUCE_PLANKS);
        generateWoodenTrim(p, WoodenTrims.WARPED_TRIM, "Warped trim", Blocks.WARPED_PLANKS);
    }

}
