package net.mcreator.calamity.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GetNearbyStationProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState sentBlock) {
		double offset_x = 0;
		double offset_y = 0;
		double offset_z = 0;
		offset_x = -2;
		offset_y = -2;
		offset_z = -2;
		for (int _i1 = 0; _i1 < 5; _i1++) {
			for (int _i2 = 0; _i2 < 5; _i2++) {
				for (int _i3 = 0; _i3 < 5; _i3++) {
					if (sentBlock.getBlock() == (world.getBlockState(BlockPos.containing(x + offset_x, y + offset_y, z + offset_z))).getBlock()) {
						return true;
					}
					offset_z = offset_z + 1;
				}
				offset_z = -2;
				offset_y = offset_y + 1;
			}
			offset_y = -2;
			offset_x = offset_x + 1;
		}
		return false;
	}
}