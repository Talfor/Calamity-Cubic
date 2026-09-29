package net.mcreator.calamity.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import java.util.Comparator;

public class SetLocalBossProcedure {
	public static Entity execute(LevelAccessor world, double x, double y, double z) {
		Entity toReturn = null;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(128 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator.is(TagKey.create(Registries.ENTITY_TYPE, Identifier.parse("calamity:bosses")))) {
					if (toReturn != null) {
						if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (toReturn instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
							toReturn = entityiterator;
						}
					} else {
						toReturn = entityiterator;
					}
				}
			}
		}
		return toReturn;
	}
}