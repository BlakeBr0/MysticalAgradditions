package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import java.util.function.Function;

public class CreativeEssenceItem extends BaseItem {
    public CreativeEssenceItem(Function<Properties, Properties> properties) {
        super(properties.compose(p -> p.rarity(Rarity.EPIC)));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
