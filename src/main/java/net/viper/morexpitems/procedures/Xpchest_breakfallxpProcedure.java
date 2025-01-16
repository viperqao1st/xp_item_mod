package net.viper.morexpitems.procedures;

import net.viper.morexpitems.init.MorexpitemsModBlocks;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class Xpchest_breakfallxpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((BuiltInRegistries.BLOCK.getKey(blockstate.getBlock()).toString()).equals(BuiltInRegistries.BLOCK.getKey(MorexpitemsModBlocks.XP_CHEST.get()).toString())) {
			if (world instanceof ServerLevel _level)
				_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, blockstate.getBlock().getStateDefinition().getProperty("xp_count") instanceof IntegerProperty _getip4 ? blockstate.getValue(_getip4) : -1));
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("xp_count") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
	}
}
