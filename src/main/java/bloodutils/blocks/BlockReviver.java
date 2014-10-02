package bloodutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import bloodutils.libs.LibMod;
import bloodutils.libs.LibRenders;
import bloodutils.tiles.TileAltarBuilder;
import bloodutils.tiles.TileReviver;

public class BlockReviver extends BUContainerBlock{
	public BlockReviver(String name) {
		super(name, Material.rock, false);
		setBlockBounds(0F, 0F, 0F, 1F, 0.31F, 1F);
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float cX, float cY, float cZ) {
		if(!world.isRemote){
			TileReviver te = (TileReviver)world.getTileEntity(x, y, z);
			te.start();
		}
		return true;
    }
	
	@Override
    public void registerBlockIcons(IIconRegister ir){
		blockIcon = Blocks.obsidian.getIcon(0, 0);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		return new TileReviver();
	}
	
	@Override
	public int getRenderType(){
		return LibRenders.reviver_ID;
    }
	
	@Override
    public boolean renderAsNormalBlock(){
        return false;
    }
	
	@Override
    public boolean isOpaqueCube(){
        return false;
    }
}