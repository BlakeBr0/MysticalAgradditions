package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseItem;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
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
	public static final List<Supplier<? extends Item>> BLOCK_ENTRIES = new ArrayList<>();
	public static final List<Supplier<? extends Item>> ENTRIES = new ArrayList<>();

	public static final RegistryObject<BaseItem> INSANIUM_ESSENCE = register("insanium_essence");
	public static final RegistryObject<BaseItem> INSANIUM_INGOT = register("insanium_ingot");
	public static final RegistryObject<BaseItem> INSANIUM_NUGGET = register("insanium_nugget");
	public static final RegistryObject<BaseItem> INSANIUM_GEMSTONE = register("insanium_gemstone");
	public static final RegistryObject<BaseItem> NETHER_STAR_SHARD = register("nether_star_shard");
	public static final RegistryObject<BaseItem> WITHERING_SOUL = register("withering_soul", () -> new WitheringSoulItem(p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<BaseItem> DRAGON_EGG_CHUNK = register("dragon_egg_chunk");
	public static final RegistryObject<BaseItem> DRAGON_SCALE = register("dragon_scale");
	public static final RegistryObject<CreativeEssenceItem> CREATIVE_ESSENCE = register("creative_essence", () -> new CreativeEssenceItem(p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<BaseItem> INFERIUM_COAL = register("inferium_coal", () -> new EssenceCoalItem(2400, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<BaseItem> PRUDENTIUM_COAL = register("prudentium_coal", () -> new EssenceCoalItem(4800, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<BaseItem> TERTIUM_COAL = register("tertium_coal", () -> new EssenceCoalItem(9600, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<BaseItem> IMPERIUM_COAL = register("imperium_coal", () -> new EssenceCoalItem(19200, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<BaseItem> SUPREMIUM_COAL = register("supremium_coal", () -> new EssenceCoalItem(38400, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<BaseItem> INSANIUM_COAL = register("insanium_coal", () -> new EssenceCoalItem(76800, p -> p.group(ITEM_GROUP)));

	public static final RegistryObject<EssencePaxelItem> INFERIUM_PAXEL = register("inferium_paxel", () -> new EssencePaxelItem(ItemTier.DIAMOND, 1, 1, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<EssencePaxelItem> PRUDENTIUM_PAXEL = register("prudentium_paxel", () -> new EssencePaxelItem(ItemTier.DIAMOND, 2, 1, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<EssencePaxelItem> TERTIUM_PAXEL = register("tertium_paxel", () -> new EssencePaxelItem(ItemTier.DIAMOND, 3, 1, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<EssencePaxelItem> IMPERIUM_PAXEL = register("imperium_paxel", () -> new EssencePaxelItem(ItemTier.DIAMOND, 4, 1, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<EssencePaxelItem> SUPREMIUM_PAXEL = register("supremium_paxel", () -> new EssencePaxelItem(ItemTier.DIAMOND, 5, 1, p -> p.group(ITEM_GROUP)));

	@SubscribeEvent
	public void onRegisterItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();

		BLOCK_ENTRIES.stream().map(Supplier::get).forEach(registry::register);
		ENTRIES.stream().map(Supplier::get).forEach(registry::register);
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
