package net.mcreator.calamity.procedures;

import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.init.CalamityModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerCoinProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double inventoryslot = 0;
		inventoryslot = 0;
		for (int _i1 = 0; _i1 < 36; _i1++) {
			if ((getEntitySlot(entity, (int) inventoryslot)).getCount() == 99) {
				if ((getEntitySlot(entity, (int) inventoryslot)).getItem() == CalamityModItems.COIN_COPPER.get()) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(CalamityModItems.COIN_COPPER.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 99, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(CalamityModItems.COIN_SILVER.get()).copy();
						_setstack.setCount(1);
						_player.getInventory().placeItemBackInInventory(_setstack);
					}
				} else if ((getEntitySlot(entity, (int) inventoryslot)).getItem() == CalamityModItems.COIN_SILVER.get()) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(CalamityModItems.COIN_SILVER.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 99, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(CalamityModItems.COIN_GOLD.get()).copy();
						_setstack.setCount(1);
						_player.getInventory().placeItemBackInInventory(_setstack);
					}
				} else if ((getEntitySlot(entity, (int) inventoryslot)).getItem() == CalamityModItems.COIN_GOLD.get()) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(CalamityModItems.COIN_GOLD.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 99, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(CalamityModItems.COIN_PLATINUM.get()).copy();
						_setstack.setCount(1);
						_player.getInventory().placeItemBackInInventory(_setstack);
					}
				}
			}
			inventoryslot = inventoryslot + 1;
		}
	}

	private static ItemStack getEntitySlot(Entity entity, int slot) {
		if (entity != null) {
			ResourceHandler<ItemResource> resourceHandler = entity.getCapability(Capabilities.Item.ENTITY, null);
			if (resourceHandler != null) {
				return ItemUtil.getStack(resourceHandler, slot);
			}
		}
		return ItemStack.EMPTY;
	}
}