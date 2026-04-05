package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseItem;
import com.blakebr0.cucumber.lib.Tooltips;
import com.blakebr0.mysticalagradditions.lib.ModTooltips;
import com.blakebr0.mysticalagradditions.util.EssenceAppleTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class EssenceAppleItem extends BaseItem {
    private static final FoodProperties.Builder food = new FoodProperties.Builder().alwaysEdible();
    private final EssenceAppleTier tier;

    public EssenceAppleItem(Identifier id, EssenceAppleTier tier) {
        super(id, p -> p.food(food.nutrition(tier.getHunger()).saturationModifier(tier.getSaturation()).build()));
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

        stack.shrink(1);

        return stack;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag flag) {
        if (flag.hasShiftDown()) {
            builder.accept(ModTooltips.GIVES_BUFFS.toComponent());

            for (var line : this.tier.getTooltip()) {
                builder.accept(line);
            }
        } else {
            builder.accept(Tooltips.HOLD_SHIFT_FOR_INFO.toComponent());
        }
    }
}
