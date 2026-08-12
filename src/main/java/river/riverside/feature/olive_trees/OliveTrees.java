package river.riverside.feature.olive_trees;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.entity.ShelfBlockEntity;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import river.riverside.Riverside;
import river.riverside.core.helpers.*;
import river.riverside.core.defaults.StandardProperties;
import net.minecraft.data.BlockFamily.Builder;

import net.minecraft.tags.TagKey;

public class OliveTrees {

    public static final BlockSetType OLIVE_BLOCK_SET = BlockSetTypesHelper.register("olive", BlockSetType.OAK);
    public static final WoodType OLIVE_WOOD_TYPE = WoodTypesHelper.register("olive", WoodType.OAK, OLIVE_BLOCK_SET);
    public static Builder OLIVE_FAMILY_BUILDER;
    public static BlockFamily OLIVE_FAMILY;


    public static TagKey<Item> OLIVE_LOGS_TAG = TagsHelper.Items.createTag("olive_logs");

    public static Block OLIVE_PLANKS;

    public static Block OLIVE_WOOD;
    public static Block OLIVE_LOG;
    public static Block STRIPPED_OLIVE_WOOD;
    public static Block STRIPPED_OLIVE_LOG;
    public static Block OLIVE_FENCE;
    public static Block OLIVE_STAIR;
    public static Block OLIVE_SLAB;
    public static Block OLIVE_FENCE_GATE;
    public static Block OLIVE_WALL;
    public static Block OLIVE_BUTTON;
    public static Block OLIVE_PRESSURE_PLATE;
    public static Block OLIVE_TRAPDOOR;
    public static Block OLIVE_DOOR;
    public static Block OLIVE_SHELF;
    public static Item OLIVE_SIGN_ITEM;
    public static Item OLIVE_HANGING_SIGN_ITEM;
    public static Block OLIVE_SIGN;
    public static Block OLIVE_WALL_SIGN;
    public static Block OLIVE_HANGING_SIGN;
    public static Block OLIVE_WALL_HANGING_SIGN;

    public static Item OLIVE_BOAT_ITEM;
    public static Item OLIVE_CHEST_BOAT_ITEM;

    public static EntityType<Boat> OLIVE_BOAT;
    public static EntityType<ChestBoat> OLIVE_CHEST_BOAT;

