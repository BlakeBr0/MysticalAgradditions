package com.blakebr0.mysticalagradditions.items;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.lib.CropType;

import net.minecraft.item.Item;

public class ModItems {
	
	public static ItemInsanium itemInsanium = new ItemInsanium();
	public static ItemStuff itemStuff = new ItemStuff();
	
	public static ItemTier6Seed itemTier6InferiumSeeds = new ItemTier6Seed("tier6_inferium_seeds", ModBlocks.blockTier6InferiumCrop);

	public static void init(){
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
	}

	public static <T extends Item> T register(T item, String name){
		MysticalAgradditions.REGISTRY.register(item, name);
		return item;
	}
}
