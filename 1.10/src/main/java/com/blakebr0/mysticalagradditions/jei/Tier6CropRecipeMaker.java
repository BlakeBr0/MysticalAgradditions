package com.blakebr0.mysticalagradditions.jei;

import java.util.ArrayList;
import java.util.List;

import com.blakebr0.mysticalagradditions.lib.CropType;
import com.blakebr0.mysticalagriculture.crafting.ReprocessorManager;
import com.blakebr0.mysticalagriculture.crafting.ReprocessorRecipe;

import net.minecraft.item.ItemStack;

public class Tier6CropRecipeMaker {
	
    public static List<Tier6CropWrapper> getRecipes(){
        List<Tier6CropWrapper> recipes = new ArrayList<Tier6CropWrapper>();

        for(CropType.Type type : CropType.Type.values()) {
        	if(type.isEnabled()){
                ItemStack input = new ItemStack(type.getSeed());
                ItemStack crop = new ItemStack(type.getPlant());
                ItemStack root = new ItemStack(type.getRoot());
                ItemStack output = new ItemStack(type.getCrop());

                recipes.add(new Tier6CropWrapper(input, crop, root, output));
        	}
        } 
        return recipes;
    }
}
