package com.blakebr0.mysticalagradditions.crafting;

import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.items.ModItems;
import com.blakebr0.mysticalagradditions.lib.CropType;
import com.blakebr0.mysticalagradditions.lib.MAHelper;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes {
	
	public static void addSeedRecipe(CropType.Type type, Object input){
		if(type.isEnabled()){
			MAHelper.addShapedRecipe(new ItemStack(type.getSeed(), 1, 0), 
					"MEM", 
					"ESE", 
					"MEM", 
					'E', new ItemStack(ModItems.itemInsanium, 1, 0), 
					'S', new ItemStack(ModItems.itemInsanium, 1, 1), 
					'M', input);
		}
	}
	
	public static CropType.Type type;
	
	public static void init(){
		MAHelper.addShapedRecipe(new ItemStack(ModBlocks.blockStorage, 1, 0), "EEE", "EEE", "EEE", 'E', new ItemStack(ModItems.itemInsanium, 1, 0));
		MAHelper.addShapedRecipe(new ItemStack(ModBlocks.blockStorage, 1, 1), "EEE", "EEE", "EEE", 'E', new ItemStack(ModItems.itemInsanium, 1, 2));
		if(MAHelper.config.confEssenceCoal){
			MAHelper.addShapedRecipe(new ItemStack(ModBlocks.blockStorage, 1, 2), "EEE", "EEE", "EEE", 'E', new ItemStack(ModItems.itemInsanium, 1, 5));
		}
		
		MAHelper.addShapedRecipe(new ItemStack(ModBlocks.blockSpecial, 1, 0), "ESE", "WDW", "ESE", 'E', new ItemStack(MAHelper.items.itemSupremiumEssence, 1, 0), 'S', new ItemStack(Items.NETHER_STAR, 1, 0), 'D', "blockDiamond", 'W', new ItemStack(ModItems.itemStuff, 1, 1));
		if(type.AWAKENED_DRACONIUM.isEnabled()){ MAHelper.addShapedRecipe(new ItemStack(ModBlocks.blockSpecial, 1, 4), "EWE", "SDS", "ESE", 'E', new ItemStack(MAHelper.items.itemSupremiumEssence, 1, 0), 'S', MAHelper.getOre("blockDraconiumAwakened", 1), 'D', "blockDiamond", 'W', new ItemStack(MAHelper.draconicHeart, 1, 0)); }
		
		MAHelper.addShapedRecipe(new ItemStack(ModBlocks.blockInsaniumTinkeringTable, 1, 0), "SSS", "ICI", "IXI", 'S', new ItemStack(MAHelper.blocks.blockSoulstone, 1, 0), 'I', new ItemStack(ModItems.itemInsanium, 1, 2), 'C', "workbench");
		
		MAHelper.addShapelessRecipe(new ItemStack(MAHelper.items.itemSupremiumEssence, 4, 0), new ItemStack(ModItems.itemInsanium, 1, 0));
		
		MAHelper.addShapedRecipe(new ItemStack(ModItems.itemInsanium, 1, 0), "XEX", "ECE", "XEX", 'E', new ItemStack(MAHelper.items.itemSupremiumEssence, 1, 0), 'C', new ItemStack(MAHelper.items.itemInfusionCrystal, 1, OreDictionary.WILDCARD_VALUE));
		MAHelper.addShapedRecipe(new ItemStack(ModItems.itemInsanium, 1, 0), "XEX", "ECE", "XEX", 'E', new ItemStack(MAHelper.items.itemSupremiumEssence, 1, 0), 'C', new ItemStack(MAHelper.items.itemInfusionCrystalMaster, 1, 0));	
		
		MAHelper.addShapedRecipe(new ItemStack(ModBlocks.blockStorage, 1, 0), "XEX", "ECE", "XEX", 'E', new ItemStack(MAHelper.blocks.blockSupremium, 1, 0), 'C', new ItemStack(MAHelper.items.itemInfusionCrystalMaster, 1, 0));
		
		MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 9, 0), new ItemStack(ModBlocks.blockStorage, 1, 0));
		
		MAHelper.addShapedRecipe(new ItemStack(ModItems.itemInsanium, 1, 1), "XEX", "ECE", "XEX", 'E', new ItemStack(ModItems.itemInsanium, 1, 0), 'C', new ItemStack(MAHelper.items.itemTier5CraftingSeed, 1, 0));

		if(MAHelper.config.confHarderIngots){
		    MAHelper.addShapedRecipe(new ItemStack(ModItems.itemInsanium, 1, 2), "XEX", "EIE", "XEX", 'E', new ItemStack(MAHelper.items.itemSupremiumEssence, 1, 0), 'I', new ItemStack(MAHelper.items.itemSuperiumIngot, 1, 0));
    	} else {
    		MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 1, 2), new ItemStack(MAHelper.items.itemSupremiumIngot, 1, 0), new ItemStack(ModItems.itemInsanium, 1, 0), new ItemStack(ModItems.itemInsanium, 1, 0));
		}
		MAHelper.addShapedRecipe(new ItemStack(ModItems.itemInsanium, 1, 2), "NNN", "NNN", "NNN", 'N', new ItemStack(ModItems.itemInsanium, 1, 3));
		MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 9, 2), new ItemStack(ModBlocks.blockStorage, 1, 1));
		
		MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 9, 3), new ItemStack(ModItems.itemInsanium, 1, 2));
		
		MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 1, 4), new ItemStack(MAHelper.items.itemTier5MobChunk, 1, 0), new ItemStack(ModItems.itemInsanium, 1, 0), new ItemStack(ModItems.itemInsanium, 1, 0));

		if(MAHelper.config.confEssenceCoal){
			MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 1, 5), new ItemStack(MAHelper.items.itemEssenceCoal, 1, 4), new ItemStack(ModItems.itemInsanium, 1, 0), new ItemStack(ModItems.itemInsanium, 1, 0));
			MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 9, 5), new ItemStack(ModBlocks.blockStorage, 1, 2));
		}
		
		MAHelper.addShapelessRecipe(new ItemStack(Items.NETHER_STAR, 1, 0), new ItemStack(ModItems.itemStuff, 1, 0), new ItemStack(ModItems.itemStuff, 1, 0), new ItemStack(ModItems.itemStuff, 1, 0));
		MAHelper.addShapedRecipe(new ItemStack(Items.SKULL, 3, 1), "SSS", "XXX", "XXX", 'S', new ItemStack(ModItems.itemStuff, 1, 1));
		
		MAHelper.addShapedRecipe(new ItemStack(ModItems.itemTier6InferiumSeeds, 1, 0), "EEE", "ESE", "EEE", 'E', new ItemStack(ModItems.itemInsanium, 1, 0), 'S', new ItemStack(MAHelper.items.itemTier5InferiumSeeds, 1, 0));
		
		addSeedRecipe(type.NETHER_STAR, new ItemStack(Items.NETHER_STAR, 1, 0));
		addSeedRecipe(type.AWAKENED_DRACONIUM, "ingotDraconiumAwakened");
		
		initEssenceRecipes();
	}
	
	public static void initEssenceRecipes(){
		if(type.NETHER_STAR.isEnabled()){ MAHelper.addEssenceRecipe(new ItemStack(ModItems.itemStuff, 1, 0), "EEE", "EEE", "EEE", 'E', new ItemStack(type.NETHER_STAR.getCrop(), 1, 0)); }
		if(type.AWAKENED_DRACONIUM.isEnabled()){ MAHelper.addEssenceRecipe(MAHelper.getOre("nuggetDraconiumAwakened", 3), "EEE", "EEE", "EEE", 'E', new ItemStack(type.AWAKENED_DRACONIUM.getCrop(), 1, 0)); }		
	}
}
