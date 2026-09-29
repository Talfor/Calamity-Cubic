package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class TerrariaSnowBlock extends Block {
	public TerrariaSnowBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.SNOW).strength(0.5f, 5f).requiresCorrectToolForDrops());
	}
}