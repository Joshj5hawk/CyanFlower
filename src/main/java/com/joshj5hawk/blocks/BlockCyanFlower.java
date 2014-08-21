package com.joshj5hawk.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.common.EnumPlantType.Plains;

import com.joshj5hawk.lib.Strings;
import com.joshj5hawk.main.CyanFlower;

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
	
	public boolean canPlaceBolckAt(World world, int x, int y, int z)
	{
		return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
	}
	
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		return world.getBlock(x, y -1 , z).canSustainPlant(world, x, y-1, z, ForgeDirection.UP, this);
	}
	
	protected boolean canPlaceBlockOn(Block block)
	{
		return block == Blocks.grass || block == Blocks.dirt || block == Blocks.farmland;
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

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) 
	{
		if (this == CyanFlower.blockCyanFlower)		return Plains;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}
}
