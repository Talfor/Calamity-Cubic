package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TerrariaHardenedStoneBlock extends Block {
	public TerrariaHardenedStoneBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(1.75f, 17.5f).requiresCorrectToolForDrops());
	}
}