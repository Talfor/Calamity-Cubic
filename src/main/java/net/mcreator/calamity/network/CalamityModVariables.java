package net.mcreator.calamity.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.ValueIOSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.saveddata.SavedDataType;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.ProblemReporter;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.calamity.CalamityMod;

import java.util.function.Supplier;

@EventBusSubscriber
public class CalamityModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, CalamityMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(PlayerVariables::new).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		CalamityMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		CalamityMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@SubscribeEvent
	public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerTickUpdateSyncPlayerVariables(PlayerTickEvent.Post event) {
		if (event.getEntity() instanceof ServerPlayer player && player.getData(PLAYER_VARIABLES)._syncDirty) {
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
			player.getData(PLAYER_VARIABLES)._syncDirty = false;
		}
	}

	@SubscribeEvent
	public static void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
		PlayerVariables clone = new PlayerVariables();
		if (!event.isWasDeath()) {
			clone.rage = original.rage;
			clone.adrenaline = original.adrenaline;
			clone.rageactive = original.rageactive;
			clone.adrenalineactive = original.adrenalineactive;
			clone.heighttemp = original.heighttemp;
			clone.heightcontinue = original.heightcontinue;
			clone.craftingstation_offset = original.craftingstation_offset;
			clone.craftingstation_temp = original.craftingstation_temp;
			clone.accessoryslot_1 = original.accessoryslot_1;
			clone.accessoryslot_2 = original.accessoryslot_2;
			clone.accessoryslot_3 = original.accessoryslot_3;
			clone.accessoryslot_4 = original.accessoryslot_4;
			clone.accessoryslot_5 = original.accessoryslot_5;
			clone.accessoryslot_6 = original.accessoryslot_6;
			clone.accessoryslot_7 = original.accessoryslot_7;
			clone.accessoryslot_8 = original.accessoryslot_8;
			clone.accessoryslot_9 = original.accessoryslot_9;
			clone.flybuttonactive = original.flybuttonactive;
		}
		event.getEntity().setData(PLAYER_VARIABLES, clone);
	}

	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData mapdata = MapVariables.get(player.level());
			SavedData worlddata = WorldVariables.get(player.level());
			if (mapdata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData worlddata = WorldVariables.get(player.level());
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		if (event.getLevel() instanceof ServerLevel level) {
			WorldVariables worldVariables = WorldVariables.get(level);
			if (worldVariables._syncDirty) {
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, worldVariables));
				worldVariables._syncDirty = false;
			}
			MapVariables mapVariables = MapVariables.get(level);
			if (mapVariables._syncDirty) {
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, mapVariables));
				mapVariables._syncDirty = false;
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final SavedDataType<WorldVariables> TYPE = new SavedDataType<>(Identifier.parse("calamity:worldvars"), level -> new WorldVariables(), level -> CompoundTag.CODEC.xmap(tag -> {
			WorldVariables instance = new WorldVariables();
			instance.read(tag, level.registryAccess());
			return instance;
		}, instance -> instance.save(new CompoundTag(), level.registryAccess())));
		boolean _syncDirty = false;

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(WorldVariables.TYPE);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final SavedDataType<MapVariables> TYPE = new SavedDataType<>(Identifier.parse("calamity:mapvars"), level -> new MapVariables(), level -> CompoundTag.CODEC.xmap(tag -> {
			MapVariables instance = new MapVariables();
			instance.read(tag, level.registryAccess());
			return instance;
		}, instance -> instance.save(new CompoundTag(), level.registryAccess())));
		boolean _syncDirty = false;
		public double difficultyreturner = 0;

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			difficultyreturner = nbt.getDoubleOr("difficultyreturner", 0);
		}

		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("difficultyreturner", difficultyreturner);
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAccessor) {
				return serverLevelAccessor.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(MapVariables.TYPE);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(CalamityMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data instanceof MapVariables mapVariables)
				buffer.writeNbt(mapVariables.save(new CompoundTag(), buffer.registryAccess()));
			else if (message.data instanceof WorldVariables worldVariables)
				buffer.writeNbt(worldVariables.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(((MapVariables) message.data).save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(((WorldVariables) message.data).save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements ValueIOSerializable {
		boolean _syncDirty = false;
		public double rage = 0;
		public double adrenaline = 0;
		public boolean rageactive = false;
		public boolean adrenalineactive = false;
		public double heighttemp = 0;
		public boolean heightcontinue = true;
		public double craftingstation_offset = 0;
		public double craftingstation_temp = 0;
		public ItemStack accessoryslot_1 = ItemStack.EMPTY;
		public ItemStack accessoryslot_2 = ItemStack.EMPTY;
		public ItemStack accessoryslot_3 = ItemStack.EMPTY;
		public ItemStack accessoryslot_4 = ItemStack.EMPTY;
		public ItemStack accessoryslot_5 = ItemStack.EMPTY;
		public ItemStack accessoryslot_6 = ItemStack.EMPTY;
		public ItemStack accessoryslot_7 = ItemStack.EMPTY;
		public ItemStack accessoryslot_8 = ItemStack.EMPTY;
		public ItemStack accessoryslot_9 = ItemStack.EMPTY;
		public boolean flybuttonactive = false;

		@Override
		public void serialize(ValueOutput output) {
			output.putDouble("rage", rage);
			output.putDouble("adrenaline", adrenaline);
			output.putBoolean("rageactive", rageactive);
			output.putBoolean("adrenalineactive", adrenalineactive);
			output.putDouble("heighttemp", heighttemp);
			output.putBoolean("heightcontinue", heightcontinue);
			output.putDouble("craftingstation_offset", craftingstation_offset);
			output.putDouble("craftingstation_temp", craftingstation_temp);
			output.store("accessoryslot_1", ItemStack.OPTIONAL_CODEC, accessoryslot_1);
			output.store("accessoryslot_2", ItemStack.OPTIONAL_CODEC, accessoryslot_2);
			output.store("accessoryslot_3", ItemStack.OPTIONAL_CODEC, accessoryslot_3);
			output.store("accessoryslot_4", ItemStack.OPTIONAL_CODEC, accessoryslot_4);
			output.store("accessoryslot_5", ItemStack.OPTIONAL_CODEC, accessoryslot_5);
			output.store("accessoryslot_6", ItemStack.OPTIONAL_CODEC, accessoryslot_6);
			output.store("accessoryslot_7", ItemStack.OPTIONAL_CODEC, accessoryslot_7);
			output.store("accessoryslot_8", ItemStack.OPTIONAL_CODEC, accessoryslot_8);
			output.store("accessoryslot_9", ItemStack.OPTIONAL_CODEC, accessoryslot_9);
			output.putBoolean("flybuttonactive", flybuttonactive);
		}

		@Override
		public void deserialize(ValueInput input) {
			rage = input.getDoubleOr("rage", 0);
			adrenaline = input.getDoubleOr("adrenaline", 0);
			rageactive = input.getBooleanOr("rageactive", false);
			adrenalineactive = input.getBooleanOr("adrenalineactive", false);
			heighttemp = input.getDoubleOr("heighttemp", 0);
			heightcontinue = input.getBooleanOr("heightcontinue", false);
			craftingstation_offset = input.getDoubleOr("craftingstation_offset", 0);
			craftingstation_temp = input.getDoubleOr("craftingstation_temp", 0);
			accessoryslot_1 = input.read("accessoryslot_1", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			accessoryslot_2 = input.read("accessoryslot_2", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			accessoryslot_3 = input.read("accessoryslot_3", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			accessoryslot_4 = input.read("accessoryslot_4", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			accessoryslot_5 = input.read("accessoryslot_5", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			accessoryslot_6 = input.read("accessoryslot_6", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			accessoryslot_7 = input.read("accessoryslot_7", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			accessoryslot_8 = input.read("accessoryslot_8", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			accessoryslot_9 = input.read("accessoryslot_9", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			flybuttonactive = input.getBooleanOr("flybuttonactive", false);
		}

		public void markSyncDirty() {
			_syncDirty = true;
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(CalamityMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> {
			TagValueOutput output = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, buffer.registryAccess());
			message.data.serialize(output);
			buffer.writeNbt(output.buildResult());
		}, (RegistryFriendlyByteBuf buffer) -> {
			PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
			message.data.deserialize(TagValueInput.create(ProblemReporter.DISCARDING, buffer.registryAccess(), buffer.readNbt()));
			return message;
		});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					TagValueOutput output = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, context.player().registryAccess());
					message.data.serialize(output);
					context.player().getData(PLAYER_VARIABLES).deserialize(TagValueInput.create(ProblemReporter.DISCARDING, context.player().registryAccess(), output.buildResult()));
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}