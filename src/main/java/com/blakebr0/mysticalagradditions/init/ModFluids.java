package com.blakebr0.mysticalagradditions.init;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.RegisterEvent;

public final class ModFluids {
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_PROSPERITY = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_prosperity"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_PROSPERITY_FLOWING = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_prosperity_flowing"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_INFERIUM = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_inferium"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_INFERIUM_FLOWING = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_inferium_flowing"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_PRUDENTIUM = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_prudentium"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_PRUDENTIUM_FLOWING = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_prudentium_flowing"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_TERTIUM = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_tertium"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_TERTIUM_FLOWING = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_tertium_flowing"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_IMPERIUM = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_imperium"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_IMPERIUM_FLOWING = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_imperium_flowing"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_SUPREMIUM = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_supremium"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_SUPREMIUM_FLOWING = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_supremium_flowing"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_AWAKENED_SUPREMIUM = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_awakened_supremium"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_AWAKENED_SUPREMIUM_FLOWING = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_awakened_supremium_flowing"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_INSANIUM = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_insanium"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_INSANIUM_FLOWING = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_insanium_flowing"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_SOULIUM = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_soulium"));
    public static final DeferredHolder<Fluid, Fluid> MOLTEN_SOULIUM_FLOWING = DeferredHolder.create(Registries.FLUID, MysticalAgradditions.resource("molten_soulium_flowing"));

