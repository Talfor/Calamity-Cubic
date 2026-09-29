package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TerrariaSilverOreBlock extends Block {
	public TerrariaSilverOreBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(4f, 40f).requiresCorrectToolForDrops());
	}
}