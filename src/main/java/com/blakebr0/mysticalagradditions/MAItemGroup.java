package com.blakebr0.mysticalagradditions;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MAItemGroup extends ItemGroup {
    public MAItemGroup() {
        super(MysticalAgradditions.MOD_ID);
    }

    @Override
    public ItemStack createIcon() {
        return ItemStack.EMPTY;
    }
}
