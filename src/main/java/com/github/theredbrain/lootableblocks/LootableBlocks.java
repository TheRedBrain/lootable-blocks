package com.github.theredbrain.lootableblocks;

import com.github.theredbrain.lootableblocks.registry.BlockRegistry;
import com.github.theredbrain.lootableblocks.registry.CustomDynamicRegistries;
import com.github.theredbrain.lootableblocks.registry.EntityRegistry;
import com.github.theredbrain.lootableblocks.registry.ServerPacketRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LootableBlocks implements ModInitializer {
	public static final String MOD_ID = "lootableblocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Lootables supplied by blocks!");

		// Packets
		ServerPacketRegistry.init();

		// Registry
		BlockRegistry.init();
		CustomDynamicRegistries.init();
		EntityRegistry.init();
	}

	public static Identifier identifier(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static void info(String message) {
		LOGGER.info("[" + MOD_ID + "] [info]: " + message);
	}

}