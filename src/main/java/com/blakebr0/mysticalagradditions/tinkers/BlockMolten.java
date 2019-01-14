package com.blakebr0.mysticalagradditions.tinkers;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BlockMolten extends BlockFluidClassic {

	public BlockMolten(Fluid fluid) {
		super(fluid, Material.LAVA);
		this.setCreativeTab(MysticalAgradditions.tabMysticalAgradditions);
	}

	@Override
	public String getUnlocalizedName() {
		Fluid fluid = FluidRegistry.getFluid(fluidName);
		if (fluid != null) {
			return fluid.getUnlocalizedName();
		}
		
		return super.getUnlocalizedName();
	}
}
