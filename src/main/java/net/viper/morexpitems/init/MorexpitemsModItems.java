
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.viper.morexpitems.init;

import net.viper.morexpitems.item.XptobottleItem;
import net.viper.morexpitems.item.XpswordItem;
import net.viper.morexpitems.item.XpingotplusItem;
import net.viper.morexpitems.item.XpingotItem;
import net.viper.morexpitems.item.XpShovelItem;
import net.viper.morexpitems.item.XpPickaxeItem;
import net.viper.morexpitems.item.XpHoeItem;
import net.viper.morexpitems.item.XpAxeItem;
import net.viper.morexpitems.item.XpArmorItem;
import net.viper.morexpitems.MorexpitemsMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class MorexpitemsModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MorexpitemsMod.MODID);
	public static final DeferredItem<Item> XP_ORE = block(MorexpitemsModBlocks.XP_ORE);
	public static final DeferredItem<Item> XP_INGOT = REGISTRY.register("xp_ingot", XpingotItem::new);
	public static final DeferredItem<Item> XP_CHEST = block(MorexpitemsModBlocks.XP_CHEST);
	public static final DeferredItem<Item> XP_INGOT_PLUS = REGISTRY.register("xp_ingot_plus", XpingotplusItem::new);
	public static final DeferredItem<Item> XP_ARMOR_HELMET = REGISTRY.register("xp_armor_helmet", XpArmorItem.Helmet::new);
	public static final DeferredItem<Item> XP_ARMOR_CHESTPLATE = REGISTRY.register("xp_armor_chestplate", XpArmorItem.Chestplate::new);
	public static final DeferredItem<Item> XP_ARMOR_LEGGINGS = REGISTRY.register("xp_armor_leggings", XpArmorItem.Leggings::new);
	public static final DeferredItem<Item> XP_ARMOR_BOOTS = REGISTRY.register("xp_armor_boots", XpArmorItem.Boots::new);
	public static final DeferredItem<Item> XP_PICKAXE = REGISTRY.register("xp_pickaxe", XpPickaxeItem::new);
	public static final DeferredItem<Item> XP_AXE = REGISTRY.register("xp_axe", XpAxeItem::new);
	public static final DeferredItem<Item> XP_SHOVEL = REGISTRY.register("xp_shovel", XpShovelItem::new);
	public static final DeferredItem<Item> XP_HOE = REGISTRY.register("xp_hoe", XpHoeItem::new);
	public static final DeferredItem<Item> XP_SWORD = REGISTRY.register("xp_sword", XpswordItem::new);
	public static final DeferredItem<Item> XP_TO_BOTTLE = REGISTRY.register("xp_to_bottle", XptobottleItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
