package com.blakebr0.mysticalagradditions.event;

import com.blakebr0.mysticalagradditions.blocks.BlockTier6Crop;
import com.blakebr0.mysticalagradditions.lib.MAHelper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoFertilizerForYou {
	
	// TODO: finish this up
	@SubscribeEvent
	public void onRightClickBlock(RightClickBlock event){
		// config
		
		if(event.getEntity() == null){
			return;
		}
		
		IBlockState state = event.getWorld().getBlockState(event.getPos());
		EntityPlayer player = event.getEntityPlayer();
		ItemStack held = player.getHeldItemMainhand();
		if(state.getBlock() instanceof BlockTier6Crop){
			if(held.getItem() == MAHelper.items.itemFertilizedEssence || held.getItem() == MAHelper.items.itemMysticalFertilizer){
				event.setCanceled(true);
			}
		}
	}
}
