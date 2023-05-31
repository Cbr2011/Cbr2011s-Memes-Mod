
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package cbrmods.memes.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import cbrmods.memes.block.LifeChartBlock;
import cbrmods.memes.block.AmazonBoxBlock;
import cbrmods.memes.MemesMod;

public class MemesModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MemesMod.MODID);
	public static final RegistryObject<Block> AMAZON_BOX = REGISTRY.register("amazon_box", () -> new AmazonBoxBlock());
	public static final RegistryObject<Block> LIFE_CHART = REGISTRY.register("life_chart", () -> new LifeChartBlock());
}
