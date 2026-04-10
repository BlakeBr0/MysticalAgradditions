package com.blakebr0.mysticalagradditions;

import com.blakebr0.mysticalagradditions.client.handler.FluidModelHandler;
import com.blakebr0.mysticalagradditions.client.handler.TintSourceHandler;
import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.handler.MobDropHandler;
import com.blakebr0.mysticalagradditions.init.ModBiomeModifiers;
import com.blakebr0.mysticalagradditions.init.ModBlocks;
import com.blakebr0.mysticalagradditions.init.ModCreativeModeTabs;
import com.blakebr0.mysticalagradditions.init.ModFluidTypes;
import com.blakebr0.mysticalagradditions.init.ModFluids;
import com.blakebr0.mysticalagradditions.init.ModItems;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(MysticalAgradditions.MOD_ID)
public final class MysticalAgradditions {
    public static final String MOD_ID = "mysticalagradditions";
    public static final String NAME = "Mystical Agradditions";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public MysticalAgradditions(IEventBus bus, ModContainer mod) {
        bus.register(this);
        bus.register(new ModFluids());

        ModBlocks.REGISTRY.register(bus);
        ModItems.REGISTRY.register(bus);
        ModCreativeModeTabs.REGISTRY.register(bus);
        ModBiomeModifiers.REGISTRY.register(bus);
        ModFluidTypes.REGISTRY.register(bus);

        if (ModConfigs.isTConstructInstalled()) {
            // TODO: 1.19, tinkers
//			ModModifiers.REGISTRY.register(bus);
        }

        if (FMLEnvironment.getDist() == Dist.CLIENT) {
            bus.register(new FluidModelHandler());
            bus.register(new TintSourceHandler());
        }

        mod.registerConfig(ModConfig.Type.STARTUP, ModConfigs.COMMON, "mysticalagradditions-common.toml");
    }

    @SubscribeEvent
    public void onCommonSetup(FMLCommonSetupEvent event) {
        NeoForge.EVENT_BUS.register(new MobDropHandler());
    }

    public static Identifier resource(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
