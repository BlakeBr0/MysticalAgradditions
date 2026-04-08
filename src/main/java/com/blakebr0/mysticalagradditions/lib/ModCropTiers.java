package com.blakebr0.mysticalagradditions.lib;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.init.ModBlocks;
import com.blakebr0.mysticalagradditions.init.ModItems;
import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import com.blakebr0.mysticalagriculture.api.registry.ICropRegistry;
import net.minecraft.ChatFormatting;

public final class ModCropTiers {
    public static final CropTier SIX = new CropTier(MysticalAgradditions.resource("6"), 6, 0x40005E, ChatFormatting.DARK_PURPLE);

    public static void onRegisterCrops(ICropRegistry registry) {
        registry.registerTier(SIX);
    }

    public static void onPostRegisterCrops(ICropRegistry registry) {
        SIX.setFarmlandBlock(ModBlocks.INSANIUM_FARMLAND)
                .setEssenceItem(ModItems.INSANIUM_ESSENCE)
                .setFertilizable(ModConfigs.FERTILIZABLE_CROPS.get())
                .setSecondarySeedDrop(false);
    }
}
