package bloodutils.blocks;

import java.util.ArrayList;

import bloodutils.libs.LibMod;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockEarth extends BUBlock{
	public BlockEarth() {
		super("Earth Block", Material.grass, true);
		setHardness(0.5F);
	}
	
	@Override
    public void registerBlockIcons(IIconRegister ir){
        blockIcon = Blocks.dirt.getBlockTextureFromSide(0);
	}
	
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune){
    	return new ArrayList<ItemStack>();
    }
}