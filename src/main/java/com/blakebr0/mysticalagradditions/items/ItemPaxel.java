package com.blakebr0.mysticalagradditions.items;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import com.blakebr0.cucumber.iface.IRepairMaterial;
import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.cucumber.util.ToolTools;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.lib.MAHelper;
import com.blakebr0.mysticalagriculture.items.tools.ToolType;
import com.blakebr0.mysticalagriculture.lib.Tooltips;
import com.blakebr0.mysticalagriculture.util.NBTHelper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ItemPaxel extends ItemTool implements IRepairMaterial {
	
	public ItemStack repairMaterial;
	public TextFormatting color;

	public ItemPaxel(String name, ToolMaterial material, TextFormatting color) {
		super(4, -3.2F, material, new HashSet<>());
		this.setUnlocalizedName("ma." + name);
		this.setCreativeTab(MysticalAgradditions.tabMysticalAgradditions);
		this.setHarvestLevel("pickaxe", material.getHarvestLevel());
		this.setHarvestLevel("shovel", material.getHarvestLevel());
		this.setHarvestLevel("axe", material.getHarvestLevel());
		this.setMaxDamage((int) (material.getMaxUses() * 1.5));
		this.color = color;
	}
	
	@Override
	@SideOnly(Side.CLIENT) // TODO: charm tooltip
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced){
		int damage = stack.getMaxDamage() - stack.getItemDamage();
		tooltip.add(Tooltips.DURABILITY + color + (damage > -1 ? damage : Tooltips.UNLIMITED));
		if(OreDictionary.itemMatches(getRepairMaterial(), MAHelper.items.itemCrafting.itemSupremiumIngot, false)){
			NBTTagCompound tag = NBTHelper.getDataMap(stack);
			if(tag.hasKey(ToolType.TOOL_TYPE) && tag.getInteger(ToolType.TOOL_TYPE) == 1000){
				tooltip.add(Tooltips.CHARM_SLOT + Colors.RED + Utils.localize("tooltip.ma.mining_aoe"));
			} else {
				tooltip.add(Tooltips.CHARM_SLOT + Colors.RED + Tooltips.EMPTY);
			}
		}
	}
	
	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
        Material material = state.getMaterial();
        float aoeNerf = NBTHelper.getDataMap(stack).hasKey(ToolType.TOOL_TYPE) ? (NBTHelper.getDataMap(stack).getInteger(ToolType.TOOL_TYPE) == 1000 ? -15.0F : 0.0F) : 0.0F;
        return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK
        	   && material != Material.WOOD && material != Material.PLANTS && material != Material.VINE 
        	   ? super.getStrVsBlock(stack, state) + aoeNerf : this.efficiencyOnProperMaterial + aoeNerf;
	}
	
	@Override
    public boolean canHarvestBlock(IBlockState state) {
        Block block = state.getBlock();

        if (block == Blocks.OBSIDIAN) {
            return this.toolMaterial.getHarvestLevel() == 3;
        } else if (block != Blocks.DIAMOND_BLOCK && block != Blocks.DIAMOND_ORE) {
            if (block != Blocks.EMERALD_ORE && block != Blocks.EMERALD_BLOCK) {
                if (block != Blocks.GOLD_BLOCK && block != Blocks.GOLD_ORE) {
                    if (block != Blocks.IRON_BLOCK && block != Blocks.IRON_ORE) {
                        if (block != Blocks.LAPIS_BLOCK && block != Blocks.LAPIS_ORE) {
                            if (block != Blocks.REDSTONE_ORE && block != Blocks.LIT_REDSTONE_ORE) {
                                Material material = state.getMaterial();

                                if (material == Material.ROCK) {
                                    return true;
                                }
                                else if (material == Material.IRON) {
                                    return true;
                                } else {
                                    return material == Material.ANVIL;
                                }
                            } else {
                                return this.toolMaterial.getHarvestLevel() >= 2;
                            }
                        } else {
                            return this.toolMaterial.getHarvestLevel() >= 1;
                        }
                    } else {
                        return this.toolMaterial.getHarvestLevel() >= 1;
                    }
                } else {
                    return this.toolMaterial.getHarvestLevel() >= 2;
                }
            } else {
                return this.toolMaterial.getHarvestLevel() >= 2;
            }
        } else {
            return this.toolMaterial.getHarvestLevel() >= 2;
        }
    }
	
	@Override
    public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player){
		if(stack.getItem() == ModItems.itemSupremiumPaxel){
			NBTTagCompound tag = NBTHelper.getDataMap(stack);
			if(tag.hasKey(ToolType.TOOL_TYPE)){
				if(tag.getInteger(ToolType.TOOL_TYPE) == 1000){
			        boolean blocks = false;
		            RayTraceResult ray = ToolTools.getBlockWithinReach(player.getEntityWorld(), player);
		            if(ray != null){
		                int side = ray.sideHit.ordinal();
		                blocks = this.harvest(stack, 1, player.getEntityWorld(), pos, side, player);
		            }
		            return blocks;
				}
			}
		}
		return super.onBlockStartBreak(stack, pos, player);
    }

    public boolean harvest(ItemStack stack, int radius, World world, BlockPos pos, int side, EntityPlayer player){
        int xRange = radius;
        int yRange = radius;
        int zRange = 0;

        if(side == 0 || side == 1){
            zRange = radius;
            yRange = 0;
        }
        
        if(side == 4 || side == 5){
            xRange = 0;
            zRange = radius;
        }
        
        IBlockState state = world.getBlockState(pos);
        float hardness = state.getBlockHardness(world, pos);
        
        if(!canHarvest(world, pos, false, stack, player)){
        	return false;
        }
        
        if(radius > 0 && hardness >= 0.2F){
        	Iterable<BlockPos> blocks = BlockPos.getAllInBox(pos.add(-xRange, -yRange, -zRange), pos.add(xRange, yRange, zRange));
        	for(BlockPos aoePos : blocks){
        		if(aoePos != pos){
        			IBlockState aoeState = world.getBlockState(aoePos);
        			if(aoeState.getBlockHardness(world, aoePos) <= hardness + 5.0F){
        				//if(aoeState.getBlock().isToolEffective("pickaxe", aoeState)){
        					canHarvest(world, aoePos, true, stack, player);
        				//}   
        			} else {
        				return false;
        			}
        		}
            }	
        }
        return true;
    }	
    
    private boolean canHarvest(World world, BlockPos pos, boolean extra, ItemStack stack, EntityPlayer player){
        IBlockState state = world.getBlockState(pos);
        float hardness = state.getBlockHardness(world, pos);
        Block block = state.getBlock();
        boolean harvest = (ForgeHooks.canHarvestBlock(block, player, world, pos) || this.canHarvestBlock(state, stack)) && (!extra || this.getStrVsBlock(stack, world.getBlockState(pos)) > 1.0F);
        if(hardness >= 0.0F && (!extra || harvest)){
            return ToolTools.breakBlocksAOE(stack, world, player, pos);
        }
        return false;
    }
	
	@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair){
        return OreDictionary.itemMatches(getRepairMaterial(), repair, false);
    }

	@Override
	public void setRepairMaterial(ItemStack stack){
		repairMaterial = stack;
	}

	@Override
	public ItemStack getRepairMaterial(){
		return repairMaterial;
	}
}
