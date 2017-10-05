package com.blakebr0.mysticalagradditions.event;

import java.util.List;

import com.blakebr0.mysticalagradditions.items.ModItems;
import com.blakebr0.mysticalagradditions.lib.MAHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDrops {
	    
    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event){

        List<EntityItem> drops = event.getDrops();
        	
    	if(event.getEntity() instanceof EntityWither){            	
    		drops.add(drop(event.getEntity(), ModItems.itemStuff, 1, 1, MAHelper.mobDrops.getChance(35)));
    	} 
    }
    
	public EntityItem drop(Entity entity, Item item, int amount, int meta, int chance){
    	ItemStack stack = new ItemStack(item, chance, meta);
    	if(stack.stackSize > amount){
    		stack.stackSize = amount;
    	}
    	EntityItem drop = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, stack);
    	return drop;
	}
}
