
package net.viper.morexpitems.block;

import org.checkerframework.checker.units.qual.s;

import net.viper.morexpitems.procedures.Fall_xpProcedure;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

public class XporeBlock extends Block {
	public XporeBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(4f, 10f).lightLevel(s -> 2).requiresCorrectToolForDrops().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		Fall_xpProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}
}
