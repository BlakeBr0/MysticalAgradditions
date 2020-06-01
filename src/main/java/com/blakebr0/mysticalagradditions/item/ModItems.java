package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseItem;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.lib.ModItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static com.blakebr0.mysticalagradditions.MysticalAgradditions.ITEM_GROUP;

public class ModItems {
	public static final List<Supplier<Item>> BLOCK_ENTRIES = new ArrayList<>();
	public static final Map<RegistryObject<Item>, Supplier<Item>> ENTRIES = new LinkedHashMap<>();

	public static final RegistryObject<Item> INSANIUM_ESSENCE = register("insanium_essence");
	public static final RegistryObject<Item> INSANIUM_INGOT = register("insanium_ingot");
	public static final RegistryObject<Item> INSANIUM_NUGGET = register("insanium_nugget");
	public static final RegistryObject<Item> INSANIUM_GEMSTONE = register("insanium_gemstone");
	public static final RegistryObject<Item> NETHER_STAR_SHARD = register("nether_star_shard");
	public static final RegistryObject<Item> WITHERING_SOUL = register("withering_soul", () -> new WitheringSoulItem(p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Item> DRAGON_EGG_CHUNK = register("dragon_egg_chunk");
	public static final RegistryObject<Item> DRAGON_SCALE = register("dragon_scale");
	public static final RegistryObject<Item> CREATIVE_ESSENCE = register("creative_essence", () -> new CreativeEssenceItem(p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Item> INFERIUM_COAL = register("inferium_coal", () -> new EssenceCoalItem(2400, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Item> PRUDENTIUM_COAL = register("prudentium_coal", () -> new EssenceCoalItem(4800, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Item> TERTIUM_COAL = register("tertium_coal", () -> new EssenceCoalItem(9600, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Item> IMPERIUM_COAL = register("imperium_coal", () -> new EssenceCoalItem(19200, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Item> SUPREMIUM_COAL = register("supremium_coal", () -> new EssenceCoalItem(38400, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Item> INSANIUM_COAL = register("insanium_coal", () -> new EssenceCoalItem(76800, p -> p.group(ITEM_GROUP)));

	public static final RegistryObject<Item> INFERIUM_PAXEL = register("inferium_paxel", () -> new EssencePaxelItem(ModItemTier.INFERIUM, 1, 1, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Item> PRUDENTIUM_PAXEL = register("prudentium_paxel", () -> new EssencePaxelItem(ModItemTier.PRUDENTIUM, 2, 1, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Item> TERTIUM_PAXEL = register("tertium_paxel", () -> new EssencePaxelItem(ModItemTier.TERTIUM, 3, 1, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Item> IMPERIUM_PAXEL = register("imperium_paxel", () -> new EssencePaxelItem(ModItemTier.IMPERIUM, 4, 1, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Item> SUPREMIUM_PAXEL = register("supremium_paxel", () -> new EssencePaxelItem(ModItemTier.SUPREMIUM, 5, 1, p -> p.group(ITEM_GROUP)));

	@SubscribeEvent
	public void onRegisterItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();

		BLOCK_ENTRIES.stream().map(Supplier::get).forEach(registry::register);
		ENTRIES.forEach((reg, item) -> {
			registry.register(item.get());
			reg.updateReference(registry);
		});
	}

	private static RegistryObject<Item> register(String name) {
		return register(name, () -> new BaseItem(p -> p.group(ITEM_GROUP)));
	}

	private static RegistryObject<Item> register(String name, Supplier<Item> item) {
		ResourceLocation loc = new ResourceLocation(MysticalAgradditions.MOD_ID, name);
		RegistryObject<Item> reg = RegistryObject.of(loc, ForgeRegistries.ITEMS);
		ENTRIES.put(reg, () -> item.get().setRegistryName(loc));
		return reg;
	}
}
