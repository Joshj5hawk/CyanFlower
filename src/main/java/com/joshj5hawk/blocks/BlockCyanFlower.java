package com.joshj5hawk.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.joshj5hawk.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCyanFlower extends Block implements IPlantable
{
	
	private IIcon[] icon;

	public BlockCyanFlower() 
	{
		super(Material.plants);
		this.setTickRandomly(true);
		float f = 0.2F;
		this.setBlockBounds(0.5F -f, 0.0F, 0.5F - f, 0.5F + f, f*3.0F, 0.5F + f);
	}
	
   public boolean canPlaceBlockAt(World world, int x, int y, int z)
   {
       return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
   }
   
   protected boolean canPlaceBlockOn(Block block)
   {
       return block == Blocks.grass || block == Blocks.dirt || block == Blocks.farmland;
   }

   public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
   {
       super.onNeighborBlockChange(world, x, y, z, block);
       this.checkAndDropBlock(world, x, y, z);
   }
   
   public void updateTick(World world, int x, int y, int z, Random random)
   {
       this.checkAndDropBlock(world, x, y, z);
   }
   
   protected void checkAndDropBlock(World world, int x, int y, int z)
   {
       if (!this.canBlockStay(world, x, y, z))
       {
           this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
           world.setBlock(x, y, z, getBlockById(0), 0, 2);
       }
   }

   public boolean canBlockStay(World world, int x, int y, int z)
   {
       return  world.getBlock(x, y - 1, z).canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);
   }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(Strings.modid + ":iconCyanFlower");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return this.blockIcon;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return 1;
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
	return null;
	}


	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) 
	{
		return EnumPlantType.Plains;
	}


	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) 
	{
		return null;
	}


	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) 
	{
		return 0;
	}
}
