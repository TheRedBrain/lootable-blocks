package com.github.theredbrain.lootableblocks.compat;

import com.github.theredbrain.lootableblocks.LootableBlocks;
import com.github.theredbrain.lootableblocks.block.InteractiveLootBlock;
import com.github.theredbrain.lootableblocks.block.entity.InteractiveLootBlockEntity;
import com.github.theredbrain.lootableblocks.block.entity.LootableVaultBlockEntity;
import me.fzzyhmstrs.lootables.api.IdKey;
import me.fzzyhmstrs.lootables.api.LootablesApi;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class LootableCompat {

	public static void supplyLootableLoot(Identifier identifier, ServerWorld world, ServerPlayerEntity serverPlayerEntity, Vec3d pos, int rolls, int choices, boolean withChoice, @Nullable ItemStack itemStack) {
		if (withChoice) {
			LootablesApi.supplyLootWithChoices(
					identifier,
					serverPlayerEntity,
					pos,
					(serverPlayerEntity1, vec3d) -> {

						BlockPos blockPos = new BlockPos((int) pos.x, (int) pos.y, (int) pos.z);
						BlockEntity blockEntity = world.getBlockEntity(blockPos);
						if (blockEntity instanceof InteractiveLootBlockEntity interactiveLootBlockEntity) {
							InteractiveLootBlock.lootWasSupplied(serverPlayerEntity, interactiveLootBlockEntity);
						}
						if (blockEntity instanceof LootableVaultBlockEntity lootableVaultBlockEntity) {
							lootableVaultBlockEntity.markAsRewarded(serverPlayerEntity, itemStack);
						}
					},
					(serverPlayerEntity2, vec3d) -> {
						// gets called when player leaves choices screen without making a choice
						BlockEntity blockEntity = world.getBlockEntity(new BlockPos((int) pos.x, (int) pos.y, (int) pos.z));
						if (blockEntity instanceof InteractiveLootBlockEntity interactiveLootBlockEntity) {
							interactiveLootBlockEntity.removePlayerFromSet(serverPlayerEntity);
						}
						if (blockEntity instanceof LootableVaultBlockEntity lootableVaultBlockEntity) {
							lootableVaultBlockEntity.unmarkAsRewarded(serverPlayerEntity);
						}
					},
					new IdKey(LootableBlocks.identifier(world.getRegistryKey().getRegistry().toTranslationKey() + "_" + world.getRegistryKey().getValue().toTranslationKey() + "_" + identifier.toTranslationKey() + "_" + pos.x + "_" + pos.y + "_" + pos.z)),
					rolls,
					choices
			);
		} else {
			LootablesApi.supplyLootRandomly(
					identifier,
					serverPlayerEntity,
					pos,
					null,
					rolls
			);
			BlockPos blockPos = new BlockPos((int) pos.x, (int) pos.y, (int) pos.z);
			BlockEntity blockEntity = world.getBlockEntity(blockPos);
			if (blockEntity instanceof InteractiveLootBlockEntity interactiveLootBlockEntity) {
				InteractiveLootBlock.lootWasSupplied(serverPlayerEntity, interactiveLootBlockEntity);
			}
			if (blockEntity instanceof LootableVaultBlockEntity lootableVaultBlockEntity) {
				lootableVaultBlockEntity.markAsRewarded(serverPlayerEntity, itemStack);
			}
		}
	}

	public static void removeLootableUses(Identifier identifier, @Nullable ServerPlayerEntity serverPlayerEntity) {
	}

}
