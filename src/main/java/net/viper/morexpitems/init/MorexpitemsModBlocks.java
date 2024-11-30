
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.viper.morexpitems.init;

import net.viper.morexpitems.block.XporeBlock;
import net.viper.morexpitems.block.XpchestBlock;
import net.viper.morexpitems.MorexpitemsMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

public class MorexpitemsModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MorexpitemsMod.MODID);
	public static final DeferredBlock<Block> XP_ORE = REGISTRY.register("xp_ore", XporeBlock::new);
	public static final DeferredBlock<Block> XP_CHEST = REGISTRY.register("xp_chest", XpchestBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
