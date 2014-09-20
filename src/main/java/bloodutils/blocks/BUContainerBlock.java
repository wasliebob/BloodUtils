package bloodutils.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import bloodutils.libs.LibMod;
import bloodutils.main.init.BUTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class BUContainerBlock extends BlockContainer{
	public BUContainerBlock(String name, Material material) {
		super(material);
		setBlockName(name.toLowerCase());
		setHardness(1.0F);
		setCreativeTab(BUTabs.tabMain);
		
		this.name = name;

		GameRegistry.registerBlock(this, this.getUnlocalizedName());
	}
	public String name;
	
	@Override
    public void registerBlockIcons(IIconRegister ir){
        blockIcon = ir.registerIcon(LibMod.modAddonName.toLowerCase() + ":" + "BlankRune");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		return null;
	}
}