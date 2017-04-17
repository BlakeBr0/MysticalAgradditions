package com.blakebr0.mysticalagradditions.tinkers;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.lib.FluidRender;
import com.blakebr0.mysticalagradditions.lib.MAHelper;
import com.blakebr0.mysticalagriculture.util.ModChecker;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.TinkerIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.ArrowShaftMaterialStats;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.smeltery.block.BlockMolten;
import slimeknights.tconstruct.tools.TinkerTools;

import static slimeknights.tconstruct.library.materials.MaterialTypes.*;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;
import static slimeknights.tconstruct.tools.TinkerTraits.*;

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
		
//		TinkerTools.registerToolForgeBlock("blockBaseEssenceIngot");
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
		prosperity.addTrait(writable2, HEAD);
		prosperity.addTrait(writable);
		TinkerRegistry.addMaterialStats(prosperity, 
                new HeadMaterialStats(36, 0.83F, 0.1F, STONE),
                new HandleMaterialStats(0.23F, 8),
                new ExtraMaterialStats(20),
				new BowMaterialStats(1.4f, 0.63f, -1.2f));
		TinkerIntegration.integrate(prosperity).integrate();
		
		soulium = new Material("ma.soulium", 0x564237);
		soulium.addItem(new ItemStack(MAHelper.items.itemSouliumIngot, 1, 0), 1, Material.VALUE_Ingot);
		soulium.setCraftable(true);
		soulium.setRepresentativeItem(new ItemStack(MAHelper.items.itemSouliumIngot, 1, 0));
		soulium.addTrait(TraitChunky.getTrait(), HEAD);
		TinkerRegistry.addMaterialStats(soulium, 
                new HeadMaterialStats(12, 0.51f, 0.05f, STONE),
                new HandleMaterialStats(0.10f, 5),
                new ExtraMaterialStats(15),
				new BowMaterialStats(2.87f, 4.53f, 14f));
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
				new HeadMaterialStats(680, 13.32f, 12.65f, IRON),
				new HandleMaterialStats(0.45f, 10), 
				new ExtraMaterialStats(40),
				new BowMaterialStats(2.87f, 4.53f, 14f));
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
				new HeadMaterialStats(680, 13.32f, 12.65f, IRON),
				new HandleMaterialStats(0.45f, 10), 
				new ExtraMaterialStats(40),
				new BowMaterialStats(2.87f, 4.53f, 14f));
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
				new HeadMaterialStats(680, 13.32f, 12.65f, DIAMOND),
				new HandleMaterialStats(0.45f, 10), 
				new ExtraMaterialStats(40),
				new BowMaterialStats(2.87f, 4.53f, 14f));
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
				new HeadMaterialStats(680, 13.32f, 12.65f, OBSIDIAN),
				new HandleMaterialStats(0.45f, 10), 
				new ExtraMaterialStats(40),
				new BowMaterialStats(2.87f, 4.53f, 14f));
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
				new HeadMaterialStats(680, 13.32f, 12.65f, COBALT),
				new HandleMaterialStats(0.45f, 10), 
				new ExtraMaterialStats(40),
				new BowMaterialStats(2.87f, 4.53f, 14f));
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
		supremium.addTrait(duritos, HEAD);
		TinkerRegistry.addMaterialStats(supremium, 
				new HeadMaterialStats(5500, 22.25F, 14.87F, COBALT),
				new HandleMaterialStats(1.35F, 200),
				new ExtraMaterialStats(300),
				new BowMaterialStats(5.00F, 5.00F, 15.02F));
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
	}
	
	@SideOnly(Side.CLIENT)
	public static void initFluidModels(){
		FluidRender.mapFluidState(moltenSoulium);
		FluidRender.mapFluidState(moltenBaseEssence);
		FluidRender.mapFluidState(moltenInferium);
		FluidRender.mapFluidState(moltenPrudentium);
		FluidRender.mapFluidState(moltenIntermedium);
		FluidRender.mapFluidState(moltenSuperium);
		FluidRender.mapFluidState(moltenSupremium);
	}
}
