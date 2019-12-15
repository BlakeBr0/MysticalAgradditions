package com.blakebr0.mysticalagradditions.items;

import com.blakebr0.cucumber.item.BaseItem;
import net.minecraft.item.ItemStack;

import java.util.function.Function;

public class CreativeEssenceItem extends BaseItem {
    public CreativeEssenceItem(Function<Properties, Properties> properties) {
        super(properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
