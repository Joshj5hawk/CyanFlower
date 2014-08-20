package com.joshj5hawk.main;

import com.joshj5hawk.lib.Strings;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Strings.modid, version = Strings.version)
public class CyanFlower 
{
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preInit)
	{
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent init)
	{
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postInit)
	{
		System.out.println("Cyan Flower" + Strings.version + "Loaded");
	}
}
