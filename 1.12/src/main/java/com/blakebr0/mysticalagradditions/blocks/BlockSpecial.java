package com.blakebr0.mysticalagradditions.blocks;

import com.blakebr0.cucumber.block.BlockBase;
import com.blakebr0.cucumber.iface.IModelHelper;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.config.ModConfig;
import com.blakebr0.mysticalagriculture.util.ModChecker;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;

public class BlockSpecial extends BlockBase implements IModelHelper {

    public static final PropertyEnum<Type> VARIANT = PropertyEnum.<Type>create("variant", Type.class);

    public BlockSpecial(){
        super("ma.special", Material.ROCK, SoundType.STONE, 5.0F, 10.0F);
        this.setCreativeTab(MysticalAgradditions.tabMysticalAgradditions);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Type.NETHER_STAR));
    }

    @Override
    public int damageDropped(IBlockState state){
        return ((Type)state.getValue(VARIANT)).getMetadata();
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> stacks){
        for(Type type : Type.values()){
        	if(type.isEnabled()){
                stacks.add(new ItemStack(this, 1, type.getMetadata()));
        	}
        }
    }
    
    @Override
    public void initModels(){
    	for(Type type : Type.values()){
    		if(type.isEnabled()){
            	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), type.getMetadata(), new ModelResourceLocation(getRegistryName().toString() + "_" + type.byMetadata(type.getMetadata()).getName()));	
    		}
    	}
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(VARIANT, Type.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return ((Type)state.getValue(VARIANT)).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] { VARIANT });
    }
    
	public static enum Type implements IStringSerializable {
		
		NETHER_STAR(0, "nether_star", ModConfig.confNetherStarSeeds),
		DRAGON_EGG(1, "dragon_egg", ModConfig.confDragonEggSeeds),
		PH2(2, "ph2", false),
		PH3(3, "ph3", false),
		AWAKENED_DRACONIUM(4, "awakened_draconium", ModConfig.confAwakenedDraconiumSeeds && ModChecker.DRACONIC_EVOLUTION);

        private static final Type[] META_LOOKUP = new Type[values().length];		
		private final int meta;
		private final String name;
		private final boolean enabled;
		
		private Type(int meta, String name, boolean enabled){
			this.meta = meta;
			this.name = name;
			this.enabled = enabled;
		}
		
		public int getMetadata(){
			return this.meta;
		}
		
		@Override
		public String getName(){
			return this.name;
		}
		
		public boolean isEnabled(){
			return this.enabled;
		}
		
        public static Type byMetadata(int meta){
            if(meta < 0 || meta >= META_LOOKUP.length){
                meta = 0;
            }
            return META_LOOKUP[meta];
        }

        static {
            for (Type type : values()) {
                META_LOOKUP[type.getMetadata()] = type;
            }
        }
	}
}
