package net.mcreator.calamity.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.calamity.network.CalamityModVariables;
import net.mcreator.calamity.init.CalamityModAttributes;
import net.mcreator.calamity.entity.WormHeadAIEntity;
import net.mcreator.calamity.entity.WormBodyAIEntity;

import java.util.UUID;
import java.util.Comparator;

public class WormBodyAITickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity storedentity = null;
		double distance = 0;
		double num_x = 0;
		double num_y = 0;
		double num_z = 0;
		if (!world.getEntitiesOfClass(Player.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(2 / 2d), e -> true).isEmpty()) {
			{
				Entity _ent = (findEntityInWorldRange(world, Player.class, x, y, z, 3));
				if (_ent.level() instanceof ServerLevel _serverLevel) {
					_ent.hurtServer(_serverLevel, new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), entity), 5);
				}
			}
		}
		entity.setNoGravity(true);
		if (entity instanceof WormBodyAIEntity) {
			if ((world instanceof ServerLevel _level7 ? getEntityFromUUID(_level7, (entity instanceof WormBodyAIEntity _datEntS ? _datEntS.getEntityData().get(WormBodyAIEntity.DATA_linked_uuid) : "")) : null) != null) {
				storedentity = world instanceof ServerLevel _level9 ? getEntityFromUUID(_level9, (entity instanceof WormBodyAIEntity _datEntS ? _datEntS.getEntityData().get(WormBodyAIEntity.DATA_linked_uuid) : "")) : null;
			}
		}
		if (storedentity == null) {
			if ((entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(CalamityModAttributes.WORM_AIID) ? _livingEntity10.getAttribute(CalamityModAttributes.WORM_AIID).getValue() : 0) == 0) {
				if (!world.getEntitiesOfClass(WormHeadAIEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(128 / 2d), e -> true).isEmpty()) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(128 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof WormHeadAIEntity) {
								if ((entityiterator instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(CalamityModAttributes.WORM_AI_TAG)
										? _livingEntity13.getAttribute(CalamityModAttributes.WORM_AI_TAG).getValue()
										: 0) == (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(CalamityModAttributes.WORM_AI_TAG)
												? _livingEntity14.getAttribute(CalamityModAttributes.WORM_AI_TAG).getValue()
												: 0)) {
									storedentity = entityiterator;
									break;
								}
							}
						}
					}
				}
			} else {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(128 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof WormBodyAIEntity) {
							if ((entityiterator instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(CalamityModAttributes.WORM_AIID)
									? _livingEntity17.getAttribute(CalamityModAttributes.WORM_AIID).getValue()
									: 0) == (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(CalamityModAttributes.WORM_AIID)
											? _livingEntity18.getAttribute(CalamityModAttributes.WORM_AIID).getValue()
											: 0) - 1
									&& (entityiterator instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(CalamityModAttributes.WORM_AI_TAG)
											? _livingEntity19.getAttribute(CalamityModAttributes.WORM_AI_TAG).getValue()
											: 0) == (entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(CalamityModAttributes.WORM_AI_TAG)
													? _livingEntity20.getAttribute(CalamityModAttributes.WORM_AI_TAG).getValue()
													: 0)) {
								storedentity = entityiterator;
								break;
							}
						}
					}
				}
			}
		}
		if (storedentity != null) {
			distance = (storedentity.position()).distanceTo((storedentity.position()));
			if (distance > entity.getBbWidth() / 2d) {
				num_x = storedentity.getX() - x;
				num_y = storedentity.getY() - y;
				num_z = storedentity.getZ() - z;
				if (distance != 0) {
					num_x = (num_x / Math.abs(num_x)) * Math.abs((storedentity.getX() - x) / 1.5);
				}
				if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).rage != 0) {
					num_y = (num_y / Math.abs(num_y)) * Math.abs((storedentity.getY() - y) / 1.5);
				}
				if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).rage != 0) {
					num_z = (num_z / Math.abs(num_z)) * Math.abs((storedentity.getZ() - z) / 1.5);
				}
				{
					Entity _ent = entity;
					double _tx = (x + num_x);
					double _ty = (y + num_y);
					double _tz = (z + num_z);
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			}
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((storedentity.getX()), (storedentity.getY()), (storedentity.getZ())));
		} else {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.NETHERRACK.defaultBlockState()));
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}

	private static Entity getEntityFromUUID(ServerLevel level, String uuid) {
		try {
			return level.getEntity(UUID.fromString(uuid));
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}