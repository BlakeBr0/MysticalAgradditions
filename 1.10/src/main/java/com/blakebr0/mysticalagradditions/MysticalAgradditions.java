package com.blakebr0.mysticalagradditions;

import com.blakebr0.mysticalagradditions.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = MysticalAgradditions.MOD_ID, name = MysticalAgradditions.NAME, version = MysticalAgradditions.VERSION)
public class MysticalAgradditions {

	public static final String MOD_ID = "mysticalagradditions";
	public static final String NAME = "Mystical Agradditions";
	public static final String VERSION = "1.0.0";
	
	@Instance(MOD_ID)
	public static MysticalAgradditions instance;
	
	@SidedProxy(clientSide = "com.blakebr0.mysticalagradditions.proxy.ClientProxy",
				serverSide = "com.blakebr0.mysticalagradditions.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	@SubscribeEvent
	public void preInit(FMLPreInitializationEvent event){
		proxy.preInit(event);
	}
	
	@SubscribeEvent
	public void init(FMLInitializationEvent event){
		proxy.init(event);
	}
	
	@SubscribeEvent
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit(event);
	}
}
