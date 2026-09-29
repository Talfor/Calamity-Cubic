package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class CalamitySulphurousSandBlock extends Block {
	public CalamitySulphurousSandBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.SAND).strength(1.25f, 12.5f).requiresCorrectToolForDrops());
	}
}