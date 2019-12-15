package com.blakebr0.mysticalagradditions;

import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.handler.MobDropsHandler;
import com.blakebr0.mysticalagradditions.items.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MysticalAgradditions.MOD_ID)
public class MysticalAgradditions {
	public static final String MOD_ID = "mysticalagradditions";
	public static final String NAME = "Mystical Agradditions";

	public static final ItemGroup ITEM_GROUP = new MAItemGroup();

	public MysticalAgradditions() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.register(this);
		bus.register(new ModBlocks());
		bus.register(new ModItems());
	}

	@SubscribeEvent
	public void onCommonSetup(FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new MobDropsHandler());
	}
}
