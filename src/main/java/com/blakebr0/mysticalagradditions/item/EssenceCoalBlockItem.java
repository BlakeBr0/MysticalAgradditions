package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import java.util.function.Function;

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
