package net.mcreator.calamity.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.init.CalamityModAttributes;

public class ReturnIfAppearFlightTicksProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS) ? _livingEntity0.getAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS).getBaseValue() : 0) != 0;
	}
}