package scorned.riverside.block.entity;


import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.entity.ShelfBlockEntity;
import scorned.riverside.Riverside;
import scorned.riverside.block.ModBlocks;
import scorned.riverside.item.ModItems;

public class ModBlockEntities {


    public static final BlockEntityType<ShelfBlockEntity> OLIVE_SHELF =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "olive_shelf_be"),
                    FabricBlockEntityTypeBuilder.create(ShelfBlockEntity::new, ModBlocks.OLIVE_SHELF).build());

    public static final BlockEntityType<HangingSignBlockEntity> OLIVE_HANGING_SIGN =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "olive_ceiling_hanging_sign"),
                    FabricBlockEntityTypeBuilder.create(HangingSignBlockEntity::new, Block.byItem(ModItems.OLIVE_HANGING_SIGN)).build());

    public static void initialize() {
        Riverside.LOGGER.info("Registering Mod Block Entities for " + Riverside.MOD_ID);
        BlockEntityTypes.SHELF.addValidBlock(ModBlocks.OLIVE_SHELF);
        BlockEntityTypes.HANGING_SIGN.addValidBlock(Block.byItem(ModItems.OLIVE_HANGING_SIGN));
        BlockEntityTypes.HANGING_SIGN.addValidBlock(ModBlocks.OLIVE_WALL_HANGING_SIGN);

        BlockEntityTypes.SIGN.addValidBlock(Block.byItem(ModItems.OLIVE_SIGN));
        BlockEntityTypes.SIGN.addValidBlock(ModBlocks.OLIVE_WALL_SIGN);
    }
}
