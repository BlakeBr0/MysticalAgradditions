package com.blakebr0.mysticalagradditions.blocks;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBase extends com.blakebr0.mysticalagriculture.blocks.BlockBase {

	public BlockBase(String name, Material material, SoundType sound, float hardness, float resistance){
		super(name, material, sound, hardness, resistance);
		this.setCreativeTab(MysticalAgradditions.tabMysticalAgradditions);
	}

}
