package com.blakebr0.mysticalagradditions.tinkers;

import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.config.ModConfig;
import com.blakebr0.mysticalagradditions.lib.FluidRender;
import com.blakebr0.mysticalagradditions.lib.MAHelper;
import com.blakebr0.mysticalagriculture.util.ModChecker;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.TinkerIntegration;
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
import slimeknights.tconstruct.smeltery.block.BlockMolten;
import slimeknights.tconstruct.tools.TinkerTools;
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
		
		if(!ModConfig.confTConstructSupport || !ModChecker.TINKERS){ return; }
		
		TinkerTools.registerToolForgeBlock("blockBaseEssenceIngot");
		TinkerTools.registerToolForgeBlock("blockSouliumIngot");
		TinkerTools.registerToolForgeBlock("blockInferiumIngot");
		TinkerTools.registerToolForgeBlock("blockPrudentiumIngot");
		TinkerTools.registerToolForgeBlock("blockIntermediumIngot");
		TinkerTools.registerToolForgeBlock("blockSuperiumIngot");
		TinkerTools.registerToolForgeBlock("blockSupremiumIngot");
		
		prosperity = new Material("ma.prosperity", 0xA3C5C5);
		prosperity.addItem(new ItemStack(MAHelper.items.itemProsperityShard, 1, 0), 1, Material.VALUE_Fragment);
		prosperity.setCraftable(true);
		prosperity.setRepresentativeItem(new ItemStack(MAHelper.items.itemProsperityShard, 1, 0));
		prosperity.addTrait(TinkerTraits.writable2, MaterialTypes.HEAD);
		prosperity.addTrait(TinkerTraits.writable);
		TinkerRegistry.addMaterialStats(prosperity, 
                new HeadMaterialStats(36, 0.83F, 0.1F, HarvestLevels.STONE),
                new HandleMaterialStats(0.23F, 8),
                new ExtraMaterialStats(20),
				new BowMaterialStats(1.4f, 0.63f, -1.2f));
		TinkerIntegration.integrate(prosperity).integrate();
		
		soulium = new Material("ma.soulium", 0x564237);
		soulium.addItem(new ItemStack(MAHelper.items.itemSouliumIngot, 1, 0), 1, Material.VALUE_Ingot);
		soulium.setCraftable(true);
		soulium.setRepresentativeItem(new ItemStack(MAHelper.items.itemSouliumIngot, 1, 0));
		soulium.addTrait(TraitChunky.getTrait(), MaterialTypes.HEAD);
		TinkerRegistry.addMaterialStats(soulium, 
                new HeadMaterialStats(310, 6.35f, 4.6F, HarvestLevels.IRON),
                new HandleMaterialStats(0.80F, 55),
                new ExtraMaterialStats(48),
                new BowMaterialStats(0.5F, 1.5F, 3.1F));
		moltenSoulium = new FluidMolten("soulium", 0x564237);
		FluidRegistry.registerFluid(moltenSoulium);
		ModBlocks.registerBlock(new BlockMolten(moltenSoulium).setRegistryName("molten_" + moltenSoulium.getName()));
		FluidRegistry.addBucketForFluid(moltenSoulium);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemNugget, 1, 6), moltenSoulium, 16);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemSouliumIngot, 1, 0), moltenSoulium, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockSouliumIngot, 1, 0), moltenSoulium, 1296);
		soulium.setFluid(moltenSoulium);
		soulium.setCastable(true);
		TinkerIntegration.integrate(soulium, moltenSoulium).integrate();

		baseEssence = new Material("ma.base_essence", 0xD1FFFF);
		baseEssence.addItem(new ItemStack(MAHelper.items.itemBaseEssenceIngot, 1, 0), 1, Material.VALUE_Ingot);
		baseEssence.setRepresentativeItem(new ItemStack(MAHelper.items.itemBaseEssenceIngot, 1, 0));
		baseEssence.addTrait(TraitProsperous.getTrait());
		TinkerRegistry.addMaterialStats(baseEssence, 
                new HeadMaterialStats(244, 6.65f, 4.33f, HarvestLevels.DIAMOND),
                new HandleMaterialStats(0.7F, 65),
                new ExtraMaterialStats(50),
				new BowMaterialStats(0.5F, 1.5F, 1.02F));
		moltenBaseEssence = new FluidMolten("base_essence", 0xD1FFFF);
		FluidRegistry.registerFluid(moltenBaseEssence);
		ModBlocks.registerBlock(new BlockMolten(moltenBaseEssence).setRegistryName("molten_" + moltenBaseEssence.getName()));
		FluidRegistry.addBucketForFluid(moltenBaseEssence);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemNugget, 1, 0), moltenBaseEssence, 16);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemBaseEssenceIngot, 1, 0), moltenBaseEssence, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockBaseEssenceIngot, 1, 0), moltenBaseEssence, 1296);
		baseEssence.setFluid(moltenBaseEssence);
		baseEssence.setCastable(true);
		TinkerIntegration.integrate(baseEssence, moltenBaseEssence).integrate();
		
		inferium = new Material("ma.inferium", 0x748E00);
		inferium.addItem(new ItemStack(MAHelper.items.itemInferiumIngot, 1, 0), 1, Material.VALUE_Ingot);
		inferium.setRepresentativeItem(new ItemStack(MAHelper.items.itemInferiumIngot, 1, 0));
		inferium.addTrait(TraitProsperous.getTrait());
		TinkerRegistry.addMaterialStats(inferium, 
				new HeadMaterialStats(345, 7.02F, 4.5F, HarvestLevels.DIAMOND),
				new HandleMaterialStats(0.63F, 50), 
				new ExtraMaterialStats(75),
				new BowMaterialStats(0.58F, 0.99F, 1.91F));
		moltenInferium = new FluidMolten("inferium", 0x748E00);
		FluidRegistry.registerFluid(moltenInferium);
		ModBlocks.registerBlock(new BlockMolten(moltenInferium).setRegistryName("molten_" + moltenInferium.getName()));
		FluidRegistry.addBucketForFluid(moltenInferium);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemNugget, 1, 1), moltenInferium, 16);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemInferiumIngot, 1, 0), moltenInferium, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockInferiumIngot, 1, 0), moltenInferium, 1296);
		inferium.setFluid(moltenInferium);
		inferium.setCastable(true);
		TinkerIntegration.integrate(inferium, moltenInferium).integrate();
		
		prudentium = new Material("ma.prudentium", 0x008C23);
		prudentium.addItem(new ItemStack(MAHelper.items.itemPrudentiumIngot, 1, 0), 1, Material.VALUE_Ingot);
		prudentium.setRepresentativeItem(new ItemStack(MAHelper.items.itemPrudentiumIngot, 1, 0));
		prudentium.addTrait(TraitProsperous.getTrait());
		TinkerRegistry.addMaterialStats(prudentium, 
				new HeadMaterialStats(690, 8.01F, 6.62F, HarvestLevels.DIAMOND),
				new HandleMaterialStats(0.78F, 75), 
				new ExtraMaterialStats(100),
				new BowMaterialStats(0.73F, 1.34F, 2.32F));
		moltenPrudentium = new FluidMolten("prudentium", 0x008C23);
		FluidRegistry.registerFluid(moltenPrudentium);
		ModBlocks.registerBlock(new BlockMolten(moltenPrudentium).setRegistryName("molten_" + moltenPrudentium.getName()));
		FluidRegistry.addBucketForFluid(moltenPrudentium);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemNugget, 1, 2), moltenPrudentium, 16);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemPrudentiumIngot, 1, 0), moltenPrudentium, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockPrudentiumIngot, 1, 0), moltenPrudentium, 1296);
		prudentium.setFluid(moltenPrudentium);
		prudentium.setCastable(true);
		TinkerIntegration.integrate(prudentium, moltenPrudentium).integrate();
		
		intermedium = new Material("ma.intermedium", 0xB74900);
		intermedium.addItem(new ItemStack(MAHelper.items.itemIntermediumIngot, 1, 0), 1, Material.VALUE_Ingot);
		intermedium.setRepresentativeItem(new ItemStack(MAHelper.items.itemIntermediumIngot, 1, 0));
		intermedium.addTrait(TraitProsperous.getTrait());
		TinkerRegistry.addMaterialStats(intermedium, 
				new HeadMaterialStats(1380, 11.08F, 9.23F, HarvestLevels.OBSIDIAN),
				new HandleMaterialStats(0.97F, 100), 
				new ExtraMaterialStats(150),
				new BowMaterialStats(1.07F, 1.63F, 4.02F));
		moltenIntermedium = new FluidMolten("intermedium", 0xB74900);
		FluidRegistry.registerFluid(moltenIntermedium);
		ModBlocks.registerBlock(new BlockMolten(moltenIntermedium).setRegistryName("molten_" + moltenIntermedium.getName()));
		FluidRegistry.addBucketForFluid(moltenIntermedium);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemNugget, 1, 3), moltenIntermedium, 16);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemIntermediumIngot, 1, 0), moltenIntermedium, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockIntermediumIngot, 1, 0), moltenIntermedium, 1296);
		intermedium.setFluid(moltenIntermedium);
		intermedium.setCastable(true);
		TinkerIntegration.integrate(intermedium, moltenIntermedium).integrate();
		
		superium = new Material("ma.superium", 0x007FDB);
		superium.addItem(new ItemStack(MAHelper.items.itemSuperiumIngot, 1, 0), 1, Material.VALUE_Ingot);
		superium.setRepresentativeItem(new ItemStack(MAHelper.items.itemSuperiumIngot, 1, 0));
		superium.addTrait(TraitProsperous.getTrait());
		TinkerRegistry.addMaterialStats(superium, 
				new HeadMaterialStats(2760, 16.53F, 11.62F, HarvestLevels.COBALT),
				new HandleMaterialStats(1.12F, 165), 
				new ExtraMaterialStats(225),
				new BowMaterialStats(1.21F, 1.91F, 5.94F));
		moltenSuperium = new FluidMolten("superium", 0x007FDB);
		FluidRegistry.registerFluid(moltenSuperium);
		ModBlocks.registerBlock(new BlockMolten(moltenSuperium).setRegistryName("molten_" + moltenSuperium.getName()));
		FluidRegistry.addBucketForFluid(moltenSuperium);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemNugget, 1, 4), moltenSuperium, 16);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemSuperiumIngot, 1, 0), moltenSuperium, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockSuperiumIngot, 1, 0), moltenSuperium, 1296);
		superium.setFluid(moltenSuperium);
		superium.setCastable(true);
		TinkerIntegration.integrate(superium, moltenSuperium).integrate();
		
		supremium = new Material("ma.supremium", 0xC40000);	
		supremium.addItem(new ItemStack(MAHelper.items.itemSupremiumIngot, 1, 0), 1, Material.VALUE_Ingot);
		supremium.setRepresentativeItem(new ItemStack(MAHelper.items.itemSupremiumIngot, 1, 0));
		supremium.addTrait(TraitProsperous.getTrait());
		supremium.addTrait(TinkerTraits.duritos, MaterialTypes.HEAD);
		TinkerRegistry.addMaterialStats(supremium, 
				new HeadMaterialStats(5520, 22.25F, 15.03F, HarvestLevels.COBALT),
				new HandleMaterialStats(1.35F, 200),
				new ExtraMaterialStats(300),
				new BowMaterialStats(1.33F, 2.35F, 7.32F));
		moltenSupremium = new FluidMolten("supremium", 0xC40000);
		FluidRegistry.registerFluid(moltenSupremium);
		ModBlocks.registerBlock(new BlockMolten(moltenSupremium).setRegistryName("molten_" + moltenSupremium.getName()));
		FluidRegistry.addBucketForFluid(moltenSupremium);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemNugget, 1, 5), moltenSupremium, 16);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.items.itemSupremiumIngot, 1, 0), moltenSupremium, 144);
		TinkerRegistry.registerMelting(new ItemStack(MAHelper.blocks.blockSupremiumIngot, 1, 0), moltenSupremium, 1296);
		supremium.setFluid(moltenSupremium);
		supremium.setCastable(true);
		TinkerIntegration.integrate(supremium, moltenSupremium).integrate();
		
		TinkerRegistry.registerTableCasting(MAHelper.items.itemNugget.baseEssence, TinkerSmeltery.castNugget, moltenBaseEssence, 16);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemNugget.inferium, TinkerSmeltery.castNugget, moltenInferium, 16);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemNugget.prudentium, TinkerSmeltery.castNugget, moltenPrudentium, 16);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemNugget.intermedium, TinkerSmeltery.castNugget, moltenIntermedium, 16);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemNugget.superium, TinkerSmeltery.castNugget, moltenSuperium, 16);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemNugget.supremium, TinkerSmeltery.castNugget, moltenSupremium, 16);
		TinkerRegistry.registerTableCasting(MAHelper.items.itemNugget.soulium, TinkerSmeltery.castNugget, moltenSoulium, 16);
		
		TinkerRegistry.registerTableCasting(new ItemStack(MAHelper.items.itemBaseEssenceIngot), TinkerSmeltery.castIngot, moltenBaseEssence, 144);
		TinkerRegistry.registerTableCasting(new ItemStack(MAHelper.items.itemInferiumIngot), TinkerSmeltery.castIngot, moltenInferium, 144);
		TinkerRegistry.registerTableCasting(new ItemStack(MAHelper.items.itemPrudentiumIngot), TinkerSmeltery.castIngot, moltenPrudentium, 144);
		TinkerRegistry.registerTableCasting(new ItemStack(MAHelper.items.itemIntermediumIngot), TinkerSmeltery.castIngot, moltenIntermedium, 144);
		TinkerRegistry.registerTableCasting(new ItemStack(MAHelper.items.itemSuperiumIngot), TinkerSmeltery.castIngot, moltenSuperium, 144);
		TinkerRegistry.registerTableCasting(new ItemStack(MAHelper.items.itemSupremiumIngot), TinkerSmeltery.castIngot, moltenSupremium, 144);
		TinkerRegistry.registerTableCasting(new ItemStack(MAHelper.items.itemSouliumIngot), TinkerSmeltery.castIngot, moltenSoulium, 144);
		
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockBaseEssenceIngot), null, moltenBaseEssence, 1296);
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockInferiumIngot), null, moltenInferium, 1296);
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockPrudentiumIngot), null, moltenPrudentium, 1296);
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockIntermediumIngot), null, moltenIntermedium, 1296);
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockSuperiumIngot), null, moltenSuperium, 1296);
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockSupremiumIngot), null, moltenSupremium, 1296);
		TinkerRegistry.registerBasinCasting(new ItemStack(MAHelper.blocks.blockSouliumIngot), null, moltenSoulium, 1296);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initFluidModels(){
		
		if(!ModConfig.confTConstructSupport || !ModChecker.TINKERS){ return; }
		
		FluidRender.mapFluidState(moltenSoulium);
		FluidRender.mapFluidState(moltenBaseEssence);
		FluidRender.mapFluidState(moltenInferium);
		FluidRender.mapFluidState(moltenPrudentium);
		FluidRender.mapFluidState(moltenIntermedium);
		FluidRender.mapFluidState(moltenSuperium);
		FluidRender.mapFluidState(moltenSupremium);
	}
}
