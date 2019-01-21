package com.blakebr0.mysticalagradditions.compat.jei;

import java.util.ArrayList;
import java.util.List;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class Tier6CropWrapper implements IRecipeWrapper {

	private IJeiHelpers helper;
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
		List<List<ItemStack>> inputs = new ArrayList<>();
		IStackHelper helper = this.helper.getStackHelper();
		
		inputs.add(helper.toItemStackList(this.input));
		inputs.add(helper.toItemStackList(this.crop));
		inputs.add(helper.toItemStackList(this.root));
		inputs.add(helper.toItemStackList(new ItemStack(Blocks.FARMLAND)));
		
		ingredients.setInputLists(ItemStack.class, inputs);
		ingredients.setOutput(ItemStack.class, this.output);
	}
	
	public Tier6CropWrapper setHelper(IJeiHelpers helper) {
		this.helper = helper;
		return this;
	}
}
