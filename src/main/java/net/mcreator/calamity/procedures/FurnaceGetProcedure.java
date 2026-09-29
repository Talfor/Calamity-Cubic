package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.calamity.init.CalamityModBlocks;

public class FurnaceGetProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double offset_x = 0;
		double offset_y = 0;
		double offset_z = 0;
		if (GetNearbyStationProcedure.execute(world, x, y, z, CalamityModBlocks.TERRARIA_FURNACE.get().defaultBlockState())) {
			return 0;
		}
		return 1;
	}
}