    private static void register_olivePlanks() {
        OLIVE_PLANKS = BlocksHelper.registerBlock("olive_planks",
                properties -> new Block(StandardProperties.woodProperties(properties, MapColor.TERRACOTTA_LIGHT_GREEN)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_PLANKS);
        OLIVE_FAMILY_BUILDER = BlockFamilies.familyBuilder(OLIVE_PLANKS);
    }

    private static void register_oliveWood() {
        OLIVE_WOOD = BlocksHelper.registerBlock("olive_wood",
                properties -> new RotatedPillarBlock(StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_WOOD);
    }

    private static void register_oliveLog() {
        OLIVE_LOG = BlocksHelper.registerBlock("olive_log",
                properties -> new RotatedPillarBlock(StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_LOG);
    }

    private static void register_strippedOliveWood() {
        STRIPPED_OLIVE_WOOD = BlocksHelper.registerBlock("stripped_olive_wood",
                properties -> new RotatedPillarBlock(StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, STRIPPED_OLIVE_WOOD);
        RegistriesHelper.makeStrippable(OLIVE_WOOD, STRIPPED_OLIVE_WOOD);

    }

    private static void register_strippedOliveLog() {
        STRIPPED_OLIVE_LOG = BlocksHelper.registerBlock("stripped_olive_log",
                properties -> new RotatedPillarBlock(StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, STRIPPED_OLIVE_LOG);
        RegistriesHelper.makeStrippable(OLIVE_LOG, STRIPPED_OLIVE_LOG);
        OLIVE_FAMILY_BUILDER.strippedLog(STRIPPED_OLIVE_LOG);
    }

    private static void register_oliveFence() {
        OLIVE_FENCE = BlocksHelper.registerBlock("olive_fence",
                properties -> new FenceBlock(StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_FENCE);
        OLIVE_FAMILY_BUILDER.fence(OLIVE_FENCE);

    }

    private static void register_oliveStair() {
        OLIVE_STAIR = BlocksHelper.registerBlock("olive_stair",
                properties -> new StairBlock(OLIVE_PLANKS.defaultBlockState(), StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_STAIR);
        OLIVE_FAMILY_BUILDER.stairs(OLIVE_STAIR);

    }

    private static void register_oliveSlab() {
        OLIVE_SLAB = BlocksHelper.registerBlock("olive_slab",
                properties -> new SlabBlock(StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_SLAB);
        OLIVE_FAMILY_BUILDER.slab(OLIVE_SLAB);
    }

    private static void register_oliveFenceGate() {
        OLIVE_FENCE_GATE = BlocksHelper.registerBlock("olive_fence_gate",
                properties -> new FenceGateBlock(OLIVE_WOOD_TYPE, StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_FENCE_GATE);
        OLIVE_FAMILY_BUILDER.fenceGate(OLIVE_FENCE_GATE);
    }

    private static void register_oliveWall() {
        OLIVE_WALL = BlocksHelper.registerBlock("olive_wall",
                properties -> new WallBlock(StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_WALL);
        OLIVE_FAMILY_BUILDER.wall(OLIVE_WALL);
    }

    private static void register_oliveButton() {
        OLIVE_BUTTON = BlocksHelper.registerBlock("olive_button",
                properties -> new ButtonBlock(OLIVE_BLOCK_SET, 30, StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_BUTTON);
        OLIVE_FAMILY_BUILDER.button(OLIVE_BUTTON);
    }

    private static void register_olivePressurePlate() {
        OLIVE_PRESSURE_PLATE = BlocksHelper.registerBlock("olive_pressure_plate",
                properties -> new PressurePlateBlock(OLIVE_BLOCK_SET, StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_PRESSURE_PLATE);
        OLIVE_FAMILY_BUILDER.pressurePlate(OLIVE_PRESSURE_PLATE);
    }

    private static void register_oliveTrapDoor() {
        OLIVE_TRAPDOOR = BlocksHelper.registerBlock("olive_trapdoor",
                properties -> new TrapDoorBlock(OLIVE_BLOCK_SET, StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_TRAPDOOR);
        OLIVE_FAMILY_BUILDER.trapdoor(OLIVE_TRAPDOOR);
    }

    private static void register_oliveDoor() {
        OLIVE_DOOR = BlocksHelper.registerBlock("olive_door",
                properties -> new DoorBlock(OLIVE_BLOCK_SET, StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_DOOR);
        OLIVE_FAMILY_BUILDER.door(OLIVE_DOOR);
    }

    private static void register_oliveShelf() {
        OLIVE_SHELF = BlocksHelper.registerBlock("olive_shelf",
                properties -> new ShelfBlock(StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_SHELF);
        BlockEntityType<ShelfBlockEntity> blockEntity = BlockEntitiesHelper.shelf("olive_shelf", OLIVE_SHELF);
        ClientHelper.shelf(blockEntity);
    }


    private static void register_oliveSign() {
        OLIVE_SIGN = BlocksHelper.registerBlock("olive_standing_sign",
                properties -> new StandingSignBlock(OLIVE_WOOD_TYPE, StandardProperties.woodProperties(properties, OLIVE_PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_WALL);

        OLIVE_WALL_SIGN = BlocksHelper.registerBlock("olive_wall_sign",
                properties -> new WallSignBlock(OLIVE_WOOD_TYPE, StandardProperties.woodProperties(properties, OLIVE_PLANKS)));

        OLIVE_SIGN_ITEM = ItemsHelper.registerBlock(
                "olive_sign"
                , OLIVE_SIGN,
                (b, p) -> new SignItem(b, OLIVE_WALL_SIGN, p),
                new Item.Properties().stacksTo(16)
        );
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_SIGN_ITEM);
        OLIVE_FAMILY_BUILDER.sign(OLIVE_SIGN, OLIVE_WALL_SIGN);

        BlockEntitiesHelper.sign(OLIVE_SIGN_ITEM);
        BlockEntitiesHelper.sign(OLIVE_WALL_SIGN);
        BlockEntitiesHelper.sign(OLIVE_SIGN);
    }

    private static void register_oliveHangingSign() {
        OLIVE_HANGING_SIGN = BlocksHelper.registerBlock("olive_ceiling_hanging_sign",
                properties -> new CeilingHangingSignBlock(OLIVE_WOOD_TYPE ,StandardProperties.woodProperties(properties, OLIVE_PLANKS)));

        OLIVE_WALL_HANGING_SIGN = BlocksHelper.registerBlock("olive_wall_hanging_sign",
                properties -> new WallHangingSignBlock(OLIVE_WOOD_TYPE ,StandardProperties.woodProperties(properties, OLIVE_PLANKS))
                        );

        OLIVE_HANGING_SIGN_ITEM = ItemsHelper.registerBlock(
                "olive_hanging_sign"
                , OLIVE_HANGING_SIGN,
                (b, p) -> new SignItem(b, OLIVE_WALL_HANGING_SIGN, p),
                new Item.Properties().stacksTo(16)
        );
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_HANGING_SIGN_ITEM);
        OLIVE_FAMILY_BUILDER.hangingSign(OLIVE_HANGING_SIGN, OLIVE_WALL_HANGING_SIGN);

        BlockEntityType<HangingSignBlockEntity> blockEntity = BlockEntitiesHelper.hangingSign("olive_hanging_sign", OLIVE_WALL_HANGING_SIGN, OLIVE_HANGING_SIGN_ITEM);
        ClientHelper.hangingSign(blockEntity);
    }


    private static void register_oliveBoat() {

        OLIVE_BOAT = EntityHelper.registerBoat("olive_boat", () -> OLIVE_BOAT_ITEM);

        OLIVE_BOAT_ITEM = ItemsHelper.registerItem("olive_boat",
                properties -> new BoatItem(OLIVE_BOAT, properties.stacksTo(1)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_BOAT_ITEM);

        ModelLayerLocation modelLayer = new ModelLayerLocation(Riverside.id("boat/olive_boat"), "main");
        ClientHelper.boat(OLIVE_BOAT, modelLayer);

    }


    private static void register_oliveChestBoat() {

        OLIVE_CHEST_BOAT = EntityHelper.registerChestBoat("olive_chest_boat", () -> OliveTrees.OLIVE_CHEST_BOAT_ITEM);

        OLIVE_CHEST_BOAT_ITEM = ItemsHelper.registerItem("olive_chest_boat",
                properties -> new BoatItem(OLIVE_CHEST_BOAT, properties.stacksTo(1)));


        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OLIVE_CHEST_BOAT_ITEM);

        ModelLayerLocation modelLayer = new ModelLayerLocation(Riverside.id("chest_boat/olive_boat"), "main");
        ClientHelper.chestBoat(OLIVE_CHEST_BOAT, modelLayer);
    }


    private static void buildFamily() {
        OLIVE_FAMILY = OLIVE_FAMILY_BUILDER
                .recipeGroupPrefix("riverside")
                .recipeUnlockedBy("has_planks")
                .getFamily();
    }

    public static void initialize() {
        Riverside.LOGGER.info(Riverside.MOD_ID + ": Initializing Olive Trees");
        register_olivePlanks();
        register_oliveWood();
        register_oliveLog();
        register_strippedOliveWood();
        register_strippedOliveLog();
        register_oliveFence();
        register_oliveStair();
        register_oliveSlab();
        register_oliveFenceGate();
        register_oliveWall();
        register_oliveButton();
        register_olivePressurePlate();
        register_oliveTrapDoor();
        register_oliveDoor();
        register_oliveShelf();
        register_oliveSign();
        register_oliveHangingSign();

        register_oliveBoat();
        register_oliveChestBoat();


        buildFamily();

    }
}
