package com.blakebr0.mysticalagradditions.compat.tconstruct.modifier;

import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class ProsperousModifier extends Modifier {
    public ProsperousModifier() {
        super(0xA3C5C5);
    }

    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();

        if (target != null) {
            Level world = target.getCommandSenderWorld();

            if (!target.isAlive() && !world.isClientSide() && world.getRandom().nextFloat() < 0.005F * level) {
                Item shard = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MysticalAgricultureAPI.MOD_ID, "prosperity_shard"));
                ItemEntity item = new ItemEntity(world, target.getX() + 0.5, target.getY(), target.getZ() + 0.5, new ItemStack(shard));

                world.addFreshEntity(item);
            }
        }

        return super.afterEntityHit(tool, level, context, damageDealt);
    }

    @Override
    public void afterBlockBreak(IModifierToolStack tool, int level, ToolHarvestContext context) {
        ServerLevel world = context.getWorld();

        if (context.isEffective() && !world.isClientSide() && world.getRandom().nextFloat() < 0.005F * level) {
            Item shard = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MysticalAgricultureAPI.MOD_ID, "prosperity_shard"));
            BlockPos pos = context.getPos();
            ItemEntity item = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(shard));

            world.addFreshEntity(item);
        }
    }
}
