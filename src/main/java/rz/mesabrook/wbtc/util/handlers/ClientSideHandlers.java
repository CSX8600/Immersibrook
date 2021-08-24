package rz.mesabrook.wbtc.util.handlers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.ISound.AttenuationType;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import rz.mesabrook.wbtc.blocks.gui.telecom.GuiCallEnd;
import rz.mesabrook.wbtc.blocks.gui.telecom.GuiEmptyPhone;
import rz.mesabrook.wbtc.blocks.gui.telecom.GuiHome;
import rz.mesabrook.wbtc.blocks.gui.telecom.GuiIncomingCall;
import rz.mesabrook.wbtc.blocks.gui.telecom.GuiPhoneActivate;
import rz.mesabrook.wbtc.blocks.gui.telecom.GuiPhoneActivate.ActivationScreens;
import rz.mesabrook.wbtc.blocks.gui.telecom.GuiPhoneBase;
import rz.mesabrook.wbtc.blocks.gui.telecom.GuiPhoneCalling;
import rz.mesabrook.wbtc.blocks.gui.telecom.GuiPhoneConnected;
import rz.mesabrook.wbtc.blocks.gui.telecom.SignalStrengths;
import rz.mesabrook.wbtc.init.SoundInit;
import rz.mesabrook.wbtc.net.PlaySoundPacket;
import rz.mesabrook.wbtc.net.telecom.PhoneQueryResponsePacket.ResponseTypes;
import rz.mesabrook.wbtc.util.Reference;

@SideOnly(Side.CLIENT)
public class ClientSideHandlers 
{
	private static HashMap<Long, PositionedSoundRecord> soundsByBlockPos = new HashMap<>();
	public static void playSoundHandler(PlaySoundPacket message, MessageContext ctx)
	{
		SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
		
		// Clear our cache of playing sounds
		// Since we do this each time the packet is received, this
		// shouldn't take a whole lot of extra processing time
		HashSet<Long> keysToRemove = new HashSet<>();
		for(Entry<Long, PositionedSoundRecord> kvp : soundsByBlockPos.entrySet())
		{
			if (!soundHandler.isSoundPlaying(kvp.getValue()))
			{
				keysToRemove.add(kvp.getKey());
			}
		}
		
		for(long key : keysToRemove)
		{
			soundsByBlockPos.remove(key);
		}
		
		PositionedSoundRecord existingSoundAtPosition = soundsByBlockPos.get(message.pos.toLong());
		if (existingSoundAtPosition != null)
		{
			return;
		}
		
		EntityPlayer player = Minecraft.getMinecraft().player;
		WorldClient world = Minecraft.getMinecraft().world;

		ResourceLocation soundLocation = new ResourceLocation(Reference.MODID, message.soundName);
		IForgeRegistry<SoundEvent> soundRegistry = GameRegistry.findRegistry(SoundEvent.class);
		SoundEvent sound = soundRegistry.getValue(soundLocation);
		
		PositionedSoundRecord record = new PositionedSoundRecord(sound, SoundCategory.BLOCKS, 1F, 1F, message.pos);
		
		soundsByBlockPos.put(message.pos.toLong(), record);
		
		Minecraft.getMinecraft().getSoundHandler().playSound(record);
	}
	
	// This little piece of shit is what actually loads the super duper poggy woggy creative menu for Immersibrook.
	public static void loadCreativeGUI()
	{
		MinecraftForge.EVENT_BUS.register(new CreativeGuiDrawHandler());
	}

	public static class TelecomClientHandlers
	{
		public static void onNoReception()
		{
			if (Minecraft.getMinecraft().currentScreen instanceof GuiPhoneActivate)
			{
				GuiPhoneActivate activate = (GuiPhoneActivate)Minecraft.getMinecraft().currentScreen;
				activate.setMessage("Failed to activate: out of range");
				activate.setActivationScreen(ActivationScreens.Message);
			}
		}
		
		public static void onChooseNumber(int[] options, boolean isResend)
		{
			if (Minecraft.getMinecraft().currentScreen instanceof GuiPhoneActivate)
			{
				GuiPhoneActivate activate = (GuiPhoneActivate)Minecraft.getMinecraft().currentScreen;
				activate.setSelectablePhoneNumbers(options, isResend);
				activate.setMessage("");
				activate.setActivationScreen(ActivationScreens.ChooseNumber);
			}
		}
		
