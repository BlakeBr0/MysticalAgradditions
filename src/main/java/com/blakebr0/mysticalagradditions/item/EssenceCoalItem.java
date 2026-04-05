package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseItem;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;

public class EssenceCoalItem extends BaseItem {
    private final int fuel;

    public EssenceCoalItem(Identifier id, int fuel) {
        super(id);
        this.fuel = fuel;
    }

    @Override
    public int getBurnTime(ItemStack stack, RecipeType<?> type, FuelValues fuelValues) {
        return this.fuel;
    }
}
