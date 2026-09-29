package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.calamity.network.CalamityModVariables;

public class ReturnIfDifficulty2Procedure {
	public static boolean execute(LevelAccessor world) {
		return CalamityModVariables.MapVariables.get(world).difficultyreturner == 2;
	}
}