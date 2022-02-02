package com.mesabrook.ib.telecom.handlers;

import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.mesabrook.ib.blocks.gui.telecom.GuiPhoneBase;

@EventBusSubscriber(Side.CLIENT)
@SideOnly(Side.CLIENT)
public class OpenGuiEventHandler {
	@SubscribeEvent
	public static void onGuiOpen(GuiOpenEvent e)
	{
		GuiPhoneBase.lastGuiWasPhone = e.getGui() instanceof GuiPhoneBase;
	}
}