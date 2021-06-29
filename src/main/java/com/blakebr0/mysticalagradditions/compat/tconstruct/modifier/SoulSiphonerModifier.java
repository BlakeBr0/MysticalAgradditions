package com.blakebr0.mysticalagradditions.compat.tconstruct.modifier;

import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;
import com.blakebr0.mysticalagriculture.api.soul.IMobSoulType;
import com.blakebr0.mysticalagriculture.api.util.MobSoulUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import java.util.List;
import java.util.stream.Collectors;

public class SoulSiphonerModifier extends Modifier {
    public SoulSiphonerModifier() {
        super(0x8c563c);
    }

    @Override
    public int afterLivingHit(IModifierToolStack tool, int level, LivingEntity attacker, LivingEntity target, float damageDealt, boolean isCritical, float cooldown) {
        if (!target.isAlive() && attacker instanceof PlayerEntity) {
            IMobSoulType type = MysticalAgricultureAPI.getMobSoulTypeRegistry().getMobSoulTypeByEntity(target);

            if (type == null || !type.isEnabled()) {
                return super.afterLivingHit(tool, level, attacker, target, damageDealt, isCritical, cooldown);
            }

            PlayerEntity player = (PlayerEntity) attacker;
            List<ItemStack> jars = getValidSoulJars(player, type);

            if (!jars.isEmpty()) {
                double remaining = 0.25D * level;

                for (ItemStack jar : jars) {
                    remaining = MobSoulUtils.addSoulsToJar(jar, type, remaining);
                    if (remaining <= 0)
                        break;
                }
            }
        }

        return super.afterLivingHit(tool, level, attacker, target, damageDealt, isCritical, cooldown);
    }

    private static List<ItemStack> getValidSoulJars(PlayerEntity player, IMobSoulType type) {
        return player.inventory.items.stream()
                .filter(s -> {
                    ResourceLocation id = s.getItem().getRegistryName();
                    return id != null && "mysticalagriculture:soul_jar".equals(id.toString());
                })
                .filter(s -> MobSoulUtils.canAddTypeToJar(s, type))
                .sorted((a, b) -> MobSoulUtils.getType(a) != null ? -1 : MobSoulUtils.getType(b) != null ? 0 : 1)
                .collect(Collectors.toList());
    }
}
