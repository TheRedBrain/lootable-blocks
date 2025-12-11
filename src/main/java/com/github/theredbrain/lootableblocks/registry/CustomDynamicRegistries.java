package com.github.theredbrain.lootableblocks.registry;

import com.github.theredbrain.lootableblocks.data.LootableVaultConfig;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class CustomDynamicRegistries {

	public static final RegistryKey<Registry<LootableVaultConfig>> LOOTABLE_VAULT_CONFIG_REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("lootable_vault_configs"));

	public static void init() {
		DynamicRegistries.registerSynced(LOOTABLE_VAULT_CONFIG_REGISTRY_KEY, LootableVaultConfig.CODEC);
	}
}
