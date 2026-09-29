package net.mcreator.calamity.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.network.CalamityModVariables;
import net.mcreator.calamity.init.CalamityModAttributes;

public class GetIfAccessoryExistsProcedure {
	public static boolean execute(Entity entity, ItemStack sentItem) {
		if (entity == null)
			return false;
		double slotid = 0;
		slotid = 1;
		for (int _i1 = 0; _i1 < (int) (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(CalamityModAttributes.ACCESSORY_SLOT_COUNT)
				? _livingEntity0.getAttribute(CalamityModAttributes.ACCESSORY_SLOT_COUNT).getBaseValue()
				: 0); _i1++) {
			if (slotid == 1 && entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_1.getItem() == sentItem.getItem()
					|| slotid == 2 && entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_2.getItem() == sentItem.getItem()
					|| slotid == 3 && entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_3.getItem() == sentItem.getItem()
					|| slotid == 4 && entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_4.getItem() == sentItem.getItem()
					|| slotid == 5 && entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_5.getItem() == sentItem.getItem()
					|| slotid == 6 && entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_6.getItem() == sentItem.getItem()
					|| slotid == 7 && entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_7.getItem() == sentItem.getItem()
					|| slotid == 8 && entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_8.getItem() == sentItem.getItem()
					|| slotid == 9 && entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_9.getItem() == sentItem.getItem()) {
				return true;
			}
			slotid = slotid + 1;
		}
		return false;
	}
}