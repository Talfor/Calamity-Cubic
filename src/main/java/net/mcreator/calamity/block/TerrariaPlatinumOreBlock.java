package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TerrariaPlatinumOreBlock extends Block {
	public TerrariaPlatinumOreBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(4.5f, 45f).requiresCorrectToolForDrops());
	}
}