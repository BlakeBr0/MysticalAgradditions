package com.blakebr0.mysticalagradditions.handler;

import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.init.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gamerules.GameRules;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;

public final class MobDropHandler {
	@SubscribeEvent
	public void onLivingDrops(LivingDropsEvent event) {
		var entity = event.getEntity();
		var level = (ServerLevel) entity.level();

		if (!level.getGameRules().get(GameRules.MOB_DROPS))
			return;

		var drops = event.getDrops();
		var witheringSoulChance = ModConfigs.WITHERING_SOUL_DROP_CHANCE.get();
		int dragonScalesAmount = ModConfigs.DRAGON_SCALES_AMOUNT.get();

		if (entity instanceof WitherBoss && Math.random() < witheringSoulChance) {
			drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ModItems.WITHERING_SOUL.get())));
		}

		if (entity instanceof EnderDragon && dragonScalesAmount > 0) {
			drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ModItems.DRAGON_SCALE.get(), dragonScalesAmount)));
		}
	}
}
