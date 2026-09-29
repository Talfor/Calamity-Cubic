package net.mcreator.calamity.client.screens;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Mth;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.Minecraft;

import net.mcreator.calamity.procedures.ReturnIfAppearFlightTicksProcedure;
import net.mcreator.calamity.procedures.ReturnFlightTicksProcedure;

@EventBusSubscriber(Dist.CLIENT)
public class FlightBarOverlayOverlay {
	private static final Identifier SPRITE_0 = Identifier.parse("calamity:textures/screens/flightbar.png");

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			if (ReturnIfAppearFlightTicksProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, w / 2 + -109, h - 36, 0, Mth.clamp((int) ReturnFlightTicksProcedure.execute(entity) * 35, 0, 735), 17, 35, 17, 770);
			}
		}
	}
}