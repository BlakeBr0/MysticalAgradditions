package com.blakebr0.mysticalagradditions.handler;

import com.blakebr0.cucumber.iface.IColored;
import com.blakebr0.mysticalagradditions.block.InfusedFarmlandBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;

public class ColorHandler {
    public static void onClientSetup() {
        Minecraft minecraft = Minecraft.getInstance();
        BlockColors blockColors = minecraft.getBlockColors();
        ItemColors itemColors = minecraft.getItemColors();

        onBlockColors(blockColors);
        onItemColors(itemColors);
    }

    private static void onBlockColors(BlockColors colors) {
        colors.register(new IColored.BlockColors(), InfusedFarmlandBlock.FARMLANDS.toArray(new InfusedFarmlandBlock[0]));
    }

    private static void onItemColors(ItemColors colors) {
        colors.register(new IColored.ItemBlockColors(), InfusedFarmlandBlock.FARMLANDS.toArray(new InfusedFarmlandBlock[0]));
    }
}
