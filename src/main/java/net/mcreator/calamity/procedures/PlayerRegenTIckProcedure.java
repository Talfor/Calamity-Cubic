package net.mcreator.calamity.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.init.CalamityModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerRegenTIckProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)
						* ((entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(CalamityModAttributes.LIFE_REGEN) ? _livingEntity3.getAttribute(CalamityModAttributes.LIFE_REGEN).getBaseValue() : 0) / 1000)));
		}
	}
}