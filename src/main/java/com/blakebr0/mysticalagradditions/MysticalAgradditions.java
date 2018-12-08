package com.blakebr0.mysticalagradditions;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.blakebr0.mysticalagradditions.items.ModItems;
import com.blakebr0.mysticalagradditions.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MysticalAgradditions.MOD_ID, name = MysticalAgradditions.NAME, version = MysticalAgradditions.VERSION, dependencies = MysticalAgradditions.DEPENDENCIES, guiFactory = MysticalAgradditions.GUI_FACTORY)
public class MysticalAgradditions {

	public static final String MOD_ID = "mysticalagradditions";
	public static final String NAME = "Mystical Agradditions";
	public static final String VERSION = "${version}";
	public static final String DEPENDENCIES = "required-after:mysticalagriculture@[1.7.0,);required-after:cucumber@[1.1.2,);after:mantle;after:tconstruct";
	public static final String GUI_FACTORY = "com.blakebr0.mysticalagradditions.config.GuiFactory";
	
	public static final ModRegistry REGISTRY = new ModRegistry(MOD_ID);
	
	@Instance(MOD_ID)
	public static MysticalAgradditions instance;
	
	@SidedProxy(clientSide = "com.blakebr0.mysticalagradditions.proxy.ClientProxy",
				serverSide = "com.blakebr0.mysticalagradditions.proxy.ServerProxy")
	public static CommonProxy proxy;
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit(event);
	}
	
	public static CreativeTabs tabMysticalAgradditions = new CreativeTabs("tab.mystical_agradditions.name"){
		
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(ModItems.itemInsanium, 1, 0);
		}
	};
}
