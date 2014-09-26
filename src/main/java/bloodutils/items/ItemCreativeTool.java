package bloodutils.items;

import java.util.HashMap;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import wasliecore.helpers.Utils;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBindable;
import WayofTime.alchemicalWizardry.api.soulNetwork.LifeEssenceNetwork;
import WayofTime.alchemicalWizardry.common.items.EnergyItems;
import WayofTime.alchemicalWizardry.common.tileEntity.TEAltar;
import bloodutils.helpers.EssenceHelper;
import bloodutils.libs.LibMod;

public class ItemCreativeTool extends BUItem implements IBindable{
	public ItemCreativeTool(String name) {
		super(name);
		this.setHasSubtypes(true);
		modes.put(0, this.altarFilling);
		modes.put(1, this.networkFilling);
	}
	public String altarFilling = "Altar Filling";
	public String networkFilling = "Network Filling";

	public HashMap<Integer, String> modes = new HashMap<Integer, String>();
	
	@Override
	public void registerIcons(IIconRegister ir){
		itemIcon = ir.registerIcon(LibMod.modName.toLowerCase() + ":" + "tool_creative");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public void getSubItems(Item item, CreativeTabs tabs, List list){
		for(int i = 0; i < modes.size(); i++){
    		ItemStack stack = new ItemStack(item, 1, i);
    		list.add(stack);
    	}
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		String name = this.modes.get(stack.getItemDamage());
		list.add("Mode: " + name);
		
		if(stack.stackTagCompound != null)
			list.add("Current owner: " + stack.stackTagCompound.getString("ownerName"));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(!world.isRemote){
	        EnergyItems.checkAndSetItemOwner(stack, player);
	        
	        NBTTagCompound itemTag = stack.stackTagCompound;

	        if (itemTag == null || itemTag.getString("ownerName").equals(""))
	            return stack;
	        
	        String ownerName = itemTag.getString("ownerName");
	       
	        EnergyItems.getCurrentEssence(ownerName);	   
	        
			String mode = modes.get(stack.getItemDamage());
			if(mode != null){
				if(player.isSneaking()){
					if(mode == this.altarFilling){
						TileEntity te = Utils.getTargetTile(player);
						if(te != null && te instanceof TEAltar){
							TEAltar altar = (TEAltar)te;
							altar.setMainFluid(new FluidStack(FluidRegistry.getFluid("life essence"), altar.capacity));
							world.markBlockForUpdate(altar.xCoord, altar.yCoord, altar.zCoord);
						}
					}else if(mode == this.networkFilling){
						World worldSave = MinecraftServer.getServer().worldServers[0];
						LifeEssenceNetwork data = EssenceHelper.getLifeEssenceNetwork(ownerName, worldSave);
						if(data != null)
							data.currentEssence = 1000000000;
					}
				}else if(!player.isSneaking()){
					stack.setItemDamage(nextMode(stack.getItemDamage()));
					player.addChatComponentMessage(new ChatComponentText("Mode: " + modes.get(stack.getItemDamage())));
				}
			}
		}
		return stack;
	}
	
	public int nextMode(int meta){
		int max = this.modes.size() - 1;
		if(meta >= max)
			return 0;
		else if(meta < max)
			return meta + 1;
		return 0;
	}
}