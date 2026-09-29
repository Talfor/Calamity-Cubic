package net.mcreator.calamity.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.calamity.init.CalamityModItems;

@EventBusSubscriber
public class CopperBoardswordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 0, 2f, 0, 2, TagKey.create(Registries.ITEM, Identifier.parse("calamity:copper_boardsword_repair_items")));

	public CopperBoardswordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 8f, -2.1f));
	}

	@SubscribeEvent
	public static void modifyDefaultComponents(ModifyDefaultComponentsEvent event) {
		event.modify(CalamityModItems.COPPER_BOARDSWORD.get(), (builder, _, _) -> builder.set(DataComponents.MAX_DAMAGE, null));
	}
}