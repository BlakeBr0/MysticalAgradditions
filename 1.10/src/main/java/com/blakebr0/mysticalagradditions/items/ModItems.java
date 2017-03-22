package com.blakebr0.mysticalagradditions.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	
	public static ItemInsanium itemInsanium = new ItemInsanium();

	public static void init(){
		registerItem(itemInsanium);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels(){
		itemInsanium.initModels();
	}
	
	public static void registerItem(Item item){
		GameRegistry.register(item);
	}
}
