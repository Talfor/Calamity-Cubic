package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ReturnBossTitleProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		Entity entitytograb = null;
		entitytograb = SetLocalBossProcedure.execute(world, x, y, z);
		return (new java.text.DecimalFormat("##.##").format(((double) (entitytograb instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / (entitytograb instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) * 100)) + "%   -   "
				+ entitytograb.getDisplayName().getString();
	}
}