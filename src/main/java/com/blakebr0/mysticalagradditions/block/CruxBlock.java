package com.blakebr0.mysticalagradditions.block;

import com.blakebr0.cucumber.block.BaseBlock;
import com.blakebr0.cucumber.iface.IEnableable;
import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagriculture.api.crop.Crop;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class CruxBlock extends BaseBlock implements IEnableable {
    private final Crop crop;

    public CruxBlock(Crop crop) {
        super(Material.STONE, SoundType.STONE, 5.0F, 10.0F);
        this.crop = crop;
    }

    @Override
    public boolean isEnabled() {
        return !ModConfigs.HIDE_UNUSED_CRUXES.get() || this.crop.isEnabled();
    }
}
