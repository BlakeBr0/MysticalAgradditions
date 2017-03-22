package com.blakebr0.mysticalagradditions.items;

import java.util.List;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemInsanium extends ItemBase {

	public ItemInsanium() {
		super("insanium");
		this.setHasSubtypes(true);
		GameRegistry.registerFuelHandler(new FuelHandler());
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> stacks){
		for(Type type : Type.values()){
			stacks.add(new ItemStack(item, 1, type.getMetadata()));
		}
	}
	
    @Override
    public String getUnlocalizedName(ItemStack stack){
        return super.getUnlocalizedName() + "_" + Type.byMetadata(stack.getMetadata()).getName();
    }
    
    @SideOnly(Side.CLIENT)
    public void initModels(){
    	for(Type type : Type.values()){
        	ModelLoader.setCustomModelResourceLocation(this, type.getMetadata(), new ModelResourceLocation(getRegistryName().toString() + "_" + type.byMetadata(type.getMetadata()).getName()));
    	}
    }
    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced){
    	if(stack.getMetadata() == Type.COAL.getMetadata()){
    		tooltip.add("Burn Time: \u00A7548.0x");
    	}
    }
	
	public static enum Type implements IStringSerializable {
		
		ESSENCE(0, "essence"),
		CRAFTING_SEED(1, "crafting_seed"),
		INGOT(2, "ingot"),
		MOB_CHUNK(3, "mob_chunk"),
		COAL(4, "coal");

        private static final Type[] META_LOOKUP = new Type[values().length];		
		private final int meta;
		private final String name;
		
		private Type(int meta, String name){
			this.meta = meta;
			this.name = name;
		}
		
		public int getMetadata(){
			return this.meta;
		}
		
		@Override
		public String getName(){
			return this.name;
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
	
	public static class FuelHandler implements IFuelHandler {

		@Override
		public int getBurnTime(ItemStack fuel){
			if(fuel.getItem() instanceof ItemInsanium && fuel.getMetadata() == Type.COAL.getMetadata()){
				return 76800;
			}
			return 0;
		}
	}
}
