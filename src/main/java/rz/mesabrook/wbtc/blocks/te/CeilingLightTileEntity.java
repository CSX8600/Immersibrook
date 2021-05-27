package rz.mesabrook.wbtc.blocks.te;

import rz.mesabrook.wbtc.blocks.BlockCeilingLight;
import rz.mesabrook.wbtc.init.ModBlocks;
import rz.mesabrook.wbtc.blocks.BlockFakeLight;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CeilingLightTileEntity extends TileEntity
{
    private int[] blockPos1 = new int[] { 0, -1, 0 };
    private int[] blockPos2 = new int[] { 0, -1, 0 };

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        blockPos1 = compound.getIntArray("blockPos1");
        blockPos2 = compound.getIntArray("blockPos2");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        compound.setIntArray("blockPos1", blockPos1);
        compound.setIntArray("blockPos2", blockPos2);

        return super.writeToNBT(compound);
    }

    @Override
    public void onLoad() {
        if (world.isRemote || isInvalid())
        {
            return;
        }

        IBlockState state = world.getBlockState(pos);

        if (state.getBlock() == ModBlocks.CEILING_LIGHT_TEST)
        {
            addLightSources();
        }
    }

    private void setBlockPosArray(BlockPos pos)
    {
        if (blockPos1[1] == -1)
        {
            blockPos1 = new int[] { pos.getX(), pos.getY(), pos.getZ() };
        }
        else
        {
            blockPos2 = new int[] { pos.getX(), pos.getY(), pos.getZ() };
        }
    }

    private void tryPlaceLightSource(BlockPos pos)
    {
        IBlockState proposedBlockState = world.getBlockState(pos);

        if (proposedBlockState.getBlock() != Blocks.AIR)
        {
            pos = pos.up();
            proposedBlockState = world.getBlockState(pos);

            if (proposedBlockState.getBlock() != Blocks.AIR)
            {
                proposedBlockState = null;
            }
        }

        if (proposedBlockState != null)
        {
            world.setBlockState(pos, ModBlocks.FAKE_LIGHT_SOURCE.getDefaultState());
            setBlockPosArray(pos);
        }
    }

    public void removeLightSources()
    {
        BlockPos pos1 = getBlockPos(1);

        if (pos1 != null)
        {
            IBlockState state1 = world.getBlockState(pos1);
            if (state1.getBlock() instanceof BlockFakeLight)
            {
                world.setBlockState(pos1, Blocks.AIR.getDefaultState());
            }
        }

        BlockPos pos2 = getBlockPos(2);

        if (pos2 != null)
        {
            IBlockState state2 = world.getBlockState(pos2);
            if (state2.getBlock() instanceof BlockFakeLight)
            {
                world.setBlockState(pos2, Blocks.AIR.getDefaultState());
            }
        }
    }

    private BlockPos getBlockPos(int index)
    {
        switch(index)
        {
            case 1:
                if (blockPos1[1] != -1)
                {
                    return new BlockPos(blockPos1[0], blockPos1[1], blockPos1[2]);
                }
            case 2:
                if (blockPos2[1] != -1)
                {
                    return new BlockPos(blockPos2[0], blockPos2[1], blockPos2[2]);
                }
            default:
                return null;
        }
    }

    public void addLightSources()
    {
        IBlockState lampState = world.getBlockState(getPos());
        EnumFacing facing = lampState.getValue(BlockCeilingLight.FACING);

        BlockPos angle;
        switch(facing)
        {
            case NORTH:
                angle = getPos().south(2).west(2);
                tryPlaceLightSource(angle);
                angle = angle.east(4);
                tryPlaceLightSource(angle);
                break;
            case WEST:
                angle = getPos().east(2).north(2);
                tryPlaceLightSource(angle);
                angle = angle.south(4);
                tryPlaceLightSource(angle);
                break;
            case SOUTH:
                angle = getPos().north(2).west(2);
                tryPlaceLightSource(angle);
                angle = angle.east(4);
                tryPlaceLightSource(angle);
                break;
            case EAST:
                angle = getPos().west(2).north(2);
                tryPlaceLightSource(angle);
                angle = angle.south(4);
                tryPlaceLightSource(angle);
                break;
        }
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
        if (newSate.getBlock() instanceof BlockCeilingLight)
        {
            return false;
        }

        return super.shouldRefresh(world, pos, oldState, newSate);
    }
}
