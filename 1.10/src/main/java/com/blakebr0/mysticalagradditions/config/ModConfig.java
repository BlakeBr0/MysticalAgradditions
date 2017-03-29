package com.blakebr0.mysticalagradditions.config;

import java.io.File;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModConfig {
	
	public static Configuration config;
	public static ModConfig instance;
	
	public static boolean confFertilizableCrops;
		
	@SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if(eventArgs.getModID().equals(MysticalAgradditions.MOD_ID)) {
            ModConfig.syncConfig();
        }
    }
	
	public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
	}
	
	public static void syncConfig() {
		
		String category;
		
		category = "Settings";
		config.addCustomCategoryComment(category, "Settings for all things Mystical Agriculture.");
		confFertilizableCrops = config.getBoolean("fertilizable_crops", category, false, "Can Tier 6 crops be fertilized using Fertilized Essence and Mystical Fertilizer?");
		
		if(config.hasChanged()){
			config.save();
		}
	}
}
