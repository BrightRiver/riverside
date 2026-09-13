package river.riverside.feature.stoneworks;

import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.world.level.block.Blocks;

public class Stoneworks {
    public static final StoneWorkSet COBBLESTONE = new StoneWorkSet(Blocks.COBBLESTONE, "cobblestone");
    public static final StoneWorkSet MOSSY_COBBLESTONE = new StoneWorkSet(Blocks.MOSSY_COBBLESTONE, "mossy_cobblestone");
    public static final StoneWorkSet STONE = new StoneWorkSet(Blocks.STONE, "stone");
    public static final StoneWorkSet STONE_BRICKS = new StoneWorkSet(Blocks.STONE_BRICKS, "stone_bricks");
    public static final StoneWorkSet MOSSY_STONE_BRICKS = new StoneWorkSet(Blocks.MOSSY_STONE_BRICKS, "mossy_stone_bricks");
    public static final StoneWorkSet CRACKED_STONE_BRICKS = new StoneWorkSet(Blocks.CRACKED_STONE_BRICKS, "cracked_stone_bricks");
    public static final StoneWorkSet SMOOTH_STONE = new StoneWorkSet(Blocks.SMOOTH_STONE, "smooth_stone");
    public static final StoneWorkSet ANDESITE = new StoneWorkSet(Blocks.ANDESITE, "andesite");
    public static final StoneWorkSet POLISHED_ANDESITE = new StoneWorkSet(Blocks.POLISHED_ANDESITE, "polished_andesite");
    public static final StoneWorkSet GRANITE = new StoneWorkSet(Blocks.GRANITE, "granite");
    public static final StoneWorkSet POLISHED_GRANITE = new StoneWorkSet(Blocks.POLISHED_GRANITE, "polished_granite");
    public static final StoneWorkSet DIORITE = new StoneWorkSet(Blocks.DIORITE, "diorite");
    public static final StoneWorkSet POLISHED_DIORITE = new StoneWorkSet(Blocks.POLISHED_DIORITE, "polished_diorite");
    public static final StoneWorkSet CALCITE = new StoneWorkSet(Blocks.CALCITE, "calcite");
    public static final StoneWorkSet DEEPSLATE = new StoneWorkSet(Blocks.DEEPSLATE, "deepslate");
    public static final StoneWorkSet COBBLED_DEEPSLATE = new StoneWorkSet(Blocks.COBBLED_DEEPSLATE, "cobbled_deepslate");
    public static final StoneWorkSet POLISHED_DEEPSLATE = new StoneWorkSet(Blocks.POLISHED_DEEPSLATE, "polished_deepslate");
    public static final StoneWorkSet DEEPSLATE_TILES = new StoneWorkSet(Blocks.DEEPSLATE_TILES, "deepslate_tiles");
    public static final StoneWorkSet DEEPSLATE_BRICKS = new StoneWorkSet(Blocks.DEEPSLATE_BRICKS, "deepslate_bricks");
    public static final StoneWorkSet BASALT = new StoneWorkSet(Blocks.BASALT, "basalt")
            .textureMapping(
                    TextureMapping.defaultTexture(
                            TextureMapping.getBlockTexture(
                                    Blocks.BASALT,
                                    "_side"
                            )
                    )
            );
    public static final StoneWorkSet POLISHED_BASALT = new StoneWorkSet(Blocks.POLISHED_BASALT, "polished_basalt")
            .textureMapping(
                    TextureMapping.defaultTexture(
                            TextureMapping.getBlockTexture(
                                    Blocks.POLISHED_BASALT,
                                    "_side"
                            )
                    )
            );
    public static final StoneWorkSet SMOOTH_BASALT = new StoneWorkSet(Blocks.SMOOTH_BASALT, "smooth_basalt");
    public static final StoneWorkSet BLACKSTONE = new StoneWorkSet(Blocks.BLACKSTONE, "blackstone");
    public static final StoneWorkSet POLISHED_BLACKSTONE = new StoneWorkSet(Blocks.POLISHED_BLACKSTONE, "polished_blackstone");
    public static final StoneWorkSet POLISHED_BLACKSTONE_BRICKS = new StoneWorkSet(Blocks.POLISHED_BLACKSTONE_BRICKS, "polished_blackstone_bricks");
    public static final StoneWorkSet CRACKED_POLISHED_BLACKSTONE_BRICKS = new StoneWorkSet(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, "cracked_polished_blackstone_bricks");
    public static final StoneWorkSet TUFF = new StoneWorkSet(Blocks.TUFF, "tuff");
    public static final StoneWorkSet POLISHED_TUFF = new StoneWorkSet(Blocks.POLISHED_TUFF, "polished_tuff");
    public static final StoneWorkSet TUFF_BRICKS = new StoneWorkSet(Blocks.TUFF_BRICKS, "tuff_bricks");
    public static final StoneWorkSet BRICKS = new StoneWorkSet(Blocks.BRICKS, "bricks");
    public static final StoneWorkSet PACKED_MUD = new StoneWorkSet(Blocks.PACKED_MUD, "packed_mud");
    public static final StoneWorkSet MUD_BRICKS = new StoneWorkSet(Blocks.MUD_BRICKS, "mud_bricks");
    public static final StoneWorkSet RESIN_BLOCK = new StoneWorkSet(Blocks.RESIN_BLOCK, "resin");
    public static final StoneWorkSet RESIN_BRICKS = new StoneWorkSet(Blocks.RESIN_BRICKS, "resin_brick");
    public static final StoneWorkSet SANDSTONE = new StoneWorkSet(Blocks.SANDSTONE, "sandstone");
    public static final StoneWorkSet SMOOTH_SANDSTONE =
            new StoneWorkSet(Blocks.SMOOTH_SANDSTONE, "smooth_sandstone")
                    .textureMapping(
                            TextureMapping.defaultTexture(
                                    TextureMapping.getBlockTexture(
                                            Blocks.SANDSTONE,
                                            "_top"
                                    )
                            )
                    );
    public static final StoneWorkSet CUT_SANDSTONE = new StoneWorkSet(Blocks.CUT_SANDSTONE, "cut_sandstone");
    public static final StoneWorkSet RED_SANDSTONE = new StoneWorkSet(Blocks.RED_SANDSTONE, "red_sandstone");

