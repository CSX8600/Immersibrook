package rz.mesabrook.wbtc.blocks.gui.telecom;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import rz.mesabrook.wbtc.net.telecom.DisconnectCallPacket;
import rz.mesabrook.wbtc.util.handlers.PacketHandler;

public class GuiPhoneCalling extends GuiPhoneBase {

	private String toNumber;
	public GuiPhoneCalling(ItemStack phoneStack, EnumHand hand, String toNumber) {
		super(phoneStack, hand);
		this.toNumber = toNumber;
	}

	@Override
	protected String getInnerTextureFileName() {
		return "app_screen.png";
	}

	public String getToNumber() {
		return toNumber;
	}

	public void setToNumber(String toNumber) {
		this.toNumber = toNumber;
	}
	
	@Override
	public void initGui() {
		super.initGui();
		
		ImageButton endCall = new ImageButton(0, INNER_X + (INNER_TEX_WIDTH / 2) - 16, INNER_Y + 150, 32, 32, "numcallend.png", 32, 32);
		buttonList.add(endCall);
	}

	@Override
	protected void doDraw(int mouseX, int mouseY, float partialticks) {
		GlStateManager.scale(dLittleFont, dLittleFont, dLittleFont);
		drawCenteredString(fontRenderer, "Calling...", scale(INNER_X + (INNER_TEX_WIDTH / 2), uLittleFont), scale(INNER_Y + 21, uLittleFont), 0xFFFFFF);
		GlStateManager.scale(uLittleFont, uLittleFont, uLittleFont);
		
		GlStateManager.scale(uBigFont, uBigFont, uBigFont);
		drawCenteredString(fontRenderer, getFormattedPhoneNumber(toNumber), scale(INNER_X + (INNER_TEX_WIDTH / 2), dBigFont), scale(INNER_Y + 50, dBigFont), 0xFFFFFF);
		GlStateManager.scale(dBigFont, dBigFont, dBigFont);
		
		super.doDraw(mouseX, mouseY, partialticks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		DisconnectCallPacket disconnect = new DisconnectCallPacket();
		disconnect.fromNumber = getCurrentPhoneNumber();
		PacketHandler.INSTANCE.sendToServer(disconnect);
	}
}