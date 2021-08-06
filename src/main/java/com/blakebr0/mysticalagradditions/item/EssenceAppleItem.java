package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseItem;
import com.blakebr0.cucumber.lib.Tooltips;
import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.lib.ModTooltips;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import net.minecraft.world.item.Item.Properties;

public class EssenceAppleItem extends BaseItem {
    private static final FoodProperties.Builder food = new FoodProperties.Builder().alwaysEat();
    private final EssenceAppleTier tier;

    public EssenceAppleItem(EssenceAppleTier tier, Function<Properties, Properties> properties) {
        super(properties.compose(p -> p.food(food.nutrition(tier.hunger).saturationMod(tier.saturation).build())));
        this.tier = tier;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (!world.isClientSide()) {
            this.tier.onFoodEaten(entity);
        }

        return entity.eat(world, stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(ModTooltips.GIVES_BUFFS.build());
            tooltip.addAll(this.tier.getTooltip());
        } else {
            tooltip.add(Tooltips.HOLD_SHIFT_FOR_INFO.build());
        }
    }

    public enum EssenceAppleTier {
        INFERIUM(6, 0.3F, MobEffects.ABSORPTION),
        PRUDENTIUM(8, 0.4F, MobEffects.ABSORPTION, MobEffects.MOVEMENT_SPEED),
        TERTIUM(10, 0.5F, MobEffects.ABSORPTION, MobEffects.MOVEMENT_SPEED, MobEffects.DAMAGE_RESISTANCE),
        IMPERIUM(12, 0.6F, MobEffects.ABSORPTION, MobEffects.MOVEMENT_SPEED, MobEffects.DAMAGE_RESISTANCE, MobEffects.REGENERATION),
        SUPREMIUM(16, 0.7F, MobEffects.ABSORPTION, MobEffects.MOVEMENT_SPEED, MobEffects.DAMAGE_RESISTANCE, MobEffects.REGENERATION, MobEffects.DAMAGE_BOOST),
        INSANIUM(20, 0.8F, MobEffects.ABSORPTION, MobEffects.MOVEMENT_SPEED, MobEffects.DAMAGE_RESISTANCE, MobEffects.REGENERATION, MobEffects.DAMAGE_BOOST, MobEffects.DIG_SPEED);

        private final Consumer<LivingEntity> onFoodEaten;
        private final List<Component> tooltip;
        private final int hunger;
        private final float saturation;
        private final MobEffect[] effects;

        EssenceAppleTier(int hunger, float saturation, MobEffect ...effects) {
            this.hunger = hunger;
            this.saturation = saturation;
            this.effects = effects;

            this.onFoodEaten = entity -> {
                Arrays.stream(effects).forEach(e -> addPotionEffect(entity, e));
            };

            this.tooltip = new ArrayList<>();
        }

        public void onFoodEaten(LivingEntity entity) {
            this.onFoodEaten.accept(entity);
        }

        public List<Component> getTooltip() {
            if (this.tooltip.isEmpty()) {
                Arrays.stream(this.effects).forEach(e -> {
                    TextComponent buff = new TextComponent(e.getDisplayName().getString() + " II");
                    int buffDuration = ModConfigs.ESSENCE_APPLE_DURATION.get();
                    int minutes = Math.floorDiv(buffDuration, 60);
                    String seconds = String.format("%02d", buffDuration % 60);
                    TextComponent duration = new TextComponent(minutes + ":" + seconds);

                    this.tooltip.add(ModTooltips.BUFF_LINE.args(buff, duration).build());
                });
            }

            return this.tooltip;
        }

        private static void addPotionEffect(LivingEntity entity, MobEffect effect) {
            int effectDuration = ModConfigs.ESSENCE_APPLE_DURATION.get() * 20;
            MobEffectInstance current = entity.getEffect(effect);
            int duration = current != null ? current.getDuration() : 0;

            entity.addEffect(new MobEffectInstance(effect, duration + effectDuration, 1));
        }
    }
}
