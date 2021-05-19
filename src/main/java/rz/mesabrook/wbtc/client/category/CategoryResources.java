package rz.mesabrook.wbtc.client.category;

import net.minecraft.item.ItemStack;
import rz.mesabrook.wbtc.init.ModBlocks;
import rz.mesabrook.wbtc.init.ModItems;

/**
 * Original Author: MrCrayfish
 * Adapted by RavenholmZombie for use in Immersibrook.
 * 
 * https://github.com/MrCrayfish
 * https://github.com/RavenholmZombie
 */
public class CategoryResources extends AbstractCategory 
{
	public CategoryResources()
	{
		super("im.filter.resources", new ItemStack(ModItems.ALUMINUM_INGOT));
	}
	
	@Override
	public void init() 
	{
		// Aluminum
		add(ModBlocks.ALUMINUM_ORE);
		add(ModBlocks.CUBE_ALUMINUM);
		add(ModItems.ALUMINUM_DUST);
		add(ModItems.ALUMINUM_INGOT);
		add(ModItems.ALUMINUM_NUGGET);
		add(ModItems.ALUMINUM_ROD);
		
		// Raw Plastics
		add(ModItems.RAW_PLASTIC);
		add(ModItems.RAW_PLASTIC_WHITE);
		add(ModItems.RAW_PLASTIC_ORANGE);
		add(ModItems.RAW_PLASTIC_MAGENTA);
		add(ModItems.RAW_PLASTIC_LBLUE);
		add(ModItems.RAW_PLASTIC_YELLOW);
		add(ModItems.RAW_PLASTIC_LIME);
		add(ModItems.RAW_PLASTIC_PINK);
		add(ModItems.RAW_PLASTIC_GRAY);
		add(ModItems.RAW_PLASTIC_SILVER);
		add(ModItems.RAW_PLASTIC_CYAN);
		add(ModItems.RAW_PLASTIC_PURPLE);
		add(ModItems.RAW_PLASTIC_BLUE);
		add(ModItems.RAW_PLASTIC_BROWN);
		add(ModItems.RAW_PLASTIC_GREEN);
		add(ModItems.RAW_PLASTIC_RED);
		add(ModItems.RAW_PLASTIC_BLACK);
		add(ModItems.RAW_PLASTIC_GLOWING);
		
		// Plastic Ingots
		add(ModItems.PLASTIC_WHITE);
		add(ModItems.PLASTIC_ORANGE);
		add(ModItems.PLASTIC_MAGENTA);
		add(ModItems.PLASTIC_LBLUE);
		add(ModItems.PLASTIC_YELLOW);
		add(ModItems.PLASTIC_LIME);
		add(ModItems.PLASTIC_PINK);
		add(ModItems.PLASTIC_GRAY);
		add(ModItems.PLASTIC_SILVER);
		add(ModItems.PLASTIC_CYAN);
		add(ModItems.PLASTIC_PURPLE);
		add(ModItems.PLASTIC_BLUE);
		add(ModItems.PLASTIC_BROWN);
		add(ModItems.PLASTIC_GREEN);
		add(ModItems.PLASTIC_RED);
		add(ModItems.PLASTIC_BLACK);
		add(ModItems.PLASTIC_GLOWING);
		
		// Plastic Blocks
		add(ModBlocks.PLASTIC_CUBE_WHITE);
		add(ModBlocks.PLASTIC_CUBE_ORANGE);
		add(ModBlocks.PLASTIC_CUBE_MAGENTA);
		add(ModBlocks.PLASTIC_CUBE_LBLUE);
		add(ModBlocks.PLASTIC_CUBE_YELLOW);
		add(ModBlocks.PLASTIC_CUBE_LIME);
		add(ModBlocks.PLASTIC_CUBE_PINK);
		add(ModBlocks.PLASTIC_CUBE_GRAY);
		add(ModBlocks.PLASTIC_CUBE_SILVER);
		add(ModBlocks.PLASTIC_CUBE_CYAN);
		add(ModBlocks.PLASTIC_CUBE_PURPLE);
		add(ModBlocks.PLASTIC_CUBE_BLUE);
		add(ModBlocks.PLASTIC_CUBE_BROWN);
		add(ModBlocks.PLASTIC_CUBE_GREEN);
		add(ModBlocks.PLASTIC_CUBE_RED);
		add(ModBlocks.PLASTIC_CUBE_BLACK);
		add(ModBlocks.PLASTIC_CUBE_GLOWING);
	}

}