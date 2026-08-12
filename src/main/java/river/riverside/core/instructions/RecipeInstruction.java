package river.riverside.core.instructions;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RecipeInstruction {

    public enum RecipeType {
        SHAPED,
        WOOD,
        PLANKS,
        STAIR,
        SLAB,
        BUTTON,
        PRESSURE_PLATE,
        FENCE,
        GATE,
        DOOR,
        TRAPDOOR,
        BOAT,
        CHEST_BOAT,
        SIGN,
        HANGING_SIGN,
        SHELF
    }

    private RecipeType type = RecipeType.SHAPED;
    private RecipeCategory category;
    private String group;
    private ItemLike target;
    private TagKey<Item> tagKey;
    private int count = 1;
    private ItemLike unlockItem;
    private final List<String> pattern = new ArrayList<>();
    private final Map<Character, ItemLike> ingredients = new LinkedHashMap<>();
    private ItemLike baseBlock;

    public RecipeInstruction type(RecipeType type) {
        this.type = type;
        return this;
    }

    public RecipeType type() {
        return type;
    }

    public RecipeInstruction category(RecipeCategory category) {
        this.category = category;
        return this;
    }

    public RecipeCategory category() {
        return category;
    }

    public RecipeInstruction group(String group) {
        this.group = group;
        return this;
    }

    public String group() {
        return group;
    }

    public RecipeInstruction target(ItemLike target) {
        this.target = target;
        return this;
    }

    public ItemLike target() {
        return target;
    }

    public RecipeInstruction count(int count) {
        this.count = count;
        return this;
    }

    public int count() {
        return count;
    }

    public RecipeInstruction unlockItem(ItemLike unlockItem) {
        this.unlockItem = unlockItem;
        return this;
    }

    public ItemLike unlockItem() {
        return unlockItem;
    }

    public RecipeInstruction pattern(String row) {
        pattern.add(row);
        return this;
    }

    public List<String> pattern() {
        return pattern;
    }

    public RecipeInstruction ingredient(char symbol, ItemLike ingredient) {
        ingredients.put(symbol, ingredient);
        return this;
    }

    public RecipeInstruction tagKey(TagKey<Item> tagKey){
        this.tagKey = tagKey;
        return this;
    }
    public TagKey<Item> tagKey(){
        return tagKey;
    }

    public RecipeInstruction baseBlock(ItemLike baseBlock){
        this.baseBlock = baseBlock;
        return this;
    }
    public ItemLike baseBlock(){
        return baseBlock;
    }


    public Map<Character, ItemLike> ingredients() {
        return ingredients;
    }
}
