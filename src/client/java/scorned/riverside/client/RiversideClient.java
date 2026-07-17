package scorned.riverside.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.ShelfRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import scorned.riverside.block.entity.ModBlockEntities;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import scorned.riverside.client.entity.ModModelLayerLocations;

import net.minecraft.client.renderer.entity.EntityRenderers;
import scorned.riverside.entity.ModEntities;

public class RiversideClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		BlockEntityRenderers.register(ModBlockEntities.OLIVE_SHELF, ShelfRenderer::new);
		BlockEntityRenderers.register(ModBlockEntities.OLIVE_HANGING_SIGN, HangingSignRenderer::new);

		ModelLayerRegistry.registerModelLayer(ModModelLayerLocations.OLIVE_BOAT, BoatModel::createBoatModel);
		ModelLayerRegistry.registerModelLayer(ModModelLayerLocations.OLIVE_CHEST_BOAT, BoatModel::createChestBoatModel);

		EntityRenderers.register(ModEntities.OLIVE_BOAT, context -> new BoatRenderer(context, ModModelLayerLocations.OLIVE_BOAT));
		EntityRenderers.register(ModEntities.OLIVE_CHEST_BOAT, context -> new BoatRenderer(context, ModModelLayerLocations.OLIVE_CHEST_BOAT));
	}
}