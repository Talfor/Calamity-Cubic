package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TerrariaHellstoneBlock extends Block {
	public TerrariaHellstoneBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(6f, 60f).requiresCorrectToolForDrops());
	}
}