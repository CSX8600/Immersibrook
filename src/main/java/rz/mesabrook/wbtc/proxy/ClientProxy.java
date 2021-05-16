package rz.mesabrook.wbtc.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rz.mesabrook.wbtc.blocks.te.TileEntityPlaque;
import rz.mesabrook.wbtc.blocks.te.TileEntityPlaqueRenderer;
import rz.mesabrook.wbtc.util.handlers.CreativeGuiDrawHandler;

public class ClientProxy extends CommonProxy
{
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
		
	}
	
	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlaque.class, new TileEntityPlaqueRenderer());
	}
}
