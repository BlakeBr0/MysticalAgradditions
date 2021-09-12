package com.blakebr0.mysticalagradditions.world;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.init.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class ModWorldgenRegistration {
    private static final RuleTest END_STONE_RULE_TEST = new BlockMatchTest(Blocks.END_STONE);
    private static ConfiguredFeature<?, ?> configuredNetherProsperityOreFeature;
    private static ConfiguredFeature<?, ?> configuredNetherInferiumOreFeature;
    private static ConfiguredFeature<?, ?> configuredEndProsperityOreFeature;
    private static ConfiguredFeature<?, ?> configuredEndInferiumOreFeature;

    @SubscribeEvent
    public void onBiomesLoading(BiomeLoadingEvent event) {
        var category = event.getCategory();
        var generation = event.getGeneration();

        switch (category) {
            case NETHER -> {
                if (ModConfigs.GENERATE_NETHER_PROSPERITY.get()) {
                    generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, configuredNetherProsperityOreFeature);
                }
                if (ModConfigs.GENERATE_NETHER_INFERIUM.get()) {
                    generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, configuredNetherInferiumOreFeature);
                }
            }
            case THEEND -> {
                if (ModConfigs.GENERATE_END_PROSPERITY.get()) {
                    generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, configuredEndProsperityOreFeature);
                }
                if (ModConfigs.GENERATE_END_INFERIUM.get()) {
                    generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, configuredEndInferiumOreFeature);
                }
            }
            default -> { }
        }
    }

    public static void onCommonSetup() {
        int size, rate, height;
        OreConfiguration config;

        size = ModConfigs.NETHER_PROSPERITY_SPAWN_SIZE.get();
        height = ModConfigs.NETHER_PROSPERITY_SPAWN_HEIGHT.get();
        rate = ModConfigs.NETHER_PROSPERITY_SPAWN_RATE.get();
        config = new OreConfiguration(OreConfiguration.Predicates.NETHERRACK, ModBlocks.NETHER_PROSPERITY_ORE.get().defaultBlockState(), size);
        configuredNetherProsperityOreFeature = Feature.ORE.configured(config)
                .range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(height))))
                .squared()
                .countRandom(rate);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "nether_prosperity_ore"), configuredNetherProsperityOreFeature);

        size = ModConfigs.NETHER_INFERIUM_SPAWN_SIZE.get();
        height = ModConfigs.NETHER_INFERIUM_SPAWN_HEIGHT.get();
        rate = ModConfigs.NETHER_INFERIUM_SPAWN_RATE.get();
        config = new OreConfiguration(OreConfiguration.Predicates.NETHERRACK, ModBlocks.NETHER_INFERIUM_ORE.get().defaultBlockState(), size);
        configuredNetherInferiumOreFeature = Feature.ORE.configured(config)
                .range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(height))))
                .squared()
                .countRandom(rate);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "nether_inferium_ore"), configuredNetherInferiumOreFeature);

        size = ModConfigs.END_PROSPERITY_SPAWN_SIZE.get();
        height = ModConfigs.END_PROSPERITY_SPAWN_HEIGHT.get();
        rate = ModConfigs.END_PROSPERITY_SPAWN_RATE.get();
        config = new OreConfiguration(END_STONE_RULE_TEST, ModBlocks.END_PROSPERITY_ORE.get().defaultBlockState(), size);
        configuredEndProsperityOreFeature = Feature.ORE.configured(config)
                .range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(height))))
                .squared()
                .countRandom(rate);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "end_prosperity_ore"), configuredEndProsperityOreFeature);

        size = ModConfigs.END_INFERIUM_SPAWN_SIZE.get();
        height = ModConfigs.END_INFERIUM_SPAWN_HEIGHT.get();
        rate = ModConfigs.END_INFERIUM_SPAWN_RATE.get();
        config = new OreConfiguration(END_STONE_RULE_TEST, ModBlocks.END_INFERIUM_ORE.get().defaultBlockState(), size);
        configuredEndInferiumOreFeature = Feature.ORE.configured(config)
                .range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(height))))
                .squared()
                .countRandom(rate);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "end_inferium_ore"), configuredEndInferiumOreFeature);
    }
}
