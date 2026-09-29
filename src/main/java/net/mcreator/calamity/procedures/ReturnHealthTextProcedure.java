package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ReturnHealthTextProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		Entity entitytograb = null;
		entitytograb = SetLocalBossProcedure.execute(world, x, y, z);
		return Math.round(entitytograb instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + " / " + Math.round(entitytograb instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
	}
}