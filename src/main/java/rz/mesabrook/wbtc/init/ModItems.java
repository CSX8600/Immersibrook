package rz.mesabrook.wbtc.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import rz.mesabrook.wbtc.Main;
import rz.mesabrook.wbtc.items.armor.Hardhat;
import rz.mesabrook.wbtc.items.armor.FaceMasks;
import rz.mesabrook.wbtc.items.armor.NightVisionGoggles;
import rz.mesabrook.wbtc.items.armor.SafetyVest;
import rz.mesabrook.wbtc.items.misc.*;
import rz.mesabrook.wbtc.items.record.MemeRecord;
import rz.mesabrook.wbtc.items.tools.ItemBanHammer;
import rz.mesabrook.wbtc.items.weapons.ItemWeapon;
import rz.mesabrook.wbtc.util.ArmorMaterialRegistry;
import rz.mesabrook.wbtc.util.ToolMaterialRegistry;

public class ModItems 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();

	// Weapons uwu
	public static final Item WOOD_SOD = new ItemWeapon("wood_sod", ToolMaterialRegistry.SOD_WOOD);
	public static final Item STONE_SOD = new ItemWeapon("stone_sod", ToolMaterialRegistry.SOD_STONE);
	public static final Item IRON_SOD = new ItemWeapon("iron_sod", ToolMaterialRegistry.SOD_IRON);
	public static final Item GOLD_SOD = new ItemWeapon("gold_sod", ToolMaterialRegistry.SOD_GOLD);
	public static final Item DIAMOND_SOD = new ItemWeapon("diamond_sod", ToolMaterialRegistry.SOD_DIAMOND);
	public static final Item ALUMINUM_SOD = new ItemWeapon("aluminum_sod", ToolMaterialRegistry.SOD_ALUMINUM);
	public static final Item ALUMINUM_SWORD = new ItemWeapon("aluminum_sword", ToolMaterialRegistry.SWORD_ALUMINUM);

	// Toys
	public static final Item POPPER_RED = new ToyPopper("popper_red", 300);
	public static final Item POPPER_GREEN = new ToyPopper("popper_green", 300);
	public static final Item POPPER_BLUE = new ToyPopper("popper_blue", 300);

	// Special Items
	public static final Item ZOE_CANE = new ItemWeapon("zoe_cane", ToolMaterialRegistry.ZOE_CANE_MAT);
	public static final Item LEVI_HAMMER = new ItemBanHammer("levi_hammer", ToolMaterialRegistry.LEVI_HAMMER_MAT);

	// Hammer Items
	public static final Item LEVI_HAMMER_HEAD = new ItemWeapon("hammer_head_levi", ToolMaterial.STONE);
	public static final Item LEVI_HAMMER_STICK = new ItemWeapon("hammer_stick_levi", ToolMaterial.WOOD);

	// Immersibrook Icons
	public static final Item IMMERSIBROOK_ICON = new ItemMesabrookIcon("icon_immersibrook");
	public static final Item DOOT_ICON = new MiscItem("doot_icon", 1);
	
	// Metals
	public static final Item IRON_ROD = new MiscItem("iron_rod", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	
	// Raw Plastic
	public static final Item RAW_PLASTIC = new MiscItem("raw_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);

	// Colored Raw Plastic
	public static final Item RAW_PLASTIC_WHITE = new ItemRawPlastic("raw_white_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_ORANGE = new ItemRawPlastic("raw_orange_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_MAGENTA = new ItemRawPlastic("raw_magenta_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_LBLUE = new ItemRawPlastic("raw_lblue_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_YELLOW = new ItemRawPlastic("raw_yellow_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_LIME = new ItemRawPlastic("raw_lime_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_PINK = new ItemRawPlastic("raw_pink_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_GRAY = new ItemRawPlastic("raw_gray_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_SILVER = new ItemRawPlastic("raw_silver_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_CYAN = new ItemRawPlastic("raw_cyan_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_PURPLE = new ItemRawPlastic("raw_purple_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_BLUE = new ItemRawPlastic("raw_blue_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_BROWN = new ItemRawPlastic("raw_brown_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_GREEN = new ItemRawPlastic("raw_green_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_RED = new ItemRawPlastic("raw_red_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_BLACK = new ItemRawPlastic("raw_black_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_PLASTIC_GLOWING = new ItemRawPlastic("raw_glowing_plastic", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);

	// Finalized Colored Plastic Ingots
	public static final Item PLASTIC_WHITE = new ItemPlasticIngot("white_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_ORANGE = new ItemPlasticIngot("orange_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_MAGENTA = new ItemPlasticIngot("magenta_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_LBLUE = new ItemPlasticIngot("lblue_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_YELLOW = new ItemPlasticIngot("yellow_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_LIME = new ItemPlasticIngot("lime_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_PINK = new ItemPlasticIngot("pink_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_GRAY = new ItemPlasticIngot("gray_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_SILVER = new ItemPlasticIngot("silver_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_CYAN = new ItemPlasticIngot("cyan_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_PURPLE = new ItemPlasticIngot("purple_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_BLUE = new ItemPlasticIngot("blue_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_BROWN = new ItemPlasticIngot("brown_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_GREEN = new ItemPlasticIngot("green_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_RED = new ItemPlasticIngot("red_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_BLACK = new ItemPlasticIngot("black_plastic",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PLASTIC_GLOWING = new ItemPlasticIngot("glowing_plastic", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	
	// Meme Records
	public static final Item BLANK_DISC = new MiscItem("blank_vinyl",  16).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item DISC_AMALTHEA = new MemeRecord("amalthea", SoundInit.AMALTHEA);
	public static final Item DISC_NYAN = new MemeRecord("nyan", SoundInit.NYAN);
	public static final Item DISC_USSR1 = new MemeRecord("ussr1", SoundInit.USSR1);
	public static final Item DISC_USSR2 = new MemeRecord("ussr2", SoundInit.USSR2);
	public static final Item DISC_BOOEY = new MemeRecord("baba_booey", SoundInit.BOOEY);
	public static final Item DISC_DOLAN = new MemeRecord("dolan", SoundInit.DOLAN);
	public static final Item DISC_MURICA = new MemeRecord("murica", SoundInit.MURICA);
	public static final Item DISC_PIGSTEP = new MemeRecord("pigstep", SoundInit.PIGSTEP);
	public static final Item DISC_KRAB_BORG = new MemeRecord("krab_borg", SoundInit.KRAB_BORG);
	public static final Item DISC_KRAB_BORG_FULL = new MemeRecord("krab_borg_full", SoundInit.KRAB_BORG_FULL);
	public static final Item DISC_FISH = new MemeRecord("fish_full", SoundInit.FISH_FULL);
	public static final Item DISC_XP = new MemeRecord("ms_xp", SoundInit.MS_XP);
	public static final Item DOOTER = new ItemDooter("dooter");

	// First Aid Kit
	public static final Item FIRST_AID_KIT = new ItemFirstAidKit("first_aid", Main.IMMERSIBROOK_MAIN);
	
	// Generic Safety Vests
	public static final Item SAFETY_VEST_ORANGE = new SafetyVest("safety_vest_orange", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.SAFETY_VEST_MATERIAL, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_YELLOW = new SafetyVest("safety_vest_yellow", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.SAFETY_VEST_YELLOW_MAT, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_ORANGE_NO_X = new SafetyVest("safety_vest_orange_no_x", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.SAFETY_VEST_ORANGE_NON_X_MAT, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_BLUE = new SafetyVest("safety_vest_blue", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.SAFETY_VEST_BLUE_MAT, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_YELLOW_X = new SafetyVest("safety_vest_yellow_x", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.SAFETY_VEST_YELLOW_WITH_X_MAT, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_TGES = new SafetyVest("tges_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.TGES_VEST, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_RED = new SafetyVest("red_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.RED_VEST, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_EMS = new SafetyVest("ems_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.EMS_VEST, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_WHITE = new SafetyVest("white_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.MAT_WHITE_VEST, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_MAGENTA = new SafetyVest("magenta_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.MAT_MAGENTA_VEST, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_LIME = new SafetyVest("lime_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.MAT_LIME_VEST, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_PINK = new SafetyVest("pink_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.MAT_PINK_VEST, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_GRAY = new SafetyVest("gray_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.MAT_GRAY_VEST, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_SILVER = new SafetyVest("silver_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.MAT_SILVER_VEST, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_CYAN = new SafetyVest("cyan_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.MAT_CYAN_VEST, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_PURPLE = new SafetyVest("purple_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.MAT_PURPLE_VEST, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_BROWN = new SafetyVest("brown_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.MAT_BROWN_VEST, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_GREEN = new SafetyVest("green_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.MAT_GREEN_VEST, EntityEquipmentSlot.CHEST);
	public static final Item SAFETY_VEST_BLACK = new SafetyVest("black_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.MAT_BLACK_VEST, EntityEquipmentSlot.CHEST);

	// IRW Vest
	public static final Item IRW_VEST = new SafetyVest("irw_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.IRW_SAFETY_VEST_MAT, EntityEquipmentSlot.CHEST);
	
	// LVN Safety Vests
	public static final Item LVN_VEST = new SafetyVest("lvn_vest", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.LVN_SAFETY_VEST_NO_X, EntityEquipmentSlot.CHEST);
	public static final Item LVN_VEST_X = new SafetyVest("lvn_vest_x", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.LVN_SAFETY_VEST_X, EntityEquipmentSlot.CHEST);
	public static final Item LVN_VEST_TXT = new SafetyVest("lvn_vest_txt", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.LVN_SAFETY_VEST_TXT, EntityEquipmentSlot.CHEST);
	
	// Night Vision Goggles
	public static final Item NV_GOGGLES = new NightVisionGoggles("nv_goggles", Main.IMMERSIBROOK_MAIN, ArmorMaterialRegistry.NIGHT_VISION_HELMET, EntityEquipmentSlot.HEAD);

	// Night vision goggles crafting ingredients.
	public static final Item NV_LENS = new MiscItem("nv_lens", 16).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item NV_BODY = new MiscItem("nv_goggle_body", 16).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item NV_INTERNALS = new MiscItem("nv_goggle_circuits", 16).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item NV_STRAPS = new MiscItem("nv_goggle_strap", 16).setCreativeTab(Main.IMMERSIBROOK_MAIN);

	// Hard Hats
	public static final Item HARDHAT_YELLOW = new Hardhat("hh_yellow", ArmorMaterialRegistry.HH_YELLOW, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_WHITE = new Hardhat("hh_white", ArmorMaterialRegistry.HH_WHITE, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_ORANGE = new Hardhat("hh_orange", ArmorMaterialRegistry.HH_ORANGE, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_MAGENTA = new Hardhat("hh_magenta", ArmorMaterialRegistry.HH_MAGENTA, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_LBLUE = new Hardhat("hh_lblue", ArmorMaterialRegistry.HH_LBLUE, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_LIME = new Hardhat("hh_lime", ArmorMaterialRegistry.HH_LIME, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_PINK = new Hardhat("hh_pink", ArmorMaterialRegistry.HH_PINK, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_GRAY = new Hardhat("hh_gray", ArmorMaterialRegistry.HH_GRAY, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_SILVER = new Hardhat("hh_silver", ArmorMaterialRegistry.HH_SILVER, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_CYAN = new Hardhat("hh_cyan", ArmorMaterialRegistry.HH_CYAN, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_PURPLE = new Hardhat("hh_purple", ArmorMaterialRegistry.HH_PURPLE, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_BLUE = new Hardhat("hh_blue", ArmorMaterialRegistry.HH_BLUE, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_BROWN = new Hardhat("hh_brown", ArmorMaterialRegistry.HH_BROWN, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_GREEN = new Hardhat("hh_green", ArmorMaterialRegistry.HH_GREEN, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_RED = new Hardhat("hh_red", ArmorMaterialRegistry.HH_RED, EntityEquipmentSlot.HEAD);
	public static final Item HARDHAT_BLACK = new Hardhat("hh_black", ArmorMaterialRegistry.HH_BLACK, EntityEquipmentSlot.HEAD);

	// Misc Items
	public static final Item PAPER_STICK = new MiscItem("paper_stick", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item WINE_BOTTLE = new ItemWineBottle("wine_bottle");

	// Foods
	public static final Item CANDY_RUBY = new ImmersiFood("ruby_red_candy", 16, 0,8, 10, false);
	public static final Item CANDY_LIME = new ImmersiFood("lime_candy", 16, 0,8, 10, false);
	public static final Item CANDY_BLUE = new ImmersiFood("blue_candy", 16, 0,8, 10, false);
	public static final Item CANDY_ORANGE = new ImmersiFood("orange_candy", 16, 0,8, 10, false);
	public static final Item CANDY_GRAPE = new ImmersiFood("grape_candy", 16, 0,8, 10, false);
	public static final Item CANDY_ROOT_BEER = new ImmersiFood("rb_candy", 16, 0,8, 10, false);
	public static final Item CANDY_CHOCOLATE = new ImmersiFood("choc_candy", 16, 0,8, 10, false);
	public static final Item CANDY_PINK_LEMONADE = new ImmersiFood("pl_candy", 16, 0,8, 10, false);
	public static final Item PINK_LEMONADE_DRINK = new ImmersiFood("pink_lemonade_drink", 1, 0, 5, 10, false);
	public static final Item SPARKLING_PINK_LEMONADE = new ImmersiFood("sparkling_pink_lemonade", 1, 0, 10, 12, false);
	public static final Item RAW_CANDY_RED = new MiscItem("raw_candy_red", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_CANDY_LIME = new MiscItem("raw_candy_lime", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_CANDY_BLUE = new MiscItem("raw_candy_blue", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_CANDY_ORANGE = new MiscItem("raw_candy_orange",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_CANDY_GRAPE = new MiscItem("raw_candy_grape",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_CANDY_RB = new MiscItem("raw_candy_rb",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_CANDY_CHOC = new MiscItem("raw_candy_choc",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item RAW_CANDY_PL = new MiscItem("raw_candy_pl",  64).setCreativeTab(Main.IMMERSIBROOK_MAIN);

	public static final Item LOLIPOP_GREEN = new ImmersiFood("green_lollipop", 32,0, 5, 10, false);
	public static final Item LOLIPOP_ORANGE = new ImmersiFood("orange_lollipop", 32,0, 5, 10, false);
	public static final Item LOLIPOP_RED = new ImmersiFood("red_lollipop", 32,0, 5, 10, false);
	public static final Item LOLIPOP_RB = new ImmersiFood("root_beer_lollipop", 32,0, 5, 10, false);
	public static final Item LOLIPOP_BLUE = new ImmersiFood("blue_lollipop", 32,0, 5, 10, false);
	public static final Item LOLIPOP_PL = new ImmersiFood("pink_lemonade_lollipop", 32,0, 5, 10, false);
	public static final Item LOLIPOP_CHOC = new ImmersiFood("chocolate_lollipop", 32,0, 5, 10, false);
	public static final Item LOLIPOP_GRAPE = new ImmersiFood("grape_lollipop", 32,0, 5, 10, false);
	public static final Item CANDY_CORN = new ImmersiFood("candy_corn", 64,0, 3, 10, false);
	public static final Item RAVEN_BAR = new DamageableFood("chocolate_bar_raven",64, 20, 3F,  false);
	public static final Item KLUSS_BAR = new DamageableFood("chocolate_bar_klussbar",64, 5, 3F,  false);
	public static final Item SERPENT_BAR = new SerpentBar("chocolate_bar_serpent",64, 1, 10F,  false);
	public static final Item STRAWBERRY_BAR = new DamageableFood("chocolate_bar_strawberry",64, 6, 10F,  false);
	public static final Item NUT_BAR = new DamageableFood("chocolate_bar_nut", 64, 6, 10F, false);
	public static final Item KRISP_BAR = new DamageableFood("chocolate_bar_krisp", 64, 4, 10F, false);

	// Decorative Wearables
	public static final Item MASK_JASON = new FaceMasks("mask_jason", ArmorMaterialRegistry.MASK_JASON, EntityEquipmentSlot.HEAD);
	public static final Item MASK_SKELETON = new FaceMasks("mask_skeleton", ArmorMaterialRegistry.MASK_SKELETON, EntityEquipmentSlot.HEAD);
	public static final Item MASK_MEDICAL = new FaceMasks("mask_medical", ArmorMaterialRegistry.MASK_MEDICAL, EntityEquipmentSlot.HEAD);
	public static final Item MASK_SLIME = new FaceMasks("mask_slime", ArmorMaterialRegistry.MASK_SLIME, EntityEquipmentSlot.HEAD);

	// Food Crafting Items
	public static final Item DYE_RED = new MiscItem("dye_red", 16).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item DYE_GREEN = new MiscItem("dye_green", 16).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item DYE_BLUE = new MiscItem("dye_blue", 16).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item DYE_WHITE = new MiscItem("dye_white", 16).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item DYE_YELLOW = new MiscItem("dye_yellow", 16).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item SUGAR_ORANGE = new MiscItem("sugar_orange", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item SUGAR_RED = new MiscItem("sugar_red", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item SUGAR_GREEN = new MiscItem("sugar_green", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item SUGAR_BLUE = new MiscItem("sugar_blue", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item SUGAR_PURPLE = new MiscItem("sugar_purple", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item SUGAR_BROWN = new MiscItem("sugar_brown", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item SUGAR_LIME = new MiscItem("sugar_lime", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item SUGAR_PINK = new MiscItem("sugar_pink", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item SUGAR_YELLOW = new MiscItem("sugar_yellow", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);

	// Holiday Records
	public static final Item DISC_SPOOKY = new MemeRecord("disc_spooky", SoundInit.SPOOKY);
	public static final Item DISC_RITZ = new MemeRecord("disc_ritz", SoundInit.RITZ);
	public static final Item DISC_HL3 = new MemeRecord("disc_pumpkin", SoundInit.HL3);

	// Communications
	public static final Item RADIO = new MiscItem("radio", 1).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PHONE_BLUE = new MiscItem("smartphone_blue", 1).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PHONE_LIME = new MiscItem("smartphone_lime", 1).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PHONE_MAGENTA = new MiscItem("smartphone_magenta", 1).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PHONE_ORANGE = new MiscItem("smartphone_orange", 1).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PHONE_SILVER = new MiscItem("smartphone_silver", 1).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PHONE_SPECIAL = new MiscItem("smartphone_special", 1).setCreativeTab(Main.IMMERSIBROOK_MAIN);
	public static final Item PHONE_WHITE = new MiscItem("smartphone_white", 1).setCreativeTab(Main.IMMERSIBROOK_MAIN);

	// Cardboard and Boxes
	public static final Item CARDBOARD_PIECE = new MiscItem("cardboard_piece", 64).setCreativeTab(Main.IMMERSIBROOK_MAIN);
}
