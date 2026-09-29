package net.mcreator.calamity.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.Identifier;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.calamity.procedures.*;
import net.mcreator.calamity.CalamityMod;

@EventBusSubscriber
public record DifficultySelectionButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<DifficultySelectionButtonMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(CalamityMod.MODID, "difficulty_selection_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, DifficultySelectionButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, DifficultySelectionButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new DifficultySelectionButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<DifficultySelectionButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final DifficultySelectionButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			SelectDifficulty0Procedure.execute(world, entity);
		}
		if (buttonID == 1) {

			SelectDifficulty1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			SelectDifficulty3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SelectDifficulty5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SelectDifficulty2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			SelectDifficulty4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			SelectDifficulty6Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CalamityMod.addNetworkMessage(DifficultySelectionButtonMessage.TYPE, DifficultySelectionButtonMessage.STREAM_CODEC, DifficultySelectionButtonMessage::handleData);
	}
}