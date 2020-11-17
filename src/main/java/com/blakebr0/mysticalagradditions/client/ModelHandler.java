package com.blakebr0.mysticalagradditions.client;

import com.blakebr0.mysticalagradditions.init.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public final class ModelHandler {
    public static void onClientSetup() {
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHER_PROSPERITY_ORE.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHER_INFERIUM_ORE.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.END_PROSPERITY_ORE.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.END_INFERIUM_ORE.get(), RenderType.getCutoutMipped());
    }
}
