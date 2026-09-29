package net.mcreator.calamity.procedures;

import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class GetItemNumberProcedure {
	public static double execute(Entity entity, ItemStack sentItem) {
		if (entity == null)
			return 0;
		double itemcount = 0;
		double slot = 0;
		itemcount = 0;
		for (int _i1 = 0; _i1 < 36; _i1++) {
			if ((getEntitySlot(entity, (int) slot)).getItem() == sentItem.getItem()) {
				itemcount = itemcount + (getEntitySlot(entity, (int) slot)).getCount();
			}
			slot = slot + 1;
		}
		return itemcount;
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