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
    public static final ForgeConfigSpec.IntValue NETHER_PROSPERITY_SPAWN_RATE;
    public static final ForgeConfigSpec.IntValue NETHER_PROSPERITY_SPAWN_SIZE;
    public static final ForgeConfigSpec.IntValue NETHER_PROSPERITY_SPAWN_MIN_Y;
    public static final ForgeConfigSpec.IntValue NETHER_PROSPERITY_SPAWN_MAX_Y;
    public static final ForgeConfigSpec.BooleanValue GENERATE_NETHER_INFERIUM;
    public static final ForgeConfigSpec.IntValue NETHER_INFERIUM_SPAWN_RATE;
    public static final ForgeConfigSpec.IntValue NETHER_INFERIUM_SPAWN_SIZE;
    public static final ForgeConfigSpec.IntValue NETHER_INFERIUM_SPAWN_MIN_Y;
    public static final ForgeConfigSpec.IntValue NETHER_INFERIUM_SPAWN_MAX_Y;
    public static final ForgeConfigSpec.BooleanValue GENERATE_END_PROSPERITY;
    public static final ForgeConfigSpec.IntValue END_PROSPERITY_SPAWN_RATE;
    public static final ForgeConfigSpec.IntValue END_PROSPERITY_SPAWN_SIZE;
    public static final ForgeConfigSpec.IntValue END_PROSPERITY_SPAWN_MIN_Y;
    public static final ForgeConfigSpec.IntValue END_PROSPERITY_SPAWN_MAX_Y;
    public static final ForgeConfigSpec.BooleanValue GENERATE_END_INFERIUM;
    public static final ForgeConfigSpec.IntValue END_INFERIUM_SPAWN_RATE;
    public static final ForgeConfigSpec.IntValue END_INFERIUM_SPAWN_SIZE;
    public static final ForgeConfigSpec.IntValue END_INFERIUM_SPAWN_MIN_Y;
    public static final ForgeConfigSpec.IntValue END_INFERIUM_SPAWN_MAX_Y;

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
        NETHER_PROSPERITY_SPAWN_RATE = common
                .comment("How many Nether Prosperity Ore veins should spawn in a chunk.")
                .defineInRange("netherProsperitySpawnRate", 12, 0, Integer.MAX_VALUE);
        NETHER_PROSPERITY_SPAWN_SIZE = common
                .comment("The maximum amount of Nether Prosperity Ore blocks that can spawn in a vein.")
                .defineInRange("netherProsperitySpawnSize", 8, 0, Integer.MAX_VALUE);
        NETHER_PROSPERITY_SPAWN_MIN_Y = common
                .comment("The minimum Y level that Nether Prosperity Ore veins can spawn.")
                .defineInRange("netherProsperitySpawnMinY", 10, 0, 128);
        NETHER_PROSPERITY_SPAWN_MAX_Y = common
                .comment("The maximum Y level that Nether Prosperity Ore veins can spawn.")
                .defineInRange("netherProsperitySpawnMaxY", 100, 0, 128);
        GENERATE_NETHER_INFERIUM = common
                .comment("Should Nether Inferium Ore generate in the world?")
                .define("generateNetherInferiumOre", true);
        NETHER_INFERIUM_SPAWN_RATE = common
                .comment("How many Nether Inferium Ore veins should spawn in a chunk.")
                .defineInRange("netherInferiumSpawnRate", 16, 0, Integer.MAX_VALUE);
        NETHER_INFERIUM_SPAWN_SIZE = common
                .comment("The maximum amount of Nether Inferium Ore blocks that can spawn in a vein.")
                .defineInRange("netherInferiumSpawnSize", 8, 0, Integer.MAX_VALUE);
        NETHER_INFERIUM_SPAWN_MIN_Y = common
                .comment("The minimum Y level that Nether Inferium Ore veins can spawn.")
                .defineInRange("netherInferiumSpawnMinY", 10, 0, 128);
        NETHER_INFERIUM_SPAWN_MAX_Y = common
                .comment("The maximum Y level that Nether Inferium Ore veins can spawn.")
                .defineInRange("netherInferiumSpawnMaxY", 100, 0, 128);
        GENERATE_END_PROSPERITY = common
                .comment("Should End Prosperity Ore generate in the world?")
                .define("generateEndProsperityOre", true);
        END_PROSPERITY_SPAWN_RATE = common
                .comment("How many End Prosperity Ore veins should spawn in a chunk.")
                .defineInRange("endProsperitySpawnRate", 12, 0, Integer.MAX_VALUE);
        END_PROSPERITY_SPAWN_SIZE = common
                .comment("The maximum amount of End Prosperity Ore blocks that can spawn in a vein.")
                .defineInRange("endProsperitySpawnSize", 8, 0, Integer.MAX_VALUE);
        END_PROSPERITY_SPAWN_MIN_Y = common
                .comment("The minimum Y level that Prosperity Ore veins can spawn.")
                .defineInRange("endProsperitySpawnMinY", 10, 0, 128);
        END_PROSPERITY_SPAWN_MAX_Y = common
                .comment("The maximum Y level that Prosperity Ore veins can spawn.")
                .defineInRange("endProsperitySpawnMaxY", 100, 0, 128);
        GENERATE_END_INFERIUM = common
                .comment("Should End Inferium Ore generate in the world?")
                .define("generateEndInferiumOre", true);
        END_INFERIUM_SPAWN_RATE = common
                .comment("How many End Inferium Ore veins should spawn in a chunk.")
                .defineInRange("endInferiumSpawnRate", 16, 0, Integer.MAX_VALUE);
        END_INFERIUM_SPAWN_SIZE = common
                .comment("The maximum amount of End Inferium Ore blocks that can spawn in a vein.")
                .defineInRange("endInferiumSpawnSize", 8, 0, Integer.MAX_VALUE);
        END_INFERIUM_SPAWN_MIN_Y = common
                .comment("The minimum Y level that End Inferium Ore veins can spawn.")
                .defineInRange("endInferiumSpawnMinY", 10, 0, 128);
        END_INFERIUM_SPAWN_MAX_Y = common
                .comment("The maximum Y level that End Inferium Ore veins can spawn.")
                .defineInRange("endInferiumSpawnMaxY", 100, 0, 128);
        common.pop();

        COMMON = common.build();
    }

    public static boolean isTConstructInstalled() {
        return ModList.get().isLoaded("tconstruct");
    }
}
