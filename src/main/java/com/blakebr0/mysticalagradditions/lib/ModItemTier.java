package com.blakebr0.mysticalagradditions.lib;

import com.blakebr0.mysticalagradditions.item.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {
    INFERIUM(3, 2000, 9.0F, 4.0F, 20, () -> {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mysticalagriculture:inferium_ingot"));
        return Ingredient.fromItems(item);
    }),
    PRUDENTIUM(3, 2800, 11.0F, 6.0F, 25, () -> {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mysticalagriculture:prudentium_ingot"));
        return Ingredient.fromItems(item);
    }),
    TERTIUM(4, 4000, 14.0F, 9.0F, 30, () -> {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mysticalagriculture:tertium_ingot"));
        return Ingredient.fromItems(item);
    }),
    IMPERIUM(4, 6000, 19.0F, 13.0F, 35, () -> {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mysticalagriculture:imperium_ingot"));
        return Ingredient.fromItems(item);
    }),
    SUPREMIUM(5, -1, 25.0F, 20.0F, 0, () -> {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mysticalagriculture:supremium_ingot"));
        return Ingredient.fromItems(item);
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
