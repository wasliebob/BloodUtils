package bloodutils.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import bloodutils.blocks.blockEffect.BlockEffect;
import bloodutils.libs.LibMod;

public class BlockMagicArea extends BUContainerBlock{

	public BlockMagicArea(String name, String textureName, BlockEffect blockEffect){
		super(name, Material.rock, false);
		this.textureName = textureName;
		this.blockEffect = blockEffect;
	}
	public String textureName;
	public BlockEffect blockEffect;
	
	@Override
    public void registerBlockIcons(IIconRegister ir){
        blockIcon = ir.registerIcon(LibMod.modName.toLowerCase() + ":" + "area_" + this.textureName);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		return this.blockEffect.createTileEntity();
	}
}