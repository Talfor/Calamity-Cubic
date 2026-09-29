package net.mcreator.calamity.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.storage.WritableLevelData;
import net.minecraft.world.level.storage.LevelData;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.calamity.world.inventory.DifficultySelectionMenu;
import net.mcreator.calamity.network.CalamityModVariables;

import javax.annotation.Nullable;

import java.util.Set;

@EventBusSubscriber
public class PlayerJoinsDimensionProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double height = 0;
		if (!(entity instanceof Player _plr0 && _plr0.containerMenu instanceof DifficultySelectionMenu)) {
			if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, Identifier.parse("calamity:terraria")))) {
				if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _serverLevel) {
					ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, Identifier.parse("calamity:terraria"));
					if (_player.level().dimension() == destinationType)
						return;
					ServerLevel nextLevel = _serverLevel.getServer().getLevel(destinationType);
					if (nextLevel != null) {
						_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
						_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), Set.of(), _player.getYRot(), _player.getXRot(), true);
						_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
						for (MobEffectInstance _effectinstance : _player.getActiveEffects())
							_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
						_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
				height = 64;
				{
					CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
					_vars.heightcontinue = true;
					_vars.markSyncDirty();
				}
				while (entity.getData(CalamityModVariables.PLAYER_VARIABLES).heightcontinue) {
					height = height + 1;
					if (height > 399) {
						break;
					}
					{
						CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
						_vars.heighttemp = height;
						_vars.markSyncDirty();
					}
					if (world instanceof ServerLevel _origLevel) {
						LevelAccessor _switchworld6 = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, Identifier.parse("calamity:terraria")));
						if (_switchworld6 != null) {
							worldSwitch6(_switchworld6, entity);
						}
					}
				}
				if (world.getLevelData() instanceof WritableLevelData _levelData && world instanceof Level _level)
					_levelData.setSpawn(LevelData.RespawnData.of(_level.dimension(), BlockPos.containing(0, height, 0), 0.0F, 0.0F));
				{
					Entity _ent = entity;
					double _tx = 0;
					double _ty = height;
					double _tz = 0;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}

	private static void worldSwitch6(LevelAccessor world, Entity entity) {
		if (world.canSeeSkyFromBelowWater(BlockPos.containing(0, entity.getData(CalamityModVariables.PLAYER_VARIABLES).heighttemp, 0))) {
			{
				CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
				_vars.heightcontinue = false;
				_vars.markSyncDirty();
			}
		}
	}
}