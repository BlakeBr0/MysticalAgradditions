//package com.blakebr0.mysticalagradditions.compat.tconstruct.modifier;
//
//import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.item.ItemEntity;
//import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.registries.ForgeRegistries;
//import slimeknights.tconstruct.library.modifiers.Modifier;
//import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
//import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
//import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
//
//public class ProsperousModifier extends Modifier {
//    public ProsperousModifier() {
//        super();
//    }
//
//    @Override
//    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
//        var target = context.getLivingTarget();
//
//        if (target != null) {
//            var world = target.getCommandSenderWorld();
//
//            if (!target.isAlive() && !world.isClientSide() && world.getRandom().nextFloat() < 0.005F * level) {
//                var shard = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MysticalAgricultureAPI.MOD_ID, "prosperity_shard"));
//                var item = new ItemEntity(world, target.getX() + 0.5, target.getY(), target.getZ() + 0.5, new ItemStack(shard));
//
//                world.addFreshEntity(item);
//            }
//        }
//
//        return super.afterEntityHit(tool, level, context, damageDealt);
//    }
//
//    @Override
//    public void afterBlockBreak(IToolStackView tool, int level, ToolHarvestContext context) {
//        var world = context.getWorld();
//
//        if (context.isEffective() && !world.isClientSide() && world.getRandom().nextFloat() < 0.005F * level) {
//            var shard = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MysticalAgricultureAPI.MOD_ID, "prosperity_shard"));
//            var pos = context.getPos();
//            var item = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(shard));
//
//            world.addFreshEntity(item);
//        }
//    }
//}
