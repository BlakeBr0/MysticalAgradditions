package com.blakebr0.mysticalagradditions.init;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;
import java.util.function.Supplier;

public final class ModFluidTypes {
    private static final ResourceLocation STILL_TEXTURE = new ResourceLocation(MysticalAgradditions.MOD_ID, "block/molten_still");
    private static final ResourceLocation FLOWING_TEXTURE = new ResourceLocation(MysticalAgradditions.MOD_ID, "block/molten_flowing");

    public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MysticalAgradditions.MOD_ID);

    public static final RegistryObject<FluidType> MOLTEN_INFERIUM = REGISTRY.register("molten_inferium", newMoltenFluidType(0xFF748E00));
    public static final RegistryObject<FluidType> MOLTEN_PRUDENTIUM = REGISTRY.register("molten_prudentium", newMoltenFluidType(0xFF008C23));
    public static final RegistryObject<FluidType> MOLTEN_TERTIUM = REGISTRY.register("molten_tertium", newMoltenFluidType(0xFFB74900));
    public static final RegistryObject<FluidType> MOLTEN_IMPERIUM = REGISTRY.register("molten_imperium", newMoltenFluidType(0xFF007FDB));
    public static final RegistryObject<FluidType> MOLTEN_SUPREMIUM = REGISTRY.register("molten_supremium", newMoltenFluidType(0xFFC40000));
    public static final RegistryObject<FluidType> MOLTEN_SOULIUM = REGISTRY.register("molten_soulium", newMoltenFluidType(0xFF8c563c));

    private static Supplier<FluidType> newMoltenFluidType(int color) {
        var properties = FluidType.Properties.create()
                .density(2000).viscosity(10000).temperature(1000)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA);

        return () -> new FluidType(properties) {
            @Override
            public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                consumer.accept(new IClientFluidTypeExtensions() {
                    @Override
                    public int getTintColor() {
                        return color;
                    }

                    @Override
                    public ResourceLocation getStillTexture() {
                        return STILL_TEXTURE;
                    }

                    @Override
                    public ResourceLocation getFlowingTexture() {
                        return FLOWING_TEXTURE;
                    }
                });
            }
        };
    }
}
