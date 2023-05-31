package cbrmods.memes.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

import cbrmods.memes.world.inventory.BoxesMenu;
import cbrmods.memes.network.BoxesButtonMessage;
import cbrmods.memes.MemesMod;

public class BoxesScreen extends AbstractContainerScreen<BoxesMenu> {
	private final static HashMap<String, Object> guistate = BoxesMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_x;
	Button button_nuke;
	Button button_about;
	Button button_ship;

	public BoxesScreen(BoxesMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 410;
		this.imageHeight = 223;
	}

	private static final ResourceLocation texture = new ResourceLocation("memes:textures/screens/boxes.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.memes.boxes.label_amazon_boxes"), 12, 7, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.memes.boxes.label_box_one"), 247, 116, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.memes.boxes.label_your_inv"), 68, 117, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.memes.boxes.label_empty"), 339, 12, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.memes.boxes.label_empty1"), 352, 11, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.memes.boxes.label_100"), 13, 20, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.memes.boxes.label_nuke_items"), 66, 32, -52480);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_x = Button.builder(Component.translatable("gui.memes.boxes.button_x"), e -> {
			if (true) {
				MemesMod.PACKET_HANDLER.sendToServer(new BoxesButtonMessage(0, x, y, z));
				BoxesButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 375, this.topPos + 6, 30, 20).build();
		guistate.put("button:button_x", button_x);
		this.addRenderableWidget(button_x);
		button_nuke = Button.builder(Component.translatable("gui.memes.boxes.button_nuke"), e -> {
			if (true) {
				MemesMod.PACKET_HANDLER.sendToServer(new BoxesButtonMessage(1, x, y, z));
				BoxesButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 179, this.topPos + 75, 51, 20).build();
		guistate.put("button:button_nuke", button_nuke);
		this.addRenderableWidget(button_nuke);
		button_about = Button.builder(Component.translatable("gui.memes.boxes.button_about"), e -> {
			if (true) {
				MemesMod.PACKET_HANDLER.sendToServer(new BoxesButtonMessage(2, x, y, z));
				BoxesButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 341, this.topPos + 192, 51, 20).build();
		guistate.put("button:button_about", button_about);
		this.addRenderableWidget(button_about);
		button_ship = Button.builder(Component.translatable("gui.memes.boxes.button_ship"), e -> {
			if (true) {
				MemesMod.PACKET_HANDLER.sendToServer(new BoxesButtonMessage(3, x, y, z));
				BoxesButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 281, this.topPos + 158, 46, 20).build();
		guistate.put("button:button_ship", button_ship);
		this.addRenderableWidget(button_ship);
	}
}
