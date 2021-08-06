package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.ItemStack;

import java.util.function.Function;

import net.minecraft.world.item.Item.Properties;

public class EssenceCoalBlockItem extends BaseBlockItem {
    private final int fuel;

    public EssenceCoalBlockItem(Block block, int fuel, Function<Properties, Properties> properties) {
        super(block, properties);
        this.fuel = fuel;
    }

    @Override
    public int getBurnTime(ItemStack stack) {
        return this.fuel;
    }
}
