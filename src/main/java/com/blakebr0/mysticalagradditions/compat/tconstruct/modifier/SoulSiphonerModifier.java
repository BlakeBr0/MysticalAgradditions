//package com.blakebr0.mysticalagradditions.compat.tconstruct.modifier;
//
//import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;
//import com.blakebr0.mysticalagriculture.api.util.MobSoulUtils;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import slimeknights.tconstruct.library.modifiers.Modifier;
//import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
//import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class SoulSiphonerModifier extends Modifier {
//    public SoulSiphonerModifier() {
//        super(0x8c563c);
//    }
//
//    @Override
//    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damageDealt) {
//        LivingEntity target = context.getLivingTarget();
//        LivingEntity attacker = context.getAttacker();
//
//        if (target != null && !target.isAlive() && attacker instanceof Player) {
//            IMobSoulType type = MysticalAgricultureAPI.getMobSoulTypeRegistry().getMobSoulTypeByEntity(target);
//
//            if (type == null || !type.isEnabled()) {
//                return super.afterEntityHit(tool, level, context, damageDealt);
//            }
//
//            Player player = (Player) attacker;
//            List<ItemStack> jars = getValidSoulJars(player, type);
//
//            if (!jars.isEmpty()) {
//                double remaining = 0.25D * level;
//
//                for (ItemStack jar : jars) {
//                    remaining = MobSoulUtils.addSoulsToJar(jar, type, remaining);
//                    if (remaining <= 0)
//                        break;
//                }
//            }
//        }
//
//        return super.afterEntityHit(tool, level, context, damageDealt);
//    }
//
//    private static List<ItemStack> getValidSoulJars(Player player, IMobSoulType type) {
//        return player.inventory.items.stream()
//                .filter(s -> {
//                    ResourceLocation id = s.getItem().getRegistryName();
//                    return id != null && "mysticalagriculture:soul_jar".equals(id.toString());
//                })
//                .filter(s -> MobSoulUtils.canAddTypeToJar(s, type))
//                .sorted((a, b) -> MobSoulUtils.getType(a) != null ? -1 : MobSoulUtils.getType(b) != null ? 0 : 1)
//                .collect(Collectors.toList());
//    }
//}
