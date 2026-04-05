package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseBlockItem;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.FuelValues;

public class EssenceCoalBlockItem extends BaseBlockItem {
    private final int fuel;

    public EssenceCoalBlockItem(Identifier id, Block block, int fuel) {
        super(id, block);
        this.fuel = fuel;
    }

    @Override
    public int getBurnTime(ItemStack stack, RecipeType<?> type, FuelValues fuelValues) {
        return this.fuel;
    }
}
