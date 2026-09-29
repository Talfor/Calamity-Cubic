package net.mcreator.calamity.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

import com.mojang.serialization.MapCodec;

public class LifeCrystalBlock extends FallingBlock {
	public static final MapCodec<LifeCrystalBlock> CODEC = simpleCodec(LifeCrystalBlock::new);

	@Override
	public MapCodec<LifeCrystalBlock> codec() {
		return CODEC;
	}

	@Override
	public int getDustColor(BlockState blockstate, BlockGetter world, BlockPos pos) {
		return blockstate.getMapColor(world, pos).col;
	}

	public LifeCrystalBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.GLASS).strength(4f, 40f).requiresCorrectToolForDrops());
	}

	@Override
	public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state, boolean includeData, Player entity) {
		return ItemStack.EMPTY;
	}
}