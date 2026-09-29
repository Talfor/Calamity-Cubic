package net.mcreator.calamity.item;

import net.minecraft.world.item.Item;

public class CoinGoldItem extends Item {
	public CoinGoldItem(Item.Properties properties) {
		super(properties.stacksTo(99));
	}
}