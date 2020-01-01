package com.blakebr0.mysticalagradditions.lib;

import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.items.ModItems;
import com.blakebr0.mysticalagriculture.api.IMysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.MysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.crop.Crop;
import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import com.blakebr0.mysticalagriculture.api.crop.CropType;
import com.blakebr0.mysticalagriculture.api.lib.LazyIngredient;
import com.blakebr0.mysticalagriculture.api.registry.ICropRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

import static com.blakebr0.mysticalagradditions.MysticalAgradditions.MOD_ID;

@MysticalAgriculturePlugin
public class ModCorePlugin implements IMysticalAgriculturePlugin {
    public static final CropTier CROP_TIER_6 = new CropTier(new ResourceLocation(MOD_ID, "6"), 6, 0x40005E, TextFormatting.DARK_PURPLE);

    public static final Crop NETHER_STAR = new Crop(new ResourceLocation(MOD_ID, "nether_star"), CROP_TIER_6, CropType.RESOURCE, LazyIngredient.item("minecraft:nether_star"));
    public static final Crop DRAGON_EGG = new Crop(new ResourceLocation(MOD_ID, "dragon_egg"), CROP_TIER_6, CropType.RESOURCE, LazyIngredient.item("dragon_scale"));

    @Override
    public void onRegisterCrops(ICropRegistry registry) {
        registry.register(NETHER_STAR);
        registry.register(DRAGON_EGG);
    }

    public static void onCommonSetup() {
        CROP_TIER_6.setFarmland(ModBlocks.INSANIUM_FARMLAND.get()).setEssence(ModItems.INSANIUM_ESSENCE.get());
    }
}
