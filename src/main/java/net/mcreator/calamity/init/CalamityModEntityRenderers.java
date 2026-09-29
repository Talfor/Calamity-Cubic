/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.calamity.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.calamity.client.renderer.WormHeadAIRenderer;
import net.mcreator.calamity.client.renderer.SlimeAIRenderer;
import net.mcreator.calamity.client.renderer.DemonEyeAIRenderer;

@EventBusSubscriber(Dist.CLIENT)
public class CalamityModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(CalamityModEntities.SLIME_AI.get(), SlimeAIRenderer::new);
		event.registerEntityRenderer(CalamityModEntities.DEMON_EYE_AI.get(), DemonEyeAIRenderer::new);
		event.registerEntityRenderer(CalamityModEntities.WORM_HEAD_AI.get(), WormHeadAIRenderer::new);
	}
}