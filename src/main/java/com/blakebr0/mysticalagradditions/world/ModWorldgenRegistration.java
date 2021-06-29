package com.blakebr0.mysticalagradditions.world;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class ModWorldgenRegistration {
    private static final RuleTest END_STONE_RULE_TEST = new BlockMatchRuleTest(Blocks.END_STONE);
    private static ConfiguredFeature<?, ?> configuredNetherProsperityOreFeature;
    private static ConfiguredFeature<?, ?> configuredNetherInferiumOreFeature;
    private static ConfiguredFeature<?, ?> configuredEndProsperityOreFeature;
    private static ConfiguredFeature<?, ?> configuredEndInferiumOreFeature;

    @SubscribeEvent
    public void onBiomesLoading(BiomeLoadingEvent event) {
        Biome.Category category = event.getCategory();
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        switch (category) {
            case NETHER:
                if (ModConfigs.GENERATE_NETHER_PROSPERITY.get()) {
                    generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, configuredNetherProsperityOreFeature);
                }

                if (ModConfigs.GENERATE_NETHER_INFERIUM.get()) {
                    generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, configuredNetherInferiumOreFeature);
                }

                break;
            case THEEND:
                if (ModConfigs.GENERATE_END_PROSPERITY.get()) {
                    generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, configuredEndProsperityOreFeature);
                }

                if (ModConfigs.GENERATE_END_INFERIUM.get()) {
                    generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, configuredEndInferiumOreFeature);
                }

                break;
            default:
                break;
        }
    }

    public static void onCommonSetup() {
        int size, rate, height;
        OreFeatureConfig config;

        size = ModConfigs.NETHER_PROSPERITY_SPAWN_SIZE.get();
        rate = ModConfigs.NETHER_PROSPERITY_SPAWN_RATE.get();
        height = ModConfigs.NETHER_PROSPERITY_SPAWN_HEIGHT.get();
        config = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.NETHER_PROSPERITY_ORE.get().defaultBlockState(), size);
        configuredNetherProsperityOreFeature = Feature.ORE.configured(config)
                .range(height)
                .squared()
                .countRandom(rate);

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "nether_prosperity_ore"), configuredNetherProsperityOreFeature);

        size = ModConfigs.NETHER_INFERIUM_SPAWN_SIZE.get();
        rate = ModConfigs.NETHER_INFERIUM_SPAWN_RATE.get();
        height = ModConfigs.NETHER_INFERIUM_SPAWN_HEIGHT.get();
        config = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.NETHER_INFERIUM_ORE.get().defaultBlockState(), size);
        configuredNetherInferiumOreFeature = Feature.ORE.configured(config)
                .range(height)
                .squared()
                .countRandom(rate);

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "nether_inferium_ore"), configuredNetherInferiumOreFeature);

        size = ModConfigs.END_PROSPERITY_SPAWN_SIZE.get();
        rate = ModConfigs.END_PROSPERITY_SPAWN_RATE.get();
        height = ModConfigs.END_PROSPERITY_SPAWN_HEIGHT.get();
        config = new OreFeatureConfig(END_STONE_RULE_TEST, ModBlocks.END_PROSPERITY_ORE.get().defaultBlockState(), size);
        configuredEndProsperityOreFeature = Feature.ORE.configured(config)
                .range(height)
                .squared()
                .countRandom(rate);

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "end_prosperity_ore"), configuredEndProsperityOreFeature);

        size = ModConfigs.END_INFERIUM_SPAWN_SIZE.get();
        rate = ModConfigs.END_INFERIUM_SPAWN_RATE.get();
        height = ModConfigs.END_INFERIUM_SPAWN_HEIGHT.get();
        config = new OreFeatureConfig(END_STONE_RULE_TEST, ModBlocks.END_INFERIUM_ORE.get().defaultBlockState(), size);
        configuredEndInferiumOreFeature = Feature.ORE.configured(config)
                .range(height)
                .squared()
                .countRandom(rate);

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "end_inferium_ore"), configuredEndInferiumOreFeature);
    }
}