    private static final BaseFlowingFluid.Properties MOLTEN_PROSPERITY_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.MOLTEN_PROSPERITY, MOLTEN_PROSPERITY, MOLTEN_PROSPERITY_FLOWING);
    private static final BaseFlowingFluid.Properties MOLTEN_INFERIUM_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.MOLTEN_INFERIUM, MOLTEN_INFERIUM, MOLTEN_INFERIUM_FLOWING);
    private static final BaseFlowingFluid.Properties MOLTEN_PRUDENTIUM_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.MOLTEN_PRUDENTIUM, MOLTEN_PRUDENTIUM, MOLTEN_PRUDENTIUM_FLOWING);
    private static final BaseFlowingFluid.Properties MOLTEN_TERTIUM_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.MOLTEN_TERTIUM, MOLTEN_TERTIUM, MOLTEN_TERTIUM_FLOWING);
    private static final BaseFlowingFluid.Properties MOLTEN_IMPERIUM_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.MOLTEN_IMPERIUM, MOLTEN_IMPERIUM, MOLTEN_IMPERIUM_FLOWING);
    private static final BaseFlowingFluid.Properties MOLTEN_SUPREMIUM_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.MOLTEN_SUPREMIUM, MOLTEN_SUPREMIUM, MOLTEN_SUPREMIUM_FLOWING);
    private static final BaseFlowingFluid.Properties MOLTEN_AWAKENED_SUPREMIUM_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.MOLTEN_AWAKENED_SUPREMIUM, MOLTEN_AWAKENED_SUPREMIUM, MOLTEN_AWAKENED_SUPREMIUM_FLOWING);
    private static final BaseFlowingFluid.Properties MOLTEN_INSANIUM_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.MOLTEN_INSANIUM, MOLTEN_INSANIUM, MOLTEN_INSANIUM_FLOWING);
    private static final BaseFlowingFluid.Properties MOLTEN_SOULIUM_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.MOLTEN_SOULIUM, MOLTEN_SOULIUM, MOLTEN_SOULIUM_FLOWING);

    @SubscribeEvent
    public void onRegisterFluids(RegisterEvent event) {
        event.register(Registries.FLUID, registry -> {
            registry.register(
                    MysticalAgradditions.resource("molten_prosperity"),
                    new BaseFlowingFluid.Source(MOLTEN_PROSPERITY_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_PROSPERITY.get())
                            .bucket(ModItems.MOLTEN_PROSPERITY_BUCKET)
                    )
            );
            registry.register(
                    MysticalAgradditions.resource("molten_prosperity_flowing"),
                    new BaseFlowingFluid.Flowing(MOLTEN_PROSPERITY_PROPERTIES)
            );
            registry.register(
                    MysticalAgradditions.resource("molten_inferium"),
                    new BaseFlowingFluid.Source(MOLTEN_INFERIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_INFERIUM.get())
                            .bucket(ModItems.MOLTEN_INFERIUM_BUCKET)
                    )
            );
            registry.register(
                    MysticalAgradditions.resource("molten_inferium_flowing"),
                    new BaseFlowingFluid.Flowing(MOLTEN_INFERIUM_PROPERTIES)
            );
            registry.register(
                    MysticalAgradditions.resource("molten_prudentium"),
                    new BaseFlowingFluid.Source(MOLTEN_PRUDENTIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_PRUDENTIUM.get())
                            .bucket(ModItems.MOLTEN_PRUDENTIUM_BUCKET)
                    )
            );
            registry.register(
                    MysticalAgradditions.resource("molten_prudentium_flowing"),
                    new BaseFlowingFluid.Flowing(MOLTEN_PRUDENTIUM_PROPERTIES)
            );
            registry.register(
                    MysticalAgradditions.resource("molten_tertium"),
                    new BaseFlowingFluid.Source(MOLTEN_TERTIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_TERTIUM.get())
                            .bucket(ModItems.MOLTEN_TERTIUM_BUCKET)
                    )
            );
            registry.register(
                    MysticalAgradditions.resource("molten_tertium_flowing"),
                    new BaseFlowingFluid.Flowing(MOLTEN_TERTIUM_PROPERTIES)
            );
            registry.register(
                    MysticalAgradditions.resource("molten_imperium"),
                    new BaseFlowingFluid.Source(MOLTEN_IMPERIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_IMPERIUM.get())
                            .bucket(ModItems.MOLTEN_IMPERIUM_BUCKET)
                    )
            );
            registry.register(
                    MysticalAgradditions.resource("molten_imperium_flowing"),
                    new BaseFlowingFluid.Flowing(MOLTEN_IMPERIUM_PROPERTIES)
            );
            registry.register(
                    MysticalAgradditions.resource("molten_supremium"),
                    new BaseFlowingFluid.Source(MOLTEN_SUPREMIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_SUPREMIUM.get())
                            .bucket(ModItems.MOLTEN_SUPREMIUM_BUCKET)
                    )
            );
            registry.register(
                    MysticalAgradditions.resource("molten_supremium_flowing"),
                    new BaseFlowingFluid.Flowing(MOLTEN_SUPREMIUM_PROPERTIES)
            );
            registry.register(
                    MysticalAgradditions.resource("molten_awakened_supremium"),
                    new BaseFlowingFluid.Source(MOLTEN_AWAKENED_SUPREMIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_AWAKENED_SUPREMIUM.get())
                            .bucket(ModItems.MOLTEN_AWAKENED_SUPREMIUM_BUCKET)
                    )
            );
            registry.register(
                    MysticalAgradditions.resource("molten_awakened_supremium_flowing"),
                    new BaseFlowingFluid.Flowing(MOLTEN_AWAKENED_SUPREMIUM_PROPERTIES)
            );
            registry.register(
                    MysticalAgradditions.resource("molten_insanium"),
                    new BaseFlowingFluid.Source(MOLTEN_INSANIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_INSANIUM.get())
                            .bucket(ModItems.MOLTEN_INSANIUM_BUCKET)
                    )
            );
            registry.register(
                    MysticalAgradditions.resource("molten_insanium_flowing"),
                    new BaseFlowingFluid.Flowing(MOLTEN_INSANIUM_PROPERTIES)
            );
            registry.register(
                    MysticalAgradditions.resource("molten_soulium"),
                    new BaseFlowingFluid.Source(MOLTEN_SOULIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_SOULIUM.get())
                            .bucket(ModItems.MOLTEN_SOULIUM_BUCKET)
                    )
            );
            registry.register(
                    MysticalAgradditions.resource("molten_soulium_flowing"),
                    new BaseFlowingFluid.Flowing(MOLTEN_SOULIUM_PROPERTIES)
            );
        });
    }
}
