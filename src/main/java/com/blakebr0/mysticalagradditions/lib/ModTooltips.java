package com.blakebr0.mysticalagradditions.lib;

import com.blakebr0.cucumber.lib.Tooltip;
import com.blakebr0.mysticalagriculture.api.util.AugmentUtils;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;

public class ModTooltips {
    public static final Tooltip TIER = new Tooltip("tooltip.mysticalagriculture.tier");

    public static ITextComponent getTooltipForTier(int tier) {
        return TIER.args(AugmentUtils.getTooltipForTier(tier)).color(TextFormatting.GRAY).build();
    }
}
