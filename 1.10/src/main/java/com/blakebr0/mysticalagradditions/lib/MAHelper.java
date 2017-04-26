package com.blakebr0.mysticalagradditions.lib;

import java.io.File;

import com.blakebr0.mysticalagriculture.blocks.ModBlocks;
import com.blakebr0.mysticalagriculture.config.ModConfig;
import com.blakebr0.mysticalagriculture.crafting.EssenceRecipes;
import com.blakebr0.mysticalagriculture.crafting.ModRecipes;
import com.blakebr0.mysticalagriculture.handler.MobDrops;
import com.blakebr0.mysticalagriculture.items.ModItems;
import com.blakebr0.mysticalagriculture.lib.OreDictResources;
import com.blakebr0.mysticalagriculture.lib.Parts;
import com.blakebr0.mysticalagriculture.lib.Parts.ItemNotFoundException;
import com.blakebr0.mysticalagriculture.lib.Tooltips;
import com.blakebr0.mysticalagriculture.util.ModChecker;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
	
	public static Block getBlock(String block) throws ItemNotFoundException{
		return Block.getBlockFromName(block);
	}
	
	public static Item getItem(String item) throws ItemNotFoundException{
		return Parts.getItem(item);
	}
	
	public static ItemStack getOre(String name, int stackSize){
		return OreDictResources.getItem(name, stackSize);
	}
}
