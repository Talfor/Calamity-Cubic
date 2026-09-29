package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class TerrariaAshBlock extends Block {
	public TerrariaAshBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.SAND).strength(2f, 20f).requiresCorrectToolForDrops());
	}
}