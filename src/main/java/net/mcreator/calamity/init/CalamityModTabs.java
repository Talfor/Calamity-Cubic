/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.calamity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.calamity.CalamityMod;

@EventBusSubscriber
public class CalamityModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CalamityMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TERRARIA_TAB = REGISTRY.register("terraria_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.calamity.terraria_tab")).icon(() -> new ItemStack(CalamityModItems.COPPER_SHORTSWORD.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CalamityModItems.COIN_COPPER.get());
				tabData.accept(CalamityModItems.COIN_SILVER.get());
				tabData.accept(CalamityModItems.COIN_GOLD.get());
				tabData.accept(CalamityModItems.COIN_PLATINUM.get());
				tabData.accept(CalamityModItems.COPPER_SHORTSWORD.get());
				tabData.accept(CalamityModItems.COPPER_BOARDSWORD.get());
				tabData.accept(CalamityModItems.COPPER_PICKAXE.get());
				tabData.accept(CalamityModItems.COPPER_AXE.get());
				tabData.accept(CalamityModItems.VOLCANO.get());
				tabData.accept(CalamityModBlocks.WORK_BENCH.get().asItem());
				tabData.accept(CalamityModBlocks.ANVIL.get().asItem());
				tabData.accept(CalamityModBlocks.TERRARIA_FURNACE.get().asItem());
				tabData.accept(CalamityModBlocks.TERRARIA_DIRT.get().asItem());
				tabData.accept(CalamityModBlocks.TERRARIA_STONE.get().asItem());
				tabData.accept(CalamityModBlocks.TERRARIA_SAND.get().asItem());
				tabData.accept(CalamityModBlocks.CALAMITY_SULPHUROUS_SAND.get().asItem());
				tabData.accept(CalamityModBlocks.TERRARIA_ICE.get().asItem());
				tabData.accept(CalamityModBlocks.TERRARIA_SNOW.get().asItem());
				tabData.accept(CalamityModBlocks.TERRARIA_MUD.get().asItem());
				tabData.accept(CalamityModBlocks.TERRARIA_CLAY.get().asItem());
				tabData.accept(CalamityModBlocks.TERRARIA_ASH.get().asItem());
				tabData.accept(CalamityModBlocks.TERRARIA_SANDSTONE.get().asItem());
				tabData.accept(CalamityModBlocks.TERRARIA_HARDENED_STONE.get().asItem());
				tabData.accept(CalamityModBlocks.TERRARIA_WOOD.get().asItem());
				tabData.accept(CalamityModBlocks.TERRARIA_COPPER_ORE.get().asItem());
				tabData.accept(CalamityModItems.TERRARIA_COPPER_INGOT.get());
				tabData.accept(CalamityModBlocks.TERRARIA_TIN_ORE.get().asItem());
				tabData.accept(CalamityModItems.TERRARIA_TIN_INGOT.get());
				tabData.accept(CalamityModBlocks.TERRARIA_IRON_ORE.get().asItem());
				tabData.accept(CalamityModItems.TERRARIA_IRON_INGOT.get());
				tabData.accept(CalamityModBlocks.TERRARIA_LEAD_ORE.get().asItem());
				tabData.accept(CalamityModItems.TERRARIA_LEAD_INGOT.get());
				tabData.accept(CalamityModBlocks.TERRARIA_SILVER_ORE.get().asItem());
				tabData.accept(CalamityModItems.TERRARIA_SILVER_INGOT.get());
				tabData.accept(CalamityModBlocks.TERRARIA_TUNGSTEN_ORE.get().asItem());
				tabData.accept(CalamityModItems.TERRARIA_TUNGSTEN_INGOT.get());
				tabData.accept(CalamityModBlocks.TERRARIA_GOLD_ORE.get().asItem());
				tabData.accept(CalamityModItems.TERRARIA_GOLD_INGOT.get());
				tabData.accept(CalamityModBlocks.TERRARIA_PLATINUM_ORE.get().asItem());
				tabData.accept(CalamityModItems.TERRARIA_PLATINUM_INGOT.get());
				tabData.accept(CalamityModBlocks.TERRARIA_CRIMTANE_ORE.get().asItem());
				tabData.accept(CalamityModItems.TERRARIA_CRIMTANE_INGOT.get());
				tabData.accept(CalamityModBlocks.TERRARIA_DEMONITE_ORE.get().asItem());
				tabData.accept(CalamityModItems.TERRARIA_DEMONITE_INGOT.get());
				tabData.accept(CalamityModBlocks.TERRARIA_HELLSTONE.get().asItem());
				tabData.accept(CalamityModItems.TERRARIA_HELLSTONE_BAR.get());
				tabData.accept(CalamityModItems.GEL.get());
				tabData.accept(CalamityModItems.LIFE_CRYSTAL_ITEM.get());
				tabData.accept(CalamityModItems.WINDS_FLEDGLING.get());
				tabData.accept(CalamityModItems.WINGSOF_REBIRTH.get());
				tabData.accept(CalamityModItems.SLIME_AI_SPAWN_EGG.get());
				tabData.accept(CalamityModItems.DEMON_EYE_AI_SPAWN_EGG.get());
				tabData.accept(CalamityModItems.WORM_HEAD_AI_SPAWN_EGG.get());
			}).withSearchBar().build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CALAMITY_TAB = REGISTRY.register("calamity_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.calamity.calamity_tab")).icon(() -> new ItemStack(CalamityModItems.GREATSWORD_OF_JUDGEMENT.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CalamityModItems.GREATSWORD_OF_JUDGEMENT.get());
				tabData.accept(CalamityModItems.ARK_OF_THE_COSMOS.get());
				tabData.accept(CalamityModItems.CRYSTAL_CRUSHER.get());
			}).withSearchBar().withTabsBefore(TERRARIA_TAB.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
			if (tabData.hasPermissions()) {
				tabData.accept(CalamityModItems.DEV_ROCK.get());
			}
		}
	}
}