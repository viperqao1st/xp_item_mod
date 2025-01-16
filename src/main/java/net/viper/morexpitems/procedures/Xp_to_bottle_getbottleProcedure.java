package net.viper.morexpitems.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class Xp_to_bottle_getbottleProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 5) {
			if (entity instanceof Player _player)
				_player.giveExperiencePoints(-(10));
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.EXPERIENCE_BOTTLE).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
