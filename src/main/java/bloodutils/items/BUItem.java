package bloodutils.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import bloodutils.libs.LibMod;
import bloodutils.main.init.BUTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class BUItem extends Item{
	public BUItem(String name){
		
		setMaxStackSize(1);
		setUnlocalizedName(name.toLowerCase());
		setCreativeTab(BUTabs.tabMain);

		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}
	
	@Override
    public void registerIcons(IIconRegister ir){
        itemIcon = ir.registerIcon(LibMod.modAddonName.toLowerCase() + ":" + "BlankSlate");
	}
}