package com.blakebr0.mysticalagradditions.init;

import com.blakebr0.cucumber.item.BaseItem;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.item.CreativeEssenceItem;
import com.blakebr0.mysticalagradditions.item.EssenceAppleItem;
import com.blakebr0.mysticalagradditions.item.EssenceCoalItem;
import com.blakebr0.mysticalagradditions.item.EssenceItem;
import com.blakebr0.mysticalagradditions.item.EssencePaxelItem;
import com.blakebr0.mysticalagradditions.item.WitheringSoulItem;
import com.blakebr0.mysticalagradditions.lib.ModCorePlugin;
import com.blakebr0.mysticalagradditions.lib.ModItemTier;
import com.blakebr0.mysticalagradditions.util.EssenceAppleTier;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public final class ModItems {
	private static final Item.Properties BUCKET_PROPERTIES = new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1);

	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MysticalAgradditions.MOD_ID);

	// register block items here for class load order purposes
	static {
		ModBlocks.BLOCK_ITEMS.forEach(REGISTRY::register);
	}

	public static final RegistryObject<Item> INSANIUM_ESSENCE = register("insanium_essence", () -> new EssenceItem(ModCorePlugin.CROP_TIER_6));
	public static final RegistryObject<Item> INSANIUM_INGOT = register("insanium_ingot");
	public static final RegistryObject<Item> INSANIUM_NUGGET = register("insanium_nugget");
	public static final RegistryObject<Item> INSANIUM_GEMSTONE = register("insanium_gemstone");
	public static final RegistryObject<Item> NETHER_STAR_SHARD = register("nether_star_shard");
	public static final RegistryObject<Item> WITHERING_SOUL = register("withering_soul", WitheringSoulItem::new);
	public static final RegistryObject<Item> DRAGON_EGG_CHUNK = register("dragon_egg_chunk");
	public static final RegistryObject<Item> DRAGON_SCALE = register("dragon_scale");
	public static final RegistryObject<Item> CREATIVE_ESSENCE = register("creative_essence", CreativeEssenceItem::new);
	public static final RegistryObject<Item> INFERIUM_COAL = register("inferium_coal", () -> new EssenceCoalItem(2400));
	public static final RegistryObject<Item> PRUDENTIUM_COAL = register("prudentium_coal", () -> new EssenceCoalItem(4800));
	public static final RegistryObject<Item> TERTIUM_COAL = register("tertium_coal", () -> new EssenceCoalItem(9600));
	public static final RegistryObject<Item> IMPERIUM_COAL = register("imperium_coal", () -> new EssenceCoalItem(19200));
	public static final RegistryObject<Item> SUPREMIUM_COAL = register("supremium_coal", () -> new EssenceCoalItem(38400));
	public static final RegistryObject<Item> INSANIUM_COAL = register("insanium_coal", () -> new EssenceCoalItem(76800));
	public static final RegistryObject<Item> INFERIUM_APPLE = register("inferium_apple", () -> new EssenceAppleItem(EssenceAppleTier.INFERIUM));
	public static final RegistryObject<Item> PRUDENTIUM_APPLE = register("prudentium_apple", () -> new EssenceAppleItem(EssenceAppleTier.PRUDENTIUM));
	public static final RegistryObject<Item> TERTIUM_APPLE = register("tertium_apple", () -> new EssenceAppleItem(EssenceAppleTier.TERTIUM));
	public static final RegistryObject<Item> IMPERIUM_APPLE = register("imperium_apple", () -> new EssenceAppleItem(EssenceAppleTier.IMPERIUM));
	public static final RegistryObject<Item> SUPREMIUM_APPLE = register("supremium_apple", () -> new EssenceAppleItem(EssenceAppleTier.SUPREMIUM));
	public static final RegistryObject<Item> INSANIUM_APPLE = register("insanium_apple", () -> new EssenceAppleItem(EssenceAppleTier.INSANIUM));

	public static final RegistryObject<Item> INFERIUM_PAXEL = register("inferium_paxel", () -> new EssencePaxelItem(ModItemTier.INFERIUM, 1, 1));
	public static final RegistryObject<Item> PRUDENTIUM_PAXEL = register("prudentium_paxel", () -> new EssencePaxelItem(ModItemTier.PRUDENTIUM, 2, 1));
	public static final RegistryObject<Item> TERTIUM_PAXEL = register("tertium_paxel", () -> new EssencePaxelItem(ModItemTier.TERTIUM, 3, 1));
	public static final RegistryObject<Item> IMPERIUM_PAXEL = register("imperium_paxel", () -> new EssencePaxelItem(ModItemTier.IMPERIUM, 4, 1));
	public static final RegistryObject<Item> SUPREMIUM_PAXEL = register("supremium_paxel", () -> new EssencePaxelItem(ModItemTier.SUPREMIUM, 5, 1));
	public static final RegistryObject<Item> AWAKENED_SUPREMIUM_PAXEL = register("awakened_supremium_paxel", () -> new EssencePaxelItem(ModItemTier.AWAKENED_SUPREMIUM, 5, 2));

	public static final RegistryObject<Item> MOLTEN_INFERIUM_BUCKET = register("molten_inferium_bucket", () -> new BucketItem(ModFluids.MOLTEN_INFERIUM, BUCKET_PROPERTIES));
	public static final RegistryObject<Item> MOLTEN_PRUDENTIUM_BUCKET = register("molten_prudentium_bucket", () -> new BucketItem(ModFluids.MOLTEN_PRUDENTIUM, BUCKET_PROPERTIES));
	public static final RegistryObject<Item> MOLTEN_TERTIUM_BUCKET = register("molten_tertium_bucket", () -> new BucketItem(ModFluids.MOLTEN_TERTIUM, BUCKET_PROPERTIES));
	public static final RegistryObject<Item> MOLTEN_IMPERIUM_BUCKET = register("molten_imperium_bucket", () -> new BucketItem(ModFluids.MOLTEN_IMPERIUM, BUCKET_PROPERTIES));
	public static final RegistryObject<Item> MOLTEN_SUPREMIUM_BUCKET = register("molten_supremium_bucket", () -> new BucketItem(ModFluids.MOLTEN_SUPREMIUM, BUCKET_PROPERTIES));
	public static final RegistryObject<Item> MOLTEN_SOULIUM_BUCKET = register("molten_soulium_bucket", () -> new BucketItem(ModFluids.MOLTEN_SOULIUM, BUCKET_PROPERTIES));

	private static RegistryObject<Item> register(String name) {
		return register(name, BaseItem::new);
	}

	private static RegistryObject<Item> register(String name, Supplier<Item> item) {
		return REGISTRY.register(name, item);
	}
}
