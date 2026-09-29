package net.mcreator.calamity.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.calamity.world.inventory.DifficultySelectionMenu;
import net.mcreator.calamity.init.CalamityModGameRules;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class LoadWorldProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().get(CalamityModGameRules.INTRODUCTION_COMPLETED.get()))) {
			if (world instanceof ServerLevel _serverLevel)
				_serverLevel.getGameRules().set(CalamityModGameRules.INTRODUCTION_COMPLETED.get(), true, world.getServer());
			if (world instanceof ServerLevel _serverLevel)
				_serverLevel.getGameRules().set(GameRules.KEEP_INVENTORY, true, world.getServer());
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("DifficultySelection");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new DifficultySelectionMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			if (world instanceof ServerLevel _serverLevel)
				_serverLevel.getGameRules().set(GameRules.NATURAL_HEALTH_REGENERATION, false, world.getServer());
			if (world instanceof ServerLevel _serverLevel)
				_serverLevel.getGameRules().set(GameRules.SPAWN_PHANTOMS, false, world.getServer());
			if (world instanceof ServerLevel _serverLevel)
				_serverLevel.getGameRules().set(GameRules.LIMITED_CRAFTING, true, world.getServer());
			if (world instanceof ServerLevel _serverLevel)
				_serverLevel.getGameRules().set(GameRules.SPAWN_PATROLS, false, world.getServer());
			if (world instanceof ServerLevel _serverLevel)
				_serverLevel.getGameRules().set(GameRules.SPAWN_WANDERING_TRADERS, false, world.getServer());
			if (world instanceof ServerLevel _serverLevel)
				_serverLevel.getGameRules().set(GameRules.SPAWN_WARDENS, false, world.getServer());
		}
	}
}