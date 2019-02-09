package com.blakebr0.mysticalagradditions.tinkers;

import java.util.ArrayList;
import java.util.List;

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
import net.minecraft.entity.monster.EntityMob;
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

	public TraitChunky() {
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
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
		World world = target.getEntityWorld();
		if (!target.isEntityAlive() && !world.isRemote) {
			List<EntityItem> items = new ArrayList<>();
			if (target instanceof EntityZombie && type.ZOMBIE.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 6, 1, MAHelper.mobDrops.getChanceFromTier(type.ZOMBIE.getTier())));
			}

			if (target instanceof EntityPig && type.PIG.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 7, 1, MAHelper.mobDrops.getChanceFromTier(type.PIG.getTier())));
			}

			if (target instanceof EntityChicken && type.CHICKEN.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 8, 1, MAHelper.mobDrops.getChanceFromTier(type.CHICKEN.getTier())));
			}

			if (target instanceof EntityCow && type.COW.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 9, 1, MAHelper.mobDrops.getChanceFromTier(type.COW.getTier())));
			}

			if (target instanceof EntitySheep && type.SHEEP.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 10, 1, MAHelper.mobDrops.getChanceFromTier(type.SHEEP.getTier())));
			}

			if (target instanceof EntitySlime && type.SLIME.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 11, 1, MAHelper.mobDrops.getChanceFromTier(type.SLIME.getTier())));
			}

			if (target instanceof EntitySkeleton && type.SKELETON.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 12, 1, MAHelper.mobDrops.getChanceFromTier(type.SKELETON.getTier())));
			}

			if (target instanceof EntityCreeper && type.CREEPER.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 13, 1, MAHelper.mobDrops.getChanceFromTier(type.CREEPER.getTier())));
			}

			if (target instanceof EntitySpider && type.SPIDER.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 14, 1, MAHelper.mobDrops.getChanceFromTier(type.SPIDER.getTier())));
			}

			if (target instanceof EntityRabbit && type.RABBIT.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 15, 1, MAHelper.mobDrops.getChanceFromTier(type.RABBIT.getTier())));
			}

			if (target instanceof EntityGuardian && type.GUARDIAN.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 16, 1, MAHelper.mobDrops.getChanceFromTier(type.GUARDIAN.getTier())));
			}

			if (target instanceof EntityBlaze && type.BLAZE.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 17, 1, MAHelper.mobDrops.getChanceFromTier(type.BLAZE.getTier())));
			}

			if (target instanceof EntityGhast && type.GHAST.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 18, 1, MAHelper.mobDrops.getChanceFromTier(type.GHAST.getTier())));
			}

			if (target instanceof EntityEnderman && type.ENDERMAN.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 19, 1, MAHelper.mobDrops.getChanceFromTier(type.ENDERMAN.getTier())));
			}

			if (target instanceof EntityWitherSkeleton && type.WITHER_SKELETON.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 20, 1, MAHelper.mobDrops.getChanceFromTier(type.WITHER_SKELETON.getTier())));
			}

			if (target.getClass().getName() == BLIZZ_CLASS && type.BLIZZ.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 21, 1, MAHelper.mobDrops.getChanceFromTier(type.BLIZZ.getTier())));
			}

			if (target.getClass().getName() == BLITZ_CLASS && type.BLITZ.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 22, 1, MAHelper.mobDrops.getChanceFromTier(type.BLITZ.getTier())));
			}

			if (target.getClass().getName() == BASALZ_CLASS && type.BASALZ.isEnabled()) {
				items.add(drop(target, MAHelper.items.itemChunk, 23, 1, MAHelper.mobDrops.getChanceFromTier(type.BASALZ.getTier())));
			}
			
        	if (target instanceof EntityMob) {  	
        		items.add(drop(target, MAHelper.items.itemChunk, 5, 1, MAHelper.mobDrops.getChance(10)));
        	}

			if (!items.isEmpty()) {
				items.forEach(item -> world.spawnEntity(item));
			}
		}
	}

	public EntityItem drop(Entity entity, Item item, int meta, int amount, int chance) {
		ItemStack stack = new ItemStack(item, chance, meta);
		if (stack.getCount() > amount) {
			stack.setCount(amount);
		}
		
		EntityItem drop = new EntityItem(entity.getEntityWorld(), entity.posX, entity.posY, entity.posZ, stack);
		
		return drop;
	}

	public static AbstractTrait getTrait() {
		return chunky;
	}
}
