package com.blakebr0.mysticalagradditions.world;

import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class ModWorldgenRegistration {
    private static final RuleTest END_STONE_RULE_TEST = new BlockMatchRuleTest(Blocks.END_STONE);

    @SubscribeEvent
    public void onBiomesLoading(BiomeLoadingEvent event) {
        Biome.Category category = event.getCategory();
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        if (category == Biome.Category.NETHER) {
            if (ModConfigs.GENERATE_NETHER_PROSPERITY.get()) {
                int size = ModConfigs.NETHER_PROSPERITY_SPAWN_SIZE.get();
                int rate = ModConfigs.NETHER_PROSPERITY_SPAWN_RATE.get();
                int height = ModConfigs.NETHER_PROSPERITY_SPAWN_HEIGHT.get();
                OreFeatureConfig config = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.NETHER_PROSPERITY_ORE.get().getDefaultState(), size);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(config)
                        .range(height)
                        .square()
                        .func_242732_c(rate)
                );
            }

            if (ModConfigs.GENERATE_NETHER_INFERIUM.get()) {
                int size = ModConfigs.NETHER_INFERIUM_SPAWN_SIZE.get();
                int rate = ModConfigs.NETHER_INFERIUM_SPAWN_RATE.get();
                int height = ModConfigs.NETHER_INFERIUM_SPAWN_HEIGHT.get();
                OreFeatureConfig config = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.NETHER_INFERIUM_ORE.get().getDefaultState(), size);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(config)
                        .range(height)
                        .square()
                        .func_242732_c(rate)
                );
            }
        }

        if (category == Biome.Category.THEEND) {
            if (ModConfigs.GENERATE_END_PROSPERITY.get()) {
                int size = ModConfigs.END_PROSPERITY_SPAWN_SIZE.get();
                int rate = ModConfigs.END_PROSPERITY_SPAWN_RATE.get();
                int height = ModConfigs.END_PROSPERITY_SPAWN_HEIGHT.get();
                OreFeatureConfig config = new OreFeatureConfig(END_STONE_RULE_TEST, ModBlocks.END_PROSPERITY_ORE.get().getDefaultState(), size);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(config)
                        .range(height)
                        .square()
                        .func_242732_c(rate)
                );
            }

            if (ModConfigs.GENERATE_END_INFERIUM.get()) {
                int size = ModConfigs.END_INFERIUM_SPAWN_SIZE.get();
                int rate = ModConfigs.END_INFERIUM_SPAWN_RATE.get();
                int height = ModConfigs.END_INFERIUM_SPAWN_HEIGHT.get();
                OreFeatureConfig config = new OreFeatureConfig(END_STONE_RULE_TEST, ModBlocks.END_INFERIUM_ORE.get().getDefaultState(), size);
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(config)
                        .range(height)
                        .square()
                        .func_242732_c(rate)
                );
            }
        }
    }
}
