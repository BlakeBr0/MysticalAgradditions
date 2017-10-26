package com.blakebr0.mysticalagradditions.crafting;

import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.items.ModItems;
import com.blakebr0.mysticalagradditions.lib.CropType;
import com.blakebr0.mysticalagradditions.lib.MAHelper;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes {
	
	public static void addSeedRecipe(CropType.Type type, Object input) {
		if (type.isEnabled()) {
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
	// TODO: Jason KappaPride
	public static void init() {
		
		if (type.NETHER_STAR.isEnabled()) { MAHelper.addShapedRecipe(new ItemStack(ModBlocks.blockSpecial, 1, 0), "ESE", "WDW", "ESE", 'E', MAHelper.items.itemCrafting.itemSupremiumEssence, 'S', new ItemStack(Items.NETHER_STAR, 1, 0), 'D', "blockDiamond", 'W', new ItemStack(ModItems.itemStuff, 1, 1)); }
		if (type.AWAKENED_DRACONIUM.isEnabled()) { MAHelper.addShapedRecipe(new ItemStack(ModBlocks.blockSpecial, 1, 4), "EWE", "IDI", "ESE", 'E', MAHelper.items.itemCrafting.itemSupremiumEssence, 'S', MAHelper.getOre("blockDraconiumAwakened", 1), 'D', "blockDiamond", 'W', new ItemStack(MAHelper.draconicHeart, 1, 0), 'I', "ingotDraconiumAwakened"); }
								
		if (MAHelper.config.confHarderIngots) {
		    MAHelper.addShapedRecipe(new ItemStack(ModItems.itemInsanium, 1, 2), " E ", "EIE", " E ", 'E', MAHelper.items.itemCrafting.itemSupremiumEssence, 'I', MAHelper.items.itemCrafting.itemSupremiumIngot);
    	} else {
    		MAHelper.addShapelessRecipe(new ItemStack(ModItems.itemInsanium, 1, 2), MAHelper.items.itemCrafting.itemSupremiumIngot, new ItemStack(ModItems.itemInsanium, 1, 0), new ItemStack(ModItems.itemInsanium, 1, 0));
		}
				
		addSeedRecipe(type.NETHER_STAR, new ItemStack(Items.NETHER_STAR, 1, 0));
		addSeedRecipe(type.AWAKENED_DRACONIUM, "ingotDraconiumAwakened");

		if (type.NETHER_STAR.isEnabled()) { MAHelper.addEssenceRecipe(new ItemStack(ModItems.itemStuff, 1, 0), "EEE", "EEE", "EEE", 'E', new ItemStack(type.NETHER_STAR.getCrop(), 1, 0)); }
		if (type.AWAKENED_DRACONIUM.isEnabled()) { MAHelper.addEssenceRecipe(MAHelper.getOre("nuggetDraconiumAwakened", 3), "EEE", "EEE", "EEE", 'E', new ItemStack(type.AWAKENED_DRACONIUM.getCrop(), 1, 0)); }		
	
		if (MAHelper.config.confGearModuleOverride) {
			com.blakebr0.mysticalagriculture.crafting.ModRecipes.addUpgradeRecipe(new ItemStack(ModItems.itemSupremiumPaxel), new ItemStack(ModItems.itemCharm, 1, 0), 1000);
		}
	}
}
