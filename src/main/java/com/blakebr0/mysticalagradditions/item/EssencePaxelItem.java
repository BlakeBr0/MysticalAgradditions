package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.cucumber.item.tool.BasePaxelItem;
import com.blakebr0.mysticalagradditions.lib.ModTooltips;
import com.blakebr0.mysticalagriculture.api.MysticalAgricultureDataComponentTypes;
import com.blakebr0.mysticalagriculture.api.tinkering.AugmentType;
import com.blakebr0.mysticalagriculture.api.tinkering.ITinkerable;
import com.blakebr0.mysticalagriculture.api.util.AugmentUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.function.Consumer;

public class EssencePaxelItem extends BasePaxelItem implements ITinkerable {
    private static final EnumSet<AugmentType> TYPES = EnumSet.of(AugmentType.TOOL, AugmentType.PICKAXE, AugmentType.SHOVEL, AugmentType.AXE);
    private final int tinkerableTier;
    private final int slots;

    public EssencePaxelItem(Identifier id, ToolMaterial material, int tinkerableTier, int slots) {
        super(id, material, p -> {
            p.component(MysticalAgricultureDataComponentTypes.EQUIPPED_AUGMENTS, new ArrayList<>());

            if (material.durability() == 0) {
                p.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);
            }

            return p;
        });
        this.tinkerableTier = tinkerableTier;
        this.slots = slots;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        var stack = context.getItemInHand();
        var augments = AugmentUtils.getAugments(stack);
        var success = false;

        for (var augment : augments) {
            if (augment.onItemUse(context))
                success = true;
        }

        if (success)
            return InteractionResult.SUCCESS;

        return super.useOn(context);
    }

    @Override
    public InteractionResult use(Level world, Player player, InteractionHand hand) {
        var stack = player.getItemInHand(hand);
        var augments = AugmentUtils.getAugments(stack);
        var success = false;

        for (var augment : augments) {
            if (augment.onRightClick(stack, world, player, hand))
                success = true;
        }

        if (success)
            return InteractionResult.SUCCESS;

        return InteractionResult.PASS;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        var augments = AugmentUtils.getAugments(stack);
        var success = false;

        for (var augment : augments) {
            if (augment.onRightClickEntity(stack, player, target, hand))
                success = true;
        }

        return success ? InteractionResult.SUCCESS : InteractionResult.PASS;
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        var augments = AugmentUtils.getAugments(stack);

        for (var augment : augments) {
            augment.onHitEntity(stack, target, attacker);
        }
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        super.mineBlock(stack, world, state, pos, entity);

        var augments = AugmentUtils.getAugments(stack);
        var success = false;

        for (var augment : augments) {
            if (augment.onBlockDestroyed(stack, world, state, pos, entity))
                success = true;
        }

        return success;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        var augments = AugmentUtils.getAugments(stack);

        for (var augment : augments) {
            augment.onInventoryTick(stack, level, entity, slot);
        }
    }

    // TODO make tooltip in MA work on this?
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(ModTooltips.getTooltipForTier(this.tinkerableTier));

        for (var augment : AugmentUtils.getAugments(stack)) {
            builder.accept(augment.getDisplayName());
        }
    }

    @Override
    public int getAugmentSlots() {
        return this.slots;
    }

    @Override
    public EnumSet<AugmentType> getAugmentTypes() {
        return TYPES;
    }

    @Override
    public int getTinkerableTier() {
        return this.tinkerableTier;
    }
}
