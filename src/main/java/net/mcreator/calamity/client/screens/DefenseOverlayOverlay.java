package net.mcreator.calamity.client.screens;

import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Mth;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.calamity.procedures.ReturnDifficultySpriteProcedure;
import net.mcreator.calamity.procedures.ReturnDefenseAttributeProcedure;

@EventBusSubscriber(Dist.CLIENT)
public class DefenseOverlayOverlay {
	private static final Identifier SPRITE_0 = Identifier.parse("calamity:textures/screens/defense_master_png.png");

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		if (event.getScreen() instanceof InventoryScreen) {
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

				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, 0, h - 20, 0, Mth.clamp((int) ReturnDifficultySpriteProcedure.execute(world) * 20, 0, 40), 23, 20, 23, 60);

				event.getGuiGraphics().text(Minecraft.getInstance().font,

						ReturnDefenseAttributeProcedure.execute(entity), 6, h - 14, -16777216, false);
				event.getGuiGraphics().text(Minecraft.getInstance().font,

						ReturnDefenseAttributeProcedure.execute(entity), 6, h - 16, -16777216, false);
				event.getGuiGraphics().text(Minecraft.getInstance().font,

						ReturnDefenseAttributeProcedure.execute(entity), 5, h - 15, -16777216, false);
				event.getGuiGraphics().text(Minecraft.getInstance().font,

						ReturnDefenseAttributeProcedure.execute(entity), 7, h - 15, -16777216, false);
				event.getGuiGraphics().text(Minecraft.getInstance().font,

						ReturnDefenseAttributeProcedure.execute(entity), 6, h - 15, -1, false);
			}
		}
	}
}