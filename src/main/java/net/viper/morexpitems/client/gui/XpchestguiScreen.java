package net.viper.morexpitems.client.gui;

import net.viper.morexpitems.world.inventory.XpchestguiMenu;
import net.viper.morexpitems.network.XpchestguiButtonMessage;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class XpchestguiScreen extends AbstractContainerScreen<XpchestguiMenu> {
	private final static HashMap<String, Object> guistate = XpchestguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_ba_jing_yan_zhuan_wei_ping;

	public XpchestguiScreen(XpchestguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("morexpitems:textures/screens/xpchestgui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.morexpitems.xpchestgui.label_jing_yan_cun_chu_qi"), 73, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_ba_jing_yan_zhuan_wei_ping = new PlainTextButton(this.leftPos + 36, this.topPos + 49, 106, 20, Component.translatable("gui.morexpitems.xpchestgui.button_ba_jing_yan_zhuan_wei_ping"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new XpchestguiButtonMessage(0, x, y, z));
				XpchestguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ba_jing_yan_zhuan_wei_ping", button_ba_jing_yan_zhuan_wei_ping);
		this.addRenderableWidget(button_ba_jing_yan_zhuan_wei_ping);
	}
}
