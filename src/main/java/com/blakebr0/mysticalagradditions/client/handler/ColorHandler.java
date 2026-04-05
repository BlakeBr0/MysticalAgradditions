package com.blakebr0.mysticalagradditions.client.handler;

import com.blakebr0.cucumber.iface.IColored;
import com.blakebr0.mysticalagradditions.block.InfusedFarmlandBlock;
import com.blakebr0.mysticalagradditions.init.ModItems;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;

import java.util.List;

public final class ColorHandler {
    @SubscribeEvent
    public void onBlockColors(RegisterColorHandlersEvent.BlockTintSources event) {
        event.register(List.of(new IColored.BlockColors()), InfusedFarmlandBlock.FARMLANDS.toArray(new InfusedFarmlandBlock[0]));
    }

//TODO item colors
//    @SubscribeEvent
//    public void onItemColors(RegisterColorHandlersEvent.Item event) {
//        event.register(new IColored.ItemBlockColors(), InfusedFarmlandBlock.FARMLANDS.toArray(new InfusedFarmlandBlock[0]));
//
//        var buckets = new Item[] {
//                ModItems.MOLTEN_INFERIUM_BUCKET.get(),
//                ModItems.MOLTEN_PRUDENTIUM_BUCKET.get(),
//                ModItems.MOLTEN_TERTIUM_BUCKET.get(),
//                ModItems.MOLTEN_IMPERIUM_BUCKET.get(),
//                ModItems.MOLTEN_SUPREMIUM_BUCKET.get(),
//                ModItems.MOLTEN_SOULIUM_BUCKET.get()
//        };
//
//        event.register((stack, tint) -> {
//            var fluid = ((BucketItem) stack.getItem()).content;
//            return tint == 1 ? IClientFluidTypeExtensions.of(fluid).getTintColor() : -1;
//        }, buckets);
//    }
}
