package com.blakebr0.mysticalagradditions.client.handler;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.init.ModFluids;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;

public final class FluidModelHandler {
    private static final Identifier STILL_TEXTURE = MysticalAgradditions.resource("block/molten_still");
    private static final Identifier FLOWING_TEXTURE = MysticalAgradditions.resource("block/molten_flowing");

    @SubscribeEvent
    public void onRegisterFluidModels(RegisterFluidModelsEvent event) {
        event.register(
                new FluidModel.Unbaked(new Material(STILL_TEXTURE), new Material(FLOWING_TEXTURE), null, _ -> ARGB.opaque(7638528)),
                ModFluids.MOLTEN_INFERIUM,
                ModFluids.MOLTEN_INFERIUM_FLOWING
        );
        event.register(
                new FluidModel.Unbaked(new Material(STILL_TEXTURE), new Material(FLOWING_TEXTURE), null, _ -> ARGB.opaque(0x008C23)),
                ModFluids.MOLTEN_PRUDENTIUM,
                ModFluids.MOLTEN_PRUDENTIUM_FLOWING
        );
        event.register(
                new FluidModel.Unbaked(new Material(STILL_TEXTURE), new Material(FLOWING_TEXTURE), null, _ -> ARGB.opaque(0xB74900)),
                ModFluids.MOLTEN_TERTIUM,
                ModFluids.MOLTEN_TERTIUM_FLOWING
        );
        event.register(
                new FluidModel.Unbaked(new Material(STILL_TEXTURE), new Material(FLOWING_TEXTURE), null, _ -> ARGB.opaque(0x007FDB)),
                ModFluids.MOLTEN_IMPERIUM,
                ModFluids.MOLTEN_IMPERIUM_FLOWING
        );
        event.register(
                new FluidModel.Unbaked(new Material(STILL_TEXTURE), new Material(FLOWING_TEXTURE), null, _ -> ARGB.opaque(0xC40000)),
                ModFluids.MOLTEN_SUPREMIUM,
                ModFluids.MOLTEN_SUPREMIUM_FLOWING
        );
        event.register(
                new FluidModel.Unbaked(new Material(STILL_TEXTURE), new Material(FLOWING_TEXTURE), null, _ -> ARGB.opaque(0x8c563c)),
                ModFluids.MOLTEN_SOULIUM,
                ModFluids.MOLTEN_SOULIUM_FLOWING
        );
    }
}
