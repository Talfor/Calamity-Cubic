package net.mcreator.calamity.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.network.CalamityModVariables;

public class MoveSelectionLeftProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).craftingstation_offset > 0) {
			{
				CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
				_vars.craftingstation_offset = entity.getData(CalamityModVariables.PLAYER_VARIABLES).craftingstation_offset - 1;
				_vars.markSyncDirty();
			}
		}
	}
}