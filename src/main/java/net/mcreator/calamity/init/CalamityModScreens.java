/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.calamity.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.calamity.client.gui.DifficultySelectionScreen;
import net.mcreator.calamity.client.gui.CraftingMenuScreen;
import net.mcreator.calamity.client.gui.ConfigScreen;
import net.mcreator.calamity.client.gui.AccessoryGUIScreen;

@EventBusSubscriber(Dist.CLIENT)
public class CalamityModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(CalamityModMenus.DIFFICULTY_SELECTION.get(), DifficultySelectionScreen::new);
		event.register(CalamityModMenus.ACCESSORY_GUI.get(), AccessoryGUIScreen::new);
		event.register(CalamityModMenus.CRAFTING_MENU.get(), CraftingMenuScreen::new);
		event.register(CalamityModMenus.CONFIG.get(), ConfigScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}