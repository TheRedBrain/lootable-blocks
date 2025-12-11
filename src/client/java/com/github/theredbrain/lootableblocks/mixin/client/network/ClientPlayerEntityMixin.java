package com.github.theredbrain.lootableblocks.mixin.client.network;

import com.github.theredbrain.lootableblocks.block.entity.InteractiveLootBlockEntity;
import com.github.theredbrain.lootableblocks.entity.player.DuckPlayerEntityMixin;
import com.github.theredbrain.lootableblocks.gui.screen.ingame.InteractiveLootBlockScreen;
import com.mojang.authlib.GameProfile;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayerEntity implements DuckPlayerEntityMixin {

	@Shadow
	@Final
	protected MinecraftClient client;

	@Shadow
	public abstract boolean isUsingItem();

	@Shadow
	public abstract float getPitch(float tickDelta);

	@Shadow
	public abstract void sendMessage(Text message, boolean overlay);

	public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile) {
		super(world, profile);
	}

	@Override
	public void lootableblocks$openInteractiveLootBlockScreen(InteractiveLootBlockEntity interactiveLootBlockEntity) {
		this.client.setScreen(new InteractiveLootBlockScreen(interactiveLootBlockEntity));
	}

}
