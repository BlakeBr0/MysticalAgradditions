package com.blakebr0.mysticalagradditions.blocks;

import java.util.List;

import com.blakebr0.cucumber.block.BlockBase;
import com.blakebr0.cucumber.helper.ResourceHelper;
import com.blakebr0.cucumber.iface.IModelHelper;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.lib.MAHelper;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockStorage extends BlockBase implements IModelHelper {

	public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("variant", Type.class);

	public BlockStorage() {
		super("ma.storage", Material.ROCK, SoundType.STONE, 5.0F, 10.0F);
		this.setCreativeTab(MysticalAgradditions.tabMysticalAgradditions);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Type.ESSENCE));
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(VARIANT).getMetadata();
	}

	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> stacks) {
		for (Type type : Type.values()) {
			if (type.isEnabled()) {
				stacks.add(new ItemStack(this, 1, type.getMetadata()));
			}
		}
	}

	@Override
	public void initModels() {
		for (Type type : Type.values()) {
			if (type.isEnabled()) {
				ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), type.getMetadata(), ResourceHelper.getModelResource(MysticalAgradditions.MOD_ID, "storage_" + type.byMetadata(type.getMetadata()).getName(), "inventory"));
			}
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, Type.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(VARIANT).getMetadata();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { VARIANT });
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
		if (stack.getMetadata() == Type.COAL.getMetadata()) {
			tooltip.add("Burn Time: \u00A7548.0x");
		}
	}

	public static enum Type implements IStringSerializable {

		ESSENCE(0, "essence"), 
		INGOT(1, "ingot"), 
		COAL(2, "coal", MAHelper.config.confEssenceCoal);

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
