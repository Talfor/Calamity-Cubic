/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.calamity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.calamity.CalamityMod;

import java.util.stream.Collectors;
import java.util.List;

@EventBusSubscriber
public class CalamityModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, CalamityMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> HAS_JOINED_WORLD = REGISTRY.register("has_joined_world", () -> new RangedAttribute("attribute.calamity.has_joined_world", 0d, 0d, 1d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> CRITICAL_STRIKE_CHANCE = REGISTRY.register("critical_strike_chance", () -> new RangedAttribute("attribute.calamity.critical_strike_chance", 0d, 0d, 1000d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> LIFE_REGEN = REGISTRY.register("life_regen", () -> new RangedAttribute("attribute.calamity.life_regen", 1d, 0d, 1000d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> DEFENSE_TERRARIA = REGISTRY.register("defense_terraria", () -> new RangedAttribute("attribute.calamity.defense_terraria", 0d, 0d, 10000d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> FLIGHT_TICKS = REGISTRY.register("flight_ticks", () -> new RangedAttribute("attribute.calamity.flight_ticks", 0d, -21d, 1200d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> MAX_FLIGHT_TICKS = REGISTRY.register("max_flight_ticks", () -> new RangedAttribute("attribute.calamity.max_flight_ticks", 0d, -21d, 1200d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> ACCESSORY_SLOT_COUNT = REGISTRY.register("accessory_slot_count", () -> new RangedAttribute("attribute.calamity.accessory_slot_count", 5d, 1d, 9d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> HORIZONTAL_BOOST = REGISTRY.register("horizontal_boost", () -> new RangedAttribute("attribute.calamity.horizontal_boost", 0d, 0d, 100000d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> VERTICAL_BOOST = REGISTRY.register("vertical_boost", () -> new RangedAttribute("attribute.calamity.vertical_boost", 0d, 0d, 100000d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> WORM_AIID = REGISTRY.register("worm_aiid", () -> new RangedAttribute("attribute.calamity.worm_aiid", -1d, -1d, 1000000000d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> WORM_AI_TAG = REGISTRY.register("worm_ai_tag", () -> new RangedAttribute("attribute.calamity.worm_ai_tag", -1d, -1d, 1000000000d).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, HAS_JOINED_WORLD);
		event.add(EntityType.PLAYER, CRITICAL_STRIKE_CHANCE);
		event.add(EntityType.PLAYER, LIFE_REGEN);
		event.add(EntityType.PLAYER, DEFENSE_TERRARIA);
		event.add(EntityType.PLAYER, FLIGHT_TICKS);
		event.add(EntityType.PLAYER, MAX_FLIGHT_TICKS);
		event.add(EntityType.PLAYER, ACCESSORY_SLOT_COUNT);
		event.add(EntityType.PLAYER, HORIZONTAL_BOOST);
		event.add(EntityType.PLAYER, VERTICAL_BOOST);
		List.of(CalamityModEntities.WORM_BODY_AI.get()).stream().filter(DefaultAttributes::hasSupplier).map(entityType -> (EntityType<? extends LivingEntity>) entityType).collect(Collectors.toList()).forEach(entity -> event.add(entity, WORM_AIID));
		List.of(CalamityModEntities.WORM_BODY_AI.get(), CalamityModEntities.WORM_HEAD_AI.get()).stream().filter(DefaultAttributes::hasSupplier).map(entityType -> (EntityType<? extends LivingEntity>) entityType).collect(Collectors.toList())
				.forEach(entity -> event.add(entity, WORM_AI_TAG));
	}
}