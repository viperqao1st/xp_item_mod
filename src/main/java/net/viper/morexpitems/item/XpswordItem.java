
package net.viper.morexpitems.item;

import net.viper.morexpitems.procedures.Fall_xpProcedure;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

public class XpswordItem extends Item {
	public XpswordItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		Fall_xpProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		return retval;
	}
}
