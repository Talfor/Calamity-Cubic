package net.mcreator.calamity.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.network.CalamityModVariables;

public class ReturnPlayerRageProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double quickstore = 0;
		quickstore = entity.getData(CalamityModVariables.PLAYER_VARIABLES).rage / 100;
		if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).rage / 100 > 1) {
			quickstore = 1;
		}
		return quickstore * 40;
	}
}