package com.blakebr0.mysticalagradditions.util;

import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.lib.ModTooltips;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public enum EssenceAppleTier {
    INFERIUM(6, 0.3F, Effects.ABSORPTION),
    PRUDENTIUM(8, 0.4F, Effects.ABSORPTION, Effects.MOVEMENT_SPEED),
    TERTIUM(10, 0.5F, Effects.ABSORPTION, Effects.MOVEMENT_SPEED, Effects.DAMAGE_RESISTANCE),
    IMPERIUM(12, 0.6F, Effects.ABSORPTION, Effects.MOVEMENT_SPEED, Effects.DAMAGE_RESISTANCE, Effects.REGENERATION),
    SUPREMIUM(16, 0.7F, Effects.ABSORPTION, Effects.MOVEMENT_SPEED, Effects.DAMAGE_RESISTANCE, Effects.REGENERATION, Effects.DAMAGE_BOOST),
    INSANIUM(20, 0.8F, Effects.ABSORPTION, Effects.MOVEMENT_SPEED, Effects.DAMAGE_RESISTANCE, Effects.REGENERATION, Effects.DAMAGE_BOOST, Effects.DIG_SPEED);

    private final Consumer<LivingEntity> onFoodEaten;
    private final List<ITextComponent> tooltip;
    private final int hunger;
    private final float saturation;
    private final Effect[] effects;

    EssenceAppleTier(int hunger, float saturation, Effect ...effects) {
        this.hunger = hunger;
        this.saturation = saturation;
        this.effects = effects;

        this.onFoodEaten = entity -> {
            Arrays.stream(effects).forEach(e -> addPotionEffect(entity, e));
        };

        this.tooltip = new ArrayList<>();
    }

    public int getHunger() {
        return this.hunger;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public void onFoodEaten(LivingEntity entity) {
        this.onFoodEaten.accept(entity);
    }

    public List<ITextComponent> getTooltip() {
        if (this.tooltip.isEmpty()) {
            Arrays.stream(this.effects).forEach(e -> {
                StringTextComponent buff = new StringTextComponent(e.getDisplayName().getString() + " II");
                int buffDuration = ModConfigs.ESSENCE_APPLE_DURATION.get();
                int minutes = Math.floorDiv(buffDuration, 60);
                String seconds = String.format("%02d", buffDuration % 60);
                StringTextComponent duration = new StringTextComponent(minutes + ":" + seconds);

                this.tooltip.add(ModTooltips.BUFF_LINE.args(buff, duration).build());
            });
        }

        return this.tooltip;
    }

    private static void addPotionEffect(LivingEntity entity, Effect effect) {
        int effectDuration = ModConfigs.ESSENCE_APPLE_DURATION.get() * 20;
        EffectInstance current = entity.getEffect(effect);
        int duration = current != null ? current.getDuration() : 0;

        entity.addEffect(new EffectInstance(effect, duration + effectDuration, 1));
    }
}
