package com.blakebr0.mysticalagradditions.lib;

import java.io.File;

import com.blakebr0.mysticalagriculture.blocks.ModBlocks;
import com.blakebr0.mysticalagriculture.config.ModConfig;
import com.blakebr0.mysticalagriculture.crafting.EssenceRecipes;
import com.blakebr0.mysticalagriculture.crafting.ModRecipes;
import com.blakebr0.mysticalagriculture.items.ModItems;

import net.minecraft.item.ItemStack;

public class MAHelper {
	
	public static ModBlocks blocks;
	public static ModItems items;
	public static ModConfig config;
	
	public static void addShapedRecipe(ItemStack output, Object... input){
		ModRecipes.addShapedRecipe(output, input);
	}
	
	public static void addShapelessRecipe(ItemStack output, Object... input){
		ModRecipes.addShapelessRecipe(output, input);
	}
	
	public static void addEssenceRecipe(ItemStack output, Object... input){
		EssenceRecipes.addEssenceRecipe(output, input);
	}
	
	public static void initConfig(File file){
		ModConfig.init(file);
	}
}
