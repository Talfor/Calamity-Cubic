package net.mcreator.calamity.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.network.CalamityModVariables;

public class ButtonFlightReleaseProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
			_vars.flybuttonactive = false;
			_vars.markSyncDirty();
		}
	}
}