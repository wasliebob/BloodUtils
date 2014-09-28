package bloodutils.items.sigils;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import wasliecore.helpers.Utils;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipe;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBindable;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;
import WayofTime.alchemicalWizardry.api.soulNetwork.LifeEssenceNetwork;
import WayofTime.alchemicalWizardry.common.items.EnergyItems;
import WayofTime.alchemicalWizardry.common.tileEntity.TEAltar;
import bloodutils.helpers.EssenceHelper;
import bloodutils.items.BUItem;
import bloodutils.libs.LibMod;

public class SigilAdvancedDivination extends BUItem implements IBindable{
	public SigilAdvancedDivination(String name) {
		super(name);
		setMaxStackSize(1);
	}

	@Override
    public void registerIcons(IIconRegister ir){
        itemIcon = ir.registerIcon(LibMod.modName.toLowerCase() + ":" + "sigil_advancedDivination");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(!world.isRemote){
	        EnergyItems.checkAndSetItemOwner(stack, player);
	        NBTTagCompound itemTag = stack.stackTagCompound;

	        if (itemTag == null || itemTag.getString("ownerName").equals(""))
	            return stack;
	        
	        String ownerName = itemTag.getString("ownerName");
	        
	        int currentEssence = EnergyItems.getCurrentEssence(ownerName);
	        
			TileEntity te = Utils.getTargetTile(player);
			if(te != null && te instanceof TEAltar){
				TEAltar altar = (TEAltar)te;
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
			}else{
				World worldSave = MinecraftServer.getServer().worldServers[0];
				if(worldSave != null){
					LifeEssenceNetwork data = EssenceHelper.getLifeEssenceNetwork(ownerName, worldSave);
					if(data != null)
						player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Network Essence: " + EnumChatFormatting.GRAY + currentEssence + " LP"));
				}
			}
		}
		return stack;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(stack.stackTagCompound != null)
			list.add("Current owner: " + stack.stackTagCompound.getString("ownerName"));
	}
}