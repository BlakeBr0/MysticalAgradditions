package com.blakebr0.mysticalagradditions.init;

import com.blakebr0.cucumber.block.BaseBlock;
import com.blakebr0.cucumber.block.BaseOreBlock;
import com.blakebr0.cucumber.item.BaseBlockItem;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.block.InfusedFarmlandBlock;
import com.blakebr0.mysticalagradditions.item.EssenceCoalBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public final class ModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MysticalAgradditions.MOD_ID);
	public static final Map<String, Supplier<BlockItem>> BLOCK_ITEMS = new LinkedHashMap<>();

	public static final RegistryObject<Block> INSANIUM_BLOCK = register("insanium_block", () -> new BaseBlock(SoundType.STONE, 4.0F, 6.0F));
	public static final RegistryObject<Block> INSANIUM_INGOT_BLOCK = register("insanium_ingot_block", () -> new BaseBlock(SoundType.METAL, 5.0F, 6.0F));
	public static final RegistryObject<Block> INSANIUM_GEMSTONE_BLOCK = register("insanium_gemstone_block", () -> new BaseBlock(SoundType.METAL, 5.0F, 6.0F));
	public static final RegistryObject<Block> INSANIUM_FARMLAND = register("insanium_farmland", () -> new InfusedFarmlandBlock(ModCropTiers.SIX));
	public static final RegistryObject<Block> INFERIUM_COAL_BLOCK = register("inferium_coal_block", () -> new BaseBlock(SoundType.STONE, 5.0F, 6.0F), block -> () -> new EssenceCoalBlockItem(block.get(), 21600));
	public static final RegistryObject<Block> PRUDENTIUM_COAL_BLOCK = register("prudentium_coal_block", () -> new BaseBlock(SoundType.STONE, 5.0F, 6.0F), block -> () -> new EssenceCoalBlockItem(block.get(), 43200));
	public static final RegistryObject<Block> TERTIUM_COAL_BLOCK = register("tertium_coal_block", () -> new BaseBlock(SoundType.STONE, 5.0F, 6.0F), block -> () -> new EssenceCoalBlockItem(block.get(), 86400));
	public static final RegistryObject<Block> IMPERIUM_COAL_BLOCK = register("imperium_coal_block", () -> new BaseBlock(SoundType.STONE, 5.0F, 6.0F), block -> () -> new EssenceCoalBlockItem(block.get(), 172800));
	public static final RegistryObject<Block> SUPREMIUM_COAL_BLOCK = register("supremium_coal_block", () -> new BaseBlock(SoundType.STONE, 5.0F, 6.0F), block -> () -> new EssenceCoalBlockItem(block.get(), 345600));
	public static final RegistryObject<Block> INSANIUM_COAL_BLOCK = register("insanium_coal_block", () -> new BaseBlock(SoundType.STONE, 5.0F, 6.0F), block -> () -> new EssenceCoalBlockItem(block.get(), 691200));
	public static final RegistryObject<Block> NETHER_PROSPERITY_ORE = register("nether_prosperity_ore", () -> new BaseOreBlock(SoundType.STONE, 3.0F, 3.0F, 2, 5));
	public static final RegistryObject<Block> NETHER_INFERIUM_ORE = register("nether_inferium_ore", () -> new BaseOreBlock(SoundType.STONE, 3.0F, 3.0F, 2, 5));
	public static final RegistryObject<Block> END_PROSPERITY_ORE = register("end_prosperity_ore", () -> new BaseOreBlock(SoundType.STONE, 3.0F, 3.0F, 2, 5));
	public static final RegistryObject<Block> END_INFERIUM_ORE = register("end_inferium_ore", () -> new BaseOreBlock(SoundType.STONE, 3.0F, 3.0F, 2, 5));
	public static final RegistryObject<Block> NETHER_STAR_CRUX = register("nether_star_crux", () -> new BaseBlock(SoundType.STONE, 5.0F, 10.0F));
	public static final RegistryObject<Block> DRAGON_EGG_CRUX = register("dragon_egg_crux", () -> new BaseBlock(SoundType.STONE, 5.0F, 10.0F));
	public static final RegistryObject<Block> GAIA_SPIRIT_CRUX = register("gaia_spirit_crux", () -> new BaseBlock(SoundType.STONE, 5.0F, 10.0F));
	public static final RegistryObject<Block> AWAKENED_DRACONIUM_CRUX = register("awakened_draconium_crux", () -> new BaseBlock(SoundType.STONE, 5.0F, 10.0F));
	public static final RegistryObject<Block> NEUTRONIUM_CRUX = register("neutronium_crux", () -> new BaseBlock(SoundType.STONE, 5.0F, 10.0F));
	public static final RegistryObject<Block> NITRO_CRYSTAL_CRUX = register("nitro_crystal_crux", () -> new BaseBlock(SoundType.STONE, 5.0F, 10.0F));

	public static final RegistryObject<Block> MOLTEN_INFERIUM = registerNoItem("molten_inferium", () -> new LiquidBlock(() -> (FlowingFluid) ModFluids.MOLTEN_INFERIUM.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
	public static final RegistryObject<Block> MOLTEN_PRUDENTIUM = registerNoItem("molten_prudentium", () -> new LiquidBlock(() -> (FlowingFluid) ModFluids.MOLTEN_PRUDENTIUM.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
	public static final RegistryObject<Block> MOLTEN_TERTIUM = registerNoItem("molten_tertium", () -> new LiquidBlock(() -> (FlowingFluid) ModFluids.MOLTEN_TERTIUM.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
	public static final RegistryObject<Block> MOLTEN_IMPERIUM = registerNoItem("molten_imperium", () -> new LiquidBlock(() -> (FlowingFluid) ModFluids.MOLTEN_IMPERIUM.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
	public static final RegistryObject<Block> MOLTEN_SUPREMIUM = registerNoItem("molten_supremium", () -> new LiquidBlock(() -> (FlowingFluid) ModFluids.MOLTEN_SUPREMIUM.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
	public static final RegistryObject<Block> MOLTEN_SOULIUM = registerNoItem("molten_soulium", () -> new LiquidBlock(() -> (FlowingFluid) ModFluids.MOLTEN_SOULIUM.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));

	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return register(name, block, b -> () -> new BaseBlockItem(b.get()));
	}

	private static RegistryObject<Block> register(String name, Supplier<Block> block, Function<RegistryObject<Block>, Supplier<? extends BlockItem>> item) {
		var reg = REGISTRY.register(name, block);
		BLOCK_ITEMS.put(name, () -> item.apply(reg).get());
		return reg;
	}

	private static RegistryObject<Block> registerNoItem(String name, Supplier<Block> block) {
		return REGISTRY.register(name, block);
	}
}
