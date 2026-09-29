/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.calamity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.calamity.item.*;
import net.mcreator.calamity.CalamityMod;

import java.util.function.Function;

public class CalamityModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(CalamityMod.MODID);
	public static final DeferredItem<Item> COPPER_SHORTSWORD;
	public static final DeferredItem<Item> GREATSWORD_OF_JUDGEMENT;
	public static final DeferredItem<Item> COPPER_PICKAXE;
	public static final DeferredItem<Item> COPPER_AXE;
	public static final DeferredItem<Item> TERRARIA_DIRT;
	public static final DeferredItem<Item> TERRARIA_STONE;
	public static final DeferredItem<Item> TERRARIA_WOOD;
	public static final DeferredItem<Item> GEL;
	public static final DeferredItem<Item> COIN_COPPER;
	public static final DeferredItem<Item> COIN_SILVER;
	public static final DeferredItem<Item> COIN_GOLD;
	public static final DeferredItem<Item> COIN_PLATINUM;
	public static final DeferredItem<Item> TERRARIA_SAND;
	public static final DeferredItem<Item> CALAMITY_SULPHUROUS_SAND;
	public static final DeferredItem<Item> TERRARIA_COPPER_ORE;
	public static final DeferredItem<Item> TERRARIA_COPPER_INGOT;
	public static final DeferredItem<Item> COPPER_BOARDSWORD;
	public static final DeferredItem<Item> TERRARIA_ICE;
	public static final DeferredItem<Item> TERRARIA_SNOW;
	public static final DeferredItem<Item> TERRARIA_MUD;
	public static final DeferredItem<Item> TERRARIA_SANDSTONE;
	public static final DeferredItem<Item> TERRARIA_HARDENED_STONE;
	public static final DeferredItem<Item> TERRARIA_TIN_ORE;
	public static final DeferredItem<Item> TERRARIA_IRON_ORE;
	public static final DeferredItem<Item> TERRARIA_LEAD_ORE;
	public static final DeferredItem<Item> CRYSTAL_CRUSHER;
	public static final DeferredItem<Item> DEV_ROCK;
	public static final DeferredItem<Item> TERRARIA_SILVER_ORE;
	public static final DeferredItem<Item> TERRARIA_TUNGSTEN_ORE;
	public static final DeferredItem<Item> TERRARIA_GOLD_ORE;
	public static final DeferredItem<Item> TERRARIA_PLATINUM_ORE;
	public static final DeferredItem<Item> TERRARIA_HELLSTONE;
	public static final DeferredItem<Item> TERRARIA_CRIMTANE_ORE;
	public static final DeferredItem<Item> TERRARIA_DEMONITE_ORE;
	public static final DeferredItem<Item> TERRARIA_TIN_INGOT;
	public static final DeferredItem<Item> TERRARIA_SILVER_INGOT;
	public static final DeferredItem<Item> TERRARIA_TUNGSTEN_INGOT;
	public static final DeferredItem<Item> TERRARIA_IRON_INGOT;
	public static final DeferredItem<Item> TERRARIA_LEAD_INGOT;
	public static final DeferredItem<Item> TERRARIA_GOLD_INGOT;
	public static final DeferredItem<Item> TERRARIA_PLATINUM_INGOT;
	public static final DeferredItem<Item> TERRARIA_DEMONITE_INGOT;
	public static final DeferredItem<Item> TERRARIA_CRIMTANE_INGOT;
	public static final DeferredItem<Item> TERRARIA_HELLSTONE_BAR;
	public static final DeferredItem<Item> VOLCANO;
	public static final DeferredItem<Item> WORK_BENCH;
	public static final DeferredItem<Item> ANVIL;
	public static final DeferredItem<Item> TERRARIA_FURNACE;
	public static final DeferredItem<Item> TERRARIA_CLAY;
	public static final DeferredItem<Item> TERRARIA_ASH;
	public static final DeferredItem<Item> ARK_OF_THE_COSMOS;
	public static final DeferredItem<Item> LIFE_CRYSTAL_ITEM;
	public static final DeferredItem<Item> WINDS_FLEDGLING;
	public static final DeferredItem<Item> WINGSOF_REBIRTH;
	public static final DeferredItem<Item> SLIME_AI_SPAWN_EGG;
	public static final DeferredItem<Item> DEMON_EYE_AI_SPAWN_EGG;
	public static final DeferredItem<Item> WORM_HEAD_AI_SPAWN_EGG;
	static {
		COPPER_SHORTSWORD = register("copper_shortsword", CopperShortswordItem::new);
		GREATSWORD_OF_JUDGEMENT = register("greatsword_of_judgement", GreatswordOfJudgementItem::new);
		COPPER_PICKAXE = register("copper_pickaxe", CopperPickaxeItem::new);
		COPPER_AXE = register("copper_axe", CopperAxeItem::new);
		TERRARIA_DIRT = block(CalamityModBlocks.TERRARIA_DIRT, new Item.Properties().stacksTo(99));
		TERRARIA_STONE = block(CalamityModBlocks.TERRARIA_STONE, new Item.Properties().stacksTo(99));
		TERRARIA_WOOD = block(CalamityModBlocks.TERRARIA_WOOD, new Item.Properties().stacksTo(99));
		GEL = register("gel", GelItem::new);
		COIN_COPPER = register("coin_copper", CoinCopperItem::new);
		COIN_SILVER = register("coin_silver", CoinSilverItem::new);
		COIN_GOLD = register("coin_gold", CoinGoldItem::new);
		COIN_PLATINUM = register("coin_platinum", CoinPlatinumItem::new);
		TERRARIA_SAND = block(CalamityModBlocks.TERRARIA_SAND, new Item.Properties().stacksTo(99));
		CALAMITY_SULPHUROUS_SAND = block(CalamityModBlocks.CALAMITY_SULPHUROUS_SAND, new Item.Properties().stacksTo(99));
		TERRARIA_COPPER_ORE = block(CalamityModBlocks.TERRARIA_COPPER_ORE, new Item.Properties().stacksTo(99));
		TERRARIA_COPPER_INGOT = register("terraria_copper_ingot", TerrariaCopperIngotItem::new);
		COPPER_BOARDSWORD = register("copper_boardsword", CopperBoardswordItem::new);
		TERRARIA_ICE = block(CalamityModBlocks.TERRARIA_ICE, new Item.Properties().stacksTo(99));
		TERRARIA_SNOW = block(CalamityModBlocks.TERRARIA_SNOW, new Item.Properties().stacksTo(99));
		TERRARIA_MUD = block(CalamityModBlocks.TERRARIA_MUD, new Item.Properties().stacksTo(99));
		TERRARIA_SANDSTONE = block(CalamityModBlocks.TERRARIA_SANDSTONE, new Item.Properties().stacksTo(99));
		TERRARIA_HARDENED_STONE = block(CalamityModBlocks.TERRARIA_HARDENED_STONE, new Item.Properties().stacksTo(99));
		TERRARIA_TIN_ORE = block(CalamityModBlocks.TERRARIA_TIN_ORE, new Item.Properties().stacksTo(99));
		TERRARIA_IRON_ORE = block(CalamityModBlocks.TERRARIA_IRON_ORE, new Item.Properties().stacksTo(99));
		TERRARIA_LEAD_ORE = block(CalamityModBlocks.TERRARIA_LEAD_ORE, new Item.Properties().stacksTo(99));
		CRYSTAL_CRUSHER = register("crystal_crusher", CrystalCrusherItem::new);
		DEV_ROCK = register("dev_rock", DevRockItem::new);
		TERRARIA_SILVER_ORE = block(CalamityModBlocks.TERRARIA_SILVER_ORE, new Item.Properties().stacksTo(99));
		TERRARIA_TUNGSTEN_ORE = block(CalamityModBlocks.TERRARIA_TUNGSTEN_ORE, new Item.Properties().stacksTo(99));
		TERRARIA_GOLD_ORE = block(CalamityModBlocks.TERRARIA_GOLD_ORE, new Item.Properties().stacksTo(99));
		TERRARIA_PLATINUM_ORE = block(CalamityModBlocks.TERRARIA_PLATINUM_ORE, new Item.Properties().stacksTo(99));
		TERRARIA_HELLSTONE = block(CalamityModBlocks.TERRARIA_HELLSTONE, new Item.Properties().stacksTo(99).fireResistant());
		TERRARIA_CRIMTANE_ORE = block(CalamityModBlocks.TERRARIA_CRIMTANE_ORE, new Item.Properties().stacksTo(99));
		TERRARIA_DEMONITE_ORE = block(CalamityModBlocks.TERRARIA_DEMONITE_ORE, new Item.Properties().stacksTo(99));
		TERRARIA_TIN_INGOT = register("terraria_tin_ingot", TerrariaTinIngotItem::new);
		TERRARIA_SILVER_INGOT = register("terraria_silver_ingot", TerrariaSilverIngotItem::new);
		TERRARIA_TUNGSTEN_INGOT = register("terraria_tungsten_ingot", TerrariaTungstenIngotItem::new);
		TERRARIA_IRON_INGOT = register("terraria_iron_ingot", TerrariaIronIngotItem::new);
		TERRARIA_LEAD_INGOT = register("terraria_lead_ingot", TerrariaLeadIngotItem::new);
		TERRARIA_GOLD_INGOT = register("terraria_gold_ingot", TerrariaGoldIngotItem::new);
		TERRARIA_PLATINUM_INGOT = register("terraria_platinum_ingot", TerrariaPlatinumIngotItem::new);
		TERRARIA_DEMONITE_INGOT = register("terraria_demonite_ingot", TerrariaDemoniteIngotItem::new);
		TERRARIA_CRIMTANE_INGOT = register("terraria_crimtane_ingot", TerrariaCrimtaneIngotItem::new);
		TERRARIA_HELLSTONE_BAR = register("terraria_hellstone_bar", TerrariaHellstoneBarItem::new);
		VOLCANO = register("volcano", VolcanoItem::new);
		WORK_BENCH = block(CalamityModBlocks.WORK_BENCH, new Item.Properties().stacksTo(99));
		ANVIL = block(CalamityModBlocks.ANVIL, new Item.Properties().stacksTo(99));
		TERRARIA_FURNACE = block(CalamityModBlocks.TERRARIA_FURNACE, new Item.Properties().stacksTo(99));
		TERRARIA_CLAY = block(CalamityModBlocks.TERRARIA_CLAY, new Item.Properties().stacksTo(99));
		TERRARIA_ASH = block(CalamityModBlocks.TERRARIA_ASH, new Item.Properties().stacksTo(99));
		ARK_OF_THE_COSMOS = register("ark_of_the_cosmos", ArkOfTheCosmosItem::new);
		LIFE_CRYSTAL_ITEM = register("life_crystal_item", LifeCrystalItemItem::new);
		WINDS_FLEDGLING = register("winds_fledgling", WindsFledglingItem::new);
		WINGSOF_REBIRTH = register("wingsof_rebirth", WingsofRebirthItem::new);
		SLIME_AI_SPAWN_EGG = register("slime_ai_spawn_egg", properties -> new SpawnEggItem(properties.spawnEgg(CalamityModEntities.SLIME_AI.get())));
		DEMON_EYE_AI_SPAWN_EGG = register("demon_eye_ai_spawn_egg", properties -> new SpawnEggItem(properties.spawnEgg(CalamityModEntities.DEMON_EYE_AI.get())));
		WORM_HEAD_AI_SPAWN_EGG = register("worm_head_ai_spawn_egg", properties -> new SpawnEggItem(properties.spawnEgg(CalamityModEntities.WORM_HEAD_AI.get())));
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, Item.Properties::new);
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), () -> properties);
	}
}