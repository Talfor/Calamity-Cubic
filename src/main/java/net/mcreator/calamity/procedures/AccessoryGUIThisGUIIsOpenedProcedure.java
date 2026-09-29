package net.mcreator.calamity.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.network.CalamityModVariables;
import net.mcreator.calamity.init.CalamityModMenus;

public class AccessoryGUIThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof CalamityModMenus.MenuAccessor _menu) {
			ItemStack _setstack1 = entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_1.copy();
			_setstack1.setCount(entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_1.getCount());
			_menu.getSlots().get(1).set(_setstack1);
			ItemStack _setstack3 = entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_2.copy();
			_setstack3.setCount(entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_2.getCount());
			_menu.getSlots().get(2).set(_setstack3);
			ItemStack _setstack5 = entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_3.copy();
			_setstack5.setCount(entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_3.getCount());
			_menu.getSlots().get(3).set(_setstack5);
			ItemStack _setstack7 = entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_4.copy();
			_setstack7.setCount(entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_4.getCount());
			_menu.getSlots().get(4).set(_setstack7);
			ItemStack _setstack9 = entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_5.copy();
			_setstack9.setCount(entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_5.getCount());
			_menu.getSlots().get(5).set(_setstack9);
			ItemStack _setstack11 = entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_6.copy();
			_setstack11.setCount(entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_6.getCount());
			_menu.getSlots().get(6).set(_setstack11);
			ItemStack _setstack13 = entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_7.copy();
			_setstack13.setCount(entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_7.getCount());
			_menu.getSlots().get(7).set(_setstack13);
			ItemStack _setstack15 = entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_8.copy();
			_setstack15.setCount(entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_8.getCount());
			_menu.getSlots().get(8).set(_setstack15);
			ItemStack _setstack17 = entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_9.copy();
			_setstack17.setCount(entity.getData(CalamityModVariables.PLAYER_VARIABLES).accessoryslot_9.getCount());
			_menu.getSlots().get(9).set(_setstack17);
			_player.containerMenu.broadcastChanges();
		}
	}
}