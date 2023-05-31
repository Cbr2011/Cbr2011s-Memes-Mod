
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package cbrmods.memes.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import cbrmods.memes.item.PringlesItem;
import cbrmods.memes.item.LondonItem;
import cbrmods.memes.item.EmptyPringlesItem;
import cbrmods.memes.item.CancellationItem;
import cbrmods.memes.MemesMod;

public class MemesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MemesMod.MODID);
	public static final RegistryObject<Item> AMAZON_BOX = block(MemesModBlocks.AMAZON_BOX);
	public static final RegistryObject<Item> LONDON = REGISTRY.register("london", () -> new LondonItem());
	public static final RegistryObject<Item> LIFE_CHART = block(MemesModBlocks.LIFE_CHART);
	public static final RegistryObject<Item> CANCELLATION = REGISTRY.register("cancellation", () -> new CancellationItem());
	public static final RegistryObject<Item> EMPTY_PRINGLES = REGISTRY.register("empty_pringles", () -> new EmptyPringlesItem());
	public static final RegistryObject<Item> PRINGLES = REGISTRY.register("pringles", () -> new PringlesItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
