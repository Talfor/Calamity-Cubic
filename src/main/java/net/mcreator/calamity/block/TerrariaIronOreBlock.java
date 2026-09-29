package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TerrariaIronOreBlock extends Block {
	public TerrariaIronOreBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(3.5f, 35f).requiresCorrectToolForDrops());
	}
}