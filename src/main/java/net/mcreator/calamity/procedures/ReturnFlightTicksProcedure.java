package net.mcreator.calamity.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.init.CalamityModAttributes;

public class ReturnFlightTicksProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return Math
				.round(22 - Math.ceil(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(CalamityModAttributes.FLIGHT_TICKS) ? _livingEntity0.getAttribute(CalamityModAttributes.FLIGHT_TICKS).getValue() : 0)
						/ (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS) ? _livingEntity1.getAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS).getValue() : 0))
						* 22));
	}
}