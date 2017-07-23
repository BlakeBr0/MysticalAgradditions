package com.blakebr0.mysticalagradditions.proxy;

import java.io.File;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.config.ModConfig;
import com.blakebr0.mysticalagradditions.crafting.ModRecipes;
import com.blakebr0.mysticalagradditions.event.MobDrops;
import com.blakebr0.mysticalagradditions.event.NoFertilizerForYou;
import com.blakebr0.mysticalagradditions.items.ModItems;
import com.blakebr0.mysticalagradditions.lib.CropType;
import com.blakebr0.mysticalagradditions.lib.MAHelper;
import com.blakebr0.mysticalagradditions.tinkers.CompatTConstruct;
import com.blakebr0.mysticalagriculture.util.ModChecker;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event){
		ModConfig.init(new File(event.getModConfigurationDirectory(), "mysticalagradditions.cfg"));
		MinecraftForge.EVENT_BUS.register(new ModConfig());
		ModBlocks.init(); 
		ModItems.init();
		CropType.init();

		MinecraftForge.EVENT_BUS.register(MysticalAgradditions.REGISTRY);
		
		if(ModChecker.TINKERS_CONSTRUCT){
			CompatTConstruct.init();
		}
	}
	
	public void init(FMLInitializationEvent event){
		ModRecipes.init();
		MinecraftForge.EVENT_BUS.register(new MobDrops());
		MinecraftForge.EVENT_BUS.register(new NoFertilizerForYou());
	}

	public void postInit(FMLPostInitializationEvent event){
		
	}
}
