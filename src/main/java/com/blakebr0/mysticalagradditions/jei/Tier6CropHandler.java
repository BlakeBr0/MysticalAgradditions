package com.blakebr0.mysticalagradditions.jei;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class Tier6CropHandler implements IRecipeHandler<Tier6CropWrapper> {
	@Override
	public Class<Tier6CropWrapper> getRecipeClass() {
		return Tier6CropWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid(Tier6CropWrapper recipe) {
		return Tier6CropCategory.UID;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(Tier6CropWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(Tier6CropWrapper recipe) {
		return true;
	}
}
