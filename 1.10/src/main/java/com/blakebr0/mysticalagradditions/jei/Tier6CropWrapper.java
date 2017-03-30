package com.blakebr0.mysticalagradditions.jei;

import java.util.Collections;
import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.item.ItemStack;

public class Tier6CropWrapper extends BlankRecipeWrapper {
	
    private ItemStack input;
    private ItemStack crop;
    private ItemStack root;
    private ItemStack output;

    public Tier6CropWrapper(ItemStack input, ItemStack crop, ItemStack root, ItemStack output) {
        this.input = input;
        this.crop = crop;
        this.root = root;
        this.output = output;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInput(ItemStack.class, input);
        ingredients.setOutput(ItemStack.class, output);
    }

    @Override
    @SuppressWarnings("deprecation")
    public List<ItemStack> getInputs() {
        return Collections.singletonList(input);
    }

    @Override
    @SuppressWarnings("deprecation")
    public List<ItemStack> getOutputs() {
        return Collections.singletonList(output);
    }
    
    @SuppressWarnings("deprecation")
    public List<ItemStack> getCrop() {
        return Collections.singletonList(crop);
    }
    
    @SuppressWarnings("deprecation")
    public List<ItemStack> getRoot() {
        return Collections.singletonList(root);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Tier6CropWrapper)) {
            return false;
        }

        Tier6CropWrapper other = (Tier6CropWrapper)obj;

        if(!ItemStack.areItemStacksEqual(input, other.input)){
        	return false;
        }

        return ItemStack.areItemStacksEqual(output, other.output);
    }

    @Override
    public String toString() {
        return input + " = " + output;
    }
}
