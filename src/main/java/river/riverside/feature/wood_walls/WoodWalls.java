package river.riverside.feature.wood_walls;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import river.riverside.Riverside;
import river.riverside.core.Blocks;
import river.riverside.core.CreativeTabs;

import static net.minecraft.world.level.block.Blocks.*;

public class WoodWalls {
    public static Block ACACIA_WALL;
    public static Block BAMBOO_WALL;
    public static Block BIRCH_WALL;
    public static Block CHERRY_WALL;
    public static Block CRIMSON_WALL;
    public static Block DARK_OAK_WALL;
    public static Block JUNGLE_WALL;
    public static Block MANGROVE_WALL;
    public static Block OAK_WALL;
    public static Block PALE_OAK_WALL;
    public static Block SPRUCE_WALL;
    public static Block WARPED_WALL;

    private static BlockBehaviour.Properties woodProperties(BlockBehaviour.Properties p, Block mapBlock) {
        return p.mapColor(mapBlock.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava();
    }
    private static void register_acaciaWalls() {
        ACACIA_WALL = Blocks.registerBlock("acacia_wall", properties -> new WallBlock(woodProperties(properties, ACACIA_PLANKS)));
        CreativeTabs.acceptAfter(CreativeModeTabs.BUILDING_BLOCKS, ACACIA_FENCE_GATE, ACACIA_WALL);
    }

    private static void register_bambooWalls() {
        BAMBOO_WALL = Blocks.registerBlock("bamboo_wall", properties -> new WallBlock(woodProperties(properties, BAMBOO_PLANKS)));
        CreativeTabs.acceptAfter(CreativeModeTabs.BUILDING_BLOCKS, BAMBOO_FENCE_GATE, BAMBOO_WALL);
    }

    private static void register_birchWalls() {
        BIRCH_WALL = Blocks.registerBlock("birch_wall", properties -> new WallBlock(woodProperties(properties, BIRCH_PLANKS)));
        CreativeTabs.acceptAfter(CreativeModeTabs.BUILDING_BLOCKS, BIRCH_FENCE_GATE, BIRCH_WALL);
    }

    private static void register_cherryWalls() {
        CHERRY_WALL = Blocks.registerBlock("cherry_wall", properties -> new WallBlock(woodProperties(properties, CHERRY_PLANKS)));
        CreativeTabs.acceptAfter(CreativeModeTabs.BUILDING_BLOCKS, CHERRY_FENCE_GATE, CHERRY_WALL);
    }

    private static void register_crimsonWalls() {
        CRIMSON_WALL = Blocks.registerBlock("crimson_wall", properties -> new WallBlock(woodProperties(properties, CRIMSON_PLANKS)));
        CreativeTabs.acceptAfter(CreativeModeTabs.BUILDING_BLOCKS, CRIMSON_FENCE_GATE, CRIMSON_WALL);
    }

    private static void register_darkOakWalls() {
        DARK_OAK_WALL = Blocks.registerBlock("dark_oak_wall", properties -> new WallBlock(woodProperties(properties, DARK_OAK_PLANKS)));
        CreativeTabs.acceptAfter(CreativeModeTabs.BUILDING_BLOCKS, DARK_OAK_FENCE_GATE, DARK_OAK_WALL);
    }

    private static void register_jungleWalls() {
        JUNGLE_WALL = Blocks.registerBlock("jungle_wall", properties -> new WallBlock(woodProperties(properties, JUNGLE_PLANKS)));
        CreativeTabs.acceptAfter(CreativeModeTabs.BUILDING_BLOCKS, JUNGLE_FENCE_GATE, JUNGLE_WALL);
    }

    private static void register_mangroveWalls() {
        MANGROVE_WALL = Blocks.registerBlock("mangrove_wall", properties -> new WallBlock(woodProperties(properties, MANGROVE_PLANKS)));
        CreativeTabs.acceptAfter(CreativeModeTabs.BUILDING_BLOCKS, MANGROVE_FENCE_GATE, MANGROVE_WALL);
    }

    private static void register_oakWalls() {
        OAK_WALL = Blocks.registerBlock("oak_wall", properties -> new WallBlock(woodProperties(properties, OAK_PLANKS)));
        CreativeTabs.acceptAfter(CreativeModeTabs.BUILDING_BLOCKS, OAK_FENCE_GATE, OAK_WALL);
    }

    private static void register_paleOakWalls() {
        PALE_OAK_WALL = Blocks.registerBlock("pale_oak_wall", properties -> new WallBlock(woodProperties(properties, PALE_OAK_PLANKS)));
        CreativeTabs.acceptAfter(CreativeModeTabs.BUILDING_BLOCKS, PALE_OAK_FENCE_GATE, PALE_OAK_WALL);
    }

    private static void register_spruceWalls() {
        SPRUCE_WALL = Blocks.registerBlock("spruce_wall", properties -> new WallBlock(woodProperties(properties, SPRUCE_PLANKS)));
        CreativeTabs.acceptAfter(CreativeModeTabs.BUILDING_BLOCKS, SPRUCE_FENCE_GATE, SPRUCE_WALL);
    }

    private static void register_warpedWalls() {
        WARPED_WALL = Blocks.registerBlock("warped_wall", properties -> new WallBlock(woodProperties(properties, WARPED_PLANKS)));
        CreativeTabs.acceptAfter(CreativeModeTabs.BUILDING_BLOCKS, WARPED_FENCE_GATE, WARPED_WALL);
    }

    public static void initialize() {
        Riverside.LOGGER.info(Riverside.MOD_ID + ": Initializing Wood Walls");
        register_oakWalls();
        register_birchWalls();
        register_acaciaWalls();
        register_bambooWalls();
        register_cherryWalls();
        register_crimsonWalls();
        register_darkOakWalls();
        register_jungleWalls();
        register_mangroveWalls();
        register_paleOakWalls();
        register_spruceWalls();
        register_warpedWalls();
    }

}
