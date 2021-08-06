package com.blakebr0.mysticalagradditions.client;

import com.blakebr0.mysticalagradditions.init.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public final class ModelHandler {
    public static void onClientSetup() {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHER_PROSPERITY_ORE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHER_INFERIUM_ORE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.END_PROSPERITY_ORE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.END_INFERIUM_ORE.get(), RenderType.cutoutMipped());
    }
}
