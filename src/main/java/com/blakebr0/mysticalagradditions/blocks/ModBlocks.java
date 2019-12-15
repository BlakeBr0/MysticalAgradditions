package com.blakebr0.mysticalagradditions.blocks;

import com.blakebr0.cucumber.block.BaseBlock;
import com.blakebr0.cucumber.item.BaseBlockItem;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.blakebr0.mysticalagradditions.MysticalAgradditions.ITEM_GROUP;

public class ModBlocks {
	public static final List<Supplier<? extends Block>> ENTRIES = new ArrayList<>();

	public static final RegistryObject<BaseBlock> INSANIUM_BLOCK = register("insanium_block", () -> new BaseBlock(Material.ROCK, SoundType.STONE, 4.0F, 6.0F));
	public static final RegistryObject<BaseBlock> INSANIUM_INGOT_BLOCK = register("insanium_ingot_block", () -> new BaseBlock(Material.IRON, SoundType.METAL, 5.0F, 6.0F));
	public static final RegistryObject<BaseBlock> INSANIUM_GEMSTONE_BLOCK = register("insanium_gemstone_block", () -> new BaseBlock(Material.IRON, SoundType.METAL, 5.0F, 6.0F));

	@SubscribeEvent
	public void onRegisterBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();

		ENTRIES.stream().map(Supplier::get).forEach(registry::register);
	}

	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
		return register(name, block, b -> () -> new BaseBlockItem(b.get(), p -> p.group(ITEM_GROUP)));
	}

	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Function<RegistryObject<T>, Supplier<? extends BlockItem>> item) {
		ResourceLocation loc = new ResourceLocation(MysticalAgradditions.MOD_ID, name);
		ENTRIES.add(() -> block.get().setRegistryName(loc));
		RegistryObject<T> reg = RegistryObject.of(loc, ForgeRegistries.BLOCKS);
		ModItems.ENTRIES.add(() -> item.apply(reg).get().setRegistryName(loc));
		return reg;
	}
}
