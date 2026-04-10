package com.blakebr0.mysticalagradditions.init;

import com.blakebr0.cucumber.item.BaseBucketItem;
import com.blakebr0.cucumber.item.BaseItem;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.item.CreativeEssenceItem;
import com.blakebr0.mysticalagradditions.item.EssenceAppleItem;
import com.blakebr0.mysticalagradditions.item.EssenceCoalItem;
import com.blakebr0.mysticalagradditions.item.EssenceItem;
import com.blakebr0.mysticalagradditions.item.EssencePaxelItem;
import com.blakebr0.mysticalagradditions.item.WitheringSoulItem;
import com.blakebr0.mysticalagradditions.lib.ModCropTiers;
import com.blakebr0.mysticalagradditions.util.EssenceAppleTier;
import com.blakebr0.mysticalagriculture.api.MysticalAgricultureToolMaterials;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(Registries.ITEM, MysticalAgradditions.MOD_ID);

	// register block items here for class load order purposes
	static {
		ModBlocks.BLOCK_ITEMS.forEach(REGISTRY::register);
	}

	public static final DeferredHolder<Item, Item> INSANIUM_ESSENCE = REGISTRY.register("insanium_essence", id -> new EssenceItem(id, ModCropTiers.SIX));
	public static final DeferredHolder<Item, Item> INSANIUM_INGOT = REGISTRY.register("insanium_ingot", BaseItem::new);
	public static final DeferredHolder<Item, Item> INSANIUM_NUGGET = REGISTRY.register("insanium_nugget", BaseItem::new);
	public static final DeferredHolder<Item, Item> INSANIUM_GEMSTONE = REGISTRY.register("insanium_gemstone", BaseItem::new);
	public static final DeferredHolder<Item, Item> NETHER_STAR_SHARD = REGISTRY.register("nether_star_shard", BaseItem::new);
	public static final DeferredHolder<Item, Item> WITHERING_SOUL = REGISTRY.register("withering_soul", WitheringSoulItem::new);
	public static final DeferredHolder<Item, Item> DRAGON_EGG_CHUNK = REGISTRY.register("dragon_egg_chunk", BaseItem::new);
	public static final DeferredHolder<Item, Item> DRAGON_SCALE = REGISTRY.register("dragon_scale", BaseItem::new);
	public static final DeferredHolder<Item, Item> CREATIVE_ESSENCE = REGISTRY.register("creative_essence", CreativeEssenceItem::new);
	public static final DeferredHolder<Item, Item> INFERIUM_COAL = REGISTRY.register("inferium_coal", id -> new EssenceCoalItem(id, 2400));
	public static final DeferredHolder<Item, Item> PRUDENTIUM_COAL = REGISTRY.register("prudentium_coal", id -> new EssenceCoalItem(id, 4800));
	public static final DeferredHolder<Item, Item> TERTIUM_COAL = REGISTRY.register("tertium_coal", id -> new EssenceCoalItem(id, 9600));
	public static final DeferredHolder<Item, Item> IMPERIUM_COAL = REGISTRY.register("imperium_coal", id -> new EssenceCoalItem(id, 19200));
	public static final DeferredHolder<Item, Item> SUPREMIUM_COAL = REGISTRY.register("supremium_coal", id -> new EssenceCoalItem(id, 38400));
	public static final DeferredHolder<Item, Item> INSANIUM_COAL = REGISTRY.register("insanium_coal", id -> new EssenceCoalItem(id, 76800));
	public static final DeferredHolder<Item, Item> INFERIUM_APPLE = REGISTRY.register("inferium_apple", id -> new EssenceAppleItem(id, EssenceAppleTier.INFERIUM));
	public static final DeferredHolder<Item, Item> PRUDENTIUM_APPLE = REGISTRY.register("prudentium_apple", id -> new EssenceAppleItem(id, EssenceAppleTier.PRUDENTIUM));
	public static final DeferredHolder<Item, Item> TERTIUM_APPLE = REGISTRY.register("tertium_apple", id -> new EssenceAppleItem(id, EssenceAppleTier.TERTIUM));
	public static final DeferredHolder<Item, Item> IMPERIUM_APPLE = REGISTRY.register("imperium_apple", id -> new EssenceAppleItem(id, EssenceAppleTier.IMPERIUM));
	public static final DeferredHolder<Item, Item> SUPREMIUM_APPLE = REGISTRY.register("supremium_apple", id -> new EssenceAppleItem(id, EssenceAppleTier.SUPREMIUM));
	public static final DeferredHolder<Item, Item> INSANIUM_APPLE = REGISTRY.register("insanium_apple", id -> new EssenceAppleItem(id, EssenceAppleTier.INSANIUM));

	public static final DeferredHolder<Item, Item> INFERIUM_PAXEL = REGISTRY.register("inferium_paxel", id -> new EssencePaxelItem(id, MysticalAgricultureToolMaterials.INFERIUM, 1, 1));
	public static final DeferredHolder<Item, Item> PRUDENTIUM_PAXEL = REGISTRY.register("prudentium_paxel", id -> new EssencePaxelItem(id, MysticalAgricultureToolMaterials.PRUDENTIUM, 2, 1));
	public static final DeferredHolder<Item, Item> TERTIUM_PAXEL = REGISTRY.register("tertium_paxel", id -> new EssencePaxelItem(id, MysticalAgricultureToolMaterials.TERTIUM, 3, 1));
	public static final DeferredHolder<Item, Item> IMPERIUM_PAXEL = REGISTRY.register("imperium_paxel", id -> new EssencePaxelItem(id, MysticalAgricultureToolMaterials.IMPERIUM, 4, 1));
	public static final DeferredHolder<Item, Item> SUPREMIUM_PAXEL = REGISTRY.register("supremium_paxel", id -> new EssencePaxelItem(id, MysticalAgricultureToolMaterials.SUPREMIUM, 5, 1));
	public static final DeferredHolder<Item, Item> AWAKENED_SUPREMIUM_PAXEL = REGISTRY.register("awakened_supremium_paxel", id -> new EssencePaxelItem(id, MysticalAgricultureToolMaterials.AWAKENED_SUPREMIUM, 5, 2));

	public static final DeferredHolder<Item, Item> MOLTEN_PROSPERITY_BUCKET = REGISTRY.register("molten_prosperity_bucket", id -> new BaseBucketItem(id, ModFluids.MOLTEN_PROSPERITY.get()));
	public static final DeferredHolder<Item, Item> MOLTEN_INFERIUM_BUCKET = REGISTRY.register("molten_inferium_bucket", id -> new BaseBucketItem(id, ModFluids.MOLTEN_INFERIUM.get()));
	public static final DeferredHolder<Item, Item> MOLTEN_PRUDENTIUM_BUCKET = REGISTRY.register("molten_prudentium_bucket", id -> new BaseBucketItem(id, ModFluids.MOLTEN_PRUDENTIUM.get()));
	public static final DeferredHolder<Item, Item> MOLTEN_TERTIUM_BUCKET = REGISTRY.register("molten_tertium_bucket", id -> new BaseBucketItem(id, ModFluids.MOLTEN_TERTIUM.get()));
	public static final DeferredHolder<Item, Item> MOLTEN_IMPERIUM_BUCKET = REGISTRY.register("molten_imperium_bucket", id -> new BaseBucketItem(id, ModFluids.MOLTEN_IMPERIUM.get()));
	public static final DeferredHolder<Item, Item> MOLTEN_SUPREMIUM_BUCKET = REGISTRY.register("molten_supremium_bucket", id -> new BaseBucketItem(id, ModFluids.MOLTEN_SUPREMIUM.get()));
	public static final DeferredHolder<Item, Item> MOLTEN_AWAKENED_SUPREMIUM_BUCKET = REGISTRY.register("molten_awakened_supremium_bucket", id -> new BaseBucketItem(id, ModFluids.MOLTEN_AWAKENED_SUPREMIUM.get()));
	public static final DeferredHolder<Item, Item> MOLTEN_INSANIUM_BUCKET = REGISTRY.register("molten_insanium_bucket", id -> new BaseBucketItem(id, ModFluids.MOLTEN_INSANIUM.get()));
	public static final DeferredHolder<Item, Item> MOLTEN_SOULIUM_BUCKET = REGISTRY.register("molten_soulium_bucket", id -> new BaseBucketItem(id, ModFluids.MOLTEN_SOULIUM.get()));
}
