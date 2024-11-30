
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.viper.morexpitems.init;

import net.viper.morexpitems.client.gui.XpchestguiScreen;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MorexpitemsModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(MorexpitemsModMenus.XPCHESTGUI.get(), XpchestguiScreen::new);
	}
}
