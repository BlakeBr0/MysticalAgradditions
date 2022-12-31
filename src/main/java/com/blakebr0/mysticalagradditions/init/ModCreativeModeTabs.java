package com.blakebr0.mysticalagradditions.init;

import com.blakebr0.cucumber.util.FeatureFlagDisplayItemGenerator;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class ModCreativeModeTabs {
    @SubscribeEvent
    public void onRegisterCreativeModeTabs(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(MysticalAgradditions.MOD_ID, "creative_mode_tab"), (builder) -> {
            var displayItems = FeatureFlagDisplayItemGenerator.create((flagSet, output, hasPermission) -> {
                output.accept(ModBlocks.INSANIUM_BLOCK);
                output.accept(ModBlocks.INSANIUM_INGOT_BLOCK);
                output.accept(ModBlocks.INSANIUM_GEMSTONE_BLOCK);
                output.accept(ModBlocks.INSANIUM_FARMLAND);
                output.accept(ModBlocks.INFERIUM_COAL_BLOCK);
                output.accept(ModBlocks.PRUDENTIUM_COAL_BLOCK);
                output.accept(ModBlocks.TERTIUM_COAL_BLOCK);
                output.accept(ModBlocks.IMPERIUM_COAL_BLOCK);
                output.accept(ModBlocks.SUPREMIUM_COAL_BLOCK);
                output.accept(ModBlocks.INSANIUM_COAL_BLOCK);
                output.accept(ModBlocks.NETHER_PROSPERITY_ORE);
                output.accept(ModBlocks.NETHER_INFERIUM_ORE);
                output.accept(ModBlocks.END_PROSPERITY_ORE);
                output.accept(ModBlocks.END_INFERIUM_ORE);

                if (ModCrops.NETHER_STAR.isEnabled()) {
                    output.accept(ModBlocks.NETHER_STAR_CRUX);
                }

                if (ModCrops.DRAGON_EGG.isEnabled()) {
                    output.accept(ModBlocks.DRAGON_EGG_CRUX);
                }

                if (ModCrops.GAIA_SPIRIT.isEnabled()) {
                    output.accept(ModBlocks.GAIA_SPIRIT_CRUX);
                }

                if (ModCrops.AWAKENED_DRACONIUM.isEnabled()) {
                    output.accept(ModBlocks.AWAKENED_DRACONIUM_CRUX);
                }

                if (ModCrops.NITRO_CRYSTAL.isEnabled()) {
                    output.accept(ModBlocks.NITRO_CRYSTAL_CRUX);
                }

                output.accept(ModItems.INSANIUM_ESSENCE);
                output.accept(ModItems.INSANIUM_INGOT);
                output.accept(ModItems.INSANIUM_NUGGET);
                output.accept(ModItems.INSANIUM_GEMSTONE);
                output.accept(ModItems.NETHER_STAR_SHARD);
                output.accept(ModItems.WITHERING_SOUL);
                output.accept(ModItems.DRAGON_EGG_CHUNK);
                output.accept(ModItems.DRAGON_SCALE);
                output.accept(ModItems.CREATIVE_ESSENCE);
                output.accept(ModItems.INFERIUM_COAL);
                output.accept(ModItems.PRUDENTIUM_COAL);
                output.accept(ModItems.TERTIUM_COAL);
                output.accept(ModItems.IMPERIUM_COAL);
                output.accept(ModItems.SUPREMIUM_COAL);
                output.accept(ModItems.INSANIUM_COAL);
                output.accept(ModItems.INFERIUM_APPLE);
                output.accept(ModItems.PRUDENTIUM_APPLE);
                output.accept(ModItems.TERTIUM_APPLE);
                output.accept(ModItems.IMPERIUM_APPLE);
                output.accept(ModItems.SUPREMIUM_APPLE);
                output.accept(ModItems.INSANIUM_APPLE);

                output.accept(ModItems.INFERIUM_PAXEL);
                output.accept(ModItems.PRUDENTIUM_PAXEL);
                output.accept(ModItems.TERTIUM_PAXEL);
                output.accept(ModItems.IMPERIUM_PAXEL);
                output.accept(ModItems.SUPREMIUM_PAXEL);
                output.accept(ModItems.AWAKENED_SUPREMIUM_PAXEL);

                output.accept(ModItems.MOLTEN_INFERIUM_BUCKET);
                output.accept(ModItems.MOLTEN_PRUDENTIUM_BUCKET);
                output.accept(ModItems.MOLTEN_TERTIUM_BUCKET);
                output.accept(ModItems.MOLTEN_IMPERIUM_BUCKET);
                output.accept(ModItems.MOLTEN_SUPREMIUM_BUCKET);
                output.accept(ModItems.MOLTEN_SOULIUM_BUCKET);
            });

            builder.title(Component.translatable("itemGroup.mysticalagradditions"))
                    .icon(() -> new ItemStack(ModItems.INSANIUM_ESSENCE.get()))
                    .displayItems(displayItems);
        });
    }
}
