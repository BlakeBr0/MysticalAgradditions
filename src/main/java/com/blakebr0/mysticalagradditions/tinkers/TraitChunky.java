package com.blakebr0.mysticalagradditions.tinkers;

import com.blakebr0.mysticalagradditions.lib.MAHelper;
import com.blakebr0.mysticalagriculture.lib.CropType;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitChunky extends AbstractTrait {

	private static AbstractTrait chunky = new TraitChunky();
	
	private static CropType.Type type;
	
    private static final String BLIZZ_CLASS = "cofh.thermalfoundation.entity.monster.EntityBlizz";
    private static final String BLITZ_CLASS = "cofh.thermalfoundation.entity.monster.EntityBlitz";
    private static final String BASALZ_CLASS = "cofh.thermalfoundation.entity.monster.EntityBasalz";
	
	public TraitChunky(){
		super("chunky", 0x564237);
	}

	@Override
	public String getLocalizedName() {
		return new TextComponentTranslation("trait.ma.chunky").getFormattedText();
	}
	
	@Override
	public String getLocalizedDesc() {
		return new TextComponentTranslation("trait.ma.chunky.desc").getFormattedText();
	}
	
	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit){
		World world = target.getEntityWorld();
		if(!target.isEntityAlive() && !world.isRemote){
			EntityItem item = null;
        	if(target instanceof EntityZombie && type.ZOMBIE.isEnabled()){
        		item = drop(target, MAHelper.items.itemZombieChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.ZOMBIE.getTier()));
        	}
        	
        	if(target instanceof EntityPig && type.PIG.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemPigChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.PIG.getTier()));
        	}
        	
        	if(target instanceof EntityChicken && type.CHICKEN.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemChickenChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.CHICKEN.getTier()));
        	}
        	
        	if(target instanceof EntityCow && type.COW.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemCowChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.COW.getTier()));
        	}
        	
        	if(target instanceof EntitySheep && type.SHEEP.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemSheepChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.SHEEP.getTier()));
        	}
        	
        	if(target instanceof EntitySlime && type.SLIME.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemSlimeChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.SLIME.getTier()));
        	}
        	
        	if(target instanceof EntitySkeleton && type.SKELETON.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemSkeletonChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.SKELETON.getTier()));
        	}
        	
        	if(target instanceof EntityCreeper && type.CREEPER.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemCreeperChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.CREEPER.getTier()));
        	}
        	
        	if(target instanceof EntitySpider && type.SPIDER.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemSpiderChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.SPIDER.getTier()));
        	}
        	
        	if(target instanceof EntityRabbit && type.RABBIT.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemRabbitChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.RABBIT.getTier()));
        	}
        	
        	if(target instanceof EntityGuardian && type.GUARDIAN.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemGuardianChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.GUARDIAN.getTier()));
        	}
        	
        	if(target instanceof EntityBlaze && type.BLAZE.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemBlazeChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.BLAZE.getTier()));
        	}
        	
        	if(target instanceof EntityGhast && type.GHAST.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemGhastChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.GHAST.getTier()));
        	}
        	
        	if(target instanceof EntityEnderman && type.ENDERMAN.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemEndermanChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.ENDERMAN.getTier()));
        	}
        	
        	if(target instanceof EntityWitherSkeleton && type.WITHER_SKELETON.isEnabled()){            	
        		item = drop(target, MAHelper.items.itemWitherSkeletonChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.WITHER_SKELETON.getTier()));
        	}
        	
        	if(target.getClass().getName() == BLIZZ_CLASS && type.BLIZZ.isEnabled()){
        		item = drop(target, MAHelper.items.itemBlizzChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.BLIZZ.getTier()));
        	}
        	
        	if(target.getClass().getName() == BLITZ_CLASS && type.BLITZ.isEnabled()){
        		item = drop(target, MAHelper.items.itemBlitzChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.BLITZ.getTier()));
        	}
        	
        	if(target.getClass().getName() == BASALZ_CLASS && type.BASALZ.isEnabled()){
        		item = drop(target, MAHelper.items.itemBasalzChunk, 1, MAHelper.mobDrops.getChanceFromTier(type.BASALZ.getTier()));
        	}
        	
        	if(item != null){
        		world.spawnEntity(item);
        	}
		}
	}
	
	public EntityItem drop(Entity entity, Item item, int amount, int chance){
    	ItemStack stack = new ItemStack(item, chance, 0);
    	if(stack.getCount() > amount){
    		stack.setCount(amount);
    	}
    	EntityItem drop = new EntityItem(entity.getEntityWorld(), entity.posX, entity.posY, entity.posZ, stack);
    	return drop;
	}
	
	public static AbstractTrait getTrait(){
		return chunky;
	}
}
