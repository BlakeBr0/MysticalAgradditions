package com.blakebr0.mysticalagradditions.util;

import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.lib.ModTooltips;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public enum EssenceAppleTier {
    INFERIUM(6, 0.3F, List.of(MobEffects.ABSORPTION)),
    PRUDENTIUM(8, 0.4F, List.of(MobEffects.ABSORPTION, MobEffects.SPEED)),
    TERTIUM(10, 0.5F, List.of(MobEffects.ABSORPTION, MobEffects.SPEED, MobEffects.RESISTANCE)),
    IMPERIUM(12, 0.6F, List.of(MobEffects.ABSORPTION, MobEffects.SPEED, MobEffects.RESISTANCE, MobEffects.REGENERATION)),
    SUPREMIUM(16, 0.7F, List.of(MobEffects.ABSORPTION, MobEffects.SPEED, MobEffects.RESISTANCE, MobEffects.REGENERATION, MobEffects.STRENGTH)),
    INSANIUM(20, 0.8F, List.of(MobEffects.ABSORPTION, MobEffects.SPEED, MobEffects.RESISTANCE, MobEffects.REGENERATION, MobEffects.STRENGTH, MobEffects.HASTE));

    private final Consumer<LivingEntity> onFoodEaten;
    private final List<Component> tooltip;
    private final int hunger;
    private final float saturation;
    private final List<Holder<MobEffect>> effects;

    EssenceAppleTier(int hunger, float saturation, List<Holder<MobEffect>> effects) {
        this.hunger = hunger;
        this.saturation = saturation;
        this.effects = effects;

        this.onFoodEaten = entity -> {
            for (var effect : effects) {
                addPotionEffect(entity, effect);
            }
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
            for (var effect : this.effects) {
                int duration = ModConfigs.ESSENCE_APPLE_DURATION.get();
                var minutes = Math.floorDiv(duration, 60);
                var seconds = String.format("%02d", duration % 60);

                this.tooltip.add(ModTooltips.createMobEffectLine(effect, "II", minutes + ":" + seconds));
            }
        }

        return this.tooltip;
    }

    private static void addPotionEffect(LivingEntity entity, Holder<MobEffect> effect) {
        var effectDuration = ModConfigs.ESSENCE_APPLE_DURATION.get() * 20;
        var current = entity.getEffect(effect);
        var duration = current != null ? current.getDuration() : 0;

        entity.addEffect(new MobEffectInstance(effect, duration + effectDuration, 1));
    }
}
