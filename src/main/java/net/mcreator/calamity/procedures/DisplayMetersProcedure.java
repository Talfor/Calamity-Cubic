package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.calamity.network.CalamityModVariables;

public class DisplayMetersProcedure {
	public static boolean execute(LevelAccessor world) {
		return CalamityModVariables.MapVariables.get(world).difficultyreturner > 1 && CalamityModVariables.MapVariables.get(world).difficultyreturner != 3 && CalamityModVariables.MapVariables.get(world).difficultyreturner != 5;
	}
}