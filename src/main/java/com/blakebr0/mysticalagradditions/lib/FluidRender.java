package com.blakebr0.mysticalagradditions.lib;

import com.blakebr0.cucumber.helper.ResourceHelper;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;

public class FluidRender {

	public static void mapFluidState(Fluid fluid) {
		Block block = fluid.getBlock();
		Item item = Item.getItemFromBlock(block);
		FluidStateMapper mapper = new FluidStateMapper(fluid);
		
		if (item != null) {
			ModelLoader.registerItemVariants(item);
			ModelLoader.setCustomMeshDefinition(item, mapper);
		}
		
		ModelLoader.setCustomStateMapper(block, mapper);
	}

	static class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition {
		
		public final ModelResourceLocation location;

		public FluidStateMapper(Fluid fluid) {
			this.location = ResourceHelper.getModelResource(MysticalAgradditions.MOD_ID, "fluid_block", fluid.getName());
		}

		@Override
		protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
			return this.location;
		}

		@Override
		public ModelResourceLocation getModelLocation(ItemStack stack) {
			return this.location;
		}
	}
}
