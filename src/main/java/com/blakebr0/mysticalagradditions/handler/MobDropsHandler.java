package com.blakebr0.mysticalagradditions.handler;

import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.init.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;

public final class MobDropsHandler {
	@SubscribeEvent
	public void onLivingDrops(LivingDropsEvent event) {
		LivingEntity entity = event.getEntityLiving();
		World world = entity.getCommandSenderWorld();
		Collection<ItemEntity> drops = event.getDrops();
		Double witheringSoulChance = ModConfigs.WITHERING_SOUL_DROP_CHANCE.get();
		Integer dragonScalesAmount = ModConfigs.DRAGON_SCALES_AMOUNT.get();

		if (entity instanceof WitherEntity && Math.random() < witheringSoulChance) {
			drops.add(new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ModItems.WITHERING_SOUL.get())));
		}

		if (entity instanceof EnderDragonEntity && dragonScalesAmount > 0) {
			drops.add(new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ModItems.DRAGON_SCALE.get(), dragonScalesAmount)));
		}
	}
}
