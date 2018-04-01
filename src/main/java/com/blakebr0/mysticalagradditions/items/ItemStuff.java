package com.blakebr0.mysticalagradditions.items;

import java.util.List;

import com.blakebr0.cucumber.item.ItemMeta;
import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.blocks.BlockSpecial.Type;
import com.blakebr0.mysticalagradditions.config.ModConfig;
import com.blakebr0.mysticalagriculture.lib.Tooltips;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStuff extends ItemMeta {

	public ItemStuff() {
		super("ma.stuff", MysticalAgradditions.REGISTRY);
		this.setCreativeTab(MysticalAgradditions.tabMysticalAgradditions);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void init() {
		addItem(0, "nether_star_shard");
		addItem(1, "withering_soul");
		addItem(2, "dragon_egg_chunk");
		addItem(3, "dragon_scale");
		
		addItem(69, "creative_essence", ModConfig.confCreativeEssence);
	}
    
    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
    	if (stack.getMetadata() == 1) {
        	tooltip.add(Tooltips.DROP_CHANCE + ModConfig.confWitherSouls + "%");
    	} else if (stack.getMetadata() == 69) {
    		tooltip.add(Colors.ITALICS + Utils.localize("tooltip.ma.creative_essence"));
    	}
    }
    
    @Override
    public boolean hasEffect(ItemStack stack) {
    	return stack.getMetadata() == 69 ? true : super.hasEffect(stack);
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
    	return stack.getMetadata() == 69 ? EnumRarity.EPIC : EnumRarity.COMMON;
    }
}
