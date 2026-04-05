package com.blakebr0.mysticalagradditions.init;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.world.modifiers.EndInferiumOreModifier;
import com.blakebr0.mysticalagradditions.world.modifiers.EndProsperityOreModifier;
import com.blakebr0.mysticalagradditions.world.modifiers.NetherInferiumOreModifier;
import com.blakebr0.mysticalagradditions.world.modifiers.NetherProsperityOreModifier;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class ModBiomeModifiers {
    public static final DeferredRegister<MapCodec<? extends BiomeModifier>> REGISTRY = DeferredRegister.create(NeoForgeRegistries.BIOME_MODIFIER_SERIALIZERS, MysticalAgradditions.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<NetherProsperityOreModifier>> NETHER_PROSPERITY_ORE = REGISTRY.register("nether_prosperity_ore", () -> NetherProsperityOreModifier.MAP_CODEC);
    public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<NetherInferiumOreModifier>> NETHER_INFERIUM_ORE = REGISTRY.register("nether_inferium_ore", () -> NetherInferiumOreModifier.MAP_CODEC);
    public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<EndProsperityOreModifier>> END_PROSPERITY_ORE = REGISTRY.register("end_prosperity_ore", () -> EndProsperityOreModifier.MAP_CODEC);
    public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<EndInferiumOreModifier>> END_INFERIUM_ORE = REGISTRY.register("end_inferium_ore", () -> EndInferiumOreModifier.MAP_CODEC);
}
