package com.blakebr0.mysticalagradditions.lib;

import com.blakebr0.cucumber.item.ItemBase;
import com.blakebr0.mysticalagradditions.blocks.BlockSpecial;
import com.blakebr0.mysticalagradditions.blocks.BlockTier6Crop;
import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.config.ModConfig;
import com.blakebr0.mysticalagradditions.items.ItemTier6Seed;
import com.blakebr0.mysticalagriculture.util.ModChecker;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class CropType {
	
	public static void init(){
		for(CropType.Type type : CropType.Type.values()){
			if(type.isEnabled()){
				type.set();
			}
		}
	}
	
	public static enum Type implements IStringSerializable {
						
		NETHER_STAR("nether_star", ModBlocks.blockSpecial.getDefaultState().withProperty(BlockSpecial.VARIANT, BlockSpecial.Type.NETHER_STAR), 0, ModConfig.confNetherStarSeeds),
		AWAKENED_DRACONIUM("awakened_draconium", ModBlocks.blockSpecial.getDefaultState().withProperty(BlockSpecial.VARIANT, BlockSpecial.Type.AWAKENED_DRACONIUM), 4, ModConfig.confNetherStarSeeds && ModChecker.DRACONIC_EVOLUTION);
		
		private final String name;
		private final boolean enabled;
		private final BlockTier6Crop plant;
		private final IBlockState root;
		private final int rootMeta;
		private final ItemBase crop;
		private final ItemTier6Seed seed;
		
		Type(String name, IBlockState root, int rootMeta, boolean enabled){
			this.name = name;
			this.enabled = enabled;
			this.plant = new BlockTier6Crop(getName() + "_crop");
			this.root = root;
			this.rootMeta = rootMeta;
			this.crop = new ItemBase("ma." + getName() + "_essence");
			this.seed = new ItemTier6Seed(getName() + "_seeds", getPlant());
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
		
		public IBlockState getRoot(){
			return this.root;
		}
		
		public int getRootMeta(){
			return this.rootMeta;
		}
		
		public ItemBase getCrop(){
			return this.crop;
		}
		
		public ItemTier6Seed getSeed(){
			return this.seed;
		}
		
		public Type set(){
			this.getPlant().setRoot(this.getRoot());
			this.getPlant().setCrop(this.getCrop());
			this.getPlant().setSeed(this.getSeed());
			return this;
		}
	}
}
