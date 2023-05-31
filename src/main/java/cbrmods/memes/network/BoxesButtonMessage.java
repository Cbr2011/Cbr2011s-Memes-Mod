
package cbrmods.memes.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

import cbrmods.memes.world.inventory.BoxesMenu;
import cbrmods.memes.procedures.ShipItemsProcedure;
import cbrmods.memes.procedures.OpenAboutBoxesProcedure;
import cbrmods.memes.procedures.NukeProcedure;
import cbrmods.memes.procedures.CloseBoxesProcedure;
import cbrmods.memes.MemesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BoxesButtonMessage {
	private final int buttonID, x, y, z;

	public BoxesButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public BoxesButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(BoxesButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(BoxesButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = BoxesMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CloseBoxesProcedure.execute(entity);
		}
		if (buttonID == 1) {

			NukeProcedure.execute(world, entity);
		}
		if (buttonID == 2) {

			OpenAboutBoxesProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ShipItemsProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MemesMod.addNetworkMessage(BoxesButtonMessage.class, BoxesButtonMessage::buffer, BoxesButtonMessage::new, BoxesButtonMessage::handler);
	}
}
