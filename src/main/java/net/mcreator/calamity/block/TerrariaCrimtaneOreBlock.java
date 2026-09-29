package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TerrariaCrimtaneOreBlock extends Block {
	public TerrariaCrimtaneOreBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(5f).requiresCorrectToolForDrops().postProcess((bs, br, bp) -> bp).emissiveRendering((bs, br, bp) -> true));
	}
}