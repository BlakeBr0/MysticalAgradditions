package com.blakebr0.mysticalagradditions;

import com.blakebr0.mysticalagradditions.init.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MACreativeTab extends CreativeModeTab {
    public MACreativeTab() {
        super(MysticalAgradditions.MOD_ID);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.INSANIUM_ESSENCE.get());
    }
}
