package net.mcreator.calamity.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.init.CalamityModAttributes;

public class ReturnDefenseAttributeProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + Math.round(
				Math.ceil(entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(CalamityModAttributes.DEFENSE_TERRARIA) ? _livingEntity0.getAttribute(CalamityModAttributes.DEFENSE_TERRARIA).getBaseValue() : 0));
	}
}