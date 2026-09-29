package net.mcreator.calamity.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.calamity.network.CalamityModVariables;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class PlayerTickRAProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean bossexists = false;
		double distancetonearestentity = 0;
		if (CalamityModVariables.MapVariables.get(world).difficultyreturner > 1 && CalamityModVariables.MapVariables.get(world).difficultyreturner != 3 && CalamityModVariables.MapVariables.get(world).difficultyreturner != 5) {
			if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).rageactive) {
				{
					CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
					_vars.rage = entity.getData(CalamityModVariables.PLAYER_VARIABLES).rage - 0.5555556;
					_vars.markSyncDirty();
				}
				if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).rage < 0) {
					{
						CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
						_vars.rageactive = false;
						_vars.markSyncDirty();
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("calamity:rage_end")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("calamity:rage_end")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (entity instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(Identifier.parse("calamity:rage"));
					}
				}
			} else {
				if (!world.getEntitiesOfClass(Monster.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(42 / 2d), e -> true).isEmpty()) {
					if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).rage != 105) {
						distancetonearestentity = (entity.position()).distanceTo(((findEntityInWorldRange(world, Monster.class, x, y, z, 50)).position()));
						if (distancetonearestentity < 8) {
							distancetonearestentity = 8;
						}
						{
							CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
							_vars.rage = entity.getData(CalamityModVariables.PLAYER_VARIABLES).rage + (1 / (0.034 * distancetonearestentity + 2) + (590.5 - distancetonearestentity) / 1181) * 0.111111111111;
							_vars.markSyncDirty();
						}
						if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).rage > 100) {
							{
								CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
								_vars.rage = 105;
								_vars.markSyncDirty();
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("calamity:rage_full")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("calamity:rage_full")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					}
				} else {
					{
						CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
						_vars.rage = entity.getData(CalamityModVariables.PLAYER_VARIABLES).rage - 0.16666668;
						_vars.markSyncDirty();
					}
				}
				if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).rage < 0) {
					{
						CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
						_vars.rage = 0;
						_vars.markSyncDirty();
					}
				}
			}
			if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).adrenalineactive) {
				{
					CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
					_vars.adrenaline = entity.getData(CalamityModVariables.PLAYER_VARIABLES).adrenaline - 1;
					_vars.markSyncDirty();
				}
				if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).adrenaline < 0) {
					{
						CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
						_vars.adrenalineactive = false;
						_vars.markSyncDirty();
					}
					if (entity instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(Identifier.parse("calamity:adrenaline"));
					}
				}
			} else {
				bossexists = false;
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator.is(TagKey.create(Registries.ENTITY_TYPE, Identifier.parse("calamity:bosses")))) {
							if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).adrenaline != 105) {
								{
									CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
									_vars.adrenaline = entity.getData(CalamityModVariables.PLAYER_VARIABLES).adrenaline + 0.166666667;
									_vars.markSyncDirty();
								}
								if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).adrenaline > 100) {
									{
										CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
										_vars.adrenaline = 105;
										_vars.markSyncDirty();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("calamity:adrenaline_full")), SoundSource.PLAYERS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("calamity:adrenaline_full")), SoundSource.PLAYERS, 1, 1, false);
										}
									}
								}
							}
							bossexists = true;
							break;
						}
					}
				}
				if (!bossexists) {
					{
						CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
						_vars.adrenaline = entity.getData(CalamityModVariables.PLAYER_VARIABLES).adrenaline - 1;
						_vars.markSyncDirty();
					}
				}
				if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).adrenaline < 0) {
					{
						CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
						_vars.adrenaline = 0;
						_vars.markSyncDirty();
					}
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}