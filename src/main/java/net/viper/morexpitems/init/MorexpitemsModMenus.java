
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.viper.morexpitems.init;

import net.viper.morexpitems.world.inventory.XpchestguiMenu;
import net.viper.morexpitems.MorexpitemsMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

public class MorexpitemsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MorexpitemsMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<XpchestguiMenu>> XPCHESTGUI = REGISTRY.register("xpchestgui", () -> IMenuTypeExtension.create(XpchestguiMenu::new));
}
