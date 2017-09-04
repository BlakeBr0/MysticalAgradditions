package com.blakebr0.mysticalagradditions.blocks;

import java.util.List;

import javax.annotation.Nonnull;

import com.blakebr0.cucumber.block.BlockBase;
import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagriculture.MysticalAgriculture;
import com.blakebr0.mysticalagriculture.tileentity.TileEntityTinkeringTable;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTier6TinkeringTable extends BlockBase implements ITileEntityProvider {
	
	public BlockTier6TinkeringTable(){
		super("tinkering_table", Material.IRON, SoundType.METAL, 8.0F, 12.0F);
	}

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(world.isRemote){
            return true;
        } else {
            TileEntity tileentity = world.getTileEntity(pos);

            if(tileentity instanceof TileEntityTinkeringTable){
                player.openGui(MysticalAgriculture.INSTANCE, 1, world, pos.getX(), pos.getY(), pos.getZ());
            }
            return true;
        }
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new TileEntityTinkeringTable();
	}

	@Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityTinkeringTable tile = (TileEntityTinkeringTable)world.getTileEntity(pos);
        if(tile instanceof TileEntityTinkeringTable) {
            for(int i = 0; i < 9; i++){
                ItemStack stack = tile.matrix.getStackInSlot(i);
                if(!stack.isEmpty()){
                    world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack));
                }
            }
        }
        super.breakBlock(world, pos, state);
    }
	
	@Nonnull
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer(){
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isFullCube(IBlockState state){
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state){
		return false;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
		tooltip.add(Colors.DARK_PURPLE + Utils.localize("tooltip.ma.insanium"));
    }
}
