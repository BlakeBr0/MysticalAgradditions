package com.blakebr0.mysticalagradditions.blocks;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.lib.CropType;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ModBlocks {
	
	public static BlockStorage blockStorage = new BlockStorage();
	public static BlockSpecial blockSpecial = new BlockSpecial();
	
	public static BlockTier6TinkeringTable blockInsaniumTinkeringTable = new BlockTier6TinkeringTable();
	
	public static BlockTier6InferiumCrop blockTier6InferiumCrop = new BlockTier6InferiumCrop("tier6_inferium_crop");
	
	public static void init(){
		register(blockStorage, "storage", new ItemBlockStorage(blockStorage));
		register(blockSpecial, "special", new ItemBlockSpecial(blockSpecial));
		
		register(blockInsaniumTinkeringTable, "tinkering_table");
		
		register(blockTier6InferiumCrop, "tier6_inferium_crop");
		
		for(CropType.Type type : CropType.Type.values()){
			if(type.isEnabled()){
				register(type.getPlant(), type.getName() + "_crop");
			}
		}
	}
	
	public static <T extends Block> T register(T block, String name){
		MysticalAgradditions.REGISTRY.register(block, name);
		return block;
	}
	
	public static <T extends Block> T register(T block, String name, boolean itemBlock){
		MysticalAgradditions.REGISTRY.register(block, name, itemBlock);
		return block;
	}
	
	public static <T extends Block> T register(T block, String name, ItemBlock itemBlock){
		MysticalAgradditions.REGISTRY.register(block, name, itemBlock);
		return block;
	}
}
