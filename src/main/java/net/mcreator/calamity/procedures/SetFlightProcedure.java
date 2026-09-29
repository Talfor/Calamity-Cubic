package net.mcreator.calamity.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.calamity.init.CalamityModItems;
import net.mcreator.calamity.init.CalamityModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SetFlightProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static boolean execute(Entity entity) {
		return execute(null, entity);
	}

	private static boolean execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS))
			_livingEntity0.getAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS).setBaseValue(0);
		if (GetIfAccessoryExistsProcedure.execute(entity, new ItemStack(CalamityModItems.WINDS_FLEDGLING.get()))) {
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS))
				_livingEntity1.getAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS).setBaseValue(9);
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(CalamityModAttributes.VERTICAL_BOOST))
				_livingEntity2.getAttribute(CalamityModAttributes.VERTICAL_BOOST).setBaseValue(15);
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(CalamityModAttributes.HORIZONTAL_BOOST))
				_livingEntity3.getAttribute(CalamityModAttributes.HORIZONTAL_BOOST).setBaseValue(31);
			return true;
		}
		if (GetIfAccessoryExistsProcedure.execute(entity, new ItemStack(CalamityModItems.WINGSOF_REBIRTH.get()))) {
			if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS))
				_livingEntity4.getAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS).setBaseValue(120);
			if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(CalamityModAttributes.VERTICAL_BOOST))
				_livingEntity5.getAttribute(CalamityModAttributes.VERTICAL_BOOST).setBaseValue(30);
			if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(CalamityModAttributes.HORIZONTAL_BOOST))
				_livingEntity6.getAttribute(CalamityModAttributes.HORIZONTAL_BOOST).setBaseValue(60);
			return true;
		}
		return true;
	}
}