package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class NighttimeSpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return !(world instanceof Level _lvl0 && _lvl0.isBrightOutside()) && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z));
	}
}