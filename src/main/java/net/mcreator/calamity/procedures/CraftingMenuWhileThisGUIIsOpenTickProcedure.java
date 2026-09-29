package net.mcreator.calamity.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.network.CalamityModVariables;
import net.mcreator.calamity.init.CalamityModMenus;

public class CraftingMenuWhileThisGUIIsOpenTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack slot_0 = ItemStack.EMPTY;
		double selectionid = 0;
		double maxid = 0;
		double slotselector = 0;
		maxid = 8;
		slotselector = 0;
		selectionid = entity.getData(CalamityModVariables.PLAYER_VARIABLES).craftingstation_offset;
		for (int _i1 = 0; _i1 < 7; _i1++) {
			slot_0 = new ItemStack(Blocks.AIR).copy();
			if (entity instanceof Player _player && _player.containerMenu instanceof CalamityModMenus.MenuAccessor _menu) {
				ItemStack _setstack0 = new ItemStack(Blocks.AIR).copy();
				_setstack0.setCount(1);
				_menu.getSlots().get((int) slotselector).set(_setstack0);
				_player.containerMenu.broadcastChanges();
			}
			while ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CalamityModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get((int) slotselector).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& selectionid + slotselector <= maxid) {
				slot_0 = GetSlotReturnProcedure.execute(world, x, y, z, entity, selectionid + slotselector).copy();
				if (entity instanceof Player _player && _player.containerMenu instanceof CalamityModMenus.MenuAccessor _menu) {
					ItemStack _setstack4 = slot_0.copy();
					_setstack4.setCount(slot_0.getCount());
					_menu.getSlots().get((int) slotselector).set(_setstack4);
					_player.containerMenu.broadcastChanges();
				}
				selectionid = selectionid + 1;
			}
			selectionid = selectionid - 1;
			slotselector = slotselector + 1;
		}
	}
}