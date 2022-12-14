package com.blakebr0.mysticalagradditions.lib;

import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.init.ModBlocks;
import com.blakebr0.mysticalagradditions.init.ModItems;
import com.blakebr0.mysticalagriculture.api.IMysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.MysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.crop.Crop;
import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import com.blakebr0.mysticalagriculture.api.crop.CropType;
import com.blakebr0.mysticalagriculture.api.lib.LazyIngredient;
import com.blakebr0.mysticalagriculture.api.lib.PluginConfig;
import com.blakebr0.mysticalagriculture.api.registry.ICropRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;

import java.util.Arrays;

import static com.blakebr0.mysticalagradditions.MysticalAgradditions.MOD_ID;

@MysticalAgriculturePlugin
public final class ModCorePlugin implements IMysticalAgriculturePlugin {
    private static final boolean DEBUG = false;

    public static final CropTier CROP_TIER_6 = new CropTier(new ResourceLocation(MOD_ID, "6"), 6, 0x40005E, ChatFormatting.DARK_PURPLE);

    public static final Crop NETHER_STAR = new Crop(new ResourceLocation(MOD_ID, "nether_star"), CROP_TIER_6, CropType.RESOURCE, LazyIngredient.item("minecraft:nether_star"));
    public static final Crop DRAGON_EGG = new Crop(new ResourceLocation(MOD_ID, "dragon_egg"), CROP_TIER_6, CropType.RESOURCE, LazyIngredient.item("mysticalagradditions:dragon_scale"));

    // BOTANIA
    public static final Crop GAIA_SPIRIT = new Crop(new ResourceLocation(MOD_ID, "gaia_spirit"), CROP_TIER_6, CropType.RESOURCE, LazyIngredient.item("botania:life_essence"));

    // DRACONIC EVOLUTION
    public static final Crop AWAKENED_DRACONIUM = new Crop(new ResourceLocation(MOD_ID, "awakened_draconium"), CROP_TIER_6, CropType.RESOURCE, LazyIngredient.tag("forge:ingots/draconium_awakened"));

    // AVARITIA
    public static final Crop NEUTRONIUM = new Crop(new ResourceLocation(MOD_ID, "neutronium"), CROP_TIER_6, CropType.RESOURCE, LazyIngredient.item("avaritia:neutronium_ingot"));

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
        registry.registerTier(CROP_TIER_6);

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

    @Override
    public void onPostRegisterCrops(ICropRegistry registry) {
        CROP_TIER_6.setFarmland(ModBlocks.INSANIUM_FARMLAND)
                .setEssence(ModItems.INSANIUM_ESSENCE)
                .setFertilizable(ModConfigs.FERTILIZABLE_CROPS.get())
                .setSecondarySeedDrop(false);

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
