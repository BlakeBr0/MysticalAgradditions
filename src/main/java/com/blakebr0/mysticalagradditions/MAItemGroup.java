package com.blakebr0.mysticalagradditions;

import com.blakebr0.mysticalagradditions.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MAItemGroup extends ItemGroup {
    public MAItemGroup() {
        super(MysticalAgradditions.MOD_ID);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.INSANIUM_ESSENCE.get());
    }
}
