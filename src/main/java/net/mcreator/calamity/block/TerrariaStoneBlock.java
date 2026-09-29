package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TerrariaStoneBlock extends Block {
	public TerrariaStoneBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(2.5f, 25f).requiresCorrectToolForDrops());
	}
}