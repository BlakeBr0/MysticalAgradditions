package com.blakebr0.mysticalagradditions.world;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.init.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public final class ModWorldgenRegistration {
    private static final RuleTest END_STONE_RULE_TEST = new BlockMatchTest(Blocks.END_STONE);

    private static PlacedFeature placedNetherProsperityOreFeature;
    private static PlacedFeature placedNetherInferiumOreFeature;
    private static PlacedFeature placedEndProsperityOreFeature;
    private static PlacedFeature placedEndInferiumOreFeature;

    @SubscribeEvent
    public void onBiomesLoading(BiomeLoadingEvent event) {
        var category = event.getCategory();
        var generation = event.getGeneration();

        switch (category) {
            case NETHER -> {
                if (ModConfigs.GENERATE_NETHER_PROSPERITY.get()) {
                    generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, placedNetherProsperityOreFeature);
                }
                if (ModConfigs.GENERATE_NETHER_INFERIUM.get()) {
                    generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, placedNetherInferiumOreFeature);
                }
            }
            case THEEND -> {
                if (ModConfigs.GENERATE_END_PROSPERITY.get()) {
                    generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, placedEndProsperityOreFeature);
                }
                if (ModConfigs.GENERATE_END_INFERIUM.get()) {
                    generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, placedEndInferiumOreFeature);
                }
            }
            default -> { }
        }
    }

    public static void onCommonSetup() {
        int size, rate, height;
        List<OreConfiguration.TargetBlockState> targets;
        ConfiguredFeature<OreConfiguration, ?> feature;

        size = ModConfigs.NETHER_PROSPERITY_SPAWN_SIZE.get();
        height = ModConfigs.NETHER_PROSPERITY_SPAWN_HEIGHT.get();
        rate = ModConfigs.NETHER_PROSPERITY_SPAWN_RATE.get();
        targets = List.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_PROSPERITY_ORE.get().defaultBlockState()));
        feature = Feature.ORE.configured(new OreConfiguration(targets, size));

        placedNetherProsperityOreFeature = feature.placed(List.of(
                CountPlacement.of(rate),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(height)),
                BiomeFilter.biome()
        ));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "nether_prosperity_ore"), feature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "nether_prosperity_ore"), placedNetherProsperityOreFeature);

        size = ModConfigs.NETHER_INFERIUM_SPAWN_SIZE.get();
        height = ModConfigs.NETHER_INFERIUM_SPAWN_HEIGHT.get();
        rate = ModConfigs.NETHER_INFERIUM_SPAWN_RATE.get();
        targets = List.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_INFERIUM_ORE.get().defaultBlockState()));
        feature = Feature.ORE.configured(new OreConfiguration(targets, size));

        placedNetherInferiumOreFeature = feature.placed(List.of(
                CountPlacement.of(rate),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(height)),
                BiomeFilter.biome()
        ));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "nether_inferium_ore"), feature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "nether_inferium_ore"), placedNetherInferiumOreFeature);

        size = ModConfigs.END_PROSPERITY_SPAWN_SIZE.get();
        height = ModConfigs.END_PROSPERITY_SPAWN_HEIGHT.get();
        rate = ModConfigs.END_PROSPERITY_SPAWN_RATE.get();
        targets = List.of(OreConfiguration.target(END_STONE_RULE_TEST, ModBlocks.END_PROSPERITY_ORE.get().defaultBlockState()));
        feature = Feature.ORE.configured(new OreConfiguration(targets, size));

        placedEndProsperityOreFeature = feature.placed(List.of(
                CountPlacement.of(rate),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(height)),
                BiomeFilter.biome()
        ));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "end_prosperity_ore"), feature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "end_prosperity_ore"), placedEndProsperityOreFeature);

        size = ModConfigs.END_INFERIUM_SPAWN_SIZE.get();
        height = ModConfigs.END_INFERIUM_SPAWN_HEIGHT.get();
        rate = ModConfigs.END_INFERIUM_SPAWN_RATE.get();
        targets = List.of(OreConfiguration.target(END_STONE_RULE_TEST, ModBlocks.END_INFERIUM_ORE.get().defaultBlockState()));
        feature = Feature.ORE.configured(new OreConfiguration(targets, size));

        placedEndInferiumOreFeature = feature.placed(List.of(
                CountPlacement.of(rate),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(height)),
                BiomeFilter.biome()
        ));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "end_inferium_ore"), feature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(MysticalAgradditions.MOD_ID, "end_inferium_ore"), placedEndInferiumOreFeature);
    }
}
