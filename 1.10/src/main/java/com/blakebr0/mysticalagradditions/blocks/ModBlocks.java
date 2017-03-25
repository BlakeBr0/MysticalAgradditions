package com.blakebr0.mysticalagradditions.blocks;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.lib.CropType;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
	
	public static BlockStorage blockStorage = new BlockStorage();
	public static BlockSpecial blockSpecial = new BlockSpecial();
	
	public static void init(){
		registerBlock(blockStorage, new ItemBlockStorage(blockStorage));
		registerBlock(blockSpecial, new ItemBlockSpecial(blockSpecial));
		
		for(CropType.Type type : CropType.Type.values()){
			if(type.isEnabled()){
				registerBlock(type.getPlant());
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels(){
		blockStorage.initModels();
		blockSpecial.initModels();
		
		for(CropType.Type type : CropType.Type.values()){
			if(type.isEnabled()){
				registerModel(type.getPlant());
			}
		}
	}
	
	public static void registerBlock(Block block){
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
	
	public static void registerBlock(Block block, ItemBlock itemBlock){
		GameRegistry.register(block);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	public static void registerModel(Block block){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MysticalAgradditions.MOD_ID + ":" + block.getUnlocalizedName().substring(8), "inventory"));
	}
}
