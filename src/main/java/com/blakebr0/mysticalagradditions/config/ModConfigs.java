package com.blakebr0.mysticalagradditions.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModList;

public final class ModConfigs {
    public static final ForgeConfigSpec COMMON;

    public static final ForgeConfigSpec.DoubleValue WITHERING_SOUL_DROP_CHANCE;
    public static final ForgeConfigSpec.IntValue DRAGON_SCALES_AMOUNT;
    public static final ForgeConfigSpec.BooleanValue FERTILIZABLE_CROPS;
    public static final ForgeConfigSpec.IntValue ESSENCE_APPLE_DURATION;
    public static final ForgeConfigSpec.BooleanValue HIDE_UNUSED_CRUXES;

    public static final ForgeConfigSpec.BooleanValue GENERATE_NETHER_PROSPERITY;
    public static final ForgeConfigSpec.BooleanValue GENERATE_NETHER_INFERIUM;
    public static final ForgeConfigSpec.BooleanValue GENERATE_END_PROSPERITY;
    public static final ForgeConfigSpec.BooleanValue GENERATE_END_INFERIUM;

    // Common
    static {
        final var common = new ForgeConfigSpec.Builder();

        common.comment("General configuration options.").push("General");
        WITHERING_SOUL_DROP_CHANCE = common
                .comment("The percentage chance that a Wither will drop a Withering Soul when killed.")
                .defineInRange("witheringSoulChance", 0.35, 0, 1);
        DRAGON_SCALES_AMOUNT = common
                .comment("The amount of Dragon Scales that an Ender Dragon will drop when killed.")
                .defineInRange("dragonScalesAmount", 8, 0, 64);
        FERTILIZABLE_CROPS = common
                .comment("Can tier 6 crops be fertilized using Mystical Fertilizer or Fertilized Essence?")
                .define("fertilizableTier6Crops", false);
        ESSENCE_APPLE_DURATION = common
                .comment("The duration of each Essence Apples effects in seconds.")
                .defineInRange("essenceAppleDuration", 180, 1, Integer.MAX_VALUE);
        HIDE_UNUSED_CRUXES = common
                .comment("Should Cruxes for disabled crops be hidden and not have recipes?")
                .define("hideUnusedCruxes", false);
        common.pop();

        common.comment("World generation options.").push("World");
        GENERATE_NETHER_PROSPERITY = common
                .comment("Should Nether Prosperity Ore generate in the world?")
                .define("generateNetherProsperityOre", true);
        GENERATE_NETHER_INFERIUM = common
                .comment("Should Nether Inferium Ore generate in the world?")
                .define("generateNetherInferiumOre", true);
        GENERATE_END_PROSPERITY = common
                .comment("Should End Prosperity Ore generate in the world?")
                .define("generateEndProsperityOre", true);
        GENERATE_END_INFERIUM = common
                .comment("Should End Inferium Ore generate in the world?")
                .define("generateEndInferiumOre", true);
        common.pop();

        COMMON = common.build();
    }

    public static boolean isTConstructInstalled() {
        return ModList.get().isLoaded("tconstruct");
    }
}
