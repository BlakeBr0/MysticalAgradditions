package com.blakebr0.mysticalagradditions.jei;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class Tier6CropHandler implements IRecipeHandler<Tier6CropWrapper> {
    @Override
    @Nonnull
    public Class<Tier6CropWrapper> getRecipeClass() {
        return Tier6CropWrapper.class;
    }

    @Override
    @Nonnull
    public String getRecipeCategoryUid(@Nonnull Tier6CropWrapper recipe) {
        return Tier6CropCategory.UID;
    }

    @Override
    @Nonnull
    public IRecipeWrapper getRecipeWrapper(@Nonnull Tier6CropWrapper recipe) {
        return recipe;
    }

    @Override
    public boolean isRecipeValid(@Nonnull Tier6CropWrapper recipe) {
        return true;
    }
}
