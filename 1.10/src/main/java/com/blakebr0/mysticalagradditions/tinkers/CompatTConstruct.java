package com.blakebr0.mysticalagradditions.tinkers;

import com.blakebr0.mysticalagradditions.lib.MAHelper;
import com.blakebr0.mysticalagriculture.util.ModChecker;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.TinkerIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ArrowShaftMaterialStats;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTools;

import static slimeknights.tconstruct.library.materials.MaterialTypes.*;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;
import static slimeknights.tconstruct.tools.TinkerTraits.*;

public class CompatTConstruct {
	
	public static void init(){
		
//		TinkerTools.registerToolForgeBlock("blockBaseEssenceIngot");
		TinkerTools.registerToolForgeBlock("blockSouliumIngot");
		TinkerTools.registerToolForgeBlock("blockInferiumIngot");
		TinkerTools.registerToolForgeBlock("blockPrudentiumIngot");
		TinkerTools.registerToolForgeBlock("blockIntermediumIngot");
		TinkerTools.registerToolForgeBlock("blockSuperiumIngot");
		TinkerTools.registerToolForgeBlock("blockSupremiumIngot");
		
		Material prosperity = new Material("ma.prosperity", 0xA3C5C5);
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
		
		Material soulium = new Material("ma.soulium", 0x564237);
		soulium.addItem(new ItemStack(MAHelper.items.itemSouliumIngot, 1, 0), 1, Material.VALUE_Ingot);
		soulium.setCraftable(true);
		soulium.setRepresentativeItem(new ItemStack(MAHelper.items.itemSouliumIngot, 1, 0));
		soulium.addTrait(TraitChunky.getTrait(), HEAD);
		TinkerRegistry.addMaterialStats(soulium, 
                new HeadMaterialStats(12, 0.51f, 0.05f, STONE),
                new HandleMaterialStats(0.10f, 5),
                new ExtraMaterialStats(15),
				new BowMaterialStats(2.87f, 4.53f, 14f));
		TinkerIntegration.integrate(soulium).integrate();

		Material baseEssence = new Material("ma.base_essence", 0xD1FFFF);
		baseEssence.addItem(new ItemStack(MAHelper.items.itemBaseEssenceIngot, 1, 0), 1, Material.VALUE_Ingot);
		baseEssence.setRepresentativeItem(new ItemStack(MAHelper.items.itemBaseEssenceIngot, 1, 0));
		baseEssence.addTrait(TraitProsperous.getTrait());
		TinkerRegistry.addMaterialStats(baseEssence, 
				new HeadMaterialStats(680, 13.32f, 12.65f, DIAMOND),
				new HandleMaterialStats(0.45f, 10), 
				new ExtraMaterialStats(40),
				new BowMaterialStats(2.87f, 4.53f, 14f));
		TinkerIntegration.integrate(baseEssence).integrate();
		
		Material inferium = new Material("ma.inferium", 0x748E00);
		inferium.addItem(new ItemStack(MAHelper.items.itemInferiumIngot, 1, 0), 1, Material.VALUE_Ingot);
		inferium.setRepresentativeItem(new ItemStack(MAHelper.items.itemInferiumIngot, 1, 0));
		inferium.addTrait(TraitProsperous.getTrait());
		TinkerRegistry.addMaterialStats(inferium, 
				new HeadMaterialStats(680, 13.32f, 12.65f, DIAMOND),
				new HandleMaterialStats(0.45f, 10), 
				new ExtraMaterialStats(40),
				new BowMaterialStats(2.87f, 4.53f, 14f));
		TinkerIntegration.integrate(inferium).integrate();
		
		Material prudentium = new Material("ma.prudentium", 0x008C23);
		prudentium.addItem(new ItemStack(MAHelper.items.itemPrudentiumIngot, 1, 0), 1, Material.VALUE_Ingot);
		prudentium.setRepresentativeItem(new ItemStack(MAHelper.items.itemPrudentiumIngot, 1, 0));
		prudentium.addTrait(TraitProsperous.getTrait());
		TinkerRegistry.addMaterialStats(prudentium, 
				new HeadMaterialStats(680, 13.32f, 12.65f, DIAMOND),
				new HandleMaterialStats(0.45f, 10), 
				new ExtraMaterialStats(40),
				new BowMaterialStats(2.87f, 4.53f, 14f));
		TinkerIntegration.integrate(prudentium).integrate();
		
		Material intermedium = new Material("ma.intermedium", 0xB74900);
		intermedium.addItem(new ItemStack(MAHelper.items.itemIntermediumIngot, 1, 0), 1, Material.VALUE_Ingot);
		intermedium.setRepresentativeItem(new ItemStack(MAHelper.items.itemIntermediumIngot, 1, 0));
		intermedium.addTrait(TraitProsperous.getTrait());
		TinkerRegistry.addMaterialStats(intermedium, 
				new HeadMaterialStats(680, 13.32f, 12.65f, DIAMOND),
				new HandleMaterialStats(0.45f, 10), 
				new ExtraMaterialStats(40),
				new BowMaterialStats(2.87f, 4.53f, 14f));
		TinkerIntegration.integrate(intermedium).integrate();
		
		Material superium = new Material("ma.superium", 0x007FDB);
		superium.addItem(new ItemStack(MAHelper.items.itemSuperiumIngot, 1, 0), 1, Material.VALUE_Ingot);
		superium.setRepresentativeItem(new ItemStack(MAHelper.items.itemSuperiumIngot, 1, 0));
		superium.addTrait(TraitProsperous.getTrait());
		TinkerRegistry.addMaterialStats(superium, 
				new HeadMaterialStats(680, 13.32f, 12.65f, DIAMOND),
				new HandleMaterialStats(0.45f, 10), 
				new ExtraMaterialStats(40),
				new BowMaterialStats(2.87f, 4.53f, 14f));
		TinkerIntegration.integrate(superium).integrate();
		
		Material supremium = new Material("ma.supremium", 0xC40000);
		supremium.addItem(new ItemStack(MAHelper.items.itemSupremiumIngot, 1, 0), 1, Material.VALUE_Ingot);
		supremium.setRepresentativeItem(new ItemStack(MAHelper.items.itemSupremiumIngot, 1, 0));
		supremium.addTrait(TraitProsperous.getTrait());
		TinkerRegistry.addMaterialStats(supremium, 
				new HeadMaterialStats(680, 13.32f, 12.65f, DIAMOND),
				new HandleMaterialStats(0.45f, 10), 
				new ExtraMaterialStats(40),
				new BowMaterialStats(2.87f, 4.53f, 14f));
		TinkerIntegration.integrate(supremium).integrate();
	}
}
