package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TerrariaTungstenOreBlock extends Block {
	public TerrariaTungstenOreBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(4f, 40f).requiresCorrectToolForDrops());
	}
}