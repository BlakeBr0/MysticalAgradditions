package com.blakebr0.mysticalagradditions.compat.tconstruct;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.compat.tconstruct.modifier.ProsperousModifier;
import com.blakebr0.mysticalagradditions.compat.tconstruct.modifier.SoulSiphonerModifier;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public final class ModModifiers {
    public static final ModifierDeferredRegister REGISTRY = ModifierDeferredRegister.create(MysticalAgradditions.MOD_ID);

    public static final StaticModifier<Modifier> PROSPEROUS = REGISTRY.register("prosperous", ProsperousModifier::new);
    public static final StaticModifier<Modifier> SOUL_SIPHONER = REGISTRY.register("soul_siphoner", SoulSiphonerModifier::new);
}
