package com.blakebr0.mysticalagradditions.compat;

import com.blakebr0.mysticalagriculture.api.farmland.IEssenceFarmland;
import com.blakebr0.mysticalagriculture.block.InfusedFarmlandBlock;
import com.blakebr0.mysticalagriculture.lib.ModTooltips;
import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import mcp.mobius.waila.api.WailaPlugin;

@WailaPlugin
public class JadeCompat implements IWailaPlugin {
    @Override
    public void register(IRegistrar registrar) {
        registrar.registerComponentProvider((tooltip, accessor, config) -> {
            var block = accessor.getBlock();
            var farmland = (IEssenceFarmland) block;

            tooltip.add(ModTooltips.TIER.args(farmland.getTier().getDisplayName()).build());
        }, TooltipPosition.BODY, InfusedFarmlandBlock.class);
    }
}
