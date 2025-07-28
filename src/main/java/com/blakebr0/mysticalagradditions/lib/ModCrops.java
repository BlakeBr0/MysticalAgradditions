package com.blakebr0.mysticalagradditions.lib;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.init.ModBlocks;
import com.blakebr0.mysticalagriculture.api.crop.Crop;
import com.blakebr0.mysticalagriculture.api.crop.CropType;
import com.blakebr0.mysticalagriculture.api.lib.LazyIngredient;
import com.blakebr0.mysticalagriculture.api.registry.ICropRegistry;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;

import java.util.Arrays;

public final class ModCrops {
    private static final boolean DEBUG = !FMLEnvironment.production;

    public static final Crop NETHER_STAR = new Crop(MysticalAgradditions.resource("nether_star"), ModCropTiers.SIX, CropType.RESOURCE, LazyIngredient.item("minecraft:nether_star"));
    public static final Crop DRAGON_EGG = new Crop(MysticalAgradditions.resource("dragon_egg"), ModCropTiers.SIX, CropType.RESOURCE, LazyIngredient.item("mysticalagradditions:dragon_scale"));

    // BOTANIA
    public static final Crop GAIA_SPIRIT = new Crop(MysticalAgradditions.resource("gaia_spirit"), ModCropTiers.SIX, CropType.RESOURCE, LazyIngredient.item("botania:life_essence"));

    // DRACONIC EVOLUTION
    public static final Crop AWAKENED_DRACONIUM = new Crop(MysticalAgradditions.resource("awakened_draconium"), ModCropTiers.SIX, CropType.RESOURCE, LazyIngredient.tag("forge:ingots/draconium_awakened"));

    // AVARITIA
    public static final Crop NEUTRONIUM = new Crop(MysticalAgradditions.resource("neutronium"), ModCropTiers.SIX, CropType.RESOURCE, LazyIngredient.tag("mysticalagradditions:neutronium_ingot"));

    // POWAH
    public static final Crop NITRO_CRYSTAL = new Crop(MysticalAgradditions.resource("nitro_crystal"), ModCropTiers.SIX, CropType.RESOURCE, LazyIngredient.item("powah:crystal_nitro"));

    public static void onRegisterCrops(ICropRegistry registry) {
        registry.register(NETHER_STAR);
        registry.register(DRAGON_EGG);

        // BOTANIA
        registry.register(withRequiredMods(GAIA_SPIRIT, "botania"));

        // DRACONIC EVOLUTION
        registry.register(withRequiredMods(AWAKENED_DRACONIUM, "draconicevolution"));

        // AVARITIA
        registry.register(withRequiredMods(NEUTRONIUM, "avaritia"));

        // POWAH
        registry.register(withRequiredMods(NITRO_CRYSTAL, "powah"));
    }

    public static void onPostRegisterCrops(ICropRegistry registry) {
        NETHER_STAR.setCruxBlock(ModBlocks.NETHER_STAR_CRUX);
        DRAGON_EGG.setCruxBlock(ModBlocks.DRAGON_EGG_CRUX);
        GAIA_SPIRIT.setCruxBlock(ModBlocks.GAIA_SPIRIT_CRUX);
        AWAKENED_DRACONIUM.setCruxBlock(ModBlocks.AWAKENED_DRACONIUM_CRUX);
        NEUTRONIUM.setCruxBlock(ModBlocks.NEUTRONIUM_CRUX);
        NITRO_CRYSTAL.setCruxBlock(ModBlocks.NITRO_CRYSTAL_CRUX);
    }

    private static Crop withRequiredMods(Crop crop, String... mods) {
        if (DEBUG) return crop;

        var enabled = Arrays.stream(mods).anyMatch(ModList.get()::isLoaded);
        return crop.setEnabled(enabled);
    }
}
