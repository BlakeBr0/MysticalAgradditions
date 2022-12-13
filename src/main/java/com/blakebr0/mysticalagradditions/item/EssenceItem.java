package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.BaseItem;
import com.blakebr0.mysticalagradditions.config.ModFeatureFlags;
import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import com.blakebr0.mysticalagriculture.api.crop.ICropTierProvider;
import com.blakebr0.mysticalagriculture.api.farmland.FarmlandConverter;
import com.blakebr0.mysticalagriculture.api.farmland.IFarmlandConverter;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

public class EssenceItem extends BaseItem implements IFarmlandConverter, ICropTierProvider {
    private final CropTier tier;

    public EssenceItem(CropTier tier) {
        super();
        this.tier = tier;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!ModFeatureFlags.ESSENCE_FARMLAND_CONVERSION.isEnabled())
            return InteractionResult.PASS;

        return FarmlandConverter.convert(this, context);
    }

    @Override
    public Block getConvertedFarmland() {
        return this.tier.getFarmland();
    }

    @Override
    public CropTier getTier() {
        return this.tier;
    }
}
