package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseItem;
import net.minecraft.item.ItemStack;

import java.util.function.Function;

import net.minecraft.item.Item.Properties;

public class EssenceCoalItem extends BaseItem {
    private final int fuel;

    public EssenceCoalItem(int fuel, Function<Properties, Properties> properties) {
        super(properties);
        this.fuel = fuel;
    }

    @Override
    public int getBurnTime(ItemStack stack) {
        return this.fuel;
    }
}
