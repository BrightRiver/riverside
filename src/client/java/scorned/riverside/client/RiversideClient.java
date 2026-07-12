package scorned.riverside.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.ShelfRenderer;
import scorned.riverside.block.entity.ModBlockEntities;

public class RiversideClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		BlockEntityRenderers.register(ModBlockEntities.OLIVE_SHELF, ShelfRenderer::new);
	}
}