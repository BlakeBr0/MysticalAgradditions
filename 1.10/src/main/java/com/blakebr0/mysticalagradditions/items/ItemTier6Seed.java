package com.blakebr0.mysticalagradditions.items;

import java.util.List;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTier6Seed extends ItemSeeds {
	
	private final Block crops;

	public ItemTier6Seed(String name, Block crops){
		super(crops, Blocks.FARMLAND);
		this.setUnlocalizedName("ma." + name);
		this.setRegistryName(name);
		this.setCreativeTab(MysticalAgradditions.tabMysticalAgradditions);
        this.crops = crops;
	}

	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced){
		tooltip.add("Tier: \u00A756");
    }
}