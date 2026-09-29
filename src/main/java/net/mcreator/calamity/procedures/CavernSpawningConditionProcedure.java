package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CavernSpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return y > 100 && y < 350 && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z));
	}
}