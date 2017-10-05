package com.blakebr0.mysticalagradditions.tinkers;

import com.blakebr0.mysticalagradditions.lib.MAHelper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitProsperous extends AbstractTrait {

	private static AbstractTrait prosperous = new TraitProsperous();
	
	public TraitProsperous(){
		super("prosperous", 0xA3C5C5);
	}
	
	@Override
	public String getLocalizedName() {
		return new TextComponentTranslation("trait.ma.prosperous").getFormattedText();
	}
	
	@Override
	public String getLocalizedDesc() {
		return new TextComponentTranslation("trait.ma.prosperous.desc").getFormattedText();
	}
	
	@Override
	public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective){
	    if(wasEffective && !world.isRemote && random.nextFloat() < 0.0033F){
	    	EntityItem item = new EntityItem(world, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, new ItemStack(MAHelper.items.itemProsperityShard, 1, 0));
	        world.spawnEntity(item);
	    }
	}
	
	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit){
		World world = target.getEntityWorld();
		if(!target.isEntityAlive() && !world.isRemote && random.nextFloat() < 0.0033F){
			EntityItem item = new EntityItem(world, target.posX, target.posY, target.posZ, new ItemStack(MAHelper.items.itemProsperityShard, 1, 0));
	        world.spawnEntity(item);
		}
	}
	
	public static AbstractTrait getTrait(){
		return prosperous;
	}
}
