package bloodutils.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import bloodutils.libs.LibMod;

public class BlockMaterial extends BUBlock{
	public BlockMaterial(String name, Material material, String textureName){
		super(name, material, false);
		this.textureName = textureName;
	}
	public String textureName;
	
	@Override
    public void registerBlockIcons(IIconRegister ir){
        blockIcon = ir.registerIcon(LibMod.modName.toLowerCase() + ":" + this.textureName);
	}
}