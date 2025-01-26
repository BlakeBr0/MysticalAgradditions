package com.blakebr0.mysticalagradditions.compat.tconstruct.modifier;

import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BlockBreakModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class ProsperousModifier extends Modifier implements MeleeHitModifierHook, BlockBreakModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder builder) {
        builder.addHook(this, ModifierHooks.MELEE_HIT);
        builder.addHook(this, ModifierHooks.BLOCK_BREAK);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        var target = context.getLivingTarget();

        if (target != null) {
            var level = target.level();

            if (!target.isAlive() && !level.isClientSide() && level.getRandom().nextFloat() < 0.005F * modifier.getLevel()) {
                var shard = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MysticalAgricultureAPI.MOD_ID, "prosperity_shard"));
                var item = new ItemEntity(level, target.getX() + 0.5, target.getY(), target.getZ() + 0.5, new ItemStack(shard));

                level.addFreshEntity(item);
            }
        }
    }

    @Override
    public void afterBlockBreak(IToolStackView tool, ModifierEntry modifier, ToolHarvestContext context) {
        var level = context.getWorld();

        if (context.isEffective() && !level.isClientSide() && level.getRandom().nextFloat() < 0.005F * modifier.getLevel()) {
            var shard = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MysticalAgricultureAPI.MOD_ID, "prosperity_shard"));
            var pos = context.getPos();
            var item = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(shard));

            level.addFreshEntity(item);
        }
    }
}