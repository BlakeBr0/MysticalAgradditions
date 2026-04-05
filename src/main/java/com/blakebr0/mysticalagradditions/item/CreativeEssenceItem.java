package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseShinyItem;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Rarity;

public class CreativeEssenceItem extends BaseShinyItem {
    public CreativeEssenceItem(Identifier id) {
        super(id, p -> p.rarity(Rarity.EPIC));
    }
}
