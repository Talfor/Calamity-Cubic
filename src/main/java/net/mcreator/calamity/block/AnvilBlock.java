package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class AnvilBlock extends Block {
	public AnvilBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.WOOD).strength(3.5f, 35f).requiresCorrectToolForDrops());
	}
}