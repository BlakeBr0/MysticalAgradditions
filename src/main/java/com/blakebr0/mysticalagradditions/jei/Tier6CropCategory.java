package com.blakebr0.mysticalagradditions.jei;

import com.blakebr0.cucumber.helper.ResourceHelper;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class Tier6CropCategory implements IRecipeCategory<Tier6CropWrapper> {
	
    public static final String UID = "mysticalagradditions:tier_6_crop_jei";

    private IDrawable background;

    public Tier6CropCategory(IGuiHelper helper) {
        background = helper.createDrawable(ResourceHelper.getResource("mysticalagradditions", "textures/gui/tier_6_crop_jei.png"), 10, 14, 156, 92);
    }

    @Override
    public String getUid() {
        return UID;
    }

    @Override
    public String getTitle() {
        return Utils.localize("jei.ma.tier_6_crop");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }
    
    @Override
    public void setRecipe(IRecipeLayout recipeLayout, Tier6CropWrapper recipeWrapper, IIngredients ingredients) {
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
