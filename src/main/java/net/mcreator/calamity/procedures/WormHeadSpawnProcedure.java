package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.calamity.init.CalamityModEntities;
import net.mcreator.calamity.init.CalamityModAttributes;
import net.mcreator.calamity.entity.WormHeadAIEntity;

public class WormHeadSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity storedentity = null;
		double segment = 0;
		segment = entity instanceof WormHeadAIEntity _datEntI ? _datEntI.getEntityData().get(WormHeadAIEntity.DATA_segments) : 0;
		if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(CalamityModAttributes.WORM_AI_TAG))
			_livingEntity2.getAttribute(CalamityModAttributes.WORM_AI_TAG).setBaseValue((Mth.nextInt(RandomSource.create(), 0, 1000000000)));
		{
			Entity _ent = entity;
			double _tx = x;
			double _ty = (y + 1);
			double _tz = z;
			_ent.teleportTo(_tx, _ty, _tz);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
		}
		storedentity = world instanceof ServerLevel _level4 ? CalamityModEntities.WORM_BODY_AI.get().spawn(_level4, BlockPos.containing(x + segment, y, z), EntitySpawnReason.MOB_SUMMONED) : null;
		if (storedentity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(CalamityModAttributes.WORM_AIID))
			_livingEntity5.getAttribute(CalamityModAttributes.WORM_AIID).setBaseValue(segment);
		if (storedentity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(CalamityModAttributes.WORM_AI_TAG))
			_livingEntity7.getAttribute(CalamityModAttributes.WORM_AI_TAG)
					.setBaseValue((entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(CalamityModAttributes.WORM_AI_TAG) ? _livingEntity6.getAttribute(CalamityModAttributes.WORM_AI_TAG).getBaseValue() : 0));
		segment = segment - 1;
		while (segment >= 0) {
			storedentity = world instanceof ServerLevel _level8 ? CalamityModEntities.WORM_BODY_AI.get().spawn(_level8, BlockPos.containing(x + segment, y, z), EntitySpawnReason.MOB_SUMMONED) : null;
			if (storedentity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(CalamityModAttributes.WORM_AIID))
				_livingEntity9.getAttribute(CalamityModAttributes.WORM_AIID).setBaseValue(segment);
			if (storedentity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(CalamityModAttributes.WORM_AI_TAG))
				_livingEntity11.getAttribute(CalamityModAttributes.WORM_AI_TAG).setBaseValue(
						(entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(CalamityModAttributes.WORM_AI_TAG) ? _livingEntity10.getAttribute(CalamityModAttributes.WORM_AI_TAG).getBaseValue() : 0));
			segment = segment - 1;
		}
	}
}