package bloodutils.blocks.fluids;

import bloodutils.libs.LibMod;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import WayofTime.alchemicalWizardry.AlchemicalWizardry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BUBlockFluid extends BlockFluidClassic{
	public BUBlockFluid(String name, String textureName, Fluid fluid) {
		super(fluid, Material.water);
		setBlockName(name);
		
		fluid.setBlock(this);
		
		this.fluid = fluid;
		this.textureName = textureName;
		
		GameRegistry.registerBlock(this, this.getUnlocalizedName());
	}
	public Fluid fluid;
	public String textureName;

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return this.blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir){
        blockIcon = ir.registerIcon(LibMod.modName.toLowerCase() + ":" + this.textureName);
		fluid.setFlowingIcon(blockIcon);
		fluid.setStillIcon(blockIcon);
	}
	 
	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z){
		if(world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;
		
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z){
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;

		return super.displaceIfPossible(world, x, y, z);
	}
}