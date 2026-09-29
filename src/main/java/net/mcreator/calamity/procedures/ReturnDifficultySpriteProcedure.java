package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.calamity.init.CalamityModGameRules;

public class ReturnDifficultySpriteProcedure {
	public static double execute(LevelAccessor world) {
		if ((world instanceof ServerLevel _serverLevelGR0 ? _serverLevelGR0.getGameRules().get(CalamityModGameRules.DIFFICULTY_CALAMITY.get()) : 0) > 2) {
			return 0;
		}
		if ((world instanceof ServerLevel _serverLevelGR1 ? _serverLevelGR1.getGameRules().get(CalamityModGameRules.DIFFICULTY_CALAMITY.get()) : 0) > 0) {
			return 1;
		}
		return 2;
	}
}