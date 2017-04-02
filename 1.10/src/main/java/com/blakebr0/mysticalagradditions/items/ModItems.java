package com.blakebr0.mysticalagradditions.items;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.lib.CropType;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	
	public static ItemInsanium itemInsanium = new ItemInsanium();
	public static ItemStuff itemStuff = new ItemStuff();

	public static void init(){
		registerItem(itemInsanium);
		registerItem(itemStuff);
		
		for(CropType.Type type : CropType.Type.values()){
			if(type.isEnabled()){
				registerItem(type.getCrop());
			}
		}
		
		for(CropType.Type type : CropType.Type.values()){
			if(type.isEnabled()){
				registerItem(type.getSeed());
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels(){
		itemInsanium.initModels();
		itemStuff.initModels();
		
		for(CropType.Type type : CropType.Type.values()){
			if(type.isEnabled()){
				registerModel(type.getCrop());
			}
		}
		
		for(CropType.Type type : CropType.Type.values()){
			if(type.isEnabled()){
				registerModel(type.getSeed());
			}
		}
	}
	
	public static void registerItem(Item item){
		GameRegistry.register(item);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerModel(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(MysticalAgradditions.MOD_ID + ":" + item.getUnlocalizedName().substring(8), "inventory")); 
	}
}
