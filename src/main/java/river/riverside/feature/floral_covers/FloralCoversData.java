package river.riverside.feature.floral_covers;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import river.riverside.core.instructions.BlockLootInstruction;
import river.riverside.core.instructions.BlockTagInstruction;
import river.riverside.core.instructions.LanguageInstruction;
import river.riverside.core.instructions.RecipeInstruction;
import river.riverside.core.providers.PackProviders;

public class FloralCoversData {

    private static RecipeInstruction coverRecipe(Block b, ItemLike flower) {
        return new RecipeInstruction()
                .category(RecipeCategory.BUILDING_BLOCKS)
                .group("floral_cover")
                .target(b)
                .count(4)
                .unlockItem(flower)
                .pattern("FF")
                .pattern("FF")
                .ingredient('F', flower);
    }


    private static LanguageInstruction coverLanguage(Block b, String englishName) {
        return new LanguageInstruction()
                .target(b)
                .englishName(englishName);
    }

    private static BlockTagInstruction coverTags(Block b) {
        return new BlockTagInstruction()
                .target(b)
                .addTag(BlockTags.MINEABLE_WITH_HOE)
                .addTag(BlockTags.SHEARS_MINOR_BREAKING_SPEED)
                .addTag(BlockTags.REPLACEABLE)
                .addTag(BlockTags.CLIMBABLE)
                .addTag(BlockTags.FALL_DAMAGE_RESETTING);
    }

    private static BlockLootInstruction coverLoot(Block b) {
        return new BlockLootInstruction()
                .target(b);
    }

    private void generateFloralCover(PackProviders p, Block cover, String name, ItemLike craftingIngredient) {
        p.blockTagProvider().add(coverTags(cover));
        p.lootProvider().add(coverLoot(cover));
        p.recipeProvider().add(coverRecipe(cover, craftingIngredient));
        p.languageProvider().add(coverLanguage(cover, name));
    }

    public FloralCoversData(PackProviders p) {
        generateFloralCover(p, FloralCovers.SUNFLOWER_COVER, "Sunflower Cover", Items.SUNFLOWER);
    }

}
