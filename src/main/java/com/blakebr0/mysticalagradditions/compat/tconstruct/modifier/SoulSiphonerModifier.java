package com.blakebr0.mysticalagradditions.compat.tconstruct.modifier;

import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;
import com.blakebr0.mysticalagriculture.api.soul.MobSoulType;
import com.blakebr0.mysticalagriculture.api.util.MobSoulUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;
import java.util.stream.Collectors;

public class SoulSiphonerModifier extends Modifier implements MeleeHitModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder builder) {
        builder.addHook(this, ModifierHooks.MELEE_HIT);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        var target = context.getLivingTarget();
        var attacker = context.getAttacker();

        if (target != null && !target.isAlive() && attacker instanceof Player player) {
            var type = MysticalAgricultureAPI.getMobSoulTypeRegistry().getMobSoulTypeByEntity(target);

            if (type == null || !type.isEnabled())
                return;

            var jars = getValidSoulJars(player, type);

            if (!jars.isEmpty()) {
                double remaining = 0.25D * modifier.getLevel();

                for (var jar : jars) {
                    remaining = MobSoulUtils.addSoulsToJar(jar, type, remaining);
                    if (remaining <= 0)
                        break;
                }
            }
        }
    }

    private static List<ItemStack> getValidSoulJars(Player player, MobSoulType type) {
        return player.getInventory().items
                .stream()
                .filter(s -> {
                    var id = ForgeRegistries.ITEMS.getKey(s.getItem());
                    return id != null && "mysticalagriculture:soul_jar".equals(id.toString());
                })
                .filter(s -> MobSoulUtils.canAddTypeToJar(s, type))
                .sorted((a, b) -> MobSoulUtils.getType(a) != null ? -1 : MobSoulUtils.getType(b) != null ? 0 : 1)
                .collect(Collectors.toList());
    }
}