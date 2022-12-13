package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class EssenceCoalBlockItem extends BaseBlockItem {
    private final int fuel;

    public EssenceCoalBlockItem(Block block, int fuel) {
        super(block);
        this.fuel = fuel;
    }

    @Override
    public int getBurnTime(ItemStack stack, RecipeType<?> type) {
        return this.fuel;
    }
}
