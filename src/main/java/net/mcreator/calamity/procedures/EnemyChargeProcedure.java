package net.mcreator.calamity.procedures;

import net.minecraft.world.entity.Entity;

public class EnemyChargeProcedure {
	public static void execute(double x, double y, double z, Entity entity, Entity target) {
		if (entity == null || target == null)
			return;
		Entity entitystored = null;
		entitystored = target;
		if ((entity.position()).distanceTo((target.position())) > 30) {
			entity.push((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z));
		} else {
			entity.push((entity.getLookAngle().x * (1.3 - (entitystored.getX() - x) * 0.05)), (entity.getLookAngle().y * (1.3 - (entitystored.getY() - y) * 0.03)), (entity.getLookAngle().z * (1.3 - (entitystored.getZ() - z) * 0.05)));
		}
	}
}