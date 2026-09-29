/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.calamity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.calamity.world.inventory.DifficultySelectionMenu;
import net.mcreator.calamity.world.inventory.CraftingMenuMenu;
import net.mcreator.calamity.world.inventory.ConfigMenu;
import net.mcreator.calamity.world.inventory.AccessoryGUIMenu;
import net.mcreator.calamity.network.MenuStateUpdateMessage;
import net.mcreator.calamity.CalamityMod;

import java.util.Map;

public class CalamityModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, CalamityMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<DifficultySelectionMenu>> DIFFICULTY_SELECTION = REGISTRY.register("difficulty_selection", () -> IMenuTypeExtension.create(DifficultySelectionMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AccessoryGUIMenu>> ACCESSORY_GUI = REGISTRY.register("accessory_gui", () -> IMenuTypeExtension.create(AccessoryGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CraftingMenuMenu>> CRAFTING_MENU = REGISTRY.register("crafting_menu", () -> IMenuTypeExtension.create(CraftingMenuMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ConfigMenu>> CONFIG = REGISTRY.register("config", () -> IMenuTypeExtension.create(ConfigMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide()) {
				if (Minecraft.getInstance().screen instanceof CalamityModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				ClientPacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}