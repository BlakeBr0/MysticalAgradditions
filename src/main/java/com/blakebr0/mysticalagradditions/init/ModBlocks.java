package com.blakebr0.mysticalagradditions.init;

import com.blakebr0.cucumber.block.BaseBlock;
import com.blakebr0.cucumber.block.BaseOreBlock;
import com.blakebr0.cucumber.item.BaseBlockItem;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.block.InfusedFarmlandBlock;
import com.blakebr0.mysticalagradditions.item.EssenceCoalBlockItem;
import com.blakebr0.mysticalagradditions.lib.ModCorePlugin;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.blakebr0.mysticalagradditions.MysticalAgradditions.ITEM_GROUP;

public final class ModBlocks {
	public static final Map<RegistryObject<Block>, Supplier<Block>> ENTRIES = new LinkedHashMap<>();

	public static final RegistryObject<Block> INSANIUM_BLOCK = register("insanium_block", () -> new BaseBlock(Material.ROCK, SoundType.STONE, 4.0F, 6.0F));
	public static final RegistryObject<Block> INSANIUM_INGOT_BLOCK = register("insanium_ingot_block", () -> new BaseBlock(Material.IRON, SoundType.METAL, 5.0F, 6.0F));
	public static final RegistryObject<Block> INSANIUM_GEMSTONE_BLOCK = register("insanium_gemstone_block", () -> new BaseBlock(Material.IRON, SoundType.METAL, 5.0F, 6.0F));
	public static final RegistryObject<Block> INSANIUM_FARMLAND = register("insanium_farmland", () -> new InfusedFarmlandBlock(ModCorePlugin.CROP_TIER_6));
	public static final RegistryObject<Block> INFERIUM_COAL_BLOCK = register("inferium_coal_block", () -> new BaseBlock(Material.ROCK, SoundType.STONE, 5.0F, 6.0F), block -> () -> new EssenceCoalBlockItem(block.get(), 21600, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Block> PRUDENTIUM_COAL_BLOCK = register("prudentium_coal_block", () -> new BaseBlock(Material.ROCK, SoundType.STONE, 5.0F, 6.0F), block -> () -> new EssenceCoalBlockItem(block.get(), 43200, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Block> TERTIUM_COAL_BLOCK = register("tertium_coal_block", () -> new BaseBlock(Material.ROCK, SoundType.STONE, 5.0F, 6.0F), block -> () -> new EssenceCoalBlockItem(block.get(), 86400, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Block> IMPERIUM_COAL_BLOCK = register("imperium_coal_block", () -> new BaseBlock(Material.ROCK, SoundType.STONE, 5.0F, 6.0F), block -> () -> new EssenceCoalBlockItem(block.get(), 172800, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Block> SUPREMIUM_COAL_BLOCK = register("supremium_coal_block", () -> new BaseBlock(Material.ROCK, SoundType.STONE, 5.0F, 6.0F), block -> () -> new EssenceCoalBlockItem(block.get(), 345600, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Block> INSANIUM_COAL_BLOCK = register("insanium_coal_block", () -> new BaseBlock(Material.ROCK, SoundType.STONE, 5.0F, 6.0F), block -> () -> new EssenceCoalBlockItem(block.get(), 691200, p -> p.group(ITEM_GROUP)));
	public static final RegistryObject<Block> NETHER_PROSPERITY_ORE = register("nether_prosperity_ore", () -> new BaseOreBlock(Material.ROCK, SoundType.STONE, 3.0F, 3.0F, 2, 5));
	public static final RegistryObject<Block> NETHER_INFERIUM_ORE = register("nether_inferium_ore", () -> new BaseOreBlock(Material.ROCK, SoundType.STONE, 3.0F, 3.0F, 2, 5));
	public static final RegistryObject<Block> END_PROSPERITY_ORE = register("end_prosperity_ore", () -> new BaseOreBlock(Material.ROCK, SoundType.STONE, 3.0F, 3.0F, 2, 5));
	public static final RegistryObject<Block> END_INFERIUM_ORE = register("end_inferium_ore", () -> new BaseOreBlock(Material.ROCK, SoundType.STONE, 3.0F, 3.0F, 2, 5));
	public static final RegistryObject<Block> NETHER_STAR_CRUX = register("nether_star_crux", () -> new BaseBlock(Material.ROCK, SoundType.STONE, 5.0F, 10.0F));
	public static final RegistryObject<Block> DRAGON_EGG_CRUX = register("dragon_egg_crux", () -> new BaseBlock(Material.ROCK, SoundType.STONE, 5.0F, 10.0F));
	public static final RegistryObject<Block> NITRO_CRYSTAL_CRUX = register("nitro_crystal_crux", () -> new BaseBlock(Material.ROCK, SoundType.STONE, 5.0F, 10.0F));

	public static final RegistryObject<Block> MOLTEN_INFERIUM = registerNoItem("molten_inferium", () -> new FlowingFluidBlock(ModFluids.MOLTEN_INFERIUM, AbstractBlock.Properties.from(Blocks.LAVA)));
	public static final RegistryObject<Block> MOLTEN_PRUDENTIUM = registerNoItem("molten_prudentium", () -> new FlowingFluidBlock(ModFluids.MOLTEN_PRUDENTIUM, AbstractBlock.Properties.from(Blocks.LAVA)));
	public static final RegistryObject<Block> MOLTEN_TERTIUM = registerNoItem("molten_tertium", () -> new FlowingFluidBlock(ModFluids.MOLTEN_TERTIUM, AbstractBlock.Properties.from(Blocks.LAVA)));
	public static final RegistryObject<Block> MOLTEN_IMPERIUM = registerNoItem("molten_imperium", () -> new FlowingFluidBlock(ModFluids.MOLTEN_IMPERIUM, AbstractBlock.Properties.from(Blocks.LAVA)));
	public static final RegistryObject<Block> MOLTEN_SUPREMIUM = registerNoItem("molten_supremium", () -> new FlowingFluidBlock(ModFluids.MOLTEN_SUPREMIUM, AbstractBlock.Properties.from(Blocks.LAVA)));
	public static final RegistryObject<Block> MOLTEN_SOULIUM = registerNoItem("molten_soulium", () -> new FlowingFluidBlock(ModFluids.MOLTEN_SOULIUM, AbstractBlock.Properties.from(Blocks.LAVA)));

	@SubscribeEvent
	public void onRegisterBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();

		ENTRIES.forEach((reg, block) -> {
			registry.register(block.get());
			reg.updateReference(registry);
		});
	}

	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return register(name, block, b -> () -> new BaseBlockItem(b.get(), p -> p.group(ITEM_GROUP)));
	}

	private static RegistryObject<Block> register(String name, Supplier<Block> block, Function<RegistryObject<Block>, Supplier<? extends BlockItem>> item) {
		ResourceLocation loc = new ResourceLocation(MysticalAgradditions.MOD_ID, name);
		RegistryObject<Block> reg = RegistryObject.of(loc, ForgeRegistries.BLOCKS);
		ENTRIES.put(reg, () -> block.get().setRegistryName(loc));
		ModItems.BLOCK_ENTRIES.add(() -> item.apply(reg).get().setRegistryName(loc));
		return reg;
	}

	public static RegistryObject<Block> registerNoItem(String name, Supplier<Block> block) {
		ResourceLocation loc = new ResourceLocation(MysticalAgradditions.MOD_ID, name);
		RegistryObject<Block> reg = RegistryObject.of(loc, ForgeRegistries.BLOCKS);
		ENTRIES.put(reg, () -> block.get().setRegistryName(loc));
		return reg;
	}
}
