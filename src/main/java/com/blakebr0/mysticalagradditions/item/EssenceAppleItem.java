package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseItem;
import com.blakebr0.cucumber.lib.Tooltips;
import com.blakebr0.mysticalagradditions.lib.ModTooltips;
import com.blakebr0.mysticalagradditions.util.EssenceAppleTier;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Function;

public class EssenceAppleItem extends BaseItem {
    private static final Food.Builder food = new Food.Builder().alwaysEat();
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
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity entity) {
        if (!world.isClientSide()) {
            this.tier.onFoodEaten(entity);
        }

        return entity.eat(world, stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(ModTooltips.GIVES_BUFFS.build());
            tooltip.addAll(this.tier.getTooltip());
        } else {
            tooltip.add(Tooltips.HOLD_SHIFT_FOR_INFO.build());
        }
    }
}
