package river.riverside.core.defaults;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.references.BlockItemId;
import net.minecraft.tags.TagKey;
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
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.material.MapColor;
import river.riverside.Riverside;
import river.riverside.core.helpers.*;

public class WoodSet {

    public BlockSetType BLOCK_SET;
    public WoodType WOOD_TYPE;
    public BlockFamily.Builder FAMILY_BUILDER;
    public BlockFamily FAMILY;
    public TagKey<Item> LOGS_TAG;
    public Block PLANKS;
    public Block WOOD;
    public Block LOG;
    public Block STRIPPED_WOOD;
    public Block STRIPPED_LOG;
    public Block FENCE;
    public Block STAIR;
    public Block SLAB;
    public Block FENCE_GATE;
    public Block WALL;
    public Block BUTTON;
    public Block PRESSURE_PLATE;
    public Block TRAPDOOR;
    public Block DOOR;
    public Block SHELF;
    public Item SIGN_ITEM;
    public Item HANGING_SIGN_ITEM;
    public Block SIGN;
    public Block WALL_SIGN;
    public Block HANGING_SIGN;
    public Block WALL_HANGING_SIGN;

    public Item BOAT_ITEM;
    public Item CHEST_BOAT_ITEM;

    public EntityType<Boat> BOAT;
    public EntityType<ChestBoat> CHEST_BOAT;

    public BlockFamily getFamily() {
        return this.FAMILY;
    }

    public TagKey<Item> getLogsTag() {
        return this.LOGS_TAG;
    }

    public Block getPlanks() {
        return this.PLANKS;
    }

    public Block getWood() {
        return this.WOOD;
    }

    public Block getLog() {
        return this.LOG;
    }

    public Block getStrippedWood() {
        return this.STRIPPED_WOOD;
    }

    public Block getStrippedLog() {
        return this.STRIPPED_LOG;
    }

    public Block getFence() {
        return this.FENCE;
    }

    public Block getStair() {
        return this.STAIR;
    }

    public Block getSlab() {
        return this.SLAB;
    }

    public Block getFenceGate() {
        return this.FENCE_GATE;
    }

    public Block getWall() {
        return this.WALL;
    }

    public Block getButton() {
        return this.BUTTON;
    }

    public Block getPressurePlate() {
        return this.PRESSURE_PLATE;
    }

    public Block getTrapdoor() {
        return this.TRAPDOOR;
    }

    public Block getDoor() {
        return this.DOOR;
    }

    public Block getShelf() {
        return this.SHELF;
    }

    public Item getSignItem() {
        return this.SIGN_ITEM;
    }

    public Item getHangingSignItem() {
        return this.HANGING_SIGN_ITEM;
    }

    public Block getSign() {
        return this.SIGN;
    }

    public Block getWallSign() {
        return this.WALL_SIGN;
    }

    public Block getHangingSign() {
        return this.HANGING_SIGN;
    }

    public Block getWallHangingSign() {
        return this.WALL_HANGING_SIGN;
    }

    public Item getBoatItem() {
        return this.BOAT_ITEM;
    }

    public Item getChestBoatItem() {
        return this.CHEST_BOAT_ITEM;
    }

    public EntityType<Boat> getBoat() {
        return this.BOAT;
    }

    public EntityType<ChestBoat> getChestBoat() {
        return this.CHEST_BOAT;
    }

    private void registerBlockSet(String name) {
        this.BLOCK_SET = BlockSetTypesHelper.register("%s".formatted(name), BlockSetType.OAK);
    }

    private void registerWoodType(String name) {
        this.WOOD_TYPE = WoodTypesHelper.register("%s".formatted(name), WoodType.OAK, BLOCK_SET);
    }


    private void registerLogsTag(String name) {
        this.LOGS_TAG = TagsHelper.Items.createTag("%s_logs".formatted(name));
    }


