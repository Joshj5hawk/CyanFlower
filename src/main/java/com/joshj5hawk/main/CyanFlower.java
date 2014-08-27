package com.joshj5hawk.main;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.gen.feature.WorldGenFlowers;

import com.joshj5hawk.blocks.BlockCyanFlower;
import com.joshj5hawk.handler.CFWorldGen;
import com.joshj5hawk.lib.Strings;
import com.joshj5hawk.recipes.CFCrafting;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Strings.modid, version = Strings.version)
public class CyanFlower 
{
	public static Block blockCyanFlower;
	
	CFWorldGen eventWorldGen = new CFWorldGen();
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preInit)
	{
		blockCyanFlower = new BlockCyanFlower().setBlockName("blockCyanFlower").setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName(Strings.modid + "iconCyanFlower");
		
		GameRegistry.registerBlock(blockCyanFlower, "blockCyanFlower");
		//Spawning
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent init)
	{
		CFCrafting.mainRegistry();
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postInit)
	{
		System.out.println("Cyan Flower-" + Strings.version + " Loaded");
	}
}
