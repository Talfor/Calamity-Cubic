package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.calamity.init.CalamityModGameRules;

public class SelectDifficulty6Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("calamity:difficultyset_malice")), SoundSource.MASTER, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("calamity:difficultyset_malice")), SoundSource.MASTER, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level) {
			_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A78Malice Selected"), false);
		}
		if (world instanceof ServerLevel _serverLevel)
			_serverLevel.getGameRules().set(CalamityModGameRules.DIFFICULTY_CALAMITY.get(), 6, world.getServer());
		DifficultyReturnerProcedure.execute(world);
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}