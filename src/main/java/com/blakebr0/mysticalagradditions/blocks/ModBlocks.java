package com.blakebr0.mysticalagradditions.blocks;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.blakebr0.cucumber.registry.Ore;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.lib.CropType;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ModBlocks {
	
	public static BlockStorage blockStorage = new BlockStorage();
	public static BlockSpecial blockSpecial = new BlockSpecial();
	
	public static BlockTier6TinkeringTable blockInsaniumTinkeringTable = new BlockTier6TinkeringTable();
	
	public static BlockTier6InferiumCrop blockTier6InferiumCrop = new BlockTier6InferiumCrop("tier6_inferium_crop");
	
	public static void init() {
		final ModRegistry registry = MysticalAgradditions.REGISTRY;
		
		registry.register(blockStorage, "storage", new ItemBlockStorage(blockStorage), Ore.of(0, "blockInsaniumEssence"), Ore.of(1, "blockInsanium"), Ore.of(2, "blockInsaniumCoal"));
		registry.register(blockSpecial, "special", new ItemBlockSpecial(blockSpecial));
		
		registry.register(blockInsaniumTinkeringTable, "tinkering_table");
		
		registry.register(blockTier6InferiumCrop, "tier6_inferium_crop");
		
		for (CropType.Type type : CropType.Type.values()) {
			if (type.isEnabled()) {
				registry.register(type.getPlant(), type.getName() + "_crop");
			}
		}
	}
}
