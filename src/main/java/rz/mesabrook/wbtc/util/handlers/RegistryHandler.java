package rz.mesabrook.wbtc.util.handlers;

import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import rz.mesabrook.wbtc.Main;
import rz.mesabrook.wbtc.cmds.CommandTeleportDimension;
import rz.mesabrook.wbtc.init.ModBlocks;
import rz.mesabrook.wbtc.init.ModItems;
import rz.mesabrook.wbtc.util.IHasModel;
import rz.mesabrook.wbtc.util.Reference;
import rz.mesabrook.wbtc.util.TooltipRandomizer;
import rz.mesabrook.wbtc.util.config.ModConfig;
import rz.mesabrook.wbtc.util.recipe.SmeltingRecipes;
import rz.mesabrook.wbtc.world.generation.WorldGenWBTCOres;

@EventBusSubscriber
public class RegistryHandler 
{	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
		OreDictRegistry.addToOD();
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		FuckingTileEntityHandler.registerTileEntites();
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	
	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		Main.logger.info("[Immersibrook] Version " + Reference.VERSION + " loading...");
        Main.IE_LOADED = Loader.isModLoaded("immersiveengineering");
        Main.JABCM_LOADED = Loader.isModLoaded("jabcm");
        Main.FURENIKUS_CITIES = Loader.isModLoaded("furenikuscities");
        
        if(Main.FURENIKUS_CITIES)
        {
        	Main.logger.warn("[" + Reference.MODNAME + "] Fureniku's Cities detected. There may be some overlap when it comes to blocks since both mods are meant for a similar purpose. We recommend using either Immersibrook or FC separately to avoid any potential conflicts.");
        }
		
		if(!Main.IE_LOADED)
		{
			Main.logger.info("Immersive Engineering NOT detected. Immersibrook Aluminum Ore gen enabled.");
			GameRegistry.registerWorldGenerator(new WorldGenWBTCOres(), 0);
		}
		else 
		{
			Main.logger.warn("Immersive Engineering detected. Immersibrook Aluminum Ore gen disabled. Use IE's ore instead.");
		}
		
		if(!Main.JABCM_LOADED)
		{
			Main.logger.info("Immersibrook goes great with the Just A Basic Concrete Mod!");
			Main.logger.info("Download it today! https://bit.ly/2NNXJL4");
		}
		else
		{
			Main.logger.info("Thank you for using JABCM!");
		}
		
		PacketHandler.registerMessages();
	}
	
	public static void initRegistries()
	{
		Main.logger.info("[" + Reference.MODNAME + "] Initialization");
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}
	
	public static void postInitRegistries(FMLPostInitializationEvent event)
	{
		Main.logger.info("[" + Reference.MODNAME + "] Post Initialization");
		
    	NonNullList<ItemStack> ironStick = OreDictionary.getOres("stickIron");
    	NonNullList<ItemStack> aluminumStick = OreDictionary.getOres("stickAluminum");
    	NonNullList<ItemStack> aluminumIngot = OreDictionary.getOres("ingotAluminum");
    	NonNullList<ItemStack> aluminumNug = OreDictionary.getOres("nuggetAluminum");
    	NonNullList<ItemStack> aluminumBlock = OreDictionary.getOres("blockAluminum");
    	NonNullList<ItemStack> aluminumOre = OreDictionary.getOres("oreAluminum");
    	NonNullList<ItemStack> aluminumDust = OreDictionary.getOres("dustAluminum");
    	NonNullList<ItemStack> rawPlastics = OreDictionary.getOres("itemRawPlastic");
    	NonNullList<ItemStack> plastics = OreDictionary.getOres("itemPlastic");
    	NonNullList<ItemStack> dairy = OreDictionary.getOres("blockCheese");
    	
    	Main.logger.info("[" + Reference.MODNAME + "] Checking to ensure our items are in the OD " + ironStick + aluminumStick + aluminumIngot + aluminumNug + aluminumBlock + aluminumOre + aluminumDust + dairy);
		Main.logger.info("[" + Reference.MODNAME + "] Scanning for plastics..." + rawPlastics + plastics);
    	TooltipRandomizer.ChosenTooltip();
		
    	SmeltingRecipes.registerSmeltingRecipes();
    	
    	Main.logger.info("[Immersibrook] Version " + Reference.VERSION + " loaded.");
	}
	
	public static void serverRegistries(FMLServerStartingEvent event)
	{
		if(ModConfig.tpdimCommand)
		{
			Main.logger.info("[" + Reference.MODNAME + "] Registering Teleport Command");
			event.registerServerCommand(new CommandTeleportDimension());
		}
		else
		{
			Main.logger.info("[" + Reference.MODNAME + "] /tpdim command has been disabled in the config.");
		}
	}
}
