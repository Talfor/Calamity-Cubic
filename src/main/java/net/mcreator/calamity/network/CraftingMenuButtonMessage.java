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

import net.mcreator.calamity.procedures.MoveSelectionRightProcedure;
import net.mcreator.calamity.procedures.MoveSelectionLeftProcedure;
import net.mcreator.calamity.CalamityMod;

@EventBusSubscriber
public record CraftingMenuButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<CraftingMenuButtonMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(CalamityMod.MODID, "crafting_menu_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, CraftingMenuButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, CraftingMenuButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new CraftingMenuButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<CraftingMenuButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final CraftingMenuButtonMessage message, final IPayloadContext context) {
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

			MoveSelectionLeftProcedure.execute(entity);
		}
		if (buttonID == 1) {

			MoveSelectionRightProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CalamityMod.addNetworkMessage(CraftingMenuButtonMessage.TYPE, CraftingMenuButtonMessage.STREAM_CODEC, CraftingMenuButtonMessage::handleData);
	}
}