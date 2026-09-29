package net.mcreator.calamity.client.gui;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import net.mcreator.calamity.world.inventory.DifficultySelectionMenu;
import net.mcreator.calamity.procedures.ReturnDifficultyContentProcedure;
import net.mcreator.calamity.network.DifficultySelectionButtonMessage;
import net.mcreator.calamity.init.CalamityModScreens;

import com.mojang.blaze3d.platform.InputConstants;

public class DifficultySelectionScreen extends AbstractContainerScreen<DifficultySelectionMenu> implements CalamityModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_normal_indicator_png;
	private ImageButton imagebutton_expert_indicator_png;
	private ImageButton imagebutton_master_indicator_png;
	private ImageButton imagebutton_legendary_indicator_png;
	private ImageButton imagebutton_revengeance_indicator_png;
	private ImageButton imagebutton_death_indicator_png;
	private ImageButton imagebutton_malice_indicator_png;
	private static final Identifier BACKGROUND = Identifier.parse("calamity:textures/screens/difficulty_selection.png");
	private static final Identifier IMAGE_0 = Identifier.parse("calamity:textures/screens/uibackground_ds.png");
	private static final Identifier IMAGE_1 = Identifier.parse("calamity:textures/screens/calamitytitle.png");
	private static final Identifier IMAGE_2 = Identifier.parse("calamity:textures/screens/cubictitlesmall.png");

	public DifficultySelectionScreen(DifficultySelectionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 206, 142);
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
	public boolean isPauseScreen() {
		return true;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		if (mouseX > leftPos + 6 && mouseX < leftPos + 45 && mouseY > topPos + 49 && mouseY < topPos + 88) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.calamity.difficulty_selection.tooltip_ssbclassic_ssf_ss7the_vanilla_expe"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 57 && mouseX < leftPos + 96 && mouseY > topPos + 49 && mouseY < topPos + 88) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.calamity.difficulty_selection.tooltip_ss5expert_ssf_ss7unique_attack_pat"), mouseX, mouseY);
		}
		if (ReturnDifficultyContentProcedure.execute())
			if (mouseX > leftPos + 57 && mouseX < leftPos + 96 && mouseY > topPos + 88 && mouseY < topPos + 127) {
				guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.calamity.difficulty_selection.tooltip_sscrevengeance_ssf_ss7expert_new"), mouseX, mouseY);
			}
		if (mouseX > leftPos + 109 && mouseX < leftPos + 148 && mouseY > topPos + 49 && mouseY < topPos + 88) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.calamity.difficulty_selection.tooltip_ss4master_ssf_ss7greatly_increased"), mouseX, mouseY);
		}
		if (ReturnDifficultyContentProcedure.execute())
			if (mouseX > leftPos + 109 && mouseX < leftPos + 148 && mouseY > topPos + 88 && mouseY < topPos + 127) {
				guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.calamity.difficulty_selection.tooltip_ssddeath_ssf_ss7master_aggressiv"), mouseX, mouseY);
			}
		if (mouseX > leftPos + 161 && mouseX < leftPos + 200 && mouseY > topPos + 49 && mouseY < topPos + 88) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.calamity.difficulty_selection.tooltip_ss6legendary_ssf_ss7master_furth"), mouseX, mouseY);
		}
		if (ReturnDifficultyContentProcedure.execute())
			if (mouseX > leftPos + 161 && mouseX < leftPos + 200 && mouseY > topPos + 88 && mouseY < topPos + 127) {
				guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.calamity.difficulty_selection.tooltip_ssjmalice_ssf_ss7death_legendary"), mouseX, mouseY);
			}
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractBackground(guiGraphics, mouseX, mouseY, partialTicks);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 3, this.topPos + 3, 0, 0, 200, 136, 200, 136);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 35, this.topPos + 3, 0, 0, 133, 46, 133, 46);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 108, this.topPos + 34, 0, 0, 41, 16, 41, 16);
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
		imagebutton_normal_indicator_png = new ImageButton(this.leftPos + 6, this.topPos + 49, 39, 39,
				new WidgetSprites(Identifier.parse("calamity:textures/screens/normal_indicator_png.png"), Identifier.parse("calamity:textures/screens/normal_selected.png")), e -> {
					int x = DifficultySelectionScreen.this.x;
					int y = DifficultySelectionScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new DifficultySelectionButtonMessage(0, x, y, z));
						DifficultySelectionButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_normal_indicator_png);
		imagebutton_expert_indicator_png = new ImageButton(this.leftPos + 57, this.topPos + 49, 39, 39,
				new WidgetSprites(Identifier.parse("calamity:textures/screens/expert_indicator_png.png"), Identifier.parse("calamity:textures/screens/expert_selected.png")), e -> {
					int x = DifficultySelectionScreen.this.x;
					int y = DifficultySelectionScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new DifficultySelectionButtonMessage(1, x, y, z));
						DifficultySelectionButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_expert_indicator_png);
		imagebutton_master_indicator_png = new ImageButton(this.leftPos + 109, this.topPos + 49, 39, 39,
				new WidgetSprites(Identifier.parse("calamity:textures/screens/master_indicator_png.png"), Identifier.parse("calamity:textures/screens/master_selected.png")), e -> {
					int x = DifficultySelectionScreen.this.x;
					int y = DifficultySelectionScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new DifficultySelectionButtonMessage(2, x, y, z));
						DifficultySelectionButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_master_indicator_png);
		imagebutton_legendary_indicator_png = new ImageButton(this.leftPos + 161, this.topPos + 49, 39, 39,
				new WidgetSprites(Identifier.parse("calamity:textures/screens/legendary_indicator_png.png"), Identifier.parse("calamity:textures/screens/legendary_selected.png")), e -> {
					int x = DifficultySelectionScreen.this.x;
					int y = DifficultySelectionScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new DifficultySelectionButtonMessage(3, x, y, z));
						DifficultySelectionButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_legendary_indicator_png);
		imagebutton_revengeance_indicator_png = new ImageButton(this.leftPos + 58, this.topPos + 88, 39, 39,
				new WidgetSprites(Identifier.parse("calamity:textures/screens/revengeance_indicator_png.png"), Identifier.parse("calamity:textures/screens/revengeance_selected.png")), e -> {
					int x = DifficultySelectionScreen.this.x;
					int y = DifficultySelectionScreen.this.y;
					if (ReturnDifficultyContentProcedure.execute()) {
						ClientPacketDistributor.sendToServer(new DifficultySelectionButtonMessage(4, x, y, z));
						DifficultySelectionButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_revengeance_indicator_png);
		imagebutton_death_indicator_png = new ImageButton(this.leftPos + 109, this.topPos + 88, 39, 39,
				new WidgetSprites(Identifier.parse("calamity:textures/screens/death_indicator_png.png"), Identifier.parse("calamity:textures/screens/death_selected.png")), e -> {
					int x = DifficultySelectionScreen.this.x;
					int y = DifficultySelectionScreen.this.y;
					if (ReturnDifficultyContentProcedure.execute()) {
						ClientPacketDistributor.sendToServer(new DifficultySelectionButtonMessage(5, x, y, z));
						DifficultySelectionButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_death_indicator_png);
		imagebutton_malice_indicator_png = new ImageButton(this.leftPos + 161, this.topPos + 88, 39, 39,
				new WidgetSprites(Identifier.parse("calamity:textures/screens/malice_indicator_png.png"), Identifier.parse("calamity:textures/screens/malice_selected.png")), e -> {
					int x = DifficultySelectionScreen.this.x;
					int y = DifficultySelectionScreen.this.y;
					if (ReturnDifficultyContentProcedure.execute()) {
						ClientPacketDistributor.sendToServer(new DifficultySelectionButtonMessage(6, x, y, z));
						DifficultySelectionButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_malice_indicator_png);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.imagebutton_revengeance_indicator_png.visible = ReturnDifficultyContentProcedure.execute();
		this.imagebutton_death_indicator_png.visible = ReturnDifficultyContentProcedure.execute();
		this.imagebutton_malice_indicator_png.visible = ReturnDifficultyContentProcedure.execute();
	}
}