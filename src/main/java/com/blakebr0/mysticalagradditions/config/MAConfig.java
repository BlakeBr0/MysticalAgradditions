package com.blakebr0.mysticalagradditions.config;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MAConfig {
    private static final Logger LOGGER = LogManager.getLogger(MysticalAgradditions.NAME);

    private static ForgeConfigSpec.BooleanValue enchantableSupremiumTools;

    public static void onCommonSetup() {
        try {
            Class<?> clazz = Class.forName("com.blakebr0.mysticalagriculture.config.ModConfigs");
            Object enchantable_supremium_tools = clazz.getDeclaredField("ENCHANTABLE_SUPREMIUM_TOOLS").get(null);

            enchantableSupremiumTools = (ForgeConfigSpec.BooleanValue) enchantable_supremium_tools;
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            LOGGER.error("Failed to load Mystical Agriculture config values", e);
        }
    }

    public static boolean getEnchantableSupremiumTools() {
        if (enchantableSupremiumTools == null)
            return false;

        return enchantableSupremiumTools.get();
    }
}
