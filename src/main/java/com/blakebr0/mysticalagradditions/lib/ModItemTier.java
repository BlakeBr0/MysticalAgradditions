package com.blakebr0.mysticalagradditions.lib;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public enum ModItemTier implements Tier {
    INFERIUM(3, 2000, 9.0F, 4.0F, 20, () -> {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mysticalagriculture:inferium_ingot"));
        return Ingredient.of(item);
    }),
    PRUDENTIUM(3, 2800, 11.0F, 6.0F, 25, () -> {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mysticalagriculture:prudentium_ingot"));
        return Ingredient.of(item);
    }),
    TERTIUM(4, 4000, 14.0F, 9.0F, 30, () -> {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mysticalagriculture:tertium_ingot"));
        return Ingredient.of(item);
    }),
    IMPERIUM(4, 6000, 19.0F, 13.0F, 35, () -> {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mysticalagriculture:imperium_ingot"));
        return Ingredient.of(item);
    }),
    SUPREMIUM(5, -1, 25.0F, 20.0F, 0, () -> {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mysticalagriculture:supremium_ingot"));
        return Ingredient.of(item);
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
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
    public int getLevel() {
        return this.harvestLevel;
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
