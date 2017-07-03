package com.blakebr0.mysticalagradditions.lib;

import java.io.File;

import com.blakebr0.mysticalagriculture.blocks.ModBlocks;
import com.blakebr0.mysticalagriculture.config.ModConfig;
import com.blakebr0.mysticalagriculture.crafting.EssenceRecipes;
import com.blakebr0.mysticalagriculture.crafting.ModRecipes;
import com.blakebr0.mysticalagriculture.handler.MobDrops;
import com.blakebr0.mysticalagriculture.items.ModItems;
import com.blakebr0.mysticalagriculture.lib.Parts;
import com.blakebr0.mysticalagriculture.lib.Parts.ItemNotFoundException;
import com.blakebr0.mysticalagriculture.lib.Tooltips;
import com.blakebr0.mysticalagriculture.util.ModChecker;
import com.blakebr0.mysticalagriculture.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class MAHelper {
	
	public static ModBlocks blocks;
	public static ModItems items;
	public static ModConfig config;
	public static MobDrops mobDrops;
	public static Tooltips tooltips; 
	
	public static Item draconicHeart;
	
	static {
		if(ModChecker.DRACONIC){
			try {
				draconicHeart = getItem("draconicevolution:dragon_heart");
			} catch(Throwable e){
				e.printStackTrace();
			}
		}
	}
	
	//TODO: a better job with recipes
	public static void addShapedRecipe(ItemStack output, Object... input){
		ForgeRegistries.RECIPES.register(new ShapedOreRecipe(ModRecipes.EMPTY_GROUP, output, input).setRegistryName(ModRecipes.getRecipeLocation(output)));
	}
	
	public static void addShapelessRecipe(ItemStack output, Object... input){
		ForgeRegistries.RECIPES.register(new ShapelessOreRecipe(ModRecipes.EMPTY_GROUP, output, input).setRegistryName(ModRecipes.getRecipeLocation(output)));
	}
	
	public static void addEssenceRecipe(ItemStack output, Object... input){
		EssenceRecipes.addEssenceRecipe(output, input);
	}
	
	public static void initConfig(File file){
		ModConfig.init(file);
	}
	
	public static Block getBlock(String block) throws ItemNotFoundException{
		return Block.getBlockFromName(block);
	}
	
	public static Item getItem(String item) throws ItemNotFoundException{
		return Parts.getItem(item);
	}
	
	public static ItemStack getOre(String name, int stackSize){
		return Utils.getItem(name, stackSize);
	}
}
