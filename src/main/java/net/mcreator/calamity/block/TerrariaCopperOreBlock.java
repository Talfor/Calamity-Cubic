package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TerrariaCopperOreBlock extends Block {
	public TerrariaCopperOreBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(3f, 30f).requiresCorrectToolForDrops());
	}
}