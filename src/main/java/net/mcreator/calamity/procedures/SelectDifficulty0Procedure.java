package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.calamity.init.CalamityModGameRules;

public class SelectDifficulty0Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level) {
			_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7bClassic Selected"), false);
		}
		if (world instanceof ServerLevel _serverLevel)
			_serverLevel.getGameRules().set(CalamityModGameRules.DIFFICULTY_CALAMITY.get(), 0, world.getServer());
		DifficultyReturnerProcedure.execute(world);
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}