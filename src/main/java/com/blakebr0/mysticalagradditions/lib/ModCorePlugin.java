package com.blakebr0.mysticalagradditions.lib;

import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.init.ModBlocks;
import com.blakebr0.mysticalagradditions.init.ModItems;
import com.blakebr0.mysticalagriculture.api.IMysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.MysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.crop.Crop;
import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import com.blakebr0.mysticalagriculture.api.crop.CropType;
import com.blakebr0.mysticalagriculture.api.crop.ICrop;
import com.blakebr0.mysticalagriculture.api.lib.LazyIngredient;
import com.blakebr0.mysticalagriculture.api.lib.PluginConfig;
import com.blakebr0.mysticalagriculture.api.registry.ICropRegistry;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.ChatFormatting;
import net.minecraftforge.fml.ModList;

import java.util.Arrays;

import static com.blakebr0.mysticalagradditions.MysticalAgradditions.MOD_ID;

@MysticalAgriculturePlugin
public final class ModCorePlugin implements IMysticalAgriculturePlugin {
    private static final boolean DEBUG = false;

    public static final CropTier CROP_TIER_6 = new CropTier(new ResourceLocation(MOD_ID, "6"), 6, 0x40005E, ChatFormatting.DARK_PURPLE);

    public static final Crop NETHER_STAR = new Crop(new ResourceLocation(MOD_ID, "nether_star"), CROP_TIER_6, CropType.RESOURCE, LazyIngredient.item("minecraft:nether_star"));
    public static final Crop DRAGON_EGG = new Crop(new ResourceLocation(MOD_ID, "dragon_egg"), CROP_TIER_6, CropType.RESOURCE, LazyIngredient.item("mysticalagradditions:dragon_scale"));

    // POWAH
    public static final Crop NITRO_CRYSTAL = new Crop(new ResourceLocation(MOD_ID, "nitro_crystal"), CROP_TIER_6, CropType.RESOURCE, LazyIngredient.item("powah:crystal_nitro"));

    @Override
    public void configure(PluginConfig config) {
        config.setModId(MOD_ID);
        config.disableDynamicSeedCraftingRecipes();
        config.disableDynamicSeedInfusionRecipes();
        config.disableDynamicSeedReprocessingRecipes();
    }

    @Override
    public void onRegisterCrops(ICropRegistry registry) {
        registry.register(NETHER_STAR);
        registry.register(DRAGON_EGG);

        // POWAH
        registry.register(withRequiredMods(NITRO_CRYSTAL, "powah"));
    }

    public static void onCommonSetup() {
        CROP_TIER_6.setFarmland(() -> (FarmBlock) ModBlocks.INSANIUM_FARMLAND.get())
                .setEssence(ModItems.INSANIUM_ESSENCE)
                .setFertilizable(ModConfigs.FERTILIZABLE_CROPS.get())
                .setSecondarySeedDrop(false);

        NETHER_STAR.setCrux(ModBlocks.NETHER_STAR_CRUX);
        DRAGON_EGG.setCrux(ModBlocks.DRAGON_EGG_CRUX);
        NITRO_CRYSTAL.setCrux(ModBlocks.NITRO_CRYSTAL_CRUX);
    }

    private static ICrop withRequiredMods(ICrop crop, String... mods) {
        if (DEBUG) return crop;

        boolean enabled = Arrays.stream(mods).anyMatch(ModList.get()::isLoaded);
        return crop.setEnabled(enabled);
    }
}
