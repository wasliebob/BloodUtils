package bloodutils.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import bloodutils.libs.LibMod;
import bloodutils.main.init.BUTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BUItem extends Item{
	public BUItem(String name){
		
		setMaxStackSize(1);
		setUnlocalizedName(name.toLowerCase());
		setCreativeTab(BUTabs.tabMain);

		GameRegistry.registerItem(this, this.getUnlocalizedName());
		postRegistration();
	}
	public boolean isWIP;
	
	public void postRegistration(){
		
	}
	
	@Override
    public void registerIcons(IIconRegister ir){
        itemIcon = ir.registerIcon(LibMod.modAddonName.toLowerCase() + ":" + "BlankSlate");
	}
	
	@Override
    @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_){
    	if(this.isWIP)
    		list.add(EnumChatFormatting.RED + "Work In Progress");
    }
}