package net.mcreator.calamity.item;

import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class WindsFledglingItem extends Item {
	public WindsFledglingItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		componentConsumer.accept(Component.translatable("item.calamity.winds_fledgling.description_0"));
		componentConsumer.accept(Component.translatable("item.calamity.winds_fledgling.description_1"));
		componentConsumer.accept(Component.translatable("item.calamity.winds_fledgling.description_2"));
	}
}