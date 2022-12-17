package com.blakebr0.mysticalagradditions.init;

import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import com.blakebr0.mysticalagriculture.api.registry.ICropRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;

import static com.blakebr0.mysticalagradditions.MysticalAgradditions.MOD_ID;

public final class ModCropTiers {
    public static final CropTier SIX = new CropTier(new ResourceLocation(MOD_ID, "6"), 6, 0x40005E, ChatFormatting.DARK_PURPLE);

    public static void onRegisterCrops(ICropRegistry registry) {
        registry.registerTier(SIX);
    }

    public static void onPostRegisterCrops(ICropRegistry registry) {
        SIX.setFarmland(ModBlocks.INSANIUM_FARMLAND)
                .setEssence(ModItems.INSANIUM_ESSENCE)
                .setFertilizable(ModConfigs.FERTILIZABLE_CROPS.get())
                .setSecondarySeedDrop(false);
    }
}
