package com.blakebr0.mysticalagradditions.jei;

import javax.annotation.Nonnull;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

public class Tier6CropCategory implements IRecipeCategory<Tier6CropWrapper> {
	
    public static final String UID = "mysticalagradditions:tier_6_crop_jei";

    private IDrawable background;

    public Tier6CropCategory(IGuiHelper helper) {
        background = helper.createDrawable(new ResourceLocation("mysticalagradditions", "textures/gui/tier_6_crop_jei.png"), 10, 14, 156, 92);
    }

    @Override
    public String getUid() {
        return UID;
    }

    @Override
    public String getTitle() {
        return new TextComponentTranslation("jei.ma.tier_6_crop").getFormattedText();
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }
    
    @Override
    public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull Tier6CropWrapper recipeWrapper, @Nonnull IIngredients ingredients) {
        IGuiItemStackGroup group = recipeLayout.getItemStacks();

        group.init(0, true, 10, 32);
        group.init(1, true, 65, 8);
        group.init(2, false, 124, 32);
        group.init(3, true, 65, 55);
        group.init(4, true, 65, 31);
        
        group.set(0, recipeWrapper.getInputs());
        group.set(1, recipeWrapper.getCrop());
        group.set(2, recipeWrapper.getOutputs());
        group.set(3, recipeWrapper.getRoot());
        group.set(4, new ItemStack(Blocks.FARMLAND));
    }

	@Override
	public String getModName(){
		return MysticalAgradditions.NAME;
	}
}
