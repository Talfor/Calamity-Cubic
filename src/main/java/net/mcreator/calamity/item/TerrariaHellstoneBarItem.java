package net.mcreator.calamity.item;

import net.minecraft.world.item.Item;

public class TerrariaHellstoneBarItem extends Item {
	public TerrariaHellstoneBarItem(Item.Properties properties) {
		super(properties.stacksTo(99).fireResistant());
	}
}