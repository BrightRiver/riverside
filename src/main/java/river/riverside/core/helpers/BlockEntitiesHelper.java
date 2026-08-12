package river.riverside.core.helpers;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.entity.ShelfBlockEntity;
import river.riverside.Riverside;

public class BlockEntitiesHelper {

    public static BlockEntityType<ShelfBlockEntity> shelf(String name, Block shelf) {
        Identifier id = Riverside.id(name);
        BlockEntityType<ShelfBlockEntity> blockEntity = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id,
                FabricBlockEntityTypeBuilder.create(ShelfBlockEntity::new, shelf).build());
        BlockEntityTypes.SHELF.addValidBlock(shelf);
        return blockEntity;
    }

    public static void sign(Block sign) {
        BlockEntityTypes.SIGN.addValidBlock(sign);
    }


    public static void sign(Item sign) {
        BlockEntityTypes.SIGN.addValidBlock(Block.byItem(sign));
    }

    public static BlockEntityType<HangingSignBlockEntity> hangingSign(String name, Block block, Item item) {
        Identifier id = Riverside.id(name);
        BlockEntityType<HangingSignBlockEntity> blockEntity = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id,
                FabricBlockEntityTypeBuilder.create(HangingSignBlockEntity::new, Block.byItem(item)).build());

        BlockEntityTypes.HANGING_SIGN.addValidBlock(Block.byItem(item));
        BlockEntityTypes.HANGING_SIGN.addValidBlock(block);

        return blockEntity;
    }


}
