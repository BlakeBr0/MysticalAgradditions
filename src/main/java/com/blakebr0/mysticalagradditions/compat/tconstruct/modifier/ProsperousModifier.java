package com.blakebr0.mysticalagradditions.compat.tconstruct.modifier;

import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class ProsperousModifier extends Modifier {
    public ProsperousModifier() {
        super(0xA3C5C5);
    }

    @Override
    public int afterLivingHit(IModifierToolStack tool, int level, LivingEntity attacker, LivingEntity target, float damageDealt, boolean isCritical, float cooldown) {
        World world = target.getCommandSenderWorld();

        if (!target.isAlive() && !world.isClientSide() && world.getRandom().nextFloat() < 0.005F * level) {
            Item shard = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MysticalAgricultureAPI.MOD_ID, "prosperity_shard"));
            ItemEntity item = new ItemEntity(world, target.getX() + 0.5, target.getY(), target.getZ() + 0.5, new ItemStack(shard));

            world.addFreshEntity(item);
        }

        return super.afterLivingHit(tool, level, attacker, target, damageDealt, isCritical, cooldown);
    }

    @Override
    public void afterBlockBreak(IModifierToolStack tool, int level, World world, BlockState state, BlockPos pos, LivingEntity target, boolean canHarvest, boolean wasEffective) {
        if (wasEffective && !world.isClientSide() && world.getRandom().nextFloat() < 0.005F * level) {
            Item shard = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MysticalAgricultureAPI.MOD_ID, "prosperity_shard"));
            ItemEntity item = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(shard));

            world.addFreshEntity(item);
        }
    }
}
