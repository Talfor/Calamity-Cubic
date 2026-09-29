package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TerrariaSandstoneBlock extends Block {
	public TerrariaSandstoneBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(1.75f, 17.5f).requiresCorrectToolForDrops());
	}
}