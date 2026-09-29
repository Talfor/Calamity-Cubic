package net.mcreator.calamity.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.calamity.init.CalamityModGameRules;
import net.mcreator.calamity.init.CalamityModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerTakesDamageProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getAmount());
		}
	}

	public static double execute(LevelAccessor world, Entity entity, double amount) {
		return execute(null, world, entity, amount);
	}

	private static double execute(@Nullable Event event, LevelAccessor world, Entity entity, double amount) {
		if (entity == null)
			return 0;
		double finalamount = 0;
		if ((world instanceof ServerLevel _serverLevelGR0 ? _serverLevelGR0.getGameRules().get(CalamityModGameRules.DIFFICULTY_CALAMITY.get()) : 0) > 2) {
			finalamount = amount
					- (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(CalamityModAttributes.DEFENSE_TERRARIA) ? _livingEntity1.getAttribute(CalamityModAttributes.DEFENSE_TERRARIA).getBaseValue() : 0);
		} else if ((world instanceof ServerLevel _serverLevelGR2 ? _serverLevelGR2.getGameRules().get(CalamityModGameRules.DIFFICULTY_CALAMITY.get()) : 0) > 0) {
			finalamount = 0.75 * (amount
					- (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(CalamityModAttributes.DEFENSE_TERRARIA) ? _livingEntity3.getAttribute(CalamityModAttributes.DEFENSE_TERRARIA).getBaseValue() : 0));
		} else {
			finalamount = 0.5 * (amount
					- (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(CalamityModAttributes.DEFENSE_TERRARIA) ? _livingEntity4.getAttribute(CalamityModAttributes.DEFENSE_TERRARIA).getBaseValue() : 0));
		}
		return finalamount;
	}
}