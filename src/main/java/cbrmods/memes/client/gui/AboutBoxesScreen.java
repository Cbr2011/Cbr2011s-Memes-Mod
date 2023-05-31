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

import cbrmods.memes.world.inventory.AboutBoxesMenu;
import cbrmods.memes.network.AboutBoxesButtonMessage;
import cbrmods.memes.MemesMod;

public class AboutBoxesScreen extends AbstractContainerScreen<AboutBoxesMenu> {
	private final static HashMap<String, Object> guistate = AboutBoxesMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_close;

	public AboutBoxesScreen(AboutBoxesMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 191;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("memes:textures/screens/about_boxes.png");

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
		this.font.draw(poseStack, Component.translatable("gui.memes.about_boxes.label_amazon_box_software"), 43, 5, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.memes.about_boxes.label_110"), 76, 18, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.memes.about_boxes.label_sends_packages_to_the_far_lands"), 13, 34, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.memes.about_boxes.label_this_software_is_not_made_by_ama"), 7, 150, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_close = Button.builder(Component.translatable("gui.memes.about_boxes.button_close"), e -> {
			if (true) {
				MemesMod.PACKET_HANDLER.sendToServer(new AboutBoxesButtonMessage(0, x, y, z));
				AboutBoxesButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 68, this.topPos + 124, 51, 20).build();
		guistate.put("button:button_close", button_close);
		this.addRenderableWidget(button_close);
	}
}
