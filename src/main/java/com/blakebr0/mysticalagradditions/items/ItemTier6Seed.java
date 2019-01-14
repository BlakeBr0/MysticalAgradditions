package com.blakebr0.mysticalagradditions.items;

import java.util.List;

import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagriculture.lib.Tooltips;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTier6Seed extends ItemSeeds {

	private final Block crops;

	public ItemTier6Seed(String name, Block crops) {
		super(crops, Blocks.FARMLAND);
		this.setUnlocalizedName("ma." + name);
		this.setCreativeTab(MysticalAgradditions.tabMysticalAgradditions);
		this.crops = crops;
	}

	public int getTier() {
		return 6;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
		tooltip.add(Tooltips.TIER + Colors.DARK_PURPLE + "6");
	}
}