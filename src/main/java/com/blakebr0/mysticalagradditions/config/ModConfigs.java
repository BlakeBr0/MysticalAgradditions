package com.blakebr0.mysticalagradditions.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class ModConfigs {
    public static final ForgeConfigSpec COMMON;

    public static final ForgeConfigSpec.DoubleValue WITHERING_SOUL_DROP_CHANCE;
    public static final ForgeConfigSpec.IntValue DRAGON_SCALES_AMOUNT;
    public static final ForgeConfigSpec.BooleanValue FERTILIZABLE_CROPS;

    public static final ForgeConfigSpec.BooleanValue GENERATE_NETHER_PROSPERITY;
    public static final ForgeConfigSpec.IntValue NETHER_PROSPERITY_SPAWN_RATE;
    public static final ForgeConfigSpec.IntValue NETHER_PROSPERITY_SPAWN_SIZE;
    public static final ForgeConfigSpec.IntValue NETHER_PROSPERITY_SPAWN_HEIGHT;
    public static final ForgeConfigSpec.BooleanValue GENERATE_NETHER_INFERIUM;
    public static final ForgeConfigSpec.IntValue NETHER_INFERIUM_SPAWN_RATE;
    public static final ForgeConfigSpec.IntValue NETHER_INFERIUM_SPAWN_SIZE;
    public static final ForgeConfigSpec.IntValue NETHER_INFERIUM_SPAWN_HEIGHT;
    public static final ForgeConfigSpec.BooleanValue GENERATE_END_PROSPERITY;
    public static final ForgeConfigSpec.IntValue END_PROSPERITY_SPAWN_RATE;
    public static final ForgeConfigSpec.IntValue END_PROSPERITY_SPAWN_SIZE;
    public static final ForgeConfigSpec.IntValue END_PROSPERITY_SPAWN_HEIGHT;
    public static final ForgeConfigSpec.BooleanValue GENERATE_END_INFERIUM;
    public static final ForgeConfigSpec.IntValue END_INFERIUM_SPAWN_RATE;
    public static final ForgeConfigSpec.IntValue END_INFERIUM_SPAWN_SIZE;
    public static final ForgeConfigSpec.IntValue END_INFERIUM_SPAWN_HEIGHT;

    // Common
    static {
        final ForgeConfigSpec.Builder common = new ForgeConfigSpec.Builder();

        common.comment("General configuration options.").push("General");
        WITHERING_SOUL_DROP_CHANCE = common
                .comment("The percentage chance that a Wither will drop a Withering Soul when killed.")
                .translation("configGui.mysticalagradditions.withering_soul_chance")
                .defineInRange("witheringSoulChance", 0.35, 0, 1);
        DRAGON_SCALES_AMOUNT = common
                .comment("The amount of Dragon Scales that an Ender Dragon will drop when killed.")
                .translation("configGui.mysticalagradditions.dragon_scales_amount")
                .defineInRange("dragonScalesAmount", 8, 0, 64);
        FERTILIZABLE_CROPS = common
                .comment("Can tier 6 crops be fertilized using Mystical Fertilizer or Fertilized Essence?")
                .translation("configGui.mysticalagradditions.fertilizable_crops")
                .define("fertilizableTier6Crops", false);
        common.pop();

        common.comment("World generation options.").push("World");
        GENERATE_NETHER_PROSPERITY = common
                .comment("Should Nether Prosperity Ore generate in the world?")
                .translation("configGui.mysticalagradditions.generate_nether_prosperity")
                .define("generateNetherProsperityOre", true);
        NETHER_PROSPERITY_SPAWN_RATE = common
                .comment("How many Nether Prosperity Ore veins should spawn in a chunk.")
                .translation("configGui.mysticalagradditions.nether_prosperity_spawn_rate")
                .defineInRange("netherProsperitySpawnRate", 12, 0, Integer.MAX_VALUE);
        NETHER_PROSPERITY_SPAWN_SIZE = common
                .comment("The maximum amount of Nether Prosperity Ore blocks that can spawn in a vein.")
                .translation("configGui.mysticalagradditions.nether_prosperity_spawn_size")
                .defineInRange("netherProsperitySpawnSize", 8, 0, Integer.MAX_VALUE);
        NETHER_PROSPERITY_SPAWN_HEIGHT = common
                .comment("The maximum Y level that Nether Prosperity Ore veins can spawn.")
                .translation("configGui.mysticalagradditions.nether_prosperity_spawn_height")
                .defineInRange("netherProsperitySpawnHeight", 100, 0, 128);
        GENERATE_NETHER_INFERIUM = common
                .comment("Should Nether Inferium Ore generate in the world?")
                .translation("configGui.mysticalagradditions.generate_nether_inferium")
                .define("generateNetherInferiumOre", true);
        NETHER_INFERIUM_SPAWN_RATE = common
                .comment("How many Nether Inferium Ore veins should spawn in a chunk.")
                .translation("configGui.mysticalagradditions.nether_inferium_spawn_rate")
                .defineInRange("netherInferiumSpawnRate", 16, 0, Integer.MAX_VALUE);
        NETHER_INFERIUM_SPAWN_SIZE = common
                .comment("The maximum amount of Nether Inferium Ore blocks that can spawn in a vein.")
                .translation("configGui.mysticalagradditions.nether_inferium_spawn_size")
                .defineInRange("netherInferiumSpawnSize", 8, 0, Integer.MAX_VALUE);
        NETHER_INFERIUM_SPAWN_HEIGHT = common
                .comment("The maximum Y level that Nether Inferium Ore veins can spawn.")
                .translation("configGui.mysticalagradditions.nether_inferium_spawn_height")
                .defineInRange("netherInferiumSpawnHeight", 100, 0, 128);
        GENERATE_END_PROSPERITY = common
                .comment("Should End Prosperity Ore generate in the world?")
                .translation("configGui.mysticalagradditions.generate_end_prosperity")
                .define("generateEndProsperityOre", true);
        END_PROSPERITY_SPAWN_RATE = common
                .comment("How many End Prosperity Ore veins should spawn in a chunk.")
                .translation("configGui.mysticalagradditions.end_prosperity_spawn_rate")
                .defineInRange("endProsperitySpawnRate", 12, 0, Integer.MAX_VALUE);
        END_PROSPERITY_SPAWN_SIZE = common
                .comment("The maximum amount of End Prosperity Ore blocks that can spawn in a vein.")
                .translation("configGui.mysticalagradditions.end_prosperity_spawn_size")
                .defineInRange("endProsperitySpawnSize", 8, 0, Integer.MAX_VALUE);
        END_PROSPERITY_SPAWN_HEIGHT = common
                .comment("The maximum Y level that Prosperity Ore veins can spawn.")
                .translation("configGui.mysticalagradditions.end_prosperity_spawn_height")
                .defineInRange("endProsperitySpawnHeight", 100, 0, 128);
        GENERATE_END_INFERIUM = common
                .comment("Should End Inferium Ore generate in the world?")
                .translation("configGui.mysticalagradditions.generate_end_inferium")
                .define("generateEndInferiumOre", true);
        END_INFERIUM_SPAWN_RATE = common
                .comment("How many End Inferium Ore veins should spawn in a chunk.")
                .translation("configGui.mysticalagradditions.end_inferium_spawn_rate")
                .defineInRange("endInferiumSpawnRate", 16, 0, Integer.MAX_VALUE);
        END_INFERIUM_SPAWN_SIZE = common
                .comment("The maximum amount of End Inferium Ore blocks that can spawn in a vein.")
                .translation("configGui.mysticalagradditions.end_inferium_spawn_size")
                .defineInRange("endInferiumSpawnSize", 8, 0, Integer.MAX_VALUE);
        END_INFERIUM_SPAWN_HEIGHT = common
                .comment("The maximum Y level that End Inferium Ore veins can spawn.")
                .translation("configGui.mysticalagradditions.end_inferium_spawn_height")
                .defineInRange("endInferiumSpawnHeight", 100, 0, 128);
        common.pop();

        COMMON = common.build();
    }
}
