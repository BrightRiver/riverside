package scorned.riverside.block.entity;


import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.entity.ShelfBlockEntity;
import scorned.riverside.Riverside;
import scorned.riverside.block.ModBlocks;

public class ModBlockEntities {


    public static final BlockEntityType<ShelfBlockEntity> OLIVE_SHELF =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "olive_shelf_be"),
                    FabricBlockEntityTypeBuilder.create(ShelfBlockEntity::new, ModBlocks.OLIVE_SHELF).build());


    public static void initialize() {
        Riverside.LOGGER.info("Registering Mod Block Entities for " + Riverside.MOD_ID);
        BlockEntityTypes.SHELF.addValidBlock(ModBlocks.OLIVE_SHELF);
    }
}
