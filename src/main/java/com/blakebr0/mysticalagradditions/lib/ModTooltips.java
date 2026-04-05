package com.blakebr0.mysticalagradditions.lib;

import com.blakebr0.cucumber.util.Tooltip;
import com.blakebr0.mysticalagriculture.api.util.TinkerableUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;

public final class ModTooltips {
    public static final Tooltip TIER = new Tooltip("tooltip.mysticalagriculture.tier");
    public static final Tooltip DROP_CHANCE = new Tooltip("tooltip.mysticalagradditions.drop_chance");
    public static final Tooltip GIVES_BUFFS = new Tooltip("tooltip.mysticalagradditions.gives_buffs");

    public static Component getTooltipForTier(int tier) {
        return TIER.args(TinkerableUtils.getTooltipForTier(tier)).color(ChatFormatting.GRAY).toComponent();
    }

    public static Component createMobEffectLine(Holder<MobEffect> effect, String level, String duration) {
        return Component.literal(" - %s %s (%s)".formatted(effect.value().getDisplayName().getString(), level, duration)).withStyle(ChatFormatting.GRAY);
    }
}
