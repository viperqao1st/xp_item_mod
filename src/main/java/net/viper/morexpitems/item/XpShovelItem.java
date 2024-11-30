
package net.viper.morexpitems.item;

import net.viper.morexpitems.procedures.Fall_xpProcedure;
import net.viper.morexpitems.init.MorexpitemsModItems;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.core.BlockPos;

public class XpShovelItem extends ShovelItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 1164;
		}

		@Override
		public float getSpeed() {
			return 12f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 42;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(new ItemStack(MorexpitemsModItems.XP_INGOT_PLUS.get()));
		}
	};

	public XpShovelItem() {
		super(TOOL_TIER, new Item.Properties().attributes(DiggerItem.createAttributes(TOOL_TIER, 13f, -1f)));
	}

	@Override
	public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
		boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
		Fall_xpProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		Fall_xpProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		return retval;
	}
}
