package com.blakebr0.mysticalagradditions.compat;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.item.ModItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class JEICompat implements IModPlugin {
    public static final ResourceLocation UID = new ResourceLocation(MysticalAgradditions.MOD_ID, "jei_plugin");

	@Override
	public ResourceLocation getPluginUid() {
		return UID;
	}

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addIngredientInfo(new ItemStack(ModItems.WITHERING_SOUL.get()), VanillaTypes.ITEM, "jei.desc.mysticalagradditions.withering_soul");
        registration.addIngredientInfo(new ItemStack(ModItems.DRAGON_SCALE.get()), VanillaTypes.ITEM, "jei.desc.mysticalagradditions.dragon_scale");
	}
}
