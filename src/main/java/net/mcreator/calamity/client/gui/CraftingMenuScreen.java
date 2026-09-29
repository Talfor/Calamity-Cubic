package net.mcreator.calamity.client.gui;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import net.mcreator.calamity.world.inventory.CraftingMenuMenu;
import net.mcreator.calamity.procedures.WorkbenchGetProcedure;
import net.mcreator.calamity.procedures.FurnaceGetProcedure;
import net.mcreator.calamity.procedures.AnvilGetProcedure;
import net.mcreator.calamity.network.CraftingMenuButtonMessage;
import net.mcreator.calamity.init.CalamityModScreens;

import com.mojang.blaze3d.platform.InputConstants;

public class CraftingMenuScreen extends AbstractContainerScreen<CraftingMenuMenu> implements CalamityModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_arrow_left;
	private ImageButton imagebutton_arrow_right;
	private static final Identifier BACKGROUND = Identifier.parse("calamity:textures/screens/crafting_menu.png");
	private static final Identifier SPRITE_0 = Identifier.parse("calamity:textures/screens/work_bench_png.png");
	private static final Identifier SPRITE_1 = Identifier.parse("calamity:textures/screens/furnace_item.png");
	private static final Identifier SPRITE_2 = Identifier.parse("calamity:textures/screens/iron_anvil_png.png");

	public CraftingMenuScreen(CraftingMenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 176, 166);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractBackground(guiGraphics, mouseX, mouseY, partialTicks);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, this.leftPos + 8, this.topPos + 66, 0, Mth.clamp((int) WorkbenchGetProcedure.execute(world, x, y, z) * 16, 0, 16), 16, 16, 16, 32);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_1, this.leftPos + 26, this.topPos + 66, 0, Mth.clamp((int) FurnaceGetProcedure.execute(world, x, y, z) * 16, 0, 16), 16, 16, 16, 32);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_2, this.leftPos + 43, this.topPos + 66, 0, Mth.clamp((int) AnvilGetProcedure.execute(world, x, y, z) * 16, 0, 16), 16, 16, 16, 32);
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		int key = InputConstants.getKey(event).getValue();
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(event);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_left = new ImageButton(this.leftPos + 11, this.topPos + 22, 10, 9, new WidgetSprites(Identifier.parse("calamity:textures/screens/arrow_left.png"), Identifier.parse("calamity:textures/screens/arrow_left_selected.png")),
				e -> {
					int x = CraftingMenuScreen.this.x;
					int y = CraftingMenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new CraftingMenuButtonMessage(0, x, y, z));
						CraftingMenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_left);
		imagebutton_arrow_right = new ImageButton(this.leftPos + 155, this.topPos + 22, 10, 9, new WidgetSprites(Identifier.parse("calamity:textures/screens/arrow_right.png"), Identifier.parse("calamity:textures/screens/arrow_right_selected.png")),
				e -> {
					int x = CraftingMenuScreen.this.x;
					int y = CraftingMenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new CraftingMenuButtonMessage(1, x, y, z));
						CraftingMenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_right);
	}
}