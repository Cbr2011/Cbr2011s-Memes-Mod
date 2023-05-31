
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package cbrmods.memes.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MemesModTabs {
	@SubscribeEvent
	public static void buildTabContentsModded(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("memes", "werid_minecraft"),
				builder -> builder.title(Component.translatable("item_group.memes.werid_minecraft")).icon(() -> new ItemStack(Blocks.GRASS_BLOCK)).displayItems((parameters, tabData) -> {
					tabData.accept(MemesModBlocks.AMAZON_BOX.get().asItem());
					tabData.accept(MemesModItems.LONDON.get());
					tabData.accept(MemesModBlocks.LIFE_CHART.get().asItem());
					tabData.accept(MemesModItems.CANCELLATION.get());
					tabData.accept(MemesModItems.EMPTY_PRINGLES.get());
					tabData.accept(MemesModItems.PRINGLES.get());
				}).withSearchBar());
	}
}