    public static final StoneWorkSet SMOOTH_RED_SANDSTONE =
            new StoneWorkSet(Blocks.SMOOTH_RED_SANDSTONE, "smooth_red_sandstone")
                    .textureMapping(
                            TextureMapping.defaultTexture(
                                    TextureMapping.getBlockTexture(
                                            Blocks.RED_SANDSTONE,
                                            "_top"
                                    )
                            )
                    );

    public static final StoneWorkSet CUT_RED_SANDSTONE = new StoneWorkSet(Blocks.CUT_RED_SANDSTONE, "cut_red_sandstone");
    public static final StoneWorkSet CINNABAR = new StoneWorkSet(Blocks.CINNABAR, "cinnabar");
    public static final StoneWorkSet CINNABAR_BRICKS = new StoneWorkSet(Blocks.CINNABAR_BRICKS, "cinnabar_bricks");
    public static final StoneWorkSet POLISHED_CINNABAR = new StoneWorkSet(Blocks.POLISHED_CINNABAR, "polished_cinnabar");
    public static final StoneWorkSet SULFUR = new StoneWorkSet(Blocks.SULFUR, "sulfur");
    public static final StoneWorkSet POLISHED_SULFUR = new StoneWorkSet(Blocks.POLISHED_SULFUR, "polished_sulfur");
    public static final StoneWorkSet SULFUR_BRICKS = new StoneWorkSet(Blocks.SULFUR_BRICKS, "sulfur_bricks");
    public static final StoneWorkSet PRISMARINE = new StoneWorkSet(Blocks.PRISMARINE, "prismarine");
    public static final StoneWorkSet PRISMARINE_BRICKS = new StoneWorkSet(Blocks.PRISMARINE_BRICKS, "prismarine_bricks");
    public static final StoneWorkSet DARK_PRISMARINE = new StoneWorkSet(Blocks.DARK_PRISMARINE, "dark_prismarine");
    public static final StoneWorkSet NETHER_BRICKS = new StoneWorkSet(Blocks.NETHER_BRICKS, "nether_bricks");
    public static final StoneWorkSet CRACKED_NETHER_BRICKS = new StoneWorkSet(Blocks.CRACKED_NETHER_BRICKS, "cracked_nether_bricks");
    public static final StoneWorkSet RED_NETHER_BRICKS = new StoneWorkSet(Blocks.RED_NETHER_BRICKS, "red_nether_bricks");
    public static final StoneWorkSet END_STONE = new StoneWorkSet(Blocks.END_STONE, "end_stone");
    public static final StoneWorkSet END_STONE_BRICKS = new StoneWorkSet(Blocks.END_STONE_BRICKS, "end_stone_bricks");
    public static final StoneWorkSet PURPUR_BLOCK = new StoneWorkSet(Blocks.PURPUR_BLOCK, "purpur_block");

