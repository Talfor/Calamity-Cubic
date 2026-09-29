/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.calamity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.calamity.CalamityMod;

public class CalamityModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, CalamityMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> RAGE_ACTIVATE = REGISTRY.register("rage_activate", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("calamity", "rage_activate")));
	public static final DeferredHolder<SoundEvent, SoundEvent> RAGE_FULL = REGISTRY.register("rage_full", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("calamity", "rage_full")));
	public static final DeferredHolder<SoundEvent, SoundEvent> RAGE_END = REGISTRY.register("rage_end", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("calamity", "rage_end")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ADRENALINE_ACTIVATE = REGISTRY.register("adrenaline_activate", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("calamity", "adrenaline_activate")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ADRENALINE_LOSS = REGISTRY.register("adrenaline_loss", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("calamity", "adrenaline_loss")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ADRENALINE_FULL = REGISTRY.register("adrenaline_full", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("calamity", "adrenaline_full")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DIFFICULTYSET_EXPERT = REGISTRY.register("difficultyset_expert", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("calamity", "difficultyset_expert")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DIFFICULTYSET_REVENGEANCE = REGISTRY.register("difficultyset_revengeance",
			() -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("calamity", "difficultyset_revengeance")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DIFFICULTYSET_MASTER = REGISTRY.register("difficultyset_master", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("calamity", "difficultyset_master")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DIFFICULTYSET_DEATH = REGISTRY.register("difficultyset_death", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("calamity", "difficultyset_death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DIFFICULTYSET_LEGENDARY = REGISTRY.register("difficultyset_legendary", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("calamity", "difficultyset_legendary")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DIFFICULTYSET_MALICE = REGISTRY.register("difficultyset_malice", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("calamity", "difficultyset_malice")));
}