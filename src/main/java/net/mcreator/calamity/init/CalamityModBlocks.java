/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.calamity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.calamity.block.*;
import net.mcreator.calamity.CalamityMod;

import java.util.function.Function;

public class CalamityModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(CalamityMod.MODID);
	public static final DeferredBlock<Block> TERRARIA_DIRT;
	public static final DeferredBlock<Block> TERRARIA_STONE;
	public static final DeferredBlock<Block> TERRARIA_GRASS;
	public static final DeferredBlock<Block> TERRARIA_WOOD;
	public static final DeferredBlock<Block> TERRARIA_LEAVES;
	public static final DeferredBlock<Block> TERRARIA_LOG;
	public static final DeferredBlock<Block> TERRARIA_SAND;
	public static final DeferredBlock<Block> CALAMITY_SULPHUROUS_SAND;
	public static final DeferredBlock<Block> TERRARIA_COPPER_ORE;
	public static final DeferredBlock<Block> TERRARIA_ICE;
	public static final DeferredBlock<Block> TERRARIA_SNOW;
	public static final DeferredBlock<Block> TERRARIA_MUD;
	public static final DeferredBlock<Block> TERRARIA_JUNGLE_GRASS;
	public static final DeferredBlock<Block> TERRARIA_SANDSTONE;
	public static final DeferredBlock<Block> TERRARIA_HARDENED_STONE;
	public static final DeferredBlock<Block> TERRARIA_TIN_ORE;
	public static final DeferredBlock<Block> TERRARIA_IRON_ORE;
	public static final DeferredBlock<Block> TERRARIA_LEAD_ORE;
	public static final DeferredBlock<Block> TERRARIA_SILVER_ORE;
	public static final DeferredBlock<Block> TERRARIA_TUNGSTEN_ORE;
	public static final DeferredBlock<Block> TERRARIA_GOLD_ORE;
	public static final DeferredBlock<Block> TERRARIA_PLATINUM_ORE;
	public static final DeferredBlock<Block> TERRARIA_HELLSTONE;
	public static final DeferredBlock<Block> TERRARIA_CRIMTANE_ORE;
	public static final DeferredBlock<Block> TERRARIA_DEMONITE_ORE;
	public static final DeferredBlock<Block> WORK_BENCH;
	public static final DeferredBlock<Block> ANVIL;
	public static final DeferredBlock<Block> TERRARIA_FURNACE;
	public static final DeferredBlock<Block> TERRARIA_CLAY;
	public static final DeferredBlock<Block> TERRARIA_ASH;
	public static final DeferredBlock<Block> LIFE_CRYSTAL;
	static {
		TERRARIA_DIRT = register("terraria_dirt", TerrariaDirtBlock::new);
		TERRARIA_STONE = register("terraria_stone", TerrariaStoneBlock::new);
		TERRARIA_GRASS = register("terraria_grass", TerrariaGrassBlock::new);
		TERRARIA_WOOD = register("terraria_wood", TerrariaWoodBlock::new);
		TERRARIA_LEAVES = register("terraria_leaves", TerrariaLeavesBlock::new);
		TERRARIA_LOG = register("terraria_log", TerrariaLogBlock::new);
		TERRARIA_SAND = register("terraria_sand", TerrariaSandBlock::new);
		CALAMITY_SULPHUROUS_SAND = register("calamity_sulphurous_sand", CalamitySulphurousSandBlock::new);
		TERRARIA_COPPER_ORE = register("terraria_copper_ore", TerrariaCopperOreBlock::new);
		TERRARIA_ICE = register("terraria_ice", TerrariaIceBlock::new);
		TERRARIA_SNOW = register("terraria_snow", TerrariaSnowBlock::new);
		TERRARIA_MUD = register("terraria_mud", TerrariaMudBlock::new);
		TERRARIA_JUNGLE_GRASS = register("terraria_jungle_grass", TerrariaJungleGrassBlock::new);
		TERRARIA_SANDSTONE = register("terraria_sandstone", TerrariaSandstoneBlock::new);
		TERRARIA_HARDENED_STONE = register("terraria_hardened_stone", TerrariaHardenedStoneBlock::new);
		TERRARIA_TIN_ORE = register("terraria_tin_ore", TerrariaTinOreBlock::new);
		TERRARIA_IRON_ORE = register("terraria_iron_ore", TerrariaIronOreBlock::new);
		TERRARIA_LEAD_ORE = register("terraria_lead_ore", TerrariaLeadOreBlock::new);
		TERRARIA_SILVER_ORE = register("terraria_silver_ore", TerrariaSilverOreBlock::new);
		TERRARIA_TUNGSTEN_ORE = register("terraria_tungsten_ore", TerrariaTungstenOreBlock::new);
		TERRARIA_GOLD_ORE = register("terraria_gold_ore", TerrariaGoldOreBlock::new);
		TERRARIA_PLATINUM_ORE = register("terraria_platinum_ore", TerrariaPlatinumOreBlock::new);
		TERRARIA_HELLSTONE = register("terraria_hellstone", TerrariaHellstoneBlock::new);
		TERRARIA_CRIMTANE_ORE = register("terraria_crimtane_ore", TerrariaCrimtaneOreBlock::new);
		TERRARIA_DEMONITE_ORE = register("terraria_demonite_ore", TerrariaDemoniteOreBlock::new);
		WORK_BENCH = register("work_bench", WorkBenchBlock::new);
		ANVIL = register("anvil", AnvilBlock::new);
		TERRARIA_FURNACE = register("terraria_furnace", TerrariaFurnaceBlock::new);
		TERRARIA_CLAY = register("terraria_clay", TerrariaClayBlock::new);
		TERRARIA_ASH = register("terraria_ash", TerrariaAshBlock::new);
		LIFE_CRYSTAL = register("life_crystal", LifeCrystalBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}