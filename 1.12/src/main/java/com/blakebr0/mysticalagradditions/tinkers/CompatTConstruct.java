package com.blakebr0.mysticalagradditions.tinkers;

import com.blakebr0.mysticalagradditions.config.ModConfig;
import com.blakebr0.mysticalagradditions.lib.FluidRender;
import com.blakebr0.mysticalagradditions.lib.MAHelper;
import com.blakebr0.mysticalagriculture.util.ModChecker;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.TinkerTraits;

public class CompatTConstruct {
	
	public static Material prosperity;
	public static Material soulium;
	public static Material baseEssence;
	public static Material inferium;
	public static Material prudentium;
	public static Material intermedium;
	public static Material superium;
	public static Material supremium;
	
	public static FluidMolten moltenSoulium;
	public static FluidMolten moltenBaseEssence;
	public static FluidMolten moltenInferium;
	public static FluidMolten moltenPrudentium;
	public static FluidMolten moltenIntermedium;
	public static FluidMolten moltenSuperium;
	public static FluidMolten moltenSupremium;
	
	public static void init(){
		
		if(!ModConfig.confTConstructSupport || !ModChecker.TINKERS_CONSTRUCT){ return; }
		
//		TinkerTools.registerToolForgeBlock("blockBaseEssenceIngot");
//		TinkerTools.registerToolForgeBlock("blockSouliumIngot");
//		TinkerTools.registerToolForgeBlock("blockInferiumIngot");
//		TinkerTools.registerToolForgeBlock("blockPrudentiumIngot");
//		TinkerTools.registerToolForgeBlock("blockIntermediumIngot");
//		TinkerTools.registerToolForgeBlock("blockSuperiumIngot");
//		TinkerTools.registerToolForgeBlock("blockSupremiumIngot");
		
		prosperity = new Material("ma.prosperity", 0xA3C5C5);
		prosperity.addItem(MAHelper.items.itemCrafting.itemProsperityShard, 1, Material.VALUE_Fragment);
		prosperity.setCraftable(true);
		prosperity.setRepresentativeItem(MAHelper.items.itemCrafting.itemProsperityShard);
		TinkerRegistry.addMaterialStats(prosperity, 
                new HeadMaterialStats(36, 0.83F, 0.1F, HarvestLevels.STONE),
                new HandleMaterialStats(0.23F, 8),
                new ExtraMaterialStats(20),
				new BowMaterialStats(1.4f, 0.63f, -1.2f));
		
		soulium = new Material("ma.soulium", 0x564237);
		soulium.addItem(MAHelper.items.itemCrafting.itemSouliumIngot, 1, Material.VALUE_Ingot);
		soulium.setCraftable(true);
		soulium.setRepresentativeItem(MAHelper.items.itemCrafting.itemSouliumIngot);
		TinkerRegistry.addMaterialStats(soulium, 
                new HeadMaterialStats(310, 6.35f, 4.6F, HarvestLevels.IRON),
                new HandleMaterialStats(0.80F, 55),
                new ExtraMaterialStats(48),
                new BowMaterialStats(0.5F, 1.5F, 3.1F));
		moltenSoulium = new FluidMolten("soulium", 0x564237);
		FluidRegistry.registerFluid(moltenSoulium);
		ForgeRegistries.BLOCKS.register(new BlockMolten(moltenSoulium).setRegistryName("molten_" + moltenSoulium.getName()));
		FluidRegistry.addBucketForFluid(moltenSoulium);
		soulium.setFluid(moltenSoulium);
		soulium.setCastable(true);

		baseEssence = new Material("ma.base_essence", 0xD1FFFF);
		baseEssence.addItem(MAHelper.items.itemCrafting.itemBaseEssenceIngot, 1, Material.VALUE_Ingot);
		baseEssence.setRepresentativeItem(MAHelper.items.itemCrafting.itemBaseEssenceIngot);
		TinkerRegistry.addMaterialStats(baseEssence, 
                new HeadMaterialStats(244, 6.65f, 4.33f, HarvestLevels.DIAMOND),
                new HandleMaterialStats(0.7F, 65),
                new ExtraMaterialStats(50),
				new BowMaterialStats(0.5F, 1.5F, 1.02F));
		moltenBaseEssence = new FluidMolten("base_essence", 0xD1FFFF);
		FluidRegistry.registerFluid(moltenBaseEssence);
		ForgeRegistries.BLOCKS.register(new BlockMolten(moltenBaseEssence).setRegistryName("molten_" + moltenBaseEssence.getName()));
		FluidRegistry.addBucketForFluid(moltenBaseEssence);
		baseEssence.setFluid(moltenBaseEssence);
		baseEssence.setCastable(true);
		
		inferium = new Material("ma.inferium", 0x748E00);
		inferium.addItem(MAHelper.items.itemCrafting.itemInferiumIngot, 1, Material.VALUE_Ingot);
		inferium.setRepresentativeItem(MAHelper.items.itemCrafting.itemInferiumIngot);
		TinkerRegistry.addMaterialStats(inferium, 
				new HeadMaterialStats(345, 7.02F, 4.5F, HarvestLevels.DIAMOND),
				new HandleMaterialStats(0.63F, 50), 
				new ExtraMaterialStats(75),
				new BowMaterialStats(0.58F, 0.99F, 1.91F));
		moltenInferium = new FluidMolten("inferium", 0x748E00);
		FluidRegistry.registerFluid(moltenInferium);
		ForgeRegistries.BLOCKS.register(new BlockMolten(moltenInferium).setRegistryName("molten_" + moltenInferium.getName()));
		FluidRegistry.addBucketForFluid(moltenInferium);
		inferium.setFluid(moltenInferium);
		inferium.setCastable(true);
		
		prudentium = new Material("ma.prudentium", 0x008C23);
		prudentium.addItem(MAHelper.items.itemCrafting.itemPrudentiumIngot, 1, Material.VALUE_Ingot);
		prudentium.setRepresentativeItem(MAHelper.items.itemCrafting.itemPrudentiumIngot);
		TinkerRegistry.addMaterialStats(prudentium, 
				new HeadMaterialStats(690, 8.01F, 6.62F, HarvestLevels.DIAMOND),
				new HandleMaterialStats(0.78F, 75), 
				new ExtraMaterialStats(100),
				new BowMaterialStats(0.73F, 1.34F, 2.32F));
		moltenPrudentium = new FluidMolten("prudentium", 0x008C23);
		FluidRegistry.registerFluid(moltenPrudentium);
		ForgeRegistries.BLOCKS.register(new BlockMolten(moltenPrudentium).setRegistryName("molten_" + moltenPrudentium.getName()));
		FluidRegistry.addBucketForFluid(moltenPrudentium);
		prudentium.setFluid(moltenPrudentium);
		prudentium.setCastable(true);
		
		intermedium = new Material("ma.intermedium", 0xB74900);
		intermedium.addItem(MAHelper.items.itemCrafting.itemIntermediumIngot, 1, Material.VALUE_Ingot);
		intermedium.setRepresentativeItem(MAHelper.items.itemCrafting.itemIntermediumIngot);
		TinkerRegistry.addMaterialStats(intermedium, 
				new HeadMaterialStats(1380, 11.08F, 9.23F, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(0.97F, 100), 
				new ExtraMaterialStats(150),
				new BowMaterialStats(1.07F, 1.63F, 4.02F));
		moltenIntermedium = new FluidMolten("intermedium", 0xB74900);
		FluidRegistry.registerFluid(moltenIntermedium);
		ForgeRegistries.BLOCKS.register(new BlockMolten(moltenIntermedium).setRegistryName("molten_" + moltenIntermedium.getName()));
		FluidRegistry.addBucketForFluid(moltenIntermedium);
		intermedium.setFluid(moltenIntermedium);
		intermedium.setCastable(true);
		
		superium = new Material("ma.superium", 0x007FDB);
		superium.addItem(MAHelper.items.itemCrafting.itemSuperiumIngot, 1, Material.VALUE_Ingot);
		superium.setRepresentativeItem(MAHelper.items.itemCrafting.itemSuperiumIngot);
		TinkerRegistry.addMaterialStats(superium, 
				new HeadMaterialStats(2760, 16.53F, 11.62F, HarvestLevels.COBALT),
				new HandleMaterialStats(1.12F, 165), 
				new ExtraMaterialStats(225),
				new BowMaterialStats(1.21F, 1.91F, 5.94F));
		moltenSuperium = new FluidMolten("superium", 0x007FDB);
		FluidRegistry.registerFluid(moltenSuperium);
		ForgeRegistries.BLOCKS.register(new BlockMolten(moltenSuperium).setRegistryName("molten_" + moltenSuperium.getName()));
		FluidRegistry.addBucketForFluid(moltenSuperium);
		superium.setFluid(moltenSuperium);
		superium.setCastable(true);
		
		supremium = new Material("ma.supremium", 0xC40000);
		supremium.addItem(MAHelper.items.itemCrafting.itemSupremiumIngot, 1, Material.VALUE_Ingot);
		supremium.setRepresentativeItem(MAHelper.items.itemCrafting.itemSupremiumIngot);
		TinkerRegistry.addMaterialStats(supremium, 
				new HeadMaterialStats(5520, 22.25F, 15.03F, HarvestLevels.COBALT),
				new HandleMaterialStats(1.35F, 200),
				new ExtraMaterialStats(300),
				new BowMaterialStats(1.33F, 2.35F, 7.32F));
		moltenSupremium = new FluidMolten("supremium", 0xC40000);
		FluidRegistry.registerFluid(moltenSupremium);
		ForgeRegistries.BLOCKS.register(new BlockMolten(moltenSupremium).setRegistryName("molten_" + moltenSupremium.getName()));
		FluidRegistry.addBucketForFluid(moltenSupremium);
		supremium.setFluid(moltenSupremium);
		supremium.setCastable(true);
		
		TinkerRegistry.integrate(prosperity).preInit();
		TinkerRegistry.integrate(soulium, moltenSoulium).preInit();
		TinkerRegistry.integrate(baseEssence, moltenBaseEssence).preInit();
		TinkerRegistry.integrate(inferium, moltenInferium).preInit();
		TinkerRegistry.integrate(prudentium, moltenPrudentium).preInit();
		TinkerRegistry.integrate(intermedium, moltenIntermedium).preInit();
		TinkerRegistry.integrate(superium, moltenSuperium).preInit();
		TinkerRegistry.integrate(supremium, moltenSupremium).preInit();	
	}
	
	@SubscribeEvent
	public void registerRecipes(RegistryEvent.Register<IRecipe> event){
		
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemSouliumNugget, moltenSoulium, 16);
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemSouliumIngot, moltenSoulium, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 6), moltenSoulium, 1296);
		
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemBaseEssenceNugget, moltenBaseEssence, 16);
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemBaseEssenceIngot, moltenBaseEssence, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 0), moltenBaseEssence, 1296);
		
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemInferiumNugget, moltenInferium, 16);
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemInferiumIngot, moltenInferium, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 1), moltenInferium, 1296);
		
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemPrudentiumNugget, moltenPrudentium, 16);
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemPrudentiumIngot, moltenPrudentium, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 2), moltenPrudentium, 1296);
		
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemIntermediumNugget, moltenIntermedium, 16);
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemIntermediumIngot, moltenIntermedium, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 3), moltenIntermedium, 1296);
		
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemSuperiumNugget, moltenSuperium, 16);
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemSuperiumIngot, moltenSuperium, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 4), moltenSuperium, 1296);
		
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemSupremiumNugget, moltenSupremium, 16);
		TinkerRegistry.registerMelting(MAHelper.items.itemCrafting.itemSupremiumIngot, moltenSupremium, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 5), moltenSupremium, 1296);
		
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemBaseEssenceNugget, TinkerSmeltery.castNugget, moltenBaseEssence, 16);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemInferiumNugget, TinkerSmeltery.castNugget, moltenInferium, 16);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemPrudentiumNugget, TinkerSmeltery.castNugget, moltenPrudentium, 16);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemIntermediumNugget, TinkerSmeltery.castNugget, moltenIntermedium, 16);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemSuperiumNugget, TinkerSmeltery.castNugget, moltenSuperium, 16);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemSupremiumNugget, TinkerSmeltery.castNugget, moltenSupremium, 16);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemSouliumNugget, TinkerSmeltery.castNugget, moltenSoulium, 16);
			
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemBaseEssenceIngot, TinkerSmeltery.castIngot, moltenBaseEssence, 144);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemInferiumIngot, TinkerSmeltery.castIngot, moltenInferium, 144);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemPrudentiumIngot, TinkerSmeltery.castIngot, moltenPrudentium, 144);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemIntermediumIngot, TinkerSmeltery.castIngot, moltenIntermedium, 144);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemSuperiumIngot, TinkerSmeltery.castIngot, moltenSuperium, 144);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemSupremiumIngot, TinkerSmeltery.castIngot, moltenSupremium, 144);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemCrafting.itemSouliumIngot, TinkerSmeltery.castIngot, moltenSoulium, 144);
			
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 0), ItemStack.EMPTY, moltenBaseEssence, 1296);
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 1), ItemStack.EMPTY, moltenInferium, 1296);
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 2), ItemStack.EMPTY, moltenPrudentium, 1296);
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 3), ItemStack.EMPTY, moltenIntermedium, 1296);
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 4), ItemStack.EMPTY, moltenSuperium, 1296);
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 5), ItemStack.EMPTY, moltenSupremium, 1296);
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockIngotStorage, 1, 6), ItemStack.EMPTY, moltenSoulium, 1296);	
	}
	
	public static void initTraits() {
		prosperity.addTrait(TinkerTraits.writable2, MaterialTypes.HEAD);
		prosperity.addTrait(TinkerTraits.writable);
		soulium.addTrait(TraitChunky.getTrait(), MaterialTypes.HEAD);
		baseEssence.addTrait(TraitProsperous.getTrait());
		inferium.addTrait(TraitProsperous.getTrait());
		prudentium.addTrait(TraitProsperous.getTrait());
		intermedium.addTrait(TraitProsperous.getTrait());
		superium.addTrait(TraitProsperous.getTrait());
		supremium.addTrait(TraitProsperous.getTrait());
		supremium.addTrait(TraitProsperous.getTrait(), MaterialTypes.HEAD);
		supremium.addTrait(TinkerTraits.duritos, MaterialTypes.HEAD);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initFluidModels(){
		
		if(!ModConfig.confTConstructSupport || !ModChecker.TINKERS_CONSTRUCT){ return; }
		
		FluidRender.mapFluidState(moltenSoulium);
		FluidRender.mapFluidState(moltenBaseEssence);
		FluidRender.mapFluidState(moltenInferium);
		FluidRender.mapFluidState(moltenPrudentium);
		FluidRender.mapFluidState(moltenIntermedium);
		FluidRender.mapFluidState(moltenSuperium);
		FluidRender.mapFluidState(moltenSupremium);
	}
}
