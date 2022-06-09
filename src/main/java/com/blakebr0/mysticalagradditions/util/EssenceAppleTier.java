package com.blakebr0.mysticalagradditions.util;

import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.lib.ModTooltips;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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

    public int getHunger() {
        return this.hunger;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public void onFoodEaten(LivingEntity entity) {
        this.onFoodEaten.accept(entity);
    }

    public List<Component> getTooltip() {
        if (this.tooltip.isEmpty()) {
            Arrays.stream(this.effects).forEach(e -> {
                var buff = Component.literal(e.getDisplayName().getString() + " II");
                var buffDuration = ModConfigs.ESSENCE_APPLE_DURATION.get();
                var minutes = Math.floorDiv(buffDuration, 60);
                var seconds = String.format("%02d", buffDuration % 60);
                var duration = Component.literal(minutes + ":" + seconds);

                this.tooltip.add(ModTooltips.BUFF_LINE.args(buff, duration).build());
            });
        }

        return this.tooltip;
    }

    private static void addPotionEffect(LivingEntity entity, MobEffect effect) {
        var effectDuration = ModConfigs.ESSENCE_APPLE_DURATION.get() * 20;
        var current = entity.getEffect(effect);
        var duration = current != null ? current.getDuration() : 0;

        entity.addEffect(new MobEffectInstance(effect, duration + effectDuration, 1));
    }
}
