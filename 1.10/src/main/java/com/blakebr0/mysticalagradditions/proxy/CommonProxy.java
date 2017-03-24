package com.blakebr0.mysticalagradditions.proxy;

import java.io.File;

import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.crafting.ModRecipes;
import com.blakebr0.mysticalagradditions.items.ModItems;
import com.blakebr0.mysticalagradditions.lib.MAHelper;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event){
		MAHelper.initConfig(new File(event.getModConfigurationDirectory(), "mysticalagriculture.cfg"));
		ModBlocks.init();
		ModItems.init();
	}
	
	public void init(FMLInitializationEvent event){
		ModRecipes.init();
	}

	public void postInit(FMLPostInitializationEvent event){
		
	}
}
