package bloodutils.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipe;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;
import WayofTime.alchemicalWizardry.common.tileEntity.TEAltar;
import bloodutils.libs.LibMod;

public class BlockAltarProgress extends BUBlock{
	public BlockAltarProgress(String name) {
		super(name, Material.rock, false);
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float cX, float cY, float cZ) {
		TEAltar altar = getAltar(world, x, y, z);

		if(altar != null){
			if(!world.isRemote && !player.isSneaking()){
				float selfSacrifiseMultiplier = altar.getSelfSacrificeMultiplier() * 10;
				float sacrifiseMultiplier = altar.getSacrificeMultiplier() * 10;

				int sacrifise = (int) (500 + ((500/100) * sacrifiseMultiplier));
				int selfSacrifise = (int) (200 + ((200/100) * selfSacrifiseMultiplier));
				player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Stored: " + EnumChatFormatting.GRAY + altar.getCurrentBlood() + "/" + altar.getCapacity()));
				player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Tier: " + EnumChatFormatting.GRAY + altar.getTier()));
				player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Self-Sacrifice: " + EnumChatFormatting.GRAY + selfSacrifise + " LP"));
				player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Sacrifice: " + EnumChatFormatting.GRAY + sacrifise + " LP"));

				if(altar.getStackInSlot(0) != null){
					AltarRecipe recipe = AltarRecipeRegistry.getAltarRecipeForItemAndTier(altar.getStackInSlot(0), altar.getTier());
					if(recipe != null && recipe.getResult() != null){
						player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Progress: " + EnumChatFormatting.GRAY + altar.getProgress() + "/" + recipe.getLiquidRequired()));
						player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Output: " + EnumChatFormatting.GRAY + recipe.getResult().getDisplayName()));
					}
					
					if(altar.getStackInSlot(0).getItem() instanceof IBloodOrb){
						IBloodOrb orb = (IBloodOrb)altar.getStackInSlot(0).getItem();
						float orbMultiplier = altar.getOrbMultiplier() * 2;
						int orbStorage = (int) (orb.getMaxEssence() + ((orb.getMaxEssence() / 100) * orbMultiplier));
						player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Orb Storage: " + EnumChatFormatting.GRAY + orbStorage + " LP"));

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