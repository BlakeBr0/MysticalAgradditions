package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class CreativeEssenceItem extends BaseItem {
    public CreativeEssenceItem() {
        super(p -> p.rarity(Rarity.EPIC));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
