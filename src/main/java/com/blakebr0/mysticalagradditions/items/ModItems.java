package com.blakebr0.mysticalagradditions.items;

import com.blakebr0.cucumber.item.BaseItem;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.blakebr0.mysticalagradditions.MysticalAgradditions.ITEM_GROUP;

public class ModItems {
	public static final List<Supplier<? extends Item>> ENTRIES = new ArrayList<>();

	public static final RegistryObject<BaseItem> INSANIUM_ESSENCE = register("insanium_essence");
	public static final RegistryObject<BaseItem> INSANIUM_INGOT = register("insanium_ingot");
	public static final RegistryObject<BaseItem> INSANIUM_NUGGET = register("insanium_nugget");
	public static final RegistryObject<BaseItem> INSANIUM_GEMSTONE = register("insanium_gemstone");
	public static final RegistryObject<BaseItem> NETHER_STAR_SHARD = register("nether_star_shard");
	public static final RegistryObject<BaseItem> WITHERING_SOUL = register("withering_soul");
	public static final RegistryObject<BaseItem> DRAGON_EGG_CHUNK = register("dragon_egg_chunk");
	public static final RegistryObject<BaseItem> DRAGON_SCALE = register("dragon_scale");
	public static final RegistryObject<CreativeEssenceItem> CREATIVE_ESSENCE = register("creative_essence", () -> new CreativeEssenceItem(p -> p.group(ITEM_GROUP)));

//	public static ItemInsanium itemInsanium = new ItemInsanium();
//	public static ItemStuff itemStuff = new ItemStuff();
//
//	public static ItemTier6Seed itemTier6InferiumSeeds = new ItemTier6Seed("tier6_inferium_seeds", ModBlocks.blockTier6InferiumCrop);
//
//	public static ItemCharm itemCharm = new ItemCharm();
//
//	public static ItemPaxel itemInferiumPaxel = new ItemPaxel("inferium_paxel", ModToolMaterials.INFERIUM, TextFormatting.YELLOW);
//	public static ItemPaxel itemPrudentiumPaxel = new ItemPaxel("prudentium_paxel", ModToolMaterials.PRUDENTIUM, TextFormatting.GREEN);
//	public static ItemPaxel itemIntermediumPaxel = new ItemPaxel("intermedium_paxel", ModToolMaterials.INTERMEDIUM, TextFormatting.GOLD);
//	public static ItemPaxel itemSuperiumPaxel = new ItemPaxel("superium_paxel", ModToolMaterials.SUPERIUM, TextFormatting.AQUA);
//	public static ItemPaxel itemSupremiumPaxel = new ItemPaxel("supremium_paxel", ModToolMaterials.SUPREMIUM, TextFormatting.RED);

	@SubscribeEvent
	public void onRegisterItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();

		ENTRIES.stream().map(Supplier::get).forEach(registry::register);
	}

	public static void init() {
//		final ModRegistry registry = MysticalAgradditions.REGISTRY;
//
//		registry.register(itemInsanium, "insanium", Ore.of(0, "essenceInsanium"), Ore.of(2, "ingotInsanium"), Ore.of(3, "nuggetInsanium"));
//		registry.register(itemStuff, "stuff");
//
//		for (CropType.Type type : CropType.Type.values()) {
//			if (type.isEnabled()) {
//				registry.register(type.getCrop(), type.getName() + "_essence");
//				if (MAHelper.config.confGenericOreDictEssence) {
//					registry.addOre(type.getCrop(), "essenceTier6");
//				}
//			}
//		}
//
//		registry.register(itemTier6InferiumSeeds, "tier6_inferium_seeds");
//
//		for (CropType.Type type : CropType.Type.values()) {
//			if (type.isEnabled()) {
//				registry.register(type.getSeed(), type.getName() + "_seeds");
//				if (MAHelper.config.confGenericOreDictEssence) {
//					registry.addOre(type.getSeed(), "seedsTier6");
//				}
//			}
//		}
//
//		if (MAHelper.config.confGearModuleOverride) {
//			registry.register(itemCharm, "charm");
//
//			registry.register(itemInferiumPaxel, "inferium_paxel", MAHelper.items.itemCrafting.itemInferiumIngot);
//			registry.register(itemPrudentiumPaxel, "prudentium_paxel", MAHelper.items.itemCrafting.itemPrudentiumIngot);
//			registry.register(itemIntermediumPaxel, "intermedium_paxel", MAHelper.items.itemCrafting.itemIntermediumIngot);
//			registry.register(itemSuperiumPaxel, "superium_paxel", MAHelper.items.itemCrafting.itemSuperiumIngot);
//			registry.register(itemSupremiumPaxel, "supremium_paxel", MAHelper.items.itemCrafting.itemSupremiumIngot);
//		}
	}

	private static <T extends Item> RegistryObject<T> register(String name) {
		return register(name, () -> new BaseItem(p -> p.group(ITEM_GROUP)));
	}

	private static <T extends Item> RegistryObject<T> register(String name, Supplier<? extends Item> item) {
		ResourceLocation loc = new ResourceLocation(MysticalAgradditions.MOD_ID, name);
		ENTRIES.add(() -> item.get().setRegistryName(loc));
		return RegistryObject.of(loc, ForgeRegistries.ITEMS);
	}
}
