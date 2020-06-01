package com.blakebr0.mysticalagradditions.item;

import com.blakebr0.mysticalagradditions.lib.ModTooltips;
import com.blakebr0.mysticalagriculture.api.tinkering.AugmentType;
import com.blakebr0.mysticalagriculture.api.tinkering.IAugment;
import com.blakebr0.mysticalagriculture.api.tinkering.ITinkerable;
import com.blakebr0.mysticalagriculture.api.util.AugmentUtils;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class EssencePaxelItem extends ToolItem implements ITinkerable {
    private static final Map<Block, BlockState> PATH_STUFF = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.GRASS_PATH.getDefaultState()));
    private static final EnumSet<AugmentType> TYPES = EnumSet.of(AugmentType.TOOL, AugmentType.PICKAXE, AugmentType.SHOVEL, AugmentType.AXE);
    private final int tinkerableTier;
    private final int slots;

    public EssencePaxelItem(IItemTier tier, int tinkerableTier, int slots, Function<Properties, Properties> properties) {
        super(4.0F, -3.2F, tier, new HashSet<>(), properties.apply(new Properties()
                .defaultMaxDamage((int) (tier.getMaxUses() * 1.5))
                .addToolType(ToolType.PICKAXE, tier.getHarvestLevel())
                .addToolType(ToolType.SHOVEL, tier.getHarvestLevel())
                .addToolType(ToolType.AXE, tier.getHarvestLevel())
        ));

        this.tinkerableTier = tinkerableTier;
        this.slots = slots;
    }

    @Override
    public boolean canHarvestBlock(BlockState state) {
        Block block = state.getBlock();
        int i = this.getTier().getHarvestLevel();
        if (state.getHarvestTool() == ToolType.PICKAXE)
            return i >= state.getHarvestLevel();

        Material material = state.getMaterial();
        return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL
                || block == Blocks.SNOW || block == Blocks.SNOW_BLOCK;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK
                && material != Material.WOOD && material != Material.PLANTS && material != Material.TALL_PLANTS
                && material != Material.BAMBOO ? super.getDestroySpeed(stack, state) : this.efficiency;
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        ItemStack stack = context.getItem();
        List<IAugment> augments = AugmentUtils.getAugments(stack);
        boolean success = false;
        for (IAugment augment : augments) {
            if (augment.onItemUse(context))
                success = true;
        }

        if (success)
            return ActionResultType.SUCCESS;

        World world = context.getWorld();
        BlockPos pos = context.getPos();
        if (context.getFace() != Direction.DOWN && world.getBlockState(pos.up()).isAir(world, pos.up())) {
            BlockState state = PATH_STUFF.get(world.getBlockState(pos).getBlock());
            if (state != null) {
                PlayerEntity player = context.getPlayer();
                world.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (!world.isRemote()) {
                    world.setBlockState(pos, state, 11);
                    if (player != null) {
                        stack.damageItem(1, player, entity -> {
                            entity.sendBreakAnimation(context.getHand());
                        });
                    }
                }

                return ActionResultType.SUCCESS;
            }
        }

        return super.onItemUse(context);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        List<IAugment> augments = AugmentUtils.getAugments(stack);
        boolean success = false;
        for (IAugment augment : augments) {
            if (augment.onRightClick(stack, world, player, hand))
                success = true;
        }

        if (success)
            return new ActionResult<>(ActionResultType.SUCCESS, stack);

        return new ActionResult<>(ActionResultType.PASS, stack);
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
        List<IAugment> augments = AugmentUtils.getAugments(stack);
        boolean success = false;
        for (IAugment augment : augments) {
            if (augment.onRightClickEntity(stack, player, target, hand))
                success = true;
        }

        return success;
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        List<IAugment> augments = AugmentUtils.getAugments(stack);
        boolean success = false;
        for (IAugment augment : augments) {
            if (augment.onHitEntity(stack, target, attacker))
                success = true;
        }

        return success;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entity) {
        super.onBlockDestroyed(stack, world, state, pos, entity);

        List<IAugment> augments = AugmentUtils.getAugments(stack);
        boolean success = false;
        for (IAugment augment : augments) {
            if (augment.onBlockDestroyed(stack, world, state, pos, entity))
                success = true;
        }

        return success;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, PlayerEntity player) {
        List<IAugment> augments = AugmentUtils.getAugments(stack);
        boolean success = false;
        for (IAugment augment : augments) {
            if (augment.onBlockStartBreak(stack, pos, player))
                success = true;
        }

        return success;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean isSelected) {
        AugmentUtils.getAugments(stack).forEach(a -> a.onInventoryTick(stack, world, entity, slot, isSelected));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(ModTooltips.getTooltipForTier(this.tinkerableTier));
        AugmentUtils.getAugments(stack).forEach(a -> {
            tooltip.add(a.getDisplayName());
        });
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        Multimap<String, AttributeModifier> modifiers = HashMultimap.create();
        if (slot == EquipmentSlotType.MAINHAND) {
            modifiers.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
            modifiers.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", this.attackSpeed, AttributeModifier.Operation.ADDITION));

            AugmentUtils.getAugments(stack).forEach(a -> {
                a.addToolAttributeModifiers(modifiers, slot, stack);
            });
        }

        return modifiers;
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
