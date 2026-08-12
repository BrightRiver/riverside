package river.riverside.core.helpers;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.ShelfRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.entity.ShelfBlockEntity;

public class ClientHelper {


    public static void shelf(
            BlockEntityType<ShelfBlockEntity> shelf) {
        BlockEntityRenderers.register(shelf, ShelfRenderer::new);
    }

    public static void hangingSign(BlockEntityType<HangingSignBlockEntity> blockEntity) {
        BlockEntityRenderers.register(blockEntity, HangingSignRenderer::new);
    }


    public static void boat(EntityType<Boat> boat, ModelLayerLocation model) {
        ModelLayerRegistry.registerModelLayer(model, BoatModel::createBoatModel);
        EntityRenderers.register(boat, context -> new BoatRenderer(context, model));
    }


    public static void chestBoat(EntityType<ChestBoat> boat, ModelLayerLocation model) {
        ModelLayerRegistry.registerModelLayer(model, BoatModel::createChestBoatModel);
        EntityRenderers.register(boat, context -> new BoatRenderer(context, model));
    }


}
