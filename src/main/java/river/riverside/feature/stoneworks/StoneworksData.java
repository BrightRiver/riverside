package river.riverside.feature.stoneworks;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import river.riverside.core.defaults.StandardRecipes;
import river.riverside.core.instructions.BlockLootInstruction;
import river.riverside.core.instructions.BlockTagInstruction;
import river.riverside.core.instructions.LanguageInstruction;
import river.riverside.core.instructions.ModelInstruction;
import river.riverside.core.providers.PackProviders;

public class StoneworksData {

    public StoneworksData(PackProviders providers) {
        generateStonework(providers, Blocks.COBBLESTONE, Stoneworks.COBBLESTONE, "Cobblestone");
        generateStonework(providers, Blocks.MOSSY_COBBLESTONE, Stoneworks.MOSSY_COBBLESTONE, "Mossy Cobblestone");
        generateStonework(providers, Blocks.STONE, Stoneworks.STONE, "Stone");
        generateStonework(providers, Blocks.STONE_BRICKS, Stoneworks.STONE_BRICKS, "Stone Brick");
        generateStonework(providers, Blocks.MOSSY_STONE_BRICKS, Stoneworks.MOSSY_STONE_BRICKS, "Mossy Stone Brick");
        generateStonework(providers, Blocks.CRACKED_STONE_BRICKS, Stoneworks.CRACKED_STONE_BRICKS, "Cracked Stone Brick");
        generateStonework(providers, Blocks.SMOOTH_STONE, Stoneworks.SMOOTH_STONE, "Smooth Stone");
        generateStonework(providers, Blocks.ANDESITE, Stoneworks.ANDESITE, "Andesite");
        generateStonework(providers, Blocks.POLISHED_ANDESITE, Stoneworks.POLISHED_ANDESITE, "Polished Andesite");
        generateStonework(providers, Blocks.GRANITE, Stoneworks.GRANITE, "Granite");
        generateStonework(providers, Blocks.POLISHED_GRANITE, Stoneworks.POLISHED_GRANITE, "Polished Granite");
        generateStonework(providers, Blocks.DIORITE, Stoneworks.DIORITE, "Diorite");
        generateStonework(providers, Blocks.POLISHED_DIORITE, Stoneworks.POLISHED_DIORITE, "Polished Diorite");
        generateStonework(providers, Blocks.CALCITE, Stoneworks.CALCITE, "Calcite");
        generateStonework(providers, Blocks.DEEPSLATE, Stoneworks.DEEPSLATE, "Deepslate");
        generateStonework(providers, Blocks.COBBLED_DEEPSLATE, Stoneworks.COBBLED_DEEPSLATE, "Cobbled Deepslate");
        generateStonework(providers, Blocks.POLISHED_DEEPSLATE, Stoneworks.POLISHED_DEEPSLATE, "Polished Deepslate");
        generateStonework(providers, Blocks.DEEPSLATE_TILES, Stoneworks.DEEPSLATE_TILES, "Deepslate Tile");
        generateStonework(providers, Blocks.DEEPSLATE_BRICKS, Stoneworks.DEEPSLATE_BRICKS, "Deepslate Brick");
        generateStonework(providers, Blocks.BASALT, Stoneworks.BASALT, "Basalt");
        generateStonework(providers, Blocks.POLISHED_BASALT, Stoneworks.POLISHED_BASALT, "Polished Basalt");
        generateStonework(providers, Blocks.SMOOTH_BASALT, Stoneworks.SMOOTH_BASALT, "Smooth Basalt");
        generateStonework(providers, Blocks.BLACKSTONE, Stoneworks.BLACKSTONE, "Blackstone");
        generateStonework(providers, Blocks.POLISHED_BLACKSTONE, Stoneworks.POLISHED_BLACKSTONE, "Polished Blackstone");
        generateStonework(providers, Blocks.POLISHED_BLACKSTONE_BRICKS, Stoneworks.POLISHED_BLACKSTONE_BRICKS, "Polished Blackstone Brick");
        generateStonework(providers, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, Stoneworks.CRACKED_POLISHED_BLACKSTONE_BRICKS, "Cracked Polished Blackstone Brick");
        generateStonework(providers, Blocks.TUFF, Stoneworks.TUFF, "Tuff");
        generateStonework(providers, Blocks.POLISHED_TUFF, Stoneworks.POLISHED_TUFF, "Polished Tuff");
        generateStonework(providers, Blocks.TUFF_BRICKS, Stoneworks.TUFF_BRICKS, "Tuff Brick");
        generateStonework(providers, Blocks.BRICKS, Stoneworks.BRICKS, "Brick");
        generateStonework(providers, Blocks.MUD, Stoneworks.PACKED_MUD, "Packed Mud");
        generateStonework(providers, Blocks.MUD_BRICKS, Stoneworks.MUD_BRICKS, "Mud Brick");
        generateStonework(providers, Blocks.RESIN_BLOCK, Stoneworks.RESIN_BLOCK, "Resin Block");
        generateStonework(providers, Blocks.RESIN_BRICKS, Stoneworks.RESIN_BRICKS, "Resin Brick");
        generateStonework(providers, Blocks.SANDSTONE, Stoneworks.SANDSTONE, "Sandstone");
        generateStonework(providers, Blocks.SMOOTH_SANDSTONE, Stoneworks.SMOOTH_SANDSTONE, "Smooth Sandstone");
        generateStonework(providers, Blocks.CUT_SANDSTONE, Stoneworks.CUT_SANDSTONE, "Cut Sandstone");
        generateStonework(providers, Blocks.RED_SANDSTONE, Stoneworks.RED_SANDSTONE, "Red Sandstone");
        generateStonework(providers, Blocks.SMOOTH_RED_SANDSTONE, Stoneworks.SMOOTH_RED_SANDSTONE, "Smooth Red Sandstone");
        generateStonework(providers, Blocks.CUT_RED_SANDSTONE, Stoneworks.CUT_RED_SANDSTONE, "Cut Red Sandstone");
        generateStonework(providers, Blocks.CINNABAR, Stoneworks.CINNABAR, "Cinnabar");
        generateStonework(providers, Blocks.CINNABAR_BRICKS, Stoneworks.CINNABAR_BRICKS, "Cinnabar Bricks");
        generateStonework(providers, Blocks.POLISHED_CINNABAR, Stoneworks.POLISHED_CINNABAR, "Polished Cinnabar");
        generateStonework(providers, Blocks.SULFUR, Stoneworks.SULFUR, "Sulfur");
        generateStonework(providers, Blocks.POLISHED_SULFUR, Stoneworks.POLISHED_SULFUR, "Polished Sulfur");
        generateStonework(providers, Blocks.SULFUR_BRICKS, Stoneworks.SULFUR_BRICKS, "Sulfur Brick");
        generateStonework(providers, Blocks.PRISMARINE, Stoneworks.PRISMARINE, "Prismarine");
        generateStonework(providers, Blocks.PRISMARINE_BRICKS, Stoneworks.PRISMARINE_BRICKS, "Prismarine Brick");
        generateStonework(providers, Blocks.DARK_PRISMARINE, Stoneworks.DARK_PRISMARINE, "Dark Prismarine");
        generateStonework(providers, Blocks.NETHER_BRICKS, Stoneworks.NETHER_BRICKS, "Nether Brick");
        generateStonework(providers, Blocks.CRACKED_NETHER_BRICKS, Stoneworks.CRACKED_NETHER_BRICKS, "Cracked Nether Brick");
        generateStonework(providers, Blocks.RED_NETHER_BRICKS, Stoneworks.RED_NETHER_BRICKS, "Red Nether Bricks");
        generateStonework(providers, Blocks.END_STONE, Stoneworks.END_STONE, "End Stone");
        generateStonework(providers, Blocks.END_STONE_BRICKS, Stoneworks.END_STONE_BRICKS, "End Stone Brick");
        generateStonework(providers, Blocks.PURPUR_BLOCK, Stoneworks.PURPUR_BLOCK, "Purpur");
        generateStonework(providers, Blocks.QUARTZ_BLOCK, Stoneworks.QUARTZ_BLOCK, "Quartz");
        generateStonework(providers, Blocks.SMOOTH_QUARTZ, Stoneworks.SMOOTH_QUARTZ, "Smooth Quartz");
        generateStonework(providers, Blocks.QUARTZ_BRICKS, Stoneworks.QUARTZ_BRICKS, "Quartz Brick");
        generateStonework(providers, Blocks.AMETHYST_BLOCK, Stoneworks.AMETHYST_BLOCK, "Amethyst");

        generateStonework(providers, Blocks.PACKED_ICE, Stoneworks.PACKED_ICE, "Packed Ice");
        generateStonework(providers, Blocks.BLUE_ICE, Stoneworks.BLUE_ICE, "Blue Ice");
        generateStonework(providers, Blocks.SNOW_BLOCK, Stoneworks.SNOW_BLOCK, "Snow");
        generateStonework(providers, Blocks.CONCRETE.white(), Stoneworks.WHITE_CONCRETE, "White Concrete");
        generateStonework(providers, Blocks.CONCRETE.orange(), Stoneworks.ORANGE_CONCRETE, "Orange Concrete");
        generateStonework(providers, Blocks.CONCRETE.magenta(), Stoneworks.MAGENTA_CONCRETE, "Magenta Concrete");
        generateStonework(providers, Blocks.CONCRETE.lightBlue(), Stoneworks.LIGHT_BLUE_CONCRETE, "Light Blue Concrete");
        generateStonework(providers, Blocks.CONCRETE.yellow(), Stoneworks.YELLOW_CONCRETE, "Yellow Concrete");
        generateStonework(providers, Blocks.CONCRETE.lime(), Stoneworks.LIME_CONCRETE, "Lime Concrete");
        generateStonework(providers, Blocks.CONCRETE.pink(), Stoneworks.PINK_CONCRETE, "Pink Concrete");
        generateStonework(providers, Blocks.CONCRETE.gray(), Stoneworks.GRAY_CONCRETE, "Gray Concrete");
        generateStonework(providers, Blocks.CONCRETE.lightGray(), Stoneworks.LIGHT_GRAY_CONCRETE, "Light Gray Concrete");
        generateStonework(providers, Blocks.CONCRETE.cyan(), Stoneworks.CYAN_CONCRETE, "Cyan Concrete");
        generateStonework(providers, Blocks.CONCRETE.purple(), Stoneworks.PURPLE_CONCRETE, "Purple Concrete");
        generateStonework(providers, Blocks.CONCRETE.blue(), Stoneworks.BLUE_CONCRETE, "Blue Concrete");
        generateStonework(providers, Blocks.CONCRETE.brown(), Stoneworks.BROWN_CONCRETE, "Brown Concrete");
        generateStonework(providers, Blocks.CONCRETE.green(), Stoneworks.GREEN_CONCRETE, "Green Concrete");
        generateStonework(providers, Blocks.CONCRETE.red(), Stoneworks.RED_CONCRETE, "Red Concrete");
        generateStonework(providers, Blocks.CONCRETE.black(), Stoneworks.BLACK_CONCRETE, "Black Concrete");
        generateStonework(providers, Blocks.TERRACOTTA, Stoneworks.TERRACOTTA, "Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.white(), Stoneworks.WHITE_TERRACOTTA, "White Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.orange(), Stoneworks.ORANGE_TERRACOTTA, "Orange Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.magenta(), Stoneworks.MAGENTA_TERRACOTTA, "Magenta Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.lightBlue(), Stoneworks.LIGHT_BLUE_TERRACOTTA, "Light Blue Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.yellow(), Stoneworks.YELLOW_TERRACOTTA, "Yellow Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.lime(), Stoneworks.LIME_TERRACOTTA, "Lime Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.pink(), Stoneworks.PINK_TERRACOTTA, "Pink Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.gray(), Stoneworks.GRAY_TERRACOTTA, "Gray Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.lightGray(), Stoneworks.LIGHT_GRAY_TERRACOTTA, "Light Gray Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.cyan(), Stoneworks.CYAN_TERRACOTTA, "Cyan Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.purple(), Stoneworks.PURPLE_TERRACOTTA, "Purple Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.blue(), Stoneworks.BLUE_TERRACOTTA, "Blue Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.brown(), Stoneworks.BROWN_TERRACOTTA, "Brown Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.green(), Stoneworks.GREEN_TERRACOTTA, "Green Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.red(), Stoneworks.RED_TERRACOTTA, "Red Terracotta");
        generateStonework(providers, Blocks.DYED_TERRACOTTA.black(), Stoneworks.BLACK_TERRACOTTA, "Black Terracotta");


    }

    private void generateStonework(PackProviders providers, Block base, StoneWorkSet blockSet, String name) {
        //model set

        providers.modelProvider().add(
                new ModelInstruction()
                        .type(ModelInstruction.ModelType.STONE_WORKS)
                        .stoneWorkSet(blockSet)
                        .baseBlock(base)
        );

        //additionals for each block
        additionalData(providers, blockSet.pillar(), base, "%s Pillar".formatted(name));
        additionalData(providers, blockSet.pillarBase(), base, "%s Pillar Base".formatted(name));
        additionalData(providers, blockSet.pillarTop(), base, "%s Pillar Top".formatted(name));
        additionalData(providers, blockSet.cornice(), base, "%s Cornice".formatted(name));
        additionalData(providers, blockSet.sill(), base, "%s Sill".formatted(name));
        additionalData(providers, blockSet.coping(), base, "%s Coping".formatted(name));
        additionalData(providers, blockSet.support(), base, "%s Support".formatted(name));
        additionalData(providers, blockSet.slope(), base, "%s Slope".formatted(name));
        additionalData(providers, blockSet.shallowSlopeLower(), base, "%s Shallow Slope Lower".formatted(name));
        additionalData(providers, blockSet.shallowSlopeUpper(), base, "%s Shallow Slope Upper".formatted(name));

    }

    private void additionalData(PackProviders p, Block b, Block s, String name) {
        p.recipeProvider().add(StandardRecipes.stoneCutter(b, s));
        p.lootProvider().add(basicLoot(b));
        p.languageProvider().add(language(b, name));
        p.blockTagProvider().add(new BlockTagInstruction()
                .target(b)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
        );
    }

    private static LanguageInstruction language(ItemLike b, String englishName) {
        return new LanguageInstruction()
                .target(b)
                .englishName(englishName);
    }

    private static BlockLootInstruction basicLoot(Block b) {
        return new BlockLootInstruction()
                .target(b);
    }


}
