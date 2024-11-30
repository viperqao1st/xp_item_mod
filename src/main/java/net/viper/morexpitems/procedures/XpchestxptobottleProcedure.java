package net.viper.morexpitems.procedures;

import net.viper.morexpitems.init.MorexpitemsModBlocks;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.Map;

public class XpchestxptobottleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		for (int index0 = 0; index0 < 1; index0++) {
			if ((BuiltInRegistries.BLOCK.getKey(MorexpitemsModBlocks.XP_CHEST.get()).toString()).equals(BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString())) {
				if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("xp_count") instanceof IntegerProperty _getip4 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip4) : -1) >= 1) {
					{
						int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("xp_count") instanceof IntegerProperty _getip6
								? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip6)
								: -1) - 1);
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("xp_count") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(1) == 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(Items.EXPERIENCE_BOTTLE).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(1)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(Items.EXPERIENCE_BOTTLE).copy();
							_setstack.setCount((int) (new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(1) + 1));
							((Slot) _slots.get(1)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
	}
}
