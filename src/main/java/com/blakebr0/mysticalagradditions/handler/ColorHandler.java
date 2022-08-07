package com.blakebr0.mysticalagradditions.handler;

import com.blakebr0.cucumber.iface.IColored;
import com.blakebr0.mysticalagradditions.block.InfusedFarmlandBlock;
import com.blakebr0.mysticalagradditions.init.ModItems;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class ColorHandler {
    @SubscribeEvent
    public void onBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register(new IColored.BlockColors(), InfusedFarmlandBlock.FARMLANDS.toArray(new InfusedFarmlandBlock[0]));
    }

    @SubscribeEvent
    public void onItemColors(RegisterColorHandlersEvent.Item event) {
        event.register(new IColored.ItemBlockColors(), InfusedFarmlandBlock.FARMLANDS.toArray(new InfusedFarmlandBlock[0]));

        var buckets = new Item[] {
                ModItems.MOLTEN_INFERIUM_BUCKET.get(),
                ModItems.MOLTEN_PRUDENTIUM_BUCKET.get(),
                ModItems.MOLTEN_TERTIUM_BUCKET.get(),
                ModItems.MOLTEN_IMPERIUM_BUCKET.get(),
                ModItems.MOLTEN_SUPREMIUM_BUCKET.get(),
                ModItems.MOLTEN_SOULIUM_BUCKET.get()
        };

        event.register((stack, tint) -> {
            var fluid = ((BucketItem) stack.getItem()).getFluid();
            return tint == 1 ? IClientFluidTypeExtensions.of(fluid).getTintColor() : -1;
        }, buckets);
    }
}
