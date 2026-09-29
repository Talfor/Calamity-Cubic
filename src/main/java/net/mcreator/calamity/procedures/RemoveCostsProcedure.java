package net.mcreator.calamity.procedures;

import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.init.CalamityModItems;
import net.mcreator.calamity.init.CalamityModBlocks;

public class RemoveCostsProcedure {
	public static void execute(Entity entity, double slot) {
		if (entity == null)
			return;
		if ((getEntitySlot(entity, (int) slot)).getItem() == CalamityModBlocks.WORK_BENCH.get().asItem()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModBlocks.TERRARIA_WOOD.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 10, _player.inventoryMenu.getCraftSlots());
			}
		}
		if ((getEntitySlot(entity, (int) slot)).getItem() == CalamityModBlocks.TERRARIA_FURNACE.get().asItem()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModBlocks.TERRARIA_STONE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 20, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModBlocks.TERRARIA_WOOD.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 4, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Items.TORCH);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 3, _player.inventoryMenu.getCraftSlots());
			}
		}
		if ((getEntitySlot(entity, (int) slot)).getItem() == Items.TORCH) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModBlocks.TERRARIA_WOOD.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModItems.GEL.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
		if ((getEntitySlot(entity, (int) slot)).getItem() == CalamityModItems.TERRARIA_COPPER_INGOT.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModBlocks.TERRARIA_COPPER_ORE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 3, _player.inventoryMenu.getCraftSlots());
			}
		}
		if ((getEntitySlot(entity, (int) slot)).getItem() == CalamityModItems.TERRARIA_TIN_INGOT.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModBlocks.TERRARIA_TIN_ORE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 3, _player.inventoryMenu.getCraftSlots());
			}
		}
		if ((getEntitySlot(entity, (int) slot)).getItem() == CalamityModItems.TERRARIA_IRON_INGOT.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModBlocks.TERRARIA_IRON_ORE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 3, _player.inventoryMenu.getCraftSlots());
			}
		}
		if ((getEntitySlot(entity, (int) slot)).getItem() == CalamityModItems.COPPER_SHORTSWORD.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModItems.TERRARIA_COPPER_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 5, _player.inventoryMenu.getCraftSlots());
			}
		}
		if ((getEntitySlot(entity, (int) slot)).getItem() == CalamityModItems.COPPER_BOARDSWORD.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModItems.TERRARIA_COPPER_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 6, _player.inventoryMenu.getCraftSlots());
			}
		}
		if ((getEntitySlot(entity, (int) slot)).getItem() == CalamityModItems.COPPER_PICKAXE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModItems.TERRARIA_COPPER_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 8, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModBlocks.TERRARIA_WOOD.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 4, _player.inventoryMenu.getCraftSlots());
			}
		}
		if ((getEntitySlot(entity, (int) slot)).getItem() == CalamityModItems.COPPER_AXE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModItems.TERRARIA_COPPER_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 6, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CalamityModBlocks.TERRARIA_WOOD.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 3, _player.inventoryMenu.getCraftSlots());
			}
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