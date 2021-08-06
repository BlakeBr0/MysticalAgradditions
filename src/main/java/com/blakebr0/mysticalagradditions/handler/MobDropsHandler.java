package com.blakebr0.mysticalagradditions.handler;

import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.init.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;

public final class MobDropsHandler {
	@SubscribeEvent
	public void onLivingDrops(LivingDropsEvent event) {
		LivingEntity entity = event.getEntityLiving();
		Level world = entity.getCommandSenderWorld();

		if (!world.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT))
			return;

		Collection<ItemEntity> drops = event.getDrops();
		Double witheringSoulChance = ModConfigs.WITHERING_SOUL_DROP_CHANCE.get();
		Integer dragonScalesAmount = ModConfigs.DRAGON_SCALES_AMOUNT.get();

		if (entity instanceof WitherBoss && Math.random() < witheringSoulChance) {
			drops.add(new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ModItems.WITHERING_SOUL.get())));
		}

		if (entity instanceof EnderDragon && dragonScalesAmount > 0) {
			drops.add(new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ModItems.DRAGON_SCALE.get(), dragonScalesAmount)));
		}
	}
}
