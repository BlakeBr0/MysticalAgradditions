package com.blakebr0.mysticalagradditions.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static BlockStorage blockStorage = new BlockStorage();
	
	public static void init(){
		registerBlock(blockStorage, new ItemBlockStorage(blockStorage));
	}
	
	public static void initModels(){
		blockStorage.initModels();
	}
	
	public static void registerBlock(Block block){
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
	
	public static void registerBlock(Block block, ItemBlock itemBlock){
		GameRegistry.register(block);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
	}

}
