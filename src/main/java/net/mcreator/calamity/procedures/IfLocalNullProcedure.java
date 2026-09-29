package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;

public class IfLocalNullProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return SetLocalBossProcedure.execute(world, x, y, z) != null;
	}
}