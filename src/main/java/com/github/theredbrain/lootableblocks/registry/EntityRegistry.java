package com.github.theredbrain.lootableblocks.registry;

import com.github.theredbrain.lootableblocks.LootableBlocks;
import com.github.theredbrain.lootableblocks.block.entity.InteractiveLootBlockEntity;
import com.github.theredbrain.lootableblocks.block.entity.LootableVaultBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EntityRegistry {

	//region Script Blocks
	public static final BlockEntityType<LootableVaultBlockEntity> LOOTABLE_VAULT_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
			LootableBlocks.identifier("lootable_vault_block"),
			BlockEntityType.Builder.create(LootableVaultBlockEntity::new, BlockRegistry.LOOTABLE_VAULT_BLOCK, BlockRegistry.LOOTABLE_FROZEN_VAULT_BLOCK).build());
	public static final BlockEntityType<InteractiveLootBlockEntity> INTERACTIVE_LOOT_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
			LootableBlocks.identifier("interactive_loot_block"),
			BlockEntityType.Builder.create(InteractiveLootBlockEntity::new, BlockRegistry.INTERACTIVE_LOOT_BLOCK).build());

	public static void init() {
	}
}
