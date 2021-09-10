package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Function;

public class EssenceCoalItem extends BaseItem {
    private final int fuel;

    public EssenceCoalItem(int fuel, Function<Properties, Properties> properties) {
        super(properties);
        this.fuel = fuel;
    }

    @Override
    public int getBurnTime(ItemStack stack, RecipeType<?> type) {
        return this.fuel;
    }
}
