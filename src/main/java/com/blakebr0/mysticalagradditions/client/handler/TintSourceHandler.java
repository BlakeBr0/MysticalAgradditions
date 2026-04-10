package com.blakebr0.mysticalagradditions.client.handler;

import com.blakebr0.cucumber.iface.IColored;
import com.blakebr0.mysticalagradditions.block.InfusedFarmlandBlock;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.List;

public final class TintSourceHandler {
    @SubscribeEvent
    public void onRegisterBlockTintSources(RegisterColorHandlersEvent.BlockTintSources event) {
        event.register(List.of(new IColored.BlockColors()), InfusedFarmlandBlock.FARMLANDS.toArray(new InfusedFarmlandBlock[0]));
    }
}
