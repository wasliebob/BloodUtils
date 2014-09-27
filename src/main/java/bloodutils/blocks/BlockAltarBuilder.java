package bloodutils.blocks;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import WayofTime.alchemicalWizardry.ModBlocks;
import bloodutils.libs.LibMod;
import bloodutils.tiles.TileAltarBuilder;

public class BlockAltarBuilder extends BUContainerBlock{

	public BlockAltarBuilder(String name) {
		super(name, Material.rock, false);
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float cX, float cY, float cZ) {
		if(!world.isRemote){
			TileAltarBuilder te = (TileAltarBuilder)world.getTileEntity(x, y, z);
			int tier = te.getTier();
			if(player.capabilities.isCreativeMode){
				if(tier == 2){
					tier2(world, x, y, z);
					te.setTier(tier + 1);
				}
					
				if(tier == 3){
					tier3(world, x, y, z);
					te.setTier(tier + 1);
				}
					
				if(tier == 4){
					tier4(world, x, y, z);
					te.setTier(tier + 1);
				}
					
				if(tier == 5){
					tier5(world, x, y, z);
					te.setTier(tier + 1);
				}
			}
		}
		return true;
    }
		
	public void tier2(World world, int x, int y, int z){
		setBlock(world, x, y + 4, z, ModBlocks.blockAltar);
		
		setBlock(world, x, y + 3, z + 1, ModBlocks.bloodRune);
		setBlock(world, x, y + 3, z - 1, ModBlocks.bloodRune);
		setBlock(world, x + 1, y + 3, z, ModBlocks.bloodRune);
		setBlock(world, x - 1, y + 3, z, ModBlocks.bloodRune);

		setBlock(world, x + 1, y + 3, z + 1, ModBlocks.bloodRune);
		setBlock(world, x - 1, y + 3, z + 1, ModBlocks.bloodRune);
		setBlock(world, x + 1, y + 3, z - 1, ModBlocks.bloodRune);
		setBlock(world, x - 1, y + 3, z - 1, ModBlocks.bloodRune);
		
		world.markBlockForUpdate(x, y + 4, z);
	}
	
	public void tier3(World world, int x, int y, int z){
		for(int xx = 0; xx < 5; xx++){
			setBlock(world, x - 2 + xx , y + 2, z + 3, ModBlocks.bloodRune);
			setBlock(world, x + 2 - xx , y + 2, z - 3, ModBlocks.bloodRune);
		}
		
		for(int zz = 0; zz < 5; zz++){
			setBlock(world, x + 3, y  + 2, z - 2 + zz, ModBlocks.bloodRune);
			setBlock(world, x - 3, y + 2, z + 2 - zz, ModBlocks.bloodRune);
		}
		
		setBlock(world, x + 3, y + 3, z + 3, Blocks.stonebrick);
		setBlock(world, x + 3, y + 4, z + 3, Blocks.stonebrick);
		setBlock(world, x + 3, y + 5, z + 3, Blocks.glowstone);

		setBlock(world, x - 3, y + 3, z + 3, Blocks.stonebrick);
		setBlock(world, x - 3, y + 4, z + 3, Blocks.stonebrick);
		setBlock(world, x - 3, y + 5, z + 3, Blocks.glowstone);
		
		setBlock(world, x + 3, y + 3, z - 3, Blocks.stonebrick);
		setBlock(world, x + 3, y + 4, z - 3, Blocks.stonebrick);
		setBlock(world, x + 3, y + 5, z - 3, Blocks.glowstone);
		
		setBlock(world, x - 3, y + 3, z - 3, Blocks.stonebrick);
		setBlock(world, x - 3, y + 4, z - 3, Blocks.stonebrick);
		setBlock(world, x - 3, y + 5, z - 3, Blocks.glowstone);
		
		world.markBlockForUpdate(x, y + 4, z);
	}
	
	public void tier4(World world, int x, int y, int z){
		for(int xx = 0; xx < 7; xx++){
			setBlock(world, x - 3 + xx , y + 1, z + 5, ModBlocks.bloodRune);
			setBlock(world, x + 3 - xx , y + 1, z - 5, ModBlocks.bloodRune);
		}
		
		for(int zz = 0; zz < 7; zz++){
			setBlock(world, x + 5, y + 1, z - 3 + zz, ModBlocks.bloodRune);
			setBlock(world, x - 5, y + 1, z + 3 - zz, ModBlocks.bloodRune);
		}
		
		setBlock(world, x + 5, y + 2, z + 5, Blocks.stonebrick);
		setBlock(world, x + 5, y + 3, z + 5, Blocks.stonebrick);
		setBlock(world, x + 5, y + 4, z + 5, Blocks.stonebrick);
		setBlock(world, x + 5, y + 5, z + 5, Blocks.stonebrick);
		setBlock(world, x + 5, y + 6, z + 5, ModBlocks.largeBloodStoneBrick);

		setBlock(world, x - 5, y + 2, z + 5, Blocks.stonebrick);
		setBlock(world, x - 5, y + 3, z + 5, Blocks.stonebrick);
		setBlock(world, x - 5, y + 4, z + 5, Blocks.stonebrick);
		setBlock(world, x - 5, y + 5, z + 5, Blocks.stonebrick);
		setBlock(world, x - 5, y + 6, z + 5, ModBlocks.largeBloodStoneBrick);
		
		setBlock(world, x + 5, y + 2, z - 5, Blocks.stonebrick);
		setBlock(world, x + 5, y + 3, z - 5, Blocks.stonebrick);
		setBlock(world, x + 5, y + 4, z - 5, Blocks.stonebrick);
		setBlock(world, x + 5, y + 5, z - 5, Blocks.stonebrick);
		setBlock(world, x + 5, y + 6, z - 5, ModBlocks.largeBloodStoneBrick);
		
		setBlock(world, x - 5, y + 2, z - 5, Blocks.stonebrick);
		setBlock(world, x - 5, y + 3, z - 5, Blocks.stonebrick);
		setBlock(world, x - 5, y + 4, z - 5, Blocks.stonebrick);
		setBlock(world, x - 5, y + 5, z - 5, Blocks.stonebrick);
		setBlock(world, x - 5, y + 6, z - 5, ModBlocks.largeBloodStoneBrick);
		
		world.markBlockForUpdate(x, y + 4, z);
	}
	
	public void tier5(World world, int x, int y, int z){
		for(int xx = 0; xx < 13; xx++){
			setBlock(world, x - 6 + xx , y, z + 8, ModBlocks.bloodRune);
			setBlock(world, x + 6 - xx , y, z - 8, ModBlocks.bloodRune);
		}
		
		for(int zz = 0; zz < 13; zz++){
			setBlock(world, x + 8, y, z - 6 + zz, ModBlocks.bloodRune);
			setBlock(world, x - 8, y, z + 6 - zz, ModBlocks.bloodRune);
		}
		
		setBlock(world, x + 8, y + 1, z + 8, Blocks.beacon);

		setBlock(world, x - 8, y + 1, z + 8, Blocks.beacon);
		
		setBlock(world, x + 8, y + 1, z - 8, Blocks.beacon);
		
		setBlock(world, x - 8, y + 1, z - 8, Blocks.beacon);
		
		world.markBlockForUpdate(x, y + 4, z);
	}
	
	@Override
    public void registerBlockIcons(IIconRegister ir){
        blockIcon = ir.registerIcon(LibMod.modName.toLowerCase() + ":" + "builder");
	}
	
	public void setBlock(World world, int x, int y, int z, Block block){
		world.setBlock(x, y, z, block);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		return new TileAltarBuilder();
	}
}