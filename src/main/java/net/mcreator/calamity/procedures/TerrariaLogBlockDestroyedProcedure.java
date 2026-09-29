package net.mcreator.calamity.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.calamity.init.CalamityModBlocks;

public class TerrariaLogBlockDestroyedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double iteration = 0;
		for (int _i1 = 0; _i1 < 10; _i1++) {
			iteration = iteration + 1;
			if ((world.getBlockState(BlockPos.containing(x, y + iteration, z))).getBlock() == CalamityModBlocks.TERRARIA_LOG.get()) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("fill ~ ~" + iteration + " ~ ~ ~" + iteration + " ~ air destroy"));
			}
			if ((world.getBlockState(BlockPos.containing(x, y - iteration, z))).getBlock() == CalamityModBlocks.TERRARIA_LOG.get()) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("fill ~ ~-" + iteration + " ~ ~ ~-" + iteration + " ~ air destroy"));
			}
		}
	}
}