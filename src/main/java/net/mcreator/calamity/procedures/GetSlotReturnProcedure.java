package net.mcreator.calamity.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.init.CalamityModItems;
import net.mcreator.calamity.init.CalamityModBlocks;

public class GetSlotReturnProcedure {
	public static ItemStack execute(LevelAccessor world, double x, double y, double z, Entity entity, double ID) {
		if (entity == null)
			return ItemStack.EMPTY;
		ItemStack toReturn = ItemStack.EMPTY;
		double stacksize = 0;
		double id_scan = 0;
		stacksize = 1;
		toReturn = new ItemStack(Blocks.AIR).copy();
		id_scan = 0;
		if (true) {
			id_scan = id_scan + 1;
			if (ID == id_scan) {
				if (GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModBlocks.TERRARIA_WOOD.get())) >= 10) {
					toReturn = new ItemStack(CalamityModBlocks.WORK_BENCH.get()).copy();
				}
			}
		}
		if (true) {
			id_scan = id_scan + 1;
			if (ID == id_scan) {
				if (GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModBlocks.TERRARIA_WOOD.get())) >= 1 && GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModItems.GEL.get())) >= 1) {
					stacksize = 3;
					toReturn = new ItemStack(Items.TORCH).copy();
				}
			}
		}
		if (true) {
			id_scan = id_scan + 1;
			if (ID == id_scan) {
				if (GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModBlocks.TERRARIA_STONE.get())) >= 20 && GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModBlocks.TERRARIA_WOOD.get())) >= 4
						&& GetItemNumberProcedure.execute(entity, new ItemStack(Items.TORCH)) >= 3 && GetNearbyStationProcedure.execute(world, x, y, z, CalamityModBlocks.WORK_BENCH.get().defaultBlockState())) {
					toReturn = new ItemStack(CalamityModBlocks.TERRARIA_FURNACE.get()).copy();
				}
			}
		}
		if (true) {
			id_scan = id_scan + 1;
			if (ID == id_scan) {
				if (GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModBlocks.TERRARIA_COPPER_ORE.get())) >= 3 && GetNearbyStationProcedure.execute(world, x, y, z, CalamityModBlocks.TERRARIA_FURNACE.get().defaultBlockState())) {
					toReturn = new ItemStack(CalamityModItems.TERRARIA_COPPER_INGOT.get()).copy();
				}
			}
		}
		if (true) {
			id_scan = id_scan + 1;
			if (ID == id_scan) {
				if (GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModBlocks.TERRARIA_TIN_ORE.get())) >= 3 && GetNearbyStationProcedure.execute(world, x, y, z, CalamityModBlocks.TERRARIA_FURNACE.get().defaultBlockState())) {
					toReturn = new ItemStack(CalamityModItems.TERRARIA_TIN_INGOT.get()).copy();
				}
			}
		}
		if (true) {
			id_scan = id_scan + 1;
			if (ID == id_scan) {
				if (GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModBlocks.TERRARIA_IRON_ORE.get())) >= 3 && GetNearbyStationProcedure.execute(world, x, y, z, CalamityModBlocks.TERRARIA_FURNACE.get().defaultBlockState())) {
					toReturn = new ItemStack(CalamityModItems.TERRARIA_IRON_INGOT.get()).copy();
				}
			}
		}
		if (true) {
			id_scan = id_scan + 1;
			if (ID == id_scan) {
				if (GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModItems.TERRARIA_COPPER_INGOT.get())) >= 5 && GetNearbyStationProcedure.execute(world, x, y, z, CalamityModBlocks.ANVIL.get().defaultBlockState())) {
					toReturn = new ItemStack(CalamityModItems.COPPER_SHORTSWORD.get()).copy();
				}
			}
		}
		if (true) {
			id_scan = id_scan + 1;
			if (ID == id_scan) {
				if (GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModItems.TERRARIA_COPPER_INGOT.get())) >= 6 && GetNearbyStationProcedure.execute(world, x, y, z, CalamityModBlocks.ANVIL.get().defaultBlockState())) {
					toReturn = new ItemStack(CalamityModItems.COPPER_BOARDSWORD.get()).copy();
				}
			}
		}
		if (true) {
			id_scan = id_scan + 1;
			if (ID == id_scan) {
				if (GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModBlocks.TERRARIA_WOOD.get())) >= 8 && GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModItems.TERRARIA_COPPER_INGOT.get())) >= 4
						&& GetNearbyStationProcedure.execute(world, x, y, z, CalamityModBlocks.ANVIL.get().defaultBlockState())) {
					toReturn = new ItemStack(CalamityModItems.COPPER_PICKAXE.get()).copy();
				}
			}
		}
		if (true) {
			id_scan = id_scan + 1;
			if (ID == id_scan) {
				if (GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModBlocks.TERRARIA_WOOD.get())) >= 6 && GetItemNumberProcedure.execute(entity, new ItemStack(CalamityModItems.TERRARIA_COPPER_INGOT.get())) >= 3
						&& GetNearbyStationProcedure.execute(world, x, y, z, CalamityModBlocks.ANVIL.get().defaultBlockState())) {
					toReturn = new ItemStack(CalamityModItems.COPPER_AXE.get()).copy();
				}
			}
		}
		toReturn.setCount((int) stacksize);
		return toReturn;
	}
}