    public static final StoneWorkSet QUARTZ_BLOCK =
            new StoneWorkSet(Blocks.QUARTZ_BLOCK, "quartz_block")
                    .textureMapping(
                            TextureMapping.defaultTexture(
                                    TextureMapping.getBlockTexture(
                                            Blocks.QUARTZ_BLOCK,
                                            "_side"
                                    )
                            )
                    );


    public static final StoneWorkSet SMOOTH_QUARTZ = new StoneWorkSet(Blocks.SMOOTH_QUARTZ, "smooth_quartz")
                    .textureMapping(
                            TextureMapping.defaultTexture(
                                    TextureMapping.getBlockTexture(
                                            Blocks.QUARTZ_BLOCK,
                                            "_bottom"
                                    )
                            )
                    );
    public static final StoneWorkSet QUARTZ_BRICKS = new StoneWorkSet(Blocks.QUARTZ_BRICKS, "quartz_bricks");
    public static final StoneWorkSet AMETHYST_BLOCK = new StoneWorkSet(Blocks.AMETHYST_BLOCK, "amethyst_block");

    public static final StoneWorkSet PACKED_ICE = new StoneWorkSet(Blocks.PACKED_ICE, "packed_ice");
    public static final StoneWorkSet BLUE_ICE = new StoneWorkSet(Blocks.BLUE_ICE, "blue_ice");
    public static final StoneWorkSet SNOW_BLOCK = new StoneWorkSet(Blocks.SNOW_BLOCK, "snow_block")
            .textureMapping(
                    TextureMapping.defaultTexture(
                            TextureMapping.getBlockTexture(
                                    Blocks.SNOW,
                                    ""
                            )
                    )
            );;

    public static final StoneWorkSet WHITE_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.white(), "white_concrete");
    public static final StoneWorkSet ORANGE_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.orange(), "orange_concrete");
    public static final StoneWorkSet MAGENTA_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.magenta(), "magenta_concrete");
    public static final StoneWorkSet LIGHT_BLUE_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.lightBlue(), "light_blue_concrete");
    public static final StoneWorkSet YELLOW_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.yellow(), "yellow_concrete");
    public static final StoneWorkSet LIME_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.lime(), "lime_concrete");
    public static final StoneWorkSet PINK_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.pink(), "pink_concrete");
    public static final StoneWorkSet GRAY_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.gray(), "gray_concrete");
    public static final StoneWorkSet LIGHT_GRAY_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.lightGray(), "light_gray_concrete");
    public static final StoneWorkSet CYAN_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.cyan(), "cyan_concrete");
    public static final StoneWorkSet PURPLE_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.purple(), "purple_concrete");
    public static final StoneWorkSet BLUE_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.blue(), "blue_concrete");
    public static final StoneWorkSet BROWN_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.brown(), "brown_concrete");
    public static final StoneWorkSet GREEN_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.green(), "green_concrete");
    public static final StoneWorkSet RED_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.red(), "red_concrete");
    public static final StoneWorkSet BLACK_CONCRETE = new StoneWorkSet(Blocks.CONCRETE.black(), "black_concrete");
    public static final StoneWorkSet TERRACOTTA = new StoneWorkSet(Blocks.TERRACOTTA, "terracotta");
    public static final StoneWorkSet WHITE_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.white(), "white_terracotta");
    public static final StoneWorkSet ORANGE_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.orange(), "orange_terracotta");
    public static final StoneWorkSet MAGENTA_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.magenta(), "magenta_terracotta");
    public static final StoneWorkSet LIGHT_BLUE_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.lightBlue(), "light_blue_terracotta");
    public static final StoneWorkSet YELLOW_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.yellow(), "yellow_terracotta");
    public static final StoneWorkSet LIME_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.lime(), "lime_terracotta");
    public static final StoneWorkSet PINK_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.pink(), "pink_terracotta");
    public static final StoneWorkSet GRAY_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.gray(), "gray_terracotta");
    public static final StoneWorkSet LIGHT_GRAY_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.lightGray(), "light_gray_terracotta");
    public static final StoneWorkSet CYAN_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.cyan(), "cyan_terracotta");
    public static final StoneWorkSet PURPLE_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.purple(), "purple_terracotta");
    public static final StoneWorkSet BLUE_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.blue(), "blue_terracotta");
    public static final StoneWorkSet BROWN_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.brown(), "brown_terracotta");
    public static final StoneWorkSet GREEN_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.green(), "green_terracotta");
    public static final StoneWorkSet RED_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.red(), "red_terracotta");
    public static final StoneWorkSet BLACK_TERRACOTTA = new StoneWorkSet(Blocks.DYED_TERRACOTTA.black(), "black_terracotta");


}
