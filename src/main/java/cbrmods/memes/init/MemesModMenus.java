
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package cbrmods.memes.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import cbrmods.memes.world.inventory.BoxesMenu;
import cbrmods.memes.world.inventory.AboutBoxesMenu;
import cbrmods.memes.MemesMod;

public class MemesModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MemesMod.MODID);
	public static final RegistryObject<MenuType<BoxesMenu>> BOXES = REGISTRY.register("boxes", () -> IForgeMenuType.create(BoxesMenu::new));
	public static final RegistryObject<MenuType<AboutBoxesMenu>> ABOUT_BOXES = REGISTRY.register("about_boxes", () -> IForgeMenuType.create(AboutBoxesMenu::new));
}
