package com.blakebr0.mysticalagradditions.blocks;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.lib.CropType;
import com.blakebr0.mysticalagradditions.registry.MysticalRegistry;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
		return register(block, name, true);
	}
	
	public static <T extends Block> T register(T block, String name, boolean itemBlock){
		MysticalRegistry.register(block, name);
		if(itemBlock){
			MysticalRegistry.register(new ItemBlock(block), name);
		}
		return block;
	}
	
	public static <T extends Block> T register(T block, String name, ItemBlock itemBlock){
		MysticalRegistry.register(block, name);
		MysticalRegistry.register(itemBlock, name);
		return block;
	}

	@SideOnly(Side.CLIENT)
	public static void registerModel(Block block){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MysticalAgradditions.MOD_ID + ":" + block.getUnlocalizedName().substring(8), "inventory"));
	}
}
