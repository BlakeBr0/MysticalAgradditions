package com.blakebr0.mysticalagradditions.items;

import java.util.List;

import com.blakebr0.cucumber.item.ItemMeta;
import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.cucumber.registry.ModRegistry;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagriculture.lib.Tooltips;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCharm extends ItemMeta {

	public ItemCharm() {
		super("ma.charm", MysticalAgradditions.REGISTRY);
		this.setCreativeTab(MysticalAgradditions.tabMysticalAgradditions);
	}

	@Override
	public void init() {
		addItem(0, "mining_aoe");
	}
	
	@Override // TODO: set this up better?
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
		if(Utils.isShiftKeyDown()){
			tooltip.add(Tooltips.DESCRIPTION);
			tooltip.add(Utils.localize("desc.ma.charm_mining_aoe"));
			tooltip.add("");
			tooltip.add(Tooltips.APPLICABLE_TO);
			tooltip.add(" - " + Colors.RED + Utils.localize("tooltip.ma.paxel"));
		} else {
			tooltip.add(Tooltips.HOLD_SHIFT_FOR_INFO);
		}
	}
}
