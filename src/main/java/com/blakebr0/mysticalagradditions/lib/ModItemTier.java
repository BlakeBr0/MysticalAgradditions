package com.blakebr0.mysticalagradditions.lib;

import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;
import com.blakebr0.mysticalagriculture.api.MysticalAgricultureTags;
import com.google.common.base.Suppliers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum ModItemTier implements Tier {
    INFERIUM(MysticalAgricultureTags.Blocks.INCORRECT_FOR_INFERIUM_TOOL, 2000, 9.0F, 4.0F, 12, () -> {
        var item = BuiltInRegistries.ITEM.get(MysticalAgricultureAPI.resource("inferium_ingot"));
        return Ingredient.of(item);
    }),
    PRUDENTIUM(MysticalAgricultureTags.Blocks.INCORRECT_FOR_PRUDENTIUM_TOOL, 2800, 11.0F, 6.0F, 14, () -> {
        var item = BuiltInRegistries.ITEM.get(MysticalAgricultureAPI.resource("prudentium_ingot"));
        return Ingredient.of(item);
    }),
    TERTIUM(MysticalAgricultureTags.Blocks.INCORRECT_FOR_TERTIUM_TOOL, 4000, 14.0F, 9.0F, 16, () -> {
        var item = BuiltInRegistries.ITEM.get(MysticalAgricultureAPI.resource("tertium_ingot"));
        return Ingredient.of(item);
    }),
    IMPERIUM(MysticalAgricultureTags.Blocks.INCORRECT_FOR_IMPERIUM_TOOL, 6000, 19.0F, 13.0F, 18, () -> {
        var item = BuiltInRegistries.ITEM.get(MysticalAgricultureAPI.resource("imperium_ingot"));
        return Ingredient.of(item);
    }),
    SUPREMIUM(MysticalAgricultureTags.Blocks.INCORRECT_FOR_SUPREMIUM_TOOL, 0, 25.0F, 20.0F, 20, () -> {
        var item = BuiltInRegistries.ITEM.get(MysticalAgricultureAPI.resource("supremium_ingot"));
        return Ingredient.of(item);
    }),
    AWAKENED_SUPREMIUM(MysticalAgricultureTags.Blocks.INCORRECT_FOR_AWAKENED_SUPREMIUM_TOOL, 0, 30.0F, 25.0F, 22, () -> {
        var item = BuiltInRegistries.ITEM.get(MysticalAgricultureAPI.resource("awakened_supremium_ingot"));
        return Ingredient.of(item);
    });

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(TagKey<Block> incorrectBlocksForDrops, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = Suppliers.memoize(repairMaterial::get);
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    @Override
    public int getUses() {
        return this.maxUses;
    }

    @Override
    public float getSpeed() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }
}