		public static void onActivationComplete()
		{
			if (Minecraft.getMinecraft().currentScreen instanceof GuiPhoneActivate)
			{
				GuiPhoneActivate activate = (GuiPhoneActivate)Minecraft.getMinecraft().currentScreen;
				activate.goToMainScreen();
				
			}
		}
	
		public static void onReceptionReceived(double reception)
		{
			if (Minecraft.getMinecraft().currentScreen instanceof GuiPhoneBase)
			{
				GuiPhoneBase phone = (GuiPhoneBase)Minecraft.getMinecraft().currentScreen;
				phone.setSignalStrength(SignalStrengths.getForReceptionAmount(reception));
			}
		}
	
		private static HashMap<String, ISound> incomingCallSoundsByPhone = new HashMap<>();
		private static Object incomingSoundLock = new Object();
		private static void playIncomingCallSound(String phoneNumber)
		{
			SoundHandler handler = Minecraft.getMinecraft().getSoundHandler();
			synchronized(incomingSoundLock)
			{
				ISound incomingCallSound = incomingCallSoundsByPhone.get(phoneNumber);
				if (incomingCallSound != null && handler.isSoundPlaying(incomingCallSound))
				{
					return;
				}
				
				incomingCallSound = new PositionedSoundRecord(SoundInit.DING_6.getSoundName(), SoundCategory.MASTER, 0.25F, 1F, true, 0, AttenuationType.NONE, 0, 0, 0);
				incomingCallSoundsByPhone.put(phoneNumber, incomingCallSound);
				handler.playSound(incomingCallSound);
			}
		}
		
		public static void onIncomingCall(String fromNumber, String toNumber)
		{
			playIncomingCallSound(toNumber);
			
			Minecraft mc = Minecraft.getMinecraft();
			if (mc.currentScreen instanceof GuiPhoneBase)
			{
				GuiPhoneBase screen = (GuiPhoneBase)mc.currentScreen;
				if (!screen.getCurrentPhoneNumber().equals(toNumber))
				{
					return;
				}
				
				GuiIncomingCall incoming = new GuiIncomingCall(screen.getPhoneStack(), screen.getHand(), fromNumber);
				mc.displayGuiScreen(incoming);
			}
		}
		
		private static HashMap<String, ISound> outgoingCallsByPhone = new HashMap<>();
		private static Object outgoingSoundLock = new Object();
		private static void playOutgoingCallSound(String phoneNumber)
		{
			SoundHandler handler = Minecraft.getMinecraft().getSoundHandler();
			synchronized(outgoingSoundLock)
			{
				ISound outgoingCall = outgoingCallsByPhone.get(phoneNumber);
				if (outgoingCall != null && handler.isSoundPlaying(outgoingCall))
				{
					return;
				}
				
				outgoingCall = new PositionedSoundRecord(SoundInit.OUTGOING_CALL.getSoundName(), SoundCategory.MASTER, 0.25F, 1F, true, 0, AttenuationType.NONE, 0, 0, 0);
				outgoingCallsByPhone.put(phoneNumber, outgoingCall);
				handler.playSound(outgoingCall);
			}
		}
		
		public static void onOutgoingCallConnected(String fromNumber)
		{
			playOutgoingCallSound(fromNumber);
		}
		
		public static void onOutgoingCallNoSuchNumber(String fromNumber, String toNumber)
		{
			SoundHandler handler = Minecraft.getMinecraft().getSoundHandler();
			ISound sit = PositionedSoundRecord.getMasterRecord(SoundInit.SIT, 1F);
			handler.playSound(sit);
			
			if (Minecraft.getMinecraft().currentScreen instanceof GuiPhoneCalling)
			{
				GuiPhoneCalling calling = (GuiPhoneCalling)Minecraft.getMinecraft().currentScreen;
				if (!calling.getCurrentPhoneNumber().equals(fromNumber))
				{
					return;
				}
				
				GuiCallEnd end = new GuiCallEnd(calling.getPhoneStack(), calling.getHand(), toNumber);
				end.setMessage("No such number!");
				Minecraft.getMinecraft().displayGuiScreen(end);
			}
		}
	
