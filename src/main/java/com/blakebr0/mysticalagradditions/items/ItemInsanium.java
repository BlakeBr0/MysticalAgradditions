package com.blakebr0.mysticalagradditions.items;

import java.util.List;

import com.blakebr0.cucumber.helper.ResourceHelper;
import com.blakebr0.cucumber.iface.IModelHelper;
import com.blakebr0.cucumber.item.ItemBase;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.lib.MAHelper;
import com.blakebr0.mysticalagriculture.lib.Tooltips;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

public class ItemInsanium extends ItemBase implements IModelHelper {

	public ItemInsanium() {
		super("ma.insanium");
		this.setHasSubtypes(true);
		this.setCreativeTab(MysticalAgradditions.tabMysticalAgradditions);
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> stacks) {
		if (isInCreativeTab(tab)) {
			for (Type type : Type.values()) {
				if (type.isEnabled()) {
					stacks.add(new ItemStack(this, 1, type.getMetadata()));
				}
			}
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "_" + Type.byMetadata(stack.getMetadata()).getName();
	}
	
	@Override
	public int getItemBurnTime(ItemStack stack) {
		return stack.getMetadata() == Type.COAL.getMetadata() ? 76800 : -1;
	}

	@Override
	public void initModels() {
		for (Type type : Type.values()) {
			if (type.isEnabled()) {
				ModelLoader.setCustomModelResourceLocation(this, type.getMetadata(), ResourceHelper.getModelResource(MysticalAgradditions.MOD_ID, "insanium_" + type.byMetadata(type.getMetadata()).getName(), "inventory"));
			}
		}
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
		if (stack.getMetadata() == Type.COAL.getMetadata()) {
			tooltip.add("Burn Time: \u00A7548.0x");
		} else if (stack.getMetadata() == Type.CRAFTING_SEED.getMetadata()) {
			tooltip.add(Tooltips.CRAFTING_SEED);
		}
	}

	public static enum Type implements IStringSerializable {
		
		ESSENCE(0, "essence"), 
		CRAFTING_SEED(1, "crafting_seed"), 
		INGOT(2, "ingot"), 
		NUGGET(3, "nugget"),
		MOB_CHUNK(4, "mob_chunk"), 
		COAL(5, "coal", MAHelper.config.confEssenceCoal);

		private static final Type[] META_LOOKUP = new Type[values().length];
		private final int meta;
		private final String name;
		private final boolean enabled;

		private Type(int meta, String name) {
			this.meta = meta;
			this.name = name;
			this.enabled = true;
		}

		private Type(int meta, String name, boolean enabled) {
			this.meta = meta;
			this.name = name;
			this.enabled = enabled;
		}

		public int getMetadata() {
			return this.meta;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public boolean isEnabled() {
			return this.enabled;
		}

		public static Type byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
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
