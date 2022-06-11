package com.blakebr0.mysticalagradditions.world.modifiers;

import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.init.ModBiomeModifiers;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public record EndProsperityOreModifier(HolderSet<Biome> biomes, Holder<PlacedFeature> feature) implements BiomeModifier {
    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD && ModConfigs.GENERATE_END_PROSPERITY.get() && this.biomes.contains(biome)) {
            builder.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, this.feature);
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return ModBiomeModifiers.END_PROSPERITY_ORE.get();
    }
}
