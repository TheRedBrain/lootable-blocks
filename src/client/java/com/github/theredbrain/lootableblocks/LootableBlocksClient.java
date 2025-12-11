package com.github.theredbrain.lootableblocks;

import com.github.theredbrain.lootableblocks.registry.BlockRegistry;
import com.github.theredbrain.lootableblocks.registry.EntityRegistry;
import com.github.theredbrain.lootableblocks.render.block.entity.LootableVaultBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class LootableBlocksClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		registerTransparency();
	}

	private void registerTransparency() {
		BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.LOOTABLE_VAULT_BLOCK, RenderLayer.getCutout());
	}

	private void registerBlockEntityRenderer() {
		BlockEntityRendererFactories.register(EntityRegistry.LOOTABLE_VAULT_BLOCK_ENTITY, LootableVaultBlockEntityRenderer::new);
	}
}