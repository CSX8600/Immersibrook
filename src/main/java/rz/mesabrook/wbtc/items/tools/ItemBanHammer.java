package rz.mesabrook.wbtc.items.tools;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rz.mesabrook.wbtc.Main;
import rz.mesabrook.wbtc.init.ModItems;
import rz.mesabrook.wbtc.net.PlaySoundPacket;
import rz.mesabrook.wbtc.util.DamageSourceHammer;
import rz.mesabrook.wbtc.util.IHasModel;
import rz.mesabrook.wbtc.util.SoundRandomizer;
import rz.mesabrook.wbtc.util.ToolMaterialRegistry;
import rz.mesabrook.wbtc.util.handlers.PacketHandler;

import javax.annotation.Nullable;
import java.util.List;

public class ItemBanHammer extends ItemPickaxe implements IHasModel
{
    public static final DamageSource HAMMER_GO_BONK = new DamageSourceHammer("hammer");
    private final TextComponentTranslation hammerShift = new TextComponentTranslation("im.hammer.shift");
    private final TextComponentTranslation noSound = new TextComponentTranslation("im.hammer.nosound");
    private final TextComponentTranslation currentSnd = new TextComponentTranslation("im.hammer.currentsnd");
    public ItemBanHammer(String name, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.IMMERSIBROOK_MAIN);
        hammerShift.getStyle().setColor(TextFormatting.BLUE);
        noSound.getStyle().setColor(TextFormatting.RED);
        currentSnd.getStyle().setColor(TextFormatting.GREEN);

        ModItems.ITEMS.add(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag)
    {
        NBTTagCompound tag = stack.getTagCompound();
        if(tag == null)
        {
            tooltip.add(noSound.getFormattedText());
        }
        else
        {
            if(tag.hasKey("sndID"))
            {
                tooltip.add(currentSnd.getFormattedText());
                tooltip.add(TextFormatting.AQUA + tag.getString("sndID"));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        if(stack.hasTagCompound())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        NBTTagCompound tag = stack.getTagCompound(); 
        String sndEvnt;
        if(stack.getItem() instanceof ItemBanHammer)
        {
            try
            {
                World worldIn = player.world;
                if(!worldIn.isRemote)
                {
                    if(tag != null)
                    {
                        if(tag.hasKey("sndID"))
                        {
                            PlaySoundPacket packet = new PlaySoundPacket();
                            packet.pos = player.getPosition();
                            packet.soundName = tag.getString("sndID");
                            PacketHandler.INSTANCE.sendToAllAround(packet, new NetworkRegistry.TargetPoint(entity.dimension, entity.posX, entity.posY, entity.posZ, 25));
                            entity.setFire(100);
                        }
                    }

                    if(entity instanceof EntityPlayer)
                    {
                        EntityPlayer target = (EntityPlayer) entity;
                        if(!target.isCreative())
                        {
                            entity.attackEntityFrom(HAMMER_GO_BONK, (int) ToolMaterialRegistry.LEVI_HAMMER_MAT.getAttackDamage());
                        }
                    }
                }
            }
            catch(Exception ex)
            {
                System.out.println(ex);
                return false;
            }
        }
        else
        {
            return false;
        }
        return false;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack item = player.getHeldItem(hand);
        SoundRandomizer.HammerRightClickRandomizer();
        if(item.getItem() == ModItems.LEVI_HAMMER || item.getItem() == ModItems.GMOD_HAMMER)
        {
            if(!world.isRemote)
            {
                PlaySoundPacket packet = new PlaySoundPacket();
                packet.pos = player.getPosition();
                packet.soundName = SoundRandomizer.hammerRightClick;
                PacketHandler.INSTANCE.sendToAllAround(packet, new NetworkRegistry.TargetPoint(player.dimension, player.posX, player.posY, player.posZ, 25));
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
            }
        }
        else
        {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, item);
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, item);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
