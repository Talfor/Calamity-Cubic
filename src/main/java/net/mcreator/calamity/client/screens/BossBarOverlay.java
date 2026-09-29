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

import net.mcreator.calamity.procedures.ReturnHealthTextProcedure;
import net.mcreator.calamity.procedures.ReturnHealthPercentageProcedure;
import net.mcreator.calamity.procedures.ReturnBossTitleProcedure;
import net.mcreator.calamity.procedures.IfLocalNullProcedure;

@EventBusSubscriber(Dist.CLIENT)
public class BossBarOverlay {
	private static final Identifier IMAGE_0 = Identifier.parse("calamity:textures/screens/boss_bar_overline.png");
	private static final Identifier SPRITE_0 = Identifier.parse("calamity:textures/screens/boss_bar.png");

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
		if (IfLocalNullProcedure.execute(world, x, y, z)) {
			event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, w / 2 + -126, 11, 0, 0, 248, 2, 248, 2);

			event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, w / 2 + -126, 14, 0, Mth.clamp((int) ReturnHealthPercentageProcedure.execute(world, x, y, z) * 8, 0, 992), 250, 8, 250, 1000);

			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnBossTitleProcedure.execute(world, x, y, z), w / 2 + -126, 1, -13312, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					ReturnHealthTextProcedure.execute(world, x, y, z), w / 2 + -126, 22, -1, false);
		}
	}
}