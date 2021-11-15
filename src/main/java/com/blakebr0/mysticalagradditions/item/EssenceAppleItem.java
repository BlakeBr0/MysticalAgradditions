package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseItem;
import com.blakebr0.cucumber.lib.Tooltips;
import com.blakebr0.mysticalagradditions.lib.ModTooltips;
import com.blakebr0.mysticalagradditions.util.EssenceAppleTier;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Function;

public class EssenceAppleItem extends BaseItem {
    private static final FoodProperties.Builder food = new FoodProperties.Builder().alwaysEat();
    private final EssenceAppleTier tier;

    public EssenceAppleItem(EssenceAppleTier tier, Function<Properties, Properties> properties) {
        super(properties.compose(p -> p.food(food.nutrition(tier.getHunger()).saturationMod(tier.getSaturation()).build())));
        this.tier = tier;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide()) {
            this.tier.onFoodEaten(entity);
        }

        return entity.eat(level, stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(ModTooltips.GIVES_BUFFS.build());
            tooltip.addAll(this.tier.getTooltip());
        } else {
            tooltip.add(Tooltips.HOLD_SHIFT_FOR_INFO.build());
        }
    }
}
