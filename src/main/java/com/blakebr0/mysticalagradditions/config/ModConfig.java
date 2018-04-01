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
	public static boolean confTConstructSupport;
	public static boolean confCreativeEssence;
	public static int confWitherSouls;
	public static int confDragonScales;
	
	public static boolean confNetherStarSeeds;
	public static boolean confDragonEggSeeds;
	public static boolean confAwakenedDraconiumSeeds;
		
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
		confTConstructSupport = config.getBoolean("tconstruct_support", category, true, "Should the Tinkers' Construct integration be enabled?");
		confCreativeEssence = config.getBoolean("creative_essence", category, true, "Should the Creative Essence item (with no default use or recipe) be enabled?");
		confWitherSouls = config.getInt("wither_souls_chance", category, 35, 0, 100, "The percentage chance that a wither will drop a Withering Soul.");
		confDragonScales = config.getInt("dragon_scales_amount", category, 8, 0, 64, "The amount of Dragon Scales an Ender Dragon should drop upon death.");
		
		category = "Seeds";
		config.addCustomCategoryComment(category, "Enable/Disable each seed individually.");
		confNetherStarSeeds = config.get(category, "nether_star_seeds", true).getBoolean();
		confDragonEggSeeds = config.get(category, "dragon_egg_seeds", true).getBoolean();
		confAwakenedDraconiumSeeds = config.get(category, "awakened_draconium_seeds", true).getBoolean();
		
		if(config.hasChanged()){
			config.save();
		}
	}
}
