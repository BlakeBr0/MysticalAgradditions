package com.blakebr0.mysticalagradditions.proxy;

import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.items.ModItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event){
		ModBlocks.init();
		ModItems.init();
	}
	
	public void init(FMLInitializationEvent event){
		
	}

	public void postInit(FMLPostInitializationEvent event){
		
	}
}
