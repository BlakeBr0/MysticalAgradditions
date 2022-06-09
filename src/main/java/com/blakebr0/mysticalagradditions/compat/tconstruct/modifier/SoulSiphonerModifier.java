//package com.blakebr0.mysticalagradditions.compat.tconstruct.modifier;
//
//import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;
//import com.blakebr0.mysticalagriculture.api.soul.MobSoulType;
//import com.blakebr0.mysticalagriculture.api.util.MobSoulUtils;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.registries.ForgeRegistries;
//import slimeknights.tconstruct.library.modifiers.Modifier;
//import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
//import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class SoulSiphonerModifier extends Modifier {
//    public SoulSiphonerModifier() {
//        super();
//    }
//
//    @Override
//    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
//        var target = context.getLivingTarget();
//        var attacker = context.getAttacker();
//
//        if (target != null && !target.isAlive() && attacker instanceof Player player) {
//            var type = MysticalAgricultureAPI.getMobSoulTypeRegistry().getMobSoulTypeByEntity(target);
//
//            if (type == null || !type.isEnabled()) {
//                return super.afterEntityHit(tool, level, context, damageDealt);
//            }
//
//            var jars = getValidSoulJars(player, type);
//
//            if (!jars.isEmpty()) {
//                double remaining = 0.25D * level;
//
//                for (var jar : jars) {
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
//    private static List<ItemStack> getValidSoulJars(Player player, MobSoulType type) {
//        return player.getInventory().items
//                .stream()
//                .filter(s -> {
//                    var id = ForgeRegistries.ITEMS.getKey(s.getItem());
//                    return id != null && "mysticalagriculture:soul_jar".equals(id.toString());
//                })
//                .filter(s -> MobSoulUtils.canAddTypeToJar(s, type))
//                .sorted((a, b) -> MobSoulUtils.getType(a) != null ? -1 : MobSoulUtils.getType(b) != null ? 0 : 1)
//                .collect(Collectors.toList());
//    }
//}
