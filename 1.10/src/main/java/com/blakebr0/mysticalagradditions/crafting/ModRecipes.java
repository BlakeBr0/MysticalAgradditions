package com.blakebr0.mysticalagradditions.crafting;

import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.items.ModItems;
import com.blakebr0.mysticalagradditions.lib.MAHelper;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes {
	
	public static void init(){
		MAHelper.addShapedRecipe(new ItemStack(ModBlocks.blockStorage, 1, 0), "EEE", "EEE", "EEE", 'E', new ItemStack(ModItems.itemInsanium, 1, 0));
		MAHelper.addShapedRecipe(new ItemStack(ModBlocks.blockStorage, 1, 1), "EEE", "EEE", "EEE", 'E', new ItemStack(ModItems.itemInsanium, 1, 2));
		if(MAHelper.config.confEssenceCoal){
			MAHelper.addShapedRecipe(new ItemStack(ModBlocks.blockStorage, 1, 2), "EEE", "EEE", "EEE", 'E', new ItemStack(ModItems.itemInsanium, 1, 4));
		}
		
		MAHelper.addShapelessRecipe(new ItemStack(MAHelper.items.itemSupremiumEssence, 4, 0), new ItemStack(ModItems.itemInsanium, 1, 0));
		
		MAHelper.addShapedRecipe(new ItemStack(ModItems.itemInsanium, 1, 0), "XEX", "ECE", "XEX", 'E', new ItemStack(MAHelper.items.itemSupremiumEssence, 1, 0), 'C', new ItemStack(MAHelper.items.itemInfusionCrystal, 1, OreDictionary.WILDCARD_VALUE));
		MAHelper.addShapedRecipe(new ItemStack(ModItems.itemInsanium, 1, 0), "XEX", "ECE", "XEX", 'E', new ItemStack(MAHelper.items.itemSupremiumEssence, 1, 0), 'C', new ItemStack(MAHelper.items.itemInfusionCrystalMaster, 1, 0));	
		MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 9, 0), new ItemStack(ModBlocks.blockStorage, 1, 0));
		
		MAHelper.addShapedRecipe(new ItemStack(ModItems.itemInsanium, 1, 1), "XEX", "ECE", "XEX", 'E', new ItemStack(ModItems.itemInsanium, 1, 0), 'C', new ItemStack(MAHelper.items.itemTier5CraftingSeed, 1, 0));

		if(MAHelper.config.confHarderIngots){
		    MAHelper.addShapedRecipe(new ItemStack(ModItems.itemInsanium, 1, 2), "XEX", "EIE", "XEX", 'E', new ItemStack(MAHelper.items.itemSupremiumEssence, 1, 0), 'I', new ItemStack(MAHelper.items.itemSuperiumIngot, 1, 0));
    	} else {
    		MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 1, 2), new ItemStack(MAHelper.items.itemSupremiumIngot, 1, 0), new ItemStack(ModItems.itemInsanium, 1, 0), new ItemStack(ModItems.itemInsanium, 1, 0));
		}
		MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 9, 2), new ItemStack(ModBlocks.blockStorage, 1, 1));
		
		MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 1, 3), new ItemStack(MAHelper.items.itemTier5MobChunk, 1, 0), new ItemStack(ModItems.itemInsanium, 1, 0), new ItemStack(ModItems.itemInsanium, 1, 0));

		if(MAHelper.config.confEssenceCoal){
			MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 1, 4), new ItemStack(MAHelper.items.itemEssenceCoal, 1, 4), new ItemStack(ModItems.itemInsanium, 1, 0), new ItemStack(ModItems.itemInsanium, 1, 0));
			MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 9, 4), new ItemStack(ModBlocks.blockStorage, 1, 2));
		}
	}
}
