package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.calamity.network.CalamityModVariables;

public class ReturnIfDifficulty5Procedure {
	public static boolean execute(LevelAccessor world) {
		return CalamityModVariables.MapVariables.get(world).difficultyreturner == 5;
	}
}