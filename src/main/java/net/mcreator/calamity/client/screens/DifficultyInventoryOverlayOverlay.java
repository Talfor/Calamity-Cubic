package net.mcreator.calamity.client.screens;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.Minecraft;

import net.mcreator.calamity.procedures.*;

@EventBusSubscriber(Dist.CLIENT)
public class DifficultyInventoryOverlayOverlay {
	private static final Identifier IMAGE_0 = Identifier.parse("calamity:textures/screens/normal_indicator_png.png");
	private static final Identifier IMAGE_1 = Identifier.parse("calamity:textures/screens/expert_indicator_png.png");
	private static final Identifier IMAGE_2 = Identifier.parse("calamity:textures/screens/master_indicator_png.png");
	private static final Identifier IMAGE_3 = Identifier.parse("calamity:textures/screens/legendary_indicator_png.png");
	private static final Identifier IMAGE_4 = Identifier.parse("calamity:textures/screens/revengeance_indicator_png.png");
	private static final Identifier IMAGE_5 = Identifier.parse("calamity:textures/screens/death_indicator_png.png");
	private static final Identifier IMAGE_6 = Identifier.parse("calamity:textures/screens/malice_indicator_png.png");

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
			if (ReturnIfDifficulty0Procedure.execute(world)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, 0, 0, 0, 0, 39, 39, 39, 39);
			}
			if (ReturnIfDifficulty1Procedure.execute(world)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, 0, 0, 0, 0, 39, 39, 39, 39);
			}
			if (ReturnIfDifficulty3Procedure.execute(world)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, 0, 0, 0, 0, 39, 39, 39, 39);
			}
			if (ReturnIfDifficulty5Procedure.execute(world)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, 0, 0, 0, 0, 39, 39, 39, 39);
			}
			if (ReturnIfDifficulty2Procedure.execute(world)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, 0, 0, 0, 0, 39, 39, 39, 39);
			}
			if (ReturnIfDifficulty4Procedure.execute(world)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, 0, 0, 0, 0, 39, 39, 39, 39);
			}
			if (ReturnIfDifficulty6Procedure.execute(world)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, IMAGE_6, 0, 0, 0, 0, 39, 39, 39, 39);
			}
		}
	}
}