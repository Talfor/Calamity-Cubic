package net.mcreator.calamity.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.network.CalamityModVariables;
import net.mcreator.calamity.init.CalamityModMenus;

public class AccessoryGUIOpenTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
			_vars.accessoryslot_1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CalamityModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(1).getItem() : ItemStack.EMPTY).copy();
			_vars.accessoryslot_2 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CalamityModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(2).getItem() : ItemStack.EMPTY).copy();
			_vars.accessoryslot_3 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CalamityModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(3).getItem() : ItemStack.EMPTY).copy();
			_vars.accessoryslot_4 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CalamityModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(4).getItem() : ItemStack.EMPTY).copy();
			_vars.accessoryslot_5 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CalamityModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(5).getItem() : ItemStack.EMPTY).copy();
			_vars.accessoryslot_6 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CalamityModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(6).getItem() : ItemStack.EMPTY).copy();
			_vars.accessoryslot_7 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CalamityModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(7).getItem() : ItemStack.EMPTY).copy();
			_vars.accessoryslot_8 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CalamityModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(8).getItem() : ItemStack.EMPTY).copy();
			_vars.accessoryslot_9 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CalamityModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(9).getItem() : ItemStack.EMPTY).copy();
			_vars.markSyncDirty();
		}
	}
}