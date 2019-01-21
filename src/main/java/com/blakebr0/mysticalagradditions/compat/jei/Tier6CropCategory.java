package com.blakebr0.mysticalagradditions.compat.jei;

import java.util.List;

import com.blakebr0.cucumber.helper.ResourceHelper;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.item.ItemStack;

public class Tier6CropCategory implements IRecipeCategory<Tier6CropWrapper> {
	
    public static final String UID = "mysticalagradditions:tier_6_crop_jei";

    private IDrawable background;

    public Tier6CropCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(ResourceHelper.getResource(MysticalAgradditions.MOD_ID, "textures/gui/tier_6_crop_jei.png"), 0, 0, 136, 65);
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
        return this.background;
    }
    
    @Override
    public void setRecipe(IRecipeLayout layout, Tier6CropWrapper wrapper, IIngredients ingredients) {
        IGuiItemStackGroup group = layout.getItemStacks();
        
        List<List<ItemStack>> inputs = ingredients.getInputs(ItemStack.class);
        List<ItemStack> outputs = ingredients.getOutputs(ItemStack.class).get(0);

        group.init(0, true, 0, 24);
        group.init(1, true, 55, 0);
        group.init(2, true, 55, 47);
        group.init(3, true, 55, 23);
        group.init(4, false, 114, 24);
        
        group.set(0, inputs.get(0));
        group.set(1, inputs.get(1));
        group.set(2, inputs.get(2));
        group.set(3, inputs.get(3));
        group.set(4, outputs);
    }

	@Override
	public String getModName() {
		return MysticalAgradditions.NAME;
	}
}
