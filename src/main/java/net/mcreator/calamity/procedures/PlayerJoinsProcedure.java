package net.mcreator.calamity.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import net.mcreator.calamity.init.CalamityModItems;
import net.mcreator.calamity.init.CalamityModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerJoinsProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal("\u00A74Calamity Cubic"), false);
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal("___________________________________"), false);
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal("\u00A77Welcome to the unofficial port for Terraria Calamity to Minecraft!"), false);
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(
					Component.literal("\u00A77\u00A7oPress \u00A7fZ\u00A77 for \u00A79Adrenaline\u00A77, \u00A7fX\u00A77 for \u00A7cRage\u00A77, \u00A7fC\u00A77 for \u00A7aAccessories\u00A77, & \u00A7fV\u00A77 for \u00A76Crafting\u00A77."), false);
		if ((entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(CalamityModAttributes.HAS_JOINED_WORLD) ? _livingEntity4.getAttribute(CalamityModAttributes.HAS_JOINED_WORLD).getBaseValue() : 0) == 0) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CalamityModItems.COPPER_SHORTSWORD.get()).copy();
				_setstack.setCount(1);
				_player.getInventory().placeItemBackInInventory(_setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CalamityModItems.COPPER_PICKAXE.get()).copy();
				_setstack.setCount(1);
				_player.getInventory().placeItemBackInInventory(_setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CalamityModItems.COPPER_AXE.get()).copy();
				_setstack.setCount(1);
				_player.getInventory().placeItemBackInInventory(_setstack);
			}
			if (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(CalamityModAttributes.HAS_JOINED_WORLD))
				_livingEntity8.getAttribute(CalamityModAttributes.HAS_JOINED_WORLD).setBaseValue(1);
			if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity9.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10);
		}
	}
}