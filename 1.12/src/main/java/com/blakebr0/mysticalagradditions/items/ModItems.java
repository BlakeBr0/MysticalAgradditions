package com.blakebr0.mysticalagradditions.items;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.lib.CropType;
import com.blakebr0.mysticalagradditions.lib.MAHelper;
import com.blakebr0.mysticalagriculture.lib.ModToolMaterials;

import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;

public class ModItems {
	
	public static ItemInsanium itemInsanium = new ItemInsanium();
	public static ItemStuff itemStuff = new ItemStuff();
	
	public static ItemTier6Seed itemTier6InferiumSeeds = new ItemTier6Seed("tier6_inferium_seeds", ModBlocks.blockTier6InferiumCrop);
	
	public static ItemPaxel itemInferiumPaxel = new ItemPaxel("inferium_paxel", ModToolMaterials.INFERIUM, TextFormatting.YELLOW);
	public static ItemPaxel itemPrudentiumPaxel = new ItemPaxel("prudentium_paxel", ModToolMaterials.PRUDENTIUM, TextFormatting.GREEN);
	public static ItemPaxel itemIntermediumPaxel = new ItemPaxel("intermedium_paxel", ModToolMaterials.INTERMEDIUM, TextFormatting.GOLD);
	public static ItemPaxel itemSuperiumPaxel = new ItemPaxel("superium_paxel", ModToolMaterials.SUPERIUM, TextFormatting.AQUA);
	public static ItemPaxel itemSupremiumPaxel = new ItemPaxel("supremium_paxel", ModToolMaterials.SUPREMIUM, TextFormatting.RED);

	public static void init(){
		final ModRegistry registry = MysticalAgradditions.REGISTRY;
		
		register(itemInsanium, "insanium");
		register(itemStuff, "stuff");
		
		for(CropType.Type type : CropType.Type.values()){
			if(type.isEnabled()){
				register(type.getCrop(), type.getName() + "_essence");
			}
		}
		
		register(itemTier6InferiumSeeds, "tier6_inferium_seeds");
		
		for(CropType.Type type : CropType.Type.values()){
			if(type.isEnabled()){
				register(type.getSeed(), type.getName() + "_seeds");
			}
		}
		
		if (MAHelper.config.confGearModuleOverride) {
			registry.register(itemInferiumPaxel, "inferium_paxel", MAHelper.items.itemCrafting.itemInferiumIngot);
			registry.register(itemPrudentiumPaxel, "prudentium_paxel", MAHelper.items.itemCrafting.itemPrudentiumIngot);
			registry.register(itemIntermediumPaxel, "intermedium_paxel", MAHelper.items.itemCrafting.itemIntermediumIngot);
			registry.register(itemSuperiumPaxel, "superium_paxel", MAHelper.items.itemCrafting.itemSuperiumIngot);
			registry.register(itemSupremiumPaxel, "supremium_paxel", MAHelper.items.itemCrafting.itemSupremiumIngot);
		}
	}

	public static <T extends Item> T register(T item, String name){
		MysticalAgradditions.REGISTRY.register(item, name);
		return item;
	}
}
