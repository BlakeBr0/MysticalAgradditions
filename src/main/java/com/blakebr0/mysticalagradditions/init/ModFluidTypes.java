package com.blakebr0.mysticalagradditions.init;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class ModFluidTypes {
    public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, MysticalAgradditions.MOD_ID);

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_INFERIUM = registerMolten("molten_inferium");
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_PRUDENTIUM = registerMolten("molten_prudentium");
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_TERTIUM = registerMolten("molten_tertium");
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_IMPERIUM = registerMolten("molten_imperium");
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_SUPREMIUM = registerMolten("molten_supremium");
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_SOULIUM = registerMolten("molten_soulium");

    private static DeferredHolder<FluidType, FluidType> registerMolten(String name) {
        var properties = FluidType.Properties.create()
                .density(2000).viscosity(10000).temperature(1000)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA);

        return REGISTRY.register(name, () -> new FluidType(properties));
    }
}