		public static void onCallNoReception(String fromNumber, String toNumber)
		{
			if (Minecraft.getMinecraft().currentScreen instanceof GuiPhoneCalling)
			{
				GuiPhoneCalling calling = (GuiPhoneCalling)Minecraft.getMinecraft().currentScreen;
				if (!calling.getCurrentPhoneNumber().equals(fromNumber))
				{
					return;
				}
				
				GuiCallEnd end = new GuiCallEnd(calling.getPhoneStack(), calling.getHand(), toNumber);
				end.setMessage("No reception!");
				Minecraft.getMinecraft().displayGuiScreen(end);
			}
		}
		
		public static void onPhoneQueryResponsePacket(String forNumber, ResponseTypes responseType, String otherNumber)
		{
			if (responseType == ResponseTypes.callConnecting)
			{
				playOutgoingCallSound(forNumber);
			}
			else if (responseType == ResponseTypes.callIncoming)
			{
				playIncomingCallSound(forNumber);
			}
			
			Minecraft mc = Minecraft.getMinecraft();
			if (!(mc.currentScreen instanceof GuiEmptyPhone))
			{
				return;
			}
			
			GuiEmptyPhone currentGui = (GuiEmptyPhone)mc.currentScreen;
			String currentPhone = currentGui.getPhoneNumber();
			if (!currentPhone.equals(forNumber))
			{
				return;
			}
			
			if (responseType == ResponseTypes.idle)
			{
				mc.displayGuiScreen(new GuiHome(currentGui.getPhoneStack(), currentGui.getHand()));
			}
			else if (responseType == ResponseTypes.callConnecting)
			{
				mc.displayGuiScreen(new GuiPhoneCalling(currentGui.getPhoneStack(), currentGui.getHand(), otherNumber));
			}
			else if (responseType == ResponseTypes.callIncoming)
			{
				mc.displayGuiScreen(new GuiIncomingCall(currentGui.getPhoneStack(), currentGui.getHand(), otherNumber));
			}
			else if (responseType == ResponseTypes.callConnected) 
			{
				mc.displayGuiScreen(new GuiPhoneConnected(currentGui.getPhoneStack(), currentGui.getHand(), otherNumber));
			}
		}
	
		public static void onCallDisconnected(String forNumber, String toNumber)
		{
			Minecraft mc = Minecraft.getMinecraft();
			
			ISound incomingCallSound = incomingCallSoundsByPhone.get(forNumber);
			if (incomingCallSound != null && mc.getSoundHandler().isSoundPlaying(incomingCallSound))
			{
				mc.getSoundHandler().stopSound(incomingCallSound);
				incomingCallSoundsByPhone.remove(forNumber);
			}

			ISound outgoingCall = outgoingCallsByPhone.get(forNumber);
			if (outgoingCall != null && mc.getSoundHandler().isSoundPlaying(outgoingCall))
			{
				mc.getSoundHandler().stopSound(outgoingCall);
				outgoingCallsByPhone.remove(forNumber);
			}
			
			PositionedSoundRecord startSound = PositionedSoundRecord.getMasterRecord(SoundInit.ENDCALL, 1F);
			mc.getSoundHandler().playSound(startSound);

			if (mc.currentScreen instanceof GuiIncomingCall)
			{
				GuiIncomingCall incomingScreen = (GuiIncomingCall)mc.currentScreen;
				if (incomingScreen.getCurrentPhoneNumber().equals(forNumber))
				{
					mc.displayGuiScreen(new GuiHome(incomingScreen.getPhoneStack(), incomingScreen.getHand()));
				}
			}
			else if (mc.currentScreen instanceof GuiPhoneCalling || mc.currentScreen instanceof GuiPhoneConnected)
			{
				GuiPhoneBase callingScreen = (GuiPhoneBase)mc.currentScreen;
				if (!callingScreen.getCurrentPhoneNumber().equals(forNumber))
				{
					return;
				}
				
				mc.displayGuiScreen(new GuiCallEnd(callingScreen.getPhoneStack(), callingScreen.getHand(), toNumber));
			}
			
			mc.player.sendMessage(new TextComponentString("Phone call with " + GuiPhoneBase.getFormattedPhoneNumber(toNumber) + " has been disconnected"));
		}
	
