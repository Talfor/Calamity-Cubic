package net.mcreator.calamity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.calamity.network.CalamityModVariables;

public class InitAdrenalineOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CalamityModVariables.PLAYER_VARIABLES).adrenaline >= 105) {
			{
				CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
				_vars.adrenalineactive = true;
				_vars.markSyncDirty();
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("calamity:adrenaline_activate")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("calamity:adrenaline_activate")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(Identifier.parse("calamity:adrenaline"), 2.5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
				if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
				}
			}
			{
				CalamityModVariables.PlayerVariables _vars = entity.getData(CalamityModVariables.PLAYER_VARIABLES);
				_vars.adrenaline = 100;
				_vars.markSyncDirty();
			}
		}
	}
}