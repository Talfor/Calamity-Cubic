package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class TerrariaMudBlock extends Block {
	public TerrariaMudBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.MUD).strength(1.25f, 12.5f).requiresCorrectToolForDrops());
	}
}