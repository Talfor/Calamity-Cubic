/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.calamity.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.calamity.network.OpenCraftingMenuMessage;
import net.mcreator.calamity.network.InitRageMessage;
import net.mcreator.calamity.network.InitAdrenalineMessage;
import net.mcreator.calamity.network.FlyButtonMessage;
import net.mcreator.calamity.network.AccessoryKeyBindingMessage;

@EventBusSubscriber(Dist.CLIENT)
public class CalamityModKeyMappings {
	public static final KeyMapping INIT_RAGE = new KeyMapping("key.calamity.init_rage", GLFW.GLFW_KEY_X, KeyMapping.Category.GAMEPLAY) {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new InitRageMessage(0, 0));
				InitRageMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping INIT_ADRENALINE = new KeyMapping("key.calamity.init_adrenaline", GLFW.GLFW_KEY_Z, KeyMapping.Category.GAMEPLAY) {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new InitAdrenalineMessage(0, 0));
				InitAdrenalineMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ACCESSORY_KEY_BINDING = new KeyMapping("key.calamity.accessory_key_binding", GLFW.GLFW_KEY_C, KeyMapping.Category.INVENTORY) {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ACCESSORY_KEY_BINDING_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ACCESSORY_KEY_BINDING_LASTPRESS);
				ClientPacketDistributor.sendToServer(new AccessoryKeyBindingMessage(1, dt));
				AccessoryKeyBindingMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_CRAFTING_MENU = new KeyMapping("key.calamity.open_crafting_menu", GLFW.GLFW_KEY_V, KeyMapping.Category.INVENTORY) {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new OpenCraftingMenuMessage(0, 0));
				OpenCraftingMenuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FLY_BUTTON = new KeyMapping("key.calamity.fly_button", GLFW.GLFW_KEY_SPACE, KeyMapping.Category.MOVEMENT) {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new FlyButtonMessage(0, 0));
				FlyButtonMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				FLY_BUTTON_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - FLY_BUTTON_LASTPRESS);
				ClientPacketDistributor.sendToServer(new FlyButtonMessage(1, dt));
				FlyButtonMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long ACCESSORY_KEY_BINDING_LASTPRESS = 0;
	private static long FLY_BUTTON_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(INIT_RAGE);
		event.register(INIT_ADRENALINE);
		event.register(ACCESSORY_KEY_BINDING);
		event.register(OPEN_CRAFTING_MENU);
		event.register(FLY_BUTTON);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				INIT_RAGE.consumeClick();
				INIT_ADRENALINE.consumeClick();
				ACCESSORY_KEY_BINDING.consumeClick();
				OPEN_CRAFTING_MENU.consumeClick();
				FLY_BUTTON.consumeClick();
			}
		}
	}
}