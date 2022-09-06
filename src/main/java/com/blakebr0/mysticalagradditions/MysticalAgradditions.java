package com.blakebr0.mysticalagradditions;

import com.blakebr0.cucumber.helper.ConfigHelper;
import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.handler.ColorHandler;
import com.blakebr0.mysticalagradditions.handler.MobDropsHandler;
import com.blakebr0.mysticalagradditions.init.ModBiomeModifiers;
import com.blakebr0.mysticalagradditions.init.ModBlocks;
import com.blakebr0.mysticalagradditions.init.ModFluidTypes;
import com.blakebr0.mysticalagradditions.init.ModFluids;
import com.blakebr0.mysticalagradditions.init.ModItems;
import com.blakebr0.mysticalagradditions.world.ModWorldgenRegistration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(MysticalAgradditions.MOD_ID)
public final class MysticalAgradditions {
	public static final String MOD_ID = "mysticalagradditions";
	public static final String NAME = "Mystical Agradditions";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
	public static final CreativeModeTab CREATIVE_TAB = new MACreativeTab();

	public MysticalAgradditions() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.register(this);
		bus.register(new ModFluids());

		ModBlocks.REGISTRY.register(bus);
		ModItems.REGISTRY.register(bus);
		ModBiomeModifiers.REGISTRY.register(bus);
		ModFluidTypes.REGISTRY.register(bus);

		if (ModConfigs.isTConstructInstalled()) {
			// TODO: 1.19, tinkers
//			ModModifiers.REGISTRY.register(bus);
		}

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			bus.register(new ColorHandler());
		});

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.COMMON);

		ConfigHelper.load(ModConfigs.COMMON, "mysticalagradditions-common.toml");
	}

	@SubscribeEvent
	public void onCommonSetup(FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new MobDropsHandler());

		event.enqueueWork(() -> {
			ModWorldgenRegistration.onCommonSetup();
		});
	}
}
