
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.viper.morexpitems.init;

import net.viper.morexpitems.MorexpitemsMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class MorexpitemsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MorexpitemsMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_MOREXPITEMS = REGISTRY.register("mod_morexpitems",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.morexpitems.mod_morexpitems")).icon(() -> new ItemStack(MorexpitemsModItems.XP_INGOT_PLUS.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MorexpitemsModBlocks.XP_ORE.get().asItem());
				tabData.accept(MorexpitemsModItems.XP_INGOT.get());
				tabData.accept(MorexpitemsModBlocks.XP_CHEST.get().asItem());
				tabData.accept(MorexpitemsModItems.XP_INGOT_PLUS.get());
				tabData.accept(MorexpitemsModItems.XP_PICKAXE.get());
				tabData.accept(MorexpitemsModItems.XP_AXE.get());
				tabData.accept(MorexpitemsModItems.XP_SHOVEL.get());
				tabData.accept(MorexpitemsModItems.XP_HOE.get());
				tabData.accept(MorexpitemsModItems.XP_SWORD.get());
				tabData.accept(MorexpitemsModItems.XP_TO_BOTTLE.get());
				tabData.accept(MorexpitemsModItems.GET_SUPEREXP_STICK.get());
				tabData.accept(MorexpitemsModItems.SUPER_EXP_SPAWN_EGG.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(MorexpitemsModBlocks.XP_ORE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(MorexpitemsModItems.XP_INGOT.get());
			tabData.accept(MorexpitemsModItems.XP_INGOT_PLUS.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(MorexpitemsModItems.XP_ARMOR_HELMET.get());
			tabData.accept(MorexpitemsModItems.XP_ARMOR_CHESTPLATE.get());
			tabData.accept(MorexpitemsModItems.XP_ARMOR_LEGGINGS.get());
			tabData.accept(MorexpitemsModItems.XP_ARMOR_BOOTS.get());
			tabData.accept(MorexpitemsModItems.XP_SWORD.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(MorexpitemsModItems.XP_PICKAXE.get());
			tabData.accept(MorexpitemsModItems.XP_AXE.get());
			tabData.accept(MorexpitemsModItems.XP_SHOVEL.get());
			tabData.accept(MorexpitemsModItems.XP_HOE.get());
			tabData.accept(MorexpitemsModItems.XP_TO_BOTTLE.get());
			tabData.accept(MorexpitemsModItems.GET_SUPEREXP_STICK.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(MorexpitemsModItems.SUPER_EXP_SPAWN_EGG.get());
		}
	}
}
