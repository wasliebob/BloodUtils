package bloodutils.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import WayofTime.alchemicalWizardry.ModBlocks;
import WayofTime.alchemicalWizardry.ModItems;
import bloodutils.api.registries.RecipeRegistry;
import bloodutils.libs.LibMod;
import bloodutils.main.init.BUBlocks;
import bloodutils.main.init.BUItems;
import bloodutils.main.init.BUTabs;

public class BlockMaterial extends BUBlock{
	public BlockMaterial(String name, Material material, String textureName) {
		super(name, material);
		this.textureName = textureName;
	}
	public String textureName;
	
	@Override
	public void postRegistration(){
		GameRegistry.addShapedRecipe(new ItemStack(this), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X', BUItems.diamond_blood});
		
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.diamond_blood, 9, 0), new ItemStack(this));
	}
	
	@Override
    public void registerBlockIcons(IIconRegister ir){
        blockIcon = ir.registerIcon(LibMod.modName.toLowerCase() + ":" + this.textureName);
	}
}