package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseItem;
import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.lib.ModTooltips;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.List;
import java.util.function.Consumer;

public class WitheringSoulItem extends BaseItem {
    public WitheringSoulItem(Identifier id) {
        super(id);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag flag) {
        var chance = ModConfigs.WITHERING_SOUL_DROP_CHANCE.get();

        builder.accept(ModTooltips.DROP_CHANCE.args(chance * 100 + "%").toComponent());
    }
}
