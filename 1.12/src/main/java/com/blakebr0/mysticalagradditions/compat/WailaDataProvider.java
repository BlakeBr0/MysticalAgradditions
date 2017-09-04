package com.blakebr0.mysticalagradditions.compat;

import java.util.List;

import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.mysticalagradditions.blocks.BlockTier6Crop;
import com.blakebr0.mysticalagradditions.blocks.BlockTier6InferiumCrop;
import com.blakebr0.mysticalagriculture.lib.Tooltips;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class WailaDataProvider implements IWailaDataProvider {

	public static void callbackRegister(IWailaRegistrar registrar){
		registrar.registerBodyProvider(new WailaDataProvider(), BlockTier6Crop.class);
		registrar.registerBodyProvider(new WailaDataProvider(), BlockTier6InferiumCrop.class);
	}
	
	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config){
		Block block = accessor.getBlock();
		if(block instanceof BlockTier6Crop || block instanceof BlockTier6InferiumCrop){
			currenttip.add(Tooltips.TIER.substring(0, 4) + " : " + Colors.DARK_PURPLE + 6);
		}
		return currenttip;
	}
}
