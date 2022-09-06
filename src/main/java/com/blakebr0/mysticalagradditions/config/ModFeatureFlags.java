package com.blakebr0.mysticalagradditions.config;

import com.blakebr0.cucumber.util.FeatureFlag;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import net.minecraft.resources.ResourceLocation;

public final class ModFeatureFlags {
    public static final FeatureFlag FERTILIZABLE_CROPS = FeatureFlag.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "fertilizable_crops"), ModConfigs.FERTILIZABLE_CROPS);
    public static final FeatureFlag GENERATE_END_INFERIUM = FeatureFlag.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "generate_end_inferium"), ModConfigs.GENERATE_END_INFERIUM);
    public static final FeatureFlag GENERATE_END_PROSPERITY = FeatureFlag.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "generate_end_prosperity"), ModConfigs.GENERATE_END_PROSPERITY);
    public static final FeatureFlag GENERATE_NETHER_INFERIUM = FeatureFlag.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "generate_nether_inferium"), ModConfigs.GENERATE_NETHER_INFERIUM);
    public static final FeatureFlag GENERATE_NETHER_PROSPERITY = FeatureFlag.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "generate_nether_prosperity"), ModConfigs.GENERATE_NETHER_PROSPERITY);
    public static final FeatureFlag HIDE_UNUSED_CRUXES = FeatureFlag.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "hide_unused_cruxes"), ModConfigs.HIDE_UNUSED_CRUXES);
}
