package com.github.theredbrain.lootableblocks;

import com.github.theredbrain.lootableblocks.compat.LootablesCompat;
import com.github.theredbrain.lootableblocks.registry.BlockRegistry;
import com.github.theredbrain.lootableblocks.registry.CustomDynamicRegistries;
import com.github.theredbrain.lootableblocks.registry.EntityRegistry;
import com.github.theredbrain.lootableblocks.registry.ServerPacketRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LootableBlocks implements ModInitializer {
	public static final String MOD_ID = "lootableblocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final boolean isLootablesLoaded = FabricLoader.getInstance().isModLoaded("lootables");

	public static void supplyLootableLoot(Identifier identifier, ServerWorld world, ServerPlayerEntity serverPlayerEntity, Vec3d pos, int rolls, int choices, boolean withChoice, @Nullable ItemStack itemStack) {
		if (isLootablesLoaded) {
			LootablesCompat.supplyLootableLoot(identifier, world, serverPlayerEntity, pos, rolls, choices, withChoice, itemStack);
		} else {
			info("Tried to supply loot via Lootables, but the mod is not installed!");
		}
	}

	public static void removeLootableUses(ServerWorld world, Vec3d pos, String identifierString, @Nullable ServerPlayerEntity serverPlayerEntity) {
		if (isLootablesLoaded) {
			LootablesCompat.removeLootableUses(world, pos, identifierString, serverPlayerEntity);
		}
	}

	public static void removeLootableUses(ServerWorld world, Vec3d pos, Identifier identifier, @Nullable ServerPlayerEntity serverPlayerEntity) {
		if (isLootablesLoaded) {
			LootablesCompat.removeLootableUses(world, pos, identifier, serverPlayerEntity);
		}
	}

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