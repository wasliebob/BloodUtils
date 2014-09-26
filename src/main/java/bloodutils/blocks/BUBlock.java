package bloodutils.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import bloodutils.libs.LibMod;
import bloodutils.main.init.BUTabs;

public class BUBlock extends Block{
	public BUBlock(String name, Material material) {
		super(material);
		setBlockName(name.toLowerCase());
		setHardness(1.0F);
		setCreativeTab(BUTabs.tabMain);
		
		this.name = name;

		GameRegistry.registerBlock(this, this.getUnlocalizedName());
		
		postRegistration();
	}
	public String name;
	
	public void postRegistration(){
	
	}
	
	@Override
    public void registerBlockIcons(IIconRegister ir){
        blockIcon = ir.registerIcon(LibMod.modAddonName.toLowerCase() + ":" + "BlankRune");
	}
}