    private void registerPlanks(String name, MapColor colour) {
        PLANKS = BlocksHelper.registerBlock("%s_planks".formatted(name),
                properties -> new Block(StandardProperties.woodProperties(properties, colour)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, PLANKS);
        FAMILY_BUILDER = BlockFamilies.familyBuilder(PLANKS);
    }

    private void registerWood(String name) {
        WOOD = BlocksHelper.registerBlock("%s_wood".formatted(name),
                properties -> new RotatedPillarBlock(StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, WOOD);
    }

    private void registerLog(String name) {
        LOG = BlocksHelper.registerBlock("%s_log".formatted(name),
                properties -> new RotatedPillarBlock(StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, LOG);
    }

    private void registerStrippedWood(String name) {
        STRIPPED_WOOD = BlocksHelper.registerBlock("stripped_%s_wood".formatted(name),
                properties -> new RotatedPillarBlock(StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, STRIPPED_WOOD);
        RegistriesHelper.makeStrippable(WOOD, STRIPPED_WOOD);

    }

    private void registerStrippedLog(String name) {
        STRIPPED_LOG = BlocksHelper.registerBlock("stripped_%s_log".formatted(name),
                properties -> new RotatedPillarBlock(StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, STRIPPED_LOG);
        RegistriesHelper.makeStrippable(LOG, STRIPPED_LOG);
        FAMILY_BUILDER.strippedLog(STRIPPED_LOG);
    }

    private void registerFence(String name) {
        FENCE = BlocksHelper.registerBlock("%s_fence".formatted(name),
                properties -> new FenceBlock(StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, FENCE);
        FAMILY_BUILDER.fence(FENCE);

    }

    private void registerStair(String name) {
        STAIR = BlocksHelper.registerBlock("%s_stair".formatted(name),
                properties -> new StairBlock(PLANKS.defaultBlockState(), StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, STAIR);
        FAMILY_BUILDER.stairs(STAIR);

    }

    private void registerSlab(String name) {
        SLAB = BlocksHelper.registerBlock("%s_slab".formatted(name),
                properties -> new SlabBlock(StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, SLAB);
        FAMILY_BUILDER.slab(SLAB);
    }

    private void registerFenceGate(String name) {
        FENCE_GATE = BlocksHelper.registerBlock("%s_fence_gate".formatted(name),
                properties -> new FenceGateBlock(WOOD_TYPE, StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, FENCE_GATE);
        FAMILY_BUILDER.fenceGate(FENCE_GATE);
    }

    private void registerWall(String name) {
        WALL = BlocksHelper.registerBlock("%s_wall".formatted(name),
                properties -> new WallBlock(StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, WALL);
        FAMILY_BUILDER.wall(WALL);
    }

    private void registerButton(String name) {
        BUTTON = BlocksHelper.registerBlock("%s_button".formatted(name),
                properties -> new ButtonBlock(BLOCK_SET, 30, StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, BUTTON);
        FAMILY_BUILDER.button(BUTTON);
    }

    private void registerPressurePlate(String name) {
        PRESSURE_PLATE = BlocksHelper.registerBlock("%s_pressure_plate".formatted(name),
                properties -> new PressurePlateBlock(BLOCK_SET, StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, PRESSURE_PLATE);
        FAMILY_BUILDER.pressurePlate(PRESSURE_PLATE);
    }

    private void registerTrapDoor(String name) {
        TRAPDOOR = BlocksHelper.registerBlock("%s_trapdoor".formatted(name),
                properties -> new TrapDoorBlock(BLOCK_SET, StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, TRAPDOOR);
        FAMILY_BUILDER.trapdoor(TRAPDOOR);
    }

    private void registerDoor(String name) {
        DOOR = BlocksHelper.registerBlock("%s_door".formatted(name),
                properties -> new DoorBlock(BLOCK_SET, StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, DOOR);
        FAMILY_BUILDER.door(DOOR);
    }

    private void registerShelf(String name) {
        SHELF = BlocksHelper.registerBlock("%s_shelf".formatted(name),
                properties -> new ShelfBlock(StandardProperties.woodProperties(properties, PLANKS)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, SHELF);
        BlockEntityType<ShelfBlockEntity> blockEntity = BlockEntitiesHelper.shelf("%s_shelf".formatted(name), SHELF);
        ClientHelper.shelf(blockEntity);
    }


    private void registerSign(String name) {

        BlockItemId id = BlocksHelper.blockItemId("%s_sign".formatted(name));
        SIGN = BlocksHelper.registerBlock(id,
                properties -> new StandingSignBlock(WOOD_TYPE, StandardProperties.woodProperties(properties, PLANKS).noCollision()));

        WALL_SIGN = BlocksHelper.registerBlock("%s_wall_sign".formatted(name),
                properties -> new WallSignBlock(WOOD_TYPE, StandardProperties.woodProperties(properties, PLANKS)));

        SIGN_ITEM = ItemsHelper.registerBlock(
                id
                , SIGN,
                (b, p) -> new SignItem(b, WALL_SIGN, p),
                new Item.Properties().stacksTo(16)
        );
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, SIGN_ITEM);
        FAMILY_BUILDER.sign(SIGN, WALL_SIGN);

        BlockEntitiesHelper.sign(SIGN_ITEM);
        BlockEntitiesHelper.sign(WALL_SIGN);
        BlockEntitiesHelper.sign(SIGN);
    }

    private void registerHangingSign(String name) {
        BlockItemId id = BlocksHelper.blockItemId("%s_hanging_sign".formatted(name));
        HANGING_SIGN = BlocksHelper.registerBlock(id,
                properties -> new CeilingHangingSignBlock(WOOD_TYPE, StandardProperties.woodProperties(properties, PLANKS)));

        WALL_HANGING_SIGN = BlocksHelper.registerBlock("%s_wall_hanging_sign".formatted(name),
                properties -> new WallHangingSignBlock(WOOD_TYPE, StandardProperties.woodProperties(properties, PLANKS))
        );

        HANGING_SIGN_ITEM = ItemsHelper.registerBlock(
                id, HANGING_SIGN,
                (b, p) -> new SignItem(b, WALL_HANGING_SIGN, p),
                new Item.Properties().stacksTo(16)
        );
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, HANGING_SIGN_ITEM);
        FAMILY_BUILDER.hangingSign(HANGING_SIGN, WALL_HANGING_SIGN);

        BlockEntityType<HangingSignBlockEntity> blockEntity = BlockEntitiesHelper.hangingSign("%s_hanging_sign".formatted(name), WALL_HANGING_SIGN, HANGING_SIGN_ITEM);
        ClientHelper.hangingSign(blockEntity);
    }


    private void registerBoat(String name) {

        BOAT = EntityHelper.registerBoat("%s_boat".formatted(name), this::getBoatItem);

        BOAT_ITEM = ItemsHelper.registerItem("%s_boat".formatted(name),
                properties -> new BoatItem(BOAT, properties.stacksTo(1)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, BOAT_ITEM);

        ModelLayerLocation modelLayer = new ModelLayerLocation(Riverside.id("boat/%s_boat".formatted(name)), "main");
        ClientHelper.boat(BOAT, modelLayer);

    }


    private void registerChestBoat(String name) {

        CHEST_BOAT = EntityHelper.registerChestBoat("%s_chest_boat".formatted(name), this::getChestBoatItem);

        CHEST_BOAT_ITEM = ItemsHelper.registerItem("%s_chest_boat".formatted(name),
                properties -> new BoatItem(CHEST_BOAT, properties.stacksTo(1)));


        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, CHEST_BOAT_ITEM);

        ModelLayerLocation modelLayer = new ModelLayerLocation(Riverside.id("chest_boat/%s_boat".formatted(name)), "main");
        ClientHelper.chestBoat(CHEST_BOAT, modelLayer);
    }


    private void buildFamily() {
        FAMILY = FAMILY_BUILDER
                .recipeGroupPrefix("riverside")
                .recipeUnlockedBy("has_planks")
                .getFamily();
    }

    public WoodSet(String name, MapColor mapColor) {
        registerBlockSet(name);
        registerWoodType(name);
        registerLogsTag(name);
        registerPlanks(name, mapColor);
        registerWood(name);
        registerLog(name);
        registerStrippedWood(name);
        registerStrippedLog(name);
        registerFence(name);
        registerStair(name);
        registerSlab(name);
        registerFenceGate(name);
        registerWall(name);
        registerButton(name);
        registerPressurePlate(name);
        registerTrapDoor(name);
        registerDoor(name);
        registerShelf(name);
        registerSign(name);
        registerHangingSign(name);
        registerBoat(name);
        registerChestBoat(name);
        buildFamily();

    }
}


