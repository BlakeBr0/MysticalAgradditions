package com.blakebr0.mysticalagradditions.init;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Consumer;
import java.util.function.Supplier;

public final class ModFluidTypes {
    private static final Identifier STILL_TEXTURE = MysticalAgradditions.resource("block/molten_still");
    private static final Identifier FLOWING_TEXTURE = MysticalAgradditions.resource("block/molten_flowing");

    public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, MysticalAgradditions.MOD_ID);

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_INFERIUM = REGISTRY.register("molten_inferium", newMoltenFluidType(0xFF748E00));
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_PRUDENTIUM = REGISTRY.register("molten_prudentium", newMoltenFluidType(0xFF008C23));
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_TERTIUM = REGISTRY.register("molten_tertium", newMoltenFluidType(0xFFB74900));
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_IMPERIUM = REGISTRY.register("molten_imperium", newMoltenFluidType(0xFF007FDB));
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_SUPREMIUM = REGISTRY.register("molten_supremium", newMoltenFluidType(0xFFC40000));
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_SOULIUM = REGISTRY.register("molten_soulium", newMoltenFluidType(0xFF8c563c));

    private static Supplier<FluidType> newMoltenFluidType(int color) {
        var properties = FluidType.Properties.create()
                .density(2000).viscosity(10000).temperature(1000)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA);

        return () -> new FluidType(properties) {
//            TODO fluid textures stuff?
//            @Override
//            public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
//                consumer.accept(new IClientFluidTypeExtensions() {
//                    @Override
//                    public int getTintColor() {
//                        return color;
//                    }
//
//                    @Override
//                    public Identifier getStillTexture() {
//                        return STILL_TEXTURE;
//                    }
//
//                    @Override
//                    public Identifier getFlowingTexture() {
//                        return FLOWING_TEXTURE;
//                    }
//                });
//            }
        };
    }
}
