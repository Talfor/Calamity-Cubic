package net.mcreator.calamity.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.network.CalamityModVariables;

public class ReturnPlayerAdrenalineProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double quickstore = 0;
		quickstore = entity.getData(CalamityModVariables.PLAYER_VARIABLES).adrenaline / 100;
		if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).adrenaline / 100 > 1) {
			quickstore = 1;
		}
		return quickstore * 40;
	}
}