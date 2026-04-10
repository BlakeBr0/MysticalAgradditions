package com.blakebr0.mysticalagradditions.handler;

import com.blakebr0.mysticalagradditions.init.ModItems;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.transfer.fluid.BucketResourceHandler;

public final class RegisterCapabilityHandler {
    @SubscribeEvent
    public void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.registerItem(
                Capabilities.Fluid.ITEM, (_, access) -> new BucketResourceHandler(access),
                ModItems.MOLTEN_PROSPERITY_BUCKET.get(),
                ModItems.MOLTEN_INFERIUM_BUCKET.get(),
                ModItems.MOLTEN_PRUDENTIUM_BUCKET.get(),
                ModItems.MOLTEN_TERTIUM_BUCKET.get(),
                ModItems.MOLTEN_IMPERIUM_BUCKET.get(),
                ModItems.MOLTEN_SUPREMIUM_BUCKET.get(),
                ModItems.MOLTEN_AWAKENED_SUPREMIUM_BUCKET.get(),
                ModItems.MOLTEN_INSANIUM_BUCKET.get(),
                ModItems.MOLTEN_SOULIUM_BUCKET.get()
        );
    }
}
