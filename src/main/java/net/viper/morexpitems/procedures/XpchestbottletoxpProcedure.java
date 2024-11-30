package net.viper.morexpitems.procedures;

import net.viper.morexpitems.init.MorexpitemsModItems;
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

public class XpchestbottletoxpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((BuiltInRegistries.BLOCK.getKey(MorexpitemsModBlocks.XP_CHEST.get()).toString()).equals(BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString())) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Items.EXPERIENCE_BOTTLE) {
				{
					int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("xp_count") instanceof IntegerProperty _getip6
							? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip6)
							: -1) + 1);
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("xp_count") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					((Slot) _slots.get(0)).remove(1);
					_player.containerMenu.broadcastChanges();
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MorexpitemsModItems.XP_INGOT
					.get()) {
				{
					int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("xp_count") instanceof IntegerProperty _getip12
							? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip12)
							: -1) + 8);
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("xp_count") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					((Slot) _slots.get(0)).remove(1);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
	}
}