		public static HashMap<String, LocalDateTime> callStartsByPhone = new HashMap<>();
		public static void onCallConnected(String forNumber, String toNumber)
		{
			Minecraft mc = Minecraft.getMinecraft();
			
			callStartsByPhone.put(forNumber, LocalDateTime.now());
			
			ISound incomingCallSound = incomingCallSoundsByPhone.get(forNumber);
			if (incomingCallSound != null && mc.getSoundHandler().isSoundPlaying(incomingCallSound))
			{
				mc.getSoundHandler().stopSound(incomingCallSound);
				incomingCallSoundsByPhone.remove(forNumber);
			}

			ISound outgoingCall = outgoingCallsByPhone.get(forNumber);
			if (outgoingCall != null && mc.getSoundHandler().isSoundPlaying(outgoingCall))
			{
				mc.getSoundHandler().stopSound(outgoingCall);
				outgoingCallsByPhone.remove(forNumber);
			}
			
			mc.player.sendMessage(new TextComponentString("You are now connected to " + GuiPhoneBase.getFormattedPhoneNumber(toNumber)));
			
			if (mc.currentScreen instanceof GuiPhoneCalling || mc.currentScreen instanceof GuiIncomingCall)
			{
				GuiPhoneBase phoneBase = (GuiPhoneBase)mc.currentScreen;
				if (!phoneBase.getCurrentPhoneNumber().equals(forNumber))
				{
					return;
				}
				
				GuiPhoneConnected connected = new GuiPhoneConnected(phoneBase.getPhoneStack(), phoneBase.getHand(), toNumber);
				mc.displayGuiScreen(connected);
			}
		}
		
		public static void onCallRejected(String forNumber, String toNumber)
		{
			Minecraft mc = Minecraft.getMinecraft();
			
			ISound incomingCallSound = incomingCallSoundsByPhone.get(toNumber);
			if (incomingCallSound != null && mc.getSoundHandler().isSoundPlaying(incomingCallSound))
			{
				mc.getSoundHandler().stopSound(incomingCallSound);
				incomingCallSoundsByPhone.remove(toNumber);
			}

			ISound outgoingCall = outgoingCallsByPhone.get(forNumber);
			if (outgoingCall != null && mc.getSoundHandler().isSoundPlaying(outgoingCall))
			{
				mc.getSoundHandler().stopSound(outgoingCall);
				outgoingCallsByPhone.remove(forNumber);
			}
			
			boolean displayRejectedMessage = true;
			if (mc.currentScreen instanceof GuiIncomingCall)
			{
				GuiIncomingCall incomingScreen = (GuiIncomingCall)mc.currentScreen;
				if (incomingScreen.getCurrentPhoneNumber().equals(toNumber))
				{
					mc.displayGuiScreen(new GuiHome(incomingScreen.getPhoneStack(), incomingScreen.getHand()));
					displayRejectedMessage = false;
				}
			}
			else if (mc.currentScreen instanceof GuiPhoneCalling || mc.currentScreen instanceof GuiPhoneConnected)
			{
				PositionedSoundRecord startSound = PositionedSoundRecord.getMasterRecord(SoundInit.ENDCALL, 1F);
				mc.getSoundHandler().playSound(startSound);
				
				GuiPhoneBase callingScreen = (GuiPhoneBase)mc.currentScreen;
				if (callingScreen.getCurrentPhoneNumber().equals(forNumber))
				{
					mc.displayGuiScreen(new GuiCallEnd(callingScreen.getPhoneStack(), callingScreen.getHand(), toNumber));
					displayRejectedMessage = false;
				}
			}
			
			if (displayRejectedMessage)
			{
				mc.player.sendMessage(new TextComponentString("Phone call attempt with " + GuiPhoneBase.getFormattedPhoneNumber(toNumber) + " was rejected"));
			}
		}
	
		public static void onPhoneToss(String number)
		{
			Minecraft mc = Minecraft.getMinecraft();
			
			ISound sound = incomingCallSoundsByPhone.get(number);
			if (sound != null)
			{
				mc.getSoundHandler().stopSound(sound);
			}
			
			sound = outgoingCallsByPhone.get(number);
			if (sound != null)
			{
				mc.getSoundHandler().stopSound(sound);
			}
			
			callStartsByPhone.remove(number);
		}
	}
}
