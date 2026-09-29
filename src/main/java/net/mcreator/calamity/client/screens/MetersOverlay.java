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

import net.mcreator.calamity.procedures.ReturnPlayerRageProcedure;
import net.mcreator.calamity.procedures.ReturnPlayerAdrenalineProcedure;
import net.mcreator.calamity.procedures.DisplayMetersProcedure;

@EventBusSubscriber(Dist.CLIENT)
public class MetersOverlay {
	private static final Identifier SPRITE_0 = Identifier.parse("calamity:textures/screens/adrenaline_meter.png");
	private static final Identifier SPRITE_1 = Identifier.parse("calamity:textures/screens/rage_meter.png");

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
		if (DisplayMetersProcedure.execute(world)) {

			event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, w - 77, h - 55, 0, Mth.clamp((int) ReturnPlayerAdrenalineProcedure.execute(entity) * 34, 0, 1666), 77, 34, 77, 1700);

			event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, SPRITE_1, w - 72, h - 25, 0, Mth.clamp((int) ReturnPlayerRageProcedure.execute(entity) * 18, 0, 882), 69, 18, 69, 900);

		}
	}
}