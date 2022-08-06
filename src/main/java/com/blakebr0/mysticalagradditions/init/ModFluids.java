package com.blakebr0.mysticalagradditions.init;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

public final class ModFluids {
    public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUIDS, MysticalAgradditions.MOD_ID);

    public static final RegistryObject<Fluid> MOLTEN_INFERIUM = RegistryObject.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_inferium"), ForgeRegistries.FLUIDS);
    public static final RegistryObject<Fluid> MOLTEN_INFERIUM_FLOWING = RegistryObject.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_inferium_flowing"), ForgeRegistries.FLUIDS);
    public static final RegistryObject<Fluid> MOLTEN_PRUDENTIUM = RegistryObject.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_prudentium"), ForgeRegistries.FLUIDS);
    public static final RegistryObject<Fluid> MOLTEN_PRUDENTIUM_FLOWING = RegistryObject.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_prudentium_flowing"), ForgeRegistries.FLUIDS);
    public static final RegistryObject<Fluid> MOLTEN_TERTIUM = RegistryObject.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_tertium"), ForgeRegistries.FLUIDS);
    public static final RegistryObject<Fluid> MOLTEN_TERTIUM_FLOWING = RegistryObject.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_tertium_flowing"), ForgeRegistries.FLUIDS);
    public static final RegistryObject<Fluid> MOLTEN_IMPERIUM = RegistryObject.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_imperium"), ForgeRegistries.FLUIDS);
    public static final RegistryObject<Fluid> MOLTEN_IMPERIUM_FLOWING = RegistryObject.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_imperium_flowing"), ForgeRegistries.FLUIDS);
    public static final RegistryObject<Fluid> MOLTEN_SUPREMIUM = RegistryObject.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_supremium"), ForgeRegistries.FLUIDS);
    public static final RegistryObject<Fluid> MOLTEN_SUPREMIUM_FLOWING = RegistryObject.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_supremium_flowing"), ForgeRegistries.FLUIDS);
    public static final RegistryObject<Fluid> MOLTEN_SOULIUM = RegistryObject.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_soulium"), ForgeRegistries.FLUIDS);
    public static final RegistryObject<Fluid> MOLTEN_SOULIUM_FLOWING = RegistryObject.create(new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_soulium_flowing"), ForgeRegistries.FLUIDS);

    private static final ForgeFlowingFluid.Properties MOLTEN_INFERIUM_PROPERTIES = new ForgeFlowingFluid.Properties(ModFluidTypes.MOLTEN_INFERIUM, MOLTEN_INFERIUM, MOLTEN_INFERIUM_FLOWING);
    private static final ForgeFlowingFluid.Properties MOLTEN_PRUDENTIUM_PROPERTIES = new ForgeFlowingFluid.Properties(ModFluidTypes.MOLTEN_PRUDENTIUM, MOLTEN_PRUDENTIUM, MOLTEN_PRUDENTIUM_FLOWING);
    private static final ForgeFlowingFluid.Properties MOLTEN_TERTIUM_PROPERTIES = new ForgeFlowingFluid.Properties(ModFluidTypes.MOLTEN_TERTIUM, MOLTEN_TERTIUM, MOLTEN_TERTIUM_FLOWING);
    private static final ForgeFlowingFluid.Properties MOLTEN_IMPERIUM_PROPERTIES = new ForgeFlowingFluid.Properties(ModFluidTypes.MOLTEN_IMPERIUM, MOLTEN_IMPERIUM, MOLTEN_IMPERIUM_FLOWING);
    private static final ForgeFlowingFluid.Properties MOLTEN_SUPREMIUM_PROPERTIES = new ForgeFlowingFluid.Properties(ModFluidTypes.MOLTEN_SUPREMIUM, MOLTEN_SUPREMIUM, MOLTEN_SUPREMIUM_FLOWING);
    private static final ForgeFlowingFluid.Properties MOLTEN_SOULIUM_PROPERTIES = new ForgeFlowingFluid.Properties(ModFluidTypes.MOLTEN_SOULIUM, MOLTEN_SOULIUM, MOLTEN_SOULIUM_FLOWING);

    @SubscribeEvent
    public void onRegisterFluids(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.FLUIDS, registry -> {
            registry.register(
                    new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_inferium"),
                    new ForgeFlowingFluid.Source(MOLTEN_INFERIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_INFERIUM.get())
                            .bucket(ModItems.MOLTEN_INFERIUM_BUCKET)
                    )
            );
            registry.register(
                    new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_inferium_flowing"),
                    new ForgeFlowingFluid.Flowing(MOLTEN_INFERIUM_PROPERTIES)
            );
            registry.register(
                    new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_prudentium"),
                    new ForgeFlowingFluid.Source(MOLTEN_PRUDENTIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_PRUDENTIUM.get())
                            .bucket(ModItems.MOLTEN_PRUDENTIUM_BUCKET)
                    )
            );
            registry.register(
                    new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_prudentium_flowing"),
                    new ForgeFlowingFluid.Flowing(MOLTEN_PRUDENTIUM_PROPERTIES)
            );
            registry.register(
                    new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_tertium"),
                    new ForgeFlowingFluid.Source(MOLTEN_TERTIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_TERTIUM.get())
                            .bucket(ModItems.MOLTEN_TERTIUM_BUCKET)
                    )
            );
            registry.register(
                    new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_tertium_flowing"),
                    new ForgeFlowingFluid.Flowing(MOLTEN_TERTIUM_PROPERTIES)
            );
            registry.register(
                    new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_imperium"),
                    new ForgeFlowingFluid.Source(MOLTEN_IMPERIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_IMPERIUM.get())
                            .bucket(ModItems.MOLTEN_IMPERIUM_BUCKET)
                    )
            );
            registry.register(
                    new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_imperium_flowing"),
                    new ForgeFlowingFluid.Flowing(MOLTEN_IMPERIUM_PROPERTIES)
            );
            registry.register(
                    new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_supremium"),
                    new ForgeFlowingFluid.Source(MOLTEN_SUPREMIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_SUPREMIUM.get())
                            .bucket(ModItems.MOLTEN_SUPREMIUM_BUCKET)
                    )
            );
            registry.register(
                    new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_supremium_flowing"),
                    new ForgeFlowingFluid.Flowing(MOLTEN_SUPREMIUM_PROPERTIES)
            );
            registry.register(
                    new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_soulium"),
                    new ForgeFlowingFluid.Source(MOLTEN_SOULIUM_PROPERTIES
                            .block(() -> (LiquidBlock) ModBlocks.MOLTEN_SOULIUM.get())
                            .bucket(ModItems.MOLTEN_SOULIUM_BUCKET)
                    )
            );
            registry.register(
                    new ResourceLocation(MysticalAgradditions.MOD_ID, "molten_soulium_flowing"),
                    new ForgeFlowingFluid.Flowing(MOLTEN_SOULIUM_PROPERTIES)
            );
        });
    }
}
