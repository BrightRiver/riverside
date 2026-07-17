package scorned.riverside.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import scorned.riverside.Riverside;
import scorned.riverside.item.ModItems;

import java.util.function.Function;

public class ModBlocks {


    //OLIVE SET
    public static final Block OLIVE_PLANKS = registerBlock("olive_planks",
            properties -> new Block(properties
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()));

    public static final Block OLIVE_WOOD = registerBlock("olive_wood",
            properties -> new RotatedPillarBlock(properties
                    .mapColor(OLIVE_PLANKS.defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()));

    public static final Block OLIVE_LOG = registerBlock("olive_log",
            properties -> new RotatedPillarBlock(properties
                    .mapColor(OLIVE_PLANKS.defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()));

    public static final Block STRIPPED_OLIVE_WOOD = registerBlock("stripped_olive_wood",
            properties -> new RotatedPillarBlock(properties
                    .mapColor(OLIVE_PLANKS.defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()

            ));

    public static final Block STRIPPED_OLIVE_LOG = registerBlock("stripped_olive_log",
            properties -> new RotatedPillarBlock(properties
                    .mapColor(OLIVE_PLANKS.defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()

            ));

    public static final Block OLIVE_FENCE = registerBlock("olive_fence",
            properties -> new FenceBlock(properties
                    .mapColor(OLIVE_PLANKS.defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava())
    );

    public static final Block OLIVE_STAIR = registerBlock("olive_stair",
            properties -> new StairBlock(ModBlocks.OLIVE_PLANKS.defaultBlockState()
                    , properties
                    .mapColor(OLIVE_PLANKS.defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava())
    );
    public static final Block OLIVE_SLAB = registerBlock("olive_slab",
            properties -> new SlabBlock(properties
                    .mapColor(OLIVE_PLANKS.defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava())
    );

    public static final Block OLIVE_FENCE_GATE = registerBlock("olive_fence_gate",
            properties -> new FenceGateBlock(WoodType.OAK,
                    properties
                            .mapColor(OLIVE_PLANKS.defaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava())
    );

    public static final Block OLIVE_WALL = registerBlock("olive_wall",
            properties -> new WallBlock(properties
                    .mapColor(OLIVE_PLANKS.defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava())
    );

    public static final Block OLIVE_SHELF = registerBlock("olive_shelf",
            properties -> new ShelfBlock(properties
                    .mapColor(OLIVE_PLANKS.defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava())
    );

    public static final Block OLIVE_BUTTON = registerBlock("olive_button",
            properties -> new ButtonBlock(BlockSetType.OAK, 30,
                    properties
                            .mapColor(OLIVE_PLANKS.defaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava())
    );

    public static final Block OLIVE_PRESSURE_PLATE = registerBlock("olive_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.OAK,
                    properties
                            .mapColor(OLIVE_PLANKS.defaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava())
    );


    public static final Block OLIVE_SIGN = registerBlock(
            "olive_standing_sign",
            properties -> new StandingSignBlock(WoodType.OAK,
                    properties
                            .mapColor(OLIVE_PLANKS.defaultMapColor())
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)
                            .ignitedByLava()
            ));


    public static final Block OLIVE_WALL_SIGN = registerBlock(
            "olive_wall_sign",
            properties -> new WallSignBlock(WoodType.OAK,
                    properties
                            .overrideLootTable(OLIVE_SIGN.getLootTable())
                            .overrideDescription(Block.byItem(ModItems.OLIVE_SIGN).getDescriptionId())
                            .mapColor(OLIVE_PLANKS.defaultMapColor())
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)
            ));


    public static final Block OLIVE_HANGING_SIGN = registerBlock(
            "olive_ceiling_hanging_sign",
            properties -> new CeilingHangingSignBlock(WoodType.OAK,
                    properties
                            .mapColor(OLIVE_PLANKS.defaultMapColor())
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)
                            .ignitedByLava()
            ));

    public static final Block OLIVE_WALL_HANGING_SIGN = registerBlock(
            "olive_wall_hanging_sign",
            properties -> new WallHangingSignBlock(WoodType.OAK,
                    properties
                            .overrideLootTable(OLIVE_HANGING_SIGN.getLootTable())
                            .overrideDescription(Block.byItem(ModItems.OLIVE_HANGING_SIGN).getDescriptionId())
                            .mapColor(OLIVE_PLANKS.defaultMapColor())
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)
                            .ignitedByLava()

            ));


    public static final Block OLIVE_TRAPDOOR = registerBlock(
            "olive_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.OAK,
                    properties
                            .mapColor(OLIVE_PLANKS.defaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(3.0F)
                            .noOcclusion()
                            .isValidSpawn(Blocks::never)
                            .ignitedByLava()
            ));

    public static final Block OLIVE_DOOR = registerBlock(
            "olive_door",
            properties -> new DoorBlock(BlockSetType.OAK,
                    properties
                            .mapColor(OLIVE_PLANKS.defaultMapColor())
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(3.0F)
                            .noOcclusion()
                            .ignitedByLava()
                            .pushReaction(PushReaction.DESTROY)
            ));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, name)))));
    }

    public static void initialize() {
        Riverside.LOGGER.info("Registering Mod Blocks for " + Riverside.MOD_ID);
    }

    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }
}