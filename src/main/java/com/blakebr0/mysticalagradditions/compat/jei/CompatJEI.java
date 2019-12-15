//package com.blakebr0.mysticalagradditions.compat.jei;
//
//import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
//import com.blakebr0.mysticalagradditions.items.ModItems;
//import com.blakebr0.mysticalagriculture.compat.jei.tinkeringtable.TinkeringTableCategory;
//
//import mezz.jei.api.IGuiHelper;
//import mezz.jei.api.IJeiHelpers;
//import mezz.jei.api.IModPlugin;
//import mezz.jei.api.IModRegistry;
//import mezz.jei.api.JEIPlugin;
//import mezz.jei.api.JeiPlugin;
//import mezz.jei.api.recipe.IRecipeCategoryRegistration;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.ResourceLocation;
//
//@JeiPlugin
//public class CompatJEI implements IModPlugin {
//
//	@Override
//	public void registerCategories(IRecipeCategoryRegistration registry) {
//		IGuiHelper helper = registry.getJeiHelpers().getGuiHelper();
//		registry.addRecipeCategories(new Tier6CropCategory(helper));
//	}
//
//	@Override
//	public void register(IModRegistry registry) {
//		registry.addIngredientInfo(new ItemStack(ModItems.itemStuff, 1, 1), ItemStack.class, "desc.withering_soul");
//		registry.addIngredientInfo(new ItemStack(ModItems.itemStuff, 1, 3), ItemStack.class, "desc.dragon_scale");
//
//		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
//		IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
//
//		registry.addRecipeCatalyst(new ItemStack(ModItems.itemInsanium, 1, 1), Tier6CropCategory.UID);
//		registry.handleRecipes(Tier6CropWrapper.class, recipe -> recipe.setHelper(jeiHelpers), Tier6CropCategory.UID);
//		registry.addRecipes(Tier6CropRecipeMaker.getRecipes(), Tier6CropCategory.UID);
//
//		registry.addRecipeCatalyst(new ItemStack(ModBlocks.blockInsaniumTinkeringTable, 1, 0), TinkeringTableCategory.UID);
//	}
//
//	@Override
//	public ResourceLocation getPluginUid() {
//		return null;
//	}
//}
