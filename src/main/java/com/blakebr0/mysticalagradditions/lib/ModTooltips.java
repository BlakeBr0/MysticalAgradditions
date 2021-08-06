package com.blakebr0.mysticalagradditions.lib;

import com.blakebr0.cucumber.util.Tooltip;
import com.blakebr0.mysticalagriculture.api.util.AugmentUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

public final class ModTooltips {
    public static final Tooltip TIER = new Tooltip("tooltip.mysticalagriculture.tier");
    public static final Tooltip DROP_CHANCE = new Tooltip("tooltip.mysticalagradditions.drop_chance");
    public static final Tooltip GIVES_BUFFS = new Tooltip("tooltip.mysticalagradditions.gives_buffs");
    public static final Tooltip BUFF_LINE = new Tooltip("tooltip.mysticalagradditions.buff_line");

    public static Component getTooltipForTier(int tier) {
        return TIER.args(AugmentUtils.getTooltipForTier(tier)).color(ChatFormatting.GRAY).build();
    }
}
