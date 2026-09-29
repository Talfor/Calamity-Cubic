package net.mcreator.calamity.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.mcreator.calamity.procedures.LifeCrystalItemRightclickedProcedure;

public class LifeCrystalItemItem extends Item {
	public LifeCrystalItemItem(Item.Properties properties) {
		super(properties.stacksTo(99));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		LifeCrystalItemRightclickedProcedure.execute(entity);
		return ar;
	}
}