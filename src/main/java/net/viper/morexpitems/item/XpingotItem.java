
package net.viper.morexpitems.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class XpingotItem extends Item {
	public XpingotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
