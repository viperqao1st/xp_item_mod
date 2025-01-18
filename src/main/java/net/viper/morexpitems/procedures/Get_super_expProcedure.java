package net.viper.morexpitems.procedures;

import net.viper.morexpitems.init.MorexpitemsModItems;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;

public class Get_super_expProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MorexpitemsModItems.GET_SUPEREXP_STICK.get())) : false) {
			if ((BuiltInRegistries.ENTITY_TYPE.getKey(sourceentity.getType()).toString()).equals("morexpitems:super_exp")) {
				if (sourceentity.getType().is(EntityTypeTags.UNDEAD)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 2));
					if (entity instanceof Player _player)
						_player.giveExperienceLevels((int) sourceentity.getPersistentData().getDouble("have_exp_count"));
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MorexpitemsModItems.XP_INGOT.get()).copy();
						_setstack.setCount(2);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u4F60\u65E0\u6CD5\u627F\u53D7\u5982\u6B64\u4E4B\u9AD8\u7684\u7ECF\u9A8C\uFF01"), false);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 5));
			if (entity instanceof Player _player)
				_player.giveExperienceLevels(-(2));
			sourceentity.getPersistentData().putDouble("have_exp_count", (sourceentity.getPersistentData().getDouble("have_exp_count") + 6));
		}
	}
}
