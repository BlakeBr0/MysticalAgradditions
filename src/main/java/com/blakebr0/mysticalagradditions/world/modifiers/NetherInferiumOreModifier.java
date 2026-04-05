package com.blakebr0.mysticalagradditions.world.modifiers;

import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.init.ModBiomeModifiers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;

public record NetherInferiumOreModifier(HolderSet<Biome> biomes, Holder<PlacedFeature> feature) implements BiomeModifier {
    public static final MapCodec<NetherInferiumOreModifier> MAP_CODEC = RecordCodecBuilder.mapCodec(builder ->
            builder.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(NetherInferiumOreModifier::biomes),
                    PlacedFeature.CODEC.fieldOf("feature").forGetter(NetherInferiumOreModifier::feature)
            ).apply(builder, NetherInferiumOreModifier::new)
    );

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD && ModConfigs.GENERATE_NETHER_INFERIUM.get() && this.biomes.contains(biome)) {
            builder.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, this.feature);
        }
    }

    @Override
    public MapCodec<? extends BiomeModifier> codec() {
        return ModBiomeModifiers.NETHER_INFERIUM_ORE.get();
    }
}
