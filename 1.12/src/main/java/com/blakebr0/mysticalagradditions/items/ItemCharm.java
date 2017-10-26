package com.blakebr0.mysticalagradditions.items;

import com.blakebr0.cucumber.item.ItemMeta;
import com.blakebr0.cucumber.registry.ModRegistry;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;

public class ItemCharm extends ItemMeta {

	public ItemCharm() {
		super("ma.charm", MysticalAgradditions.REGISTRY);
		this.setCreativeTab(MysticalAgradditions.tabMysticalAgradditions);
	}

	@Override
	public void init() {
		addItem(0, "mining_aoe");
	}
}
