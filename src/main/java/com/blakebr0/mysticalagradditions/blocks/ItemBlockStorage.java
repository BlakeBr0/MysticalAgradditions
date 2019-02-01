package com.blakebr0.mysticalagradditions.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockStorage extends ItemBlock {

	public ItemBlockStorage(Block block) {
		super(block);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "_" + BlockStorage.Type.byMetadata(stack.getMetadata()).getName();
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
	@Override
	public int getItemBurnTime(ItemStack stack) {
		return stack.getMetadata() == BlockStorage.Type.COAL.getMetadata() ? 691200 : -1;
	}
}
