package com.blakebr0.mysticalagradditions.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfigs {
    public static final ForgeConfigSpec COMMON;

    public static final ForgeConfigSpec.DoubleValue WITHERING_SOUL_DROP_CHANCE;
    public static final ForgeConfigSpec.IntValue DRAGON_SCALES_AMOUNT;

    // Common
    static {
        final ForgeConfigSpec.Builder common = new ForgeConfigSpec.Builder();

        common.comment("General configuration options.").push("General");
        WITHERING_SOUL_DROP_CHANCE = common
                .comment("The percentage chance that a wither will drop a Withering Soul when killed.")
                .translation("configGui.mysticalagradditions.withering_soul_chance")
                .defineInRange("witheringSoulChance", 0.35, 0, 1);
        DRAGON_SCALES_AMOUNT = common
                .comment("The amount of Dragon Scales that an Ender Dragon will drop when killed.")
                .translation("configGui.mysticalagradditions.dragon_scales_amount")
                .defineInRange("dragonScalesAmount", 8, 0, 64);
        common.pop();

        COMMON = common.build();
    }

//	public static boolean confFertilizableCrops;
//	public static boolean confTConstructSupport;
//	public static boolean confCreativeEssence;
//
//		confFertilizableCrops = config.getBoolean("fertilizable_crops", category, false, "Can Tier 6 crops be fertilized using Fertilized Essence and Mystical Fertilizer?");
//		confTConstructSupport = config.getBoolean("tconstruct_support", category, true, "Should the Tinkers' Construct integration be enabled?");
//		confCreativeEssence = config.getBoolean("creative_essence", category, true, "Should the Creative Essence item (with no default use or recipe) be enabled?");
}
