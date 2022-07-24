package com.blakebr0.mysticalagradditions.handler;

import com.blakebr0.cucumber.iface.IColored;
import com.blakebr0.mysticalagradditions.block.InfusedFarmlandBlock;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class ColorHandler {
    @SubscribeEvent
    public void onBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register(new IColored.BlockColors(), InfusedFarmlandBlock.FARMLANDS.toArray(new InfusedFarmlandBlock[0]));
    }

    @SubscribeEvent
    public void onItemColors(RegisterColorHandlersEvent.Item event) {
        event.register(new IColored.ItemBlockColors(), InfusedFarmlandBlock.FARMLANDS.toArray(new InfusedFarmlandBlock[0]));
    }
}
