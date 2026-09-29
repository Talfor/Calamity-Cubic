package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.calamity.network.CalamityModVariables;
import net.mcreator.calamity.init.CalamityModGameRules;

public class DifficultyReturnerProcedure {
	public static void execute(LevelAccessor world) {
		CalamityModVariables.MapVariables.get(world).difficultyreturner = (world instanceof ServerLevel _serverLevelGR0 ? _serverLevelGR0.getGameRules().get(CalamityModGameRules.DIFFICULTY_CALAMITY.get()) : 0);
		CalamityModVariables.MapVariables.get(world).markSyncDirty();
	}
}