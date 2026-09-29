package net.mcreator.calamity.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.calamity.network.CalamityModVariables;
import net.mcreator.calamity.init.CalamityModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FlyButtonTickProcedure {
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
		if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).flybuttonactive) {
			if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(CalamityModAttributes.FLIGHT_TICKS) ? _livingEntity0.getAttribute(CalamityModAttributes.FLIGHT_TICKS).getBaseValue() : 0) > 0) {
				entity.setNoGravity(true);
				if (entity.getDeltaMovement()
						.y() < (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(CalamityModAttributes.VERTICAL_BOOST) ? _livingEntity3.getAttribute(CalamityModAttributes.VERTICAL_BOOST).getBaseValue() : 0)
								/ 100) {
					entity.push(0, 0.05, 0);
				}
				if ((entity.getDeltaMovement().x() + entity.getDeltaMovement().z())
						/ 2 < (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(CalamityModAttributes.VERTICAL_BOOST) ? _livingEntity7.getAttribute(CalamityModAttributes.VERTICAL_BOOST).getBaseValue() : 0)
								/ 100) {
					entity.push((entity.getDeltaMovement().x() / 10), 0, (entity.getDeltaMovement().z() / 10));
				}
				if (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(CalamityModAttributes.FLIGHT_TICKS))
					_livingEntity12.getAttribute(CalamityModAttributes.FLIGHT_TICKS).setBaseValue(
							((entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(CalamityModAttributes.FLIGHT_TICKS) ? _livingEntity11.getAttribute(CalamityModAttributes.FLIGHT_TICKS).getBaseValue() : 0)
									- 1));
			} else {
				entity.setNoGravity(false);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 2, 0, false, false));
			}
		} else {
			entity.setNoGravity(false);
		}
		if (entity.onGround()) {
			if (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(CalamityModAttributes.FLIGHT_TICKS))
				_livingEntity18.getAttribute(CalamityModAttributes.FLIGHT_TICKS)
						.setBaseValue((entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS)
								? _livingEntity17.getAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS).getBaseValue()
								: 0));
		}
		if ((entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS) ? _livingEntity19.getAttribute(CalamityModAttributes.MAX_FLIGHT_TICKS).getBaseValue() : 0) != 0) {
			if (entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.SAFE_FALL_DISTANCE))
				_livingEntity20.getAttribute(Attributes.SAFE_FALL_DISTANCE).setBaseValue(10000);
		} else {
			if (entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.SAFE_FALL_DISTANCE))
				_livingEntity21.getAttribute(Attributes.SAFE_FALL_DISTANCE).setBaseValue(3);
		}
	}
}