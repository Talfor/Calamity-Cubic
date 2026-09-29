/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.calamity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.gamerules.GameRuleTypeVisitor;
import net.minecraft.world.level.gamerules.GameRuleType;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.core.registries.Registries;

import net.mcreator.calamity.CalamityMod;

import com.mojang.serialization.Codec;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class CalamityModGameRules {
	public static final DeferredRegister<GameRule<?>> REGISTRY = DeferredRegister.create(Registries.GAME_RULE, CalamityMod.MODID);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> INTRODUCTION_COMPLETED = registerBoolean("introduction_completed", GameRuleCategory.MISC, false);
	public static DeferredHolder<GameRule<?>, GameRule<Integer>> DIFFICULTY_CALAMITY = registerInteger("difficulty_calamity", GameRuleCategory.MISC, 0);

	private static DeferredHolder<GameRule<?>, GameRule<Boolean>> registerBoolean(String registryname, GameRuleCategory category, boolean value) {
		return REGISTRY.register(registryname, () -> new GameRule<>(category, GameRuleType.BOOL, BoolArgumentType.bool(), GameRuleTypeVisitor::visitBoolean, Codec.BOOL, b -> b ? 1 : 0, value, FeatureFlagSet.of()));
	}

	private static DeferredHolder<GameRule<?>, GameRule<Integer>> registerInteger(String registryname, GameRuleCategory category, int value) {
		return REGISTRY.register(registryname, () -> new GameRule<>(category, GameRuleType.INT, IntegerArgumentType.integer(Integer.MIN_VALUE, Integer.MAX_VALUE), GameRuleTypeVisitor::visitInteger,
				Codec.intRange(Integer.MIN_VALUE, Integer.MAX_VALUE), i -> i, value, FeatureFlagSet.of()));
	}
}