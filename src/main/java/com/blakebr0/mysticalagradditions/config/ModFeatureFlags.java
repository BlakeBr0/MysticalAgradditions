package com.blakebr0.mysticalagradditions.config;

import com.blakebr0.cucumber.util.FeatureFlag;
import com.blakebr0.cucumber.util.FeatureFlags;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;

@FeatureFlags
public final class ModFeatureFlags {
    public static final FeatureFlag FERTILIZABLE_CROPS = FeatureFlag.create(MysticalAgradditions.resource("fertilizable_crops"), ModConfigs.FERTILIZABLE_CROPS);
    public static final FeatureFlag GENERATE_END_INFERIUM = FeatureFlag.create(MysticalAgradditions.resource("generate_end_inferium"), ModConfigs.GENERATE_END_INFERIUM);
    public static final FeatureFlag GENERATE_END_PROSPERITY = FeatureFlag.create(MysticalAgradditions.resource("generate_end_prosperity"), ModConfigs.GENERATE_END_PROSPERITY);
    public static final FeatureFlag GENERATE_NETHER_INFERIUM = FeatureFlag.create(MysticalAgradditions.resource("generate_nether_inferium"), ModConfigs.GENERATE_NETHER_INFERIUM);
    public static final FeatureFlag GENERATE_NETHER_PROSPERITY = FeatureFlag.create(MysticalAgradditions.resource("generate_nether_prosperity"), ModConfigs.GENERATE_NETHER_PROSPERITY);

    public static final FeatureFlag ESSENCE_FARMLAND_CONVERSION = FeatureFlag.from(MysticalAgricultureAPI.resource("essence_farmland_conversion"));
}
