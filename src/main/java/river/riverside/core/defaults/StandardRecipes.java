package river.riverside.core.defaults;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import river.riverside.core.instructions.RecipeInstruction;
import river.riverside.feature.olive_trees.OliveTrees;

public final class StandardRecipes {


    private static RecipeInstruction standard(
            RecipeInstruction.RecipeType type,
            ItemLike b,
            ItemLike base
    ) {
        return new RecipeInstruction()
                .type(type)
                .category(RecipeCategory.BUILDING_BLOCKS)
                .group("planks")
                .target(b)
                .baseBlock(base);
    }

    public static RecipeInstruction woodenWall(Block b, Block planks) {
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

    public static RecipeInstruction planks(Block b, TagKey<Item> tag) {
        return new RecipeInstruction()
                .type(RecipeInstruction.RecipeType.PLANKS)
                .category(RecipeCategory.BUILDING_BLOCKS)
                .group("planks")
                .target(b)
                .tagKey(tag);

    }

    public static RecipeInstruction fence(Block target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.FENCE, target, base);
    }

    public static RecipeInstruction fenceGate(Block target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.GATE, target, base);
    }


    public static RecipeInstruction stair(Block target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.STAIR, target, base);
    }

    public static RecipeInstruction button(Block target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.BUTTON, target, base);
    }

    public static RecipeInstruction pressurePlate(Block target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.PRESSURE_PLATE, target, base);
    }

    public static RecipeInstruction trapdoor(Block target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.TRAPDOOR, target, base);
    }


    public static RecipeInstruction sign(Item target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.SIGN, target, base);
    }

    public static RecipeInstruction hangingSign(Item target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.HANGING_SIGN, target, base);
    }

    public static RecipeInstruction door(Block target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.DOOR, target, base);
    }

    public static RecipeInstruction slab(Block target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.SLAB, target, base);
    }


    public static RecipeInstruction wood(Block target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.WOOD, target, base);
    }


    public static RecipeInstruction shelf(Block target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.SHELF, target, base);
    }
    public static RecipeInstruction boat(Item target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.BOAT, target, base);
    }
    public static RecipeInstruction chestBoat(Item target, ItemLike base) {
        return standard(RecipeInstruction.RecipeType.CHEST_BOAT, target, base);
    }


}
