package com.blakebr0.mysticalagradditions.lib;

import com.blakebr0.mysticalagradditions.blocks.BlockSpecial;
import com.blakebr0.mysticalagradditions.blocks.BlockTier6Crop;
import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.config.ModConfig;
import com.blakebr0.mysticalagradditions.items.ItemBase;
import com.blakebr0.mysticalagradditions.items.ItemTier6Seed;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class CropType {

	public static enum Type implements IStringSerializable {
						
		NETHER_STAR("nether_star", new ItemStack(ModBlocks.blockSpecial, 1, 0).getItem(), ModConfig.confNetherStarSeeds);
		
		private final String name;
		private final boolean enabled;
		private final BlockTier6Crop plant;
		private final Item root;
		private final ItemBase crop;
		private final ItemTier6Seed seed;
		
		Type(String name, Item root, boolean enabled){
			this.name = name;
			this.enabled = enabled;
			this.plant = new BlockTier6Crop(getName() + "_crop");
			this.root = root;
			this.crop = new ItemBase(getName() + "_essence");
			this.seed = new ItemTier6Seed(getName() + "_seeds", getPlant());
			getPlant().setRoot(getRoot());
			getPlant().setCrop(getCrop());
			getPlant().setSeed(getSeed());
		}

		@Override
		public String getName(){
			return this.name;
		}
		
		public int getTier(){
			return 6;
		}
		
		public boolean isEnabled(){
			return this.enabled;
		}
		
		public BlockTier6Crop getPlant(){
			return this.plant;
		}
		
		public Item getRoot(){
			return this.root;
		}
		
		public ItemBase getCrop(){
			return this.crop;
		}
		
		public ItemTier6Seed getSeed(){
			return this.seed;
		}
	}
}
