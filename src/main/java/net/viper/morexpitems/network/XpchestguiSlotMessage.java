
package net.viper.morexpitems.network;

import net.viper.morexpitems.world.inventory.XpchestguiMenu;
import net.viper.morexpitems.procedures.XpchestbottletoxpProcedure;
import net.viper.morexpitems.MorexpitemsMod;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record XpchestguiSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) implements CustomPacketPayload {

	public static final Type<XpchestguiSlotMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MorexpitemsMod.MODID, "xpchestgui_slots"));
	public static final StreamCodec<RegistryFriendlyByteBuf, XpchestguiSlotMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, XpchestguiSlotMessage message) -> {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}, (RegistryFriendlyByteBuf buffer) -> new XpchestguiSlotMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<XpchestguiSlotMessage> type() {
		return TYPE;
	}

	public static void handleData(final XpchestguiSlotMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = XpchestguiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 0 && changeType == 0) {

			XpchestbottletoxpProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MorexpitemsMod.addNetworkMessage(XpchestguiSlotMessage.TYPE, XpchestguiSlotMessage.STREAM_CODEC, XpchestguiSlotMessage::handleData);
	}
}
