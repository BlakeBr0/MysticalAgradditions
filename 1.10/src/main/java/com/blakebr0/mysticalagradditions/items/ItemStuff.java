package com.blakebr0.mysticalagradditions.items;

import java.util.List;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStuff extends ItemBase {

	public ItemStuff() {
		super("stuff");
		this.setHasSubtypes(true);
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> stacks){
		for(Type type : Type.values()){
			if(type.isEnabled()){
				stacks.add(new ItemStack(item, 1, type.getMetadata()));
			}
		}
	}
	
    @Override
    public String getUnlocalizedName(ItemStack stack){
        return super.getUnlocalizedName() + "_" + Type.byMetadata(stack.getMetadata()).getName();
    }
    
    @SideOnly(Side.CLIENT)
    public void initModels(){
    	for(Type type : Type.values()){
    		if(type.isEnabled()){
            	ModelLoader.setCustomModelResourceLocation(this, type.getMetadata(), new ModelResourceLocation(getRegistryName().toString() + "_" + type.byMetadata(type.getMetadata()).getName()));		
    		}
    	}
    }
    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
    	if(stack.getMetadata() == Type.WITHERING_SOUL.getMetadata()){
        	tooltip.add("Drop Chance: 35%");	
    	}
    }
	
	public static enum Type implements IStringSerializable {
		
		NETHER_STAR_SHARD(0, "nether_star_shard"),
		WITHERING_SOUL(1, "withering_soul");

        private static final Type[] META_LOOKUP = new Type[values().length];		
		private final int meta;
		private final String name;
		private final boolean enabled;
		
		private Type(int meta, String name){
			this.meta = meta;
			this.name = name;
			this.enabled = true;
		}
		
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
            for(Type type : values()){
                META_LOOKUP[type.getMetadata()] = type;
            }
        }
	}
}
