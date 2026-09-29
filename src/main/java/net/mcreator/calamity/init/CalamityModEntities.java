/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.calamity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.calamity.entity.WormHeadAIEntity;
import net.mcreator.calamity.entity.SlimeAIEntity;
import net.mcreator.calamity.entity.DemonEyeAIEntity;
import net.mcreator.calamity.CalamityMod;

@EventBusSubscriber
public class CalamityModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, CalamityMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<SlimeAIEntity>> SLIME_AI = register("slime_ai",
			EntityType.Builder.<SlimeAIEntity>of(SlimeAIEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.notInPeaceful().sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<DemonEyeAIEntity>> DEMON_EYE_AI = register("demon_eye_ai",
			EntityType.Builder.<DemonEyeAIEntity>of(DemonEyeAIEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.notInPeaceful().sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<WormHeadAIEntity>> WORM_HEAD_AI = register("worm_head_ai",
			EntityType.Builder.<WormHeadAIEntity>of(WormHeadAIEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.notInPeaceful().sized(1f, 1f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(CalamityMod.MODID, registryname))));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		SlimeAIEntity.init(event);
		DemonEyeAIEntity.init(event);
		WormHeadAIEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SLIME_AI.get(), SlimeAIEntity.createAttributes().build());
		event.put(DEMON_EYE_AI.get(), DemonEyeAIEntity.createAttributes().build());
		event.put(WORM_HEAD_AI.get(), WormHeadAIEntity.createAttributes().build());
	}
}