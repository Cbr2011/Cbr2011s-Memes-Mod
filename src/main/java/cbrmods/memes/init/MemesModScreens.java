
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package cbrmods.memes.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import cbrmods.memes.client.gui.BoxesScreen;
import cbrmods.memes.client.gui.AboutBoxesScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MemesModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MemesModMenus.BOXES.get(), BoxesScreen::new);
			MenuScreens.register(MemesModMenus.ABOUT_BOXES.get(), AboutBoxesScreen::new);
		});
	}
}
