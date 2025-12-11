package com.github.theredbrain.lootableblocks.registry;

import com.github.theredbrain.lootableblocks.LootableBlocks;
import com.github.theredbrain.lootableblocks.block.InteractiveLootBlock;
import com.github.theredbrain.lootableblocks.block.LootableVaultBlock;
import com.github.theredbrain.lootableblocks.block.lootable_vault.LootableVaultState;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;

public class BlockRegistry {

	public static final Block LOOTABLE_VAULT_BLOCK = registerBlock("lootable_vault_block", new LootableVaultBlock(Block.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).strength(50.0F).nonOpaque().sounds(BlockSoundGroup.VAULT).luminance(state -> ((LootableVaultState) state.get(LootableVaultBlock.LOOTABLE_VAULT_STATE)).getLuminance()).blockVision(Blocks::never).dropsNothing()), ItemGroups.FUNCTIONAL);
	public static final Block INTERACTIVE_LOOT_BLOCK = registerBlock("interactive_loot_block", new InteractiveLootBlock(Block.Settings.create().mapColor(MapColor.LIGHT_GRAY).requiresTool().strength(-1.0f, 3600000.0f).dropsNothing()), ItemGroups.OPERATOR);

	private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> itemGroup) {
		Registry.register(Registries.ITEM, LootableBlocks.identifier(name), new BlockItem(block, new Item.Settings()));
		ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> content.add(block));
		return Registry.register(Registries.BLOCK, LootableBlocks.identifier(name), block);
	}

	public static void init() {
	}
}
