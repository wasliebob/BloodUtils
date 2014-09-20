package bloodutils.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipe;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import WayofTime.alchemicalWizardry.common.tileEntity.TEAltar;
import bloodutils.libs.LibMod;

public class BlockAltarProgress extends BUBlock{
	public BlockAltarProgress(String name) {
		super(name, Material.rock);
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float cX, float cY, float cZ) {
		TEAltar altar = getAltar(world, x, y, z);

		if(altar != null){
			if(!world.isRemote && !player.isSneaking()){
				player.addChatComponentMessage(new ChatComponentText("Stored: " + altar.getCurrentBlood() + "/" + altar.getCapacity()));
				player.addChatComponentMessage(new ChatComponentText("Tier: " + altar.getTier()));
				if(altar.getStackInSlot(0) != null){
					AltarRecipe recipe = AltarRecipeRegistry.getAltarRecipeForItemAndTier(altar.getStackInSlot(0), altar.getTier());
					if(recipe != null && recipe.getResult() != null){
						player.addChatComponentMessage(new ChatComponentText("Progress: " + altar.getProgress() + "/" + recipe.getLiquidRequired()));
						player.addChatComponentMessage(new ChatComponentText("Output: " + recipe.getResult().getDisplayName()));
					}
				}
			}
		}
		return true;
    }
	
	public TEAltar getAltar(World world, int x, int y, int z){
		for(int xx = -2; xx < 2; xx++){
			for(int yy = -2; yy < 2; yy++){
				for(int zz = -2; zz < 2; zz++){
					TileEntity te = world.getTileEntity(x + xx, y + yy, z + zz);
					
					if(te != null && te instanceof TEAltar)
						return (TEAltar)te;
				}
			}
		}
		return null;
	}
	
	@Override
    public void registerBlockIcons(IIconRegister ir){
        blockIcon = ir.registerIcon(LibMod.modName.toLowerCase() + ":" + "progress");
	}
}