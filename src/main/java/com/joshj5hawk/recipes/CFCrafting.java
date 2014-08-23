package com.joshj5hawk.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.joshj5hawk.main.CyanFlower;

import cpw.mods.fml.common.registry.GameRegistry;

public class CFCrafting 
{

	public static void mainRegistry()
	{
		shapedRecipes();
		shapelessRecipes();
	}

	public static void shapelessRecipes() 
	{
		GameRegistry.addRecipe(new ItemStack(Items.dye, 2, 6), new Object[]{"X", 'X', CyanFlower.blockCyanFlower});
	}

	public static void shapedRecipes() 
	{
		
	}
}
